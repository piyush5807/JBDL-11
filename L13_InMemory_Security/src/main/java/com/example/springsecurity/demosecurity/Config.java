package com.example.springsecurity.demosecurity;

import com.sun.tools.corba.se.idl.Noop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Config extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Piyush")
                .password("$2a$10$vv5DzDO1KWGO.M4Ns5.CHeJJLW69CrB2IPMgOtcm.5B8G.bZhhDW.")
                .authorities("FACULTY")
                .and()
                .withUser("Karan")
                .password("$2a$10$7V.AjxaQWlC1e4KjTobg4uchoZ1wzP.IksxFzK9MMTL0g9uApreAK")
                .authorities("STUDENT");
    }

    // Every faculty should be able to operate on student APIs as well

    // 1. Either give your faculty multiple authorities - STUDENT, FACULTY
    // 2. Give only one authority to the user and while authorizing check for multiple scopes

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/student/greet2/**").hasAuthority("FACULTY")
                .antMatchers(HttpMethod.GET, "/student/*").hasAnyAuthority("STUDENT", "FACULTY")
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
