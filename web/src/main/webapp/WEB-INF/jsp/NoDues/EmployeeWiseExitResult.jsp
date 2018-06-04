<%--
    Document   : LeaveEmployeeDetailSearch
    Created on : Oct 19, 2015, 4:03:28 PM
    Author     : AJAY
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Employee Exit Detail Search</title>
    </head>

    <script>

        var flag3 = true;
        function saveSubmit11() {
            if (flag3) {
                flag3 = false;
                document.getElementById('saveSubmit1').innerHTML = 'Searching ... .. .';
                document.form1.submit();
                return true;
            } else {
                return false;
            }
        }
    </script>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>SEARCH </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Result Employee Exit Detail</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form" action="" commandName="employeeMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--<span style="color: red;font-size: 14px;">* indicates mandatory field.</span>-->
                                <!--form horizontal starts here-->

                                <div class="box box-info">
                                    <div class="box-header">
                                        <h3 class="box-title">Employee Detail:</h3>
                                        <div class="box-tools pull-right">
                                            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <c:forEach var="list" items="${list}">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Employee Name:</label>
                                                            <input type="Text" id="empName" class="form-control" value="${list[1]}" readonly>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Employee No.:</label>
                                                            <input type="Text" id="empNo" class="form-control" value="${list[0]}" readonly>
                                                        </div>
                                                        <input type="hidden" name="empId" value="${list[0]}"/>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Department:</label>
                                                            <input type="Text" id="dept" class="form-control" value="${list[2]}" readonly>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Designation:</label>
                                                            <input type="Text" id="desc" class="form-control"  value="${list[3]}" readonly>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Level:</label>
                                                            <input type="Text" id="level1" class="form-control" value="${list[4]}" readonly>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Reporting Manager:</label>
                                                            <input type="Text" id="manager" class="form-control" value="${list[5]}" readonly>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Work Location:</label>
                                                            <input type="Text" id="location" class="form-control" value="${list[6]}" readonly>
                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->
                                            </c:forEach>
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                                <c:if test="${not empty resgList}">
                                    <c:forEach var="resgList" items="${resgList}">
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Resignation Information:</h3>
                                        <div class="box-tools pull-right">
                                            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">Resignation Effective Date & Time:</label>
                                                    <div class=" col-sm-7">
                                                        <div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy - hh:ii " data-link-field="dtp_input1">
                                                            <input class="form-control" size="16" type="text" value="${resgList[0].effectiveDatetime}" readonly>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                        <!--Resignation Information completes Here-->
                                        <div class="box-header">
                                            <h3 class="box-title">Reason Of Resignation:</h3>
                                        </div><!-- /.box-header -->
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">Reason:</label>
                                                    <div class="col-sm-7">
                                                        <textarea class="form-control" rows="6">${resgList[0].reason}</textarea>
                                                    </div>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                        <div class="box-header">
                                            <h3 class="box-title">Manager Comment:</h3>
                                            <div class="box-tools pull-right">
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">Comment:</label>
                                                    <div class="col-sm-7">
                                                        <textarea class="form-control" rows="6">${resgList[0].managerComment}</textarea>
                                                    </div>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->
                                </c:forEach>
                            </c:if>
                                 <c:if test="${not empty exitList}">
                                    <c:forEach var="exitList" items="${exitList}">
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Exit Interview Information:</h3>
                                        <div class="box-tools pull-right">
                                            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="box-header">
                                            <h3 class="box-title">1)Please describe the primary reason(s) you are leaving your current position:</h3>
                                        </div><!-- /.box-header -->

                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label"></label>
                                                    <div class="col-sm-12">
                                                        <textarea type="Text" class="form-control">${exitList[0].reasonLeaving}</textarea>
                                                    </div>
                                                </div>
                                            </div><!-- /.col -->

                                        </div><!-- /.row -->

                                    <div class="box-header">
                                        <h3 class="box-title">2)Which of the below mentioned factors where you dissatisfied with, which triggered your thought to leave us?:</h3>
                                    </div><!-- /.box-header -->
                                    <div class="row">
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Type of Work or Profile:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                    <option value="${exitList[0].typeOfWork}">${exitList[0].typeOfWork}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Working conditions (setting, schedule, travel, flexibility):</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                     <option value="${exitList[0].workingCondition}">${exitList[0].workingCondition}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Current Compensation:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                     <option value="${exitList[0].currentCompensation}">${exitList[0].currentCompensation}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Grade / Level:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                     <option value="${exitList[0].gradeOrLevel}">${exitList[0].gradeOrLevel}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Reporting Manager:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                    <option value="${exitList[0].reportingManger}">${exitList[0].reportingManger}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Location:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                    <option value="${exitList[0].location}">${exitList[0].location}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Commutation or Transportation Issues:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                     <option value="${exitList[0].transportIssues}">${exitList[0].transportIssues}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Any Medical / Health Condition:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                    <option value="${exitList[0].medicalCondition}">${exitList[0].medicalCondition}</option>
                                                </select>
                                            </div>
                                        </div>

                                    </div>

                                    <div class="box-header">
                                        <h3 class="box-title">3)Please provide your candid feedback and rate the following aspects with reference to your job at SPC Lifesciences. (Please use the 1 – 5 scale below):</h3>
                                    </div><!-- /.box-header -->
                                    <div class="row">
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Job / Role Clarity:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                    <option value="${exitList[0].rateJob}">${exitList[0].rateJob}</option>

                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Fairness of Workload:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                    <option value="${exitList[0].rateWorkload}">${exitList[0].rateWorkload}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Work Conditions:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                    <option value="${exitList[0].rateWorkCondition}">${exitList[0].rateWorkCondition}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Current Compensation:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                     <option value="${exitList[0].rateCompensation}">${exitList[0].rateCompensation}</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Facilities & Tools provided to you:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                     <option value="${exitList[0].rateFacilites}">${exitList[0].rateFacilites}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Trainings & Learning Opportunities:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                    <option value="${exitList[0].rateLearning}">${exitList[0].rateLearning}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Support from Co-workers & Seniors within your team:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                    <option value="${exitList[0].rateSupportFromSeniors}">${exitList[0].rateSupportFromSeniors}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Reporting Manager – Guidance & Supervision:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                     <option value="${exitList[0].rateSupervision}">${exitList[0].rateSupervision}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Quality of Performance Feedback:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                    <option value="${exitList[0].rateQualityOfPerformance}">${exitList[0].rateQualityOfPerformance}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Overall Feedback about your Job:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                     <option value="${exitList[0].rateFeedbackAboutJob}">${exitList[0].rateFeedbackAboutJob}</option>
                                                </select>
                                            </div>
                                        </div>

                                    </div>

                                    <div class="box-header">
                                        <h3 class="box-title">4)Please rate the following aspects of the organization overall:</h3>
                                    </div><!-- /.box-header -->
                                    <div class="row">

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Openness & Transparency:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                     <option value="${exitList[0].transparency}">${exitList[0].transparency}</option>

                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Support & Cooperation from Employees (Across all Levels):</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                     <option value="${exitList[0].supportFromEmployee}">${exitList[0].supportFromEmployee}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Learning Opportunities:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                     <option value="${exitList[0].learning}">${exitList[0].learning}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Career development Opportunities:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                     <option value="${exitList[0].careerDevelopment}">${exitList[0].careerDevelopment}</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Overall Recognition for Job:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                     <option value="${exitList[0].recognisitonForJob}">${exitList[0].recognisitonForJob}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Work Life Balance:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                     <option value="${exitList[0].workLife}">${exitList[0].workLife}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Org. Policies & Procedures:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                    <option value="${exitList[0].orgPolicies}">${exitList[0].orgPolicies}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Employee Welfare Facilities:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                    <option value="${exitList[0].employeeWellfare}">${exitList[0].employeeWellfare}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Overall Organizational Culture:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                    <option value="${exitList[0].orgCulture}">${exitList[0].orgCulture}</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="box-header">
                                        <h3 class="box-title">5)Please rate your supervisor on the following factors.:</h3>
                                    </div><!-- /.box-header -->
                                    <div class="row">

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Provide Candid & Constructive Performance Feedback:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                     <option value="${exitList[0].performanceFeedback}">${exitList[0].performanceFeedback}</option>

                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Recognize accomplishments:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                    <option value="${exitList[0].accomplishments}">${exitList[0].accomplishments}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Learning Opportunities:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                    <option value="${exitList[0].learningOpportunities}">${exitList[0].learningOpportunities}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Clearly communicate expectations:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                    <option value="${exitList[0].cummunicateExpectation}">${exitList[0].cummunicateExpectation}</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Fair & Respectful Treatment:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                     <option value="${exitList[0].respectfullTreatment}">${exitList[0].respectfullTreatment}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Provide Learning Opportunities:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                     <option value="${exitList[0].provideLearning}">${exitList[0].provideLearning}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Coaching & Mentoring:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                     <option value="${exitList[0].coaching}">${exitList[0].coaching}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Encourage teamwork & cooperation:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                     <option value="${exitList[0].teamWork}">${exitList[0].teamWork}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Resolve concerns promptly:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                     <option value="${exitList[0].resolveConcern}">${exitList[0].resolveConcern}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Listen to suggestions & feedback:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                     <option value="${exitList[0].listenToFeedback}">${exitList[0].listenToFeedback}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Provide necessary & timely information:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                     <option value="${exitList[0].provideNecessaryInfo}">${exitList[0].provideNecessaryInfo}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Support Work-Life Balance:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                    <option value="${exitList[0].sopportWorkLife}">${exitList[0].sopportWorkLife}</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="box-header">
                                        <h3 class="box-title">6)Please rate your next job on the following aspects in priority, which made you take the decision of leaving SPC Lifesciences.
                                            Please rate top three reasons by mentioning 1, 2 & 3 against each of the below items:</h3>
                                    </div><!-- /.box-header -->
                                    <div class="row">

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Compensation Offered:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                    <option value="${exitList[0].compensatiionOffered}">${exitList[0].compensatiionOffered}</option>

                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Role / Job matching my expectations:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                     <option value="${exitList[0].jobMatchingExpectation}">${exitList[0].jobMatchingExpectation}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Higher Responsibilities & Job Enrichment:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                    <option value="${exitList[0].higherResponsibility}">${exitList[0].higherResponsibility}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Designation & Level:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                    <option value="${exitList[0].designationOrLevel}">${exitList[0].designationOrLevel}</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Brand Consideration:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                     <option value="${exitList[0].brandConsideration}">${exitList[0].brandConsideration}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Location:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                     <option value="${exitList[0].factorLocation}">${exitList[0].factorLocation}</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Time to Commute:</label>
                                            <div class="col-sm-7">
                                                <select id="TravelTypeSelectId" class="form-control">
                                                    <option value="${exitList[0].timeToCommute}">${exitList[0].timeToCommute}</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="box-header">
                                        <h3 class="box-title">7)Since how long were you considering leaving SPC Lifesciences? What could have been done to retain you? Please mention in brief:</h3>
                                    </div><!-- /.box-header -->
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label"></label>
                                                <div class="col-sm-12">
                                                    <textarea type="Text" class="form-control">${exitList[0].reasonForSustain}</textarea>
                                                </div>
                                            </div>
                                        </div><!-- /.col -->

                                    </div><!-- /.row -->
                                    <div class="box-header">
                                        <h3 class="box-title">8)If given a choice or considered at a later date, would you like to re-join us?
                                            Please tick: Yes / No.  If No, Why? (Please mention in the space provided here below):</h3>
                                    </div><!-- /.box-header -->
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label"></label>
                                                <div class="col-sm-12">
                                                    <textarea type="Text" class="form-control">${exitList[0].notToJoinReason}</textarea>
                                                </div>
                                            </div>
                                        </div><!-- /.col -->

                                    </div><!-- /.row -->
                                    <div class="box-header">
                                        <h3 class="box-title">9)Any other Suggestions or Feedback? Please mention in brief.:</h3>
                                    </div><!-- /.box-header -->
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label"></label>
                                                <div class="col-sm-12">
                                                    <textarea type="Text" class="form-control">${exitList[0].otherFeedback}</textarea>
                                                </div>
                                            </div>
                                        </div><!-- /.col -->

                                    </div><!-- /.row -->
                                </div>
                                </div>
                                    </c:forEach>
                                 </c:if>
 <c:if test="${not empty noDueList}">
                                    <c:forEach var="noDueList" items="${noDueList}">
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">No Due Form:</h3>
                                        <div class="box-tools pull-right">
                                            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                     <div class="box-body no-padding">
                                    <div class="box-header">
                                        <h3 class="box-title">Concerned Department:</h3>
                                    </div><!-- /.box-header -->
                                    <table id="demo" class="table table-bordered table-striped table-hover" style="" align="Center"  >



                                        <tr style="background-color: darkgrey">
                                            <th style="text-align: center"><b>Concerned Department</b></th>
                                            <th style="text-align: center">Status</th>
                                            <th style="text-align: center">Remark</th>

                                        </tr>


                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle"><b>Equipments / Manuals / Files </b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <select id="TravelTypeSelectId" class="form-control">
                                                             <option value="${noDueList[0].equipments}">${noDueList[0].equipments}</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-12">
                                                        <textarea class="form-control" rows="2">${noDueList[0].equipmentsRemarks}</textarea>                                                    </div>
                                                </div>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle"><b>Special Tools & Gadgets </b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <select id="TravelTypeSelectId" class="form-control">
                                                             <option value="${noDueList[0].specialTool}">${noDueList[0].specialTool}</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-12">
                                                        <textarea class="form-control" rows="2">${noDueList[0].specialToolRemark}</textarea>                                                    </div>
                                                </div>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle"><b>Computer Files & Password /Cupboard Keys</b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <select id="TravelTypeSelectId" class="form-control">
                                                             <option value="${noDueList[0].computerFiles}">${noDueList[0].computerFiles}</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-12">
                                                        <textarea class="form-control" rows="2">${noDueList[0].computerFilesRemark}</textarea>                                                    </div>
                                                </div>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td  style="background-color: lightgrey;vertical-align: middle"><b>Transfer of Advance Amount (please mention name in remarks)</b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <select id="TravelTypeSelectId" class="form-control">
                                                             <option value="${noDueList[0].advanceAmount}">${noDueList[0].advanceAmount}</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-12">
                                                        <textarea class="form-control" rows="2" >${noDueList[0].advanceAmountRemark} </textarea>                                                    </div>
                                                </div>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle">
                                                <b>Other</b>
                                                <textarea class="form-control">${noDueList[0].deptOtherText}</textarea>
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <select id="TravelTypeSelectId" class="form-control">
                                                            <option value="${noDueList[0].deptOther}">${noDueList[0].deptOther}</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-12">
                                                        <textarea class="form-control" rows="2" >${noDueList[0].deptOtherRemark} </textarea>                                                    </div>
                                                </div>
                                            </td>

                                        </tr>

                                    </table>

                                    <!-- /.col -->
                                    <div class="box-header">
                                        <h3 class="box-title">HR / Administration:</h3>
                                    </div><!-- /.box-header -->
                                    <table id="demo" class="table table-bordered table-striped table-hover" style="" align="Center"  >



                                        <tr style="background-color: darkgrey">
                                            <th style="text-align: center"><b>Concerned Department</b></th>
                                            <th style="text-align: center">Status</th>
                                            <th style="text-align: center">Remark</th>

                                        </tr>



                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle"><b>Company provided car </b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <select id="TravelTypeSelectId" class="form-control">
                                                             <option value="${noDueList[0].carProvided}">${noDueList[0].carProvided}</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-12">
                                                        <textarea class="form-control" rows="2" >${noDueList[0].carProvidedRemark} </textarea>                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle"><b>Returnable Stationary Items – calculator, punch, stapler, etc.</b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <select id="TravelTypeSelectId" class="form-control">
                                                             <option value="${noDueList[0].stationaryItem}">${noDueList[0].stationaryItem}</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-12">
                                                        <textarea class="form-control" rows="2" >${noDueList[0].stationaryItemRemark} </textarea>                                                    </div>
                                                </div>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td  style="background-color: lightgrey;vertical-align: middle"><b>Checking  of   company  provided residence and equipments installed inside</b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <select id="TravelTypeSelectId" class="form-control">
                                                             <option value="${noDueList[0].residance}">${noDueList[0].residance}</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-12">
                                                        <textarea class="form-control" rows="2" > ${noDueList[0].residanceRemark}</textarea>                                                    </div>
                                                </div>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td  style="background-color: lightgrey;vertical-align: middle"><b>Identity Card</b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <select id="TravelTypeSelectId" class="form-control">
                                                             <option value="${noDueList[0].identityCard}">${noDueList[0].identityCard}</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-12">
                                                        <textarea class="form-control" rows="2" > ${noDueList[0].identityCardRemark}</textarea>                                                    </div>
                                                </div>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle">
                                                <b>Other</b>
                                                <textarea class="form-control">${noDueList[0].hrOtherText}</textarea>
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <select id="TravelTypeSelectId" class="form-control">
                                                             <option value="${noDueList[0].hrOther}">${noDueList[0].hrOther}</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-12">
                                                        <textarea class="form-control" rows="2" >${noDueList[0].hrOtherRemark} </textarea>                                                    </div>
                                                </div>
                                            </td>

                                        </tr>

                                    </table>

                                    <!-- /.col -->
                                    <div class="box-header">
                                        <h3 class="box-title">I.T Department:</h3>
                                    </div><!-- /.box-header -->
                                    <table id="demo" class="table table-bordered table-striped table-hover" style="" align="Center"  >

                                        <tr style="background-color: darkgrey">
                                            <th style="text-align: center"><b>Concerned Department</b></th>
                                            <th style="text-align: center">Status</th>
                                            <th style="text-align: center">Remark</th>
                                        </tr>
                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle"><b>Company mobile phone </b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <select id="TravelTypeSelectId" class="form-control">
                                                             <option value="${noDueList[0].companyMobile}">${noDueList[0].companyMobile}</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-12">
                                                        <textarea class="form-control" rows="2" >${noDueList[0].companyMobileRemark} </textarea>                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle"><b>Computer Checked / Password / Printer Recovered </b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <select id="TravelTypeSelectId" class="form-control">
                                                             <option value="${noDueList[0].computerChecked}">${noDueList[0].computerChecked}</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-12">
                                                        <textarea class="form-control" rows="2" >${noDueList[0].computerCheckedRemark} </textarea>                                                    </div>
                                                </div>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle"><b>Domain Name Changed / Email</b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <select id="TravelTypeSelectId" class="form-control">
                                                             <option value="${noDueList[0].email}">${noDueList[0].email}</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-12">
                                                        <textarea class="form-control" rows="2" >${noDueList[0].emailRemark} </textarea>                                                    </div>
                                                </div>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle"><b>Computer Transferred To(please mention name in remarks)</b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <select id="TravelTypeSelectId" class="form-control">
                                                            <option value="${noDueList[0].computerTransfered}">${noDueList[0].computerTransfered}</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-12">
                                                        <textarea class="form-control" rows="2" >${noDueList[0].computerTransferedRemark} </textarea>                                                    </div>
                                                </div>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle">
                                                <b>Other</b>
                                                <textarea class="form-control">${noDueList[0].itOtherText}</textarea>
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <select id="TravelTypeSelectId" class="form-control">
                                                             <option value="${noDueList[0].itOther}">${noDueList[0].itOther}</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-12">
                                                        <textarea class="form-control" rows="2" >${noDueList[0].itOtherRemark} </textarea>                                                    </div>
                                                </div>
                                            </td>

                                        </tr>


                                    </table>

                                    <!-- /.col -->
                                    <div class="box-header">
                                        <h3 class="box-title">Finance Department:</h3>
                                    </div><!-- /.box-header -->
                                    <table id="demo" class="table table-bordered table-striped table-hover" style="" align="Center"  >



                                        <tr style="background-color: darkgrey">
                                            <th style="text-align: center"><b>Concerned Department</b></th>
                                            <th style="text-align: center">Status</th>
                                            <th style="text-align: center">Remark</th>

                                        </tr>


                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle"><b>Advance Cleared</b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <select id="TravelTypeSelectId" class="form-control">
                                                            <option value="${noDueList[0].advanceCleared}">${noDueList[0].advanceCleared}</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-12">
                                                        <textarea class="form-control" rows="2" >${noDueList[0].advanceClearedRemark} </textarea>                                                    </div>
                                                </div>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle"><b>Pending Bills Submitted</b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <select id="TravelTypeSelectId" class="form-control">
                                                             <option value="${noDueList[0].pendingBills}">${noDueList[0].pendingBills}</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-12">
                                                        <textarea class="form-control" rows="2" >${noDueList[0].pendingBillsRemark} </textarea>                                                    </div>
                                                </div>
                                            </td>

                                        </tr>

                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle"><b>Salary Advance / Loans / Earlier Travel Remittance</b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <select id="TravelTypeSelectId" class="form-control">
                                                            <option value="${noDueList[0].salaryAdvanceOrLoan}">${noDueList[0].salaryAdvanceOrLoan}</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-12">
                                                        <textarea class="form-control" rows="2" >${noDueList[0].salaryAdvanceOrLoanRemark} </textarea>                                                    </div>
                                                </div>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle">
                                                <b>Other</b>
                                                <textarea class="form-control">${noDueList[0].financeOtherText}</textarea>
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <select id="TravelTypeSelectId" class="form-control">
                                                            <option value="${noDueList[0].financeOther}"></option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-12">
                                                        <textarea class="form-control" rows="2" >${noDueList[0].financeOtherRemark} </textarea>                                                    </div>
                                                </div>
                                            </td>

                                        </tr>

                                    </table>

                                    <!-- /.col -->
                                </div><!-- /.row -->
                            </div><!-- /.row -->
                                    </c:forEach>
 </c:if>

                        <div class="form-group">
                            <div class=" col-sm-2">
                                <input type="button" class="btn btn-primary" value="Back" onclick="window.history.back();" />
                            </div>
                        </div>

                    </div>
                </div>
        </div>
    </div>
</section>
</form:form>
</div>

<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>

