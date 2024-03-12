package com.robinlb.techbit.controllers;

//import org.mindrot.jbcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Proporciona servicio de cifrado y validación de contraseñas.
 */
public class PasswordSecurityService {

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    /**
     * Cifra la contraseña ingresada.
     * 
     * @param password
     * @return String passwordEncrypted
     */
    public String encrypt(String password) {
        return encoder.encode(password);
//        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    /**
     * Retorna verdadero o falso según coincida la contraseña ingresada con la
     * contraseña encriptada almacenada.
     * 
     * @param password
     * @param hashedPassword
     * @return true / false 
     */
    public boolean matches(String password, String hashedPassword) {
        return encoder.matches(password, hashedPassword);
//        return BCrypt.checkpw(password, hashedPassword);
    }

}
