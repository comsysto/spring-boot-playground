package com.comsysto.configuration.spring.data;

import com.comsysto.configuration.Neo4jAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.neo4j.core.GraphDatabase;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;

@Configuration
@ConditionalOnClass ({GraphDatabase.class, GraphRepository.class})
@ConditionalOnMissingBean (RepositoryFactoryBeanSupport.class)
@ConditionalOnExpression ("${spring.data.neo4j.repositories.enabled:true}")
@Import (Neo4jRepositoriesAutoConfigureRegistrar.class)
@AutoConfigureAfter (Neo4jAutoConfiguration.class)
public class Neo4jRepositoriesAutoConfiguration
{
}
