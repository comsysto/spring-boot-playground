package com.comsysto.configuration.spring.data;

import org.springframework.boot.autoconfigure.data.AbstractRepositoryConfigurationSourceSupport;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jRepositoryConfigurationExtension;
import org.springframework.data.repository.config.RepositoryConfigurationExtension;

import java.lang.annotation.Annotation;

public class Neo4jRepositoriesAutoConfigureRegistrar
    extends AbstractRepositoryConfigurationSourceSupport
{
    @Override
    protected Class<? extends Annotation> getAnnotation()
    {
        return EnableNeo4jRepositories.class;
    }

    @Override
    protected Class<?> getConfiguration()
    {
        return EnableNeo4jRepositoriesConfiguration.class;
    }

    @Override
    protected RepositoryConfigurationExtension getRepositoryConfigurationExtension()
    {
        return new Neo4jRepositoryConfigurationExtension();
    }

    @EnableNeo4jRepositories(basePackages = "")
    private static class EnableNeo4jRepositoriesConfiguration {}
}
