<%--
    Document   : PerformanceImprovementPlanCreate
    Created on : Mar 25, 2016, 09:45:53 AM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
    <!--<link rel="stylesheet" href="StorageYard/CSS/bootstrap-datetimepicker.css">-->
    <!--<script type="text/javascript" src="StorageYard/JS/bootstrap-datetimepicker.js" charset="UTF-8"></script>-->
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PIP</title>
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
            $(function () {
                $('#startDate1').datetimepicker({timepicker: false, format: 'd/m/Y'});
            });
            $(function () {
                $('#completionDate1').datetimepicker({timepicker: false, format: 'd/m/Y'});
            });
            $(function () {
                $('#scheduledDate1').datetimepicker({format: 'd/m/Y H:m'});
                $('#nextScheduleDate').datetimepicker({format: 'd/m/Y H:m'});
            });

            function changeDateFun(id) {
                $("#startDate" + id).datetimepicker({timepicker: false, format: 'd/m/Y'});
            }
            function changeCompletionDateFun(id) {
                $("#completionDate" + id).datetimepicker({timepicker: false, format: 'd/m/Y'});
            }
        </script>
        <script>
            //Step:1
            var i1 = 1;
            $(function () {
                $("#step1cloneid").on("click", function () {
                    i1 = document.getElementById("firstStepCount").value;
                    i1++;
                    if (i1 <= 8) {
                        var clone = "<tr id='cloneTr_Id" + i1 + "'>"
                                + "<td style=\"text-align: center\">" + i1 + "</td>"
                                + "<td><textarea class='form-control' id='pipGoal" + i1 + "' name='pipGoal" + i1 + "' onchange='addToDropDownList(" + i1 + ")'></textarea></td>"
                                + "<td></td>"
                                + "<td style=\"text-align: center\"><input type =\"button\" value=\"-\" onclick=\"removeStep1Tr('cloneTr_Id" + i1 + "');\"/>"
                                + "</tr>";
                        $("#table_1").append(clone);
                        document.getElementById("firstStepCount").value = i1;
                    }
                });
            });

            function removeStep1Tr(cloneTr_Id) {
                try {
                    i1--;
                    var val = document.getElementById("firstStepCount").value;
                    val = val - 1;
                    document.getElementById("firstStepCount").value = val;
                    var element1 = document.getElementById(cloneTr_Id);
                    element1.parentNode.removeChild(element1);
                } catch (e) {

                }


            }

