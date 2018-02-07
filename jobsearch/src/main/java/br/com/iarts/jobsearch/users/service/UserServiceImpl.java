package br.com.iarts.jobsearch.users.service;

import br.com.iarts.jobsearch.users.entity.User;
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
    public User getLoggedUserInfo() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user =  repository.findByUsername(auth.getName());
        user.setPassword(null);
        return user;
    }

    @Override
    public String signUpUser(User user) {
        if(repository.findByUsername(user.getUsername())!=null){
            return "User already registered";
        }else{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            repository.save(user);
            return "Registered user";
        }
    }

    @Override
    public Boolean existsUserByName(String name) {
        if(this.repository.findByUsername(name)!=null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public User findUserByName(String name) {
        return repository.findByUsername(name);
    }
}
