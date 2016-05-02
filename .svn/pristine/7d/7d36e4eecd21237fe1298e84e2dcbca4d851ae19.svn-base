<%-- 
    Document   : probationExcel
    Created on : Mar 30, 2016, 10:49:39 AM
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
        <title>Export Probation To Confirmation Result</title>
         <style>
            table,th,td {
                border: 1px solid black;
            }
        </style>
    </head>
       <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <c:choose>
                                                            <c:when test="${empty hrlist}">
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
                                                                        <th>Employee Id</th>
                                                                        <th>Employee Name</th>
                                                                        <th>Date of Joining(DD/MM/YYYY)</th>
                                                                        <th>Date of Confirmation(DD/MM/YYYY)</th>
                                                                        <th>Department</th>
                                                                        <th>Designation</th>
                                                                        <!--<th>Action</th>-->
                                                                    </tr>
                                                                </thead>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <tbody>
                                                            <c:forEach var="list" items="${hrlist}" varStatus="status">
                                                                <tr>
                                                                    <!--<td></td>--> 
                                                                    <td>${list[1]}</td>
                                                                    <td>${list[2]}</td>
                                                                    <td>${list[3]}</td>
                                                                    <c:forEach items="${mapVal}" var="mapVal">

                                                                        <c:if test="${mapVal.key eq list[0]}">
                                                                            <td>${mapVal.value}</td>
                                                                        </c:if>
                                                                    </c:forEach> 
                                                                    <td>${list[4]}</td>
                                                                    <td>${list[5]}</td>

<!--                                                                    <td>
                                                                        <div class="btn-group">
                                                                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                                <a href="#" onclick="viewClick(${list[0]},${list[1]});">
                                                                                    View
                                                                                </a>
                                                                            </button>
                                                                                                                                                            <ul class="dropdown-menu">
                                                                                                                                                                <li>
                                                                                                                                                                   
                                                                                                                                                                </li>
                                                                                                                                                            </ul>
                                                                        </div>
                                                                    </td>-->
                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>
</html>