//            Step:2
            var i2 = 1;
            $(function () {
                $("#step2cloneid").on("click", function () {
                    i2 = document.getElementById("secondStepCount").value;
                    i2++;
                    if (i2 <= 8) {
                        var clone = "<tr id='step_2_rowNo1_" + i2 + "'>"
                                + "<td style=\"text-align: center\">" + i2 + "</td>"
                                + "<td><select name='activityGoal" + i2 + "' id='activityGoal" + i2 + "' class='form-control'>"
                                + "<option value=''>---Select---</option>"
                                + "</select></td>"
                                + "<td><textarea style=\"height: 54px;\" class=\"form-control\" name='activityName" + i2 + "' id='activityName" + i2 + "'></textarea></td>"
                                + "<td><textarea style=\"height: 54px;\" class=\"form-control\" name='howToAccomplish" + i2 + "' id='howToAccomplish" + i2 + "'></textarea></td>"
                                + "<td><input class=\"form-control\" name='startDate" + i2 + "' id='startDate" + i2 + "' type=\"text\"></td>"
                                + "<td><input class=\"form-control\" name='completionDate" + i2 + "' id='completionDate" + i2 + "' type=\"text\"></td>"
                                + "<td style=\"text-align: center\"><input type =\"button\" value=\"-\" onclick=\"removeIt2('step_2_rowNo1_" + i2 + "');\"/>"
                                + "</tr>";
                        $("#table_2").append(clone);
                        document.getElementById("secondStepCount").value = i2;
                        $("#startDate" + i2).datetimepicker({timepicker: false, format: 'd/m/Y'});
                        $("#completionDate" + i2).datetimepicker({timepicker: false, format: 'd/m/Y'});
                        step2OptionAdd(i2);
                    }

                });
            });
            function step2OptionAdd(id) {
                var element2 = document.getElementById('activityGoal1');
                var obj2 = document.getElementById("activityGoal" + id);
                for (var i2 = 1; i2 < element2.options.length; i2++) {
                    var opt2 = document.createElement("option");
                    opt2.value = element2.options[i2].value;
                    opt2.text = element2.options[i2].text;
                    obj2.appendChild(opt2);
                }
            }
            function removeIt2(removeRowId1) {
                i2--;
                var val = document.getElementById("secondStepCount").value;
                val = val - 1;
                document.getElementById("secondStepCount").value = val;
                var element1 = document.getElementById(removeRowId1);
                element1.parentNode.removeChild(element1);

            }

            //Step:3
            var i3 = 1;
            $(function () {
                $("#step3cloneid").on("click", function () {
                    i3 = document.getElementById("thirdStepCount").value;
                    i3++;
                    if (i3 <= 8) {
                        var clone = "<tr id='step_3_rowNo1_" + i3 + "'>"
                                + "<td style=\"text-align: center\">" + i3 + "</td>"
                                + "<td><select name='resourceGoal" + i3 + "' id='resourceGoal" + i3 + "' class='form-control'>"
                                + "<option value=''>---Select---</option>"
                                + "</select></td>"
                                + "<td><textarea class='form-control' name='resourceName" + i3 + "' id='resourceName" + i3 + "'></textarea></td>"
                                + "<td style=\"text-align: center\"><input type =\"button\" value=\"-\" onclick=\"removeIt1('step_3_rowNo1_" + i3 + "');\"/>"
                                + "</tr>";
                        $("#table_3").append(clone);
                        document.getElementById("thirdStepCount").value = i3;
                        step3OptionAdd(i3);
                    }
                });
            });
            function step3OptionAdd(id) {
                var element2 = document.getElementById('resourceGoal1');
                var obj2 = document.getElementById("resourceGoal" + id);
                for (var i2 = 1; i2 < element2.options.length; i2++) {
                    var opt2 = document.createElement("option");
                    opt2.value = element2.options[i2].value;
                    opt2.text = element2.options[i2].text;
                    obj2.appendChild(opt2);
                }
            }
            function removeIt1(removeRowId1) {
                i3--;
                var val = document.getElementById("thirdStepCount").value;
                val = val - 1;
                document.getElementById("thirdStepCount").value = val;
                var element1 = document.getElementById(removeRowId1);
                element1.parentNode.removeChild(element1);
            }

