package br.com.provalp4.prova.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Fornecedor {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 3, message = "deve ter no mínimo 3 caracteres")
	private String cnpj;
	
	@NotNull
	@Size(min = 3, message = "deve ter no mínimo 3 caracteres")
	private String nome;
	
	@NotNull
	@Size(min = 3, message = "deve ter no mínimo 3 caracteres")
	private String cidade;
	
	@NotNull
	@Size(min = 3, message = "deve ter no mínimo 3 caracteres")
	private String estado;
	

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "computador_id")
	private Computador computador;
	

	public Computador getComputador() {
		return computador;
	}

	public void setComputador(Computador computador) {
		this.computador = computador;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
