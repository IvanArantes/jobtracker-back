package br.com.iarts.jobsearch.vacancy.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iarts.jobsearch.vacancy.entity.Vacancy;
import br.com.iarts.jobsearch.vacancy.repository.VacancyRepository;

@RestController
@RequestMapping("/vacancies")
public class VacancyController {

	private VacancyRepository repository;
	
    public VacancyController(VacancyRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping
    public List<Vacancy> vacancies() {
        return (List<Vacancy>) repository.findAll();
    }
    
    @PostMapping(consumes = { "application/json" })
	public Vacancy save(@RequestBody Vacancy vacancy) {
    	return repository.save(vacancy);
    }
}
