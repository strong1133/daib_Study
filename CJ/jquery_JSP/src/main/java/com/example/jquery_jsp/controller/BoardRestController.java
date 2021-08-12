package com.example.jquery_jsp.controller;

import com.example.jquery_jsp.domain.Board;
import com.example.jquery_jsp.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardRestController {

    private final BoardService boardService;

    @GetMapping("/board")
    public List<Board> getBoards (){
        return boardService.getBoards();
    }

    //Create
    @PostMapping("/board")
    public String createBoard (@RequestBody Board board){
        boardService.createBoard(board);
        return "작성완료";
    }

    //File Upload
    @PostMapping("/fupload")
    public String fileUploader(@RequestParam("files") MultipartFile multipartFile){
        System.out.println("--------------------");
        System.out.println(multipartFile.getOriginalFilename());
        return "연결 성공";
    }
}
