package com.powerup.propertymicroservice.infrastructure.security;

import com.powerup.propertymicroservice.infrastructure.security.jwt.JwtTokenValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtTokenValidator jwtTokenValidator;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(http -> {
                    http.requestMatchers(HttpMethod.GET, "/swagger-ui/**", "/v3/api-docs*/**").permitAll();
                    http.requestMatchers(HttpMethod.POST, "/api/v1/category/create").hasAuthority("ADMIN");
                    http.requestMatchers(HttpMethod.POST, "/api/v1/ubication/create").hasAuthority("ADMIN");
                    http.requestMatchers(HttpMethod.POST, "/api/v1/house/create").hasAuthority("SELLER");

                    http.anyRequest().permitAll();
                })
                .addFilterBefore(jwtTokenValidator, BasicAuthenticationFilter.class)
                .build();
    }
}
