package com.telkomsel.fww.core.configuration;

import com.telkomsel.fww.core.model.Airport;
import com.telkomsel.fww.core.model.Member;
import com.telkomsel.fww.core.model.MemberToken;
import com.telkomsel.fww.core.model.Schedule;
import com.telkomsel.fww.core.projection.MemberView;
import com.telkomsel.fww.core.projection.ReservationView;
import com.telkomsel.fww.core.projection.ScheduleView;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(
            RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Schedule.class);
        config.exposeIdsFor(Airport.class);
        config.exposeIdsFor(Member.class);
        config.exposeIdsFor(MemberToken.class);

        config.getProjectionConfiguration().addProjection(ScheduleView.class);
        config.getProjectionConfiguration().addProjection(ReservationView.class);
        config.getProjectionConfiguration().addProjection(MemberView.class);
    }

}
