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
        <title>Edit Form Sixteen </title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>EDIT FORM SIXTEEN</h1>
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
                                           commandName="payrollFormSixteenMaster" action="payrollFormSixteenMaster.htm?act=editSubmit">
                                    <form:hidden path="id" ></form:hidden>    
                                    <div class="form-group" style="pointer-events: none">
                                        <div class="col-sm-6">
                                            <label>Location:<span style="color: red;font-size: 12px;">*</span></label>
                                            <form:select path="zydexLocationMaster.id" class="form-control ">
                                                <form:option value="" label="-- Select --" ></form:option>
                                                <form:options items="${deptMap}"></form:options>
                                            </form:select>
                                            <form:errors path="zydexLocationMaster.id" cssClass="errorDiv"></form:errors>
                                            </div>
                                     
                                        <div class="col-sm-6">
                                            <label>Financial year<span style="color: red;font-size: 12px;">*</span></label>
                                            <form:select path="payrollFinancialYear.id" class="form-control ">
                                                <form:option value="" label="-- Select --" ></form:option>
                                                <form:options items="${financialYearMap}"></form:options>
                                            </form:select>
                                            <form:errors path="payrollFinancialYear.id" cssClass="errorDiv"></form:errors>
                                            </div>
                                        </div>
                                       
                                        <div class="form-group"> 

                                            <div class="col-sm-6">
                                                <label>Name <span style="color: red;font-size: 12px;">*</span></label>
                                            <form:input path="ename" class="form-control" placeholder="Enter Name"></form:input>
                                            <form:errors path="ename" cssClass="errorDiv"></form:errors>
                                            </div>
                                      
                                            <div class="col-sm-6">
                                                <label> Father Name <span style="color: red;font-size: 12px;">*</span></label>
                                            <form:input path="fname" class="form-control" placeholder="Enter Father Name"></form:input>
                                            <form:errors path="fname" cssClass="errorDiv"></form:errors>
                                            </div>
                                        </div>
                                               <div class="form-group">
                                            <div class="col-sm-6">
                                                <label> Date:<span style="color: red;font-size: 12px;"></span></label>
                                                <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1" >
                                                    <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                <form:input path="date" class="form-control" onchange="dateDifference(this.value);" placeholder="Enter Date"></form:input>
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                </div>
                                                <form:errors path="date" cssClass="errorDiv"></form:errors>
                                            </div>
                                            <div class="col-sm-6">
                                                <label> Member Ship <span style="color: red;font-size: 12px;">*</span></label>
                                            <form:input path="memberShip" class="form-control" placeholder="Enter Member Ship"></form:input>
                                            <form:errors path="memberShip" cssClass="errorDiv"></form:errors>
                                            </div>
                                        </div>
                                           <div class="form-group"> 

                                            <div class="col-sm-6">
                                                <label> Place <span style="color: red;font-size: 12px;">*</span></label>
                                            <form:input path="place" class="form-control" placeholder="Enter Place"></form:input>
                                            <form:errors path="place" cssClass="errorDiv"></form:errors>
                                            </div>
                                       
                                            <div class="col-sm-6">
                                                <label> PAN / GIR No <span style="color: red;font-size: 12px;">*</span></label>
                                            <form:input path="panNo" class="form-control" placeholder="Enter PAN / GIR No"></form:input>
                                            <form:errors path="panNo" cssClass="errorDiv"></form:errors>
                                            </div>
                                        </div>
                                             <div class="form-group"> 

                                            <div class="col-sm-6">
                                                <label> TAN No<span style="color: red;font-size: 12px;">*</span></label>
                                            <form:input path="tanNo" class="form-control" placeholder="Enter TAN No"></form:input>
                                            <form:errors path="tanNo" cssClass="errorDiv"></form:errors>
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
   
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
