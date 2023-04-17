package br.edu.ifms.ConsoleTLP.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifms.ConsoleTLP.modelo.Console;
import jakarta.validation.Valid;
import br.edu.ifms.ConsoleTLP.repository.ConsoleRepository;


@Controller
@RequestMapping("/console")
public class ConsoleController {
	@Autowired
	private ConsoleRepository cp;
	
		@GetMapping("/new")
		public String addConsole(Model model) {
			model.addAttribute("console", new Console());
			return "/cadastrar-console";
		}
		
		@PostMapping("/save")
		public String consoleSave(@Valid Console console, BindingResult result, 
					Model model, RedirectAttributes attributes) {
			if (result.hasErrors()) {
				return "/cadastrar-console";
			}	
					
			cp.save(console);
			attributes.addFlashAttribute("confirma", "Console cadastrado com sucesso!");
			return "redirect:/console/new";
		}
		
		@RequestMapping("/admin/list")
		public String consoleList(Model model) {
			model.addAttribute("consoles", cp.findAll());		
			return "/auth/admin/adm-list";		
		}
		
}
