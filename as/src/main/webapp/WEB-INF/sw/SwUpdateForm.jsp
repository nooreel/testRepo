<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../TopBottom/Top.jsp"%>

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">SW수정하기</h1>
		</div>
	</div>
	<div class="row">
			<div class="col-lg-8">
				<div class="panel panel-primary">
					<div class="panel panel-heading">
						빈칸을 입력해주세요
					</div>
					<div class="panel panel-body">
						<form action="swUpdate.sw" method="post">
							<table class="table table-bordered">
								<tr>
									<td>SW명</td>
									<td><input type="text" name="swname" class="form-control" value="${swbean.swname }"></td>
								</tr>
								<tr>
									<td>SW버전</td>
									<td><input type="text" name="swversion" class="form-control" value="${swbean.swversion }"></td>
								</tr>
								<tr>
									<td>SW타입</td>
									<td>
										<select name="swtype" class="form-control">
											<option value="표준SW"
											<c:if test="${swbean.swtype eq '표준SW' }">selected</c:if>
											>표준SW</option>
											<option value="Explorer"
											<c:if test="${swbean.swtype eq 'Explorer' }">selected</c:if>											
											>Explorer</option>
											<option value="OS"
											<c:if test="${swbean.swtype eq 'OS' }">selected</c:if>
											>OS</option>
										</select>
									</td>
								</tr>
								<tr>
									<td>BIT</td>
									<td>
										<input type="radio" name="bit" value="x86" 
										<c:if test="${swbean.bit eq 'x86' }">checked</c:if>
										> x86 						
										<input type="radio" name="bit" value="x64"
										<c:if test="${swbean.bit eq 'x64' }">checked</c:if>
										> x64
									</td>
								</tr>
								<tr>
									<td>제조사</td>
									<td><input type="text" name="maker" class="form-control" value="${swbean.maker }"></td>
								</tr>
								<tr>
									<td>용도</td>
									<td><select name="used" class="form-control">
										<option value="그래픽"
										<c:if test="${swbean.used eq '그래픽'}">checked</c:if>
										>그래픽</option>
										<option value="전자출판"
										<c:if test="${swbean.used eq '전자출판'}">checked</c:if>
										>전자출판</option>
										<option value="개발/제작도구"
										<c:if test="${swbean.used eq '개발/제작도구'}">checked</c:if>
										>개발/제작도구</option>
									</select></td>
								</tr>
								<tr>
									<td>보유수량</td>
									<td>
										<input type="number" name="quantity" class="form-control" value="${swbean.quantity }">
									</td>
								</tr>
								<tr>
									<td colspan=2 style="text-align:center;">
										<input type="hidden" value="${swbean.swnumber }" name="swnumber">
										<input type="submit" value="수정하기" class="btn btn-primary">
									</td>
								</tr>
							</table>
						</form>
					</div>
				</div><!-- 패널 끝 -->
			</div><!-- col-lg-12끝  -->
		</div><!-- row 끝 -->
</div>

<%@ include file="../TopBottom/Bottom.jsp"%>