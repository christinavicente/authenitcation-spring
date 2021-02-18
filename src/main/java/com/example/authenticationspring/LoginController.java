package com.example.authenticationspring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    UserRepo userRepo;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(@RequestParam String username, @RequestParam String password){
        if(authenticate(username,password)){
            return "hello";
        }else{
            return "incorrect";
        }

    }

    private boolean authenticate(String username, String password){
        User userName = userRepo.FindByUsername(username);
        User userPass = userRepo.FindByPassword(password);
        boolean result=false;

        if((userName!=null)&&(userPass!=null)&&(userName.getId()==userPass.getId())){
            result=true;
        }

        return result;
    }

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
