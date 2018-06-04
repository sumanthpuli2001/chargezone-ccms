<%--

    Document   : PerformanceAppraisalForm
    Created on : Oct 5, 2015, 2:47:30 PM
    Author     : Dhaval
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/EmployeeCommanForCompetency.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Performance Appraisal Form</title>
        <style>
            form { position: relative;}
        </style>

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
                    <!--<a href="appraisalPerformance.htm?act=appraisalPrintToPdfByEmployee&id=${empId}&userid=${userid}&appraisalId=${appraisalId}&year=${year}" target="_blank"  class="btn btn-primary">Print</a>-->

                    <input type="hidden" id="empId" name="empId" value="${empId}">
                    <input type="hidden" id="userid" name="userid" value="${userid}">
                    <input type="hidden" id="appraisalId" name="appraisalId" value="${appraisalId}">
                    <input type="hidden" id="managerStatus" name="managerStatus" value="${managerStatus}">

                    <input type="hidden" id="empCompetencyStatus" name="empCompetencyStatus" value="${empCompetencyStatus}">
                    <input type="hidden" id="managerCompetencyStatus" name="managerCompetencyStatus" value="${managerCompetencyStatus}">

                    <input type="hidden" name="tflagId" id="tflagId" value="${Tflag}">
                    <input type="hidden" name="flagId" id="flagId" value="${flag}">
                    <input type="hidden" name="flagMidId" id="flagMidId" value="${flag1}">
                    <input type="hidden" name="flagEndId" id="flagEndId" value="${flag2}">

                    <input type="hidden" id="pmpstartyearstatus" name="pmpstartyearstatus" value="${pmpstartyearstatus}">
                    <input type="hidden" id="pmpmidyearstatus" name="pmpmidyearstatus" value="${pmpmidyearstatus}">
                    <input type="hidden" id="pmpendyearstatus" name="pmpendyearstatus" value="${pmpendyearstatus}">
                    <input type="hidden" id="pmpasEmployee" name="pmpasEmployee" value="${pmpasEmployee}">
                    <!--compentency Status-->
                    <input type="hidden" id="compentencyStartYearStatus" name="compentencyStartYearStatus" value="${compentencyStartYearStatus}">
                    <input type="hidden" id="compentencyMidYearStatus" name="compentencyMidYearStatus" value="${compentencyMidYearStatus}">
                    <input type="hidden" id="compentencyEndYearStatus" name="compentencyEndYearStatus" value="${compentencyEndYearStatus}">

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
                                <form:form class="form-horizontal" id="form1" role="form1" action="appraisalPerformance.htm?act=createSubmitCompetency" commandName="appraisalPerformanceMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
                                    <input type="hidden" id="year" name="year" value="${year}">
                                    <!--form horizontal starts here-->
                                    <!--<form class="form-horizontal" role="form" commandName="AppraisalPerformanceMaster">-->
                                    <div class="box box-info collapsed-box displayAction">
                                        <div class="box-header">
                                            <h3 class="box-title">Employee Detail:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId1">Expand</span><span class="btn btn-box-tool" id="btn1" data-widget="collapse" onclick="buttonFun1();"><i class="fa fa-plus" id="minusId1" ></i></span>
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
                                    </div>

                                    <div class="box box-info collapsed-box displayAction">
                                        <div class="box-header">
                                            <h3 class="box-title">Competency Evaluation (As Per SPC Lifesciences Competency Framework) :${cpmname}</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId3">Expand</span><span class="btn btn-box-tool" id="btn4" data-widget="collapse" onclick="
                                                        buttonFun3();"><i class="fa fa-plus" id="minusId3" ></i></span>
                                                <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <%--<c:if test="${empty competencyEvaluationList[0][2].title}">--%>
                                                    <!--<div>-->

                                                    <!--<select name="competencyEvaluation_Id" id="competencyEvaluation_Id" class="form-control" onchange="ajaxfun();"/>-->
                                                    <!--<option value="">--SELECT--</option>-->
                                                    <%--<c:forEach var="competencyMap" items="${competencyMap}">--%>
                                                        <!--<option value="${competencyMap.key}">${competencyMap.value}</option>-->
                                                    <%--</c:forEach>--%>
                                                    <!--</select>-->
                                                    <!--</div>-->
                                                    <%--</c:if>--%>

                                                    <%--<c:if test="${empty competencyEvaluationList[0][2].title || appraisalPerformanceMaster.managerStatus ne 1 }">--%>

                                                    <!--<div>-->
                                                    <!--<select name="competencyEvaluation_Id" id="competencyEvaluation_Id" class="form-control" onchange="ajaxfun();"/>-->
                                                    <!--<option value="">--SELECT--</option>-->
                                                    <%--<c:forEach var="competencyMap" items="${competencyMap}">--%>
                                                    <%--<c:if test="${competencyEvaluationList[0][2].title  eq competencyMap.value}">--%>
                                                    <!--<option value="$/{competencyMap.key}" selected="true">$/{competencyMap.value}</option>-->
                                                    <%--</c:if>--%>
                                                    <%--<c:if test="${competencyEvaluationList[0][2].title  ne competencyMap.value}">--%>
                                                    <!--<option value="$/{competencyMap.key}">$/{competencyMap.value}</option>-->
                                                    <%--</c:if>--%>
                                                    <%--</c:forEach>--%>
                                                    <!--</select>-->
                                                    <!--</div>-->
                                                    <%--</c:if>--%>

                                                    <c:if test="${appraisalPerformanceMaster.managerStatus eq 1 && !empty competencyEvaluationList[0][2].title}">
                                                        <div><input type="text" id="competencyEvaluation_Id" class="form-control" name="competencyEvaluation_Id" value="${competencyEvaluationList[0][2].title}" readonly="true"></div>
                                                        </c:if>

                                                    <%--<c:if test="${appraisalPerformanceMaster.managerStatus ne 1}">--%>
                                                        <!--<div><input type="text" id="competencyEvaluation_Id" class="form-control" name="competencyEvaluation_Id" value="${competencyEvaluationList[0][2].title}" readonly="true"></div>-->
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
                                                                    <td id="subCompentencyTitleId${status.count}" >${competencyEvaluationList[4]}</td>
                                                                    <td id="subCompentencyStartId${status.count}" >

                                                                        <select id="competencyStartYear${status.count}" name="compentencyStartYear${status.count}" value="${competencyEvaluationList[5]}"  class="form-control">
                                                                            <option value="">--SELECT--</option>
                                                                            <c:choose>
                                                                                <c:when test="${competencyEvaluationList[5] eq 'Exceed Expectations'}">

                                                                                    <option value="Exceed Expectations" selected="">Exceed Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="Exceed Expectations">Exceed Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${competencyEvaluationList[5] eq 'Meet Expectations'}">

                                                                                    <option value="Meet Expectations" selected="">Meet Expectations</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="Meet Expectations">Meet Expectations</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:choose>
                                                                                <c:when test="${competencyEvaluationList[5] eq 'Need Improvement'}">

                                                                                    <option value="Need Improvement" selected="">Need Improvement</option>
                                                                                </c:when>
                                                                                <c:otherwise>

                                                                                    <option value="Need Improvement">Need Improvement</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </select>
                                                                    </td>
                                                                    <td id="subCompentencyStartRemarkId${status.count}" >
                                                                        <textarea type="Text" id="compentencyStartRemark${status.count}" name="compentencyStartRemark${status.count}" class="form-control"  rows="4">${competencyEvaluationList[6]}</textarea>
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
                                                                    <td id="subCompentencyMidRemarkId${status.count}">
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
                                                            <%--</c:when>--%>
                                                            <%--</c:choose>--%>

                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </div><!-- /.box-body -->
                                    </div>


                                    <c:if test="${appraisalPerformanceMaster.competencyReworkStatus eq 1}">

                                        <div class="box box-info collapsed-box">
                                            <div class="box-header">
                                                <h3 class="box-title">Reworked Comment:</h3>
                                                <div class="box-tools pull-right">
                                                    <span id="spanId7">Expand</span><span class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun7()"><i class="fa fa-plus" id="minusId7"></i></span>
                                                    <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                                </div>

                                            </div><!-- /.box-header -->
                                            <div class="box-body no-padding">
                                                <div class="row">
                                                    <div class="col-md-12 col-sm-12">
                                                        <div class="form-group">
                                                            <label class="col-sm-3 control-label">Comment:</label>
                                                            <div class="col-sm-7">
                                                                <form:textarea path="competencyReworkComment" class="form-control" readonly="true" rows="6"></form:textarea>
                                                                </div>
                                                            </div>
                                                        </div><!-- /.col -->
                                                    </div><!-- /.row -->
                                                </div><!-- /.box-body -->
                                            </div>
                                    </c:if>
                                    <!--Reason In Detail completes Here-->
                                    <%--<c:if test="${flag eq 'true' || flag1 eq 'true' || flag2 eq 'true'}">--%>
                                    <c:if test="${Tflag eq 'true'}">
                                        <div class="form-group">
                                            <div class="col-sm-12">
                                                   <!--<button type="submit" class="btn btn-primary" data-original-title="" <c:if test="${managerStatus eq '1'}"> disabled="true" </c:if> id="submit" name="submit" value="submit" title="" style="width: 100px; margin-left: 550px;">SUBMIT</button>-->
                                                <c:choose>
                                                    <c:when test="${empCompetencyStatus eq '0'}">
                                                        <div class="col-sm-6 " style="text-align: left;">
                                                            <button type="submit" class="btn btn-warning" data-original-title="" value="save" id="save" name="save" title="" >SAVE</button>
                                                        </div>
                                                        <div class="col-sm-6 " style="text-align: right;">
                                                            <button type="submit" class="btn btn-primary" data-original-title="" id="submit" name="submit" value="submit" title="" >SUBMIT</button>
                                                        </div>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <div class="col-sm-6 " style="text-align: left;">
                                                            <button type="submit" class="btn btn-warning" data-original-title="" id="save" name="save" disabled="true"  title="" >SAVE</button>
                                                        </div>
                                                        <div class="col-sm-6 " style="text-align: right;">
                                                            <button type="submit" class="btn btn-primary" data-original-title=""  id="submit" name="submit" disabled="true" value="submit" title="" >SUBMIT</button>
                                                        </div>

                                                    </c:otherwise>
                                                </c:choose>
                                            </div>
                                        </div>
                                    </c:if>

                                </form:form>
                            </div><!-- /.tab-content -->
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
            </section><!-- /.content -->
        </div>
        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    </body>

    <script>
        var tflag11 = document.getElementById("tflagId").value;
