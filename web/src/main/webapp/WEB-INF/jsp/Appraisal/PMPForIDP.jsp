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
    <%@include file="/WEB-INF/jsp/Common/EmployeeCommanForIDP.jsp"%>
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
                    <input type="hidden" id="pmpstartyearstatus" name="pmpstartyearstatus" value="${pmpstartyearstatus}">
                    <input type="hidden" id="pmpmidyearstatus" name="pmpmidyearstatus" value="${pmpmidyearstatus}">
                    <input type="hidden" id="pmpendyearstatus" name="pmpendyearstatus" value="${pmpendyearstatus}">
                    <input type="hidden" id="pmpasEmployee" name="pmpasEmployee" value="${pmpasEmployee}">

                    <input type="hidden" name="tflagId" id="tflagId" value="${Tflag}">
                    <input type="hidden" name="flagId" id="flagId" value="${flag}">
                    <input type="hidden" name="flagMidId" id="flagMidId" value="${flag1}">
                    <input type="hidden" name="flagEndId" id="flagEndId" value="${flag2}">
                    <input type="hidden" name="status1" id="status1" value="${status}">
                    <input type="hidden" name="kraremovedIdVal" id="kraremovedIdVal" value="">
                    <input type="hidden" id="managerStatus" name="managerStatus" value="${managerStatus}">
                    <input type="hidden" id="employeeStatus" name="employeeStatus" value="${employeeStatus}">

                    <input type="hidden" id="employeeIdpStatus" name="employeeIdpStatus" value="${employeeIdpStatus}">
                    <input type="hidden" id="managerIdpStatus" name="managerIdpStatus" value="${managerIdpStatus}">
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
                                <form:form class="form-horizontal" id="form1" role="form1" action="appraisalPerformance.htm?act=createSubmitIDP" commandName="appraisalPerformanceMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
                                    <!--form horizontal starts here-->
                                    <input type="hidden" id="year" name="year" value="${year}">
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
                                            <h3 class="box-title">Individual Development Plan(Training Need Identification):</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId4">Expand</span><span class="btn btn-box-tool" data-widget="collapse" id="btn5" onclick="buttonFun4();"><i class="fa fa-plus" id="minusId4" ></i></span>

                                            </div>
                                        </div>
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
                                                                            <td id="indDevId"><textarea type="Text" id="text${status.count}" name="text${status.count}" class="form-control saveRequried">${individualDevelopmentPlan.text1}</textarea></td>
                                                                            <td><div>
                                                                                    <select id="individualtextDiv${status.count}" name="individualtextDiv${status.count}" value="${individualDevelopmentPlan.text2}" class="form-control saveRequried">
                                                                                        <option value="">--SELECT--</option>
                                                                                        <c:choose>
                                                                                            <c:when test="${individualDevelopmentPlan.text2 eq 'Technical'}">

                                                                                                <option value="Technical" selected="">Technical</option>
                                                                                            </c:when>
                                                                                            <c:otherwise>

                                                                                                <option value="Technical">Technical</option>
                                                                                            </c:otherwise>
                                                                                        </c:choose>
                                                                                        <c:choose>
                                                                                            <c:when test="${individualDevelopmentPlan.text2 eq 'Other'}">

                                                                                                <option value="Other" selected="">Other</option>
                                                                                            </c:when>
                                                                                            <c:otherwise>

                                                                                                <option value="Other">Other</option>
                                                                                            </c:otherwise>
                                                                                        </c:choose>
                                                                                        <c:choose>
                                                                                            <c:when test="${individualDevelopmentPlan.text2 eq 'Soft Skill'}">

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
                                                                                    <select id="trainingSelectId${status.count}" name="trainingSelectId${status.count}" value="${individualDevelopmentPlan.text3}" class="form-control saveRequried" onchange="trainingSelect(${status.count});">
                                                                                        <option value="">--SELECT--</option>
                                                                                        <c:choose>
                                                                                            <c:when test="${individualDevelopmentPlan.text3 eq 'On The Job Training'}">

                                                                                                <option value="On The Job Training" selected="">On The Job Training</option>
                                                                                            </c:when>
                                                                                            <c:otherwise>

                                                                                                <option value="On The Job Training">On The Job Training</option>
                                                                                            </c:otherwise>
                                                                                        </c:choose>
                                                                                        <c:choose>
                                                                                            <c:when test="${individualDevelopmentPlan.text3 eq 'Classroom Training'}">

                                                                                                <option value="Classroom Training" selected="">Classroom Training</option>
                                                                                            </c:when>
                                                                                            <c:otherwise>

                                                                                                <option value="Classroom Training">Classroom Training</option>
                                                                                            </c:otherwise>
                                                                                        </c:choose>
                                                                                        <c:choose>
                                                                                            <c:when test="${individualDevelopmentPlan.text3 eq 'Other'}">

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
                                                                                    <textarea class="form-control saveRequried" id="trainingSelectTextinput${status.count}" name="trainingSelectTextinput${status.count}" style="display: none">${individualDevelopmentPlan.remark}</textarea>
                                                                                </div>
                                                                            </td>
                                                                            <c:if test="${status.last}">

                                                                                <td style="text-align: center">
                                                                                    <span style='margin-top: 5px;'>
                                                                                        <c:if test="${flag eq 'true' || flag1 eq 'true' || flag2 eq 'true'}">
                                                                                            <input type="button" value="+" id="addIndividualId" />
                                                                                        </c:if>
                                                                                    </span>
                                                                                </td>
                                                                            </c:if>
                                                                            <c:if test="${!status.last && statusFlag eq 0}">
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
                                                                                <td colspan="3"><textarea rows="3" id="managerMidYearRemark${status.count}" style="width: 451px;" name="managerMidYearRemark${status.count}" class="form-control saveRequried">${individualDevelopmentPlan.managerMidYearRemarkEmployee}</textarea></td>
                                                                                <td colspan="3"><textarea rows="3" id="managerEndYearRemark${status.count}" style="width: 451px;" name="managerEndYearRemark${status.count}" class="form-control saveRequried">${individualDevelopmentPlan.managerEndYearRemarkManager}</textarea></td>
                                                                            </tr>
                                                                        </c:if>
                                                                    </c:forEach>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <input type="hidden" name="IndividualId" id="IndividualId" value="1">
                                                                    <tr>
                                                                        <td style="text-align: center">1</td>
                                                                        <td><textarea type="Text" id="text1" name="text1" class="form-control"></textarea></td>
                                                                        <td><div>
                                                                                <select id="individualtextDiv1" name="individualtextDiv1" class="form-control">
                                                                                    <option value="">--SELECT--</option>
                                                                                    <option value="Technical">Technical</option>
                                                                                    <option value="Other">Other</option>
                                                                                    <option value="Soft Skill">Soft Skill</option>

                                                                                </select>
                                                                            </div>
                                                                        </td>
                                                                        <td><div>
                                                                                <select id="trainingSelectId1" name="trainingSelectId1" class="form-control" onchange="trainingSelect(1)">
                                                                                    <option value="">--SELECT--</option>
                                                                                    <option value="On The Job Training">On The Job Training</option>
                                                                                    <option value="Classroom Training">Classroom Training</option>
                                                                                    <option value="Other">Other</option>
                                                                                </select>
                                                                            </div>
                                                                        </td>
                                                                        <td><div>
                                                                                <textarea class="form-control" id="trainingSelectTextinput1" name="trainingSelectTextinput1" style="display: none"></textarea>
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
                                                                        <td colspan="3"><textarea rows="3" id="midYearRemark1" style="width: 451px;" name="midYearRemark1" class="form-control"></textarea></td>
                                                                        <td colspan="3"><textarea rows="3" id="endYearRemark1" style="width: 451px;" name="endYearRemark1" class="form-control"></textarea></td>
                                                                    </tr>
                                                                    <tr></tr>
                                                                    <tr>
                                                                        <td colspan="3" id="endYearReId"><b>Manager Mid-Year Remark</b></td>
                                                                        <td colspan="3" id="endYearReId"><b>Manager End-Year Remark</b></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td colspan="3"><textarea rows="3" id="managerMidYearRemark1" style="width: 451px;" name="managerMidYearRemark1" class="form-control"></textarea></td>
                                                                        <td colspan="3"><textarea rows="3" id="managerEndYearRemark1" style="width: 451px;" name="managerEndYearRemark1" class="form-control"></textarea></td>
                                                                    </tr>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </table>

                                                    </div>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>

                                    <c:if test="${appraisalPerformanceMaster.idpReworkStatus eq 1}">

                                        <div class="box box-info collapsed-box">
                                            <div class="box-header">
                                                <h3 class="box-title">Reworked Comment:</h3>
                                                <div class="box-tools pull-right">
                                                    <span id="spanId7">Expand</span><span class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun7()"><i class="fa fa-plus" id="minusId7"></i></span>
                                                </div>

                                            </div><!-- /.box-header -->
                                            <div class="box-body no-padding">
                                                <div class="row">
                                                    <div class="col-md-12 col-sm-12">
                                                        <div class="form-group">
                                                            <label class="col-sm-3 control-label">Comment:</label>
                                                            <div class="col-sm-7">
                                                                <form:textarea path="idpReworkComment" class="form-control" readonly="true" rows="6"></form:textarea>
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
                                                    <c:when test="${employeeIdpStatus eq '0'}">
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
//        var tflag11 = document.getElementById("tflagId").value;
//        var flag11 = document.getElementById("flagId").value;
//        var employeeStatusVar = document.getElementById("employeeStatus").value;
        var employeeStatusVar = document.getElementById("employeeIdpStatus").value;
//        var flagmid = document.getElementById("flagMidId").value;
//        var flagEndId = document.getElementById("flagEndId").value;

        if (employeeStatusVar === '1') {
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
    </script>

    <style>
        .class-with-width { width: 150px !important; }
    </style>
    <script type="text/javascript" src="StorageYard/Plugins/alert/bootbox.min.js"></script>
</html>
