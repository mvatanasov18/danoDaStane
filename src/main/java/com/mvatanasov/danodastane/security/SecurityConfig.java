package com.mvatanasov.danodastane.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

@Bean
    JdbcUserDetailsManager users(DataSource dataSource){
    JdbcUserDetailsManager jdbcUserDetailsManager=new JdbcUserDetailsManager(dataSource);
    return jdbcUserDetailsManager;
}

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests(auth->{
                    auth.antMatchers("/index").permitAll();
                    auth.antMatchers("/").permitAll();
                    auth.antMatchers("/ceopage");
                    auth.antMatchers("/teamleadpage");
                    auth.antMatchers("/login").permitAll();
                    auth.antMatchers("/postRegister").permitAll();
                })
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}
