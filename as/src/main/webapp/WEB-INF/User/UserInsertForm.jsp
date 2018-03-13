<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../TopBottom/Top.jsp"%>

<script>
var chkresult=false;
var chkyes=false;


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

function departmentView(){
	var office_seq=$("select[name=office_seq").val();
	$.ajax({
		url:"getDepartmentList.us",
		data:{office_seq:office_seq},
		success:function(data){
			$("select[name=department_seq]").html(data);
		}
	})
	
}

function employeeNumberCheck(){
	var employeenumber=$("input[name=employeenumber]").val();
	$.ajax({
		url:"employeeNumberCheck.us",
		data:{employeenumber:employeenumber},
		success:function(data){
			chkyes=true;
			$("#numberTestResult").text(data);
			if(data=="사용 가능한 사번입니다"){
				chkresult=true;
			}else{
				chkresult=false;
				chkyes=false;
			}
			
		}
	})
}



function validationTest(){
	
	if(chkresult==false||chkyes==false){
		alert("사번검사를 통과하지 않았습니다");
		return false;
	}
	if($("input[name=employeenumber]").val()==""){
		alert("사번을 입력하지 않았습니다");
		return false;
	}
	if($("input[name=password]").val()==""){
		alert("비밀번호를 입력하지 않았습니다");
		return false;
	}
	if($("input[name=employeename]").val()==""){
		alert("이름을 입력하지 않았습니다");
		return false;
	}
	if($("select[name=employeeposition]").val()=="default"){
		alert("직위를 선택하지 않았습니다");
		return false;
	}
	if($("input[name=email]").val()==""){
		alert("이메일을 입력하지 않았습니다");
		return false;
	}
	if($("input[name=birth]").val()==""){
		alert("생년월일을 입력하지 않았습니다");
		return false;
	}
	if($("select[name=area_seq]").val()=="default"){
		alert("권역을 선택하지 않았습니다");
		return false;
	}
	if($("select[name=office_seq]").val()=="default"){
		alert("권역을 선택하지 않았습니다");
		return false;
	}
	if($("select[name=department_seq]").val()=="default"){
		alert("권역을 선택하지 않았습니다");
		return false;
	}
	
	
}

</script>


	<div id="page-wrapper">
	
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">사용자 등록</h1>
			</div>
		</div>
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						빈 칸을 채워주세요
					</div>
					<div class="panel-body">
					<form action="#" method="post">
					<table class="table">
						<tr>
							<td>사번</td>
							<td><input type="text" name="employeenumber" class="form-control" placeholder="정확한 사번을 입력해주세요"></td>
							<td><input type="button" class="btn btn-primary" onclick="employeeNumberCheck()" value="사번검사"></button>
							&nbsp&nbsp&nbsp<span id="numberTestResult">아이디를 입력해주세요</sapn>
							</td>
						</tr> 
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="password" class="form-control"></td>
							<td>비밀번호를 입력해주세요</td>
						</tr> 
						<tr>
							<td>이름</td>
							<td><input type="text" name="employeename" class="form-control"></td>
							<td>이름을 입력해주세요</td>
						</tr>
						<tr>
							<td>직위</td>
							<td colspan=2>
								<select name="employeeposition" class="form-control">
									<option value="default" selected>선택</option>
									<option value="사장">사장</option>
									<option value="부장">부장</option>
									<option value="차장">차장</option>
									<option value="사원">사원</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>이메일</td>
							<td><input type="email" name="email" class="form-control"></td>
							<td>이메일을 입력해주세요</td>
						</tr>
						<tr>
							<td>생년월일</td>
							<td><input type="date" name="birth" class="form-control"></td>
							<td>생년월일을 입력해주세요</td>
						</tr>
						<tr>
							<td width=33%>권역
							<select name="area_seq" class="form-control" onchange="officeView()">
								<option value="default" selected>선택</option>
							<c:forEach items="${areaList }" var="areaList">
								<option value="${areaList.area_seq }">${areaList.areaname }</option>
							</c:forEach>
							</select>
							</td>
							<td width=33%>지점
							<select name="office_seq" class="form-control" onchange="departmentView()">
							<option value="default">권역을 선택해주세요</option>
							</select>
							</td>
							<td width=33%>부서
							<select name="department_seq" class="form-control">
							<option value="default">지점을 선택해주세요</option>
							</select>
							</td>
						</tr>
						<tr>
							<td>권한</td>
							<td>
							<select name="privilege" class="form-control">
							<option value="1" selected>시스템관리자</option>
							<option value="2">일반사용자</option>
							</select>
							</td>
						</tr>
						<tr>
							<td align="center" colspan=3>
								<input type="submit" value="사용자 등록" class="btn btn-primary" onclick="return validationTest();">
								<input type="reset" value="초기화" class="btn" >
							</td>
						</tr>
					</table>
					</form>
					</div>
				</div><!-- panel 끝 -->
			</div><!-- col-lg-12끝  -->
		</div><!-- row 끝 -->
	</div><!-- #page-wrapper 끝 -->

<%@ include file="../TopBottom/Bottom.jsp"%>