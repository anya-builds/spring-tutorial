package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {

//        ApplicationContext context =
//                new AnnotationConfigApplicationContext(AppConfig.class);
//        ApplicationContext context =
//                new AnnotationConfigApplicationContext(AppConfig.class);
//        GreetingService greetingService =
//                context.getBean(GreetingService.class);
//        greetingService.sayHello();
//
//        UserService userServiceSMS =
//                context.getBean("userServiceSMS", UserService.class);
//        userServiceSMS.notifyUser("Whats up!");
//
//        UserService userServiceEmail =
//                context.getBean("userServiceEmail", UserService.class);
//        userServiceEmail.notifyUser("Whats up!");
        System.out.println("Starting spring application context");
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("Retrieving lifecycle bean");
        LifecycleBean lifeCycleBean=context.getBean(LifecycleBean.class);
        System.out.println("Closing spring context");
        lifeCycleBean.performTask();
    }

}