package br.com.iarts.jobsearch.skills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.iarts.jobsearch.skills.repository.SkillRepository;

@Service
public class SkillService {

	@Autowired
	private SkillRepository repository;
}
