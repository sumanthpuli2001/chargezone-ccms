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
    <%--<%@include file="/WEB-INF/jsp/Common/EmployeeComman.jsp"%>--%>
    <%@include file="/WEB-INF/jsp/Common/EmployeeComman2017.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Performance Appraisal Form</title>
        <style>
            form { position: relative;}

            :required:focus {
                box-shadow: 0  0 3px rgba(255,0,0,0.5);
            }
        </style>
        <!--        <script>
                    document.querySelector("form")
                            .addEventListener("invalid", function (event) {
                                event.preventDefault();
                            }, true);
                </script>-->

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
    <body onload="myFunction()">

        <h1>Hello World!</h1>

        <script>
            function myFunction() {
                setInterval(function () {
                    document.getElementById("save").click()
//                    alert("Hello");
                }, 300000);
            }
        </script>

    </body>
    <script>
        window.onload = myFunction()
//        function myFunction() {
//            setInterval(function () {
//                alert("Hello");
//            }, 3000);
//        }
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
                    <a href="appraisalPerformance.htm?act=appraisalPrintToPdfByEmployee&id=${empId}&userid=${userid}&appraisalId=${appraisalId}&year=${year}" target="_blank"  class="btn btn-primary">Print</a>

                    <input type="hidden" id="empId" name="empId" value="${empId}">
                    <input type="hidden" id="userid" name="userid" value="${userid}">
                    <input type="hidden" id="appraisalId" name="appraisalId" value="${appraisalId}">
                    <input type="hidden" id="managerStatus" name="managerStatus" value="${managerStatus}">
                    <input type="hidden" id="pmpstartyearstatus" name="pmpstartyearstatus" value="${pmpstartyearstatus}">
                    <input type="hidden" id="pmpmidyearstatus" name="pmpmidyearstatus" value="${pmpmidyearstatus}">
                    <input type="hidden" id="pmpendyearstatus" name="pmpendyearstatus" value="${pmpendyearstatus}">
                    <input type="hidden" id="pmpasEmployee" name="pmpasEmployee" value="${pmpasEmployee}">
                </div>
                <input type="button" class="btn btn-primary btn-xs" value="Back" onclick="window.history.back();" />
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
                                <form:form class="form-horizontal" id="form1" role="form1" action="appraisalPerformance.htm?act=createSubmit" commandName="appraisalPerformanceMaster" enctype="multipart/form-data" method="post" name='form'>
                                    <input type="hidden" id="yearparmStr" name="yearparmStr" value="${year}">
                                    <div id="autocall" onload="myFunction();" hidden></div>
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



                                    <!--Employee detail completes here-->
                                    <%--<c:if test="${flag eq 'true' || flag1 eq 'true' || flag2 eq 'true'}"></c:if>--%>
                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">Results:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId2">Expand</span><span class="btn btn-box-tool" id="btn2" data-widget="collapse" onclick="buttonFun2();"><i class="fa fa-plus" id="minusId2" ></i></span>
                                                <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body">

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
                                                            <input type="hidden" name="cycleCompletedflag" id="cycleCompletedflag" value="${cycleCompletedflag}">

                                                            <th style="text-align: center">Sr. No.</th>


                                                            <th style="text-align: center" id="kraGoalid1">High Impact Goal / KRA</th>
                                                            <th style="text-align: center" id="metricid1">Time Space</th>
                                                            <th style="text-align: center" id="metricid1">KRA Category</th>

                                                            <th style="margin: 0px;width: 25px;text-align: center;" id="weightageid12">Weightage Out Of 75</th>
                                                            <!--<th style="display: none;" id='weightageOut'></th>-->


