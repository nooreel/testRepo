<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../TopBottom/Top.jsp" %>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">
				권역별 정보 현황
			</h1>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-primary">
					<div class="panel panel-heading">
						
						<table width=100%>
							<tr>
								<td>NetClient 권역별 정보 현황</td>
								<td align="right">
						<form action="NclientInfoByArea.ni" method="get" id="f">
						기준일자 <input type="date" name="fixedDate" onchange="getRecordBySwDate()" value="${fixedDate}" style="color:black;"><br>	
						</form>
						</td>
							</tr>
						</table>
						
					</div>
					<div class="panel panel-body">
						<table class="table table-bordered">
							<tr>
								<td rowspan=2>권역</td>
								<td colspan=3>자산</td>
								<td colspan=3>비자산</td>
								<td colspan=3>합계</td>
							</tr>
							<tr>
								<td>대상</td>
								<td>수신</td>
								<td>표시율</td>
								<td>대상</td>
								<td>수신</td>
								<td>표시율</td>
								<td>대상</td>
								<td>수신</td>
								<td>표시율</td>
							</tr>
							<c:forEach var="n" items="${nclientinfolist}">
								<tr onclick="ftest('${n.area_seq}')">
									<td>${n.areaname}</td>
									<td>${n.assetcount}</td>
									<td>${n.assetrecevingcount}</td>
								<c:if test="${n.assetcount==0}">
									<td>0%</td>
								</c:if>
								<c:if test="${n.assetcount!=0}">
									<td>
									<fmt:formatNumber value="${n.assetrecevingcount/n.assetcount*100}" pattern=".00" />
									%</td>
								</c:if>
									<td>${n.notassetcount}</td>
									<td>${n.notassetrecevingcount}</td>
								<c:if test="${n.notassetcount==0}">
									<td>0%</td>
								</c:if>
								<c:if test="${n.notassetcount!=0 }">
									<td>
									<fmt:formatNumber value="${n.notassetrecevingcount/n.notassetcount*100}" pattern=".00" />
									%</td>
								</c:if>
									<td>${n.assetcount+n.notassetcount}</td>
									<td>${n.assetrecevingcount+n.notassetrecevingcount}</td>
								<c:if test="${n.assetrecevingcount+n.notassetrecevingcount==0}">
									<td>0%</td>
								</c:if>	
								<c:if test="${n.assetrecevingcount+n.notassetrecevingcount!=0}">	
									<td>
									<fmt:formatNumber value="${(n.assetrecevingcount+n.notassetrecevingcount)/(n.assetcount+n.notassetcount)*100}" pattern=".00" />
									%</td>
								</c:if>
								</tr>
							</c:forEach>
								<tr>
							<td colspan=5>${paginghtml}</td>
							<td colspan=5 style="text-align:right">${beginrow }-${endrow } of ${totalCount} items</td>
								</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-primary">
					<div class="panel panel-heading">
						NetClient 조직별 정보 현황
					</div>
					<div class="panel panel-body" id="departmentDiv">
					
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
function ftest(area_seq){
	alert("json테스트 들어옴"+area_seq);
	$.ajax({
		url:"NclientInfoJson.ni",
		data:{area_seq:area_seq},
		dataType :"json",
		success:function(data){
			var tablecode="";
			tablecode+="<table class='table table-bordered'>";
			tablecode+="<tr>";
			tablecode+="<td colspan=3>구분</td>";
			tablecode+="<td colspan=3>자산</td>";
			tablecode+="<td colspan=3>비자산</td>";
			tablecode+="<td colspan=3>합계</td>";
			tablecode+="</tr>";
			
			tablecode+="<tr>";
			tablecode+="<td>권역</td>";
			tablecode+="<td>지점</td>";
			tablecode+="<td>부서</td>";
			tablecode+="<td>대상</td>";
			tablecode+="<td>수신</td>";
			tablecode+="<td>표시율</td>";
			tablecode+="<td>대상</td>";
			tablecode+="<td>수신</td>";
			tablecode+="<td>표시율</td>";
			tablecode+="<td>대상</td>";
			tablecode+="<td>수신</td>";
			tablecode+="<td>표시율</td>";
			tablecode+="</tr>";
			
			var result=data.ablist;
			for(var i=0;i<result.length;i++){
				tablecode+="<tr>";
				tablecode+="<td>"+result[i].areaname+"</td>";
				tablecode+="<td>"+result[i].officename+"</td>";
				tablecode+="<td>"+result[i].departmentname+"</td>";
				
				tablecode+="<td>"+result[i].assetcount+"</td>";
				tablecode+="<td>"+result[i].assetrecevingcount+"</td>";
				var assetper=result[i].assetrecevingcount*1.0/result[i].assetcount*100;
				if(isNaN(assetper)){
					assetper=0;
				};
				
				tablecode+="<td>"+assetper.toFixed(2)+"%</td>";
				
				tablecode+="<td>"+result[i].notassetcount+"</td>";
				tablecode+="<td>"+result[i].notassetrecevingcount+"</td>";
				var notassetper=result[i].notassetrecevingcount*1.0/result[i].notassetcount*100;
				if(isNaN(notassetper)){
					notassetper=0;
				};
				
				tablecode+="<td>"+notassetper.toFixed(2)+"%</td>";
				
				var sumasset=result[i].assetcount*1+result[i].notassetcount;
				var sumreceving=result[i].assetrecevingcount*1+result[i].notassetrecevingcount;
				var sumper=sumreceving*1.0/sumasset*100;
				if(isNaN(sumper)){
					sumper=0;
				};
				
				
				
				tablecode+="<td>"+sumasset+"</td>";
				tablecode+="<td>"+sumreceving+"</td>";
				tablecode+="<td>"+sumper.toFixed(2)+"%</td>";
				
				tablecode+="</tr>";
			};
			
			var paging=data.paging;

			tablecode+="<tr>";
			tablecode+="<td colspan=6>"+paging.pagingHtml+"</td>";
			tablecode+="<td>"+paging.beginRow+"-"+paging.endRow+" of "+paging.totalCount+" items</td>"
			tablecode+="</tr>";
			
			
			
			tablecode+="</table>"
			
			$("#departmentDiv").html(tablecode);
			alert("ajax끝");

		}
	});
}



