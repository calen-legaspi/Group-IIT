package com.onb.orderingsystem.util;

import javax.naming.*;

/**
 * This utility class provide convenient methods to extract the values of environment entries.
 * Environment entries are located in the deployment descriptor.
 * Example code:
 * <code>
 * <env-entry>
 *       <env-entry-name>variableName</env-entry-name>
 *       <env-entry-type>java.lang.String</env-entry-type>
 *       <env-entry-value>Value</env-entry-value>
 * </env-entry>
 * </code>
 */
public class EnvironmentEntry {
    
    /**
     * Retrieves a String en
     * @param entryName the name of the environment entry to lookup from the list of environment entries.
     * @return the String value of the entry mapped by the parameter.
     * @throws IllegalArgumentException if the parameter is null.
     * @throws EnvironmentEntryException if the entry does not exists.
     * @throws ClassCastException if the environment variable does not exist(null) of is not a String.
     */
    public static String getAsString(String entryName) throws IllegalArgumentException, EnvironmentEntryException, ClassCastException {
        String entry = "";
        if(entryName == null) {
            throw new IllegalArgumentException("Parameter can't be null");
        } 
        try {
            Context context = new InitialContext();
            Context environment = (Context)context.lookup("java:comp/env");
            entry = (String)environment.lookup(entryName);
        } catch(NamingException e) {
            throw new EnvironmentEntryException("The entry does not exist:"+entryName);
        } catch(ClassCastException e) {
            throw new ClassCastException("The environment entry does not exist or is not a String");
        }
        return entry;
    }
}
