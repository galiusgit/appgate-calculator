package com.appgate.calc.infra.adapters;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appgate.calc.domain.codes.OperationCodes;
import com.appgate.calc.domain.exception.AppCalcException;
import com.appgate.calc.domain.model.Operation;
import com.appgate.calc.domain.ports.OperationRepositoryPort;
import com.appgate.calc.infra.mapper.OperationMapper;
import com.appgate.calc.infra.repository.OperationRespository;

@Component
public class OperationRepositoryAdapter implements OperationRepositoryPort {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OperationRepositoryAdapter.class);
	
	@Autowired
	private OperationRespository opeRepo;

	@Override
	public Optional<Operation> createCalcSession(Operation newOperation) throws AppCalcException {
		try {
			var opeSaved = opeRepo.save(OperationMapper.mapTo(newOperation));
			return Optional.of(OperationMapper.mapTo(opeSaved));
		} catch (Exception e) {
			var msgError = "error trying to save operation";
			LOGGER.error(msgError, e);
			throw new AppCalcException(OperationCodes.OPE_SAVE_ERROR.name(), msgError, e);
		}
	}

	@Override
	public List<Operation> findBySessionId(String calcSessionId) throws AppCalcException {
		try {
			var result = opeRepo.findBySessionId(calcSessionId);
			return result.stream().map(n -> OperationMapper.mapTo(n)).collect(Collectors.toList());
		} catch (Exception e) {
			var msgError = String.format("error trying to get operations by calc session id:[%s]", calcSessionId);
			LOGGER.error(msgError, e);
			throw new AppCalcException(OperationCodes.OPE_GET_LIST_BY_CALC_SESSION_ERROR.name(), msgError, e);
		}
	}

	@Override
	public Optional<Operation> getLastResult(String calcSessionId) throws AppCalcException {
		try {
			var ope = opeRepo.getLastResult(calcSessionId);
			return Optional.of(OperationMapper.mapTo(ope));
		} catch (Exception e) {
			var msgError = String.format("error trying to get last operation by calc session id:[%s]", calcSessionId);
			LOGGER.error(msgError, e);
			throw new AppCalcException(OperationCodes.OPE_GET_BY_CALC_SESSION_ERROR.name(), msgError, e);
		}
	}

}
