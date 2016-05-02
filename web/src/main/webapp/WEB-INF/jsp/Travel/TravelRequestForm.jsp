<%--
    Document   : travelManagementForm
    Created on : Oct 3, 2015, 4:18:42 PM
    Author     : Irfan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>

    <link rel="stylesheet" href="StorageYard/CSS/bootstrap-datetimepicker.css">
    <script type="text/javascript" src="StorageYard/JS/bootstrap-datetimepicker.js" charset="UTF-8"></script>
    <head>
        <title>Travel Management</title>

        <style>
            #tabs{ margin: 20px -20px; border: none; }
            #tabs, #ui-datepicker-div, .ui-datepicker{ font-size: 85%; }
            .clear{ clear: both; }

            /*.example-container{ background-color: #f4f4f4; border-bottom: solid 2px #777777; margin: 0 0 20px 40px; padding: 20px; }*/
            /*.example-container input{ border: solid 1px #aaa; padding: 4px; width: 175px; }*/
        </style>

        <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">


        <script>
            var i1 = 1;
            var i2 = 1;
            var i3 = 1;
            $(function () {
                $("#addRowButtonId_table_1").on("click", function () {
                    i1++;
                    var clone = "<tr id='table_1_rowNo_" + i1 + "'>"
                            + "<td style=\"text-align: center\">" + i1 + "</td>"
                            + "<td style=\"width:95px\">"
//                            + "<div class=\"input-group date form_datetime\" id=\"ajay\" data-date-format=\"dd/mm/yyyy - hh:ii\" data-link-field=\"dtp_input1\">"
                            + "<input class=\"form-control\" name=\"date" + i1 + "\" id=\"datepicker" + i1 + "\" size=\"5\" type=\"text\" onchange=\"dateValidateFun(" + i1 + ");\">"
                            + "<span id=\"dateError" + i1 + "\" style=\"color: red;\"></span> <span id=\"dateValidateError" + i1 + "\" style=\"color: red;display: none\">Select Date Between Start & End Date</span>"
                            + "</td>"
                            + "<td style=\"text-align: center\"><input type=\"Text\" name=\"fromLocation" + i1 + "\" id=\"fromLocation" + i1 + "\" class=\"form-control\"><span id=\"fromLocationError" + i1 + "\" style=\"color: red;\"></span></td>"
                            + "<td style=\"text-align: center\"><input type=\"Text\" name=\"toLocation" + i1 + "\" id=\"toLocation" + i1 + "\" class=\"form-control\"><span id=\"toLocationError" + i1 + "\" style=\"color: red;\"></span></td>"
                            + "<td style=\"text-align: center\"><select class=\"form-control\" id=\"travelModeId" + i1 + "\" name=\"travelModeId" + i1 + "\" onchange=\"ajaxfun1(" + i1 + ");\">"
                            + "<option value=\"\"> --SELECT-- </option>"
                            + "<option value=\"Air\"> Air </option>"
                            + "<option value =\"Train\"> Train </option>"
                            + "<option value =\"Bus\"> Bus </option>"
                            + "<option value =\"Cab\"> Cab </option>"
                            + "<option value =\"AutoRickshaw\"> Auto Rickshaw </option>"
                            + "</select><span id=\"travelModeIdError" + i1 + "\" style=\"color: red;\"></span></td>"
                            + "<td style=\"text-align: center;\" id=\"policy_deviated_id_" + i1 + "\"><b><input type=\"text\" id=\"deviateId" + i1 + "\" name=\"deviateId" + i1 + "\" value=\"\" class=\"form-control\" readonly=\"true\"></b></td>"
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
                        $('#policyDeviation_th_id').hide();
                        $('#policyDeviation_td_id').hide();

                        $("#travelModeId1").children('option').show();
//                        $("#travelModeId1").children("option[value^=Air]").show();
//                        document.getElementById("travelModeId1").options[1].selected = "true";

//                    document.getElementById("travelModeId1").disabled = true;
//                    document.getElementById("travelModeId1").value = 'Air';
//                    for (i = 2; i <= countId; i++) {
                        $('#policy_deviated_id_' + i1).hide()
                        $("#travelModeId" + i1).children('option').show();
//                        $("#travelModeId" + i).children("option[value^=Air]").show();

//                        document.getElementById("travelModeId" + i1).options[1].selected = "true";
//                        document.getElementById("travelModeId" + i).value = 'Air';
                    }

                });

                $("#addRowButtonId_table_2").on("click", function () {
                    i2++;

                    var clone = "<tr id='table_2_rowNo1_" + i2 + "'>"
                            + "<th style=\"text-align: center\"> Sr No. </th>"
                            + "<th style=\"text-align: center\"> Hotel Booking Required<span style=\"color: red;font-size: 12px;\" >*</span></th>"
                            + "<th style=\"text-align: center\"> Locations<span style=\"color: red;font-size: 12px;\" id=\"locationStarId" + i2 + "\">*</span></th>"
//                            + "<th style=\"text-align: center\"> Check - in (Date & Time)</th>"
//                            + "<th> Pick Up </th>"
                            + "<th style=\"text-align: center\"> Preferred Hotels<span style=\"color: red;font-size: 12px;\" id=\"preferredStarId" + i2 + "\">*</span></th>"
                            + "<th></th>"
                            + "</tr>"
                            + "<tr id='table_2_rowNo2_" + i2 + "'>"
                            + "<td style=\"text-align: center\"> " + i2 + " </td>"
                            + "<td><select class =\"form-control\" id=\"hotelBookingRequired" + i2 + "\" name=\"hotelBookingRequired" + i2 + "\" onchange=\"bookingRequiredFun1(" + i2 + ");\">"
                            + "<option value =\"\"> --SELECT-- </option>"
                            + "<option value =\"Yes\"> Yes </option>"
                            + "<option value =\"No\"> No </option>"
                            + "</select><span id=\"hotelBookingRequiredError" + i2 + "\" style=\"color: red;\"></span></td>"
                            + "<td style=\"text-align: center\"> <input type =\"text\" name=\"location" + i2 + "\" id=\"location" + i2 + "\" class =\"form-control\"><span id=\"locationError" + i2 + "\" style=\"color: red;\"></span> </td>"
                            + "<td><input type =\"text\" name='preferredHotel" + i2 + "' id='preferredHotel" + i2 + "' class =\"form-control\" /><span id=\"preferredHotelError" + i2 + "\" style=\"color: red;\"></span></td>"

//                            + "<td><input type =\"checkbox\" onclick=\"pickUpCheckBox(" + i2 + ")\" id =\"pickUpCheckBoxId" + i2 + "\" name =\"pickUpCheckBoxId" + i2 + "\" style =\"width: 20px\"><select id =\"pickUpId" + i2 + "\" name =\"pickUpId" + i2 + "\" class =\"form-control\" style =\"width: 150px;margin-left: 24px;margin-top: -21px;display: none\">"
//                            + "<option value =\"\"> --SELECT-- </option>"
//                            + "<option value =\"Railwaystation\"> Railway Station </option>"
//                            + "<option value =\"Airport\" > Airport </option>"
//                            + "</select></td>"

                            + "<td><span style =\"margin-top: 5px;\" class =\"col-sm-1\">"
                            + "<input type=\"button\" value=\"-\" id=\"removeRowButtonId\" onclick=\"removeChild2('table_2_rowNo1_" + i2 + "','table_2_rowNo2_" + i2 + "','table_2_rowNo3_" + i2 + "','table_2_rowNo4_" + i2 + "');\">"
                            + "</span></td>"
                            + "</tr>"
                            + "<tr id='table_2_rowNo3_" + i2 + "'>"
                            + "<th></th>"

                            + "<th style=\"text-align: center\">Check-In Date<span style=\"color: red;font-size: 12px;\" id=\"checkIn_idStar" + i2 + "\">*</span></th>"
                            + "<th>Check-Out Date<span style=\"color: red;font-size: 12px;\" id=\"checkOut_idStar" + i2 + "\">*</span> </th>"
//                            + "<th> Drop </th>"
                            + "<th style=\"text-align: center\"> Comments / Remarks Box </th>"
                            + "<th> </th>"
                            + "</tr>"
                            + "<tr id='table_2_rowNo4_" + i2 + "'>"
                            + "<td></td>"
                            + "<td style =\"width: 190px\">"
//            <div class =\"input-group date form_datetime\" data - date - format =\"dd/mm/yyyy - hh:ii\" data - link - field =\"dtp_input1\">"
                            + "<input class =\"form-control date_datetime\" size =\"5\" type =\"text\" name=\"checkInDate" + i2 + "\" id=\"datepickerr" + i2 + "\"  style =\"\" onchange=\"checkInDateValidate(" + i2 + ");\">"
                            + "<span id=\"checkInDateError" + i2 + "\" style=\"color: red;\"></span>"
                            + " <span id=\"checkInValidateError" + i2 + "\" style=\"color: red;display: none\">Select Date Between Start Date & End Date</span>"
//                            + "</div>\n\
                            + "</td>"

                            + "<td style =\"width: 190px\">"
//            <div class =\"input-group date form_datetime\" data-date-format =\"dd/mm/yyyy - hh:ii\" data-link-field =\"dtp_input1\">"
                            + "<input class =\"form-control date_datetime\" name=\"checkOutDate" + i2 + "\" id=\"datepickerrr" + i2 + "\" size =\"5\" type =\"text\" onchange=\"checkInDateValidate(" + i2 + ");\">"
                            + "<span id=\"checkOutDateError" + i2 + "\" style=\"color: red;\"></span>"
                            + "<span id=\"checkOutValidateError" + i2 + "\" style=\"color: red;display: none\">Select Date Between Start Date & End Date</span>"
                            + "</td>"
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

                });
                //            checkbox of travel detail

                $('#pickUpCheckBoxId1').on('ifChecked', function (event) {
                    $('#pickUpId1').show(500);
                });
                $('#pickUpCheckBoxId1').on('ifUnchecked', function (event) {
                    $('#pickUpId1').hide(500);
                });
                $('#dropCheckBoxId1').on('ifChecked', function (event) {
                    $('#dropId1').show(500);
                });
                $('#dropCheckBoxId1').on('ifUnchecked', function (event) {
                    $('#dropId1').hide(500);
                });
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
                var travelType = document.getElementById("TravelTypeSelectId").value;
                var countId = document.getElementById("countId").value;

                if (travelType == 'International') {
                    document.getElementById("attendanceDetail_id").style.display = "block";
                    document.getElementById("travelDetail_Id").style.display = "block";
                    $('#policyDeviation_th_id').hide();
                    $('#policyDeviation_td_id').hide();

                    $("#travelModeId1").children('option').show();
//                    $("#travelModeId1").children("option[value^=Air]").show();
//                    document.getElementById("travelModeId1").options[1].selected = "true";

//                    document.getElementById("travelModeId1").disabled = true;
//                    document.getElementById("travelModeId1").value = 'Air';
                    for (i = 2; i <= countId; i++) {
                        $('#policy_deviated_id_' + i).hide();
                        $("#travelModeId" + i).children('option').show();
//                        $("#travelModeId" + i).children("option[value^=Air]").show();

//                        document.getElementById("travelModeId" + i).options[1].selected = "true";
//                        document.getElementById("travelModeId" + i).value = 'Air';
                    }
                } else if (travelType == 'Domestic') {
                    document.getElementById("attendanceDetail_id").style.display = "block";
                    document.getElementById("travelDetail_Id").style.display = "block";
                    $('#policyDeviation_th_id').show();
                    $('#policyDeviation_td_id').show();
                    $("#travelModeId1").children('option').show();
//                    document.getElementById("travelModeId1").disabled = false;
                    for (i = 2; i <= countId; i++) {
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

                document.getElementById("countId").value = i1;
                // Removes an element from the document
                var element1 = document.getElementById(removeRowId1);
                element1.parentNode.removeChild(element1);

            }
            function removeChild2(removeRowId1, removeRowId2, removeRowId3, removeRowId4) {
                i2--;
                document.getElementById("countDetailId").value = i2;
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
                var policy_deviated = document.getElementById("policy_deviated_id_" + id).value;
                var empAjaxId = document.getElementById("empAjaxId").value;
                var levelId = document.getElementById("levelId").value;
                var travelType = document.getElementById("TravelTypeSelectId").value;

                if (selectedVal == 'Air' && travelType == 'Domestic') {
                    $('#policy_deviated_id_' + id).show();
                    $('#deviateId' + id).show();
                } else {
//                    $('#policy_deviated_id_' + id).hide();
                    $('#deviateId' + id).hide();
                }
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
                var travelType = document.getElementById("TravelTypeSelectId").value;
//                alert('ajay' + selectedVal);
                if (selectedVal == 'Air' && travelType == 'Domestic') {
                    $('#policyDeviation_th_id').show();
//                    $('#policyDeviation_td_id').show();
                    $('#deviateId1').show();
                } else {
//                    $('#policyDeviation_th_id').hide();
//                    $('#policyDeviation_td_id').hide();
                    $('#deviateId1').hide();
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
                bookingRequiredFun();

            });



            function bookingRequiredFun1(id) {
                var booking = document.getElementById("hotelBookingRequired" + id).value;
                if (booking == 'No') {
                    $("#datepickerr" + id).datepicker("disable");
                    $("#datepickerrr" + id).datepicker("disable");
//                    $("#location" + id).prop("disabled", true);
                    $("#preferredHotel" + id).prop("disabled", true);
//                    alert("#preferredHotel" + id);
//                    document.getElementById("preferredHotel" + id).readOnly = true;
//                    alert(id + "11111");
                    document.getElementById("datepickerr" + id).value = "";
                    document.getElementById("datepickerrr" + id).value = "";
                    document.getElementById("location" + id).value = "";
                    document.getElementById("preferredHotel" + id).value = "";
                    document.getElementById("preferredStarId" + id).innerHTML = "";
                    document.getElementById("locationStarId" + id).innerHTML = "";
                    document.getElementById("checkIn_idStar" + id).innerHTML = "";
                    document.getElementById("checkOut_idStar" + id).innerHTML = "";
                } else {
                    $("#datepickerr" + id).datepicker("enable");
                    $("#datepickerrr" + id).datepicker("enable");
//                    $("#location" + id).prop("disabled", false);
                    $("#preferredHotel" + id).prop("disabled", false);
                    document.getElementById("preferredStarId" + id).innerHTML = "*";
                    document.getElementById("locationStarId" + id).innerHTML = "*";
                    document.getElementById("checkIn_idStar" + id).innerHTML = "*";
                    document.getElementById("checkOut_idStar" + id).innerHTML = "*";

                }

            }
            function bookingRequiredFun() {
                var booking = document.getElementById("hotelBookingRequired1").value;
                //                alert(booking);
                if (booking === 'No' || booking === '') {
                    $("#datepickerr1").datepicker("disable");
                    $("#datepickerrr1").datepicker("disable");
//                    $("#location1").prop("disabled", true);
                    $("#preferredHotel1").prop("disabled", true);
                    document.getElementById("datepickerr1").value = "";
                    document.getElementById("datepickerrr1").value = "";
                    document.getElementById("location1").value = "";
                    document.getElementById("preferredHotel1").value = "";
                    document.getElementById("preferredStarId").innerHTML = "";
                    document.getElementById("locationStarId").innerHTML = "";
                    document.getElementById("checkIn_idStar").innerHTML = "";
                    document.getElementById("checkOut_idStar").innerHTML = "";
//                    document.getElementById("locationStarId").innerHTML = "*";
                } else {
                    $("#datepickerr1").datepicker("enable");
                    $("#datepickerrr1").datepicker("enable");
//                    $("#location1").prop("disabled", false);
                    $("#preferredHotel1").prop("disabled", false);
                    document.getElementById("preferredStarId").innerHTML = "*";
                    document.getElementById("locationStarId").innerHTML = "*";
                    document.getElementById("checkIn_idStar").innerHTML = "*";
                    document.getElementById("checkOut_idStar").innerHTML = "*";

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
            }</script>

        <!--        <script>/*
                 window.onerror = function(errorMsg) {
                 $('#console').html($('#console').html()+'<br>'+errorMsg)
                 }*/

                    $.datetimepicker.setLocale('en');

                    $('#datetimepicker_format').datetimepicker({value: '2015/04/15 05:03', format: $("#datetimepicker_format_value").val()});
                    $("#datetimepicker_format_change").on("click", function (e) {
                        $("#datetimepicker_format").data('xdsoft_datetimepicker').setOptions({format: $("#datetimepicker_format_value").val()});
                    });
                    $("#datetimepicker_format_locale").on("change", function (e) {
                        $.datetimepicker.setLocale($(e.currentTarget).val());
                    });

                    $('#datetimepicker').datetimepicker({
                        dayOfWeekStart: 1,
                        lang: 'en',
                        disabledDates: ['1986/01/08', '1986/01/09', '1986/01/10'],
                        startDate: '1986/01/05'
                    });
                    $('#datetimepicker').datetimepicker({value: '2015/04/15 05:03', step: 10});



                </script>-->
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
                var travelType = document.getElementById("TravelTypeSelectId").value;
                if (travelType != 'Local') {


                    for (var i = 1; i <= countDetailId; i++) {

                        var hotelBookingRequired = document.getElementById("hotelBookingRequired" + i).value;
                        //                    alert(hotelBookingRequired + "aaaa" + i);
                        if (hotelBookingRequired === '') {
                            document.getElementById("checkInDateError" + i).innerHTML = "";
                            document.getElementById("checkOutDateError" + i).innerHTML = "";
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
                            document.getElementById("preferredHotelError" + i).innerHTML = "";
//                        document.getElementById("locationError" + i).innerHTML = "";
//                            if (document.getElementById("location" + i).value == '') {
//                                document.getElementById("locationError" + i).innerHTML = "- It must not be empty or whitespace";
//                                flag3 = false;
//                            } else {
//                                document.getElementById("locationError" + i).innerHTML = "";
//
//                            }

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
                    if (document.getElementById("startDateTime").value == '') {
                        document.getElementById("startDateTimeError").innerHTML = "- It must not be empty or whitespace";
                        flag3 = false;
                    } else {
                        document.getElementById("startDateTimeError").innerHTML = "";

                    }
                    if (document.getElementById("endDateTime").value == '') {
                        document.getElementById("endDateTimeError").innerHTML = "- It must not be empty or whitespace";
                        flag3 = false;
                    } else {
                        document.getElementById("endDateTimeError").innerHTML = "";
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
                    document.getElementById("cashRequiredIdError").innerHTML = "";

                }
                if (document.getElementById("purpose").value == '') {
                    document.getElementById("purposeError").innerHTML = "- It must not be empty or whitespace";
                    flag3 = false;
                } else {
                    document.getElementById("purposeError").innerHTML = "";
                }

                if (document.getElementById("TravelTypeSelectId").value == '') {
                    document.getElementById("travelTypeError").innerHTML = "- It must not be empty or whitespace";
                    flag3 = false;
                } else {
                    document.getElementById("travelTypeError").innerHTML = "";
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

            function  bothdateValidateFun() {
                var leaveStartDate = document.getElementById("startDateTime").value;
                var leaveEndDate = document.getElementById("endDateTime").value;
                if (leaveStartDate != '' && leaveEndDate != '') {
                    leaveStartDate = leaveStartDate.split('-');
                    var sDate = leaveStartDate[0];
                    leaveStartDate = sDate.split('/');
                    leaveEndDate = leaveEndDate.split('-');
                    var eDate = leaveEndDate[0];
                    leaveEndDate = eDate.split('/');
                    leaveStartDate = new Date(leaveStartDate[2], leaveStartDate[1], leaveStartDate[0]);
                    leaveEndDate = new Date(leaveEndDate[2], leaveEndDate[1], leaveEndDate[0]);
                    var leaveDays = ((leaveEndDate - leaveStartDate) / (1000 * 60 * 60 * 24)) + 1;
                    if (leaveDays <= 0) {
                        alert('please select Start Date After End Date.');
                        document.getElementById("startDateTime").value = "";
                        document.getElementById("endDateTime").value = "";
                    }
                }
            }
        </script>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Travel Management Form :</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Travel Request</li>
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
                            <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                            <!--form horizontal starts here-->
                            <form:form action="travelRequestMaster.htm?act=applySubmit" method="post" commandName="travelRequestMaster"
                                       name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">

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
                                            <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2()"><i class="fa fa-plus" id="minusId2"></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <label class="col-sm-3   control-label">Travel Request Application No.:</label>

                                                    <div class="col-sm-7">
                                                        <form:input path="travelRequestNo" class="form-control" value="${requestNo}" readonly="true"></form:input>
                                                        <form:errors path="travelRequestNo" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-3  control-label">Travel Type:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="col-sm-7">
                                                        <form:select path="travelType" onchange="cashRequired()" id="TravelTypeSelectId" class="form-control">
                                                            <form:option value="" label="--SELECT--"></form:option>
                                                            <form:option value="Domestic" label="Domestic"></form:option>
                                                            <form:option value="International" label="International"></form:option>
                                                            <form:option value="Local" label="Local"></form:option>
                                                        </form:select>
                                                        <%--<form:errors path="travelType" cssClass="errorDiv"></form:errors>--%>
                                                        <span id="travelTypeError" style="color: red;"></span>
                                                    </div>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                                <!--Travel request and type detail completes here-->
                                <div class="box box-info collapsed-box" id="attendanceDetail_id">
                                    <div class="box-header">
                                        <h3 class="box-title">Attendance Regularization Detail:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun3()"><i class="fa fa-plus" id="minusId3"></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <label class="col-sm-3  control-label">Start Date And Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class=" col-sm-7">
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy - hh:ii " data-link-field="dtp_input1">
                                                            <form:input path="startDateTime" class="form-control" size="16" value="" readonly="" onchange="bothdateValidateFun();"></form:input>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        <%--<form:errors path="startDateTime" cssClass="errorDiv"></form:errors>--%>
                                                        <span id="startDateTimeError" style="color: red;"></span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3  control-label">End Date And Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class=" col-sm-7">
                                                        <div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy - hh:ii " data-link-field="dtp_input1">
                                                            <form:input path="endDateTime" class="form-control" size="16" value="" readonly="" onchange="bothdateValidateFun();"></form:input>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        <%--<form:errors path="endDateTime" cssClass="errorDiv"></form:errors>--%>
                                                        <span id="endDateTimeError" style="color: red;"></span>
                                                    </div>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                                <!--Attendance Regularization detail completes here-->
                                <div class="box box-info collapsed-box" id="travelDetail_Id">
                                    <div class="box-header">
                                        <h3 class="box-title">Travel Detail:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun4()"><i class="fa fa-plus" id="minusId4"></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="table-responsive">
                                                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <tr>
                                                            <th style="text-align: center;width: 6%;">Sr No.</th>
                                                            <th style="text-align: center">Date <span style="color: red;font-size: 12px;">*</span></th>
                                                            <th style="text-align: center">From Location <span style="color: red;font-size: 12px;">*</span></th>
                                                            <th style="text-align: center">To  <span style="color: red;font-size: 12px;">*</span></th>
                                                            <th style="text-align: center">Mode of Travel <span style="color: red;font-size: 12px;">*</span></th>
                                                            <th style="text-align: center;" id="policyDeviation_th_id">Policy Deviation</th>
                                                            <th style="text-align: center">Comments / Remarks Box</th>
                                                            <th style="text-align: center;width: 8%;">Add New</th>
                                                        </tr>
                                                        <tr>
                                                        <input type="hidden" name="countId" id="countId" value="1">
                                                        <td style="text-align: center">1</td>
                                                        <td style="width:95px">
                                                            <!--<div class="input-group date form_datetime" data-date-format="dd/mm/yyyy-hh:ii " data-link-field="dtp_input1">-->
                                                            <input class="form-control" name="date1" id="datepicker1" type="text" onchange="dateValidateFun(1);">
                                                            <span id="dateError1" style="color: red;"></span>
                                                            <span id="dateValidateError1" style="color: red;display: none">Select Date Between Start Date & End Date</span>
                                                            <!--<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>-->
                                                            <!--</div>-->
                                                        </td>
                                                        <td><input type="Text" name="fromLocation1" id="fromLocation1" class="form-control">
                                                            <span id="fromLocationError1" style="color: red;"></span>
                                                        </td>
                                                        <td><input type="Text" name="toLocation1" id="toLocation1" class="form-control">
                                                            <span id="toLocationError1" style="color: red;"></span>
                                                        </td>
                                                        <td><select class="form-control" id="travelModeId1" name="travelModeId1" onchange="ajaxfun();">
                                                                <option value="">--SELECT--</option>
                                                                <option value="Air">Air</option>
                                                                <option value="Train">Train</option>
                                                                <option value="Bus">Bus</option>
                                                                <option value="Cab">Cab</option>
                                                                <option value="AutoRickshaw">Auto Rickshaw</option>
                                                            </select>
                                                            <span id="travelModeIdError1" style="color: red;"></span>
                                                        </td>
                                                        <td style="text-align: center;width: 102px;" id="policyDeviation_td_id"><b><input type="text" id="deviateId1" name="deviateId1" value="" class="form-control" readonly="true"></b></td>
                                                        <td><textarea class="form-control" name="comments1" id="comments1" style="width: 227px;"></textarea></td>
                                                        <td style="text-align: center">
                                                            <span style='margin-top: 5px;' class="col-sm-1">
                                                                <input type="button" value="+" id="addRowButtonId_table_1" />
                                                            </span>
                                                        </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row 1-->
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="table-responsive">
                                                    <table id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <tr>
                                                        <input type="hidden" name="countDetailId" id="countDetailId" value="1">
                                                        <th style="text-align: center;width: 6%;">Sr No.</th>
                                                        <th style="text-align: center">Hotel Booking Required<span style="color: red;font-size: 12px;">*</span></th>
                                                        <th style="text-align: center">Locations <span style="color: red;font-size: 12px;" id="locationStarId">*</span></th>
                                                        <th style="text-align: center">Preferred Hotels <span id="preferredStarId" style="color: red;font-size: 12px;">*</span></th>
                                                        <!--<th style="text-align: center">Pick Up</th>-->
                                                        <th style="width: 8%;">Add New</th>
                                                        </tr>
                                                        <tr>
                                                            <td style="text-align: center;">1</td>
                                                            <td>
                                                                <select class="form-control" id="hotelBookingRequired1" name="hotelBookingRequired1" onchange="bookingRequiredFun(1
                                                                                );">
                                                                    <option value="">--SELECT--</option>
                                                                    <option value="Yes">Yes</option>
                                                                    <option value="No">No</option>
                                                                </select>
                                                                <span id="hotelBookingRequiredError1" style="color: red;"></span>

                                                            </td>
                                                            <td><input type="Text" name="location1" id="location1" class="form-control">
                                                                <span id="locationError1" style="color: red;"></span>
                                                            </td>

                                                            <td >
                                                                <!--<div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy-hh:ii " data-link-field="dtp_input1">-->
                                                                <input type="Text" name="preferredHotel1" id="preferredHotel1" class="form-control">
                                                                <span id="preferredHotelError1" style="color: red;"></span>
                                                                <!--<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>-->
                                                                <!--</div>-->
                                                            </td>
                                                            <!--                                                                <td><input type="checkbox" id="pickUpCheckBoxId1" name="pickUpCheckBoxId1" style="width: 20px"><select id="pickUpId1" name="pickUpId1" class="form-control " style="width: 150px;margin-left: 24px;margin-top: -21px;display: none">
                                                                                                                                    <option value="">--SELECT--</option>
                                                                                                                                    <option value="Railwaystation">Railway Station</option>
                                                                                                                                    <option value="Airport">Airport</option>
                                                                                                                                </select></td>-->

                                                            <td style="width: 7%;"><span style='margin-top: 5px;' class="col-sm-1">
                                                                    <input type="button" value="+" id="addRowButtonId_table_2" />
                                                                </span></td>
                                                        </tr>
                                                        <tr>
                                                            <th style="text-align: center"></th>

                                                            <th style="text-align: center">Check-In Date<span style="color: red;font-size: 12px;" id="checkIn_idStar">*</span></th>
                                                            <th style="text-align: center">Check-Out Date<span style="color: red;font-size: 12px;" id="checkOut_idStar">*</span></th>
                                                            <!--<th style="text-align: center">Drop </th>-->
                                                            <th style="text-align: center">Comments / Remarks Box</th>
                                                            <th style="text-align: center"></th>
                                                        </tr>
                                                        <tr>
                                                            <td style="text-align: center"></td>
                                                            <td  style="width: 190px">
                                                                <!--<div class="example-container">-->
                                                                <!--<input type="text" name="basic_example_1" id="basic_example_1" value="" />-->
                                                                <input class="form-control" size="5" name="checkInDate1" id="datepickerr1" type="text" onchange="checkInDateValidate(1
                                                                                );">
                                                                <!--<script>-->
                                                                <!--$("#datepickerr1").datetimepicker();-->
                                                                <!--//                                                                        $('#basic_example_1').datetimepicker();-->
                                                                <!--</script>-->
                                                                <!--</div>-->
                                                                <span id="checkInDateError1" style="color: red;"></span>
                                                                <span id="checkInValidateError1" style="color: red;display: none">Select Date Between Start Date & End Date</span>
                                                            </td>
                                                            <td style="width: 190px">
                                                                <!--<div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy-hh:ii" data-link-field="dtp_input1">-->
                                                                <input class="form-control" size="5"  name="checkOutDate1" id="datepickerrr1" type="text" onchange="checkInDateValidate(1
                                                                                );">
                                                                <span id="checkOutDateError1" style="color: red;"></span>
                                                                <span id="checkOutValidateError1" style="color: red;display: none">Select Date Between Start Date & End Date</span>
                                                                <!--<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>-->
                                                                </div>
                                                            </td>
                                                            <!--                                                                <td style="width: 200px"><input type="checkbox" id="dropCheckBoxId1" name="dropCheckBoxId1"><select id="dropId1" name="dropId1" class="form-control " style="width: 150px;margin-left: 24px;margin-top: -21px;display: none">
                                                                                                                                    <option value="">--SELECT--</option>
                                                                                                                                    <option value="Railwaystation">Railway Station</option>
                                                                                                                                    <option value="Airport">Airport</option>
                                                                                                                                </select></td>-->
                                                            <td><textarea name="remark1" id="remark1" class="form-control"></textarea></td>
                                                            <td>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                    <!--<span id="checkInAndOutValidateError1" style="color: red;">Select Date Between Start Date & End Date</span>-->
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
                                            <span id="spanId5">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun5()"><i class="fa fa-plus" id="minusId5"></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-3" style="width: 17%">
                                                        <label>Cash Advance Required <span style="color: red;font-size: 12px;">*</span></label>
                                                        <select name="cashRequiredId" id="cashRequiredId" class="form-control" onchange="cashRequired()" style="text-align: center">
                                                            <option value="">--SELECT--</option>
                                                            <option value="Yes">Yes</option>
                                                            <option value="No">No</option>
                                                        </select>
                                                        <span id="cashRequiredIdError" style="color: red;"></span>
                                                    </div>
                                                    <div id="cashRequiredYes" style="display:none">

                                                        <div class="col-sm-2">
                                                            <label>Amount <span style="color: red;font-size: 12px;">*</span></label>
                                                            <form:input path="amount" class="form-control"  type="number" min="0"></form:input>
                                                                <span id="amountError" style="color: red;"></span>
                                                            </div>
                                                            <div class="col-sm-5">
                                                                <label>Reason Of Advance <span style="color: red;font-size: 12px;">*</span></label>
                                                            <form:textarea path="reasonForAdvance" class="form-control"></form:textarea>
                                                                <span id="reasonForAdvanceError" style="color: red;"></span>
                                                            </div>
                                                            <div class="col-sm-2">
                                                                <div id="cashRequiredYesCurrency">
                                                                    <label>Currency</label>
                                                                    <select  class="form-control" name="interCurrency" id="interCurrency">
                                                                        <option value="">--SELECT--</option>
                                                                    <c:forEach var="currency" items="${currencyMap}">
                                                                        <option value="${currency.key}">${currency.value}</option>
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
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Travel Purpose:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId6">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun6()"><i class="fa fa-plus" id="minusId6"></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">Reason for Request:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="col-sm-7">
                                                        <form:textarea path="purpose" class="form-control" rows="6"></form:textarea>
                                                        <form:errors path="purpose" cssClass="errorDiv"></form:errors>
                                                            <span id="purposeError" style="color: red;"></span>
                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <!--Travel Purpose In Detail completes Here-->
                                    <div class="form-group">
                                        <div class="col-sm-12" style="text-align: center">
                                            <button type="submit" class="btn btn-primary" data-original-title="" title="" style="width: 100px">SUBMIT</button>
                                            <!--<button type="button" class="btn btn-primary" data-original-title="" title="" style="width: 100px" onclick="window.history.back();">Back</button>-->
                                        </div>
                                        <!--                                        <div class="col-sm-4">
                                                                                    <button type="submit" class="btn btn-warning" data-original-title="" title="" style="width: 100px">Withdraw</button>
                                                                                </div>-->
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
            //language:  'fr',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            forceParse: 0,
            showMeridian: 1,
            startDate: new Date()
        });</script>

    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <%--<%@include file="/WEB-INF/jsp/Travel/DateTimePickerTravel.jsp"%>--%>

</html>
