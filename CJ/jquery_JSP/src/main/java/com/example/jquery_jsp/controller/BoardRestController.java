package com.example.jquery_jsp.controller;

import com.example.jquery_jsp.domain.Board;
import com.example.jquery_jsp.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
