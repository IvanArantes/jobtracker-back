package br.com.iarts.jobsearch.controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iarts.jobsearch.entity.Vacancy;
import br.com.iarts.jobsearch.repository.VacancyRepository;

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
    public Vacancy save(Vacancy vacancy) {
    	return repository.save(vacancy);
    }
}
