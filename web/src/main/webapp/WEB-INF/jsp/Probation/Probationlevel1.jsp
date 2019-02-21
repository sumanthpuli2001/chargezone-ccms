<%--
    Document   : Probationlevel1
    Created on : Dec 16, 2015, 3:38:34 PM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
        <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Probation To Confirmation</title>
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
        <script>
            function saveSubmit11() {
                var flag3 = true;
//            alert("called");
                var selectedValue = document.getElementById("RecomendationTypeSelectId").value;
//                alert(selectedValue);
                if (selectedValue == "Extend") {
                    if (document.getElementById("extendedmonth").value == '') {
                        document.getElementById("recommendationExtendPeriodError").innerHTML = "- It must be Selected";
                        flag3 = false;
                    } else {
                        document.getElementById("recommendationExtendPeriodError").innerHTML = "";
                    }
                    if (document.getElementById("remarkid").value == '') {
                        document.getElementById("recommendationRemarkError").innerHTML = "- It must be Selected";
                        flag3 = false;
                    } else {
                        document.getElementById("recommendationRemarkError").innerHTML = "";
                    }
                } else if (selectedValue == "No") {
                    if (document.getElementById("remarkid").value == '') {
                        document.getElementById("recommendationRemarkError").innerHTML = "- It must be Selected";
                        flag3 = false;
                    } else {
                        document.getElementById("recommendationRemarkError").innerHTML = "";
                    }
                }

                if (flag3) {

                    flag3 = false;
                    document.getElementById('saveSubmit1').innerHTML = 'Saving ... .. .';
                    document.form1.submit();
                    return true;
                } else {
                    return false;
                }
            }
        </script>
    </head>
    <style>
        table, th, th {
            border: 2px solid black;
            border-collapse: collapse;
        }
        th, th {
            padding: 15px;
        }
        td{
            border: 1px solid black;
            border-collapse: collapse;

        }

    </style>
    <body>
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>PROBATION TO CONFIRMATION FORM  </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Probation To Confirmation</li>
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
                                <form:form action="probationToConfirmation.htm?act=level1Submit" method="post" commandName="ptc"
                                           name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
                                    <form:hidden path="employeeMasterByEmployeeMasterId.id"></form:hidden>
                                    <%--<form:hidden path="reportingManagerId"></form:hidden>--%>
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
                                                            <input type="hidden" id="empId" name="empId" value="${empid}" />
                                                            
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-sm-2">
                                                                <label>Department:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="employeeMasterByEmployeeMasterId.departmentMaster.departmentName" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                            </div>
                                                            <div class="col-sm-2">
                                                                <label>Sub Team:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="employeeMasterByEmployeeMasterId.employeeSubType.subType" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                            </div>
                                                            
                                                            
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-sm-2">
                                                                <label>Designation:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="employeeMasterByEmployeeMasterId.designationMaster.designationName" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                <!--employeeMasterByEmployeeMasterId.designationMaster.designationName-->
                                                            </div>
                                                            
                                                            <div class="col-sm-2">
                                                                <label>Level:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="employeeMasterByEmployeeMasterId.levelMaster.level" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class=" col-sm-2">
                                                                <label>Work Location:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="employeeMasterByEmployeeMasterId.locationMaster.location" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                            </div>
                                                            <div class="col-sm-2">
                                                                <label>Reporting Manager:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="reportingManagerId" class="form-control" size="16" type="text" value="${reportingLevel1}" readonly="true"></form:input>
                                                            </div>
                                                            
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="box box-info collapsed-box">
                                            <div class="box-header">
                                                <h3 class="box-title">Assessment Period:</h3>
                                                <div class="box-tools pull-right">
                                                    <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                                    <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2();"><i class="fa fa-plus" id="minusId2" ></i></button>
                                                </div>
                                            </div><!-- /.box-header -->
                                            <div class="box-body no-padding">
                                                <div class="row">
                                                    <div class="col-md-12 col-sm-12">
                                                        <div class="form-group">
                                                            <label class="col-sm-3 control-label">Form Issue Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <div class=" col-sm-7">
                                                                <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy hh:ii " data-link-field="dtp_input1">
                                                                <form:input path="" name="formIssueDate" class="form-control" size="16" type="text" value="${ptc.formIssueDate}"  readonly="true"></form:input>
                                                                <%--<form:errors path="" cssClass="errorDiv"></form:errors>--%>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="col-sm-3 control-label">From Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <div class=" col-sm-7">
                                                                <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy hh:ii " data-link-field="dtp_input1">
                                                                <form:input path="assessmentFromDate" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                                <form:errors path="assessmentFromDate" cssClass="errorDiv"></form:errors>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="col-sm-3 control-label">To Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <div class=" col-sm-7">
                                                                <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy hh:ii" data-link-field="dtp_input1">
                                                                <form:input path="assessmentToDate" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                                <form:errors path="assessmentToDate" cssClass="errorDiv"></form:errors>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div><!-- /.col -->
                                                </div><!-- /.row -->
                                            </div><!-- /.box-body -->
                                        </div>
                                        <div class="box box-info collapsed-box">
                                            <div class="box-header">
                                                <h3 class="box-title">General</h3><span style="color: red;font-size: 12px;">*</span>
                                                <div class="box-tools pull-right">
                                                    <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                                    <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun3();"><i class="fa fa-plus" id="minusId3" ></i></button>
                                                </div>
                                            </div><!-- /.box-header -->
                                            <div class="box-body no-padding">
                                                <div class="row">
                                                    <div class="col-md-12 col-sm-12">
                                                                <label>Brief description of role handled by Employee:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                            <form:textarea path="jobHandled" class="form-control" size="16" type="text" value=""></form:textarea>
                                                            <form:errors path="jobHandled" cssClass="errorDiv"></form:errors>
                                                            </div>
                                                        </div>
                                                    </div><!-- /.col -->
                                                    <div class="col-md-12 col-sm-12">
                                                                <label>Describe the extent to which Employee has fulfilled the requirement of role:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                            <form:textarea path="employeeFullfill" class="form-control" size="16" type="text" value=""></form:textarea>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-12 col-sm-12">
                                                                <label>Describe areas of Employee’s strengths:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                            <form:textarea path="employeeStrengths" class="form-control" size="16" type="text" value=""></form:textarea>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-12 col-sm-12">
                                                                <label>Describe areas where Employee can improve upon:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                            <form:textarea path="employeeImprove" class="form-control" size="16" type="text" value=""></form:textarea>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-12 col-sm-12">
                                                                <label>Training programs attended by Employee during probation period:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                            <form:textarea path="employeeTrainingAttend" class="form-control" size="16" type="text" value=""></form:textarea>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div><!-- /.row -->
                                            </div><!-- /.box-body -->
                                        </div>
    <div class="box box-info collapsed-box">
        <div class="box-header">
            <h3 class="box-title">Competency Assessment </h3><span style="color: red;font-size: 12px;">*</span>
            <div class="box-tools pull-right">
                <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun4();"><i class="fa fa-plus" id="minusId4" ></i></button>
            </div>
        </div><!-- /.box-header -->

        <div class="box-body no-padding">
            <div class="row">
                <div class="col-md-12 col-sm-12">
                    <div class="form-group">
                        <div class="col-md-3 col-sm-3">
                        </div>
                        <div class="table" style="margin-left: 2%;">
                            <label>Rate the Employee’s performance during their probation period. Based on the Team Leader’s evaluation and observations during the probation period, evaluate the Employee on a 5-point scale where 5 is an indicator of excellence and 1 signifies poor performance.</label>
                            <table style="width:95%; ">
                                <tr>
                                    <th colspan="7" style="text-align: center" rowspan = "2">Competency</th>
                                    <th colspan="5" style="text-align: center">Rating (click radio button at appropriate place)</th>
                                </tr>        
                                <tr>
                                    <th colspan="1" style="text-align: center">1</th>
                                    <th colspan="1" style="text-align: center">2</th>
                                    <th colspan="1" style="text-align: center">3</th>
                                    <th colspan="1" style="text-align: center">4</th>
                                    <th colspan="1" style="text-align: center">5</th>
                                </tr>
                                <tr>
                                    <th colspan="12" style="text-align: center">Job Knowledge</th>

                            </tr>
                            <tr>
                                <td  colspan="7">Understanding of job requirements</td>
                                <th colspan="1" rowspan=""><form:radiobutton path="jobKnowledge1" name="jobKnowledge1" value="1" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="jobKnowledge1" name="jobKnowledge1"  value="2" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="jobKnowledge1" name="jobKnowledge1"  value="3" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="jobKnowledge1" name="jobKnowledge1"  value="4" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="jobKnowledge1" name="jobKnowledge1"  value="5" required="" /> </th>
                            </tr>
                            <tr>
                                <td  colspan="7">Demonstrated a desire to learn and accepted role</td>
                                <th colspan="1" rowspan=""><form:radiobutton path="jobKnowledge2" name="jobKnowledge2" value="1" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="jobKnowledge2" name="jobKnowledge2"  value="2" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="jobKnowledge2" name="jobKnowledge2"  value="3" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="jobKnowledge2" name="jobKnowledge2"  value="4" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="jobKnowledge2" name="jobKnowledge2"  value="5" required="" /> </th>
                            </tr>
                            <tr>
                                <td  colspan="7">Desire to acquire knowledge of key aspect of job</td>
                                <th colspan="1" rowspan=""><form:radiobutton path="jobKnowledge3" name="jobKnowledge3" value="1" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="jobKnowledge3" name="jobKnowledge3"  value="2" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="jobKnowledge3" name="jobKnowledge3"  value="3" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="jobKnowledge3" name="jobKnowledge3"  value="4" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="jobKnowledge3" name="jobKnowledge3"  value="5" required="" /> </th>
                            </tr>
                            <tr>
                                <td  colspan="7">Understanding the need to complete the job smoothly and efficiently</td>
                                <th colspan="1" rowspan=""><form:radiobutton path="jobKnowledge4" name="jobKnowledge4" value="1" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="jobKnowledge4" name="jobKnowledge4"  value="2" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="jobKnowledge4" name="jobKnowledge4"  value="3" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="jobKnowledge4" name="jobKnowledge4"  value="4" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="jobKnowledge4" name="jobKnowledge4"  value="5" required="" /> </th>
                            </tr>
                            <tr>
                                <td  colspan="7">Understanding of co-ordination and effective working between teams</td>
                                <th colspan="1" rowspan=""><form:radiobutton path="jobKnowledge5" name="jobKnowledge5" value="1" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="jobKnowledge5" name="jobKnowledge5"  value="2" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="jobKnowledge5" name="jobKnowledge5"  value="3" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="jobKnowledge5" name="jobKnowledge5"  value="4" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="jobKnowledge5" name="jobKnowledge5"  value="5" required="" /> </th>
                            </tr>
                                <tr>
                                    <th colspan="12" style="text-align: center">Quality</th>

                            </tr>
                            <tr>
                                <td  colspan="7">Understanding of quality parameters of the job</td>
                                <th colspan="1" rowspan=""><form:radiobutton path="quality1" name="quality1" value="1" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="quality1" name="quality1"  value="2" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="quality1" name="quality1"  value="3" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="quality1" name="quality1"  value="4" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="quality1" name="quality1"  value="5" required="" /> </th>
                            </tr>
                            <tr>
                                <td  colspan="7">Work accurate and deadlines achieved</td>
                                <th colspan="1" rowspan=""><form:radiobutton path="quality2" name="quality2" value="1" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="quality2" name="quality2"  value="2" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="quality2" name="quality2"  value="3" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="quality2" name="quality2"  value="4" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="quality2" name="quality2"  value="5" required="" /> </th>
                            </tr>
                            <tr>
                                <td  colspan="7">Correct use of resources available</td>
                                <th colspan="1" rowspan=""><form:radiobutton path="quality3" name="quality3" value="1" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="quality3" name="quality3"  value="2" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="quality3" name="quality3"  value="3" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="quality3" name="quality3"  value="4" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="quality3" name="quality3"  value="5" required="" /> </th>
                            </tr>
                            <tr>
                                <td  colspan="7">Establishing work standards for self and department</td>
                                <th colspan="1" rowspan=""><form:radiobutton path="quality4" name="quality4" value="1" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="quality4" name="quality4"  value="2" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="quality4" name="quality4"  value="3" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="quality4" name="quality4"  value="4" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="quality4" name="quality4"  value="5" required="" /> </th>
                            </tr>
                            <tr>
                                <td  colspan="7">Accurate and legible documentation</td>
                                <th colspan="1" rowspan=""><form:radiobutton path="quality5" name="quality5" value="1" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="quality5" name="quality5"  value="2" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="quality5" name="quality5"  value="3" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="quality5" name="quality5"  value="4" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="quality5" name="quality5"  value="5" required="" /> </th>
                            </tr>
                                <tr>
                                    <th colspan="12" style="text-align: center">Learning </th>

                            </tr>
                            <tr>
                                <td  colspan="7">Desire to learn new projects</td>
                                <th colspan="1" rowspan=""><form:radiobutton path="learning1" name="learning1" value="1" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="learning1" name="learning1"  value="2" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="learning1" name="learning1"  value="3" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="learning1" name="learning1"  value="4" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="learning1" name="learning1"  value="5" required="" /> </th>
                            </tr>
                            <tr>
                                <td  colspan="7">Asks questions & gives feedback</td>
                                <th colspan="1" rowspan=""><form:radiobutton path="learning2" name="learning2" value="1" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="learning2" name="learning2"  value="2" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="learning2" name="learning2"  value="3" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="learning2" name="learning2"  value="4" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="learning2" name="learning2"  value="5" required="" /> </th>
                            </tr>
                            <tr>
                                <td  colspan="7">Tries to explore new ideas</td>
                                <th colspan="1" rowspan=""><form:radiobutton path="learning3" name="learning3" value="1" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="learning3" name="learning3"  value="2" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="learning3" name="learning3"  value="3" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="learning3" name="learning3"  value="4" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="learning3" name="learning3"  value="5" required="" /> </th>
                            </tr>
                            <tr>
                                <td  colspan="7">Learns from past experiences </td>
                                <th colspan="1" rowspan=""><form:radiobutton path="learning4" name="learning4" value="1" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="learning4" name="learning4"  value="2" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="learning4" name="learning4"  value="3" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="learning4" name="learning4"  value="4" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="learning4" name="learning4"  value="5" required="" /> </th>
                            </tr>
                            <tr>
                                <td  colspan="7">Looks for continual improvement</td>
                                <th colspan="1" rowspan=""><form:radiobutton path="learning5" name="learning5" value="1" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="learning5" name="learning5"  value="2" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="learning5" name="learning5"  value="3" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="learning5" name="learning5"  value="4" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="learning5" name="learning5"  value="5" required="" /> </th>
                            </tr>
                                <tr>
                                    <th colspan="12" style="text-align: center">General </th>

                            </tr>
                            <tr>
                                <td  colspan="7">Co-operative and approachable </td>
                                <th colspan="1" rowspan=""><form:radiobutton path="general1" name="general1" value="1" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="general1" name="general1"  value="2" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="general1" name="general1"  value="3" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="general1" name="general1"  value="4" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="general1" name="general1"  value="5" required="" /> </th>
                            </tr>
                            <tr>
                                <td  colspan="7">Reliable and trustworthy </td>
                                <th colspan="1" rowspan=""><form:radiobutton path="general2" name="general2" value="1" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="general2" name="general2"  value="2" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="general2" name="general2"  value="3" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="general2" name="general2"  value="4" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="general2" name="general2"  value="5" required="" /> </th>
                            </tr>
                            <tr>
                                <td  colspan="7">Ability to work within a team</td>
                                <th colspan="1" rowspan=""><form:radiobutton path="general3" name="general3" value="1" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="general3" name="general3"  value="2" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="general3" name="general3"  value="3" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="general3" name="general3"  value="4" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="general3" name="general3"  value="5" required="" /> </th>
                            </tr>
                            <tr>
                                <td  colspan="7">Reliable and punctual</td>
                                <th colspan="1" rowspan=""><form:radiobutton path="general4" name="general4" value="1" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="general4" name="general4"  value="2" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="general4" name="general4"  value="3" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="general4" name="general4"  value="4" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="general4" name="general4"  value="5" required="" /> </th>
                            </tr>
                            <tr>
                                <td  colspan="7">Communication skills</td>
                                <th colspan="1" rowspan=""><form:radiobutton path="general5" name="general5" value="1" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="general5" name="general5"  value="2" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="general5" name="general5"  value="3" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="general5" name="general5"  value="4" required="" /> </th>
                                <th colspan="1" rowspan=""><form:radiobutton path="general5" name="general5"  value="5" required="" /> </th>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
        <div class="box box-info collapsed-box">
                    <div class="box-header">
                        <h3 class="box-title">Overall Comments and Review by Team Leader</h3><span style="color: red;font-size: 12px;">*</span>
                        <div class="box-tools pull-right">
                            <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                            <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun3();"><i class="fa fa-plus" id="minusId3" ></i></button>
                        </div>
                    </div><!-- /.box-header -->
                    <div class="box-body no-padding">
                        <div class="row">
                            <div class="col-md-12 col-sm-12">
                                        <label>Comments about overall performance of Employee during probation period:<span style="color: red;font-size: 12px;">*</span></label>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                    <form:textarea path="overallPerformance" class="form-control" size="16" type="text" value=""></form:textarea>
                                    <%--<form:errors path="" cssClass="errorDiv"></form:errors>--%>
                                    </div>
                                </div>
                            </div>
                        </div><!-- /.row -->
                    </div><!-- /.box-body -->
                </div>

                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">Performance Rating:</h3><span style="color: red;font-size: 12px;">*</span>
                                            <div class="box-tools pull-right">
                                                <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                                <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun4();"><i class="fa fa-plus" id="minusId4" ></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <div class="col-md-3 col-sm-3"></div>
                                                        <fieldset id="performanceRating">
                                                            <!--<label class="col-sm-3 control-label">Name of the Joiner:</label>-->
                                                            <div class="col-sm-10 " >
                                                                <c:if test="${ptc.performanceRating eq 'Excellent'}">
                                                                    <input type="radio" name="performanceRating" id="Excellent" value="Excellent" checked style="width: 15px;height: 15px" > Excellent
                                                                    <input type="radio" name="performanceRating" id="Very Good" value="Very Good" style="width: 15px;height: 15px" > Very Good
                                                                    <input type="radio" name="performanceRating" id="Good"  value="Good" style="width: 15px;height: 15px" >Good
                                                                    <input type="radio" name="performanceRating" id="Average" value="Average" style="width: 15px;height: 15px" >Average
                                                                    <input type="radio" name="performanceRating" id="NeedsImprovement" value="Poor" style="width: 15px;height: 15px" >Poor
                                                                </c:if>
                                                                <c:if test="${ptc.performanceRating eq 'Very Good'}">
                                                                    <input type="radio" name="performanceRating" id="Excellent" value="Excellent"  style="width: 15px;height: 15px" > Excellent
                                                                    <input type="radio" name="performanceRating" id="Very Good" value="Very Good" checked style="width: 15px;height: 15px"> Very Good
                                                                    <input type="radio" name="performanceRating" id="Good"  value="Good" style="width: 15px;height: 15px" >Good
                                                                    <input type="radio" name="performanceRating" id="Average" value="Average" style="width: 15px;height: 15px" >Average
                                                                    <input type="radio" name="performanceRating" id="NeedsImprovement" value="Poor" style="width: 15px;height: 15px" >Poor
                                                                </c:if>
                                                                <c:if test="${ptc.performanceRating eq 'Good'}">
                                                                    <input type="radio" name="performanceRating" id="Excellent" value="Excellent"  style="width: 15px;height: 15px" > Excellent
                                                                    <input type="radio" name="performanceRating" id="Very Good" value="Very Good" style="width: 15px;height: 15px" > Very Good
                                                                    <input type="radio" name="performanceRating" id="Good"  value="Good" checked style="width: 15px;height: 15px">Good
                                                                    <input type="radio" name="performanceRating" id="Average" value="Average" style="width: 15px;height: 15px" >Average
                                                                    <input type="radio" name="performanceRating" id="NeedsImprovement" value="Poor" style="width: 15px;height: 15px">Poor
                                                                </c:if>
                                                                <c:if test="${ptc.performanceRating eq 'Average'}">
                                                                    <input type="radio" name="performanceRating" id="Excellent" value="Excellent"  style="width: 15px;height: 15px" > Excellent
                                                                    <input type="radio" name="performanceRating" id="Very Good" value="Very Good" style="width: 15px;height: 15px" > Very Good
                                                                    <input type="radio" name="performanceRating" id="Good"  value="Good" style="width: 15px;height: 15px" >Good
                                                                    <input type="radio" name="performanceRating" id="Average" value="Average" checked style="width: 15px;height: 15px">Average
                                                                    <input type="radio" name="performanceRating" id="NeedsImprovement" value="Poor" style="width: 15px;height: 15px" >Poor
                                                                </c:if>
                                                                <c:if test="${ptc.performanceRating eq 'Poor'}">
                                                                    <input type="radio" name="performanceRating" id="Excellent" value="Excellent"  style="width: 15px;height: 15px" > Excellent
                                                                    <input type="radio" name="performanceRating" id="Very Good" value="Very Good" style="width: 15px;height: 15px" > Very Good
                                                                    <input type="radio" name="performanceRating" id="Good"  value="Good" style="width: 15px;height: 15px" >Good
                                                                    <input type="radio" name="performanceRating" id="Average" value="Average" style="width: 15px;height: 15px">Average
                                                                    <input type="radio" name="performanceRating" id="NeedsImprovement" checked value="Poor" style="width: 15px;height: 15px">Poor
                                                                </c:if>
                                                                <c:if test="${ptc.performanceRating eq null || ptc.performanceRating eq ''}">
                                                                    <label class="radio-inline">
                                                                        <input type="radio" name="performanceRating" id="NeedsImprovement" value="Poor" style="width: 15px;height: 15px">Poor
                                                                    </label>
                                                                    <label class="radio-inline">
                                                                        <input type="radio" name="performanceRating" id="Average" value="Average" style="width: 15px;height: 15px">Average
                                                                    </label>
                                                                    <label class="radio-inline">
                                                                        <input type="radio" name="performanceRating" id="Good"  value="Good" style="width: 15px;height: 15px">Good
                                                                    </label>
                                                                    <label class="radio-inline">
                                                                        <input type="radio" name="performanceRating" id="Very Good" value="Very Good" style="width: 15px;height: 15px"> Very Good
                                                                    </label>
                                                                    <label class="radio-inline">
                                                                        <input type="radio" name="performanceRating" id="Excellent" value="Excellent"  style="width: 15px;height: 15px"> Excellent
                                                                    </label>
                                                                </c:if>
                                                            </div>
                                                        </fieldset>
                                                        <!--<div class="col-md-3 col-sm-3">-->
                                                        <!--</div>-->
                                                    </div>
                                                    <div class="col-sm-offset-5 col-sm-4">
                                                        <form:errors path="performanceRating" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div><!-- /.col -->
                                                </div><!-- /.row -->
                                            </div><!-- /.box-body -->
                                        </div>
                                        <div class="box box-info collapsed-box">
                                            <div class="box-header">
                                                <h3 class="box-title">Can The Employee Be Confirmed Based On Present Performance?:</h3>
                                                <div class="box-tools pull-right">
                                                    <span id="spanId5">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun5();"><i class="fa fa-plus" id="minusId5" ></i></button>
                                                </div>
                                            </div><!-- /.box-header -->
                                            <div class="box-body no-padding">
                                                <div class="row">
                                                    <div class="col-md-12 col-sm-12">
                                                        <div class="table-responsive">
                                                            <table id="demo" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                                <tr>
                                                                    <td >REPORTING MANAGER (RECOMMENDATION)<span style="color: red;font-size: 12px;">*</span></td>
                                                                    <td>
                                                                    <form:select path="recommendationSelect" id="RecomendationTypeSelectId" class="form-control ">
                                                                        <form:option value="">--SELECT--</form:option>
                                                                        <form:option value="Yes">Yes</form:option>
                                                                        <form:option value="No">No</form:option>
                                                                        <form:option value="Extend">Extend</form:option>
                                                                    </form:select>
                                                                    <form:errors path="recommendationSelect" cssClass="errorDiv"></form:errors>
                                                                    </td>
                                                                    <td id="RecomendationExtPeriodId" style="display: none">Extention Period<span style="color: red;font-size: 12px;">*</span></td>
                                                                    <td id="RecomendationExtSelectId" style="display: none">
                                                                    <form:select path="recommendationExtendPeriod" id="extendedmonth" name ="extendedmonth" class="form-control ">
                                                                        <form:option value="">--SELECT--</form:option>
                                                                        <form:option value="1Month">1 Month</form:option>
                                                                        <form:option value="2Month">2 Month</form:option>
                                                                        <form:option value="3Month">3 Month</form:option>
                                                                        <form:option value="4Month">4 Month</form:option>
                                                                        <form:option value="5Month">5 Month</form:option>
                                                                        <form:option value="6Month">6 Month</form:option>
                                                                        <form:option value="7Month">7 Month</form:option>
                                                                        <form:option value="8Month">8 Month</form:option>
                                                                        <form:option value="9Month">9 Month</form:option>
                                                                    </form:select>
                                                                    <span id="recommendationExtendPeriodError" style="color: red;"></span>
                                                                </td>
                                                                <td id="RecomendationRemarkId" style="display: none">Remark<span style="color: red;font-size: 12px;">*</span></td>
                                                                <td id="RecomendationRemarkTxtId" style="display: none">
                                                                    <form:textarea path="recommendationRemark" id="remarkid" name = "remarkid" class="form-control" type="text" value=""></form:textarea>
                                                                        <span id="recommendationRemarkError" style="color: red;"></span>
                                                                </tr>
                                                            </table>
                                                        </div><!-- /.col -->
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                                <label>Please provide your detailed justification for Confirmation / Extension of Probation / Termination of Services. Kindly Note, the same is mandatory for further process.</label><span style="color: red;font-size: 12px;">*</span>
                                                            <form:textarea path="managerJustification" id="remarkid" name = "remarkid" class="form-control" type="text" value=""></form:textarea>
                                                            <form:errors path="managerJustification" cssClass="errorDiv"></form:errors>
                                                            </div>
                                                        </div>
                                                    <c:if test="${ptc.recomendationByHr ne '' && ptc.recomendationByHr ne null}">
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                                <label>HR Remarks:</label>
                                                                <form:textarea path="recomendationByHr" class="form-control" type="text" value="" readonly="true" ></form:textarea>
                                                                </div>
                                                            </div>
                                                    </c:if>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-5 col-sm-4">
                                            &nbsp;&nbsp;<button type="submit" style="width: 100px" class="btn btn-primary" id="saveSubmit1" >Submit</button>
                                        </div>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
        <script>
            $(function () {
                $("#RecomendationTypeSelectId").on("change", function () {
                    var selectedValue = this.value;
                    if (selectedValue == "Extend") {
                        $('#RecomendationExtPeriodId').show();
                        $('#RecomendationExtSelectId').show();
                        $('#RecomendationRemarkId').show();
                        $('#RecomendationRemarkTxtId').show();
                    }
                    else if (selectedValue == "No") {
                        $('#RecomendationExtPeriodId').hide();
                        $('#RecomendationExtSelectId').hide();
                        $('#RecomendationRemarkId').show();
                        $('#RecomendationRemarkTxtId').show();
                    }
                    else {
                        $('#RecomendationExtPeriodId').hide();
                        $('#RecomendationExtSelectId').hide();
                        $('#RecomendationRemarkId').hide();
                        $('#RecomendationRemarkTxtId').hide();
                    }
                });
            });</script>
        <script>

            $(document).ready(function () {
                var concentration = $('input:radio[name=concentration]');
                if (concentration.is(':checked') === false) {
                    concentration.filter('[value=1]').attr('checked', true);
                }
                var consistency = $('input:radio[name=consistency]');
                if (consistency.is(':checked') === false) {
                    consistency.filter('[value=1]').attr('checked', true);
                }
                var cooperation = $('input:radio[name=cooperation]');
                if (cooperation.is(':checked') === false) {
                    cooperation.filter('[value=1]').attr('checked', true);
                }
                var knowledge = $('input:radio[name=knowledge]');
                if (knowledge.is(':checked') === false) {
                    knowledge.filter('[value=1]').attr('checked', true);
                }
                var discipline = $('input:radio[name=discipline]');
                if (discipline.is(':checked') === false) {
                    discipline.filter('[value=1]').attr('checked', true);
                }
                var leadership = $('input:radio[name=leadership]');
                if (leadership.is(':checked') === false) {
                    leadership.filter('[value=1]').attr('checked', true);
                }
                var communication = $('input:radio[name=communication]');
                if (communication.is(':checked') === false) {
                    communication.filter('[value=1]').attr('checked', true);
                }
                var safety = $('input:radio[name=safety]');
                if (safety.is(':checked') === false) {
                    safety.filter('[value=1]').attr('checked', true);
                }
                var team = $('input:radio[name=team]');
                if (team.is(':checked') === false) {
                    team.filter('[value=1]').attr('checked', true);
                }
                var integrity = $('input:radio[name=integrity]');
                if (integrity.is(':checked') === false) {
                    integrity.filter('[value=1]').attr('checked', true);
                }
            });
        </script>
        <!--         <script type="text/javascript">
                $('.form_datetime').datetimepicker({
                    weekStart: 1,
                    todayBtn: 1,
                    autoclose: 1,
                    todayHighlight: 1,
                    startView: 2,
                    forceParse: 0,
                    showMeridian: 1
        //             startDate: new Date()
                });
            </script>-->

        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    </body>
</html>
