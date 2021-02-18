package com.example.authenticationspring;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
        User FindByUsername(String username);
        User FindByPassword(String password);

}
