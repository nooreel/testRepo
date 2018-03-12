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

<script src="http://code.jquery.com/jquery-1.12.0.js"></script>
<script>




function ajaxtest(){
	
	
	
	
	var name=$("input[name=userName]").val();
	var email=$("input[name=userEmail]").val();
	var num=$("input[name=userNum]").val();
	var birth=$("input[name=userBirth]").val();
	
	$.ajax({
		url:"pwFoundAuth.uf",
		data:{name:name,
			num:num,
			birth:birth,
			email:email
		},
		success: function(data) { 
		$("#resultdiv").html(data);
		$.ajax({
			url:"codecheck.uf",
			data:{pmt:pmt,num:num},
			success:function(data){
				$("#result2").html(data);
			}
		})
		
		}
	})
	
	if(name==""){
		alert("이름을 입력해주세요");
		return false;
	}if(birth==""){
		alert("생일을 입력해주세요");
		return false;
	}if(num==""){
		alert("사번을 입력해주세요");
		return false;
	}if(email==""){
		alert("이메일을 입력해주세요");
		return false;
	}
	
	
	
}


</script>


</head>

<body>

<div class="container">
<div id="result2"></div>

	<div id="resultdiv"></div>
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"> 비밀번호 찾기 </h3>
                    </div>
                    <div class="panel-body">
                    
                        <!-- <form action="pwFound.uf" method="post" target="w"> -->
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="이름을 입력하세요" name="userName" type="text" value="">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="사번을 입력하세요" name="userNum" type="text" value="">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="생년월일을 입력하세요" name="userBirth" type="date" value="">
                                </div>
                           
                                 <div class="form-group">
                                    <input class="form-control" placeholder="이메일을 입력하세요" name="userEmail" type="text" value="">
                                </div>
                            

                                
                                <!-- Change this to a button or input when using this as a form -->
                                 <input type="button" class="form-control" value="비밀번호 찾기" onclick="ajaxtest()" >
                                
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