package br.com.iarts.jobsearch.users.service;

import br.com.iarts.jobsearch.users.entity.ApplicationUser;
import br.com.iarts.jobsearch.users.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    ApplicationUserRepository repository;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(ApplicationUserRepository repository,
                           BCryptPasswordEncoder encoder) {
        this.repository = repository;
        this.passwordEncoder = encoder;
    }

    @Override
    public ApplicationUser getLoggedUserInfo() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ApplicationUser user =  repository.findByUsername(auth.getName());
        user.setPassword(null);
        return user;
    }

    @Override
    public String signUpUser(ApplicationUser user) {
        if(repository.findByUsername(user.getUsername())!=null){
            return "User already registered";
        }else{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            repository.save(user);
            return "Registered user";
        }
    }
}
