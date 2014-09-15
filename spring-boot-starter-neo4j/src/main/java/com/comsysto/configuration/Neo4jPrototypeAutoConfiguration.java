package com.comsysto.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.core.GraphDatabase;

@Configuration
@ConditionalOnClass(GraphDatabase.class)
public class Neo4jPrototypeAutoConfiguration extends Neo4jConfiguration
{
    public Neo4jPrototypeAutoConfiguration() throws ClassNotFoundException
    {
        setBasePackage("");
    }
}
