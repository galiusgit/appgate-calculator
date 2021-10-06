package com.appgate.calc.app.adapters;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appgate.calc.domain.codes.AppCodes;
import com.appgate.calc.domain.codes.CalcSessionCodes;
import com.appgate.calc.domain.codes.OperationCodes;
import com.appgate.calc.domain.exception.AppCalcException;
import com.appgate.calc.domain.model.ArithmeticOperator;
import com.appgate.calc.domain.model.calcsession.CalcProcessReq;
import com.appgate.calc.domain.model.calcsession.CalcProcessRes;
import com.appgate.calc.domain.model.calcsession.CalcSession;
import com.appgate.calc.domain.model.calcsession.CalcSessionListRes;
import com.appgate.calc.domain.model.calcsession.CalcSessionRes;
import com.appgate.calc.domain.model.calcsession.CalcStatus;
import com.appgate.calc.domain.model.operation.NewOperationRes;
import com.appgate.calc.domain.model.operation.Operation;
import com.appgate.calc.domain.model.operation.OperationReq;
import com.appgate.calc.domain.model.operation.OperationRes;
import com.appgate.calc.domain.model.operation.OperationType;
import com.appgate.calc.domain.ports.CalcServicePort;
import com.appgate.calc.domain.ports.CalcSessionRepositoryPort;
import com.appgate.calc.domain.ports.OperationRepositoryPort;
import com.appgate.calc.domain.service.CalcProcessor;
import com.appgate.calc.domain.service.CalcProcessorImpl;
import com.appgate.calc.domain.util.DateUtil;
import com.appgate.calc.domain.util.UuidUtil;
import com.appgate.calc.domain.validators.CalcSessionValidator;
import com.appgate.calc.domain.validators.OperationValidator;