<!--                                                            <th style="margin: 0px;width: 70px;text-align: center" id="midYearDivid">Mid Year Status</th>-->
                                                            <th style="margin: 0px;text-align: center" id="endYearDivid1">Status</th>
                                                            <th style="margin: 0px;text-align: center" id="empfinalScoreid01">Employee Score</th>
                                                            <th style="margin: 0px;text-align: center" id="finalScoreid01">Manager Final Score</th>

                                                            <th style="text-align: center;width: 50px" id="editT">Edit <br><a href="#" title="Deleted KRA" data-toggle="modal" data-target="#deletedKraModel" onclick="deletedKraajaxfun('${appraisalId}');" style="color: red;">KRA</a> </th>
                                                            <th style="text-align: center;width: 50px"><span style='margin-top: 5px;'>Add New KRA
                                                                    <c:if test="${flag ne 'true' && flag1 ne 'true' && flag2 ne 'true'}">
                                                                        <input type="button" value="+" id="addRowButtonId" title="Add New" />
                                                                    </c:if>
                                                                    <c:if test="${flag eq 'true' || flag1 eq 'true' || flag2 eq 'true'}">
                                                                        <input type="button" value="+" id="addRowButtonId" title="Add New" />
                                                                    </c:if>
                                                                </span></th>

                                                            </tr>
                                                            <input type="hidden" name="kragoalLength" id="kragoalLength" value="${fn:length(kragoal)}">
                                                            <c:choose>
                                                                <c:when test="${fn:length(kragoal) > 0}">
                                                                    <input type="hidden" name="countId" id="countId" value="${fn:length(kragoal)}">
                                                                    <!--<input type="button" value="CountId" onclick="alert(document.getElementById('countId').value);"/>-->
                                                                    <c:set var="resultCount" value="${fn:length(kragoal)}"></c:set>
                                                                    <c:forEach var="kragoallist" items="${kragoal}" varStatus="status">
                                                                        <%--  <c:if test="${(kragoallist.kraGoal ne '' || kragoallist.metric ne '') ||
                                                                                      ((kragoallist.kraGoal eq '' || kragoallist.metric eq '')&&
(kragoallist.kraGoalByManager ne '' || kragoallist.matrixByManager ne ''))}"> --%>
                                                                        <!--Lock Assecement-->
                                                                        <input type="hidden" name="midyearEmpSelfassStatus${status.count}" id="midyearEmpSelfassStatus${status.count}" value="${kragoallist.midyearEmpSelfassStatus}">
                                                                        <input type="hidden" name="midyearManagerSelfassStatus${status.count}" id="midyearManagerSelfassStatus${status.count}" value="${kragoallist.midyearManagerSelfassStatus}">
                                                                        <input type="hidden" name="endyearEmpSelfassStatus${status.count}" id="endyearEmpSelfassStatus${status.count}" value="${kragoallist.endyearEmpSelfassStatus}">
                                                                        <input type="hidden" name="endyearManagerSelfassStatus${status.count}" id="endyearManagerSelfassStatus${status.count}" value="${kragoallist.endyearManagerSelfassStatus}">

                                                                        <tr id="removeTr${status.count}">
                                                                        <input type="hidden" name="kragoal_id${status.count}" id="kragoal_id${status.count}" value="${kragoallist.id}">
                                                                        <td id="removeKRAID${status.count}" class="removeClass" style="margin: 0px;width: 45px;"><span>${status.count} </span></td>


                                                                        <td id="kraGoalid1${status.count}"><textarea type="Text" name="kraGoal${status.count}" id="kraGoal${status.count}"  class="form-control">${kragoallist.kraGoal}</textarea></td>
                                                                        <td id="metricid1${status.count}"><textarea type="Text" name="metric${status.count}" id="metric${status.count}" class="form-control">${kragoallist.metric}</textarea></td>

                                                                        <!--By Ajay Start-->
                                                                        <td id="kraCategoryId${status.count}">
                                                                            <select id="kraCategoryMap${status.count}" name="kraCategoryMap${status.count}" class="form-control" >
                                                                                <option value="">--SELECT--</option>
                                                                                <c:forEach var="kraCategory" items="${kraCategoryMap}">
                                                                                    <c:if test="${kragoallist.kraCategoryByKraCategoryByEmployee.id eq kraCategory.key}">
                                                                                        <option value="${kraCategory.key}" selected="">${kraCategory.value}</option>
                                                                                    </c:if>
                                                                                    <c:if test="${kragoallist.kraCategoryByKraCategoryByEmployee.id ne kraCategory.key}">
                                                                                        <option value="${kraCategory.key}">${kraCategory.value}</option>
                                                                                    </c:if>
                                                                                </c:forEach>
                                                                            </select>
                                                                        </td>
                                                                        <!--By Ajay  End-->
                                                                        <td id="weightageidT1${status.count}">
                                                                            <c:choose>
                                                                                <c:when test="${appraisalPerformanceMaster.getEmployeeStatus() eq 0}">
                                                                                    <input type="Text" name="weightage${status.count}" id="weightage${status.count}" class="form-control" value="${kragoallist.weightage}" onkeypress="return allowOnlyNumber1(event);" onchange="weightageCountEmp()" style="margin: 0px;width: 67px;">
                                                                                </c:when>
                                                                                <c:otherwise>
                                                                                    <input type="Text" name="weightage${status.count}" id="weightage${status.count}" class="form-control" value="${kragoallist.weightage}" onkeypress="return allowOnlyNumber1(event);" onchange="weightageCountEmp()" style="margin: 0px;width: 67px;">
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </td>
                                                                     
                                                                        <td id="endYearDivid1${status.count}" class="displayAction"><div>
                                                                                <select id="endYearDiv${status.count}" name="endYearDiv${status.count}" value="${kragoallist.endyearStatus}" style="margin: 0px;width: 96px;" class="form-control">

                                                                                    <option value="">SELECT</option>
                                                                                    <c:choose>
                                                                                        <c:when test="${kragoallist.endyearStatus eq 'Yet to Start'}">

                                                                                            <option value="Yet to Start" selected="">Yet to Start</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>

                                                                                            <option value="Yet to Start">Yet to Start</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                    <c:choose>
                                                                                        <c:when test="${kragoallist.endyearStatus eq 'In Progress'}">

                                                                                            <option value="In Progress" selected="">In Progress</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>

                                                                                            <option value="In Progress">In Progress</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                    <c:choose>
                                                                                        <c:when test="${kragoallist.endyearStatus eq 'Completed'}">

                                                                                            <option value="Completed" selected="">Completed</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>

                                                                                            <option value="Completed">Completed</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                    <c:choose>
                                                                                        <c:when test="${kragoallist.endyearStatus eq 'Canceled'}">

                                                                                            <option value="Canceled" selected="">Canceled</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>

                                                                                            <option value="Canceled">Canceled</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                </select>
                                                                            </div>
                                                                        </td>
                                                                        <td id="empfinalScoreid${status.count}"><input type="Text" id="empfinalScore${status.count}" name="empfinalScore${status.count}" value="${kragoallist.empFinalScore}" class="form-control" style="margin: 0px;"  onkeypress="return allowOnlyNumber1(event);" onchange="CountEmpScore();" readonly="true"></td>
                                                                        <td id="finalScoreid${status.count}"><input type="Text" id="finalScore${status.count}" name="finalScore${status.count}" value="${kragoallist.finalScore}" class="form-control" style="margin: 0px;" readonly="true"></td>


                                                                        <td style="text-align: center" id="edit${status.count}"><span style='margin-top: 5px;' id="editC${status.count}">
                                                                                <%--<c:if test="${flag ne 'true' && flag1 ne 'true' && flag2 ne 'true'}">--%>
                                                                                <button type="button" class="btns btn-warnings" id="EditByEmployee${status.count}" name="EditByEmployee${status.count}" onclick="changeReadonly('${status.count}')" style="width: 50px;" >Edit</button>
                                                                                <%--</c:if>--%>
                                                                                <%--<c:if test="${flag eq 'true' || flag1 eq 'true' || flag2 eq 'true'}">--%>
                                                                                    <!--<button type="button" class="btn btn-warning" id="EditByEmployee" name="EditByEmployee" onclick="changeReadonly('${status.count}')" style="width: 50px;">Edit</button>-->
                                                                                <%--</c:if>--%>
                                                                            </span><br/>
                                                                            <span>${kragoallist.editDate}</span>
                                                                            <input type="hidden" id="startDate${status.count}" name="startDate${status.count}" value="${kragoallist.startDate}">
                                                                            <!--<a href="#" data-toggle="modal" data-target="#History" id="d1" name="dhaval1" onclick="historyajaxfun();">History</a>-->
                                                                            <c:if test="${appraisalPerformanceMaster.managerStatus ne 0 and updateStatus}">
                                                                                <!--<a href="" data-toggle="modal" data-target="#modal-fullscreen" onclick="historyajaxfun('${kragoallist.id}');">History</a>-->
                                                                                <!--<a href="" data-toggle="modal" data-target=".bs-example-modal-lg" onclick="historyajaxfun('${kragoallist.id}');">History</a>-->
                                                                                <a href="" data-toggle="modal" data-target="#kraModel" onclick="historyajaxfun('${kragoallist.id}');">History</a>
                                                                            </c:if>
                                                                        </td>
                                                                        <%--<c:if test="${status.last}">--%>
                                                                        <!--<td style="text-align: center">-->
                                                                        <!--<span style='margin-top: 5px;'>-->
                                                                        <%--<c:if test="${flag ne 'true' && flag1 ne 'true' && flag2 ne 'true'}">--%>
                                                                        <!--<input type="button" value="+" id="addRowButtonId" disabled="true" />-->
                                                                        <%--</c:if>--%>
                                                                        <%--<c:if test="${flag eq 'true' || flag1 eq 'true' || flag2 eq 'true'}">--%>
                                                                        <!--<input type="button" value="+" id="addRowButtonId" />-->
                                                                        <%--</c:if>--%>
                                                                        <!--</span>-->
                                                                        <!--</td>-->
                                                                        <%--</c:if>--%>
                                                                        <%--<c:if test="${!status.last}">--%>
                                                                        <td id="" style="text-align: center">
                                                                            <span style="margin-top: 5px;">

                                                                                <c:if test="${(flag eq 'true' || flag1 eq 'true' || flag2 eq 'true') && resultCount > 1 }">
                                                                                    <input type="button" value="-" id="removeRowButtonId" onclick="removeChild3('removeTr${status.count}', 'employeesMid${status.count}', 'textemployeesMid${status.count}', 'employeesEnd${status.count}', 'textemployeesEnd${status.count}', '${kragoallist.id}');" <c:if test="${employeeStatus eq 1}">disabled="true"</c:if>>
                                                                                </c:if>
                                                                            </span>
                                                                        </td>
                                                                        <%--</c:if>--%>

                                                                        </tr>
