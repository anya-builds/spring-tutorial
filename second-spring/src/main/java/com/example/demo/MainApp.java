package com.example.demo;

import com.example.loose.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        GreetingService greetingService =
                context.getBean("myBean", GreetingService.class);
        greetingService.sayHello();

//        UserService userServiceSMS =
//                context.getBean("userServiceSMS", UserService.class);
//        userServiceSMS.notifyUser("Whats up!");
//
//        UserService userServiceEmail =
//                context.getBean("userServiceEmail", UserService.class);
//        userServiceEmail.notifyUser("Whats up!");
    }
}