package com.appgate.calc.infra.mapper;

import com.appgate.calc.domain.model.operation.Operation;
import com.appgate.calc.infra.entity.OperationEntity;

public class OperationMapper {
	
	public static OperationEntity mapTo(Operation ope) {
		if(ope == null) {
			return null;
		}
		return new OperationEntity(ope.getId(), ope.getCalcSessionId(), 
				ope.getValue(), ope.getFromOtherSessionId(), 
				ope.getCreationDate(), ope.getType(), 
				ope.getOperator(), ope.getDescription());
	}
	
	public static Operation mapTo(OperationEntity opeEntity) {
		if(opeEntity == null) {
			return null;
		}
		return new Operation(opeEntity.getId(), opeEntity.getCalcSessionId(), 
				opeEntity.getValue(), opeEntity.getFromOtherSessionId(), 
				opeEntity.getCreationDate(), opeEntity.getType(), 
				opeEntity.getOperator(), opeEntity.getDescription());
	}

}
