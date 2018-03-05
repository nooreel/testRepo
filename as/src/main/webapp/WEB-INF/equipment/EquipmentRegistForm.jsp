<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../TopBottom/Top.jsp"%>

	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">장비 등록하기</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-primary">
					<div class="panel panel-heading">
						빈칸을 입력해주세요
					</div>
					<div class="panel panel-body">
					<form action="EquipmentRegist.eq" method="post">
						<table class="table table-bordered">
							<tr>
								<td>장비ID</td>
								<td><input type="text" name="equipmentid" class="form-control"></td>
								<td><input type="button" value="중복검사" class="btn btn-danger"></td>
							</tr>
							<tr>
								<td>장비타입</td>
								<td>
									PC<input type="radio" name="equipmenttype" value="pc" class="radio-inline">
									노트북<input type="radio" name="equipmenttype" value="노트북" class="radio-inline">
								</td>
							</tr>
							<tr>
								<td>장비IP</td>
								<td>
									<input type="text" name="equipmentip" class="form-control">
								</td>
							</tr>
							<tr>
								<td>자산여부</td>
								<td>
									자산 <input type="radio" name="assetyn" value="0" class="radio-inline">
									비자산<input type="radio" name="assetyn" value="1" class="radio-inline">
								</td>
							</tr>
							<tr>
								<td>Nclient설치 여부</td>
								<td>
									설치<input type="radio" name="nclientsetup" value="0" class="radio-inline">
									미설치<input type="radio" name="nclientsetup" value="1" class="radio-inline">
								</td>
							</tr>
							<tr>
								<td>사번</td>
								<td>
									<input type="text" name="employeenumber" class="form-control" value="${loginuser.employeenumber}" readonly>
								</td>
							</tr>
							<tr>
								<td colspan=3>
									<input type="submit" value="장비 등록하기" class="btn btn-danger">
								</td>
							</tr>
						</table>
					</form>	
					</div>
				</div><!-- panel 끝 -->
			</div>
		</div> <!-- row 끝 -->
	</div>

<%@ include file="../TopBottom/Bottom.jsp"%>
