<!DOCTYPE html>
<html>
<head>
	<title>forget password</title>
</head>
<body>
        <form action="/AppFeb/forgetPassword" method="post">
        	
        	<label>email</label>
        	 <input type="email" placeholder="enter your email" name="email"  required>  <br>
        	
        	<label for="abul">password<label>	
             <input type="text" placeholder="enter old password" name="password" required> 	<br>
             <label for="abul">new password<label>
             
             <input type="text" placeholder="enter new password" name="newpassword" required>  <br>


             <label>submit</label>
             <input type="submit" name="submit">
        </form>
</body>
</html>