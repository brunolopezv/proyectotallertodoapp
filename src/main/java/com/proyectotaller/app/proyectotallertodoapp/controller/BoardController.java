package com.proyectotaller.app.proyectotallertodoapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import com.proyectotaller.app.proyectotallertodoapp.model.Board;
import com.proyectotaller.app.proyectotallertodoapp.service.BoardService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
public class BoardController {
    private final Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    BoardService boardService;

    @GetMapping("/boards")
    public ResponseEntity<List<Board>> getAllBoards(SpringDataWebProperties.Pageable pageable) {
        logger.info("REST request to get a page of Boards");
        List<Board> allBoards = boardService.findAll();
        return ResponseEntity.ok().body(allBoards);
    }
}