<!--                                                                        <tr id="employeesMid${status.count}">
                                                                            <td colspan="4"><b>Employee’s Mid - Year Self – Assessment KRA:</b></td>
                                                                            <td colspan="4"><b>Manager’s Mid - Year Review / Evaluation KRA:</b></td>
                                                                        </tr>
                                                                        <tr id="textemployeesMid${status.count}" class="displayAction">
                                                                            <td colspan="4"><textarea id="employeeMidYearSelfAssesssmentGoal${status.count}" style="width: 474px;" name="employeeMidYearSelfAssesssmentGoal${status.count}"type="Text" class="form-control">${kragoallist.empMidyearSelfassessmentGoal}</textarea></td>
                                                                            <td colspan="4"><textarea id="managerMidYearSelfAssesssmentGoal${status.count}" style="width: 474px;" name="managerMidYearSelfAssesssmentGoal${status.count}" type="Text" class="form-control">${kragoallist.managerMidyearReviewEvaluation}</textarea></td>
                                                                        </tr>-->

                                                                        <tr id="employeesEnd${status.count}">
                                                                            <td colspan="4"><b>Employee’s  Self – Assessment KRA:</b></td>
                                                                            <td colspan="4"><b>Manager’s  Review / Evaluation KRA:</b></td>
                                                                        </tr>
                                                                        <tr id="textemployeesEnd${status.count}" class="displayAction">
                                                                            <td colspan="4"><textarea id="employeeEndYearSelfAssesssmentGoal${status.count}" style="width: 474px;" name="employeeEndYearSelfAssesssmentGoal${status.count}" type="Text" class="form-control">${kragoallist.empEndyearSelfassessmentGoal}</textarea></td>
                                                                            <td colspan="4"><textarea id="managerEndYearSelfAssesssmentGoal${status.count}" style="width: 474px;" name="managerEndYearSelfAssesssmentGoal${status.count}" type="Text" class="form-control">${kragoallist.managerEndyearReviewEvaluation}</textarea></td>
                                                                        </tr>
                                                                        <%--</c:if>--%>
                                                                    </c:forEach>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <input type="hidden" name="countId" id="countId" value="1">
                                                                    <input type="hidden" name="midyearEmpSelfassStatus1" id="midyearEmpSelfassStatus1" value="0">
                                                                    <input type="hidden" name="endyearEmpSelfassStatus1" id="endyearEmpSelfassStatus1" value="0">
                                                                    <tr id="row_1_1">
                                                                        <td style="margin: 0px;width: 45px;">1</td>
                                                                        <%--<c:if test="${flag eq true}">--%>
                                                                        <!--<td id="kraGoalid"><textarea type="Text" name="kraGoal1" id="kraGoal1" class="form-control"></textarea></td>-->
                                                                        <td id="kraGoalid"><textarea type="Text" name="kraGoal1" id="kraGoal1"  class="form-control"></textarea></td>
                                                                        <td id="metricid"><textarea type="Text" name="metric1" id="metric1" class="form-control"></textarea></td>
                                                                        <td id="kraCategoryId">
                                                                            <select id="kraCategoryMap1" name="kraCategoryMap1" class="form-control" style="margin: 0px;width: 115px;">
                                                                                <option value="">--SELECT--</option>
                                                                                <c:forEach var="kraCategory" items="${kraCategoryMap}">
                                                                                    <option value="${kraCategory.key}">${kraCategory.value}</option>
                                                                                </c:forEach>
                                                                            </select>
                                                                        </td>
                                                                        <%--</c:if>--%>
                                                                        <%--<c:if test="${flag ne true}">--%>

                                                                        <td id="weightageid"><input type="Text" name="weightage1" id="weightage1" class="form-control" onkeypress="return allowOnlyNumber1(event);" onchange="weightageCountEmp()" style="margin: 0px;width: 100px;"></td>
                                                                        
                                                                        <td id="endYearDivid"><div>
                                                                                <select id="endYearDiv1" name="endYearDiv1" class="form-control" style="margin: 0px;width: 115px;">
                                                                                    <option value="">--SELECT--</option>
                                                                                    <option value="Yet to Start">Yet to Start</option>
                                                                                    <option value="In Progress">In Progress</option>
                                                                                    <option value="Completed">Completed</option>
                                                                                    <option value="Canceled">Canceled</option>
                                                                                </select>
                                                                            </div>
                                                                        </td>
                                                                        <td id="empfinalScoreid"><input type="Text" id="empfinalScore1" name="empfinalScore1" class="form-control" style="margin: 0px;" onkeypress="return allowOnlyNumber1(event);" onchange="CountEmpScore();" ></td>
                                                                        <td id="finalScoreid"><input type="Text" id="finalScore1" name="finalScore1" class="form-control" style="margin: 0px;"></td>



                                                                        <td style="text-align: center" id="edit"><span style='margin-top: 5px;'><button type="button" class="btns btn-warnings" style="width: 50px;">Edit</button></span><br/>
                                                                        </td>
                                                                    <input type="hidden" id="startDate1" name="startDate1" value="${kragoal[0].startDate}">
                                                                    <td style="text-align: center"><span style='margin-top: 5px;'>
                                                                            <!--<input type="button" value="-" id="removeRowButtonId" onclick="removeChild4('removeTr', 'employeesMid', 'textemployeesMid', 'employeesEnd', 'textemployeesEnd');">-->
                                                                        </span>
                                                                    </td>

