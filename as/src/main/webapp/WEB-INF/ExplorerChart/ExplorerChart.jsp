<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">

	$(document).ready(){
		asd();
		
	}

	function asd() {

	    var barOptions = {
	        series: {
	            bars: {
	                show: true,
	                barWidth: 43200000
	            }
	        },
	        xaxis: {
	            mode: "time",
	            timeformat: "%m/%d",
	            minTickSize: [1, "day"]
	        },
	        grid: {
	            hoverable: true
	        },
	        legend: {
	            show: false
	        },
	        tooltip: true,
	        tooltipOpts: {
	            content: "x: %x, y: %y"
	        }
	    };
	    var barData = {
	        label: "bar",
	        data: [
	            [1354521600000, 1000],
	            [1355040000000, 2000],
	            [1355223600000, 3000],
	            [1355306400000, 4000],
	            [1355487300000, 5000],
	            [1355571900000, 6000]
	        ]
	    };
	    $.plot($("#flot-bar-chart"), [barData], barOptions);

	}
    
    
    
</script>
</head>
<body>
    <div id="flot-bar-chart"></div>
 
</body>
</html>