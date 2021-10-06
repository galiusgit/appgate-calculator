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
	
	public CalcSessionRes addCalcSession(final String description);
	
	public CalcSessionListRes getAllCalcSessions();
	
	public CalcProcessRes buildCalcSessionProcess(final CalcProcessReq calcProcessReq);
	
	public NewOperationRes addOperationToSession(final OperationReq operation);
	
	public OperationRes getLastResult(final String calcSessionId); 

}
