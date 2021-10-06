package com.proyectotaller.app.proyectotallertodoapp.service;

import org.springframework.stereotype.Service;

import java.util.List;

import com.proyectotaller.app.proyectotallertodoapp.model.Column;
import com.proyectotaller.app.proyectotallertodoapp.repository.ColumnRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ColumnService {
   
    private final Logger logger = LoggerFactory.getLogger(ColumnService.class);

    @Autowired
    private ColumnRepository columnRepository;

    public Column save(Column newColumn) {
        return columnRepository.save(newColumn);
    }

    // public Column update(Long id,String titulo) {
    //     return columnRepository.update(id,titulo);
    // }

    public List<Column> findAll() {
        return columnRepository.findAll();
    }

    public Column findById(Long id) {
        return columnRepository.findById(id);
    }

}
