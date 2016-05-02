<%--
    Document   : TravelReportExportToPdf
    Created on : Mar 3, 2016, 5:30:04 PM
    Author     : AJAY
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%--<%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>--%>

    <head>
        <title>Travel Report</title>
        <style type="text/css" media="print">
            @page { margin: 0;
                    size: landscape; }
            </style>

            <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
            <link rel="stylesheet" href="/resources/demos/style.css">
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
                                + "<td style=\"width:95px\">"
                                + "<input  name=\"date" + i1 + "\" id=\"datepicker" + i1 + "\" size=\"5\" type=\"text\" readonly class=\"form-control\" onchange=\"dateValidateFun(" + i1 + ");\"><span id=\"dateError" + i1 + "\" style=\"color: red;\"><span id=\"dateValidateError" + i1 + "\" style=\"color: red;display: none\">Select Date Between Start & End Date</span>"
                                + "</div></td>"
                                + "<td><input type=\"Text\" name=\"fromLocation" + i1 + "\" id=\"fromLocation" + i1 + "\" class=\"form-control\"><span id=\"fromLocationError" + i1 + "\" style=\"color: red;\"></span></td>"
                                + "<td><input type=\"Text\" name=\"toLocation" + i1 + "\" id=\"toLocation" + i1 + "\" class=\"form-control\"><span id=\"toLocationError" + i1 + "\" style=\"color: red;\"></span></td>"
                                + "<td><select class=\"form-control\" id=\"travelModeId" + i1 + "\" name=\"travelModeId" + i1 + "\" onchange=\"ajaxfun1(" + i1 + ");\">"
                                + "<option value=\"\"> --SELECT-- </option>"
                                + "<option value=\"Air\"> Air </option>"
                                + "<option value =\"Train\"> Train </option>"
                                + "<option value =\"Bus\"> Bus </option>"
                                + "<option value =\"Cab\"> Cab </option>"
                                + "<option value =\"AutoRickshaw\"> Auto Rickshaw </option>"
                                + "</select><span id=\"travelModeIdError" + i1 + "\" style=\"color: red;\"></span></td>"
                                + "<td style=\"text-align: center\" id=\"policy_deviated_id_" + i1 + "\"><b><input type=\"text\" id=\"deviateId" + i1 + "\" name=\"deviateId" + i1 + "\" value=\"\" class=\"form-control\" readonly=\"true\"></b></td>"
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

                        $("#datepicker" + i1 + "").datepicker({dateFormat: 'dd/mm/yy'});
                        var travelType = document.getElementById("TravelTypeSelectId").value;
                        if (travelType == 'International') {

                            $('#policy_deviated_id_' + i1).hide();
                            $("#travelModeId" + i1).children('option').hide();
                            //                        $("#travelModeId" + i).children("option[value^=Air]").show();

                            document.getElementById("travelModeId" + i1).options[1].selected = "true";
                        }

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
                                + "<th style=\"text-align: center\"> Sr No. </th>"
                                + "<th style=\"text-align: center\"> Hotel Booking Required <span style=\"color: red;font-size: 12px;\">*</span></th>"
                                + "<th style=\"text-align: center\"> Locations <span style=\"color: red;font-size: 12px;\">*</span></th>"

                                //                            + "<th> Pick Up </th>"
                                + "<th style=\"text-align: center\"> Preferred Hotels <span style=\"color: red;font-size: 12px;\">*</span></th>"
                                + "<th></th>"
                                + "</tr>"
                                + "<tr id='table_2_rowNo2_" + i2 + "'>"
                                + "<td style=\"text-align: center\"> " + i2 + " </td>"
                                + "<td><select class =\"form-control\" id=\"hotelBookingRequired" + i2 + "\" name=\"hotelBookingRequired" + i2 + "\" onchange=\"bookingRequiredFun1(" + i2 + ");\">"
                                + "<option value =\"\"> --SELECT-- </option>"
                                + "<option value =\"Yes\"> Yes </option>"
                                + "<option value =\"No\"> No </option>"
                                + "</select><span id=\"hotelBookingRequiredError" + i2 + "\" style=\"color: red;\"></span></td>"
                                + "<td> <input type =\"Text\" name=\"location" + i2 + "\" id=\"location" + i2 + "\" class =\"form-control\"><span id=\"locationError" + i2 + "\" style=\"color: red;\"></span>  </td>"

                                //                            + "<td><input type =\"checkbox\" onclick=\"pickUpCheckBox(" + i2 + ")\" id =\"pickUpCheckBoxId" + i2 + "\" name =\"pickUpCheckBoxId" + i2 + "\" style =\"width: 20px\"><select id =\"pickUpId" + i2 + "\" name =\"pickUpId" + i2 + "\" class =\"form-control\" style =\"width: 150px;margin-left: 24px;margin-top: -21px;display: none\">"
                                //                            + "<option value =\"\"> --SELECT-- </option>"
                                //                            + "<option value =\"Railwaystation\"> Railway Station </option>"
                                //                            + "<option value =\"Airport\" > Airport </option>"
                                //                            + "</select></td>"
                                + "<td><input type =\"Text\" name=\"preferredHotel" + i2 + "\" id=\"preferredHotel" + i2 + "\" class =\"form-control\"><span id=\"preferredHotelError" + i2 + "\" style=\"color: red;\"></span></td>"
                                + "<td><span style =\"margin-top: 5px;\" class =\"col-sm-1\">"
                                + "<input type=\"button\" value=\"-\" id=\"removeRowButtonId\" onclick=\"removeChild2('table_2_rowNo1_" + i2 + "','table_2_rowNo2_" + i2 + "','table_2_rowNo3_" + i2 + "','table_2_rowNo4_" + i2 + "');\">"
                                + "</span></td>"
                                + "</tr>"
                                + "<tr id='table_2_rowNo3_" + i2 + "'>"
                                + "<th></th>"

                                + "<th style=\"text-align: center\"> Check-In Date</th>"
                                + "<th style=\"text-align: center\"> Check-Out Date</th>"
                                //                            + "<th> Drop </th>"
                                + "<th style=\"text-align: center\"> Comments / Remarks Box </th>"
                                + "<th> </th>"
                                + "</tr>"
                                + "<tr id='table_2_rowNo4_" + i2 + "'>"
                                + "<td></td>"

                                + "<td style =\"width: 190px\">"
                                + "<input class =\"form-control date_datetime\" size =\"5\" type =\"text\" name=\"checkInDate" + i2 + "\" id=\"datepickerr" + i2 + "\" readonly style =\"\" onchange=\"checkInDateValidate(" + i2 + ");\">"
                                + "</div><span id=\"checkInDateError" + i2 + "\" style=\"color: red;\"></span><span id=\"checkInValidateError" + i2 + "\" style=\"color: red;display: none\">Select Date Between Start Date & End Date</span></td>"

                                + "<td style =\"width: 190px\">"
                                + "<input class =\"form-control date_datetime\" name=\"checkOutDate" + i2 + "\" id=\"datepickerrr" + i2 + "\" size =\"5\" type =\"text\" readonly  onchange=\"checkInDateValidate(" + i2 + ");\">"
                                + "</div><span id=\"checkOutDateError" + i2 + "\" style=\"color: red;\"></span><span id=\"checkOutValidateError" + i2 + "\" style=\"color: red;display: none\">Select Date Between Start Date & End Date</span></td >"
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
                        $("#datepickerr" + i2 + "").datepicker({dateFormat: 'dd/mm/yy'});
                        $("#datepickerrr" + i2 + "").datepicker({dateFormat: 'dd/mm/yy'});
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

                    //                alert('aaaa1111' + travelType);
                    if (travelType == 'International') {
                        document.getElementById("attendanceDetail_id").style.display = "block";
                        document.getElementById("travelDetail_Id").style.display = "block";
                        $('#policyDeviation_th_id').hide();
                        $('#policyDeviation_td_id').hide();

                        $("#travelModeId1").children('option').hide();
                        //                    $("#travelModeId1").children("option[value^=Air]").show();
                        document.getElementById("travelModeId1").options[1].selected = "true";

                        //                    document.getElementById("travelModeId1").disabled = true;
                        //                    document.getElementById("travelModeId1").value = 'Air';
                        for (i = 1; i <= countId; i++) {
                            $('#policy_deviated_id_' + i).hide();
                            $("#travelModeId" + i).children('option').hide();
                            //                        $("#travelModeId" + i).children("option[value^=Air]").show();

                            document.getElementById("travelModeId" + i).options[1].selected = "true";
                            //                        document.getElementById("travelModeId" + i).value = 'Air';
                        }
                    } else if (travelType == 'Domestic') {
                        document.getElementById("attendanceDetail_id").style.display = "block";
                        document.getElementById("travelDetail_Id").style.display = "block";
                        $('#policyDeviation_th_id').show();
                        //                    $('#policyDeviation_td_id').show();
                        $("#travelModeId1").children('option').show();
                        //                    document.getElementById("travelModeId1").disabled = false;
                        for (i = 1; i <= countId; i++) {
                            $('#policy_deviated_id_' + i).show();
                            $("#travelModeId" + i).children('option').show();
                            //                        document.getElementById("travelModeId" + i).disabled = false;
                        }

                    } else {
                        document.getElementById("attendanceDetail_id").style.display = "none";
                        document.getElementById("travelDetail_Id").style.display = "none";
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
                    var travelType = document.getElementById("TravelTypeSelectId").value;
                    //                alert('ajay' + selectedVal);


                    if (selectedVal == 'Air' && travelType == 'Domestic') {
                        $('#policy_deviated_id_' + id).show();
                        $('#deviateId' + id).show();
                    } else {
                        //                    $('#policy_deviated_id_' + id).hide();
                        $('#deviateId' + id).hide();
                    }

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
                });

                function bookingRequiredFun1(id) {
                    var booking = document.getElementById("hotelBookingRequired" + id).value;
                    //                alert(booking);
                    if (booking == 'No') {
                        $("#datepickerr" + id).datepicker("disable");
                        $("#datepickerrr" + id).datepicker("disable");
                        $("#location" + id).prop("disabled", true);
                        $("#preferredHotel" + id).prop("disabled", true);
                    } else {
                        $("#datepickerr" + id).datepicker("enable");
                        $("#datepickerrr" + id).datepicker("enable");
                        $("#location" + id).prop("disabled", false);
                        $("#preferredHotel" + id).prop("disabled", false);

                    }

                }



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
            <!--        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
                    <link rel="stylesheet" href="/resources/demos/style.css">-->
            <script>
                $(function () {
                    $("#datepickerr1").datepicker({dateFormat: 'dd/mm/yy'});
                });

                $(function () {
                    $("#datepicker1").datepicker({dateFormat: 'dd/mm/yy'});
                });
                $(function () {
                    $("#datepickerrr1").datepicker({dateFormat: 'dd/mm/yy'});
                });



                function saveSubmit11() {
                    var flag3 = true;
                    var countDetailId = document.getElementById("countDetailId").value;
                    var countId = document.getElementById("countId").value;
                    //                alert(countId);
                    var btnName = document.getElementById("btnSubmit").value;
                    //                alert(btnName);
                    //                alert(countDetailId);
                    if (btnName === 'submit') {


                        for (var i = 1; i <= countDetailId; i++) {

                            var hotelBookingRequired = document.getElementById("hotelBookingRequired" + i).value;
                            //                        alert(hotelBookingRequired + "aaaa" + i);
                            if (hotelBookingRequired === '') {
                                document.getElementById("hotelBookingRequiredError" + i).innerHTML = "- It must not be empty or whitespace";
                                flag3 = false;
                                //                        return  false;
                            }
                            else if (hotelBookingRequired === 'Yes') {
                                document.getElementById("hotelBookingRequiredError" + i).innerHTML = "";
                                var checkInDate = document.getElementById("datepickerr" + i).value;
                                var checkOutDate = document.getElementById("datepickerrr" + i).value;
                                //                        alert(checkOutDate + "ddd");
                                if (checkInDate === '') {
                                    document.getElementById("checkInDateError" + i).innerHTML = "- It must not be empty or whitespace";
                                    flag3 = false;
                                    //                            return false;
                                } else {
                                    document.getElementById("checkInDateError" + i).innerHTML = "";
                                }
                                if (checkOutDate === '') {
                                    document.getElementById("checkOutDateError" + i).innerHTML = "- It must not be empty or whitespace";
                                    flag3 = false;
                                    //                            return false;
                                } else {
                                    document.getElementById("checkOutDateError" + i).innerHTML = "";
                                }
                                if (document.getElementById("location" + i).value == '') {
                                    document.getElementById("locationError" + i).innerHTML = "- It must not be empty or whitespace";
                                    flag3 = false;
                                } else {
                                    document.getElementById("locationError" + i).innerHTML = "";

                                }
                                if (document.getElementById("preferredHotel" + i).value == '') {
                                    document.getElementById("preferredHotelError" + i).innerHTML = "- It must not be empty or whitespace";
                                    flag3 = false;
                                } else {
                                    document.getElementById("preferredHotelError" + i).innerHTML = "";
                                }


                            } else if (hotelBookingRequired === 'No') {
                                document.getElementById("checkInDateError" + i).innerHTML = "";
                                document.getElementById("checkOutDateError" + i).innerHTML = "";

                            }

                        }

                        for (var i = 1; i <= countId; i++) {
                            if (document.getElementById("datepicker" + i).value == '') {
                                document.getElementById("dateError" + i).innerHTML = "- It must not be empty or whitespace";
                                flag3 = false;
                            } else {
                                document.getElementById("dateError" + i).innerHTML = '';
                            }
                            if (document.getElementById("fromLocation" + i).value == '') {
                                document.getElementById("fromLocationError" + i).innerHTML = "- It must not be empty or whitespace";
                                flag3 = false;
                            } else {
                                document.getElementById("fromLocationError" + i).innerHTML = '';
                            }
                            if (document.getElementById("toLocation" + i).value == '') {
                                document.getElementById("toLocationError" + i).innerHTML = "- It must not be empty or whitespace";
                                flag3 = false;
                            } else {
                                document.getElementById("toLocationError" + i).innerHTML = '';
                            }
                            if (document.getElementById("travelModeId" + i).value == '') {
                                document.getElementById("travelModeIdError" + i).innerHTML = "- It must be selected";
                                flag3 = false;
                            } else {
                                document.getElementById("travelModeIdError" + i).innerHTML = '';
                            }

                        }

                        var cashRequiredId = document.getElementById("cashRequiredId").value;
                        if (cashRequiredId == '') {
                            document.getElementById("cashRequiredIdError").innerHTML = "- It must not be empty or whitespace";
                            flag3 = false;

                        } else if (cashRequiredId == 'Yes') {
                            if (document.getElementById("amount").value == '') {
                                document.getElementById("cashRequiredIdError").innerHTML = "";
                                document.getElementById("amountError").innerHTML = "- It must not be empty or whitespace";
                                flag3 = false;
                            } else {
                                document.getElementById("amountError").innerHTML = "";
                            }
                            if (document.getElementById("reasonForAdvance").value == '') {
                                document.getElementById("cashRequiredIdError").innerHTML = "";
                                document.getElementById("reasonForAdvanceError").innerHTML = "- It must not be empty or whitespace";
                                flag3 = false;
                            } else {
                                document.getElementById("reasonForAdvanceError").innerHTML = "";
                            }

                        } else if (cashRequiredId == 'No') {

                        }

                    }

                    if (flag3) {
                        flag3 = false;
                        document.getElementById('saveSubmit1').innerHTML = 'Saving ... .. .';
                        document.form1.submit();
                        return true;
                    } else {
                        return false;
                    }

                }

            </script>
            <script>
                function dateValidateFun(id) {
                    var countId = document.getElementById("countId").value;
                    var startDateTime = document.getElementById("startDateTime").value;
                    var endDateTime = document.getElementById("endDateTime").value;
                    startDateTime = startDateTime.split('-');
                    //                alert(startDateTime[0]);
                    var newStartDate = startDateTime[0].split("/");
                    newStartDate = new Date(newStartDate[2], newStartDate[1] - 1, newStartDate[0]);
                    endDateTime = endDateTime.split('-');
                    //                alert(endDateTime[0]);
                    var newEndDate = endDateTime[0].split("/");
                    newEndDate = new Date(newEndDate[2], newEndDate[1] - 1, newEndDate[0]);
                    //                for (var i = 1; i <= countId; i++) {
                    var datepicker = document.getElementById("datepicker" + id).value;
                    datepicker = datepicker.split('/');
                    datepicker = new Date(datepicker[2], datepicker[1] - 1, datepicker[0]);
                    //                    alert("datepicker" + datepicker);
                    if (datepicker < newStartDate || datepicker > newEndDate) {
                        //                        alert("Please Select Date Between S n E Date");
                        $('#dateValidateError' + id).show();
                        setTimeout(function () {
                            $("#dateValidateError" + id).fadeOut();
                        }, 1500);
                        setTimeout(function () {
                            document.getElementById("datepicker" + id).value = "";
                        }, 1500);


                    } else {
                        $('#dateValidateError' + id).hide();
                    }

                    //                }


                }

                function checkInDateValidate(id) {

                    var startDateTime = document.getElementById("startDateTime").value;
                    var endDateTime = document.getElementById("endDateTime").value;
                    startDateTime = startDateTime.split('-');
                    //                alert(startDateTime[0]);
                    var newStartDate = startDateTime[0].split("/");
                    newStartDate = new Date(newStartDate[2], newStartDate[1] - 1, newStartDate[0]);
                    endDateTime = endDateTime.split('-');
                    //                alert(endDateTime[0]);
                    var newEndDate = endDateTime[0].split("/");
                    newEndDate = new Date(newEndDate[2], newEndDate[1] - 1, newEndDate[0]);

                    var checkInDate = document.getElementById("datepickerr" + id).value;
                    //                alert("checkInDate" + checkInDate);
                    if (checkInDate !== '') {

                        checkInDate = checkInDate.split('/');
                        var newCheckInDate = new Date(checkInDate[2], checkInDate[1] - 1, checkInDate[0]);
                        //                alert("newCheckOutDate" + newCheckOutDate);
                        //                    alert("newCheckInDate" + newCheckInDate);
                        if (newCheckInDate < newStartDate || newCheckInDate > newEndDate) {
                            $("#checkInValidateError" + id).show();
                            setTimeout(function () {
                                $("#checkInValidateError" + id).fadeOut();
                            }, 1500);
                            setTimeout(function () {
                                document.getElementById("datepickerr" + id).value = "";
                            }, 1500);

                        }
                    }
                    var checkOutDate = document.getElementById("datepickerrr" + id).value;
                    if (checkOutDate !== '') {

                        checkOutDate = checkOutDate.split('/');
                        //                    alert("checkOutDate" + checkOutDate);

                        var newCheckOutDate = new Date(checkOutDate[2], checkOutDate[1] - 1, checkOutDate[0]);
                        if (newCheckOutDate < newStartDate || newCheckOutDate > newEndDate) {
                            $("#checkOutValidateError" + id).show();
                            setTimeout(function () {
                                $("#checkOutValidateError" + id).fadeOut();
                            }, 1500);
                            setTimeout(function () {
                                document.getElementById("datepickerrr" + id).value = "";
                            }, 1500);

                        }
                    }

                }
            </script>

        </head>
        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper">

        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <span class="logo-lg"><img src="StorageYard/Images/logo.png" style="width: 160px;float: left;"/></span>
                        <br>
                        <br>
                        <div class="tab-content">
                            <!--form horizontal starts here-->
                            <form:form action="travelRequestMaster.htm?act=editRequest" method="post" commandName="travelRequestMaster"
                                       name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
                                <form:hidden path="id"></form:hidden>
                                <form:hidden path="status"></form:hidden>
                                <form:hidden path="dateOfSubmit"></form:hidden>

                                    <div>
                                        <div class="box-header">
                                            <h3 class="box-title">Employee Detail:</h3>
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
                                <div class="">
                                    <div class="box-header">
                                        <h3 class="box-title">Travel Request and Type:</h3>
                                        <!--                                        <div class="box-tools pull-right">
                                                                                    <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2()"><i class="fa fa-plus" id="minusId2"></i></button>
                                                                                </div>-->
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
                                                        <label class="col-sm-3  control-label">Travel Type:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="col-sm-7">
                                                        <form:input path="travelType" onchange="cashRequired()" id="TravelTypeSelectId" class="form-control"></form:input>
                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <!--Travel request and type detail completes here-->
                                    <div id="attendanceDetail_id">
                                        <div class="box-header">
                                            <h3 class="box-title">Attendance Regularization Detail:</h3>
                                            <!--                                        <div class="box-tools pull-right">
                                                                                        <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun3()"><i class="fa fa-plus" id="minusId3"></i></button>
                                                                                    </div>-->
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <label class="col-sm-3  control-label">Start Date And Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class=" col-sm-7">
                                                            <!--<div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy - hh:ii " data-link-field="dtp_input1">-->
                                                        <form:input path="startDateTime" class="form-control" size="16" value="" readonly=""></form:input>
                                                            <!--<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>-->
                                                            <!--</div>-->
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-3  control-label">End Date And Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class=" col-sm-7">
                                                            <!--<div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy - hh:ii " data-link-field="dtp_input1">-->
                                                        <form:input path="endDateTime" class="form-control" size="16" value="" readonly=""></form:input>
                                                            <!--<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>-->
                                                            <!--</div>-->
                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <!--Attendance Regularization detail completes here-->
                                    <div id="travelDetail_Id">
                                        <div class="box-header" >
                                            <h3 class="box-title">Travel Detail:</h3>
                                            <!--                                            <div class="box-tools pull-right">
                                                                                            <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun4()"><i class="fa fa-plus" id="minusId4"></i></button>
                                                                                        </div>-->
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="table-responsive">
                                                        <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                            <tr>
                                                                <th style="text-align: center;width: 7%;">Sr No.</th>
                                                                <th style="text-align: center">Date<span style="color: red;font-size: 12px;">*</span></th>
                                                                <th style="text-align: center">From Location<span style="color: red;font-size: 12px;">*</span></th>
                                                                <th style="text-align: center">To Location<span style="color: red;font-size: 12px;">*</span></th>
                                                                <th style="text-align: center">Mode of Travel<span style="color: red;font-size: 12px;">*</span></th>
                                                                <th style="text-align: center;display: none" id="policyDeviation_th_id">Policy Deviation</th>
                                                                <th style="text-align: center">Comments / Remarks Box</th>
                                                                <!--<th style="text-align: center;width: 8%;">Add New</th>-->
                                                            </tr>
                                                            <input type="hidden" name="countId" id="countId" value="${fn:length(travelDetailList)}">
                                                        <c:forEach var="travelDetailList" items="${travelDetailList}" varStatus="status">
                                                            <tr>
                                                            <input type="hidden" name="travelDetailId_${status.count}" id="travelDetailId${status.count}" value="${travelDetailList.id}">
                                                            <td style="text-align: center">${status.count}</td>
                                                            <td style="width:95px">
                                                                <!--<div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy-hh:ii " data-link-field="dtp_input1">-->

                                                                <input class="form-control" name="date${status.count}"  id="datepicker${status.count}" size="5" type="text" readonly value="${travelDetailList.date}" onchange="dateValidateFun('${status.count}');">
                                                                <span id="dateError${status.count}" style="color: red;"></span>
                                                                <span id="dateValidateError${status.count}" style="color: red;display: none">Select Date Between Start Date & End Date</span>
                                                                <!--<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>-->
                                                                <!--</div>-->
                                                            </td>
                                                            <td><input type="Text" name="fromLocation${status.count}" id="fromLocation${status.count}" class="form-control" value="${travelDetailList.fromLocation}">
                                                                <span id="fromLocationError${status.count}" style="color: red;"></span>
                                                            </td>
                                                            <td><input type="Text" name="toLocation${status.count}" id="toLocation${status.count}" class="form-control" value="${travelDetailList.toLocation}">
                                                                <span id="toLocationError${status.count}" style="color: red;"></span></td>
                                                            <td><select class="form-control" id="travelModeId${status.count}" name="travelModeId${status.count}" onchange="ajaxfun1(${status.count});">
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
                                                                </select>
                                                                <span id="travelModeIdError${status.count}" style="color: red;"></span>
                                                            </td>
                                                            <td style="text-align: center;width: 102px; display: none" id="policy_deviated_id_${status.count}"><b><input type="text" id="deviateId${status.count}" name="deviateId${status.count}" value="${travelDetailList.policyDeviation}" class="form-control" readonly="true"></b></td>
                                                            <td><textarea class="form-control" name="comments${status.count}" id="comments${status.count}">${travelDetailList.comments}</textarea></td>
                                                                <c:if test="${status.last}">
                                                                <!--<td style="text-align: center">-->
                                                                <!--<span style='margin-top: 5px;' class="col-sm-1">-->
                                                                <!--<input type="button" value="+" id="addRowButtonId_table_1" />-->
                                                                <!--</span>-->
                                                                <!--</td>-->
                                                            </c:if>
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
                                                                <th style="text-align: center;width: 7%">Sr No.</th>
                                                                <th style="text-align: center">Hotel Booking Required<span style="color: red;font-size: 12px;">*</span></th>
                                                                <th style="text-align: center">Locations<span style="color: red;font-size: 12px;">*</span></th>

                                                                <!--<th style="text-align: center">Pick Up</th>-->
                                                                <th style="text-align: center">Preferred Hotels<span style="color: red;font-size: 12px;">*</span></th>
                                                                <!--<th style="text-align: center;width: 8%">Add New</th>-->
                                                            </tr>
                                                            <tr>
                                                            <input type="hidden" name="accommodationId_${status1.count}" id="accommodationId_${status1.count}" value="${accommodationList.id}">
                                                            <td style="text-align: center">${status1.count}</td>
                                                            <td><select class="form-control" id="hotelBookingRequired${status1.count}" name="hotelBookingRequired${status1.count}" onchange="bookingRequiredFun1(${status1.count});">
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
                                                                </select>
                                                                <span id="hotelBookingRequiredError${status1.count}" style="color: red;"></span>
                                                            </td>
                                                            <td><input type="Text" name="location${status1.count}" id="location${status1.count}" class="form-control" value="${accommodationList.location}">
                                                                <span id="locationError${status1.count}" style="color: red;"></span>
                                                            </td>


                                                            <!--<td>
                                                            <///c:choose><c/:when test="$/{accommodationList.pickUpCheck eq true}"><input type="checkbox" id="pickUpCheckBoxId_$/{status1.count}" name="pickUpCheckBoxId_$/{status1.count}" style="width: 20px" checked=""><//c:when><//c:otherwise><input type="checkbox" id="pickUpCheckBoxId_$/{status1.count}" name="pickUpCheckBoxId_$/{status1.count}" style="width: 20px"><//c:otherwise><//c:choose><select id="pickUpId$/{status1.count}" name="pickUpId$/{status1.count}" class="form-control " style="width: 150px;margin-left: 24px;margin-top: -21px;display: none">-->
                                                            <!--<option value="">--SELECT--</option>-->
                                                            <%--<c:choose>--%>
                                                            <%--<c:when test="${accommodationList.pickLocation eq 'Railwaystation'}">--%>
                                                            <!--<option value="Railwaystation" selected="">Railway Station</option>-->
                                                            <%--</c:when>--%>
                                                            <%--<c:otherwise>--%>
                                                            <!--<option value="Railwaystation">Railway Station</option>-->
                                                            <%--</c:otherwise>--%>
                                                            <%--</c:choose>--%>
                                                            <%--<c:choose>--%>
                                                            <%--<c:when test="${accommodationList.pickLocation eq 'Airport'}">--%>
                                                            <!--<option value="Airport" selected="">Airport</option>-->
                                                            <%--</c:when>--%>
                                                            <%--<c:otherwise>--%>
                                                            <!--<option value="Airport">Airport</option>-->
                                                            <%--</c:otherwise>--%>
                                                            <%--</c:choose>--%>

                                                            <!--</select></td>-->
                                                            <td><input type="Text" name="preferredHotel${status1.count}" id="preferredHotel${status1.count}" class="form-control" value="${accommodationList.preferredHotel}"><span id="preferredHotelError${status1.count}" style="color: red;"></span></td>

                                                            <c:if test="${status1.last}">

                                                                <!--<td style="text-align: center"><span style='margin-top: 5px;' class="col-sm-1">-->
                                                                <!--<input type="button" value="+" id="addRowButtonId_table_2" />-->
                                                                <!--</span></td>-->
                                                            </c:if>
                                                            </tr>
                                                            <tr>
                                                                <th style="text-align: center"></th>
                                                                <th style="text-align: center">Check-In Date</th>
                                                                <th style="text-align: center">Check-Out Date</th>
                                                                <!--<th style="text-align: center">Drop </th>-->
                                                                <th style="text-align: center">Comments / Remarks Box</th>
                                                                <!--<th style="text-align: center"></th>-->
                                                            </tr>
                                                            <tr>
                                                                <td style="text-align: center"></td>
                                                                <td style="width: 190px">
                                                                    <!--<div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy-hh:ii" data-link-field="dtp_input1">-->
                                                                    <input class="form-control" size="5" name="checkInDate${status1.count}" id="datepickerr${status1.count}" readonly type="text"  style="" onchange="checkInDateValidate('${status1.count}');"  value="${accommodationList.checkInDate}">
                                                                    <span id="checkInDateError${status1.count}" style="color: red;"></span>
                                                                    <span id="checkInValidateError${status1.count}" style="color: red;display: none">Select Date Between Start Date & End Date</span>
                                                                    <!--<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>-->
                                                                    <!--</div>-->
                                                                </td>
                                                                <td style="width: 190px">
                                                                    <!--<div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy-hh:ii " data-link-field="dtp_input1">-->
                                                                    <input class="form-control" size="5" type="text" name="checkOutDate${status1.count}" id="datepickerrr${status1.count}" readonly style="" onchange="checkInDateValidate('${status1.count}');" readonly value="${accommodationList.checkOutDate}">
                                                                    <span id="checkOutDateError${status1.count}" style="color: red;"></span>
                                                                    <span id="checkOutValidateError${status1.count}" style="color: red;display: none">Select Date Between Start Date & End Date</span>
                                                                    <!--<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>-->
                                                                    </div>
                                                                </td>
                                                                <!--                                                                <td style="width: 200px">
                                                                <%--<c:choose><c:when test="${accommodationList.dropCheck eq true}">--%>
                                                                        <input type="checkbox" id="dropCheckBoxId_$//{status1.count}" name="dropCheckBoxId_$/{status1.count}" checked="">
                                                                <%--</c:when><c:otherwise><input type="checkbox" id="dropCheckBoxId${status1.count}" name="dropCheckBoxId${status1.count}" ></c:otherwise></c:choose>--%>
                                                            <select id="dropId$//{status1.count}" name="dropId$/{status1.count}" class="form-control " style="width: 150px;margin-left: 24px;margin-top: -21px;display: none">
                                                                <option value="">--SELECT--</option>
                                                                <%--<c:choose>--%>
                                                                <%--<c:when test="${accommodationList.dropLocation eq 'Railwaystation'}">--%>
                                                                    <option value="Railwaystation" selected="">Railway Station</option>
                                                                <%--</c:when>--%>
                                                                <%--<c:otherwise>--%>
                                                                    <option value="Railwaystation">Railway Station</option>
                                                                <%--</c:otherwise>--%>
                                                                <%--</c:choose>--%>
                                                                <%--<c:choose>--%>
                                                                <%--<c:when test="${accommodationList.dropLocation eq 'Airport'}">--%>
                                                                    <option value="Airport" selected="">Airport</option>
                                                                <%--</c:when>--%>
                                                                <%--<c:otherwise>--%>
                                                                    <option value="Airport">Airport</option>
                                                                <%--</c:otherwise>--%>
                                                                <%--</c:choose>--%>
                                                            </select></td>-->
                                                                <td><textarea name="remark${status1.count}" id="remark${status1.count}" class="form-control">${accommodationList.comments}</textarea></td>
                                                                <!--<td>-->
                                                                <!--</td>-->
                                                            </tr>
                                                        </c:forEach>
                                                    </table>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row  2-->
                                    </div><!-- /.box-body -->
                                </div>
                                <!--Travel detail completes here-->
                                <div >
                                    <div class="box-header">
                                        <h3 class="box-title">Cash Advance Required:</h3>
                                        <!--                                        <div class="box-tools pull-right">
                                                                                    <span id="spanId5">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun5()"><i class="fa fa-plus" id="minusId5"></i></button>
                                                                                </div>-->
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-3" style="width: 17%">
                                                        <label>Cash Advance Required:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <select name="cashRequiredId" id="cashRequiredId" class="form-control" onchange="cashRequired()">
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
                                                        <span id="cashRequiredIdError" style="color: red;"></span>
                                                    </div>
                                                    <div id="cashRequiredYes" style="display:none">

                                                        <div class="col-sm-2">
                                                            <label>Amount:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <form:input path="amount" class="form-control"></form:input>
                                                                <span id="amountError" style="color: red;"></span>
                                                            </div>
                                                            <div class="col-sm-5">
                                                                <label>Reason Of Advance:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <form:textarea path="reasonForAdvance" class="form-control"></form:textarea>
                                                                <span id="reasonForAdvanceError" style="color: red;"></span>
                                                            </div>
                                                            <div class="col-sm-2">
                                                                <div id="cashRequiredYesCurrency">
                                                                    <label>Currency</label>
                                                                    <select class="form-control" name="interCurrency" id="interCurrency">
                                                                        <option value="">--SELECT--</option>
                                                                    <c:forEach var="currency" items="${currencyMap}">
                                                                        <c:if test="${travelRequestMaster.currency eq currency.key}">
                                                                            <option value="${currency.key}" selected="">${currency.value}</option>
                                                                        </c:if>
                                                                        <c:if test="${travelRequestMaster.currency ne currency.key}">
                                                                            <option value="${currency.key}" >${currency.value}</option>
                                                                        </c:if>
                                                                    </c:forEach>
                                                                </select>
                                                            </div>
                                                        </div>

                                                    </div>
                                                </div>




                                                <!--                                                <div id="cashRequiredYes" style="display:none">

                                                                                                    <div class="form-group">
                                                                                                        <label class="col-sm-3  control-label">Amount</label>
                                                                                                        <div class="col-sm-4">
                                                                                                            <input type="Text" class="form-control">
                                                                                                        </div>
                                                                                                    </div>
                                                                                                    <div class="form-group">
                                                                                                        <label class="col-sm-3  control-label">Reason Of Advance</label>
                                                                                                        <div class="col-sm-4">
                                                                                                            <input type="Text" class="form-control">
                                                                                                        </div>
                                                                                                    </div>
                                                                                                    <div class="form-group" id="cashRequiredYesCurrency">
                                                                                                        <label class="col-sm-3  control-label">Currency</label>
                                                                                                        <div class="col-sm-4">
                                                                                                            <select class="form-control">
                                                                                                                <option value="">--SELECT--</option>
                                                                                                                <option value="Euro">Euro</option>
                                                                                                                <option value="Dollar">Dollar</option>
                                                                                                                <option value="Rupees">Rupees</option>
                                                                                                                <option value="Yen">Yen</option>
                                                                                                                <option value="Pound">Pound</option>
                                                                                                            </select>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                </div>-->
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                                <!--cash advanced required completes here-->
                                <div>
                                    <div class="box-header">
                                        <h3 class="box-title">Travel Purpose:</h3>
                                        <!--                                        <div class="box-tools pull-right">
                                                                                    <span id="spanId6">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun6()"><i class="fa fa-plus" id="minusId6"></i></button>
                                                                                </div>-->
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">Reason for Request:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="col-sm-7">
                                                        <form:textarea path="purpose" class="form-control" rows="6"></form:textarea>
                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                <c:if test="${travelRequestMaster.status eq 1 }">
                                    <div>
                                        <div class="box-header">
                                            <h3 class="box-title">Rework remark:</h3>
                                            <!--                                            <div class="box-tools pull-right">
                                                                                            <span id="spanId8">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun8()"><i class="fa fa-plus" id="minusId8"></i></button>
                                                                                            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
                                                                                        </div>-->
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label">Rework remark:</label>
                                                        <div class="col-sm-7">
                                                            <form:textarea path="managerRemark" class="form-control" rows="6" readonly="true"></form:textarea>
                                                            </div>
                                                        </div>
                                                    </div><!-- /.col -->
                                                </div><!-- /.row -->
                                            </div><!-- /.box-body -->
                                        </div>
                                </c:if>
                                <c:if test="${travelRequestMaster.status eq 0 || travelRequestMaster.status eq 1 || travelRequestMaster.status eq 3}">
                                    <div>
                                        <div class="box-header">
                                            <h3 class="box-title">Withdraw Remark:</h3>
                                            <!--                                            <div class="box-tools pull-right">
                                                                                            <span id="spanId7">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun7()"><i class="fa fa-plus" id="minusId7"></i></button>
                                                                                            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
                                                                                        </div>-->
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label">remark:</label>
                                                        <div class="col-sm-7">
                                                            <form:textarea path="empRemark" class="form-control" rows="6"></form:textarea>
                                                            </div>
                                                        </div>
                                                    </div><!-- /.col -->
                                                </div><!-- /.row -->
                                            </div><!-- /.box-body -->
                                        </div>
                                </c:if>

                                <!--Travel Purpose In Detail completes Here-->




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

        $(document).ready(function () {
            cashRequired();


            $('input[type=checkbox]').attr('checked', function (event) {

                $('#pickUpId' + event).show(500);
                $('#dropId' + event).show(500);
            });
        });
        window.print();
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>