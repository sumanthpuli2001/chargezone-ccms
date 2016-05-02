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
        <title>Temporary Shift Assign Create</title>
    </head>
    <script>
        var flag3 = true;
        function saveSubmit11() {
            if (flag3) {
                flag3 = false;
                document.getElementById('saveSubmit1').innerHTML = 'Saving ... .. .';
                document.form1.submit();
                return true;
            } else {
                return false;
            }
        }
    </script>

    <script type="text/javascript">
        $('#startDate').datetimepicker({
            //language:  'fr',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });
        $('#endDate').datetimepicker({
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
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Temporary Shift Assign Create: </h1>

        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="temporaryShiftAssign.htm?act=createSubmit" method="post" commandName="tempShiftAssignMaster"
                   name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="box-header">
                                    <!--<h3 class="box-title">Employee Detail:</h3>-->
                                    <!--                                        <div class="box-tools pull-right">
                                                                                <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
                                                                            </div>-->
                                </div><!-- /.box-header -->
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">

                                                <div class="col-sm-6">
                                                    <label>Start Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                        <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                        <form:input path="startDate"  class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    <form:errors path="startDate" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>End Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                        <form:input path="endDate"  class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    <form:errors path="endDate" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Employee Name:</label>
                                                        <div>
                                                            <input type="text" id="employeeMasterId" name="employeeMasterId" class="form-control">
                                                        </div>
                                                    <form:errors path="employeeMaster" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class=" col-sm-6">
                                                        <label>Shift Name:</label>
                                                        <div>
                                                            <input type="text"  id="shiftMasterId" name="shiftMasterId" class="form-control">
                                                        </div>
                                                    <form:errors path="shiftMaster" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class=" col-sm-12" style="text-align: center;">
                                                        <button type="submit" class="btn btn-primary" >Submit</button>
                                                        <!--<button type="button" class="btn btn-primary"  onclick="window.history.back();">Back</button>-->
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
            forceParse: 0
        });
    </script>
    <script>
        jQuery.noConflict();
        jQuery(document).ready(function () {
            jQuery("#employeeMasterId").tokenInput(${list}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "100",
                searchingText: "Searching ... .. .",
            });
        });
        jQuery(document).ready(function () {
            jQuery("#shiftMasterId").tokenInput(${list1}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. .",
            });
        });
    </script>

    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

</html>
