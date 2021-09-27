package com.study.jspexcel.service;

import com.study.jspexcel.domain.File;
import com.study.jspexcel.mapper.FileMapper;
import com.study.jspexcel.utils.MD5Generator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileService {

    private final FileMapper fileMapper;

    public List<File> getFiles(){
        return  fileMapper.getAll();
    }

    public String saveFile(MultipartFile multipartFile) throws IOException, NoSuchAlgorithmException {
        String origFileName = multipartFile.getOriginalFilename();
        String fileName = new MD5Generator(origFileName).toString();

        String savePath = System.getProperty("user.dir") + "\\files";
        /* 파일이 저장되는 폴더가 없으면 폴더를 생성합니다. */
        if (!new java.io.File(savePath).exists()) {
            try{
                new java.io.File(savePath).mkdir();
            }
            catch(Exception e){
                e.getStackTrace();
            }
        }

        multipartFile.transferTo(new java.io.File(savePath, fileName));
        String filePath = savePath+"/"+fileName;

        File file = new File();
        file.setOrigFileName(origFileName);
        file.setFilePath(filePath);
        file.setFileName(fileName);

        fileMapper.createFile(file);

        return "작성완료";

    }
}
