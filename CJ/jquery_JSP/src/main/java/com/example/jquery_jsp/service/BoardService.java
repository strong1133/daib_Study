package com.example.jquery_jsp.service;

import com.example.jquery_jsp.domain.Board;
import com.example.jquery_jsp.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;

    // getAll
    public List<Board> getBoards(){
        return boardMapper.getAll();
    }

    // Create
    @Transactional
    public void createBoard (Board saveBoard){
        boardMapper.createBoard(saveBoard);
    }
}
