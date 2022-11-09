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
public class Computador {
	//geracao de ID de forma automatica
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 3, message = "deve ter no mínimo 3 caracteres")
	private String placaVideo;
	
	@NotNull
	@Size(min = 3, message = "deve ter no mínimo 3 caracteres")
	
	private String modeloCpu;
	@NotNull
	@Size(min = 3, message = "deve ter no mínimo 3 caracteres")
	private String modeloGabinete;
	
	@NotNull
	@Size(min = 3, message = "deve ter no mínimo 3 caracteres")
	private String modeloMemoriaRam;
	
	@NotNull
	private int qtdPecas;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "computador", fetch = FetchType.EAGER)
	
	@Valid
	private Fornecedor fornecedor;
	
	
	
	//Métodos acessores GET e Set
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getPlacaVideo() {
		return placaVideo;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPlacaVideo(String placaVideo) {
		this.placaVideo = placaVideo;
	}
	
	public String getModeloCpu() {
		return modeloCpu;
	}
	
	public void setModeloCpu(String modeloCpu) {
		this.modeloCpu = modeloCpu;
	}
	
	public String getModeloGabinete() {
		return modeloGabinete;
	}
	
	public void setModeloGabinete(String modeloGabinete) {
		this.modeloGabinete = modeloGabinete;
	}
	
	public String getModeloMemoriaRam() {
		return modeloMemoriaRam;
	}
	
	public void setModeloMemoriaRam(String modeloMemoriaRam) {
		this.modeloMemoriaRam = modeloMemoriaRam;
	}

	public int getQtdPecas() {
		return qtdPecas;
	}
	
	public void setQtdPecas(int qtdPecas) {
		this.qtdPecas = qtdPecas;
	}
	

}
