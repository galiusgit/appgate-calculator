package com.appgate.calc.domain.ports;

import java.util.List;
import java.util.Optional;

import com.appgate.calc.domain.exception.AppCalcException;
import com.appgate.calc.domain.model.CalcSession;

/**
 * The Interface CalcSessionRepositoryPort.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public interface CalcSessionRepositoryPort {
	
	public Optional<CalcSession> createCalcSession(CalcSession calcSession) throws AppCalcException;
	
	public List<CalcSession> findAllCalcSessions() throws AppCalcException;
	
	public Optional<CalcSession> getById(String id) throws AppCalcException;
	
}