//            Step 4
            var i4 = 1;
            $(function () {
                $("#step4cloneid").on("click", function () {
                    i4 = document.getElementById("forthStepCount").value;
                    i4++;
                    if (i4 <= 8) {
                        var clone = "<tr id='step_4_rowNo1_" + i4 + "'>"
                                + "<td style=\"text-align: center\">" + i4 + "</td>"
                                + "<td><input class='form-control' name='scheduledDate" + i4 + "' id='scheduledDate" + i4 + "' type='text'></td>"
                                + "<td><select name='meeting" + i4 + "' id='meeting" + i4 + "' class='form-control'>"
                                + "<option value=''>---Select---</option>"
                                + "<option value='Face-To-Face'>Face-To-Face</option>"
                                + "<option value='Skype'>Skype</option>"
                                + "<option value='Call'>Call</option>"
                                + "</select></td>"
                                + "<td><textarea class='form-control' name='managerRemark" + i4 + "' id='managerRemark" + i4 + "'></textarea></td>"
                                + "<td style=\"text-align: center\"><input type =\"button\" value=\"-\" onclick=\"removeIt4('step_4_rowNo1_" + i4 + "');\"/>"
                                + "</tr>";
                        $("#table_4").append(clone);
                        document.getElementById("forthStepCount").value = i4;
                        $("#scheduledDate" + i4).datetimepicker({format: 'd/m/Y H:m'});
                    }
                });
            });
            function removeIt4(removeRowId4) {
                i4--;
                var val = document.getElementById("forthStepCount").value;
                val = val - 1;
                document.getElementById("forthStepCount").value = val;
                var element1 = document.getElementById(removeRowId4);
                element1.parentNode.removeChild(element1);
            }

            function addToDropDownList(id) {
                var myvalue = $('#pipGoal' + id).val();

                var step2Count = document.getElementById("secondStepCount").value;
                var step3Count = document.getElementById("thirdStepCount").value;
                for (var j = 1; j <= step2Count; j++) {
                    if ($("#activityGoal" + j + " option[value='" + id + "']").length > 0) {
                        if (myvalue != '') {
                            $("#activityGoal" + j + " option[value='" + id + "']").text(myvalue);
                        } else {
                            var x = document.getElementById("activityGoal" + j);
                            x.remove(id);
                        }
                    } else {
                        $('#activityGoal' + j).append($("<option></option>").attr("value", id).text(myvalue));

                    }
                }
                for (var m = 1; m <= step3Count; m++) {
                    if ($("#resourceGoal" + m + " option[value='" + id + "']").length > 0) {
                        if (myvalue != '') {
                            $("#resourceGoal" + m + " option[value='" + id + "']").text(myvalue);
                        } else {
                            var x = document.getElementById("resourceGoal" + m);
                            x.remove(id);
                        }
                    } else {
                        $('#resourceGoal' + m).append($("<option></option>").attr("value", id).text(myvalue));
                    }
                }
            }
            $(document).ready(function () {
                var step1Count = document.getElementById("firstStepCount").value;
                var step2Count = document.getElementById("secondStepCount").value;
                var step3Count = document.getElementById("thirdStepCount").value;
                for (var i = 1; i <= step1Count; i++) {
                    var myvalue = $('#pipGoal' + i).val();
                    for (var j = 1; j <= step2Count; j++) {
                        $('#activityGoal' + j).append($("<option></option>").attr("value", i).text(myvalue));
                    }
                    for (var m = 1; m <= step3Count; m++) {
                        $('#resourceGoal' + m).append($("<option></option>").attr("value", i).text(myvalue));
                    }

                }
                for (var k = 1; k <= step2Count; k++) {
                    var hiddenActivityGoal = document.getElementById("hiddenActivityGoal" + k).value;
                    var element2 = document.getElementById('activityGoal' + k);
                    for (var i2 = 0; i2 < element2.options.length; i2++) {
                        var activityOption = element2.options[i2].value;
                        if (hiddenActivityGoal == activityOption) {
                            element2.options[i2].selected = true;
                        }
                    }
                }
                for (var n = 1; n <= step3Count; n++) {
                    var hiddenResourceGoal = document.getElementById("hiddenResourceGoal" + n).value;
                    var element3 = document.getElementById('resourceGoal' + n);
                    for (var i2 = 0; i2 < element3.options.length; i2++) {
                        var resourceOption = element3.options[i2].value;
                        if (hiddenResourceGoal == resourceOption) {
                            element3.options[i2].selected = true;
                        }
                    }
                }
            });


            function readHistory(goalId) {
                var pip_id = document.getElementById("pip_id").value;
                var improvementGoal_id = document.getElementById("improvementGoal_id" + goalId).value;
                document.getElementById('viewHistory_id').innerHTML = "Fetching ......";
                $.post("performanceImprovementPlanMaster.htm?act=readHistoryAjax",
                        {
                            improvementGoal_id: improvementGoal_id, pip_id: pip_id
                        }, function (responseTxt, statusTxt, xhr) {
                    if (statusTxt === "success") {
                        document.getElementById('viewHistory_id').innerHTML = responseTxt;
                    }
                    if (statusTxt === "error")
                        alert("Error: " + xhr.status + ": " + xhr.statusText);
                });
            }

        </script>
    </head>
    <body>
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>Performance Improvement Plan (PIP) Form :</h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Performance Appraisal</li>
                </ol>
            </section>
            <c:if test="${!empty successMessage}">
                <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
            </c:if>
            <c:if test="${!empty failureMessage}">
                <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
            </c:if>

            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--<span style="color: red;font-size: 14px;">* indicates mandatory field.</span>-->
                                <h4 class="box-title">The Purpose Of This Performance Improvement Plan (PIP) Is To Define Serious Areas Of Concern, Gaps In Your Work Performance, Reiterate <b>Zydex</b> Expectations, And Allow You The Opportunity To Demonstrate Improvement And Commitment.</h4>
                                <form:form action="performanceImprovementPlanMaster.htm?act=createSubmit" method="post" commandName=""
                                           name='form1'  class="form-horizontal" role="form">
                                    <input type="hidden" name="pip_id" id="pip_id" value="${performanceImprovementPlanMaster.id}">
                                    <div class="box box-info collapsed-box ">
                                        <div class="box-header">
                                            <h3 class="box-title">Employee Detail:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId1">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun1()"><i class="fa fa-plus" id="minusId1"></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <input type="hidden" name="empAjaxId" id="empAjaxId" value="${employeeMaster[6]}">
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
                                                            <input type="Text" class="form-control" readonly value="${employeeMaster[1]}">
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
                                                            <input type="Text" class="form-control" name="levelId" id="levelId" readonly value="${employeeMaster[3]}">
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
                                                            <input type="Text" class="form-control" value="${reportingManager}" readonly>
                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <div class="box box-info collapsed-box ">
                                        <div class="box-header">
                                            <h3 class="box-title">Step 1:  Improvement Goals: These Are The Goals Related To Areas Of Concern To Be Improved And Addressed:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2();"><i class="fa fa-plus" id="minusId2" ></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="table-responsive">
                                                        <c:choose>
                                                            <c:when test="${empty improvementGoalList}">

                                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                                    <tr>
                                                                        <th style="text-align: center;width:55px">Sr No.</th>
                                                                        <th style="text-align: center;">Goal Name</th>
                                                                        <th style="text-align: center;width:55px"></th>
                                                                    </tr>
                                                                    <input type="hidden" name="firstStepCount" id="firstStepCount" value="1">
                                                                    <tr id="cloneTr_Id">
                                                                        <td style="text-align: center">1</td>
                                                                        <td><textarea onchange="addToDropDownList(1)" id="pipGoal1" name="pipGoal1" class="form-control"></textarea></td>
                                                                        <td></td>
                                                                        <td style="text-align: center"><span style='margin-top: 5px;'>
                                                                                <input type="button" value="+" id="step1cloneid" />  </span>
                                                                        </td>
                                                                    </tr>
                                                                </table>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                                    <tr>
                                                                        <th style="text-align: center;width:55px">Sr No.</th>
                                                                        <th style="text-align: center;">Goal Name</th>
                                                                        <th style="text-align: center;width:55px"></th>
                                                                        <th style="text-align: center;width:55px"></th>
                                                                    </tr>
                                                                    <input type="hidden" name="firstStepCount" id="firstStepCount" value="${fn:length(improvementGoalList)}">
                                                                    <c:forEach var="improvementGoalList" items="${improvementGoalList}" varStatus="step1Status">
                                                                        <input type="hidden" name="improvementGoal_id${step1Status.count}" id="improvementGoal_id${step1Status.count}" value="${improvementGoalList.id}">
                                                                        <tr id="cloneTr_Id">

                                                                            <td style="text-align: center;">${step1Status.count}</td>
                                                                            <td <c:if test="${performanceImprovementPlanMaster.status eq 1}">style="pointer-events: none;"</c:if>><textarea onchange="addToDropDownList('${step1Status.count}')" id="pipGoal${step1Status.count}" name="pipGoal${step1Status.count}" class="form-control">${improvementGoalList.goals}</textarea></td>
                                                                            <td><a href="#" data-toggle="modal" data-target="#myModal" onclick="readHistory('${step1Status.count}')">History</a></td>
                                                                            <td style="text-align: center;<c:if test="${performanceImprovementPlanMaster.status eq 1}">pointer-events: none;</c:if>">
                                                                                    <span style='margin-top: 5px;'>
                                                                                    <c:if test="${step1Status.last}">
                                                                                        <input type="button" value="+" id="step1cloneid" />
                                                                                    </c:if>
                                                                                </span>
                                                                            </td>
                                                                        </tr>
                                                                    </c:forEach>
                                                                </table>

                                                            </c:otherwise>
                                                        </c:choose>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="box box-info collapsed-box ">
                                        <div class="box-header">
                                            <h3 class="box-title">Step 2:  Activity Goals:  Listed Below Are Activities That Will Help You Reach Each Goal:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun3();"><i class="fa fa-plus" id="minusId3" ></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding" <c:if test="${performanceImprovementPlanMaster.status eq 1}">style="pointer-events: none;"</c:if>>
                                                <div class="row">
                                                    <div class="col-md-12 col-sm-12">
                                                    <c:choose>
                                                        <c:when test="${empty activityGoalList}">
                                                            <table id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                                <tr>
                                                                    <th style="text-align: center;width: 5%">Sr No.</th>
                                                                    <th style="text-align: center;width: 15%">Goal</th>
                                                                    <th style="text-align: center;width: 25%">Activity</th>
                                                                    <th style="text-align: center;width: 25%">How to Accomplish</th>
                                                                    <th style="text-align: center;width: 13%">Start Date</th>
                                                                    <th style="text-align: center;width: 13%">Completion Date</th>
                                                                    <th style="text-align: center;width: 55px"></th>
                                                                </tr>
                                                                <input type="hidden" name="secondStepCount" id="secondStepCount" value="1">
                                                                <tr>
                                                                    <td style="text-align: center">1</td>
                                                                    <td>
                                                                        <select name="activityGoal1" id="activityGoal1" class="form-control">
                                                                            <option value="">---Select---</option>
                                                                        </select>
                                                                    </td>
                                                                    <td><textarea class="form-control" id="activityName1" name="activityName1"></textarea></td>
                                                                    <td><textarea class="form-control" id="howToAccomplish1" name="howToAccomplish1"></textarea></td>
                                                                    <td><input class="form-control" name="startDate1" id="startDate1" type="text" ></td>
                                                                    <td><input class="form-control" name="completionDate1" id="completionDate1" type="text"></td>
                                                                    <td style="text-align: center"><span style='margin-top: 5px;'>
                                                                            <input type="button" value="+" id="step2cloneid" />  </span>
                                                                    </td>

                                                                </tr>
                                                            </table>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <table id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                                <tr>
                                                                    <th style="text-align: center;width: 5%">Sr No.</th>
                                                                    <th style="text-align: center;width: 15%">Goal</th>
                                                                    <th style="text-align: center;width: 25%">Activity</th>
                                                                    <th style="text-align: center;width: 25%">How to Accomplish</th>
                                                                    <th style="text-align: center;width: 13%">Start Date</th>
                                                                    <th style="text-align: center;width: 13%">Completion Date</th>
                                                                    <th style="text-align: center;width: 55px"></th>
                                                                </tr>
                                                                <input type="hidden" name="secondStepCount" id="secondStepCount" value="${fn:length(activityGoalList)}">
                                                                <c:forEach var="activityGoalList" items="${activityGoalList}" varStatus="step2Status">
                                                                    <input type="hidden" name="activityGoal_id${step2Status.count}" id="activityGoal_id${step2Status.count}" value="${activityGoalList.id}">
                                                                    <tr>
                                                                        <td style="text-align: center">${step2Status.count}</td>
                                                                        <td>
                                                                            <input type="hidden" name="hiddenActivityGoal${step2Status.count}" id="hiddenActivityGoal${step2Status.count}" value="${activityGoalList.improvementGoal}">
                                                                            <select name="activityGoal${step2Status.count}" id="activityGoal${step2Status.count}" class="form-control">
                                                                                <option value="">---Select---</option>
                                                                            </select>
                                                                        </td>
                                                                        <td><textarea class="form-control" id="activityName${step2Status.count}" name="activityName${step2Status.count}">${activityGoalList.activity}</textarea></td>
                                                                        <td><textarea class="form-control" id="howToAccomplish${step2Status.count}" name="howToAccomplish${step2Status.count}">${activityGoalList.howToCcomplish}</textarea></td>
                                                                        <td><input class="form-control" name="startDate${step2Status.count}" id="startDate${step2Status.count}" type="text" onclick="changeDateFun('${step2Status.count}');" value="${activityGoalList.activityStartDate}"></td>
                                                                        <td><input class="form-control" name="completionDate${step2Status.count}" id="completionDate${step2Status.count}" type="text" onclick="changeCompletionDateFun('${step2Status.count}');" value="${activityGoalList.projectedCompletionDate}"></td>
                                                                        <td style="text-align: center">
                                                                            <span style='margin-top: 5px;'>
                                                                                <c:if test="${step2Status.last}">
                                                                                    <input type="button" value="+" id="step2cloneid" />
                                                                                </c:if>
                                                                            </span>
                                                                        </td>
                                                                    </tr>
                                                                </c:forEach>
                                                            </table>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <!--</div>-->
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="box box-info collapsed-box ">
                                        <div class="box-header">
                                            <h3 class="box-title">Step 3:  Resource & Management Support To Accomplish Goals:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun4();"><i class="fa fa-plus" id="minusId4" ></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding" <c:if test="${performanceImprovementPlanMaster.status eq 1}">style="pointer-events: none;"</c:if>>
                                                <div class="row">
                                                    <div class="col-md-12 col-sm-12">
                                                        <!--<div class="table-responsive">-->
                                                    <c:choose>
                                                        <c:when test="${empty goalResourceManagementList}">
                                                            <table id="table_3" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                                <tr>
                                                                    <th style="text-align: center;width: 55px;">Sr No.</th>
                                                                    <th style="text-align: center;width: 285px;">Goals</th>
                                                                    <th style="text-align: center;">Resource Name</th>
                                                                    <th style="text-align: center;width: 55px;"></th>
                                                                </tr>
                                                                <input type="hidden" name="thirdStepCount" id="thirdStepCount" value="1">
                                                                <tr>
                                                                    <td style="text-align: center">1</td>
                                                                    <td>
                                                                        <select name="resourceGoal1" id="resourceGoal1" class="form-control">
                                                                            <option value="">---Select---</option>
                                                                        </select>
                                                                    </td>
                                                                    <td><textarea class="form-control" id="resourceName1" name="resourceName1"></textarea></td>
                                                                    <td style="text-align: center"><span style='margin-top: 5px;'>
                                                                            <input type="button" value="+" id="step3cloneid" />  </span>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <table id="table_3" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                                <tr>
                                                                    <th style="text-align: center;width: 55px;">Sr No.</th>
                                                                    <th style="text-align: center;width: 285px;">Goals</th>
                                                                    <th style="text-align: center;">Resource Name</th>
                                                                    <th style="text-align: center;width: 55px;"></th>
                                                                </tr>
                                                                <input type="hidden" name="thirdStepCount" id="thirdStepCount" value="${fn:length(goalResourceManagementList)}">
                                                                <c:forEach var="goalResourceManagementList" items="${goalResourceManagementList}" varStatus="step3Status">
                                                                    <input type="hidden" name="goalResource_id${step3Status.count}" id="goalResource_id${step3Status.count}" value="${goalResourceManagementList.id}">
                                                                    <tr>
                                                                        <td style="text-align: center">${step3Status.count}</td>
                                                                        <td>
                                                                            <input type="hidden" name="hiddenResourceGoal${step3Status.count}" id="hiddenResourceGoal${step3Status.count}" value="${goalResourceManagementList.improvementGoal}">
                                                                            <select name="resourceGoal${step3Status.count}" id="resourceGoal${step3Status.count}" class="form-control">
                                                                                <option value="1">---Select---</option>
                                                                            </select>
                                                                        </td>
                                                                        <td><textarea class="form-control" id="${step3Status.count}" name="resourceName${step3Status.count}">${goalResourceManagementList.resources}</textarea></td>
                                                                        <td style="text-align: center">
                                                                            <span style='margin-top: 5px;'>
                                                                                <c:if test="${step3Status.last}">
                                                                                    <input type="button" value="+" id="step3cloneid" />
                                                                                </c:if>
                                                                            </span>
                                                                        </td>
                                                                    </tr>
                                                                </c:forEach>
                                                            </table>

                                                        </c:otherwise>
                                                    </c:choose>
                                                    <!--</div>-->
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="box box-info collapsed-box ">
                                        <div class="box-header">
                                            <h3 class="box-title">Step 4:  PIP Meeting And Manager's Remarks:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId5">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun5();"><i class="fa fa-plus" id="minusId5" ></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding" style="pointer-events: none;">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <!--<div class="table-responsive">-->
                                                    <c:choose>
                                                        <c:when test="${empty pipMeetingList}">
                                                            <table id="table_4" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                                <tr>
                                                                    <th style="text-align: center;width: 55px;">Sr No.</th>
                                                                    <th style="text-align: center;width: 135px;">Date Scheduled</th>
                                                                    <th style="text-align: center;width: 155px;">Meeting</th>
                                                                    <th style="text-align: center;">Remarks</th>
                                                                    <!--<th style="text-align: center;width: 55px;"></th>-->
                                                                </tr>
                                                                <input type="hidden" name="forthStepCount" id="forthStepCount" value="1">
                                                                <tr>
                                                                    <td style="text-align: center">1</td>
                                                                    <td><input class="form-control" name="scheduledDate1" id="scheduledDate1" type="text"></td>
                                                                    <td>
                                                                        <select name="meeting1" id="meeting1" class="form-control">
                                                                            <option value="">---Select---</option>
                                                                            <option value="Face-To-Face">Face-To-Face</option>
                                                                            <option value="Skype">Skype</option>
                                                                            <option value="Call">Call</option>
                                                                        </select>
                                                                    </td>
                                                                    <td><textarea class="form-control" id="managerRemark1" name="managerRemark1"></textarea></td>
                                                                    <!--                                                                    <td style="text-align: center">
                                                                                                                                            <span style='margin-top: 5px;'>

                                                                                                                                                <input type="button" value="+" id="step4cloneid" /> </span>
                                                                                                                                        </td>-->
                                                                </tr>
                                                            </table>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <table id="table_4" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                                <tr>
                                                                    <th style="text-align: center;width: 55px;">Sr No.</th>
                                                                    <th style="text-align: center;width: 155px;">Date Scheduled</th>
                                                                    <th style="text-align: center;width: 155px;">Meeting</th>
                                                                    <th style="text-align: center;">Remarks</th>
                                                                </tr>
                                                                <input type="hidden" name="forthStepCount" id="forthStepCount" value="${fn:length(pipMeetingList)}">
                                                                <c:forEach var="pipMeetingList" items="${pipMeetingList}" varStatus="step4Status">
                                                                    <input type="hidden" name="pipMeeting_id${step4Status.count}" id="pipMeeting_id${step4Status.count}" value="${pipMeetingList.id}">
                                                                    <tr>
                                                                        <td style="text-align: center">${step4Status.count}</td>
                                                                        <td><input class="form-control" name="scheduledDate${step4Status.count}" id="scheduledDate${step4Status.count}" type="text" value="${pipMeetingList.dateScheduled}"></td>
                                                                        <td>
                                                                            <select name="meeting${step4Status.count}" id="meeting${step4Status.count}" class="form-control">
                                                                                <option value="">---Select---</option>
                                                                                <c:if test="${pipMeetingList.meeting eq 'Face-To-Face'}">
                                                                                    <option value="Face-To-Face" selected="">Face-To-Face</option>
                                                                                </c:if>
                                                                                <c:if test="${pipMeetingList.meeting ne 'Face-To-Face'}">
                                                                                    <option value="Face-To-Face" >Face-To-Face</option>
                                                                                </c:if>

                                                                                <c:if test="${pipMeetingList.meeting eq 'Skype'}">
                                                                                    <option value="Skype" selected="">Skype</option>
                                                                                </c:if>
                                                                                <c:if test="${pipMeetingList.meeting ne 'Skype'}">
                                                                                    <option value="Skype">Skype</option>
                                                                                </c:if>
                                                                                <c:if test="${pipMeetingList.meeting eq 'Call'}">
                                                                                    <option value="Call" selected="">Call</option>
                                                                                </c:if>
                                                                                <c:if test="${pipMeetingList.meeting ne 'Call'}">
                                                                                    <option value="Call">Call</option>
                                                                                </c:if>
                                                                            </select>
                                                                        </td>
                                                                        <td><textarea class="form-control" id="managerRemark${step4Status.count}" name="managerRemark${step4Status.count}">${pipMeetingList.remarks}</textarea></td>
                                                                    </tr>
                                                                </c:forEach>
                                                            </table>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <div class="col-sm-2">
                                                        <label>Next Schedule Date:</label>
                                                    </div>
                                                    <c:choose>
                                                        <c:when test="${empty pipNextScheduledDateList}">
                                                            <div class="col-sm-2">
                                                                <input type="Text" class="form-control" name="nextScheduleDate" id="nextScheduleDate" >
                                                            </div>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <c:forEach var="pipNextScheduledDateList" items="${pipNextScheduledDateList}">
                                                                <input type="hidden" name="pipNextScheduledDate_id" id="pipNextScheduledDate_id" value="${pipNextScheduledDateList.id}">
                                                                <div class="col-sm-2">
                                                                    <input type="Text" class="form-control" name="nextScheduleDate" id="nextScheduleDate" value="${pipNextScheduledDateList.nextScheduleDateTime}">
                                                                </div>
                                                            </c:forEach>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <br/>
                                                    <!--</div>-->
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <h4><b>TimeLine For Improvement, Consequences & Expectations:</b></h4>
                                    <h4 class="box-title">Objective of the Performance Improvement Plan is to help you improve on your current level of performance. This tool will help you as an employee to focus on the performance areas and prioritize your business activities to bring out better performance resulting in better individual results.</h4>
                                    <h4 class="box-title">Effective immediately, you are placed on a <b>(insert 60, 75, 90, 120 or 160)</b>-day PIP.  During this time your performance will be closely observed and monitored. Should you need any assistance you are required to contact your Reporting Manager immediately and seek support and required clarity for accomplishing your goals.</h4>
                                    <h4 class="box-title">It is expected that the contents of the PIP are kept confidential by the employee and the Reporting Manager.  Should you have questions or concerns regarding the content, you will be expected to follow up directly with the Reporting Manager.</h4>
                                    <h4 class="box-title">We will meet again on as noted above to discuss your Performance Improvement Plan.  Please schedule accordingly.</h4>
                                    <div>
                                        &nbsp;
                                    </div>
                                    <c:if test="${performanceImprovementPlanMaster.status ne 1}">

                                        <div class="form-group">
                                            <div class="col-sm-12" style="text-align: center">
                                                <button type="submit" class="btn btn-primary" data-original-title="" title="" style="width: 100px">SUBMIT</button>
                                            </div>
                                        </div>
                                    </c:if>
                                </form:form>
                            </div>
                        </div><!-- nav-tabs-custom -->
                    </div>
                </div>
            </section>

        </div>
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">History</h4>
                    </div>
                    <div class="modal-body" id="viewHistory_id">

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
        <link rel="stylesheet" href="StorageYard/datetimepicker/css/bootstrap-datetimepicker.min.css">
        <script type="text/javascript" src="StorageYard/datetimepicker/js/jquery.datetimepicker.full.min.js" charset="UTF-8"></script>
    </body>
</html>
