<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
                   <form:form action="" commandName="bookingDetail">
                        <form:select id="hotelName" path="hotelName" style="width:170px;height:22px;display:${select}">
                            <form:option value="0" label="Select" />
                            <form:options items="${hotelNames}"/>
                        </form:select>
                    </form:form>
                    <table style="background-color:black;width:auto;height:auto;display:${forEach}" border="1" align="center">
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
</html>
