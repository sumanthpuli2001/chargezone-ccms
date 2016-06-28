<%--
    Document   : ResignationHrResultExcel
    Created on : Jun 24, 2016, 10:56:15 AM
    Author     : AJAY <ajay@bulwarks.com>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Resignation Result: </h1>

        </section>

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
                                                    <c:when test="${empty resignationResultSessionList}">
                                                        <tr>
                                                            <td align="center">
                                                                <c:out value="There is no record found."></c:out>
                                                                </td>
                                                            </tr>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <thead>
                                                            <tr>
                                                                <th>Employee id</th>
                                                                <th>Employee Name</th>
                                                                <th>Effective Date</th>
                                                                <th>Status</th>
                                                            </tr>
                                                        </thead>
                                                    </c:otherwise>
                                                </c:choose>
                                                <tbody>
                                                    <c:forEach var="list" items="${resignationResultSessionList}">

                                                        <tr>
                                                            <td>${list[4]}</td>
                                                            <td>${list[5]}</td>
                                                            <td>${list[1]}</td>
                                                            <c:if test="${list[2] == 2}"><td><span class="badge">Pending</span></td></c:if>
                                                            <c:if test="${list[2] == 8}"><td><span class="badge">Returned Pending</span></td></c:if>
                                                            <c:if test="${list[2] == 7}"><td><span class="badge">Withdraw Pending</span></td></c:if>
                                                            <c:if test="${list[2] == 10}"><td><span class="badge">Withdraw Pending(Rejected by Manager)</span></td></c:if>
                                                            <c:if test="${list[2] == 4}"><td><span class="label label-success">Approved by HR</span></td></c:if>
                                                            </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
</html>



