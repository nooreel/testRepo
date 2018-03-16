<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../TopBottom/Top.jsp"%>

<script language="JavaScript">

$(document).ready(function(){
	
	$('#standardSw').DataTable({
		"scrollY":        "150px",
		ordering:false
	});
	

});


	


$(function() {

	var ticks=[
		
		<c:forEach var="e" items="${ecb }" varStatus="status"> 
		[${status.index },"Explorer "+${e.floor}],
		</c:forEach>
		
	]
	
	
    var barOptions = {
        series: {
            bars: {
                show: true,
                horizontal:true
            }
        },
        bars:{
        	align: "center",
            barWidth: 0.5,
            horizontal: true,
            
            fillColor: { colors: [{ opacity: 0.7 }, { opacity: 1}] },
            lineWidth: 1
        },
        
        xaxis: {
        	tickDecimals:0,
        	axisLabelPadding: 10,
        	max:6
        	
        },
        yaxis:{
        	min:-1,
        	max:7,
        	axisLabelPadding: 5,
        	ticks:ticks
        },
        grid: {
            hoverable: true,
            borderWidth: 2
        },
        legend: {
            show: false
        },
        tooltip: true,
        tooltipOpts: {
            content: "%x"
        }
    };
    var barData = {
        label: "bar",
        data: [
        	
        	
        	<c:forEach var="e" items="${ecb }" varStatus="status"> 
			[${e.count},${status.index }],
			</c:forEach>
			
            
        ]
    };
  
    $.plot($("#flot-bar-chart"), [barData], barOptions);
});



</script>




        	
<div id="page-wrapper">


<div class="row">
		<div class="col-lg-6">
			<div class="panel panel-primary">
				<div class="panel panel-heading">
					표준 SW 등록현황
				</div>
				<div class="panel panel-body">
				<table id="standardSw" class="table table-hover table-bordered" cellspacing="0" width="100%">
						<thead>
						<tr>
							<td rowspan=2 valign="bottom" align="center">S/W명</td>
							<td colspan=2 align="center">자산</td>
							<td colspan=2 align="center">비자산</td>
						</tr>
						<tr>
							<td align="center">대상</td>
							<td align="center">율</td>
							<td align="center">대상</td>
							<td align="center">율</td>
						</tr>
						</thead>
						<tbody>
					<c:forEach var="s" items="${swlist}">
						<tr>
						<td>${s.swname}</td>
						<td align="right">${s.assetdaesang}</td>
						<td align="right">
						<fmt:formatNumber value="${s.assetsetupcount/s.assetdaesang*100 }" pattern=".00" />
						%</td>
						<td align="right">${s.notassetdaesang}</td>
						<td align="right">
						<fmt:formatNumber value="${s.notassetsetupcount/s.notassetdaesang*100 }" pattern=".00" />
						%</td>
						</tr>
					</c:forEach>
					</tbody>
						
					</table>
				</div>
			</div>
		</div>
	</div> <!-- row 끝 -->


	<!-- /.col-lg-6 -->
	<div class="col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading">Windows 설치 현황
			
			
			</div>
			
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="flot-chart">
					<div class="flot-chart-content" id="flot-bar-chart"></div>
				</div>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-6 -->
</div>

<%@ include file="../TopBottom/Bottom.jsp"%>
