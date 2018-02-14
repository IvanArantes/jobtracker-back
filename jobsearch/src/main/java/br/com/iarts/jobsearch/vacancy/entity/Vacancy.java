package br.com.iarts.jobsearch.vacancy.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.iarts.jobsearch.skills.entity.Skill;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Vacancy {

	@Id
	@GeneratedValue
	private Long id;

	@NonNull
	private String company;
	private String role;
	private String level;

	@OneToMany
	private List<Skill> skills;
	private Integer xpTime;
	private String quality;
	private String url;
	private String description;
	private Date dtVacancy;
	private Date dtCreation;

}
