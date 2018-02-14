package br.com.iarts.jobsearch.skills.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.iarts.jobsearch.skills.entity.Skill;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Long> {

	Skill findSkillBySkillName(String skillName);
}
