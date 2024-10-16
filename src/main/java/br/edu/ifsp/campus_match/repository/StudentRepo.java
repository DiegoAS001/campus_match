package br.edu.ifsp.campus_match.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.campus_match.model.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

}
