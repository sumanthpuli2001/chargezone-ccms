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
        <title>Tax Rule Create</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1> Add New Tax Rule:</h1>
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
                                <form:form class="form-horizontal" method="post"
                                           commandName="payrollTaxRule" action="payrollTaxRule.htm?act=createSubmit">
                                    <div class="form-group">
                                        <div class="col-sm-6">
                                            <label>Location:<span style="color: red;font-size: 12px;">*</span></label>
                                            <form:select path="zydexLocationMaster.id" class="form-control ">
                                                <form:option value="" label="-- Select --" ></form:option>
                                                <form:options items="${deptMap}"></form:options>
                                            </form:select>
                                            <form:errors path="zydexLocationMaster.id" cssClass="errorDiv"></form:errors>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-6">
                                                <label>Salary From:<span style="color: red;font-size: 12px;">*</span></label>
                                            <form:input path="salaryFrom" class="form-control" type="number" min="0" max="10000000"></form:input>
                                            <form:errors path="salaryFrom" cssClass="errorDiv"></form:errors>
                                            </div>
                                            <div class="col-sm-6">
                                                <label>Salary To:<span style="color: red;font-size: 12px;">*</span></label>
                                            <form:input path="salaryTo" class="form-control" type="number" min="0" max="10000000" ></form:input>
                                            <form:errors path="salaryTo" cssClass="errorDiv"></form:errors>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-6">
                                                <label>Sex:<span style="color: red;font-size: 12px;">*</span></label>
                                            <form:select path="gender" class="form-control">
                                                <form:option value="0" label="Male" />
                                                <form:option value="1" label="Female" />
                                            </form:select>
                                            <form:errors path="gender" cssClass="errorDiv"></form:errors>
                                            </div>
                                            <div class="col-sm-6">
                                                <label>Tax Percentage (%):<span style="color: red;font-size: 12px;">*</span></label>
                                            <form:input path="taxPercentage"  maxlength="4" class="form-control"></form:input>
                                            <form:errors path="taxPercentage" cssClass="errorDiv"></form:errors>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-6 col-sm-offset-5">
                                                <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" onclick="return pepe();" value="SUBMIT">
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
              if(salaryFrom !='' && salaryTo !=''){
                  salaryFrom = parseFloat(salaryFrom);
                  salaryTo = parseFloat(salaryTo);
                  if(salaryTo<salaryFrom){
                alert(" Salary To is Greater than Salary From.!!");
                flag = false;
                  }
               
              }
              return flag;
            }
        </script>   
</html>
