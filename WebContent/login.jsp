
<style>
    
    body{
    background: rgb(1, 0, 25);
    margin: 0;
}

.login_page {
  width: 360px;
  padding: 8% 0 0;
  margin: auto;
}

.form {
  position: relative;
  z-index: 1;
  background: #FFFFFF;
  max-width: 360px;
  margin: 0 auto 100px;
  padding: 45px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}

.form input {
  font-family: "Roboto", sans-serif;
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}

.form input:focus{
    width: 70%;
    border: 1px solid #FF7F50;
}

.form input:hover{
    width: 70%;
    border: 1px solid #FF7F50;
}

.form button {
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background: #0B0C10;
  width: 100%;
  border: 0;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  cursor: pointer;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
 
}

.form button:hover,.form button:active,.form button:focus {
  background: rgb(218, 118, 81);
}

.form .message {
  margin: 15px 0 0;
  color: #b3b3b3;
  font-size: 12px;
}

.form .message a {
  color:#0B0C10 ;
  text-decoration: none;
}

.form .message a:hover {
  color:#FF7F50;
}


h1 {
  color: white;
  font-family: 'Raleway', sans-serif;
  font-size: 28px;
  font-weight: 500;
  text-align: left;
  text-transform: uppercase;
}

/* Page Content Ends Here */


</style>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel = "stylesheet" href = "css/fontawesome/css/all.css" type = "text/css">
    <link rel = "stylesheet" href = "css/login.css" type ="text/css">
    <script  src="js/login.js" type="text/javascript"></script>
    <link href="https://fonts.googleapis.com/css?family=Montserrat|Muli|Roboto|ZCOOL+XiaoWei|Work+Sans|Hind+Siliguri|Lobster|Merienda" rel="stylesheet">
    
    <title>Login</title>
</head>

<body>
    
<!-- Page Content Appear Here-->
<marquee><h1>Log in to your Account</h1></marquee>

<div class="login_page">
    <div class="form">
          <form  action="/AppFeb/login" name="login" method="post" onsubmit= "return formValidation();">
            <input name="email" type="text"  placeholder="Email" />
              <input name="password"  type="password" placeholder="Password" />
              <button>login</button>
              <p class="message">Not registered? <a href="signup.jsp">Create an account</a></p>
               <p class="message"><a href="forgetPassword.jsp">forget password</a></p>
          </form>
    </div>
</div>

<br><br><!-- Page Content Appear Here-->
</body>
</html>