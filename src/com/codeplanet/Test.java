package com.codeplanet;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SplittableRandom;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class Test {
	
	
	@Autowired    
	
	JdbcTemplate jdbcTamplate;  //create Object of JdbcTemplate internally @Autowire manage
	
	@PostMapping("/signup")
	public String signup(HttpServletRequest req, MultipartFile file) throws SQLException, ClassNotFoundException,NumberFormatException
	{
		//fatch data from font end(form) by req.getParameter()
		String email =req.getParameter("email");
		String password=req.getParameter("psw");
	    String first_name= req.getParameter("fname");
	    String last_name=req.getParameter("lname");
	    String country=req.getParameter("country");
	    String phone=req.getParameter("phone");
	    
	    
	   
	    String filepPath = uploadFileOnserver(file);
	  
	    /*
	    //we can get the same data from model class in this way   in model class all from tag name attribute data is binding automatically 
	    String email =user.getEmail();
		String password=user.getPsw();
	    String first_name= user.getFname();
	    String last_name=user.getLname();
	    String country=user.getCountry();
	    String phone=user.getPhone();
	    */
	    
	    
	   
	    //this will print the data to the console
		System.out.println("emai= "+email+"  passoword= "+password +" f_name= "+first_name+"  lname= "+last_name+ "country"+country+"phone"+phone);
		
		//we can get connection Object to database through normal way
		//Class.forName("com.mysql.cj.jdbc.Driver");
		//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/codeplanet","root","12345");
	    
		//we can get connection Object to use spring-jdbc  jdbcTamplate this is best way of get connection it will take data from properties file
		Connection con= jdbcTamplate.getDataSource().getConnection();
		
		// create object of createStatement
	    Statement	stm=con.createStatement();
	    String query="select * from signup where email='"+email+"'";
	    
	    ResultSet rs= stm.executeQuery(query); 
	    // after connection it will send back data to ResultSet from database
	    
	 
	    
        /*
	    //we can do same thing by storeProcedure callebale statement 
	   CallableStatement stmt2= con.prepareCall("signup(?)");
	   stmt2.setString(1, email); 
	    ResultSet   rs2= stmt2.executeQuery();
	  */
	        
	    if(rs.next())    //if resultSet have atleast one row then rs.next() will return true	
	    {
	     req.setAttribute("text", "You are all ready sigin");  //we send back data to font end through req.setAttribute()
	     return"first";
	    }
	    else {
	  	  String otp= "";
	  	  otp = generateOtp(6);
	  	  System.out.println("your otp is " + otp);
	  	  String q1="insert into signup(first_name,last_name,phone_number,password,country,email,otp) values('"+first_name+"','"+last_name+"','"+phone+"','"+password+"','"+country+"','"+email+"' ,'"+otp+"')";
	  	  Statement	stm1=con.createStatement();
	   	  int row =stm1 .executeUpdate(q1);
	  	  /*
	  	   // we can get data through PreparedStatement also
	  	  String query2 = "insert into signup(first_name,last_name,phone_number,password,country,email,otp) values(?,?,?,?,?,?,?)";
	  	  PreparedStatement stmt1 = con.prepareStatement(query2);
	  	  stmt1.setString(1,first_name);
	  	  stmt1.setString(2, last_name);
	  	  stmt1.setString(3, phone);
	  	  stmt1.setString(4,password);
	  	  stmt1.setString(5,country);
	  	  stmt1.setString(6, email);
	  	  stmt1.setString(7, otp);
	  	  int row = stmt1.executeUpdate();
	  	  */
	  	  if (row >=1) {
	  		 sendMail(email, "otp is  "+otp, "otp for varification");
	  		 
	  		req.setAttribute("email", email);
	  	  }
	  	}
	  	
	  	return "signupsuccess";
	    
	  
	  	
	      
		
	
	}
	
	
	
	private String uploadFileOnserver(MultipartFile file) {
		String rootDirectory="f:/AppFeb/";
		File directory= new File(rootDirectory);
		if(! directory.exists())
			directory.mkdir();
		
		String filePath = null;
		
		 String fileName = file.getOriginalFilename();
		 if(fileName != null && fileName.length()>0){
			 
			 filePath = rootDirectory + File.separator+fileName;
			 
			 try {
				BufferedOutputStream bos = new  BufferedOutputStream( new FileOutputStream(filePath));
				bos.write(file.getBytes());
				bos.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		
		return filePath;
	}

	
	
	// we send the mail
	public void sendMail(String emailTo, String body, String subject) {
		// TODO Auto-generated method stub
		Properties p= new Properties();
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.ssl.enable", "true");
		p.put("mail.smtp.auth", "true");
		
		MailAuthenticator m= new MailAuthenticator("khanalisaif761@gmail.com", "8892042297");
		
		Session session= Session.getInstance(p, m);
		session.setDebug(true);
		
		MimeMessage msg= new MimeMessage(session);
		
		try {
			msg.setFrom("khanalisaif761@gmail.com");
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
			msg.setSubject(subject);
			msg.setText(body);
			 Transport.send(msg);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	// this is used for genrate random otp
	public String generateOtp(int size) {
		StringBuilder sb = new StringBuilder();
  		SplittableRandom sp = new SplittableRandom();
  		 for (int i =0 ; i<size; i++) {
  			 int rn = sp.nextInt(0,9);
  			 sb.append(rn);
  		 }
  		return sb.toString();
		
 
	}
	

	
	
	
	@PostMapping("/login")
	public String login(HttpServletRequest req)throws SQLException,ClassNotFoundException
	{
		String email =req.getParameter("email");
		String psw=req.getParameter("password");
		
		
	Class.forName("com.mysql.cj.jdbc.Driver");	
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/codeplanet","root","12345");
	Statement	stm=con.createStatement();
	String query="select * from signup where email='"+email+"'";
    ResultSet rs= stm.executeQuery(query);
    
    
    if (rs.next())
    {
 	   if(rs.getInt("is_varify") == 0) {
 		  req.setAttribute("text", "You are not verified");
 			return "first";
 	   }
 	   if((rs.getString("password")).equals(psw))
 	   {
 		  String query2="select * from links where created_by='"+email+"'";
 		    ResultSet rs1= stm.executeQuery(query2);
 		    
 		 ArrayList <Map<String ,String>>  l=new ArrayList <Map<String ,String>>(); 
 		   while(rs1.next())
 		   {
 			   Map<String ,String> m=new HashMap<String ,String>();
 			   m.put(("longUrl"), rs1.getString("long_link"));
 			   m.put(("shortUrl"), rs1.getString("short_link"));
 			   l.add(m);
 			
 			   
 		   }
 		   req.setAttribute("list",l);
 		   
 		   return"AfterLogin";   
 	   } else 
 	       {
 		   req.setAttribute("text", "Your psw is not correct please check");
 	       }
 	}
     else 
         {
 		   req.setAttribute("text", "You are NOT signedup");
 	      }
 	
 	return "first";	
 	}
	
	
	@PostMapping("/forgetPassword")
	
	public String forgetPasswod(HttpServletRequest req) throws ClassNotFoundException, SQLException
	{
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String newpassword=req.getParameter("newpassword");
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/codeplanet","root","12345");
		
		Statement smt =con.createStatement();
		String query="select * from signup where email='"+email+"'";
	    ResultSet rs= smt.executeQuery(query);
	   
	    if(rs.next())
	    {
	    	if(rs.getString("email").equals(email) && rs.getString("password").equals(password))
	    	{
	    		Statement	stm1=con.createStatement();
	    	    String query1="update signup set password='"+newpassword+"' where email='"+email+"'";
	    	     stm1.executeUpdate(query1);
	    	     req.setAttribute("text", "your password is changed successfully ");
	    	}
	    	else
	    		req.setAttribute("text", " wrong passwored or email ");
	    		
	    	
	    }
	    else
	    	req.setAttribute("text", "youre not signup ");
	    	
	   
		
		return"first";
	}
	
	
	@PostMapping("/otpVerification")
	
	public String otpVerification(HttpServletRequest req)throws SQLException,ClassNotFoundException
	{
	
		String otp =req.getParameter("otp");
		String email=req.getParameter("email");
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");	
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/codeplanet","root","12345");
		Statement	stm=con.createStatement();
		String query="select * from signup where email='"+email+"'";
	    ResultSet rs= stm.executeQuery(query);
	    
	    if(rs.next())
	    {
	        if(rs.getString("otp").equals(otp))
	        {
	        	Statement	stm1=con.createStatement();
	    	    String query1="update signup set is_varify=1 where email='"+email+"'";
	    	     stm1.executeUpdate(query1);
	    	     req.setAttribute("text", "your login successfully ");
	         }
	        else
	    	   req.setAttribute("text", "your passwor is nit valid");
	    }
		
		
		return "first";
	}
	
	@GetMapping("/urlshortner")
	public String urlshortner(HttpServletRequest req) throws ClassNotFoundException, SQLException
	{
	    String link=	req.getParameter("link");
	    String customurl=	req.getParameter("customurl");
	      if(customurl != null && ! customurl.isEmpty())
	       {
		     Class.forName("com.mysql.cj.jdbc.Driver");	
		     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/codeplanet","root","12345");
		     Statement	stm=con.createStatement();
		     String query="select * from links where short_link='"+customurl+"'";
	         ResultSet rs= stm.executeQuery(query);
	            if(rs.next())
	            {
	            	req.setAttribute("error", "customurl allready exists");
	            }
	            else {
	              String query2 = "insert into links(long_link,short_link) values(?,?)";
	      	  	  PreparedStatement stmt1 = con.prepareStatement(query2);
	      	  	  stmt1.setString(1,link);
	      	  	  stmt1.setString(2,customurl );
	      	  	  stmt1.executeUpdate();
	      	   	 req.setAttribute("url", "youe customurlis"+customurl );
	            }
	        }
	return "home";		
	}
	@GetMapping("/{url}")
	public String handleSort(@PathVariable String url, HttpServletRequest req) throws ClassNotFoundException, SQLException
	{
		System.out.print("your path is "+url);
		
		 Class.forName("com.mysql.cj.jdbc.Driver");	
	     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/codeplanet","root","12345");
	     Statement	stm=con.createStatement();
	     String query="select * from links where short_link='"+url+"'";
         ResultSet rs= stm.executeQuery(query);
         if(rs.next())
         {
        	String long_link =rs.getString("long_link");
        	
        	return "redirect:"+long_link;
         }
         else
        	 req.setAttribute("error", "yor url is not short plese short your url");
         
		return"Error";
	}
	
    
}
