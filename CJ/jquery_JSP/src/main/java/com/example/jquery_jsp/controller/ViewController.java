package com.example.jquery_jsp.controller;

import com.example.jquery_jsp.domain.Board;
import com.example.jquery_jsp.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ViewController {

    private final BoardService boardService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHome(Model model){
        List<Board> boardList = boardService.getBoards();
        model.addAttribute("boardList", boardList);
        return "index";
    }

    @RequestMapping(value = "/uploader", method = RequestMethod.GET)
    public String getUploader(){
        return "uploader";
    }


}
