package br.spin.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.spin.login.modelos.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

}
