package br.edu.ifsp.campus_match.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.ifsp.campus_match.model.Student;
import br.edu.ifsp.campus_match.repository.StudentRepo;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentRepo repo;
	
	@RequestMapping("index")
	public String index(Model model) {
		
		List<Student> students = repo.findAll();
		
		model.addAttribute("students", students);
		
		return "StudentIndex";
	}
	
	@RequestMapping("new")
	public String newStudent(Model model) {
		
		model.addAttribute("student", new Student());
		
		return "StudentNew";
	}
	
	@PostMapping("save")
	public String saveStudent(@ModelAttribute Student student) {
		
		repo.save(student);
		
		return "redirect:index";
	}
	
	@RequestMapping("editStudent/{id}")
	public String editStudent(@PathVariable("id") Student student, Model model) {
		
		model.addAttribute(student);
		
		return "StudentNew";
	}
	
	@RequestMapping("deleteStudent/{id}")
	public String deleteStudent(@PathVariable("id") Long id) {
		
		repo.deleteById(id);
		
		return "redirect:/students/index";
	}
}
