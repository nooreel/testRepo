<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../TopBottom/Top.jsp"%>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">OS 설치 현황</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-primary">
				<div class="panel panel-heading">
				OS 설치 현황
				</div>
				<div class="panel panel-body">
				<form action="OSlist.os" method="get" id="f">
				기준일자 <input type="date" name="fixedDate" onchange="getRecordByFixedDate()"  value="${fixedDate }"><br>	
				</form>
				
				<script>
				function getRecordByFixedDate(){
					$("#f").submit();
				}
				
				</script>
				
				<table class="table table-bordered">
					<tr>
						<td rowspan=2>OS명</td>
						<td colspan=3>자산</td>
						<td colspan=3>비자산</td>
					</tr>
					<tr>
						<td>설치수량</td>
						<td>PC</td>
						<td>NoteBook</td>
						<td>설치수량</td>
						<td>PC</td>
						<td>NoteBook</td>
					</tr>
					<c:forEach var="o" items="${oslist}">
					
					<tr>
					
						<td><a href="OSlist.os?fixedDate=${fixedDate}&pageNumber=${pageNumber}&swnumber=${o.swnumber}">
						${o.swname}</a></td>
						<td>${o.assetcount}</td>
						<td>${o.assetcountpc}</td>
						<td>${o.assetcount-o.assetcountpc}</td>
						<td>${o.notassetcount}</td>
						<td>${o.notassetcountpc}</td>
						<td>${o.notassetcount-o.notassetcountpc}</td>
						
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
					OS 설치 상세 현황
					
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
							<td>S/W명</td>
							<td>권역</td>
							<td>지점</td>
							<td>부서</td>
							<td>사용자</td>
							<td>장비종류</td>
							<td>장비ID</td>
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