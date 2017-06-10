/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author edson
 */
public class Funcoes {
    
    public static Date StringToDate(String str) {
        
        java.sql.Date data;
        try {
           SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
           data = new java.sql.Date(format.parse(str).getTime());
        } catch (Exception ex) {
            return null;
        }
        
        return data;
    }
    
}
