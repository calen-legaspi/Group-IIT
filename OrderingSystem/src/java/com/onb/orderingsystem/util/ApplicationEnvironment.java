package com.onb.orderingsystem.util;

/**
 *
 * 
 */
public enum ApplicationEnvironment {
    TEST("TEST"),
    PRODUCTION("PRODUCTION"),
    DEVELOPMENT("DEVELOPMENT");
    
    public String dbName;
    public String dbConnectionDriver;
    public String dbUrl;
    public String dbPort;
    public String dbUsername;
    public String dbPassword;

    private ApplicationEnvironment(String prepend) {
        try {
            dbName              = EnvironmentEntry.getAsString(prepend+"_DBNAME");
            dbConnectionDriver  = EnvironmentEntry.getAsString(prepend+"_DBCONNECTIONDRIVER");
            dbUrl               = EnvironmentEntry.getAsString(prepend+"_DBURL");
            dbPort              = EnvironmentEntry.getAsString(prepend+"_DBPORT");
            dbUsername          = EnvironmentEntry.getAsString(prepend+"_USERNAME");
            dbPassword          = EnvironmentEntry.getAsString(prepend+"_PASSWORD");
        } catch(EnvironmentEntryException e) {
            System.exit(1);
        }
        
    }
    
    
}
