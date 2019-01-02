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
        <h1>Training Summary List </h1>

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
                                                            <!--<th style="width: 1px;" align="Center"><input type="checkbox" id="toggleId" align="Center" ></th>-->
                                                            <th>Title</th>
                                                            <th>Description</th>
                                                            <th>Department</th>
                                                            <th>Trainer</th>
                                                            <th>Training Type</th>
                                                            <th>Start Date</th>
                                                            <th>End Date</th>
                                                            <!--<th>Status</th>-->
                                                            <!--<th>Action</th>-->
                                                        </tr>
                                                    </thead>
                                                </c:otherwise>
                                            </c:choose>
                                            <tbody>
                                                <c:forEach  var="trainingList" items="${list}">
                                                    <tr>
                                                        <!--                                                                        <td align="Center">
                                                                                                                                    <input type="checkbox" name="checkId" id="checkId" value="${trainingList[0]}">
                                                                                                                                </td>-->
                                                        <td>
                                                            ${trainingList[1]}
                                                        </td>
                                                        <td>
                                                            ${trainingList[2]}
                                                        </td>
                                                        <td>
                                                            ${trainingList[7]}
                                                        </td>
                                                        <td>
                                                            ${trainingList[3]}
                                                        </td>
                                                        <td>
                                                            ${trainingList[4]}
                                                        </td>
                                                        <td>
                                                            ${trainingList[5]}
                                                        </td>
                                                        <td>
                                                            ${trainingList[6]}
                                                        </td>
                                                       

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



