<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>


<%@ include file="../TopBottom/Top.jsp" %>
<title>비밀번호 찾기</title>
<script type="text/javascript">


function pwchk(){
	
	var auth=$("input[name=authPW]").val();
	var auth2=$("input[name=authPW2]").val();
	
	if(auth!=auth2){
		alert("비밀번호를 확인해 주세요");
		return false;
	}
	
	alert("비밀번호가 변경되었습니다");
	
	
}
</script>
</head>
<body>

<div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"> 새 비밀번호 입력 </h3>
                    </div>
                    <div class="panel-body">
                    
                        <!-- <form action="pwFound.uf" method="post" target="w"> -->
                            <fieldset>
                            	<form action="pwAuth.uf" method="post">
                                <div class="form-group">
                                    <input class="form-control" placeholder="새 비밀번호 입력" name="authPW" type="password" value="">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="새 비밀번호 확인" name="authPW2" type="password" value="">
                                </div>

								<input type="hidden" name="empnum" value="${empnum}">
								<input type="submit" class="form-control" value="비밀번호 변경" onclick="return pwchk();">
                                </form>
                            </fieldset>
                       <!--  </form> -->
                    </div>
                </div>
            </div>
        </div>
</div>
</div>

  


    <!-- jQuery -->
    <script src="../vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>

</body>


</html>

<%@ include file="../TopBottom/Bottom.jsp" %>