package br.com.iarts.jobsearch.vacancy.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.iarts.jobsearch.skills.entity.Skill;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "vacancy", schema = "public")
public class Vacancy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vacancy")
	private Long idVacancy;

	@NonNull
	private String company;
	private String role;
	private String level;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "vacancy_skill", joinColumns = { @JoinColumn(name = "id_vacancy") }, inverseJoinColumns = { @JoinColumn(name = "id_skill") })
	private List<Skill> skills;
	private Integer xpTime;
	private String quality;
	private String url;
	private String description;
	private Date dtVacancy;
	private Date dtCreation;

}
