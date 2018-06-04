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
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Performance Appraisal Form</title>

    </head>

    <script>
        var i = 1;
        $(function () {
            $("#addRowButtonId").on("click", function () {
                var flag11 = document.getElementById("flagId").value;
//        alert(flag11);

                i++;
//                alert(i1);
                var clone = "<tr id='row_1_" + i + "' style='clear:both;'>"
                        + "<td valign=\"middle\">" + i + "</td>"
                        + "<td id=\"\"><textarea name=\"kraGoal" + i + "\" id=\"kraGoal" + i + "\" class=\"form-control\"></textarea></td>"
                        + "<td id=\"\"><textarea name=\"metric1" + i + "\" id=\"metric1" + i + "\" class=\"form-control\"></textarea></td>"
                        + "<td id=\"flagId1_" + i + "\"><input type=\"Text\" class=\"form-control\"></td>"
                        + "<td id=\"flagId2_" + i + "\"><div><select id=\"midYearDiv" + i + "\" name=\"midYearDiv" + i + "\" class=\"form-control\">"
                        + "<option value=\"\">--SELECT--</option>"
                        + "<option value=\"Yet to Start\">Yet to Start</option>"
                        + "<option value=\"In Progress\">In Progress</option>"
                        + "<option value=\"Completed\">Completed</option>"
                        + "<option value=\"Canceled\">Canceled</option></select>"
                        + "</div></td>"
                        + "<td id=\"flagId3_" + i + "\"><div><select id=\"EndYearDiv" + i + "\" name=\"EndYearDiv" + i + "\" class=\"form-control\">"
                        + "<option value=\"\">--SELECT--</option>"
                        + "<option value=\"Yet to Start\">Yet to Start</option>"
                        + "<option value=\"In Progress\">In Progress</option>"
                        + "<option value=\"Completed\">Completed</option>"
                        + "<option value=\"Canceled\">Canceled</option></select>"
                        + "</div></td>"
                        + "<td id=\"flagId4_" + i + "\"><input type=\"Text\" class=\"form-control\"></td>"
                        + "<td id=\"\" style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\" value=\"-\" id=\"removeRowButtonId\" onclick=\"removeChild1('row_1_" + i + "', 'row_2_" + i + "', 'row_3_" + i + "', 'row_4_" + i + "', 'row_5_" + i + "', 'row_6_" + i + "', 'row_7_" + i + "', 'row_8_" + i + "', 'row_9_" + i + "');\">"
                        + "</span>"
                        + "</td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style=\'margin-top: 5px;\'>"
                        + "<button type=\"button\" class=\"btn btn-warning\">Edit</button>"
                        + "</span><br/>"
                        + "<span>23-10-2015</span></td>"
                        + "</tr>"
                        + "<tr id='row_2_" + i + "' style='clear:both;'><td></td><td colspan=\"6\"><b>Employee’s Mid - Year Self – Assessment Goal:</b></td><td></td><td></td></tr>"
                        + "<tr id='row_3_" + i + "' style='clear:both;'><td></td><td colspan=\"6\"><textarea type=\"Text\" class=\"form-control\"></textarea></td><td></td><td></td></tr>"
                        + "<tr id='row_4_" + i + "' style='clear:both;'><td></td><td colspan=\"6\"><b>Manager’s Mid - Year Review / Evaluation Goal:</b></td><td></td><td></td></tr>"
                        + "<tr id='row_5_" + i + "' style='clear:both;'><td></td><td colspan=\"6\"><textarea type=\"Text\" class=\"form-control\"></textarea></td><td></td><td></td>"
                        + "</tr>"
                        + "<tr id='row_6_" + i + "' style='clear:both;'><td></td><td colspan=\"6\"><b>Employee’s End - Year Self – Assessment Goal:</b></td><td></td><td></td></tr>"
                        + "<tr id='row_7_" + i + "' style='clear:both;'><td></td><td colspan=\"6\"><textarea type=\"Text\" class=\"form-control\"></textarea></td><td></td><td></td></tr>"
                        + "<tr id='row_8_" + i + "' style='clear:both;'><td></td><td colspan=\"6\"><b>Manager’s End - Year Review / Evaluation Goal:</b></td><td></td><td></td></tr>"
                        + "<tr id='row_9_" + i + "' style='clear:both;'><td></td><td colspan=\"6\"><textarea type=\"Text\" class=\"form-control\"></textarea></td><td></td><td></td></tr>";
                $("#demo").append(clone);
                document.getElementById("countId").value = i;
                if (flag11 == 'true') {
//                alert('ajay');
//                $('#flagId1').hide();
//                $('#flagId2').hide();
                    $('#flagId1_' + i).hide();
                    $('#flagId2_' + i).hide();
                    $('#flagId3_' + i).hide();
                    $('#flagId4_' + i).hide();
                    $('#row_2_' + i).hide();
                    $('#row_3_' + i).hide();
                    $('#row_4_' + i).hide();
                    $('#row_5_' + i).hide();
                    $('#row_6_' + i).hide();
                    $('#row_7_' + i).hide();
                    $('#row_8_' + i).hide();
                    $('#row_9_' + i).hide();
//                $('#flagId7').hide();
                }
            });

        });
        function removeChild1(removeRowId_1, removeRowId_2, removeRowId_3, removeRowId_4, removeRowId_5, removeRowId_6, removeRowId_7, removeRowId_8, removeRowId_9)
        {
            i--;
            var element1 = document.getElementById(removeRowId_1);
            var element2 = document.getElementById(removeRowId_2);
            var element3 = document.getElementById(removeRowId_3);
            var element4 = document.getElementById(removeRowId_4);
            var element5 = document.getElementById(removeRowId_5);
            var element6 = document.getElementById(removeRowId_6);
            var element7 = document.getElementById(removeRowId_7);
            var element8 = document.getElementById(removeRowId_8);
            var element9 = document.getElementById(removeRowId_9);
            element1.parentNode.removeChild(element1);
            element2.parentNode.removeChild(element2);
            element3.parentNode.removeChild(element3);
            element4.parentNode.removeChild(element4);
            element5.parentNode.removeChild(element5);
            element6.parentNode.removeChild(element6);
            element7.parentNode.removeChild(element7);
            element8.parentNode.removeChild(element8);
            element9.parentNode.removeChild(element9);
        }
        function trainingSelect() {
            var selectedValue1 = document.getElementById("trainingSelectId1").value;
//            var selectedValue2 = document.getElementById("trainingSelectId2").value;
//            var selectedValue3 = document.getElementById("trainingSelectId3").value;
            if (selectedValue1 == "Other") {
                document.getElementById("trainingSelectTextinput1").style.display = "block";
            } else {
                document.getElementById("trainingSelectTextinput1").style.display = "none";
            }
//            if (selectedValue2 == "Other") {
//                document.getElementById("trainingSelectTextinput2").style.display = "block";
//            } else {
//                document.getElementById("trainingSelectTextinput2").style.display = "none";
//            }
//            if (selectedValue3 == "Other") {
//                document.getElementById("trainingSelectTextinput3").style.display = "block";
//            } else {
//                document.getElementById("trainingSelectTextinput3").style.display = "none";
//            }
        }

    </script>
    <script>
        var j = 1;
        $(function () {
            $("#addIndividualId").on("click", function () {
                j++;
//                alert(i1);
                var clone = "<tr id='1moreFile_1_" + j + "'>"
                        + "<td style=\"text-align: center\">" + j + "</td>"
                        + "<td><textarea type=\"Text\" class=\"form-control\"></textarea></td>"
                        + "<td><div>"
                        + "<select id=\"EndYearDiv\" class=\"form-control\">"
                        + "<option value=\"\">--SELECT--</option>"
                        + "<option value=\"Air\">Technical</option>"
                        + "<option value=\"Bus\">Other</option>"
                        + "<option value =\"SoftSkill\"> Soft Skill </option>"
                        + "</select>"
                        + "</div>"
                        + "</td>"
                        + "<td><div>"
                        + "<select id=\"trainingSelectId1_" + j + "\" class=\"form-control\" onchange=\"trainingSelectCloneOfTable1(" + j + ")\">"
                        + "<option value=\"\">--SELECT--</option>"
                        + "<option value=\"Air\">On The Job Training</option>"
                        + "<option value=\"SoftSkill\">Classroom Training</option>"
                        + "<option value=\"Other\">Other</option>"
                        + "</select>"
                        + "</div>"
                        + "</td>"
                        + "<td><div>"
                        + "<textarea class=\"form-control\" id=\"trainingSelectTextinput1_" + j + "\" style=\"display: none\"></textarea>"
                        + "</div>"
                        + "</td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style=\'margin-top: 5px;\'>"
                        + "<input type=\"button\" value=\"-\" id=\"removeRowButtonId\" onclick=\"removeChild_j('1moreFile_1_" + j + "', '1moreFile_2_" + j + "', '1moreFile_3_" + j + "');\">"
                        + "</span>"
                        + "</td>"
                        + "</tr>"
                        + "<tr id='1moreFile_2_" + j + "'>"
                        + "<td></td>"
                        + "<td><b>Mid-Year Remark</b></td>"
                        + "<td colspan=\"2\"><textarea rows=\"3\" class=\"form-control\"></textarea></td>"
                        + "<td></td>"
                        + "<td></td>"
                        + "</tr>"
                        + "<tr id='1moreFile_3_" + j + "'>"
                        + "<td></td>"
                        + "<td><b>End-Year Remark</b></td>"
                        + "<td colspan=\"2\"><textarea rows=\"3\" class=\"form-control\"></textarea></td>"
                        + "<td></td>"
                        + "<td></td>"
                        + "</tr>";
                $("#demo5").append(clone);
            });

        });
        function removeChild_j(removeRow_1_Id, removeRow_2_Id, removeRow_3_Id) {
            j--
            var element1 = document.getElementById(removeRow_1_Id);
            var element2 = document.getElementById(removeRow_2_Id);
            var element3 = document.getElementById(removeRow_3_Id);
            element1.parentNode.removeChild(element1);
            element2.parentNode.removeChild(element2);
            element3.parentNode.removeChild(element3);
        }
        function trainingSelectCloneOfTable1(j) {
            var selectedValue1 = document.getElementById("trainingSelectId1_" + j).value;
            if (selectedValue1 == "Other") {
                document.getElementById("trainingSelectTextinput1_" + j).style.display = "block";
            } else {
                document.getElementById("trainingSelectTextinput1_" + j).style.display = "none";
            }
        }


    </script>

    <script>

        $(function () {
            $("#competencyEvaluationId").on("change", function () {
                var selectedValue = this.value;
                if (selectedValue == "IndividualContributor") {
                    $('.individualContributorId').show();
                    $('.leadingOthersId').hide();
                    $('.leadingManagersId').hide();
                    $('.leadingFunctionsId').hide();
                }
                else if (selectedValue == "LeadingOthers") {
                    $('.leadingOthersId').show();
                    $('.individualContributorId').hide();
                    $('.leadingManagersId').hide();
                    $('.leadingFunctionsId').hide();
                }
                else if (selectedValue == "LeadingManagers") {
                    $('.leadingManagersId').show();
                    $('.leadingOthersId').hide();
                    $('.individualContributorId').hide();
                    $('.leadingFunctionsId').hide();
                }
                else if (selectedValue == "LeadingFunctions") {
                    $('.leadingFunctionsId').show();
                    $('.leadingManagersId').hide();
                    $('.leadingOthersId').hide();
                    $('.individualContributorId').hide();
                }
                else {
                    $('.individualContributorId').hide();
                    $('.leadingOthersId').hide();
                    $('.leadingManagersId').hide();
                    $('.leadingFunctionsId').hide();
                }
            });
        });</script>
    <script>

        $(function () {
            $("#competencyEvaluationEndId").on("change", function () {
                var selectedValue = this.value;
                if (selectedValue == "IndividualContributor") {
                    $('#individualContributorEndId').show();
                    $('#leadingOthersEndId').hide();
                    $('#leadingManagersEndId').hide();
                    $('#leadingFunctionsEndId').hide();
                }
                else if (selectedValue == "LeadingOthers") {
                    $('#leadingOthersEndId').show();
                    $('#individualContributorEndId').hide();
                    $('#leadingManagersEndId').hide();
                    $('#leadingFunctionsEndId').hide();
                }
                else if (selectedValue == "LeadingManagers") {
                    $('#leadingManagersEndId').show();
                    $('#leadingOthersEndId').hide();
                    $('#individualContributorEndId').hide();
                    $('#leadingFunctionsEndId').hide();
                }
                else if (selectedValue == "LeadingFunctions") {
                    $('#leadingFunctionsEndId').show();
                    $('#leadingManagersEndId').hide();
                    $('#leadingOthersEndId').hide();
                    $('#individualContributorEndId').hide();
                }
                else {
                    $('#individualContributorEndId').hide();
                    $('#leadingOthersEndId').hide();
                    $('#leadingManagersEndId').hide();
                    $('#leadingFunctionsEndId').hide();
                }
            });
        });
    </script>

    <script>
        $(function () {
            $("#competencyEvaluationMidId").on("change", function () {
                var selectedValue = this.value;
                if (selectedValue == "IndividualContributor") {
                    $('#individualContributorMidId').show();
                    $('#leadingOthersMidId').hide();
                    $('#leadingManagersMidId').hide();
                    $('#leadingFunctionsMidId').hide();
                }
                else if (selectedValue == "LeadingOthers") {
                    $('#leadingOthersMidId').show();
                    $('#individualContributorMidId').hide();
                    $('#leadingManagersMidId').hide();
                    $('#leadingFunctionsMidId').hide();
                }
                else if (selectedValue == "LeadingManagers") {
                    $('#leadingManagersMidId').show();
                    $('#leadingOthersMidId').hide();
                    $('#individualContributorMidId').hide();
                    $('#leadingFunctionsMidId').hide();
                }
                else if (selectedValue == "LeadingFunctions") {
                    $('#leadingFunctionsMidId').show();
                    $('#leadingManagersMidId').hide();
                    $('#leadingOthersMidId').hide();
                    $('#individualContributorMidId').hide();
                }
                else {
                    $('#individualContributorMidId').hide();
                    $('#leadingOthersMidId').hide();
                    $('#leadingManagersMidId').hide();
                    $('#leadingFunctionsMidId').hide();
                }
            });
        });
    </script>

    <body>
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>Performance Appraisal Form :</h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Performance Appraisal</li>
                </ol>
            </section>
            <!-- Main content -->
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--form horizontal starts here-->
                                <!--<form class="form-horizontal" role="form" commandName="AppraisalPerformanceMaster">-->
                                <div class="box box-info collapsed-box ">
                                    <div class="box-header">
                                        <h3 class="box-title">Employee Detail:</h3>
                                        <div class="box-tools pull-right">
                                            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">

                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Employee No.:</label>
                                                        <input type="Text" class="form-control" readonly value="${employeeMaster[0]}">
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Employee Name:</label>
                                                        <input type="Text" id="employeeName" name="employeeName"  class="form-control" readonly value="${employeeMaster[1]}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Designation:</label>
                                                        <input type="Text" class="form-control" readonly value="${employeeMaster[2]}">
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Level:</label>
                                                        <input type="Text" class="form-control" readonly value="${employeeMaster[3]}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Department:</label>
                                                        <input type="Text" class="form-control" readonly value="${employeeMaster[4]}">
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Work Location:</label>
                                                        <input type="Text" class="form-control" readonly value="${employeeMaster[5]}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Reporting Manager:</label>
                                                        <input type="Text" class="form-control" readonly value="${reportingManager}">
                                                    </div>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                                                    
                                <form:form class="form-horizontal" role="form1" action="appraisalPerformance.htm?act=createSubmit" commandName="appraisalPerformanceMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>

                                    <!--Employee detail completes here-->
                                    <div class="box box-info collapsed-box"> 
                                        <div class="box-header">
                                            <h3 class="box-title">Results:</h3>
                                            <div class="box-tools pull-right">
                                                <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="table-responsive">
                                                        <table id="demo" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                            <tr>
                                                            <input type="hidden" name="flagId" id="flagId" value="${flag}">
                                                            <input type="hidden" name="flagMidId" id="flagMidId" value="${flag1}">
                                                            <input type="hidden" name="countId" id="countId" value="1">
                                                            <th style="text-align: center">Sr. No.</th>
                                                                <%--<c:if test="${flag eq true}">--%>

                                                            <th style="text-align: center" id="kraGoalid1">High Impact Goal / KRA</th>
                                                            <th style="text-align: center" id="metricid1">Time Space</th>
                                                                <%--</c:if>--%>
                                                                <%--<c:if test="${flag ne true}">--%>
                                                            <th style="margin: 0px;width: 100px;text-align: center" id="weightageid1">Weightage Out Of 75</th>

                                                            <th style="margin: 0px;width: 130px;text-align: center" id="midYearDivid1">Mid Year Status</th>
                                                            <th style="margin: 0px;width: 130px;text-align: center" id="endYearDivid1">End Year Status</th>
                                                            <th style="margin: 0px;width: 100px;text-align: center" id="finalScoreid1">Final Score</th>
                                                                <%--</c:if>--%>
                                                            <th style="text-align: center;">Add New</th>
                                                            <th style="text-align: center;width: 100px">Edit</th>
                                                            </tr>
                                                            <tr>
                                                                <td style="margin: 0px;width: 45px;">1</td>
                                                                <%--<c:if test="${flag eq true}">--%>
                                                                <td id="kraGoalid"><textarea type="Text" name="kraGoal1" id="kraGoal1" class="form-control"></textarea></td>
                                                                <td id="metricid"><textarea type="Text" name="metric1" id="metric1" class="form-control"></textarea></td>
                                                                    <%--</c:if>--%>
                                                                    <%--<c:if test="${flag ne true}">--%>

                                                                <td id="weightageid"><input type="Text" name="weightage1" id="weightage1" class="form-control" style="margin: 0px;width: 100px;"></td>
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

                                                                <td style="text-align: center"><span style='margin-top: 5px;'>
                                                                        <input type="button" value="+" id="addRowButtonId" />
                                                                    </span>
                                                                </td>
                                                                <td style="text-align: center"><span style='margin-top: 5px;'><button type="button" class="btn btn-warning">Edit</button></span><br/>
                                                                    <span>23-10-2015</span></td>

                                                            </tr>
                                                            <tr id="employeesMid"><td></td><td colspan="6"><b>Employee’s Mid - Year Self – Assessment Goal:</b></td><td></td><td></td></tr>
                                                            <tr id="textemployeesMid"><td></td><td colspan="6" ><textarea id="employeeMidYearSelfAssesssmentGoal" type="Text" class="form-control"></textarea></td><td></td><td></td></tr>
                                                            <tr id="managersMid"><td></td><td colspan="6" ><b>Manager’s Mid - Year Review / Evaluation Goal:</b></td><td></td><td></td></tr>
                                                            <tr id="textmanagersMid"><td></td><td colspan="6" ><textarea id="" type="Text" class="form-control"></textarea></td><td></td></tr>
                                                            <tr id="employeesEnd"><td></td><td colspan="6" ><b>Employee’s End - Year Self – Assessment Goal:</b></td><td></td><td></td></tr>
                                                            <tr id="textemployeesEnd"><td></td><td colspan="6" ><textarea id="" type="Text" class="form-control"></textarea></td><td></td><td></td></tr>
                                                            <tr id="managersEnd"><td></td><td colspan="6" ><b>Manager’s End - Year Review / Evaluation Goal:</b></td><td></td><td></td></tr>
                                                            <tr id="textmanagersEnd"><td></td><td colspan="6" ><textarea id="" type="Text" class="form-control"></textarea></td><td></td><td></td></tr>

                                                        </table>

                                                    </div>
                                                    <div class="table-responsive">
                                                        <table id="demo1" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                            <tr id="weightage">
                                                                <td style="margin: 0px;width: 100px;"></td>
                                                                <td style="margin: 0px;width: 100px;"></td>
                                                                <td style="margin: 0px;width: 285px;" align="right"><b>Weightage Score</b></td>
                                                                <td style="margin: 0px;width: 100px;"><input id="weightageScore" name="weightageScore" class="form-control" style="margin: 0px;width: 100px;"></input></td>
                                                                    <td style="margin: 0px;width: 170px;">
                                                                    </td>
                                                                    <td style="margin: 0px;width: 90px;" align="right"><b>Total Score</b>
                                                                    </td>
                                                                    <td><input id="totalScore" name="totalScore" class="form-control" style="margin: 0px;width: 100px;"></input></td>
                                                                    <td></td>
                                                                </tr>
                                                            </table>

                                                        </div>
                                                        <div class="table-responsive">
                                                            <table id="demo1" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                                <tr>
                                                                    <td id="employeesMidOtherActivity"><b>Employee’s Mid - Year Self – Assessment For Other Activities:</b></td>
                                                                    <td id="managersMidOtherActivity"><b>Manager’s Mid - Year Review / Evaluation For Other Activities:</b></td>
                                                                </tr>
                                                                <tr>
                                                                    <td id="employeesMidOtherActivity1"><textarea name="empMidyearSelfassOtheractivty" class="form-control"></textarea></td>
                                                                    <td id="managersMidOtherActivity1"><textarea name="managerMidyearReviewevalOtheractivity" class="form-control"></textarea></td>
                                                                </tr>
                                                                <tr>
                                                                    <td id="employeesEndOtherActivity"><b>Employee’s End - Year Self – Assessment For Other Activities:</b></td>
                                                                    <td id="managersEndOtherActivity"><b>Manager’s End - Year Review / Evaluation For Other Activities:</b></td>
                                                                </tr>
                                                                <tr>
                                                                    <td id="employeesEndOtherActivity1"><textarea name="empEndyearSelfassOtheractivty" class="form-control"></textarea></td>
                                                                    <td id="managersEndOtherActivity1"><textarea name="managerEndyearReviewevalOtheractivity" class="form-control"></textarea></td>
                                                                </tr>
                                                            </table>

                                                        </div>

                                                    </div><!-- /.col -->
                                                    <!--                                                <div class="col-md-12 col-sm-12">
                                                                                                        
                                                    
                                                                                                    </div>-->

                                                </div><!-- /.row -->
                                            </div><!-- /.box-body -->
                                        </div>
                                        <div class="box box-info collapsed-box">
                                            <div class="box-header">
                                                <h3 class="box-title">Competency Evaluation (As Per SPC Lifesciences Competency Framework) :</h3>
                                                <div class="box-tools pull-right">
                                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
                                                </div>
                                            </div><!-- /.box-header -->
                                            <div class="box-body no-padding">
                                                <div class="row">
                                                    <div class="col-md-12 col-sm-12">
                                                        <div>
                                                            <select id="competencyEvaluationId" class="form-control">
                                                                <option value="">--SELECT--</option>
                                                                <option value="IndividualContributor">Individual Contributor</option>
                                                                <option value="LeadingOthers">Leading Others</option>
                                                                <option value="LeadingManagers">Leading Managers</option>
                                                                <option value="LeadingFunctions">Leading Functions/Organizations</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <br/>
                                                    <br/>
                                                    <div class="col-md-12 col-sm-12">
                                                        <div class="table-responsive">
                                                            <table id="demo9" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                                <tr>
                                                                    <th style="text-align: center">Title</th>
                                                                    <th style="text-align: center">Start Year</th>
                                                                    <th style="text-align: center">Remark</th>
                                                                    <th style="text-align: center">Mid Year</th>
                                                                    <th style="text-align: center">Remark</th>
                                                                    <th style="text-align: center">End Year</th>
                                                                    <th style="text-align: center">Remark</th>
                                                                </tr>

                                                                <tr class="individualContributorId" style="display: none">
                                                                    <td>1) Smart Execution</td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                </tr>
                                                                <tr class="individualContributorId" style="display: none">
                                                                    <td>2) Customer Focus</td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                </tr> 
                                                                <tr class="individualContributorId" style="display: none">
                                                                    <td>3) Drive for Results</td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                </tr> 
                                                                <tr class="individualContributorId" style="display: none">
                                                                    <td>4) High Learning Ability</td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                </tr> 
                                                                <tr class="individualContributorId" style="display: none">
                                                                    <td>5) Clearly Communicate & Present</td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                </tr> 
                                                                <tr class="individualContributorId" style="display: none">
                                                                    <td>6) Interpersonal Skills</td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                </tr> 
                                                                <tr class="individualContributorId" style="display: none">
                                                                    <td>7) Managing Time</td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                </tr> 
                                                                <tr class="individualContributorId" style="display: none">
                                                                    <td>8) Problem Solving Skill</td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                </tr> 
                                                                <tr class="leadingOthersId" style="display: none">
                                                                    <td>1) Managing Conflicts</td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                </tr> 

                                                                <tr class="leadingOthersId" style="display: none">
                                                                    <td>2) Effective Delegation</td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                </tr> 
                                                                <tr class="leadingOthersId" style="display: none">
                                                                    <td>3) Timely Decision Making</td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                </tr> 
                                                                <tr class="leadingOthersId" style="display: none">
                                                                    <td>4) Developing Direct Reports & Others</td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                </tr> 
                                                                <tr class="leadingOthersId" style="display: none">
                                                                    <td>5) Innovate</td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                </tr> 
                                                                <tr class="leadingOthersId" style="display: none">
                                                                    <td>6) Ability to Articulate</td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                </tr> 
                                                                <tr class="leadingManagersId" style="display: none">
                                                                    <td>1) Comfort with LeaderShip</td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                </tr> 
                                                                <tr class="leadingManagersId" style="display: none">
                                                                    <td>2) Managerial Courage</td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                </tr> 
                                                                <tr class="leadingManagersId" style="display: none">
                                                                    <td>3) Political Savvy</td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                </tr> 
                                                                <tr class="leadingManagersId" style="display: none">
                                                                    <td>4) Build High Performance Team</td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                </tr> 
                                                                <tr class="leadingManagersId" style="display: none">
                                                                    <td>5) Strategic Thinking</td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                </tr> 
                                                                <tr class="leadingFunctionsId" style="display: none">
                                                                    <td>1) Managing Vision and Purpose</td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                </tr> 
                                                                <tr class="leadingFunctionsId" style="display: none">
                                                                    <td>2) Mentoring and Coaching</td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                </tr> 
                                                                <tr class="leadingFunctionsId" style="display: none">
                                                                    <td>3) High Business Acumen</td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                </tr> 
                                                                <tr class="leadingFunctionsId" style="display: none">
                                                                    <td>4) Strategic Thinking</td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                    <td>
                                                                        <select id="" class="form-control ">
                                                                            <option value="">--SELECT--</option>
                                                                            <option value="self">Exceed Expectations</option>
                                                                            <option value="other">Meet  Expectations</option>
                                                                            <option value="other">Need Improvement</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <textarea type="Text" class="form-control" rows="4"></textarea>
                                                                    </td>
                                                                </tr> 
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
                                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
                                                </div>
                                            </div><!-- /.box-header -->
                                            <div class="box-body no-padding">
                                                <div class="row">
                                                    <div class="col-md-12 col-sm-12">

                                                        <div class="table-responsive">
                                                            <table id="demo5" class="table table-bordered table-striped table-hover" style="" align="Center"  >

                                                                <tr>
                                                                    <th style="text-align: center">Sr.No.</th>
                                                                    <th style="text-align: center"></th>
                                                                    <th style="text-align: center"></th>
                                                                    <th style="text-align: center"></th>
                                                                    <th style="text-align: center"></th>
                                                                    <th style="text-align: center">Add New</th>
                                                                </tr>
                                                                <tr>
                                                                    <td style="text-align: center">1</td>
                                                                    <td><textarea type="Text" class="form-control"></textarea></td>
                                                                    <td><div>
                                                                            <select id="EndYearDiv" class="form-control">
                                                                                <option value="">--SELECT--</option>
                                                                                <option value="Air">Technical</option>
                                                                                <option value="Bus">Other</option>
                                                                                <option value="SoftSkill">Soft Skill</option>

                                                                            </select>
                                                                        </div>
                                                                    </td>
                                                                    <td><div>
                                                                            <select id="trainingSelectId1" class="form-control" onchange="trainingSelect()">
                                                                                <option value="">--SELECT--</option>
                                                                                <option value="Air">On The Job Training</option>
                                                                                <option value="SoftSkill">Classroom Training</option>
                                                                                <option value="Other">Other</option>

                                                                            </select>
                                                                        </div>
                                                                    </td>
                                                                    <td><div>
                                                                            <textarea class="form-control" id="trainingSelectTextinput1" style="display: none"></textarea>
                                                                        </div>
                                                                    </td>
                                                                    <td style="text-align: center">
                                                                        <span style='margin-top: 5px;'>
                                                                            <input type="button" value="+" id="addIndividualId" />
                                                                        </span>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td></td>
                                                                    <td style="text-align: center;vertical-align: middle"><b>Mid-Year Remark</b></td>
                                                                    <td colspan="2"><textarea rows="3" class="form-control"></textarea></td>
                                                                    <td></td>
                                                                    <td></td>
                                                                </tr>
                                                                <tr>
                                                                    <td></td>
                                                                    <td style="text-align: center;vertical-align: middle"><b>End-Year Remark</b></td>
                                                                    <td colspan="2"><textarea rows="3" class="form-control"></textarea></td>
                                                                    <td></td>
                                                                    <td></td>
                                                                </tr>

                                                            </table>

                                                        </div>
                                                    </div><!-- /.col -->
                                                </div><!-- /.row -->
                                            </div><!-- /.box-body -->
                                        </div>


                                        <div class="box box-info collapsed-box">
                                            <div class="box-header">
                                                <h3 class="box-title">Behaviors:</h3>
                                                <div class="box-tools pull-right">
                                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
                                                </div>
                                            </div><!-- /.box-header -->
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



                                                    </div><!-- /.col -->
                                                    <div class="col-md-12 col-sm-12">



                                                    </div>
                                                    <!-- /.col -->
                                                </div><!-- /.row -->
                                            </div><!-- /.box-body -->
                                        </div>
                                        <div class="box box-info collapsed-box">
                                            <div class="box-header">
                                                <h3 class="box-title">Performance Ratings:</h3>
                                                <div class="box-tools pull-right">
                                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
                                                </div>
                                            </div><!-- /.box-header -->
                                            <div class="box-body no-padding">
                                                <div class="row">
                                                    <div class="col-md-12 col-sm-12">
                                                        <div class="form-group">
                                                            <label class="col-sm-2 control-label"><b>Final Score</b></label>
                                                            <div class="col-sm-2">
                                                                <input type="Text" class="form-control" readonly>
                                                            </div>
                                                        </div>

                                                        <div class="table-responsive">
                                                            <table id="demo" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                                <tr style="background-color: darkgrey">
                                                                    <th style="text-align: center">Performance Ratings</th>
                                                                    <th style="text-align: center">Score</th>
                                                                    <th style="text-align: center">Score Achieved</th>
                                                                </tr>
                                                                <tr class="" style="background-color: #008000">
                                                                    <td style="vertical-align: middle"><b>Far Exceeds Expectations</b></td>
                                                                    <td style="text-align: center"><h4><b>91 to 100</b></h4></td>
                                                                    <td style="text-align: center"><span class="glyphicon glyphicon-ok " style="font-size: 30px"></span></td>
                                                                </tr>
                                                                <tr class="" style="background-color: #6AA121">
                                                                    <td style="vertical-align: middle"><b>Exceeds Expectations</b></td>
                                                                    <td style="text-align: center"><h4><b>81 to 90</b></h4></td>
                                                                    <td></td>
                                                                </tr>
                                                                <tr class="" style="background-color: #FFFF00">
                                                                    <td style="vertical-align: middle"><b>Meets Expectations</b></td>
                                                                    <td style="text-align: center"><h4><b>71 to 80</b></h4></td>
                                                                    <td></td>
                                                                </tr>
                                                                <tr class="" style="background-color: #FFA375">
                                                                    <td style="vertical-align: middle"><b>Partially Meets Expectations</td>
                                                                    <td style="text-align: center"><h4><b>61 to 70</b></h4></td>
                                                                    <td></td>
                                                                </tr>
                                                                <tr class="" style="background-color: #FF8080">
                                                                    <td style="vertical-align: middle"><b>Does Not Meet Expectations</b></td>
                                                                    <td style="text-align: center"><h4><b>51 to 60</b></h4></td>
                                                                    <td></td>
                                                                </tr>


                                                            </table>

                                                        </div>

                                                    </div><!-- /.col -->

                                                    <!-- /.col -->
                                                </div><!-- /.row -->
                                            </div><!-- /.box-body -->
                                        </div>
                                        <!--Reason In Detail completes Here-->
                                        <div class="form-group">
                                            <div class="col-lg-offset-2 col-sm-3">
                                                <button type="submit" class="btn btn-success" data-original-title="" title="" style="width: 100px">Save</button>
                                            </div>
                                            <div class="col-lg-4 col-sm-4">
                                                <button type="submit" class="btn btn-primary" data-original-title="" title="" style="width: 100px">Submit</button>
                                            </div>
                                        </div>
                                </form:form>
                                <!--form horizontal ends here-->
                                <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
                            </div><!-- /.tab-content -->
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
            </section><!-- /.content -->
        </div>
        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

        <script>
            $(document).ready(function () {
                var flag11 = document.getElementById("flagId").value;
                var flagmid = document.getElementById("flagMidId").value;
                alert("fkgkdfg" + flag11);
                alert("fkgkdfg" + flagmid);
                if (flag11 === 'true') {
//                alert('ajay');
//                $('#flagId1').hide();
//                $('#flagId2').hide();
                    $('#kraGoal1').show();
                    $('#metric1').show();
                    $('#weightageid').show();
                    $('#weightageid1').show();
                    $('#midYearDivid').hide();
                    $('#midYearDivid1').hide();
                    $('#endYearDivid').hide();
                    $('#endYearDivid1').hide();
                    $('#finalScoreid').hide();
                    $('#finalScoreid1').hide();
                    $('#employeesMid').hide();//Employee’s Mid - Year Self – Assessment Goal:
                    $('#textemployeesMid').hide();//textarea:Employee’s Mid - Year Self – Assessment Goal:
                    $('#managersMid').hide();//Manager’s Mid - Year Review / Evaluation Goal:
                    $('#textmanagersMid').hide();//textarea:Manager’s Mid - Year Review / Evaluation Goal:
                    $('#employeesEnd').hide();//Employee’s End - Year Self – Assessment Goal:
                    $('#textemployeesEnd').hide();//textarea:Employee’s End - Year Self – Assessment Goal:
                    $('#managersEnd').hide();//Manager’s End - Year Review / Evaluation Goal:
                    $('#textmanagersEnd').hide();//textarea:Manager’s End - Year Review / Evaluation Goal:
                    $('#employeesMidOtherActivity').hide();//textarea:Manager’s End - Year Review / Evaluation Goal:
                    $('#employeesMidOtherActivity1').hide();//textarea:Manager’s End - Year Review / Evaluation Goal:
                    $('#managersMidOtherActivity').hide();//textarea:Manager’s End - Year Review / Evaluation Goal:
                    $('#managersMidOtherActivity1').hide();//textarea:Manager’s End - Year Review / Evaluation Goal:
                    $('#employeesEndOtherActivity').hide();//textarea:Manager’s End - Year Review / Evaluation Goal:
                    $('#employeesEndOtherActivity1').hide();//textarea:Manager’s End - Year Review / Evaluation Goal:
                    $('#managersEndOtherActivity').hide();//textarea:Manager’s End - Year Review / Evaluation Goal:
                    $('#managersEndOtherActivity1').hide();//textarea:Manager’s End - Year Review / Evaluation Goal:

                } else if (flagmid === 'true') {
                    alert(flagmid);
                    $('#kraGoal1').show();
                    $('#metric1').show();
                    $('#weightageid').show();
                    $('#weightageid1').show();
                    $('#midYearDivid').hide();
                    $('#midYearDivid1').hide();
                    $('#endYearDivid').hide();
                    $('#endYearDivid1').hide();
                    $('#finalScoreid').hide();
                    $('#finalScoreid1').hide();
                }
            });
        </script>
</html>
