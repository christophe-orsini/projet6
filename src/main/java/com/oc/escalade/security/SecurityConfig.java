package com.oc.escalade.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
    UserDetailsService userDetailsService;
    /*
	@Override protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(userDetailsService).getUserDetailsService();
	}
	 */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
		        .authorizeRequests()
			        .antMatchers("/").permitAll()
			        .antMatchers("/inscription").permitAll()
			        .antMatchers("/theme/error").permitAll()
			        .antMatchers("/theme/fatal").permitAll()
			        .antMatchers("/public/**").permitAll()
			        .antMatchers("/webjars/**").permitAll()
			        .antMatchers("/inscrit/**").hasAnyRole("UTILISATEUR, MEMBRE, ADMINISTRATEUR")
			        .antMatchers("/membre/**").hasAnyRole("MEMBRE, ADMINISTRATEUR")
			        .anyRequest().hasAnyRole("ADMINISTRATEUR")
		        .and()
        		.formLogin()
	                .loginPage("/login")
	                .defaultSuccessUrl("/")
	                .permitAll()
	                .and()
	                .logout()
	                .logoutUrl("/logout")
	                .logoutSuccessUrl("/")
	                .invalidateHttpSession(true)
	                .permitAll();
    }

    /*
    @Bean
    public AuthenticationProvider getProvider()
    {
        AppAuthProvider provider = new AppAuthProvider();
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }
    */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
    
    /**
     * Création du Manager d'Authentification 
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
}
