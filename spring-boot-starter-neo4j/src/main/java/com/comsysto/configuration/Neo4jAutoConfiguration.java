package com.comsysto.configuration;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

import javax.annotation.PostConstruct;

@Configuration
@ConditionalOnClass(Node.class)
@EnableNeo4jRepositories(basePackages = "com.comsysto.boot.neo4j")
public class Neo4jAutoConfiguration extends Neo4jConfiguration
{
    public Neo4jAutoConfiguration()
    {
        setBasePackage("com.comsysto.boot.neo4j");
    }

    @Bean
    GraphDatabaseService graphDatabaseService() {
        return new GraphDatabaseFactory().newEmbeddedDatabase("accessingdataneo4j.db");
    }

    @PostConstruct
    public void init()
    {
        System.out.println("test");
    }


}
