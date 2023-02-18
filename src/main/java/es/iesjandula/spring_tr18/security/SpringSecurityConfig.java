/**
 * ------------------------------------------------------
 * | WARNING!!!                                         |
 * | This is a stable version of the code application.  |
 * | Please, don't modify!                              |
 * ------------------------------------------------------
 */
package es.iesjandula.spring_tr18.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
/**
 * This class is a security configuration that allows manage which endpoints and URLs can be
 * accesible for the public and which can be accesible only a user with an assigned role
 * @author Manuel Canio Gil
 * @version 1.4.0
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig
{
    /**
     * This {@code Bean} method is the {@code SecurityFilterChain} that configure the endpoints for the public access
     * and the endpoints for the private access with a role identification
     * @param http
     * @return The build of the Security Filter Chain with authorization of the HTTP requests
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception
    {
        http.authorizeHttpRequests()

            .requestMatchers("/inicio/","/inicio/acerca_de","/login","/login-error","/acceso-denegado","/css/**").permitAll()
            .requestMatchers("/aulas_informatica/","/carritos_pcs/","/carritos_tablets/","/profesores/").hasRole("ADMIN")
            .requestMatchers("/reservas/","/reservas/formulario_nueva_reserva_aula","/reservas/formulario_actualizar_reserva_aula/{id}","/reservas/anular_reserva_aula/{id}").hasAnyRole("ADMIN","USER_CARRITO_PC","USER_CARRITO_TABLET")
            .requestMatchers("/reservas/formulario_nueva_reserva_carrito_pcs","/reservas/formulario_actualizar_reserva_carrito_pcs/{id}","/reservas/anular_reserva_carrito_pcs/{id}").hasAnyRole("ADMIN","USER_CARRITO_PC")
            .requestMatchers("/reservas/formulario_nueva_reserva_carrito_tablets","/reservas/formulario_actualizar_reserva_carrito_tablets/{id}","/reservas/anular_reserva_carrito_tablets/{id}").hasAnyRole("ADMIN","USER_CARRITO_TABLET")
            .anyRequest().authenticated()
            .and().formLogin().loginPage("/login").failureUrl("/login-error").permitAll()
            .and().logout().logoutSuccessUrl("/inicio/").permitAll()
            .and().exceptionHandling().accessDeniedPage("/acceso-denegado")
            .and().httpBasic();

        http.csrf().disable();

        return http.build();
    }
    /**
     * This {@code Bean} method stores the user data for the identification and log in to access the private pages
     * @return the user details with username and password
     */
    @Bean
    public InMemoryUserDetailsManager userDetailsManager()
    {
        UserDetails admin = User.withUsername("paco").password("{noop}admin").roles("ADMIN").build();
        UserDetails carritopc = User.withUsername("rafael").password("{noop}carropc").roles("USER_CARRITO_PC").build();
        UserDetails carritotablet = User.withUsername("juana").password("{noop}carrotablet").roles("USER_CARRITO_TABLET").build();
        return new InMemoryUserDetailsManager(admin,carritopc,carritotablet);
    }
}
