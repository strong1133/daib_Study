package com.example.jquery_jsp.controller;


import com.example.jquery_jsp.domain.File;
import com.example.jquery_jsp.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FileRestController {

    private final FileService fileService;

    @GetMapping("/file")
    public List<File> getFile(){
        return fileService.getFiles();
    }
    //File Upload
    @PostMapping("/file")
    public String saveFile(@RequestParam("files") MultipartFile multipartFile) throws IOException, NoSuchAlgorithmException {
        return fileService.saveFile(multipartFile);
    }


}
