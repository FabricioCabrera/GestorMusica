
package com.utilidades;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Faby
 */
public class Utilidades {
     public String devolverFecha(Date fecha) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        return f.format(fecha);
    
}
}
