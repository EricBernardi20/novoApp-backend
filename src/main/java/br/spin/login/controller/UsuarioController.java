package br.spin.login.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.spin.login.modelos.UsuarioModel;
import br.spin.login.repository.UsuarioRepository;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping("/criar")
	public UsuarioModel criarUsuario(@RequestBody UsuarioModel criarUsuario) {
		List<UsuarioModel> userEquals = usuarioRepository.findAll();
		for (int i = 0; i < userEquals.size(); i++) {
			if (criarUsuario.getNome().equals(userEquals.get(i).getNome())) {
				return null;
			}
		}
		BCryptPasswordEncoder criptografarSenha = new BCryptPasswordEncoder();
		criarUsuario.setSenha(criptografarSenha.encode(criarUsuario.getSenha()));
		usuarioRepository.save(criarUsuario);
		return criarUsuario;
	}
}
