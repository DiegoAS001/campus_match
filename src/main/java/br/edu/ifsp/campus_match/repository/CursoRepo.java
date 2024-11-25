package br.edu.ifsp.campus_match.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.campus_match.model.Curso;

public interface CursoRepo extends JpaRepository<Curso, Long>{

}
