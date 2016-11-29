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
    <%@include file="/WEB-INF/jsp/Common/ManagerCommanForIDP.jsp"%>

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
            /*//padding: 6px 12px;*/
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
                    <!--<a href="appraisalPerformance.htm?act=appraisalPerformancePrint&id=${empId}&userid=${userid}&appraisalId=${appraisalId}" target="_blank"  class="btn btn-primary">Print</a>-->

                    <input type="hidden" id="empId" name="empId" value="${empId}">
                    <input type="hidden" id="userid" name="userid" value="${userid}">
                    <input type="hidden" id="appraisalId" name="appraisalId" value="${appraisalId}">
                    <input type="hidden" id="managerStatus" name="managerStatus" value="${managerStatus}">
                    <input type="hidden" id="managerKraStatus" name="managerKraStatus" value="${managerKraStatus}">
                    <input type="hidden" id="pmpmidyearstatus" name="pmpmidyearstatus" value="${pmpmidyearstatus}">
                    <input type="hidden" id="pmpendyearstatus" name="pmpendyearstatus" value="${pmpendyearstatus}">
                    <input type="hidden" id="pmpasManager" name="pmpasManager" value="${pmpasManager}">

                    <input type="hidden" name="tflagId" id="tflagId" value="${Tflag}">
                    <input type="hidden" name="flagId" id="flagId" value="${flag}">
                    <input type="hidden" name="flagMidId" id="flagMidId" value="${flag1}">
                    <input type="hidden" name="flagEndId" id="flagEndId" value="${flag2}">
                    <input type="hidden" name="employeeId" id="employeeId" value="${employeeId}">
                    <input type="hidden" name="managerIdpStatus" id="managerIdpStatus" value="${managerIdpStatus}">
                    <input type="hidden" name="employeeIdpStatus" id="employeeIdpStatus" value="${employeeIdpStatus}">


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
                                <form:form class="form-horizontal" id="form1" role="form1" action="appraisalPerformance.htm?act=createSubmitIdpManagerForManager" commandName="appraisalPerformanceMaster" enctype="multipart/form-data" method="post" name='form' >
                                    <input type="hidden" id="appraisalId" name="appraisalId" value="${appraisalId}">
                                    <!--form horizontal starts here-->
                                    <!--<form class="form-horizontal" role="form" commandName="AppraisalPerformanceMaster">-->
                                    <div class="box box-info collapsed-box ">
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
                                    </div><!-- /.row -->

                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">Individual Development Plan(Training Need Identification):</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId4">Expand</span><span class="btn btn-box-tool" id="btn5" data-widget="collapse" onclick="buttonFun4();"><i class="fa fa-plus" id="minusId4" ></i></span>
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
                                                                <th style="text-align: center"></th><!--Add New-->
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
                                                                        <td id="indDevId"><textarea type="Text" id="text${status.count}" name="text${status.count}" class="form-control saveRequried" readonly>${individualDevelopmentPlan.managertext1}</textarea></td>
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
                                                                                    <input style='display: none;' type="button" value="+" id="addIndividualId" />
                                                                                </span>
                                                                            </td>
                                                                        </c:if>
                                                                        <c:if test="${!status.last}">
                                                                            <td id="" style="text-align: center">
                                                                                <span style="margin-top: 5px;">
                                                                                    <c:if test="${flag eq 'true' || flag1 eq 'true' || flag2 eq 'true'}">
                                                                                        <input style='display: none;' type="button" value="-" id="removeRowButtonId" onclick="removeIndividualChild('individualTrId${status.count}', 'individualEmpMidLabel1TrId${status.count}', 'individualEmpMid1TrId${status.count}', 'individualEmpMidLabel2TrId${status.count}', 'individualEmpMid2TrId${status.count}', '${individualDevelopmentPlan.id}');">
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

                                                                            <td colspan="3" id="midYearRetxtId${status.count}"><textarea rows="3" style="width: 451px;" id="midYearRemark${status.count}" name="midYearRemark${status.count}" class="form-control saveRequried">${individualDevelopmentPlan.managerMidYearRemarkManager}</textarea></td>
                                                                            <td colspan="3" id="endYearRetxtId${status.count}"><textarea rows="3" style="width: 451px;" id="endYearRemark${status.count}" name="endYearRemark${status.count}" class="form-control saveRequried">${individualDevelopmentPlan.managerEndYearRemarkEmployee}</textarea></td>
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
                                                                        <td><textarea type="Text" id="text" name="text" class="form-control saveRequried" readonly></textarea></td>
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
                                                                                <input type="button" style="display: none;" value="+" id="addIndividualId" />
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

                                    <c:if test="${Tflag eq 'true'}">
                                        <div class="form-group">
                                            <div class="col-sm-12">
                                                <c:choose>
                                                    <c:when test="${managerIdpStatus eq '0'}">
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
                                              action="appraisalPerformance.htm?act=reworkByManagerForIdp" commandName=""
                                              method="post"  name='form11' id ="form11" class="form-horizontal" role="form"> 
                                            <input type="hidden" id="pmpIdForRework" name="pmpIdForRework" value="${appraisalId}">
                                            <input type="hidden" name="flagId1" id="flagId" value="${flag}">
                                            <input type="hidden" name="flagMidId1" id="flagMidId" value="${flag1}">
                                            <input type="hidden" name="flagEndId1" id="flagEndId" value="${flag2}">
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
        var managerStatusVar = document.getElementById("managerIdpStatus").value;
        var flagmid = document.getElementById("flagMidId").value;
        var flagEndId = document.getElementById("flagEndId").value;
        if (managerStatusVar === '1') {
            $("#form1 :input").attr("disabled", true);

            $("#btn5").attr("disabled", false);
        }
    </script>
    <script>
        $(document).keydown(function (objEvent) {
            if (objEvent.keyCode == 9) {  //tab pressed
                objEvent.preventDefault(); // stops its action
            }
        });

        $(document).ready(function () {
//            alert('${sessionScope.employeeInfo.competencyEvaluationId}');

            var subCompentencyCountId = document.getElementById("subCompentencyCount").value;
            if (subCompentencyCountId == 0) {
                myajaxfunManager1('${sessionScope.employeeInfo.competencyEvaluationId}');
            }
        });
    </script>
    <style>
        .class-with-width { width: 150px !important; }
    </style>
    <!--<script type="text/javascript" src="StorageYard/Plugins/alert/sweetalert-dev.js"></script>-->
    <script type="text/javascript" src="StorageYard/Plugins/alert/bootbox.min.js"></script>
</html>
