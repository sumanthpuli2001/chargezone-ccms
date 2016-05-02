<%-- 
    Document   : HrSearch
    Created on : Nov 20, 2015, 5:04:04 PM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
        <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Hr Service Request</title>
        <script>
            function dateValidator() {
                var startDate = document.getElementById("startDate").value;
                var endDate = document.getElementById("endDate").value;
                if (startDate) {
                    var startDatearray = startDate.split("/");
                    var endDatearray = endDate.split("/");
                    var sDate = new Date(startDatearray[2], startDatearray[1] - 1, startDatearray[0]);
                    var eDate = new Date(endDatearray[2], endDatearray[1] - 1, endDatearray[0]);
                    if (sDate > eDate) {
                        document.getElementById("endDate").value = "";
                        alert("End date should be greater than Start date");
                        return false;
                    }
                } else {
                    document.getElementById("endDate").value = "";
                    alert("startdate must not be empty");
                }
            }
        </script>
    </head>
    <body>
        <div class="content-wrapper">
            <section class="content-header">
                <h1>Search Hr Service Request: </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Search</li>
                </ol>
            </section>
            <c:if test="${!empty successMessage}">
                <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
            </c:if>
            <c:if test="${!empty failureMessage}">
                <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
            </c:if>

            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <form:form class="form-horizontal" role="form" action="hrServiceRequest.htm?act=searchHrResult" commandName="employeeMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
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
                                                                    <div class="form-group">
                                                                        <div class="col-sm-6"><span style="color: red;font-size: 12px;"></span>
                                                                            <label>Employee Name:<span style="color: red;font-size: 12px;"></span></label>
                                                                                <form:input path="employeeName" class="form-control"></form:input>
                                                                                <form:errors path="employeeName" cssClass="errorDiv"></form:errors>
                                                                            </div>
                                                                            <div class="col-sm-6">
                                                                                <label>Department:<span style="color: red;font-size: 12px;"></span></label>
                                                                                <form:select path="departmentMaster" id="departmentMaster" class="form-control">
                                                                                    <form:option value="" label="-- Select --" />
                                                                                    <form:options items="${deptMap}"></form:options>
                                                                                </form:select>
                                                                                <form:errors path="departmentMaster" cssClass="errorDiv"></form:errors>
                                                                            </div>

                                                                        </div>

                                                                        <div class="form-group">
                                                                            <div class="col-sm-6">
                                                                                <label>Designation:<span style="color: red;font-size: 12px;"></span></label>
                                                                                <form:select path="designationMaster" id="designationMaster" class="form-control">
                                                                                    <form:option value="" label="-- Select --" />
                                                                                    <form:options items="${desigList}"></form:options>
                                                                                </form:select>
                                                                                <form:errors path="designationMaster" cssClass="errorDiv"></form:errors>
                                                                            </div>

                                                                            <div class="col-sm-6">
                                                                                <label>Status:<span style="color: red;font-size: 12px;"></span></label>
                                                                                <select name="status" id="status" class="form-control">
                                                                                    <option value="">--Select--</option>
                                                                                    <option value="1">Requested</option>
                                                                                    <option value="2">Approved</option>
                                                                                    <option value="3">Rejected</option>
                                                                                    <option value="4">Return</option>
                                                                                    <option value="8">Withdraw</option>
                                                                                </select>
                                                                            </div>

                                                                        </div>

                                                                        <div class="form-group">
                                                                            <div class="col-sm-6">
                                                                                <label>Start Date:<span style="color: red;font-size: 12px;"></span></label>
                                                                                <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                                    <input id="startDate" name="startDate" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly/>
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-sm-6">
                                                                                <label>End Date<span style="color: red;font-size: 12px;"></span></label>
                                                                                <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                                    <input id="endDate" name="endDate" class="form-control" size="16" placeholder="DD/MM/YYYY" onchange="dateValidator();" readonly/>
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
                            </div>

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
                                    jQuery("#employeeName").tokenInput(${list}, {
                                        preventDuplicates: true,
                                        noResultsText: "No Result",
                                        tokenLimit: "1",
                                        searchingText: "Searching ... .. .",
                                    });
                                });

                            </script>
                            <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
                        </div>
                        </body>
                        </html>
