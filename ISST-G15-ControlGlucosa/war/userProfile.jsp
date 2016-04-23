<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>TMPS00015</title>
<link href="css/styles.css" rel="stylesheet" type="text/css" />
<link href='http://fonts.googleapis.com/css?family=Economica'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Lato'
	rel='stylesheet' type='text/css'>
<!--menu-->
<link rel="stylesheet" href="css/superfish.css" media="screen">
<script src="js/jquery-1.9.0.min.js"></script>
<script src="js/hoverIntent.js"></script>
<script src="js/superfish.js"></script>
<script>
	// initialise plugins
	jQuery(function() {
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
					<h1>
						<a href="paciente.html">Control de Glucosa</a>
					</h1>
					<h2>Información de usuario</h2>
				</div>
				<div class="menu">
					<ul class="sf-menu" id="example">
						<li><a href="userData.html">Consulta de datos</a></li>
						<li class="current"><a href="enterData.html">Formulario</a></li>
						<li><a href="userProfile.html">Perfil</a></li>
						<li><a href="index.html">Log Out</a></li>
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
			<!--<ul>
			<li>Nombre:</li>
			<li>Apellidos:</li>
			<li>Correo:</li>
			<li>DNI:</li>
			<li>Fecha de nacimiento:</li>
			<li>Grupo sanguíneo:</li>
			<li>Tipo de diabetes:</li>
			<li>Peso:</li>
			<li>Teléfono de contacto:</li>
	</ul>-->
			<table>
				<tr>
					<td>Nombre:</td>
					<td><c:out value="${nombre}" /></td>
				</tr>
				<tr>
					<td>Apellidos:</td>
					<td><c:out value="${apellidos}" /></td>
				</tr>
				<tr>
					<td>Correo:</td>
					<td><c:out value="${usuario}" /></td>
				</tr>
				<tr>
					<td>DNI:</td>
					<td><c:out value="${dni}" /></td>
				</tr>
				<tr>
					<td>Fecha de nacimiento:</td>
					<td><c:out value="${nacimiento}" /></td>
				</tr>
				<tr>
					<td>Grupo sanguíneo:</td>
					<td><c:out value="${gsanguineo}" /></td>
				</tr>
				<tr>
					<td>Tipo de diabetes:</td>
					<td><c:out value="${tipoDiabetes}" /></td>
				</tr>
				<tr>
					<td>Peso:</td>
					<td><c:out value="${peso}" /></td>
				</tr>
				<tr>
					<td>Teléfono de contacto:</td>
					<td><c:out value="${telefono}" /></td>
				</tr>
			</table>

			<div class="clearing"></div>
		</div>
	</div>
	<!--wrap4-->
	<div class="wrap3">
		<div class="container">
			<div class="footer">
				Grupo 15 ISST - Sistema de Control de Glucosa
				<div id="fecha">
					<script type="text/javascript">
						var fecha = new Date();
						var date = fecha.toLocaleDateString("en-US");
						var hora = " " + fecha.getHours() + ":"
								+ fecha.getMinutes()
						document.getElementById("fecha").innerHTML = date
								+ hora;
					</script>
				</div>
			</div>
			<div class="clearing"></div>
		</div>
	</div>
	<div class="shadows2"></div>
</body>
</html>