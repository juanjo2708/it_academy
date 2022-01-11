package academy.it.SpringBoot_jwt_1.security;

import academy.it.SpringBoot_jwt_1.filter.CustomAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

       http.csrf().disable(); // Desactivar la falsificació de sol.licituds entre llocs.
       http.sessionManagement().sessionCreationPolicy(STATELESS);  //Política de creació de gestió de sessions http, sense estat.
       http.authorizeHttpRequests().anyRequest().permitAll(); // http autoritza qualsevol sol.licitud que ho permeti tot
       http.addFilter(new CustomAuthenticationFilter);  // Afegim un filtre (CustomAutenticationFilter) d'autenticació per poder comprovar l'usuari
    }
}
