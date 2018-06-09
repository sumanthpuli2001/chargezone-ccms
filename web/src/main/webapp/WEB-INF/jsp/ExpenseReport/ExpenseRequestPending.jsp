<%--
    Document   : ExpenseRequestPending
    Created on : Feb 13, 2016, 2:45:48 PM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Travel Request</title>
    </head>
    <script>
        function viewClick(id, empId) {
            window.location = 'expenseMaster.htm?act=viewExpenseRequestByAdmin&id=' + id + '&empId=' + empId;
        }

    </script>



    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>EXPENSE PENDING</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Expense Pending</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>


        <!-- Main content -->

        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="box-header" style="text-align: right;">
                                <button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" title="Export To Excel" onclick="window.location = 'expenseMaster.htm?act=exportToExcelForTravelCompletedAndExpensePending'"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>
                            </div>
                            <div class="box-body no-padding">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12">
                                        <div class="table table-bordered">
                                            <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                <c:choose>
                                                    <c:when test="${empty finalList}">
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
                                                                <th></th>

                                                            </tr>
                                                        </thead>
                                                    </c:otherwise>
                                                </c:choose>
                                                <tbody>
                                                    <c:forEach var="list" items="${finalList}">
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
                                                            <c:if test="${list[10] ne 'Pending'}">
                                                                <td><div class="btn-group">
                                                                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" onclick="viewClick('${list[10]}', '${list[9]}');">
                                                                            &nbsp;&nbsp;View</button>

                                                                    </div></td>    
                                                                </c:if>  
                                                            <c:if test="${list[10] eq 'Pending'}">
                                                                <td>
                                                                    
                                                                </td>
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



        <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
        <!-- /.content -->
    </div>

    <script type="text/javascript">
        $('.form_datetime').datetimepicker({
            //language:  'fr',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            forceParse: 0,
            showMeridian: 1
        });
    </script>

    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <!--    <script>
            $(document).ready(function () {
                $('#table_2').DataTable();
            })
        </script>-->
</html>


