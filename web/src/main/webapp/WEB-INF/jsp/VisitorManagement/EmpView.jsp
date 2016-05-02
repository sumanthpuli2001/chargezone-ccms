<%-- 
    Document   : EmpView
    Created on : Nov 16, 2015, 5:44:26 PM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Visitor Request</title>
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
                <h1>Visitor Request: </h1>
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
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <form:form action="visitorManagement.htm?act=returnCreateSubmit&id=${visitorManagement.id}" method="post" commandName="visitorManagement"
                                           name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
                                    <form:hidden path="employeeMasterByEmployeeMasterId.id"></form:hidden>
                                    <form:hidden path="id"></form:hidden>
                                        <!--Read only entries Starts here-->

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
                                                            <form:input path="" class="form-control" size="16" type="text" value="${employeeMaster.employeeId}" readonly="true"></form:input>
                                                            </div>
                                                            <div class=" col-sm-2">
                                                                <label>Employee Name:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="" class="form-control" size="16" type="text" value="${employeeMaster.employeeName}" readonly="true"></form:input>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class=" col-sm-2">
                                                                <label>Department:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="" class="form-control" size="16" type="text" value="${employeeMaster.departmentMaster.departmentName}" readonly="true"></form:input>
                                                            </div>
                                                            <div class="col-sm-2">
                                                                <label>Designation:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="" class="form-control" size="16" type="text" value="${employeeMaster.designationMaster.designationName}" readonly="true"></form:input>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class=" col-sm-2">
                                                                <label>Level:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="" class="form-control" size="16" type="text" value="${employeeMaster.levelMaster.level}" readonly="true"></form:input>
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
                                                            <form:input path="" class="form-control" size="16" type="text" value="${employeeMaster.locationMaster.location}" readonly="true"></form:input>
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
                                                                <label class="col-sm-3 control-label">Visitor's Name:</label>
                                                                <div class="col-sm-7">
                                                                <form:input path="visitorName" class="form-control" size="16" type="text" value=""></form:input>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Visitor's Organization:</label>
                                                                <div class="col-sm-7">
                                                                <form:input path="visitorOrganization" class="form-control" size="16" type="text" value=""  ></form:input>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Incoming Date & Time:</label>
                                                                <div class="col-sm-7">
                                                                    <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy hh:ii " data-link-field="dtp_input1">
                                                                    <form:input path="incomingDateTime" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Visitor Visits To:</label>
                                                                <div class="col-sm-7">
                                                                <form:select path="visitorVisitedLocation.id" value="" class="form-control">
                                                                    <%--<form:option value="">${visitorManagement.locationMaster.location}</form:option>--%>
                                                                    <c:forEach var="visitedLocationMap" items="${visitedLocationMap}">
                                                                        <form:option value="${visitedLocationMap.key}">${visitedLocationMap.value}</form:option>
                                                                    </c:forEach>
                                                                </form:select>   
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="col-sm-3 control-label">Visitor's Contact Detail:</label>
                                                            <div class="col-sm-7">
                                                                <form:textarea path="visitorContactDetail"  class="form-control" size="16" type="text" value=""></form:textarea>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Visitor Coming From:</label>
                                                                <div class="col-sm-7">
                                                                <form:textarea path="visitorComingFrom"  class="form-control" size="16" type="text" value="" ></form:textarea>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Accessories:</label>
                                                                <div class="col-sm-7">
                                                                <form:textarea path="accesories"  class="form-control" size="16" type="text" value="" ></form:textarea>
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
                                                                        <label class="col-sm-3 control-label">Reason:</label>
                                                                        <div class="col-sm-7">
                                                                        <form:textarea path="reason" rows="6" class="form-control" size="16" type="text" value="" ></form:textarea>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </section>
                                            </div> 
                                        </div>
                                    <c:if test="${visitorManagement.status eq 4 || visitorManagement.status eq 3 || visitorManagement.status eq 9}">
                                        <div class="box box-info collapsed-box">
                                            <div class="box-header">
                                                <h3 class="box-title">Return Reason:</h3>
                                                <div class="box-tools pull-right">
                                                    <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun4();"><i class="fa fa-plus" id="minusId4" ></i></button>
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
                                                                        <label class="col-sm-3 control-label">Reason:</label>
                                                                        <div class="col-sm-7">
                                                                            <form:textarea path="securityRemark" rows="6" class="form-control" size="16" type="text" value="" readonly="true"></form:textarea>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </section>
                                                </div> 
                                            </div> 
                                    </c:if>
                                    <div class="form-group">
                                        <div class="col-sm-offset-5 col-sm-4">
                                            <c:if test="${visitorManagement.status eq 4}">
                                                &nbsp;&nbsp;<button type="submit" class="btn btn-primary" id="saveSubmit1" value="Submit">SUBMIT</button>
                                            </c:if>  
                                            <c:if test="${visitorManagement.status eq 9}">
                                                &nbsp;&nbsp;<button type="submit"  class="btn btn-primary" id="saveSubmit1"  value="Submit">SUBMIT</button>
                                            </c:if>
                                            <!--onclick="withdrawreturnSubmit(${visitorManagement.id})"-->
                                            <c:if test="${visitorManagement.status eq 1 }">
                                                <button type="submit"  class=" btn btn-warning" onclick="withdraw(${visitorManagement.id})" value="Withdraw"><b>WITHDRAW</b></button>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                            </form:form>
                        </div><!-- nav-tabs-custom -->
                    </div>
                </div>
        </div>
        <script type="text/javascript">
            $('.form_datetime').datetimepicker({
                //language:  'fr',
                weekStart: 1,
                todayBtn: 1,
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
