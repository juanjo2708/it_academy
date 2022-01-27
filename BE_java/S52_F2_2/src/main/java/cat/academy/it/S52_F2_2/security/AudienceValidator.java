package cat.academy.it.S52_F2_2.security;

import java.util.List;

import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2ErrorCodes;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.util.Assert;



public class AudienceValidator implements OAuth2TokenValidator<Jwt> {
	 
	 private final String audience;
	 
	  AudienceValidator(String audience) {
		    Assert.hasText(audience, "audience is null or empty");
		    this.audience = audience;
		  }

	 /**
	  * La interfície OAuth2TokenValidator i el seu mètode de validació 
	  * proporcionen mitjans per verificar els atributs personalitzats del testimoni OAuth 2.0.   
	  */
	@Override
	public OAuth2TokenValidatorResult validate(Jwt jwt) {
		
	  List<String> audiences = jwt.getAudience();
		
	    if (audiences.contains(this.audience)) {
	      return OAuth2TokenValidatorResult.success();
	    }
	    
	    OAuth2Error err = new OAuth2Error(OAuth2ErrorCodes.INVALID_TOKEN);
	    return OAuth2TokenValidatorResult.failure(err);
	}	

}
