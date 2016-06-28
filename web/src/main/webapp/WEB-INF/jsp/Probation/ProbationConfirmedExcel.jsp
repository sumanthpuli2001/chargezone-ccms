<%--
    Document   : ProbationConfirmedExcel
    Created on : Jun 23, 2016, 4:37:58 PM
    Author     : AJAY <ajay@bulwarks.com>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <div class="content-wrapper">
            <section class="content-header">
                <h1>Probation Confirmed</h1>
            </section>

            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div style="clear: both"></div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">
                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${empty probatonConfirmedSessionList}">
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
                                                                    <th>Department</th>
                                                                    <th>Designation</th>
                                                                    <th>Date of Joining</th>
                                                                    <th>Date of Confirmation</th>
                                                                    <th>Status</th>
                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <!--<tbody>-->
                                                    <c:forEach var="list" items="${probatonConfirmedSessionList}">
                                                        <tr>
                                                            <td>${list[0]}</td>
                                                            <td>${list[1]}</td>
                                                            <td>${list[2]}</td>
                                                            <td>${list[3]}</td>
                                                            <td>${list[4]}</td>
                                                            <td>${list[5]}</td>
                                                            <td><span class="label label-success">Confirmed</span></td>
                                                        </tr>
                                                    </c:forEach>

                                                    <!--</tbody>-->
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
    </body>
</html>
