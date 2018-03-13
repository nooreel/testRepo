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
						기준일자 <input type="date" name="fixedDate" onchange="getRecordBySwDate()" value="${fixedDate}"><br>	
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
									<td>${n.assetrecevingcount/n.assetcount*100}%</td>
								</c:if>
									<td>${n.notassetcount}</td>
									<td>${n.notassetrecevingcount}</td>
								<c:if test="${n.notassetcount==0}">
									<td>0%</td>
								</c:if>
								<c:if test="${n.notassetcount!=0 }">
									<td>${n.notassetrecevingcount/n.notassetcount*100}%</td>
								</c:if>
									<td>${n.assetcount+n.notassetcount}</td>
									<td>${n.assetrecevingcount+n.notassetrecevingcount}</td>
								<c:if test="${n.assetrecevingcount+n.notassetrecevingcount==0}">
									<td>0%</td>
								</c:if>	
								<c:if test="${n.assetrecevingcount+n.notassetrecevingcount!=0}">	
									<td>${(n.assetrecevingcount+n.notassetrecevingcount)/(n.assetcount+n.notassetcount)*100}%</td>
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
	alert("area_seq는 "+area_seq);
	
	 $.ajax({
			url:"NclientInfoByAreaToDepartment.ni",
			data:{area_seq:area_seq},
			success:function(data){
				$("#departmentDiv").html(data);
				}
		}) 
	
}

function ftest2(area_seq,pageNumber){
	alert("ftest2 area_seq는 "+area_seq);	
	 $.ajax({
			url:"NclientInfoByAreaToDepartment.ni",
			data:{area_seq:area_seq,pageNumber:pageNumber},
			success:function(data){
				$("#departmentDiv").html(data);
				}
		}) 
	
}

function getRecordByPageNumber(area_seq){
	alert("레코드바이페이지넘버 area_seq는 "+area_seq);	
	
	var pageNumber=$("input[name=pageNumber2]").val();
	 $.ajax({
			url:"NclientInfoByAreaToDepartment.ni",
			data:{area_seq:area_seq,pageNumber:pageNumber},
			success:function(data){
				$("#departmentDiv").html(data);
				}
		}) 
}

function getRecordBySwDate(){
	var fixedDate=$('input[name=fixedDate]').val();
	$('#f').submit();
}
</script>

<%@ include file="../TopBottom/Bottom.jsp" %>