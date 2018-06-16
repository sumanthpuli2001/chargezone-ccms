<%--
    Document   : Probationlevel2
    Created on : Dec 19, 2015, 2:50:12 PM
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
                var selectedValue = document.getElementById("ApprovalTypeSelectId").value;
//                alert(selectedValue);
                if (document.getElementById("ApprovalTypeSelectId").value == '') {
                    document.getElementById("approvalSelectError").innerHTML = "- It must be Selected";
                    flag3 = false;
                } else {

                    if (selectedValue == "Extend") {
                        if (document.getElementById("approvalextend").value == '') {
                            document.getElementById("approvalExtendPeriodError").innerHTML = "- It must be Selected";
                            flag3 = false;
                        } else {
                            document.getElementById("approvalExtendPeriodError").innerHTML = "";
                        }
                        if (document.getElementById("approvalremarkid").value == '') {
                            document.getElementById("approvalRemarkError").innerHTML = "- It must be Selected";
                            flag3 = false;
                        } else {
                            document.getElementById("approvalRemarkError").innerHTML = "";
                        }
                    } else if (selectedValue == "No") {
                        if (document.getElementById("approvalremarkid").value == '') {
                            document.getElementById("approvalRemarkError").innerHTML = "- It must be Selected";
                            flag3 = false;
                        } else {
                            document.getElementById("approvalRemarkError").innerHTML = "";
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
    </head>
    <body>
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>Probation To Confirmation Form : </h1>
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
                                <form:form action="probationToConfirmation.htm?act=functionalheadSubmit&Emid=${employeeMaster.id}" method="post" commandName="ptc"
                                           name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
                                    <form:hidden path="id"></form:hidden>
                                    <%--<form:hidden path="employeeMasterByEmployeeMasterId.id"></form:hidden>--%>
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
                                                                <label>Designation:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="" class="form-control" size="16" type="text" value="${employeeMaster.designationMaster.designationName}" readonly="true"></form:input>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-sm-2">
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
                                                <h3 class="box-title">What are the jobs being handled by the employee?</h3>
                                                <div class="box-tools pull-right">
                                                    <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                                    <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun3();"><i class="fa fa-plus" id="minusId3" ></i></button>
                                                </div>
                                            </div><!-- /.box-header -->
                                            <div class="box-body no-padding">
                                                <div class="row">
                                                    <div class="col-md-12 col-sm-12">

                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                            <form:textarea path="jobHandled" class="form-control" size="16" type="text" value="" readonly="true"></form:textarea>
                                                            <form:errors path="jobHandled" cssClass="errorDiv"></form:errors>
                                                            </div>
                                                        </div>
                                                    </div><!-- /.col -->
                                                </div><!-- /.row -->
                                            </div><!-- /.box-body -->
                                        </div>
                                        <div class="box box-info collapsed-box">
                                            <div class="box-header">
                                                <h3 class="box-title">3 C  Behaviours (Each 3C carries 10 Marks i.e. 30 Marks Total)</h3><span style="color: red;font-size: 12px;">*</span>
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
                                                                <table style="width:95%; ">
                                                                    <tr >
                                                                        <th colspan="8" style="text-align: center">Behaviours</th>
                                                                        <th colspan="2" style="text-align: center">Satisfactory</th>
                                                                        <th colspan="2" style="text-align: center">Not-Satisfactory</th>
                                                                    </tr>
                                                                    <tr>
                                                                        <th colspan="8">C 1: Concentration</th>
                                                                        <c:if test="${ptc.concentration eq 'true'}">
                                                                        <th colspan="2" rowspan="7">
                                                                            <input type="radio" name="concentration" id="Yes" value="Yes" checked style="width: 15px;height: 15px" > Yes
                                                                        </th>
                                                                        <th colspan="2" rowspan="7">
                                                                            <input type="radio" name="concentration" id="NO" value="No"  style="width: 15px;height: 15px" > No
                                                                        </th>
                                                                    </c:if>
                                                                    <c:if test="${ptc.concentration eq 'false'}">
                                                                        <th colspan="2" rowspan="7"> 
                                                                            <input type="radio" name="concentration" id="Yes" value="Yes"  style="width: 15px;height: 15px" > Yes
                                                                        </th>
                                                                        <th colspan="2" rowspan="7">
                                                                            <input type="radio" name="concentration" id="NO" value="No" checked  style="width: 15px;height: 15px" > No
                                                                        </th>
                                                                    </c:if>
                                                                </tr>
                                                                <tr>
                                                                    <td  colspan="8">Concentration on the work</td>
                                                                </tr>
                                                                <tr>
                                                                    <td  colspan="8">Attention in detailing of work</td>
                                                                </tr>
                                                                <tr>
                                                                    <td  colspan="8">targeting the highest standard of excellence</td>
                                                                </tr>
                                                                <tr>
                                                                    <td  colspan="8">doing better than yesterday</td>
                                                                </tr>
                                                                <tr>
                                                                    <td  colspan="8">Respect every employee</td>
                                                                </tr>
                                                                <tr>
                                                                    <td  colspan="8">concentrtaion on performance achievement and individual development</td>
                                                                </tr>
                                                                <tr>
                                                                    <th colspan="8">C 2: Consistency</th>
                                                                        <c:if test="${ptc.consistency eq 'true'}">
                                                                        <th colspan="2" rowspan="3">
                                                                            <input type="radio" name="consistency" id="Yes" value="Yes" checked style="width: 15px;height: 15px" > Yes
                                                                        </th>
                                                                        <th colspan="2" rowspan="3">
                                                                            <input type="radio" name="consistency" id="NO" value="No"  style="width: 15px;height: 15px" > No
                                                                        </th>
                                                                    </c:if>
                                                                    <c:if test="${ptc.consistency eq 'false'}">
                                                                        <th colspan="2" rowspan="3"> 
                                                                            <input type="radio" name="consistency" id="Yes" value="Yes"  style="width: 15px;height: 15px" > Yes
                                                                        </th>
                                                                        <th colspan="2" rowspan="3">
                                                                            <input type="radio" name="consistency" id="NO" value="No" checked  style="width: 15px;height: 15px" > No
                                                                        </th>
                                                                    </c:if>    
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="8">Consistency in building system and for organizations betterment</td>
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="8">to maintain consistency in respect with organization's future, mission and vision, safety and security of employees</td>
                                                                </tr>
                                                                <tr>
                                                                    <th colspan="8">C 3: Cooperation</th>
                                                                        <c:if test="${ptc.cooperation eq 'true'}">
                                                                        <th colspan="2" rowspan="3">
                                                                            <input type="radio" name="cooperation" id="Yes" value="Yes" checked style="width: 15px;height: 15px" > Yes
                                                                        </th>
                                                                        <th colspan="2" rowspan="3">
                                                                            <input type="radio" name="cooperation" id="NO" value="No"  style="width: 15px;height: 15px" > No
                                                                        </th>
                                                                    </c:if>
                                                                    <c:if test="${ptc.cooperation eq 'false'}">
                                                                        <th colspan="2" rowspan="3"> 
                                                                            <input type="radio" name="cooperation" id="Yes" value="Yes"  style="width: 15px;height: 15px" > Yes
                                                                        </th>
                                                                        <th colspan="2" rowspan="3">
                                                                            <input type="radio" name="cooperation" id="NO" value="No" checked  style="width: 15px;height: 15px" > No
                                                                        </th>
                                                                    </c:if>
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="8">Conduct of the highest ethical standard, intellectual , financial and moral . </td>
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="8">Conduct which builds and maintains teamwork</td>
                                                                </tr>
                                                                <tr>
                                                                    <th colspan="12" style="text-align: center;">Job Knowledge & Working Standards</th>
                                                                </tr>
                                                                <tr>
                                                                    <th colspan="8">1. Job Knowledge</th>
                                                                        <c:if test="${ptc.knowledge eq 'true'}">
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="knowledge" id="Yes" value="Yes" checked style="width: 15px;height: 15px" > Yes
                                                                        </th>
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="knowledge" id="NO" value="No"  style="width: 15px;height: 15px" > No
                                                                        </th>
                                                                    </c:if>
                                                                    <c:if test="${ptc.knowledge eq 'false'}">
                                                                        <th colspan="2" rowspan="2"> 
                                                                            <input type="radio" name="knowledge" id="Yes" value="Yes"  style="width: 15px;height: 15px" > Yes
                                                                        </th>
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="knowledge" id="NO" value="No" checked  style="width: 15px;height: 15px" > No
                                                                        </th>
                                                                    </c:if>
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="8">Knowledge to perform the task</td>
                                                                </tr>
                                                                <tr>
                                                                    <th colspan="8">2. Discipline</th>
                                                                        <c:if test="${ptc.discipline eq 'true'}">
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="discipline" id="Yes" value="Yes" checked style="width: 15px;height: 15px" > Yes
                                                                        </th>
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="discipline" id="NO" value="No"  style="width: 15px;height: 15px" > No
                                                                        </th>
                                                                    </c:if>
                                                                    <c:if test="${ptc.discipline eq 'false'}">
                                                                        <th colspan="2" rowspan="2"> 
                                                                            <input type="radio" name="discipline" id="Yes" value="Yes"  style="width: 15px;height: 15px" > Yes
                                                                        </th>
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="discipline" id="NO" value="No" checked  style="width: 15px;height: 15px" > No
                                                                        </th>
                                                                    </c:if>      
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="8">Way of thinking, belief or opinion of approval and disapproval towards the organization decision and action. The way in which one acts or conducts oneself, especially towards others, respects for others, Eagerness to help others.</td>
                                                                </tr>
                                                                <tr>
                                                                    <th colspan="8">3. Leadership Quality</th>
                                                                        <c:if test="${ptc.leadership eq 'true'}">
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="leadership" id="Yes" value="Yes" checked style="width: 15px;height: 15px" > Yes
                                                                        </th>
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="leadership" id="NO" value="No"  style="width: 15px;height: 15px" > No
                                                                        </th>
                                                                    </c:if>
                                                                    <c:if test="${ptc.leadership eq 'false'}">
                                                                        <th colspan="2" rowspan="2"> 
                                                                            <input type="radio" name="leadership" id="Yes" value="Yes"  style="width: 15px;height: 15px" > Yes
                                                                        </th>
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="leadership" id="NO" value="No" checked  style="width: 15px;height: 15px" > No
                                                                        </th>
                                                                    </c:if> 
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="8">Deliver result on time, build relationship & develop others & possess good decision making skills</td>
                                                                </tr>
                                                                <tr>
                                                                    <th colspan="8">4. Communication </th>
                                                                        <c:if test="${ptc.communication eq 'true'}">
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="communication" id="Yes" value="Yes" checked style="width: 15px;height: 15px" > Yes
                                                                        </th>
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="communication" id="NO" value="No"  style="width: 15px;height: 15px" > No
                                                                        </th>
                                                                    </c:if>
                                                                    <c:if test="${ptc.communication eq 'false'}">
                                                                        <th colspan="2" rowspan="2"> 
                                                                            <input type="radio" name="communication" id="Yes" value="Yes"  style="width: 15px;height: 15px" > Yes
                                                                        </th>
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="communication" id="NO" value="No" checked  style="width: 15px;height: 15px" > No
                                                                        </th>
                                                                    </c:if>                                                                         
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="8">Express ideas and concerns clearly Proficient and confident in presentation Flexible and effective writing skills </td>
                                                                </tr>
                                                                <tr>
                                                                    <th colspan="8">5. 5S and Safety Norms </th>
                                                                        <c:if test="${ptc.safety eq 'true'}">
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="safety" id="Yes" value="Yes" checked style="width: 15px;height: 15px" > Yes
                                                                        </th>
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="safety" id="NO" value="No"  style="width: 15px;height: 15px" > No
                                                                        </th>
                                                                    </c:if>
                                                                    <c:if test="${ptc.safety eq 'false'}">
                                                                        <th colspan="2" rowspan="2"> 
                                                                            <input type="radio" name="safety" id="Yes" value="Yes"  style="width: 15px;height: 15px" > Yes
                                                                        </th>
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="safety" id="NO" value="No" checked  style="width: 15px;height: 15px" > No
                                                                        </th>
                                                                    </c:if>
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="8">Cleanliness of own self, work premises, retrieval of data, safe working practice, safety knowledge</td>
                                                                </tr>
                                                                <tr>
                                                                    <th colspan="8">6. Team Work </th>
                                                                        <c:if test="${ptc.team eq 'true'}">
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="team" id="Yes" value="Yes" checked style="width: 15px;height: 15px" > Yes
                                                                        </th>
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="team" id="NO" value="No"  style="width: 15px;height: 15px" > No
                                                                        </th>
                                                                    </c:if>
                                                                    <c:if test="${ptc.team eq 'false'}">
                                                                        <th colspan="2" rowspan="2"> 
                                                                            <input type="radio" name="team" id="Yes" value="Yes"  style="width: 15px;height: 15px" > Yes
                                                                        </th>
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="team" id="NO" value="No" checked  style="width: 15px;height: 15px" > No
                                                                        </th>
                                                                    </c:if>
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="8">The extent to which the employee successfully collaborates with others to accomplish departmental and Organizational goals. Target achieved through team work.</td>
                                                                </tr>
                                                                <tr>
                                                                    <th colspan="8">7. Integrity/Ethics </th>
                                                                        <c:if test="${ptc.integrity eq 'true'}">
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="integrity" id="Yes" value="Yes" checked style="width: 15px;height: 15px" > Yes
                                                                        </th>
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="integrity" id="NO" value="No"  style="width: 15px;height: 15px" > No
                                                                        </th>
                                                                    </c:if>
                                                                    <c:if test="${ptc.integrity eq 'false'}">
                                                                        <th colspan="2" rowspan="2"> 
                                                                            <input type="radio" name="integrity" id="Yes" value="Yes"  style="width: 15px;height: 15px" > Yes
                                                                        </th>
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="integrity" id="NO" value="No" checked  style="width: 15px;height: 15px" > No
                                                                        </th>
                                                                    </c:if>
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="8">Practices excellent work ethics. Properly handles confidential information. Avoids situations and actions considered inappropriate or which present a conflict of interest. Demonstrates integrity in all work. Has a strong sense of right and wrong and consistently strives to do what is right.</td>
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
                                                                    <input type="radio" name="performanceRating" id="Excellent" value="Excellent" checked style="width: 15px;height: 15px" > Excellent
                                                                    <input type="radio" name="performanceRating" id="Very Good" value="Very Good" style="width: 15px;height: 15px" > Very Good
                                                                    <input type="radio" name="performanceRating" id="Good"  value="Good" style="width: 15px;height: 15px" >Good
                                                                    <input type="radio" name="performanceRating" id="Average" value="Average" style="width: 15px;height: 15px" >Average
                                                                    <input type="radio" name="performanceRating" id="NeedsImprovement" value="NeedsImprovement" style="width: 15px;height: 15px" >Needs Improvement
                                                                </c:if>
                                                                <c:if test="${ptc.performanceRating eq 'Very Good'}">
                                                                    <input type="radio" name="performanceRating" id="Excellent" value="Excellent"  style="width: 15px;height: 15px" > Excellent
                                                                    <input type="radio" name="performanceRating" id="Very Good" value="Very Good" checked style="width: 15px;height: 15px"> Very Good
                                                                    <input type="radio" name="performanceRating" id="Good"  value="Good" style="width: 15px;height: 15px" >Good
                                                                    <input type="radio" name="performanceRating" id="Average" value="Average" style="width: 15px;height: 15px" >Average
                                                                    <input type="radio" name="performanceRating" id="NeedsImprovement" value="NeedsImprovement" style="width: 15px;height: 15px" >Needs Improvement
                                                                </c:if>
                                                                <c:if test="${ptc.performanceRating eq 'Good'}">
                                                                    <input type="radio" name="performanceRating" id="Excellent" value="Excellent"  style="width: 15px;height: 15px" > Excellent
                                                                    <input type="radio" name="performanceRating" id="Very Good" value="Very Good" style="width: 15px;height: 15px" > Very Good
                                                                    <input type="radio" name="performanceRating" id="Good"  value="Good" checked style="width: 15px;height: 15px">Good
                                                                    <input type="radio" name="performanceRating" id="Average" value="Average" style="width: 15px;height: 15px" >Average
                                                                    <input type="radio" name="performanceRating" id="NeedsImprovement" value="NeedsImprovement" style="width: 15px;height: 15px">Needs Improvement
                                                                </c:if>
                                                                <c:if test="${ptc.performanceRating eq 'Average'}">
                                                                    <input type="radio" name="performanceRating" id="Excellent" value="Excellent"  style="width: 15px;height: 15px" > Excellent
                                                                    <input type="radio" name="performanceRating" id="Very Good" value="Very Good" style="width: 15px;height: 15px" > Very Good
                                                                    <input type="radio" name="performanceRating" id="Good"  value="Good" style="width: 15px;height: 15px" >Good
                                                                    <input type="radio" name="performanceRating" id="Average" value="Average" checked style="width: 15px;height: 15px">Average
                                                                    <input type="radio" name="performanceRating" id="NeedsImprovement" value="NeedsImprovement" style="width: 15px;height: 15px" >Needs Improvement
                                                                </c:if>
                                                                <c:if test="${ptc.performanceRating eq 'NeedsImprovement'}">
                                                                    <input type="radio" name="performanceRating" id="Excellent" value="Excellent"  style="width: 15px;height: 15px" > Excellent
                                                                    <input type="radio" name="performanceRating" id="Very Good" value="Very Good" style="width: 15px;height: 15px" > Very Good
                                                                    <input type="radio" name="performanceRating" id="Good"  value="Good" style="width: 15px;height: 15px" >Good
                                                                    <input type="radio" name="performanceRating" id="Average" value="Average" style="width: 15px;height: 15px">Average
                                                                    <input type="radio" name="performanceRating" id="NeedsImprovement" checked value="NeedsImprovement" style="width: 15px;height: 15px">Needs Improvement
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
                                                                <tr>
                                                                    <td >FUNCTIONAL HEAD (APPROVAL)</td>
                                                                    <td>
                                                                    <form:select path="approvalSelect" id="ApprovalTypeSelectId" class="form-control ">
                                                                        <form:option value="">--SELECT--</form:option>
                                                                        <form:option value="Yes">Yes</form:option>
                                                                        <form:option value="No">No</form:option>
                                                                        <form:option value="Extend">Extend</form:option>
                                                                    </form:select>
                                                                    <span id="approvalSelectError" style="color: red;"></span>
                                                                </td>
                                                                <td id="ApprovalExtPeriodId" style="display: none">Extention Period</td>
                                                                <td id="ApprovalExtSelectId" style="display: none">
                                                                    <form:select path="approvalExtendPeriod" id="approvalextend" name="approvalextend" class="form-control ">
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
                                                                    <span id="approvalExtendPeriodError" style="color: red;"></span>
                                                                </td>
                                                                <td id="ApprovalRemarkId" style="display: none">Remark</td>
                                                                <td id="ApprovalRemarkTxtId" style="display: none">
                                                                    <form:textarea path="approvalRemark" id="approvalremarkid" name = "approvalremarkid"  class="form-control" type="text" value=""></form:textarea>
                                                                        <span id="approvalRemarkError" style="color: red;"></span>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="9"><b>Functional Head's Remarks:</b></td>
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="9"> <form:textarea path="hrAdditionalRemark" rows="3" class="form-control" type="text" value=""></form:textarea></td>
                                                                </tr>

                                                            </table>
                                                        </div><!-- /.col -->
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
        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
        <script>
            $(function () {
                $("#ApprovalTypeSelectId").on("change", function () {
                    var selectedValue = this.value;
                    if (selectedValue == "Extend") {
                        $('#ApprovalExtPeriodId').show();
                        $('#ApprovalExtSelectId').show();
                        $('#ApprovalRemarkId').show();
                        $('#ApprovalRemarkTxtId').show();
                    }
                    else if (selectedValue == "No") {
                        $('#ApprovalExtPeriodId').hide();
                        $('#ApprovalExtSelectId').hide();
                        $('#ApprovalRemarkId').show();
                        $('#ApprovalRemarkTxtId').show();
                    }
                    else {
                        $('#ApprovalExtPeriodId').hide();
                        $('#ApprovalExtSelectId').hide();
                        $('#ApprovalRemarkId').hide();
                        $('#ApprovalRemarkTxtId').hide();
                    }
                });
            });</script>
    </body>
</html>
