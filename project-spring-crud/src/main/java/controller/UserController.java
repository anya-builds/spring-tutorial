package controller;

import org.springframework.stereotype.Controller;
import service.UserService;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;
    public void createUser(String name){
        userService.addUser(name);
        System.out.println("User added: "+name);

    }
    public void  listUsers(){
        List<String> users=userService.getAllUsers();
        System.out.println("All users: "+users);
    }
}
