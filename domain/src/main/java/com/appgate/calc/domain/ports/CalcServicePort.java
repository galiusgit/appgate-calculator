package com.appgate.calc.domain.ports;

import com.appgate.calc.domain.model.calcsession.CalcProcessReq;
import com.appgate.calc.domain.model.calcsession.CalcProcessRes;
import com.appgate.calc.domain.model.calcsession.CalcSessionListRes;
import com.appgate.calc.domain.model.calcsession.CalcSessionRes;
import com.appgate.calc.domain.model.operation.NewOperationRes;
import com.appgate.calc.domain.model.operation.OperationReq;
import com.appgate.calc.domain.model.operation.OperationRes;

/**
 * The Interface CalcServicePort.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public interface CalcServicePort {
	
	/**
	 * Adds the calc session.
	 *
	 * @param description the description
	 * @return the calc session res
	 */
	public CalcSessionRes addCalcSession(final String description);
	
	/**
	 * Gets the all calc sessions.
	 *
	 * @return the all calc sessions
	 */
	public CalcSessionListRes getAllCalcSessions();
	
	/**
	 * Builds the calc session process.
	 *
	 * @param calcProcessReq the calc process req
	 * @return the calc process res
	 */
	public CalcProcessRes buildCalcSessionProcess(final CalcProcessReq calcProcessReq);
	
	/**
	 * Adds the operation to session.
	 *
	 * @param operation the operation
	 * @return the new operation res
	 */
	public NewOperationRes addOperationToSession(final OperationReq operation);
	
	/**
	 * Gets the last result.
	 *
	 * @param calcSessionId the calc session id
	 * @return the last result
	 */
	public OperationRes getLastResult(final String calcSessionId); 

}
