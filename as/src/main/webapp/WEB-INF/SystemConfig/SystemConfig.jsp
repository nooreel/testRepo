<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="../TopBottom/Top.jsp" %>

<script type="text/javascript">
$(document).ready(function(){

	$('#areatable').DataTable({
		"scrollY":        "150px",
        "paging":         false,
        "searching":false,
        "ordering":false

	});
	
	$('#officetable').DataTable({
		"scrollY":        "150px",
        "paging":         false,
        "searching":false,
        "ordering":false
	});
	
	 
	$('#departmenttable').DataTable();
	$('#employeetable').DataTable();

	
});
function insertArea(){
	var areaname=prompt("권역의 이름을 입력하세요");
	
	$.ajax({
		url:"InsertArea.sc",
		data:{areaname:areaname},
		success:function(data){
			$("#areaA").html(data);
			location.reload();
		}
	});
}

function UpdateArea(area_seq){
	alert(area_seq);
	var areaname=prompt("수정할 이름을 입력해주세요");
	$.ajax({
		url:"UpdateArea.sc",
		data:{areaname:areaname,area_seq:area_seq},
		success:function(data){
			alert("수정 완료");
			location.reload();
		}
	});
	
}

</script>

	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">시스템 관리</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-6">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<table width="100%">
							<tr>
								<td width=80%>권역목록</td>
								<td width=20% align="right">
									<a href="#" onclick="insertArea()" style="color:white;">Write</a>
									<div id="areaA"></div>
								</td>
							</tr>
						</table>
					</div>
					<div class="panel-body">
						<table class="table table-border table-hover table-bordered" id="areatable" cellspacing="0" width="100%">
							<thead>
							<tr>
								<td width=60%>권역명</td>
								<td width=15%></td>
								<td width=15%></td>
							</tr>
							</thead>
							<tbody>
						<c:forEach items="${arealist}" var="arealist">
							<tr>
								<td>${arealist.areaname}</td>
								<td>
								<a href="#" onclick="UpdateArea('${arealist.area_seq}')">Edit</a>
								</td>
								<td>
								<a href="DeleteArea.sc?area_seq=${arealist.area_seq}">Delete</a>
								</td>
							</tr>
						</c:forEach>
							</tbody>
						</table>
					</div>
				</div> <!-- panel 끝 -->
			</div>	<!-- col-lg-4 끝 -->	
			<div class="col-lg-6">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<table width="100%">
							<tr>
								<td width=80%>지점목록</td>
								<td width=20% align="right">
									<a href="InsertOffice.sc" style="color:white;">Write</a>
									<div id="areaA"></div>
								</td>
							</tr>
						</table>
					</div>
					<div class="panel-body">
						<table class="table table-border table-hover table-bordered" id="officetable" cellspacing="0" width="100%">
							<thead>
							<tr>
								<td width=35%>권역명</td>
								<td width=35%>지점명</td>
								<td width=15%></td>
								<td width=15%></td>
							</tr>
							</thead>
							<tbody>
								<c:forEach items="${officelist}" var="officelist">
								<tr>
									<td>${officelist.areaname }</td>
									<td>${officelist.officename }</td>
									<td><a href="EditOffice.sc?office_seq=${officelist.office_seq }">Edit</a></td>
									<td><a href="DeleteOffice.sc?office_seq=${officelist.office_seq }">Delete</a></td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div> <!-- panel 끝 -->				
			</div>	<!-- col-lg-4 끝 -->		
		</div><!-- row 끝 -->
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<table width="100%">
							<tr>
								<td width=80%>부서목록</td>
								<td width=20% align="right">
									<a href="InsertDepartment.sc" style="color:white;">Write</a>
									<div id="areaA"></div>
								</td>
							</tr>
						</table>
					</div>
					<div class="panel-body">
						<table class="table table-border table-hover table-bordered" id="departmenttable" cellspacing="0" width="100%">
							<thead>
							<tr>
								<td width=28%>권역명</td>
								<td width=28%>지점명</td>
								<td width=28%>부서명</td>
								<td width=7%></td>
								<td width=7%></td>
							</tr>
							</thead>
							<tbody>
								<c:forEach items="${departmentlist}" var="departmentlist">
								<tr>
									<td>${departmentlist.areaname }</td>
									<td>${departmentlist.officename }</td>
									<td>${departmentlist.departmentname}</td>
									<td><a href="UpdateDepartment.sc?department_seq=${departmentlist.department_seq}">Edit</a></td>
									<td><a href="deleteDepartment.sc?department_seq=${departmentlist.department_seq}">Delete</a></td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div> <!-- panel 끝 -->	
			</div>
		</div><!-- row 끝 -->
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-yellow">
					<div class="panel-heading">
						사원 목록
					</div>
					<div class="panel-body">
						<table id="employeetable" class="table table-hover table-bordered" cellspacing="0" width="100%">
							<thead>
								<tr>
									<td>권역명</td>
									<td>지점명</td>
									<td>부서명</td>
									<td>사번</td>
									<td>생년월일</td>
									<td>사원명</td>
									<td>직위</td>
									<td></td>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="employeelist" items="${employeelist}">
									<tr>
										<td>${employeelist.areaname}</td>
										<td>${employeelist.officename}</td>
										<td>${employeelist.departmentname}</td>
										<td>${employeelist.employeenumber}</td>
										<td>${employeelist.birth}</td>
										<td>${employeelist.employeename}</td>
										<td>${employeelist.employeeposition}</td>
										<td>
											<a href="EmployeeDelete.sc?employeenumber=${employeelist.employeenumber}">Delete</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div> <!-- panel 끝 -->
			</div>
		</div><!-- row 끝 -->
	
	<!-- #page-wrapper 끝 -->
	</div>


<%@ include file="../TopBottom/Bottom.jsp" %>