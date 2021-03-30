package com.mariia.syne.splitwise.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@EnableWebSecurity
@PropertySource("classpath:user.properties")
@PropertySource("classpath:admin.properties")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${user.login}")
    private String userLogin;

    @Value("${user.password}")
    private String userPassword;

    @Value("${admin.login}")
    private String adminLogin;

    @Value("${admin.password}")
    private String adminPassword;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser(adminLogin)
                .password(passwordEncoder().encode(adminPassword))
                .roles("admin")
                .and()
                .withUser(userLogin)
                .password(passwordEncoder().encode(userPassword))
                .roles("user");

//        auth
//                .inMemoryAuthentication()
//                .withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("USER")
//                .and()
//                .withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
//                .and()
//                .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
    }

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

        //enable the scenario which allows multiple concurrent sessions
        //for the same user
        http
                .sessionManagement().maximumSessions(2);

        //on authentication a new HTTP Session is created,
        //the old one is invalidated and
        //(migrateSession) the attributes from the old session are copied over
        //(newSession) the attributes from the old session are NOT copied over
        http
                .sessionManagement().sessionFixation().newSession();
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //for the enabling the concurrent session-control support we add listener
    //to make sure that the Spring Security session registry is notified
    //when the session is destroyed
    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

}