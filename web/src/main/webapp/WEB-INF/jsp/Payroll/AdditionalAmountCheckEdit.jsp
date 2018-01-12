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
        <title>Additional Amount Check Edit</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Edit Additional Amount Check:</h1>
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
                                           commandName="additionalAmountCheck" action="additionalAmountCheck.htm?act=editSubmit">
                                    <form:hidden path="id"></form:hidden>
                                         <div class="form-group">
                                            <div class="col-sm-6">
                                                <label>Salary Type:<span style="color: red;font-size: 12px;">*</span></label>
                                            <form:select path="payrollSalaryType.id" class="form-control ">
                                                <form:option value="" label="-- Select --" ></form:option>
                                                <form:options items="${SalaryTypeList}"></form:options>
                                            </form:select>
                                            <form:errors path="payrollSalaryType.id" cssClass="errorDiv"></form:errors>
                                            </div>
                                        </div>
                                            <div class="form-group">
                                            <div class="col-sm-6">
                                                <label>Amount Type:<span style="color: red;font-size: 12px;">*</span></label>
                                            <form:select path="amountType" class="form-control ">
                                                <form:option value="" label="-- Select --" ></form:option>
                                                <form:option value="Percentage" label="Percentage" ></form:option>
                                                <form:option value="Amount" label="Amount" ></form:option>
                                            </form:select>
                                            <form:errors path="amountType" cssClass="errorDiv"></form:errors>
                                            </div>
                                        </div>

                                         <div class="form-group">
                                            <div class="col-sm-6">
                                                <label>Enter Amount:<span style="color: red;font-size: 12px;">*</span></label>
                                            <form:input path="salaryTypeAmount" class="form-control" type="number" min="0" max="10000000" placeholder="Enter Amount"/>
                                            <form:errors path="salaryTypeAmount" cssClass="errorDiv"/>
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
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
