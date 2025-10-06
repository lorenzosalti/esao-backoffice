package org.lessons.java.esao_backoffice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(request -> request
        .requestMatchers("/conditions/create", "/conditions/edit/**").hasAuthority("ADMIN")
        .requestMatchers(HttpMethod.POST, "/conditions/**").hasAuthority("ADMIN")
        .requestMatchers("/records/delete/**").hasAnyAuthority("SUPERUSER", "ADMIN")
        .requestMatchers("/records", "/records/**", "/records/create", "/records/edit/**", "/conditions",
            "/conditions/**")
        .hasAnyAuthority("USER", "SUPERUSER", "ADMIN")
        .requestMatchers("/", "/**").permitAll())
        .formLogin(Customizer.withDefaults());
    return http.build();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }

}
