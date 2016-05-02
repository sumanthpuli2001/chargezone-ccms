<%--
    Document   : ExpensePendingExcelData
    Created on : Feb 26, 2016, 5:36:57 PM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Travel Request</title>
        <style>
            table,th,td {
                border: 1px solid black;

            }
        </style>
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Expense Pending</h1>
        </section>
        <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
            <c:choose>
                <c:when test="${empty expensePendingList}">
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
                            <th>Travel Request No.</th>
                            <th>Travel Type</th>
                            <th>Start Date Time</th>
                            <th>End Date Time</th>
                            <th>Status</th>
                            <th>Expense Requested Status</th>

                        </tr>
                    </thead>
                </c:otherwise>
            </c:choose>
            <tbody>
                <c:forEach var="list" items="${expensePendingList}">
                    <tr>

                        <td>${list[1]}</td>
                        <td>${list[2]}</td>
                        <td><b>${list[3]}</b></td>
                        <td>${list[4]}</td>
                        <td>${list[5]}</td>
                        <td>${list[6]}</td>
                        <td><span class="badge">${list[7]}</span></td>
                        <c:if test="${list[8] == 0}"><td><span class="badge">Pending</span></td></c:if>
                        <c:if test="${list[8] == 10}"><td><span class="label label-danger">Reworked By Manager</span></td></c:if>
                        <c:if test="${list[8] == 1}"><td><span class="label label-danger">Rejected By Manager</span></td></c:if>
                        <c:if test="${list[8] == 2}"><td><span class="label label-success">Approved By Manager </span></td></c:if>
                        <c:if test="${list[8] == 3}"><td><span class="label label-default">Saved As Draft</span></td></c:if>
                        <c:if test="${list[8] == 4}"><td><span class="label label-success">Final Approved By Expense Admin </span></td></c:if>



                        </tr>
                </c:forEach>
            </tbody>
        </table>

</html>



