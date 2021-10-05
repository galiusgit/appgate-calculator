package com.appgate.calc.domain.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

/**
 * The Class JsonUtil.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public class JsonUtil {
	
    /** The mapper. */
    private static ObjectMapper mapper;

    /**
     * Instantiates a new json util.
     */
    private JsonUtil() {
    	throw new IllegalStateException("Utility class");
    }

    /**
     * Gets the mapper.
     *
     * @return the mapper
     */
    public static ObjectMapper getMapper() {
    	if (mapper == null) {
    		mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN, true);
            mapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
            mapper.setNodeFactory(JsonNodeFactory.withExactBigDecimals(true));
    	}
        return mapper;
    }
    
    /**
     * Map to json string.
     *
     * @param <T> the generic type
     * @param json the json string to map
     * @param classToConvert the type of class to convert
     * @return the object converted
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static  <T> T mapFromJson(String json, Class<T> classToConvert) throws IOException {
        return  JsonUtil.getMapper().readValue(json, classToConvert);
    }

}
