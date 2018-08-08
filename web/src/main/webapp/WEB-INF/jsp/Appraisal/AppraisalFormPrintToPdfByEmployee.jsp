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
        /*        @media print {
                    #demo234 tr th  {
                        background-color: darkgrey !important;
                        border-color: black !important;
                    }
                    #demo234 tr#tbl111 td {
                        background-color: #337AB7 !important;
                        border-color: black !important;
                    }
                    #demo234 tr#tbl112 td {
                        background-color: #5CB85C !important;
                        border-color: black !important;
                    }
                    #demo234 tr#tbl113 td {
                        background-color: #F0AD4E !important;
                        border-color: black !important;
                    }
                    #demo234 tr#tbl114 td {
                        background-color: #FFA375 !important;
                        border-color: black !important;
                    }
                    #demo234 tr#tbl115 td {
                        background-color: #D9534F !important;
                        border-color: black !important;
                    }
                }*/
        table.table-bordered > tbody > tr > th{
            border: 1px solid;
            border-color: #000 !important;
            text-align: center;
            vertical-align: middle;
            font-size:12px;
        }
        table.table-bordered > tbody > tr > td{
            border: 1px solid;
            border-color: #000 !important;
            text-align: center;
            vertical-align: middle;
            font-size:12px;
        }

        page {
            background: white;
            display: block;
            margin: 0 auto;
            margin-bottom: 0.5cm;
            box-shadow: 0 0 0.5cm rgba(0,0,0,0.5);
        }
        page[size="A4"] {  
            width: 21cm;
            height: 29.7cm; 
        }
        page[size="A4"][layout="portrait"] {
            width: 29.7cm;
            height: 21cm;  
        }
        page[size="A3"] {
            width: 29.7cm;
            height: 42cm;
        }
        page[size="A3"][layout="portrait"] {
            width: 42cm;
            height: 29.7cm;  
        }
        page[size="A5"] {
            width: 14.8cm;
            height: 21cm;
        }
        page[size="A5"][layout="portrait"] {
            width: 21cm;
            height: 14.8cm;  
        }
        @media print {
            body, page {
                margin: 0;
                box-shadow: 0;
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
                        <div class="box-header" style="" align="Center" >
                            <h3 class="box-title">Performance Appraisal</h3>
                        </div>
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
                                                        <th style="text-align: center" id="metricid1">Time Space</th>
                                                        <th style="text-align: center" id="metricid1">KRA Category</th>

                                                        <th style="margin: 0px;width: 25px;text-align: center;" id="weightageid12">Weightage Out Of 75</th>
                                                        <!--<th style="display: none;" id='weightageOut'></th>-->


                                                        <!--<th style="margin: 0px;width: 70px;text-align: center" id="midYearDivid">Mid Year Status</th>-->
                                                        <th style="margin: 0px;width: 70px;text-align: center" id="endYearDivid1">Status</th>
                                                        <th style="margin: 0px;text-align: center" id="empfinalScoreid01">Employee Score</th>
                                                        <th style="margin: 0px;width: 25px;text-align: center" id="finalScoreid01">Manager Total Score</th>
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
<!--                                                                    <td id="midYearDivid1${status.count}">
                                                                    ${kragoallist.midyearStatus}
                                                                </td>-->
                                                                    <td id="endYearDivid1${status.count}">
                                                                        ${kragoallist.endyearStatus}
                                                                    </td>

                                                                    <td id="empfinalScore${status.count}">
                                                                        ${kragoallist.empFinalScore}
                                                                    </td>
                                                                    <td id="finalScoreid${status.count}">
                                                                        ${kragoallist.finalScore}
                                                                    </td>
                                                                    </tr>
<!--                                                                    <tr id="employeesMid${status.count}">
                                                                        <td colspan="4"><b>Employee’s Mid - Year Self – Assessment KRA:</b></td>
                                                                        <td colspan="4"><b>Manager’s Mid - Year Review / Evaluation KRA:</b></td>
                                                                    </tr>-->
<!--                                                                    <tr id="textemployeesMid${status.count}">
                                                                        <td colspan="4">${kragoallist.empMidyearSelfassessmentGoal}</td>
                                                                        <td colspan="4">${kragoallist.managerMidyearReviewEvaluation}</td>
                                                                    </tr>-->

                                                                    <tr id="employeesEnd${status.count}">
                                                                        <td colspan="4"><b>Employee’s Self – Assessment KRA:</b></td>
                                                                        <td colspan="4"><b>Manager’s Review / Evaluation KRA:</b></td>
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
                                                                    <!--<td id="midYearDivid1"></td>-->
                                                                    <td id="endYearDivid"></td>
                                                                    <td id="finalScoreid"></td>
                                                                    <td id="finalScoreid"></td>
                                                                <input type="hidden" id="startDate1" name="startDate1" value="${kragoal[0].startDate}">
                                                                <!--                                                                <tr id="employeesMid">
                                                                                                                                    <td colspan="4"><b>Employee’s Mid - Year Self – Assessment KRA:</b></td>
                                                                                                                                    <td colspan="4"><b>Manager’s Mid - Year Review / Evaluation KRA:</b></td>
                                                                                                                                </tr>
                                                                                                                                <tr id="textemployeesMid">
                                                                                                                                    <td colspan="4"></td>
                                                                                                                                    <td colspan="4"></td>
                                                                                                                                </tr>-->

                                                                <tr id="employeesEnd">
                                                                    <td colspan="4"><b>Employee’s Self – Assessment KRA:</b></td>
                                                                    <td colspan="4"><b>Manager’s  Review / Evaluation KRA:</b></td>
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
                                                            <!--                                                            <td style="margin: 0px;width: 100px;"></td>
                                                                                                                        <td style="margin: 0px;width: 100px;"></td>-->
                                                            <td style="margin: 0px;width: 200px;" id="weightageScoreId" align="right"><b>Weightage</b></td>
                                                            <td style="margin: 0px;width: 100px;" id="dhaval">
                                                                <input type="text" id="weightageScore" name="weightageScore" class="form-control"  value="${weightageScore}" style="margin: 0px;width: 100px;" readonly="true">
                                                            </td>
                                                            <td style="margin: 0px;width: 150px;" id="empScoreId" align="right"><b>Employee Total Score</b></td>
                                                            <td style="margin: 0px;width: 100px;" id="dhaval">
                                                                <input type="text" id="empScore" name="empScore" class="form-control"  value="${empScore}" style="margin: 0px;width: 100px;" readonly="true">
                                                            </td>
                                                            <td style="margin: 0px;width: 150px;" id="totalScoreId" align="right"><b>Manager Total Score</b></td>
                                                            <td><input id="totalScore" name="totalScore" value="${totalScore}" class="form-control" value="${totalScore}" style="margin: 0px;width: 100px;" readonly="true">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->

                                </div>

                                <!--                                <div class="box box-info ">
                                                                    <div class="box-header">
                                                                        <h3 class="box-title">Competency Evaluation (As Per Bulwarks System Competency Framework) :</h3>
                                
                                                                    </div> /.box-header 
                                                                    <div class="box-body no-padding">
                                                                        <div class="row">
                                                                            <div class="col-md-12 col-sm-12">
                                <%--<c:if test="${empty competencyEvaluationList[0][2].title || appraisalPerformanceMaster.managerStatus ne 1}">--%>
                                <%--<c:forEach var="competencyMap" items="${competencyMap}">--%>
                                <%--<c:if test="${competencyEvaluationList[0][2].title  eq competencyMap.value}">--%>
                                ${competencyMap.value}
                                <%--</c:if>--%>
                                <%--<c:if test="${competencyEvaluationList[0][2].title  ne competencyMap.value}">--%>
                                ${competencyMap.value}
                                <%--</c:if>--%>
                                <%--</c:forEach>--%>
                                <%--</c:if>--%>
                                <%--<c:if test="${appraisalPerformanceMaster.managerStatus eq 1 && !empty competencyEvaluationList[0][2].title}">--%>
                                ${competencyEvaluationList[0][2].title}
                                <%--</c:if>--%>
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
                                <%--<c:forEach var="competencyEvaluationList" items="${competencyEvaluationList}" varStatus="status">--%>

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
                                <%--</c:forEach>--%>
                            </table>
                        </div>
                    </div>
                </div>
            </div> /.box-body 
        </div>-->




                                <!--                                <div class="box box-info " id="RatingsTabId">
                                                                    <div class="box-header">
                                                                        <h3 class="box-title">Performance Ratings:</h3>
                                
                                                                    </div> /.box-header 
                                                                    <div class="box-body no-padding">
                                                                        <div class="row">
                                                                            <div class="col-md-12 col-sm-12">-->
                                <!--                                                    <div class="form-group">
                                                                                        <label class="col-sm-5 control-label"><b>Final Score</b></label>
                                                                                        <div class="col-sm-2">
                                
                                                                                            <input type="number" id="behaviorsFinalscore" name="behaviorsFinalscore" value="${behaviorsFinalscore}" onload="printfinalScoreRatings();"class="form-control" readonly="true">
                                
                                                                                        </div>
                                                                                    </div>-->

                                <!--                                                <div class="row">
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
                                                                                            <input type="number" id="behaviorsFinalscore" name="behaviorsFinalscore" value="${behaviorsFinalscore}" disabled="disabled" style="border-radius: 4px; border: 1px solid #ccc; padding: 6px 12px;" readonly="true">
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                
                                                                            </div>-->



                                <!--                                        </div> /.row 
                                                                    </div> /.box-body 
                                                                </div>-->
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
