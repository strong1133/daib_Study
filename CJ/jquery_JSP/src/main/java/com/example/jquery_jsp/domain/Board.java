package com.example.jquery_jsp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Board extends TimeStamped {

    private Long id;
    private String title;
    private String content;
    private boolean completed;

}