<!--                                                                    <tr id="employeesMid">
                                                                        <td colspan="4"><b>Employee’s Mid - Year Self – Assessment KRA:</b></td>
                                                                        <td colspan="4"><b>Manager’s Mid - Year Review / Evaluation KRA:</b></td>
                                                                    </tr>
                                                                    <tr id="textemployeesMid">
                                                                        <td colspan="4"><textarea id="employeeMidYearSelfAssesssmentGoal1" style="width: 474px;" name="employeeMidYearSelfAssesssmentGoal1" type="Text" class="form-control"></textarea></td>
                                                                        <td colspan="4"><textarea id="managerMidYearSelfAssesssmentGoal1" style="width: 474px;" name="managerMidYearSelfAssesssmentGoal1" type="Text" class="form-control"></textarea></td>
                                                                    </tr>-->

                                                                    <tr id="employeesEnd">
                                                                        <td colspan="4"><b>Employee’s  Self – Assessment KRA:</b></td>
                                                                        <td colspan="4"><b>Manager’s Review / Evaluation KRA:</b></td>
                                                                    </tr>
                                                                    <tr id="textemployeesEnd">
                                                                        <td colspan="4"><textarea id="employeeEndYearSelfAssesssmentGoal1" style="width: 474px;" name="employeeEndYearSelfAssesssmentGoal1" type="Text" class="form-control"></textarea></td>
                                                                        <td colspan="4"><textarea id="managerEndYearSelfAssesssmentGoal1" style="width: 474px;" name="managerEndYearSelfAssesssmentGoal1" type="Text" class="form-control"></textarea></td>
                                                                    </tr>



                                                                </c:otherwise>
                                                            </c:choose>
                                                        </table>

                                                    </div>
                                                    <div class="table-responsive">
                                                        <table id="demo1" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                            <tr id="weightage">
