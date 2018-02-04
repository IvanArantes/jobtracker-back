package br.com.iarts.jobsearch.users.controller;

import br.com.iarts.jobsearch.users.entity.ApplicationUser;
import br.com.iarts.jobsearch.users.service.UserService;
import br.com.iarts.jobsearch.users.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class ApplicationUserController {
    private UserService userService;

    @Autowired
    public ApplicationUserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    public String signUp(@RequestBody ApplicationUser user) {
       return userService.signUpUser(user);
    }

    @GetMapping("/info")
    public ApplicationUser getUserInfo(){
        return userService.getLoggedUserInfo();
    }
}
