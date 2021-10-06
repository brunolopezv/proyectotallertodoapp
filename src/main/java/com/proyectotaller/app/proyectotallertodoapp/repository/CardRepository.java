package com.proyectotaller.app.proyectotallertodoapp.repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ch.qos.logback.classic.spi.CallerData;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.proyectotaller.app.proyectotallertodoapp.model.Card;
import com.proyectotaller.app.proyectotallertodoapp.model.User;

@Repository
public class CardRepository {
    
    private final Logger logger = LoggerFactory.getLogger(CardRepository.class);
    Random random = new Random();
    List<Card> dbMock = new ArrayList<>();

    public CardRepository() {
        loadMockedCardList();
    }
     
    /* Este metodo simula guardar un objeto en la BD
     * en este caso lo estamos agregando a una lista en memoria
     * y simulando que se le asigna un id de bd.
     * @param newCard
     */
    public Card save(Card newCard) {
        newCard.setId(random.nextLong());
        logger.info("Saving card with id: {}", newCard.getId());
        dbMock.add(newCard);
        return newCard;
    }

    /* Este metodo simula actualizar un objeto en la BD
     * ¿Cómo actuariamos si no se encuentra en la lista?
     */
    public Card update(Card card,String titulo,User propietario,String descripcion,Date fecha){
        /*Implementar lógica que me permita tomar la lista de tarjetas dbMock y actualizar la que corresponda en base a su id.
        Una vez encontrada, deberia retornar la tarjeta actualizada*/
       String updateado;
    
       updateado="no";
        while(updateado=="si"){
         for (Card carta : dbMock){
           if(carta.getId()==card.getId()){
            card.setTitulo("NuevoTitulo");
            // Aca entrarian los nuevos datos ingresados,como por ejemplo:
            card.setFecha(fecha);
            card.setDescripcion(descripcion);
            card.setPropietario(propietario);
            // card.setResponsables(responsables);
            System.out.println("Carta de id " + "id" + ",cambio de titulo: " + "titulo");
            updateado="si";
            return card;
            }else{
                updateado="no";
            } 
        }
        }
        return null;
    }

    public List<Card> findAll() {
        return dbMock;
    }

    /* Este metodo debe filtrar la lista y obtener la tarjeta correspondiente
     * ¿Como actuariamos si no se encuentra en la lista?
     */
    public Card findById(Long id) {
        //deberia retornar la tarjeta que se busca
        Card tarjetabuscada;
         for (Card card : dbMock){
           if(card.getId()==id){
            tarjetabuscada=card;
            return tarjetabuscada;
            }
        }
        System.out.println("No se encontro la tarjeta");     
        return null;
    }
    // private Long id;
    // private String titulo;
    // private String descripcion;
    // private Date fecha;
    // private List<User> responsables;
    // private User propietario;

    public void delete(Long id,String titulo,User propietario,String descripcion,Date fecha){
        for(Card card : dbMock){
            if(card.getId()==id & card.getTitulo()==titulo){
                dbMock.remove(card);
                break;
            }
        }
        System.out.println("No se encontro el card");
    }

    
    /* Este metodo simula traer información de una BD y crea
     * aleatoriamente una lista con 20 objetos.
     */
    private void loadMockedCardList() {
        for (int i = 0; i < 20; i++) {
            dbMock.add(new Card(random.nextLong(),"Titulo Hola","Soy la descripcion",null,null,null));
        }
    }

    
}
