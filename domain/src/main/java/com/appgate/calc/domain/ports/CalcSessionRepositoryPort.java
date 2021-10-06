package com.appgate.calc.domain.ports;

import java.util.List;
import java.util.Optional;

import com.appgate.calc.domain.exception.AppCalcException;
import com.appgate.calc.domain.model.calcsession.CalcSession;

/**
 * The Interface CalcSessionRepositoryPort.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public interface CalcSessionRepositoryPort {
	
	/**
	 * Creates the calc session.
	 *
	 * @param calcSession the calc session
	 * @return the optional
	 * @throws AppCalcException the app calc exception
	 */
	public Optional<CalcSession> createCalcSession(CalcSession calcSession) throws AppCalcException;
	
	/**
	 * Update calc session.
	 *
	 * @param calcSession the calc session
	 * @return the optional
	 * @throws AppCalcException the app calc exception
	 */
	public Optional<CalcSession> updateCalcSession(CalcSession calcSession) throws AppCalcException;
	
	/**
	 * Find all calc sessions.
	 *
	 * @return the list
	 * @throws AppCalcException the app calc exception
	 */
	public List<CalcSession> findAllCalcSessions() throws AppCalcException;
	
	/**
	 * Gets the by id.
	 *
	 * @param id the id
	 * @return the by id
	 * @throws AppCalcException the app calc exception
	 */
	public Optional<CalcSession> getById(String id) throws AppCalcException;
	
}
