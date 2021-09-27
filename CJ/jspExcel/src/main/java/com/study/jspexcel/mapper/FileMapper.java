package com.study.jspexcel.mapper;


import com.study.jspexcel.domain.File;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileMapper {

    List<File> getAll();
    void createFile(File file);

}
