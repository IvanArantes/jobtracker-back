package br.com.iarts.jobsearch.entity;

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
	private String empresa;
	
	private String descricao;
	
	
}
