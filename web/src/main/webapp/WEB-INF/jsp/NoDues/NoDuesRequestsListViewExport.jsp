<%--
    Document   : NoDuesRequestsListView
    Created on : Mar 19, 2016, 11:20:40 AM
    Author     : Dhaval
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>No Dues Requests</title>
    </head>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>No Due Requests: </h1>
            
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="box-header">

                            </div>
                            <div class="box-body no-padding">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12">
                                        <div class="table table-bordered">
                                            <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                <c:choose>
                                                    <c:when test="${empty employeesListOfList}">
                                                        <tr>
                                                            <td align="center">
                                                                <c:out value="There is no record found."></c:out>
                                                                </td>
                                                            </tr>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <thead>
                                                            <tr>

                                                                <!--<th>user id</th>-->
                                                                <th>Employee ID</th>
                                                                <th>Employee Name</th>
                                                                <th>Department</th>
                                                                <th>Designation</th>
                                                                <th>Effective Date</th>
                                                                <th>Date of Relieving</th>
                                                                <th>Good/Bad Attrition</th>
                                                                <th>Status</th>


                                                            </tr>
                                                        </thead>
                                                    </c:otherwise>
                                                </c:choose>
                                                <tbody>
                                                    <c:forEach var="employeesListOfListOuter" items="${employeesListOfList}">
                                                        <c:forEach var="list" items="${employeesListOfListOuter}">

                                                            <tr>

                                                                <!--<td>/</td>-->
                                                                <td>${list[1]}</td>
                                                                <td>${list[2]}</td>
                                                                <td>${list[3]}</td>
                                                                <td>${list[4]}</td>
                                                                <td>${list[13]}</td>
                                                                <td>${list[12]}</td>
                                                                <td>${list[14]}</td>
                                                                <td>
                                                                    <c:set var="count" value="0" scope="page"/>
                                                                    <c:choose>
                                                                        <c:when test="${sessionScope.employeeInfo.id eq list[7]}">
                                                                            <!--check it that reporting manager or not-->
                                                                            <c:choose>
                                                                                <c:when test="${list[8]}">
                                                                                    <c:set var="count" scope="page" value="${count + 1}" />
                                                                                    <c:if test="${count eq 1}">
                                                                                        <span class="label label-success label-as-badge">
                                                                                            Completed
                                                                                        </span>
                                                                                    </c:if>
                                                                                </c:when>
                                                                                <c:otherwise>
                                                                                    <c:set var="count" scope="page" value="${count + 1}" />
                                                                                    <c:if test="${count eq 1}">
                                                                                        <span class="label label-default label-as-badge">
                                                                                            Pending
                                                                                        </span>
                                                                                    </c:if>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <c:if test="${sessionScope.userRight.employeeExit}">
                                                                                <c:choose>
                                                                                    <c:when test="${list[9]}">
                                                                                        <c:set var="count" scope="page" value="${count + 1}" />
                                                                                        <c:if test="${count eq 1}">
                                                                                            <span class="label label-success label-as-badge">
                                                                                                Completed
                                                                                            </span>
                                                                                        </c:if>
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        <c:set var="count" scope="page" value="${count + 1}" />
                                                                                        <c:if test="${count eq 1}">
                                                                                            <span class="label label-default label-as-badge">
                                                                                                Pending
                                                                                            </span>
                                                                                        </c:if>
                                                                                    </c:otherwise>
                                                                                </c:choose>
                                                                            </c:if>
                                                                            <c:if test="${sessionScope.userRight.itAdmin}">
                                                                                <c:choose>
                                                                                    <c:when test="${list[10]}">
                                                                                        <c:set var="count" scope="page" value="${count + 1}" />
                                                                                        <c:if test="${count eq 1}">
                                                                                            <span class="label label-success label-as-badge">
                                                                                                Completed
                                                                                            </span>
                                                                                        </c:if>
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        <c:set var="count" scope="page" value="${count + 1}" />
                                                                                        <c:if test="${count eq 1}">
                                                                                            <span class="label label-default label-as-badge">
                                                                                                Pending
                                                                                            </span>
                                                                                        </c:if>
                                                                                    </c:otherwise>
                                                                                </c:choose>
                                                                            </c:if>
                                                                            <c:if test="${sessionScope.userRight.travelExpenseAdmin}">
                                                                                <c:choose>
                                                                                    <c:when test="${list[11]}">
                                                                                        <c:set var="count" scope="page" value="${count + 1}" />
                                                                                        <c:if test="${count eq 1}">
                                                                                            <span class="label label-success label-as-badge">
                                                                                                Completed
                                                                                            </span>
                                                                                        </c:if>
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        <c:set var="count" scope="page" value="${count + 1}" />
                                                                                        <c:if test="${count eq 1}">
                                                                                            <span class="label label-default label-as-badge">
                                                                                                Pending
                                                                                            </span>
                                                                                        </c:if>
                                                                                    </c:otherwise>
                                                                                </c:choose>
                                                                            </c:if>
                                                                        </c:otherwise>

                                                                    </c:choose>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div><!-- /.col -->
                                </div><!-- /.row -->
                            </div><!-- /.box-body -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section>
</html>
