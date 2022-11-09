package br.com.provalp4.prova.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.provalp4.prova.modelo.Computador;
import br.com.provalp4.prova.modelo.Fornecedor;
import br.com.provalp4.prova.repositorio.ComputadorRepositorio;
import br.com.provalp4.prova.repositorio.FornecedorRepositorio;


@Controller
@RequestMapping("/fornecedor")
public class FornecedorController {
	
	@Autowired
	private ComputadorRepositorio computadorRepositorio;
	
	@Autowired
	private FornecedorRepositorio fornecedorRepositorio;
	
	@PostMapping("/salvar/{id}")
	public String salvarFornecedor(@Valid Fornecedor fornecedor, BindingResult result, Model model,
			@PathVariable("id") long idFornecedor) {
		Optional<Computador> computadorReserva = computadorRepositorio.findById(idFornecedor);
		Computador computador = computadorReserva.get();
		if (result.hasErrors()) {
			fornecedor.setComputador(computador);
			return "/publica-criar-fornecedor";
		}

		fornecedor.setComputador(computador);
		fornecedorRepositorio.save(fornecedor);
		
		return "redirect:/computador/listar";
	}
	
	@GetMapping("/editarFornecedor/{id}")
	public String editarEndereco(@PathVariable("id") long id, Model model) {
		
		Optional<Computador> computadorAntigo = computadorRepositorio.findById(id);
		if (!computadorAntigo.isPresent()) {
            throw new IllegalArgumentException("Computador informado invalido:" + id);
        } 
		Computador computador = computadorAntigo.get();
		Fornecedor fornecedor = null;
		String urlPrincipal = "";
		if (computador.getFornecedor() == null) {
			fornecedor = new Fornecedor();
			fornecedor.setComputador(computador);
			urlPrincipal = "/publica-criar-fornecedor";
		} else {
			fornecedor = computador.getFornecedor();
			urlPrincipal = "/publica-criar-fornecedor";
		}
		
				
		model.addAttribute("fornecedor", fornecedor);
	    return urlPrincipal;
	    
	}
	
	@RequestMapping("/listar")
	public String listagemFornecedores(Model model) {
		model.addAttribute("fornecedores", fornecedorRepositorio.findAll());
		return "listar-computadores";
	}

}
