<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>TMPS00015</title>
<link href="css/styles.css" rel="stylesheet" type="text/css" />
<link href='http://fonts.googleapis.com/css?family=Economica' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
<!--menu-->
<link rel="stylesheet" href="css/superfish.css" media="screen">
<script src="js/jquery-1.9.0.min.js"></script>
<script src="js/hoverIntent.js"></script>
<script src="js/superfish.js"></script>
<script>

		// initialise plugins
		jQuery(function(){
			jQuery('#example').superfish({
				//useClick: true
			});
		});

</script>	
</head>
<body>


<div class="wrap1">
<div class="container">
  <div class="header">
    <div class="logo">
      <h1>Control de Glucosa</h1>
      <h2>Log-In</h2>
    </div>
    <div class="menu">
      <ul class="sf-menu" id="example">
        <li><a href="index.html">Home</a></li>
        <li class="current"> <a href="guide.html">¿Cómo funciona?</a></li>
        <li> <a href="aboutUs.html">Sobre Nosotros </a></li>
        <li> <a href="logIn.jsp">Log In </a></li>
      </ul>
    </div>
  </div>
  <div class="clearing"></div>
</div>
<div class="clearing"></div>
</div>
<!--header-wrap-->
<div class="wrap2">
<div class="container">
 	<form name = "formularioLogIn" action ="/logIn" method = "POST" onSubmit="return validate_form()">
		Correo:<br/>
 		<input type="email" name="correo" id="email" required = "required" size="30" /><br/>
 		Contraseña:<br/>
 		<input type="password" name="password" id="password" required = "required" size="30" /><br/>
 		<button  type="submit" size="15">Log-In </button>

	</form>
	<div class="qregister"><a href="register.html">¿Aún no estás registrado? Pulsa aquí.<a></div>
	<div class="qregister"><a href="registroMedico.html">Si eres médico pulsa aquí para registrarte.<a></div>
		
<div class="clearing"></div>
</div>
</div>
<!--wrap4-->
<div class="wrap3">
	<div class="container">
	  <div class="footer"> Grupo 15 ISST - Sistema de Control de Glucosa 
	  <div id= "fecha">
			<script type="text/javascript">
				var fecha = new Date();
				var date = fecha.toLocaleDateString("en-US");
				var hora = " " + fecha.getHours() + ":" + fecha.getMinutes() 
				document.getElementById("fecha").innerHTML = date + hora;
			</script>
		</div>
		</div>
	<div class="clearing"></div>
</div>
</div>
<div class="shadows2">
</div>
</body>
</html>
