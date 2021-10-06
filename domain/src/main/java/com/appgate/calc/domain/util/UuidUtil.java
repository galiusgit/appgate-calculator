package com.appgate.calc.domain.util;

import java.util.UUID;

/**
 * The Class UuidUtil.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public class UuidUtil {

    /**
     * Instantiates a new uuid util.
     */
    private UuidUtil(){
        throw new IllegalStateException("Utility class");
    }
    
    /**
     * New uuid.
     *
     * @return the string
     */
    public static String newUuid() {
        return UUID.randomUUID().toString();
    }
    
    /**
     * Checks if is uuid.
     *
     * @param string the string
     * @return true, if is uuid
     */
    public static boolean isUUID(String string) {
        try {
        	if (string == null) {
        		return false;
        	}
            UUID.fromString(string);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

}