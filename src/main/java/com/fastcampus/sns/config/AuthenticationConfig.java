package com.fastcampus.sns.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class AuthenticationConfig {

    private static final String[] PERMIT_ALL_PATTERNS = {
            "/api/*/users/join",
            "/api/*/users/login"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authRequests) ->
                        authRequests
                                .requestMatchers(PERMIT_ALL_PATTERNS).permitAll()
                                .requestMatchers("/api/**").authenticated()
                                .anyRequest().authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                TODO
//                .exceptionHandling()
//                .authenticationEntryPoint()
                .build();
    }

}
