<%--
    Document   : returnableNonReturnableGatePass
    Created on : Oct 5, 2015, 11:02:24 AM
    Author     : admin dhaval
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
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

        function buttonFun6() {
            var className = $('#minusId6').attr('class');
            if (className == 'fa fa-plus') {
                document.getElementById('spanId6').innerHTML = 'Minimize';
            } else {
                document.getElementById('spanId6').innerHTML = 'Expand';
            }
        }
        function buttonFun7() {
            var className = $('#minusId7').attr('class');
            if (className == 'fa fa-plus') {
                document.getElementById('spanId7').innerHTML = 'Minimize';
            } else {
                document.getElementById('spanId7').innerHTML = 'Expand';
            }
        }
        function buttonFun8() {
            var className = $('#minusId8').attr('class');
            if (className == 'fa fa-plus') {
                document.getElementById('spanId8').innerHTML = 'Minimize';
            } else {
                document.getElementById('spanId8').innerHTML = 'Expand';
            }
        }
        function buttonFun9() {
            var className = $('#minusId9').attr('class');
            if (className == 'fa fa-plus') {
                document.getElementById('spanId9').innerHTML = 'Minimize';
            } else {
                document.getElementById('spanId9').innerHTML = 'Expand';
            }
        }
        function buttonFun10() {
            var className = $('#minusId10').attr('class');
            if (className == 'fa fa-plus') {
                document.getElementById('spanId10').innerHTML = 'Minimize';
            } else {
                document.getElementById('spanId10').innerHTML = 'Expand';
            }
        }

    </script>
    <script>
        function hrapprove(id) {
            window.location = "exitInterviewMaster.htm?act=HrApprove&id=" + id;
        }
        function withdraw(id) {
            window.location = "exitInterviewMaster.htm?act=withdrawapprove&id=" + id;
        }
    </script>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Exit Interview </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Exit Interview</li>
            </ol>
            <div class="col-md-12" style="text-align: center;">
                <!--<input type="button" value="Print" id="printBtn" name="printBtn" style="margin-left: 959px; width: 100px;" class="btn btn-primary" onclick="appraisalSelectedPrint()">-->
                <a href="exitInterviewMaster.htm?act=printClick&id=${id}&empId=${empid}" target="_blank"  class="btn btn-primary">Print</a>
                <input type="hidden" id="id" name="id" value="${id}">
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
                            <!--form horizontal starts here-->
                            <form:form action="exitInterviewMaster.htm?act=submitApproveOrReturn" method="post" commandName="exitInterviewMaster" name='form1' class="form-horizontal" role="form">
                                <input type="hidden" id="empid" name="empid" value="${empid}" >
                                <div class="box box-info collapsed-box">
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
                                                        <input type="Text" class="form-control" value="${employeeMaster.employeeId}" readonly="true">
                                                        <input type="hidden" name="empId" value="${employeeMaster.id}"/>
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <label>Employee Name:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" value="${employeeMaster.employeeName}" readonly="true">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label>Designation:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" value="${employeeMaster.designationMaster.designationName}" readonly="true">
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <label>Level:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" value="${employeeMaster.levelMaster.level}" readonly="true">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label>Department:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" value="${employeeMaster.departmentMaster.departmentName}" readonly="true">
                                                    </div>

                                                    <div class="col-sm-2">
                                                        <label>Work Location:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" value="${employeeMaster.locationMaster.location}" readonly="true">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label>Reporting Manager:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" value="${reportingLevel1}" readonly="true">
                                                        <input type="hidden" name="approverId" value="${employeeMaster.reportingManagerLevel1}"/>
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <label>Date of Joining:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy - hh:ii " data-link-field="dtp_input1">
                                                            <input class="form-control" size="16" type="text" value="${employeeMaster.dateOfJoining}" readonly>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label>Date of Leaving:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy - hh:ii " data-link-field="dtp_input1">
                                                            <input class="form-control" size="16" type="text" value="${employeeMaster.dateOfLeaving}" readonly>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <label>Date of Form Submit:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy hh:ii" data-link-field="dtp_input1">
                                                            <form:input path="dateOfSubmit" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
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
                                            <h3 class="box-title">1)Please describe the primary reason(s) for leaving your current position with SPC Life Science:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2();"><i class="fa fa-plus" id="minusId2" ></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label"></label>
                                                        <div class="col-sm-12">
                                                        <form:textarea path="reasonLeaving" class="form-control" readonly="true"/>
                                                    </div>
                                                </div>
                                            </div><!-- /.col -->

                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>

                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">2)Which of the below mentioned factors were you dissatisfied with, which triggered your thought of leaving SPC Life Science?:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun3();"><i class="fa fa-plus" id="minusId3" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">


                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Type of Work or Profile:</label>
                                                    <div class="col-sm-5">
                                                        <c:if test="${exitInterviewMaster.typeOfWork eq true}">
                                                            <form:input path="typeOfWork" value="Yes" class="form-control" readonly="true"></form:input>
                                                        </c:if>
                                                        <c:if test="${exitInterviewMaster.typeOfWork eq false}">
                                                            <form:input path="typeOfWork" value="No" class="form-control" readonly="true"></form:input>
                                                        </c:if>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Working conditions (setting, schedule, travel, flexibility):</label>
                                                    <div class="col-sm-5">
                                                        <c:if test="${exitInterviewMaster.workingCondition eq true}">
                                                            <form:input path="workingCondition" value="Yes" class="form-control" readonly="true"></form:input>
                                                        </c:if>
                                                        <c:if test="${exitInterviewMaster.workingCondition eq false}">
                                                            <form:input path="workingCondition" value="No" class="form-control" readonly="true"></form:input>
                                                        </c:if>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Current Compensation:</label>
                                                    <div class="col-sm-5">
                                                        <c:if test="${exitInterviewMaster.currentCompensation eq true}">
                                                            <form:input path="currentCompensation" value="Yes" class="form-control" readonly="true"></form:input>
                                                        </c:if>
                                                        <c:if test="${exitInterviewMaster.currentCompensation eq false}">
                                                            <form:input path="currentCompensation" value="No" class="form-control" readonly="true"></form:input>
                                                        </c:if>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Grade / Level:</label>
                                                    <div class="col-sm-5">
                                                        <c:if test="${exitInterviewMaster.gradeOrLevel eq true}">
                                                            <form:input path="gradeOrLevel" value="Yes" class="form-control" readonly="true"></form:input>
                                                        </c:if>
                                                        <c:if test="${exitInterviewMaster.gradeOrLevel eq false}">
                                                            <form:input path="gradeOrLevel" value="No" class="form-control" readonly="true"></form:input>
                                                        </c:if>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Reporting Manager:</label>
                                                    <div class="col-sm-5">
                                                        <c:if test="${exitInterviewMaster.reportingManger eq true}">
                                                            <form:input path="reportingManger" value="Yes" class="form-control" readonly="true"></form:input>
                                                        </c:if>
                                                        <c:if test="${exitInterviewMaster.reportingManger eq false}">
                                                            <form:input path="reportingManger" value="No" class="form-control" readonly="true"></form:input>
                                                        </c:if>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Location:</label>
                                                    <div class="col-sm-5">
                                                        <c:if test="${exitInterviewMaster.location eq true}">
                                                            <form:input path="location" value="Yes" class="form-control" readonly="true"></form:input>
                                                        </c:if>
                                                        <c:if test="${exitInterviewMaster.location eq false}">
                                                            <form:input path="location" value="No" class="form-control" readonly="true"></form:input>
                                                        </c:if>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Commutation or Transportation Issues:</label>
                                                    <div class="col-sm-5">
                                                        <c:if test="${exitInterviewMaster.transportIssues eq true}">
                                                            <form:input path="transportIssues" value="Yes" class="form-control" readonly="true"></form:input>
                                                        </c:if>
                                                        <c:if test="${exitInterviewMaster.transportIssues eq false}">
                                                            <form:input path="transportIssues" value="No" class="form-control" readonly="true"></form:input>
                                                        </c:if>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Any Medical / Health Condition:</label>
                                                    <div class="col-sm-5">
                                                        <c:if test="${exitInterviewMaster.medicalCondition eq true}">
                                                            <form:input path="medicalCondition" value="Yes" class="form-control" readonly="true"></form:input>
                                                        </c:if>
                                                        <c:if test="${exitInterviewMaster.medicalCondition eq false}">
                                                            <form:input path="medicalCondition" value="No" class="form-control" readonly="true"></form:input>
                                                        </c:if>
                                                    </div>
                                                </div>



                                            </div>

                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div><!-- /.box-body -->
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">3)Please provide your candid feedback and rate the following aspects with reference to your job at SPC Life Science. (Please use the 1 – 5 scale below)</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun4();"><i class="fa fa-plus" id="minusId4" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Job / Role Clarity:</label>
                                                <div class="col-sm-5">
                                                    <form:input path="rateJob" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Fairness of Workload:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="rateWorkload" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Work Conditions:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="rateWorkCondition" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Current Compensation:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="rateCompensation" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Facilities & Tools provided to you:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="rateFacilites" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Trainings & Learning Opportunities:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="rateLearning" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Support from Co-workers & Seniors within your team:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="rateSupportFromSeniors" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Reporting Manager – Guidance & Supervision:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="rateSupervision" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Quality of Performance Feedback:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="rateQualityOfPerformance" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Overall Feedback about your Job:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="rateFeedbackAboutJob" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>

                                            </div>

                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->

                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">4)Please rate the following aspects of the organization overall. Use the 1 – 5 scale below.</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId5">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun5();"><i class="fa fa-plus" id="minusId5" ></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">

                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Openness & Transparency:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="transparency" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Support & Cooperation from Employees (Across all Levels):</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="supportFromEmployee" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Learning Opportunities:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="learning" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Career development Opportunities:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="careerDevelopment" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Overall Recognition for Job:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="recognisitonForJob" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Work Life Balance:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="workLife" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Org. Policies & Procedures:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="orgPolicies" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Employee Welfare Facilities:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="employeeWellfare" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Overall Organizational Culture:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="orgCulture" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>
                                            </div>

                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">5)Please rate your supervisor on the following factors. Use the 1-4 Rating scale below.</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId6">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun6();"><i class="fa fa-plus" id="minusId6" ></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">

                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Provide Candid & Constructive Performance Feedback:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="performanceFeedback" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Recognize accomplishments:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="accomplishments" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>
                                                <!--                                            <div class="form-group">
                                                                                                <label class="col-sm-5 control-label">Learning Opportunities:</label>
                                                                                                <div class="col-sm-5">
                                            <%--<form:input path="learningOpportunities" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>--%>
                                       </div>
                                   </div>-->
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Clearly communicate expectations:</label>
                                                <div class="col-sm-5">
                                                    <form:input path="cummunicateExpectation" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Fair & Respectful Treatment:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="respectfullTreatment" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Provide Learning Opportunities:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="provideLearning" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Coaching & Mentoring:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="coaching" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Encourage teamwork & cooperation:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="teamWork" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Resolve concerns promptly:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="resolveConcern" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Listen to suggestions & feedback:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="listenToFeedback" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Provide necessary & timely information:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="provideNecessaryInfo" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Support Work-Life Balance:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="sopportWorkLife" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>
                                            </div>

                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">6)Which reason made you take decision to leave SPC Life Science?  Rate top 3 reasons from the following: (Rate 1,2 &3 only) 
                                            </h3>

                                            <div class="box-tools pull-right">
                                                <span id="spanId7">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun7();"><i class="fa fa-plus" id="minusId7" ></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">

                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Compensation Offered:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="compensatiionOffered" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Role / Job matching my expectations:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="jobMatchingExpectation" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Higher Responsibilities & Job Enrichment:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="higherResponsibility" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Designation & Level:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="designationOrLevel" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Brand Consideration:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="brandConsideration" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Location:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="factorLocation" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Time to Commute:</label>
                                                    <div class="col-sm-5">
                                                    <form:input path="timeToCommute" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                    </div>
                                                </div>
                                            </div>
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">7)Since when were you considering leaving SPC Life Science? What can be done to retain you? Please mention in brief.</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId8">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun8();"><i class="fa fa-plus" id="minusId8" ></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label"></label>

                                                        <div class="col-sm-12" id="">
                                                        <form:textarea path="reasonForSustain" class="form-control" readonly="true"/>
                                                    </div>
                                                </div>
                                            </div><!-- /.col -->

                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">8)If given a choice or considered at a later date, would you like to re-join us?  
                                            <br>Please tick: Yes | No.   If No, Why? (Please mention in the space provided here below)
                                        </h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId9">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun9();"><i class="fa fa-plus" id="minusId9" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label"></label>
                                                    <div class="col-sm-10"  style="pointer-events: none;">
                                                        <form:radiobutton path="againJoin" value="true"/>Yes
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <form:radiobutton path="againJoin" value="false"/>No
                                                    </div>
                                                    <br/>
                                                    <br/>
                                                    <div class="col-sm-12">
                                                        <form:textarea path="notToJoinReason" class="form-control" readonly="true"/>
                                                    </div>
                                                </div>
                                            </div><!-- /.col -->

                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">9)Any other Suggestions or Feedback? Please mention in brief.</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId10">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun10();"><i class="fa fa-plus" id="minusId10" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label"></label>
                                                    <div class="col-sm-12">
                                                        <form:textarea path="otherFeedback" class="form-control" readonly="true"/>
                                                    </div>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                                <div class="form-group">
                                    <input type="hidden" name="tabId" value="${id}"/>
                                    <div class="col-lg-offset-5 col-sm-4">
                                        <%--<c:if test="${!sessionScope.userRight.hr}">--%>
                                        <%--<c:if test="${exitInterviewMaster.status eq 0 ||exitInterviewMaster.status eq 3}">--%>
                                        <%--<c:if test="${exitInterviewMaster.status eq 0}">--%>
                                        <!--<button type="submit" class="btn btn-success" style="width: 100px;" name="btnType" value="Approve" >ACCEPT</button>-->
                                        <!--<input type="submit" class="btn btn-primary" name="btnType" value="Approve"  />-->
                                        <!--<input type="submit" class="btn btn-primary" name="btnType" value="Return"  />-->
                                        <%--</c:if>--%>
                                        <%--<c:if test="${exitInterviewMaster.status eq 5}">--%>
                                           <!--<button type="button" class="btn btn-primary" onclick="withdraw(${exitInterviewMaster.id},2);">Approve</button>-->
                                        <%--</c:if>--%>
                                        <%--</c:if>--%>
                                        <c:if test="${sessionScope.userRight.hr or sessionScope.userRight.exitInterview}">
                                            <c:if test="${exitInterviewMaster.status eq 1}">
                                                <button type="button" class="btn btn-success" style="width: 100px;"onclick="hrapprove(${exitInterviewMaster.id}, 2);" name="btnType" >ACCEPT</button>
                                            </c:if>
                                        </c:if>
                                            <!--<button type="button" class="btn btn-primary" onclick="hrapprove(${exitInterviewMaster.id},2);">Approve</button>-->
                                        <!--<input type="button" class="btn btn-primary" style="width: 100px;" value="BACK" onclick="window.history.back();" />-->
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
</html>

