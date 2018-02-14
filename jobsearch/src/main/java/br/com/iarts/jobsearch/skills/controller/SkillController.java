package br.com.iarts.jobsearch.skills.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iarts.jobsearch.skills.entity.Skill;
import br.com.iarts.jobsearch.skills.repository.SkillRepository;

@RestController
@RequestMapping("/skills")
public class SkillController {

	@Autowired
	private SkillRepository skillRepository;

	@GetMapping
	public List<Skill> getAll() {
		return (List<Skill>) skillRepository.findAll();
	}
}
