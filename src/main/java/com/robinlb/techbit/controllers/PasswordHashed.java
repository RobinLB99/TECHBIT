package com.robinlb.techbit.controllers;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Robin
 */
public class PasswordHashed {

    public String hashedPassword(String password) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println("Contraseña hasheada: " + hashedPassword);
        return hashedPassword;
    }

}
