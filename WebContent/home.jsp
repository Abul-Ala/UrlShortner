
<!DOCTYPE html>
<html>
<head>
	<!--<img src="favicon.jpeg">-->
	<title> Bitly | Custom URL Shortener, Link Management & Branded Links </title>
	<!-- Bootstrap Files-->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="static/Bootstrap/bootstrap.min.css">

	<!-- manual CSS -->
	<link rel="stylesheet" type="text/css" href="static/css/style.css">

</head>
<body>
	<!--- Header Part -->
	<form action="/AppFeb/login">
		<nav class="navbar black navbar-expand-md navbar-light sticky-top" style="background-color: white; padding-top:10px;">
			<div class="container">
				<a class="navbar-brand" href="#">
				  	<div class="icon-img">
				  		<img src="static/images/bitly_logo.jpg" width="100%;">
				  	</div>
				  </a>
				  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
				    <span class="navbar-toggler-icon"></span>
				  </button>
				  <div class="collapse navbar-collapse" id="collapsibleNavbar" style="border: 0px solid;margin-left: 35px;">
				    <ul class="navbar-nav">
				      <li class="nav-item menu-opt">
				        <a class="nav-link" href="#">Why Bitly</a>
				      </li>
				      <li class="nav-item menu-opt">
				        <a class="nav-link" href="#">Solution</a>
				      </li>
				      <li class="nav-item menu-opt">
				        <a class="nav-link" href="#">Features</a>
				      </li>    
				      <li class="nav-item menu-opt">
				        <a class="nav-link" href="#">Pricing</a>
				      </li>    
				      <li class="nav-item menu-opt">
				        <a class="nav-link" href="/log">Resources</a>
				      </li>
                          <li class="nav-item menu-opt">
				        <a class="nav-link" href="login.jsp">Login</a>
				      </li>
                          <li class="nav-item menu-opt">
				        <a class="nav-link" href="signup.jsp">SignUp</a>
				      </li>

				    </ul>
			 	 </div> 
			 </div> 
		</nav>	
		  
      </form>
	<!--- Header Part Ends-->
			<div class="container-fuild" style=" margin-top:50px; ">
				<div class="container" >
					<div class="row">
						 <div class="col-md-7" >
						 	<div class="row" style="margin-top:20%">
						 		<h1><b>Create Click-Worthy Links</b></h1>
						 		<h5>Build and protect your brand using powerful, recognizable short links.</h5>
						 	</div>
						 	<div class="row" style="margin-top: 30px;">
						 		<div class="col-md-5" >
						 			<div class="btn1">
						 				Get Started for Free	
						 			</div>
						 			<div >
						 				<center><a href="#" style="text-decoration: none">Get a Quote</a></center>
						 			</div>
						 		</div>
						 	</div>
						 </div>
						 <div class="col-md-5 img1">
						 	<img src="static/images/girl_img.jpg" width="100%">
						 </div>
                        <div><a href="">Short Url</a></div>
					</div>
				</div>
			</div>

			<div class="container-fuild" style="margin-top: 30px; background-color: #0B1736;"> 

                <div class="container">
 <form action="urlshortner">
                    <div class="row" style="padding:20px 0px 20px 0px; ">
						<div class="col-md-8">
								<input type="text" name="link" placeholder="Paste Your Long URL">
                                <input type="text" name="customurl" placeholder="custom url">
						</div>
						<div class="col-md-4">
							<input type="submit" name="short-btn" value="Shorten">
						</div>

						<div class="col-md-8">
							<label style="color:#818797;">
								By clicking SHORTEN, you are agreeing to Bitly’s <a href="#">Terms of Service</a>  and <a href="#"> Privacy Policy</a>
							</label>
						</div>
					</div>
        </form>
   ${error }
    ${ url }
				</div>

			</div>

</body>
</html>