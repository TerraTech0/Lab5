package com.example.lab5.Students.Model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Students {
    private String name;
    private int age;
    private String degree;
    private boolean status;
//    private String[] students;
}
