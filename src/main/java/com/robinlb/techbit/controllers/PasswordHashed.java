package com.robinlb.techbit.controllers;

//import org.mindrot.jbcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Robin
 *
 */
public class PasswordHashed {

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    /**
     *
     * @param password
     * @return contraseña encriptada
     */
    public String encrypt(String password) {
        return encoder.encode(password);
//        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    /**
     *
     * @param password
     * @param hashedPassword
     * @return true o false según coincida la contraseña ingresada con la
     * contraseña encriptada almacenada.
     */
    public boolean match(String password, String hashedPassword) {
        return encoder.matches(password, hashedPassword);
//        return BCrypt.checkpw(password, hashedPassword);
    }

}
