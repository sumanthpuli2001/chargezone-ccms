<%--
    Document   : PayrollProfessionalTaxCreate
    Created on : Jul 13, 2016, 4:02:56 PM
    Author     : AJAY <ajay@bulwarks.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <script>
        function checkBlankField() {
            var flag = true;
            if ($('#salaryFrom').val() == '') {
                document.getElementById('salaryFromError').innerHTML = '-It must not be empty or white space.';
                flag = false;
            }
            if ($('#salaryTo').val() == '') {
                document.getElementById('salaryToError').innerHTML = '-It must not be empty or white space.';
                flag = false;
            }
            if ($('#amount').val() == '') {
                document.getElementById('amountError').innerHTML = '-It must be selected.';
                flag = false;
            }
            return  flag;
        }

        function OnchangeFunction(idString) {
            if (document.getElementById(idString).innerHTML != null) {
                document.getElementById(idString).innerHTML = '';
            }
        }
    </script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Professional Tax Create</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>ADD NEW PROFESSIONAL TAX</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Create</li>
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
                                <form:form class="form-horizontal" method="post" onsubmit='return checkBlankField();'
                                           commandName="payrollProfessionalTax" action="payrollProfessionalTax.htm?act=createSubmit">

                                    <div class="form-group">
                                        <div class="col-sm-6">
                                            <label>Salary From:<span style="color: red;font-size: 12px;">*</span></label>
                                            <form:input path="salaryFrom" maxlength="10" placeholder="Enter Salary From" class="form-control" onchange="OnchangeFunction('salaryFromError');"></form:input>
                                                <span style="font-size: 14px; color: #dd4b39;" id="salaryFromError"></span>
                                            <form:errors path="salaryFrom" cssClass="errorDiv"></form:errors>
                                            </div>
                                            <div class="col-sm-6">
                                                <label>Salary To:<span style="color: red;font-size: 12px;">*</span></label>
                                            <form:input path="salaryTo"  maxlength="10" placeholder="Enter Salary To"  class="form-control" onchange="OnchangeFunction('salaryToError');"></form:input>
                                                <span style="font-size: 14px; color: #dd4b39;" id="salaryToError"></span>
                                            <form:errors path="salaryTo" cssClass="errorDiv"></form:errors>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-6">
                                                <label>Amount:<span style="color: red;font-size: 12px;">*</span></label>
                                            <form:input path="amount" type="number" min="0" max="10000000" placeholder="Enter Amount" class="form-control" onchange="OnchangeFunction('amountError');"></form:input>
                                                <span style="font-size: 14px; color: #dd4b39;" id="amountError"></span>
                                            <form:errors path="amount" cssClass="errorDiv"></form:errors>
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
    <script type="text/javascript">
        function pepe() {
            var flag = true;
            var salaryFrom = document.getElementById("salaryFrom").value;
            var salaryTo = document.getElementById("salaryTo").value;
            if (salaryFrom != '' && salaryTo != '') {
                salaryFrom = parseFloat(salaryFrom);
                salaryTo = parseFloat(salaryTo);
                if (salaryTo < salaryFrom) {
                    alert(" Salary To is Greater than Salary From.!!");
                    flag = false;
                }

            }
            return flag;
        }
    </script>   
</html>