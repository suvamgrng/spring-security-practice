package com.suvam.securitypractice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        http
                .authorizeHttpRequests(auth -> auth

                        // ✅ Public pages - no login needed
                        .requestMatchers(
                                "/students/**",   // your students API
                                "/login",         // 👈 ADD THIS! Login page itself
                                "/logout"         // 👈 ADD THIS! Logout endpoint
                        ).permitAll()

                        // 🔐 Everything else needs login
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")       // Your custom login page URL
                        .defaultSuccessUrl("/students", true) // 👈 Where to go after login
                        .permitAll()
                )
                .logout(log -> log
                        .logoutSuccessUrl("/login?logout")  // 👈 Where to go after logout
                        .permitAll()
                );

        return http.build();
    }
}
