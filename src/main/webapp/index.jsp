<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hotel Management System</title>
        <style>
            #form{
                background-color: black;
                opacity: 0.9;
                width: 550px;
                height: 217px;
                position: absolute;
                left:500px; 
                top: 273px;
                right: 500px;
                bottom: 367px;
                font-size: 35px;
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
    <body align="center" background="<c:url value="/images/hotel.jpg"/>" style="color:white;">
        <div id="title">
            <h1>Hotel Management System</h1>
        </div>
        <div id="form">
            <br>
                    <a href="bookRoom" style="color: white"> Book Hotel</a> 
                    <br><br>
                    <a href="lowestPricedHotels" style="color: white"> View Lowest Priced Hotels</a>
                    <br>
        </div>
</body>
</html>
