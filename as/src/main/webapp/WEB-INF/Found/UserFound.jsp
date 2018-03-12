<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%@ include file="../TopBottom/Top.jsp" %>

<head>


    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">


 <!-- Bootstrap Core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">


<script>
function inputcheck(){

	
	if($("input[name='userBirth']").val()==""){
		alert("입력한 정보와 일치하는 회원이 없습니다");
		return false;
	}

}

</script>


</head>

<body>


    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
            
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"> 사번 찾기 </h3>
                    </div>
                    <div class="panel-body">
                        <form action="userFound.uf" method="post">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="이름을 입력하세요" name="userName" type="text" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="생년월일을 입력하세요" name="userBirth" type="date" value="">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="이메일을 입력하세요" name="userEmail" type="text" value="">
                                </div>
                            
                                    <label>

                                         <input type="reset" value="초기화"/>
                                       
                                    </label>
                                
                                <!-- Change this to a button or input when using this as a form -->
                                 <input type="submit" class="form-control" value="사번 찾기" onclick="return inputcheck();">

                                 <c:if test="${msg == 'failure'}">
                                 <div style="color:black">
                                 <center>
                                 이름, 생년월일, 이메일을 다시 입력해주세요.
                                 </center>
                                 </div>
                                 </c:if>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>


</div>
</body>
</html>


 <%@ include file="../TopBottom/Bottom.jsp" %>
