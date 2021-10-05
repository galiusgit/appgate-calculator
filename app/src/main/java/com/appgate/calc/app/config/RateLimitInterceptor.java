package com.appgate.calc.app.config;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.ConsumptionProbe;
import io.github.bucket4j.Refill;

/**
 * The Class RateLimitInterceptor.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
public class RateLimitInterceptor implements HandlerInterceptor {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(RateLimitInterceptor.class);

	/** The Constant NUM_TOKENS. */
	private static final Integer NUM_TOKENS = 1;
	
	/** The Constant one million. */
	private static final long ONE_MILLION = 1000000;

	/**
	 * Pre handle.
	 *
	 * @param request the request
	 * @param response the response
	 * @param handler the handler
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		LOGGER.debug("------> RateLimitInterceptor init");
		ConsumptionProbe consumptionProbe = newBucketLimiter().tryConsumeAndReturnRemaining(NUM_TOKENS);
	    if (consumptionProbe.isConsumed()) {
	      response.addHeader("X-Rate-Limit-Remaining", Long.toString(consumptionProbe.getRemainingTokens()));
	      return true;
	    }
	    response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value()); // 429
	    response.addHeader("X-Rate-Limit-Retry-After-Milliseconds",
	        Long.toString(TimeUnit.NANOSECONDS.toMillis(consumptionProbe.getNanosToWaitForRefill())));
	    return false;
	}

	/**
	 * New bucket limiter.
	 *
	 * @return the bucket
	 */
	private Bucket newBucketLimiter() {
		//return Bucket4j.builder().addLimit(Bandwidth.classic(1, Refill.intervally(10000, Duration.ofMinutes(1)))).build();
		// (Entre 100 y 1 millón de peticiones por segundo)
		return Bucket4j.builder().addLimit(Bandwidth.classic(ONE_MILLION, Refill.intervally(ONE_MILLION, Duration.ofSeconds(1)))).build();
	}
}
