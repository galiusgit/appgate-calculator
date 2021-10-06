package com.appgate.calc.domain.ports;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.appgate.calc.domain.exception.AppCalcException;
import com.appgate.calc.domain.model.operation.Operation;

/**
 * The Interface OperationRepositoryPort.
 */
public interface OperationRepositoryPort {
	
	/**
	 * Creates the operation.
	 *
	 * @param newOperation the new operation
	 * @return the optional
	 * @throws AppCalcException the app calc exception
	 */
	public Optional<Operation> createOperation(Operation newOperation) throws AppCalcException;
	
	/**
	 * Find by session id.
	 *
	 * @param calcSessionId the calc session id
	 * @return the list
	 * @throws AppCalcException the app calc exception
	 */
	public List<Operation> findBySessionId(String calcSessionId) throws AppCalcException;
	
	/**
	 * Find by session id and date.
	 *
	 * @param calcSessionId the calc session id
	 * @param creationDate the creation date
	 * @return the list
	 * @throws AppCalcException the app calc exception
	 */
	public List<Operation> findBySessionIdAndDate(String calcSessionId, Date creationDate) throws AppCalcException;
	
	/**
	 * Gets the last result.
	 *
	 * @param calcSessionId the calc session id
	 * @return the last result
	 * @throws AppCalcException the app calc exception
	 */
	public Optional<Operation> getLastResult(String calcSessionId) throws AppCalcException;
}
