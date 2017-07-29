package Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class dates {
	
	public dates() {
		// TODO Auto-generated constructor stub
	}
	

	public static Date convertionDate(String dateString){
		
	      SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	      java.util.Date d = null;
	      try {
				d=(java.util.Date) (formatter.parse(dateString));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		return d;
	}
	
	
	public static Date convertionDateFrom(String dateString){
		
	      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	      java.util.Date d = null;
	      try {
				d=(java.util.Date) (formatter.parse(dateString));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		return d;
	}
	
	public static java.util.Date convertFromSQLDateToJAVADate(
            java.sql.Date sqlDate) {
		
        java.util.Date javaDate = null;
        
        if (sqlDate != null) {
            javaDate = new Date(sqlDate.getTime());
        }
        
        return javaDate;
    }
	
	public static String getFormaDate(Date date){
		
 
    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
    String formatted = format1.format(date.getTime());
    
    
    return formatted;
	}
	
	public static java.sql.Date convertFromJavaToSQLDate(java.util.Date dateJava){
	        
		return new java.sql.Date(dateJava.getTime());
	    	
	}
	
	

}
