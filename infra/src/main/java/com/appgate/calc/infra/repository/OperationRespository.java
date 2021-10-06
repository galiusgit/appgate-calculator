package com.appgate.calc.infra.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.appgate.calc.domain.exception.AppCalcException;
import com.appgate.calc.infra.entity.OperationEntity;

public interface OperationRespository extends JpaRepository<OperationEntity, String> {

	@Query(value = "select * from operation where calc_session_id =?1", nativeQuery = true)
	public List<OperationEntity> findBySessionId(String calcSessionId);
	
	@Query(value = "select * from operation where calc_session_id =?1 and creation_date >=?2", nativeQuery = true)
	public List<OperationEntity> findBySessionIdAndDate(String calcSessionId, Date creationDate);
	
	@Query(value = "select * from operation where calc_session_id =?1 and type = 'RESULT' "
			+ "order by creation_date desc limit 1;", nativeQuery = true)
	public OperationEntity getLastResult(String calcSessionId) throws AppCalcException;
	
	
}
