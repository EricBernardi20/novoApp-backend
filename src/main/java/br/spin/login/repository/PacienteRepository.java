package br.spin.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.spin.login.modelos.PacienteModel;

public interface PacienteRepository extends JpaRepository<PacienteModel, Integer> {

}
