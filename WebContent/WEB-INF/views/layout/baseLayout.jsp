<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<spring:url value="/resources/js/jquery.min.js" var="jqueryJS"></spring:url>
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCSS"></spring:url>
<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJS"></spring:url>
<spring:url value="/resources/js/jquery-dateformat.min.js" var="dateformatJS"></spring:url>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute></title>
<script type="text/javascript" src="${jqueryJS}"></script>
<link href="${bootstrapCSS}" rel="stylesheet"/>
<script type="text/javascript" src="${bootstrapJS}"></script>
<script type="text/javascript" src="${dateformatJS}"></script>
</head>
<body>
	<div style="width: 100%">
		<tiles:insertAttribute name="header" ignore="false"></tiles:insertAttribute>
	</div>
	<div style="width: 100%; margin:2%;">
		<tiles:insertAttribute name="body" ignore="false"></tiles:insertAttribute>
	</div>
	<div style="width: 100%">
		<tiles:insertAttribute name="footer" ignore="false"></tiles:insertAttribute>
	</div>
</body>
</html>