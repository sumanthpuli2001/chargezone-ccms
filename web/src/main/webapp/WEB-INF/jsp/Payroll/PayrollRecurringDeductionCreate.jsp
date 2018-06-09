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
        <title>Recurring Deduction Create</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>ADD NEW RECURRING DEDUCTION</h1>
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
                                           commandName="payrollRecurringDeduction" action="payrollRecurringDeduction.htm?act=createSubmit">
                                    <div class="form-group">
                                         <div class="col-sm-6"><span style="color: red;font-size: 12px;"></span>
                                                    <label>Employee Name:<span style="color: red;font-size: 12px;"></span></label>
                                                    <input type="text" name="empId" id="empId" class="form-control">
                                                        <%--<form:errors path="employeeMaster.id" cssClass="errorDiv"></form:errors>--%>
                                                    </div>
                                                    </div>
                                                    
                                       <div class="form-group"> 
                                        <div class="col-sm-6">
                                                <label>Title <span style="color: red;font-size: 12px;">*</span></label>
                                            <form:input path="title" class="form-control" placeholder="Enter Title"></form:input>
                                            <form:errors path="title" cssClass="errorDiv"></form:errors>
                                            </div>
                                            
                                        <div class="col-sm-6">
                                                <label> Amount <span style="color: red;font-size: 12px;">*</span></label>
                                            <form:input path="amount" class="form-control" placeholder="Enter Amount" type="number" min="0" max="1000000"></form:input>
                                            <form:errors path="amount" cssClass="errorDiv"></form:errors>
                                            </div>
                                                </div>  
                                            
                                     <div class="form-group">   
                                                 <div class="col-sm-6">
                                                <label>Start Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1" >
                                                    <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                <form:input path="startDate" class="form-control" readonly="true" onchange="dateDifference(this.value);" placeholder="Enter Start Date"></form:input>
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                </div>
                                                <form:errors path="startDate" cssClass="errorDiv"></form:errors>
                                               </div>
                                               
                                            <div class="col-sm-6">
                                                <label>End Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1" >
                                                    <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                <form:input path="endDate" class="form-control" readonly="true" onchange="dateDifference(this.value);" placeholder="Enter End Date"></form:input>
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                </div>
                                                <form:errors path="endDate" cssClass="errorDiv"></form:errors>
                                                </div>   
                                                </div> 
                                               
                                               
                                      
                                               
                                         <div class="form-group">
                                        <div class="col-sm-6">
                                                <label>Description<span style="color: red;font-size: 12px;">*</span></label>
                                        <form:textarea path="description" class="form-control" placeholder="Enter Description"></form:textarea>
                                            <form:errors path="description" cssClass="errorDiv"></form:errors>
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
            jQuery("#empId").tokenInput(${list}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. .",
                prePopulate: ${preList}
            });
        });

    </script>
   <script type="text/javascript">
            function pepe() {
            
              var startDate = document.getElementById("startDate").value;
              var endDate = document.getElementById("endDate").value;
             leaveStartDate = startDate.split('/');
            leaveEndDate = endDate.split('/');
             leaveStartDate = new Date(leaveStartDate[2], leaveStartDate[1], leaveStartDate[0]);
             leaveEndDate = new Date(leaveEndDate[2], leaveEndDate[1], leaveEndDate[0]);
               
               
              if(leaveStartDate > leaveEndDate){
                  
                alert(" End Date is Greater than Start Date.!!");
              
                  }
               
              
              
            }
        </script>   
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
