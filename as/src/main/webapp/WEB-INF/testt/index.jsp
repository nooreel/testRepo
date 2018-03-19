<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../TopBottom/Top.jsp"%>

<script>
$(document).ready(function(){
	
	/* Nclient 정보현황(자산) */
	assetchart();
	/* Nclient 정보현황(비자산) */
	notassetchart();
	/* 상용 소프트웨어 현황(제조사별) */
	makerSwChart()
	
	
	/* os설치현황 */
	ospatch();
	
	/* window 패치현황 */
	windowpatch();
	
	/* 현장 sw 배포현황 */
	swdistribute();
	
	
	/* 표준sw등록현황 */
	standardsw();
	
	/* Explorer 설치 현황 */
	ExplorerPatch();
	

	
	});
	
function assetchart(){
	var chart=Morris.Bar({
		  // ID of the element in which to draw the chart.
		  element: 'nclientassetinfo',
		  // Chart data records -- each entry in this array corresponds to a point on
		  // the chart
		  data: [
			  
		    { x: '전체', y: ${assetbean.countentire}, z: ${assetbean.coutnentiresetup}},
		    { x: 'PC', y: ${assetbean.countpc}, z: ${assetbean.countpcsetup}},
		    { x: 'NoteBook', y:${assetbean.countnotebook}, z: ${assetbean.countnotebooksetup}},
		  ],
		  // The name of the data record attribute that contains x-values.
		  xkey: 'x',
		  // A list of names of data record attributes that contain y-values.
		  ykeys: ['y','z'],
		  // Labels for the ykeys -- will be displayed when you hover over the
		  // chart.
		  labels: ['대상수','설치수'],
		  barColors:['#4F86C0','#FC9B2B'],
		  hideHover:true
		
		});
	
	var legendtag="";
	for(var i=0;i<chart.options.labels.length;i++){
		
		legendtag+="<span style='width:10px;height:5px;background:"+chart.options.barColors[i]+";color:"+chart.options.barColors[i]+"'>___</span>";
		legendtag+=" "+chart.options.labels[i]+"&nbsp&nbsp";
	}
	$("#nclientassetinfolegend").html(legendtag);
}
function notassetchart(){
	var chart=Morris.Bar({
		  // ID of the element in which to draw the chart.
		  element: 'nclientnotassetinfo',
		  // Chart data records -- each entry in this array corresponds to a point on
		  // the chart
		  data: [
			  
		    { x: '전체', y: ${notassetbean.countentire}, z: ${notassetbean.coutnentiresetup}},
		    { x: 'PC', y: ${notassetbean.countpc}, z: ${notassetbean.countpcsetup}},
		    { x: 'NoteBook', y:${notassetbean.countnotebook}, z: ${notassetbean.countnotebooksetup}},
		  ],
		  // The name of the data record attribute that contains x-values.
		  xkey: 'x',
		  // A list of names of data record attributes that contain y-values.
		  ykeys: ['y','z'],
		  // Labels for the ykeys -- will be displayed when you hover over the
		  // chart.
		  labels: ['대상수','설치수'],
		  hideHover:true,
		  barColors:['#4F86C0','#FC9B2B']
		});
	
	

	
	var legendtag="";
	for(var i=0;i<chart.options.labels.length;i++){
		
		legendtag+="<span style='width:10px;height:5px;background:"+chart.options.barColors[i]+";color:"+chart.options.barColors[i]+"'>___</span>";
		legendtag+=" "+chart.options.labels[i]+"&nbsp&nbsp";
	}
	$("#nclientnotassetinfolegend").html(legendtag);
	
}
function makerSwChart(){
	var chart=Morris.Bar({
		  // ID of the element in which to draw the chart.
		  element: 'makerchart',
		  // Chart data records -- each entry in this array corresponds to a point on
		  // the chart
		  data: [
			  <c:forEach items="${makerlist}" var="m">
			  {x:'${m.maker }', y:${m.quantity}, z: ${m.setup}},
			  </c:forEach>
		  ],
		  // The name of the data record attribute that contains x-values.
		  xkey: 'x',
		  // A list of names of data record attributes that contain y-values.
		  ykeys: ['y','z'],
		  // Labels for the ykeys -- will be displayed when you hover over the
		  // chart.
		  labels: ['보유수량','설치수량'],
		  hideHover:true,
		  barColors:['#4F86C0','#FC9B2B']
		});
	
	/* chart lengend */
	
	var legendtag="";
	for(var i=0;i<chart.options.labels.length;i++){
		
		legendtag+="<span style='width:10px;height:5px;background:"+chart.options.barColors[i]+";color:"+chart.options.barColors[i]+"'>___</span>";
		legendtag+=" "+chart.options.labels[i]+"&nbsp&nbsp";
	}
	$("#makerchartlegend").html(legendtag);
}
function aaa(){
	
	var barOptions = {
			
	        series: {
	            bars: {
	                show: true,
	                barWidth: 0.1,
	                align:"center",
	                horizontal: true,
	            }
	        },
	        grid: {
	            hoverable: true
	        },
	        yaxis:{
	        	min:0,
	        	max:4,
	        	mode:null,
	        	align:"center",
	        	ticks: [
                        [1, "누리"],
                        [2, "세미"],
                        [3, "세미2"]	 
                        ],
                ticksLength:0,
                axisLabelUseCanvas: true,
                axisLabelPadding: 5},
            xaxis:{
            	tickDecimals:0,
            	axisLabelUseCanvas: true,
                axisLabelPadding: 5,
                tickLength: 0
            },
	        legend: {
	            show: false
	        },
	  		lines:true,
	        tooltip: true,
	        tooltipOpts: {
	            content: "x: %x, y: %y"
	        }
	    };
	
	    var barData1 = {
	        label: "bar2",
	        data: [
	 			[5,1],[6,2],[3,3]
	        ],
	        label:"as"
	        
	    };
	    var barData2 = {
		        label: "bar1",
		        data: [
		 			[3,1],[2,2],[1,3]
		        ],
		        label:"bd"
		    };
	    
	    var data1=[[5,1],[6,2],[3,3]];
	    var data2=[[3,1],[2,2],[1,3]];
	    
	    
	    var data = [
            {label: "PASS", data:data1, bars: {fillColor: "#336600",order:1}, color: "#336600"},
            {label: "FAIL", data:data2, bars: {fillColor: "#E41B17",order:2}, color: "#E41B17"}
        ];
	    $.plot($("#flotbarchart"),data, barOptions);
}


