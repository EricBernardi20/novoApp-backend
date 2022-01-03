package br.spin.login.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import br.spin.login.modelos.UsuarioModel;
import br.spin.login.repository.UsuarioRepository;


@Primary
@Component
public class CustomAuthenticationProvider implements AuthenticationManager {

    @Autowired
    private UsuarioRepository repositoryUsuario; 
    
    
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getPrincipal().toString();
		String password = authentication.getCredentials().toString();

		Authentication usuario = this.fazerLogin(username, password);
		if (usuario == null) {
			throw new BadCredentialsException("Bad credentials");
		}

		((AbstractAuthenticationToken) usuario).setDetails(authentication.getDetails());

		return usuario;
	}

	private Authentication fazerLogin(String username, String password) {
		List<UsuarioModel> listaTeste = repositoryUsuario.findAll();
		for (int i = 0; i <= listaTeste.size(); i++) {
			List<UsuarioModel> lista = listaTeste;
			String usuario = lista.get(i).getNome();
			String senha = lista.get(i).getSenha();
			if (username.equals(usuario) && password.equals(senha)) {
				UserDetailsCustom userDetailsCustom = new UserDetailsCustom(username, password);
				return new UsernamePasswordAuthenticationToken(userDetailsCustom, null, null);
			}
		}
		return null;
	}

}
