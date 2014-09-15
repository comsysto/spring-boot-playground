package com.comsysto.configuration;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.core.GraphDatabase;

@Configuration
@ConditionalOnClass(GraphDatabase.class)
@EnableConfigurationProperties(Neo4jProperties.class)
public class Neo4jAutoConfiguration
{
    @Autowired
    private Neo4jProperties neo4jProperties;

    @Bean
    GraphDatabaseService graphDatabaseService()
    {
        return new GraphDatabaseFactory().newEmbeddedDatabase(neo4jProperties.getDatabaseName());
    }
}
