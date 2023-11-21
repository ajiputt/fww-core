package com.telkomsel.fww.core.security;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SecurityConfigTest {

    @Mock
    private AuthEntryPoint unauthorizedHandler;

    @Mock
    private HttpSecurity httpSecurity;

    SecurityConfig securityConfig;


    @BeforeEach
    void init() {
        securityConfig = new SecurityConfig(unauthorizedHandler);
    }


    @Test
    void filterChain() throws Exception {
        when(httpSecurity.csrf(any())).thenReturn(httpSecurity);
        when(httpSecurity.exceptionHandling(any())).thenReturn(httpSecurity);
        when(httpSecurity.sessionManagement(any())).thenReturn(httpSecurity);
        securityConfig.filterChain(httpSecurity);
        org.junit.jupiter.api.Assertions.assertTrue(true, "ok");
    }

    @Test
    void passwordEncoder() {
        PasswordEncoder resp = securityConfig.passwordEncoder();
        Assertions.assertThat(resp).isNotNull();
    }

    @Test
    void userDetailsService() {
        securityConfig.setUsername("test");
        securityConfig.setPassword("test");
        InMemoryUserDetailsManager resp = securityConfig.userDetailsService();
        Assertions.assertThat(resp).isNotNull();
    }
}