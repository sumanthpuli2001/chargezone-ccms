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

            #approveId,#rejectId{
                width: 50px !important;
                height: 25px !important;
            }
        </style>
    </head>
    <script>
        function viewClick(monthlyShiftId) {
         
            window.location = 'shiftRotationMaster.htm?act=viewClickEmployeeShiftAssign&id=' + monthlyShiftId;
        }

//        function approveClick(arId) {
//            window.location = 'attendanceRegularizationMaster.htm?act=approvalEditSubmitByAdmin&id=' + arId;
//        }
//
//        function rejectClick(arId) {
//            window.location = 'attendanceRegularizationMaster.htm?act=rejectSubmitByAdmin&id=' + arId;
//        }
//
//        function reworkClick(arId) {
//            window.location = 'attendanceRegularizationMaster.htm?act=reworkSubmitByAdmin&id=' + arId;
//        }
    </script>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Employee Shift Assign List: </h1>
            <div style="float: right"></div>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active"Employee Shift Assign List</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form     
                   name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--                                <div class="box-header" style="text-align: right;">
                                                                    <button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" title="Export To Excel" onclick="window.location = 'attendanceRegularizationMaster.htm?act=exportToExcelAttendenceRequest'"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>
                                                                </div>-->
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
                                                                    <th>Employee Id</th>
                                                                    <th>Employee Name</th>

                                                                    <th>Action</th>
                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="list" items="${list}">
                                                            <tr>
                                                                <td>${list[1]}</td>
                                                                <td>${list[2]}</td>
                                                                <td> 
                                                                    <button type="button" class="btn btn-default dropdown-toggle" onclick="viewClick(${list[0]});" >
                                                                        Edit
                                                                    </button>

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