//        var flag11 = document.getElementById("flagId").value;
//        var employeeStatusVar = document.getElementById("employeeStatus").value;
        var employeeStatusVar = document.getElementById("empCompetencyStatus").value;
//        alert("DhDDjDD"+employeeStatusVar);
//        var flagmid = document.getElementById("flagMidId").value;
//        var flagEndId = document.getElementById("flagEndId").value;
        if (employeeStatusVar === '1') {
//            alert("alal");
            $("#form1 :input").attr("disabled", true);

            $("#btn4").attr("disabled", false);
        }
//        if (flag11 === 'true' && flagmid !== 'true' && flagEndId !== 'true') {
//            if (employeeStatusVar === '1') {
//                $("#form1 :input").attr("disabled", true);
//
//                $("#btn4").attr("disabled", false);
//
//                $(".close").attr("disabled", false);
//
//
//            }
////
//        } else if (flag11 !== 'true' && flagmid === 'true' && flagEndId !== 'true') {
//
//            if (employeeStatusVar === '1') {
//                $("#form1 :input").attr("disabled", true);
//                $("#btn4").attr("disabled", false);
//                $(".close").attr("disabled", false);
////
//            }
////
//        } else if (flag11 !== 'true' && flagmid !== 'true' && flagEndId === 'true') {
////            alert("NO3 flage Found");
//            if (employeeStatusVar === '1') {
//                $("#form1 :input").attr("disabled", true);
//                $("#btn4").attr("disabled", false);
//                $(".close").attr("disabled", false);
//
//            }
//
//        } else {
//            $(".displayAction :input").attr("readOnly", true);
//            $(".displayAction1 :input").attr("readOnly", true);
//            if (employeeStatusVar === '1') {
//                $("#form1 :input").attr("disabled", true);
//            }
//            $("#btn1").attr("disabled", false);
//            $("#btn2").attr("disabled", false);
//            $("#btn3").attr("disabled", false);
//            $("#btn4").attr("disabled", false);
//            $("#btn5").attr("disabled", false);
//            $("#btn6").attr("disabled", false);
//            $("#btn7").attr("disabled", false);
//            $(".close").attr("disabled", true);
//
//        }

    </script>
    <script>
        $(document).keydown(function (objEvent) {
            if (objEvent.keyCode == 9) {  //tab pressed
                objEvent.preventDefault(); // stops its action
            }
        });


//        alert('${sessionScope.employeeInfo.competencyEvaluationId}');
        $(document).ready(function () {
//            document.getElementById('countId').value = '${fn:length(kragoal)}';

//            alert('${sessionScope.employeeInfo.competencyEvaluationId}');

            var subCompentencyCountId = document.getElementById("subCompentencyCount").value;
            if (subCompentencyCountId == 0) {
                myajaxfun1('${sessionScope.employeeInfo.competencyEvaluationId}');
            }
        });

    </script>

    <style>
        .class-with-width { width: 150px !important; }
    </style>
    <script type="text/javascript" src="StorageYard/Plugins/alert/bootbox.min.js"></script>
</html>
