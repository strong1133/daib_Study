package com.study.jspexcel.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class File extends TimeStamped {
    Long id;
    String origFileName;
    String fileName;
    String filePath;
}
