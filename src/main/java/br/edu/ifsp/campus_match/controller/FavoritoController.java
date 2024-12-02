package br.edu.ifsp.campus_match.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifsp.campus_match.model.Favorito;
import br.edu.ifsp.campus_match.model.FavoritoId;
import br.edu.ifsp.campus_match.repository.FavoritoRepo;

@Controller
@RequestMapping("/favoritos")
public class FavoritoController {

    @Autowired
    private FavoritoRepo favoritoRepo;

    @RequestMapping("index")
    public String index(Model model) {
        model.addAttribute("favoritos", favoritoRepo.findAll());
        return "/pages/favorito/FavoritoIndex";
    }

    @PostMapping("save")
    public String saveFavorito(@ModelAttribute Favorito favorito) {
        favoritoRepo.save(favorito);
        return "redirect:index";
    }

    @RequestMapping("delete/{idEstudante}/{idInstituicao}")
    public String deleteFavorito(@PathVariable Long idEstudante, @PathVariable Long idInstituicao) {
        favoritoRepo.deleteById(new FavoritoId(idEstudante, idInstituicao));
        return "redirect:/favoritos/index";
    }
}
