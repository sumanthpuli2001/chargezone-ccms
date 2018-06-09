<%--
    Document   : TravelRequestFinalApprove
    Created on : Feb 5, 2016, 2:32:45 PM
    Author     : Vinita
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>

    <head>
        <title>Travel Request Approve</title>
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
            function buttonFun6() {
                var className = $('#minusId6').attr('class');
                if (className == 'fa fa-plus') {
                    document.getElementById('spanId6').innerHTML = 'Minimize';
                } else {
                    document.getElementById('spanId6').innerHTML = 'Expand';
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
            function buttonFun8() {
                var className = $('#minusId8').attr('class');
                if (className == 'fa fa-plus') {
                    document.getElementById('spanId8').innerHTML = 'Minimize';
                } else {
                    document.getElementById('spanId8').innerHTML = 'Expand';
                }
            }

        </script>
        <script>


            var i1 = 1;
            var i2 = 1;
            var i3 = 1;
            $(function () {
                $("#addRowButtonId_table_1").on("click", function () {
                    i1 = document.getElementById("countId").value;
                    i1++;
                    var clone = "<tr id='table_1_rowNo_" + i1 + "'>"
                            + "<td style=\"text-align: center\">" + i1 + "</td>"
                            + "<td style=\"width:190px\"><div class=\"input-group date\" data-date-format=\"dd/mm/yyyy - hh:ii\" data-link-field=\"dtp_input1\">"
                            + "<input class=\"form-control date date_datetime\" name=\"date" + i1 + "\" id=\"date" + i1 + "\" size=\"5\" type=\"text\" readonly>"
                            + "<span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-th\"></span></span>"
                            + "</div></td>"
                            + "<td><input type=\"Text\" name=\"fromLocation" + i1 + "\" id=\"fromLocation" + i1 + "\" class=\"form-control\"></td>"
                            + "<td><input type=\"Text\" name=\"toLocation" + i1 + "\" id=\"toLocation" + i1 + "\" class=\"form-control\"></td>"
                            + "<td><select class=\"form-control\" id=\"travelModeId" + i1 + "\" name=\"travelModeId" + i1 + "\" onchange=\"ajaxfun1(" + i1 + ");\">"
                            + "<option value=\"\"> --SELECT-- </option>"
                            + "<option value=\"Air\"> Air </option>"
                            + "<option value =\"Train\"> Train </option>"
                            + "<option value =\"Bus\"> Bus </option>"
                            + "<option value =\"Cab\"> Cab </option>"
                            + "<option value =\"AutoRickshaw\"> Auto Rickshaw </option>"
                            + "</select></td>"
                            + "<td style=\"text-align: center\"><b><input type=\"text\" id=\"deviateId" + i1 + "\" name=\"deviateId" + i1 + "\" value=\"\" class=\"form-control\" readonly=\"true\"></b></td>"
                            + "<td><textarea class=\"form-control\" name=\"comments" + i1 + "\" id=\"comments" + i1 + "\"></textarea></td>"
                            + "<td>"
                            + "<span style='margin-top: 5px;' class=\"col-sm-1\">"
                            + "<input type=\"button\" value=\"-\" id=\"removeRowButtonId\" onclick=\"removeChild1('table_1_rowNo_" + i1 + "');\">"
                            + "</span>"
                            + "</td>"
                            + "</tr>";
                    document.getElementById("countId").value = i1;
                    //                        +"<script>"
                    //                        +" $('.date_datetime').datepicker({});"
                    //                        +"<\/script>";
                    $("#table_1").append(clone);
                    $('.date_datetime').datepicker({
                        weekStart: 1,
                        todayBtn: 1,
                        autoclose: 1,
                        todayHighlight: 1,
                        startView: 2,
                        forceParse: 0,
                        showMeridian: 1
                    });
                });
                $("#addRowButtonId_table_2").on("click", function () {
                    i2 = document.getElementById("countDetailId").value
                    i2++;
                    //                var clone = "<tr id='table_2_rowNo_" + i2 + "'>"
                    //                        + "<td>" + i2 + "</td>"
                    //                        + "<td><input type=\"Text\" class=\"form-control\"></td>"
                    //                        + "<td><select class=\"form-control\">"
                    //                        + "<option value =\"\"> --SELECT-- </option>"
                    //                        + "<option value =\"Yes\"> Yes </option>"
                    //                        + "<option value =\"No\"> No </option>"
                    //                        + "</select></td>"
                    //                        + "<td style=\"width:190px\"><div class=\"input-group date\" data-date-format=\"dd/mm/yyyy - hh:ii\" data-link-field=\"dtp_input1\">"
                    //                        + "<input class=\"form-control date_datetime\" size=\"5\" type=\"text\" readonly>"
                    //                        + "<span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-th\"></span></span>"
                    //                        + "</div></td>"
                    //                        + "<td style=\"width:190px\"><div class=\"input-group date\" data-date-format=\"dd/mm/yyyy - hh:ii\" data-link-field=\"dtp_input1\">"
                    //                        + "<input class=\"form-control date_datetime\" size=\"5\" type=\"text\" readonly>"
                    //                        + "<span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-th\"></span></span>"
                    //                        + "</div></td>"
                    //                        + "<td><input type=\"Text\" class=\"form-control\"></td>"
                    //                        + "<td><textarea class=\"form-control\"></textarea></td>"
                    //                        + "<td>"
                    //                        + "<span style='margin-top: 5px;' class=\"col-sm-1\">"
                    //                        + "<input type=\"button\" value=\"-\" id=\"removeRowButtonId\" onclick=\"removeChild2('table_2_rowNo_" + i2 + "');\">"
                    //                        + "</span>"
                    //                        + "</td>"
                    //                        + "</tr>";
                    var clone = "<tr id='table_2_rowNo1_" + i2 + "'>"
                            + "<th> Sr No. </th>"
                            + "<th> Locations </th>"
                            + "<th> Check - in (Date & Time)</th>"
//                            + "<th> Pick Up </th>"
                            + "<th> Preferred Hotels </th>"
                            + "<th></th>"
                            + "</tr>"
                            + "<tr id='table_2_rowNo2_" + i2 + "'>"
                            + "<td> " + i2 + " </td>"
                            + "<td> <input type =\"Text\" name=\"location" + i2 + "\" id=\"location" + i2 + "\" class =\"form-control\"> </td>"
                            + "<td style =\"width: 190px\"> <div class =\"input-group date form_datetime\" data - date - format =\"dd/mm/yyyy - hh:ii\" data - link - field =\"dtp_input1\">"
                            + "<input class =\"form-control date_datetime\" size =\"5\" type =\"text\" name=\"checkInDate" + i2 + "\" id=\"checkInDate" + i2 + "\"  style =\"\" readonly>"
                            + "<span class =\"input-group-addon\"> <span class =\"glyphicon glyphicon-th\"></span></span>"
                            + "</div></td>"
//                            + "<td><input type =\"checkbox\" onclick=\"pickUpCheckBox(" + i2 + ")\" id =\"pickUpCheckBoxId" + i2 + "\" name =\"pickUpCheckBoxId" + i2 + "\" style =\"width: 20px\"><select id =\"pickUpId" + i2 + "\" name =\"pickUpId" + i2 + "\" class =\"form-control\" style =\"width: 150px;margin-left: 24px;margin-top: -21px;display: none\">"
//                            + "<option value =\"\"> --SELECT-- </option>"
//                            + "<option value =\"Railwaystation\"> Railway Station </option>"
//                            + "<option value =\"Airport\" > Airport </option>"
//                            + "</select></td>"
                            + "<td><input type =\"Text\" name=\"preferredHotel" + i2 + "\" id=\"preferredHotel" + i2 + "\" class =\"form-control\"></td>"
                            + "<td><span style =\"margin-top: 5px;\" class =\"col-sm-1\">"
                            + "<input type=\"button\" value=\"-\" id=\"removeRowButtonId\" onclick=\"removeChild2('table_2_rowNo1_" + i2 + "','table_2_rowNo2_" + i2 + "','table_2_rowNo3_" + i2 + "','table_2_rowNo4_" + i2 + "');\">"
                            + "</span></td>"
                            + "</tr>"
                            + "<tr id='table_2_rowNo3_" + i2 + "'>"
                            + "<th></th>"
                            + "<th> Hotel Booking Required </th>"
                            + "<th> Check - out (Date & Time) </th>"
//                            + "<th> Drop </th>"
                            + "<th> Comments / Remarks Box </th>"
                            + "<th> </th>"
                            + "</tr>"
                            + "<tr id='table_2_rowNo4_" + i2 + "'>"
                            + "<td></td>"
                            + "<td><select class =\"form-control\" id=\"hotelBookingRequired" + i2 + "\" name=\"hotelBookingRequired" + i2 + "\">"
                            + "<option value =\"\"> --SELECT-- </option>"
                            + "<option value =\"Yes\"> Yes </option>"
                            + "<option value =\"No\"> No </option>"
                            + "</select></td>"
                            + "<td style =\"width: 190px\"><div class =\"input-group date form_datetime\" data - date - format =\"dd/mm/yyyy - hh:ii\" data - link - field =\"dtp_input1\">"
                            + "<input class =\"form-control date_datetime\" name=\"checkOutDate" + i2 + "\" id=\"checkOutDate" + i2 + "\" size =\"5\" type =\"text\" readonly >"
                            + "<span class =\"input-group-addon\"><span class=\"glyphicon glyphicon-th\"></span></span>"
                            + "</div></td >"
//                            + "<td style =\"width: 200px\"><input type =\"checkbox\" onclick=\"pickUpCheckBox(" + i2 + ")\" id =\"dropCheckBoxId" + i2 + "\" name =\"dropCheckBoxId" + i2 + "\" style =\"width: 20px;\"><select id =\"dropId" + i2 + "\" name =\"dropId" + i2 + "\" class =\"form-control\" style=\"width: 150px;margin-left: 24px;margin-top: -21px;display: none\">"
//                            + "<option value =\"\" > --SELECT-- </option>"
//                            + "<option value =\"Railwaystation\"> Railway Station </option>"
//                            + "<option value =\"Airport\"> Airport </option>"
//                            + "</select></td>"
                            + "<td><textarea class =\"form-control\" name=\"remark" + i2 + "\" id=\"remark" + i2 + "\"></textarea></td>"
                            + "<td>"
                            + "</td>"
                            + "</tr>";
                    document.getElementById("countDetailId").value = i2;
                    $("#table_2").append(clone);
                    $('.date_datetime').datepicker({
                        weekStart: 1,
                        todayBtn: 1,
                        autoclose: 1,
                        todayHighlight: 1,
                        startView: 2,
                        forceParse: 0,
                        showMeridian: 1
                    });
                });
                $("#addRowButtonId_table_3").on("click", function () {
                    i3++;
                    var clone = "<tr id='table_3_rowNo_" + i3 + "'>"
                            + "<td>" + i3 + "</td>"
                            + "<td><input type=\"Text\" class=\"form-control\"></td>"

                            + "<td><input type=\"Text\" class=\"form-control\"></td>"
                            + "<td>"
                            + "<span style='margin-top: 5px;' class=\"col-sm-1\">"
                            + "<input type=\"button\" value=\"-\" id=\"removeRowButtonId\" onclick=\"removeChild3('table_3_rowNo_" + i3 + "');\">"
                            + "</span>"
                            + "</td>"
                            + "</tr>";
                    $("#table_3").append(clone);
                    $('.date_datetime').datepicker({
                        weekStart: 1,
                        todayBtn: 1,
                        autoclose: 1,
                        todayHighlight: 1,
                        startView: 2,
                        forceParse: 0,
                        showMeridian: 1
                    });
                });
                //            checkbox of travel detail


                $('input[type=checkbox]').on('ifChecked', function (event) {
                    var abc = event.target.name;
                    var newCheck = abc.split('_');

                    var cc = newCheck[1];
                    var aa = newCheck[0];
//                    alert(aa);
                    if (aa == 'dropCheckBoxId') {
//                        alert('xxxxx');
                        $('#dropId' + cc).show(500);
                    }
                    else if (aa == 'pickUpCheckBoxId') {
//                        alert('azzzzzz');
                        $('#pickUpId' + cc).show(500);

                    }
                });
                $('input[type=checkbox]').on('ifUnchecked', function (event) {
                    var abc = event.target.name;
                    var newCheck = abc.split('_');
                    var cc = newCheck[1];
                    var aa = newCheck[0];
                    if (aa == 'dropCheckBoxId') {
                        $('#dropId' + cc).hide(500);
                    } else if (aa == 'pickUpCheckBoxId') {
                        $('#pickUpId' + cc).hide(500);
                    }
                });
//                $('#dropCheckBoxId1').on('ifChecked', function (event) {
//                    $('#dropId1').show(500);
//                });
//                $('#dropCheckBoxId1').on('ifUnchecked', function (event) {
//                    $('#dropId1').hide(500);
//                });
//                $("#pickUpCheckBoxId1").click(function () {
//                    if ($(this).is(":checked")) {
//                        $("#pickUpId1").show();
//                    } else {
//                        $("#pickUpId1").hide();
//                    }
//                });
//                $("#dropCheckBoxId1").click(function () {
//                    if ($(this).is(":checked")) {
//                        $("#dropId1").show();
//                    } else {
//                        $("#dropId1").hide();
//                    }
//                });
            });
            function cashRequired() {
                var selectedValue = document.getElementById("cashRequiredId").value;
//                alert('aaaa' + selectedValue);
                var travelType = document.getElementById("TravelTypeSelectId").value;
                var countId = document.getElementById("countId").value;


                if (travelType == 'International') {
                    $('#policyDeviation_th_id').hide();
//                    $('#policyDeviation_td_id').hide();

//                    $("#travelModeId1").children('option').hide();
//                    $("#travelModeId1").children("option[value^=Air]").show();
                    document.getElementById("travelModeId1").options[1].selected = "true";

//                    document.getElementById("travelModeId1").disabled = true;
//                    document.getElementById("travelModeId1").value = 'Air';
                    for (i = 1; i <= countId; i++) {
                        $('#policy_deviated_id_' + i).hide();
//                        $("#travelModeId" + i).children('option').hide();
//                        $("#travelModeId" + i).children("option[value^=Air]").show();

//                        document.getElementById("travelModeId" + i).options[1].selected = "true";
//                        document.getElementById("travelModeId" + i).value = 'Air';
                    }
                } else {
//                    $('#policyDeviation_th_id').show();
//                    $('#policyDeviation_td_id').show();
//                    $("#travelModeId1").children('option').show();
//                    document.getElementById("travelModeId1").disabled = false;
                    for (i = 1; i <= countId; i++) {
                        $('#policy_deviated_id_' + i).show();
//                        $("#travelModeId" + i).children('option').show();
//                        document.getElementById("travelModeId" + i).disabled = false;
                    }

                }


                if (selectedValue == 'Yes') {
                    $("#cashRequiredYes").show();
                    if (travelType == 'International') {
                        $("#cashRequiredYesCurrency").show();
                    } else {
                        $("#cashRequiredYesCurrency").hide();
                    }
                }
                else {
                    $("#cashRequiredYes").hide();
                }
            }
            //            $("#removeRowButtonId").on("click", function () {
            //            });
            function removeChild1(removeRowId1) {

                i1--;
                // Removes an element from the document
                var element1 = document.getElementById(removeRowId1);
                element1.parentNode.removeChild(element1);
            }
            function removeChild2(removeRowId1, removeRowId2, removeRowId3, removeRowId4) {
                i2--;
                // Removes an element from the document
                var element1 = document.getElementById(removeRowId1);
                var element2 = document.getElementById(removeRowId2);
                var element3 = document.getElementById(removeRowId3);
                var element4 = document.getElementById(removeRowId4);
                element1.parentNode.removeChild(element1);
                element2.parentNode.removeChild(element2);
                element3.parentNode.removeChild(element3);
                element4.parentNode.removeChild(element4);
            }
            function removeChild3(removeRowId1) {

                i3--;
                // Removes an element from the document
                var element1 = document.getElementById(removeRowId1);
                element1.parentNode.removeChild(element1);
            }



            function pickUpCheckBox(checkId) {
                if (document.getElementById("pickUpCheckBoxId" + checkId).checked) {
                    $("#pickUpId" + checkId).show();
                } else {

                    $("#pickUpId" + checkId).hide();
                }
                if (document.getElementById("dropCheckBoxId" + checkId).checked) {
                    $("#dropId" + checkId).show();
                } else {

                    $("#dropId" + checkId).hide();
                }


            }

            function ajaxfun1(id) {
                var selectedVal = document.getElementById("travelModeId" + id).value;
                var empAjaxId = document.getElementById("empAjaxId").value;
                var levelId = document.getElementById("levelId").value;
//                alert('ajay' + selectedVal);
                $.ajax({
                    type: "POST",
                    url: "policyDeviationForAir.htm?act=ajaxCall&levelId=" + levelId,
//                    data: "selectedvalue=" + selectedVal,
                    data: {"selectedvalue": selectedVal},
                    dataType: "text",
                    success: function (responseTxt) {
//                        alert(responseTxt);
                        if (selectedVal == 'Air') {
                            document.getElementById("deviateId" + id).value = responseTxt;
                        } else {

                            document.getElementById("deviateId" + id).value = "";
                        }
//                        data = response;
//                        return response;
                    },
                    error: function () {
                        alert('Error occured');
                    }
                });
            }
        </script>
        <script>
            function ajaxfun() {
                var selectedVal = document.getElementById("travelModeId1").value;
                var empAjaxId = document.getElementById("empAjaxId").value;
                var levelId = document.getElementById("levelId").value;
//                alert('ajay' + selectedVal);
                $.ajax({
                    type: "POST",
                    url: "policyDeviationForAir.htm?act=ajaxCall&levelId=" + levelId,
//                    data: "selectedvalue=" + selectedVal,
                    data: {"selectedvalue": selectedVal},
                    dataType: "text",
                    success: function (responseTxt) {
//                        alert(responseTxt);
                        if (selectedVal == 'Air') {
                            document.getElementById("deviateId1").value = responseTxt;
                        } else {

                            document.getElementById("deviateId1").value = "";
                        }
//                        data = response;
//                        return response;
                    },
                    error: function () {
                        alert('Error occured');
                    }
                });
            }
        </script>
        <script>
            $(document).ready(function () {
                $('#travelRequestNo').css("font-weight", "Bold");
            });</script>


    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>TRAVEL REQUEST</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Approve</li>
            </ol>
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
                            <!--form horizontal starts here-->
                            <form:form action="travelRequestMaster.htm?act=approveCEO" method="post" commandName="travelRequestMaster"
                                       name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
                                <form:hidden path="id"></form:hidden>
                                <input type="hidden" name="empid" id="empid" value="${empid}">

                                <div class="box box-info collapsed-box ">
                                    <div class="box-header">
                                        <h3 class="box-title">Employee Detail:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId1">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun1();"><i class="fa fa-plus" id="minusId1" ></i></button>
                                            <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
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
                                                        <label>Contact No:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" value="${employeeMaster[8]}" readonly>
                                                    </div>
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

                                <!--Employee detail completes here-->
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Travel Request and Type:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2();"><i class="fa fa-plus" id="minusId2" ></i></button>
                                            <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <label class="col-sm-3   control-label">Travel Request Application No.:</label>

                                                    <div class="col-sm-7">
                                                        <form:input path="travelRequestNo" class="form-control" value="${requestNo}" readonly="true"></form:input>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-3  control-label">Travel Type:</label>
                                                        <div class="col-sm-7">
                                                        <form:select path="travelType" onchange="cashRequired()" id="TravelTypeSelectId" class="form-control" disabled="true">
                                                            <form:option value="" label="--SELECT--"></form:option>
                                                            <form:option value="Domestic" label="Domestic"></form:option>
                                                            <form:option value="International" label="International"></form:option>
                                                        </form:select>
                                                    </div>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                                <!--Travel request and type detail completes here-->
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Attendance Regularization Detail:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun3();"><i class="fa fa-plus" id="minusId3" ></i></button>
                                            <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <label class="col-sm-3  control-label">Start Date And Time:</label>
                                                    <div class=" col-sm-7">
                                                        <!--<div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy - hh:ii " data-link-field="dtp_input1">-->
                                                        <form:input path="startDateTime" class="form-control" size="16" value="" readonly="true"></form:input>
                                                            <!--<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>-->
                                                            <!--</div>-->
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-3  control-label">End Date And Time:</label>
                                                        <div class=" col-sm-7">
                                                            <!--<div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy - hh:ii " data-link-field="dtp_input1">-->
                                                        <form:input path="endDateTime" class="form-control" size="16" value="" readonly="true"></form:input>
                                                            <!--<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>-->
                                                            <!--</div>-->
                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <!--Attendance Regularization detail completes here-->
                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">Travel Detail:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun4();"><i class="fa fa-plus" id="minusId4" ></i></button>
                                                <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="table-responsive">
                                                        <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                            <tr>
                                                                <th style="text-align: center;width: 7%;">Sr No.</th>
                                                                <th style="text-align: center">Date</th>
                                                                <th style="text-align: center">From Location</th>
                                                                <th style="text-align: center">To Location</th>
                                                                <th style="text-align: center">Mode of Travel</th>
                                                                <th style="text-align: center;display: none" id="policyDeviation_th_id">Policy Deviation</th>
                                                                <th style="text-align: center">Comments / Remarks Box</th>
                                                            </tr>
                                                            <input type="hidden" name="countId" id="countId" value="${fn:length(travelDetailList)}">
                                                        <c:forEach var="travelDetailList" items="${travelDetailList}" varStatus="status">
                                                            <tr>
                                                            <input type="hidden" name="travelDetailId_${status.count}" id="travelDetailId${status.count}" value="${travelDetailList.id}">
                                                            <td style="text-align: center">${status.count}</td>
                                                            <td style="width:190px">
                                                                <!--<div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy-hh:ii " data-link-field="dtp_input1">-->
                                                                <input class="form-control" name="date${status.count}" id="date${status.count}"  size="5" type="text" readonly value="${travelDetailList.date}">
                                                                <!--<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>-->
                                                                <!--</div>-->
                                                            </td>
                                                            <td><input type="Text" name="fromLocation${status.count}" id="fromLocation${status.count}" class="form-control" readonly="" value="${travelDetailList.fromLocation}"></td>
                                                            <td><input type="Text" name="toLocation${status.count}" id="toLocation${status.count}" class="form-control" readonly="" value="${travelDetailList.toLocation}"></td>
                                                            <td><select class="form-control" id="travelModeId${status.count}" name="travelModeId${status.count}" onchange="ajaxfun1(${status.count});" disabled="true">
                                                                    <option value="">--SELECT--</option>
                                                                    <c:choose>
                                                                        <c:when test="${travelDetailList.modeOfTravel eq 'Air'}">
                                                                            <option value="Air" selected="">Air</option>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <option value="Air">Air</option>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                    <c:choose>
                                                                        <c:when test="${travelDetailList.modeOfTravel eq 'Train'}">
                                                                            <option value="Train" selected="">Train</option>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <option value="Train">Train</option>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                    <c:choose>
                                                                        <c:when test="${travelDetailList.modeOfTravel eq 'Bus'}">
                                                                            <option value="Bus" selected="">Bus</option>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <option value="Bus">Bus</option>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                    <c:choose>
                                                                        <c:when test="${travelDetailList.modeOfTravel eq 'Cab'}">
                                                                            <option value="Cab" selected="">Cab</option>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <option value="Cab">Cab</option>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                    <c:choose>
                                                                        <c:when test="${travelDetailList.modeOfTravel eq 'AutoRickshaw'}">
                                                                            <option value="AutoRickshaw" selected="">Auto Rickshaw</option>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <option value="AutoRickshaw">Auto Rickshaw</option>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </select></td>
                                                            <td style="text-align: center" id="policy_deviated_id_${status.count}"> ><b><input type="text" readonly="" id="deviateId${status.count}" name="deviateId${status.count}" value="${travelDetailList.policyDeviation}" class="form-control" readonly="true"></b></td>
                                                            <td><textarea class="form-control" readonly="" name="comments${status.count}" id="comments${status.count}">${travelDetailList.comments}</textarea></td>

                                                            </tr>
                                                        </c:forEach>
                                                    </table>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row 1-->
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="table-responsive">
                                                    <table id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <input type="hidden" name="countDetailId" id="countDetailId" value="${fn:length(accommodationList)}">
                                                        <c:forEach var="accommodationList" items="${accommodationList}" varStatus="status1">

                                                            <tr>
                                                                <th style="text-align: center;width: 7%;">Sr No.</th>
                                                                <th style="text-align: center">Hotel Booking Required</th>
                                                                <th style="text-align: center">Locations</th>

                                                                <!--<th style="text-align: center">Pick Up</th>-->
                                                                <th style="text-align: center">Preferred Hotels</th>
                                                            </tr>
                                                            <tr>
                                                            <input type="hidden" name="accommodationId_${status1.count}" id="accommodationId_${status1.count}" value="${accommodationList.id}">
                                                            <td style="text-align: center">${status1.count}</td>
                                                            <td><select class="form-control" id="hotelBookingRequired${status1.count}" name="hotelBookingRequired${status1.count}" disabled="true">
                                                                    <option value="">--SELECT--</option>
                                                                    <c:choose>
                                                                        <c:when test="${accommodationList.hotelBookingRequired eq 'Yes'}">
                                                                            <option value="Yes" selected="">Yes</option>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <option value="Yes">Yes</option>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                    <c:choose>
                                                                        <c:when test="${accommodationList.hotelBookingRequired eq 'No'}">
                                                                            <option value="No" selected="">No</option>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <option value="No">No</option>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </select></td>
                                                            <td><input type="Text" readonly="" name="location${status1.count}" id="location${status1.count}" class="form-control" value="${accommodationList.location}"></td>

                                                            <td><input type="Text" readonly="" name="preferredHotel${status1.count}" id="preferredHotel${status1.count}" class="form-control" value="${accommodationList.preferredHotel}"></td>

                                                            </tr>
                                                            <tr>
                                                                <th style="text-align: center"></th>

                                                                <th style="text-align: center">Check-In Date</th>
                                                                <th style="text-align: center">Check-Out Date</th>
                                                                <!--<th style="text-align: center">Drop </th>-->
                                                                <th style="text-align: center">Comments / Remarks Box</th>
                                                                <th style="text-align: center"></th>
                                                            </tr>
                                                            <tr>
                                                                <td style="text-align: center"></td>

                                                                <td style="width: 190px">
                                                                    <input class="form-control" size="5" name="checkInDate${status1.count}" id="checkInDate${status1.count}" type="text"  style="" readonly value="${accommodationList.checkInDate}">
                                                                </td>
                                                                <td style="width: 190px">
                                                                    <input class="form-control" size="5" type="text"  name="checkOutDate${status1.count}" id="checkOutDate${status1.count}"  style="" readonly value="${accommodationList.checkOutDate}">
                                                                </td>
                                                                <td><textarea readonly="" name="remark${status1.count}" id="remark${status1.count}" class="form-control">${accommodationList.comments}</textarea></td>
                                                                <td>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </table>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row  2-->
                                    </div><!-- /.box-body -->
                                </div>
                                <!--Travel detail completes here-->
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Cash Advance Required:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId5">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun5();"><i class="fa fa-plus" id="minusId5" ></i></button>
                                            <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-3">
                                                        <label>Cash Advance Required</label>
                                                        <select name="cashRequiredId" id="cashRequiredId" class="form-control" onchange="cashRequired()" disabled="true">
                                                            <option value="">--SELECT--</option>
                                                            <c:choose>
                                                                <c:when test="${travelRequestMaster.cashRequired eq 'Yes'}">
                                                                    <option value="Yes" selected="">Yes</option>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <option value="Yes">Yes</option>
                                                                </c:otherwise>
                                                            </c:choose>
                                                            <c:choose>
                                                                <c:when test="${travelRequestMaster.cashRequired eq 'No'}">
                                                                    <option value="No" selected="">No</option>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <option value="No">No</option>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </select>
                                                    </div>
                                                    <div id="cashRequiredYes" style="display:none">

                                                        <div class="col-sm-2">
                                                            <label>Amount</label>
                                                            <form:input path="amount" class="form-control" readonly="true"></form:input>
                                                            </div>
                                                            <div class="col-sm-5">
                                                                <label>Reason Of Advance</label>
                                                            <form:input path="reasonForAdvance" class="form-control" readonly="true"></form:input>
                                                            </div>
                                                            <div class="col-sm-2">
                                                                <div id="cashRequiredYesCurrency">
                                                                    <label>Currency</label>
                                                                <c:forEach var="currency" items="${currencyMap}">
                                                                    <c:if test="${travelRequestMaster.currency eq currency.key}">
                                                                        <input type="text" name="currency" id="currency" value="${currency.value}" readonly="" class="form-control">
                                                                    </c:if>
                                                                </c:forEach>
                                                            </div>
                                                        </div>

                                                    </div>
                                                </div>

                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                                <!--cash advanced required completes here-->
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Travel Purpose:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId6">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun6();"><i class="fa fa-plus" id="minusId6" ></i></button>
                                            <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">Reason for Request:</label>
                                                    <div class="col-sm-7">
                                                        <form:textarea path="purpose" class="form-control" rows="6" readonly="true"></form:textarea>
                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">Approver Comments:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId7">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun7();"><i class="fa fa-plus" id="minusId7" ></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label">Comments/Remark:</label>
                                                        <div class="col-sm-7">
                                                        <c:if test="${travelRequestMaster.status eq 6}">
                                                            <textarea id="managerRemark" name="adminRemark" class="form-control" rows="6"></textarea>
                                                        </c:if>
                                                        <c:if test="${travelRequestMaster.status ne 6}">
                                                            <textarea id="managerRemark" name="adminRemark" class="form-control" rows="6" readonly="true"></textarea>
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>

                                <!--Travel Purpose In Detail completes Here-->
                                <div class="form-group">
                                    <c:if test="${travelRequestMaster.status eq 6}">
                                        <div class="col-sm-6" style="text-align: left">
                                            <button type="submit" name="btnSubmit" id="btnSubmit" class="btn btn-success" data-original-title="" title="" value="approve" style="width: 100px;">ACCEPT</button>
                                        </div>
                                        <div class="col-sm-6" style="text-align: right">
                                            <button type="submit" name="btnSubmit" id="btnSubmit" class="btn btn-warning" data-original-title="" title="" value="rework" style="width: 100px;">REWORK</button>
                                        </div>
                                    </c:if>
                                </div>
                            </form:form>

                            <!--form horizontal ends here-->
                            <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <script type="text/javascript">
        $('.form_datetime').datetimepicker({
            //        language:  'fr',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            forceParse: 0,
            showMeridian: 1
        });
        $(document).ready(function () {
            $("input[name='checkgroup']").attr("disabled", "disabled");
            cashRequired();

            $('input[type=checkbox]').attr('checked', function (event) {

                $('#pickUpId' + event).show(500);
                $('#dropId' + event).show(500);
            });

        });

    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
