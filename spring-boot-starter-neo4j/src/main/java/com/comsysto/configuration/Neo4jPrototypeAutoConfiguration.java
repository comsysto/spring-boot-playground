package com.comsysto.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.core.GraphDatabase;

@Configuration
@ConditionalOnClass(GraphDatabase.class)
@EnableNeo4jRepositories (basePackages = "")
public class Neo4jPrototypeAutoConfiguration extends Neo4jConfiguration
{
    public Neo4jPrototypeAutoConfiguration() throws ClassNotFoundException
    {
        setBasePackage("");
    }
}
