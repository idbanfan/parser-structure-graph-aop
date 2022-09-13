package com.example.parserstructuregraphaop.utils;

import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class BD {

    private int count = 0;

    public void bd1(String[] args) {
        bd2();
        bd2();
        bd3();
        bd4();
    }

    public void bd2() {
        bd3();
    }

    public void bd3() {
        bd4();
    }

    public void bd4() {

    }
}
