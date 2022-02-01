
package cde.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDateToStringUtil {
    
    
    private ConvertDateToStringUtil(){
        
    }
    
    public static String convertToString(Date date){
        DateFormat dtFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = dtFormat.format(date);
        String dateWithoutBar = formattedDate.replace("/", "_");
        return dateWithoutBar;
                
    }
}
