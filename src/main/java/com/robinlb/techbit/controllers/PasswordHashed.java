package com.robinlb.techbit.controllers;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Robin
 *
 */
public class PasswordHashed {

    /**
     *
     * @param password
     * @return contraseña encriptada
     */
    public String encrypt(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    /**
     *
     * @param password
     * @param hashedPassword
     * @return true o false según coincida la contraseña ingresada con la
     * contraseña encriptada almacenada.
     */
    public boolean match(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }

}
