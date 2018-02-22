<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../TopBottom/Top.jsp"%>

<script>
$(document).ready(function(){
	officeView();
	$("option[value="+${bean.office_seq}+"]").attr("selected",true);
});

function officeView(){
	var area_seq=$("select[name=area_seq]").val();
	
	$.ajax({
		url:"getOfficeList.us",
		data:{area_seq:area_seq},
		success:function(data){
			$("select[name=office_seq]").html(data);
			departmentView();
		}
	})
	
}

</script>


	<div id="page-wrapper">
	
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">부서 수정</h1>
			</div>
		</div>
		
		
		<div class="row">
			<div class="col-lg-8">
				<div class="panel panel-primary">
					<div class="panel panel-heading">
						권역과 지점을 선택한 후 추가할 부서의 이름을 수정하세요
					</div>
					<div class="panel panel-body">
					<form action="UpdateDepartment.sc" method="post">
					<input type="hidden" name="department_seq" value="${bean.department_seq }">
						<table class=table>
							<tr>
								<td width=20%>권역</td>
								<td width=80%>
									<select name="area_seq" class="form-control" onchange="officeView()">
										<option value="default">선택</option>
										<c:forEach var="arealist" items="${arealist}">
											<c:choose>
												<c:when test="${bean.area_seq eq arealist.area_seq}">
													<option value="${arealist.area_seq}" selected>${arealist.areaname}</option>
												</c:when>
												<c:otherwise><option value="${arealist.area_seq}">${arealist.areaname}</option></c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td>지점</td>
								<td>
								<select name="office_seq" class="form-control">
								<option value="default">권역을 먼저 선택하세요</option>
								</select>
								</td>
							</tr>
							<tr>
								<td>부서</td>
								<td>
									<input type="text" name="departmentname" class="form-control" placeholder="부서명을 입력하세요" value="${bean.departmentname }">
								</td>
							</tr>
							<tr>
								<td colspan=2>
									<input type="submit" value="부서수정" class="btn btn-primary form-control">
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