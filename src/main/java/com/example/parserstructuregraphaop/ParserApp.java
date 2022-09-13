package com.example.parserstructuregraphaop;

import com.example.parserstructuregraphaop.config.MyAspect;
import com.example.parserstructuregraphaop.utils.AC;
import me.banfan.model.ParserStack;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackageClasses = {ParserApp.class, MyAspect.class})
public class ParserApp {



    public static void main(String[] args) {
        ConfigurableApplicationContext context =  SpringApplication.run(ParserApp.class, args);


        AC bean = context.getBean(AC.class);

//        bean.test(null);
        bean.test(null);


        ParserStack strings = ParserStack.get();
        System.out.println();
    }

}
