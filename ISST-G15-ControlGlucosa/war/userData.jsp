<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/styles.css" rel="stylesheet" type="text/css" />
<link type="text/css" href="css/jquery.simple-dtpicker.css" rel="stylesheet" />
<link href='http://fonts.googleapis.com/css?family=Economica' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
<!--menu-->
<link rel="stylesheet" href="css/superfish.css" media="screen">
<script src="js/jquery-1.9.0.min.js"></script>
<script src="js/hoverIntent.js"></script>
<script src="js/superfish.js"></script>
<script type="text/javascript" src="js/jquery.simple-dtpicker.js"></script>
<script>

		// initialise plugins
		jQuery(function(){
			jQuery('#example').superfish({
				//useClick: true
			});
		});

</script>
<script type="text/javascript" src="http://mbostock.github.com/d3/d3.js"></script>
<script src="http://d3js.org/d3.v3.min.js"></script>

</head>
<body>


<div class="wrap1">
<div class="container">
  <div class="header">
    <div class="logo">
      <h1><a href="paciente.html">Control de Glucosa</a></h1>
      <h2>Consulta de datos</h2>
    </div>
    <div class="menu">
      <ul class="sf-menu" id="example">
        <li><a href="userData.jsp">Consulta de datos</a></li>
        <li class="current"> <a href="enterData.jsp">Formulario</a></li>
        <li> <a href="userProfile.jsp">Perfil</a></li>
        <li> <a href="logOut">Log Out</a></li>
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




<form name = "selectDay" action ="mostrar" method = "post" >
Elija la fecha
  <input type="text" id="fecha" name="fecha" >
  <script type="text/javascript">
    $(function(){
      $('*[name=fecha]').appendDtpicker({
    	  "dateOnly": true
      });
    });
  </script>
    <br>
    <br>
    <button type="submit"> Seleccionar </button>
</form>
<a href="/mostrar">Mostrar todas las medidas</a>




		
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