<%--
    Document   : ShiftResult
    Created on : Oct 9, 2015, 3:36:40 PM
    Author     :Dhaval Patel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Attendance Regularization Result</title>
        <style>
            .dataTables_wrapper .dataTables_paginate .paginate_button:hover{
                background-color: white !important;
                background:linear-gradient(to bottom,#fffff 0,#111 100%) !important;
            }
        </style>
    </head>
    <script>
        function editClick(id) {
            window.location = 'attendanceRegularizationMaster.htm?act=editClick&id=' + id;
        }
    </script>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Attendance Regularization Result: </h1>
            <div style="float: right"></div>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Attendance Regularization Result</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="attendanceRegularizationMaster.htm?act=editSubmit" method="post" commandName="attendanceRegularization"
                   name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="box-header">
                                    <button type="button" class="btn btn-primary" style="float: right;width: 100px;" onclick="window.location = 'attendanceRegularizationMaster.htm?act=createClick'"><i class="fa fa-plus"></i>&nbsp;&nbsp;NEW</button>
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">
                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${empty list}">
                                                            <tr>
                                                                <td align="center">
                                                                    <c:out value="There is no record found."></c:out>
                                                                    </td>
                                                                </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr >
                                                                    <th>Start Date & Time</th>
                                                                    <th>End Date & Time</th>
                                                                    <th>Reason</th>
                                                                    <th>Date of Submission</th>
                                                                    <th>Time Difference</th>
                                                                    <th>AR Type</th>
                                                                    
                                                                    <th>Status</th>
                                                                    <th>Action</th>
                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="list" items="${list}">
                                                            <tr>
                                                                <td>${list.startDateTime}</td>
                                                                <td>${list.endDateTime}</td>
                                                                <td>${list.reason}</td>
                                                                <td>${list.dateOfSubmit}</td>
                                                                 <td>${list.differentCompare}</td>
                                                                  <td>${list.arType}</td>
                                                                   
                                                                  
                                                                <c:if test="${list.status eq 0}">
                                                                    <td><span class="label label-primary ">Pending</span></td>
                                                                </c:if>
                                                                <c:if test="${list.status eq 18}">
                                                                    <td><span class="label label-primary ">Pending</span></td>
                                                                </c:if>
                                                                <c:if test="${list.status eq 1}">
                                                                    <td><span class="label label-success">Approved by ${managerName}</span></td>
                                                                </c:if>
                                                                <c:if test="${list.status eq 11}">
                                                                    <td><span class="label label-success">Partially Approved</span></td>
                                                                </c:if>
                                                                <c:if test="${list.status eq 2}">
                                                                    <td><span class="label label-warning ">Withdraw</span></td>
                                                                </c:if>
                                                                <c:if test="${list.status eq 3}">
                                                                    <td><span class="label label-danger">Rejected by ${managerName}</span></td>
                                                                </c:if>
                                                                <%--<c:if test="${list.status eq 4}">--%>
                                                                <!--<td><span class="badge">Apply For Withdraw</span></td>-->
                                                                <%--</c:if>--%>
                                                                <%--<c:if test="${list.status eq 5}">--%>
                                                                <!--<td><span class="label label-success">Withdraw Approve</span></td>-->
                                                                <%--</c:if>--%>
                                                                <c:if test="${list.status eq 7}">
                                                                    <td><span class="label label-info">Reworked by ${managerName}</span></td>
                                                                </c:if>

                                                                <td>  <button type="button" class="btn btn-default" onclick="editClick(${list.id});">View</button></td>

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

        </form:form>
        <!--</div>-->
        <!--Employee detail completes here-->
        <!--read only entries ends here-->

        <!--form horizontal ends here-->
        <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
        <!-- /.content -->
    </div>

    <script type="text/javascript">
        $('.form_datetime').datetimepicker({
            //            language: 'fr',
            weekStart: 1,
            //            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 1,
            minView: 0,
            maxView: 1,
            forceParse: 0
        });
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>

