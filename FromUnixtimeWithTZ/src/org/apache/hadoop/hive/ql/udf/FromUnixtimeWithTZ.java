/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apache.hadoop.hive.ql.udf;

/**
 *
 * @author nitin
 */
import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;
import java.util.*;
import java.text.*;

@Description(name = "from_unixtime_with_tz",
value = "_FUNC_(epochtime, string) - returns date in that timezone for that epoch")
public class FromUnixtimeWithTZ extends UDF {
	
	private final long defaultAge = 0;
	private String timezone = "UTC";
	
	public String evaluate(long epochTime, String timezone) {
		
		
		Date date = new Date(epochTime);
                DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                format.setTimeZone(TimeZone.getTimeZone(timezone));
                String formatted = format.format(date);
                
		 return formatted; 
		
	}
	public static void main(String[] args) {
		FromUnixtimeWithTZ gdm = new FromUnixtimeWithTZ();
	    System.out.println(gdm.evaluate(1415232000000L, "UTC"));
	    System.out.println(gdm.evaluate(1415232000000L, "Asia/Calcutta"));
	    System.out.println(gdm.evaluate(1415232000000L, "US/Pacific"));
            System.out.println(gdm.evaluate(1415232000000L, ""));
            System.out.println(gdm.evaluate(0L, "UTC"));
            System.out.println(gdm.evaluate(0L, "Asia/Calcutta"));
            System.out.println(gdm.evaluate(0L, "US/Pacific"));
            System.out.println(gdm.evaluate(0L, ""));
            
            
	    
	}

}