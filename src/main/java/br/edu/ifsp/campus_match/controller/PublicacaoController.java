package br.edu.ifsp.campus_match.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifsp.campus_match.model.Publicacao;
import br.edu.ifsp.campus_match.repository.PublicacaoRepo;

@Controller
@RequestMapping("/publicacoes")
public class PublicacaoController {
	
	@Autowired
	private PublicacaoRepo PublicacaoRepo; 
	
	@RequestMapping("index")
	public String index(Model model) {
		
		List<Publicacao> publicacoes = PublicacaoRepo.findAll();
		
		model.addAttribute("publicacoes", publicacoes);
		
		return "/pages/publicacao/PublicacaoIndex";
	}
	
	@RequestMapping("new")
	public String newPublicacao(Model model) {
		
		model.addAttribute("publicacao", new Publicacao());
		
		return "/pages/publicacao/PublicacaoNew";
	}
	
	@PostMapping("save")
	public String savePublicacao(@ModelAttribute Publicacao publicacao) {
		
		PublicacaoRepo.save(publicacao);
		
		return "redirect:index";
	}
	
	@RequestMapping("editPublicacao/{id}")
	public String editPublicacao(@PathVariable("id") Publicacao publicacao, Model model) {
		
		model.addAttribute(publicacao);
		
		return "/pages/publicacao/PublicacaoNew";
	}
	

	@RequestMapping("deletePublicacao/{id}")
	public String deletePublicacao(@PathVariable("id") Long id) {
		
		PublicacaoRepo.deleteById(id);
		
		return "redirect:/publicacoes/index";
	}
}
