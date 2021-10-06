package com.proyectotaller.app.proyectotallertodoapp.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.proyectotaller.app.proyectotallertodoapp.model.Column;
import com.proyectotaller.app.proyectotallertodoapp.service.ColumnService;

@RestController
@RequestMapping("/api")

public class ColumnController {
      
    private final Logger logger = LoggerFactory.getLogger(ColumnController.class);

    @Autowired
    ColumnService columnService;

    @GetMapping("/columns")
    public ResponseEntity<List<Column>> getAllColumns(SpringDataWebProperties.Pageable pageable) {
        logger.info("REST request to get a page of Columns");
        List<Column> allColumns = columnService.findAll();
        return ResponseEntity.ok().body(allColumns);
    }
}