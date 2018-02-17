package br.com.iarts.jobsearch.users.service;

import br.com.iarts.jobsearch.users.entity.User;

public interface UserService {
     User getLoggedUserInfo();
     String signUpUser(User user);
     Boolean existsUserByName(String name);
     User findUserByName(String name);
}
