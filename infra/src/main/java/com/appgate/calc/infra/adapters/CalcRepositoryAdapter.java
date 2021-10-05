package com.appgate.calc.infra.adapters;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.stereotype.Component;

import com.appgate.calc.domain.exception.CalcException;
import com.appgate.calc.domain.model.CalcSession;
import com.appgate.calc.domain.ports.CalcRepositoryPort;
import com.appgate.calc.infra.entity.CalcSessionEntity;
import com.appgate.calc.infra.mapper.CalcSessionMapper;
import com.appgate.calc.infra.repository.CalcRepository;

/**
 * The Class CalcRepositoryAdapter.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
public class CalcRepositoryAdapter implements CalcRepositoryPort {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(CalcRepositoryAdapter.class);

	/** The calculator repository. */
	@Autowired
	private CalcRepository calcRepo;

	@Override
	public Optional<CalcSession> createCalcSession(CalcSession calcSession) throws CalcException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CalcSession> findAllCalcSessions() throws CalcException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<CalcSession> getById(String id) throws CalcException {
		// TODO Auto-generated method stub
		return null;
	}



}
