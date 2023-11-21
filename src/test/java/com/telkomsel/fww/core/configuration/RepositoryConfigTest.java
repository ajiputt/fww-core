package com.telkomsel.fww.core.configuration;

import com.telkomsel.fww.core.model.Airport;
import com.telkomsel.fww.core.model.Schedule;
import com.telkomsel.fww.core.projection.ReservationView;
import com.telkomsel.fww.core.projection.ScheduleView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.rest.core.config.EnumTranslationConfiguration;
import org.springframework.data.rest.core.config.MetadataConfiguration;
import org.springframework.data.rest.core.config.ProjectionDefinitionConfiguration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@ExtendWith(MockitoExtension.class)
public class RepositoryConfigTest {


    private RepositoryRestConfiguration config;

    @Mock
    ProjectionDefinitionConfiguration projectionConfiguration;

    @Mock
    MetadataConfiguration metadataConfiguration;

    @Mock
    EnumTranslationConfiguration enumTranslationConfiguration;

    @BeforeEach
    void init() {
        config = new RepositoryRestConfiguration(projectionConfiguration,
                metadataConfiguration, enumTranslationConfiguration);
    }


    @Test
    public void configureRepositoryRestConfiguration() {
        config.exposeIdsFor(Schedule.class);
        config.exposeIdsFor(Airport.class);

        config.getProjectionConfiguration().addProjection(ScheduleView.class);
        config.getProjectionConfiguration().addProjection(ReservationView.class);
    }
}
