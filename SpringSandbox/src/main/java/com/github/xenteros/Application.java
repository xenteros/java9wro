package com.github.xenteros;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);


//        System.out.println("--------------");
//        for (String s : ctx.getBeanDefinitionNames()) {
//            System.out.println(s);
//        }
//        System.out.println("--------------");


    }
}
