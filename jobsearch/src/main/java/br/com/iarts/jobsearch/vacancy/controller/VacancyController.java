package br.com.iarts.jobsearch.vacancy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iarts.jobsearch.vacancy.entity.Vacancy;
import br.com.iarts.jobsearch.vacancy.repository.VacancyRepository;
import br.com.iarts.jobsearch.vacancy.service.VacancyService;

@RestController
@RequestMapping("/vacancies")
public class VacancyController {

	private VacancyRepository repository;

	@Autowired
	private VacancyService service;
	
    public VacancyController(VacancyRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping
    public List<Vacancy> vacancies() {
        return (List<Vacancy>) repository.findAll();
    }
    
    @PostMapping(consumes = { "application/json" })
	public Vacancy save(@RequestBody Vacancy vacancy) {
		return service.save(vacancy);
    }
}
