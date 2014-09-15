package com.comsysto.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties (prefix = "spring.data.neo4j")
public class Neo4jProperties
{
    private String databaseName = "test.db";

    public String getDatabaseName()
    {
        return databaseName;
    }

    public void setDatabaseName(String databaseName)
    {
        this.databaseName = databaseName;
    }
}
