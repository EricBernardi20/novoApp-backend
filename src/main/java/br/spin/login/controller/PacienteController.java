package br.spin.login.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.spin.login.modelos.PacienteModel;
import br.spin.login.repository.PacienteRepository;

@RestController
@RequestMapping("paciente")
public class PacienteController {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@GetMapping("/listar")
	public List<PacienteModel> listarPacientes(){
		List<PacienteModel> lista = pacienteRepository.findAll();
		return lista;
	}
	
	@PostMapping("/adicionar")
	public PacienteModel adicionarPaciente(@RequestBody PacienteModel adicionarPaciente) {
		pacienteRepository.save(adicionarPaciente);
		return adicionarPaciente;
	}
	
	@PutMapping("/alterar")
	public PacienteModel alterarPaciente(@RequestBody PacienteModel salvarPaciente) {

		Optional<PacienteModel> pacienteExistente = pacienteRepository.findById(salvarPaciente.getId());
		if(!pacienteExistente.isPresent()) {
			return null;
		}
		PacienteModel pacienteAlterado = pacienteRepository.save(salvarPaciente);
		return pacienteAlterado;
	}
	
	@DeleteMapping("/apagar")
	public PacienteModel deletarPaciente (@RequestBody PacienteModel deletarPaciente) {
		pacienteRepository.deleteById(deletarPaciente.getId());
		return deletarPaciente;
	}
}
