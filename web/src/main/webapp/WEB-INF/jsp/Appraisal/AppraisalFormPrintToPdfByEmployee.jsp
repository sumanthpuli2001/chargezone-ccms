<%-- 
    Document   : AppraisalFormPrintToPdfByEmployee
    Created on : 29 Apr, 2016, 10:35:15 AM
    Author     : HRINTRA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%--<%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>--%>
    <%@include file="/WEB-INF/jsp/Common/EmployeeComman.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Performance Appraisal Form</title>
        <style>
            td { word-break: break-all;}
            select {
                /*for firefox*/
                -moz-appearance: none;
                /*for chrome*/
                -webkit-appearance:none;
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
        function buttonFun7() {
            var className = $('#minusId7').attr('class');
            if (className == 'fa fa-plus') {
                document.getElementById('spanId7').innerHTML = 'Minimize';
            } else {
                document.getElementById('spanId7').innerHTML = 'Expand';
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

    </script>
    <script>
        function appraisalSelectedPrint() {
            var empId = document.getElementById("empId").value;
            var userid = document.getElementById("userid").value;
            var appraisalId = document.getElementById("appraisalId").value;
            var path = 'appraisalPerformance.htm?act=appraisalPerformancePrint&id=' + empId + '&userid=' + userid + '&appraisalId=' + appraisalId;

//             window.print(path, 'popUpWindow', 'height=700,width=900,left=10,top=10,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no,status=yes')
            popupWindow = window.open(path, 'popUpWindow', 'height=700,width=900,left=10,top=10,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no,status=yes,type=text/css')

        }
        function removeChild4(removeRowId_1, removeRowId_2, removeRowId_3, removeRowId_4, removeRowId_5) {
//        var val = document.getElementById("countId").value;
//        document.getElementById("countId").value = (--val);
            var element1 = document.getElementById(removeRowId_1);
            var element2 = document.getElementById(removeRowId_2);
            var element3 = document.getElementById(removeRowId_3);
            var element4 = document.getElementById(removeRowId_4);
            var element5 = document.getElementById(removeRowId_5);
            element1.parentNode.removeChild(element1);
            element2.parentNode.removeChild(element2);
            element3.parentNode.removeChild(element3);
            element4.parentNode.removeChild(element4);
            element5.parentNode.removeChild(element5);

        }
    </script>
    <style>
        .btn-warnings {
            color: #fff;
            background-color: #f0ad4e;
            border-color: #eea236;
        }
        .btns {
            display: inline-block;
            padding: 1px 7px;
            /*padding: 6px 12px;*/
            margin-bottom: 0;
            font-size: 14px;
            font-weight: 400;
            line-height: 1.42857143;
            text-align: center;
            white-space: nowrap;
            vertical-align: middle;
            -ms-touch-action: manipulation;
            touch-action: manipulation;
            cursor: pointer;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
            background-image: none;
            border: 1px solid transparent;
            border-radius: 4px;
        }

        .modal-body {
            padding:9px 15px !important;
            /*border-bottom:1px solid red !important;*/
            border-bottom:1px solid #eee !important;
            box-sizing: border-box !important;
            border: 10px solid red !important;
            padding: 35px !important;
            background-repeat: no-repeat !important;
            background-origin: border-box !important;

        }
        .modal-footer{
            display: none !important;
        }
        textarea:focus {
            height: 20em;
            width: 35em;
        }
        textarea {
            resize: none;
        }
    </style>

    <body id="bodyId">
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>Performance Appraisal Form :</h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Performance Appraisal</li>
                </ol>
                <div class="col-md-12" style="text-align: center;">
                    <!--<input type="button" value="Print" id="printBtn" name="printBtn" style="margin-left: 959px; width: 100px;" class="btn btn-primary" onclick="appraisalSelectedPrint()">-->
                    <!--<a href="appraisalPerformance.htm?act=appraisalPerformancePrint&id=${empId}&userid=${userid}&appraisalId=${appraisalId}" target="_blank"  class="btn btn-primary">Print</a>-->

                    <input type="hidden" id="empId" name="empId" value="${empId}">
                    <input type="hidden" id="userid" name="userid" value="${userid}">
                    <input type="hidden" id="appraisalId" name="appraisalId" value="${appraisalId}">
                    <input type="hidden" id="managerStatus" name="managerStatus" value="${managerStatus}">
                    <input type="hidden" id="year" name="year" value="${year}">
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
                                <!--<span style="color: red;font-size: 14px;">* indicates mandatory field.</span>-->
                                <!--<span style="color: red;font-size: 14px;">All the editable fields are mandatory.</span>-->
                                <%--<form:form class="form-horizontal" id="form1" role="form1" action="appraisalPerformance.htm?act=createSubmit" commandName="appraisalPerformanceMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>--%>
                                <!--form horizontal starts here-->
                                <!--<form class="form-horizontal" role="form" commandName="AppraisalPerformanceMaster">-->
                                <div class="box box-info  ">
                                    <div class="box-header">
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
                                    </div><!-- /.box-body -->
                                </div>

                                <div class="box box-info ">
                                    <div class="box-header">
                                        <h3 class="box-title">Results:</h3>

                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">

                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="table-responsive">
                                                    <table id="demo" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                        <tr>
                                                        <input type="hidden" name="tflagId" id="tflagId" value="${Tflag}">
                                                        <input type="hidden" name="flagId" id="flagId" value="${flag}">
                                                        <input type="hidden" name="flagMidId" id="flagMidId" value="${flag1}">
                                                        <input type="hidden" name="flagEndId" id="flagEndId" value="${flag2}">
                                                        <input type="hidden" name="status1" id="status1" value="${status}">
                                                        <input type="hidden" name="kraremovedIdVal" id="kraremovedIdVal" value="">
                                                        <input type="hidden" id="managerStatus" name="managerStatus" value="${managerStatus}">
                                                        <input type="hidden" id="employeeStatus" name="employeeStatus" value="${employeeStatus}">
                                                        <input type="hidden" name="weightage" id="weightage" value="${weightage}">

                                                        <th style="text-align: center">Sr. No.</th>


                                                        <th style="text-align: center" id="kraGoalid1">High Impact Goal / KRA</th>
                                                        <th style="text-align: center" id="metricid1">Metric</th>
                                                        <th style="text-align: center" id="metricid1">KRA Category</th>

                                                        <th style="margin: 0px;width: 25px;text-align: center;" id="weightageid12">Weightage Out Of 75</th>
                                                        <!--<th style="display: none;" id='weightageOut'></th>-->


                                                        <th style="margin: 0px;width: 70px;text-align: center" id="midYearDivid">Mid Year Status</th>
                                                        <th style="margin: 0px;width: 70px;text-align: center" id="endYearDivid1">End Year Status</th>
                                                        <th style="margin: 0px;width: 25px;text-align: center" id="finalScoreid01">Final Score</th>
                                                        </tr>
                                                        <input type="hidden" name="kragoalLength" id="kragoalLength" value="${fn:length(kragoal)}">
                                                        <c:choose>
                                                            <c:when test="${fn:length(kragoal) > 0}">
                                                                <input type="hidden" name="countId" id="countId" value="${fn:length(kragoal)}">
                                                                <c:set var="resultCount" value="${fn:length(kragoal)}"></c:set>
                                                                <c:forEach var="kragoallist" items="${kragoal}" varStatus="status">
                                                                    <tr id="removeTr${status.count}">
                                                                    <input type="hidden" name="kragoal_id${status.count}" id="kragoal_id${status.count}" value="${kragoallist.id}">
                                                                    <td id="removeKRAID${status.count}" class="removeClass" style="margin: 0px;width: 45px;"><span>${status.count} </span></td>


                                                                    <td id="kraGoalid1${status.count}">${kragoallist.kraGoal}</td>
                                                                    <td id="metricid1${status.count}">${kragoallist.metric}</td>
                                                                    <td id="kraCategoryId${status.count}">
                                                                        <%--<c:forEach var="kraCategory" items="${kraCategoryMap}">--%>
                                                                        <%--<c:if test="${kragoallist.kraCategoryByKraCategoryByEmployee.id eq kraCategory.key}">--%>
                                                                            <!--<option value="${kraCategory.key}" selected="">${kraCategory.value}</option>-->
                                                                        <%--</c:if>--%>
                                                                        <%--<c:if test="${kragoallist.kraCategoryByKraCategoryByEmployee.id ne kraCategory.key}">--%>
                                                                            <!--<option value="${kraCategory.key}">${kraCategory.value}</option>-->
                                                                        <%--</c:if>--%>
                                                                        <%--</c:forEach>--%>


                                                                        <c:forEach var="kraCategory" items="${kraCategoryMap}">
                                                                            <c:if test="${kragoallist.kraCategoryByKraCategoryByEmployee.id eq kraCategory.key}">
                                                                            <option value="${kraCategory.key}" selected="">${kraCategory.value}</option>
                                                                        </c:if>
                                                                    </c:forEach>

                                                                    </td>
                                                                    <!--By Ajay  End-->
                                                                    <td id="weightageidT1${status.count}">
                                                                        <c:choose>
                                                                            <c:when test="${appraisalPerformanceMaster.getEmployeeStatus() eq 0}">
                                                                                ${kragoallist.weightage}
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                ${kragoallist.weightage}
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </td>
                                                                    <td id="midYearDivid1${status.count}">
                                                                        ${kragoallist.midyearStatus}
                                                                    </td>
                                                                    <td id="endYearDivid1${status.count}">
                                                                        ${kragoallist.endyearStatus}
                                                                    </td>
                                                                    <td id="finalScoreid${status.count}">
                                                                        ${kragoallist.finalScore}
                                                                    </td>
                                                                    </tr>
                                                                    <tr id="employeesMid${status.count}">
                                                                        <td colspan="4"><b>Employee’s Mid - Year Self – Assessment KRA:</b></td>
                                                                        <td colspan="4"><b>Manager’s Mid - Year Review / Evaluation KRA:</b></td>
                                                                    </tr>
                                                                    <tr id="textemployeesMid${status.count}">
                                                                        <td colspan="4">${kragoallist.empMidyearSelfassessmentGoal}</td>
                                                                        <td colspan="4">${kragoallist.managerMidyearReviewEvaluation}</td>
                                                                    </tr>

                                                                    <tr id="employeesEnd${status.count}">
                                                                        <td colspan="4"><b>Employee’s End - Year Self – Assessment KRA:</b></td>
                                                                        <td colspan="4"><b>Manager’s End - Year Review / Evaluation KRA:</b></td>
                                                                    </tr>
                                                                    <tr id="textemployeesEnd${status.count}">
                                                                        <td colspan="4">${kragoallist.empEndyearSelfassessmentGoal}</td>
                                                                        <td colspan="4">${kragoallist.managerEndyearReviewEvaluation}</td>
                                                                    </tr>
                                                                    <%--</c:if>--%>
                                                                </c:forEach>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <input type="hidden" name="countId" id="countId" value="1">
                                                                <tr id="row_1_1">
                                                                    <td style="margin: 0px;width: 45px;">1</td>
                                                                    <td id="kraGoalid"></td>
                                                                    <td id="metricid"></td>
                                                                    <td id="kraCategoryId"></td>
                                                                    <td id="weightageid"></td>
                                                                    <td id="midYearDivid1"></td>
                                                                    <td id="endYearDivid"></td>
                                                                    <td id="finalScoreid"></td>
                                                                <input type="hidden" id="startDate1" name="startDate1" value="${kragoal[0].startDate}">
                                                                <tr id="employeesMid">
                                                                    <td colspan="4"><b>Employee’s Mid - Year Self – Assessment KRA:</b></td>
                                                                    <td colspan="4"><b>Manager’s Mid - Year Review / Evaluation KRA:</b></td>
                                                                </tr>
                                                                <tr id="textemployeesMid">
                                                                    <td colspan="4"></td>
                                                                    <td colspan="4"></td>
                                                                </tr>

                                                                <tr id="employeesEnd">
                                                                    <td colspan="4"><b>Employee’s End - Year Self – Assessment KRA:</b></td>
                                                                    <td colspan="4"><b>Manager’s End - Year Review / Evaluation KRA:</b></td>
                                                                </tr>
                                                                <tr id="textemployeesEnd">
                                                                    <td colspan="4"></td>
                                                                    <td colspan="4"></td>
                                                                </tr>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </table>
                                                </div>
                                                <div class="table-responsive">
                                                    <table id="demo1" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                        <tr id="weightage">
                                                            <td style="margin: 0px;width: 100px;"></td>
                                                            <td style="margin: 0px;width: 100px;"></td>
                                                            <td style="margin: 0px;width: 285px;" id="weightageScoreId" align="right"><b>Weightage</b></td>
                                                            <td style="margin: 0px;width: 100px;" id="dhaval">
                                                                <input type="text" id="weightageScore" name="weightageScore" class="form-control"  value="${weightageScore}" style="margin: 0px;width: 100px;" readonly="true">
                                                            </td>
                                                            <td style="margin: 0px;width: 170px;">
                                                            </td>
                                                            <td style="margin: 0px;width: 90px;" id="totalScoreId" align="right"><b>Total Score</b>
                                                            </td>
                                                            <td><input id="totalScore" name="totalScore" value="${totalScore}" class="form-control" value="${totalScore}" style="margin: 0px;width: 100px;" readonly="true"></input></td>
                                                            <td></td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->

                                </div>
                                <c:if test="${year==2016}">
                                    <div class="box box-info ">
                                        <div class="box-header">
                                            <h3 class="box-title">Additional Activities / Projects:</h3>

                                        </div><!-- /.box-header -->
                                    </div>
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="table-responsive">
                                                    <table id="demo10" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                        <tr>

                                                        <input type="hidden" name="status1" id="status1" value="${status}">
                                                        <input type="hidden" name="kraremovedActivitiesIdVal" id="kraremovedActivitiesIdVal" value="">

                                                        <input type="hidden" id="managerStatus" name="managerStatus" value="${managerStatus}">
                                                        <input type="hidden" id="employeeStatus" name="employeeStatus" value="${employeeStatus}">
                                                        <input type="hidden" name="weightage" id="weightage" value="${weightage}">

                                                        <th style="text-align: center">Sr. No.</th>


                                                        <th style="text-align: center" id="kraGoalid1">Additional Activities / Projects</th>
                                                        <th style="text-align: center" id="metricid1">Metric</th>
                                                        <th style="text-align: center" id="metricid1">Project Category</th>

                                                        <th style="margin: 0px;width: 25px;text-align: center;" id="">Priority</th>

                                                        <th style="margin: 0px;width: 70px;text-align: center" id="midYearDivid">Mid Year Status</th>
                                                        <th style="margin: 0px;width: 70px;text-align: center" id="endYearDivid1">End Year Status</th>
                                                        <th style="margin: 0px;width: 25px;text-align: center" id="finalScoreid01">Activity/Project Performance</th>
                                                        </tr>
                                                        <input type="hidden" name="kragoalLengthactivity" id="kragoalLengthactivity" value="${fn:length(kragoalOtherActivity)}">

                                                        <c:choose>
                                                            <c:when test="${fn:length(kragoalOtherActivity) > 0}">
                                                                <input type="hidden" name="countactivityId" id="countactivityId" value="${fn:length(kragoalOtherActivity)}">
                                                                <c:set var="kragoalOtherActivityValManager" value="${fn:length(kragoalOtherActivity)}"></c:set>
                                                                <c:forEach var="kragoalOtherActivity" items="${kragoalOtherActivity}" varStatus="status">
                                                                    <c:if test="${kragoalOtherActivity.kraGoalActivities ne '' && kragoalOtherActivity.metricActivities ne ''}">
                                                                        <tr id="activitiesTrId${status.count}">
                                                                        <input type="hidden" name="kragoal_activity_id${status.count}" id="kragoal_activity_id${status.count}" value="${kragoalOtherActivity.id}">
                                                                        <td id="removeKRAactivitiesID${status.count}" class="removeactivitiesClass" style="margin: 0px;width: 45px;">${status.count} </td>
                                                                        <td id="">${kragoalOtherActivity.kraGoalActivities}</td>
                                                                        <td id="">${kragoalOtherActivity.metricActivities}</td>
                                                                        <td id="kraCategoryId${status.count}">
                                                                            <c:forEach var="kraCategory" items="${kraCategoryMap}">
                                                                                <c:if test="${kragoalOtherActivity.kraCategoryByEmployeeActivities eq kraCategory.key}">
                                                                                <option value="${kraCategory.key}" selected="">${kraCategory.value}</option>
                                                                            </c:if>
                                                                        </c:forEach>                                                                      
                                                                        <td id="priorityid${status.count}">
                                                                            ${kragoalOtherActivity.priority}
                                                                        </td>
                                                                        <td id="midYearDivid1${status.count}">
                                                                            ${kragoalOtherActivity.midyearStatusActivities}
                                                                        </td>
                                                                        <td id="endYearDivid1${status.count}">
                                                                            ${kragoalOtherActivity.endyearStatusActivities}
                                                                        </td>
                                                                        <td id="activityDivid1${status.count}">
                                                                            ${kragoalOtherActivity.activity}
                                                                        </td>
                                                                        </tr>
                                                                        <tr id="activitiesEmpMidLabel1TrId${status.count}">
                                                                            <td colspan="4"><b>Employee’s Mid - Year Self – Assessment For Other Projects:</b></td>
                                                                            <td colspan="4"><b>Manager’s Mid - Year Review / Evaluation For Other Projects:</b></td>
                                                                        </tr>
                                                                        <tr id="activitiesEmpMid1TrId${status.count}">
                                                                            <td colspan="4">${kragoalOtherActivity.empMidyearSelfassessmentGoalActivities}</td>
                                                                            <td colspan="4">${kragoalOtherActivity.managerMidyearSelfassesssmentGoalActivities}</td>
                                                                        </tr>

                                                                        <tr id="activitiesEmpMidLabel2TrId${status.count}">
                                                                            <td colspan="4"><b>Employee’s End - Year Self – Assessment For Other Projects:</b></td>
                                                                            <td colspan="4"><b>Manager’s End - Year Review / Evaluation For Other Projects:</b></td>
                                                                        </tr>
                                                                        <tr id="activitiesEmpMid2TrId${status.count}">
                                                                            <td colspan="4">${kragoalOtherActivity.empEndyearSelfassessmentGoalActivities}</td>
                                                                            <td colspan="4">${kragoalOtherActivity.managerEndyearSelfassesssmentGoalActivities}</td>
                                                                        </tr>
                                                                    </c:if>

                                                                </c:forEach>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <tr>
                                                                    <td style="margin: 0px;width: 45px;">1</td>
                                                                <input type="hidden" name="countactivityId" id="countactivityId" value="1">
                                                                <td id=""></td>
                                                                <td id=""></td>
                                                                <td id="kraCategoryId">
                                                                </td>
                                                                <td id="priorityid">
                                                                </td>
                                                                <td id="midYearDividact1">
                                                                </td>
                                                                <td id="endYearDividact">
                                                                </td>
                                                                <td id="">
                                                                </td>
                                                                <input type="hidden" id="startDate1" name="startDate1" value="${kragoal[0].startDate}">
                                                                <tr id="employeesMid">
                                                                    <td colspan="4"><b>Employee’s Mid - Year Self – Assessment Project:</b></td>
                                                                    <td colspan="4"><b>Manager’s Mid - Year Review / Evaluation Project:</b></td>
                                                                </tr>
                                                                <tr id="textemployeesMid">
                                                                    <td colspan="4"></td>
                                                                    <td colspan="4"></td>
                                                                </tr>

                                                                <tr id="employeesEnd">
                                                                    <td colspan="4"><b>Employee’s End - Year Self – Assessment Project:</b></td>
                                                                    <td colspan="4"><b>Manager’s End - Year Review / Evaluation Project:</b></td>
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
                                <div class="box box-info ">
                                    <div class="box-header">
                                        <h3 class="box-title">Competency Evaluation (As Per Zydex Competency Framework) :</h3>

                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <c:if test="${empty competencyEvaluationList[0][2].title || appraisalPerformanceMaster.managerStatus ne 1}">
                                                    <c:forEach var="competencyMap" items="${competencyMap}">
                                                        <c:if test="${competencyEvaluationList[0][2].title  eq competencyMap.value}">
                                                            ${competencyMap.value}
                                                        </c:if>
                                                        <c:if test="${competencyEvaluationList[0][2].title  ne competencyMap.value}">
                                                            ${competencyMap.value}
                                                        </c:if>
                                                    </c:forEach>
                                                </c:if>
                                                <c:if test="${appraisalPerformanceMaster.managerStatus eq 1 && !empty competencyEvaluationList[0][2].title}">
                                                    ${competencyEvaluationList[0][2].title}
                                                </c:if>
                                            </div>
                                            <div class="col-md-12 col-sm-12">
                                                <div class="table-responsive">
                                                    <table id="demo9" class="table table-bordered table-striped table-hover" style="" align="Center"  >
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
                                                        <c:forEach var="competencyEvaluationList" items="${competencyEvaluationList}" varStatus="status">

                                                            <input type="hidden" name="competencyEveId${status.count}" id="competencyEveId${status.count}" value="${competencyEvaluationList[0]}">
                                                            <input type="hidden" name="competencyEvaluationId${status.count}" id="competencyEvaluationId${status.count}" value="${competencyEvaluationList[2].id}">
                                                            <input type="hidden" name="compentencyTextMasterId${status.count}" id="compentencyTextMasterId${status.count}" value="${competencyEvaluationList[3].id}">
                                                            <tr class="">
                                                                <td id="subCompentencySrId${status.count}">${status.count}</td>
                                                                <td id="subCompentencyTitleId${status.count}" >${competencyEvaluationList[4]}</td>
                                                                <td id="subCompentencyStartId${status.count}" >
                                                                    ${competencyEvaluationList[5]}
                                                                </td>
                                                                <td id="subCompentencyStartRemarkId${status.count}" >
                                                                    ${competencyEvaluationList[6]}
                                                                </td>
                                                                <td id="subCompentencyMidId${status.count}">
                                                                    ${competencyEvaluationList[7]}
                                                                </td>
                                                                <td id="subCompentencyMidRemarkId${status.count}">
                                                                    ${competencyEvaluationList[8]}
                                                                </td>
                                                                <td id="subCompentencyEndId${status.count}">
                                                                    ${competencyEvaluationList[9]}
                                                                </td>
                                                                <td id="subCompentencyEndRemarkId${status.count}">
                                                                    ${competencyEvaluationList[10]}
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div><!-- /.box-body -->
                                </div>
                                <div class="box box-info ">
                                    <div class="box-header">
                                        <h3 class="box-title">Individual Development Plan(Training Need Identification):</h3>

                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">

                                                <div class="table-responsive">
                                                    <table id="demo5" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <tr>
                                                        <input type="hidden" name="kraremovedIndividualIdVal" id="kraremovedIndividualIdVal" value="">
                                                        <th style="text-align: center">Sr.No.</th>
                                                        <th style="text-align: center">IDP Name & Details</th>
                                                        <th style="text-align: center">IDP Type</th>
                                                        <th style="text-align: center">How to achieve this IDP</th>
                                                        <th style="text-align: center"></th>
                                                        <th style="text-align: center">Add New</th>
                                                        </tr>
                                                        <tr>

                                                            <c:choose>
                                                                <c:when test="${not empty individualDevelopmentPlanList}">
                                                                <input type="hidden" name="IndividualId" id="IndividualId" value="${fn:length(individualDevelopmentPlanList)}">

                                                                <c:forEach var="individualDevelopmentPlan" items="${individualDevelopmentPlanList}" varStatus="status">
                                                                    <c:if test="${individualDevelopmentPlan.text1 ne '' && individualDevelopmentPlan.text2 ne '' && individualDevelopmentPlan.text3 ne ''}">
                                                                        <tr id="individualTrId${status.count}">
                                                                            <td id="removeKRAIndividualID${status.count}" name="removeKRAIndividualID${status.count}" style="text-align: center">${status.count}</td>
                                                                        <input type="hidden" name="IndividualDevelopmentPlanId${status.count}" id="IndividualDevelopmentPlanId${status.count}" value="${individualDevelopmentPlan.id}">
                                                                        <td id="indDevId">${individualDevelopmentPlan.text1}</td>
                                                                        <td>
                                                                            ${individualDevelopmentPlan.text2}
                                                                        </td>
                                                                        <td>
                                                                            ${individualDevelopmentPlan.text3}
                                                                        </td>
                                                                        <td>
                                                                            ${individualDevelopmentPlan.remark}
                                                                        </td>
                                                                        </tr>
                                                                        <tr id="individualEmpMidLabel1TrId${status.count}">
                                                                            <td colspan="3" id="midYearReId${status.count}"><b>Employee Mid-Year Remark</b></td>
                                                                            <td colspan="3" id="endYearReId${status.count}"><b>Employee End-Year Remark</b></td>
                                                                        </tr>
                                                                        <tr id="individualEmpMid1TrId${status.count}">
                                                                            <td colspan="3" id="midYearRetxtId${status.count}">${individualDevelopmentPlan.midYearRemark}</td>
                                                                            <td colspan="3" id="endYearRetxtId${status.count}">${individualDevelopmentPlan.endYearRemark}</td>
                                                                        </tr>
                                                                        <tr id="individualEmpMidLabel2TrId${status.count}">
                                                                            <td colspan="3" id="endYearReId"><b>Manager Mid-Year Remark</b></td>
                                                                            <td colspan="3" id="endYearReId"><b>Manager End-Year Remark</b></td>
                                                                        </tr>
                                                                        <tr id="individualEmpMid2TrId${status.count}">
                                                                            <td colspan="3">${individualDevelopmentPlan.managerMidYearRemark}</td>
                                                                            <td colspan="3">
                                                                                ${individualDevelopmentPlan.managerEndYearRemark}</td>
                                                                        </tr>
                                                                    </c:if>
                                                                </c:forEach>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <input type="hidden" name="IndividualId" id="IndividualId" value="1">
                                                                <tr>
                                                                    <td style="text-align: center">1</td>
                                                                    <td></td>
                                                                    <td>
                                                                    </td>
                                                                    <td>
                                                                    </td>
                                                                    <td>
                                                                    </td>

                                                                </tr>

                                                                <tr>
                                                                    <td colspan="3" id="midYearReId"><b>Employee Mid-Year Remark</b></td>
                                                                    <td colspan="3" id="endYearReId"><b>Employee End-Year Remark</b></td>
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="3"></td>
                                                                    <td colspan="3"></td>
                                                                </tr>
                                                                <tr></tr>
                                                                <tr>
                                                                    <td colspan="3" id="endYearReId"><b>Manager Mid-Year Remark</b></td>
                                                                    <td colspan="3" id="endYearReId"><b>Manager End-Year Remark</b></td>
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="3"></td>
                                                                    <td colspan="3"></td>
                                                                </tr>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </table>

                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>


                                <div class="box box-info " id="behaviorsTabId">
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
                                                            <th style="text-align: center">End'Year Score</th>

                                                        </tr>
                                                        <input type="hidden" name="BehaviorsId" id="BehaviorsId" value="${fn:length(behaviorsList)}">
                                                        <tr style="background-color: lightgrey">
                                                            <c:choose>
                                                                <c:when test="${not empty behaviorsList}">
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
                                                                    <c:if test="${behaviorsList[0].midYearScore eq null}">
                                                                        <input type="Text" id="midYearScore1" name="midYearScore1" value="" class="form-control" readonly="true">
                                                                    </c:if>
                                                                </td>
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
                                                                    <c:if test="${behaviorsList[0].endYearScore eq null}">
                                                                        <input type="Text" id="endYearScore1" name="endYearScore1" value="" class="form-control" readonly="true">
                                                                    </c:if>

                                                                </td>
                                                                </tr>
                                                                <tr style="background-color: lightgrey">
                                                                    <td><b>Manager’s Mid - Year Review / Evaluation</b></td>
                                                                    <td colspan="2">${behaviorsList[0].managerMidYearReview}</td>
                                                                </tr>
                                                                <tr style="background-color: lightgrey" >
                                                                    <td id="managerEndYearReviewId1"><b>Manager’s End - Year Review / Evaluation</b></td>
                                                                    <td colspan="2"></td>
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
                                                                    <c:if test="${behaviorsList[0].midYearScore eq null}">
                                                                        <input type="Text" id="midYearScore2" name="midYearScore2" value="" class="form-control" readonly="true">
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
                                                                    <c:if test="${behaviorsList[1].endYearScore eq null}">
                                                                        <input type="Text" id="endYearScore2" name="endYearScore2" value="" class="form-control" readonly="true">
                                                                    </c:if>
                                                                </td>

                                                                </tr>
                                                                <tr style="background-color: lightgrey">
                                                                    <td><b>Manager’s Mid - Year Review / Evaluation</b></td>
                                                                    <td colspan="2">${behaviorsList[1].managerMidYearReview}</td>
                                                                </tr>
                                                                <tr style="background-color: lightgrey" id="managerEndYearReviewId">
                                                                    <td id="managerEndYearReviewId2"><b>Manager’s End - Year Review / Evaluation</b></td>
                                                                    <td colspan="2">${behaviorsList[1].managerEndYearReview}</td>
                                                                </tr>
                                                                <tr style="background-color: lightgrey">
                                                                <input type="hidden" id="w3" name="w3" value="WLB 3"/>
                                                                <td><b>WLB 3: Build Relationships & Develop Others</b><br>&nbsp;&nbsp;- Be grounded at all times & approachable<br>&nbsp;&nbsp;- Treat people with utmost respect & care<br>&nbsp;- Understand other’s perspective & concern<br>&nbsp;&nbsp;- Invest in developing the talent<br>&nbsp;&nbsp;- Give your team the right opportunities to learn and grow<br>&nbsp;&nbsp;- Create a learning environment & help others to learn from success stories & failures<br>&nbsp;&nbsp; </td>
                                                                <td>
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
                                                                    <c:if test="${behaviorsList[2].midYearScore eq null}">
                                                                        <input type="Text" id="midYearScore3" name="midYearScore3" value="" class="form-control" readonly="true">
                                                                    </c:if>
                                                                </td>

                                                                <td  id="endYearId3">
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
                                                                    <c:if test="${behaviorsList[2].endYearScore eq null}">
                                                                        <input type="Text" id="endYearScore3" name="endYearScore3" value="" class="form-control" readonly="true">
                                                                    </c:if>

                                                                    </tr>
                                                                <tr style="background-color: lightgrey">
                                                                    <td><b>Manager’s Mid - Year Review / Evaluation</b></td>
                                                                    <td colspan="2"><textarea type="Text" id="managerMidYearReview3" name="managerMidYearReview3" class="form-control" readonly="true"><c:if test="${appraisalPerformanceMaster.getManagerStatus() ne 0}">${behaviorsList[2].managerMidYearReview}</c:if></textarea></td>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey" id="managerEndYearReviewId">
                                                                        <td id="managerEndYearReviewId3"><b>Manager’s End - Year Review / Evaluation</b></td>
                                                                        <td colspan="2"><textarea type="Text" id="managerEndYearReview3" name="managerEndYearReview3" class="form-control" readonly="true"><c:if test="${appraisalPerformanceMaster.getManagerStatus() ne 0}">${behaviorsList[2].managerEndYearReview}</c:if></textarea></td>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey">
                                                                    <input type="hidden" id="w4" name="w4" value="WLB 4"/>
                                                                    <td><b>WLB 4: Act with Courage</b><br>&nbsp;&nbsp;- Take a stand – have your individual opinion & stand by it<br>&nbsp;&nbsp;- Don’t shy away from conflicts<br>&nbsp;&nbsp;- Deal with the issues head on – never procrastinate<br>&nbsp;&nbsp;- Never bury your head in the sand<br>&nbsp;&nbsp;- Be direct & candid</td>
                                                                    <td>
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
                                                                    <c:if test="${behaviorsList[3].midYearScore eq null}">
                                                                        <input type="Text" id="midYearScore4" name="midYearScore4" value="" class="form-control" readonly="true">
                                                                    </c:if>

                                                                <td id="endYearId4">
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
                                                                    <c:if test="${behaviorsList[3].endYearScore eq null}">
                                                                        <input type="Text" id="endYearScore4" name="endYearScore4" value="" class="form-control" readonly="true">
                                                                    </c:if>
                                                                </td>

                                                                </tr>
                                                                <tr style="background-color: lightgrey">
                                                                    <td><b>Manager’s Mid - Year Review / Evaluation</b></td>
                                                                    <td colspan="2">${behaviorsList[3].managerMidYearReview}</td>
                                                                </tr>
                                                                <tr style="background-color: lightgrey" id="managerEndYearReviewId">
                                                                    <td id="managerEndYearReviewId4"><b>Manager’s End - Year Review / Evaluation</b></td>
                                                                    <td colspan="2">${behaviorsList[3].managerEndYearReview}</td>
                                                                </tr>
                                                                <tr style="background-color: lightgrey">
                                                                <input type="hidden" id="w5" name="w5" value="WLB 5"/>
                                                                <td><b>WLB 5: Believe in Vision & Purpose</b><br>&nbsp;&nbsp;- Be Far-sighted & Look beyond the obvious<br>&nbsp;&nbsp;- Be Strategic – Have a macro & micro perspective, Innovate<br>&nbsp;&nbsp;- Be Entrepreneurial <br>&nbsp;&nbsp;- Communicate your Vision to your team<br>&nbsp;&nbsp;- Make sure everyone on board under stand's the purpose<br>&nbsp;&nbsp;- Communicate ‘What’ , Why and When to align people to your Vision & Purpose </td>
                                                                <td>
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
                                                                    <c:if test="${behaviorsList[4].midYearScore eq null}">
                                                                        <input type="Text" id="midYearScore5" name="midYearScore5" value="" class="form-control" readonly="true">
                                                                    </c:if>
                                                                </td>
                                                                <td id="endYearId5">
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
                                                                    <c:if test="${behaviorsList[4].endYearScore eq null}">
                                                                        <input type="Text" id="endYearScore5" name="endYearScore5" value="" class="form-control" readonly="true">
                                                                    </c:if>
                                                                </td>

                                                                </tr>
                                                                <tr style="background-color: lightgrey">
                                                                    <td><b>Manager’s Mid - Year Review / Evaluation</b></td>
                                                                    <td colspan="2">${behaviorsList[4].managerMidYearReview}</td>
                                                                </tr>
                                                                <tr style="background-color: lightgrey" id="managerEndYearReviewId">
                                                                    <td id="managerEndYearReviewId5"><b>Manager’s End - Year Review / Evaluation</b></td>
                                                                    <td colspan="2">${behaviorsList[4].managerEndYearReview}</td>
                                                                </tr>
                                                                <tr style="background-color: lightgrey">
                                                                    <td><b style="font-size: 16px">TOTAL SCORE</b></td>
                                                                    <td id="scoreMid">${behaviorsMidyearTotalscore}</td>
                                                                    <!--<td id="scoreEnd">${behaviorsEndyearTotalscore}</td>-->
                                                                    <td id="scoreEnd">${behaviorsEndyearTotalscoreForemp}</td>
                                                                </tr>
                                                                <tr style="background-color: lightgrey">
                                                                    <td><b>Other Comment/Remark (Mid Year)</b></td>
                                                                    <td colspan="2">${behaviorsMidyearOtherremark}</td>
                                                                </tr>
                                                                <tr style="background-color: lightgrey">
                                                                    <td id="behaviorsEndyearOtherremarkId"><b>Other Comment/Remark (End Year)</b></td>
                                                                    <td colspan="2">${behaviorsEndyearOtherremark}</td>
                                                                </tr>
                                                            </c:when>
                                                            <c:otherwise>

                                                                <tr style="background-color: lightgrey">
                                                                    <td><b>WLB 1: Walk the Talk </b><br>&nbsp;&nbsp;- Do & Act What you Preach<br>&nbsp;&nbsp;- Keep commitments<br>&nbsp;&nbsp;- Talk Straight – Be Honest & Tell the Truth<br>&nbsp;&nbsp;- Use simple language and call things what they are<br>&nbsp;&nbsp;- Don’t manipulate people nor distort facts</td>
                                                                    <td></td>
                                                                    <td></td>
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
                                                                    <td></td>
                                                                    <td></td>
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
                                                                    <td></td>
                                                                    <td></td>
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
                                                                    <td></td>
                                                                    <td></td>
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
                                                                    <td></td>
                                                                    <td></td>
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
                                                                    <td></td>
                                                                    <td></td>
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
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                                <div class="box box-info " id="RatingsTabId">
                                    <div class="box-header">
                                        <h3 class="box-title">Performance Ratings:</h3>

                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <!--                                                    <div class="form-group">
                                                                                                        <label class="col-sm-5 control-label"><b>Final Score</b></label>
                                                                                                        <div class="col-sm-2">
                                                
                                                                                                            <input type="number" id="behaviorsFinalscore" name="behaviorsFinalscore" value="${behaviorsFinalscore}" onload="printfinalScoreRatings();"class="form-control" readonly="true">
                                                
                                                                                                        </div>
                                                                                                    </div>-->

                                                <div class="row">
                                                    <div class="col-sm-4">
                                                        <div class="form-group text-center">
                                                            <label class="control-label"><b>KRA Score</b></label>&nbsp;&nbsp;
                                                            <input type="number" id="totalScore" name="totalScore" value="${totalScoreForemployee}" disabled="disabled" style="border-radius: 4px; border: 1px solid #ccc; padding: 6px 12px;" readonly="true">
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-4 form-group text-center">
                                                        <div class="form-group">
                                                            <label class="control-label"><b>WLB Score</b></label>&nbsp;&nbsp;
                                                            <input type="number" id="behaviorsEndyearTotalscore" name="behaviorsEndyearTotalscore" value="${behaviorsEndyearTotalscoreForemp}" disabled="disabled" style="border-radius: 4px; border: 1px solid #ccc; padding: 6px 12px;" readonly="true">
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-4 form-group text-center">
                                                        <div class="form-group">
                                                            <label class="control-label"><b>Final Score</b></label>&nbsp;&nbsp;
                                                            <input type="Text" id="behaviorsFinalscore" name="behaviorsFinalscore" value="${behaviorsFinalscoreForemployee}" onchange="performancefinalScoreRatingsEmployee();" disabled="disabled" style="border-radius: 4px; border: 1px solid #ccc; padding: 6px 12px;" readonly="true">
                                                            <!--<input type="number" id="behaviorsFinalscore" name="behaviorsFinalscore" value="${behaviorsFinalscore}" disabled="disabled" style="border-radius: 4px; border: 1px solid #ccc; padding: 6px 12px;" readonly="true">-->
                                                        </div>
                                                    </div>
                                                </div>

                                            </div>

                                            <div class="col-md-12 col-sm-12">
                                                <div class="table-responsive">
                                                    <table id="demo234" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                        <tr>
                                                            <th style="text-align: center">Performance Ratings</th>
                                                            <th style="text-align: center">Score</th>
                                                            <th style="text-align: center">Score Achieved</th>
                                                        </tr>
                                                        <tr class="d1" id="tbl111" >
                                                            <td style="vertical-align: middle"><b>Far Exceeds Expectations</b></td>
                                                            <td style="text-align: center"><h4 style="background-color: #337AB7;"><b>106 to 110</b></h4></td>
                                                            <td style="text-align: center"><c:if test="${behaviorsFinalscoreForemployee ge '116' && behaviorsFinalscoreForemployee le '110' || behaviorsFinalscoreForemployee eq '116' || behaviorsFinalscoreForemployee eq '116'}"><i class="fa fa-check"></i></c:if></td>
                                                            </tr>
                                                            <tr class="" id="tbl112" >
                                                                <td style="vertical-align: middle"><b>Exceeds Expectations</b></td>
                                                                <td style="text-align: center"><h4><b>101 to 105</b></h4></td>
                                                                <td style="text-align: center"><c:if test="${behaviorsFinalscoreForemployee ge '101' && behaviorsFinalscoreForemployee le '105' || behaviorsFinalscoreForemployee eq '101' || behaviorsFinalscoreForemployee eq '105'}"><i class="fa fa-check"></i></c:if></td>

                                                            </tr>
                                                            <tr class="" id="tbl113" >
                                                                <td style="vertical-align: middle"><b>Meets Expectations</b></td>
                                                                <td style="text-align: center"><h4><b>80 to 100</b></h4></td>
                                                                <td style="text-align: center"><c:if test="${behaviorsFinalscoreForemployee ge '80'  && behaviorsFinalscoreForemployee le '100' || behaviorsFinalscoreForemployee eq '80' || behaviorsFinalscoreForemployee eq '100'}"><i class="fa fa-check"></i></c:if></td>

                                                            </tr>
                                                            <tr class="" id="tbl114" >
                                                                <td style="vertical-align: middle"><b>Partially Meets Expectations</td>
                                                                <td style="text-align: center"><h4><b>51 to 79</b></h4></td>
                                                                <td style="text-align: center"><c:if test="${behaviorsFinalscoreForemployee ge '51'  && behaviorsFinalscoreForemployee le '79' || behaviorsFinalscoreForemployee eq '51' || behaviorsFinalscoreForemployee eq '79'}"><i class="fa fa-check"></i></c:if></td>

                                                            </tr>
                                                            <tr class="" id="tbl115">
                                                                <td style="vertical-align: middle"><b>Does Not Meet Expectations</b></td>
                                                                <td style="text-align: center"><h4><b>50 & Below</b></h4></td>
                                                                <td style="text-align: center">
                                                                <c:if test="behaviorsFinalscoreForemployee le '50' || behaviorsFinalscoreForemployee eq '50'}"> 
                                                                    <i class="fa fa-check"></i>
                                                                </c:if>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div><!-- /.col -->
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label"><b>Activity/Project Performance${behaviorsFinalscoreForemployee ge '0' && behaviorsFinalscoreForemployee le '50' || behaviorsFinalscoreForemployee eq '0' || behaviorsFinalscoreForemployee eq '50'}</b></label>
                                                    <div class="col-sm-2">
                                                        <input type="Text" id="" name="" value="${empActivityScore}"  class="form-control" readonly>
                                                </div>
                                            </div> 
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                                <%--</form:form>--%>
                            </div><!-- /.tab-content -->
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
            </section><!-- /.content -->
        </div>
    </body>

    <script>
        var tflag11 = document.getElementById("tflagId").value;
        var flag11 = document.getElementById("flagId").value;
        var employeeStatusVar = document.getElementById("employeeStatus").value;
        var flagmid = document.getElementById("flagMidId").value;
        var flagEndId = document.getElementById("flagEndId").value;

        if (flag11 === 'true' && flagmid !== 'true' && flagEndId !== 'true') {
            if (employeeStatusVar === '1') {
                $("#form1 :input").attr("disabled", true);
                $("#btn1").attr("disabled", false);
                $("#btn2").attr("disabled", false);
                $("#btn3").attr("disabled", false);
                $("#btn4").attr("disabled", false);
                $("#btn5").attr("disabled", false);
                $("#btn6").attr("disabled", false);
                $("#btn7").attr("disabled", false);
                $(".close").attr("disabled", false);


            }
//
        } else if (flag11 !== 'true' && flagmid === 'true' && flagEndId !== 'true') {
//            alert("NO2 flage Found");
            if (employeeStatusVar === '1') {
                $("#form1 :input").attr("disabled", true);
                $("#btn1").attr("disabled", false);
                $("#btn2").attr("disabled", false);
                $("#btn3").attr("disabled", false);
                $("#btn4").attr("disabled", false);
                $("#btn5").attr("disabled", false);
                $("#btn6").attr("disabled", false);
                $("#btn7").attr("disabled", false);
                $(".close").attr("disabled", false);

            }
//
        } else if (flag11 !== 'true' && flagmid !== 'true' && flagEndId === 'true') {
//            alert("NO3 flage Found");
            if (employeeStatusVar === '1') {
                $("#form1 :input").attr("disabled", true);
                $("#btn1").attr("disabled", false);
                $("#btn2").attr("disabled", false);
                $("#btn3").attr("disabled", false);
                $("#btn4").attr("disabled", false);
                $("#btn5").attr("disabled", false);
                $("#btn6").attr("disabled", false);
                $("#btn7").attr("disabled", false);
                $(".close").attr("disabled", false);

            }

        } else {
            $("#form1 :input").attr("disabled", true);
            $("#btn1").attr("disabled", false);
            $("#btn2").attr("disabled", false);
            $("#btn3").attr("disabled", false);
            $("#btn4").attr("disabled", false);
            $("#btn5").attr("disabled", false);
            $("#btn6").attr("disabled", false);
            $("#btn7").attr("disabled", false);
            $(".close").attr("disabled", false);

        }
//        if (tflag11 === 'true' ) {
//
//        } else {
//            $("#form1 :input").attr("readonly", true);
//        }
    </script>
    <script>
        $(document).keydown(function (objEvent) {
            if (objEvent.keyCode == 9) {  //tab pressed
                objEvent.preventDefault(); // stops its action
            }
        })
    </script>
    <style>
        .class-with-width { width: 150px !important; }
    </style>
    <script type="text/javascript" src="StorageYard/Plugins/alert/bootbox.min.js"></script>
</html>
