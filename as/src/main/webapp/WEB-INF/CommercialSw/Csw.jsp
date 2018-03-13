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
					
					<tr>
					
						<td><a href="cswlist.csw?fixedDate=${fixedDate}&pageNumber=${pageNumber}">
						${csw.maker}</a></td>
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
				<div class="panel panel-body">
					<table class="table table-borderd">
					<c:if test="${osdetaillist==null }">
						<tr>
							<td>OS설치현황 테이블에서 OS를 선택해주세요</td>
						</tr>
					</c:if>
					<c:if test="${osdetaillist!=null }">
						<tr>
							<td>기관명</td>
							<td>조직경로명</td>
							<td>사번</td>
							<td>사용자</td>
							<td>직위</td>
							<td>설치일자</td>
							<td>장비ID</td>
							<td>로컬IP</td>
						</tr>
						<c:forEach var="osd" items="${osdetaillist}">
							<tr>
								<td>${osd.swname}</td>
								<td>${osd.areaname }</td>
								<td>${osd.officename }</td>
								<td>${osd.departmentname }</td>
								<td>${osd.employeename }</td>
								<td>${osd.equipmenttype }</td>
								<td>${osd.equipmentid}</td>
							</tr>
						</c:forEach>
							<tr>
							<td colspan=4>${detailpaginghtml }</td>
							<td colspan=4 style="text-align:right">
							${detailbeginrow }-${detailendrow} of ${detailtotalCount} items
							</td>
						</tr>
					</c:if>
					</table>
					
					
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="../TopBottom/Bottom.jsp"%>