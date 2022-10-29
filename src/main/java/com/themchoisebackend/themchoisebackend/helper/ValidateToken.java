package com.themchoisebackend.themchoisebackend.helper;
import com.themchoisebackend.themchoisebackend.models.Data;
import com.themchoisebackend.themchoisebackend.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public  class ValidateToken {

        @Autowired
        private JWTUtil jwtUtil;
        public boolean validate(String token){

            try{
                String tokenRecived = jwtUtil.getKey(token);
                if ( tokenRecived == null){
                    return false;

                }else{
                    return true;
                }

            }catch  (Exception e){
                return false;
            }

        }


}
