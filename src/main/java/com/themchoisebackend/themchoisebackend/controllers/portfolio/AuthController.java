package com.themchoisebackend.themchoisebackend.controllers.portfolio;

import com.themchoisebackend.themchoisebackend.interfaces.portfolio.IUserService;
import com.themchoisebackend.themchoisebackend.models.AuthData;
import com.themchoisebackend.themchoisebackend.models.Data;
import com.themchoisebackend.themchoisebackend.models.User;
import com.themchoisebackend.themchoisebackend.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private IUserService usuarioService;

    @GetMapping("/token/validateToken")
    @ResponseBody
    public Data validarToken(@RequestHeader(value="Authorization") String token){

        try{
            String tokenRecived = jwtUtil.getKey(token);
            if ( tokenRecived == null){
                return new Data(false, null, "invalidToken");

            }else{
                return new Data(true,null, "tokenValid");
            }

        }catch  (Exception e){
            return new Data(false, null, "invalidToken");
        }

// boolean status, List data, String error
    }

/*
    @GetMapping("/ver/usuarios")
    @ResponseBody
    public List<User> verUsuarios(@RequestHeader(value="Authorization") String token){
        String tokenRecived = jwtUtil.getKey(token);
        if ( tokenRecived == null){
            return new ArrayList<>();
        }
        return usuarioService.listUsers();
    }


 */
 /*
    @PostMapping("/registrar/usuario")
    public Data registrarUsuario(@RequestBody User usr){

        try{
            System.out.println(usr.getData());
            Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
            String hash = argon2.hash(1,1024,1, usr.getPassword());
            usr.setPassword(hash);
            usuarioService.crearUsuario(usr);
            Data datares  = new Data(true, null,null);
            return datares;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
*/
    @Autowired
    private JWTUtil jwtUtil;


    @PostMapping("/login")
    public AuthData login(@RequestBody User usr){

        System.out.println(usr.getData());
        AuthData authResponse = new AuthData();

        User usrLogin =  usuarioService.findbyLoginName(usr);
        if ( usrLogin != null ) {
            String token = jwtUtil.create(String.valueOf(usrLogin.getId()), usrLogin.getLogin());
            authResponse.setLogin(usrLogin.getLogin());
            authResponse.setToken(token);
            authResponse.setUid(usrLogin.getId());
            authResponse.setOk(true);
            return authResponse;
        }else{
            authResponse.setLogin(null);
            authResponse.setToken(null);
            authResponse.setUid(0);
            authResponse.setOk(false);
            return authResponse;
        }

    }



}
