package com.example.springsecurity.demosecuritydb.Configurations;

import com.example.springsecurity.demosecuritydb.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Config extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService service;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service);
    }

    // Every faculty should be able to operate on student APIs as well

    // 1. Either give your faculty multiple authorities - STUDENT, FACULTY
    // 2. Give only one authority to the user and while authorizing check for multiple scopes

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/student/greet2/**").hasAuthority("FACULTY")
                .antMatchers(HttpMethod.GET, "/student/*").hasAnyAuthority("STUDENT")
                .antMatchers("/faculty/**").hasAuthority("FACULTY")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin();
    }


    @Bean
    public PasswordEncoder getBEncoder(){
        return new BCryptPasswordEncoder();
    }
}
