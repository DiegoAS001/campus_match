package br.edu.ifsp.campus_match.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifsp.campus_match.model.Estudante;
import br.edu.ifsp.campus_match.repository.EstudanteRepo;

@Controller
@RequestMapping("/estudantes")
public class EstudanteController {

	@Autowired
	private EstudanteRepo estudanteRepo;
	
	@RequestMapping("index")
	public String index(Model model) {
		
		List<Estudante> estudantes = estudanteRepo.findAll();
		
		model.addAttribute("estudantes", estudantes);
		
		return "/pages/estudante/EstudanteIndex";
	}
	
	@RequestMapping("new")
	public String newEstudante(Model model) {
		
		model.addAttribute("estudante", new Estudante());
		
		return "/pages/estudante/EstudanteNew";
	}
	
	@PostMapping("save")
	public String saveEstudante(@ModelAttribute Estudante estudante) {
		
		estudanteRepo.save(estudante);
		
		return "redirect:index";
	}
	
	@RequestMapping("editEstudante/{id}")
	public String editEstudante(@PathVariable("id") Estudante estudante, Model model) {
		
		model.addAttribute(estudante);
		
		return "/pages/estudante/EstudanteNew";
	}
	
	@RequestMapping("deleteEstudante/{id}")
	public String deleteEstudante(@PathVariable("id") Long id) {
		
		estudanteRepo.deleteById(id);
		
		return "redirect:/estudantes/index";
	}
}
