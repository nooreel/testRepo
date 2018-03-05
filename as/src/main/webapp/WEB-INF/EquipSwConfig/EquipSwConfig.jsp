<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../TopBottom/Top.jsp"%>

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
				<h1 class="page-header">장비&소프트웨어 관리</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-primary">
				<div class="panel panel-heading">
					<table width="100%">
							<tr>
								<td width=80%>SW목록</td>
								<td width=20% align="right">
									<a href="SwRegist.sw" style="color:white;">Write</a>
								</td>
							</tr>
					</table>
				</div>
				<div class="pane panel-body">
						<table class="table table-bordered">
							<tr>
								<td>SW명</td>
								<td>SW버전</td>
								<td>SW타입</td>
								<td>BIT</td>
								<td>제조사</td>
								<td>용도</td>
								<td>보유수량</td>
								<td></td>
								<td></td>
							</tr>
						<c:forEach var="swlist" items="${swlist}">
							<tr>
								<td>${swlist.swname}</td>
								<td>${swlist.swversion}</td>
								<td>${swlist.swtype}</td>
								<td>${swlist.bit}</td>
								<td>${swlist.maker}</td>
								<td>${swlist.used}</td>
								<td>${swlist.quantity}</td>
								<td><a href="swUpdate.sw?swnumber=${swlist.swnumber}">Edit</a></td>
								<td><a href="swDelete.sw?swnumber=${swlist.swnumber}">Delete</a></td>
							</tr>
						</c:forEach>
						
							<tr>
								
								<td colspan=9 align=center>
									<form action="EquipSwConfig.es" method="get">
										<select name="whatColumn">
											<option value="swname">SW명</option>
											<option value="swtype">SW타입</option>
											<option value="maker">제조사</option>
										</select>
										<input type="text" name="keyword" style="width:60%;">
										<input type="hidden" name="pageNumber" value="${pageNumber}">
										<input type="hidden" name="swtype" value="${swtype}">
										<input type="submit" value="검색" class="btn btn-primary">
									</form>	
								</td>
							</tr>
						
							<tr>
								<td colspan=7 style="text-align:right">${swpagehtml}</td>
							</tr>
						</table>
				</div>
			</div><!-- panel 끝 -->
			<div class="panel panel-primary">
				<div class="panel panel-heading">
					장비목록
				</div>
				<div class="panel panel-body">
					<table class="table">
						<tr>
							<td>장비ID</td>
							<td>장비타입</td>
							<td>장비IP</td>
							<td>자산여부</td>
							<td>NClient 설치 여부</td>
							<td>담당자사번</td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<c:forEach var="eqlist" items="${eqlist}">
							<tr>
								<td>${eqlist.equipmentid}</td>
								<td>${eqlist.equipmenttype}</td>
								<td>${eqlist.equipmentip}</td>
								<td>
									<c:if test="${eqlist.assetyn==0}">
									자산
									</c:if>
									<c:if test="${eqlist.assetyn==1}">
									비자산
									</c:if>
								</td>
								<td>
									<c:if test="${eqlist.nclientsetup==0}">
									설치
									</c:if>
									<c:if test="${eqlist.nclientsetup==1}">
									미설치
									</c:if>
								</td>
								<td>${eqlist.employeenumber}</td>
								<td>
								<a href="EquipSwInsert.es?equipmentid=${eqlist.equipmentid}">
								SW등록하기
								</a>
								</td>
								<td>Edit</td>
								<td>Delete</td>
							</tr>
						</c:forEach>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div><!-- row 끝 -->
</div>

<%@ include file="../TopBottom/Bottom.jsp"%>