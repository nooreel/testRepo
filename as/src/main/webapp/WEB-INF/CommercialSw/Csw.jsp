<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../TopBottom/Top.jsp"%>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">상용 소프트웨어 현황</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-primary">
				<div class="panel panel-heading">
				상용 소프트웨어 현황
				</div>
				<div class="panel panel-body">
				<form action="cswlist.csw" method="get" id="f">
				기준일자 <input type="date" name="fixedDate" onchange="getRecordByFixedDate()"  value="${fixedDate}"><br>	
				</form>
				
				<script>
				function getRecordByFixedDate(){
					$("#f").submit();
				}
				
				</script>
				
				<table class="table table-bordered">
					<tr>
							<td>제조사</td>
							<td>S/W제품명</td>
							<td>용도</td>
							<td>보유수량</td>
							<td>설치수량</td>
							<td>부족수량</td>
						</tr>
					<c:forEach var="csw" items="${cswlist}">
					
					<tr onclick="ftest('${csw.swnumber}')">
					
						<td>${csw.maker}</td>
						<td>${csw.swname}</td>
						<td>${csw.used}</td>
						<td>${csw.quantity}</td>
						<td>${csw.installquantity}</td>
						<td>${csw.quantity-csw.installquantity}</td>
						
					</tr>
					
					</c:forEach>
						<tr>
							<td colspan=4>${paginghtml }</td>
							<td colspan=4 style="text-align:right">
							${beginrow }-${endrow } of ${totalCount} items
							</td>
						</tr>
					
				</table>
				</div>
			</div>
		</div>
	</div> <!-- row끝 -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-red">
				<div class="panel panel-heading">
					상용 소프트웨어 사용내역	
				</div>
				<div class="panel panel-body" id="departmentDiv">
				
				</div>
						</div>
					</div>
				</div>
			</div>
				
				
				
				
				
<script>
function ftest(swname){
	alert("json테스트 들어옴"+swname);
	$.ajax({
		url:"cswDetailJson.csw",
		data:{swname:swname},
		dataType :"json",
		success:function(data){
			var tablecode="";
			tablecode+="<table class='table table-bordered'>";
			
			tablecode+="<tr>";
			tablecode+="<td>기관명</td>";
			tablecode+="<td>조직경로명</td>";
			tablecode+="<td>사번</td>";
			tablecode+="<td>사용자</td>";
			tablecode+="<td>직위</td>";
			tablecode+="<td>설치일자</td>";
			tablecode+="<td>장비ID</td>";
			tablecode+="<td>로컬IP</td>";
			tablecode+="</tr>";
			
			var result=data.cswlist;
			for(var i=0;i<result.length;i++){
				tablecode+="<tr>";
				tablecode+="<td>"+result[i].org+"</td>";
				tablecode+="<td>"+result[i].areaname+"/"+result[i].officename+"/"+result[i].departmentname+"</td>";
				tablecode+="<td>"+result[i].employeenumber+"</td>";
				tablecode+="<td>"+result[i].employeename+"</td>";
				tablecode+="<td>"+result[i].employeeposition+"</td>";
				tablecode+="<td>"+result[i].created+"</td>";
				tablecode+="<td>"+result[i].equipmentID+"</td>";
				tablecode+="<td>"+result[i].equipmentIP+"</td>";

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



function ftest2(swname,pageNumber){
alert("igii");
	$.ajax({
		url:"csDetailJson.csw",
		data:{swname:swname,pageNumber:pageNumber},
		dataType :"json",
		success:function(data){
			var tablecode="";
			tablecode+="<table class='table table-bordered'>";
			
			tablecode+="<tr>";
			tablecode+="<td>기관명</td>";
			tablecode+="<td>조직경로명</td>";
			tablecode+="<td>사번</td>";
			tablecode+="<td>사용자</td>";
			tablecode+="<td>직위</td>";
			tablecode+="<td>설치일자</td>";
			tablecode+="<td>장비ID</td>";
			tablecode+="<td>로컬IP</td>";
			tablecode+="</tr>";
			
			var result=data.cswlist;
			for(var i=0;i<result.length;i++){
				tablecode+="<tr>";
				tablecode+="<td>"+result[i].org+"</td>";
				tablecode+="<td>"+result[i].areaname+"/"+result[i].officename+"/"+result[i].departmentname+"</td>";
				tablecode+="<td>"+result[i].employeenumber+"</td>";
				tablecode+="<td>"+result[i].employeename+"</td>";
				tablecode+="<td>"+result[i].employeeposition+"</td>";
				tablecode+="<td>"+result[i].created+"</td>";
				tablecode+="<td>"+result[i].equipmentID+"</td>";
				tablecode+="<td>"+result[i].equipmentIP+"</td>";

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

function getRecordByPageNumber(swname){
	
	
	var pageNumber=$("input[name=pageNumber2]").val();
	
	alert(swname+"//"+pageNumber);
	
	$.ajax({
		url:"csDetailJson.csw",
		data:{swname:swname,pageNumber:pageNumber},
		dataType :"json",
		success:function(data){
			var tablecode="";
			tablecode+="<table class='table table-bordered'>";
			
			tablecode+="<tr>";
			tablecode+="<td>기관명</td>";
			tablecode+="<td>조직경로명</td>";
			tablecode+="<td>사번</td>";
			tablecode+="<td>사용자</td>";
			tablecode+="<td>직위</td>";
			tablecode+="<td>설치일자</td>";
			tablecode+="<td>장비ID</td>";
			tablecode+="<td>로컬IP</td>";
			tablecode+="</tr>";
			
			var result=data.cswlist;
			for(var i=0;i<result.length;i++){
				tablecode+="<tr>";
				tablecode+="<td>"+result[i].org+"</td>";
				tablecode+="<td>"+result[i].areaname+"/"+result[i].officename+"/"+result[i].departmentname+"</td>";
				tablecode+="<td>"+result[i].employeenumber+"</td>";
				tablecode+="<td>"+result[i].employeename+"</td>";
				tablecode+="<td>"+result[i].employeeposition+"</td>";
				tablecode+="<td>"+result[i].created+"</td>";
				tablecode+="<td>"+result[i].equipmentID+"</td>";
				tablecode+="<td>"+result[i].equipmentIP+"</td>";

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

<%@ include file="../TopBottom/Bottom.jsp"%>