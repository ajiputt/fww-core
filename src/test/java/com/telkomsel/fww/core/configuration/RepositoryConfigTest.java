package com.telkomsel.fww.core.configuration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.rest.core.config.EnumTranslationConfiguration;
import org.springframework.data.rest.core.config.MetadataConfiguration;
import org.springframework.data.rest.core.config.ProjectionDefinitionConfiguration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@ExtendWith(MockitoExtension.class)
class RepositoryConfigTest {

    private RepositoryRestConfiguration config;

    private CorsRegistry cors;

    RepositoryConfig repositoryConfig;

    @Mock
    ProjectionDefinitionConfiguration projectionConfiguration;

    @Mock
    MetadataConfiguration metadataConfiguration;

    @Mock
    EnumTranslationConfiguration enumTranslationConfiguration;

    @BeforeEach
    void init() {
        repositoryConfig = new RepositoryConfig();
        config = new RepositoryRestConfiguration(projectionConfiguration,
                metadataConfiguration, enumTranslationConfiguration);
        cors = new CorsRegistry();
    }

    @Test
    void configureRepositoryRestConfiguration() {
        repositoryConfig.configureRepositoryRestConfiguration(config, cors);
        org.junit.jupiter.api.Assertions.assertTrue(true, "ok");
    }
}