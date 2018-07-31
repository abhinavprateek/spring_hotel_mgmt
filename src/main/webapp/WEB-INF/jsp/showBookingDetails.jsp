<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hotel Management System</title>
    </head>
    <style>
            #form{
                background-color: black;
                opacity: 0.9;
                width: 800px;
                height: 350px;
                position: absolute;
                left: 430px;
                top: 233px;
                right: 288px;
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
    <body align="center" background="<c:url value="/images/hotel.jpg"/>" style="color:white">
        <div id="title">
            <h1>Booking Details</h1>
        </div>
        <div id="form">
            <h3 style="color:green">Your Booking Is Successfully Done</h3>
            <h3 style="color:red">Your Booking Reference Id is ${bookingId}</h3>
            <h3>Booking Details</h3>
            <table style="background-color:black;width:auto;height:auto" border="1" style="font-size: 20px;" align ="center">
            <th>City Name</th><th>Hotel Name</th>
            <th>Number Of Rooms</th><th>Check-In Date</th>
            <th>Check-Out Date</th><th>Total Amount Payable</th>
            <c:forEach items="${details}" var="detail">
            <tr><td>${detail.getCity()}</td>
            <td>${detail.getHotelName()}</td>
            <td>${detail.getNumberOfRooms()}</td>
            <td>${detail.getCheckInDate()}</td>
            <td>${detail.getCheckOutDate()}</td>
            <td>${detail.getTotalAmount()}</td>
            </tr>
            </c:forEach>
            </table><br>
            <form action="index.jsp"><input type="submit" value="Home Page" style="width:170px;height:30px;color:red;"/></form>
        </div>
            
    </body>
</html>
