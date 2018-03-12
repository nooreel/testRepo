<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>삼성화재 현장 PC 운영 관리 화면</title>

    <!-- Bootstrap Core CSS -->
    <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="resources/vendor/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<link href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" rel="stylesheet">
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>


</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="goMain.mainpage">삼성화재 현장 PC 운영</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
            	<li>
            		<a href="EquipSwConfig.es">
            			<i class="fa fa-envelope fa-fw"></i>장비,SW관리
            		</a>
            	</li>
            	<li>
                    <a href="SwRegist.sw">
                        <i class="fa fa-envelope fa-fw"></i>소프트웨어 등록
                    </a>
                </li>
            	<li>
                    <a href="EquipmentRegist.eq">
                        <i class="fa fa-envelope fa-fw"></i>장비등록
                    </a>
                </li>
                <li>
                    <a href="SystemConfig.sc">
                        <i class="fa fa-envelope fa-fw"></i> 인사관리
                    </a>
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <c:choose>
                		<c:when test="${loginuser eq null}">
                		<a href="login.login">
                			<i class="fa fa-tasks fa-fw"></i>로그인
                		 </a>
                		</c:when>
                		<c:otherwise>
                		<a href="logOut.login">
                			<i class="fa fa-tasks fa-fw"></i>로그아웃
                			 </a>
                		</c:otherwise>
                	</c:choose>
                </li>
               
                <li>
                    <a href="UserInsertForm.us">
                        <i class="fa fa-user fa-fw"></i>사용자 등록
                    </a>
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="index.html"><i class="fa fa-dashboard fa-fw"></i> 메인화면</a>
                        </li>
                        <li>
                            <a href="NclientInfoByArea.ni"><i class="fa fa-bar-chart-o fa-fw"></i> 권역별 정보현황</a>
                        </li>
                        <li>
                            <a href="tables.html"><i class="fa fa-table fa-fw"></i>사용자현황</a>
                        </li>
                        <li>
                            <a href="forms.html"><i class="fa fa-edit fa-fw"></i>상용 소프트웨어 현황</a>
                        </li>
                        <li>
                        	<a href="WindowsPatch.wp"><i class="fa fa-edit fa-fw"></i>WINDOWS 패치 현황(상세)</a>
                        </li>
                        <li>
                            <a href="OSlist.os"><i class="fa fa-wrench fa-fw"></i>OS 설치 현황<span class="fa arrow"></span></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-sitemap fa-fw"></i> Explorer설치 현황<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="#">Second Level Item</a>
                                </li>
                                <li>
                                    <a href="#">Second Level Item</a>
                                </li>
                                <li>
                                    <a href="#">Third Level <span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                    </ul>
                                    <!-- /.nav-third-level -->
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="SwVersionManagement.stswtb"><i class="fa fa-files-o fa-fw"></i> 표준 SW 버전 현황<span class="fa arrow"></span></a>

                        </li>
                        <li>
                        	<a href="StandardSwTable.stswtb"><i class="fa fa-files-o fa-fw"></i>표준 SW 기준표<span class="fa arrow"></span></a>
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>