package com.robinlb.techbit.controllers;

import java.io.InputStream;
import java.util.Scanner;
import org.json.JSONArray;

/**
 * Controlador para manejar y procesar archivos JSON.
 * 
 * @author Robin
 */
public class JSONController {

  /**
   * Devuelve un array de objetos según los datos del archivo JSON leido.
   * 
   * @param uri
   * @return JSONArray 
   */
  public JSONArray obtenerJSONArray(String uri) {
    String stringJson = "";

    ClassLoader cl = Thread.currentThread().getContextClassLoader();
    InputStream is = cl.getResourceAsStream(uri);

    if (is != null) {
      Scanner scanner = new Scanner(is).useDelimiter("\\A");
      stringJson = scanner.hasNext() ? scanner.next() : "";
      scanner.close();
    }
    
    return new JSONArray(stringJson);
  }

}
