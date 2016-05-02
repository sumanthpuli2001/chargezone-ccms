<%-- 
    Document   : VisitorManagementCreate
    Created on : Nov 7, 2015, 3:57:22 PM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
        <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visitor Management</title>
        <script>
            function buttonFun1() {
                var className = $('#minusId1').attr('class');
                if (className == 'fa fa-plus') {
                    document.getElementById('spanId1').innerHTML = 'Minimize';
                } else {
                    document.getElementById('spanId1').innerHTML = 'Expand';
                }
            }
            function buttonFun2() {
                var className = $('#minusId2').attr('class');
                if (className == 'fa fa-plus') {
                    document.getElementById('spanId2').innerHTML = 'Minimize';
                } else {
                    document.getElementById('spanId2').innerHTML = 'Expand';
                }
            }
            function buttonFun3() {
                var className = $('#minusId3').attr('class');
                if (className == 'fa fa-plus') {
                    document.getElementById('spanId3').innerHTML = 'Minimize';
                } else {
                    document.getElementById('spanId3').innerHTML = 'Expand';
                }
            }
            function buttonFun4() {
                var className = $('#minusId4').attr('class');
                if (className == 'fa fa-plus') {
                    document.getElementById('spanId4').innerHTML = 'Minimize';
                } else {
                    document.getElementById('spanId4').innerHTML = 'Expand';
                }
            }
            function buttonFun5() {
                var className = $('#minusId5').attr('class');
                if (className == 'fa fa-plus') {
                    document.getElementById('spanId5').innerHTML = 'Minimize';
                } else {
                    document.getElementById('spanId5').innerHTML = 'Expand';
                }
            }

        </script>
    </head>
    <body>
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>Visitor Management Form : </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Visitor Management System</li>
                </ol>
            </section>
            <c:if test="${!empty successMessage}">
                <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
            </c:if>
            <c:if test="${!empty failureMessage}">
                <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
            </c:if>
            <!-- Main content -->
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <form:form action="visitorManagement.htm?act=createSubmit" method="post" commandName="visitorManagement"
                                           name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
                                    <form:hidden path="employeeMasterByEmployeeMasterId.id"></form:hidden>
                                        <!--Read only entries Starts here-->   
                                         <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                        <div class="box box-info collapsed-box ">
                                            <div class="box-header">
                                                <h3 class="box-title">Employee Detail:</h3>
                                                <div class="box-tools pull-right">
                                                    <span id="spanId1">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun1();"><i class="fa fa-plus" id="minusId1" ></i></button>
                                                </div>
                                            </div><!-- /.box-header -->
                                            <div class="box-body no-padding">
                                                <div class="row">
                                                    <div class="col-md-12 col-sm-12">
                                                        <div class="form-group">
                                                            <div class="col-sm-2">
                                                                <label>Employee No.:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="employeeMasterByEmployeeMasterId.employeeId" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                            </div>
                                                            <div class="col-sm-2">
                                                                <label>Employee Name:</label>
                                                            </div>
                                                            <div class="col-sm-4">   
                                                            <form:input path="employeeMasterByEmployeeMasterId.employeeName" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-sm-2">
                                                                <label>Department:</label>
                                                            </div>
                                                            <div class="col-sm-4">   
                                                            <form:input path="employeeMasterByEmployeeMasterId.departmentMaster.departmentName" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                            </div>
                                                            <div class="col-sm-2">
                                                                <label>Designation:</label>
                                                            </div>
                                                            <div class="col-sm-4">   
                                                            <form:input path="employeeMasterByEmployeeMasterId.designationMaster.designationName" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                <!--employeeMasterByEmployeeMasterId.designationMaster.designationName-->
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-sm-2">
                                                                <label>Level:</label>
                                                            </div>
                                                            <div class="col-sm-4">   
                                                            <form:input path="employeeMasterByEmployeeMasterId.levelMaster.level" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                            </div>
                                                            <div class="col-sm-2">
                                                                <label>Reporting Manager:</label>
                                                            </div>
                                                            <div class="col-sm-4">   
                                                            <form:input path="" class="form-control" size="16" type="text" value="${reportingLevel1}" readonly="true"></form:input>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class=" col-sm-2">
                                                                <label>Work Location:</label>
                                                            </div>
                                                            <div class="col-sm-4">   
                                                            <form:input path="employeeMasterByEmployeeMasterId.locationMaster.location" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>                 
                                        <div class="box box-info collapsed-box">
                                            <div class="box-header">
                                                <h3 class="box-title">Visitor's Detail:</h3>
                                                <div class="box-tools pull-right">
                                                    <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2();"><i class="fa fa-plus" id="minusId2" ></i></button>
                                                </div>
                                            </div><!-- /.box-header -->
                                            <div class="box-body no-padding">
                                                <section class="content">
                                                    <div class="row">
                                                        <div class="col-md-12 col-sm-12">
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Visitor's Name<span style="color: red;font-size: 12px;">*</span></label>
                                                                <div class="col-sm-7">
                                                                <form:input path="visitorName" class="form-control" size="16" type="text" value="" ></form:input>
                                                                <form:errors path="visitorName" cssClass="errorDiv"></form:errors>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Visitor's Organization:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <div class="col-sm-7">
                                                                <form:input path="visitorOrganization" class="form-control" size="16" type="text" value="" ></form:input>
                                                                <form:errors path="visitorOrganization" cssClass="errorDiv"></form:errors>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Incoming Date & Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <div class="col-sm-7">
                                                                    <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy hh:ii " data-link-field="dtp_input1">
                                                                    <form:input path="incomingDateTime" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                    <form:errors path="incomingDateTime" cssClass="errorDiv"></form:errors>
                                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Visitor Visits To:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <div class="col-sm-7">
                                                                <form:select path="visitorVisitedLocation.id" class="form-control">
                                                                    <form:option value="">--Select--</form:option>
                                                                    <c:forEach var="visitedLocationMap" items="${visitedLocationMap}">
                                                                        <form:option value="${visitedLocationMap.key}">${visitedLocationMap.value}</form:option>
                                                                    </c:forEach>
                                                                </form:select> 
                                                                <form:errors path="visitorVisitedLocation.id" cssClass="errorDiv"></form:errors>
                                                                <%--<form:errors path="visitorVisitedLocation.id" cssClass="errorDiv"></form:errors>--%>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Visitor's Contact Detail:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <div class="col-sm-7">
                                                                <form:textarea path="visitorContactDetail"  class="form-control" size="16" type="text" value=""></form:textarea>
                                                                <form:errors path="visitorContactDetail" cssClass="errorDiv"></form:errors>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Visitor Coming From:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <div class="col-sm-7">
                                                                <form:textarea path="visitorComingFrom"  class="form-control" size="16" type="text" value=""></form:textarea>
                                                                <form:errors path="visitorComingFrom" cssClass="errorDiv"></form:errors>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Accessories:</label>
                                                                <div class="col-sm-7">
                                                                <form:textarea path="accesories"  class="form-control" size="16" type="text" value=""></form:textarea>
                                                                <form:errors path="accesories" cssClass="errorDiv"></form:errors>
                                                                </div>
                                                            </div>
                                                        </div>
                                                </section>
                                            </div>
                                        </div>
                                        <div class="box box-info collapsed-box">
                                            <div class="box-header">
                                                <h3 class="box-title">Reason In Detail:</h3>
                                                <div class="box-tools pull-right">
                                                    <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun3();"><i class="fa fa-plus" id="minusId3" ></i></button>
                                                </div>
                                            </div><!-- /.box-header -->
                                            <div class="box-body no-padding">
                                                <section>
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <!-- Custom Tabs -->
                                                            <div class="nav-tabs-custom">
                                                                <div class="tab-content">
                                                                    <div class="form-group">
                                                                        <label class="col-sm-3 control-label">Reason:<span style="color: red;font-size: 12px;">*</span></label>
                                                                        <div class="col-sm-7">
                                                                        <form:textarea path="reason" rows="6" class="form-control" size="16" type="text" value=""></form:textarea>
                                                                        <form:errors path="reason" cssClass="errorDiv"></form:errors>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </section>
                                            </div> 
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-5 col-sm-4">
                                                <button type="submit" class="btn btn-primary" id="saveSubmit1" style="width: 100px;text-align: center;font-size:16px ;">Submit</button>
                                                <!--                <button type="submit" class="btn btn-primary"  >Withdraw</button>-->
                                            </div> 
                                        </div>
                                    </div>
                                </div>
                            </div>

                    </form:form>
            </section>

        </div>
        <script type="text/javascript">
            $('.form_datetime').datetimepicker({
                //language:  'fr',
                weekStart: 1,
//                todayBtn: 1,
                autoclose: 1,
                todayHighlight: 1,
                startView: 2,
                forceParse: 0,
                showMeridian: 1,
                startDate: new Date()
            });
        </script>
        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    </body>
</html>
