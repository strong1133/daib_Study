package com.example.jquery_jsp.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class Person {
    String name;
    String age;
    public Person(String name, String  age  ){
        this.name = name;
        this.age = age;
    }
}
