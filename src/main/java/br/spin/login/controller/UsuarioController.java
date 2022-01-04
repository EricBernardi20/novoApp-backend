package br.spin.login.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.spin.login.modelos.PacienteModel;
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
		usuarioRepository.save(criarUsuario);
		return criarUsuario;
	}

	@PutMapping("/alterarsenha")
	public UsuarioModel alterarSenha(@RequestBody UsuarioModel alterarSenha) {
		Optional<UsuarioModel> userExistingById = usuarioRepository.findById(alterarSenha.getId());
		if (!userExistingById.isPresent()) {
			return null;
		} else {
			List<UsuarioModel> userExisting = usuarioRepository.findAll();
			for (int i = 0; i < userExisting.size(); i++) {
				if (alterarSenha.getSenha().equals(userExisting.get(i).getSenha()) &
						!alterarSenha.getNome().equals(userExisting.get(i).getNome())) {
					return null;
				}
			}

			alterarSenha.setNome(alterarSenha.getNome());
		}
		usuarioRepository.save(alterarSenha);
		return alterarSenha;

	}
}
