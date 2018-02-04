package br.com.iarts.jobsearch;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.iarts.jobsearch.entity.Vacancy;
import br.com.iarts.jobsearch.repository.VacancyRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class JobsearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobsearchApplication.class, args);
	}
	
    @Bean
    ApplicationRunner init(VacancyRepository repository) {
        return args -> {
            Stream.of("Desenvolvedor Java", "Desenvolvedor Big Data").forEach(descricao -> {
                Vacancy vacancy = new Vacancy();
                vacancy.setDescription(descricao);
                repository.save(vacancy);
            });
            repository.findAll().forEach(System.out::println);
        };
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