function ftest2(area_seq,pageNumber){

	$.ajax({
		url:"NclientInfoJson.ni",
		data:{area_seq:area_seq,pageNumber:pageNumber},
		dataType :"json",
		success:function(data){
			var tablecode="";
			tablecode+="<table class='table table-bordered'>";
			tablecode+="<tr>";
			tablecode+="<td colspan=3>구분</td>";
			tablecode+="<td colspan=3>자산</td>";
			tablecode+="<td colspan=3>비자산</td>";
			tablecode+="<td colspan=3>합계</td>";
			tablecode+="</tr>";
			
			tablecode+="<tr>";
			tablecode+="<td>권역</td>";
			tablecode+="<td>지점</td>";
			tablecode+="<td>부서</td>";
			tablecode+="<td>대상</td>";
			tablecode+="<td>수신</td>";
			tablecode+="<td>표시율</td>";
			tablecode+="<td>대상</td>";
			tablecode+="<td>수신</td>";
			tablecode+="<td>표시율</td>";
			tablecode+="<td>대상</td>";
			tablecode+="<td>수신</td>";
			tablecode+="<td>표시율</td>";
			tablecode+="</tr>";
			
			var result=data.ablist;
			for(var i=0;i<result.length;i++){
				tablecode+="<tr>";
				tablecode+="<td>"+result[i].areaname+"</td>";
				tablecode+="<td>"+result[i].officename+"</td>";
				tablecode+="<td>"+result[i].departmentname+"</td>";
				
				tablecode+="<td>"+result[i].assetcount+"</td>";
				tablecode+="<td>"+result[i].assetrecevingcount+"</td>";
				var assetper=result[i].assetrecevingcount*1.0/result[i].assetcount*100;
				if(isNaN(assetper)){
					assetper=0;
				};
				
				tablecode+="<td>"+assetper.toFixed(2)+"%</td>";
				
				tablecode+="<td>"+result[i].notassetcount+"</td>";
				tablecode+="<td>"+result[i].notassetrecevingcount+"</td>";
				var notassetper=result[i].notassetrecevingcount*1.0/result[i].notassetcount*100;
				if(isNaN(notassetper)){
					notassetper=0;
				};
				
				tablecode+="<td>"+notassetper.toFixed(2)+"%</td>";
				
				var sumasset=result[i].assetcount*1+result[i].notassetcount;
				var sumreceving=result[i].assetrecevingcount*1+result[i].notassetrecevingcount;
				var sumper=sumreceving*1.0/sumasset*100;
				if(isNaN(sumper)){
					sumper=0;
				};
				
				
				
				tablecode+="<td>"+sumasset+"</td>";
				tablecode+="<td>"+sumreceving+"</td>";
				tablecode+="<td>"+sumper.toFixed(2)+"%</td>";
				
				tablecode+="</tr>";
			};
			
			var paging=data.paging;

			tablecode+="<tr>";
			tablecode+="<td colspan=6>"+paging.pagingHtml+"</td>";
			tablecode+="<td>"+paging.beginRow+"-"+paging.endRow+" of "+paging.totalCount+" items</td>"
			tablecode+="</tr>";
			
			
			
			tablecode+="</table>"
			
			$("#departmentDiv").html(tablecode);


		}
	});
	
}

