<%-- 
    Document   : PayrollTaxDeductionComponentEdit
    Created on : Apr 7, 2018, 11:27:31 AM
    Author     : DELL3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tax Deduction Component Edit</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Create Tax Deduction Component:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Edit Tax Deduction Component</li>
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
                                <c:if test="${!empty faliureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${faliureMessage}</div>
                                </c:if>
                                <form:form class="form-horizontal" method="post" commandName="payrollTaxDeductionComponentCreate" 
                                           action="payrollTaxDeduction.htm?act=editTaxDeductionComponentSubmit">
                                        <form:hidden path="componentId"></form:hidden>
                                        <form:hidden path="tdcStatus"></form:hidden>
                                        <form:hidden path="createdBy"></form:hidden>
                                        <form:hidden path="createdDate"></form:hidden>
                                        <div class="form-group">
                                            <div class="col-sm-6">
                                                <label>Section:<span style="color: red;font-size: 12px;">*</span></label>
                                                <form:select path="payrollTaxDeductionMaster.id" id="selectSectionId" class="form-control">
                                                    <form:option value="" label="Select"/>
                                                    <form:options items="${sectionsMap}"/>
                                                </form:select>
                                                <form:errors path="payrollTaxDeductionMaster.id" cssClass="errorDiv"></form:errors>
                                            </div> 
                                            <div class="col-sm-6">
                                                <label>Component:<span style="color: red;font-size: 12px;">*</span></label>
                                                <form:input path="component" placeholder="Enter Component" class="form-control"></form:input>
                                                <form:errors path="component" cssClass="errorDiv"></form:errors>
                                            </div>
                                            <div class="col-sm-6">
                                                <label>Age Limit:<span style="color: red;font-size: 12px;">*</span></label>
                                                <form:input path="ageLimit"  type="number"  placeholder="Enter Age Limit" min="0" class="form-control"></form:input>
                                                <form:errors path="ageLimit" cssClass="errorDiv"></form:errors>
                                            </div>
                                            <div class="col-sm-6">
                                                <label>Tax Saving Limit:<span style="color: red;font-size: 12px;">*</span></label>
                                                <form:input path="taxSavingLimit" type="number" placeholder="Enter Tax Saving Limit" min="0" class="form-control"></form:input>
                                                <form:errors path="taxSavingLimit" cssClass="errorDiv"></form:errors>
                                            </div>
                                        </div>
                                       
                                        <div class="form-group">
                                            <div class="col-sm-6 col-sm-offset-5">
                                                <input type="submit" class="btn btn-primary" style="width: 100px;" onclick="return pepe();" title="" value="SUBMIT">
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
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

</html>

