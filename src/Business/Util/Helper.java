/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author rwalawalkar
 */
public class Helper {
    public boolean isValidString(String s){
        if(s.isEmpty() || s == null){
            return false;
        }
        return true;
    }
    
    public Boolean isValidInteger(String s){
        try{
            Integer.parseInt(s);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    
      public Boolean isValidLong(String s){
        try{
            Long.parseLong(s);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    
    public Boolean isValidDouble(String s){
        try{
            Double.parseDouble(s);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    
    public boolean isValidEmail(String email){
           Pattern p = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
           Matcher m = p.matcher(email);
           return m.matches();
    }
    
    public boolean isValidPassword(String email){
           Pattern p = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9].*)(?=.*[$#*&]).{6,}$");
           Matcher m = p.matcher(email);
           return m.matches();
    }
    
    public boolean userNamePatternCheck(String email){
           Pattern p = Pattern.compile("^[a-zA-Z0-9]+_[a-zA-Z0-9]+@[a-zA-Z0-9.-]+$");
           Matcher m = p.matcher(email);
           return m.matches();
    }
    
    public Boolean isValidQuantity(String s){
        try{
            Integer.parseInt(s);
            if(Integer.parseInt(s) < 0 )
                return false;
            else return true;
        }catch(NumberFormatException e){
            return false;
        }
      
    }
    
    public int stringToInteger(String s){
        try{
            Integer.parseInt(s);
        }catch(NumberFormatException e){
            return 0;
        }
        return Integer.parseInt(s);
    }
    
    public Boolean isValidYear(String s){
        if(!isValidString(s)) return false;
        DateFormat date = new SimpleDateFormat("yyyy");
        date.setLenient(false);
        try {
            date.parse(s);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    public Boolean isValidDate(String s){
        if(!isValidString(s)) return false;
        DateFormat date = new SimpleDateFormat("MM/dd/yyyy");
        date.setLenient(false);
        try {
            date.parse(s);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    
    public Timestamp getCurrentTimeStamp(){
        Date date = new Date();
        Timestamp timestamp2 = new Timestamp(date.getTime());
        return timestamp2;
    }
    
    public Date stringToDateTime(String s){
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        try {
            return formatter.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }
    
    public boolean isValidDateTime(String s){
        if(!isValidString(s)) return false;
        DateFormat date = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        date.setLenient(false);
        try {
            date.parse(s);
            return true;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Date stringToDate(String s){
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        try {
            return formatter.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }
    
    public boolean compareDate(Date one, Date two){
        if(one.compareTo(two) > 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean checkSameDates(Date one, Date two){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        if(sdf.format(one).equals(sdf.format(two))){
            return true;
        }else{
            return false;
        }
    }
    public String dateToString(Date date){
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");  
        return dateFormat.format(date); 
        
    }
    
    public String dateTimeToString(Date date){
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");  
        return dateFormat.format(date); 
        
    }
    
    public String capitalizeFirstLetter(String str){  
        str = str.toLowerCase();
        String words[]=str.split("\\s");  
        String capitalizeWord="";  
        for(String w:words){  
            String first=w.substring(0,1);  
            String afterfirst=w.substring(1);  
            capitalizeWord+=first.toUpperCase()+afterfirst+" ";  
        }  
        return capitalizeWord.trim();  
    } 
    
    public long generateRandomLong(){
           return Math.abs(new Random().nextLong());
    }
}