<!--                                                                <td style="margin: 0px;width: 100px;"></td>
                                                                <td style="margin: 0px;width: 100px;"></td>-->
                                                                <td style="margin: 0px;width: 285px;" id="weightageScoreId" align="right"><b>Weightage</b></td>
                                                                <td style="margin: 0px;width: 100px;" id="dhaval">
                                                                    <input type="text" id="weightageScore" name="weightageScore" class="form-control"  value="${weightageScore}" style="margin: 0px;width: 100px;" readonly="true">
                                                                </td>
                                                                <td style="margin: 0px;width: 285px;" id="empScoreId" align="right"><b>Employee Total Score</b></td>
                                                                <td style="margin: 0px;width: 100px;" id="dhaval">
                                                                    <input type="text" id="empScore" name="empScore" class="form-control"  value="${empScore}" style="margin: 0px;width: 100px;" readonly="true">
                                                                </td>

                                                                <td style="margin: 0px;width: 170px;">
                                                                </td>
                                                                <td style="margin: 0px;width: 90px;" id="totalScoreId" align="right"><b>Manager Total Score</b>
                                                                </td>
                                                                <!--<td><input id="totalScore" name="totalScore" value="${totalScore}" class="form-control" value="${totalScore}" style="margin: 0px;width: 100px;" readonly="true"></input></td>-->
                                                                <td><input id="totalScore" name="totalScore"  class="form-control" value="${totalScore}" style="margin: 0px;width: 100px;" readonly="true"></input></td>
                                                                <td></td>
                                                            </tr>
                                                        </table>

                                                    </div>


                                                </div><!-- /.col -->

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


                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->

                                    </div>
                                    <%--<c:if test="${year eq 2016}"></c:if>--%>
                                    <!--changes by dhaval-->                               


                                    <!--changes by dhaval--> 

                                    <!--change by date 11/11/2016-->
                                    <!--                                    <div class="box box-info collapsed-box displayAction">
                                                                            <div class="box-header">
                                                                                <h3 class="box-title">Competency Evaluation (As Per Zydex Competency Framework) :${cpmname}</h3>
                                                                                <div class="box-tools pull-right">
                                                                                    <span id="spanId3">Expand</span><span class="btn btn-box-tool" id="btn4" data-widget="collapse" onclick="
                                                                                            buttonFun3();"><i class="fa fa-plus" id="minusId3" ></i></span>
                                                                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
                                                                                </div>
                                                                            </div> /.box-header
                                                                            <div class="box-body no-padding">
                                                                                <div class="row">
                                                                                    <div class="col-md-12 col-sm-12">
                                    <%--<c:if test="${empty competencyEvaluationList[0][2].title}">--%>
                                    <div>

                                    <select name="competencyEvaluation_Id" id="competencyEvaluation_Id" class="form-control" onchange="ajaxfun();"/>
                                    <option value="">--SELECT--</option>
                                    <%--<c:forEach var="competencyMap" items="${competencyMap}">--%>
                                        <option value="$/{competencyMap.key}">$/{competencyMap.value}</option>
                                    <%--</c:forEach>--%>
                                    </select>
                                    </div>
                                    <%--</c:if>--%>

                                    <%--<c:if test="${empty competencyEvaluationList[0][2].title || appraisalPerformanceMaster.managerStatus ne 1 }">--%>

                                    <div>
                                    <select name="competencyEvaluation_Id" id="competencyEvaluation_Id" class="form-control" onchange="ajaxfun();"/>
                                    <option value="">--SELECT--</option>
                                    <%--<c:forEach var="competencyMap" items="${competencyMap}">--%>
                                    <%--<c:if test="${competencyEvaluationList[0][2].title  eq competencyMap.value}">--%>
                                    <option value="$/{competencyMap.key}" selected="true">$/{competencyMap.value}</option>
                                    <%--</c:if>--%>
                                    <%--<c:if test="${competencyEvaluationList[0][2].title  ne competencyMap.value}">--%>
                                    <option value="$/{competencyMap.key}">$/{competencyMap.value}</option>
                                    <%--</c:if>--%>
                                    <%--</c:forEach>--%>
                                    </select>
                                    </div>
                                    <%--</c:if>--%>

                                    <%--<c:if test="${appraisalPerformanceMaster.managerStatus eq 1 && !empty competencyEvaluationList[0][2].title}">--%>
                                        <div><input type="text" id="competencyEvaluation_Id" class="form-control" name="competencyEvaluation_Id" value="$/{competencyEvaluationList[0][2].title}" readonly="true"></div>
                                    <%--</c:if>--%>

                                    <%--<c:if test="${appraisalPerformanceMaster.managerStatus ne 1}">--%>
                                        <div><input type="text" id="competencyEvaluation_Id" class="form-control" name="competencyEvaluation_Id" value="$/{competencyEvaluationList[0][2].title}" readonly="true"></div>
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
                                            <input type="hidden" name="subCompentencyCount" id="subCompentencyCount" value="$/{fn:length(competencyEvaluationList)}">
                                    <%--<c:choose>--%>
                                    <%--<c:when test="${fn:length(competencyEvaluationList) > 0}">--%>
                                    <%--<c:forEach var="competencyEvaluationList" items="${competencyEvaluationList}" varStatus="status">--%>

                                        <input type="hidden" name="competencyEveId${status.count}" id="competencyEveId${status.count}" value="${competencyEvaluationList[0]}">
                                        <input type="hidden" name="compentencyTextMasterId${status.count}" id="compentencyTextMasterId${status.count}" value="${competencyEvaluationList[1].id}">
                                        <input type="hidden" name="competencyEvaluationId${status.count}" id="competencyEvaluationId${status.count}" value="${competencyEvaluationList[2].id}">
                                        <input type="hidden" name="compentencyTextMasterId${status.count}" id="compentencyTextMasterId${status.count}" value="${competencyEvaluationList[3].id}">
                                        <tr class="">
                                            <td id="subCompentencySrId${status.count}">${status.count}</td>
                                            <td><input type="text" id="demo" name="demo"></td>
                                            <td>$/{competencyEvaluationList[0][4].infoText}</td>
                                            <td id="subCompentencyTitleId${status.count}" >${competencyEvaluationList[4]}</td>
                                            <td id="subCompentencyStartId${status.count}" >

                                                <select id="competencyStartYear${status.count}" name="compentencyStartYear${status.count}" value="${competencyEvaluationList[5]}"  class="form-control">
                                                    <option value="">--SELECT--</option>
                                    <%--<c:choose>--%>
                                    <%--<c:when test="${competencyEvaluationList[5] eq 'Exceed Expectations'}">--%>

                                        <option value="Exceed Expectations" selected="">Exceed Expectations</option>
                                    <%--</c:when>--%>
                                    <%--<c:otherwise>--%>

                                        <option value="Exceed Expectations">Exceed Expectations</option>
                                    <%--</c:otherwise>--%>
                                    <%--</c:choose>--%>
                                    <%--<c:choose>--%>
                                    <%--<c:when test="${competencyEvaluationList[5] eq 'Meet Expectations'}">--%>

                                        <option value="Meet Expectations" selected="">Meet Expectations</option>
                                    <%--</c:when>--%>
                                    <%--<c:otherwise>--%>

                                        <option value="Meet Expectations">Meet Expectations</option>
                                    <%--</c:otherwise>--%>
                                    <%--</c:choose>--%>
                                    <%--<c:choose>--%>
                                    <%--<c:when test="${competencyEvaluationList[5] eq 'Need Improvement'}">--%>

                                        <option value="Need Improvement" selected="">Need Improvement</option>
                                    <%--</c:when>--%>
                                    <%--<c:otherwise>--%>

                                        <option value="Need Improvement">Need Improvement</option>
                                    <%--</c:otherwise>--%>
                                    <%--</c:choose>--%>
                                </select>
                            </td>
                            <td id="subCompentencyStartRemarkId${status.count}" >
                                <textarea type="Text" id="compentencyStartRemark${status.count}" name="compentencyStartRemark${status.count}" class="form-control"  rows="4">${competencyEvaluationList[6]}</textarea>
                            </td>
                            <td id="subCompentencyMidId${status.count}">
                                <select id="compentencyMidYear${status.count}" name="compentencyMidYear${status.count}" value="${competencyEvaluationList[7]}" class="form-control">
                                    <option value="">--SELECT--</option>
                                    <%--<c:choose>--%>
                                    <%--<c:when test="${competencyEvaluationList[7] eq 'Exceed Expectations'}">--%>

                                        <option value="Exceed Expectations" selected="">Exceed Expectations</option>
                                    <%--</c:when>--%>
                                    <%--<c:otherwise>--%>

                                        <option value="Exceed Expectations">Exceed Expectations</option>
                                    <%--</c:otherwise>--%>
                                    <%--</c:choose>--%>
                                    <%--<c:choose>--%>
                                    <%--<c:when test="${competencyEvaluationList[7] eq 'Meet Expectations'}">--%>

                                        <option value="Meet Expectations" selected="">Meet Expectations</option>
                                    <%--</c:when>--%>
                                    <%--<c:otherwise>--%>

                                        <option value="Meet Expectations">Meet Expectations</option>
                                    <%--</c:otherwise>--%>
                                    <%--</c:choose>--%>
                                    <%--<c:choose>--%>
                                    <%--<c:when test="${competencyEvaluationList[7] eq 'Need Improvement'}">--%>

                                        <option value="Need Improvement" selected="">Need Improvement</option>
                                    <%--</c:when>--%>
                                    <%--<c:otherwise>--%>

                                        <option value="Need Improvement">Need Improvement</option>
                                    <%--</c:otherwise>--%>
                                    <%--</c:choose>--%>
                                </select>
                            </td>
                            <td id="subCompentencyMidRemarkId${status.count}">
                                <textarea type="Text" id="compentencyMidRemark${status.count}" name="compentencyMidRemark${status.count}" class="form-control" rows="4">${competencyEvaluationList[8]}</textarea>
                            </td>
                            <td id="subCompentencyEndId${status.count}">
                                <select id="compentencyEndYear${status.count}" name="compentencyEndYear${status.count}" value="${competencyEvaluationList[9]}" class="form-control">
                                    <option value="">--SELECT--</option>
                                    <%--<c:choose>--%>
                                    <%--<c:when test="${competencyEvaluationList[9] eq 'Exceed Expectations'}">--%>

                                        <option value="Exceed Expectations" selected="">Exceed Expectations</option>
                                    <%--</c:when>--%>
                                    <%--<c:otherwise>--%>

                                        <option value="Exceed Expectations">Exceed Expectations</option>
                                    <%--</c:otherwise>--%>
                                    <%--</c:choose>--%>
                                    <%--<c:choose>--%>
                                    <%--<c:when test="${competencyEvaluationList[9] eq 'Meet Expectations'}">--%>

                                        <option value="Meet Expectations" selected="">Meet Expectations</option>
                                    <%--</c:when>--%>
                                    <%--<c:otherwise>--%>

                                        <option value="Meet Expectations">Meet Expectations</option>
                                    <%--</c:otherwise>--%>
                                    <%--</c:choose>--%>
                                    <%--<c:choose>--%>
                                    <%--<c:when test="${competencyEvaluationList[9] eq 'Need Improvement'}">--%>

                                        <option value="Need Improvement" selected="">Need Improvement</option>
                                    <%--</c:when>--%>
                                    <%--<c:otherwise>--%>

                                        <option value="Need Improvement">Need Improvement</option>
                                    <%--</c:otherwise>--%>
                                    <%--</c:choose>--%>
                                </select>
                            </td>
                            <td id="subCompentencyEndRemarkId${status.count}">
                                <textarea type="Text" id="compentencyEndRemark${status.count}" name="compentencyEndRemark${status.count}" class="form-control" rows="4">${competencyEvaluationList[10]}</textarea>
                            </td>

                        </tr>

                                    <%--</c:forEach>--%>
                                    <%--</c:when>--%>
                                    <%--</c:choose>--%>

                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>-->
                                    <!--change by date 11/11/2016-->

                                    <!--                                    <div class="box box-info collapsed-box displayAction">
                                                                            <div class="box-header">
                                                                                <h3 class="box-title">Individual Development Plan(Training Need Identification):</h3>
                                                                                <div class="box-tools pull-right">
                                                                                    <span id="spanId4">Expand</span><span class="btn btn-box-tool" data-widget="collapse" id="btn5" onclick="buttonFun4();"><i class="fa fa-plus" id="minusId4" ></i></span>
                                                                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
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

                                    <%--<c:choose>--%>
                                    <%--<c:when test="${not empty individualDevelopmentPlanList}">--%>
                                    <input type="hidden" name="IndividualId" id="IndividualId" value="$/{fn:length(individualDevelopmentPlanList)}">

                                    <%--<c:forEach var="individualDevelopmentPlan" items="${individualDevelopmentPlanList}" varStatus="status">--%>
                                    <%--<c:if test="${individualDevelopmentPlan.text1 ne '' && individualDevelopmentPlan.text2 ne '' && individualDevelopmentPlan.text3 ne ''}">--%>
                                        <tr id="individualTrId$/{status.count}">
                                            <td id="removeKRAIndividualID$/{status.count}" name="removeKRAIndividualID$/{status.count}" style="text-align: center">$/{status.count}</td>
                                        <input type="hidden" name="IndividualDevelopmentPlanId$/{status.count}" id="IndividualDevelopmentPlanId$/{status.count}" value="$/{individualDevelopmentPlan.id}">
                                        <td id="indDevId"><textarea type="Text" id="text$/{status.count}" name="text$/{status.count}" class="form-control saveRequried">$/{individualDevelopmentPlan.text1}</textarea></td>
                                        <td><div>
                                                <select id="individualtextDiv$/{status.count}" name="individualtextDiv$/{status.count}" value="$/{individualDevelopmentPlan.text2}" class="form-control saveRequried">
                                                    <option value="">--SELECT--</option>
                                    <%--<c:choose>--%>
                                    <%--<c:when test="${individualDevelopmentPlan.text2 eq 'Technical'}">--%>

                                        <option value="Technical" selected="">Technical</option>
                                    <%--</c:when>--%>
                                    <%--<c:otherwise>--%>

                                        <option value="Technical">Technical</option>
                                    <%--</c:otherwise>--%>
                                    <%--</c:choose>--%>
                                    <%--<c:choose>--%>
                                    <%--<c:when test="${individualDevelopmentPlan.text2 eq 'Other'}">--%>

                                        <option value="Other" selected="">Other</option>
                                    <%--</c:when>--%>
                                    <%--<c:otherwise>--%>

                                        <option value="Other">Other</option>
                                    <%--</c:otherwise>--%>
                                    <%--</c:choose>--%>
                                    <%--<c:choose>--%>
                                    <%--<c:when test="${individualDevelopmentPlan.text2 eq 'Soft Skill'}">--%>

                                        <option value="Soft Skill" selected="">Soft Skill</option>
                                    <%--</c:when>--%>
                                    <%--<c:otherwise>--%>
                                        <option value="Soft Skill">Soft Skill</option>
                                    <%--</c:otherwise>--%>
                                    <%--</c:choose>--%>

                                </select>
                            </div>
                        </td>
                        <td><div>
                                <select id="trainingSelectId$/{status.count}" name="trainingSelectId$/{status.count}" value="$/{individualDevelopmentPlan.text3}" class="form-control saveRequried" onchange="trainingSelect($/{status.count});">
                                    <option value="">--SELECT--</option>
                                    <%--<c:choose>--%>
                                    <%--<c:when test="${individualDevelopmentPlan.text3 eq 'On The Job Training'}">--%>

                                        <option value="On The Job Training" selected="">On The Job Training</option>
                                    <%--</c:when>--%>
                                    <%--<c:otherwise>--%>

                                        <option value="On The Job Training">On The Job Training</option>
                                    <%--</c:otherwise>--%>
                                    <%--</c:choose>--%>
                                    <%--<c:choose>--%>
                                    <%--<c:when test="${individualDevelopmentPlan.text3 eq 'Classroom Training'}">--%>

                                        <option value="Classroom Training" selected="">Classroom Training</option>
                                    <%--</c:when>--%>
                                    <%--<c:otherwise>--%>

                                        <option value="Classroom Training">Classroom Training</option>
                                    <%--</c:otherwise>--%>
                                    <%--</c:choose>--%>
                                    <%--<c:choose>--%>
                                    <%--<c:when test="${individualDevelopmentPlan.text3 eq 'Other'}">--%>

                                        <option value="Other" selected="">Other</option>
                                    <%--</c:when>--%>
                                    <%--<c:otherwise>--%>

                                        <option value="Other">Other</option>
                                    <%--</c:otherwise>--%>
                                    <%--</c:choose>--%>

                                </select>
                            </div>
                        </td>
                        <td><div>
                                <textarea class="form-control saveRequried" id="trainingSelectTextinput$/{status.count}" name="trainingSelectTextinput${status.count}" style="display: none">${individualDevelopmentPlan.remark}</textarea>
                            </div>
                        </td>
                                    <%--<c:if test="${status.last}">--%>

                                        <td style="text-align: center">
                                            <span style='margin-top: 5px;'>
                                    <%--<c:if test="${flag eq 'true' || flag1 eq 'true' || flag2 eq 'true'}">--%>
                                        <input type="button" value="+" id="addIndividualId" />
                                    <%--</c:if>--%>
                                </span>
                            </td>
                                    <%--</c:if>--%>
                                    <%--<c:if test="${!status.last && statusFlag eq 0}">--%>
                                        <td id="" style="text-align: center">
                                            <span style="margin-top: 5px;">
                                    <%--<c:if test="${flag eq 'true' || flag1 eq 'true' || flag2 eq 'true'}">--%>
                                        <input type="button" value="-" id="removeRowButtonId" onclick="removeIndividualChild('individualTrId$/{status.count}', 'individualEmpMidLabel1TrId$/{status.count}', 'individualEmpMid1TrId$/{status.count}', 'individualEmpMidLabel2TrId$/{status.count}', 'individualEmpMid2TrId$/{status.count}', '$/{individualDevelopmentPlan.id}');">
                                    <%--</c:if>--%>
                                </span>
                            </td>
                                    <%--</c:if>--%>
                                    </tr>


                                        <tr id="individualEmpMidLabel1TrId$/{status.count}">
                                        <td colspan="3" id="midYearReId$/{status.count}"><b>Employee Mid-Year Remark</b></td>
                                        <td colspan="3" id="endYearReId$/{status.count}"><b>Employee End-Year Remark</b></td>
                                    </tr>
                                    <tr id="individualEmpMid1TrId$/{status.count}">
                                        <td colspan="3" id="midYearRetxtId$/{status.count}"><textarea rows="3" style="width: 451px;" id="midYearRemark$/{status.count}" name="midYearRemark$/{status.count}" class="form-control saveRequried">$/{individualDevelopmentPlan.midYearRemark}</textarea></td>
                                        <td colspan="3" id="endYearRetxtId$/{status.count}"><textarea rows="3" style="width: 451px;" id="endYearRemark$/{status.count}" name="endYearRemark$/{status.count}" class="form-control saveRequried">$/{individualDevelopmentPlan.endYearRemark}</textarea></td>
                                    </tr>
                                    <tr id="individualEmpMidLabel2TrId$/{status.count}">
                                        <td colspan="3" id="endYearReId"><b>Manager Mid-Year Remark</b></td>
                                        <td colspan="3" id="endYearReId"><b>Manager End-Year Remark</b></td>
                                    </tr>
                                    <tr id="individualEmpMid2TrId$/{status.count}">
                                        <td colspan="3"><textarea rows="3" id="managerMidYearRemark$/{status.count}" style="width: 451px;" name="managerMidYearRemark$/{status.count}" class="form-control saveRequried">$/{individualDevelopmentPlan.managerMidYearRemarkEmployee}</textarea></td>
                                        <td colspan="3"><textarea rows="3" id="managerEndYearRemark$/{status.count}" style="width: 451px;" name="managerEndYearRemark$/{status.count}" class="form-control saveRequried">$/{individualDevelopmentPlan.managerEndYearRemarkManager}</textarea></td>
                                    </tr>
                                    <%--</c:if>--%>
                                    <%--</c:forEach>--%>
                                    <%--</c:when>--%>
                                    <%--<c:otherwise>--%>
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
                                    <%--</c:otherwise>--%>
                                    <%--</c:choose>--%>
                                </table>

                            </div>
                        </div>
                    </div>
                </div>
            </div>-->


                                  
