package br.com.iarts.jobsearch.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.iarts.jobsearch.entity.Vacancy;

import org.springframework.data.jpa.repository.JpaRepository;

@RepositoryRestResource
public interface VacancyRepository extends JpaRepository<Vacancy, Long>{

}
