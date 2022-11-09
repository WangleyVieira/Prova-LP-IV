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
import br.com.provalp4.prova.repositorio.ComputadorRepositorio;

@Controller
@RequestMapping("/computador")
public class ComputadorController {
	
	@Autowired
	private ComputadorRepositorio computadorRespositorio;
	
	@GetMapping("/novo")
	public String adicionarComputador(Model model) {
		model.addAttribute("computador", new Computador());
		
		return "/publica-criar-computador";
	}
	
	//salvar os dados no BD
	@PostMapping("/salvar")
	public String salvarComputador(@Valid Computador computador, BindingResult result, 
			Model model, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			return "/publica-criar-computador";
		}
		
		computadorRespositorio.save(computador);
		attributes.addFlashAttribute("mensagem", "Cadastrado com sucesso");
		
		return "redirect:/computador/listar";
	}
	
	//listagem dos dados cadastrados
	@RequestMapping("/listar")
	public String listagemComputadores(Model model) {
		model.addAttribute("computadores", computadorRespositorio.findAll());
		return "listar-computadores";
	}
	
	
}