<!--                                    <div class="box box-info collapsed-box" id="RatingsTabId">
                                        <div class="box-header">
                                            <h3 class="box-title">Performance Ratings:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId6">Expand</span><span id="btn7" class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun6();"><i class="fa fa-plus" id="minusId6" ></i></span>
                                                <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
                                            </div>
                                        </div> /.box-header 
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="row">
                                                        <div class="col-sm-4">
                                                            <div class="form-group text-center">
                                                                <label class="control-label"><b>KRA Score</b></label>&nbsp;&nbsp;
                                                                <input type="number" id="totalScore" name="totalScore" value="${totalScoreForemployee}" disabled="disabled" style="border-radius: 4px; border: 1px solid #ccc; padding: 6px 12px;" readonly="true">
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-4 form-group text-center">-->
<!--                                                            <div class="form-group">
                                                                <label class="control-label"><b>WLB Score</b></label>&nbsp;&nbsp;
                                                                <input type="number" id="behaviorsEndyearTotalscore" name="behaviorsEndyearTotalscore" value="${behaviorsEndyearTotalscoreForemp}" disabled="disabled" style="border-radius: 4px; border: 1px solid #ccc; padding: 6px 12px;" readonly="true">
                                                            </div>-->
<!--                                                        </div>
                                                        <div class="col-sm-4 form-group text-center">
                                                            <div class="form-group">
                                                                <label class="control-label"><b>Final Score</b></label>&nbsp;&nbsp;
                                                                <input type="Text" id="behaviorsFinalscore" name="behaviorsFinalscore" value="${behaviorsFinalscoreForemployee}" onchange="performancefinalScoreRatingsEmployee();" disabled="disabled" style="border-radius: 4px; border: 1px solid #ccc; padding: 6px 12px;" readonly="true">
                                                                <input type="number" id="behaviorsFinalscore" name="behaviorsFinalscore" value="${behaviorsFinalscore}" disabled="disabled" style="border-radius: 4px; border: 1px solid #ccc; padding: 6px 12px;" readonly="true">
                                                            </div>
                                                        </div>
                                                    </div>-->

                                                    <!--                                                    <div class="form-group">
                                                                                                            <label class="col-sm-5 control-label"><b>Final Score</b></label>
                                                                                                            <div class="col-sm-2">
                                                                                                                <input type="Text" id="behaviorsFinalscore" name="behaviorsFinalscore" value="${behaviorsFinalscoreForemployee}" onchange="performancefinalScoreRatingsEmployee();" class="form-control" readonly>
                                                                                                            </div>
                                                                                                        </div>-->

                                                    <!--<div class="table-responsive">-->
