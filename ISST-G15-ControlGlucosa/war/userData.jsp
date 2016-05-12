<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<script type="text/javascript" src="http://mbostock.github.com/d3/d3.js"></script>
<script src="http://d3js.org/d3.v3.min.js"></script>
<style>
body {
  font: 11px sans-serif;
}

.axis path,
.axis line {
  fill: none;
  stroke: #000;
  shape-rendering: crispEdges;
}

.dot {
  stroke: #000;
}

.tooltip {
  position: absolute;
  width: 200px;
  height: 28px;
  pointer-events: none;
}
.tablaDatos{
	
}
</style>
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
        <li class="current"> <a href="enterData.html">Formulario</a></li>
        <li> <a href="userProfile.html">Perfil</a></li>
        <li> <a href="index.html">Log Out</a></li>
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
	
<p>Estas son sus medidas de glucosa:</p>

<div id="tablaDatos"></div>
<div id="graficaDatos"></div>

<script type="text/javascript">    
	//Imprimir por pantalla la tabla con el CSV
	d3.text("datosGlucosaCSV.csv", function(datasetText) {
	var parsedCSV = d3.csv.parseRows(datasetText);
	var sampleHTML = d3.select("#tablaDatos")
	    .append("table")
	    .style("border-collapse", "collapse")
	    .style("border", "2px black solid")
	    .selectAll("tr")
	    .data(parsedCSV)
	    .enter().append("tr")
	    .selectAll("td")
	    .data(function(d){return d;})
	    .enter().append("td")
	    .style("border", "1px black solid")
	    .style("padding", "5px")
	    .on("mouseover", function(){d3.select(this).style("background-color", "aliceblue")})
	    .on("mouseout", function(){d3.select(this).style("background-color", "white")})
	    .text(function(d){return d;})
	    .style("font-size", "12px");
	});

</script>
  
<script>
var margin = {top: 20, right: 60, bottom: 30, left: 40},
    width = 960 - margin.left - margin.right,
    height = 500 - margin.top - margin.bottom;

// setup x 
var xValue = function(d) { return d.hora;}, // data -> value
    xScale = d3.scale.linear().domain([0, 24]).range([0, width]), // value -> display
    xMap = function(d) { return xScale(xValue(d));}, // data -> display
    xAxis = d3.svg.axis().scale(xScale).orient("bottom").ticks(24);

// setup y
var yValue = function(d) { return d["medida"];}, // data -> value
    yScale = d3.scale.linear().domain([0, 400]).range([height, 0]), // value -> display
    yMap = function(d) { return yScale(yValue(d));}, // data -> display
    yAxis = d3.svg.axis().scale(yScale).orient("left").ticks(30);

// setup fill color
var cValue = function(d) { return d.nombre;},
    color = d3.scale.category10();

// add the graph canvas to the body of the webpage
var svg = d3.select("#graficaDatos").append("svg")
    .attr("width", width + margin.left + margin.right)
    .attr("height", height + margin.top + margin.bottom)
  .append("g")
    .attr("transform", "translate(" + margin.left + "," + margin.top + ")");

// add the tooltip area to the webpage
var tooltip = d3.select("graficaBody").append("div")
    .attr("class", "tooltip")
    .style("opacity", 0);

//Pinto la zona en verde
svg.append("rect")
  .style("fill", "#99FF99")
  .style("opacity", 0.5)
  .attr("x", 0)     // x position of the first end of the line
  .attr("y", 280)      // y position of the first end of the line
  .attr("width", width)     // x position of the second end of the line
  .attr("height", 80);  

// load data
d3.csv("datosGlucosaCSV.csv", function(error, data) {

  // change string (from CSV) into number format
  data.forEach(function(d) {
    d.hora = +d.hora;
    d["medida"] = +d["medida"];
  });

  // x-axis
  svg.append("g")
      .attr("class", "x axis")
      .attr("transform", "translate(0," + height + ")")
      .call(xAxis)
    .append("text")
      .attr("class", "label")
      .attr("x", width)
      .attr("y", -6)
      .style("text-anchor", "end")
      .text("Hora");

  // y-axis
  svg.append("g")
      .attr("class", "y axis")
      .call(yAxis)
    .append("text")
      .attr("class", "label")
      .attr("transform", "rotate(-90)")
      .attr("y", 6)
      .attr("dy", ".71em")
      .style("text-anchor", "end")
      .text("Medida Glucosa");

  // draw dots
  svg.selectAll(".dot")
      .data(data)
    .enter().append("circle")
      .attr("class", "dot")
      .attr("r", 3.5)
      .attr("cx", xMap)
      .attr("cy", yMap)
      .style("fill", function(d) { return color(cValue(d));}) 
      .on("mouseover", function(d) {
          tooltip.transition()
               .duration(200)
               .style("opacity", .9);
          tooltip.html(d["nombre"] + "<br/> (" + xValue(d) 
	        + ", " + yValue(d) + ")")
               .style("left", (d3.event.pageX + 5) + "px")
               .style("top", (d3.event.pageY - 28) + "px");
      })
      .on("mouseout", function(d) {
          tooltip.transition()
               .duration(500)
               .style("opacity", 0);
      });
});

</script>





		
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