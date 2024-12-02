package br.edu.ifsp.campus_match.repository;

import br.edu.ifsp.campus_match.model.Favorito;
import br.edu.ifsp.campus_match.model.FavoritoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritoRepo extends JpaRepository<Favorito, FavoritoId> {}
