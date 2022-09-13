package me.banfan.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Link {
    private String from;
    private String to;
    private String text;
    private int time;
}
