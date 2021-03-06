package br.spin.login.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

@Primary
@Component
public class CustomTokenEnhancer extends JwtAccessTokenConverter {
	
	@Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken,
                                     OAuth2Authentication authentication) {
        if (authentication.getOAuth2Request().getGrantType().equalsIgnoreCase("password")) {
            final Map<String, Object> additionalInfo = new HashMap();
            UserDetailsCustom userDetailsCustom = (UserDetailsCustom) authentication.getUserAuthentication().getPrincipal();
            additionalInfo.put("username", userDetailsCustom.getUsername());
            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        }
        return accessToken;
    }

}
