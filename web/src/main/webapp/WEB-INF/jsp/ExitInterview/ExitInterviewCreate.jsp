<%--
    Document   : returnableNonReturnableGatePass
    Created on : Oct 5, 2015, 11:02:24 AM
    Author     : admin dhaval
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
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
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Exit Interview Form (Employee)</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Exit Interview</li>
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
                            <!--form horizontal starts here-->
                            <form:form action="exitInterviewMaster.htm?act=submitExitInterviewForm" method="post" commandName="exitInterviewMaster" name='form1' class="form-horizontal" role="form">
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Employee Detail:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId1">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun1();"><i class="fa fa-plus" id="minusId1" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <c:forEach var="list1" items="${list}">
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Employee No:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control" value="${list1.employeeId}" readonly="true">
                                                            <input type="hidden" name="empId" value="${list1.id}"/>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label>Employee Name:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control" value="${list1.employeeName}" readonly="true">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Designation:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control" value="${list1.designationMaster.designationName}" readonly="true">
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label>Level:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control" value="${list1.levelMaster.level}" readonly="true">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Department:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control" value="${list1.departmentMaster.departmentName}" readonly="true">
                                                        </div>

                                                        <div class="col-sm-2">
                                                            <label>Work Location:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control" value="${list1.locationMaster.location}" readonly="true">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Reporting Manager:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control" value="${reportingLevel1}" readonly="true">
                                                            <input type="hidden" name="approverId" value="${list1.reportingManagerLevel1}"/>
                                                            <input type="hidden" name="approverId2" value="${list1.reportingManagerLevel2}"/>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label>Date of Joining:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy - hh:ii " data-link-field="dtp_input1">
                                                                <input class="form-control" size="16" type="text" value="${list1.dateOfJoining}" readonly>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">

                                                        <div class="col-sm-2">
                                                            <label>Date of Leaving:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input class="form-control" size="16" type="text" value="${list1.dateOfLeaving}" readonly>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label>Date of Form Submit:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                <jsp:useBean id="now" class="java.util.Date" />
                                                                <fmt:formatDate type="date"  value="${now}" var="today" pattern="dd/MM/yyyy" />
                                                                <form:input class="form-control" path="dateOfSubmit" value="${today}" readonly="true"/>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </c:forEach>
                                </div>
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">1)Please describe the primary reason(s) you are leaving your current position:</h3>
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
                                                        <form:textarea path="reasonLeaving" class="form-control"/>
                                                        <div style="color: red"><form:errors path="reasonLeaving" cssClass="errorDiv"></form:errors></div>
                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->

                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>

                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">2)Which of the below mentioned factors where you dissatisfied with, which triggered your thought to leave us?:</h3>
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
                                                        <form:select path="typeOfWork" id="typeOfWork" class="form-control" >
                                                            <form:options items="${status2}"></form:options>
                                                        </form:select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Working conditions (setting, schedule, travel, flexibility):</label>
                                                    <div class="col-sm-5">
                                                        <form:select path="workingCondition" id="workingCondition" class="form-control" >
                                                            <form:options items="${status2}"></form:options>
                                                        </form:select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Current Compensation:</label>
                                                    <div class="col-sm-5">
                                                        <form:select path="currentCompensation" id="currentCompensation" class="form-control" >
                                                            <form:options items="${status2}"></form:options>
                                                        </form:select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Grade / Level:</label>
                                                    <div class="col-sm-5">
                                                        <form:select path="gradeOrLevel" id="gradeOrLevel" class="form-control" >
                                                            <form:options items="${status2}"></form:options>
                                                        </form:select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Reporting Manager:</label>
                                                    <div class="col-sm-5">
                                                        <form:select path="reportingManger" id="reportingManger" class="form-control" >
                                                            <form:options items="${status2}"></form:options>
                                                        </form:select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Location:</label>
                                                    <div class="col-sm-5">
                                                        <form:select path="location" id="location" class="form-control" >
                                                            <form:options items="${status2}"></form:options>
                                                        </form:select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Commutation or Transportation Issues:</label>
                                                    <div class="col-sm-5">
                                                        <form:select path="transportIssues" id="transportIssues" class="form-control" >
                                                            <form:options items="${status2}"></form:options>
                                                        </form:select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Any Medical / Health Condition:</label>
                                                    <div class="col-sm-5">
                                                        <form:select path="medicalCondition" id="medicalCondition" class="form-control" >
                                                            <form:options items="${status2}"></form:options>
                                                        </form:select>
                                                    </div>
                                                </div>
                                            </div>
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div><!-- /.box-body -->
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">3)Please provide your candid feedback and rate the following aspects with reference to your job at Zydex.<br/>(Please use the 1 – 5 scale below):</h3>
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
                                                    <form:select path="rateJob" id="rateJob" class="form-control">
                                                        <form:option value="Excellent" label="Excellent"/>
                                                        <form:options items="${status}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Fairness of Workload:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="rateWorkload" id="rateWorkload" class="form-control" >
                                                        <form:option value="Excellent" label="Excellent"/>
                                                        <form:options items="${status}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Work Conditions:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="rateWorkCondition" id="rateWorkCondition" class="form-control" >
                                                        <form:option value="Excellent" label="Excellent"/>
                                                        <form:options items="${status}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Current Compensation:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="rateCompensation" id="rateCompensation" class="form-control" >
                                                        <form:option value="Excellent" label="Excellent"/>
                                                        <form:options items="${status}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Facilities & Tools provided to you:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="rateFacilites" id="rateFacilites" class="form-control" >
                                                        <form:option value="Excellent" label="Excellent"/>
                                                        <form:options items="${status}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Trainings & Learning Opportunities:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="rateLearning" id="rateLearning" class="form-control" >
                                                        <form:option value="Excellent" label="Excellent"/>
                                                        <form:options items="${status}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Support from Co-workers & Seniors within your team:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="rateSupportFromSeniors" id="rateSupportFromSeniors" class="form-control" >
                                                        <form:option value="Excellent" label="Excellent"/>
                                                        <form:options items="${status}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Reporting Manager – Guidance & Supervision:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="rateSupervision" id="rateSupervision" class="form-control" >
                                                        <form:option value="Excellent" label="Excellent"/>
                                                        <form:options items="${status}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Quality of Performance Feedback:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="rateQualityOfPerformance" id="rateQualityOfPerformance" class="form-control" >
                                                        <form:option value="Excellent" label="Excellent"/>
                                                        <form:options items="${status}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Overall Feedback about your Job:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="rateFeedbackAboutJob" id="rateFeedbackAboutJob" class="form-control" >
                                                        <form:option value="Excellent" label="Excellent"/>
                                                        <form:options items="${status}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>

                                        </div>

                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->

                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">4)Please rate the following aspects of the organization overall:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId5">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun5();"><i class="fa fa-plus" id="minusId5" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">

                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Openness & Transparency:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="transparency" id="transparency" class="form-control" >
                                                        <form:option value="Excellent" label="Excellent"/>
                                                        <form:options items="${status}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Support & Cooperation from Employees (Across all Levels):</label>
                                                <div class="col-sm-5">
                                                    <form:select path="supportFromEmployee" id="supportFromEmployee" class="form-control" >
                                                        <form:option value="Excellent" label="Excellent"/>
                                                        <form:options items="${status}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Learning Opportunities:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="learning" id="learning" class="form-control" >
                                                        <form:option value="Excellent" label="Excellent"/>
                                                        <form:options items="${status}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Career development Opportunities:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="careerDevelopment" id="careerDevelopment" class="form-control" >
                                                        <form:option value="Excellent" label="Excellent"/>
                                                        <form:options items="${status}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Overall Recognition for Job:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="recognisitonForJob" id="recognisitonForJob" class="form-control" >
                                                        <form:option value="Excellent" label="Excellent"/>
                                                        <form:options items="${status}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Work Life Balance:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="workLife" id="workLife" class="form-control" >
                                                        <form:option value="Excellent" label="Excellent"/>
                                                        <form:options items="${status}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Org. Policies & Procedures:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="orgPolicies" id="orgPolicies" class="form-control" >
                                                        <form:option value="Excellent" label="Excellent"/>
                                                        <form:options items="${status}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Employee Welfare Facilities:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="employeeWellfare" id="employeeWellfare" class="form-control" >
                                                        <form:option value="Excellent" label="Excellent"/>
                                                        <form:options items="${status}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Overall Organizational Culture:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="orgCulture" id="orgCulture" class="form-control" >
                                                        <form:option value="Excellent" label="Excellent"/>
                                                        <form:options items="${status}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                        </div>

                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">5)Please rate your supervisor on the following factors.:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId6">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun6();"><i class="fa fa-plus" id="minusId6" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">

                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Provide Candid & Constructive Performance Feedback:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="performanceFeedback" id="performanceFeedback" class="form-control" >
                                                        <%--<form:option value="Excellent" label="Excellent"/>--%>
                                                        <form:options items="${status3}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Recognize accomplishments:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="accomplishments" id="accomplishments" class="form-control" >
                                                        <%--<form:option value="Excellent" label="Excellent"/>--%>
                                                        <form:options items="${status3}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <!--<div class="form-group">-->
                                            <!--<label class="col-sm-5 control-label">Learning Opportunities:</label>-->
                                            <!--<div class="col-sm-5">-->
                                            <%--<form:select path="learningOpportunities" id="learningOpportunities" class="form-control" >--%>
                                            <%--<form:option value="Excellent" label="Excellent"/>--%>
                                            <%--<form:options items="${status}"></form:options>--%>
                                            <%--</form:select>--%>
                                            <!--</div>-->
                                            <!--</div>-->
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Clearly communicate expectations:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="cummunicateExpectation" id="cummunicateExpectation" class="form-control" >
                                                        <%--<form:option value="Excellent" label="Excellent"/>--%>
                                                        <form:options items="${status3}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Fair & Respectful Treatment:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="respectfullTreatment" id="respectfullTreatment" class="form-control" >
                                                        <%--<form:option value="Excellent" label="Excellent"/>--%>
                                                        <form:options items="${status3}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Provide Learning Opportunities:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="provideLearning" id="provideLearning" class="form-control" >
                                                        <%--<form:option value="Excellent" label="Excellent"/>--%>
                                                        <form:options items="${status3}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Coaching & Mentoring:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="coaching" id="coaching" class="form-control" >
                                                        <%--<form:option value="Excellent" label="Excellent"/>--%>
                                                        <form:options items="${status3}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Encourage teamwork & cooperation:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="teamWork" id="teamWork" class="form-control" >
                                                        <%--<form:option value="Excellent" label="Excellent"/>--%>
                                                        <form:options items="${status3}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Resolve concerns promptly:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="resolveConcern" id="resolveConcern" class="form-control" >
                                                        <%--<form:option value="Excellent" label="Excellent"/>--%>
                                                        <form:options items="${status3}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Listen to suggestions & feedback:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="listenToFeedback" id="listenToFeedback" class="form-control" >
                                                        <%--<form:option value="Excellent" label="Excellent"/>--%>
                                                        <form:options items="${status3}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Provide necessary & timely information:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="provideNecessaryInfo" id="provideNecessaryInfo" class="form-control" >
                                                        <%--<form:option value="Excellent" label="Excellent"/>--%>
                                                        <form:options items="${status3}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Support Work-Life Balance:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="sopportWorkLife" id="sopportWorkLife" class="form-control" >
                                                        <%--<form:option value="Excellent" label="Excellent"/>--%>
                                                        <form:options items="${status3}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                        </div>

                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">6)Please rate your next job on the following aspects in priority, which made you take the decision of leaving Zydex.
                                        </h3>
                                        <h3 class="box-title"> Please rate top three reasons by mentioning 1, 2 & 3 against each of the below items:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId7">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun7();"><i class="fa fa-plus" id="minusId7" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">

                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Compensation Offered:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="compensatiionOffered" id="compensatiionOffered" class="form-control">
                                                        <form:options items="${status1}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Role / Job matching my expectations:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="jobMatchingExpectation" id="jobMatchingExpectation" class="form-control">
                                                        <form:options items="${status1}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Higher Responsibilities & Job Enrichment:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="higherResponsibility" id="higherResponsibility" class="form-control">
                                                        <form:options items="${status1}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Designation & Level:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="designationOrLevel" id="designationOrLevel" class="form-control">
                                                        <form:options items="${status1}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Brand Consideration:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="brandConsideration" id="brandConsideration" class="form-control">
                                                        <form:options items="${status1}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Location:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="factorLocation" id="factorLocation" class="form-control">
                                                        <form:options items="${status1}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Time to Commute:</label>
                                                <div class="col-sm-5">
                                                    <form:select path="timeToCommute" id="timeToCommute" class="form-control">
                                                        <form:options items="${status1}"></form:options>
                                                    </form:select>
                                                </div>
                                            </div>
                                        </div>
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">7)Since how long were you considering leaving Zydex? What could have been done to retain you? Please mention in brief:</h3>
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
                                                        <form:textarea path="reasonForSustain" class="form-control"/>
                                                        <form:errors path="reasonForSustain" cssClass="errorDiv"></form:errors>
                                                        <div style="color: red"><form:errors path="reasonForSustain" cssClass="errorDiv"></form:errors></div>
                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->

                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">8)If given a choice or considered at a later date, would you like to re-join us?
                                                Please tick: Yes / No.  If No, Why?<br/>(Please mention in the space provided here below):</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId9">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun9();"><i class="fa fa-plus" id="minusId9" ></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label"></label>
                                                        <div class="col-sm-10">
                                                        <form:radiobutton path="againJoin" value="1"/>Yes
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <form:radiobutton path="againJoin" value="0"/>No
                                                    </div>
                                                    <br/>
                                                    <br/>
                                                    <div class="col-sm-12">
                                                        <form:textarea path="notToJoinReason" class="form-control"/>
                                                    </div>
                                                </div>
                                            </div><!-- /.col -->

                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">9)Any other Suggestions or Feedback? Please mention in brief:</h3>
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
                                                        <form:textarea path="otherFeedback" class="form-control"/>
                                                    </div>
                                                </div>
                                            </div><!-- /.col -->

                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                                <div class="form-group">
                                    <div class="col-lg-offset-5 col-sm-3">
                                        <!--<button type="submit" class="btn btn-success" data-original-title="" title="" style="width: 100px">Save</button>-->
                                        <!--<input type="button" class="btn btn-primary" value="Back" onclick="window.history.back();" />-->
                                        <button type="submit" class="btn btn-primary" data-original-title="" title="" style="width: 100px">Submit</button>
                                    </div>
                                    <div class="col-lg-4 col-sm-4">
                                    </div>
                                </div>
                            </form:form>
                        </div>
                        <div class="tab-pane" id="tab_3"></div>

                    </div>
                </div>
            </div>
        </section>
    </div>


    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>

