package com.appgate.calc.app.config;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	/** The Constant NUM_TOKENS. */
	private static final Integer NUM_TOKENS = 1;
	
	/** The Constant LIMIT_CONCURRENCY. */
	private static final long LIMIT_CONCURRENCY = 500;

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
	 * NOTE: 500 requests by second
	 *
	 * @return the bucket
	 */
	private Bucket newBucketLimiter() {
		return Bucket4j.builder().addLimit(
				Bandwidth.classic(LIMIT_CONCURRENCY, 
						Refill.intervally(LIMIT_CONCURRENCY, Duration.ofSeconds(1)))).build();
	}
}
