package com.appgate.calc.infra.mapper;

import com.appgate.calc.domain.model.CalcSession;
import com.appgate.calc.infra.entity.CalcSessionEntity;

/**
 * The Class CalcSessionMapper.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public class CalcSessionMapper {

	/**
	 * Map.
	 *
	 * @param CalcSession the calc result
	 * @return the calc result entity
	 */
	public static CalcSessionEntity map(CalcSession calcSession) {
		return new CalcSessionEntity(calcSession.getId(), calcSession.getStatus(), calcSession.getResult(),
				calcSession.getDescription(), calcSession.getCreationDate(), calcSession.getUpdateDate());
	}

	/**
	 * Map.
	 *
	 * @param CalcSessionEntity the calc result entity
	 * @return the calc result
	 */
	public static CalcSession map(CalcSessionEntity calcSessionEntity) {
		return new CalcSession(calcSessionEntity.getId(), calcSessionEntity.getStatus(), calcSessionEntity.getResult(),
				calcSessionEntity.getDescription(), calcSessionEntity.getCreationDate(), calcSessionEntity.getUpdateDate());
	}

}
