package com.themchoisebackend.themchoisebackend.service;

import com.themchoisebackend.themchoisebackend.interfaces.portfolio.IUserService;
import com.themchoisebackend.themchoisebackend.models.User;
import com.themchoisebackend.themchoisebackend.repository.UserRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class UsuarioService implements IUserService {

    @PersistenceContext
    private EntityManager entityManager;

     // Nos permite hacer inyeccion de dependencias ; ; ; ; ; ;
    public UserRepository usuarioRepo;


    @Override
    public List<User> listUsers() {
        return usuarioRepo.findAll();
    }

    @Override
    @Deprecated
    public User findbyLoginName(User user) {

        String query = "FROM User WHERE login = :login";
        List<User> lista = entityManager.createQuery(query)
                .setParameter("login", user.getLogin())
                .getResultList();
        if ( lista.isEmpty()){
            return null;
        }
        String passwordHashed = lista.get(0).getPassword();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if  ( argon2.verify(passwordHashed, user.getPassword()) ){
            return lista.get(0);
        }else{
            return null;
        }

    }

    @Override
    public void crearUsuario(User usr){
        usuarioRepo.save(usr);
    }
}