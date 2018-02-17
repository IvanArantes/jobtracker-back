package br.com.iarts.jobsearch.vacancy.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.iarts.jobsearch.vacancy.entity.Vacancy;
import br.com.iarts.jobsearch.vacancy.repository.VacancyRepository;

@Service
public class VacancyService {

	@Autowired
	private VacancyRepository vacancyRepository;

	public Vacancy save(Vacancy vacancy) {
		vacancy.setDtCreation(new Date());
		return vacancyRepository.save(vacancy);
	}

}
