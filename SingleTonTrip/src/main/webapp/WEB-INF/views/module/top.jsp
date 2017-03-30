<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>싱글톤트립 - 여행혼자갈꺼야?</title>
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="./assets/img/base/logo.png">
	<link rel="icon" type="image/png" href="./assets/img/base/logo.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />

	<!--     Fonts and icons     -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />

	<!-- CSS Files -->
    <link href="./assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="./assets/css/material-kit.css" rel="stylesheet"/>
    <link href="./assets/css/demo.css" rel="stylesheet" />
    <link href="./css/hideimg.css" rel="stylesheet" />
    
    <!--   Core JS Files   -->
	<script src="./assets/js/jquery.min.js" type="text/javascript"></script>
	<script src="./assets/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="./assets/js/material.min.js"></script>

	<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
	<script src="./assets/js/nouislider.min.js" type="text/javascript"></script>

	<!--  Plugin for the Datepicker, full documentation here: http://www.eyecon.ro/bootstrap-datepicker/ -->
	<script src="./assets/js/bootstrap-datepicker.js" type="text/javascript"></script>

	<!-- Control Center for Material Kit: activating the ripples, parallax effects, scripts from the example pages etc -->
	<script src="./assets/js/material-kit.js" type="text/javascript"></script>

	<link href="./css/star-rating.css" rel="stylesheet" />
	<script src="./js/star-rating.js" type="text/javascript"></script>
	
	<script src="<c:url value='/js/imageView.js'/>"></script>
	<script src="<c:url value='/js/pageJs/groupAjax.js'/>"></script>
	<c:import url="/WEB-INF/views/page/group/groupList.jsp"></c:import>
	
	<script src="<c:url value='/js/pageJs/tripAjax.js'/>"></script>
	<c:import url="/WEB-INF/views/trip/tripApply.jsp"></c:import>
	<c:import url="/WEB-INF/views/page/trip/tripEnd.jsp"></c:import>
	
	<script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDI3-OfEdnYv_YcK0ZnIG-nGAk3WvnMAk4&&sensor=false"></script>
</head>

	
