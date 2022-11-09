package br.com.provalp4.prova.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.provalp4.prova.modelo.Fornecedor;

public interface FornecedorRepositorio extends JpaRepository<Fornecedor, Long> {

}
