package com.comsysto.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

@Configuration
@ConditionalOnClass(Neo4jAutoConfiguration.class)
public class Neo4jDataAutoConfiguration extends Neo4jConfiguration
{
    public Neo4jDataAutoConfiguration()
    {
        setBasePackage("");
    }
}
