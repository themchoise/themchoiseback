package com.themchoisebackend.themchoisebackend.interfaces.portfolio;

import com.themchoisebackend.themchoisebackend.models.User;

import java.util.List;

public interface IUserService {

     List<User> listUsers ();

     User findbyLoginName(User usr);

     void crearUsuario(User usr);





}
