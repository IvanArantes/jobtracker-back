package br.com.iarts.jobsearch.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Vacancy {
	
	@Id @GeneratedValue
	private Long id;
	
	@NonNull
	private String company;
	private String role;
	private String skills;
	private Integer xpTime;
	private String quality;
	private String description;
	private Date dtVacancy;
	private Date dtCreation;
	
	
}
