<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../TopBottom/Top.jsp"%>

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">표준SW기준표</h1>			
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel panel-heading">
				표준 SW 기준 현황
				</div>
				<div class="panel panel-body">
				<form action="StandardSwTable.stswtb" method="get" id="f">
				기준일자 <input type="date" name="swDate" onchange="getRecordBySwDate()" value="${swDate }"><br>
					
				</form>
<script>
function getRecordBySwDate(){
	var swDate=$('input[name=swDate]').val();
	alert(swDate);
	$('#f').submit();
}


</script>
				
				
				<table class="table table-striped">
					<tr>
						<td width="15%">프로그램번호</td>
						<td width="40%">프로그램명</td>
						<td width="15%">BIT</td>
						<td width="30%">Version</td>
					</tr>
					<c:forEach var="s" items="${swlist}" >
						<tr>
							<td>${s.swnumber }</td>
							<td>${s.swname }</td>
							<td>${s.bit }</td>
							<td>${s.swversion }</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan=2>${paginghtml }</td>
						<td colspan=2 style="text-align:right;">${beginrow }-${endrow } of ${totalCount} items</td>
					</tr>
				</table>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="../TopBottom/Bottom.jsp"%>