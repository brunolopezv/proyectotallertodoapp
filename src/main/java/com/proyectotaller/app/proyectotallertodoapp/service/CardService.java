package com.proyectotaller.app.proyectotallertodoapp.service;

import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

import com.proyectotaller.app.proyectotallertodoapp.model.Card;
import com.proyectotaller.app.proyectotallertodoapp.model.User;
import com.proyectotaller.app.proyectotallertodoapp.repository.CardRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CardService {
   
    private final Logger logger = LoggerFactory.getLogger(CardService.class);

    @Autowired
    private CardRepository cardRepository;

    public Card save(Card newCard) {
        return cardRepository.save(newCard);
    }
   
    public Card update(Card card,String titulo,User propietario,String descripcion,Date fecha) {
        return cardRepository.update(card,titulo,propietario,descripcion,fecha);
    }

    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    public Card findById(Long id) {
        return cardRepository.findById(id);
    }

}
