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
        <h1>Kaizen Summary List </h1>

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
                                                        <tr>
                                                            <!--<th style="width: 1px; text-align: center" ><input type="checkbox" id="toggleId" align="Center" ></th>-->
                                                            <th style="width: 50px;">Sr.No</th>
                                                            <th style="width: 50px;">Kaizen Team</th>
                                                            <th style="width: 50px;">Department</th>
                                                            <th style="width: 50px;">Date</th>
                                                            <th style="width: 50px;">Kaizen Idea</th>
                                                            <th style="width: 50px;">Problem/waste identified </th>
                                                            <th style="width: 50px;">Idea Generator's Name</th>
                                                            <th style="width: 50px;">Kaizen Completion Target Date</th>
                                                            <th style="width: 50px;">Kaizen Status (Open/Close)</th>
                                                            <!--<th style="width: 50px;">Action</th>-->
                                                        </tr>
                                                    </thead>
                                                </c:otherwise>
                                            </c:choose>
                                            <tbody>
                                                <c:forEach  var="list1" items="${list}">
                                                    <tr>
                                                        <!--                                                                    <td align="Center">
                                                                                                                                <input type="checkbox" name="checkId" id="checkId" value="${list[0]}">
                                                                                                                            </td>-->
                                                        <td>${list1[1]}</td>
                                                        <td>${list1[2]}</td>
                                                        <td>${list1[3]}</td>
                                                        <td>${list1[4]}</td>
                                                        <td>${list1[5]}</td>
                                                        <td>${list1[6]}</td>
                                                        <td>${list1[9]}</td>
                                                        <td>${list1[7]}</td>
                                                        <c:if test="${list1[8] eq 21}"><td><span class="label label-success">Close</span></td></c:if>
                                                        <c:if test="${list1[8] eq 0}"><td><span class="badge">Open</span></td></c:if>
                                                        <c:if test="${list1[8] eq 2 || list1[8] eq 22}"><td><span class="label label-warning">Recycled</span></td></c:if>
                                                        <c:if test="${list1[8] eq 3 || list1[8] eq 23}"><td><span class="label label-danger">Rejected</span></td></c:if>
                                                        <%--<c:if test="${list1[8] eq 10}"><td><span class="label label-default">OnHold</span></td></c:if>--%>
                                                        <%--<c:if test="${list1[8] eq 4}"><td><span class="label label-success">Final Approve Pending</span></td></c:if>--%>
                                                        <c:if test="${list1[8] eq 1}"><td><span class="label label-success">Final Approve Pending</span></td></c:if>

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



