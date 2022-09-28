package com.example.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Component-based security configuration.
 *
 * @implNote {@code WebSecurityConfigurerAdapter} is deprecated.
 */
@Configuration
public class SecurityConfiguration {

  /**
   * It is used for setting HttpSecurity
   * instead of the {@code configure(HttpSecurity http)}
   * in the {@code WebSecurityConfigurerAdapter}.
   */
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .sessionManagement()
          .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .cors().and().csrf().disable();

    return http.build();
  }
}