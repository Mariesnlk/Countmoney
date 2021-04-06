package com.mariia.syne.splitwise.config;

import com.mariia.syne.splitwise.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@EnableWebSecurity
@PropertySource("classpath:user.properties")
@PropertySource("classpath:admin.properties")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Value("${user.login}")
//    private String userLogin;
//
//    @Value("${user.password}")
//    private String userPassword;

//    @Value("${admin.login}")
//    private String adminLogin;
//
//    @Value("${admin.password}")
//    private String adminPassword;
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

   /* @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser(adminLogin)
                .password(bCryptPasswordEncoder().encode(adminPassword))
                .roles("admin")
                .and()
                .withUser(userLogin)
                .password(bCryptPasswordEncoder().encode(userPassword))
                .roles("user");

    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/index",
                        "/static/images/**",
                        "/ui/users/**", "/users", "/users/**",
                        "/ui/groups/**", "/groups", "/groups/**",
                        "/ui/incomes/**", "/incomes", "/incomes/**",
                        "/ui/transactions/**", "/transactions","/transactions/**",
                        "/ui/typeTransactions/**", "/typeTransactions", "/typeTransactions/**").permitAll()
//                .antMatchers("/users/create","/orders/**").hasAnyRole("ADMIN","USER")
//                .antMatchers("/ui/users/list").hasAnyRole("admin")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .deleteCookies("JSESSIONID")
                .permitAll();

        //-----------session configuration
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);

        http
                .sessionManagement().maximumSessions(2);

        http
                .sessionManagement().sessionFixation().newSession();
    }




    @Autowired
    UsersService userService;

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

}