<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotel Management System</title>
<style>
            #form{
                background-color: black;
                opacity: 0.9;
                width: 500px;
                height: 350px;
                position: absolute;
                left: 500px;
                top: 273px;
                right: 500px;
                bottom: 367px;
                font-size: 20px;
            }
            #title{
                background-color: black;
                opacity: 0.9;
                width: auto;
                height: 170px;
                position: absolute;
                top:0.1px;
                left: 0px;
                right: 0px;
                font-size: 28px;
            }
        </style>
</head>
<body align="center" background="<c:url value="/images/hotel.jpg"/>" style="color:white">
    <div id="title">
            <h1>Hotel Management System</h1>
        </div>
    <div id="form">
        <br>
<form action="index.jsp" method="post">
<img src="<c:url value="/images/smile.jpg"/>" height="80" width="100" />
<h1>Oops!!!! Something Went Wrong....</h1><br>
<input type="submit" value="Try Again" style="width:170px;height:30px;color:red;">
</form>
</div>
</body>
</html>