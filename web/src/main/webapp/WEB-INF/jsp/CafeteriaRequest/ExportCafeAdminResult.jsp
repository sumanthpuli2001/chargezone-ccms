<%-- 
    Document   : CafeAdminResult
    Created on : Nov 5, 2015, 2:45:32 PM
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
        <title>Cafe Request Result</title>
        <style>
            table,th,td {
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
         
                                                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <c:choose>
                                                            <c:when test="${empty cafeRequestList}">
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
                                                                        <th>Request</th>
                                                                        <th>No.of Employees/Visitors</th>
                                                                          <th>Requested Date</th>
                                                                        <th>Status</th>
<!--                                                                        <th>Action</th>-->
                                                                    </tr>
                                                                </thead>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <tbody>
                                                            <c:forEach var="list" items="${cafeRequestList}">
                                                                <tr>
                                                                    <td>${list[1]}</td>
                                                                    <td>${list[2]}</td>
                                                                    <td>${list[4]}</td>
                                                                    <td>${list[5]}</td>
                                                                    <td>${list[9]}</td>
                                                                    <td>
                                                                        <c:if test="${list[7] eq 1}"><span class="badge">Pending</span>
                                                                        </c:if>
                                                                        <c:if test="${list[7] eq 5}"><span class="badge">Pending</span>
                                                                        </c:if>
                                                                        <c:if test="${list[7] eq 6}"><span class="badge">Withdraw Pending</span>
                                                                        </c:if>
                                                                        <c:if test="${list[7] eq 10}"><span class="badge">Withdraw Pending</span>
                                                                        </c:if>
                                                                        <c:if test="${list[7] eq 2}"><span class="label label-success">Approved by ${list[8]}</span></c:if>
                                                                        <c:if test="${list[7] eq 3}"><span class="label label-danger">Rejected by ${list[8]}</span></c:if>
                                                                        <c:if test="${list[7] eq 4}"><span class="label label-warning">Returned by ${list[8]}</span></c:if>
                                                                        <c:if test="${list[7] eq 8}"><span class="label label-warning">Withdrawn</span></c:if>

                                                                        </td>
                                                                      
                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>
                                              

    </body>
</html>
l>
