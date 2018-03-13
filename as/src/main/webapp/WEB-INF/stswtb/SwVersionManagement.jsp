<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../TopBottom/Top.jsp"%>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">
				표준 SW 버전 관리
			</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-primary">
				<div class="panel panel-heading">
					표준 SW 등록현황
				</div>
				<div class="panel panel-body">
				<form action="SwVersionManagement.stswtb" method="get" id="f">
				기준일자 <input type="date" name="swDate" onchange="getRecordBySwDate()" value="${swDate }"><br>	
				</form>
				
<script>


function getRecordBySwDate(){
	var swDate=$('input[name=swDate]').val();
	alert(swDate);
	$('#f').submit();
}

function ftest(swname){
	alert("swname은 "+swname);
	
	$.ajax({
		url:"GetSwAllVersion.stswtb",
		data:{swname:swname},
		success:function(data){
			$("#AllVersionDiv").html(data);
			
			}
	})
}
function ftest2(swname,pageNumber){
	alert("pageNumber "+pageNumber);
	
	$.ajax({
		url:"GetSwAllVersion.stswtb",
		data:{swname:swname,pageNumber:pageNumber},
		success:function(data){
			$("#AllVersionDiv").html(data);
			
			}
	})
}



</script>
					<table class="table table-striped table-bordered">
						<tr>
							<td rowspan=2>S/W명</td>
							<td colspan=3>자산</td>
							<td colspan=3>비자산</td>
						</tr>
						<tr>
							<td>대상</td>
							<td>설치</td>
							<td>율</td>
							<td>대상</td>
							<td>설치</td>
							<td>율</td>
						</tr>
					<c:forEach var="s" items="${swlist}">
						<tr onclick="javascript:ftest('${s.swname}')">
						<td>${s.swname}</td>
						<td>${s.assetdaesang}</td>
						<td>${s.assetsetupcount}</td>
						<td>${s.assetsetupcount/s.assetdaesang*100 }%</td>
						<td>${s.notassetdaesang}</td>
						<td>${s.notassetsetupcount}</td>
						<td>${s.notassetsetupcount/s.notassetdaesang*100 }%</td>
						</tr>
					</c:forEach>
						<tr>
						<td colspan=3>${paginghtml }</td>
						<td colspan=4 style="text-align:right;">${beginrow }-${endrow } of ${totalCount} items</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div> <!-- row 끝 -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-yellow">
				<div class="panel panel-heading">
				표준 SW 버전별 현황
				</div>
				<div class="panel panel-body">
				<div id="AllVersionDiv" style="width:100%">
				
				<table class="table table-bordered table-striped" >
					<tr>
						<td>SW가 선택되지 않았습니다</td>
					</tr>	
				</table>
				
				</div>
				
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="../TopBottom/Bottom.jsp"%>