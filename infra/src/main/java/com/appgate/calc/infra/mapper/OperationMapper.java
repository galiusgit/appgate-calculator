package com.appgate.calc.infra.mapper;

import com.appgate.calc.domain.model.Operation;
import com.appgate.calc.infra.entity.OperationEntity;

public class OperationMapper {
	
	public static OperationEntity mapTo(Operation ope) {
		return new OperationEntity(ope.getId(), ope.getCalcSessionId(), 
				ope.getValue(), ope.getFromOtherSessionId(), 
				ope.getCreationDate(), ope.getType(), 
				ope.getOperator(), ope.getDescription());
	}
	
	public static Operation mapTo(OperationEntity ope) {
		return new Operation(ope.getId(), ope.getCalcSessionId(), 
				ope.getValue(), ope.getFromOtherSessionId(), 
				ope.getCreationDate(), ope.getType(), 
				ope.getOperator(), ope.getDescription());
	}

}
