package com.example.parserstructuregraphaop.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class AC {

    @Autowired
    private BD BD;

    public void test(String[] args) {

        BD.bd1(args);

        BD.bd3();


    }


}