/**
 * The Class CalcServiceAdapter.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class CalcServiceAdapter implements CalcServicePort {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(CalcServiceAdapter.class);
	
	private static final String ERROR_SAVE_MSG = "error trying to save calc session";
	
	private static final String ERROR_GETTING_SESSIONS_MSG = "error trying to get session list";
	
	/** The calculator repository port. */
	@Autowired
	private CalcSessionRepositoryPort calcRepo;
	
	@Autowired
	private OperationRepositoryPort opeRepo;
	
	/** The calculator processor. */
	private CalcProcessor calcProcessor = new CalcProcessorImpl();

	
	@Override
	public CalcSessionRes addCalcSession(String description) {
		// step 1: initialize calc session
		try {
			var creationDate = DateUtil.getCurrentDate();
			var sessionResult = calcRepo.createCalcSession(new CalcSession(UuidUtil.newUuid(), 
				CalcStatus.PENDING_RESULT, 
				null, 
				description, 
				creationDate, 
				creationDate));
			if(sessionResult.isPresent()) {
				return new CalcSessionRes(sessionResult.get(), AppCodes.OK.name(), "calc session created");
			}
			return new CalcSessionRes(null, AppCodes.ERROR_TO_SAVE_CALC_SESSION.name(), ERROR_SAVE_MSG);
		} catch (AppCalcException e) {
			LOGGER.error(ERROR_SAVE_MSG, e);
			return new CalcSessionRes(null, e.getCode(), e.getMessage());
		}
	}

	@Override
	public CalcSessionListRes getAllCalcSessions() {
		try {
			var sessions = calcRepo.findAllCalcSessions();
			return new CalcSessionListRes(sessions, AppCodes.OK.name(), "calc sessoin list ok");
		} catch (AppCalcException e) {
			LOGGER.error(ERROR_GETTING_SESSIONS_MSG, e);
			return new CalcSessionListRes(null, e.getCode(), e.getMessage());
		}
	}

	@Override
	public CalcProcessRes buildCalcSessionProcess(final CalcProcessReq calcProcessReq) {
		try {
			CalcSessionValidator.validSessionId(calcProcessReq.getCalcSessionId());
			var calcSession = getCalcSession(calcProcessReq.getCalcSessionId());
			var lastResult = opeRepo.getLastResult(calcProcessReq.getCalcSessionId());
			List<Operation> operations = null;
			if(lastResult.isPresent()) {
				operations = opeRepo.findBySessionIdAndDate(calcSession.getId(), lastResult.get().getCreationDate());
			} else {
				operations = opeRepo.findBySessionId(calcSession.getId());
			}
			return calcOperationsProcess(calcSession, operations, calcProcessReq.getOperator(), calcProcessReq.getDescription());
		} catch (AppCalcException e) {
			LOGGER.error("error trying to calculate session [{}]", calcProcessReq.getCalcSessionId(), e);
			return new CalcProcessRes(null, null, e.getCode(), e.getMessage());
		} catch (Exception e) {
			var msgError = String.format("unexpected trying to calculate session [%s]", calcProcessReq.getCalcSessionId());
			LOGGER.error(msgError, e);
			return new CalcProcessRes(null, null, AppCodes.CALC_PROCESS_ERROR.name(), msgError);
		}
	}
	
	@Transactional
	public CalcProcessRes calcOperationsProcess(final CalcSession calcSession, final List<Operation> operations, 
			final ArithmeticOperator operator, final String description) throws AppCalcException {
		// 1) loop operations and process calculator
		BigDecimal result = null;
		var index2 = 1;
		for (var ope: operations) {
			if(index2 < operations.size()) {
				var nextOpe = operations.get(index2);
				result = calcProcessor.applyOperator(ope.getValue(), nextOpe.getValue(), operator);
				index2 ++;
			}
		}
		// 2) add operation result type to current calc session
		var operationResult = addResultOperation(calcSession.getId(), result, operator, description);
		// 3) update calc session with last result
		var calsessionUpdated = updateCalcSession(calcSession, result);
		// 4) return result operation and calc session updated
		return new CalcProcessRes(calsessionUpdated, operationResult, AppCodes.OK.name(), "calc session processed");
	}
	
	private CalcSession updateCalcSession(final CalcSession calcSession, 
			final BigDecimal result) throws AppCalcException {
		calcSession.setUpdateDate(DateUtil.getCurrentDate());
		calcSession.setResult(result);
		calcSession.setStatus(CalcStatus.HAS_RESULT);
		var calsessionUpdated = calcRepo.updateCalcSession(calcSession);
		if (calsessionUpdated.isEmpty()) {
			throw new AppCalcException(CalcSessionCodes.CALC_SESSION_NO_RESULT.name(), 
					"calc session no result trying to update");
		}
		return calsessionUpdated.get();
	}

	@Override
	public NewOperationRes addOperationToSession(OperationReq opeReq) {
		// step 2: add operations to created session
		try {
			OperationValidator.validOperationReq(opeReq);
			var calcSession = getCalcSession(opeReq.getCalcSessionId());
			var operation = addNewOperation(opeReq);
			return new NewOperationRes(calcSession, operation, AppCodes.OK.name(), "calc session created");
		} catch (AppCalcException e) {
			LOGGER.error("error trying to add operation for calcSessionId:[{}]", 
					opeReq != null ? opeReq.getCalcSessionId() : "", e);
			return new NewOperationRes(null, null, e.getCode(), e.getMessage());
		}
	}
	
	private CalcSession getCalcSession(String sessionId) throws AppCalcException {
		var calcSession = calcRepo.getById(sessionId);
		if (calcSession.isEmpty()) {
			throw new AppCalcException(CalcSessionCodes.CALC_SESSION_NOT_EXIST.name(), 
					String.format("calc session not found:[%s]", sessionId));
		}
		return calcSession.get();
	}
	
	private Operation addNewOperation(OperationReq opeReq) throws AppCalcException {
		var operation = opeRepo.createOperation(new Operation(UuidUtil.newUuid(), 
				opeReq.getCalcSessionId(), opeReq.getValue(), null, 
				DateUtil.getCurrentDate(), OperationType.NEW, 
				null, opeReq.getDescription()));
		if(operation.isEmpty()) {
			throw new AppCalcException(OperationCodes.OPE_SAVE_ERROR.name(), 
					String.format("new operation save error, empty result calcSessionId:[%s]", opeReq.getCalcSessionId()));
		}
		return operation.get();
	}
	
	private Operation addResultOperation(final String sessionId, final BigDecimal value, 
			final ArithmeticOperator operator, final String description) throws AppCalcException {
		var operation = opeRepo.createOperation(new Operation(UuidUtil.newUuid(), 
				sessionId, value, null, 
				DateUtil.getCurrentDate(), OperationType.RESULT, 
				operator, description));
		if(operation.isEmpty()) {
			throw new AppCalcException(OperationCodes.OPE_SAVE_ERROR.name(), 
					String.format("result operation save error, empty result calcSessionId:[%s]", sessionId));
		}
		return operation.get();
	}

	@Override
	public OperationRes getLastResult(String calcSessionId) {
		try {
			var result = opeRepo.getLastResult(calcSessionId);
			if (result.isEmpty()) {
				return new OperationRes(result.get(), AppCodes.OK.name(), "not found operation calc result for session");
			}
			return new OperationRes(result.get(), AppCodes.OK.name(), "operation result ok");
		} catch (AppCalcException e) {
			LOGGER.error("error trying to get last result for calc session:[{}]", calcSessionId, e);
			return new OperationRes(null, e.getCode(), e.getMessage());
		}
	}

}
