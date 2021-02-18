package com.example.authenticationspring;


import org.springframework.stereotype.Controller;

@Controller
public class LoginController {





    public void savedUsers() {
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();
        User user5 = new User();
        user1.setUsername("username");
        user1.setPassword("password");
        user2.setUsername("hello");
        user2.setPassword("hello");
        user3.setUsername("simplilearn");
        user3.setPassword("hello");
        user4.setUsername("david");
        user4.setPassword("smith");
        user5.setUsername("lisa");
        user5.setPassword("frank");


        //return new InMemoryUserDetailsManager(user);
    }
}
