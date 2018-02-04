package br.com.iarts.jobsearch.users.service;

import br.com.iarts.jobsearch.users.entity.ApplicationUser;

public interface UserService {
     ApplicationUser getLoggedUserInfo();
     String signUpUser(ApplicationUser user);
}
