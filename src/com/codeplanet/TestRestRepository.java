package com.codeplanet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestRestRepository {
	
@Autowired    
	
	JdbcTemplate jdbcTamplate;

     public ArrayList<Map<String, String>> getFirstApi(String email) 
     {
    	 try
    	 {
       Connection con= jdbcTamplate.getDataSource().getConnection();
        Statement	stm=con.createStatement();
    	    
    	 String query2="select * from links where created_by='"+email+"'";
		    ResultSet rs1= stm.executeQuery(query2);
		    
		    ArrayList<Map<String, String>> l = new ArrayList<Map<String,String>>(); 
		  
		    while(rs1.next())
		   {
			   Map<String ,String> m=new HashMap<String ,String>();
			   m.put(("longUrl"), rs1.getString("long_link"));
			   m.put(("shortUrl"), rs1.getString("short_link"));
		   
			   l.add(m);
		   }
    	 return l;
    	 }
    	 catch(Exception e)
    	 {
    		 return null;
    	 }
    	 
     }

     }
