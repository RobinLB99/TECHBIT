package com.robinlb.techbit.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateController {
    
    public Date formatToDate(String dateString) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = new Date();
        
        try {
            fecha = formato.parse(dateString);
        } catch (ParseException ex) {
            System.out.println("Error al parsear la fecha: " + ex.getMessage());
            ex.printStackTrace();
        }
        return fecha;
    }
    
    public String dateToString(Date date) {
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        return formateador.format(date);
    }
    
}