function ospatch(){
	
    
    /* os설치 현황 */
		var osdata = [
			<c:forEach var="i" items="${oslists}">
			{label: '${i.osname }',data: ${i.oscount}},
			</c:forEach>
			]; 
		
		
		var plotObj = $.plot($("#flot-pie-chartsemi"), osdata, {
		    series: {
		        pie: {
		            show: true
		        }
		    },
		    grid: {
		        hoverable: true
		    },
		    tooltip: true,
		    tooltipOpts: {
		        content: "%p.0%, %s", // show percentages, rounding to 2 decimal places
		        shifts: {
		            x: 20,
		            y: 0
		        },
		        defaultTheme: false
		    }
		});
	
}
function standardsw(){
	
	
	$('#standardSw').DataTable({
		"scrollY":        "150px",
		ordering:false
	});
	
}

function ExplorerPatch(){
	
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
  
    $.plot($("#flot-bar-chart2"), [barData], barOptions);
	
	
    
    
}


function windowpatch(){
	

	/* windows 패치현황 */
   var barOptions = {
           series: {
               bars: {
                   show: true,
                   barWidth: 0.2,
                   align:"center",
                   horizontal: true,
                   order:1
               }
           },
           grid: {
               hoverable: true
           },
           yaxis:{
        	   min:0,
        	   max:4,
              mode:null,
              align:"center",
              ticks: [
                        [1, "잔여"],
                        [2, "완료"],
                        [3, "전체"]    
                        ],
                ticksLength:0},
            xaxis:{
            	min:0,
	        	max:7,
               tickDecimals:0
            },
           legend: {
               show: true
           },
           lines:true,
           tooltip: true,
           tooltipOpts: {
               content: "패치량: %x"
           }
       };
   
       var barData1 = {
           label: "패치량",
           data: [
             [${bean.patchall-bean.patchend},1],[${bean.patchend},2],[${bean.patchall},3]
           ]
       };

       
       $.plot($("#flotbarchart"), [barData1], barOptions);

       
   
}


function swdistribute(){

	/* 현장 sw 배포 현황*/
		   
		   var barOptions = {
		         
		           series: {
		               bars: {
		                   show: true,
		                   barWidth: 0.2,
		                   align:"center",
		                   horizontal: true,
		               }
		           },
		           grid: {
		               hoverable: true
		           },
		           yaxis:{
		              min:-1,
		              max:7,
		              mode:null,
		              align:"center",
		              ticks: [
		            	  
		            	<c:forEach var="i" items="${swlists }" varStatus="status">
		            	[${status.index},'${i.swname}']
		            	<c:if test="${status.index ne fn:length(swlists)-1 }">
			    	   		,
			    	   	</c:if>
			    	   </c:forEach>
		                        ],
		                ticksLength:0,
		                axisLabelUseCanvas: true,
		                axisLabelPadding: 5},
		            xaxis:{
		            	max:12,
		               tickDecimals:0,
		               axisLabelUseCanvas: true,
		                axisLabelPadding: 5,
		                tickLength: 0
		            },
		           legend: {
		               show: true
		           },
		           lines:true,
		           tooltip: true,
		           tooltipOpts: {
		               content: " %y, %x"
		           }
		       };
		   

		            	  
		            	  
		            	  
		            	  
		      
		       var data1=[
		    	   <c:forEach var="i" items="${swlists }" varStatus="status">
		    	   [${i.setupcount},${status.index}]
		    	   <c:if test="${status.index ne fn:length(swlists)-1 }">
            	  	,
		    	   </c:if>
                    </c:forEach>
            	  ];
		       
		       var data2=[
	    	   	<c:forEach var="i" items="${swlists }" varStatus="status">
		    	   [${i.daesangcount},${status.index}]
		    	   
		    	   <c:if test="${status.index ne fn:length(swlists)-1 }">
		    	   ,
			       </c:if>
                   </c:forEach>
            	  ];
		       
		       
		      
		       

		      
		       
		       var data = [
		            {label: "설치수", data:data1, bars: {fillColor: "#4F86C0",order:1}, color: "#4F86C0"},
		            {label: "대상수", data:data2, bars: {fillColor: "#FC9B2B",order:2}, color: "#FC9B2B"}
		        ];
		       
		       
		       
		       $.plot($("#standardsw"),data, barOptions);
		       


	
}
</script>




