package br.com.iarts.jobsearch.users.service;

import br.com.iarts.jobsearch.users.entity.User;

public interface UserService {
     User getLoggedUserInfo();
     String signUpUser(User user);
     Boolean existsUserByEmail(String name);
     User findUserByEmail(String name);
}
