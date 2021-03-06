<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../TopBottom/Top.jsp"%>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">현장 PC 운영 관리 화면</h1>
		</div>
	</div>
	<!-- 	<script type="text/javascript">
	
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
	</script> -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-primary">
				<div class="panel panel-heading">NetClient 조직별 정보 현황</div>
				<div class="panel panel-body">
					
						<form action="user.user" method="get" id="f">
							<div align="left">
							기준일자 <input type="date" name="swDate"
								onchange="getRecordBySwDate()" value="${swDate }"><br>
							</div>
							<div align="right">
								<select name="areaname" onchange="getArea()">
									<option value="">선 택</option>
									<c:forEach var="arealist" items="${arealist}">
									
										<option value="${arealist.areaname}"
										<c:if test="${areaname==arealist.areaname }">selected</c:if>
										>${arealist.areaname}
										
										
										</option>
									</c:forEach>
								</select>
							</div>
						</form>

						<script type="text/javascript">
							function getRecordBySwDate() {
								var swDate = $('input[name=swDate]').val();
								alert(swDate);
								$('#f').submit();
							}
							function getArea() {
								var areaname = $('select[name=areaname]').val();
								$('#f').submit();
							}
						</script>



					

					<table class="table table-bordered">
						<tr>
							<td colspan=3>구분</td>
							<td colspan=3>자산</td>
							<td colspan=3>비자산</td>
							<td colspan=3>합계</td>
						</tr>
						<tr>
							<td <%-- onclick="javascript:ftest('${list.swnumber}')"  --%>>권역</td>
							<td>지점</td>
							<td>부서</td>
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
						<c:forEach var="list" items="${list}">
							<tr>
								<td>${list.areaname }</td>
								<td>${list.officename}</td>
								<td>${list.departmentname}</td>
								<td>${list.assetdaesang}</td>
								<td>${list.assetreceive }</td>

								<td><c:if test="${list.assetreceive!=0 }">

										<fmt:formatNumber
											value="${list.assetreceive/list.assetdaesang }"
											type="percent"></fmt:formatNumber>
									</c:if></td>
								<td>${list.noassetdaesang}</td>
								<td>${list.noassetreceive}</td>
								<td><c:if test="${list.noassetreceive!=0 }">
										<fmt:formatNumber
											value="${list.noassetreceive/list.noassetdaesang }"
											type="percent"></fmt:formatNumber>
									</c:if></td>
								<td>${list.assetdaesang+list.noassetdaesang }</td>
								<td>${list.assetreceive + list.noassetreceive }</td>
								<td><c:if test="${list.assetreceive!=0 }">
										<fmt:formatNumber
											value="${(list.assetreceive+list.noassetreceive)/(list.assetdaesang+list.noassetdaesang)}"
											type="percent"></fmt:formatNumber>
									</c:if></td>

							</tr>
						</c:forEach>
						<tr>
							<td colspan=3>${paginghtml }</td>
							<td colspan=9 style="text-align: right;">${beginrow }-${endrow }
								of ${totalCount} items</td>
						</tr>
					</table>

				</div>
			</div>
		</div>
		<!-- 끝 -->

		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-yellow">
					<div class="panel panel-heading">NetClient 사용자 현황</div>
					<div class="panel panel-body">
						<div id="AllVersionDiv" style="width: 100%">

							<table class="table table-bordered table-striped">
								<tr>
									<td>선택되지 않았습니다</td>
								</tr>
							</table>

						</div>

					</div>
				</div>
			</div>
		</div>




	</div>

	<%@ include file="../TopBottom/Bottom.jsp"%>