<!--                                                        <table id="demo" class="table table-bordered table-striped table-hover" style="" align="Center">
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


                                                        </table>-->

                                                    <!--</div>-->

                                                <!--</div> /.col -->
                                                <!--                                                <div class="form-group">
                                                                                                    <label class="col-sm-5 control-label"><b>Activity/Project Performance</b></label>
                                                                                                    <div class="col-sm-2">
                                                                                                        <input type="Text" id="" name="" value="${empActivityScore}"  class="form-control" readonly>
                                                                                                    </div>
                                                                                                </div>-->
                                                <!-- /.col -->
                                            <!--</div> /.row -->
                                        <!--</div> /.box-body -->
                                    <!--</div>-->
                                    <c:if test="${appraisalPerformanceMaster.reworkStatus eq 1}">

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
                                                                <form:textarea path="reworkComment" class="form-control" readonly="true" rows="6"></form:textarea>
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
                                                    <c:when test="${employeeStatus eq '0'}">
                                                        <div class="col-sm-6 " style="text-align: left;">
                                                            <!--<button type="button" class="btn btn-warning" data-original-title="" value="save" id="save" name="save" title="" onclick="return myFunction(this);">SAVE</button>-->
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
//            $(".displayAction :input").attr("readOnly", true);
//            $(".displayAction1 :input").attr("readOnly", true);
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
//
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
            $(".displayAction :input").attr("readOnly", true);
            $(".displayAction1 :input").attr("readOnly", true);
            if (employeeStatusVar === '1') {
                $("#form1 :input").attr("disabled", true);
            }
            $("#btn1").attr("disabled", false);
            $("#btn2").attr("disabled", false);
            $("#btn3").attr("disabled", false);
            $("#btn4").attr("disabled", false);
            $("#btn5").attr("disabled", false);
            $("#btn6").attr("disabled", false);
            $("#btn7").attr("disabled", false);
            $(".close").attr("disabled", true);

        }
