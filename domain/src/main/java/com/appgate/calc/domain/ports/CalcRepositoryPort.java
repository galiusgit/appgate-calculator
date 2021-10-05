package com.appgate.calc.domain.ports;

import java.util.List;
import java.util.Optional;

import com.appgate.calc.domain.exception.CalcException;
import com.appgate.calc.domain.model.CalcSession;

/**
 * The Interface CalcRepositoryPort.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public interface CalcRepositoryPort {
	
	public Optional<CalcSession> createCalcSession(CalcSession calcSession) throws CalcException;
	
	public List<CalcSession> findAllCalcSessions() throws CalcException;
	
	public Optional<CalcSession> getById(String id) throws CalcException;
	
}
