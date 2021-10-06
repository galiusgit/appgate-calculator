package com.appgate.calc.infra.mapper;

import com.appgate.calc.domain.model.calcsession.CalcSession;
import com.appgate.calc.infra.entity.CalcSessionEntity;

/**
 * The Class CalcSessionMapper.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public class CalcSessionMapper {

	public static CalcSessionEntity mapTo(CalcSession calcSession) {
		if(calcSession == null) {
			return null;
		}
		return new CalcSessionEntity(calcSession.getId(), calcSession.getStatus(), calcSession.getResult(),
				calcSession.getDescription(), calcSession.getCreationDate(), calcSession.getUpdateDate());
	}

	public static CalcSession mapTo(CalcSessionEntity calcSessionEntity) {
		if(calcSessionEntity == null) {
			return null;
		}
		return new CalcSession(calcSessionEntity.getId(), calcSessionEntity.getStatus(), calcSessionEntity.getResult(),
				calcSessionEntity.getDescription(), calcSessionEntity.getCreationDate(), calcSessionEntity.getUpdateDate());
	}

}
