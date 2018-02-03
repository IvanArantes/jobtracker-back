package br.com.iarts.jobsearch.users.controller;

import br.com.iarts.jobsearch.security.JWTAuthenticationFilter;
import br.com.iarts.jobsearch.security.JWTAuthorizationFilter;
import br.com.iarts.jobsearch.users.entity.ApplicationUser;
import br.com.iarts.jobsearch.users.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import static br.com.iarts.jobsearch.security.SecurityConstants.TOKEN_PREFIX;

@RestController
@RequestMapping("/auth")
public class ApplicationUserController {

    private ApplicationUserRepository repository;
    private BCryptPasswordEncoder passwordEncoder;
    private JWTAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    public ApplicationUserController(ApplicationUserRepository repository,
                                     BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/sign-up")
    public String signUp(@RequestBody ApplicationUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
        return "ok";
    }
}
