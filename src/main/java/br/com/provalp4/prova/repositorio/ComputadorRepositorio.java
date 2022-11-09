package br.com.provalp4.prova.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.provalp4.prova.modelo.Computador;

public interface ComputadorRepositorio extends JpaRepository<Computador, Long> {
	
}