<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">현장PC 운영 관리 화면</h1>
		</div>
	</div>

	<div class="row">
		<div class="col-lg-6">
			<div class="panel panel-primary">
				<div class="panel panel-heading">Nclient 정보현황(자산)</div>
				<div class="panel panel-body">
					<div id="nclientassetinfolegend" align="center"></div>
					<div id="nclientassetinfo" style="height: 250px;"></div>
				</div>

			</div>
		</div>

		<div class="col-lg-6">
			<div class="panel panel-primary">
				<div class="panel panel-heading">Nclient 정보현황(비자산)</div>
				<div class="panel panel-body">
					<div id="nclientnotassetinfolegend" align="center"></div>
					<div id="nclientnotassetinfo" style="height: 250px;"></div>
				</div>
			</div>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-6">
			<div class="panel panel-primary">
				<div class="panel panel-heading">상용 소프트웨어 현황(제조사별)</div>
				<div class="panel panel-body">
					<div id="makerchartlegend" align="center"></div>
					<div id="makerchart" style="height: 250px;"></div>
				</div>
			</div>
		</div>

		<!-- os설치현황 -->

		<div class="col-lg-6">
			<div class="panel panel-primary">
				<div class="panel panel-heading">OS 설치 현황</div>
				<!-- /.panel-heading -->
				<div class="panel panel-body">
					<div class="flot-chart " style="height: 250px;">
						<div class="flot-chart-content" id="flot-pie-chartsemi"
							style="height: 250px;"></div>
					</div>
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-6 -->
	</div>


	<div class="row">
		<!-- windows 패치 -->
		<div class="col-lg-6">
			<div class="panel panel-primary">
				<div class="panel-heading">windows 패치</div>
				<!-- /.panel-heading -->
				<div class="panel panel-body">
					<div id="flotbarchart" style="height: 250px;"></div>
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- windows 패치 -->


		<!-- 현장 sw 배포 현황 -->
		<div class="col-lg-6">
			<div class="panel panel-primary">
				<div class="panel panel-heading">현장 sw 배포 현황</div>
				<!-- /.panel-heading -->
				<div class="panel-body">

					<div id="standardsw" style="height: 250px;"></div>
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- 현장 sw 배포 현황 끝 -->
	</div>
	<div class="row">
		<div class="col-lg-6">
			<div class="panel panel-primary">
				<div class="panel panel-heading">표준 SW 등록현황</div>
				<div class="panel panel-body">
					<table id="standardSw" class="table table-hover table-bordered"
						cellspacing="0" width="100%">
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
									<td align="right"><fmt:formatNumber
											value="${s.assetsetupcount/s.assetdaesang*100 }"
											pattern=".00" /> %</td>
									<td align="right">${s.notassetdaesang}</td>
									<td align="right"><fmt:formatNumber
											value="${s.notassetsetupcount/s.notassetdaesang*100 }"
											pattern=".00" /> %</td>
								</tr>
							</c:forEach>
						</tbody>

					</table>
				</div>
			</div>
		</div>



		<!-- /.col-lg-6 -->
		<div class="col-lg-6">
			<div class="panel panel-primary">
				<div class="panel-heading">Explorer 설치 현황</div>

				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="flot-chart">
						<div class="flot-chart-content" id="flot-bar-chart2"
							style="height: 250px;"></div>
					</div>
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-6 -->
	</div>
	<!-- row 끝 -->




</div>
<!-- /#page-wrapper -->

<!-- jQuery -->
<script src="../vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="../vendor/metisMenu/metisMenu.min.js"></script>



<!-- Custom Theme JavaScript -->
<script src="../dist/js/sb-admin-2.js"></script>

<%@ include file="../TopBottom/Bottom.jsp"%>