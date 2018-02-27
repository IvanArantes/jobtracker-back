package br.com.iarts.jobsearch.users.service;

import br.com.iarts.jobsearch.users.entity.User;
import br.com.iarts.jobsearch.users.repository.ApplicationUserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private ApplicationUserRepository applicationUserRepository;

    public UserDetailsServiceImpl(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public org.springframework.security.core.userdetails.User loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = applicationUserRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), emptyList());
    }
}
