package main.java.stockmarket.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import main.java.stockmarket.Entities.User;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
    DetailsService detailsService;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        //HTTP Basic authentication
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/shares").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/shares").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/shares/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/shares/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/shares/**").hasRole("ADMIN")     
                .antMatchers(HttpMethod.GET, "/sharesBook").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/sharesBook/**").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/sharesBook/**").hasRole("ADMIN")       
                .antMatchers(HttpMethod.GET, "/users").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/users").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/users/{userId}").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/users/{userId}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/users/{userId}").hasRole("ADMIN")              
                .antMatchers(HttpMethod.GET, "/users/{userId}/shares").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/users/{userId}/shares/{shareCode}").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/users/{userId}/shares/{shareCode}").hasRole("USER")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(detailsService).passwordEncoder(User.PASSWORD_ENCODER);
//        auth.inMemoryAuthentication()
//                .withUser("user").password("{noop}password").roles("USER")
//                .and()
//                .withUser("admin").password("{noop}password").roles("USER", "ADMIN");

    }

}
