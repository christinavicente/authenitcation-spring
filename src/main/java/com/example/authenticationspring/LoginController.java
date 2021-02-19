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

    @RequestMapping(value = "/incorrect", method = RequestMethod.GET)
    public String noUser(){

        return"incorrect";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String welcome(){

        return"hello";
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


}
