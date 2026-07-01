package com.cinema.crvg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. Desabilita o CSRF completamente (necessário para APIs REST e para o H2 funcionar)
                .csrf(csrf -> csrf.disable())

                // 2. Configura as permissões das rotas
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers("/swagger-ui/**", "/swagger-ui.html", "/v3/api-docs/**").permitAll()
                        .anyRequest().authenticated() // Protege as rotas de Sessão, Cinema, etc.
                )

                // 3. Permite que o H2 Console abra em frames do navegador
                .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()))

                // 4. FORÇA A API A SER STATELESS (Isso mata o loop do navegador)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // 5. Ativa o HTTP Basic padrão
                .httpBasic(httpBasic -> {});

        return http.build();
    }
}