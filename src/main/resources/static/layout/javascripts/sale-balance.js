/*<![CDATA[*/
           
var year = new Date().getFullYear();
         
$(document).ready(function() {
	showChart(year);
});

var showChart = function(yea){
	$.get("/datapoint/" + yea, function (result) {
		var dpoints = [];
	    var yea = year;
	    var total;
	    var average;
	 	
	    for (var i = 0; i < result.length; i++) {
		   dpoints.push({
	            label: result[i].label,
	            y: result[i].y
	          });
		}
	    
	  	var chart = new CanvasJS.Chart("chartContainer", {	
			title: {
				text: "Gráfico de balanço de vendas"
			},
	       	animationEnabled: true,
	       	axisY:{
	           title:"Reais (R$)"
	        },
	        axisX:{
	            title: yea,
	         },
			data: [
				{
					type: "spline",
					indexLabel: "R$ {y}",
					dataPoints: dpoints
				}
			]
		});
	 	$("#totalLabel").html("<h4> Faturamento de " + yea + " </h4>");
	 	$("#averageLabel").html("<h4> Média mensal de " + yea + "</h4>");
	 	$.get("/sale/" + yea, function (result) {
	 		$("#totalValue").html("<h5> R$ " + result + " </h5>");
	 		$("#averageValue").html("<h5> R$ " + parseFloat((result/12).toFixed(2)) + " </h5>");
	 	});
	 	chart.render();
	});
}

$("#btn_prevyear").click(function(){
	year = year-1;
	showChart(year);
});

$("#btn_nextyear").click(function(){
	year = year+1;
	showChart(year);
});

/*]]>*/