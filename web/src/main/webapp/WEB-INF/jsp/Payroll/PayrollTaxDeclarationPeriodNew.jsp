<%-- 
    Document   : PayrollTaxDeclarationPeriodNew
    Created on : Apr 11, 2018, 11:07:34 AM
    Author     : DELL3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Tax Declaration Period New</title>
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Create New Declaration Period</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Create New Declaration Period</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty faliureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${faliureMessage}</div>
        </c:if>
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="box-header">
                            </div>
                            <div class="box-body no-padding">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12">
                                        <div class="table table-bordered">
                                        </div>
                                        <!--<div class="form-group">-->

                                        <form:form class="form-horizontal" method="post"
                                                   commandName="payrollTaxDeclarationPeriodMaster" action="payrollTaxDeclaration.htm?act=clickSubmit">
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Financial Year:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:select path="payrollFinancialYear.id" id="selectFinancialYearId" class="form-control">
                                                        <form:option value="" label="Select"/>
                                                        <form:options items="${financialYearMap}"/>
                                                    </form:select>
                                                    <form:errors path="payrollFinancialYear.id" cssClass="errorDiv"></form:errors>
                                                </div> 
                                                <div class="col-sm-6">
                                                    <label>Declaration Threshold Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="input-group date form_Startdatetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1" id="datetimepicker6">
                                                    <form:input path="declarationThresholdDate" class="form-control" id="startDate"  placeholder="Enter Declaration Threshold Date" readonly="true" ></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    <form:errors path="declarationThresholdDate" cssClass="errorDiv"></form:errors>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label>Proof Threshold Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="input-group date form_Enddatetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1" id="datetimepicker7">
                                                        <form:input path="proofThresholdDate" class="form-control" id="endDate" onchange="getDate();" placeholder="Enter proof Threshold Date" readonly="true"></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                    </div>
                                                    <form:errors path="proofThresholdDate" cssClass="errorDiv"></form:errors>
                                                </div>
  
                                                <div class="form-group">
                                                    <div class="col-sm-6 col-sm-offset-5" style="margin-top:20px">
                                                        <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
                                                    </div>
                                                 </div>
                                            </form:form>
                                        <!--</div>-->

                                    </div><!-- /.col -->
                                </div><!-- /.row -->
                            </div>
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section>
    </div>
    
    <script type="text/javascript"> 
      
    $('.form_Startdatetime').datetimepicker({
                //language:  'fr',
                dateFormat: 'dd/MM/yyyy',
                weekStart: 1,
                todayBtn: 1,
                autoclose: 2,
                todayHighlight: 1,
                startView: 2,
                minView: 2,
                forceParse: 0,
                showMeridian: 1
            });
            
            $('.form_Enddatetime').datetimepicker({
                //language:  'fr',
                dateFormat: 'dd/MM/yyyy',
                weekStart: 1,
                todayBtn: 1,
                autoclose: 2,
                todayHighlight: 1,
                startView: 2,
                minView: 2,
                forceParse: 0,
                showMeridian: 1
            });
    
  /*  function checkDate()
    {
        var d1 = document.getElementById('startDate').value;
        var d2 = document.getElementById('endDate').value;
        
        var date1 = Date.parse(d1.toString());
        var date2 = Date.parse(d2.toString());
        
        date
        
    }*/
      
    
    </script>

    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <script src="StorageYard/Plugins/ckeditor/ckeditor.js"></script>
    <script src="StorageYard/Plugins/ckeditor/samples/js/sample.js"></script>
    <!--<link rel="stylesheet" href="StorageYard/Plugins/ckeditor/samples/css/samples.css">-->
    <link rel="stylesheet" href="StorageYard/Plugins/ckeditor/samples/toolbarconfigurator/lib/codemirror/neo.css">
    <script>
        initSample();
    </script>
</html>

