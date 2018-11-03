<%-- 
    Document   : SecurityResult
    Created on : Nov 16, 2015, 2:46:32 PM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Approve Visitor Request</title>
        <style>
            table,th,td {
                border: 1px solid black;
            }
        </style>
    </head>


    <div class="table-responsive" style="font-size: 12px;text-align: center;">   
        <table id="table_1" class="table table-bordered table-hover" style="text-align: center;" >
            <c:choose>
                <c:when test="${empty Approverlist}">
                    <tr>
                        <td align="center">
                            <c:out value="There is no record found."></c:out>
                            </td>
                        </tr>
                </c:when>
                <c:otherwise>
                    <thead>
                        <tr>
                            <!--<th align="center" style="width: 1px;"><input type="checkbox" id="toggleId"/></th>-->
                            <!--<th style="width: 20%">Employee Id</th>-->
                            <th style="width: 20%">Location</th>
                            <th style="width: 20%">Requested By</th>
                            <th style="width: 20%">Visit's To</th>
                            <th style="width: 20%">Visitor's Name</th>
                            <th style="width: 20%">Visitor Coming From</th>
                            <th style="width: 20%">Visitor's Organization</th>
                            <th style="width: 20%">Reason</th>
                            <th style="width: 20%">Requested Date</th>
                            <th style="width: 20%">Incoming Date</th>
                            <th style="width: 20%">Meeting Off Date</th>
                            <th style="width: 20%">Outgoing Date</th>
                            <th style="width: 20%">Duration(In-Out)</th>
                            <th style="width: 20%">Duration(Meet-Out)</th>
                            <th style="width: 20%">Accessories</th>
                            <th style="width: 20%">Visitor's Contact</th>
                            <th style="width: 20%">Status</th>
                        </tr>
                    </thead>
                </c:otherwise>
            </c:choose>
            <tbody>
                <c:forEach var="visitorlist" items="${Approverlist}">
                    <tr>
                        <td>${visitorlist[5]}(${visitorlist[6]})</td>
                        <td>${visitorlist[1]}</td>
                        <td>${visitorlist[3]}(${visitorlist[4]})</td>
                        <td>${visitorlist[2]}</td>
                        <td>${visitorlist[7]}</td>
                        <td>${visitorlist[18]}</td>
                        <td>${visitorlist[17]}</td>
                        <td>${visitorlist[8]}</td>
                        <td>${visitorlist[9]}</td>
                        <td>${visitorlist[14]}</td>
                        <td>${visitorlist[10]}</td>
                        <td>
                            <c:if test="${visitorlist[21] eq null or visitorlist[21] eq ''}">-</c:if>
                            <c:if test="${visitorlist[21] ne null and visitorlist[21] ne ''}">
                                ${visitorlist[21]}
                            </c:if>
                        </td>
                        <td>
                            <c:if test="${visitorlist[22] eq null or visitorlist[22] eq ''}">
                                -
                            </c:if>
                            <c:if test="${visitorlist[22] ne null and visitorlist[22] ne ''}">
                                ${visitorlist[22]}
                            </c:if> 
                        </td>
                        <td> ${visitorlist[20]}</td>
                        <td>${visitorlist[19]}</td>
                        <td>
                            <c:if test="${visitorlist[12] eq 1}"><span class="badge" style="font-size:10px; ">Pending</span></c:if> 
                            <c:if test="${visitorlist[12] eq 2}"><span class="label label-success">Confirmed</span></c:if>
                            <c:if test="${visitorlist[12] eq 8}"><span class="label label-warning">Withdrawn</span></c:if>
                            </td>
                        </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</html>
