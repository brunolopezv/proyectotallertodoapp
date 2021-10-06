package com.proyectotaller.app.proyectotallertodoapp.repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.proyectotaller.app.proyectotallertodoapp.model.Board;
import com.proyectotaller.app.proyectotallertodoapp.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ch.qos.logback.classic.spi.CallerData;

@Repository
public class BoardRepository {
    
    private final Logger logger = LoggerFactory.getLogger(BoardRepository.class);
    Random random = new Random();
    List<Board> dbMock = new ArrayList<>();

    public BoardRepository() {
        loadMockedBoardList();
    }
     
    /* Este metodo simula guardar un objeto en la BD
     * en este caso lo estamos agregando a una lista en memoria
     * y simulando que se le asigna un id de bd.
     * @param newBoard
     */
    public Board save(Board newBoard) {
        newBoard.setId(random.nextLong());
        logger.info("Saving board with id: {}", newBoard.getId());
        dbMock.add(newBoard);
        return newBoard;
    }

    /* Este metodo simula actualizar un objeto en la BD
     * ¿Cómo actuariamos si no se encuentra en la lista?
     */
    public Board update(Board board,Long id,String titulo,User propietario){
        /*Implementar lógica que me permita tomar la lista de tarjetas dbMock y actualizar la que corresponda en base a su id.
        Una vez encontrada, deberia retornar la tarjeta actualizada*/
       String updateado;
    //    private String titulo;
    //    private User propietario;
    //    private Long id;
       updateado="no";
        while(updateado=="no"){
         for (Board boardn : dbMock){
           if(boardn.getId()==board.getId()){
            board.setTitulo(titulo);
            board.setPropietario(propietario);
            updateado="si";
            return board;
            }else{
                updateado="no";
            } 
        }
        }
        return null;
    }

    public List<Board> findAll() {
        return dbMock;
    }

    /* Este metodo debe filtrar la lista y obtener la tarjeta correspondiente
     * ¿Como actuariamos si no se encuentra en la lista?
     */
    public Board findById(Long id) {
        //deberia retornar la tarjeta que se busca
        Board tarjetabuscada;
         for (Board board : dbMock){
           if(board.getId()==id){
            tarjetabuscada=board;
            return tarjetabuscada;
            }
        }
        System.out.println("No se encontro la tarjeta");     
        return null;
    }

    public void delete(Long id,String titulo,User propietario){
        for(Board board : dbMock){
            if(board.getId()==id & board.getTitulo()==titulo & board.getPropietario()==propietario){
                dbMock.remove(board);
                break;
            }
        }
        System.out.println("No se encontro el board");
    }


    /* Este metodo simula traer información de una BD y crea
     * aleatoriamente una lista con 20 objetos.
     */
    private void loadMockedBoardList() {
        for (int i = 0; i < 20; i++) {
            dbMock.add(new Board(random.nextLong(), "Titulo Board" + i, null));
        }
    }

    
}

