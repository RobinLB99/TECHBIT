package com.robinlb.techbit.controllers;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Robin
 */
public class PasswordHashed {

    public String encrypt(String password) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println("Contraseña hasheada: " + hashedPassword);
        return hashedPassword;
    }
    
    public String decrypt(String password) {
        String PasswordUnhashed = "";
        return PasswordUnhashed;
    }

}
