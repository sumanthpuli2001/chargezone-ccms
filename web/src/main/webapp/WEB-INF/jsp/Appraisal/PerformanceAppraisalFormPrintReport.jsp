<%--

    Document   : PerformanceAppraisalForm
    Created on : Oct 5, 2015, 2:47:30 PM
    Author     : dhaval
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%--<%@include file="/WEB-INF/jsp/Common/Header.jsp"%>--%>
    <%--<%@include file="/WEB-INF/jsp/Common/Top.jsp"%>--%>

    <%--<%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>--%>
    <%--<%@include file="/WEB-INF/jsp/Common/EmployeeComman.jsp"%>--%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <head>
        <link rel="stylesheet" href="StorageYard/Plugins/datatables/jquery.dataTables.min.css">
        <link rel="stylesheet" href="StorageYard/CSS/bootstrap/bootstrap.min.css">
        <!--<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">-->
        <link rel="stylesheet" href="StorageYard/CSS/bootstrap/font-awesome.min.css">
        <link rel="stylesheet" href="StorageYard/CSS/bootstrap/vms.css">
        <!--<link rel="stylesheet" href="StorageYard/CSS/bootstrap/bootstrap.min.css">-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>Performance Appraisal Form</title>
        <style>
            td { word-break: break-all;}
            select {
                /*for firefox*/
                -moz-appearance: none;
                /*for chrome*/
                -webkit-appearance:none;

                /*                select::-ms-expand {
                    display: none;
                }*/
            }
        </style>
    </head>
    <style type="text/css">
        @media print {
            #demo234 tr th  {
                background-color: darkgrey !important;
            }
            #demo234 tr#tbl111 td {
                background-color: #337AB7 !important;
            }
            #demo234 tr#tbl112 td {
                background-color: #5CB85C !important;
            }
            #demo234 tr#tbl113 td {
                background-color: #F0AD4E !important;
            }
            #demo234 tr#tbl114 td {
                background-color: #FFA375 !important;
            }
            #demo234 tr#tbl115 td {
                background-color: #D9534F !important;
            }
        }

    </style>
    <script>
        window.print();
    </script>
    <body>
        <!--<div class="content-wrapper">-->
        <span class="logo-lg"><img src="StorageYard/Images/logo.png" style="width: 160px;float: left;"/></span>
        <!-- Content Header (Page header) -->
        <section class="content-header">

            <div class="col-md-2">

                <!--<input type="hidden" id="empId" name="empId" value="${empId}">-->
                <!--<input type="hidden" id="userid" name="userid" value="${userid}">-->
                <!--<input type="hidden" id="appraisalId" name="appraisalId" value="${appraisalId}">-->
                <!--<input type="hidden" id="managerStatus" name="managerStatus" value="${managerStatus}">-->
            </div>
        </section>
    <form:form class="form-horizontal" id="form1" role="form1" action="" commandName="appraisalPerformanceMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="box-header">
                                <span style="text-align: center"><h2>Performance Appraisal Report</h2></span>
                                <h3 class="box-title">Employee Detail:</h3>

                            </div><!-- /.box-header -->
                            <div class="box-body no-padding">
                                <div class="row">

                                    <div class="col-md-12 col-sm-12">
                                        <div class="form-group">
                                            <div class="col-sm-2">
                                                <label>Employee No.:</label>
                                            </div>
                                            <div class="col-sm-4">
                                                <input type="Text" class="form-control" readonly value="${employeeMaster[0]}">
                                            </div>
                                            <div class="col-sm-2">
                                                <label>Employee Name:</label>
                                            </div>
                                            <div class="col-sm-4">
                                                <input type="Text" id="employeeName" name="employeeName"  class="form-control" readonly value="${employeeMaster[1]}">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-2">
                                                <label>Designation:</label>
                                            </div>
                                            <div class="col-sm-4">
                                                <input type="Text" class="form-control" readonly value="${employeeMaster[2]}">
                                            </div>
                                            <div class="col-sm-2">
                                                <label>Level:</label>
                                            </div>
                                            <div class="col-sm-4">
                                                <input type="Text" class="form-control" readonly value="${employeeMaster[3]}">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-2">
                                                <label>Department:</label>
                                            </div>
                                            <div class="col-sm-4">
                                                <input type="Text" class="form-control" readonly value="${employeeMaster[4]}">
                                            </div>
                                            <div class="col-sm-2">
                                                <label>Work Location:</label>
                                            </div>
                                            <div class="col-sm-4">
                                                <input type="Text" class="form-control" readonly value="${employeeMaster[5]}">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-2">
                                                <label>Reporting Manager:</label>
                                            </div>

                                            <div class="col-sm-4">
                                                <input type="Text" class="form-control" readonly value="${reportingManager}">
                                                <select id="kraCategoryMapHiddenMap" name="kraCategoryMapHiddenMap" class="form-control" style="display: none;" >
                                                    <option value="">--SELECT--</option>
                                                    <c:forEach var="kraCategory" items="${kraCategoryMap}">
                                                        <option value="${kraCategory.key}">${kraCategory.value}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div><!-- /.col -->
                                </div><!-- /.row -->
                            </div>
                            <div class="box-header">
                                <h3 class="box-title">Results:</h3>
                            </div><!-- /.box-header -->
                            <div class="box-body no-padding">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12">
                                        <div class="table-responsive">
                                            <table id="demo" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                <tr>
                                                <input type="hidden" name="flagId" id="flagId" value="${flag}">
                                                <input type="hidden" name="flagMidId" id="flagMidId" value="${flag1}">
                                                <input type="hidden" name="flagEndId" id="flagEndId" value="${flag2}">
                                                <input type="hidden" name="countId" id="countId" value="${fn:length(kragoal)}">
                                                <input type="hidden" name="appraisalId" id="appraisalId" value="${appraisalId}">
                                                <input type="hidden" name="employeeId" id="employeeId" value="${employeeId}">
                                                <input type="hidden" name="year" id="year" value="${year}">
                                                <th style="text-align: center">Sr. No.</th>
                                                <th style="text-align: center" id="kraGoalid1">High Impact Goal / KRA</th>
                                                <th style="text-align: center" id="metricid1">Metric</th>
                                                <th style="text-align: center" id="metricid1">KRA Category</th>

                                                <th style="margin: 0px;width: 100px;text-align: center" id="weightageid12">Weightage Out Of 75</th>

                                                <th style="margin: 0px;width: 130px;text-align: center" id="midYearDivid1">Mid Year Status</th>
                                                <th style="margin: 0px;width: 130px;text-align: center" id="endYearDivid1">End Year Status</th>
                                                <th style="margin: 0px;width: 100px;text-align: center" id="finalScoreid">Final Score</th>
                                                </tr>
                                                <input type="hidden" name="kragoalLength" id="kragoalLength" value="${fn:length(kragoal)}">

                                                <c:choose>
                                                    <c:when test="${fn:length(kragoal) > 0}">
                                                        <c:forEach var="kragoallist" items="${kragoal}" varStatus="status">
                                                            <tr>
                                                            <input type="hidden" name="kragoal_id${status.count}" id="kragoal_id${status.count}" value="${kragoallist.id}">
                                                            <td style="margin: 0px;width: 45px;">${status.count}</td>
                                                            <td id="kraGoalid1${status.count}">${kragoallist.kraGoalByManager}</td>
                                                            <td id="metricid1${status.count}">${kragoallist.matrixByManager}
                                                            </td>
                                                            <td id="kraCategoryId${status.count}">
                                                                <c:forEach var="kraCategory" items="${kraCategoryMap}">
                                                                    <c:if test="${kragoallist.kraCategoryByKraCategoryByManager.id eq kraCategory.key}">
                                                                    <option value="${kraCategory.key}" selected="">${kraCategory.value}</option>
                                                                </c:if>
                                                            </c:forEach>
                                                            </td>
                                                            <td id="weightageid1${status.count}">${kragoallist.weightage}</td>
                                                            <td id="midYearDivid1${status.count}">${kragoallist.midyearStatus}</td>
                                                            <td id="endYearDivid1${status.count}">${kragoallist.endyearStatus}</td>
                                                            <td id="finalScoreid${status.count}">${kragoallist.finalScore}</td>
                                                            </tr>
                                                            <tr id="employeesMid">
                                                                <td colspan="3"><b>Employee’s Mid - Year Self – Assessment Goal:</b></td>
                                                                <td colspan="5"><b>Manager’s Mid - Year Review / Evaluation Goal:</b></td>
                                                            </tr>
                                                            <tr id="textemployeesMid">
                                                                <td colspan="3">${kragoallist.empMidyearSelfassessmentGoal}</td>
                                                                <td colspan="5">${kragoallist.managerMidyearReviewEvaluation}</td>
                                                            </tr>
                                                            <tr id="employeesEnd">
                                                                <td colspan="3"><b>Employee’s End - Year Self – Assessment Goal:</b></td>
                                                                <td colspan="5"><b>Manager’s End - Year Review / Evaluation Goal:</b></td>
                                                            </tr>
                                                            <tr id="textemployeesEnd">
                                                                <td colspan="3">${kragoallist.empEndyearSelfassessmentGoal}</td>
                                                                <td colspan="5">${kragoallist.managerEndyearReviewEvaluation}</td>
                                                            </tr>
                                                        </c:forEach>
                                                    </c:when>
                                                    <c:otherwise></c:otherwise>
                                                </c:choose>
                                            </table>
                                        </div>
                                        <div class="table-responsive">
                                            <table id="demo1" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                <tr id="weightage">
                                                    <td style="margin: 0px;width: 100px;"></td>
                                                    <td style="margin: 0px;width: 100px;"></td>
                                                    <td style="margin: 0px;width: 285px;" align="right" id="weightageScoreId"><b>Weightage Score</b></td>
                                                    <td style="margin: 0px;width: 100px;" id="dhaval"><input id="weightageScore" name="weightageScore" value="${weightageScore}" class="form-control" style="margin: 0px;width: 100px;" readonly="true"></input></td>
                                                    <td style="margin: 0px;width: 170px;">
                                                    </td>
                                                    <td style="margin: 0px;width: 90px;" align="right" id="totalScoreId"><b>Total Score</b>
                                                    </td>
                                                    <td>
                                                        <input id="totalScore" name="totalScore" value="<fmt:formatNumber minFractionDigits="0" value="${totalScore}"></fmt:formatNumber>" class="form-control" style="margin: 0px;width: 100px;" readonly></input></td>
                                                        <td></td>
                                                    </tr>
                                                </table>

                                            </div>
                                            <!--                                            <div class="table-responsive">
                                                                                            <table id="demo1" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                                                                <tr>
                                                                                                    <td id="employeesMidOtherActivity"><b>Employee’s Mid - Year Self – Assessment For Other Activities:</b></td>
                                                                                                    <td id="managersMidOtherActivity"><b>Manager’s Mid - Year Review / Evaluation For Other Activities:</b></td>
                                                                                                </tr>
                                                                                                <tr>
                                                                                                    <td id="employeesMidOtherActivity1">${empMidyearSelfassOtheractivty}</td>
                                                                                                <td id="managersMidOtherActivity1">${managerMidyearReviewevalOtheractivity}</td>
                                                                                            </tr>
                                                                                            <tr>
                                                                                                <td id="employeesEndOtherActivity"><b>Employee’s End - Year Self – Assessment For Other Activities:</b></td>
                                                                                                <td id="managersEndOtherActivity"><b>Manager’s End - Year Review / Evaluation For Other Activities:</b></td>
                                                                                            </tr>
                                                                                            <tr>
                                                                                                <td id="employeesEndOtherActivity1">${empEndyearSelfassOtheractivty}</td>
                                                                                                <td id="managersEndOtherActivity1">${managerEndyearReviewevalOtheractivity}</td>
                                                                                            </tr>
                                                                                        </table>
                                            
                                                                                    </div>-->

                                    </div>


                                </div>
                            </div>

                            <c:if test="${year == 2016}">
                                <div class="box-header">
                                    <h3 class="box-title">Additional Activities / Projects:</h3>

                                </div>

                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table-responsive">
                                                <table id="demo10" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                    <tr>

                                                    <input type="hidden" name="status1" id="status1" value="${status}">

                                                    <input type="hidden" id="managerStatus" name="managerStatus" value="${managerStatus}">
                                                    <input type="hidden" id="employeeStatus" name="employeeStatus" value="${employeeStatus}">
                                                    <input type="hidden" name="weightage" id="weightage" value="${weightage}">

                                                    <th style="text-align: center">Sr. No.</th>


                                                    <th style="text-align: center" id="kraGoalid1">Additional Activities / Projects</th>
                                                    <th style="text-align: center" id="metricid1">Metric</th>
                                                    <th style="text-align: center" id="metricid1">KRA Category</th>

                                                    <th style="margin: 0px;width: 25px;text-align: center;" id="">Priority</th>

                                                    <th style="margin: 0px;width: 70px;text-align: center" id="midYearDivid">Mid Year Status</th>
                                                    <th style="margin: 0px;width: 70px;text-align: center" id="endYearDivid1">End Year Status</th>
                                                    <th style="margin: 0px;width: 25px;text-align: center" id="finalScoreid01">Activity/Project Performance</th>


                                                    </tr>
                                                    <input type="hidden" name="kragoalLengthactivity" id="kragoalLengthactivity" value="${fn:length(kragoalOtherActivity)}">

                                                    <c:choose>
                                                        <c:when test="${fn:length(kragoalOtherActivity) > 0}">
                                                            <input type="hidden" name="countactivityId" id="countactivityId" value="${fn:length(kragoalOtherActivity)}">
                                                            <c:forEach var="kragoalOtherActivity" items="${kragoalOtherActivity}" varStatus="status">
                                                                <%--<c:if test="${kragoallist.kragoal_activity ne '' && kragoallist.metric_activity ne ''}">--%>
                                                                <tr>
                                                                <input type="hidden" name="kragoal_activity_id${status.count}" id="kragoal_activity_id${status.count}" value="${kragoalOtherActivity.id}">
                                                                <td style="margin: 0px;width: 45px;">${status.count} </td>
                                                                <td id="">${kragoalOtherActivity.kraGoalActivitiesManager}</td>
                                                                <td id="">${kragoalOtherActivity.metricActivitiesManager}</td>
                                                                <td id="kraCategoryId${status.count}">

                                                                    <c:forEach var="kraCategory" items="${kraCategoryMap}">
                                                                        <c:if test="${kragoalOtherActivity.kraCategoryByManagerActivities eq kraCategory.key}">
                                                                            ${kraCategory.value}
                                                                        </c:if>
                                                                    </c:forEach>

                                                                </td>
                                                                <td id="priorityid${status.count}">
                                                                    ${kragoalOtherActivity.priority}
                                                                </td> 
                                                                <td id="midYearDivid1${status.count}">
                                                                    ${kragoalOtherActivity.midyearStatusActivities}
                                                                </td>
                                                                <td id="endYearDivid1${status.count}">${kragoalOtherActivity.endyearStatusActivities}</td>


                                                                <td id="activityDivid1${status.count}">${kragoalOtherActivity.activity}</td>


                                                                </tr>

                                                                <!--<table id="demo1" class="table table-bordered table-striped table-hover" style="" align="Center">-->


                                                                <tr id="">
                                                                    <td colspan="3"><b>Employee’s Mid - Year Self – Assessment For Other Activities:</b></td>
                                                                    <td colspan="5"><b>Manager’s Mid - Year Review / Evaluation For Other Activities:</b></td>
                                                                </tr>
                                                                <tr id="">
                                                                    <td colspan="3">${kragoalOtherActivity.empMidyearSelfassessmentGoalActivities}</td>
                                                                    <td colspan="5">${kragoalOtherActivity.managerMidyearSelfassesssmentGoalActivities}</td>
                                                                </tr>

                                                                <tr id="">
                                                                    <td colspan="3"><b>Employee’s End - Year Self – Assessment For Other Activities:</b></td>
                                                                    <td colspan="5"><b>Manager’s End - Year Review / Evaluation For Other Activities:</b></td>
                                                                </tr>
                                                                <tr id="">
                                                                    <td colspan="3">${kragoalOtherActivity.empEndyearSelfassessmentGoalActivities}</td>
                                                                    <td colspan="5">${kragoalOtherActivity.managerEndyearSelfassesssmentGoalActivities}</td>
                                                                </tr>
                                                                <!--</table>-->


                                                            </c:forEach>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <tr>
                                                                <td style="margin: 0px;width: 45px;">1</td>
                                                                <%--<c:if test="${flag eq true}">--%>
                                                            <input type="hidden" name="countactivityId" id="countactivityId" value="1">
                                                            <!--<td id="kraGoalid"><textarea type="Text" name="kraGoal1" id="kraGoal1" class="form-control"></textarea></td>-->
                                                            <td id=""></td>
                                                            <td id=""></td>
                                                            <td id="kraCategoryId">
                                                                <select id="kraCategoryMap1" name="kraCategoryMap1" class="form-control" style="margin: 0px;width: 115px;">
                                                                    <option value="">--SELECT--</option>
                                                                    <c:forEach var="kraCategory" items="${kraCategoryMap}">
                                                                        <option value="${kraCategory.key}">${kraCategory.value}</option>
                                                                    </c:forEach>
                                                                </select>
                                                            </td>
                                                            <td id="priorityid">
                                                                <select id="priority1" name="priority1" class="form-control" style="margin: 0px;width: 115px;">
                                                                    <option value="">--SELECT--</option>
                                                                    <option value="High Priority">High Priority</option>
                                                                    <option value="Medium Priority">Medium Priority</option>
                                                                    <option value="Low Priority">Low Priority</option>
                                                                </select>
                                                            </td> 
                                                            <td id="midYearDividact1"><div>
                                                                    <select id="midYearDivOther1" name="midYearDivOther1" class="form-control" style="margin: 0px;width: 115px;">
                                                                        <option value="">--SELECT--</option>
                                                                        <option value="Yet to Start">Yet to Start</option>
                                                                        <option value="In Progress">In Progress</option>
                                                                        <option value="Completed">Completed</option>
                                                                        <option value="Canceled">Canceled</option>
                                                                    </select>
                                                                </div>
                                                            </td>
                                                            <td id="endYearDividact"><div>
                                                                    <select id="endYearDivOther1" name="endYearDivOther1" class="form-control" style="margin: 0px;width: 115px;">
                                                                        <option value="">--SELECT--</option>
                                                                        <option value="Yet to Start">Yet to Start</option>
                                                                        <option value="In Progress">In Progress</option>
                                                                        <option value="Completed">Completed</option>
                                                                        <option value="Canceled">Canceled</option>
                                                                    </select>
                                                                </div>
                                                            </td>
                                                            <td id="">
                                                                <select id="activity1" name="activity1" class="form-control" style="margin: 0px;width: 115px;">
                                                                    <option value="">--SELECT--</option>
                                                                    <option value="Excellent">Excellent</option>
                                                                    <option value="Very Good">Very Good</option>
                                                                    <option value="Good">Good</option>
                                                                    <option value="Average">Average</option>
                                                                    <option value="Needs Improvement">Needs Improvement</option>
                                                                </select>
                                                            </td>


                                                            <tr id="employeesMid">
                                                                <td colspan="4"><b>Employee’s Mid - Year Self – Assessment For Other Activities:</b></td>
                                                                <td colspan="4"><b>Manager’s Mid - Year Review / Evaluation For Other Activities:</b></td>
                                                            </tr>
                                                            <tr id="textemployeesMid">
                                                                <td colspan="4"></td>
                                                                <td colspan="4"></td>
                                                            </tr>

                                                            <tr id="employeesEnd">
                                                                <td colspan="4"><b>Employee’s End - Year Self – Assessment For Other Activities:</b></td>
                                                                <td colspan="4"><b>Manager’s End - Year Review / Evaluation For Other Activities:</b></td>
                                                            </tr>
                                                            <tr id="textemployeesEnd">
                                                                <td colspan="4"></td>
                                                                <td colspan="4"></td>
                                                            </tr>

                                                        </c:otherwise>
                                                    </c:choose>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:if>


                            <div class="box-header">
                                <h3 class="box-title">Competency Evaluation (As Per SPC Life Science Competency Framework) :</h3>

                            </div><!-- /.box-header -->
                            <div class="box-body no-padding">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12">

                                        <div>
                                            <div><input type="text" id="competencyEvaluationId" class="form-control" name="competencyEvaluationId" value="${competencyEvaluationList[0][2].title}" readonly="true"></div>
                                        </div>

                                        <div class="col-md-12 col-sm-12">
                                            <div class="table-responsive">
                                                <table id="demo9" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                    <tr>
                                                        <th style="text-align: center">No</th>
                                                        <th style="text-align: center">Title</th>
                                                        <th style="text-align: center">Start Year</th>
                                                        <th style="text-align: center">Remark</th>
                                                        <th style="text-align: center" id="midYearText">Mid Year</th>
                                                        <th style="text-align: center" id="midYearRemarkText">Remark</th>
                                                        <th style="text-align: center" id="endYearText">End Year</th>
                                                        <th style="text-align: center" id="endYearRemarkText">Remark</th>
                                                    </tr>
                                                    <input type="hidden" name="subCompentencyCount" id="subCompentencyCount" value="${fn:length(competencyEvaluationList)}">
                                                    <%--<c:choose>--%>
                                                    <%--<c:when test="${fn:length(competencyEvaluationList) > 0}">--%>
                                                    <c:forEach var="competencyEvaluationList" items="${competencyEvaluationList}" varStatus="status">

                                                        <input type="hidden" name="competencyEveId${status.count}" id="competencyEveId${status.count}" value="${competencyEvaluationList[0]}">

                                                        <input type="hidden" name="competencyEvaluationId${status.count}" id="competencyEvaluationId${status.count}" value="${competencyEvaluationList[2].id}">
                                                        <input type="hidden" name="compentencyTextMasterId${status.count}" id="compentencyTextMasterId${status.count}" value="${competencyEvaluationList[3].id}">
                                                        <tr class="">
                                                            <td id="subCompentencySrId${status.count}">${status.count}</td>
                                                            <!--<td><input type="text" id="demo" name="demo"></td>-->
                                                            <!--<td>$/{competencyEvaluationList[0][4].infoText}</td>-->
                                                            <td id="subCompentencyTitleId${status.count}">${competencyEvaluationList[4]}</td>
                                                            <td id="subCompentencyStartId${status.count}">${competencyEvaluationList[11]}</td>

                                                            <td id="subCompentencyStartRemarkId${status.count}">
                                                                ${competencyEvaluationList[12]}
                                                            </td>
                                                            <td id="subCompentencyMidId${status.count}">${competencyEvaluationList[7]}</td>

                                                            <td id="subCompentencyMidRemarkId${status.count}">
                                                                ${competencyEvaluationList[8]}
                                                            </td>
                                                            <td id="subCompentencyEndId${status.count}">${competencyEvaluationList[9]}</td>

                                                            <td id="subCompentencyEndRemarkId${status.count}">${competencyEvaluationList[10]}</td>
                                                        </tr>

                                                    </c:forEach>

                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div><!-- /.box-body -->
                            </div>


                            <div class="box-header">
                                <h3 class="box-title">Individual Development Plan(Training Need Identification):</h3>

                            </div><!-- /.box-header -->
                            <div class="box-body no-padding">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12">

                                        <div class="table-responsive">
                                            <table id="demo5" class="table table-bordered table-striped table-hover" style="" align="Center"  >

                                                <tr>
                                                    <th style="text-align: center">Sr.No.</th>
                                                    <th style="text-align: center">IDP Name & Details</th>
                                                    <th style="text-align: center">IDP Type</th>
                                                    <th style="text-align: center">How to achieve this IDP</th>
                                                </tr>
                                                <tr>
                                                <input type="hidden" name="IndividualId" id="IndividualId" value="${fn:length(individualDevelopmentPlanList)}">

                                                <c:choose>
                                                    <c:when test="${not empty individualDevelopmentPlanList}">

                                                        <c:forEach var="individualDevelopmentPlan" items="${individualDevelopmentPlanList}" varStatus="status">
                                                            <tr>
                                                                <td style="text-align: center">${status.count}</td>
                                                            <input type="hidden" name="IndividualDevelopmentPlanId${status.count}" id="IndividualDevelopmentPlanId${status.count}" value="${individualDevelopmentPlan.id}">
                                                            <td id="indDevId">${individualDevelopmentPlan.managertext1}</td>
                                                            <td>${individualDevelopmentPlan.managertext2}</td>
                                                            <td>${individualDevelopmentPlan.managertext3}</td>

                                                            <td>${individualDevelopmentPlan.managerremark}</td>
                                                            </tr>
                                                            <tr>
                                                                <td colspan="3" id="midYearReId${status.count}"><b>Employee Mid-Year Remark</b></td>
                                                                <td colspan="3" id="endYearReId${status.count}"><b>Employee End-Year Remark</b></td>
                                                            </tr>
                                                            <tr>

                                                                <td colspan="3" id="midYearRetxtId${status.count}">${individualDevelopmentPlan.midYearRemark}</td>
                                                                <td colspan="3" id="endYearRetxtId${status.count}">${individualDevelopmentPlan.endYearRemark}</td>
                                                            </tr>
                                                            <tr>
                                                                <td colspan="3" id="endYearReId"><b>Manager Mid-Year Remark</b></td>
                                                                <td colspan="3" id="endYearReId"><b>Manager End-Year Remark</b></td>
                                                            </tr>
                                                            <tr>
                                                                <td colspan="3">${individualDevelopmentPlan.managerMidYearRemark}</td>
                                                                <td colspan="3">${individualDevelopmentPlan.managerEndYearRemark}</td>
                                                            </tr>
                                                        </c:forEach>
                                                    </c:when>
                                                    <c:otherwise>

                                                    </c:otherwise>
                                                </c:choose>
                                            </table>

                                        </div>
                                    </div><!-- /.col -->
                                </div><!-- /.row -->
                            </div><!-- /.box-body -->






                            <div class="box-header">
                                <h3 class="box-title">Behaviors:</h3>

                            </div><!-- /.box-header -->
                            <div class="box-body no-padding">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12">
                                        <div class="table-responsive">
                                            <table id="demo" class="table table-bordered table-striped table-hover" style="" align="Center">

                                                <tr style="background-color: darkgrey">
                                                    <th style="text-align: center"><b>Behaviors</b></th>
                                                    <th style="text-align: center">Mid'Year Score</th>
                                                    <th style="text-align: center" id="endYearHeader">

                                                        End'Year Score

                                                    </th>
                                                </tr>
                                                <input type="hidden" name="BehaviorsId" id="BehaviorsId" value="${fn:length(behaviorsList)}">
                                                <tr style="background-color: lightgrey">


                                                    <c:choose>
                                                        <c:when test="${not empty behaviorsList}">

                                                            <%--<c:forEach var="behaviorsPlan" items="${behaviorsList}" varStatus="status">--%>

                                                        <input type="hidden" id="w1" name="w1" value="WLB 1"/>

                                                        <td><b>WLB 1: Walk the Talk </b><br>&nbsp;&nbsp;- Do & Act What you Preach<br>&nbsp;&nbsp;- Keep commitments<br>&nbsp;&nbsp;- Talk Straight – Be Honest & Tell the Truth<br>&nbsp;&nbsp;- Use simple language and call things what they are<br>&nbsp;&nbsp;- Don’t manipulate people nor distort facts</td>
                                                        <td>
                                                            <c:if test="${behaviorsList[0].midYearScore eq '5.0'}">
                                                                <input type="Text" id="midYearScore1" name="midYearScore1" value="Far Exceeds Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[0].midYearScore eq '4.0'}">
                                                                <input type="Text" id="midYearScore1" name="midYearScore1" value="Exceeds Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[0].midYearScore eq '3.0'}">
                                                                <input type="Text" id="midYearScore1" name="midYearScore1" value="Meets Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[0].midYearScore eq '2.0'}">
                                                                <input type="Text" id="midYearScore1" name="midYearScore1" value="Partially Meets Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[0].midYearScore eq '1.0'}">
                                                                <input type="Text" id="midYearScore1" name="midYearScore1" value="Does Not Meet Expectations" class="form-control" readonly="true">
                                                            </c:if>

                                                        </td>
                                                        <!--<input type="Text" id="midYearScore1" name="midYearScore1" value="" class="form-control" readonly="true"></td>-->

                                                        <td id="endYearId1">
                                                            <c:if test="${behaviorsList[0].endYearScore eq '5.0'}">
                                                                <input type="Text" id="endYearScore1" name="endYearScore1" value="Far Exceeds Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[0].endYearScore eq '4.0'}">
                                                                <input type="Text" id="endYearScore1" name="endYearScore1" value="Exceeds Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[0].endYearScore eq '3.0'}">
                                                                <input type="Text" id="endYearScore1" name="endYearScore1" value="Meets Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[0].endYearScore eq '2.0'}">
                                                                <input type="Text" id="endYearScore1" name="endYearScore1" value="Partially Meets Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[0].endYearScore eq '1.0'}">
                                                                <input type="Text" id="endYearScore1" name="endYearScore1" value="Does Not Meet Expectations" class="form-control" readonly="true">
                                                            </c:if>

                                                        </td>
                                                        </tr>
                                                        <tr style="background-color: lightgrey">
                                                            <td><b>Manager’s Mid - Year Review / Evaluation</b></td>
                                                            <td colspan="2"><c:if test="${appraisalPerformanceMaster.getManagerStatus() ne 0}">${behaviorsList[0].managerMidYearReview}</c:if></td>
                                                            </tr>
                                                            <tr style="background-color: lightgrey" >
                                                                <td id="managerEndYearReviewId1"><b>Manager’s End - Year Review / Evaluation</b></td>
                                                                <td colspan="2"><c:if test="${appraisalPerformanceMaster.getManagerStatus() ne 0}">${behaviorsList[0].managerEndYearReview}</c:if></td>
                                                            </tr>
                                                            <tr style="background-color: lightgrey">
                                                            <input type="hidden" id="w2" name="w2" value="WLB 2"/>
                                                            <td><b>WLB 2: Deliver Results</b><br>&nbsp;&nbsp;- Master the art of execution & Establish a track record of results<br>&nbsp;&nbsp;- Practice Accountability – Hold self & others accountable<br>&nbsp;&nbsp;- Get the best out of you and your team<br>&nbsp;&nbsp;- Be on time and within budget<br>&nbsp;&nbsp;- Don’t find excuses for not delivering<br>&nbsp;&nbsp;- Celebrate success with the team</td>
                                                            <td>

                                                            <c:if test="${behaviorsList[0].midYearScore eq '5.0'}">
                                                                <input type="Text" id="midYearScore2" name="midYearScore2" value="Far Exceeds Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[0].midYearScore eq '4.0'}">
                                                                <input type="Text" id="midYearScore2" name="midYearScore2" value="Exceeds Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[0].midYearScore eq '3.0'}">
                                                                <input type="Text" id="midYearScore2" name="midYearScore2" value="Meets Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[0].midYearScore eq '2.0'}">
                                                                <input type="Text" id="midYearScore2" name="midYearScore2" value="Partially Meets Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[0].midYearScore eq '1.0'}">
                                                                <input type="Text" id="midYearScore2" name="midYearScore2" value="Does Not Meet Expectations" class="form-control" readonly="true">
                                                            </c:if>

                                                        </td>

                                                        <td id="endYearId2">
                                                            <!--<input type="Text" id="endYearScore2" name="endYearScore2" value="${behaviorsList[1].endYearScore}" class="form-control" readonly="true">-->
                                                            <c:if test="${behaviorsList[1].endYearScore eq '5.0'}">
                                                                <input type="Text" id="endYearScore2" name="endYearScore2" value="Far Exceeds Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[1].endYearScore eq '4.0'}">
                                                                <input type="Text" id="endYearScore2" name="endYearScore2" value="Exceeds Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[1].endYearScore eq '3.0'}">
                                                                <input type="Text" id="endYearScore2" name="endYearScore2" value="Meets Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[1].endYearScore eq '2.0'}">
                                                                <input type="Text" id="endYearScore2" name="endYearScore2" value="Partially Meets Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[1].endYearScore eq '1.0'}">
                                                                <input type="Text" id="endYearScore2" name="endYearScore2" value="Does Not Meet Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                        </td>

                                                        </tr>
                                                        <tr style="background-color: lightgrey">
                                                            <td><b>Manager’s Mid - Year Review / Evaluation</b></td>
                                                            <td colspan="2"><c:if test="${appraisalPerformanceMaster.getManagerStatus() ne 0}">${behaviorsList[1].managerMidYearReview}</c:if></td>
                                                            </tr>
                                                            <tr style="background-color: lightgrey" id="managerEndYearReviewId">
                                                                <td id="managerEndYearReviewId2"><b>Manager’s End - Year Review / Evaluation</b></td>
                                                                <td colspan="2"><c:if test="${appraisalPerformanceMaster.getManagerStatus() ne 0}">${behaviorsList[1].managerEndYearReview}</c:if></td>
                                                            </tr>
                                                            <tr style="background-color: lightgrey">
                                                            <input type="hidden" id="w3" name="w3" value="WLB 3"/>
                                                            <td><b>WLB 3: Build Relationships & Develop Others</b><br>&nbsp;&nbsp;- Be grounded at all times & approachable<br>&nbsp;&nbsp;- Treat people with utmost respect & care<br>&nbsp;- Understand other’s perspective & concern<br>&nbsp;&nbsp;- Invest in developing the talent<br>&nbsp;&nbsp;- Give your team the right opportunities to learn and grow<br>&nbsp;&nbsp;- Create a learning environment & help others to learn from success stories & failures<br>&nbsp;&nbsp; </td>
                                                            <td>
                                                                <!--<input type="Text" id="midYearScore3" name="midYearScore3" value="${behaviorsList[2].midYearScore}" class="form-control" readonly="true">-->
                                                            <c:if test="${behaviorsList[2].midYearScore eq '5.0'}">
                                                                <input type="Text" id="midYearScore3" name="midYearScore3" value="Far Exceeds Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[2].midYearScore eq '4.0'}">
                                                                <input type="Text" id="midYearScore3" name="midYearScore3" value="Exceeds Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[2].midYearScore eq '3.0'}">
                                                                <input type="Text" id="midYearScore3" name="midYearScore3" value="Meets Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[2].midYearScore eq '2.0'}">
                                                                <input type="Text" id="midYearScore3" name="midYearScore3" value="Partially Meets Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[2].midYearScore eq '1.0'}">
                                                                <input type="Text" id="midYearScore3" name="midYearScore3" value="Does Not Meet Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                        </td>

                                                        <td  id="endYearId3">
                                                            <!--<input type="Text" id="endYearScore3" name="endYearScore3" value="${behaviorsList[2].endYearScore}" class="form-control" readonly="true"></td>-->
                                                            <c:if test="${behaviorsList[2].endYearScore eq '5.0'}">
                                                                <input type="Text" id="endYearScore3" name="endYearScore3" value="Far Exceeds Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[2].endYearScore eq '4.0'}">
                                                                <input type="Text" id="endYearScore3" name="endYearScore3" value="Exceeds Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[2].endYearScore eq '3.0'}">
                                                                <input type="Text" id="endYearScore3" name="endYearScore3" value="Meets Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[2].endYearScore eq '2.0'}">
                                                                <input type="Text" id="endYearScore3" name="endYearScore3" value="Partially Meets Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[2].endYearScore eq '1.0'}">
                                                                <input type="Text" id="endYearScore3" name="endYearScore3" value="Does Not Meet Expectations" class="form-control" readonly="true">
                                                            </c:if>

                                                            </tr>
                                                        <tr style="background-color: lightgrey">
                                                            <td><b>Manager’s Mid - Year Review / Evaluation</b></td>
                                                            <td colspan="2"><c:if test="${appraisalPerformanceMaster.getManagerStatus() ne 0}">${behaviorsList[2].managerMidYearReview}</c:if></td>
                                                            </tr>
                                                            <tr style="background-color: lightgrey" id="managerEndYearReviewId">
                                                                <td id="managerEndYearReviewId3"><b>Manager’s End - Year Review / Evaluation</b></td>
                                                                <td colspan="2"><c:if test="${appraisalPerformanceMaster.getManagerStatus() ne 0}">${behaviorsList[2].managerEndYearReview}</c:if></td>
                                                            </tr>
                                                            <tr style="background-color: lightgrey">
                                                            <input type="hidden" id="w4" name="w4" value="WLB 4"/>
                                                            <td><b>WLB 4: Act with Courage</b><br>&nbsp;&nbsp;- Take a stand – have your individual opinion & stand by it<br>&nbsp;&nbsp;- Don’t shy away from conflicts<br>&nbsp;&nbsp;- Deal with the issues head on – never procrastinate<br>&nbsp;&nbsp;- Never bury your head in the sand<br>&nbsp;&nbsp;- Be direct & candid</td>
                                                            <td>
                                                                <!--<input type="Text" id="midYearScore4" name="midYearScore4" value="${behaviorsList[3].midYearScore}" class="form-control" readonly="true"></td>-->
                                                            <c:if test="${behaviorsList[3].midYearScore eq '5.0'}">
                                                                <input type="Text" id="midYearScore4" name="midYearScore4" value="Far Exceeds Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[3].midYearScore eq '4.0'}">
                                                                <input type="Text" id="midYearScore4" name="midYearScore4" value="Exceeds Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[3].midYearScore eq '3.0'}">
                                                                <input type="Text" id="midYearScore4" name="midYearScore4" value="Meets Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[3].midYearScore eq '2.0'}">
                                                                <input type="Text" id="midYearScore4" name="midYearScore4" value="Partially Meets Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[3].midYearScore eq '1.0'}">
                                                                <input type="Text" id="midYearScore4" name="midYearScore4" value="Does Not Meet Expectations" class="form-control" readonly="true">
                                                            </c:if>

                                                        <td id="endYearId4">
                                                            <!--<input type="Text" id="endYearScore4" name="endYearScore4" value="${behaviorsList[3].endYearScore}" class="form-control" readonly="true">-->
                                                            <c:if test="${behaviorsList[3].endYearScore eq '5.0'}">
                                                                <input type="Text" id="endYearScore4" name="endYearScore4" value="Far Exceeds Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[3].endYearScore eq '4.0'}">
                                                                <input type="Text" id="endYearScore4" name="endYearScore4" value="Exceeds Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[3].endYearScore eq '3.0'}">
                                                                <input type="Text" id="endYearScore4" name="endYearScore4" value="Meets Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[3].endYearScore eq '2.0'}">
                                                                <input type="Text" id="endYearScore4" name="endYearScore4" value="Partially Meets Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[3].endYearScore eq '1.0'}">
                                                                <input type="Text" id="endYearScore4" name="endYearScore4" value="Does Not Meet Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                        </td>

                                                        </tr>
                                                        <tr style="background-color: lightgrey">
                                                            <td><b>Manager’s Mid - Year Review / Evaluation</b></td>
                                                            <td colspan="2"><c:if test="${appraisalPerformanceMaster.getManagerStatus() ne 0}">${behaviorsList[3].managerMidYearReview}</c:if></td>
                                                            </tr>
                                                            <tr style="background-color: lightgrey" id="managerEndYearReviewId">
                                                                <td id="managerEndYearReviewId4"><b>Manager’s End - Year Review / Evaluation</b></td>
                                                                <td colspan="2"><c:if test="${appraisalPerformanceMaster.getManagerStatus() ne 0}">${behaviorsList[3].managerEndYearReview}</c:if></td>
                                                            </tr>
                                                            <tr style="background-color: lightgrey">
                                                            <input type="hidden" id="w5" name="w5" value="WLB 5"/>
                                                            <td><b>WLB 5: Believe in Vision & Purpose</b><br>&nbsp;&nbsp;- Be Far-sighted & Look beyond the obvious<br>&nbsp;&nbsp;- Be Strategic – Have a macro & micro perspective, Innovate<br>&nbsp;&nbsp;- Be Entrepreneurial <br>&nbsp;&nbsp;- Communicate your Vision to your team<br>&nbsp;&nbsp;- Make sure everyone on board under stand's the purpose<br>&nbsp;&nbsp;- Communicate ‘What’ , Why and When to align people to your Vision & Purpose </td>
                                                            <td>
                                                                <!--<input type="Text" id="midYearScore5" name="midYearScore5" value="${behaviorsList[4].midYearScore}" class="form-control" readonly="true">-->
                                                            <c:if test="${behaviorsList[4].midYearScore eq '5.0'}">
                                                                <input type="Text" id="midYearScore5" name="midYearScore5" value="Far Exceeds Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[4].midYearScore eq '4.0'}">
                                                                <input type="Text" id="midYearScore5" name="midYearScore5" value="Exceeds Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[4].midYearScore eq '3.0'}">
                                                                <input type="Text" id="midYearScore5" name="midYearScore5" value="Meets Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[4].midYearScore eq '2.0'}">
                                                                <input type="Text" id="midYearScore5" name="midYearScore5" value="Partially Meets Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[4].midYearScore eq '1.0'}">
                                                                <input type="Text" id="midYearScore5" name="midYearScore5" value="Does Not Meet Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                        </td>

                                                        <td id="endYearId5">
                                                            <!--<input type="Text" id="endYearScore5" name="endYearScore5" value="${behaviorsList[4].endYearScore}" class="form-control" readonly="true">-->
                                                            <c:if test="${behaviorsList[4].endYearScore eq '5.0'}">
                                                                <input type="Text" id="endYearScore5" name="endYearScore5" value="Far Exceeds Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[4].endYearScore eq '4.0'}">
                                                                <input type="Text" id="endYearScore5" name="endYearScore5" value="Exceeds Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[4].endYearScore eq '3.0'}">
                                                                <input type="Text" id="endYearScore5" name="endYearScore5" value="Meets Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[4].endYearScore eq '2.0'}">
                                                                <input type="Text" id="endYearScore5" name="endYearScore5" value="Partially Meets Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                            <c:if test="${behaviorsList[4].endYearScore eq '1.0'}">
                                                                <input type="Text" id="endYearScore5" name="endYearScore5" value="Does Not Meet Expectations" class="form-control" readonly="true">
                                                            </c:if>
                                                        </td>

                                                        </tr>
                                                        <tr style="background-color: lightgrey">
                                                            <td><b>Manager’s Mid - Year Review / Evaluation</b></td>
                                                            <td colspan="2"><c:if test="${appraisalPerformanceMaster.getManagerStatus() ne 0}">${behaviorsList[4].managerMidYearReview}</c:if></td>
                                                            </tr>
                                                            <tr style="background-color: lightgrey" id="managerEndYearReviewId">
                                                                <td id="managerEndYearReviewId5"><b>Manager’s End - Year Review / Evaluation</b></td>
                                                                <td colspan="2"><c:if test="${appraisalPerformanceMaster.getManagerStatus() ne 0}">${behaviorsList[4].managerEndYearReview}</c:if></td>
                                                            </tr>
                                                            <tr style="background-color: lightgrey">
                                                                <td><b style="font-size: 16px">TOTAL SCORE</b></td>
                                                                <td id="scoreMid"><input type="Text" class="form-control" value="<c:if test="${appraisalPerformanceMaster.getManagerStatus() ne 0}">${behaviorsMidyearTotalscore}</c:if>" readonly="true"></td>
                                                            <td id="scoreEnd"><input type="Text" class="form-control" value="<c:if test="${appraisalPerformanceMaster.getManagerStatus() ne 0}">${behaviorsEndyearTotalscore}</c:if>" readonly="true"></td>
                                                            </tr>
                                                            <tr style="background-color: lightgrey">
                                                                <td><b>Other Comment/Remark (Mid Year)</b></td>
                                                                <td colspan="2"><c:if test="${appraisalPerformanceMaster.getManagerStatus() ne 0}">${behaviorsMidyearOtherremark}</c:if></td>
                                                            </tr>
                                                            <tr style="background-color: lightgrey">
                                                                <td id="behaviorsEndyearOtherremarkId"><b>Other Comment/Remark (End Year)</b></td>
                                                                <td colspan="2"><c:if test="${appraisalPerformanceMaster.getManagerStatus() ne 0}">${behaviorsEndyearOtherremark}</c:if></td>
                                                            </tr>

                                                        <%--</c:forEach>--%>
                                                    </c:when>
                                                    <c:otherwise>

                                                        <tr style="background-color: lightgrey">
                                                            <td><b>WLB 1: Walk the Talk </b><br>&nbsp;&nbsp;- Do & Act What you Preach<br>&nbsp;&nbsp;- Keep commitments<br>&nbsp;&nbsp;- Talk Straight – Be Honest & Tell the Truth<br>&nbsp;&nbsp;- Use simple language and call things what they are<br>&nbsp;&nbsp;- Don’t manipulate people nor distort facts</td>
                                                            <td><select id="midYearScore1" class="form-control">
                                                                    <option value="">--SELECT--</option>
                                                                    <option value="5">Far Exceeds Expectations</option>
                                                                    <option value="4">Exceeds Expectations</option>
                                                                    <option value="3">Meets Expectations</option>
                                                                    <option value="2">Partially Meets Expectations</option>
                                                                    <option value="1">Does Not Meet Expectations</option>
                                                                </select></td>
                                                            <td><select id="endYearScore1" class="form-control">
                                                                    <option value="">--SELECT--</option>
                                                                    <option value="5">Far Exceeds Expectations</option>
                                                                    <option value="4">Exceeds Expectations</option>
                                                                    <option value="3">Meets Expectations</option>
                                                                    <option value="2">Partially Meets Expectations</option>
                                                                    <option value="1">Does Not Meet Expectations</option>
                                                                </select></td>
                                                        </tr>
                                                        <tr style="background-color: lightgrey">
                                                            <td><b>Manager’s Mid - Year Review / Evaluation</b></td>
                                                            <td colspan="2"></td>
                                                        </tr>
                                                        <tr style="background-color: lightgrey">
                                                            <td><b>Manager’s End - Year Review / Evaluation</b></td>
                                                            <td colspan="2"></td>
                                                        </tr>
                                                        <tr style="background-color: lightgrey">
                                                            <td><b>WLB 2: Deliver Results</b><br>&nbsp;&nbsp;- Master the art of execution & Establish a track record of results<br>&nbsp;&nbsp;- Practice Accountability – Hold self & others accountable<br>&nbsp;&nbsp;- Get the best out of you and your team<br>&nbsp;&nbsp;- Be on time and within budget<br>&nbsp;&nbsp;- Don’t find excuses for not delivering<br>&nbsp;&nbsp;- Celebrate success with the team</td>
                                                            <td><select id="midYearScore2" class="form-control">
                                                                    <option value="">--SELECT--</option>
                                                                    <option value="5">Far Exceeds Expectations</option>
                                                                    <option value="4">Exceeds Expectations</option>
                                                                    <option value="3">Meets Expectations</option>
                                                                    <option value="2">Partially Meets Expectations</option>
                                                                    <option value="1">Does Not Meet Expectations</option>
                                                                </select></td>
                                                            <td><select id="endYearScore2" class="form-control">
                                                                    <option value="">--SELECT--</option>
                                                                    <option value="5">Far Exceeds Expectations</option>
                                                                    <option value="4">Exceeds Expectations</option>
                                                                    <option value="3">Meets Expectations</option>
                                                                    <option value="2">Partially Meets Expectations</option>
                                                                    <option value="1">Does Not Meet Expectations</option>
                                                                </select></td>
                                                        </tr>
                                                        <tr style="background-color: lightgrey">
                                                            <td><b>Manager’s Mid - Year Review / Evaluation</b></td>
                                                            <td colspan="2"></td>
                                                        </tr>
                                                        <tr style="background-color: lightgrey">
                                                            <td><b>Manager’s End - Year Review / Evaluation</b></td>
                                                            <td colspan="2"></td>
                                                        </tr>
                                                        <tr style="background-color: lightgrey">
                                                            <td><b>WLB 3: Build Relationships & Develop Others</b><br>&nbsp;&nbsp;- Be grounded at all times & approachable<br>&nbsp;&nbsp;- Treat people with utmost respect & care<br>&nbsp;- Understand other’s perspective & concern<br>&nbsp;&nbsp;- Invest in developing the talent<br>&nbsp;&nbsp;- Give your team the right opportunities to learn and grow<br>&nbsp;&nbsp;- Create a learning environment & help others to learn from success stories & failures<br>&nbsp;&nbsp; </td>
                                                            <td><select id="midYearScore3" class="form-control">
                                                                    <option value="">--SELECT--</option>
                                                                    <option value="5">Far Exceeds Expectations</option>
                                                                    <option value="4">Exceeds Expectations</option>
                                                                    <option value="3">Meets Expectations</option>
                                                                    <option value="2">Partially Meets Expectations</option>
                                                                    <option value="1">Does Not Meet Expectations</option>
                                                                </select></td>
                                                            <td><select id="endYearScore3" class="form-control">
                                                                    <option value="">--SELECT--</option>
                                                                    <option value="5">Far Exceeds Expectations</option>
                                                                    <option value="4">Exceeds Expectations</option>
                                                                    <option value="3">Meets Expectations</option>
                                                                    <option value="2">Partially Meets Expectations</option>
                                                                    <option value="1">Does Not Meet Expectations</option>
                                                                </select></td>
                                                        </tr>
                                                        <tr style="background-color: lightgrey">
                                                            <td><b>Manager’s Mid - Year Review / Evaluation</b></td>
                                                            <td colspan="2"></td>
                                                        </tr>
                                                        <tr style="background-color: lightgrey">
                                                            <td><b>Manager’s End - Year Review / Evaluation</b></td>
                                                            <td colspan="2"></td>
                                                        </tr>
                                                        <tr style="background-color: lightgrey">
                                                            <td><b>WLB 4: Act with Courage</b><br>&nbsp;&nbsp;- Take a stand – have your individual opinion & stand by it<br>&nbsp;&nbsp;- Don’t shy away from conflicts<br>&nbsp;&nbsp;- Deal with the issues head on – never procrastinate<br>&nbsp;&nbsp;- Never bury your head in the sand<br>&nbsp;&nbsp;- Be direct & candid</td>
                                                            <td><select id="midYearScore4" class="form-control">
                                                                    <option value="">--SELECT--</option>
                                                                    <option value="5">Far Exceeds Expectations</option>
                                                                    <option value="4">Exceeds Expectations</option>
                                                                    <option value="3">Meets Expectations</option>
                                                                    <option value="2">Partially Meets Expectations</option>
                                                                    <option value="1">Does Not Meet Expectations</option>
                                                                </select></td>
                                                            <td><select id="endYearScore4" class="form-control">
                                                                    <option value="">--SELECT--</option>
                                                                    <option value="5">Far Exceeds Expectations</option>
                                                                    <option value="4">Exceeds Expectations</option>
                                                                    <option value="3">Meets Expectations</option>
                                                                    <option value="2">Partially Meets Expectations</option>
                                                                    <option value="1">Does Not Meet Expectations</option>
                                                                </select></td>
                                                        </tr>
                                                        <tr style="background-color: lightgrey">
                                                            <td><b>Manager’s Mid - Year Review / Evaluation</b></td>
                                                            <td colspan="2"></td>
                                                        </tr>
                                                        <tr style="background-color: lightgrey">
                                                            <td><b>Manager’s End - Year Review / Evaluation</b></td>
                                                            <td colspan="2"></td>
                                                        </tr>
                                                        <tr style="background-color: lightgrey">
                                                            <td><b>WLB 5: Believe in Vision & Purpose</b><br>&nbsp;&nbsp;- Be Far-sighted & Look beyond the obvious<br>&nbsp;&nbsp;- Be Strategic – Have a macro & micro perspective, Innovate<br>&nbsp;&nbsp;- Be Entrepreneurial <br>&nbsp;&nbsp;- Communicate your Vision to your team<br>&nbsp;&nbsp;- Make sure everyone on board under stand's the purpose<br>&nbsp;&nbsp;- Communicate ‘What’ , Why and When to align people to your Vision & Purpose </td>
                                                            <td><select id="midYearScore5" class="form-control">
                                                                    <option value="">--SELECT--</option>
                                                                    <option value="5">Far Exceeds Expectations</option>
                                                                    <option value="4">Exceeds Expectations</option>
                                                                    <option value="3">Meets Expectations</option>
                                                                    <option value="2">Partially Meets Expectations</option>
                                                                    <option value="1">Does Not Meet Expectations</option>
                                                                </select></td>
                                                            <td><select id="endYearScore5" class="form-control">
                                                                    <option value="">--SELECT--</option>
                                                                    <option value="5">Far Exceeds Expectations</option>
                                                                    <option value="4">Exceeds Expectations</option>
                                                                    <option value="3">Meets Expectations</option>
                                                                    <option value="2">Partially Meets Expectations</option>
                                                                    <option value="1">Does Not Meet Expectations</option>
                                                                </select></td>
                                                        </tr>
                                                        <tr style="background-color: lightgrey">
                                                            <td><b>Manager’s Mid - Year Review / Evaluation</b></td>
                                                            <td colspan="2"></td>
                                                        </tr>
                                                        <tr style="background-color: lightgrey">
                                                            <td><b>Manager’s End - Year Review / Evaluation</b></td>
                                                            <td colspan="2"></td>
                                                        </tr>
                                                        <tr style="background-color: lightgrey">
                                                            <td><b style="font-size: 16px">TOTAL SCORE</b></td>
                                                            <td><input type="Text" class="form-control" readonly="true"></td>
                                                            <td><input type="Text" class="form-control" readonly="true"></td>
                                                        </tr>
                                                        <tr style="background-color: lightgrey">
                                                            <td><b>Other Comment/Remark (Mid Year)</b></td>
                                                            <td colspan="2"></td>
                                                        </tr>
                                                        <tr style="background-color: lightgrey">
                                                            <td><b>Other Comment/Remark (End Year)</b></td>
                                                            <td colspan="2"></td>
                                                        </tr>
                                                    </c:otherwise>
                                                </c:choose>
                                            </table>
                                            <p><b>Note</b>: Please note that the score in Mid-Year Review/Evaluation of Behavior is just an indicator of an individual’s behavior during the first half of the year and the same is not considered in any rating calculation.
                                                It is the score in End-Year Review/Evaluation which is considered in the final rating of an employee.</p>
                                        </div>



                                    </div><!-- /.col -->
                                </div>
                            </div>

                            <div class="box-header">
                                <h3 class="box-title">Performance Ratings:</h3>

                            </div><!-- /.box-header -->
                            <div class="box-body no-padding">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12">
                                        <!--                                        <div class="form-group">
                                                                                    <label class="col-sm-5 control-label"><b>Final Score</b></label>
                                                                                    <div class="col-sm-2">
                                        
                                                                                        <input type="number" id="behaviorsFinalscore" name="behaviorsFinalscore" value="${behaviorsFinalscore}" onload="printfinalScoreRatings();"class="form-control" readonly="true">
                                        
                                                                                    </div>
                                                                                </div>-->
                                        <div class="row">
                                            <div class="col-sm-4">
                                                <div class="form-group text-center">
                                                    <label class="control-label"><b>KRA Score</b></label>&nbsp;&nbsp;
                                                    <input type="number" id="totalScore" name="totalScore" value="${totalScore}" disabled="disabled" style="border-radius: 4px; border: 1px solid #ccc; padding: 6px 12px;" readonly="true">
                                                </div>
                                            </div>
                                            <div class="col-sm-4 form-group text-center">
                                                <div class="form-group">
                                                    <label class="control-label"><b>WLB Score</b></label>&nbsp;&nbsp;
                                                    <input type="number" id="behaviorsEndyearTotalscore" name="behaviorsEndyearTotalscore" value="${behaviorsEndyearTotalscore}" disabled="disabled" style="border-radius: 4px; border: 1px solid #ccc; padding: 6px 12px;" readonly="true">
                                                </div>
                                            </div>
                                            <div class="col-sm-4 form-group text-center">
                                                <div class="form-group">
                                                    <label class="control-label"><b>Final Score</b></label>&nbsp;&nbsp;
                                                    <input type="Text" id="behaviorsFinalscore" name="behaviorsFinalscore" value="${behaviorsFinalscore}" onload="printfinalScoreRatings();" disabled="disabled" style="border-radius: 4px; border: 1px solid #ccc; padding: 6px 12px;" readonly="true">
                                                    <!--<input type="number" id="behaviorsFinalscore" name="behaviorsFinalscore" value="${behaviorsFinalscore}" disabled="disabled" style="border-radius: 4px; border: 1px solid #ccc; padding: 6px 12px;" readonly="true">-->
                                                </div>
                                            </div>
                                        </div>
                                        <div class="table-responsive">
                                            <table id="demo234" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                <tr >
                                                    <th style="text-align: center">Performance Ratings</th>
                                                    <th style="text-align: center">Score</th>
                                                    <th style="text-align: center">Score Achieved</th>
                                                </tr>
                                                <tr class="d1" id="tbl111" >
                                                    <td style="vertical-align: middle"><b>Far Exceeds Expectations</b></td>
                                                    <td style="text-align: center"><h4 style="background-color: #337AB7;"><b>106 to 110</b></h4></td>
                                                    <td style="text-align: center"><c:if test="${behaviorsFinalscore ge '116' && behaviorsFinalscore le '110' || behaviorsFinalscore eq '116' || behaviorsFinalscore eq '116'}"><i class="fa fa-check"></i></c:if></td>
                                                    </tr>
                                                    <tr class="" id="tbl112" >
                                                        <td style="vertical-align: middle"><b>Exceeds Expectations</b></td>
                                                        <td style="text-align: center"><h4><b>101 to 105</b></h4></td>
                                                        <td style="text-align: center"><c:if test="${behaviorsFinalscore ge '101' && behaviorsFinalscore le '105' || behaviorsFinalscore eq '101' || behaviorsFinalscore eq '105'}"><i class="fa fa-check"></i></c:if></td>

                                                    </tr>
                                                    <tr class="" id="tbl113" >
                                                        <td style="vertical-align: middle"><b>Meets Expectations</b></td>
                                                        <td style="text-align: center"><h4><b>80 to 100</b></h4></td>
                                                        <td style="text-align: center"><c:if test="${behaviorsFinalscore ge '80'  && behaviorsFinalscore le '100' || behaviorsFinalscore eq '80' || behaviorsFinalscore eq '100'}"><i class="fa fa-check"></i></c:if></td>

                                                    </tr>
                                                    <tr class="" id="tbl114" >
                                                        <td style="vertical-align: middle"><b>Partially Meets Expectations</td>
                                                        <td style="text-align: center"><h4><b>51 to 79</b></h4></td>
                                                        <td style="text-align: center"><c:if test="${behaviorsFinalscore ge '51'  && behaviorsFinalscore le '79' || behaviorsFinalscore eq '51' || behaviorsFinalscore eq '79'}"><i class="fa fa-check"></i></c:if></td>

                                                    </tr>
                                                    <tr class="" id="tbl115">
                                                        <td style="vertical-align: middle"><b>Does Not Meet Expectations</b></td>
                                                        <td style="text-align: center"><h4><b>50 & Below</b></h4></td>
                                                        <td style="text-align: center"><c:if test="${behaviorsFinalscore ge '1' && behaviorsFinalscore le '50' || behaviorsFinalscore eq '1' || behaviorsFinalscore eq '50'}"> <i class="fa fa-check"></i></c:if></td>

                                                    </tr>


                                                </table>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label"><b>Activity/Project Performance</b></label>
                                                <div class="col-sm-2">
                                                    <input type="Text" id="managerActivityScore" name="managerActivityScore" value="${managerActivityScore}" class="form-control" readonly>
                                            </div>
                                        </div>

                                    </div>

                                </div>


                            </div>
                        </div>

                    </div>

                </div>

            </div>
        </section>
    </form:form>
