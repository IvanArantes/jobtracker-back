package br.com.iarts.jobsearch.users.repository;

import br.com.iarts.jobsearch.users.entity.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationUserRepository extends CrudRepository<ApplicationUser, Long>{
    ApplicationUser findByUsername(String username);
}
