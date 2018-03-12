<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../TopBottom/Top.jsp"%>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Windows패치현황</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-primary">
				<div class="panel panel-heading">
				<table width=100%>
					<tr>
						<td>Windows 패치 현황</td>
						<td align="right">
				<form action="WindowsPatch.wp" method="get" id="f">
				기준일자 <input type="date" name="fixedDate" onchange="getRecordBySwDate()" value="${fixedDate}"><br>	
				</form>
				</td>
					</tr>
				</table>
				</div>
				
				<div class="panel panel-body">
					<table class="table table-bordered">
						<tr>
							<td>OS명</td>
							<td>대상수</td>
							<td>100%</td>
							<td>99%~90%</td>
							<td>89%~70%</td>
							<td>69%~50%</td>
							<td>49% 이하</td>
						</tr>
						<c:forEach var="w" items="${windowslist}">
							<tr onclick="ftest('${w.swnumber}')">
								<td>${w.swname }</td>
								<td>${w.windowscount }</td>
								<td>${w.perfect}</td>
								<td>${w.great}</td>
								<td>${w.good}</td>
								<td>${w.notbad}</td>
								<td>${w.bad}</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan=4>${paginghtml}</td>
							<td colspan=3 style="text-align:right">${beginrow }-${endrow } of ${totalCount} items</td>
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
					Windows 사용자 패치 현황
				</div>
				<div class="panel panel-body" id="WindowsUserListDiv">
					상단 테이블에서 사용자 현황을 조회하고픈 Windows를 선택해주세요
				</div>
			</div>
		</div>
	</div>
</div>


<script>
function getRecordBySwDate(){
	var fixedDate=$('input[name=fixedDate]').val();
	$('#f').submit();
}

function ftest(swnumber){
	 $.ajax({
		url:"WindowsPatchUserList.wp",
		data:{swnumber:swnumber},
		success:function(data){
			$("#WindowsUserListDiv").html(data);
			}
	}) 
}
function ftest2(swnumber,pageNumber){
	alert("ftest2 들어옴");
	
	 $.ajax({
		url:"WindowsPatchUserList.wp",
		data:{swnumber:swnumber,pageNumber:pageNumber},
		success:function(data){
			$("#WindowsUserListDiv").html(data);
			
			}
	}) 
}

function getRecordByPageNumber(swnumber){
	alert("함수 실행");
	var pageNumber=$("input[name=pageNumber2]").val();
	alert("pageNumber: "+pageNumber);
	 $.ajax({
			url:"WindowsPatchUserList.wp",
			data:{swnumber:swnumber,pageNumber:pageNumber},
			success:function(data){
				$("#WindowsUserListDiv").html(data);
				
				}
		}) 
}
</script>

<%@ include file="../TopBottom/Bottom.jsp"%>