</body>


<script>
    $(document).ready(function () {
        window.onload = printfinalScoreRatings();
    });
</script>
<script>
    //        function printfinalScoreRatings() {
    //    var totalScore = parseInt(document.getElementById("totalScore").value);
    //    var behaviorsEndyearTotalscore = parseInt(document.getElementById("behaviorsEndyearTotalscore").value);
    //    alert("DODODOD" + behaviorsEndyearTotalscore);
    //    var behaviorsFinalscore12 = totalScore + behaviorsEndyearTotalscore;
    //            alert("DFFFFFFFFFFFFFFFFFFFSS");
    //            var behaviorsFinalscore12 = document.getElementById("behaviorsFinalscore").value;
    //                        alert("POPOPOPO" + behaviorsFinalscore12);
    //            $('#score1').hide();
    //            $('#score2').hide();
    //            $('#score3').hide();
    //            $('#score4').hide();
    //            $('#score5').hide();
    //
    //            if ((behaviorsFinalscore12 >= 106) && (behaviorsFinalscore12 <= 110))
    //            {
    //                //        alert("score1" + behaviorsFinalscore12);
    //                $('#score1').show();
    //
    //            }
    //            if ((behaviorsFinalscore12 >= 101) && (behaviorsFinalscore12 <= 105))
    //            {
    //                $('#score2').show();
    //            }
    //            else if ((behaviorsFinalscore12 >= 80) && (behaviorsFinalscore12 <= 100))
    //            {
    //                //        alert("score1" + behaviorsFinalscore12);
    //                $('#score3').show();
    //            }
    //            else if ((behaviorsFinalscore12 >= 51) && (behaviorsFinalscore12 <= 79))
    //            {
    //                $('#score4').show();
    //            }
    //            else if ((behaviorsFinalscore12 >= 0) && (behaviorsFinalscore12 <= 50)) {
    //                $('#score5').show();
    //            }
    //
    //        }

</script>

</html>