function getRecordByPageNumber(area_seq){
	var pageNumber=$("input[name=pageNumber2]").val();
	$.ajax({
		url:"NclientInfoJson.ni",
		data:{area_seq:area_seq,pageNumber:pageNumber},
		dataType :"json",
		success:function(data){
			var tablecode="";
			tablecode+="<table class='table table-bordered'>";
			tablecode+="<tr>";
			tablecode+="<td colspan=3>구분</td>";
			tablecode+="<td colspan=3>자산</td>";
			tablecode+="<td colspan=3>비자산</td>";
			tablecode+="<td colspan=3>합계</td>";
			tablecode+="</tr>";
			
			tablecode+="<tr>";
			tablecode+="<td>권역</td>";
			tablecode+="<td>지점</td>";
			tablecode+="<td>부서</td>";
			tablecode+="<td>대상</td>";
			tablecode+="<td>수신</td>";
			tablecode+="<td>표시율</td>";
			tablecode+="<td>대상</td>";
			tablecode+="<td>수신</td>";
			tablecode+="<td>표시율</td>";
			tablecode+="<td>대상</td>";
			tablecode+="<td>수신</td>";
			tablecode+="<td>표시율</td>";
			tablecode+="</tr>";
			
			var result=data.ablist;
			for(var i=0;i<result.length;i++){
				tablecode+="<tr>";
				tablecode+="<td>"+result[i].areaname+"</td>";
				tablecode+="<td>"+result[i].officename+"</td>";
				tablecode+="<td>"+result[i].departmentname+"</td>";
				
				tablecode+="<td>"+result[i].assetcount+"</td>";
				tablecode+="<td>"+result[i].assetrecevingcount+"</td>";
				var assetper=result[i].assetrecevingcount*1.0/result[i].assetcount*100;
				if(isNaN(assetper)){
					assetper=0;
				};
				
				tablecode+="<td>"+assetper.toFixed(2)+"%</td>";
				
				tablecode+="<td>"+result[i].notassetcount+"</td>";
				tablecode+="<td>"+result[i].notassetrecevingcount+"</td>";
				var notassetper=result[i].notassetrecevingcount*1.0/result[i].notassetcount*100;
				if(isNaN(notassetper)){
					notassetper=0;
				};
				
				tablecode+="<td>"+notassetper.toFixed(2)+"%</td>";
				
				var sumasset=result[i].assetcount*1+result[i].notassetcount;
				var sumreceving=result[i].assetrecevingcount*1+result[i].notassetrecevingcount;
				var sumper=sumreceving*1.0/sumasset*100;
				if(isNaN(sumper)){
					sumper=0;
				};
				
				
				
				tablecode+="<td>"+sumasset+"</td>";
				tablecode+="<td>"+sumreceving+"</td>";
				tablecode+="<td>"+sumper.toFixed(2)+"%</td>";
				
				tablecode+="</tr>";
			};
			
			var paging=data.paging;

			tablecode+="<tr>";
			tablecode+="<td colspan=6>"+paging.pagingHtml+"</td>";
			tablecode+="<td>"+paging.beginRow+"-"+paging.endRow+" of "+paging.totalCount+" items</td>"
			tablecode+="</tr>";
			
			
			
			tablecode+="</table>"
			
			$("#departmentDiv").html(tablecode);

		}
	});
}

function getRecordBySwDate(){
	var fixedDate=$('input[name=fixedDate]').val();
	$('#f').submit();
}
</script>

<%@ include file="../TopBottom/Bottom.jsp" %>