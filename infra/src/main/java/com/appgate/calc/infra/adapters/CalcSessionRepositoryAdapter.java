package com.appgate.calc.infra.adapters;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appgate.calc.domain.codes.CalcSessionCodes;
import com.appgate.calc.domain.exception.AppCalcException;
import com.appgate.calc.domain.model.calcsession.CalcSession;
import com.appgate.calc.domain.ports.CalcSessionRepositoryPort;
import com.appgate.calc.infra.mapper.CalcSessionMapper;
import com.appgate.calc.infra.repository.CalcSessionRepository;

/**
 * The Class CalcSessionRepositoryAdapter.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
public class CalcSessionRepositoryAdapter implements CalcSessionRepositoryPort {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(CalcSessionRepositoryAdapter.class);

	/** The calculator repository. */
	@Autowired
	private CalcSessionRepository calcRepo;

	@Override
	public Optional<CalcSession> createCalcSession(CalcSession calcSession) throws AppCalcException {
		try {
			var calcSaved = calcRepo.save(CalcSessionMapper.mapTo(calcSession));
			return Optional.ofNullable(CalcSessionMapper.mapTo(calcSaved));
		} catch (Exception e) {
			var msgError = "error trying to save calc session";
			LOGGER.error(msgError, e);
			throw new AppCalcException(CalcSessionCodes.CALC_SAVE_ERROR.name(), msgError, e);
		}
	}

	@Override
	public List<CalcSession> findAllCalcSessions() throws AppCalcException {
		try {
			var result = calcRepo.findAll();
			return result.stream().map(n -> CalcSessionMapper.mapTo(n)).collect(Collectors.toList());
		} catch (Exception e) {
			var msgError = "error trying to get calc session list";
			LOGGER.error(msgError, e);
			throw new AppCalcException(CalcSessionCodes.CALC_GETTING_LIST_ERROR.name(), msgError, e);
		}
	}

	@Override
	public Optional<CalcSession> getById(String id) throws AppCalcException {
		try {
			var result = calcRepo.findById(id);
			if (result.isPresent()) {
				return Optional.of(CalcSessionMapper.mapTo(result.get()));
			}
			return Optional.empty();
		} catch (Exception e) {
			var msgError = "error trying to calc session by id";
			LOGGER.error(msgError, e);
			throw new AppCalcException(CalcSessionCodes.CALC_GETTING_ERROR.name(), msgError, e);
		}
	}

	@Override
	public Optional<CalcSession> updateCalcSession(CalcSession calcSession) throws AppCalcException {
		try {
			var calcSaved = calcRepo.save(CalcSessionMapper.mapTo(calcSession));
			return Optional.ofNullable(CalcSessionMapper.mapTo(calcSaved));
		} catch (Exception e) {
			var msgError = "error trying to update calc session";
			LOGGER.error(msgError, e);
			throw new AppCalcException(CalcSessionCodes.CALC_UPDATE_ERROR.name(), msgError, e);
		}
	}

}
