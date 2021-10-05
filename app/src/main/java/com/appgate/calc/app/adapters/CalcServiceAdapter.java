package com.appgate.calc.app.adapters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appgate.calc.domain.model.ArithmeticOperator;
import com.appgate.calc.domain.model.CalcSessionListRes;
import com.appgate.calc.domain.model.CalcSessionRes;
import com.appgate.calc.domain.model.NewOperationRes;
import com.appgate.calc.domain.model.Operation;
import com.appgate.calc.domain.ports.CalcRepositoryPort;
import com.appgate.calc.domain.ports.CalcServicePort;
import com.appgate.calc.domain.service.CalcProcessor;

/**
 * The Class CalcServiceAdapter.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class CalcServiceAdapter implements CalcServicePort {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(CalcServiceAdapter.class);
	
	/** The calculator repository port. */
	@Autowired
	private CalcRepositoryPort calcRepositoryPort;
	
	/** The calculator processor. */
	private CalcProcessor calcProcessor = new CalcProcessor();

	@Override
	public CalcSessionRes addCalcSession(String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CalcSessionListRes getAllCalcSessions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CalcSessionRes calculateSession(String id, ArithmeticOperator operator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NewOperationRes appOperationToSession(String id, Operation operation) {
		// TODO Auto-generated method stub
		return null;
	}

}
