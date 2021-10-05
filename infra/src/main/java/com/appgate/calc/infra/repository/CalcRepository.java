package com.appgate.calc.infra.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appgate.calc.infra.entity.CalcSessionEntity;

/**
 * The Interface CalcRepository.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public interface CalcRepository extends JpaRepository<CalcSessionEntity, String> {

}