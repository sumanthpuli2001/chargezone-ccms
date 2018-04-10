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

                                                <!--<th style="margin: 0px;width: 130px;text-align: center" id="midYearDivid1">Mid Year Status</th>-->
                                                <th style="margin: 0px;width: 130px;text-align: center" id="endYearDivid1">Status</th>
                                                <th style="margin: 0px;text-align: center" id="empfinalScoreid01">Employee Score</th>
                                                <th style="margin: 0px;width: 25px;text-align: center" id="finalScoreid">Manager  Score</th>
                                                <!--<th style="margin: 0px;width: 100px;text-align: center" id="finalScoreid">Final Score</th>-->
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
                                                            <!--<td id="midYearDivid1${status.count}">${kragoallist.midyearStatus}</td>-->
                                                            <td id="endYearDivid1${status.count}">${kragoallist.endyearStatus}</td>
                                                            <td id="empfinalScore${status.count}">
                                                                ${kragoallist.empFinalScore}
                                                            </td>
                                                            <td id="finalScoreid${status.count}">${kragoallist.finalScore}</td>
                                                            </tr>

                                                            <tr id="employeesEnd">
                                                                <td colspan="3"><b>Employee’s Self – Assessment Goal:</b></td>
                                                                <td colspan="5"><b>Manager’s Review / Evaluation Goal:</b></td>
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
                                                    <td style="margin: 0px;width: 200px;" id="weightageScoreId" align="right"><b>Weightage</b></td>
                                                    <td style="margin: 0px;width: 100px;" id="dhaval">
                                                        <input type="text" id="weightageScore" name="weightageScore" class="form-control"  value="${weightageScore}" style="margin: 0px;width: 100px;" readonly="true">
                                                    </td>
                                                    <td style="margin: 0px;width: 140px;" id="empScoreId" align="right"><b>Employee Total Score</b></td>
                                                    <td style="margin: 0px;width: 100px;" id="dhaval">
                                                        <input type="text" id="empScore" name="empScore" class="form-control"  value="${empScore}" style="margin: 0px;width: 100px;" readonly="true">
                                                    </td>
                                                    <td style="margin: 0px;width: 150px;" id="totalScoreId" align="right"><b>Manager Total Score</b>
                                                    </td>
                                                    <td><input id="totalScore" name="totalScore" value="${totalScore}" class="form-control" value="${totalScore}" style="margin: 0px;width: 100px;" readonly="true"></input></td>
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
