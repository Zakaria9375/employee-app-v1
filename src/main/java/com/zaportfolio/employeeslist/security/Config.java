package com.zaportfolio.employeeslist.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class Config {
    @Bean
    public UserDetailsManager userDetailsManager (DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery(
            "SELECT username, password, enabled FROM users WHERE username=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
            "SELECT username, authority FROM authorities WHERE username=?");
        return jdbcUserDetailsManager;
    }
    @Bean
    public SecurityFilterChain filterChainLogin(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests( configurer -> configurer

                .requestMatchers(HttpMethod.GET,"/list").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET,"/list/new").hasRole("MANAGER")
                .requestMatchers(HttpMethod.GET,"/list/update").hasRole("MANAGER")
                .requestMatchers(HttpMethod.GET,"/list/delete").hasRole("ADMIN")
                .anyRequest().authenticated())
            .formLogin(form -> form
                .loginPage("/loginPage")
                .loginProcessingUrl("/authenticate")
                .permitAll())

            .logout(LogoutConfigurer::permitAll)

            .exceptionHandling(configurer -> configurer.accessDeniedPage("/access-denied"));
        return http.build();
    }

}
