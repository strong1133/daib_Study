package com.example.jquery_jsp.service;

import com.example.jquery_jsp.domain.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ObjPrac {
    public static void main(String[] args) {
        Person person1 = new Person("홍슬기", "26");
        Person person2 = new Person("정석진", "26");

        List<Map<String, Object>> objList = new ArrayList<>();
        List<Map<String, Object>> persons= new ArrayList<>();
        objList.add("persons", persons);
        Map<String, Object> objectMap = new HashMap<>();
        Map<String, Object> objectMap2 = new HashMap<>();

        objectMap.put("per", person1);
        objectMap2.put("per", person2);

        System.out.println(objectMap);
        objList.add(objectMap);
        objList.add(objectMap2);
        System.out.println(objList.toString());
    }

}
