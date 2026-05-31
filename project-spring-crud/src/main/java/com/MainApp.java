package com;

import com.example.config.AppConfig;
import com.example.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainApp {
    public static void main() {
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        UserController controller=context.getBean(UserController.class);
        controller.createUser("lice");
        controller.createUser("Bob");
        controller.listUsers();
    }
}
