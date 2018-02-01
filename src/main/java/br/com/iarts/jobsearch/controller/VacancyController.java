package br.com.iarts.jobsearch.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;

import br.com.iarts.jobsearch.entity.Vacancy;
import br.com.iarts.jobsearch.repository.VacancyRepository;

public class VacancyController {

	private VacancyRepository repository;
	
    public VacancyController(VacancyRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping("/vacancy")
    public Collection<Vacancy> vacancies() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }
}
