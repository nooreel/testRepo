<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../TopBottom/Top.jsp"%>


	<div id="page-wrapper">
	
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">SW 등록</h1>
			</div>
		</div>
		
		<div class="row">
			<div class="col-lg-8">
				<div class="panel panel-primary">
					<div class="panel panel-heading">
						빈칸을 입력해주세요
					</div>
					<div class="panel panel-body">
						<form action="InsertSw.sw" method="post">
							<table class="table table-bordered">
								<tr>
									<td>SW명</td>
									<td><input type="text" name="swname" class="form-control"></td>
								</tr>
								<tr>
									<td>SW버전</td>
									<td><input type="text" name="swversion" class="form-control"></td>
								</tr>
								<tr>
									<td>SW타입</td>
									<td>
										<select name="swtype" class="form-control">
											<option value="표준SW">표준SW</option>
											<option value="Explorer">Explorer</option>
											<option value="OS">OS</option>
										</select>
									</td>
								</tr>
								<tr>
									<td>BIT</td>
									<td>
										<input type="radio" name="bit" value="x86"> x86 						
										<input type="radio" name="bit" value="x64"> x64
									</td>
								</tr>
								<tr>
									<td>제조사</td>
									<td><input type="text" name="maker" class="form-control"></td>
								</tr>
								<tr>
									<td>용도</td>
									<td><select name="used" class="form-control">
										<option value="그래픽">그래픽</option>
										<option value="전자출판">전자출판</option>
										<option value="개발/제작도구">개발/제작도구</option>
									</select></td>
								</tr>
								<tr>
									<td>보유수량</td>
									<td>
										<input type="number" name="quantity" class="form-control">
									</td>
								</tr>
								<tr>
									<td colspan=2>
										
										<input type="submit" value="수정하기" class="btn btn-primary">
									</td>
								</tr>
							</table>
						</form>
					</div>
				</div><!-- 패널 끝 -->
			</div><!-- col-lg-12끝  -->
		</div><!-- row 끝 -->
	</div><!-- #page-wrapper 끝 -->


<%@ include file="../TopBottom/Bottom.jsp"%>