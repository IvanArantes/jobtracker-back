package br.com.iarts.jobsearch.users.repository;

import br.com.iarts.jobsearch.users.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationUserRepository extends CrudRepository<User, Long>{
    User findByEmail(String username);
}
