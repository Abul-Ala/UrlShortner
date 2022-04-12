
<!DOCTYPE html>
<html>
<head>

<style>

[11:38 pm, 18/02/2022] Abul Ala: /* Created by a friend/mentor and some by me */
html {
  scroll-behavior: smooth;
}
body {
  display: grid;
  background: url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQC9fvhYbDyIqo2f4kDBcPB__sReqy6Rriecw&usqp=CAU");
  background-size: cover;
}

.wrapper {
  border: solid rgba(255, 255, 255, 0.1);
  border-radius: 13px;
  box-shadow: 0 10px 11px rgba(0, 0, 0, 0.3);
  margin: 5%;
  padding: 20px;
}

h1 {
  margin-top: 0px;
  color: white;
  font-family: Georgia, 'Times New Roman', Times, serif;
  text-align: center;
}

.form {
  position: relative;
  width: 400px;
  height: 400px;
  display: grid;
  background: rgba(255, 255, 255, 0.1);
  border-top: 1px solid rgba(255, 255, 255, 0.5);
  border-left: 1px solid rgba(255, 255, 255, 0.3);
  border-right: 1px solid rgba(255, 255, 255, 0.3);
  border-bottom: 1px solid rgba(255, 255, 255, 0.2);
  backdrop-filter: blur(12px);
  box-shadow: 0 26px 42px rgba(0, 0, 0, 0.1);
}

label {
  color: #FFFF;
  font-family: Georgia;
}

input {
  box-sizing: border-box;
  border: none;
  background: rgba(255, 255, 255, 0.1);
  border-radius: 6px;
  border-top: 1px solid rgba(255, 255, 255, 0.2);
  box-shadow: 0 13px 20px rgba(0, 0, 0, 0.3);
  color: white;
  height: 18px;
  width: 100%;
}

select {
   border: none;
   height: 20px;
   width: 110px;
   background: rgba(255, 255, 255, 0.1);
   border-radius: 8px;
   border-top: 1px solid rgba(255, 255, 255, 0.2);
   box-shadow: 0 13px 21px rgba(0, 0, 0, 0.3);
   color: white;
}
.check {
  width: 15.5px;
  border: none;
  box-shadow: none;
}

.checkbox {
  color: #FFFF;
  font-family: monospace;
  font-size: 11.07px;
}

/For login/
.login {
  color: #FFFF;
  font-family: Georgia, 'Times New Roman', Times, serif;
  font-size: 14px;
  text-align: center;
}

a {
  color: #FFFF;
}

button {
  border: none;
  background: #FF8A00;
  border-radius: 6px;
  color: #FFFFFF;
  font-size: 17.5px;
  height: 30px;
  width: 100%;
}

.norights {
    text-align: right;
    color: #FFFF;
    font-size: 11px;
    font-family: Courier;
}
</style>


  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>Sign Up Form</title>
  
  <link rel="stylesheet" href="style.css"/>
</head>

<body>
  <div class="wrapper">
    <h1>Sign up</h1>
    
    <form action="/AppFeb/signup"  method="POST"  enctype='multipart/form-data'  onsubmit="myFunction()">
    
      <label for="fname">First Name</label><br>
      <input type="text" name="fname" id="name" required/>
      <br><br>
      
      <label for="lname">Last Name</label><br>
      <input type="text" name="lname" required/>
      <br><br>
      
      <label for="email"> E-mail</label><br>
      <input type="email" name="email" required/>
      <br><br>
      
      <label for="phone">Phone number</label><br>
      <input type="tel" name="phone" required/>
      <br><br>
      
      <label for="psw">Password</label><br>
      <input type="password" name="psw" id="password" minlength="8" required/>
      <br><br>
      
      <label>Confirm Password</label><br>
      <input type="password" id="password " minlength="8" required/>
      <br><br>
      
      <!-- Countries -->
      <label for="country">Country</label>
      <select name="country" required>
        <option></option>
        <option>india</option>
        <option>pakistan</option>
        <option>Yemen</option>
       
      </select>
      <br><br>
      
      <label for="userFile">Upload your file</label><br>
      <input type="file" name="userFile" required/>
      <br><br>
      
      <!-- checkbox -->
      <div class="checkbox">
        <input type="checkbox" class="check" value="terms" required/>I agree to the <a href="#">terms and conditions</a>
      </div>
      <br><br>
      
      <div class="login">
        Already member? <a href= login.jsp><b>login</b></a>
      </div>
      <br><br>
    
     <button type="submit">Sign up</button>
    </form>
    
</div>

<!-- Copyright claim, no copyright -->
<div class="norights">
    2021 Strx. No rights reserved
</div>

</body>
</html>