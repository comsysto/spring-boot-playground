package com.comsysto.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(Neo4jAutoConfiguration.class)
public class Neo4jDataAutoConfiguration
{
}
