package com.grs.config;

import com.grs.filter.JwtRequestFilter;
import com.grs.repository.UserRepository;
import com.grs.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserRepository userRepository;


    @Autowired
    private JwtRequestFilter jwtRequestFilter;



    private MyUserDetailService myUserDetailService;

   @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

       auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder());
   }

    private PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

      //  http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    }
}
