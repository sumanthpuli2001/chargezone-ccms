<%--
    Document   : PayrollTaxRuleCreate
    Created on : Jul 14, 2016, 4:39:27 PM
    Author     : AJAY <ajay@bulwarks.com>
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Leave Detail Search</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1> Leave Detail Search </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Report</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                                <form:form class="form-horizontal" method="post"
                                           commandName="employeeMaster" action="leaveEmployeeDetail.htm?act=searchEmpLeaveDetailSubmit" >
                                    <div class="form-group">


                                        <div class="col-md-6" id="employeeName">
                                            <label>Employee Name:</label>
                                            <input type="text" id="employeeMasterId" name="employeeMasterId" class="form-control">
                                        </div>
                                        <div class="col-sm-6">
                                            <label>Leave Type:<span style="color: red;font-size: 12px;"></span></label>
                                            <select name="leaveType" id="leaveType" onchange="showDiv(this.value);" class="form-control">
                                                <option value="">--Select--</option>
                                                <c:forEach var="map" items="${leaveTypemap11}">
                                                    <option value="${map.key}">${map.value}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>



                                    <div class="form-group">
                                        <div class="col-sm-6">
                                            <label>Start Date:<span style="color: red;font-size: 12px;"></span></label>
                                            <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                <input type="text" id="startDate" name="startDate" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" />
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <label>End Date<span style="color: red;font-size: 12px;"></span></label>
                                            <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                <input id="endDate" name="endDate" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" />
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                            </div>
                                        </div>

                                    </div>



                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
                                        </div>

                                    </div>
                                </form:form>
                                <form:form action="leaveTypeMaster.htm?act=deleteSubmit" method="post" commandName="leaveTypeMaster"
                                           name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
                                    <section class="content">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <!-- Custom Tabs -->
                                                <div class="nav-tabs-custom">
                                                    <div class="tab-content">
                                                        <div class="box-header" style="text-align: right;">
                                                            <button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" title="Export To Excel" onclick="window.location = 'leaveEmployeeDetail.htm?act=exportToExcelForLeaveRequest'"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>
                                                        </div>
                                                        <div class="box-body no-padding">
                                                            <div class="row">
                                                                <div class="col-md-12 col-sm-12">
                                                                    <div class="table table-bordered">
                                                                        <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                                            <c:choose>
                                                                                <c:when test="${empty list11}">
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
                                                                                            <th>Leave Type</th>
                                                                                            <th>Start Date</th>
                                                                                            <th>End Date</th>
                                                                                            <th>Date of Submission</th>
                                                                                            <th>No Of Days</th>
                                                                                            <th>Status</th>
                                                                                        </tr>
                                                                                    </thead>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <tbody>
                                                                                <c:forEach var="list11" items="${list11}">
                                                                                    <tr>
                                                                                        <td>${list11[0]}</td>
                                                                                        <td>${list11[1]}</td>
                                                                                        <td>${list11[4]}</td>
                                                                                        <td>${list11[5]}</td>
                                                                                        <td>${list11[6]}</td>
                                                                                        <td>${list11[9]}</td>
                                                                                        <td>${list11[8]}</td>
                                                                                        <c:if test="${list11[7] eq 0}">
                                                                                            <td><span class="badge">Pending</span></td>
                                                                                        </c:if>
                                                                                        <c:if test="${list11[7] eq 3}">
                                                                                            <td><span class="label label-success">Approved</span></td>
                                                                                        </c:if>
                                                                                        <c:if test="${list11[7] eq 2}">
                                                                                            <td> <span class="label label-danger">Rejected</span></td>
                                                                                        </c:if>
                                                                                        <c:if test="${list11[7] eq 1}">
                                                                                            <td><span class="label label-warning">Reworked</span></td>
                                                                                        </c:if>
                                                                                        <c:if test="${list11[7] eq 4}">
                                                                                            <td><span class="label label-info">WithDraw Request</span></td>
                                                                                        </c:if>
                                                                                        <c:if test="${list11[7] eq 5}">
                                                                                            <td><span class="label label-info">WithDrawn</span></td>
                                                                                        </c:if>
                                                                                        <c:if test="${list11[7] eq 6}">
                                                                                            <td><span class="label label-info">Approved By HR</span></td>
                                                                                        </c:if>
                                                                                        <c:if test="${list11[7] eq 7}">
                                                                                            <td><span class="label label-info">Rejected By HR</span></td>
                                                                                        </c:if>
                                                                                        <c:if test="${list11[7] eq 8}">
                                                                                            <td><span class="label label-info">Reworked By HR</span></td>
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
                                </form:form>

                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <script type="text/javascript">
        $('.form_datetime').datetimepicker({
            //language:  'fr',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });

    </script>
    <script>
        jQuery.noConflict();
        jQuery(document).ready(function () {
            jQuery("#employeeMasterId").tokenInput(${list}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. .",
            });
        });
    </script>
    <script type="text/javascript">
        function printDiv(divName) {
            var printContents = document.getElementById(divName).innerHTML;
            var originalContents = document.body.innerHTML;

            document.body.innerHTML = printContents;

            window.print();

            document.body.innerHTML = originalContents;
        }
    </script>
    <script type="text/javascript">
        function ExportToExcel(tableid) {
            var htmltable = document.getElementById('tableid');
            var html = htmltable.outerHTML;
            window.open('data:application/vnd.ms-excel,' + encodeURIComponent(html));
        }
    </script>


    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
