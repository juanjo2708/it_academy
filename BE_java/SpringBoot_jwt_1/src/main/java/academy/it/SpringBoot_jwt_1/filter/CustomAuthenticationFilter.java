package academy.it.SpringBoot_jwt_1.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;


    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    // Autenticació
    // Crida al gestor d'autenticació passant les credencials de l'usuari
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        // Obtenim user i password i els mostrem via log
        String username =request.getParameter("username");
        String password =request.getParameter("password");
        log.info("username is {}", username);
        log.info("password is {}", password);

        //Creem un objecte token d'autenticació de contrasenya de nom d'usuari.
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        // Retornem el testimoni d'autenticació
        return authenticationManager.authenticate(authenticationToken);


    }

    //Autorització
    // mètode que s'executa si ha tingut èxit l'autenticació.
    //Enviar el testimoni d'accés i d'actualització quan l'inici de sessió sigui exitòs
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
    }
}
