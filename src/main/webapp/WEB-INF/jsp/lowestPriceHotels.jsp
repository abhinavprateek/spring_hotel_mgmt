<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hotel Management System</title>
         <style>
            #form{
                background-color: black;
                opacity: 0.9;
                width: 800px;
                height: 350px;
                position: absolute;
                left: 400px;
                top: 233px;
                right: 288px;
                bottom: 350px;
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
         <script type="text/javascript">
            function getLowestPricedHotelsByCity(){
                var city = document.getElementById("cityName").value;
                var url = "lowestPricedHotelByCity?cityName="+city;
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function() {
                  if (xhttp.readyState == 4 && xhttp.status == 200 ) 
                  {
                   document.getElementById("default").style.display = "none";
                   document.getElementById("list").innerHTML = xhttp.responseText;
                   document.getElementById("cityName").value = city;
                  }
                };
                xhttp.open("GET", url, true);
                xhttp.send();
            }
        </script>
    </head>
    <body align="center" background="<c:url value="/images/hotel.jpg"/>" style="color:white">
         <div id="title">
            <h1>Lowest priced Hotels</h1>
        </div>
        <div id="form">
        <table align="center">
            <tr>
                <td>
                    <form:form action="" commandName="bookingDetail">
                        <form:select id="cityName" path="city" onchange="getLowestPricedHotelsByCity()" style="width:170px;height:22px;">
                            <form:option value="0" label="Select"/>
                            <form:options items="${cityNames}"/>
                        </form:select>
                    </form:form>
                </td>&nbsp;&nbsp;
            <td>
                <form action="index.jsp">
                    <input type="submit" value="Cancel" style="width:120px;height:22px;color:red"/>
                </form>
            </td>
            </tr>
            </table>
             <h3 style="color: red">List Of Lowest Priced Hotels</h3>
             <div id="list"></div>
             <div id="default">
            <table style="background-color:black;width:auto;height:auto" border="1" align="center">
                <th>Hotel Name</th><th>City</th>
            <th>Address</th>
            <th>Number Of Rooms</th><th>Star Rating</th>
            <th>Tariff Per Day</th>
            <c:forEach items="${hotels}" var="hotel">
            <tr><td>${hotel.getHotelName()}</td>
            <td>${hotel.getCity()}</td>
            <td>${hotel.getAddress()}</td>
            <td>${hotel.getNumberOfRooms()}</td>
            <td>${hotel.getStarRating()}</td>
            <td>${hotel.getTariffPerDay()}</td>
            </tr>
            </c:forEach>
            </table>
             </div>
        </div>
    </body>
</html>
