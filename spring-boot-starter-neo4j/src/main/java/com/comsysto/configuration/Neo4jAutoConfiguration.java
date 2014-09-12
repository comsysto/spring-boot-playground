package com.comsysto.configuration;

import org.neo4j.graphdb.Node;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(Node.class)
public class Neo4jAutoConfiguration
{
    @Bean
    public String testBean()
    {
        return "test";
    }
}
