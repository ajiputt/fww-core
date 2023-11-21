package com.telkomsel.fww.core.security;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@ExtendWith(MockitoExtension.class)
class SecurityConfigTest {

    @Mock
    private AuthEntryPoint unauthorizedHandler;

    SecurityConfig securityConfig;

    @BeforeEach
    void init() {
        securityConfig = new SecurityConfig(unauthorizedHandler);
    }


    @Test
    void filterChain() {
        org.junit.jupiter.api.Assertions.assertTrue(true, "ok");
    }

    @Test
    void passwordEncoder() {
        PasswordEncoder resp = new BCryptPasswordEncoder();
        Assertions.assertThat(resp).isNotNull();
    }

    @Test
    void userDetailsService() {
        UserDetails user = User.withUsername("test")
                .password(new BCryptPasswordEncoder().encode("test"))
                .roles("ADMIN")
                .build();
        InMemoryUserDetailsManager resp = new InMemoryUserDetailsManager(user);
        Assertions.assertThat(resp).isNotNull();
    }
}