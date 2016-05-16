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
<script src="http://d3js.org/d3.v3.min.js"></script>
<script src="http://labratrevenge.com/d3-tip/javascripts/d3.tip.v0.6.3.js"></script>

<script>
	// initialise plugins
	jQuery(function() {
		jQuery('#example').superfish({
		//useClick: true
		});
	});
</script>

<style>

body {
  font: 10px sans-serif;
}

.axis path,
.axis line {
  fill: none;
  stroke: #000;
  shape-rendering: crispEdges;
}

.bar {
  fill: orange;
}

.bar:hover {
  fill: orangered ;
}

.x.axis path {
  display: none;
}

.d3-tip {
  line-height: 1;
  font-weight: bold;
  padding: 12px;
  background: rgba(0, 0, 0, 0.8);
  color: #fff;
  border-radius: 2px;
}

/* Creates a small triangle extender for the tooltip */
.d3-tip:after {
  box-sizing: border-box;
  display: inline;
  font-size: 10px;
  width: 100%;
  line-height: 1;
  color: rgba(0, 0, 0, 0.8);
  content: "\25BC";
  position: absolute;
  text-align: center;
}

/* Style northward tooltips differently */
.d3-tip.n:after {
  margin: -1px 0 0 0;
  top: 100%;
  left: 0;
}
</style>

</head>
<body>


	<div class="wrap1">
		<div class="container">
			<div class="header">
				<div class="logo">
					<h1>
						<a href="medico.html">Control de Glucosa</a>
					</h1>
					<h2>Información de usuario</h2>
				</div>
				<div class="menu">
					<ul class="sf-menu" id="example">
						<li><a href="doctorData.jsp">Consulta de datos</a></li>
						<li><a href="medicoProfile.jsp">Perfil</a></li>
						<li><a href="logOut">Log Out</a></li>
					</ul>
				</div>
			</div>
			<div class="clearing"></div>
		</div>
		<div class="clearing"></div>
	</div>
	
	<div class="wrap2">
		<div class="container">
		
        <c:forEach items="${medidas}" var="medida">
    		${medida}<br>
		</c:forEach>
		<br>
		<br>
		<c:forEach items="${datos}" var="dato">
    		${dato}<br>
		</c:forEach>
		<br>
		<br>
		<c:forEach items="${fechas}" var="fecha">
    		${fecha}<br>
		</c:forEach>
		<br>
		<br>
		<c:forEach items="${dates}" var="date">
    		${date}<br>
		</c:forEach>
		
<div id="grafica"></div>	
<div id="graficaIMG"></div>	

<script>

//datos

//var data = ${medidas};
var data = [{
    "time": "01:00",
    "total": 120
}];

var margin = {
    top: 40,
    right: 40,
    bottom: 40,
    left: 40
},
width = 800,
    height = 500;


var today = new Date();
today.setHours(0, 0, 0, 0);
todayMillis = today.getTime();

data.forEach(function(d) {
    var parts = d.time.split(/:/);
    var timePeriodMillis = (parseInt(parts[0], 10) * 60 * 60 * 1000) +
                           (parseInt(parts[1], 10) * 60 * 1000);
    
    d.time = new Date();
    d.time.setTime(todayMillis + timePeriodMillis);
});

var x = d3.time.scale()
    .domain(d3.extent(data, function(d) { return d.time; }))
    .nice(d3.time.day, 1)
    .rangeRound([0, width - margin.left - margin.right]);

var y = d3.scale.linear()
    .domain([0, 350])
    .range([height - margin.top - margin.bottom, 0]);

var xAxis = d3.svg.axis()
    .scale(x)
    .orient('bottom')
    .ticks(d3.time.hours, 2)
    .tickFormat(d3.time.format('%H:%M'))
    .tickSize(0)
    .tickPadding(8);

var yAxis = d3.svg.axis()
    .scale(y)
    .orient('left')
    .tickPadding(8)
    .ticks(30)
    .tickFormat(function(d) { return d.total; });

var svg = d3.select('#grafica').append('svg')
    .attr('class', 'chart')
    .attr('width', width)
    .attr('height', height)
    .append('g')
    .attr('transform', 'translate(' + margin.left + ', ' + margin.top + ')');

svg.selectAll('.chart')
    .data(data)
    .enter().append('rect')
    .attr('class', 'bar')
    .attr('x', function (d) {
        return x(d.time);
    })
    .attr('y', function (d) {
        return height - margin.top - margin.bottom - (height - margin.top - margin.bottom - y(d.total))
    })
    .attr('width', 10)
    .attr('height', function (d) {
        return height - margin.top - margin.bottom - y(d.total)
    });

svg.append('g')
    .attr('class', 'x axis')
    .attr('transform', 'translate(0, ' + (height - margin.top - margin.bottom) + ')')
    .call(xAxis);

svg.append('g')
    .attr('class', 'y axis')
    .call(yAxis);




    var html = d3.select("svg")
  .attr("version", 1.1)
  .attr("xmlns", "http://www.w3.org/2000/svg")
  .node().parentNode.innerHTML;

	//console.log(html);
	var imgsrc = 'data:image/svg+xml;base64,'+ btoa(html);
	var img = '<img src="'+imgsrc+'">'; 
	d3.select("#graficaIMG").html(img);

</script>
		
		
		
		
		
		</div>
	</div>
	
	
	
	
	
	
	
	
	
	
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