package br.spin.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.spin.login.modelos.PacienteModel;
import br.spin.login.repository.PacienteRepository;

@RestController
@RequestMapping("paciente")
public class PacienteController {
	
	@Autowired
	private PacienteRepository paciente;
	
	@GetMapping("/listar")
	public List<PacienteModel> listarPacientes(){
		List<PacienteModel> lista = paciente.findAll();
		return lista;
	}
	
	@PostMapping("/adicionar")
	public PacienteModel adicionarPaciente(@RequestBody PacienteModel adicionarPaciente) {
		paciente.save(adicionarPaciente);
		return adicionarPaciente;
	}
	
	@PutMapping("/alterar")
	public PacienteModel alterarPaciente(@RequestBody PacienteModel alterarPaciente) {
		paciente.getById(alterarPaciente.getId());
		paciente.save(alterarPaciente);
		return alterarPaciente;
	}
	
	@DeleteMapping("/apagar")
	public PacienteModel deletarPaciente (@RequestBody PacienteModel deletarPaciente) {
		paciente.deleteById(deletarPaciente.getId());
		return deletarPaciente;
	}
}
