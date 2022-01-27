package cat.academy.it.S52_F2_2.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.*;


//  L'anotació @EnableWebSecurity diu a Spring que aplique la configuració de seguretat web declarada per la classe.
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Value("${auth0.audience}") 	
	 private  String audience;
	
	@Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
	  private String issuer;
	
	@Override
	  protected void configure(HttpSecurity http) throws Exception {
		// HttpSecurity és una classe builder que ofereix nombrosos mètodes de conveniència que es poden encadenar. 
		//cada mètode afegeix un filtre pel qual ha de passar la sol·licitud HTTP.
	    http.authorizeRequests()
	      .mvcMatchers(HttpMethod.GET, "/players/**").permitAll() // GET requests don't need auth
	      .anyRequest()
	      .authenticated()
	      .and()
	      .oauth2ResourceServer()
	      .jwt();
	  }
	
	 JwtDecoder jwtDecoder() {
		    OAuth2TokenValidator<Jwt> withAudience = new AudienceValidator(audience);
		    OAuth2TokenValidator<Jwt> withIssuer = JwtValidators.createDefaultWithIssuer(issuer);
		    OAuth2TokenValidator<Jwt> validator = new DelegatingOAuth2TokenValidator<>(withAudience, withIssuer);

		    NimbusJwtDecoder jwtDecoder = (NimbusJwtDecoder) JwtDecoders.fromOidcIssuerLocation(issuer);
		    jwtDecoder.setJwtValidator(validator);
		    return jwtDecoder;
	  }
	
	
}
