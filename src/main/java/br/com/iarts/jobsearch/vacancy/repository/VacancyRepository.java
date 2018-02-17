package br.com.iarts.jobsearch.vacancy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.iarts.jobsearch.vacancy.entity.Vacancy;

@Repository
public interface VacancyRepository extends CrudRepository<Vacancy, Long> {
}
