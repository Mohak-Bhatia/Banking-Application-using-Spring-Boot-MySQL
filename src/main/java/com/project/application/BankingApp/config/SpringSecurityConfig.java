package com.project.application.BankingApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf((csrf) -> csrf.disable()).
                authorizeHttpRequests((authorize) -> {
                    authorize.requestMatchers(HttpMethod.POST,"/api/accounts").hasRole("admin");
                    authorize.requestMatchers(HttpMethod.GET,"/api/accounts/**").hasRole("admin");
                    authorize.requestMatchers(HttpMethod.DELETE,"/api/accounts/**").hasRole("admin");
                    authorize.anyRequest().authenticated();
                } ).
                httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService(){
        UserDetails userOne = User.builder().
                username("User1").
                roles("user").
                password(passwordEncoder().
                        encode("efjbsgihiuwgsdui234287")).build();


        UserDetails adminOne = User.builder().
                username("Admin1").
                roles("admin").
                password(passwordEncoder().
                        encode("ekhbwefb347hjesdsf7")).build();

        return new InMemoryUserDetailsManager(userOne,adminOne);
    }
}
