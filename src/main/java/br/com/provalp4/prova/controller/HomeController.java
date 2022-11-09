package br.com.provalp4.prova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("msnBemVindoSite", "Seja Bem-Vindo ao Site de Computadores");
		return "redirect:/computador/listar";
	}
	
	
}
