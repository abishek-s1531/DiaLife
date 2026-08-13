package com.diabetic.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

   
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable()).sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).authorizeHttpRequests(auth -> auth.requestMatchers("/api/auth/**").permitAll()

                // ADMIN ONLY
                // Manage users
                .requestMatchers("/api/users/**").hasRole("ADMIN")

                // Manage roles
                .requestMatchers("/api/roles/**").hasRole("ADMIN")

                // Manage doctors
                .requestMatchers("/api/doctors/**").hasRole("ADMIN")

                // ADMIN + DOCTOR
                // Prescriptions
                .requestMatchers("/api/prescriptions/**").hasAnyRole("ADMIN", "DOCTOR")


               
                // ADMIN + DOCTOR + PATIENT
                

                // Appointments
                .requestMatchers("/api/appointments/**").hasAnyRole("ADMIN", "DOCTOR", "PATIENT")

                // Health Records
                .requestMatchers("/api/healthRecords/**").hasAnyRole("ADMIN", "DOCTOR", "PATIENT")

                // Medications
                .requestMatchers("/api/medications/**").hasAnyRole("ADMIN", "DOCTOR", "PATIENT")


                // EVERYTHING ELSE
                // User must be logged in
                .anyRequest().authenticated()
            )

            // Basic Authentication for now
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}