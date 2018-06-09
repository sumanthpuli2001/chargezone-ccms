<%-- 
    Document   : PayrollTaxDeductionEdit
    Created on : Apr 5, 2018, 5:08:29 PM
    Author     : DELL3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tax Deduction Edit</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>EDIT NEW TAX DEDUCTION</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Create New Tax Deduction</li>
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
                                           commandName="payrollTaxDeductionMaster" action="payrollTaxDeduction.htm?act=editSubmit">
                                        <form:hidden path="id"></form:hidden>
                                        <form:hidden path="tdStatus"></form:hidden>
                                        <form:hidden path="createdBy"></form:hidden>
                                        <form:hidden path="createdDate"></form:hidden>
                                        <div class="form-group">
                                            <div class="col-sm-6">
                                                <label>Section:<span style="color: red;font-size: 12px;">*</span></label>
                                                <form:input path="section" placeholder="Enter Section" class="form-control"></form:input>
                                                <form:errors path="section" cssClass="errorDiv"></form:errors>
                                            </div>
                                            <div class="col-sm-6">
                                                <label>Tax Saving Limit:<span style="color: red;font-size: 12px;">*</span></label>
                                                <form:input path="taxSavingLimit"  type="number" placeholder="Enter Tax Saving Limit"  class="form-control"></form:input>
                                                <form:errors path="taxSavingLimit" cssClass="errorDiv"></form:errors> 
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-6">
                                                <label>Description:<span style="color: red;font-size: 12px;">*</span></label>
                                                <form:input path="description" placeholder="Enter Description" class="form-control"></form:input>
                                                <form:errors path="description" cssClass="errorDiv"></form:errors>
                                            </div>
                                            <div class="col-sm-6">
                                                <label>Additional Tax Benefit:<span style="color: red;font-size: 12px;">*</span></label>
                                                <form:input path="additionalTaxBenefit" type="number" placeholder="Enter Additional Tax Benefit" class="form-control"></form:input>
                                                <form:errors path="additionalTaxBenefit" cssClass="errorDiv"></form:errors>
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
