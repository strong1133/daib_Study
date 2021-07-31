package com.example.jquery_jsp.mapper;

import com.example.jquery_jsp.domain.Board;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardMapper {

    List<Board> getAll();
    void createBoard(Board board);

}