//        $(document).on("click", ":submit", function (e) {
//            if ($(this).val() !== "" && $(this).val() === "submit") {
//                var w1 = document.getElementById("weightageScore").value;
//                if (w1 < 75 || w1 > 75) {
//                    weitageAlert();
//                    return false;
//                }
//            }
//        });
//        if (tflag11 === 'true') {
//            $kraGoal1 = $('#kraGoal1');
//            $kraGoal1.attr('disabled', true);
//        } else {
//            $("#form1 :input").attr("readonly", true);
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
        //        var w1 = document.getElementById("weightageScore").value;
//        if (w1 < 75 || w1 > 75) {
//            weitageAlert();
//            return false;
//        }
//        $(".btn-warnings").click(function () {
//            //alert("The paragraph was clicked.");
//            event.preventDefault();
//            $(".btn-warnings').removeAttr("disabled")
//        });
//        $("form").submit(function(event) {
//        if ($("input:first").val() === "75") {
//        $("span").text("Validated...").show();
//                return;
//        }
//        function myFunctionSubmit() {
//            var txt;
//            var r = confirm("Are You Sure ! You want to submit!");
//            if (r == true) {
//                txt = "true";
//            } else {
//                txt = "You pressed Cancel!";
//            }
////            document.getElementById("demo").innerHTML = txt;
//        }

    </script>

    <style>
        .class-with-width { width: 150px !important; }
    </style>
    <script type="text/javascript" src="StorageYard/Plugins/alert/bootbox.min.js"></script>
</html>
