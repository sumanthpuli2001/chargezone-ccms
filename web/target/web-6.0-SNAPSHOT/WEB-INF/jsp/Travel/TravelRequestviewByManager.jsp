<%--
    Document   : TravelRequestviewByManager
    Created on : Oct 28, 2015, 2:36:07 PM
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
            window.location = 'travelRequestMaster.htm?act=approveRequestManagerSide&id=' + id + "&empId=" + empId;
        }

    </script>



    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Travel Request </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Travel Request</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>

        <form:form class="form-horizontal" role="form" action="travelRequestMaster.htm?act=searchTravelRequestSubmitAdmin" commandName="employeeMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--<span style="color: red;font-size: 14px;">* indicates mandatory field.</span>-->
                                <!--form horizontal starts here-->

                                <div class="box-header">

                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <div class="col-sm-6"><span style="color: red;font-size: 12px;"></span>
                                                    <label>Employee Name:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:input path="employeeName" class="form-control"></form:input>
                                                        <form:errors path="employeeName" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Travel Type<span style="color: red;font-size: 12px;"></span></label>
                                                        <select name="travelType" id="travelType" onchange="cashRequired()" class="form-control">
                                                            <option value="" label="--SELECT--">--SELECT--</option>
                                                            <option value="Domestic" label="Domestic">Domestic</option>
                                                            <option value="International" label="International">International</option>
                                                        </select>
                                                    </div>


                                                </div>



                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Start Date:<span style="color: red;font-size: 12px;"></span></label>
                                                        <!--<div class="input-group date form_datetime" data-date-format="dd/mm/yyyy-hh:ii" data-link-field="dtp_input1">-->
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                            <input type="text" id="startDate" name="startDate" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" />
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>End Date<span style="color: red;font-size: 12px;"></span></label>
                                                        <!--<div class="input-group date form_datetime" data-date-format="dd/mm/yyyy-hh:ii" data-link-field="dtp_input1">-->
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                            <input id="endDate" name="endDate" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" />
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    </div>

                                                </div>

                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->

                                    <div class="form-group">
                                        <div class=" col-sm-2">
                                            <button type="submit" class="btn btn-primary" data-original-title="" title="" >Search</button>
                                        </div>
                                    </div>

                                    <div class="tab-pane" id="tab_3"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
        </form:form>

        <!-- Main content -->
        <form:form action="leaveEmployeeDetail.htm?act=deleteLeaveRequest" method="post" commandName="leaveEmployeeDetail"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
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
                                                        <c:when test="${empty reportingLevel}">
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
                                                                    <th>Travel Type</th>
                                                                    <th>Travel Request No.</th>
                                                                    <th>Start Date Time</th>
                                                                    <th>End Date Time</th>
                                                                    <th>Date OF Submit</th>

                                                                    <th>Status</th>
                                                                    <th>Action</th>
                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="list" items="${reportingLevel}">
                                                            <tr>

                                                                <td>${list[1]}</td>
                                                                <td>${list[2]}</td>
                                                                <td>${list[3]}</td>
                                                                <td>${list[4]}</td>
                                                                <td>${list[5]}</td>
                                                                <td>${list[6]}</td>

                                                                <td>${list[8]}</td>

                                                                <c:if test="${list[7] eq 0}"><td>Travel Request</td></c:if>
                                                                <c:if test="${list[7] eq 4}"><td>Withdraw Request</td></c:if>
                                                                    <td>
                                                                        <div class="btn-group">
                                                                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                                Action <span class="caret"></span>
                                                                            </button>
                                                                            <ul class="dropdown-menu">
                                                                                <li>
                                                                                    <a href="#"
                                                                                       onclick="viewClick(${list[0]}, ${list[9]});">
                                                                                    &nbsp;&nbsp;View
                                                                                </a>
                                                                            </li>


                                                                        </ul>
                                                                    </div>
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
    <script>
        jQuery.noConflict();
        jQuery(document).ready(function () {
            jQuery("#employeeName").tokenInput(${list}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. .",
            });
        });

    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <!--    <script>
            $(document).ready(function () {
                $('#table_2').DataTable();
            })
        </script>-->
</html>

