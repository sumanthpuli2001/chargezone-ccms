<%--
    Document   : ShiftResult
    Created on : Oct 9, 2015, 3:36:40 PM
    Author     :Dhaval Patel
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
    table,th,td {
        border: 1px solid black;

    }
</style>
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>Attendance Regularization Requested List: </h1>

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
                                                <c:when test="${empty list}">
                                                    <tr align="center">
                                                        <td align="center">
                                                            <c:out value="There is no record found."></c:out>
                                                            </td>
                                                        </tr>
                                                </c:when>
                                                <c:otherwise>
                                                    <thead>
                                                        <tr >
                                                            <th>Employee Id</th>
                                                            <th>Employee Name</th>
                                                            <th>Start Date & Time</th>
                                                            <th>End Date & Time</th>
                                                            <th>Reason</th>
                                                            <th>Date of Submission</th>
                                                            <th>Status</th>
                                                        </tr>
                                                    </thead>
                                                </c:otherwise>
                                            </c:choose>
                                            <tbody>
                                                <c:forEach var="list" items="${list}">
                                                    <tr>
                                                        <td >${list[6]}</td>
                                                        <td >${list[1]}</td>
                                                        <td >${list[2]}</td>
                                                        <td>${list[3]}</td>
                                                        <td style="width:40%;">${list[4]}</td>
                                                        <td>${list[7]}</td>
                                                        <c:if test="${list[5] eq 0}">
                                                            <td><span  class="label label-primary" >Pending</span></td>
                                                        </c:if>
                                                        <c:if test="${list[5] eq 1}">
                                                            <td><span  class="label label-success">Approved</span></td>
                                                        </c:if>
                                                        <c:if test="${list[5] eq 2}">
                                                            <td><span class="label label-warning ">Withdrawn</span></td>
                                                        </c:if>
                                                        <c:if test="${list[5] eq 3}">
                                                            <td><span class="label label-danger">Rejected</span></td>
                                                        </c:if>
                                                        <%--<c:if test="${list[5] eq 4}">--%>
                                                        <!--<td>Apply For Withdraw</td>-->
                                                        <%--</c:if>--%>
                                                        <c:if test="${list[5] eq 7}">
                                                            <td><span class="label label-info">Rework</span></td>
                                                        </c:if>

                                                    </tr>
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


</div>



