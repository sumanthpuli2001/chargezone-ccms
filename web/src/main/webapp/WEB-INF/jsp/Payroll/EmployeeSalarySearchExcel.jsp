<%--
    Document   : LeaveRequestExcelData
    Created on : Feb 26, 2016, 6:29:42 PM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Salary Detail</title>
        <style>
            table,th,td {
                border: 1px solid black;

            }
        </style>
    </head>
    <section class="content-header">
        <h1>Employee Salary Detail</h1>
    </section>

    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
        <c:choose>
            <c:when test="${empty SalaryList}">
                <tr>
                    <td align="center">
                        <c:out value="There is no record found."></c:out>
                        </td>
                    </tr>
            </c:when>
            <c:otherwise>
                <thead>
                    <tr>
                        <th>Employee Id</th>
                        <th>Employee Name</th>
                        <th>Basic Salary</th>
                       
                    </tr>
                </thead>
            </c:otherwise>
        </c:choose>
        <tbody>
            <c:forEach var="list1" items="${SalaryList}">
                <tr>
                    <td>${list1[0]}</td>
                    <td>${list1[1]}</td>
                    <td>${list1[2]}</td>
               
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>

</html>




