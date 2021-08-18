package com.example.jquery_jsp.controller;

import com.example.jquery_jsp.domain.Board;
import com.example.jquery_jsp.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.lang.reflect.Parameter;
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

    @PostMapping("/form")
    public String formData (MultipartHttpServletRequest formData){
        System.out.println(formData.getParameter("name"));
        System.out.println(formData.getParameter("cpt"));
        return "작성완료";
    }
}
