<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hotel Management System</title>
        
        <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>  
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>  
        <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script> 
         <style>
            #form{
                background-color: black;
                opacity: 0.9;
                width: 550px;
                height: 420px;
                position: absolute;
                left: 500px;
                top: 233px;
                right: 500px;
                bottom: 367px;
                font-size: 25px;
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
          function getHotelNames(){
              var city = document.getElementById("cityName").value;
              var url = "hotelNames?cityName="+city;
              var xhttp = new XMLHttpRequest();
              xhttp.onreadystatechange = function() {
                if (xhttp.readyState == 4 && xhttp.status == 200 ) 
                {
                 document.getElementById("withList").innerHTML = xhttp.responseText;
                }
              };
              xhttp.open("GET", url, true);
              xhttp.send();
              }
             $(function() {
             $("#checkInDate").datepicker({ dateFormat: "dd-mm-yy" }).val()
             $("#checkOutDate").datepicker({ dateFormat: "dd-mm-yy" }).val()
     });
      </script>
      <script>
          function validateFields() {
              var cityName = document.getElementById("cityName").value;
              var hotelName = document.getElementById("hotelName").value;
              var numberOfRooms = document.getElementById("numberOfRooms").value;
              var validate = false;
               
              if(cityName!=0){
                  validate = true;
              }
              else{
                  document.getElementById("errorMessage").style.display = "block";
                  document.getElementById("errorMessage").value="The Value Provided For The Field City Name Is Incorrect Or Incomplete";
                  return false;
              }
              if(hotelName!=0){
                  validate = true;
              }
              else{
                  document.getElementById("errorMessage").style.display = "block";
                  document.getElementById("errorMessage").value="The Value Provided For The Field Hotel Name Is Incorrect Or Incomplete";                 
                  return false;
              }
                 validate = validateDate();
                 if(validate) {
                  validate =  true;          
                  } else {
                 document.getElementById("errorMessage").value="The Value Provided For The Field Check-In/Check-Out Date Is Incorrect Or Incomplete";
                  document.getElementById("errorMessage").style.display = "block";
                  return false;
             }
             if(numberOfRooms>0) {
                 validate = true;
                 return validate;
             }
             else {
                 document.getElementById("errorMessage").value="The Value Provided For The Field Number Of Rooms Is Incorrect Or Incomplete";
                  document.getElementById("errorMessage").style.display = "block";
                 return false;
             }
          }
          function validateDate() {
              var validate = false;
              var checkInDate = document.getElementById("checkInDate").value;
              var checkOutDate = document.getElementById("checkOutDate").value;
              var checkIn = checkInDate.split("-");
              var checkOut = checkOutDate.split("-");
            if(checkIn[2]>=2016&&checkIn[2]<=9999&&checkOut[2]>=2016&&checkOut[2]<=9999) {
                 if(checkOut[1]>0&&checkIn[1]>0&&checkOut[1]<=12&&checkIn[1]<=12){
                      if(checkOut[0]>0&&checkIn[0]>0&&checkOut[0]<=31&&checkIn[0]<=31) 
                    {    
                     var In = new Date(checkIn[1]+"-"+checkIn[0]+"-"+checkIn[2]);
                     var Out = new Date(checkOut[1]+"-"+checkOut[0]+"-"+checkOut[2]);
                     var today = new Date();
                     today.setHours(0,0,0,0);
                     if(In >= today && Out > In) {
                        validate=true;
                    return validate;
                    }}}}
                   else {
                        validate=false;
                    return validate;
                    }
          }
      </script>
      
    </head>
    <body align="center" background="<c:url value="/images/hotel.jpg"/>" style="color:white" >
         <div id="title">
            <h1>Fill In Booking Details</h1>
        </div>
         <div id="form">
             <input type="text" style="color:red;font-weight: bold;display: ${display};border: 0;background-color:Black;height: 25px;" size="73" readonly="readonly" id="errorMessage" value="${value}"/><br>
        <form:form action="saveBooking" commandName="bookingDetail">
            <table cellpadding="10" style="width: 500px;height:280px;">
                <tr>
                    <td align="right">Select City</td>
                    <td>
                        <form:select id="cityName" path="city" onchange="getHotelNames()" style="width:170px;height:22px;">
                            <form:option value="0" label="Select" />
                            <form:options items="${cityNames}" />
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td align="right">Select Hotel</td>
                    <td id="withList">
                        <form:select id="hotelName" path="hotelName" style="width:170px;height:22px;">
                            <form:option value="0" label="Select" />
                            <form:options items="${hotelNames}"/>
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td align="right">Check-In Date</td>
                    <td>
                        <form:input id="checkInDate" type="text" path="checkInDate"/>
                    </td>
                </tr>
                <tr>
                    <td align="right">Check-Out Date</td>
                    <td>
                        <form:input id="checkOutDate" type="text" path="checkOutDate"/>
                    </td>
                </tr>
                <tr>
                    <td align="right">Number Of Rooms</td>
                    <td>
                        <form:input id="numberOfRooms" type="number" path="numberOfRooms"/>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Book Room" style="width:170px;height:30px;color:red;" onclick="return validateFields();"</td>
                </tr>
            </table>
       </form:form>
        <div align="right"><form action="index.jsp"><input type="submit" value="Cancel" style="width:170px;height:30px;color:red;"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</form></div>
       </div>
    </body>
</html>
