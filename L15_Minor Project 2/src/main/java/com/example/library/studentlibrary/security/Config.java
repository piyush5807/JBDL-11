package com.example.library.studentlibrary.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
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

    // /student/ -> get (ADMIN/ STUDENT) , put STUDENT ADMIN, delete ADMIN, POST ADMIN
    // /book/ -> GET STUDENT ADMIN, POST/PUT/DELETE ADMIN
    // /transaction/ (issue or return) -> GET ADMIN STUDENT, POST PUT DELETE ADMIN
    // /author/ no authentication or authorization

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.
                csrf().disable().
                httpBasic().and().
                authorizeRequests()
                .antMatchers(HttpMethod.PUT, "/student/update_password/**").hasAnyAuthority(AuthorityConstants.STUDENT_AUTHORITY)
                .antMatchers(HttpMethod.PUT, "/student/**").hasAnyAuthority("STUDENT", "ADMIN")
                .antMatchers(HttpMethod.GET, "/student/all/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/student/studentById/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/student/**").hasAuthority("STUDENT")
                .antMatchers("/student/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/book/**").hasAnyAuthority("ADMIN", "STUDENT")
                .antMatchers("/book/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/transaction/all/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/transaction/**").hasAnyAuthority("ADMIN", "STUDENT")
                .antMatchers("/transaction/**").hasAuthority("ADMIN")
                .antMatchers("/**").permitAll()
                .and().formLogin();
    }

    @Bean
    public PasswordEncoder getPE(){
        return new BCryptPasswordEncoder();
    }
}
