<%--

    Document   : PerformanceAppraisalForm
    Created on : Oct 5, 2015, 2:47:30 PM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/ManagerComman.jsp"%>
    <!--<script type="text/javascript" src="StorageYard/Plugins/alert/example.css"></script>-->
    <!--<script type="text/javascript" src="StorageYard/Plugins/alert/sweetalert.css"></script>-->


    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Performance Appraisal Form</title>
    </head>
    <script>
        function buttonFun1() {
            var className = $('#minusId1').attr('class');
            if (className == 'fa fa-plus') {
                document.getElementById('spanId1').innerHTML = 'Minimize';
            } else {
                document.getElementById('spanId1').innerHTML = 'Expand';
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

    </script>
    <script>
        function appraisalSelectedPrint() {
            var empId = document.getElementById("empId").value;
            var userid = document.getElementById("userid").value;
            var appraisalId = document.getElementById("appraisalId").value;
//            alert(empId);
//            alert(appraisalId);
//            alert(userid);
            var path = 'appraisalPerformance.htm?act=appraisalPerformancePrint&id=' + empId + '&userid=' + userid + '&appraisalId=' + appraisalId;
//            ;
//             window.print(path, 'popUpWindow', 'height=700,width=900,left=10,top=10,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no,status=yes')
            popupWindow = window.open(path, 'popUpWindow', 'height=700,width=900,left=10,top=10,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no,status=yes,type=text/css')
//             mywindow.document.write('<link rel="stylesheet" href="/WEB-INF/jsp/Common/Top.jsp" type="text/css" />');
//            window.print();
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
            //padding: 6px 12px;
            padding: 1px 7px;
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
    <body>
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
                    <a href="appraisalPerformance.htm?act=appraisalPerformancePrint&id=${empId}&userid=${userid}&appraisalId=${appraisalId}" target="_blank"  class="btn btn-primary">Print</a>

                    <input type="hidden" id="empId" name="empId" value="${empId}">
                    <input type="hidden" id="userid" name="userid" value="${userid}">
                    <input type="hidden" id="appraisalId" name="appraisalId" value="${appraisalId}">
                    <input type="hidden" id="managerStatus" name="managerStatus" value="${managerStatus}">
                    <input type="hidden" id="managerKraStatus" name="managerKraStatus" value="${managerKraStatus}">
                </div>
            </section>
            <!-- Main content -->
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--<span style="color: red;font-size: 14px;">All the editable fields are mandatory.</span>-->
                                <form:form class="form-horizontal" id="form1" role="form1" action="appraisalPerformance.htm?act=createSubmitManager" commandName="appraisalPerformanceMaster" enctype="multipart/form-data" method="post" name='form' >

                                    <!--form horizontal starts here-->
                                    <!--<form class="form-horizontal" role="form" commandName="AppraisalPerformanceMaster">-->
                                    <div class="box box-info collapsed-box ">
                                        <div class="box-header">
                                            <h3 class="box-title">Employee Detail:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId1">Expand</span><button class="btn btn-box-tool" id="btn1" data-widget="collapse" onclick="buttonFun1();"><i class="fa fa-plus" id="minusId1" ></i></button>
                                                <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
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
                                    </div><!-- /.row -->



                                    <!--Employee detail completes here-->
                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">Results:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId2">Expand</span><button class="btn btn-box-tool" id="btn2" data-widget="collapse" onclick="buttonFun2();"><i class="fa fa-plus" id="minusId2" ></i></button>
                                                <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                            </div>
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
                                                            <input type="hidden" name="countId" id="countId" value="${fn:length(kragoal)}">
                                                            <input type="hidden" name="appraisalId" id="appraisalId" value="${appraisalId}">
                                                            <input type="hidden" name="employeeId" id="employeeId" value="${employeeId}">
                                                            <input type="hidden" name="kraremovedIdVal" id="kraremovedIdVal" value="">
                                                            <th style="text-align: center">Sr. No.</th>


                                                            <th style="text-align: center" id="kraGoalid1">High Impact Goal / KRA</th>
                                                            <th style="text-align: center" id="metricid1">Metric</th>
                                                            <th style="text-align: center" id="metricid1">KRA Category</th>

                                                            <th style="margin: 0px;width: 50px;text-align: center" id="weightageid12">Weightage Out Of 75</th>

                                                            <th style="margin: 0px;width: 70px;text-align: center" id="midYearDivid1">Mid Year Status</th>
                                                            <th style="margin: 0px;width: 70px;text-align: center" id="endYearDivid1">End Year Status</th>
                                                            <th style="margin: 0px;width: 50px;text-align: center" id="finalScoreid">Final Score</th>
                                                                <%--</c:if>--%>
                                                            <th style="text-align: center;width: 50px">Edit<br><a href="#" title="Deleted KRA" data-toggle="modal" data-target="#deletedKraModel" onclick="deletedKraajaxfun('${appraisalId}');">KRA</a></th>
                                                            <th style="text-align: center;width: 50px"><span style='margin-top: 5px;'>
                                                                    <input type="button" value="+" id="addRowButtonId" title="Add New"/>
                                                                </span></th>
                                                            </tr>
                                                            <input type="hidden" name="kragoalLength" id="kragoalLength" value="${fn:length(kragoal)}">

                                                            <c:choose>
                                                                <c:when test="${fn:length(kragoal) > 0}">
                                                                    <c:set var="resultkraGoalByManager" value="${fn:length(kragoal)}"></c:set>
                                                                    <c:forEach var="kragoallist" items="${kragoal}" varStatus="status">
                                                                        <tr id="removeTr${status.count}">
                                                                        <input type="hidden" name="kragoal_id${status.count}" id="kragoal_id${status.count}" value="${kragoallist.id}">
                                                                        <td id="removeKRAID${status.count}" class="removeClass" style="margin: 0px;width: 45px;">${status.count}</td>
                                                                        <%--<c:if test="${flag eq true}">--%>

                                                                        <td id="kraGoalid1${status.count}"><textarea type="Text" name="kraGoal${status.count}" id="kraGoal${status.count}"  class="form-control">${kragoallist.kraGoalByManager}</textarea></td>
                                                                        <td id="metricid1${status.count}"><textarea type="Text" name="metric${status.count}" id="metric${status.count}" class="form-control">${kragoallist.matrixByManager}</textarea>
                                                                        </td>
                                                                        <td id="kraCategoryId${status.count}">
                                                                            <select id="kraCategoryMap${status.count}" name="kraCategoryMap${status.count}" class="form-control" >
                                                                                <option value="">SELECT</option>
                                                                                <c:forEach var="kraCategory" items="${kraCategoryMap}">
                                                                                    <c:if test="${kragoallist.kraCategoryByKraCategoryByManager.id eq kraCategory.key}">
                                                                                        <option value="${kraCategory.key}" selected="">${kraCategory.value}</option>
                                                                                    </c:if>
                                                                                    <c:if test="${kragoallist.kraCategoryByKraCategoryByManager.id ne kraCategory.key}">
                                                                                        <option value="${kraCategory.key}">${kraCategory.value}</option>
                                                                                    </c:if>
                                                                                </c:forEach>
                                                                            </select>
                                                                        </td>


                                                                        <td id="weightageid1${status.count}"><input type="number" name="weightage${status.count}" id="weightage${status.count}" value="${kragoallist.weightageManager}" min="1" max="75" class="form-control" style="margin: 0px;width: 67px;" onkeypress="return allowOnlyNumber(event);" onchange="weightageCount(${status.count});"></td>
                                                                        <td id="midYearDivid1${status.count}"><div>
                                                                                <select id="midYearDiv${status.count}" name="midYearDiv${status.count}" value="${kragoallist.midyearStatusManager}" style="margin: 0px;width: 115px;" class="form-control">
                                                                                    <option value="">SELECT</option>
                                                                                    <c:choose>
                                                                                        <c:when test="${kragoallist.midyearStatusManager eq 'Yet to Start'}">

                                                                                            <option value="Yet to Start" selected="">Yet to Start</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>

                                                                                            <option value="Yet to Start">Yet to Start</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                    <c:choose>
                                                                                        <c:when test="${kragoallist.midyearStatusManager eq 'In Progress'}">

                                                                                            <option value="In Progress" selected="">In Progress</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>

                                                                                            <option value="In Progress">In Progress</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                    <c:choose>
                                                                                        <c:when test="${kragoallist.midyearStatusManager eq 'Completed'}">

                                                                                            <option value="Completed" selected="">Completed</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>

                                                                                            <option value="Completed">Completed</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                    <c:choose>
                                                                                        <c:when test="${kragoallist.midyearStatusManager eq 'Canceled'}">

                                                                                            <option value="Canceled" selected="">Canceled</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>

                                                                                            <option value="Canceled">Canceled</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>

                                                                                </select>
                                                                            </div>
                                                                        </td>
                                                                        <td id="endYearDivid1${status.count}"><div>
                                                                                <select id="endYearDiv${status.count}" name="endYearDiv${status.count}" value="${kragoallist.endyearStatusManager}" style="margin: 0px;width: 115px;" class="form-control">
                                                                                    <option value="">SELECT</option>
                                                                                    <c:choose>
                                                                                        <c:when test="${kragoallist.endyearStatusManager eq 'Yet to Start'}">

                                                                                            <option value="Yet to Start" selected="">Yet to Start</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>

                                                                                            <option value="Yet to Start">Yet to Start</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                    <c:choose>
                                                                                        <c:when test="${kragoallist.endyearStatusManager eq 'In Progress'}">

                                                                                            <option value="In Progress" selected="">In Progress</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>

                                                                                            <option value="In Progress">In Progress</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                    <c:choose>
                                                                                        <c:when test="${kragoallist.endyearStatusManager eq 'Completed'}">

                                                                                            <option value="Completed" selected="">Completed</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>

                                                                                            <option value="Completed">Completed</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                    <c:choose>
                                                                                        <c:when test="${kragoallist.endyearStatusManager eq 'Canceled'}">

                                                                                            <option value="Canceled" selected="">Canceled</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>

                                                                                            <option value="Canceled">Canceled</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                </select>
                                                                            </div>
                                                                        </td>
                                                                        <td id="finalScoreid${status.count}"><input type="number" id="finalScore${status.count}" name="finalScore${status.count}" value="${kragoallist.finalScoreManager}" min="1" class="form-control" style="margin: 0px;width: 67px;"  onchange="finalScoreCount(${status.count});"></td>
                                                                            <%--</c:if>--%>

                                                                        <td style="text-align: center"><span style='margin-top: 5px;'><button type="button" class="btns btn-warnings" onclick="changeReadonly('${status.count}')">Edit</button></span><br/>
                                                                            <span>${kragoallist.editDate}</span><input type="hidden" id="startDate${status.count}" name="startDate${status.count}" value="${kragoallist.startDate}">
                                                                               <!--<a href="" data-toggle="modal" data-target="#History" onclick="managerhistoryajaxfun('${kragoallist.id}');">History</a>-->
                                                                            <c:if test="${appraisalPerformanceMaster.managerStatus ne 0 and updateStatus}">

                                                                                <a href="" data-toggle="modal" data-target="#kraModel" onclick="managerhistoryajaxfun('${kragoallist.id}');">History</a>
                                                                            </c:if>
                                                                        </td>
                                                                        <%--<c:if test="${status.last}">--%>
                                                                        <!--<td style="text-align: center"><span style='margin-top: 5px;'>-->
                                                                        <!--<input type="button" value="+" id="addRowButtonId" />-->
                                                                        <!--</span>-->
                                                                        <!--</td>-->
                                                                        <%--</c:if>--%>
                                                                        <%--<c:if test="${!status.last}">--%>
                                                                        <td id="" style="text-align: center">
                                                                            <span style="margin-top: 5px;">
                                                                                <c:if test="${(flag eq 'true' || flag1 eq 'true' || flag2 eq 'true') && resultkraGoalByManager > 1}">
                                                                                    <input type="button" value="-" id="removeRowButtonId" onclick="removeChild4('removeTr${status.count}', 'employeesMid${status.count}', 'textemployeesMid${status.count}', 'employeesEnd${status.count}', 'textemployeesEnd${status.count}', '${kragoallist.id}');">
                                                                                </c:if>
                                                                            </span>
                                                                        </td>
                                                                        <%--</c:if>--%>

                                                                        </tr>

<!--                                                                        <tr id="employeesMid${status.count}"><td></td><td colspan="6"><b>Employee’s Mid - Year Self – Assessment Goal:</b></td><td></td><td></td></tr>
                                                                        <tr id="textemployeesMid${status.count}"><td></td><td colspan="6" ><textarea id="employeeMidYearSelfAssesssmentGoal${status.count}" name="employeeMidYearSelfAssesssmentGoal${status.count}" type="Text" class="form-control">${kragoallist.empMidyearSelfassessmentGoal}</textarea></td><td></td><td></td></tr>
                                                                        <tr id="managersMid${status.count}"><td></td><td colspan="6" ><b>Manager’s Mid - Year Review / Evaluation Goal:</b></td><td></td><td></td></tr>
                                                                        <tr id="textmanagersMid${status.count}"><td></td><td colspan="6" ><textarea id="managerMidYearSelfAssesssmentGoal${status.count}" name="managerMidYearSelfAssesssmentGoal${status.count}" type="Text" class="form-control">${kragoallist.managerMidyearReviewEvaluation}</textarea></td><td></td></tr>
                                                                        <tr id="employeesEnd${status.count}"><td></td><td colspan="6" ><b>Employee’s End - Year Self – Assessment Goal:</b></td><td></td><td></td></tr>
                                                                        <tr id="textemployeesEnd${status.count}"><td></td><td colspan="6" ><textarea id="employeeEndYearSelfAssesssmentGoal${status.count}" name="employeeEndYearSelfAssesssmentGoal${status.count}" type="Text" class="form-control">${kragoallist.empEndyearSelfassessmentGoal}</textarea></td><td></td><td></td></tr>
                                                                        <tr id="managersEnd${status.count}"><td></td><td colspan="6" ><b>Manager’s End - Year Review / Evaluation Goal:</b></td><td></td><td></td></tr>
                                                                        <tr id="textmanagersEnd${status.count}"><td></td><td colspan="6" ><textarea id="managerEndYearSelfAssesssmentGoal${status.count}" name="managerEndYearSelfAssesssmentGoal${status.count}" type="Text" class="form-control">${kragoallist.managerEndyearReviewEvaluation}</textarea></td><td></td><td></td></tr>-->
                                                                        <tr id="employeesMid${status.count}">
                                                                            <td colspan="5"><b>Employee’s Mid - Year Self – Assessment KRA:</b></td>
                                                                            <td colspan="5"><b>Manager’s Mid - Year Review / Evaluation KRA:</b></td>
                                                                        </tr>
                                                                        <tr id="textemployeesMid${status.count}">
                                                                            <td colspan="5"><textarea id="employeeMidYearSelfAssesssmentGoal${status.count}" style="width: 474px;" name="employeeMidYearSelfAssesssmentGoal${status.count}"type="Text" class="form-control">${kragoallist.empMidyearSelfassessmentGoalManager}</textarea></td>
                                                                            <td colspan="5"><textarea id="managerMidYearSelfAssesssmentGoal${status.count}" style="width: 474px;" name="managerMidYearSelfAssesssmentGoal${status.count}" type="Text" class="form-control"><c:if test="${appraisalPerformanceMaster.getManagerStatus() ne 0}">${kragoallist.managerMidyearReviewEvaluationManager}</c:if></textarea></td>
                                                                            </tr>

                                                                            <tr id="employeesEnd${status.count}">
                                                                            <td colspan="5"><b>Employee’s End - Year Self – Assessment KRA:</b></td>
                                                                            <td colspan="5"><b>Manager’s End - Year Review / Evaluation KRA:</b></td>
                                                                        </tr>
                                                                        <tr id="textemployeesEnd${status.count}">
                                                                            <td colspan="5"><textarea id="employeeEndYearSelfAssesssmentGoal${status.count}" style="width: 474px;" name="employeeEndYearSelfAssesssmentGoal${status.count}" type="Text" class="form-control">${kragoallist.empEndyearSelfassessmentGoalManager}</textarea></td>
                                                                            <td colspan="5"><textarea id="managerEndYearSelfAssesssmentGoal${status.count}" style="width: 474px;" name="managerEndYearSelfAssesssmentGoal${status.count}" type="Text" class="form-control"><c:if test="${appraisalPerformanceMaster.getManagerStatus() ne 0}">${kragoallist.managerEndyearReviewEvaluationManager}</c:if></textarea></td>
                                                                            </tr>
                                                                    </c:forEach>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <tr>
                                                                        <td style="margin: 0px;width: 45px;">1</td>
                                                                        <%--<c:if test="${flag eq true}">--%>
                                                                        <%--</c:if>--%>
                                                                        <%--<c:if test="${flag ne true}">--%>

                                                                        <!--<td id="kraGoalid"><textarea type="Text" name="kraGoal1" id="kraGoal1" class="form-control"></textarea></td>-->
                                                                        <td id="kraGoalid"><textarea type="Text" name="kraGoal1" id="kraGoal1"  class="form-control"></textarea></td>
                                                                        <td id="metricid"><textarea type="Text" name="metric1" id="metric1" class="form-control"></textarea></td>

                                                                        <td id="weightageid"><input type="number" name="weightage1" id="weightage1" class="form-control" style="margin: 0px;width: 100px;"></td>
                                                                    <span id="error" style="color: Red; display: none">* Input digits (0 - 9)</span>
                                                                    <td id="midYearDivid"><div>
                                                                            <select id="midYearDiv1" name="midYearDiv1" class="form-control">
                                                                                <option value="">--SELECT--</option>
                                                                                <option value="Yet to Start">Yet to Start</option>
                                                                                <option value="In Progress">In Progress</option>
                                                                                <option value="Completed">Completed</option>
                                                                                <option value="Canceled">Canceled</option>
                                                                            </select>
                                                                        </div>
                                                                    </td>
                                                                    <td id="endYearDivid"><div>
                                                                            <select id="EndYearDiv1" name="EndYearDiv1" class="form-control">
                                                                                <option value="">--SELECT--</option>
                                                                                <option value="Yet to Start">Yet to Start</option>
                                                                                <option value="In Progress">In Progress</option>
                                                                                <option value="Completed">Completed</option>
                                                                                <option value="Canceled">Canceled</option>
                                                                            </select>
                                                                        </div>
                                                                    </td>
                                                                    <td id="finalScoreid"><input type="Text" id="finalScore" name="finalScore" class="form-control" style="margin: 0px;width: 100px;"></td>
                                                                        <%--</c:if>--%>

                                                                    <td style="text-align: center"><span style='margin-top: 5px;'><button type="button" class="btns btn-warnings">Edit</button></span><br/>
                                                                    </td>
                                                                    <td style="text-align: center">

                                                                    </td>
                                                                    <!--//=============================Otherwise//-->
                                                                    <!--                                                                    <tr id="employeesMid"><td></td><td colspan="6"><b>Employee’s Mid - Year Self – Assessment Goal:</b></td><td></td><td></td></tr>
                                                                                                                                        <tr id="textemployeesMid"><td></td><td colspan="6" ><textarea id="employeeMidYearSelfAssesssmentGoal" id="employeeMidYearSelfAssesssmentGoal" type="Text" class="form-control"></textarea></td><td></td><td></td></tr>
                                                                                                                                        <tr id="managersMid"><td></td><td colspan="6" ><b>Manager’s Mid - Year Review / Evaluation Goal:</b></td><td></td><td></td></tr>
                                                                                                                                        <tr id="textmanagersMid"><td></td><td colspan="6" ><textarea id="managerMidYearSelfAssesssmentGoal" type="Text" class="form-control" required="true"></textarea></td><td></td></tr>
                                                                                                                                        <tr id="employeesEnd"><td></td><td colspan="6" ><b>Employee’s End - Year Self – Assessment Goal:</b></td><td></td><td></td></tr>
                                                                                                                                        <tr id="textemployeesEnd"><td></td><td colspan="6" ><textarea id="" type="Text" class="form-control"></textarea></td><td></td><td></td></tr>
                                                                                                                                        <tr id="managersEnd"><td></td><td colspan="6" ><b>Manager’s End - Year Review / Evaluation Goal:</b></td><td></td><td></td></tr>
                                                                                                                                        <tr id="textmanagersEnd"><td></td><td colspan="6" ><textarea id="" type="Text" class="form-control" required="true"></textarea></td><td></td><td></td></tr>-->

                                                                    <tr id="employeesMid">
                                                                        <td colspan="4"><b>Employee’s Mid - Year Self – Assessment KRA:</b></td>
                                                                        <td colspan="4"><b>Manager’s Mid - Year Review / Evaluation KRA:</b></td>
                                                                    </tr>
                                                                    <tr id="textemployeesMid">
                                                                        <td colspan="4"><textarea id="employeeMidYearSelfAssesssmentGoal1" name="employeeMidYearSelfAssesssmentGoal1" type="Text" class="form-control"></textarea></td>
                                                                        <td colspan="4"><textarea id="managerMidYearSelfAssesssmentGoal1" name="managerMidYearSelfAssesssmentGoal1" type="Text" class="form-control"></textarea></td>
                                                                    </tr>

                                                                    <tr id="employeesEnd">
                                                                        <td colspan="4"><b>Employee’s End - Year Self – Assessment KRA:</b></td>
                                                                        <td colspan="4"><b>Manager’s End - Year Review / Evaluation KRA:</b></td>
                                                                    </tr>
                                                                    <tr id="textemployeesEnd">
                                                                        <td colspan="4"><textarea id="employeeEndYearSelfAssesssmentGoal1" name="employeeEndYearSelfAssesssmentGoal1" type="Text" class="form-control"></textarea></td>
                                                                        <td colspan="4"><textarea id="managerEndYearSelfAssesssmentGoal1" name="managerEndYearSelfAssesssmentGoal1" type="Text" class="form-control"></textarea></td>
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
                                                                <td style="margin: 0px;width: 285px;" align="right" id="weightageScoreId"><b>Weightage</b></td>
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
                                                        <!--                                                        <div class="table-responsive">
                                                                                                                    <table id="demo1" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                                                                                        <tr>
                                                                                                                            <td id="employeesMidOtherActivity"><b>Employee’s Mid - Year Self – Assessment For Other Activities:</b></td>
                                                                                                                            <td id="managersMidOtherActivity"><b>Manager’s Mid - Year Review / Evaluation For Other Activities:</b></td>
                                                                                                                        </tr>
                                                                                                                        <tr>
                                                                                                                            <td id="employeesMidOtherActivity1"><textarea id="empMidyearSelfassOtheractivty" name="empMidyearSelfassOtheractivty" class="form-control">${empMidyearSelfassOtheractivty}</textarea></td>
                                                                                                                        <td id="managersMidOtherActivity1"><textarea id="managerMidyearReviewevalOtheractivity" name="managerMidyearReviewevalOtheractivity" class="form-control">${managerMidyearReviewevalOtheractivity}</textarea></td>
                                                                                                                    </tr>
                                                                                                                    <tr>
                                                                                                                        <td id="employeesEndOtherActivity"><b>Employee’s End - Year Self – Assessment For Other Activities:</b></td>
                                                                                                                        <td id="managersEndOtherActivity"><b>Manager’s End - Year Review / Evaluation For Other Activities:</b></td>
                                                                                                                    </tr>
                                                                                                                    <tr>
                                                                                                                        <td id="employeesEndOtherActivity1"><textarea name="empEndyearSelfassOtheractivty" id="empEndyearSelfassOtheractivty" class="form-control">${empEndyearSelfassOtheractivty}</textarea></td>
                                                                                                                        <td id="managersEndOtherActivity1"><textarea name="managerEndyearReviewevalOtheractivity" id="managerEndyearReviewevalOtheractivity" class="form-control">${managerEndyearReviewevalOtheractivity}</textarea></td>
                                                                                                                    </tr>
                                                                                                                </table>

                                                                                                            </div>-->

                                                </div>

                                                <div class="modal fade bs-example-modal-lg" id="kraModel" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
                                                    <div class="modal-dialog modal-lg">
                                                        <div class="modal-content">
                                                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only"></span></button>
                                                            <h4 class="modal-title" id="myModalLabel">History Detail</h4>
                                                            <div class="table-responsive">
                                                                <table id="modeldemo" class="table table-bordered table-striped table-hover" style="" align="Center">

                                                                </table>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="modal fade bs-example-modal-lg" id="deletedKraModel" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
                                                    <div class="modal-dialog modal-lg">
                                                        <div class="modal-content">
                                                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only"></span></button>
                                                            <h4 class="modal-title" id="myModalLabel">History Detail</h4>
                                                            <div class="table-responsive">
                                                                <table id="deletedKraDemo" class="table table-bordered table-striped table-hover" style="" align="Center">

                                                                </table>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div><!-- /.box-body -->
                                        </div>
                                    </div>



                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">Additional Activities / Projects:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId7">Expand</span><button class="btn btn-box-tool" id="btn3" data-widget="collapse" onclick="buttonFun7();"><i class="fa fa-plus" id="minusId7" ></i></button>
                                                <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                            </div>
                                        </div><!-- /.box-header -->

                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="table-responsive">
                                                        <table id="demo10" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                            <tr>

                                                            <input type="hidden" name="status1" id="status1" value="${status}">

                                                            <input type="hidden" id="managerStatus" name="managerStatus" value="${managerStatus}">
                                                            <input type="hidden" id="employeeStatus" name="employeeStatus" value="${employeeStatus}">
                                                            <input type="hidden" name="kraremovedActivitiesIdVal" id="kraremovedActivitiesIdVal" value="">

                                                            <input type="hidden" name="weightage" id="weightage" value="${weightage}">

                                                            <th style="text-align: center">Sr. No.</th>


                                                            <th style="text-align: center" id="kraGoalid1">Additional Activities / Projects</th>
                                                            <th style="text-align: center" id="metricid1">Metric</th>
                                                            <th style="text-align: center" id="metricid1">Project Category</th>

                                                            <th style="margin: 0px;width: 25px;text-align: center;" id="">Priority</th>

                                                            <th style="margin: 0px;width: 70px;text-align: center" id="midYearDivid">Mid Year Status</th>
                                                            <th style="margin: 0px;width: 70px;text-align: center" id="endYearDivid1">End Year Status</th>
                                                            <th style="margin: 0px;width: 25px;text-align: center" id="finalScoreid01">Activity/Project Performance</th>
                                                            <th style="text-align: center;width: 50px" id="editT">Edit<br><a href="#" title="Deleted Activities" data-toggle="modal" data-target="#deletedActivityModel" onclick="deletedActivitiesajaxfun('${appraisalId}');">Activities</a></th>
                                                            <th style="text-align: center;width: 50px"><span style='margin-top: 5px;'>
                                                                    <c:if test="${flag ne 'true' && flag1 ne 'true' && flag2 ne 'true'}">
                                                                        <input type="button" value="+" id="addactivityRowButtonId" disabled="true" title="Add New" />
                                                                    </c:if>
                                                                    <c:if test="${flag eq 'true' || flag1 eq 'true' || flag2 eq 'true'}">
                                                                        <input type="button" value="+" id="addactivityRowButtonId" title="Add New" />
                                                                    </c:if>
                                                                </span></th>

                                                            </tr>
                                                            <input type="hidden" name="kragoalLengthactivity" id="kragoalLengthactivity" value="${fn:length(kragoalOtherActivity)}">

                                                            <c:choose>
                                                                <c:when test="${fn:length(kragoalOtherActivity) > 0}">
                                                                    <input type="hidden" name="countactivityId" id="countactivityId" value="${fn:length(kragoalOtherActivity)}">
                                                                    <c:set var="kragoalOtherActivitySize" value="${fn:length(kragoalOtherActivity)}"></c:set>
                                                                    <c:forEach var="kragoalOtherActivity" items="${kragoalOtherActivity}" varStatus="status">
                                                                        <%--<c:if test="${kragoallist.kragoal_activity ne '' && kragoallist.metric_activity ne ''}">--%>
                                                                        <tr id="activitiesTrId${status.count}">
                                                                        <input type="hidden" name="kragoal_activity_id${status.count}" id="kragoal_activity_id${status.count}" value="${kragoalOtherActivity.id}">
                                                                        <td id="removeKRAactivitiesID${status.count}" class="removeactivitiesClass" style="margin: 0px;width: 45px;">${status.count} </td>
                                                                        <td id=""><textarea type="Text" name="kraGoal_activity${status.count}" id="kraGoal_activity${status.count}"  class="form-control saveRequried">${kragoalOtherActivity.kraGoalActivitiesManager}</textarea></td>
                                                                        <td id=""><textarea type="Text" name="metric_activity${status.count}" id="metric_activity${status.count}" class="form-control saveRequried">${kragoalOtherActivity.metricActivitiesManager}</textarea></td>
                                                                        <td id="kraCategoryId${status.count}">
                                                                            <select id="kraCategoryMapOther${status.count}" name="kraCategoryMapOther${status.count}" class="form-control saveRequried" >
                                                                                <option value="">--SELECT--</option>
                                                                                <c:forEach var="kraCategory" items="${kraCategoryMap}">
                                                                                    <c:if test="${kragoalOtherActivity.kraCategoryByManagerActivities eq kraCategory.key}">
                                                                                        <option value="${kraCategory.key}" selected="">${kraCategory.value}</option>
                                                                                    </c:if>
                                                                                    <c:if test="${kragoalOtherActivity.kraCategoryByManagerActivities ne kraCategory.key}">
                                                                                        <option value="${kraCategory.key}">${kraCategory.value}</option>
                                                                                    </c:if>
                                                                                </c:forEach>
                                                                            </select>
                                                                        </td>
                                                                        <td id="priorityid${status.count}">
                                                                            <select id="priority${status.count}" name="priority${status.count}" value="${kragoalOtherActivity.managerPriority}" class="form-control saveRequried" style="margin: 0px;width: 115px;">
                                                                                <option value="">--SELECT--</option>
                                                                                <c:choose>
                                                                                    <c:when test="${kragoalOtherActivity.managerPriority eq 'High Priority'}">

                                                                                        <option value="High Priority" selected="">High Priority</option>
                                                                                    </c:when>
                                                                                    <c:otherwise>

                                                                                        <option value="High Priority">High Priority</option>
                                                                                    </c:otherwise>
                                                                                </c:choose>
                                                                                <c:choose>
                                                                                    <c:when test="${kragoalOtherActivity.managerPriority eq 'Medium Priority'}">

                                                                                        <option value="Medium Priority" selected="">Medium Priority</option>
                                                                                    </c:when>
                                                                                    <c:otherwise>

                                                                                        <option value="Medium Priority">Medium Priority</option>
                                                                                    </c:otherwise>
                                                                                </c:choose>
                                                                                <c:choose>
                                                                                    <c:when test="${kragoalOtherActivity.managerPriority eq 'Low Priority'}">

                                                                                        <option value="Low Priority" selected="">Low Priority</option>
                                                                                    </c:when>
                                                                                    <c:otherwise>

                                                                                        <option value="Low Priority">Low Priority</option>
                                                                                    </c:otherwise>
                                                                                </c:choose>

                                                                            </select>
                                                                        </td>
                                                                        <td id="midYearDivid1${status.count}"><div>
                                                                                <select id="midYearDivOther${status.count}" name="midYearDivOther${status.count}" value="${kragoalOtherActivity.midyearStatusActivitiesManager}" style="margin: 0px;width: 96px;" class="form-control saveRequried">

                                                                                    <option value="">SELECT</option>
                                                                                    <c:choose>
                                                                                        <c:when test="${kragoalOtherActivity.midyearStatusActivitiesManager eq 'Yet to Start'}">

                                                                                            <option value="Yet to Start" selected="">Yet to Start</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>

                                                                                            <option value="Yet to Start">Yet to Start</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                    <c:choose>
                                                                                        <c:when test="${kragoalOtherActivity.midyearStatusActivitiesManager eq 'In Progress'}">

                                                                                            <option value="In Progress" selected="">In Progress</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>

                                                                                            <option value="In Progress">In Progress</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                    <c:choose>
                                                                                        <c:when test="${kragoalOtherActivity.midyearStatusActivitiesManager eq 'Completed'}">

                                                                                            <option value="Completed" selected="">Completed</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>

                                                                                            <option value="Completed">Completed</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                    <c:choose>
                                                                                        <c:when test="${kragoalOtherActivity.midyearStatusActivitiesManager eq 'Canceled'}">

                                                                                            <option value="Canceled" selected="">Canceled</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>

                                                                                            <option value="Canceled">Canceled</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                </select>
                                                                        </td>
                                                                        <td id="endYearDivid1${status.count}"><div>
                                                                                <select id="endYearDivOther${status.count}" name="endYearDivOther${status.count}" value="${kragoalOtherActivity.endyearStatusActivitiesManager}" style="margin: 0px;width: 96px;" class="form-control saveRequried">

                                                                                    <option value="">SELECT</option>
                                                                                    <c:choose>
                                                                                        <c:when test="${kragoalOtherActivity.endyearStatusActivitiesManager eq 'Yet to Start'}">

                                                                                            <option value="Yet to Start" selected="">Yet to Start</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>

                                                                                            <option value="Yet to Start">Yet to Start</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                    <c:choose>
                                                                                        <c:when test="${kragoalOtherActivity.endyearStatusActivitiesManager eq 'In Progress'}">

                                                                                            <option value="In Progress" selected="">In Progress</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>

                                                                                            <option value="In Progress">In Progress</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                    <c:choose>
                                                                                        <c:when test="${kragoalOtherActivity.endyearStatusActivitiesManager eq 'Completed'}">

                                                                                            <option value="Completed" selected="">Completed</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>

                                                                                            <option value="Completed">Completed</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                    <c:choose>
                                                                                        <c:when test="${kragoalOtherActivity.endyearStatusActivitiesManager  eq 'Canceled'}">

                                                                                            <option value="Canceled" selected="">Canceled</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>

                                                                                            <option value="Canceled">Canceled</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                </select>
                                                                            </div>
                                                                        </td>


                                                                        <td id="activityDivid1${status.count}"><div>
                                                                                <select id="activity${status.count}" name="activity${status.count}" value="${kragoalOtherActivity.managerActivity}" style="margin: 0px;width: 115px;" class="form-control saveRequried">
                                                                                    <option value="">SELECT</option>
                                                                                    <c:choose>
                                                                                        <c:when test="${kragoalOtherActivity.managerActivity eq 'Excellent'}">

                                                                                            <option value="Excellent" selected="">Excellent</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>

                                                                                            <option value="Excellent">Excellent</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                    <c:choose>
                                                                                        <c:when test="${kragoalOtherActivity.managerActivity eq 'Very Good'}">

                                                                                            <option value="Very Good" selected="">Very Good</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>

                                                                                            <option value="Very Good">Very Good</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                    <c:choose>
                                                                                        <c:when test="${kragoalOtherActivity.managerActivity eq 'Good'}">

                                                                                            <option value="Good" selected="">Good</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>

                                                                                            <option value="Good">Good</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                    <c:choose>
                                                                                        <c:when test="${kragoalOtherActivity.managerActivity eq 'Average'}">

                                                                                            <option value="Average" selected="">Average</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>

                                                                                            <option value="Average">Average</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                    <c:choose>
                                                                                        <c:when test="${kragoalOtherActivity.managerActivity eq 'Needs Improvement'}">

                                                                                            <option value="Needs Improvement" selected="">Needs Improvement</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>

                                                                                            <option value="Needs Improvement">Needs Improvement</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                </select>
                                                                            </div>
                                                                        </td>
                                                                        <td style="text-align: center" id="edit${status.count}"><span style='margin-top: 5px;' id="editC${status.count}">

                                                                                <button type="button" class="btns btn-warnings" id="EditByEmployeeact${status.count}" name="EditByEmployeeact" onclick="changeReadonlyOther('${status.count}')" style="width: 50px;" disabled="true">Edit</button>

                                                                            </span><br/>

                                                                            <input type="hidden" id="startDate${status.count}" name="startDate${status.count}" value="${kragoallist.startDate}">
                                                                            <c:if test="${appraisalPerformanceMaster.getManagerStatus() ne 0 and updateStatus}">

                                                                                <a href="" data-toggle="modal" data-target="#kraotherActivity" onclick="managerhistoryajaxfunOtherActivity('${kragoalOtherActivity.id}');">History</a>
                                                                            </c:if>
                                                                        </td>
                                                                        <%--<c:if test="${status.last}">--%>
                                                                        <!--<td style="text-align: center">-->
                                                                        <!--<span style='margin-top: 5px;'>-->
                                                                        <%--<c:if test="${flag ne 'true' && flag1 ne 'true' && flag2 ne 'true'}">--%>
                                                                        <!--<input type="button" value="+" id="addactivityRowButtonId" disabled="true" />-->
                                                                        <%--</c:if>--%>
                                                                        <%--<c:if test="${flag eq 'true' || flag1 eq 'true' || flag2 eq 'true'}">--%>
                                                                        <!--<input type="button" value="+" id="addactivityRowButtonId" />-->
                                                                        <%--</c:if>--%>
                                                                        <!--</span>-->
                                                                        <!--</td>-->
                                                                        <%--</c:if>--%>
                                                                        <%--<c:if test="${!status.last}">--%>
                                                                        <td id="" style="text-align: center">
                                                                            <span style="margin-top: 5px;">
                                                                                <c:if test="${(flag eq 'true' || flag1 eq 'true' || flag2 eq 'true' && Finalstatus eq '0') && kragoalOtherActivitySize > 1}">
                                                                                    <input type="button" value="-" id="removeRowButtonId" onclick="removeActivityChild('activitiesTrId${status.count}', 'activitiesEmpMidLabel1TrId${status.count}', 'activitiesEmpMid1TrId${status.count}', 'activitiesEmpMidLabel2TrId${status.count}', 'activitiesEmpMid2TrId${status.count}', '${kragoalOtherActivity.id}');">
                                                                                </c:if>
                                                                            </span>
                                                                        </td>
                                                                        <%--</c:if>--%>
                                                                        </tr>

                                                                        <tr id="activitiesEmpMidLabel1TrId${status.count}">
                                                                            <td colspan="4"><b>Employee’s Mid - Year Self – Assessment For Other Project:</b></td>
                                                                            <td colspan="4"><b>Manager’s Mid - Year Review / Evaluation For Other Project:</b></td>
                                                                        </tr>
                                                                        <tr id="activitiesEmpMid1TrId${status.count}">
                                                                            <td colspan="4"><textarea id="empMidyearSelfassessmentGoalActivities${status.count}" style="width: 474px;" name="empMidyearSelfassessmentGoalActivities${status.count}" type="Text" class="form-control saveRequried">${kragoalOtherActivity.empMidyearSelfassessmentGoalActivitiesManager}</textarea></td>
                                                                            <td colspan="4"><textarea id="managerMidYearSelfAssesssmentGoalActivities${status.count}" style="width: 474px;" name="managerMidYearSelfAssesssmentGoalActivities${status.count}" type="Text" class="form-control saveRequried">${kragoalOtherActivity.managerMidyearSelfassesssmentGoalActivitiesManager}</textarea></td>
                                                                        </tr>

                                                                        <tr id="activitiesEmpMidLabel2TrId${status.count}">
                                                                            <td colspan="4"><b>Employee’s End - Year Self – Assessment For Other Project:</b></td>
                                                                            <td colspan="4"><b>Manager’s End - Year Review / Evaluation For Other Project:</b></td>
                                                                        </tr>
                                                                        <tr id="activitiesEmpMid2TrId${status.count}">
                                                                            <td colspan="4"><textarea id="empEndyearSelfassessmentGoalActivities${status.count}" style="width: 474px;" name="empEndyearSelfassessmentGoalActivities${status.count}" type="Text" class="form-control saveRequried">${kragoalOtherActivity.empEndyearSelfassessmentGoalActivitiesManager}</textarea></td>
                                                                            <td colspan="4"><textarea id="managerEndYearSelfAssesssmentGoalActivities${status.count}" style="width: 474px;" name="managerEndYearSelfAssesssmentGoalActivities${status.count}" type="Text" class="form-control saveRequried">${kragoalOtherActivity.managerEndyearSelfassesssmentGoalActivitiesManager}</textarea></td>
                                                                        </tr>

                                                                    </c:forEach>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <tr>
                                                                        <td style="margin: 0px;width: 45px;">1</td>
                                                                        <%--<c:if test="${flag eq true}">--%>
                                                                    <input type="hidden" name="countactivityId" id="countactivityId" value="1">
                                                                    <!--<td id="kraGoalid"><textarea type="Text" name="kraGoal1" id="kraGoal1" class="form-control"></textarea></td>-->
                                                                    <td id=""><textarea type="Text" name="kraGoal_activity1" id="kraGoal_activity1"  class="form-control saveRequried"></textarea></td>
                                                                    <td id=""><textarea type="Text" name="metric_activity1" id="metric_activity1" class="form-control saveRequried"></textarea></td>
                                                                    <td id="kraCategoryId">
                                                                        <select id="kraCategoryMap1" name="kraCategoryMap1" class="form-control saveRequried" style="margin: 0px;width: 115px;">
                                                                            <option value="">--SELECT--</option>
                                                                            <c:forEach var="kraCategory" items="${kraCategoryMap}">
                                                                                <option value="${kraCategory.key}">${kraCategory.value}</option>
                                                                            </c:forEach>
                                                                        </select>
                                                                    </td>
                                                                    <td id="priorityid">
                                                                        <select id="priority1" name="priority1" class="form-control saveRequried" style="margin: 0px;width: 115px;">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="High Priority">High Priority</option>
                                                                            <option value="Medium Priority">Medium Priority</option>
                                                                            <option value="Low Priority">Low Priority</option>
                                                                        </select>
                                                                    </td>
                                                                    <td id="midYearDividact1"><div>
                                                                            <select id="midYearDivOther1" name="midYearDivOther1" class="form-control saveRequried" style="margin: 0px;width: 115px;">
                                                                                <option value="">--SELECT--</option>
                                                                                <option value="Yet to Start">Yet to Start</option>
                                                                                <option value="In Progress">In Progress</option>
                                                                                <option value="Completed">Completed</option>
                                                                                <option value="Canceled">Canceled</option>
                                                                            </select>
                                                                        </div>
                                                                    </td>
                                                                    <td id="endYearDividact"><div>
                                                                            <select id="endYearDivOther1" name="endYearDivOther1" class="form-control saveRequried" style="margin: 0px;width: 115px;">
                                                                                <option value="">--SELECT--</option>
                                                                                <option value="Yet to Start">Yet to Start</option>
                                                                                <option value="In Progress">In Progress</option>
                                                                                <option value="Completed">Completed</option>
                                                                                <option value="Canceled">Canceled</option>
                                                                            </select>
                                                                        </div>
                                                                    </td>
                                                                    <td id="">
                                                                        <select id="activity1" name="activity1" class="form-control saveRequried" style="margin: 0px;width: 115px;">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="Excellent">Excellent</option>
                                                                            <option value="Very Good">Very Good</option>
                                                                            <option value="Good">Good</option>
                                                                            <option value="Average">Average</option>
                                                                            <option value="Needs Improvement">Needs Improvement</option>
                                                                        </select>
                                                                    </td>

                                                                    <td style="text-align: center" id="edit"><span style='margin-top: 5px;'><button type="button" class="btns btn-warnings" style="width: 50px;">Edit</button></span><br/>
                                                                    </td>
                                                                    <input type="hidden" id="startDate1" name="startDate1" value="${kragoal[0].startDate}">
                                                                    <td style="text-align: center">
                                                                        <!--<span style='margin-top: 5px;'>-->
                                                                        <!--<input type="button" value="+" id="addactivityRowButtonId" />-->
                                                                        <!--</span>-->
                                                                    </td>


                                                                    <tr id="employeesMid">
                                                                        <td colspan="4"><b>Employee’s Mid - Year Self – Assessment For Other Project:</b></td>
                                                                        <td colspan="4"><b>Manager’s Mid - Year Review / Evaluation For Other Project:</b></td>
                                                                    </tr>
                                                                    <tr id="textemployeesMid">
                                                                        <td colspan="4"><textarea id="empMidyearSelfassessmentGoalActivities1" style="width: 474px;" name="empMidyearSelfassessmentGoalActivities1" type="Text" class="form-control saveRequried"></textarea></td>
                                                                        <td colspan="4"><textarea id="managerMidYearSelfAssesssmentGoalActivities1" style="width: 474px;" name="managerMidYearSelfAssesssmentGoalActivities1" type="Text" class="form-control saveRequried"></textarea></td>
                                                                    </tr>

                                                                    <tr id="employeesEnd">
                                                                        <td colspan="4"><b>Employee’s End - Year Self – Assessment For Other Project:</b></td>
                                                                        <td colspan="4"><b>Manager’s End - Year Review / Evaluation For Other Project:</b></td>
                                                                    </tr>
                                                                    <tr id="textemployeesEnd">
                                                                        <td colspan="4"><textarea id="empEndyearSelfassessmentGoalActivities1" style="width: 474px;" name="empEndyearSelfassessmentGoalActivities1" type="Text" class="form-control saveRequried"></textarea></td>
                                                                        <td colspan="4"><textarea id="managerEndYearSelfAssesssmentGoalActivities1" style="width: 474px;" name="managerEndYearSelfAssesssmentGoalActivities1" type="Text" class="form-control saveRequried"></textarea></td>
                                                                    </tr>

                                                                </c:otherwise>
                                                            </c:choose>
                                                        </table>
                                                    </div>

                                                </div>
                                                <div class="modal fade bs-example-modal-lg" tabindex="-1" id="kraotherActivity" role="dialog" aria-labelledby="myLargeModalLabel">
                                                    <div class="modal-dialog modal-lg">
                                                        <div class="modal-content">
                                                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only"></span></button>
                                                            <h4 class="modal-title" id="myModalLabel">History Detail</h4>
                                                            <div class="table-responsive">
                                                                <table id="modeldemo1" class="table table-bordered table-striped table-hover" style="" align="Center">

                                                                </table>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="modal fade bs-example-modal-lg" id="deletedActivityModel" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
                                                    <div class="modal-dialog modal-lg">
                                                        <div class="modal-content">
                                                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only"></span></button>
                                                            <h4 class="modal-title" id="myModalLabel">History Detail</h4>
                                                            <div class="table-responsive">
                                                                <table id="deletedActivitydemo" class="table table-bordered table-striped table-hover" style="" align="Center">

                                                                </table>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>



                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">Competency Evaluation (As Per Zydex Competency Framework) : ${competencyEvaluationList[0][2].title}</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId3">Expand</span><button class="btn btn-box-tool" id="btn4" data-widget="collapse" onclick="buttonFun3();"><i class="fa fa-plus" id="minusId3" ></i></button>
                                                <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <%--<c:if test="${empty competencyEvaluationList[0][2].title && managerStatus eq '0'}">--%>
                                                    <%--<c:if test="${managerStatus eq '0' || sessionScope.user.userName eq 'admin' || empty competencyEvaluationList[0][2].title}">--%>
                                                        <div>
                                                            <select name="competencyEvaluationId" id="competencyEvaluationId" value="${competencyMap.key}" class="form-control" onchange="managerajaxfun();"/>
                                                            <option value="">--SELECT--</option>
                                                            <c:forEach var="competencyMap" items="${competencyMap}">
                                                                <c:if test="${competencyEvaluationList[0][2].title eq competencyMap.value}">
                                                                    <option value="${competencyMap.key}" selected="">${competencyMap.value}</option>
                                                                </c:if>
                                                                <c:if test="${competencyEvaluationList[0][2].title ne competencyMap.value}">
                                                                    <option value="${competencyMap.key}">${competencyMap.value}</option>
                                                                </c:if>

                                                            </c:forEach>
                                                            </select>
                                                        </div>
                                                    <%--</c:if>--%>
                                                    <%--<c:if test="${!empty competencyEvaluationList[0][2].title && managerStatus eq '1' && sessionScope.user.userName ne 'admin' && !empty competencyEvaluationList[0][2].title}">--%>
                                                        <!--<div><input type="text" id="competencyEvaluationId" class="form-control" name="competencyEvaluationId" value="${competencyEvaluationList[0][2].title}" readonly="true"></div>-->
                                                        <%--</c:if>--%>
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
                                                                <!--<input type="hidden" name="compentencyTextMasterId${status.count}" id="compentencyTextMasterId${status.count}" value="${competencyEvaluationList[1].id}">-->
                                                                <input type="hidden" name="competencyEvaluationId${status.count}" id="competencyEvaluationId${status.count}" value="${competencyEvaluationList[2].id}">
                                                                <input type="hidden" name="compentencyTextMasterId${status.count}" id="compentencyTextMasterId${status.count}" value="${competencyEvaluationList[3].id}">
                                                                <tr class="">
                                                                    <td id="subCompentencySrId${status.count}">${status.count}</td>
                                                                    <!--<td><input type="text" id="demo" name="demo"></td>-->
                                                                    <!--<td>$/{competencyEvaluationList[0][4].infoText}</td>-->
                                                                    <td id="subCompentencyTitleId${status.count}">${competencyEvaluationList[4]}</td>
                                                                    <td id="subCompentencyStartId${status.count}" >

                                                                        <select id="competencyStartYear${status.count}" name="compentencyStartYear${status.count}" value="${competencyEvaluationList[11]}" class="form-control" >
                                                                            <option value="">--SELECT--</option>
                                                                            <c:choose>
                                                                                <c:when test="${competencyEvaluationList[11] eq 'Exceed Expectations'}">

                                                                                    <option value="Exceed Expectations" selected="">Exceed Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="Exceed Expectations">Exceed Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${competencyEvaluationList[11] eq 'Meet Expectations'}">

                                                                                    <option value="Meet Expectations" selected="">Meet Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="Meet Expectations">Meet Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${competencyEvaluationList[11] eq 'Need Improvement'}">

                                                                                    <option value="Need Improvement" selected="">Need Improvement</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="Need Improvement">Need Improvement</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </select>
                                                                    </td>
                                                                    <td id="subCompentencyStartRemarkId${status.count}">
                                                                        <textarea type="Text" id="compentencyStartRemark${status.count}" name="compentencyStartRemark${status.count}" class="form-control" rows="4">${competencyEvaluationList[12]}</textarea>
                                                                    </td>
                                                                    <td id="subCompentencyMidId${status.count}">
                                                                        <select id="compentencyMidYear${status.count}" name="compentencyMidYear${status.count}" value="${competencyEvaluationList[7]}" class="form-control">
                                                                            <option value="">--SELECT--</option>
                                                                            <c:choose>
                                                                                <c:when test="${competencyEvaluationList[7] eq 'Exceed Expectations'}">

                                                                                    <option value="Exceed Expectations" selected="">Exceed Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="Exceed Expectations">Exceed Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${competencyEvaluationList[7] eq 'Meet Expectations'}">

                                                                                    <option value="Meet Expectations" selected="">Meet Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="Meet Expectations">Meet Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${competencyEvaluationList[7] eq 'Need Improvement'}">

                                                                                    <option value="Need Improvement" selected="">Need Improvement</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="Need Improvement">Need Improvement</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </select>
                                                                    </td>
                                                                    <td id="subCompentencyMidRemarkId${status.count}" >
                                                                        <textarea type="Text" id="compentencyMidRemark${status.count}" name="compentencyMidRemark${status.count}" class="form-control" rows="4">${competencyEvaluationList[8]}</textarea>
                                                                    </td>
                                                                    <td id="subCompentencyEndId${status.count}">
                                                                        <select id="compentencyEndYear${status.count}" name="compentencyEndYear${status.count}" value="${competencyEvaluationList[9]}" class="form-control">
                                                                            <option value="">--SELECT--</option>
                                                                            <c:choose>
                                                                                <c:when test="${competencyEvaluationList[9] eq 'Exceed Expectations'}">

                                                                                    <option value="Exceed Expectations" selected="">Exceed Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="Exceed Expectations">Exceed Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${competencyEvaluationList[9] eq 'Meet Expectations'}">

                                                                                    <option value="Meet Expectations" selected="">Meet Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="Meet Expectations">Meet Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${competencyEvaluationList[9] eq 'Need Improvement'}">

                                                                                    <option value="Need Improvement" selected="">Need Improvement</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="Need Improvement">Need Improvement</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </select>
                                                                    </td>
                                                                    <td id="subCompentencyEndRemarkId${status.count}">
                                                                        <textarea type="Text" id="compentencyEndRemark${status.count}" name="compentencyEndRemark${status.count}" class="form-control" rows="4">${competencyEvaluationList[10]}</textarea>
                                                                    </td>

                                                                </tr>

                                                            </c:forEach>

                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </div><!-- /.box-body -->
                                    </div>


                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">Individual Development Plan(Training Need Identification):</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId4">Expand</span><button class="btn btn-box-tool" id="btn5" data-widget="collapse" onclick="buttonFun4();"><i class="fa fa-plus" id="minusId4" ></i></button>
                                                <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                            </div>
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
                                                                <th style="text-align: center"></th>
                                                                <th style="text-align: center">Add New</th>
                                                            </tr>
                                                            <tr>
                                                            <input type="hidden" name="IndividualId" id="IndividualId" value="${fn:length(individualDevelopmentPlanList)}">
                                                            <input type="hidden" name="kraremovedIndividualIdVal" id="kraremovedIndividualIdVal" value="">
                                                            <c:choose>
                                                                <c:when test="${not empty individualDevelopmentPlanList}">

                                                                    <c:forEach var="individualDevelopmentPlan" items="${individualDevelopmentPlanList}" varStatus="status">
                                                                        <tr id="individualTrId${status.count}">
                                                                            <td id="removeKRAIndividualID${status.count}" name="removeKRAIndividualID${status.count}" style="text-align: center">${status.count}</td>
                                                                        <input type="hidden" name="IndividualDevelopmentPlanId${status.count}" id="IndividualDevelopmentPlanId${status.count}" value="${individualDevelopmentPlan.id}">
                                                                        <td id="indDevId"><textarea type="Text" id="text${status.count}" name="text${status.count}" class="form-control saveRequried">${individualDevelopmentPlan.managertext1}</textarea></td>
                                                                        <td><div>
                                                                                <select id="individualtextDiv${status.count}" name="individualtextDiv${status.count}" value="${individualDevelopmentPlan.managertext2}" class="form-control saveRequried">
                                                                                    <option value="">--SELECT--</option>
                                                                                    <c:choose>
                                                                                        <c:when test="${individualDevelopmentPlan.managertext2 eq 'Technical'}">

                                                                                            <option value="Technical" selected="">Technical</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>

                                                                                            <option value="Technical">Technical</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                    <c:choose>
                                                                                        <c:when test="${individualDevelopmentPlan.managertext2 eq 'Other'}">

                                                                                            <option value="Other" selected="">Other</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>

                                                                                            <option value="Other">Other</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                    <c:choose>
                                                                                        <c:when test="${individualDevelopmentPlan.managertext2 eq 'Soft Skill'}">

                                                                                            <option value="Soft Skill" selected="">Soft Skill</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>
                                                                                            <option value="Soft Skill">Soft Skill</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>

                                                                                </select>
                                                                            </div>
                                                                        </td>
                                                                        <td><div>
                                                                                <select id="trainingSelectId${status.count}" name="trainingSelectId${status.count}" value="${individualDevelopmentPlan.managertext3}" class="form-control saveRequried" onchange="trainingSelect(${status.count});">
                                                                                    <option value="">--SELECT--</option>
                                                                                    <c:choose>
                                                                                        <c:when test="${individualDevelopmentPlan.managertext3 eq 'On The Job Training'}">

                                                                                            <option value="On The Job Training" selected="">On The Job Training</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>

                                                                                            <option value="On The Job Training">On The Job Training</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                    <c:choose>
                                                                                        <c:when test="${individualDevelopmentPlan.managertext3 eq 'Classroom Training'}">

                                                                                            <option value="Classroom Training" selected="">Classroom Training</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>

                                                                                            <option value="Classroom Training">Classroom Training</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                    <c:choose>
                                                                                        <c:when test="${individualDevelopmentPlan.managertext3 eq 'Other'}">

                                                                                            <option value="Other" selected="">Other</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>

                                                                                            <option value="Other">Other</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>

                                                                                </select>
                                                                            </div>
                                                                        </td>
                                                                        <td><div>
                                                                                <textarea class="form-control saveRequried" id="trainingSelectTextinput${status.count}" name="trainingSelectTextinput${status.count}" style="display: none">${individualDevelopmentPlan.managerremark}</textarea>
                                                                            </div>
                                                                        </td>
                                                                        <c:if test="${status.last}">

                                                                            <td style="text-align: center">
                                                                                <span style='margin-top: 5px;'>
                                                                                    <input type="button" value="+" id="addIndividualId" />
                                                                                </span>
                                                                            </td>
                                                                        </c:if>
                                                                        <c:if test="${!status.last}">
                                                                            <td id="" style="text-align: center">
                                                                                <span style="margin-top: 5px;">
                                                                                    <c:if test="${flag eq 'true' || flag1 eq 'true' || flag2 eq 'true'}">
                                                                                        <input type="button" value="-" id="removeRowButtonId" onclick="removeIndividualChild('individualTrId${status.count}', 'individualEmpMidLabel1TrId${status.count}', 'individualEmpMid1TrId${status.count}', 'individualEmpMidLabel2TrId${status.count}', 'individualEmpMid2TrId${status.count}', '${individualDevelopmentPlan.id}');">
                                                                                    </c:if>
                                                                                </span>
                                                                            </td>
                                                                        </c:if>
                                                                        </tr>
                                                                        <tr id="individualEmpMidLabel1TrId${status.count}">
                                                                            <td colspan="3" id="midYearReId${status.count}"><b>Employee Mid-Year Remark</b></td>
                                                                            <td colspan="3" id="endYearReId${status.count}"><b>Employee End-Year Remark</b></td>
                                                                        </tr>
                                                                        <tr id="individualEmpMid1TrId${status.count}">

                                                                            <td colspan="3" id="midYearRetxtId${status.count}"><textarea rows="3" style="width: 451px;" id="midYearRemark${status.count}" name="midYearRemark${status.count}" class="form-control saveRequried">${individualDevelopmentPlan.midYearRemark}</textarea></td>
                                                                            <td colspan="3" id="endYearRetxtId${status.count}"><textarea rows="3" style="width: 451px;" id="endYearRemark${status.count}" name="endYearRemark${status.count}" class="form-control saveRequried">${individualDevelopmentPlan.endYearRemark}</textarea></td>
                                                                        </tr>
                                                                        <tr id="individualEmpMidLabel2TrId${status.count}">
                                                                            <td colspan="3" id="endYearReId"><b>Manager Mid-Year Remark</b></td>
                                                                            <td colspan="3" id="endYearReId"><b>Manager End-Year Remark</b></td>
                                                                        </tr>
                                                                        <tr id="individualEmpMid2TrId${status.count}">

                                                                            <td colspan="3"><textarea rows="3" style="width: 451px;" id="managerMidYearRemark${status.count}" name="managerMidYearRemark${status.count}" class="form-control saveRequried">${individualDevelopmentPlan.managerMidYearRemark}</textarea></td>
                                                                            <td colspan="3"><textarea rows="3" style="width: 451px;" id="managerEndYearRemark${status.count}" name="managerEndYearRemark${status.count}" class="form-control saveRequried">${individualDevelopmentPlan.managerEndYearRemark}</textarea></td>
                                                                        </tr>
                                                                    </c:forEach>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <tr>
                                                                        <td style="text-align: center">1</td>
                                                                        <td><textarea type="Text" class="form-control saveRequried"></textarea></td>
                                                                        <td><div>
                                                                                <select id="individualtextDiv" name="individualtextDiv" class="form-control saveRequried">
                                                                                    <option value="">--SELECT--</option>
                                                                                    <option value="Technical">Technical</option>
                                                                                    <option value="Other">Other</option>
                                                                                    <option value="Soft Skill">Soft Skill</option>

                                                                                </select>
                                                                            </div>
                                                                        </td>
                                                                        <td><div>
                                                                                <select id="trainingSelectId1" name="trainingSelectId1" class="form-control saveRequried" onchange="trainingSelect(1)">
                                                                                    <option value="">--SELECT--</option>
                                                                                    <option value="On The Job Training">On The Job Training</option>
                                                                                    <option value="Classroom Training">Classroom Training</option>
                                                                                    <option value="Other">Other</option>
                                                                                </select>
                                                                            </div>
                                                                        </td>
                                                                        <td><div>
                                                                                <textarea class="form-control saveRequried" id="trainingSelectTextinput1" name="trainingSelectTextinput1" style="display: none"></textarea>
                                                                            </div>
                                                                        </td>
                                                                        <td style="text-align: center">
                                                                            <span style='margin-top: 5px;'>
                                                                                <input type="button" value="+" id="addIndividualId" />
                                                                            </span>
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td colspan="3" id="midYearReId"><b>Employee Mid-Year Remark</b></td>
                                                                        <td colspan="3" id="endYearReId"><b>Employee End-Year Remark</b></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td colspan="3"><textarea rows="3" id="midYearRemark" style="width: 451px;" name="midYearRemark" class="form-control saveRequried"></textarea></td>
                                                                        <td colspan="3"><textarea rows="3" id="endYearRemark" style="width: 451px;" name="endYearRemark" class="form-control saveRequried"></textarea></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td colspan="3" id="endYearReId"><b>Manager Mid-Year Remark</b></td>
                                                                        <td colspan="3" id="endYearReId"><b>Manager End-Year Remark</b></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td colspan="3"><textarea rows="3" id="managerMidYearRemark" style="width: 451px;" name="managerMidYearRemark" class="form-control saveRequried"></textarea></td>
                                                                        <td colspan="3"><textarea rows="3" id="managerEndYearRemark" style="width: 451px;" name="managerEndYearRemark" class="form-control saveRequried"></textarea></td>
                                                                    </tr>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </table>

                                                    </div>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>


                                    <!--                                    <div class="box box-info collapsed-box">
                                                                            <div class="box-header">
                                                                                <h3 class="box-title">Behaviors:</h3>
                                                                                <div class="box-tools pull-right">
                                                                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
                                                                                </div>
                                                                            </div> /.box-header
                                                                            <div class="box-body no-padding">
                                                                                <div class="row">
                                                                                    <div class="col-md-12 col-sm-12">
                                                                                        <div class="table-responsive">
                                                                                            <table id="demo" class="table table-bordered table-striped table-hover" style="" align="Center"  >

                                                                                                <tr style="background-color: darkgrey">
                                                                                                    <th style="text-align: center"><b>Behaviors</b></th>
                                                                                                    <th style="text-align: center">Mid'Year Score</th>
                                                                                                    <th style="text-align: center">End'Year Score</th>
                                                                                                </tr>
                                                                                                <tr style="background-color: lightgrey">
                                                                                                    <td><b>WLB 1: Walk the Talk </b><br>&nbsp;&nbsp;- Do & Act What you Preach<br>&nbsp;&nbsp;- Keep commitments<br>&nbsp;&nbsp;- Talk Straight – Be Honest & Tell the Truth<br>&nbsp;&nbsp;- Use simple language and call things what they are<br>&nbsp;&nbsp;- Don’t manipulate people nor distort facts</td>
                                                                                                    <td><select id="" class="form-control ">
                                                                                                            <option value="">--SELECT--</option>
                                                                                                            <option value="1">1</option>
                                                                                                            <option value="2">2</option>
                                                                                                            <option value="3">3</option>
                                                                                                            <option value="4">4</option>
                                                                                                            <option value="5">5</option>
                                                                                                        </select></td>
                                                                                                    <td><select id="" class="form-control ">
                                                                                                            <option value="">--SELECT--</option>
                                                                                                            <option value="1">1</option>
                                                                                                            <option value="2">2</option>
                                                                                                            <option value="3">3</option>
                                                                                                            <option value="4">4</option>
                                                                                                            <option value="5">5</option>
                                                                                                        </select></td>
                                                                                                </tr>
                                                                                                <tr style="background-color: lightgrey">
                                                                                                    <td><b>Manager’s Mid - Year Review / Evaluation</b></td>
                                                                                                    <td colspan="2"><textarea type="Text" class="form-control"></textarea></td>
                                                                                                </tr>
                                                                                                <tr style="background-color: lightgrey">
                                                                                                    <td><b>Manager’s End - Year Review / Evaluation</b></td>
                                                                                                    <td colspan="2"><textarea type="Text" class="form-control"></textarea></td>
                                                                                                </tr>
                                                                                                <tr style="background-color: lightgrey">
                                                                                                    <td><b>WLB 2: Deliver Results</b><br>&nbsp;&nbsp;- Master the art of execution & Establish a track record of results<br>&nbsp;&nbsp;- Practice Accountability – Hold self & others accountable<br>&nbsp;&nbsp;- Get the best out of you and your team<br>&nbsp;&nbsp;- Be on time and within budget<br>&nbsp;&nbsp;- Don’t find excuses for not delivering<br>&nbsp;&nbsp;- Celebrate success with the team</td>
                                                                                                    <td><select id="" class="form-control ">
                                                                                                            <option value="">--SELECT--</option>
                                                                                                            <option value="1">1</option>
                                                                                                            <option value="2">2</option>
                                                                                                            <option value="3">3</option>
                                                                                                            <option value="4">4</option>
                                                                                                            <option value="5">5</option>
                                                                                                        </select></td>
                                                                                                    <td><select id="" class="form-control ">
                                                                                                            <option value="">--SELECT--</option>
                                                                                                            <option value="1">1</option>
                                                                                                            <option value="2">2</option>
                                                                                                            <option value="3">3</option>
                                                                                                            <option value="4">4</option>
                                                                                                            <option value="5">5</option>
                                                                                                        </select></td>
                                                                                                </tr>
                                                                                                <tr style="background-color: lightgrey">
                                                                                                    <td><b>Manager’s Mid - Year Review / Evaluation</b></td>
                                                                                                    <td colspan="2"><textarea type="Text" class="form-control"></textarea></td>
                                                                                                </tr>
                                                                                                <tr style="background-color: lightgrey">
                                                                                                    <td><b>Manager’s End - Year Review / Evaluation</b></td>
                                                                                                    <td colspan="2"><textarea type="Text" class="form-control"></textarea></td>
                                                                                                </tr>
                                                                                                <tr style="background-color: lightgrey">
                                                                                                    <td><b>WLB 3: Build Relationships & Develop Others</b><br>&nbsp;&nbsp;- Be grounded at all times & approachable<br>&nbsp;&nbsp;- Treat people with utmost respect & care<br>&nbsp;- Understand other’s perspective & concern<br>&nbsp;&nbsp;- Invest in developing the talent<br>&nbsp;&nbsp;- Give your team the right opportunities to learn and grow<br>&nbsp;&nbsp;- Create a learning environment & help others to learn from success stories & failures<br>&nbsp;&nbsp; </td>
                                                                                                    <td><select id="" class="form-control ">
                                                                                                            <option value="">--SELECT--</option>
                                                                                                            <option value="1">1</option>
                                                                                                            <option value="2">2</option>
                                                                                                            <option value="3">3</option>
                                                                                                            <option value="4">4</option>
                                                                                                            <option value="5">5</option>
                                                                                                        </select></td>
                                                                                                    <td><select id="" class="form-control ">
                                                                                                            <option value="">--SELECT--</option>
                                                                                                            <option value="1">1</option>
                                                                                                            <option value="2">2</option>
                                                                                                            <option value="3">3</option>
                                                                                                            <option value="4">4</option>
                                                                                                            <option value="5">5</option>
                                                                                                        </select></td>
                                                                                                </tr>
                                                                                                <tr style="background-color: lightgrey">
                                                                                                    <td><b>Manager’s Mid - Year Review / Evaluation</b></td>
                                                                                                    <td colspan="2"><textarea type="Text" class="form-control"></textarea></td>
                                                                                                </tr>
                                                                                                <tr style="background-color: lightgrey">
                                                                                                    <td><b>Manager’s End - Year Review / Evaluation</b></td>
                                                                                                    <td colspan="2"><textarea type="Text" class="form-control"></textarea></td>
                                                                                                </tr>
                                                                                                <tr style="background-color: lightgrey">
                                                                                                    <td><b>WLB 4: Act with Courage</b><br>&nbsp;&nbsp;- Take a stand – have your individual opinion & stand by it<br>&nbsp;&nbsp;- Don’t shy away from conflicts<br>&nbsp;&nbsp;- Deal with the issues head on – never procrastinate<br>&nbsp;&nbsp;- Never bury your head in the sand<br>&nbsp;&nbsp;- Be direct & candid</td>
                                                                                                    <td><select id="" class="form-control ">
                                                                                                            <option value="">--SELECT--</option>
                                                                                                            <option value="1">1</option>
                                                                                                            <option value="2">2</option>
                                                                                                            <option value="3">3</option>
                                                                                                            <option value="4">4</option>
                                                                                                            <option value="5">5</option>
                                                                                                        </select></td>
                                                                                                    <td><select id="" class="form-control ">
                                                                                                            <option value="">--SELECT--</option>
                                                                                                            <option value="1">1</option>
                                                                                                            <option value="2">2</option>
                                                                                                            <option value="3">3</option>
                                                                                                            <option value="4">4</option>
                                                                                                            <option value="5">5</option>
                                                                                                        </select></td>
                                                                                                </tr>
                                                                                                <tr style="background-color: lightgrey">
                                                                                                    <td><b>Manager’s Mid - Year Review / Evaluation</b></td>
                                                                                                    <td colspan="2"><textarea type="Text" class="form-control"></textarea></td>
                                                                                                </tr>
                                                                                                <tr style="background-color: lightgrey">
                                                                                                    <td><b>Manager’s End - Year Review / Evaluation</b></td>
                                                                                                    <td colspan="2"><textarea type="Text" class="form-control"></textarea></td>
                                                                                                </tr>
                                                                                                <tr style="background-color: lightgrey">
                                                                                                    <td><b>WLB 5: Believe in Vision & Purpose</b><br>&nbsp;&nbsp;- Be Far-sighted & Look beyond the obvious<br>&nbsp;&nbsp;- Be Strategic – Have a macro & micro perspective, Innovate<br>&nbsp;&nbsp;- Be Entrepreneurial <br>&nbsp;&nbsp;- Communicate your Vision to your team<br>&nbsp;&nbsp;- Make sure everyone on board under stand's the purpose<br>&nbsp;&nbsp;- Communicate ‘What’ , Why and When to align people to your Vision & Purpose </td>
                                                                                                    <td><select id="" class="form-control ">
                                                                                                            <option value="">--SELECT--</option>
                                                                                                            <option value="1">1</option>
                                                                                                            <option value="2">2</option>
                                                                                                            <option value="3">3</option>
                                                                                                            <option value="4">4</option>
                                                                                                            <option value="5">5</option>
                                                                                                        </select></td>
                                                                                                    <td><select id="" class="form-control ">
                                                                                                            <option value="">--SELECT--</option>
                                                                                                            <option value="1">1</option>
                                                                                                            <option value="2">2</option>
                                                                                                            <option value="3">3</option>
                                                                                                            <option value="4">4</option>
                                                                                                            <option value="5">5</option>
                                                                                                        </select></td>
                                                                                                </tr>
                                                                                                <tr style="background-color: lightgrey">
                                                                                                    <td><b>Manager’s Mid - Year Review / Evaluation</b></td>
                                                                                                    <td colspan="2"><textarea type="Text" class="form-control"></textarea></td>
                                                                                                </tr>
                                                                                                <tr style="background-color: lightgrey">
                                                                                                    <td><b>Manager’s End - Year Review / Evaluation</b></td>
                                                                                                    <td colspan="2"><textarea type="Text" class="form-control"></textarea></td>
                                                                                                </tr>
                                                                                                <tr style="background-color: lightgrey">
                                                                                                    <td><b style="font-size: 16px">TOTAL SCORE</b></td>
                                                                                                    <td><input type="Text" class="form-control"></td>
                                                                                                    <td><input type="Text" class="form-control"></td>
                                                                                                </tr>
                                                                                                <tr style="background-color: lightgrey">
                                                                                                    <td><b>Other Comment/Remark (Mid Year)</b></td>
                                                                                                    <td colspan="2"><textarea type="Text" class="form-control"></textarea></td>
                                                                                                </tr>
                                                                                                <tr style="background-color: lightgrey">
                                                                                                    <td><b>Other Comment/Remark (End Year)</b></td>
                                                                                                    <td colspan="2"><textarea type="Text" class="form-control"></textarea></td>
                                                                                                </tr>
                                                                                            </table>

                                                                                        </div>



                                                                                    </div> /.col
                                                                                    <div class="col-md-12 col-sm-12">



                                                                                    </div>
                                                                                     /.col
                                                                                </div> /.row
                                                                            </div> /.box-body
                                                                        </div>-->

                                    <div class="box box-info collapsed-box" id="behaviorsTabId">
                                        <div class="box-header">
                                            <h3 class="box-title">Behaviors:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId5">Expand</span><button class="btn btn-box-tool" id="btn6" data-widget="collapse" onclick="buttonFun5();"><i class="fa fa-plus" id="minusId5" ></i></button>
                                                <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="table-responsive">
                                                        <table id="demo" class="table table-bordered table-striped table-hover" style="" align="Center">

                                                            <tr style="background-color: darkgrey">
                                                                <th style="text-align: center"><b>Behaviors</b></th>
                                                                <th style="text-align: center">Mid'Year Score</th>
                                                                <th style="text-align: center" id="endYearHeader">End'Year Score</th>
                                                            </tr>
                                                            <input type="hidden" name="BehaviorsId" id="BehaviorsId" value="${fn:length(behaviorsList)}">
                                                            <tr style="background-color: lightgrey">
                                                                <c:choose>
                                                                    <c:when test="${not empty behaviorsList}">

                                                                        <%--<c:forEach var="behaviorsPlan" items="${behaviorsList}" varStatus="status">--%>

                                                                    <input type="hidden" id="id1" name="id1" value="${behaviorsList[0].id}"/>
                                                                    <input type="hidden" id="w1" name="w1" value="WLB 1"/>

                                                                    <td><b>WLB 1: Walk the Talk </b><br>&nbsp;&nbsp;- Do & Act What you Preach<br>&nbsp;&nbsp;- Keep commitments<br>&nbsp;&nbsp;- Talk Straight – Be Honest & Tell the Truth<br>&nbsp;&nbsp;- Use simple language and call things what they are<br>&nbsp;&nbsp;- Don’t manipulate people nor distort facts</td>
                                                                    <td><select id="midYearScore1" name="midYearScore1" value="${behaviorsList[0].midYearScoreManager}" onchange="behaviorsCount(this);" class="form-control">
                                                                            <option value="">--SELECT--</option>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[0].midYearScoreManager eq '1'}">

                                                                                    <option value="5" selected="">Far Exceeds Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="5">Far Exceeds Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[0].midYearScoreManager eq '2'}">

                                                                                    <option value="4" selected="">Exceeds Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="4">Exceeds Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[0].midYearScoreManager eq '3'}">

                                                                                    <option value="3" selected="">Meets Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="3">Meets Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[0].midYearScoreManager eq '4'}">

                                                                                    <option value="2" selected="">Partially Meets Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="2">Partially Meets Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[0].midYearScoreManager eq '1'}">

                                                                                    <option value="1" selected="">Does Not Meet Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="1">Does Not Meet Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>

                                                                        </select></td>
                                                                    <td id="endYearId1"><select id="endYearScore1" name="endYearScore1" value="${behaviorsList[0].endYearScoreManager}" onchange="behaviorsCountEndYear(this)" class="form-control">
                                                                            <option value="">--SELECT--</option>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[0].endYearScoreManager eq '5'}">

                                                                                    <option value="5" selected="">Far Exceeds Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="5">Far Exceeds Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[0].endYearScoreManager eq '4'}">

                                                                                    <option value="4" selected="">Exceeds Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="4">Exceeds Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[0].endYearScoreManager eq '3'}">

                                                                                    <option value="3" selected="">Meets Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="3">Meets Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[0].endYearScoreManager eq '2'}">

                                                                                    <option value="2" selected="">Partially Meets Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="2">Partially Meets Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[0].endYearScoreManager eq '1'}">

                                                                                    <option value="1" selected="">Does Not Meet Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="1">Does Not Meet Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </select></td>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey">
                                                                        <td><b>Manager’s Mid - Year Review / Evaluation</b></td>
                                                                        <td colspan="2"><textarea type="Text" id="managerMidYearReview1" name="managerMidYearReview1" class="form-control">${behaviorsList[0].managerMidYearReviewManager}</textarea></td>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey" >
                                                                        <td id="managerEndYearReviewId1"><b>Manager’s End - Year Review / Evaluation</b></td>
                                                                        <td colspan="2"><textarea type="Text" id="managerEndYearReview1" name="managerEndYearReview1" class="form-control">${behaviorsList[0].managerEndYearReviewManager}</textarea></td>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey">
                                                                    <input type="hidden" id="id2" name="id2" value="${behaviorsList[1].id}"/>
                                                                    <input type="hidden" id="w2" name="w2" value="WLB 2"/>
                                                                    <td><b>WLB 2: Deliver Results</b><br>&nbsp;&nbsp;- Master the art of execution & Establish a track record of results<br>&nbsp;&nbsp;- Practice Accountability – Hold self & others accountable<br>&nbsp;&nbsp;- Get the best out of you and your team<br>&nbsp;&nbsp;- Be on time and within budget<br>&nbsp;&nbsp;- Don’t find excuses for not delivering<br>&nbsp;&nbsp;- Celebrate success with the team</td>
                                                                    <td><select id="midYearScore2" name="midYearScore2" value="${behaviorsList[1].midYearScoreManager}" onchange="behaviorsCount(this);" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[1].midYearScoreManager eq '5'}">

                                                                                    <option value="5" selected="">Far Exceeds Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="5">Far Exceeds Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[1].midYearScoreManager eq '4'}">

                                                                                    <option value="4" selected="">Exceeds Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="4">Exceeds Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[1].midYearScoreManager eq '3'}">

                                                                                    <option value="3" selected="">Meets Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="3">Meets Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[1].midYearScoreManager eq '2'}">

                                                                                    <option value="2" selected="">Partially Meets Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="2">Partially Meets Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[1].midYearScoreManager eq '1'}">

                                                                                    <option value="1" selected="">Does Not Meet Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="1">Does Not Meet Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </select></td>
                                                                    <td id="endYearId2"><select id="endYearScore2" name="endYearScore2" value="${behaviorsList[1].endYearScoreManager}" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[1].endYearScoreManager eq '5'}">

                                                                                    <option value="5" selected="">Far Exceeds Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="5">Far Exceeds Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[1].endYearScoreManager eq '4'}">

                                                                                    <option value="4" selected="">Exceeds Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="4">Exceeds Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[1].endYearScoreManager eq '3'}">

                                                                                    <option value="3" selected="">Meets Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="3">Meets Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[1].endYearScoreManager eq '2'}">

                                                                                    <option value="2" selected="">Partially Meets Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="2">Partially Meets Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[1].endYearScoreManager eq '1'}">

                                                                                    <option value="1" selected="">Does Not Meet Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="1">Does Not Meet Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </select></td>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey">
                                                                        <td><b>Manager’s Mid - Year Review / Evaluation</b></td>
                                                                        <td colspan="2"><textarea type="Text" id="managerMidYearReview2" name="managerMidYearReview2" class="form-control">${behaviorsList[1].managerMidYearReviewManager}</textarea></td>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey" id="managerEndYearReviewId">
                                                                        <td id="managerEndYearReviewId2"><b>Manager’s End - Year Review / Evaluation</b></td>
                                                                        <td colspan="2"><textarea type="Text" id="managerEndYearReview2" name="managerEndYearReview2" class="form-control">${behaviorsList[1].managerEndYearReviewManager}</textarea></td>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey">
                                                                    <input type="hidden" id="id3" name="id3" value="${behaviorsList[2].id}"/>
                                                                    <input type="hidden" id="w3" name="w3" value="WLB 3"/>
                                                                    <td><b>WLB 3: Build Relationships & Develop Others</b><br>&nbsp;&nbsp;- Be grounded at all times & approachable<br>&nbsp;&nbsp;- Treat people with utmost respect & care<br>&nbsp;- Understand other’s perspective & concern<br>&nbsp;&nbsp;- Invest in developing the talent<br>&nbsp;&nbsp;- Give your team the right opportunities to learn and grow<br>&nbsp;&nbsp;- Create a learning environment & help others to learn from success stories & failures<br>&nbsp;&nbsp; </td>
                                                                    <td><select id="midYearScore3" name="midYearScore3" value="${behaviorsList[2].midYearScoreManager}" onchange="behaviorsCount(this);" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[2].midYearScoreManager eq '5'}">

                                                                                    <option value="5" selected="">Far Exceeds Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="5">Far Exceeds Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[2].midYearScoreManager eq '4'}">

                                                                                    <option value="4" selected="">Exceeds Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="4">Exceeds Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[2].midYearScoreManager eq '3'}">

                                                                                    <option value="3" selected="">Meets Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="3">Meets Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[2].midYearScoreManager eq '2'}">

                                                                                    <option value="2" selected="">Partially Meets Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="2">Partially Meets Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[2].midYearScoreManager eq '1'}">

                                                                                    <option value="1" selected="">Does Not Meet Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="1">Does Not Meet Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </select></td>
                                                                    <td  id="endYearId3"><select id="endYearScore3" name="endYearScore3" value="${behaviorsList[2].endYearScoreManager}" onchange="behaviorsCountEndYear(this);" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[2].endYearScoreManager eq '5'}">

                                                                                    <option value="5" selected="">Far Exceeds Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="5">Far Exceeds Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[2].endYearScoreManager eq '4'}">

                                                                                    <option value="4" selected="">Exceeds Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="4">Exceeds Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[2].endYearScoreManager eq '3'}">

                                                                                    <option value="3" selected="">Meets Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="3">Meets Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[2].endYearScoreManager eq '2'}">

                                                                                    <option value="2" selected="">Partially Meets Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="2">Partially Meets Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[2].endYearScoreManager eq '1'}">

                                                                                    <option value="1" selected="">Does Not Meet Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="1">Does Not Meet Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </select></td>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey">
                                                                        <td><b>Manager’s Mid - Year Review / Evaluation</b></td>
                                                                        <td colspan="2"><textarea type="Text" id="managerMidYearReview3" name="managerMidYearReview3" class="form-control">${behaviorsList[2].managerMidYearReviewManager}</textarea></td>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey" id="managerEndYearReviewId">
                                                                        <td id="managerEndYearReviewId3"><b>Manager’s End - Year Review / Evaluation</b></td>
                                                                        <td colspan="2"><textarea type="Text" id="managerEndYearReview3" name="managerEndYearReview3" class="form-control">${behaviorsList[2].managerEndYearReviewManager}</textarea></td>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey">
                                                                    <input type="hidden" id="id4" name="id4" value="${behaviorsList[3].id}"/>
                                                                    <input type="hidden" id="w4" name="w4" value="WLB 4"/>
                                                                    <td><b>WLB 4: Act with Courage</b><br>&nbsp;&nbsp;- Take a stand – have your individual opinion & stand by it<br>&nbsp;&nbsp;- Don’t shy away from conflicts<br>&nbsp;&nbsp;- Deal with the issues head on – never procrastinate<br>&nbsp;&nbsp;- Never bury your head in the sand<br>&nbsp;&nbsp;- Be direct & candid</td>
                                                                    <td><select id="midYearScore4" name="midYearScore4" value="${behaviorsList[3].midYearScoreManager}" onchange="behaviorsCount(this);" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[3].midYearScoreManager eq '5'}">

                                                                                    <option value="5" selected="">Far Exceeds Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="5">Far Exceeds Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[3].midYearScoreManager eq '4'}">

                                                                                    <option value="4" selected="">Exceeds Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="4">Exceeds Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[3].midYearScoreManager eq '3'}">

                                                                                    <option value="3" selected="">Meets Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="3">Meets Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[3].midYearScoreManager eq '2'}">

                                                                                    <option value="2" selected="">Partially Meets Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="2">Partially Meets Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[3].midYearScoreManager eq '1'}">

                                                                                    <option value="1" selected="">Does Not Meet Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="1">Does Not Meet Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </select></td>
                                                                    <td id="endYearId4"><select id="endYearScore4" name="endYearScore4" value="${behaviorsList[3].endYearScoreManager}" onchange="behaviorsCountEndYear(this);" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[3].endYearScoreManager eq '5'}">

                                                                                    <option value="5" selected="">Far Exceeds Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="5">Far Exceeds Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[3].endYearScoreManager eq '4'}">

                                                                                    <option value="4" selected="">Exceeds Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="4">Exceeds Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[3].endYearScoreManager eq '3'}">

                                                                                    <option value="3" selected="">Meets Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="3">Meets Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[3].endYearScoreManager eq '2'}">

                                                                                    <option value="2" selected="">Partially Meets Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="2">Partially Meets Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[3].endYearScoreManager eq '1'}">

                                                                                    <option value="1" selected="">Does Not Meet Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="1">Does Not Meet Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </select></td>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey">
                                                                        <td><b>Manager’s Mid - Year Review / Evaluation</b></td>
                                                                        <td colspan="2"><textarea type="Text" id="managerMidYearReview4" name="managerMidYearReview4" class="form-control">${behaviorsList[3].managerMidYearReviewManager}</textarea></td>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey" id="managerEndYearReviewId">
                                                                        <td id="managerEndYearReviewId4"><b>Manager’s End - Year Review / Evaluation</b></td>
                                                                        <td colspan="2"><textarea type="Text" id="managerEndYearReview4" name="managerEndYearReview4" class="form-control">${behaviorsList[3].managerEndYearReviewManager}</textarea></td>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey">
                                                                    <input type="hidden" id="id5" name="id5" value="${behaviorsList[4].id}"/>
                                                                    <input type="hidden" id="w5" name="w5" value="WLB 5"/>
                                                                    <td><b>WLB 5: Believe in Vision & Purpose</b><br>&nbsp;&nbsp;- Be Far-sighted & Look beyond the obvious<br>&nbsp;&nbsp;- Be Strategic – Have a macro & micro perspective, Innovate<br>&nbsp;&nbsp;- Be Entrepreneurial <br>&nbsp;&nbsp;- Communicate your Vision to your team<br>&nbsp;&nbsp;- Make sure everyone on board under stand's the purpose<br>&nbsp;&nbsp;- Communicate ‘What’ , Why and When to align people to your Vision & Purpose </td>
                                                                    <td><select id="midYearScore5" name="midYearScore5" value="${behaviorsList[4].midYearScoreManager}" onchange="behaviorsCount(this);" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[4].midYearScoreManager eq '5'}">

                                                                                    <option value="5" selected="">Far Exceeds Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="5">Far Exceeds Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[4].midYearScoreManager eq '4'}">

                                                                                    <option value="4" selected="">Exceeds Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="4">Exceeds Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[4].midYearScoreManager eq '3'}">

                                                                                    <option value="3" selected="">Meets Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="3">Meets Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[4].midYearScoreManager eq '2'}">

                                                                                    <option value="2" selected="">Partially Meets Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="2">Partially Meets Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[4].midYearScoreManager eq '1'}">

                                                                                    <option value="1" selected="">Does Not Meet Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="1">Does Not Meet Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </select></td>
                                                                    <td id="endYearId5"><select id="endYearScore5" name="endYearScore5" value="${behaviorsList[4].endYearScoreManager}" onchange="behaviorsCountEndYear(this);" class="form-control">
                                                                            <option value="">--SELECT--</option>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[4].endYearScoreManager eq '5'}">

                                                                                    <option value="5" selected="">Far Exceeds Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="5">Far Exceeds Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[4].endYearScoreManager eq '4'}">

                                                                                    <option value="4" selected="">Exceeds Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="4">Exceeds Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[4].endYearScoreManager eq '3'}">

                                                                                    <option value="3" selected="">Meets Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="3">Meets Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[4].endYearScoreManager eq '2'}">

                                                                                    <option value="2" selected="">Partially Meets Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="2">Partially Meets Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${behaviorsList[4].endYearScoreManager eq '1'}">

                                                                                    <option value="1" selected="">Does Not Meet Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="1">Does Not Meet Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </select></td>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey">
                                                                        <td><b>Manager’s Mid - Year Review / Evaluation</b></td>
                                                                        <td colspan="2"><textarea type="Text" id="managerMidYearReview5" name="managerMidYearReview5" class="form-control">${behaviorsList[4].managerMidYearReviewManager}</textarea></td>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey" id="managerEndYearReviewId">
                                                                        <td id="managerEndYearReviewId5"><b>Manager’s End - Year Review / Evaluation</b></td>
                                                                        <td colspan="2"><textarea type="Text" id="managerEndYearReview5" name="managerEndYearReview5" class="form-control">${behaviorsList[4].managerEndYearReviewManager}</textarea></td>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey">
                                                                        <td><b style="font-size: 16px">TOTAL SCORE</b></td>
                                                                        <td><input type="Text" id="behaviorsMidyearTotalscore" name="behaviorsMidyearTotalscore" value="${behaviorsMidyearTotalscore}" class="form-control" readonly="true"></td>
                                                                        <td><input type="Text" id="behaviorsEndyearTotalscore" name="behaviorsEndyearTotalscore" value="${behaviorsEndyearTotalscore}" class="form-control"  readonly="true"></td>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey">
                                                                        <td><b>Other Comment/Remark (Mid Year)</b></td>
                                                                        <td colspan="2"><textarea type="Text" id="behaviorsMidyearOtherremark" name="behaviorsMidyearOtherremark" class="form-control">${behaviorsMidyearOtherremark}</textarea></td>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey">
                                                                        <td id="behaviorsEndyearOtherremarkId"><b>Other Comment/Remark (End Year)</b></td>
                                                                        <td colspan="2"><textarea type="Text" id="behaviorsEndyearOtherremark" name="behaviorsEndyearOtherremark" class="form-control">${behaviorsEndyearOtherremark}</textarea></td>
                                                                    </tr>

                                                                    <%--</c:forEach>--%>
                                                                </c:when>
                                                                <c:otherwise>

                                                                    <tr style="background-color: lightgrey">
                                                                        <td><b>WLB 1: Walk the Talk </b><br>&nbsp;&nbsp;- Do & Act What you Preach<br>&nbsp;&nbsp;- Keep commitments<br>&nbsp;&nbsp;- Talk Straight – Be Honest & Tell the Truth<br>&nbsp;&nbsp;- Use simple language and call things what they are<br>&nbsp;&nbsp;- Don’t manipulate people nor distort facts</td>
                                                                        <td><select id="midYearScore1" name="midYearScore1" class="form-control" onchange="behaviorsCount(this);">
                                                                                <option value="">--SELECT--</option>
                                                                                <option value="5">Far Exceeds Expectations</option>
                                                                                <option value="4">Exceeds Expectations</option>
                                                                                <option value="3">Meets Expectations</option>
                                                                                <option value="2">Partially Meets Expectations</option>
                                                                                <option value="1">Does Not Meet Expectations</option>
                                                                            </select></td>
                                                                        <td><select id="endYearScore1" name="endYearScore1" class="form-control" onchange="behaviorsCountEndYear(this);">
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
                                                                        <td colspan="2"><textarea type="Text" id="managerMidYearReview1" name="managerMidYearReview1" class="form-control"></textarea></td>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey">
                                                                        <td><b>Manager’s End - Year Review / Evaluation</b></td>
                                                                        <td colspan="2"><textarea type="Text" id="managerEndYearReview1" name="managerEndYearReview1" class="form-control"></textarea></td>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey">
                                                                        <td><b>WLB 2: Deliver Results</b><br>&nbsp;&nbsp;- Master the art of execution & Establish a track record of results<br>&nbsp;&nbsp;- Practice Accountability – Hold self & others accountable<br>&nbsp;&nbsp;- Get the best out of you and your team<br>&nbsp;&nbsp;- Be on time and within budget<br>&nbsp;&nbsp;- Don’t find excuses for not delivering<br>&nbsp;&nbsp;- Celebrate success with the team</td>
                                                                        <td><select id="midYearScore2" name="midYearScore2" class="form-control" onchange="behaviorsCount(this);">
                                                                                <option value="">--SELECT--</option>
                                                                                <option value="5">Far Exceeds Expectations</option>
                                                                                <option value="4">Exceeds Expectations</option>
                                                                                <option value="3">Meets Expectations</option>
                                                                                <option value="2">Partially Meets Expectations</option>
                                                                                <option value="1">Does Not Meet Expectations</option>
                                                                            </select></td>
                                                                        <td><select id="endYearScore2" name="endYearScore2" class="form-control" onchange="behaviorsCountEndYear(this);">
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
                                                                        <td colspan="2"><textarea type="Text" id="managerMidYearReview2" name="managerMidYearReview2" class="form-control"></textarea></td>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey">
                                                                        <td><b>Manager’s End - Year Review / Evaluation</b></td>
                                                                        <td colspan="2"><textarea type="Text" id="managerEndYearReview2" name="managerEndYearReview2" class="form-control"></textarea></td>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey">
                                                                        <td><b>WLB 3: Build Relationships & Develop Others</b><br>&nbsp;&nbsp;- Be grounded at all times & approachable<br>&nbsp;&nbsp;- Treat people with utmost respect & care<br>&nbsp;- Understand other’s perspective & concern<br>&nbsp;&nbsp;- Invest in developing the talent<br>&nbsp;&nbsp;- Give your team the right opportunities to learn and grow<br>&nbsp;&nbsp;- Create a learning environment & help others to learn from success stories & failures<br>&nbsp;&nbsp; </td>
                                                                        <td><select id="midYearScore3" name="midYearScore3" class="form-control" onchange="behaviorsCount(this);">
                                                                                <option value="">--SELECT--</option>
                                                                                <option value="5">Far Exceeds Expectations</option>
                                                                                <option value="4">Exceeds Expectations</option>
                                                                                <option value="3">Meets Expectations</option>
                                                                                <option value="2">Partially Meets Expectations</option>
                                                                                <option value="1">Does Not Meet Expectations</option>
                                                                            </select></td>
                                                                        <td><select id="endYearScore3" name="endYearScore3" class="form-control" onchange="behaviorsCountEndYear(this);">
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
                                                                        <td colspan="2"><textarea type="Text" id="managerMidYearReview3" name="managerMidYearReview3" class="form-control"></textarea></td>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey">
                                                                        <td><b>Manager’s End - Year Review / Evaluation</b></td>
                                                                        <td colspan="2"><textarea type="Text" id="managerEndYearReview3" name="managerEndYearReview3" class="form-control"></textarea></td>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey">
                                                                        <td><b>WLB 4: Act with Courage</b><br>&nbsp;&nbsp;- Take a stand – have your individual opinion & stand by it<br>&nbsp;&nbsp;- Don’t shy away from conflicts<br>&nbsp;&nbsp;- Deal with the issues head on – never procrastinate<br>&nbsp;&nbsp;- Never bury your head in the sand<br>&nbsp;&nbsp;- Be direct & candid</td>
                                                                        <td><select id="midYearScore4" name="midYearScore4" class="form-control" onchange="behaviorsCount(this);">
                                                                                <option value="">--SELECT--</option>
                                                                                <option value="5">Far Exceeds Expectations</option>
                                                                                <option value="4">Exceeds Expectations</option>
                                                                                <option value="3">Meets Expectations</option>
                                                                                <option value="2">Partially Meets Expectations</option>
                                                                                <option value="1">Does Not Meet Expectations</option>
                                                                            </select></td>
                                                                        <td><select id="endYearScore4" name="endYearScore4" class="form-control" onchange="behaviorsCountEndYear(this);">
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
                                                                        <td colspan="2"><textarea type="Text" id="managerMidYearReview4" name="managerMidYearReview4" class="form-control"></textarea></td>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey">
                                                                        <td><b>Manager’s End - Year Review / Evaluation</b></td>
                                                                        <td colspan="2"><textarea type="Text" id="managerEndYearReview4" name="managerEndYearReview4" class="form-control"></textarea></td>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey">
                                                                        <td><b>WLB 5: Believe in Vision & Purpose</b><br>&nbsp;&nbsp;- Be Far-sighted & Look beyond the obvious<br>&nbsp;&nbsp;- Be Strategic – Have a macro & micro perspective, Innovate<br>&nbsp;&nbsp;- Be Entrepreneurial <br>&nbsp;&nbsp;- Communicate your Vision to your team<br>&nbsp;&nbsp;- Make sure everyone on board under stand's the purpose<br>&nbsp;&nbsp;- Communicate ‘What’ , Why and When to align people to your Vision & Purpose </td>
                                                                        <td><select id="midYearScore5" name="midYearScore5" class="form-control" onchange="behaviorsCount(this);">
                                                                                <option value="">--SELECT--</option>
                                                                                <option value="5">Far Exceeds Expectations</option>
                                                                                <option value="4">Exceeds Expectations</option>
                                                                                <option value="3">Meets Expectations</option>
                                                                                <option value="2">Partially Meets Expectations</option>
                                                                                <option value="1">Does Not Meet Expectations</option>
                                                                            </select></td>
                                                                        <td><select id="endYearScore5" name="endYearScore5" class="form-control" onchange="behaviorsCountEndYear(this);">
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
                                                                        <td colspan="2"><textarea type="Text" id="managerMidYearReview5" name="managerMidYearReview5" class="form-control"></textarea></td>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey">
                                                                        <td><b>Manager’s End - Year Review / Evaluation</b></td>
                                                                        <td colspan="2"><textarea type="Text" id="managerEndYearReview5" name="managerEndYearReview5" class="form-control"></textarea></td>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey">
                                                                        <td><b style="font-size: 16px">TOTAL SCORE</b></td>
                                                                        <td><input type="Text" id="behaviorsMidyearTotalscore" name="behaviorsMidyearTotalscore" value="${behaviorsMidyearTotalscore}" class="form-control" readonly="true"></td>
                                                                        <td><input type="Text" id="behaviorsEndyearTotalscore" name="behaviorsEndyearTotalscore" value="${behaviorsEndyearTotalscore}" class="form-control"  readonly="true"></td>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey">
                                                                        <td><b>Other Comment/Remark (Mid Year)</b></td>
                                                                        <td colspan="2"><textarea type="Text" id="behaviorsMidyearOtherremark" name="behaviorsMidyearOtherremark" class="form-control"></textarea></td>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey">
                                                                        <td><b>Other Comment/Remark (End Year)</b></td>
                                                                        <td colspan="2"><textarea type="Text" id="behaviorsEndyearOtherremark" name="behaviorsEndyearOtherremark" class="form-control"></textarea></td>
                                                                    </tr>

                                                                </c:otherwise>
                                                            </c:choose>
                                                        </table>
                                                        <p><b>Note</b>: Please note that the score in Mid-Year Review/Evaluation of Behavior is just an indicator of an individual’s behaviour during the first half of the year and the same is not considered in any rating calculation.
                                                            It is the score in End-Year Review/Evaluation which is considered in the final rating of an employee.</p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>


                                    <div class="box box-info collapsed-box" id="RatingsTabId">
                                        <div class="box-header">
                                            <h3 class="box-title">Performance Ratings:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId6">Expand</span><button class="btn btn-box-tool" id="btn7" data-widget="collapse" onclick="buttonFun6();"><i class="fa fa-plus" id="minusId6" ></i></button>
                                                <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <label class="col-sm-5 control-label"><b>Final Score</b></label>
                                                        <div class="col-sm-2">

                                                            <input type="number" id="behaviorsFinalscore" name="behaviorsFinalscore" value="${behaviorsFinalscore}" class="form-control" readonly="true">

                                                        </div>
                                                    </div>

                                                    <div class="table-responsive">
                                                        <table id="demo" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                            <tr style="background-color: darkgrey">
                                                                <th style="text-align: center">Performance Ratings</th>
                                                                <th style="text-align: center">Score</th>
                                                                <th style="text-align: center">Score Achieved</th>
                                                            </tr>
                                                            <tr class="" style="background-color: #337AB7">
                                                                <td style="vertical-align: middle"><b>Far Exceeds Expectations</b></td>
                                                                <td style="text-align: center"><h4><b>106 to 110</b></h4></td>
                                                                <td style="text-align: center"><span id="score1" class="glyphicon glyphicon-ok" style="font-size: 30px"></span></td>
                                                            </tr>
                                                            <tr class="" style="background-color: #5CB85C">
                                                                <td style="vertical-align: middle"><b>Exceeds Expectations</b></td>
                                                                <td style="text-align: center"><h4><b>101 to 105</b></h4></td>
                                                                <td style="text-align: center"><span id="score2" class="glyphicon glyphicon-ok" style="font-size: 30px"></span></td>

                                                            </tr>
                                                            <tr class="" style="background-color: #F0AD4E">
                                                                <td style="vertical-align: middle"><b>Meets Expectations</b></td>
                                                                <td style="text-align: center"><h4><b>80 to 100</b></h4></td>
                                                                <td style="text-align: center"><span id="score3" class="glyphicon glyphicon-ok" style="font-size: 30px"></span></td>

                                                            </tr>
                                                            <tr class="" style="background-color: #FFA375">
                                                                <td style="vertical-align: middle"><b>Partially Meets Expectations</td>
                                                                <td style="text-align: center"><h4><b>51 to 79</b></h4></td>
                                                                <td style="text-align: center"><span id="score4" class="glyphicon glyphicon-ok" style="font-size: 30px"></span></td>

                                                            </tr>
                                                            <tr class="" style="background-color: #D9534F">
                                                                <td style="vertical-align: middle"><b>Does Not Meet Expectations</b></td>
                                                                <td style="text-align: center"><h4><b>50 & Below</b></h4></td>
                                                                <td style="text-align: center"><span id="score5" class="glyphicon glyphicon-ok" style="font-size: 30px"></span></td>

                                                            </tr>


                                                        </table>

                                                    </div>

                                                </div><!-- /.col -->

                                                <!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <!--Reason In Detail completes Here-->
                                    <!--                                            <div class="form-group">
                                                                                    <div class="col-lg-offset-2 col-sm-3">
                                                                                        <button type="submit" class="btn btn-success" data-original-title="" title="" style="width: 100px">Save</button>
                                                                                    </div>
                                                                                    <div class="col-lg-4 col-sm-4">
                                                                                        <button type="submit" class="btn btn-primary" data-original-title="" title="" style="width: 100px; margin-left: -180px;">Submit</button>
                                                                                    </div>
                                                                                </div>-->

                                    <%--<c:if test="${flag eq 'true' || flag1 eq 'true' || flag2 eq 'true'}">--%>
                                    <c:if test="${Tflag eq 'true'}">
                                        <div class="form-group">
                                            <!--<div class="col-lg-offset-2 col-sm-3">-->
                                            <div class="col-sm-12">

                                                <c:choose>
                                                    <%--<c:when test="${managerStatus eq '0'}">--%>

                                                    <c:when test="${managerKraStatus eq '0'}">
                                                        <div class="col-sm-4" style="text-align: left;">
                                                            <button type="submit" class="btn btn-warning" data-original-title="" id="save" value="save" name="save" title="">SAVE</button>
                                                        </div>
                                                        <div class="col-sm-4" style="text-align: center;">
                                                            <button type="button" class="btn btn-primary" data-original-title="" data-toggle="modal" data-target="#reworkPmp" id="rework" value="rework" name="rework" title="" >REWORK</button>
                                                        </div>
                                                        <div class="col-sm-4" style="text-align: right;">
                                                            <button type="submit" class="btn btn-success" data-original-title="" id="submit" name="submit" value="submit" title="">APPROVE</button>
                                                        </div>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <div class="col-sm-4" style="text-align: left;">
                                                            <button type="submit" class="btn btn-warning" data-original-title="" id="save" value="save" name="save" title="" disabled="true">SAVE</button>
                                                        </div>
                                                        <div class="col-sm-4" style="text-align: center;">
                                                            <button type="button" class="btn btn-primary" data-original-title="" data-toggle="modal" data-target="#reworkPmp" id="rework" value="rework" name="rework" title="" disabled="true">REWORK</button>
                                                        </div>
                                                        <div class="col-sm-4" style="text-align: right;">
                                                            <button type="submit" class="btn btn-success" data-original-title="" id="submit" name="submit" value="submit" title="" disabled="true">APPROVE</button>
                                                        </div>
                                                    </c:otherwise>
                                                </c:choose>
                                            </div>
                                        </div>
                                    </c:if>
                                </form:form>
                                <div class="modal fade bs-example-modal-lg" id="reworkPmp" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
                                    <div class="modal-dialog modal-lg">
                                        <form onsubmit="return returnSubmit();"
                                              action="appraisalPerformance.htm?act=reworkByManager" commandName=""
                                              method="post"  name='form11' id ="form11" class="form-horizontal" role="form"> 
                                            <input type="hidden" id="pmpIdForRework" name="pmpIdForRework" value="${appraisalId}">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only"></span></button>
                                                    <h4 class="modal-title" id="myModalLabel">Rework</h4>
                                                    <div>
                                                        &nbsp;
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <label>Comment:</label>
                                                    </div>
                                                    <textarea type="Text" name="reworkComment" id="reworkComment" class="form-control"></textarea>
                                                    <div>
                                                        &nbsp;
                                                    </div>
                                                    <button id="close" type="button" style="width: 100px" class="btn btn-default" data-dismiss="modal">Close</button>
                                                    <button id="Save1" type="submit" class="btn btn-primary" >Submit</button>
                                                </div>

                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </section>
        </div>

    </body>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

    <script>
        var tflag11 = document.getElementById("tflagId").value;
        var flag11 = document.getElementById("flagId").value;
        var managerStatusVar = document.getElementById("managerKraStatus").value;
        var flagmid = document.getElementById("flagMidId").value;
        var flagEndId = document.getElementById("flagEndId").value;

        if (flag11 === 'true' && flagmid !== 'true' && flagEndId !== 'true') {
            if (managerStatusVar === '1') {
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
            if (managerStatusVar === '1') {
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
            if (managerStatusVar === '1') {
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
    <!--<script type="text/javascript" src="StorageYard/Plugins/alert/sweetalert-dev.js"></script>-->
    <script type="text/javascript" src="StorageYard/Plugins/alert/bootbox.min.js"></script>
</html>
