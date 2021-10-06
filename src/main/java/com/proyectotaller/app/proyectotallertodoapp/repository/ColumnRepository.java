package com.proyectotaller.app.proyectotallertodoapp.repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ch.qos.logback.classic.spi.CallerData;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.proyectotaller.app.proyectotallertodoapp.model.Column;

@Repository
public class ColumnRepository {
    
    private final Logger logger = LoggerFactory.getLogger(ColumnRepository.class);
    Random random = new Random();
    List<Column> dbMock = new ArrayList<>();

    public ColumnRepository() {
        loadMockedColumnList();
    }
     
    /* Este metodo simula guardar un objeto en la BD
     * en este caso lo estamos agregando a una lista en memoria
     * y simulando que se le asigna un id de bd.
     * @param newColumn
     */
    public Column save(Column newColumn) {
        newColumn.setId(random.nextLong());
        logger.info("Saving column with id: {}", newColumn.getId());
        dbMock.add(newColumn);
        return newColumn;
    }
  // private Long id;
    // private String titulo;
    // private Integer orden;
    /* Este metodo simula actualizar un objeto en la BD
     * ¿Cómo actuariamos si no se encuentra en la lista?
     */
    public Column update(Column column,Long id,String titulo,Integer orden){
        /*Implementar lógica que me permita tomar la lista de tarjetas dbMock y actualizar la que corresponda en base a su id.
        Una vez encontrada, deberia retornar la tarjeta actualizada*/
       String updateado;

       updateado="no";
        while(updateado=="si"){
         for (Column columnn : dbMock){
           if(columnn.getId()==column.getId()){
            column.setTitulo(titulo);
            column.setOrden(orden);
            updateado="si";
            return column;
            }else{
                updateado="no";
            } 
        }
        }
        return null;
    }

    public List<Column> findAll() {
        return dbMock;
    }

    /* Este metodo debe filtrar la lista y obtener la tarjeta correspondiente
     * ¿Como actuariamos si no se encuentra en la lista?
     */
    public Column findById(Long id) {
        //deberia retornar la tarjeta que se busca
        Column tarjetabuscada;
         for (Column column : dbMock){
           if(column.getId()==id){
            tarjetabuscada=column;
            return tarjetabuscada;
            }
        }
        System.out.println("No se encontro la tarjeta");     
        return null;
    }
  
    public void delete(Long id,String titulo,Integer orden){
        for(Column column : dbMock){
            if(column.getId()==id & column.getTitulo()==titulo & column.getOrden()==orden){
                dbMock.remove(column);
                break;
            }
        }
        System.out.println("No se encontro el column");
    }

    /* Este metodo simula traer información de una BD y crea
     * aleatoriamente una lista con 20 objetos.
     */
    private void loadMockedColumnList() {
        for (int i = 0; i < 20; i++) {
            dbMock.add(new Column(random.nextLong(), "Titulo Columna" + i, random.nextInt()));
        }
    }

    
}
