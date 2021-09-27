package com.study.jspexcel.controller;

import com.study.jspexcel.domain.File;
import com.study.jspexcel.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
