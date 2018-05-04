<%-- 
    Document   : PayrollTaxRateMasterEdit
    Created on : Apr 14, 2018, 12:45:07 PM
    Author     : DELL3
--%>

<%-- 
    Document   : PayrollTaxRateMasterNew
    Created on : Apr 14, 2018, 12:44:40 PM
    Author     : DELL3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tax Rate Edit</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Create New Tax Rate:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Edit Tax Rate</li>
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
                                           commandName="payrollTaxRateMaster" action="payrollTaxRate.htm?act=editSubmit">
                                    <form:hidden path="id"/>
                                    <form:hidden path="createdBy"/>
                                    <form:hidden path="createdDate"/>
                                    <form:hidden path="status"/>
                                        <div class="form-group">
                                            <div class="col-sm-6">
                                                <label>Taxable Income From:<span style="color: red;font-size: 12px;">*</span></label>
                                                <form:input path="incomeFrom" min="0" type="number" step="any" placeholder="Enter Income From" class="form-control"></form:input>
                                                <form:errors path="incomeFrom" cssClass="errorDiv"></form:errors>
                                            </div>
                                            <div class="col-sm-6">
                                                <label>Taxable Income To:<span style="color: red;font-size: 12px;">*</span></label>
                                                <form:input path="incomeTo" type="number" step="any" min="0" placeholder="Enter Income To" class="form-control"></form:input>
                                                <form:errors path="incomeTo" cssClass="errorDiv"></form:errors> 
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-6">
                                                <label>Tax Rate(%) :<span style="color: red;font-size: 12px;">*</span></label>
                                                <form:input path="taxRate" min="0" type="number" step="any" placeholder="Enter Tax Rate" class="form-control"></form:input>
                                                <form:errors path="taxRate" cssClass="errorDiv"></form:errors>
                                            </div>
                                        </div>    
                                        <div class="form-group">
                                            <div class="col-sm-6">
                                                <label>Age Limit From:<span style="color: red;font-size: 12px;">*</span></label>
                                                <form:input path="ageFrom" type="number" step="any" placeholder="Enter Age Limit From" class="form-control"></form:input>
                                                <form:errors path="ageFrom" cssClass="errorDiv"></form:errors>
                                            </div>
                                            <div class="col-sm-6">
                                                <label>Age Limit To:<span style="color: red;font-size: 12px;">*</span></label>
                                                 <form:input path="ageTo" type="number" step="any" placeholder="Enter Age Limit To" min="0" class="form-control"></form:input>
                                                <form:errors path="ageTo" cssClass="errorDiv"></form:errors>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-6 col-sm-offset-5">
                                                <input type="submit" class="btn btn-primary" style="width: 100px;" title="" value="SUBMIT">
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
