<%-- 
    Document   : EmployeeShiftReport
    Created on : Oct 12, 2018, 3:53:23 PM
    Author     : Vinit
--%>

<%--
    Document   : ShiftCreate
    Created on : Oct 9, 2015, 10:47:55 AM
    Author     : Dhaval Patel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shift Report</title>
    </head>

    <style>
        .checkbox-grid li {
            display: block;
            float: left;
            width: 25%;
        }
    </style>
<script>
        var flag3 = true;
        function saveSubmit11() {
            if (flag3) {
                 var intime = document.getElementById("inDateTime").value;
                 var outtime = document.getElementById("outDateTime").value;
                 var locatoin = document.getElementById("zydexLocationId").value;
                 var empid = document.getElementById("employeeMasterId").value;
                 if(intime == null || intime == "" || outtime == null || outtime == "" || locatoin == null || locatoin == "" || empid == null || empid == ""){
                     document.getElementById('errormsg').innerHTML = '-Enter all the details to Export Data.';
                     $("#errormsg").delay(0).fadeIn(0);
                     $("#errormsg").delay(3200).fadeOut(300);
                     return false;
                 }
            }
        }

    </script>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>SHIFT REPORT</h1>

        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <%--<form:form action="shiftRotationMaster.htm?act=employeeAttandanceDataSearchSubmit" method="post" commandName="employeeAdvanceSearch"--%>
        <form:form action="shiftRotationMaster.htm?act=getShiftForReportSubmit" method="post" commandName="employeeAdvanceSearch"
                   name='form1' class="form-horizontal" role="form" onsubmit='return saveSubmit11();'>
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="box-header">
                                </div><!-- /.box-header -->
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <!--<div class="col-md-6 col-sm-6">-->
                                        <div class="col-md-12">
                                            <span style="font-size: 14px; color: red;" id="errormsg"></span>
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Start Date<span style="color : red;font-size:12px;"></span></label>
                                                    <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_form:input1">
                                                        <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                        <form:input path="inDateTime" id="inDateTime" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>End Date<span style="color:red;font-size:12px;"></span></label>
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_form:input1">
                                                            <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                        <form:input path="outDateTime" id="outDateTime" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label> Location:</label>
                                                        <input type="text" id="zydexLocationId" name="zydexLocationId" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6" id="employeeName">
                                                        <label>Employee Name:</label>
                                                        <input type="text" id="employeeMasterId" name="employeeMasterId" class="form-control">
                                                    </div>
                                                    <!--                                                    <div class="col-sm-6" id="zydexLocationIdDiv" style="display: none;">
                                                                                                            <label> Location:</label>
                                                                                                            <input type="text" id="zydexLocationId" name="zydexLocationId" class="form-control">
                                                                                                        </div>-->
                                                    
                                                </div>
                                            </div>
                                        </div>
                                        <br/>
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class=" col-sm-12" style="text-align: center;">
                                                        <button type="submit" class="btn btn-primary" style="width: 100px;" >EXPORT</button>
                                                       
                                                    </div>
                                                     
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
            forceParse: 0,
            endDate: new Date()
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
    <script>
        jQuery.noConflict();
        jQuery(document).ready(function () {
            jQuery("#zydexLocationId").tokenInput(${zydexLocationList}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. .",
            });
        });
    </script>
    <script>
        jQuery.noConflict();
        jQuery(document).ready(function () {
            jQuery("#levelId").tokenInput(${levelList}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. .",
            });
        });
    </script>
    <script>
        jQuery.noConflict();
        jQuery(document).ready(function () {
            jQuery("#departmentId").tokenInput(${departmentList}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. .",
            });
        });
    </script>

    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>

