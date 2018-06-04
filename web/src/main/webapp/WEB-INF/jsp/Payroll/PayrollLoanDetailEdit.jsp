<%--
    Document   : PayrollTaxRuleCreate
    Created on : Jul 14, 2016, 4:39:27 PM
    Author     : AJAY <ajay@bulwarks.com>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loan Details Edit</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>EDIT LOAN DETAILS </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Edit</li>
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
                                           commandName="payrollLoanDetail" action="payrollLoanType.htm?act=editSubmitLoanDetail">
                                    <form:hidden path="id"></form:hidden>
                                    <form:hidden path="employeeMaster.id"></form:hidden>
                                    <%--<form:hidden path="payrollLoanType.id"></form:hidden>--%>

                                        <div class="form-group">
                                            <div class="col-sm-6"><span style="color: red;font-size: 12px;"></span>
                                                <label>Employee Name:<span style="color: red;font-size: 12px;"></span></label>
                                                <form:input path="employeeMaster.employeeName" class="form-control" readonly="true"></form:input>
                                                <form:errors path="employeeMaster.employeeName" cssClass="errorDiv"></form:errors>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-6">
                                                <label>Loan Type:<span style="color: red;font-size: 12px;">*</span></label>
                                            <form:select path="payrollLoanType.id" class="form-control ">
                                                <form:option value="" label="-- Select --" ></form:option>
                                                <form:options items="${PayrollLoanTypeList}" ></form:options>
                                            </form:select>
                                            <form:errors path="payrollLoanType.id" cssClass="errorDiv"></form:errors>
                                            </div>

                                            <div class="col-sm-6">
                                                <label> Loan Interest Rates <span style="color: red;font-size: 12px;">*</span></label>
                                            <form:input path="instRate" class="form-control" placeholder="Enter Loan Interest Rates"></form:input>
                                            <form:errors path="instRate" cssClass="errorDiv"></form:errors>
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <div class="col-sm-6">
                                                <label> Loan Amount<span style="color: red;font-size: 12px;">*</span></label>
                                            <form:input path="loanAmount" class="form-control" placeholder="Enter Loan Amount"></form:input>
                                            <form:errors path="loanAmount" cssClass="errorDiv"></form:errors>
                                            </div>

                                            <div class="col-sm-6">
                                                <label> Monthly EMI <span style="color: red;font-size: 12px;">*</span></label>
                                            <form:input path="monltyEmi" class="form-control" placeholder="Enter Monthly EMI"></form:input>
                                            <form:errors path="monltyEmi" cssClass="errorDiv"></form:errors>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <!--                                            <div class="col-sm-6">
                                                                                            <label> Monthly Ins.<span style="color: red;font-size: 12px;">*</span></label>
                                        <%--<form:input path="monthyInstallment" class="form-control" placeholder="Enter Monthly Ins"></form:input>--%>
                                        <%--<form:errors path="monthyInstallment" cssClass="errorDiv"></form:errors>--%>
                                        </div>-->

                                        <div class="col-sm-6">
                                            <label>Start Date:<span style="color: red;font-size: 12px;">*</span></label>
                                            <div class="input-group date form_datetime" data-date-format="mm/yyyy" data-link-field="dtp_input1" >
                                                <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                <form:input path="startDate" class="form-control"  placeholder="Enter Start Date"></form:input>
                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                </div>
                                            <form:errors path="startDate" cssClass="errorDiv"></form:errors>
                                            </div>
                                            <!--                                        <div class="form-group">-->
                                            <div class="col-sm-6">
                                                <label>End Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                <div class="input-group date form_datetime" data-date-format="mm/yyyy" data-link-field="dtp_input1" >
                                                    <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                <form:input path="endDate" class="form-control"  placeholder="Enter End Date"></form:input>
                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                </div>
                                            <form:errors path="endDate" cssClass="errorDiv"></form:errors>
                                            </div>

                                        </div>



                                        <div class="form-group">
                                            <div class="col-sm-6 col-sm-offset-5">
                                                <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
                                            </div>

                                        </div>
                                </form:form>
                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <!--    <script type="text/javascript">
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
                jQuery("#empId").tokenInput(${list}, {
                    preventDuplicates: true,
                    noResultsText: "No Result",
                    tokenLimit: "1",
                    searchingText: "Searching ... .. .",
                    prePopulate: ${preList}
                });
            });
    
        </script>-->

    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
