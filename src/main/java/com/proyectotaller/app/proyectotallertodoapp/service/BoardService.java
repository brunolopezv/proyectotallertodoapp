package com.proyectotaller.app.proyectotallertodoapp.service;

import org.springframework.stereotype.Service;

import java.util.List;

import com.proyectotaller.app.proyectotallertodoapp.model.Board;
import com.proyectotaller.app.proyectotallertodoapp.repository.BoardRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BoardService {
   
    private final Logger logger = LoggerFactory.getLogger(BoardService.class);

    @Autowired
    private BoardRepository boardRepository;

    public Board save(Board newBoard) {
        return boardRepository.save(newBoard);
    }

    // public Board update(Long id,String titulo) {
    //     return boardRepository.update(id,titulo);
    // }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public Board findById(Long id) {
        return boardRepository.findById(id);
    }

}