package com.appgate.calc.domain.ports;

import com.appgate.calc.domain.model.ArithmeticOperator;
import com.appgate.calc.domain.model.CalcSessionListRes;
import com.appgate.calc.domain.model.CalcSessionRes;
import com.appgate.calc.domain.model.NewOperationRes;
import com.appgate.calc.domain.model.Operation;

/**
 * The Interface CalcServicePort.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public interface CalcServicePort {
	
	public CalcSessionRes addCalcSession(String description);
	
	public CalcSessionListRes getAllCalcSessions();
	
	public CalcSessionRes calculateSession(String id, ArithmeticOperator operator);
	
	public NewOperationRes appOperationToSession(String id, Operation operation);

}
