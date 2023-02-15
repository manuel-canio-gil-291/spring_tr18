package es.iesjandula.spring_tr18.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig
{
    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception
    {
        http.authorizeHttpRequests()

            .requestMatchers("/inicio/","/inicio/acerca_de","/login","/login-error","/acceso-denegado","/css/**").permitAll()
            .requestMatchers("/aulas_informatica/","/carritos_pcs/","/carritos_tablets/","/profesores/").hasRole("ADMIN")
            .requestMatchers("/reservas/").hasAnyRole("ADMIN","USER_CARRITO_1PLANTA","USER_CARRITO_2PLANTA")
            .anyRequest().authenticated()
            .and().formLogin().loginPage("/login").failureUrl("/login-error").permitAll()
            .and().logout().logoutSuccessUrl("/inicio/").permitAll()
            .and().exceptionHandling().accessDeniedPage("/acceso-denegado")
            .and().httpBasic();

        http.csrf().disable();

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager()
    {
        UserDetails admin = User.withUsername("paco").password("{noop}admin").roles("ADMIN").build();
        UserDetails carrito1 = User.withUsername("rafael").password("{noop}carro1").roles("USER_CARRITO_1PLANTA").build();
        UserDetails carrito2 = User.withUsername("juana").password("{noop}carro2").roles("USER_CARRITO_2PLANTA").build();
        return new InMemoryUserDetailsManager(admin,carrito1,carrito2);
    }
}
