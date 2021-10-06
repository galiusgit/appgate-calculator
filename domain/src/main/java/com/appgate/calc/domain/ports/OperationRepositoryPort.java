package com.appgate.calc.domain.ports;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.appgate.calc.domain.exception.AppCalcException;
import com.appgate.calc.domain.model.operation.Operation;

public interface OperationRepositoryPort {
	
	public Optional<Operation> createOperation(Operation newOperation) throws AppCalcException;
	
	public List<Operation> findBySessionId(String calcSessionId) throws AppCalcException;
	
	public List<Operation> findBySessionIdAndDate(String calcSessionId, Date creationDate) throws AppCalcException;
	
	public Optional<Operation> getLastResult(String calcSessionId) throws AppCalcException;
}
