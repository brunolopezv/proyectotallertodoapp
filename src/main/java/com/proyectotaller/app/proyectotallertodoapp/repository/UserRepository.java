package com.proyectotaller.app.proyectotallertodoapp.repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ch.qos.logback.classic.spi.CallerData;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.proyectotaller.app.proyectotallertodoapp.model.User;

@Repository
public class UserRepository {
    
    private final Logger logger = LoggerFactory.getLogger(UserRepository.class);
    Random random = new Random();
    List<User> dbMock = new ArrayList<>();

    public UserRepository() {
        loadMockedUserList();
    }
     
    /* Este metodo simula guardar un objeto en la BD
     * en este caso lo estamos agregando a una lista en memoria
     * y simulando que se le asigna un id de bd.
     * @param newUser
     */
    public User save(User newUser) {
        newUser.setId(random.nextLong());
        logger.info("Saving user with id: {}", newUser.getId());
        dbMock.add(newUser);
        return newUser;
    }
    


    /* Este metodo simula actualizar un objeto en la BD
     * ¿Cómo actuariamos si no se encuentra en la lista?
     */
    public User update(User user,Long id,String username,String nombre,String apellido,String dni){
        /*Implementar lógica que me permita tomar la lista de tarjetas dbMock y actualizar la que corresponda en base a su id.
        Una vez encontrada, deberia retornar la tarjeta actualizada*/
       String updateado;

       updateado="no";
        while(updateado=="si"){
         for (User usern : dbMock){
           if(usern.getId()==user.getId()){
            user.setUsername(username);
            user.setNombre(nombre);
            user.setApellido(apellido);
            user.setDni(dni);
            updateado="si";
            return user;
            }else{
                updateado="no";
            } 
        }
        }
        return null;
    }

    public List<User> findAll() {
        return dbMock;
    }

    /* Este metodo debe filtrar la lista y obtener la tarjeta correspondiente
     * ¿Como actuariamos si no se encuentra en la lista?
     */
    public User findById(Long id) {
        //deberia retornar la tarjeta que se busca
        User tarjetabuscada;
         for (User user : dbMock){
           if(user.getId()==id){
            tarjetabuscada=user;
            return tarjetabuscada;
            }
        }
        System.out.println("No se encontro la tarjeta");     
        return null;
    }
    
    public void delete(Long id,String username,String dni){
        for(User user : dbMock){
            if(user.getId()==id & user.getUsername()==username & user.getDni()==dni){
                dbMock.remove(user);
                break;
            }
        }
        System.out.println("No se encontro el user");
    }

    /* Este metodo simula traer información de una BD y crea
     * aleatoriamente una lista con 20 objetos.
     */
    private void loadMockedUserList() {
        for (int i = 0; i < 20; i++) {
            dbMock.add(new User(random.nextLong(), "Username" + i, "Pila", "Apellido", null));
        }
    }

    
}
