<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>TMPS00015</title>
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
    <script type="text/javascript">
      function vaciar(){
        document.getElementById("valor").value = "";
      }
      function guardar(valor, fecha){
        alert("Se ha guardado correctamente para el dia " + fecha + " con nivel de glucosa = " + valor )
        document.getElementById("saved").value = "Se ha guardado correctamente";
      }
      function comprobar(){
        var glucoseLv = document.getElementById("valor").value 
        if(glucoseLv == ""){
          alert("El campo de nivel de glucosa es obligatorio")
        }
        else if(isNaN(glucoseLv)){
          alert("El valor tiene que ser un número")
        }
        else if (glucoseLv<0){
          alert("El valor tiene que ser mayor que 0")
        }
        else if (glucoseLv>=1000){
          alert("El valor tiene que ser menor que 1000")
        }else { 
          var fecha = $('#fechaMedicion').handleDtpicker('getDate');
          if (fecha <= new Date()){
            guardar(glucoseLv, fecha);
          }else{alert("La fecha tiene que ser anterior a hoy");}
        }

      }
    </script>
</head>
<body>


<div class="wrap1">
<div class="container">
  <div class="header">
    <div class="logo">
      <h1><a href="paciente.html">Control de Glucosa</a></h1>
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
<form name = "dataenter" action ="MedidaNueva" method = "POST" onSubmit="comprobar()">
Introduzca el nivel de glucosa

    <input type="text" id="valor" name="valor">
    </br>
    </br>
    Seleccione fecha de la medición
  <input type="text" id="fechaMedicion" name="fechaMedicion" value="">
  <script type="text/javascript">
    $(function(){
      $('*[name=fechaMedicion]').appendDtpicker();
    });
  </script>
    </br>
    </br>
    <button type="submit"> Guardar </button>
</form>

    <div id= "saved"></div>
    </br>
    <div id= "fecha"></div>

    <script type="text/javascript">
      var fecha = new Date();
      var date = fecha.toLocaleDateString("en-US");
      var hora = " " + fecha.getHours() + ":" + fecha.getMinutes() 
      document.getElementById("fecha").innerHTML = date + hora;
    </script>
  </body>

  </div>
<div class="clearing"></div>
</div>
</div>
<!--wrap4-->
<div class="wrap3">
<div class="container">
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
