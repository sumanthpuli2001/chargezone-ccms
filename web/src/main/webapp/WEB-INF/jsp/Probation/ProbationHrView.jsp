<%--
    Document   : ProbationHrView
    Created on : Dec 21, 2015, 5:56:05 PM
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
                var selectedValue = document.getElementById("hrSelectId").value;
//                alert(selectedValue);
                if (document.getElementById('saveSubmit1').value == 'approve') {

                    if (document.getElementById("hrSelectId").value == '') {
                        document.getElementById("hrSelectError").innerHTML = "- It must be Selected";
                        flag3 = false;
                    } else {

                        if (selectedValue == "Extend") {
                            if (document.getElementById("hrextendmonth").value == '') {
                                document.getElementById("hrExtendPeriodError").innerHTML = "- It must be Selected";
                                flag3 = false;
                            } else {
                                document.getElementById("hrExtendPeriodError").innerHTML = "";
                            }
                            if (document.getElementById("hrremark").value == '') {
                                document.getElementById("hrApprovalRemarkError").innerHTML = "- It must be Selected";
                                flag3 = false;
                            } else {
                                document.getElementById("hrApprovalRemarkError").innerHTML = "";
                            }
                        } else if (selectedValue == "No") {
                            if (document.getElementById("hrremark").value == '') {
                                document.getElementById("hrApprovalRemarkError").innerHTML = "- It must be Selected";
                                flag3 = false;
                            } else {
                                document.getElementById("hrApprovalRemarkError").innerHTML = "";
                            }
                        }
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
    <script>
        function appraisalSelectedPrint() {
            var id = document.getElementById("id").value;
            var empId = document.getElementById("empId").value;
            var path = 'probationToConfirmation.htm?act=printClick&id= ' + id + '&empId= ' + empId;

            //             window.print(path, 'popUpWindow', 'height=700,width=900,left=10,top=10,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no,status=yes')
            popupWindow = window.open(path, 'popUpWindow', 'height=700,width=900,left=10,top=10,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no,status=yes,type=text/css')

        }

    </script>
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
                <h1>Probation To Confirmation Form : </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Probation To Confirmation</li>
                </ol>
                <div class="col-md-12" style="text-align: center;">
                    <!--<input type="button" value="Print" id="printBtn" name="printBtn" style="margin-left: 959px; width: 100px;" class="btn btn-primary" onclick="appraisalSelectedPrint()">-->
                    <a href="probationToConfirmation.htm?act=printClick&id=${id}&empId=${empId}" target="_blank"  class="btn btn-primary">Print</a>
                    <input type="hidden" id="empId" name="empId" value="${empId}">
                </div>
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
                                <form:form action="probationToConfirmation.htm?act=hrSubmit&Emid=${employeeMaster.id}" method="post" commandName="ptc"
                                           name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
                                    <form:hidden path="id"></form:hidden>
                                        <!--<span style="color: red;font-size: 14px;">* indicates mandatory field.</span>-->
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
                                                            <div class="col-sm-2">
                                                                <label>Employee Name:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="" class="form-control" size="16" type="text" value="${employeeMaster.employeeName}" readonly="true"></form:input>
                                                            </div>
                                                            
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-sm-2">
                                                                <label>Department:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="" class="form-control" size="16" type="text" value="${employeeMaster.departmentMaster.departmentName}" readonly="true"></form:input>
                                                            </div>
                                                            <div class="col-sm-2">
                                                                <label>Sub Team:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="" class="form-control" size="16" type="text" value="${employeeMaster.employeeSubType.subType}" readonly="true"></form:input>
                                                            </div>
                                                            
                                                            
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-sm-2">
                                                                <label>Designation:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="" class="form-control" size="16" type="text" value="${employeeMaster.designationMaster.designationName}" readonly="true"></form:input>
                                                            </div>
                                                            <div class="col-sm-2">
                                                                <label>Level:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="" class="form-control" size="16" type="text" value="${employeeMaster.levelMaster.level}" readonly="true"></form:input>
                                                            </div>
                                                            
                                                        </div>
                                                        <div class="form-group">
                                                            <div class=" col-sm-2">
                                                                <label>Work Location:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="" class="form-control" size="16" type="text" value="${employeeMaster.locationMaster.location}" readonly="true"></form:input>
                                                            </div>
                                                            <div class="col-sm-2">
                                                                <label>Reporting Manager:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="" class="form-control" size="16" type="text" value="${reportingLevel1}" readonly="true"></form:input>
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
                                                                <form:input path="" class="form-control" size="16" type="text" value="${ptc.formIssueDate}"  readonly="true"></form:input>
                                                                <%--<form:errors path="" cssClass="errorDiv"></form:errors>--%>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="col-sm-3 control-label">From Date:</label>
                                                            <div class=" col-sm-7">
                                                                <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy hh:ii " data-link-field="dtp_input1">
                                                                <form:input path="assessmentFromDate" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                                <form:errors path="assessmentFromDate" cssClass="errorDiv"></form:errors>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                        <c:choose>
                                                            <c:when test="${ptc.hrSelect eq 'Extend'  && !sessionScope.userRight.hr}">
                                                                <label class="col-sm-3 control-label">Extended Date:</label>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <label class="col-sm-3 control-label">To Date:</label>
                                                            </c:otherwise>
                                                        </c:choose>
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
                                                            <form:textarea path="jobHandled" class="form-control" size="16" type="text" value="" readonly="true"></form:textarea>
                                                            <form:errors path="jobHandled" cssClass="errorDiv"></form:errors>
                                                            </div>
                                                        </div>
                                                    </div><!-- /.col -->
                                                    <div class="col-md-12 col-sm-12">
                                                                <label>Describe the extent to which Employee has fulfilled the requirement of role:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                            <form:textarea path="employeeFullfill" class="form-control" size="16" type="text" value="" readonly="true"></form:textarea>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-12 col-sm-12">
                                                                <label>Describe areas of Employee’s strengths:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                            <form:textarea path="employeeStrengths" class="form-control" size="16" type="text" value="" readonly="true"></form:textarea>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-12 col-sm-12">
                                                                <label>Describe areas where Employee can improve upon:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                            <form:textarea path="employeeImprove" class="form-control" size="16" type="text" value="" readonly="true"></form:textarea>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-12 col-sm-12">
                                                                <label>Training programs attended by Employee during probation period:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                            <form:textarea path="employeeTrainingAttend" class="form-control" size="16" type="text" value="" readonly="true"></form:textarea>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div><!-- /.row -->
                                            </div><!-- /.box-body -->
                                        </div>
                                        <div class="box box-info collapsed-box">
                                            <div class="box-header">
                                                <h3 class="box-title">Competency Assessment</h3><span style="color: red;font-size: 12px;">*</span>
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
                                        <form:textarea path="overallPerformance" class="form-control" size="16" type="text" value="" readonly="true"></form:textarea>
                                    <%--<form:errors path="" cssClass="errorDiv"></form:errors>--%>
                                    </div>
                                </div>
                            </div>
                        </div><!-- /.row -->
                    </div><!-- /.box-body -->
                </div>
                                        <div class="box box-info collapsed-box">
                                            <div class="box-header">
                                                <h3 class="box-title">Performance Rating:</h3>
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
                                                                    <input type="radio" name="performanceRating" id="NeedsImprovement" value="Poor" style="width: 15px;height: 15px" >Poor
                                                                    <input type="radio" name="performanceRating" id="Average" value="Average" style="width: 15px;height: 15px" >Average
                                                                    <input type="radio" name="performanceRating" id="Good"  value="Good" style="width: 15px;height: 15px" >Good
                                                                    <input type="radio" name="performanceRating" id="Very Good" value="Very Good" style="width: 15px;height: 15px" > Very Good
                                                                    <input type="radio" name="performanceRating" id="Excellent" value="Excellent" checked style="width: 15px;height: 15px" > Excellent
                                                                </c:if>
                                                                <c:if test="${ptc.performanceRating eq 'Very Good'}">
                                                                    <input type="radio" name="performanceRating" id="NeedsImprovement" value="Poor" style="width: 15px;height: 15px" >Poor
                                                                    <input type="radio" name="performanceRating" id="Average" value="Average" style="width: 15px;height: 15px" >Average
                                                                    <input type="radio" name="performanceRating" id="Good"  value="Good" style="width: 15px;height: 15px" >Good
                                                                    <input type="radio" name="performanceRating" id="Very Good" value="Very Good" checked style="width: 15px;height: 15px"> Very Good
                                                                    <input type="radio" name="performanceRating" id="Excellent" value="Excellent"  style="width: 15px;height: 15px" > Excellent
                                                                </c:if>
                                                                <c:if test="${ptc.performanceRating eq 'Good'}">
                                                                    <input type="radio" name="performanceRating" id="NeedsImprovement" value="Poor" style="width: 15px;height: 15px">Poor
                                                                    <input type="radio" name="performanceRating" id="Average" value="Average" style="width: 15px;height: 15px" >Average
                                                                    <input type="radio" name="performanceRating" id="Good"  value="Good" checked style="width: 15px;height: 15px">Good
                                                                    <input type="radio" name="performanceRating" id="Very Good" value="Very Good" style="width: 15px;height: 15px" > Very Good
                                                                    <input type="radio" name="performanceRating" id="Excellent" value="Excellent"  style="width: 15px;height: 15px" > Excellent
                                                                </c:if>
                                                                <c:if test="${ptc.performanceRating eq 'Average'}">
                                                                    <input type="radio" name="performanceRating" id="NeedsImprovement" value="Poor" style="width: 15px;height: 15px" >Poor
                                                                    <input type="radio" name="performanceRating" id="Average" value="Average" checked style="width: 15px;height: 15px">Average
                                                                    <input type="radio" name="performanceRating" id="Good"  value="Good" style="width: 15px;height: 15px" >Good
                                                                    <input type="radio" name="performanceRating" id="Very Good" value="Very Good" style="width: 15px;height: 15px" > Very Good
                                                                    <input type="radio" name="performanceRating" id="Excellent" value="Excellent"  style="width: 15px;height: 15px" > Excellent
                                                                </c:if>
                                                                <c:if test="${ptc.performanceRating eq 'Poor'}">
                                                                    <input type="radio" name="performanceRating" id="NeedsImprovement" checked value="Poor" style="width: 15px;height: 15px">Poor
                                                                    <input type="radio" name="performanceRating" id="Average" value="Average" style="width: 15px;height: 15px">Average
                                                                    <input type="radio" name="performanceRating" id="Good"  value="Good" style="width: 15px;height: 15px" >Good
                                                                    <input type="radio" name="performanceRating" id="Very Good" value="Very Good" style="width: 15px;height: 15px" > Very Good
                                                                    <input type="radio" name="performanceRating" id="Excellent" value="Excellent"  style="width: 15px;height: 15px" > Excellent 
                                                                </c:if>
                                                                <c:if test="${ptc.performanceRating eq null}">
                                                                    <input type="radio" name="performanceRating" id="NeedsImprovement" value="Poor" style="width: 15px;height: 15px" >Poor
                                                                    <input type="radio" name="performanceRating" id="Average" value="Average" style="width: 15px;height: 15px">Average
                                                                    <input type="radio" name="performanceRating" id="Good"  value="Good" style="width: 15px;height: 15px" >Good
                                                                    <input type="radio" name="performanceRating" id="Very Good" value="Very Good" style="width: 15px;height: 15px"> Very Good
                                                                    <input type="radio" name="performanceRating" id="Excellent" value="Excellent" checked style="width: 15px;height: 15px" > Excellent
                                                                </c:if>
                                                            </div>
                                                        </fieldset>
                                                    </div>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">Can The Employee Be Confirmed Based On Present Performance?</h3>
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
                                                                    <td >REPORTING MANAGER (RECOMMENDATION)</td>
                                                                    <td>
                                                                        <form:input path="recommendationSelect"  class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                        </td>
                                                                    <c:if test="${ptc.recommendationSelect eq 'Extend'}">
                                                                        <td id="RecomendationExtPeriodId" >Extention Period</td>
                                                                        <td id="RecomendationExtSelectId" >
                                                                            <form:input path="recommendationExtendPeriod"  class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                            </td>
                                                                    </c:if>
                                                                    <c:if test="${ptc.recommendationSelect eq 'Extend' || ptc.recommendationSelect eq 'No'}">
                                                                        <td id="RecomendationRemarkId" >Remark</td>
                                                                        <td id="RecomendationRemarkTxtId">
                                                                            <form:textarea path="recommendationRemark" class="form-control" type="text" value="" readonly="true"></form:textarea>
                                                                        </c:if>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="9"><b>Please provide your detailed justification for Confirmation / Extension of Probation / Termination of Services. Kindly Note, the same is mandatory for further process.</b></td>
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="9"> <form:textarea path="managerJustification" rows="3" class="form-control" type="text" readonly="true" value=""></form:textarea></td>
                                                                    </tr>
<!--                                                            <tr>
                                                                <td >FUNCTIONAL HEAD (RECOMMENDATION)</td>
                                                                <td>
                                                                    <%--<form:input path="approvalSelect"  class="form-control" size="16" type="text" value="" readonly="true"></form:input>--%>
                                                                    </td>
                                                                <%--<c:if test="${ptc.approvalSelect eq 'Extend'}">--%>
                                                                    <td id="ApprovalExtPeriodId" >Extention Period</td>
                                                                    <td id="ApprovalExtSelectId" >
                                                                        <%--<form:input path="approvalExtendPeriod"  class="form-control" size="16" type="text" value="" readonly="true"></form:input>--%>
                                                                        </td>
                                                                <%--</c:if>--%>
                                                                <%--<c:if test="${ptc.approvalSelect eq 'Extend' || ptc.approvalSelect eq 'No'}">--%>
                                                                    <td id="ApprovalRemarkId" >Remark</td>
                                                                    <td id="ApprovalRemarkTxtId">
                                                                        <%--<form:textarea path="approvalRemark" class="form-control" type="text" value="" readonly="true"></form:textarea>--%>
                                                                    <%--</c:if>--%>
                                                                </td>
                                                            </tr>-->
<!--                                                            <tr>
                                                                <td colspan="9"><b>Additional Remarks:</b></td>
                                                            </tr>
                                                            <tr>
                                                                <td colspan="9"> <form:textarea path="hrAdditionalRemark" rows="3" readonly="" class="form-control" type="text" value=""></form:textarea></td>
                                                                </tr>-->
                                                            <c:if test="${sessionScope.userRight.probationToConfirmation}">
                                                                <c:if test="${ptc.status ne 4 && ptc.status ne 5}">
                                                                    <tr>
                                                                        <td >HR (APPROVAL)</td>
                                                                        <td>
                                                                            <form:select path="hrSelect" id="hrSelectId" class="form-control ">
                                                                                <form:option value="">--SELECT--</form:option>
                                                                                <form:option value="Yes">Yes</form:option>
                                                                                <form:option value="No">No</form:option>
                                                                                <form:option value="Extend">Extend</form:option>
                                                                            </form:select>
                                                                            <span id="hrSelectError" style="color: red;"></span>
                                                                        </td>
                                                                        <td id="hrExtPeriodId" style="display: none">Extention Period</td>
                                                                        <td id="hrExtSelectId" style="display: none">
                                                                            <form:select path="hrExtendPeriod" id="hrextendmonth" name="hrextendmonth" class="form-control ">
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
                                                                            <span id="hrExtendPeriodError" style="color: red;"></span>

                                                                        </td>
                                                                        <c:if test="${ptc.status ne 3}">
                                                                            <td id="hrRemarkId" style="display: none">Remark</td>
                                                                            <td id="hrRemarkTxtId" style="display: none">
                                                                                <form:textarea path="hrApprovalRemark" id="hrremark" name="hrremark" class="form-control" type="text" value=""></form:textarea>
                                                                                    <span id="hrApprovalRemarkError" style="color: red;"></span>
                                                                                </td></c:if>
                                                                        <c:if test="${ptc.status eq 3}">
                                                                            <td id="hrRemarkId" >Remark</td>
                                                                            <td id="hrRemarkTxtId" >
                                                                                <form:textarea path="hrApprovalRemark" class="form-control" type="text" value=""></form:textarea>
                                                                            </td></c:if>
                                                                        </tr>
                                                                </c:if>
                                                                <c:if test="${ptc.status eq 4 || ptc.status eq 5}">
                                                                    <tr>
                                                                        <td>HR (APPROVAL)</td>
                                                                        <td>
                                                                            <form:input path="hrSelect"  class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                            </td>
                                                                        <c:if test="${ptc.hrSelect eq 'Extend'}">
                                                                            <td id="hrExtPeriodId" >Extention Period</td>
                                                                            <td id="hrExtSelectId">
                                                                                <form:input path="hrExtendPeriod"  class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${ptc.hrSelect eq 'Extend' || ptc.hrSelect eq 'No'}">
                                                                            <td id="hrRemarkId">Remark</td>
                                                                            <td id="hrRemarkTxtId">
                                                                                <form:textarea path="hrApprovalRemark" class="form-control" type="text" value="" readonly="true"></form:textarea>
                                                                                </td>
                                                                        </c:if>
                                                                    </tr>
                                                                </c:if>
                                                            </c:if>
                                                            <c:if test="${!sessionScope.userRight.probationToConfirmation}">
                                                                <tr>
                                                                    <td>HR (APPROVAL)</td>
                                                                    <td>
                                                                        <form:input path="hrSelect"  class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                        </td>
                                                                    <c:if test="${ptc.hrSelect eq 'Extend'}">
                                                                        <td id="hrExtPeriodId" >Extention Period</td>
                                                                        <td id="hrExtSelectId">
                                                                            <form:input path="hrExtendPeriod"  class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                            </td>
                                                                    </c:if>
                                                                    <c:if test="${ptc.hrSelect eq 'Extend' || ptc.hrSelect eq 'No'}">
                                                                        <td id="hrRemarkId">Remark</td>
                                                                        <td id="hrRemarkTxtId">
                                                                            <form:textarea path="hrApprovalRemark" class="form-control" type="text" value="" readonly="true"></form:textarea>
                                                                            </td>
                                                                    </c:if>
                                                                </tr>
                                                            </c:if>

                                                            <tr>
                                                                <td>RECOMMENDATION BY HR (IF ANY):</td>
                                                                <td colspan="5" >
                                                                    <c:if test="${sessionScope.userRight.probationToConfirmation}">
                                                                        <c:if test="${ptc.status eq 4 || ptc.status eq 5}">
                                                                            <form:textarea path="recomendationByHr" class="form-control" type="text" readonly="true" value=""></form:textarea></td>
                                                                        </c:if>
                                                                        <c:if test="${ptc.status ne 4 && ptc.status ne 5}">
                                                                            <form:textarea path="recomendationByHr" class="form-control" type="text" value=""></form:textarea></td>
                                                                    </c:if>
                                                                </c:if>
                                                                <c:if test="${!sessionScope.userRight.probationToConfirmation}">
                                                                    <form:textarea path="recomendationByHr" class="form-control" type="text" value="" readonly="true" ></form:textarea></td>
                                                                </c:if>
                                                            </tr>
                                                        </table>
                                                    </div><!-- /.col -->
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>

                                    <div class="form-group">
                                        <c:if test="${sessionScope.userRight.probationToConfirmation}">
                                            <c:if test="${ptc.status ne 5 && ptc.status ne 4}">
                                                <div class="col-sm-12">
                                                    <div class="col-sm-6" style="text-align: left;">
                                                        &nbsp;&nbsp;<button type="submit" style="width: 100px;"class="btn btn-warning" id="" name="submit" value="rework" >Rework</button>
                                                    </div>
                                                    <div class="col-sm-6" style="text-align: right;">
                                                        &nbsp;&nbsp;<button type="submit" style="width: 100px;"class="btn btn-primary" id="saveSubmit1" name="submit" value="approve">Submit</button>
                                                    </div>
                                                </div>
                                            </c:if>
                                        </c:if>
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
                $("#hrSelectId").on("change", function () {
                    var selectedValue = this.value;
                    if (selectedValue == "Extend") {
                        $('#hrExtPeriodId').show();
                        $('#hrExtSelectId').show();
                        $('#hrRemarkId').show();
                        $('#hrRemarkTxtId').show();
                    }
                    else if (selectedValue == "No") {
                        $('#hrExtPeriodId').hide();
                        $('#hrExtSelectId').hide();
                        $('#hrRemarkId').show();
                        $('#hrRemarkTxtId').show();
                    }
                    else {
                        $('#hrExtPeriodId').hide();
                        $('#hrExtSelectId').hide();
                        $('#hrRemarkId').hide();
                        $('#hrRemarkTxtId').hide();
                    }
                });
            });</script>
            <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    </body>
</html>
