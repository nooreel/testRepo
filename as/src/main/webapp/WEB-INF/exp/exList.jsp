<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../TopBottom/Top.jsp"%>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Explorer 설치 현황</h1>
		</div>
	</div>
	<script type="text/javascript">
	
	function ftest(swnumber){
		alert("swnumber은 "+swnumber);
		
		$.ajax({
			url:"exDetail.exp",
			data:{swnumber:swnumber},
			success:function(data){
				$("#AllVersionDiv").html(data);
				
				}
		})
	}
	function ftest2(swnumber,pageNumber){
		alert("swnumber은 "+swnumber);
		
		$.ajax({
			url:"exDetail.exp",
			data:{swnumber:swnumber,pageNumber:pageNumber},
			success:function(data){
				$("#AllVersionDiv").html(data);
				
				}
		})
	}
	
	function getRecordByPageNumber(swnumber){
		var pageNumber=$("input[name=pageNumber2]").val();
		$.ajax({
			url:"exDetail.exp",
			data:{swnumber:swnumber,pageNumber:pageNumber},
			success:function(data){
				$("#AllVersionDiv").html(data);
				alert("Ajax끝남");		
				}
		})
	}
	</script>
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-primary">
				<div class="panel panel-heading">Explorer 설치 현황</div>
				<div class="panel panel-body">
				<form action="explorer.exp" method="get" id="f">
				기준일자 <input type="date" name="swDate" onchange="getRecordBySwDate()" value="${swDate }"><br>	
				</form>
				
				<script type="text/javascript">
					function getRecordBySwDate(){
						
						var swDate=$('input[name=swDate]').val();
						alert(swDate);
						$('#f').submit();
						
					}
				
				
				
				
				</script>
				
					<table class="table table-bordered">
						<tr>
							<td rowspan=2>Explorer</td>
							<td colspan=3>자산</td>
							<td colspan=3>비자산</td>
							<td colspan=3>합계</td>
						</tr>
						<tr>
							<td>설치수량</td>
							<td>PC</td>
							<td>NoteBook</td>
							<td>설치수량</td>
							<td>PC</td>
							<td>NoteBook</td>
							<td>설치수량</td>
							<td>PC</td>
							<td>NoteBook</td>
						</tr>
						<c:forEach var="list" items="${list}">
							<tr onclick="javascript:ftest('${list.swnumber}')">
								<td>${list.swversion }</td>
								<td>${list.assetsetupcount}</td>
								<td>${list.assetsetuppc }</td>
								<td>${list.assetsetupcount-list.assetsetuppc }</td>
								<td>${list.noassetsetupcount}</td>
								<td>${list.noassetsetuppc}</td>
								<td>${list.noassetsetupcount-list.noassetsetuppc}</td>
								<td>${list.assetsetupcount+list.noassetsetupcount}</td>
								<td>${list.assetsetuppc+list.noassetsetuppc}</td>
								<td>${(list.assetsetupcount-list.assetsetuppc)+(list.noassetsetupcount-list.noassetsetuppc) }</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan=3>${paginghtml }</td>
							<td colspan=7 style="text-align: right;">${beginrow }-${endrow }
								of ${totalCount} items</td>
						</tr>
					</table>

			</div>
		</div>
	</div> <!-- 끝 -->
	
		<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-yellow">
				<div class="panel panel-heading">
				Explorer 설치 상세내역
				</div>
				<div class="panel panel-body">
				<div id="AllVersionDiv" style="width:100%">
				
				<table class="table table-bordered table-striped" >
					<tr>
						<td>Explorer가 선택되지 않았습니다</td>
					</tr>	
				</table>
				
				</div>
				
				</div>
			</div>
		</div>
	</div>
	
	
	
	
</div>

<%@ include file="../TopBottom/Bottom.jsp"%>
