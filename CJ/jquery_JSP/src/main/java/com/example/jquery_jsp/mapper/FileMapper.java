package com.example.jquery_jsp.mapper;

import com.example.jquery_jsp.domain.Board;
import com.example.jquery_jsp.domain.File;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileMapper {

    List<File> getAll();
    void createFile(File file);

}
