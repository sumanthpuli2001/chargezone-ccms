<%--
    Document   : ExpenseReport
    Created on : Oct 5, 2015, 10:42:46 AM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Expense Report</title>
    </head>
    <script>

        function dropDown() {
            var selectedValue = document.getElementById("expenseType").value;

//            alert(selectedValue);
            if (selectedValue === "Travel") {
                $('#applicationDivId').show();
                $('#travel1').show();
                $('#demo').show();
                $('#demo2').show();
                $('#otherDivId').hide();
                $('#demo3').hide();
                $('.travelGEId').show();
                $('.RelocationGTEId').hide();
                $('#policyDivId').hide();
                $('#relocation1').hide();
                $('#policy11').hide();
                $('#demo9').hide();
                $('#demo7').hide();
                $('#travelAppDateDiv_id').show();
                $('#localTravelId').hide();
                var countSecond = document.getElementById("countSecond").value;
                 for (var i = 1; i <= countSecond; i++) {
                    travelOtherBox(i);
                }
            }
            else if (selectedValue === "Others") {
                $('#otherDivId').show();
                $('#demo').hide();
                $('#demo2').hide();
                $('#demo3').show();
                $('#applicationDivId').hide();
                $('.travelGEId').hide();
                $('.RelocationGTEId').hide();
                $('#policyDivId').hide();
                $('#relocation1').hide();
                $('#travel1').hide();
                $('#policy11').hide();
                $('#demo9').hide();
                $('#demo7').hide();
                $('#travelAppDateDiv_id').hide();
                $('#localTravelId').hide();

                var othersCount = document.getElementById("othersCount").value;
                for (var i = 1; i <= othersCount; i++) {
                    var element2 = document.getElementById("currencyOtherDiv" + i);
                    for (var i2 = 0; i2 < element2.options.length; i2++) {
                        var currencyVal = element2.options[i2].value;
//                            alert("currencyVal" + currencyVal);
                        var currencyText = element2.options[i2].text;
                        try {
                            currencyText = currencyText.split('(');
                            var currencyText11 = currencyText[1];
//                                alert("currencyText11" + currencyText11);
                            currencyText11 = currencyText11.split(')');
                            if (currencyText11[0] === 'INR') {
//                                    alert("currencyText" + currencyText11[0]);
                                $("#currencyOtherDiv" + i).children('option').hide();
                                document.getElementById("currencyOtherDiv" + i).options[i2].selected = "true";

                            }
                        } catch (e) {

                        }
                    }
                    document.getElementById("otherCurrency_td" + i).style.display = 'none';
                    document.getElementById("otherCurrency_th").style.display = 'none';
                }
            }
            else if (selectedValue === "Relocation") {
                $('#relocation1').show();
                $('#demo8').show();
                $('#demo9').show();
                $('#demo3').hide();
                $('#demo7').hide();
                $('#otherDivId').hide();
                $('#applicationDivId').hide();
                $('.travelGEId').hide();
                $('.RelocationGTEId').show();
                $('#policyDivId').hide();
                $('#travel1').hide();
                $('#policy11').hide();
                $('#travelAppDateDiv_id').hide();
                $('#localTravelId').hide();

                var countFirstRelo = document.getElementById("countFirstRelo").value;
                var countSecondRelo = document.getElementById("countSecondRelo").value;

//                    alert("countSecond" + countSecond);
                for (var i = 1; i <= countFirstRelo; i++) {
                    var element2 = document.getElementById("currencyTravelDivRelo" + i);
                    for (var i2 = 0; i2 < element2.options.length; i2++) {
                        var currencyVal = element2.options[i2].value;
//                            alert("currencyVal" + currencyVal);
                        var currencyText = element2.options[i2].text;
                        try {
                            currencyText = currencyText.split('(');
                            var currencyText11 = currencyText[1];
//                                alert("currencyText11" + currencyText11);
                            currencyText11 = currencyText11.split(')');
                            if (currencyText11[0] === 'INR') {
//                                    alert("currencyText" + currencyText11[0]);
                                $("#currencyTravelDivRelo" + i).children('option').hide();
                                document.getElementById("currencyTravelDivRelo" + i).options[i2].selected = "true";

                            }
                        } catch (e) {

                        }
                    }
                    document.getElementById("currencyTravelRelo_td" + i).style.display = 'none';
                    document.getElementById("currencyTravelRelo_th").style.display = 'none';
                    showOnlyOtherBox(i);
                }
                for (var i = 1; i <= countSecondRelo; i++) {
                    var element2 = document.getElementById("currencyRelocationDivRelo" + i);
                    for (var i2 = 0; i2 < element2.options.length; i2++) {
                        var currencyVal = element2.options[i2].value;
//                            alert("currencyVal" + currencyVal);
                        var currencyText = element2.options[i2].text;
                        try {
                            currencyText = currencyText.split('(');
                            var currencyText11 = currencyText[1];
//                                alert("currencyText11" + currencyText11);
                            currencyText11 = currencyText11.split(')');
                            if (currencyText11[0] === 'INR') {
//                                    alert("currencyText" + currencyText11[0]);
                                $("#currencyRelocationDivRelo" + i).children('option').hide();
                                document.getElementById("currencyRelocationDivRelo" + i).options[i2].selected = "true";

                            }
                        } catch (e) {

                        }
                    }
                    document.getElementById("currencyRelocationDiv_td" + i).style.display = 'none';
                    document.getElementById("currencyRelocationDiv_th").style.display = 'none';
                }



            }
            else if (selectedValue === "PolicyReimbursements") {
                $('#demo').hide();
                $('#demo7').show();
                $('#demo3').hide();
                $('#applicationDivId').hide();
                $('#otherDivId').hide();
                $('.travelGEId').hide();
                $('.RelocationGTEId').hide();
                $('#policyDivId').show();
                $('#relocation1').hide();
                $('#travel1').hide();
                $('#policy11').show();
                $('#demo9').hide();
                $('#travelAppDateDiv_id').hide();
                $('#localTravelId').show();

                var countSecondOther = document.getElementById("countSecondOther").value;
                for (var i = 1; i <= countSecondOther; i++) {
                    var element2 = document.getElementById("currencyRelocationDivPolicy" + i);
                    for (var i2 = 0; i2 < element2.options.length; i2++) {
                        var currencyVal = element2.options[i2].value;
//                            alert("currencyVal" + currencyVal);
                        var currencyText = element2.options[i2].text;
                        try {
                            currencyText = currencyText.split('(');
                            var currencyText11 = currencyText[1];
//                                alert("currencyText11" + currencyText11);
                            currencyText11 = currencyText11.split(')');
                            if (currencyText11[0] === 'INR') {
//                                    alert("currencyText" + currencyText11[0]);
                                $("#currencyRelocationDivPolicy" + i).children('option').hide();
                                document.getElementById("currencyRelocationDivPolicy" + i).options[i2].selected = "true";

                            }
                        } catch (e) {

                        }
                    }
                    document.getElementById("policyReimbCurrency_td" + i).style.display = 'none';
                    document.getElementById("policyReimbCurrency_th").style.display = 'none';
                    otherEnble(i);
//                    if()
                }



            } else {
                $('#demo').hide();
                $('#demo7').show();
                $('#demo3').hide();
                $('#applicationDivId').hide();
                $('#otherDivId').hide();
                $('.travelGEId').hide();
                $('.RelocationGTEId').hide();
                $('#policyDivId').hide();
                $('#relocation1').hide();
                $('#travel1').hide();
                $('#policy11').hide();
                $('#demo9').hide();
                $('#travelAppDateDiv_id').hide();
                $('#localTravelId').hide();

            }
            var val;
            changeAmount1(val);
            calculateAmount();
        }
    </script>
    <script>

        $(document).ready(function () {

            dropDown();
            var expenseType = document.getElementById('expenseType').value;
            if (expenseType == 'Travel') {
                var travelAppId = document.getElementById("travelNo").value;
//                alert(travelAppId);

//                alert("travelNo" + document.getElementById("travelNo").value);
                $.ajax({
                    type: "POST",
                    url: "travelRequestMaster.htm?act=getTravelDatesAjax",
                    data: {"travelNo": travelAppId},
                    dataType: "text",
                    success: function (responseTxt) {
                        var newText = responseTxt.split("~");
//                        document.getElementById("travelStartDate").value = newText[0];
//                        document.getElementById("travelEndDate").value = newText[1];
                        document.getElementById("travelType").value = newText[2];

                        var countFirst = document.getElementById("countFirst").value;
                        var countSecond = document.getElementById("countSecond").value;
//                        alert(newText[2]);
//                        var travelType = document.getElementById("travelType").value;
                        if (newText[2] == 'Domestic') {
                            for (var i = 1; i <= countFirst; i++) {
                                var element2 = document.getElementById("currencyTravelDivId" + i);
                                for (var i2 = 0; i2 < element2.options.length; i2++) {
                                    var currencyVal = element2.options[i2].value;
//                                alert("currencyVal" + currencyVal);
                                    var currencyText = element2.options[i2].text;
                                    try {
                                        currencyText = currencyText.split('(');
                                        var currencyText11 = currencyText[1];
//                                    alert("currencyText11" + currencyText11);
                                        currencyText11 = currencyText11.split(')');
                                        if (currencyText11[0] === 'INR') {
//                                        alert("currencyText" + currencyText11[0]);
                                            $("#currencyTravelDivId" + i).children('option').hide();
                                            document.getElementById("currencyTravelDivId" + i).options[i2].selected = "true";
                                            var id;
                                            changeAmount1(id);
                                        }
                                    } catch (e) {

                                    }
                                }
                            }

                            for (var i = 1; i <= countSecond; i++) {
                                var element2 = document.getElementById("currencyRelocationDivId" + i);
                                for (var i2 = 0; i2 < element2.options.length; i2++) {
                                    var currencyVal = element2.options[i2].value;
                                    var currencyText = element2.options[i2].text;
                                    try {
                                        currencyText = currencyText.split('(');
                                        var currencyText11 = currencyText[1];
//                                alert("currencyText11" + currencyText11);
                                        currencyText11 = currencyText11.split(')');
                                        if (currencyText11[0] === 'INR') {
//                                    alert("currencyText" + currencyText11[0]);
                                            $("#currencyRelocationDivId" + i).children('option').hide();
                                            document.getElementById("currencyRelocationDivId" + i).options[i2].selected = "true";

                                        }
                                    } catch (e) {

                                    }
                                }
//                                document.getElementById("otherCurrrency_th").style.display = 'none';
//                                document.getElementById("otherCurrrency_td_" + i).style.display = 'none';
                            }

                        } else {
                            $("#currencyTravelDivId" + i).children('option').show();
                            $("#currencyRelocationDivId" + i).children('option').show();
                        }
                    },
                    error: function () {
//                        alert('Error occured');
                    }
                });

            }
        });
//        $(function () {
//            var myInt = setInterval(function () {
//                clearInterval(myInt);
//            }, 1000);
//        });
    </script>
    <!--    <script>

            $(function () {
                $("#expenseType").on("change", function () {
                    var selectedValue = this.value;
                    if (selectedValue === "Travel") {
                        $('#applicationDivId').show();
                        $('#travel1').show();
                        $('#demo').show();
                        $('#demo2').show();
                        $('#otherDivId').hide();
                        $('#demo3').hide();
                        $('.travelGEId').show();
                        $('.RelocationGTEId').hide();
                        $('#policyDivId').hide();
                        $('#relocation1').hide();
                        $('#policy11').hide();
                        $('#demo9').hide();
                        $('#demo7').hide();
                    }
                    else if (selectedValue === "Others") {
                        $('#otherDivId').show();
                        $('#demo').hide();
                        $('#demo2').hide();
                        $('#demo3').show();
                        $('#applicationDivId').hide();
                        $('.travelGEId').hide();
                        $('.RelocationGTEId').hide();
                        $('#policyDivId').hide();
                        $('#relocation1').hide();
                        $('#travel1').hide();
                        $('#policy11').hide();
                        $('#demo9').hide();
                        $('#demo7').hide();
                    }
                    else if (selectedValue === "Relocation") {
                        $('#relocation1').show();
                        $('#demo8').show();
                        $('#demo9').show();
                        $('#demo3').hide();
                        $('#demo7').hide();
                        $('#otherDivId').hide();
                        $('#applicationDivId').hide();
                        $('.travelGEId').hide();
                        $('.RelocationGTEId').show();
                        $('#policyDivId').hide();
                        $('#travel1').hide();
                        $('#policy11').hide();
                    }
                    else {
                        $('#demo').hide();
                        $('#demo7').show();
                        $('#demo3').hide();
                        $('#applicationDivId').hide();
                        $('#otherDivId').hide();
                        $('.travelGEId').hide();
                        $('.RelocationGTEId').hide();
                        $('#policyDivId').show();
                        $('#relocation1').hide();
                        $('#travel1').hide();
                        $('#policy11').show();
                        $('#demo9').hide();
                    }
                });
            });</script>-->

    <script>
        var i1First = 1;
        var tempCountFirst = 1;
//        alert(i1);
        //        alert(tempCount);
        $(function () {
            $("#addRowButtonId").on("click", function () {
                //                alert(i1First);
                i1First = document.getElementById('countFirst').value;
                i1First++;
                tempCountFirst = document.getElementById('countFirst').value;
                tempCountFirst++;
                //                alert(tempCountFirst);
                var clone = "<tr id='1moreFile" + i1First + "' style='clear:both;'>"
                        + "<td style=\"text-align: center\">" + i1First + "</td>"
                        + "<td><input type=\"text\" name='fromCity" + tempCountFirst + "' id='fromCity" + tempCountFirst + "' class=\"form-control\"><span id=\"fromCityError" + tempCountFirst + "\" style=\"color: red;\"></span></td>"
                        + "<td><input type=\"text\" name='toCity" + tempCountFirst + "' id='toCity" + tempCountFirst + "' class=\"form-control\"><span id=\"toCityError" + tempCountFirst + "\" style=\"color: red;\"></span></td>"
//                        + "<td><div class=\"input-group date form_datetime\" data-date-format=\"dd/mm/yyyy - hh:ii\" data-link-field=\"dtp_input1\" style=\"width: 105px\">"
//                        + "<input class=\"form-control date_datetime\" size=\"16\" name='travelDate" + tempCountFirst + "' id='travelDate" + tempCountFirst + "' type=\"text\" readonly style=\"width: 98px\">"
//                        + "<span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-th\"></span></span>"
                        //                        + "</div></td>"
                        + "<td>"
                        + "<input class=\"form-control\" size=\"16\" name='travelDate" + tempCountFirst + "' type=\"text\"  id=\"datepickerr" + tempCountFirst + "\" onclick=\"clickToPickData(" + tempCountFirst + ");\" style=\"width: 141px\">"
                        + "<span id=\"travelDateError" + tempCountFirst + "\" style=\"color: red;\"></span></td>"
                        + "<td><div><select id=\"WorkTypeSelectId\" name='WorkTypeSelect" + tempCountFirst + "' class=\"form-control\">"
                        + "<option value=\"\"> --SELECT-- </option>"
                        + "<option value=\"Air\"> Air </option>"
                        + "<option value =\"Train\"> Train </option>"
                        + "<option value =\"Bus\"> Bus </option>"
                        + "<option value =\"Cab\"> Cab </option>"
                        + "<option value =\"AutoRickshaw\"> Auto Rickshaw </option>"
                        + "</select>"
                        + "</div><span id=\"WorkTypeSelectIdError" + tempCountFirst + "\" style=\"color: red;\"></span></td>"
                        + "<td><input type=\"text\" name='amount" + tempCountFirst + "' id='amount" + tempCountFirst + "' class=\"form-control\" onchange=\"calculateAmount();\"><span id=\"amountError" + tempCountFirst + "\" style=\"color: red;\"></span></td>"
                        + "<td><div><select id='currencyTravelDivId" + tempCountFirst + "' class=\"form-control\" name='currencyTravelDiv" + tempCountFirst + "' onchange=\"changeAmount1(this.value);\">"
                        + "<option value=\"\">--SELECT--</option>"
                        + "</select>"
                        + "</div><span id=\"currencyTravelDivIdError" + tempCountFirst + "\" style=\"color: red;\"></td>"
                        //                        + "<td style=\"text-align: center\"><span><input type=\"checkbox\"/></span></td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\" value=\"-\" id=\"removeRowButtonId\" onclick=\"removeChild31('1moreFile" + i1First + "','" + tempCountFirst + "');\">"
                        + "</span>"
                        + "</td>"
                        + "</tr>";
                document.getElementById('countFirst').value = tempCountFirst;
                $("#demo").append(clone);
                optionsAdding(tempCountFirst);
//                alert(document.getElementById('travelType').value);

                if (document.getElementById('travelType').value == 'Domestic') {
                    var element2 = document.getElementById("currencyTravelDivId" + tempCountFirst);
                    alert(element2);
                    for (var i2 = 0; i2 < element2.options.length; i2++) {
                        alert(element2.options.length);
                        var currencyVal = element2.options[i2].value;
                        alert("currencyVal" + currencyVal);
                        var currencyText = element2.options[i2].text;
                        try {
                            currencyText = currencyText.split('(');
                            var currencyText11 = currencyText[1];
                            alert("currencyText11" + currencyText11);
                            currencyText11 = currencyText11.split(')');
                            if (currencyText11[0] === 'INR') {
                                alert("currencyText" + currencyText11[0]);
                                $("#currencyTravelDivId" + tempCountFirst).children('option').hide();
                                document.getElementById("currencyTravelDivId" + tempCountFirst).options[i2].selected = "true";

                            }
                        } catch (e) {

                        }
                    }

                } else {
                    $("#currencyTravelDivId" + tempCountFirst).children('option').show();
                }
            });
        });
        //            $("#removeRowButtonId").on("click", function () {
        function optionsAdding(id) {
            var element2 = document.getElementById('finalCurrencyId');
            var obj2 = document.getElementById("currencyTravelDivId" + id);
            //            alert(element2.options.length);
            for (var i2 = 0; i2 < element2.options.length; i2++) {
                var opt2 = document.createElement("option");
                opt2.value = element2.options[i2].value;
//                alert(i2);
                //                alert(opt2.value);
                opt2.text = element2.options[i2].text;
                obj2.appendChild(opt2);
            }
        }

        function removeChild31(removeRowId, currentCount) {
//            alert("ajya" + removeRowId);
            i1First--;
            tempCountFirst--;
            try {

                var currencyTravelDivId = document.getElementById("currencyTravelDivId" + currentCount).value;
                var amount = parseFloat(document.getElementById("amount" + currentCount).value);
                var totalAmount = document.getElementById("totalAmount_" + currencyTravelDivId).value;
                var finalTotal = parseFloat(totalAmount) - parseFloat(amount);
                // Removes an element from the document
                document.getElementById("totalAmount_" + currencyTravelDivId).value = finalTotal;
            } catch (e) {

            }
            document.getElementById('countFirst').value = i1First;
            document.getElementById('countFirst').value = tempCountFirst;
            // Removes an element from the document
            var element = document.getElementById(removeRowId);
            element.parentNode.removeChild(element);
            var id;
            changeAmount1(id);
            //            });
        }
    </script>

    <script>
        var i1Relo = 1;
        var tempCountRelo = 1;
        $(function () {
            $("#addRowButtonId1").on("click", function () {
//                alert(i1Relo);
                i1Relo = document.getElementById('countFirstRelo').value;
                i1Relo++;
                tempCountRelo = document.getElementById('countFirstRelo').value;
                tempCountRelo++;
                //                alert(tempCountRelo);
                var clone = "<tr id='1moreFile" + i1Relo + "' style='clear:both;'>"
                        + "<td style=\"text-align: center\">" + i1Relo + "</td>"
                        + "<td><input type=\"text\" name='fromCityRelo" + tempCountRelo + "' id='fromCityRelo" + tempCountRelo + "' class=\"form-control\"><span id=\"fromCityReloError" + tempCountRelo + "\" style=\"color: red;\"></span></td>"
                        + "<td><input type=\"text\" name='toCityRelo" + tempCountRelo + "' id='toCityRelo" + tempCountRelo + "' class=\"form-control\"><span id=\"toCityReloError" + tempCountRelo + "\" style=\"color: red;\"></td>"
                        + "<td><input class=\"form-control\" size=\"16\" type=\"text\" id=\"travelDateRelo" + tempCountRelo + "\" name=\"travelDateRelo" + tempCountRelo + "\" value=\"\"  style=\"width: 141px\" onclick=\"clickToPicker11(" + tempCountRelo + ");\"><span id=\"travelDateReloError" + tempCountRelo + "\" style=\"color: red;\"></td>"
                        + "<td><div><select id=\"WorkTypeSelectRelo" + tempCountRelo + "\" name='WorkTypeSelectRelo" + tempCountRelo + "' class=\"form-control\">"
                        + "<option value=\"\"> --SELECT-- </option>"
                        + "<option value=\"Air\"> Air </option>"
                        + "<option value =\"Train\"> Train </option>"
                        + "<option value =\"Bus\"> Bus </option>"
                        + "<option value =\"Cab\"> Cab </option>"
                        + "<option value =\"AutoRickshaw\"> Auto Rickshaw </option>"
                        + "</select>"
                        + "</div><span id=\"WorkTypeSelectReloError" + tempCountRelo + "\" style=\"color: red;\"></td>"
                        + "<td><input type=\"text\" name='amountRelo" + tempCountRelo + "' id='amountRelo" + tempCountRelo + "' class=\"form-control\" onchange=\"calculateAmount();\"><span id=\"amountReloError" + tempCountRelo + "\" style=\"color: red;\"></td>"
                        + "<td id=\"currencyTravelRelo_td" + tempCountRelo + "\"><div><select id='currencyTravelDivRelo" + tempCountRelo + "' class=\"form-control\" name='currencyTravelDivRelo" + tempCountRelo + "' onchange=\"changeAmount1(this.value);\">"
                        + "<option value=\"\">--SELECT--</option>"
                        + "</select>"
                        + "</div><span id=\"fromCityError" + tempCountRelo + "\" style=\"color: red;\"></td>"
                        //                        + "<td style=\"text-align: center\"><span><input type=\"checkbox\"/></span></td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\" value=\"-\" id=\"removeRowButtonId\" onclick=\"removeChild3Relo('1moreFile" + i1Relo + "','" + tempCountRelo + "');\">"
                        + "</span>"
                        + "</td>"
                        + "</tr>";
                document.getElementById('countFirstRelo').value = tempCountRelo;
                $("#demo8").append(clone);
                optionsAdd555(tempCountRelo);
                var selectedValue = document.getElementById("expenseType").value;
                if (selectedValue === "Relocation") {

                    var element2 = document.getElementById("currencyTravelDivRelo" + tempCountRelo);
                    for (var i2 = 0; i2 < element2.options.length; i2++) {
                        var currencyVal = element2.options[i2].value;
                        //                            alert("currencyVal" + currencyVal);
                        var currencyText = element2.options[i2].text;
                        try {
                            currencyText = currencyText.split('(');
                            var currencyText11 = currencyText[1];
                            //                                alert("currencyText11" + currencyText11);
                            currencyText11 = currencyText11.split(')');
                            if (currencyText11[0] === 'INR') {
                                //                                    alert("currencyText" + currencyText11[0]);
                                $("#currencyTravelDivRelo" + tempCountRelo).children('option').hide();
                                document.getElementById("currencyTravelDivRelo" + tempCountRelo).options[i2].selected = "true";

                            }
                        } catch (e) {

                        }
                    }
                    document.getElementById("currencyTravelRelo_td" + tempCountRelo).style.display = 'none';
                    document.getElementById("currencyTravelRelo_th").style.display = 'none';
                }
            });
        });
        //            $("#removeRowButtonId").on("click", function () {
        function optionsAdd555(id) {
            var element2 = document.getElementById('currencyTravelDivId1');
            //            var element2 = document.getElementById('currencyTravelDivRelo1');
            var obj2 = document.getElementById("currencyTravelDivRelo" + id);
            for (var i2 = 1; i2 < element2.options.length; i2++) {
                var opt2 = document.createElement("option");
                opt2.value = element2.options[i2].value;
                opt2.text = element2.options[i2].text;
                obj2.appendChild(opt2);
            }
        }
        function optionsAdd(id) {
            //                alert(id);
            var element2 = document.getElementById('currencyTravelDivId1');
            var obj2 = document.getElementById("currencyTravelDivId" + id);
            for (var i2 = 0; i2 < element2.options.length; i2++) {
                var opt2 = document.createElement("option");
                opt2.value = element2.options[i2].value;
                opt2.text = element2.options[i2].text;
                obj2.appendChild(opt2);
            }
        }

        function removeChild3Relo(removeRowId, currentCount) {

            i1Relo--;
            tempCountRelo--;
            document.getElementById('countFirstRelo').value = tempCountRelo;
            document.getElementById('countFirstRelo').value = i1Relo;
            try {

                var currencyTravelDivRelo = document.getElementById("currencyTravelDivRelo" + currentCount).value;
                var amount = parseFloat(document.getElementById("amountRelo" + currentCount).value);
                var totalAmount = document.getElementById("totalAmount_" + currencyTravelDivRelo).value;
                var finalTotal = parseFloat(totalAmount) - parseFloat(amount);
                // Removes an element from the document
                document.getElementById("totalAmount_" + currencyTravelDivRelo).value = finalTotal;
            } catch (e) {

            }
            // Removes an element from the document
            var element = document.getElementById(removeRowId);
            element.parentNode.removeChild(element);
            var id;
            changeAmount1(id);
            //            });
        }
    </script>
    <script>
        function otherEnble(id) {
            var selectedVal = document.getElementById("RentAndFoodDivPolicy" + id).value;
            if (selectedVal == "Other") {
                $('#purposePolicy' + id).show();
            } else {
                $('#purposePolicy' + id).hide();
            }

        }
        function travelOtherBox(id) {
            var selectedVal = document.getElementById("RentAndFoodDiv" + id).value;
            if (selectedVal == "Other") {
                $('#travelotherOptionId' + id).show();
                $('#otherPurposeId').show();
            } else {
                $('#travelotherOptionId' + id).hide();
                $('#otherPurposeId').hide();
            }

        }
        $(function () {
            $("#travelotherExpenseDate1").datepicker({dateFormat: 'dd/mm/yy'});
        });
        $(function () {
            $("#reloOtherExpenseDate1").datepicker({dateFormat: 'dd/mm/yy'});
        });
        $(function () {
            $("#billDate1").datepicker({dateFormat: 'dd/mm/yy'});
        });
        $(function () {
            $("#travelDateRelo1").datepicker({dateFormat: 'dd/mm/yy'});
        });
    </script>

    <script>
        var tempCount3 = 1;
        $(function () {
            $("#addButtonFoodCategoryId").on("click", function () {
                //                alert(i1);
                tempCount3 = document.getElementById('countSecond').value;
                tempCount3++;
                //                alert(tempCount3);
                var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"
                        + "<td style=\"text-align: center\">" + tempCount3 + "</td>"
                        + "<td><input class='form-control' size='16' type='text' id='travelotherExpenseDate" + tempCount3 + "' name='travelotherExpenseDate" + tempCount3 + "' value=''>"
                        + "<span id='travelotherExpenseDateError" + tempCount3 + "' style='color: red;'></span>"
                        + "</td>"
                        + "<td><div><select id=\"RentAndFoodDiv" + tempCount3 + "\" name='RentAndFoodDiv" + tempCount3 + "' class=\"form-control\" onchange=travelOtherBox(" + tempCount3 + ");>"
                        + "<option value =\"\"> --SELECT-- </option>"
                        + "<option value =\"RoomRent\"> Room Rent </option>"
                        + "<option value =\"BreakFast\"> BreakFast </option>"
                        + "<option value =\"Lunch\"> Lunch </option>"
                        + "<option value =\"Dinner\"> Dinner </option>"
                        + "<option value =\"Communication\"> Communication </option>"
                        + "<option class=\"travelGEId\" style=\"display: none\" value=\"GuestEntertainment\">Guest Entertainment</option>"
                        + "<option class=\"RelocationGTEId\" style=\"display: none\" value=\"GoodsTransitExpense\">Goods Transit Expense</option>"
                        + "<option value =\"Other\"> Other </option>"
                        + "</select>"
                        + "</div></td>"
                        + "<td><input type=\"text\" name=\"purpose" + tempCount3 + "\" class=\"form-control\" id=\"travelotherOptionId" + tempCount3 + "\" style=\"display: none\" placeholder=\"(Please Specify In case of Other)\"></td>"
                        + "<td><input type=\"text\" name='otherAmount" + tempCount3 + "' id='otherAmount" + tempCount3 + "' class=\"form-control\" onchange=\"calculateAmount();\"></td>"
                        + "<td><div><select id='currencyRelocationDivId" + tempCount3 + "' name='currencyRelocationDiv" + tempCount3 + "' class=\"form-control\" onchange=\"changeAmount1(this.value);\">"
                        + "<option value=\"\">--SELECT--</option>"
                        + "</select>"
                        + "</div></td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\"value=\"-\" id=\"removeRowButtonId\" onclick=\"removeChild3Second('addmoreFile" + tempCount3 + "','" + tempCount3 + "');\">"
                        + "</span>"
                        + "</td>"
                        + "</tr>";
                $("#demo2").append(clone);
                document.getElementById('countSecond').value = tempCount3;
                optionsAdding1(tempCount3);
                $("#travelotherExpenseDate" + tempCount3).datepicker({dateFormat: 'dd/mm/yy'});
                var expenseType = document.getElementById('expenseType').value;
                if (expenseType === "Travel") {
//                    $('#applicationDivId').show();
//                    $('#demo').show();
//                    $('#demo2').show();
//                    $('#otherDivId').hide();
                    //                    $('#demo3').hide();
                    $('.travelGEId').show();
                    $('.RelocationGTEId').hide();
                }
                else if (expenseType === "Others") {
//                    $('#otherDivId').show();
//                    $('#demo').hide();
//                    $('#demo2').hide();
//                    $('#demo3').show();
                    //                    $('#applicationDivId').hide();
                    $('.travelGEId').hide();
                    $('.RelocationGTEId').hide();
                }
                else if (expenseType === "Relocation") {
//                    $('#demo').show();
//                    $('#demo2').show();
//                    $('#demo3').hide();
//                    $('#otherDivId').hide();
                    //                    $('#applicationDivId').hide();
                    $('.travelGEId').hide();
                    $('.RelocationGTEId').show();
                }
                else {
//                    $('#demo').hide();
//                    $('#demo2').show();
//                    $('#demo3').hide();
//                    $('#applicationDivId').hide();
                    //                    $('#otherDivId').hide();
                    $('.travelGEId').hide();
                    $('.RelocationGTEId').hide();
                }

                if (document.getElementById("travelType").value == 'Domestic') {

//                        for (var i = 1; i <= countSecond; i++) {
                    var element2 = document.getElementById("currencyRelocationDivId" + tempCount3);
                    for (var i2 = 0; i2 < element2.options.length; i2++) {
                        var currencyVal = element2.options[i2].value;
                        var currencyText = element2.options[i2].text;
                        try {
                            currencyText = currencyText.split('(');
                            var currencyText11 = currencyText[1];
//                                alert("currencyText11" + currencyText11);
                            currencyText11 = currencyText11.split(')');
                            if (currencyText11[0] === 'INR') {
//                                    alert("currencyText" + currencyText11[0]);
                                $("#currencyRelocationDivId" + tempCount3).children('option').hide();
                                document.getElementById("currencyRelocationDivId" + tempCount3).options[i2].selected = "true";

                            }
                        } catch (e) {

                        }
                    }
//                                document.getElementById("otherCurrrency_th").style.display = 'none';
//                                document.getElementById("otherCurrrency_td_" + i).style.display = 'none';
//                        }

                } else {
                    $("#currencyRelocationDivId" + tempCount3).children('option').show();
                }

            });
        });
        //            $("#removeRowButtonId").on("click", function () {
        function optionsAdding1(id) {
            //            alert(id);
            var element2 = document.getElementById('currencyRelocationDivId1');
            var obj2 = document.getElementById("currencyRelocationDivId" + id);
            for (var i2 = 0; i2 < element2.options.length; i2++) {
                var opt2 = document.createElement("option");
                opt2.value = element2.options[i2].value;
                opt2.text = element2.options[i2].text;
                obj2.appendChild(opt2);
            }
        }

        function removeChild3Second(removeRowId, currentCount) {
            tempCount3--;
            document.getElementById('countSecond').value = tempCount3;
            try {

                var currencyRelocationDiv = document.getElementById("currencyRelocationDivId" + currentCount).value;
                var otherAmount = parseFloat(document.getElementById("otherAmount" + currentCount).value);
                var totalAmount = document.getElementById("totalAmount_" + currencyRelocationDiv).value;
                var finalTotal = parseFloat(totalAmount) - parseFloat(otherAmount);
                // Removes an element from the document
                document.getElementById("totalAmount_" + currencyRelocationDiv).value = finalTotal;
            } catch (e) {

            }

            // Removes an element from the document
            var element = document.getElementById(removeRowId);
            element.parentNode.removeChild(element);
            var id;
            changeAmount1(id);
            //            });
        }
    </script>

    <script>
        var tempCount3Second = 1;
        $(function () {
            $("#addButtonFoodCategoryId1").on("click", function () {
                //                alert(i1);
                tempCount3Second = document.getElementById('countSecondRelo').value;
                tempCount3Second++;
                //                alert(tempCount3Second);
                var clone = "<tr id='addmoreFile" + tempCount3Second + "' style='clear:both;'>"
                        + "<td style=\"text-align: center\">" + tempCount3Second + "</td>"
                        + "<td><input class='form-control' size='16' type='text' id='reloOtherExpenseDate" + tempCount3Second + "' name='reloOtherExpenseDate" + tempCount3Second + "' value=''>"
                        + "<span id='reloOtherExpenseDateError" + tempCount3Second + "' style='color: red;'></span>"
                        + "</td>"
                        + "<td><div><select id=\"RentAndFoodDivRelo" + tempCount3Second + "\" name='RentAndFoodDivRelo" + tempCount3Second + "' class=\"form-control\" onchange=showOnlyOtherBox(" + tempCount3Second + ");>"
                        + "<option value =\"\"> --SELECT-- </option>"
                        + "<option value =\"RoomRent\"> Room Rent </option>"
                        + "<option value =\"BreakFast\"> BreakFast </option>"
                        + "<option value =\"Lunch\"> Lunch </option>"
                        + "<option value =\"Dinner\"> Dinner </option>"
                        + "<option value =\"Communication\"> Communication </option>"
                        + "<option class=\"travelGEId\" style=\"display: none\" value=\"GuestEntertainment\">Guest Entertainment</option>"
                        + "<option class=\"RelocationGTEId\" style=\"display: none\" value=\"GoodsTransitExpense\">Goods Transit Expense</option>"
                        + "<option value =\"Other\"> Other </option>"
                        + "</select>"
                        + "</div><span id=\"RentAndFoodDivReloError" + tempCount3Second + "\" style=\"color: red;\"></span></td>"
                        + "<td><input type=\"text\" name=\"purposeRelo" + tempCount3Second + "\" class=\"form-control\" id=\"purposeRelo" + tempCount3Second + "\" style=\"display: none\" placeholder=\"(Please Specify In case of Other)\"><span id=\"purposeReloError" + tempCount3Second + "\" style=\"color: red;\"></span></td>"
                        + "<td><input type=\"text\" name='otherAmountRelo" + tempCount3Second + "' id='otherAmountRelo" + tempCount3Second + "' class=\"form-control\" onchange=\"calculateAmount();\"><span id=\"otherAmountReloError" + tempCount3Second + "\" style=\"color: red;\"></span></td>"
                        + "<td id=\"currencyRelocationDiv_td" + tempCount3Second + "\"><div><select id='currencyRelocationDivRelo" + tempCount3Second + "' name='currencyRelocationDivRelo" + tempCount3Second + "' class=\"form-control\" onchange=\"changeAmount1(this.value);\">"
                        + "<option value=\"\">--SELECT--</option>"
                        + "</select>"
                        + "</div><span id=\"currencyRelocationDivReloError" + tempCount3Second + "\" style=\"color: red;\"></span></td>"
//                        + "<td style=\"text-align: center\">"
//                        + "<span><input type=\"checkbox\"/></span>"
                        //                        + "</td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\"value=\"-\" id=\"removeRowButtonId\" onclick=\"removeChild3Second('addmoreFile" + tempCount3Second + "','" + tempCount3Second + "');\">"
                        + "</span>"
                        + "</td>"
                        + "</tr>";
                $("#demo9").append(clone);
                document.getElementById('countSecondRelo').value = tempCount3Second;
                optionsAdd123(tempCount3Second);
                $("#reloOtherExpenseDate" + tempCount3Second).datepicker({dateFormat: 'dd/mm/yy'});
                var expenseType = document.getElementById('expenseType').value;
                if (expenseType === "Travel") {
//                    $('#applicationDivId').show();
//                    $('#demo').show();
//                    $('#demo2').show();
//                    $('#otherDivId').hide();
                    //                    $('#demo3').hide();
                    $('.travelGEId').show();
                    $('.RelocationGTEId').hide();
                }
                else if (expenseType === "Others") {
//                    $('#otherDivId').show();
//                    $('#demo').hide();
//                    $('#demo2').hide();
//                    $('#demo3').show();
                    //                    $('#applicationDivId').hide();
                    $('.travelGEId').hide();
                    $('.RelocationGTEId').hide();
                }
                else if (expenseType === "Relocation") {
//                    $('#demo').show();
//                    $('#demo2').show();
//                    $('#demo3').hide();
//                    $('#otherDivId').hide();
                    //                    $('#applicationDivId').hide();
                    $('.travelGEId').hide();
                    $('.RelocationGTEId').show();
                }
                else {
//                    $('#demo').hide();
//                    $('#demo2').show();
//                    $('#demo3').hide();
//                    $('#applicationDivId').hide();
                    //                    $('#otherDivId').hide();
                    $('.travelGEId').hide();
                    $('.RelocationGTEId').hide();
                }


                if (expenseType === "Relocation") {
                    var element2 = document.getElementById("currencyRelocationDivRelo" + tempCount3Second);
                    for (var i2 = 0; i2 < element2.options.length; i2++) {
                        var currencyVal = element2.options[i2].value;
                        //                            alert("currencyVal" + currencyVal);
                        var currencyText = element2.options[i2].text;
                        try {
                            currencyText = currencyText.split('(');
                            var currencyText11 = currencyText[1];
                            //                                alert("currencyText11" + currencyText11);
                            currencyText11 = currencyText11.split(')');
                            if (currencyText11[0] === 'INR') {
                                //                                    alert("currencyText" + currencyText11[0]);
                                $("#currencyRelocationDivRelo" + tempCount3Second).children('option').hide();
                                document.getElementById("currencyRelocationDivRelo" + tempCount3Second).options[i2].selected = "true";

                            }
                        } catch (e) {

                        }
                    }
                    document.getElementById("currencyRelocationDiv_td" + tempCount3Second).style.display = 'none';
                    document.getElementById("currencyRelocationDiv_th").style.display = 'none';
                }

            });
        });
        //            $("#removeRowButtonId").on("click", function () {
        function optionsAdd123(id) {
            //            alert(id);
            var element2 = document.getElementById('currencyRelocationDivRelo1');
            var obj2 = document.getElementById("currencyRelocationDivRelo" + id);
            for (var i2 = 0; i2 < element2.options.length; i2++) {
                var opt2 = document.createElement("option");
                opt2.value = element2.options[i2].value;
                opt2.text = element2.options[i2].text;
                obj2.appendChild(opt2);
            }
        }
        function optionsAdd1(id) {
            //                alert(id);
            var element2 = document.getElementById('currencyRelocationDivId1');
            var obj2 = document.getElementById("currencyRelocationDivId" + id);
            for (var i2 = 0; i2 < element2.options.length; i2++) {
                var opt2 = document.createElement("option");
                opt2.value = element2.options[i2].value;
                opt2.text = element2.options[i2].text;
                obj2.appendChild(opt2);
            }
        }

        function removeChild3Second(removeRowId, currentCount) {
            tempCount3Second--;
            document.getElementById('countSecondRelo').value = tempCount3Second;
            try {

                var currencyRelocationDivRelo = document.getElementById("currencyRelocationDivRelo" + currentCount).value;
                var otherAmount = parseFloat(document.getElementById("otherAmountRelo" + currentCount).value);
                var totalAmount = document.getElementById("totalAmount_" + currencyRelocationDivRelo).value;
                var finalTotal = parseFloat(totalAmount) - parseFloat(otherAmount);
                // Removes an element from the document
                document.getElementById("totalAmount_" + currencyRelocationDivRelo).value = finalTotal;
            } catch (e) {

            }
            // Removes an element from the document
            var element = document.getElementById(removeRowId);
            element.parentNode.removeChild(element);
            var id;
            changeAmount1(id);
            //            });
        }
    </script>

    <script>
        var tempCount3Policy = 1;
        $(function () {
            $("#addButtonFoodCategoryId2").on("click", function () {
                //                alert(i1);
                tempCount3Policy = document.getElementById('countSecondOther').value;
                tempCount3Policy++;
                //                alert(tempCount3Policy);
                var clone = "<tr id='addmoreFile" + tempCount3Policy + "' style='clear:both;'>"
                        + "<td style=\"text-align: center\">" + tempCount3Policy + "</td>"
                        + "<td><input class='form-control' size='16' type='text' id='otherExpenseDate" + tempCount3Policy + "' name='otherExpenseDate" + tempCount3Policy + "' onclick='otherExpenseDatePic(" + tempCount3Policy + ")' value=''>"
                        + "<span id='otherExpenseDateError" + tempCount3Policy + "' style='color: red;'></span>"
                        + "</td>"
                        + "<td><div><select id=\"RentAndFoodDivPolicy" + tempCount3Policy + "\" name='RentAndFoodDivPolicy" + tempCount3Policy + "' class=\"form-control\" onchange='otherEnble(" + tempCount3Policy + ");'>"
                        + "<option value =\"\"> --SELECT-- </option>"
                        + "<option value =\"RoomRent\"> Room Rent </option>"
                        + "<option value =\"BreakFast\"> BreakFast </option>"
                        + "<option value =\"Lunch\"> Lunch </option>"
                        + "<option value =\"Dinner\"> Dinner </option>"
                        + "<option value =\"Communication\"> Communication </option>"
                        + "<option class=\"travelGEId\" style=\"display: none\" value=\"GuestEntertainment\">Guest Entertainment</option>"
                        + "<option class=\"RelocationGTEId\" style=\"display: none\" value=\"GoodsTransitExpense\">Goods Transit Expense</option>"
                        + "<option value =\"Other\"> Other </option>"
                        + "</select>"
                        + "</div></td>"
                        + "<td><input type=\"text\" name='purposePolicy" + tempCount3Policy + "' class=\"form-control\" id='purposePolicy" + tempCount3Policy + "' style=\"display: none\" placeholder=\"(Please Specify In case of Other)\"></td>"
                        + "<td><input type=\"text\" name='otherAmountPolicy" + tempCount3Policy + "' id='otherAmountPolicy" + tempCount3Policy + "' class=\"form-control\" onchange=\"calculateAmount();\"></td>"
                        + "<td id=\"policyReimbCurrency_td" + tempCount3Policy + "\"><div><select id='currencyRelocationDivPolicy" + tempCount3Policy + "' name='currencyRelocationDivPolicy" + tempCount3Policy + "' class=\"form-control\" onchange=\"changeAmount1(this.value);\">"
                        + "<option value=\"\">--SELECT--</option>"
                        + "</select>"
                        + "</div></td>"
//                        + "<td style=\"text-align: center\">"
//                        + "<span><input type=\"checkbox\"/></span>"
                        //                        + "</td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\"value=\"-\" id=\"removeRowButtonId\" onclick=\"removeChild3Policy('addmoreFile" + tempCount3Policy + "','" + tempCount3Policy + "');\">"
                        + "</span>"
                        + "</td>"
                        + "</tr>";
                $("#demo7").append(clone);
                document.getElementById('countSecondOther').value = tempCount3Policy;
                optionsAdded1(tempCount3Policy);
                var expenseType = document.getElementById('expenseType').value;
                if (expenseType === "Travel") {
//                    $('#applicationDivId').show();
//                    $('#demo').show();
//                    $('#demo2').show();
//                    $('#otherDivId').hide();
                    //                    $('#demo3').hide();
                    $('.travelGEId').show();
                    $('.RelocationGTEId').hide();
                }
                else if (expenseType === "Others") {
//                    $('#otherDivId').show();
//                    $('#demo').hide();
//                    $('#demo2').hide();
//                    $('#demo3').show();
                    //                    $('#applicationDivId').hide();
                    $('.travelGEId').hide();
                    $('.RelocationGTEId').hide();
                }
                else if (expenseType === "Relocation") {
//                    $('#demo').show();
//                    $('#demo2').show();
//                    $('#demo3').hide();
//                    $('#otherDivId').hide();
                    //                    $('#applicationDivId').hide();
                    $('.travelGEId').hide();
                    $('.RelocationGTEId').show();
                }
                else {
//                    $('#demo').hide();
//                    $('#demo2').show();
//                    $('#demo3').hide();
//                    $('#applicationDivId').hide();
                    //                    $('#otherDivId').hide();
                    $('.travelGEId').hide();
                    $('.RelocationGTEId').hide();
                }

                if (expenseType === "PolicyReimbursements") {
                    var element2 = document.getElementById("currencyRelocationDivPolicy" + tempCount3Policy);
                    for (var i2 = 0; i2 < element2.options.length; i2++) {
                        var currencyVal = element2.options[i2].value;
//                            alert("currencyVal" + currencyVal);
                        var currencyText = element2.options[i2].text;
                        try {
                            currencyText = currencyText.split('(');
                            var currencyText11 = currencyText[1];
//                                alert("currencyText11" + currencyText11);
                            currencyText11 = currencyText11.split(')');
                            if (currencyText11[0] === 'INR') {
//                                    alert("currencyText" + currencyText11[0]);
                                $("#currencyRelocationDivPolicy" + tempCount3Policy).children('option').hide();
                                document.getElementById("currencyRelocationDivPolicy" + tempCount3Policy).options[i2].selected = "true";

                            }
                        } catch (e) {

                        }
                    }
                    document.getElementById("policyReimbCurrency_td" + tempCount3Policy).style.display = 'none';
                    document.getElementById("policyReimbCurrency_th").style.display = 'none';
                }

            });
        });
        //            $("#removeRowButtonId").on("click", function () {
        function optionsAdded1(id) {
            //            alert(id);
            var element2 = document.getElementById('currencyRelocationDivId1');
            var obj2 = document.getElementById("currencyRelocationDivPolicy" + id);
            for (var i2 = 1; i2 < element2.options.length; i2++) {
                var opt2 = document.createElement("option");
                opt2.value = element2.options[i2].value;
                opt2.text = element2.options[i2].text;
                obj2.appendChild(opt2);
            }
        }

        function removeChild3Policy(removeRowId, currentCount) {
            tempCount3Policy--;
            document.getElementById('countSecondOther').value = tempCount3Policy;
            try {

                var currencyRelocationDivPolicy = document.getElementById("currencyRelocationDivPolicy" + currentCount).value;
                var otherAmount = parseFloat(document.getElementById("otherAmountPolicy" + currentCount).value);
                var totalAmount = document.getElementById("totalAmount_" + currencyRelocationDivPolicy).value;
                var finalTotal = parseFloat(totalAmount) - parseFloat(otherAmount);
                // Removes an element from the document
                document.getElementById("totalAmount_" + currencyRelocationDivPolicy).value = finalTotal;
            } catch (e) {

            }
            // Removes an element from the document
            var element = document.getElementById(removeRowId);
            element.parentNode.removeChild(element);
            var id;
            changeAmount1(id);
            //            });
        }
    </script>

    <script>
        var i3 = 1;
        var tempCountOther = 1;
        $(function () {
            $("#addButtonOtherTableId").on("click", function () {
                i3 = document.getElementById('othersCount').value;
                i3++;
                tempCountOther = document.getElementById('othersCount').value;
                tempCountOther++;
                var clone3 = "<tr id='addmoreFile" + i3 + "' style='clear:both;'>"
                        + "<td style=\"text-align: center\">" + i3 + "</td>"
                        + "<td style=\"width: 20%\">"
                        + "<input class=\"form-control\" size=\"16\" type=\"text\" id=\"billDate" + tempCountOther + "\" name='billDate" + tempCountOther + "' value=\"\"  onclick=\"clickToPickData('" + tempCountOther + "');\">"
                        + "</td>"
                        + "<td><input type=\"text\" name='billNo" + tempCountOther + "' class=\"form-control\"></td>"
                        + "<td><input type=\"text\" name='policyAmount" + tempCountOther + "' id='policyAmount" + tempCountOther + "' class=\"form-control\" onchange=\"calculateAmount();\"></td>"
                        + "<td id=\"otherCurrency_td" + tempCountOther + "\"><div>"
                        + "<select id='currencyOtherDiv" + tempCountOther + "' name='otherCurrency" + tempCountOther + "' class=\"form-control\" onchange=\"changeAmount1(this.value);\">"
                        + "<option value=\"\">--SELECT--</option>"
                        + "</select>"
                        + "</div></td>"
                        //                        + "<td style=\"text-align: center\"><span><input type=\"checkbox\"/></span></td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\"value=\"-\" id=\"removeRowButtonId\" onclick=\"removeChild3('addmoreFile" + i3 + "','" + tempCountOther + "');\">"
                        + "</span>"
                        + "</td>"
                        + "</tr>"
                $("#demo3").append(clone3);
                //                alert(tempCountOther);
                document.getElementById('othersCount').value = tempCountOther;
                optionsAdd2(tempCountOther);
                $("#billDate" + tempCountOther).datepicker({dateFormat: 'dd/mm/yy'});
                var element2 = document.getElementById("currencyOtherDiv" + tempCountOther);
                for (var i2 = 0; i2 < element2.options.length; i2++) {
                    var currencyVal = element2.options[i2].value;
//                            alert("currencyVal" + currencyVal);
                    var currencyText = element2.options[i2].text;
                    try {
                        currencyText = currencyText.split('(');
                        var currencyText11 = currencyText[1];
//                                alert("currencyText11" + currencyText11);
                        currencyText11 = currencyText11.split(')');
                        if (currencyText11[0] === 'INR') {
//                                    alert("currencyText" + currencyText11[0]);
                            $("#currencyOtherDiv" + tempCountOther).children('option').hide();
                            document.getElementById("currencyOtherDiv" + tempCountOther).options[i2].selected = "true";

                        }
                    } catch (e) {

                    }
                }
                document.getElementById("otherCurrency_td" + tempCountOther).style.display = 'none';
                document.getElementById("otherCurrency_th").style.display = 'none';

            });
        });
        function optionsAdd2(id) {
            //                alert(id);
            var element2 = document.getElementById('currencyOtherDiv1');
            var obj2 = document.getElementById("currencyOtherDiv" + id);
            for (var i2 = 0; i2 < element2.options.length; i2++) {
                var opt2 = document.createElement("option");
                opt2.value = element2.options[i2].value;
                opt2.text = element2.options[i2].text;
                obj2.appendChild(opt2);
            }
        }

        function removeChild3(removeRowId, currentCount) {
            //            alert("ajay" + i3);
            i3--;
            tempCountOther--;
            document.getElementById('othersCount').value = tempCountOther;
            document.getElementById('othersCount').value = i3;
            try {

                var currencyOtherDiv = document.getElementById("currencyOtherDiv" + currentCount).value;
                var policyAmount = parseFloat(document.getElementById("policyAmount" + currentCount).value);
                var totalAmount = document.getElementById("totalAmount_" + currencyOtherDiv).value;
                var finalTotal = parseFloat(totalAmount) - parseFloat(policyAmount);
                // Removes an element from the document
                document.getElementById("totalAmount_" + currencyOtherDiv).value = finalTotal;
            } catch (e) {

            }
            // Removes an element from the document
            var element = document.getElementById(removeRowId);
            element.parentNode.removeChild(element);
            var id;
            changeAmount1(id);
        }
    </script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script>
        function clickToPickData(pick) {
            $("#datepickerr" + pick).datepicker({dateFormat: 'dd/mm/yy'});
        }
        function clickToPicker(pick1) {

            $("#billDate" + pick1).datepicker({dateFormat: 'dd/mm/yy'});
        }
        function clickToPicker11(pick1) {

            $("#travelDateRelo" + pick1).datepicker({dateFormat: 'dd/mm/yy'});
        }
        function otherExpenseDatePic(pick1) {

            $("#otherExpenseDate" + pick1).datepicker({dateFormat: 'dd/mm/yy'});
        }
        function travelOtherExpenseDatePic(pick1) {

            $("#travelotherExpenseDate" + pick1).datepicker({dateFormat: 'dd/mm/yy'});
        }
        function reloOtherExpenseDatePic(pick1) {

            $("#travelotherExpenseDate" + pick1).datepicker({dateFormat: 'dd/mm/yy'});
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
        }</script>
    <script>
//        $(function () {
//            $("#RentAndFoodDiv").on("change", function () {
        function showOnlyOtherBox(id) {
//            alert("iiiiiiiii" + id);
            var selectedValue = document.getElementById("RentAndFoodDivRelo" + id).value;
//            alert("selectedValue" + selectedValue);
            if (selectedValue === "Other") {
                document.getElementById("purposeRelo" + id).style.display = 'block';
//                $('#otherOptionId' + id).show();
                $('#otherPurposeId').show();
            }
            else {
                document.getElementById("purposeRelo" + id).style.display = 'none';
//                $('#otherOptionId' + id).hide();
                $('#otherPurposeId').hide();
            }
        }
//            });
        //        });
        function travelAppNoAjax() {
            var travelNo = document.getElementById("travelNo").value;
            alert(travelNo);
            $.ajax({
                type: "POST",
                url: "travelRequestMaster.htm?act=getTravelDatesAjax",
                data: {"travelNo": travelNo},
                dataType: "text",
                success: function (responseTxt) {
                    var newText = responseTxt.split("~");
                    document.getElementById("travelStartDate").value = newText[0];
                    document.getElementById("travelEndDate").value = newText[1];
                },
                error: function () {
                    alert('Error occured');
                }
            });
        }


        function saveSubmit11() {
            var flag3 = true;
            var travelNo = document.getElementById("travelNo").value;
            var expenseType = document.getElementById("expenseType").value;
            var countFirst = document.getElementById("countFirst").value;
            var countFirstRelo = document.getElementById('countFirstRelo').value;
            var countSecondRelo = document.getElementById('countSecondRelo').value;
            //            alert('aa');
            if (expenseType == 'Travel') {
                //                alert("expenseType" + expenseType);

                if (travelNo == '') {
                    document.getElementById("travelNoError").innerHTML = '- Please Select Travel Request Application No.';
                    flag3 = false;
                } else {
                    document.getElementById("travelNoError").innerHTML = '';
                }


                for (var i = 1; i <= countFirst; i++) {
                    //                    alert('aa' + document.getElementById("fromCity" + i).value);
                    if (document.getElementById("fromCity" + i).value == '') {
                        document.getElementById("fromCityError" + i).innerHTML = '- It must not be empty or whitespace';
                        flag3 = false;
                    } else {
                        document.getElementById("fromCityError" + i).innerHTML = '';
                    }
                    if (document.getElementById("toCity" + i).value == '') {
                        document.getElementById("toCityError" + i).innerHTML = '- It must not be empty or whitespace';
                        flag3 = false;
                    } else {
                        document.getElementById("toCityError" + i).innerHTML = '';
                    }
                    if (document.getElementById("datepickerr" + i).value == '') {
                        document.getElementById("travelDateError" + i).innerHTML = '- It must not be empty or whitespace';
                        flag3 = false;
                    } else {
                        document.getElementById("travelDateError" + i).innerHTML = '';
                    }
                    if (document.getElementById("WorkTypeSelectId" + i).value == '') {
                        document.getElementById("WorkTypeSelectIdError" + i).innerHTML = '- It must be selected';
                        flag3 = false;
                    } else {
                        document.getElementById("WorkTypeSelectIdError" + i).innerHTML = '';
                    }
                    if (document.getElementById("amount" + i).value == '') {
                        document.getElementById("amountError" + i).innerHTML = '- It must not be empty or whitespace';
                        flag3 = false;
                    } else {
                        document.getElementById("amountError" + i).innerHTML = '';
                    }
                    if (document.getElementById("currencyTravelDivId" + i).value == '') {
                        document.getElementById("currencyTravelDivIdError" + i).innerHTML = '- It must be selected';
                        flag3 = false;
                    } else {
                        document.getElementById("currencyTravelDivIdError" + i).innerHTML = '';
                    }

                }

            } else if (expenseType == '') {
                document.getElementById("expenseTypeError").innerHTML = '- Please Select Expense Type.';
                flag3 = false;
            } else if (expenseType == 'PolicyReimbursements') {
                var policyNo = document.getElementById("policyNo").value;
                if (policyNo == '') {
                    document.getElementById("policyNoError").innerHTML = '- Please Select Policy No.';
                    flag3 = false;
                } else {
                    document.getElementById("policyNoError").innerHTML = '';
                }
            } else if (expenseType == 'Others') {
                var specify = document.getElementById("Specify").value;
                if (specify == '') {
                    document.getElementById("specifyError").innerHTML = '- It must not be empty or whitespace';
                    flag3 = false;
                } else {
                    document.getElementById("specifyError").innerHTML = '';
                }
            } else
            if (expenseType == 'Relocation') {
                for (var z = 1; z <= countFirstRelo; z++) {


                    if (document.getElementById("fromCityRelo" + z).value == '') {
                        document.getElementById("fromCityReloError" + z).innerHTML = '- It must not be empty or whitespace';
                        flag3 = false;
                    } else {
                        document.getElementById("fromCityReloError" + z).innerHTML = '';
                    }
                    if (document.getElementById("toCityRelo" + z).value == '') {
                        document.getElementById("toCityReloError" + z).innerHTML = '- It must not be empty or whitespace';
                        flag3 = false;
                    } else {
                        document.getElementById("toCityReloError" + z).innerHTML = '';
                    }
                    if (document.getElementById("datepicker" + z).value == '') {
                        document.getElementById("travelDateReloError" + z).innerHTML = '- It must not be empty or whitespace';
                        flag3 = false;
                    } else {
                        document.getElementById("travelDateReloError" + z).innerHTML = '';
                    }
                    if (document.getElementById("WorkTypeSelectRelo" + z).value == '') {
                        document.getElementById("WorkTypeSelectReloError" + z).innerHTML = '- It must be selected.';
                        flag3 = false;
                    } else {
                        document.getElementById("WorkTypeSelectReloError" + z).innerHTML = '';
                    }
                    if (document.getElementById("amountRelo" + z).value == '') {
                        document.getElementById("amountReloError" + z).innerHTML = '- It must not be empty or whitespace';
                        flag3 = false;
                    } else {
                        document.getElementById("amountReloError" + z).innerHTML = '';
                    }

                }
                for (var z = 1; z <= countSecondRelo; z++) {

                    if (document.getElementById("RentAndFoodDivRelo" + z).value == '') {
                        document.getElementById("RentAndFoodDivReloError" + z).innerHTML = '- It must be selected.';
                        flag3 = false;
                    } else {
                        document.getElementById("RentAndFoodDivReloError" + z).innerHTML = '';
                    }
                    if (document.getElementById("otherAmountRelo" + z).value == '') {
                        document.getElementById("otherAmountReloError" + z).innerHTML = '- It must not be empty or whitespace';
                        flag3 = false;
                    } else {
                        document.getElementById("otherAmountReloError" + z).innerHTML = '';
                    }

                }

            }
            //            alert("flag" + flag3)
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
    <body >
        <!--<body onload="dropDown();">-->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>EXPENSE REPORT</h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Expense Report</li>
                </ol>
            </section>
            <!-- Main content -->
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                <!--form horizontal starts here-->
                                <form:form action="expenseMaster.htm?act=saveSubmitExpenseReport" method="post" commandName="expenseMaster" name='form1' id="form1" class="form-horizontal" role="form" onsubmit='return saveSubmit11();'>

                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">Employee Detail:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId1">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun1()"><i class="fa fa-plus" id="minusId1"></i></button>
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
                                                            <input type="text" class="form-control" value="${employeeMaster.employeeId}" readonly="true">
                                                            <input type="hidden" name="empId" value="${employeeMaster.id}">
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label>Employee Name:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="text" class="form-control" value="${employeeMaster.employeeName}" readonly="true">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Designation:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="text" class="form-control" value="${employeeMaster.designationMaster.designationName}" readonly="true">
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label>Level:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="text" class="form-control" value="${employeeMaster.levelMaster.level}" readonly="true">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Department:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="text" class="form-control" value="${employeeMaster.departmentMaster.departmentName}" readonly="true">
                                                        </div>

                                                        <div class="col-sm-2">
                                                            <label>Work Location:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="text" class="form-control" value="${employeeMaster.locationMaster.location}" readonly="true">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Contact No:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control" value="${employeeMaster.contactNo2}" readonly>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label>Reporting Manager:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="text" class="form-control" value="${employeeMaster.child1}" readonly="true">
                                                            <input type="hidden" name="ApproverId1" value="${employeeMaster.reportingManagerLevel1}">
                                                            <input type="hidden" name="ApproverId2" value="${employeeMaster.reportingManagerLevel2}">
                                                        </div>
                                                        <!--<div class="col-sm-2">-->
                                                        <!--<label>Date of Form Submit:</label>-->
                                                        <!--</div>-->
                                                        <!--<div class="col-sm-4">-->
                                                        <!--<div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">-->
                                                        <%--<jsp:useBean id="now" class="java.util.Date" />--%>
                                                        <%--<fmt:formatDate type="date"  value="${now}" var="today" pattern="dd/MM/yyyy" />--%>
                                                        <form:hidden class="form-control" path="dateOfSubmit" value="" readonly="true"/>
                                                        <!--<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>-->
                                                        <!--</div>-->
                                                        <!--</div>-->
                                                    </div>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <!--Employee detail completes here-->
                                    <form:hidden path="id" />
                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">Expense Type :</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2()"><i class="fa fa-plus" id="minusId2"></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label">Expense Type:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="col-sm-7">
                                                            <!--<input type="hidden" value="$//{exo}" id="expenseTypeHidden">-->
                                                            <form:select path="expenseType" id="expenseType" class="form-control"  onchange="dropDown();">
                                                                <form:option  label="--Select--" value=""></form:option>
                                                                <form:option  label="Travel" value="Travel"></form:option>
                                                                <form:option  label="Relocation" value="Relocation"></form:option>
                                                                <form:option  label="Policy Reimbursements" value="PolicyReimbursements"></form:option>
                                                                <form:option label="Others" value="Others"></form:option>
                                                            </form:select>
                                                            <input type="hidden" name="previousExpense" id="previousExpense" value="${previousExpense}"/>
                                                            <span id="expenseTypeError" style="color: red;"></span>
                                                        </div>
                                                    </div>
                                                    <c:choose>
                                                        <c:when test="${not empty othersList}">
                                                            <div class="form-group" id="otherDivId" style="display: none">
                                                                <label class="col-sm-3 control-label">Please Specify:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <div class="col-sm-7">
                                                                    <textarea class="form-control" name="Specify" id="Specify" placeholder="(Please Specify Other Here.)" >${othersList[0].specify}</textarea>
                                                                    <span id="specifyError" style="color: red;"></span>
                                                                </div>
                                                            </div>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <div class="form-group" id="otherDivId" style="display: none">
                                                                <label class="col-sm-3 control-label">Please Specify:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <div class="col-sm-7">
                                                                    <textarea class="form-control" name="Specify" id="Specify" placeholder="(Please Specify Other Here.)"></textarea>
                                                                    <span id="specifyError" style="color: red;"></span>
                                                                </div>
                                                            </div>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <c:choose>
                                                        <c:when test="${not empty travelTypeList}">
                                                            <div class="form-group" id="applicationDivId" style="display: none">
                                                                <label class="col-sm-3 control-label">Travel Request Application No.:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <div class="col-sm-7">
                                                                    <select name="travelNo" id="travelNo" class="form-control" onchange="travelAppNoAjax();">
                                                                        <c:forEach var="travel" items="${travelNo}">
                                                                            <c:if test="${travelTypeList[0].travelApplicationNo==travel.key}">
                                                                                <option value="${travel.key}">${travel.value}</option>
                                                                                <!--<input type="text" class="form-control" name="travelNo" id="travelNo" value="${travel.value}" readonly="true">-->
                                                                            </c:if>
                                                                        </c:forEach>
                                                                    </select>
                                                                    <input type="hidden" name="travelAppId" id="travelAppId" value="${travel.key}">
                                                                    <span id="travelNoError" style="color: red;"></span></div>
                                                            </div>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <div class="form-group" id="applicationDivId" style="display: none">
                                                                <label class="col-sm-3 control-label">Travel Request Application No.:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <div class="col-sm-7">
                                                                    <select name="travelNo" id="travelNo" class="form-control" onchange="travelAppNoAjax();">
                                                                        <option value="" label="-- Select --" />
                                                                        <c:forEach var="travel" items="${travelNo}">
                                                                            <option value="${travel.key}">${travel.value}</option>
                                                                        </c:forEach>
                                                                    </select>
                                                                    <span id="travelNoError" style="color: red;"></span>
                                                                </div>
                                                            </div>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <c:choose>
                                                        <c:when test="${not empty policyOtherTypeList}">
                                                            <div class="form-group" id="policyDivId" style="display: none">
                                                                <label class="col-sm-3 control-label">Please Specify:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <div class="col-sm-7">
                                                                    <textarea class="form-control" name="policyNo" id="policyNo" >${policyOtherTypeList[0].policyNo}</textarea>
                                                                    <span id="policyNoError" style="color: red;"></span>
                                                                </div>
                                                                                        <!--<input type="text" class="form-control" name="policyNo" id="policyNo" value="${policyMap.value}" readonly="true">-->
                                                            </div>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <div class="form-group" id="policyDivId" style="display: none">
                                                                <label class="col-sm-3 control-label">Please Specify:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <div class="col-sm-7">
                                                                    <textarea class="form-control" name="policyNo" id="policyNo" ></textarea>
                                                                    <span id="policyNoError" style="color: red;"></span>
                                                                </div>
                                                            </div>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <div class="form-group" id="travelAppDateDiv_id" style="display: none">
                                                        <div class="col-sm-3" style="text-align: right">
                                                            <label>Start Date:</label>
                                                        </div>
                                                        <div class="col-sm-3" style="text-align: right">
                                                            <div class="input-group date form_datetime1" data-date-format="dd/mm/yyyy - hh:ii " data-link-field="dtp_input1">
                                                            <input type="Text" name="travelStartDate" id="travelStartDate" class="form-control" value="${expenseMaster.travelStartDate}" readonly="true">
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        </div>

                                                        <div class="col-sm-1" style="text-align: right">
                                                            <label>End Date:</label>
                                                        </div>
                                                        <div class="col-sm-3" style="text-align: right">
                                                              <div class="input-group date form_datetime1" data-date-format="dd/mm/yyyy - hh:ii " data-link-field="dtp_input1">
                                                            <input type="Text" name="travelEndDate" id="travelEndDate" class="form-control" value="${expenseMaster.travelEndDate}" readonly="true">
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                            <input type="hidden" name="travelType" id="travelType" value="">
                                                        </div>
                                                    </div>
                                                    <select id="finalCurrencyId" name="finalCurrencyId" class="form-control" style="display: none;">
                                                        <option value="">--SELECT--</option>
                                                        <c:forEach var="currency" items="${currencyMap}">
                                                            <option value="${currency.key}">${currency.value}</option>
                                                        </c:forEach>
                                                    </select>




                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <!--Travel request and type detail completes here-->

                                    <!--Attendance Regularization detail completes here-->
                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">Expense Detail:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun3()"><i class="fa fa-plus" id="minusId3"></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="table-responsive" id="travel1">
                                                        <table id="demo" class="table table-bordered table-striped table-hover" style="display: none" align="Center"  >
                                                            <tr>
                                                                <th style="text-align: center; vertical-align: middle;width: 5%">Sr.No.</th>
                                                                <th style="text-align: center; vertical-align: middle">From City</th>
                                                                <th style="text-align: center; vertical-align: middle">To City</th>
                                                                <th style="text-align: center; vertical-align: middle">Date</th>
                                                                <th style="text-align: center; vertical-align: middle">Travel By</th>
                                                                <th style="text-align: center; vertical-align: middle">Amount</th>
                                                                <th style="text-align: center; vertical-align: middle">Currency</th>
                                                                <!--<th style="text-align: center; vertical-align: middle;width: 6%">Approve</th>-->
                                                                <th style="text-align: center; vertical-align: middle;width: 7%">Add New</th>
                                                            <input type="hidden" name="TravelExpCount" value="1"/>
                                                            </tr>


                                                            <c:choose>
                                                                <c:when test="${not empty travelTypeList}">
                                                                    <c:forEach var="travelList" items="${travelTypeList}" varStatus="countVal">
                                                                        <input type="hidden" name="countFirst" id="countFirst" value="${fn:length(travelTypeList)}"/>
                                                                        <tr>
                                                                            <td style="text-align: center">${countVal.count}</td>
                                                                            <td><input type="text" name="fromCity${countVal.count}" id="fromCity${countVal.count}" class="form-control" value="${travelList.fromCity}">
                                                                                <span id="fromCityError${countVal.count}" style="color: red;"></span>
                                                                            </td>
                                                                            <td><input type="text" name="toCity${countVal.count}" id="toCity${countVal.count}" class="form-control" value="${travelList.toCity}">
                                                                                <span id="toCityError${countVal.count}" style="color: red;"></span>
                                                                            </td>
                                                                            <td>
                                                                                <!--<div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-format="dd/mm/yyyy" data-link-field="dtp_input1" style="width: 105px">-->
                                                                                <input class="form-control" size="16" type="text" id="datepickerr${countVal.count}" name="travelDate${countVal.count}" value="${travelList.date}"  style="width: 141px" onclick="clickToPickData('${countVal.count}');">
                                                                                <span id="travelDateError${countVal.count}" style="color: red;"></span>
                                                                                <!--<input class="form-control" size="16" type="text" name="travelDate${countVal.count}" id="travelDate${countVal.count}" value="${travelList.date}" readonly style="width: 98px">-->
                                                                                <!--                                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>-->
                                                                                <!--<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>-->
                                                                                <!--</div>-->
                                                                            </td>

                                                                            <td><div>

                                                                                    <select id="WorkTypeSelectId" name="WorkTypeSelect${countVal.count}" class="form-control">
                                                                                        <option value="">--SELECT--</option>
                                                                                        <c:choose>
                                                                                            <c:when test="${travelList.travelBy == 'Air'}">
                                                                                                <option value="Air" selected="selected">Air </option>
                                                                                            </c:when>
                                                                                            <c:otherwise>
                                                                                                <option value="Air">Air </option>
                                                                                            </c:otherwise>
                                                                                        </c:choose>
                                                                                        <c:choose>
                                                                                            <c:when test="${travelList.travelBy == 'Bus'}">
                                                                                                <option value="Bus" selected="selected">Bus </option>
                                                                                            </c:when>
                                                                                            <c:otherwise>
                                                                                                <option value="Bus" >Bus</option>
                                                                                            </c:otherwise>
                                                                                        </c:choose>
                                                                                        <c:choose>
                                                                                            <c:when test="${travelList.travelBy == 'Train'}">
                                                                                                <option value="Train" selected="selected">Train </option>
                                                                                            </c:when>
                                                                                            <c:otherwise>
                                                                                                <option value="Train" >Train</option>
                                                                                            </c:otherwise>
                                                                                        </c:choose>
                                                                                        <c:choose>
                                                                                            <c:when test="${travelList.travelBy == 'Cab'}">
                                                                                                <option value="Cab" selected="selected">Cab </option>
                                                                                            </c:when>
                                                                                            <c:otherwise>
                                                                                                <option value="Cab" >Cab</option>
                                                                                            </c:otherwise>
                                                                                        </c:choose>
                                                                                        <c:choose>
                                                                                            <c:when test="${travelList.travelBy == 'AutoRickshaw'}">
                                                                                                <option value="AutoRickshaw" selected="selected">Auto Rickshaw </option>
                                                                                            </c:when>
                                                                                            <c:otherwise>
                                                                                                <option value="AutoRickshaw" >Auto Rickshaw</option>
                                                                                            </c:otherwise>
                                                                                        </c:choose>


                                                                                    </select>
                                                                                </div>
                                                                                <span id="WorkTypeSelectIdError${countVal.count}" style="color: red;"></span>
                                                                            </td>
                                                                            <td><input type="text" name="amount${countVal.count}" id="amount${countVal.count}" onchange="calculateAmount(


                                                                                            );" class="form-control" value="${travelList.amount}"></td>
                                                                            <td><div>
                                                                                    <select id="currencyTravelDivId${countVal.count}" name="currencyTravelDiv${countVal.count}" class="form-control" onchange="changeAmount1(this.value


                                                                                                    );">
                                                                                        <c:forEach var="currency" items="${currencyMap}">
                                                                                            <c:choose>
                                                                                                <c:when test="${travelList.currency == currency.key}">
                                                                                                    <option value="${currency.key}" selected="selected">${currency.value}</option>
                                                                                                </c:when>
                                                                                                <c:otherwise>
                                                                                                    <option value="${currency.key}" >${currency.value}</option>
                                                                                                </c:otherwise>
                                                                                            </c:choose>
                                                                                        </c:forEach>
                                                                                    </select>
                                                                                </div>
                                                                                <span id="currencyTravelDivIdError${countVal.count}" style="color: red;"></span>
                                                                            </td>
                                                                            <!--<td style="text-align: center"><span><input type="checkbox"/></span></td>-->
                                                                            <c:if test="${countVal.last}">
                                                                                <td style="text-align: center">
                                                                                    <span style='margin-top: 5px;'>
                                                                                        <input type="button" value="+" id="addRowButtonId" />
                                                                                    </span>
                                                                                </td>
                                                                            </c:if>
                                                                        </tr>

                                                                    </c:forEach>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <tr>
                                                                        <td style="text-align: center">1</td>
                                                                        <td><input type="text" name="fromCity1" id="fromCity1" class="form-control">
                                                                            <span id="fromCityError1" style="color: red;"></span>
                                                                        </td>
                                                                        <td><input type="text" name="toCity1" id="toCity1" class="form-control">
                                                                            <span id="toCityError1" style="color: red;"></span>
                                                                        </td>
                                                                        <td>
                                                                            <input class="form-control" size="16" type="text" id="datepickerr1" name="travelDate1" value=""  style="width: 141px" onclick="clickToPickData(1);">
                                                                            <!--<div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-format="dd/mm/yyyy" data-link-field="dtp_input1" style="width: 105px">-->
                                                                            <!--<input class="form-control" size="16" type="text" name="travelDate1" id="travelDate1" value="" readonly style="width: 98px">-->
                                                                            <!--                                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>-->
                                                                            <!--<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>-->
                                                                            <!--</div>-->
                                                                            <span id="travelDateError1" style="color: red;"></span>
                                                                        </td>

                                                                        <td><div>
                                                                                <select id="WorkTypeSelectId" name="WorkTypeSelect1" class="form-control">
                                                                                    <option value="">--SELECT--</option>
                                                                                    <option value="Air">Air </option>
                                                                                    <option value="Bus">Bus</option>
                                                                                    <option value="Rail">Rail</option>
                                                                                    <option value="Cab/Taxi">Cab/Taxi</option>
                                                                                </select>
                                                                            </div>
                                                                            <span id="WorkTypeSelectIdError1" style="color: red;"></span>
                                                                        </td>
                                                                        <td><input type="text" name="amount1" id="amount1" class="form-control" onchange="calculateAmount();">
                                                                            <span id="amountError1" style="color: red;"></span>
                                                                        </td>
                                                                        <td><div>
                                                                                <select id="currencyTravelDivId1" name="currencyTravelDiv1" class="form-control" onchange="changeAmount1(this.value);">
                                                                                    <option value="">--SELECT--</option>
                                                                                    <c:forEach var="currency" items="${currencyMap}">
                                                                                        <option value="${currency.key}">${currency.value}</option>
                                                                                    </c:forEach>
                                                                                </select>
                                                                            </div>
                                                                            <span id="currencyTravelDivIdError1" style="color: red;"></span>
                                                                        </td>
                                                                        <!--<td style="text-align: center"><span><input type="checkbox"/></span></td>-->
                                                                        <td style="text-align: center">
                                                                            <span style='margin-top: 5px;'>
                                                                                <input type="button" value="+" id="addRowButtonId" />
                                                                            </span>
                                                                        </td>
                                                                    <input type="hidden" name="countFirst" id="countFirst" value="1"/>

                                                                    </tr>
                                                                </c:otherwise>
                                                            </c:choose>

                                                        </table>
                                                        <div class="">
                                                            <div class="table-responsive">
                                                                <table id="demo2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                                    <tr>
                                                                        <th style="text-align: center; vertical-align: middle;width: 5%">Sr.No.</th>
                                                                        <th style="text-align: center; vertical-align: middle;width: 12%">Date</th>
                                                                        <th style="text-align: center; vertical-align: middle">Other Expense</th>
                                                                        <th style="text-align: center; vertical-align: middle"><span id="otherPurposeId" style="display: none">Purpose</span></th>
                                                                        <th style="text-align: center; vertical-align: middle">Amount</th>
                                                                        <th style="text-align: center; vertical-align: middle">Currency</th>
                                                                        <!--<th style="text-align: center; vertical-align: middle;width: 6%">Approve</th>-->
                                                                        <th style="text-align: center; vertical-align: middle;width: 7%">Add New</th>
                                                                    <input type="hidden" name="OtherExpCount" value="1"/>
                                                                    </tr>
                                                                    <c:choose>
                                                                        <c:when test="${not empty travelOtherTypeList}">
                                                                            <c:forEach var="otherList" items="${travelOtherTypeList}" varStatus="countVal">
                                                                                <input type="hidden" name="countSecond" id="countSecond" value="${fn:length(travelOtherTypeList)}"/>
                                                                                <tr>
                                                                                    <td style="text-align: center">${countVal.count}</td>
                                                                                    <td>
                                                                                        <input class="form-control" size="16" type="text" id="travelotherExpenseDate${countVal.count}" name="travelotherExpenseDate${countVal.count}" value="${otherList.otherExpenseDate}" onclick="travelOtherExpenseDatePic('${countVal.count}');">
                                                                                        <span id="travelotherExpenseDateError${countVal.count}" style="color: red;"></span>
                                                                                    </td>
                                                                                    <td><div>
                                                                                            <select id="RentAndFoodDiv${countVal.count}" name='RentAndFoodDiv${countVal.count}' class="form-control" onchange="travelOtherBox('${countVal.count}');" >
                                                                                                <option value="">--SELECT--</option>
                                                                                                <c:choose>
                                                                                                    <c:when test="${otherList.otherExpense == 'RoomRent'}">
                                                                                                        <option value="RoomRent" selected="selected">Room Rent </option>
                                                                                                    </c:when>
                                                                                                    <c:otherwise>
                                                                                                        <option value="RoomRent" >Room Rent</option>
                                                                                                    </c:otherwise>
                                                                                                </c:choose>
                                                                                                <c:choose>
                                                                                                    <c:when test="${otherList.otherExpense == 'BreakFast'}">
                                                                                                        <option value="BreakFast" selected="selected">BreakFast </option>
                                                                                                    </c:when>
                                                                                                    <c:otherwise>
                                                                                                        <option value="BreakFast" >BreakFast</option>
                                                                                                    </c:otherwise>
                                                                                                </c:choose>
                                                                                                <c:choose>
                                                                                                    <c:when test="${otherList.otherExpense == 'Lunch'}">
                                                                                                        <option value="Lunch" selected="selected">Lunch </option>
                                                                                                    </c:when>
                                                                                                    <c:otherwise>
                                                                                                        <option value="Lunch" >Lunch</option>
                                                                                                    </c:otherwise>
                                                                                                </c:choose>
                                                                                                <c:choose>
                                                                                                    <c:when test="${otherList.otherExpense == 'Dinner'}">
                                                                                                        <option value="Dinner" selected="selected">Dinner </option>
                                                                                                    </c:when>
                                                                                                    <c:otherwise>
                                                                                                        <option value="Dinner" >Dinner</option>
                                                                                                    </c:otherwise>
                                                                                                </c:choose>
                                                                                                <c:choose>
                                                                                                    <c:when test="${otherList.otherExpense == 'Communication'}">
                                                                                                        <option value="Communication" selected="selected">Communication </option>
                                                                                                    </c:when>
                                                                                                    <c:otherwise>
                                                                                                        <option value="Communication" >Communication</option>
                                                                                                    </c:otherwise>
                                                                                                </c:choose>
                                                                                                <c:choose>
                                                                                                    <c:when test="${otherList.otherExpense == 'GuestEntertainment'}">
                                                                                                        <option class="travelGEId" value="GuestEntertainment" selected="selected">Guest Entertainment </option>
                                                                                                    </c:when>
                                                                                                    <c:otherwise>
                                                                                                        <option class="travelGEId" value="GuestEntertainment" >Guest Entertainment</option>
                                                                                                    </c:otherwise>
                                                                                                </c:choose>
                                                                                                <c:choose>
                                                                                                    <c:when test="${otherList.otherExpense == 'GoodsTransitExpense'}">
                                                                                                        <option class="RelocationGTEId" value="GoodsTransitExpense" selected="selected">Goods Transit Expense </option>
                                                                                                    </c:when>
                                                                                                    <c:otherwise>
                                                                                                        <option class="RelocationGTEId" value="GoodsTransitExpense" >Goods Transit Expense</option>
                                                                                                    </c:otherwise>
                                                                                                </c:choose>
                                                                                                <c:choose>
                                                                                                    <c:when test="${otherList.otherExpense == 'Other'}">
                                                                                                        <option value="Other" selected="selected">Other </option>
                                                                                                    </c:when>
                                                                                                    <c:otherwise>
                                                                                                        <option value="Other" >Other</option>
                                                                                                    </c:otherwise>
                                                                                                </c:choose>
                                                                                            </select>
                                                                                        </div></td>
                                                                                        <td><input type="text" name="purpose${countVal.count}" class="form-control" id="travelotherOptionId${countVal.count}" value="${otherList.expenseOtherSpecify}" style="display: none" placeholder="(Please Specify In case of Other)"></td>
                                                                                    <td><input type="text" name="otherAmount${countVal.count}" id="otherAmount${countVal.count}" onchange="calculateAmount();" class="form-control" value="${otherList.amount}"></td>
                                                                                    <td><div>
                                                                                            <select id="currencyRelocationDivId${countVal.count}" name="currencyRelocationDiv${countVal.count}" class="form-control" onchange="changeAmount1(this.value);">
                                                                                                <c:forEach var="currency" items="${currencyMap}">
                                                                                                    <c:choose>
                                                                                                        <c:when test="${otherList.currency == currency.key}">
                                                                                                            <option value="${currency.key}" selected="selected">${currency.value}</option>
                                                                                                        </c:when>
                                                                                                        <c:otherwise>
                                                                                                            <option value="${currency.key}" >${currency.value}</option>
                                                                                                        </c:otherwise>
                                                                                                    </c:choose>
                                                                                                </c:forEach>
                                                                                            </select>
                                                                                        </div></td>
                                                                                    <!--                                                                                    <td style="text-align: center">
                                                                                                                                                                            <span><input type="checkbox"/></span>
                                                                                                                                                                        </td>-->
                                                                                    <c:if test="${countVal.last}">
                                                                                        <td style="text-align: center">
                                                                                            <c:if test="${countVal.last}">
                                                                                                <span style='margin-top: 5px;'>
                                                                                                    <input type="button" value="+" id="addButtonFoodCategoryId" />
                                                                                                </span>
                                                                                            </c:if>
                                                                                        </td>
                                                                                    </c:if>
                                                                                </tr>
                                                                            </c:forEach>

                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <tr>
                                                                                <td style="text-align: center">1</td>
                                                                                <td>
                                                                                    <input class="form-control" size="16" type="text" id="travelotherExpenseDate1" name="travelotherExpenseDate1" value="" >
                                                                                    <span id="travelotherExpenseDateError1" style="color: red;"></span>
                                                                                </td>
                                                                                <td><div>
                                                                                        <select id="RentAndFoodDiv1" name='RentAndFoodDiv1' class="form-control"  onchange="travelOtherBox(1);">
                                                                                            <option value="">--SELECT--</option>
                                                                                            <option value="RoomRent">Room Rent </option>
                                                                                            <option value="BreakFast">BreakFast</option>
                                                                                            <option value="Lunch">Lunch</option>
                                                                                            <option value="Dinner">Dinner</option>
                                                                                            <option value="Communication">Communication</option>
                                                                                            <option class="travelGEId" style="display: none" value="GuestEntertainment">Guest Entertainment</option>
                                                                                            <option class="RelocationGTEId" style="display: none" value="GoodsTransitExpense">Goods Transit Expense</option>
                                                                                            <option value="Other">Other</option>
                                                                                        </select>
                                                                                    </div></td>
                                                                                <td><input type="text" name="purpose1" class="form-control" id="travelotherOptionId1" style="display: none" placeholder="(Please Specify In case of Other)"></td>
                                                                                <td><input type="text" name="otherAmount1" id="otherAmount1" class="form-control" onchange="calculateAmount();"></td>
                                                                                <td><div>
                                                                                        <select id="currencyRelocationDivId1" name="currencyRelocationDiv1" class="form-control" onchange="changeAmount1(this.value);">
                                                                                            <option value="">--SELECT--</option>
                                                                                            <c:forEach var="currency" items="${currencyMap}">
                                                                                                <option value="${currency.key}">${currency.value}</option>
                                                                                            </c:forEach>
                                                                                        </select>
                                                                                    </div></td>
                                                                                <!--                                                                                <td style="text-align: center">
                                                                                                                                                                    <span><input type="checkbox"/></span>
                                                                                                                                                                </td>-->
                                                                                <td style="text-align: center">
                                                                                    <span style='margin-top: 5px;'>
                                                                                        <input type="button" value="+" id="addButtonFoodCategoryId" />
                                                                                    </span>
                                                                                </td>
                                                                            <input type="hidden" name="countSecond" id="countSecond" value="1"/>
                                                                            </tr>
                                                                        </c:otherwise>
                                                                    </c:choose>

                                                                </table>
                                                            </div>

                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="table-responsive" id="relocation1">
                                                        <table id="demo8" class="table table-bordered table-striped table-hover" style="display: none" align="Center"  >
                                                            <tr>
                                                                <th style="text-align: center; vertical-align: middle;width: 5%">Sr.No.</th>
                                                                <th style="text-align: center; vertical-align: middle">From City <span style="color: red;font-size: 12px;">*</span></th>
                                                                <th style="text-align: center; vertical-align: middle">To City <span style="color: red;font-size: 12px;">*</span></th>
                                                                <th style="text-align: center; vertical-align: middle">Date <span style="color: red;font-size: 12px;">*</span></th>
                                                                <th style="text-align: center; vertical-align: middle">Travel By <span style="color: red;font-size: 12px;">*</span></th>
                                                                <th style="text-align: center; vertical-align: middle">Amount <span style="color: red;font-size: 12px;">*</span></th>
                                                                <th style="text-align: center; vertical-align: middle" id="currencyTravelRelo_th">Currency</th>
                                                                <!--<th style="text-align: center; vertical-align: middle;width: 6%">Approve</th>-->
                                                                <th style="text-align: center; vertical-align: middle;width: 7%">Add New</th>
                                                            <input type="hidden" name="TravelExpCount" value="1"/>
                                                            </tr>

                                                            <c:choose>
                                                                <c:when test="${not empty relocationTypeList}">
                                                                    <c:forEach var="relocationList" items="${relocationTypeList}" varStatus="countVal">
                                                                        <input type="hidden" name="countFirstRelo" id="countFirstRelo" value="${fn:length(relocationTypeList)}"/>
                                                                        <tr>
                                                                            <td style="text-align: center">${countVal.count}</td>
                                                                            <td><input type="text" name="fromCityRelo${countVal.count}" id="fromCityRelo${countVal.count}" class="form-control" value="${relocationList.fromCity}">
                                                                                <span id="fromCityReloError${countVal.count}" style="color: red;"></span>
                                                                            </td>
                                                                            <td><input type="text" name="toCityRelo${countVal.count}" id="toCityRelo${countVal.count}" class="form-control" value="${relocationList.toCity}">
                                                                                <span id="toCityReloError${countVal.count}" style="color: red;"></span>
                                                                            </td>
                                                                            <td>
                                                                                <!--<div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-format="dd/mm/yyyy" data-link-field="dtp_input1" style="width: 105px">-->
                                                                                <input class="form-control" size="16" type="text" id="travelDateRelo${countVal.count}" name="travelDateRelo${countVal.count}" value="${relocationList.date}"  style="width: 141px" onclick="clickToPicker11('${countVal.count}');">
                                                                                <span id="travelDateReloError${countVal.count}" style="color: red;"></span>
                                                                                <!--<input class="form-control" size="16" type="text" name="travelDateRelo${countVal.count}" value="${relocationList.date}" readonly style="width: 98px">-->
                                                                                <!--                                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>-->
                                                                                <!--<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>-->
                                                                                <!--</div>-->
                                                                            </td>

                                                                            <td><div>

                                                                                    <select id="WorkTypeSelectRelo${countVal.count}" name="WorkTypeSelectRelo${countVal.count}" class="form-control">
                                                                                        <option value="">--SELECT--</option>
                                                                                        <c:choose>
                                                                                            <c:when test="${relocationList.travelBy == 'Air'}">
                                                                                                <option value="Air" selected="selected">Air </option>
                                                                                            </c:when>
                                                                                            <c:otherwise>
                                                                                                <option value="Air">Air </option>
                                                                                            </c:otherwise>
                                                                                        </c:choose>
                                                                                        <c:choose>
                                                                                            <c:when test="${relocationList.travelBy == 'Bus'}">
                                                                                                <option value="Bus" selected="selected">Bus </option>
                                                                                            </c:when>
                                                                                            <c:otherwise>
                                                                                                <option value="Bus" >Bus</option>
                                                                                            </c:otherwise>
                                                                                        </c:choose>
                                                                                        <c:choose>
                                                                                            <c:when test="${relocationList.travelBy == 'Train'}">
                                                                                                <option value="Train" selected="selected">Train </option>
                                                                                            </c:when>
                                                                                            <c:otherwise>
                                                                                                <option value="Train" >Train</option>
                                                                                            </c:otherwise>
                                                                                        </c:choose>
                                                                                        <c:choose>
                                                                                            <c:when test="${relocationList.travelBy == 'Cab'}">
                                                                                                <option value="Cab" selected="selected">Cab </option>
                                                                                            </c:when>
                                                                                            <c:otherwise>
                                                                                                <option value="Cab" >Cab/Taxi</option>
                                                                                            </c:otherwise>
                                                                                        </c:choose>
                                                                                        <c:choose>
                                                                                            <c:when test="${relocationList.travelBy == 'AutoRickshaw'}">
                                                                                                <option value="AutoRickshaw" selected="selected">Auto Rickshaw </option>
                                                                                            </c:when>
                                                                                            <c:otherwise>
                                                                                                <option value="AutoRickshaw" >Auto Rickshaw</option>
                                                                                            </c:otherwise>
                                                                                        </c:choose>


                                                                                    </select>
                                                                                </div>
                                                                                <span id="WorkTypeSelectReloError${countVal.count}" style="color: red;"></span>
                                                                            </td>
                                                                            <td><input type="text" name="amountRelo${countVal.count}" id="amountRelo${countVal.count}" onchange="calculateAmount(
                                                                                            );" class="form-control" value="${relocationList.amount}">
                                                                                <span id="amountReloError${countVal.count}" style="color: red;"></span>
                                                                            </td>
                                                                            <td id="currencyTravelRelo_td${countVal.count}"><div>
                                                                                    <select id="currencyTravelDivRelo${countVal.count}" name="currencyTravelDivRelo${countVal.count}" class="form-control" onchange="changeAmount1(this.value
                                                                                                    );">
                                                                                        <c:forEach var="currency" items="${currencyMap}">
                                                                                            <c:choose>
                                                                                                <c:when test="${relocationList.currency == currency.key}">
                                                                                                    <option value="${currency.key}" selected="selected">${currency.value}</option>
                                                                                                </c:when>
                                                                                                <c:otherwise>
                                                                                                    <option value="${currency.key}" >${currency.value}</option>
                                                                                                </c:otherwise>
                                                                                            </c:choose>
                                                                                        </c:forEach>
                                                                                    </select>
                                                                                </div>
                                                                                <span id="currencyTravelDivReloError${countVal.count}" style="color: red;"></span>
                                                                            </td>
                                                                            <!--<td style="text-align: center"><span><input type="checkbox"/></span></td>-->
                                                                            <td style="text-align: center">
                                                                                <c:if test="${countVal.last}">

                                                                                    <span style='margin-top: 5px;'>
                                                                                        <input type="button" value="+" id="addRowButtonId1" />
                                                                                    </span>
                                                                                </c:if>
                                                                            </td>
                                                                        </tr>
                                                                    </c:forEach>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <tr>
                                                                        <td style="text-align: center">1</td>
                                                                        <td><input type="text" name="fromCityRelo1" id="fromCityRelo1" class="form-control">
                                                                            <span id="fromCityReloError1" style="color: red;"></span>
                                                                        </td>
                                                                        <td><input type="text" name="toCityRelo1" class="form-control">
                                                                            <span id="toCityReloError1" style="color: red;"></span>
                                                                        </td>
                                                                        <td style="text-align: center">
                                                                            <!--<div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-format="dd/mm/yyyy" data-link-field="dtp_input1" style="width: 105px">-->
                                                                            <!--<input class="form-control" size="16" type="text" name="travelDateRelo1" value="" readonly style="width: 98px">-->
                                                                            <input class="form-control" type="text" id="travelDateRelo1" name="travelDateRelo1" value=""  style="width: 141px" >
                                                                            <span id="travelDateReloError1" style="color: red;"></span>
                                                                            <!--                                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>-->
                                                                            <!--<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>-->
                                                                            <!--</div>-->
                                                                        </td>


                                                                        <td style="text-align: center"><div>
                                                                                <select id="WorkTypeSelectRelo1" name="WorkTypeSelectRelo1" class="form-control">
                                                                                    <option value="">--SELECT--</option>
                                                                                    <option value="Air">Air </option>
                                                                                    <option value="Bus">Bus</option>
                                                                                    <option value="Rail">Rail</option>
                                                                                    <option value="Cab/Taxi">Cab/Taxi</option>
                                                                                </select>
                                                                            </div>
                                                                            <span id="WorkTypeSelectReloError1" style="color: red;"></span>
                                                                        </td>
                                                                        <td><input type="text" name="amountRelo1" id="amountRelo1" class="form-control" onchange="calculateAmount(
                                                                                        );">
                                                                            <span id="amountReloError1" style="color: red;"></span>
                                                                        </td>
                                                                        <td id="currencyTravelRelo_td1"><div>
                                                                                <select id="currencyTravelDivRelo1" name="currencyTravelDivRelo1" class="form-control" onchange="changeAmount1(this.value
                                                                                                );">
                                                                                    <option value="">--SELECT--</option>
                                                                                    <c:forEach var="currency" items="${currencyMap}">
                                                                                        <option value="${currency.key}">${currency.value}</option>
                                                                                    </c:forEach>
                                                                                </select>
                                                                            </div>
                                                                            <span id="currencyTravelDivReloError1" style="color: red;"></span>
                                                                        </td>
                                                                        <!--<td style="text-align: center"><span><input type="checkbox"/></span></td>-->
                                                                        <td style="text-align: center">
                                                                            <span style='margin-top: 5px;'>
                                                                                <input type="button" value="+" id="addRowButtonId1" />
                                                                            </span>
                                                                        </td>
                                                                    </tr>
                                                                    <input type="hidden" name="countFirstRelo" id="countFirstRelo" value="1"/>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </table>
                                                        <div class="">
                                                            <div class="table-responsive">
                                                                <table id="demo9" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                                    <tr>
                                                                        <th style="text-align: center; vertical-align: middle;width: 5%">Sr.No.</th>
                                                                        <th style="text-align: center; vertical-align: middle;width: 12%">Date</th>
                                                                        <th style="text-align: center; vertical-align: middle">Other Expense <span style="color: red;font-size: 12px;">*</span></th>
                                                                        <th style="text-align: center; vertical-align: middle"><span id="otherPurposeId" style="display: none">Purpose</span></th>
                                                                        <th style="text-align: center; vertical-align: middle">Amount <span style="color: red;font-size: 12px;">*</span></th>
                                                                        <th style="text-align: center; vertical-align: middle" id="currencyRelocationDiv_th">Currency <span style="color: red;font-size: 12px;">*</span></th>
                                                                        <!--<th style="text-align: center; vertical-align: middle;width: 6%">Approve</th>-->
                                                                        <th style="text-align: center; vertical-align: middle;width: 7%">Add New</th>
                                                                    <input type="hidden" name="OtherExpCount" value="1"/>
                                                                    </tr>
                                                                    <c:choose>
                                                                        <c:when test="${not empty relocationOtherTypeList}">
                                                                            <c:forEach var="relocationOtherList" items="${relocationOtherTypeList}" varStatus="countVal">
                                                                                <input type="hidden" name="countSecondRelo" id="countSecondRelo" value="${fn:length(relocationOtherTypeList)}"/>
                                                                                <tr>
                                                                                    <td style="text-align: center">${countVal.count}</td>
                                                                                    <td>
                                                                                        <input class="form-control" size="16" type="text" id="reloOtherExpenseDate${countVal.count}" name="reloOtherExpenseDate${countVal.count}" value="${relocationOtherList.otherExpenseDate}"  onclick="reloOtherExpenseDatePic('${countVal.count}');">
                                                                                        <span id="reloOtherExpenseDateError${countVal.count}" style="color: red;"></span>
                                                                                    </td>
                                                                                    <td><div>
                                                                                            <select id="RentAndFoodDivRelo${countVal.count}" name='RentAndFoodDivRelo${countVal.count}' class="form-control" onchange="showOnlyOtherBox('${countVal.count}');">
                                                                                                <option value="">--SELECT--</option>
                                                                                                <c:choose>
                                                                                                    <c:when test="${relocationOtherList.otherExpense == 'RoomRent'}">
                                                                                                        <option value="RoomRent" selected="selected">Room Rent </option>
                                                                                                    </c:when>
                                                                                                    <c:otherwise>
                                                                                                        <option value="RoomRent" >Room Rent</option>
                                                                                                    </c:otherwise>
                                                                                                </c:choose>
                                                                                                <c:choose>
                                                                                                    <c:when test="${relocationOtherList.otherExpense == 'BreakFast'}">
                                                                                                        <option value="BreakFast" selected="selected">BreakFast </option>
                                                                                                    </c:when>
                                                                                                    <c:otherwise>
                                                                                                        <option value="BreakFast" >BreakFast</option>
                                                                                                    </c:otherwise>
                                                                                                </c:choose>
                                                                                                <c:choose>
                                                                                                    <c:when test="${relocationOtherList.otherExpense == 'Lunch'}">
                                                                                                        <option value="Lunch" selected="selected">Lunch </option>
                                                                                                    </c:when>
                                                                                                    <c:otherwise>
                                                                                                        <option value="Lunch" >Lunch</option>
                                                                                                    </c:otherwise>
                                                                                                </c:choose>
                                                                                                <c:choose>
                                                                                                    <c:when test="${relocationOtherList.otherExpense == 'Dinner'}">
                                                                                                        <option value="Dinner" selected="selected">Dinner </option>
                                                                                                    </c:when>
                                                                                                    <c:otherwise>
                                                                                                        <option value="Dinner" >Dinner</option>
                                                                                                    </c:otherwise>
                                                                                                </c:choose>
                                                                                                <c:choose>
                                                                                                    <c:when test="${relocationOtherList.otherExpense == 'Communication'}">
                                                                                                        <option value="Communication" selected="selected">Communication </option>
                                                                                                    </c:when>
                                                                                                    <c:otherwise>
                                                                                                        <option value="Communication" >Communication</option>
                                                                                                    </c:otherwise>
                                                                                                </c:choose>
                                                                                                <c:choose>
                                                                                                    <c:when test="${relocationOtherList.otherExpense == 'GuestEntertainment'}">
                                                                                                        <option class="travelGEId" value="GuestEntertainment" selected="selected">Guest Entertainment </option>
                                                                                                    </c:when>
                                                                                                    <c:otherwise>
                                                                                                        <option class="travelGEId" value="GuestEntertainment" >Guest Entertainment</option>
                                                                                                    </c:otherwise>
                                                                                                </c:choose>
                                                                                                <c:choose>
                                                                                                    <c:when test="${relocationOtherList.otherExpense == 'GoodsTransitExpense'}">
                                                                                                        <option class="RelocationGTEId" value="GoodsTransitExpense" selected="selected">Goods Transit Expense </option>
                                                                                                    </c:when>
                                                                                                    <c:otherwise>
                                                                                                        <option class="RelocationGTEId" value="GoodsTransitExpense" >Goods Transit Expense</option>
                                                                                                    </c:otherwise>
                                                                                                </c:choose>
                                                                                                <c:choose>
                                                                                                    <c:when test="${relocationOtherList.otherExpense == 'Other'}">
                                                                                                        <option value="Other" selected="selected">Other </option>
                                                                                                    </c:when>
                                                                                                    <c:otherwise>
                                                                                                        <option value="Other" >Other</option>
                                                                                                    </c:otherwise>
                                                                                                </c:choose>
                                                                                            </select>
                                                                                        </div>
                                                                                        <span id="RentAndFoodDivReloError${countVal.count}" style="color: red;"></span>
                                                                                    </td>
                                                                                    <td><input type="text" name="purposeRelo${countVal.count}" class="form-control" id="purposeRelo${countVal.count}" value="${relocationOtherList.expenseOtherSpecify}" style="display: none" placeholder="(Please Specify In case of Other)">
                                                                                        <span id="purposeReloError${countVal.count}" style="color: red;"></span>
                                                                                    </td>
                                                                                    <td><input type="text" name="otherAmountRelo${countVal.count}" id="otherAmountRelo${countVal.count}" class="form-control" value="${relocationOtherList.amount}" onchange="calculateAmount();">
                                                                                        <span id="otherAmountReloError${countVal.count}" style="color: red;"></span>
                                                                                    </td>
                                                                                    <td id="currencyRelocationDiv_td${countVal.count}"><div>
                                                                                            <select id="currencyRelocationDivRelo${countVal.count}" name="currencyRelocationDivRelo${countVal.count}" class="form-control" onchange="changeAmount1(this.value);">
                                                                                                <c:forEach var="currency" items="${currencyMap}">
                                                                                                    <c:choose>
                                                                                                        <c:when test="${relocationOtherList.currency == currency.key}">
                                                                                                            <option value="${currency.key}" selected="selected">${currency.value}</option>
                                                                                                        </c:when>
                                                                                                        <c:otherwise>
                                                                                                            <option value="${currency.key}" >${currency.value}</option>
                                                                                                        </c:otherwise>
                                                                                                    </c:choose>
                                                                                                </c:forEach>
                                                                                            </select>
                                                                                        </div>
                                                                                        <span id="currencyRelocationDivReloError${countVal.count}" style="color: red;"></span>
                                                                                    </td>
                                                                                    <!--                                                                                    <td style="text-align: center">
                                                                                                                                                                            <span><input type="checkbox"/></span>
                                                                                                                                                                        </td>-->
                                                                                    <td style="text-align: center">
                                                                                        <c:if test="${countVal.last}">
                                                                                            <span style='margin-top: 5px;'>
                                                                                                <input type="button" value="+" id="addButtonFoodCategoryId1" />
                                                                                            </span>
                                                                                        </c:if>
                                                                                    </td>
                                                                                </tr>
                                                                            </c:forEach>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <tr>
                                                                                <td style="text-align: center">1</td>
                                                                                <td>
                                                                                    <input class="form-control" size="16" type="text" id="reloOtherExpenseDate1" name="reloOtherExpenseDate1" value="" >
                                                                                    <span id="reloOtherExpenseDateError1" style="color: red;"></span>
                                                                                </td>
                                                                                <td><div>
                                                                                        <select id="RentAndFoodDivRelo1" name='RentAndFoodDivRelo1' class="form-control" onchange="showOnlyOtherBox(1);">
                                                                                            <option value="">--SELECT--</option>
                                                                                            <option value="RoomRent">Room Rent </option>
                                                                                            <option value="BreakFast">BreakFast</option>
                                                                                            <option value="Lunch">Lunch</option>
                                                                                            <option value="Dinner">Dinner</option>
                                                                                            <option value="Communication">Communication</option>
                                                                                            <option class="travelGEId" style="display: none" value="GuestEntertainment">Guest Entertainment</option>
                                                                                            <option class="RelocationGTEId" style="display: none" value="GoodsTransitExpense">Goods Transit Expense</option>
                                                                                            <option value="Other">Other</option>
                                                                                        </select>
                                                                                    </div>
                                                                                    <span id="RentAndFoodDivReloError1" style="color: red;"></span>
                                                                                </td>
                                                                                <td><input type="text" name="purposeRelo1" class="form-control" id="purposeRelo1" style="display: none" placeholder="(Please Specify In case of Other)">
                                                                                    <span id="purposeReloError1" style="color: red;"></span>
                                                                                </td>
                                                                                <td><input type="text" name="otherAmountRelo1" id="otherAmountRelo1" class="form-control" onchange="calculateAmount();">
                                                                                    <span id="otherAmountReloError1" style="color: red;"></span>
                                                                                </td>
                                                                                <td id="currencyRelocationDiv_td1"><div>
                                                                                        <select id="currencyRelocationDivRelo1" name="currencyRelocationDivRelo1" class="form-control" onchange="changeAmount1(this.value);">
                                                                                            <option value="">--SELECT--</option>
                                                                                            <c:forEach var="currency" items="${currencyMap}">
                                                                                                <option value="${currency.key}">${currency.value}</option>
                                                                                            </c:forEach>
                                                                                        </select>
                                                                                    </div>
                                                                                    <span id="currencyRelocationDivReloError1" style="color: red;"></span>
                                                                                </td>
                                                                                <!--                                                                                <td style="text-align: center">
                                                                                                                                                                    <span><input type="checkbox"/></span>
                                                                                                                                                                </td>-->
                                                                                <td style="text-align: center">
                                                                                    <span style='margin-top: 5px;'>
                                                                                        <input type="button" value="+" id="addButtonFoodCategoryId1" />
                                                                                    </span>
                                                                                </td>
                                                                            </tr>
                                                                            <input type="hidden" name="countSecondRelo" id="countSecondRelo" value="1"/>
                                                                        </c:otherwise>
                                                                    </c:choose>

                                                                </table>
                                                            </div>

                                                        </div>
                                                    </div>

                                                </div><!-- /.col -->
                                                <!--                                                <div class="form-group" style="padding-left: 100px" >
                                                                                                    <label class="col-lg-9 control-label">Sub Total:</label>
                                                                                                    <div class="col-lg-3" style="width: 19.2%">
                                                                                                        <input type="text" class="form-control" >
                                                                                                    </div>
                                                                                                </div>-->

                                                <div class="col-md-12 col-sm-12">
                                                    <div class="table-responsive" id="policy1">
                                                        <table id="demo7" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                            <tr>
                                                                <th style="text-align: center; vertical-align: middle;width: 5%">Sr.No.</th>
                                                                <th style="text-align: center; vertical-align: middle;width: 12%">Date</th>
                                                                <th style="text-align: center; vertical-align: middle">Other Expense</th>
                                                                <th style="text-align: center; vertical-align: middle"><span id="otherPurposeId" style="display: none">Purpose</span></th>
                                                                <th style="text-align: center; vertical-align: middle">Amount</th>
                                                                <th style="text-align: center; vertical-align: middle" id="policyReimbCurrency_th">Currency</th>
                                                                <!--<th style="text-align: center; vertical-align: middle;width: 6%">Approve</th>-->
                                                                <th style="text-align: center; vertical-align: middle;width: 7%">Add New</th>
                                                            <input type="hidden" name="OtherExpCount" value="1"/>
                                                            </tr>
                                                            <c:choose>
                                                                <c:when test="${not empty policyOtherTypeList}">
                                                                    <c:forEach var="policyOtherList" items="${policyOtherTypeList}" varStatus="countVal">
                                                                        <input type="hidden" name="countSecondOther" id="countSecondOther" value="${fn:length(policyOtherTypeList)}"/>
                                                                        <tr>
                                                                            <td style="text-align: center">${countVal.count}</td>
                                                                            <td>
                                                                                <input class="form-control" size="16" type="text" id="otherExpenseDate${countVal.count}" name="otherExpenseDate${countVal.count}" onclick="otherExpenseDatePic('${countVal.count}')" value="${policyOtherList.otherExpenseDate}" />
                                                                                <span id="otherExpenseDateError${countVal.count}" style="color: red;"></span>
                                                                            </td>
                                                                            <td><div>
                                                                                    <select id="RentAndFoodDivPolicy${countVal.count}" name='RentAndFoodDivPolicy${countVal.count}' class="form-control" onchange="otherEnble('${countVal.count}');">
                                                                                        <option value="">--SELECT--</option>
                                                                                        <c:choose>
                                                                                            <c:when test="${policyOtherList.otherExpense == 'RoomRent'}">
                                                                                                <option value="RoomRent" selected="selected">Room Rent </option>
                                                                                            </c:when>
                                                                                            <c:otherwise>
                                                                                                <option value="RoomRent" >Room Rent</option>
                                                                                            </c:otherwise>
                                                                                        </c:choose>
                                                                                        <c:choose>
                                                                                            <c:when test="${policyOtherList.otherExpense == 'BreakFast'}">
                                                                                                <option value="BreakFast" selected="selected">BreakFast </option>
                                                                                            </c:when>
                                                                                            <c:otherwise>
                                                                                                <option value="BreakFast" >BreakFast</option>
                                                                                            </c:otherwise>
                                                                                        </c:choose>
                                                                                        <c:choose>
                                                                                            <c:when test="${policyOtherList.otherExpense == 'Lunch'}">
                                                                                                <option value="Lunch" selected="selected">Lunch </option>
                                                                                            </c:when>
                                                                                            <c:otherwise>
                                                                                                <option value="Lunch" >Lunch</option>
                                                                                            </c:otherwise>
                                                                                        </c:choose>
                                                                                        <c:choose>
                                                                                            <c:when test="${policyOtherList.otherExpense == 'Dinner'}">
                                                                                                <option value="Dinner" selected="selected">Dinner </option>
                                                                                            </c:when>
                                                                                            <c:otherwise>
                                                                                                <option value="Dinner" >Dinner</option>
                                                                                            </c:otherwise>
                                                                                        </c:choose>
                                                                                        <c:choose>
                                                                                            <c:when test="${policyOtherList.otherExpense == 'Communication'}">
                                                                                                <option value="Communication" selected="selected">Communication </option>
                                                                                            </c:when>
                                                                                            <c:otherwise>
                                                                                                <option value="Communication" >Communication</option>
                                                                                            </c:otherwise>
                                                                                        </c:choose>
                                                                                        <c:choose>
                                                                                            <c:when test="${policyOtherList.otherExpense == 'GuestEntertainment'}">
                                                                                                <option class="travelGEId" value="GuestEntertainment" selected="selected">Guest Entertainment </option>
                                                                                            </c:when>
                                                                                            <c:otherwise>
                                                                                                <option class="travelGEId" value="GuestEntertainment" >Guest Entertainment</option>
                                                                                            </c:otherwise>
                                                                                        </c:choose>
                                                                                        <c:choose>
                                                                                            <c:when test="${policyOtherList.otherExpense == 'GoodsTransitExpense'}">
                                                                                                <option class="RelocationGTEId" value="GoodsTransitExpense" selected="selected">Goods Transit Expense </option>
                                                                                            </c:when>
                                                                                            <c:otherwise>
                                                                                                <option class="RelocationGTEId" value="GoodsTransitExpense" >Goods Transit Expense</option>
                                                                                            </c:otherwise>
                                                                                        </c:choose>
                                                                                        <c:choose>
                                                                                            <c:when test="${policyOtherList.otherExpense == 'Other'}">
                                                                                                <option value="Other" selected="selected">Other </option>
                                                                                            </c:when>
                                                                                            <c:otherwise>
                                                                                                <option value="Other" >Other</option>
                                                                                            </c:otherwise>
                                                                                        </c:choose>
                                                                                        <c:choose>
                                                                                            <c:when test="${policyOtherList.otherExpense == 'LocalTravel'}">
                                                                                                <option value="LocalTravel" id='localTravelId' style="display: none;" selected="selected">Local Travel </option>
                                                                                            </c:when>
                                                                                            <c:otherwise>
                                                                                                <option value="LocalTravel" id='localTravelId' style="display: none;">Local Travel</option>
                                                                                            </c:otherwise>
                                                                                        </c:choose>
                                                                                    </select>
                                                                                </div></td>
                                                                            <td><input type="text" name="purposePolicy${countVal.count}" class="form-control" id="purposePolicy${countVal.count}" value="${policyOtherList.expenseOtherSpecify}" style="display: none" placeholder="(Please Specify In case of Other)"></td>
                                                                            <td><input type="text" name="otherAmountPolicy${countVal.count}" id="otherAmountPolicy${countVal.count}" class="form-control" value="${policyOtherList.amount}" onchange="calculateAmount();"></td>
                                                                            <td id="policyReimbCurrency_td${countVal.count}"><div>
                                                                                    <select id="currencyRelocationDivPolicy${countVal.count}" name="currencyRelocationDivPolicy${countVal.count}" class="form-control" onchange="changeAmount1(this.value);">
                                                                                        <c:forEach var="currency" items="${currencyMap}">
                                                                                            <c:choose>
                                                                                                <c:when test="${policyOtherList.currency == currency.key}">
                                                                                                    <option value="${currency.key}" selected="selected">${currency.value}</option>
                                                                                                </c:when>
                                                                                                <c:otherwise>
                                                                                                    <option value="${currency.key}" >${currency.value}</option>
                                                                                                </c:otherwise>
                                                                                            </c:choose>
                                                                                        </c:forEach>
                                                                                    </select>
                                                                                </div></td>
                                                                            <!--                                                                            <td style="text-align: center">
                                                                                                                                                            <span><input type="checkbox"/></span>
                                                                                                                                                        </td>-->
                                                                            <td style="text-align: center">
                                                                                <c:if test="${countVal.last}">
                                                                                    <span style='margin-top: 5px;'>
                                                                                        <input type="button" value="+" id="addButtonFoodCategoryId2" />
                                                                                    </span>
                                                                                </c:if>
                                                                            </td>
                                                                        </tr>
                                                                    </c:forEach>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <tr>
                                                                        <td style="text-align: center">1</td>
                                                                        <td>
                                                                            <input class="form-control" size="16" type="text" id="otherExpenseDate1" name="otherExpenseDate1" value="" >
                                                                            <span id="otherExpenseDateError1" style="color: red;"></span>
                                                                        </td>
                                                                        <td><div>
                                                                                <select id="RentAndFoodDivPolicy1" name='RentAndFoodDivPolicy1' class="form-control" onchange="otherEnble(1);">
                                                                                    <option value="">--SELECT--</option>
                                                                                    <option value="RoomRent">Room Rent </option>
                                                                                    <option value="BreakFast">BreakFast</option>
                                                                                    <option value="Lunch">Lunch</option>
                                                                                    <option value="Dinner">Dinner</option>
                                                                                    <option value="Communication">Communication</option>
                                                                                    <option class="travelGEId" style="display: none" value="GuestEntertainment">Guest Entertainment</option>
                                                                                    <option class="RelocationGTEId" style="display: none" value="GoodsTransitExpense">Goods Transit Expense</option>
                                                                                    <option value="Other">Other</option>
                                                                                    <option value="LocalTravel" id='localTravelId' style="display: none;">Local Travel</option>
                                                                                </select>
                                                                            </div></td>
                                                                        <td><input type="text" name="purposePolicy1" class="form-control" id="purposePolicy1" style="display: none" placeholder="(Please Specify In case of Other)"></td>
                                                                        <td><input type="text" name="otherAmountPolicy1" id="otherAmountPolicy1" class="form-control" onchange="calculateAmount();"></td>
                                                                        <td id="policyReimbCurrency_td1"><div>
                                                                                <select id="currencyRelocationDivPolicy1" name="currencyRelocationDivPolicy1" class="form-control" onchange="changeAmount1(this.value);">
                                                                                    <option value="">--SELECT--</option>
                                                                                    <c:forEach var="currency" items="${currencyMap}">
                                                                                        <option value="${currency.key}">${currency.value}</option>
                                                                                    </c:forEach>
                                                                                </select>
                                                                            </div></td>

                                                                        <td style="text-align: center">
                                                                            <span style='margin-top: 5px;'>
                                                                                <input type="button" value="+" id="addButtonFoodCategoryId2" />
                                                                            </span>
                                                                        </td>
                                                                    </tr>
                                                                    <input type="hidden" name="countSecondOther" id="countSecondOther" value="1"/>
                                                                </c:otherwise>
                                                            </c:choose>

                                                        </table>
                                                    </div>

                                                </div>


                                                <div class="col-md-12 col-sm-12">
                                                    <div class="table-responsive">
                                                        <input type="hidden" id="currencyMapId" name="currencyMapId" value="${fn:length(currencyMap)}">
                                                        <table id="demo3" class="table table-bordered table-striped table-hover" style="display: none" align="Center"  >
                                                            <tr>
                                                                <th style="text-align: center; vertical-align: middle;width: 5%">Sr.No.</th>
                                                                <th style="text-align: center; vertical-align: middle">Invoice/Bill Date</th>
                                                                <th style="text-align: center; vertical-align: middle">Invoice/Bill No.</th>
                                                                <th style="text-align: center; vertical-align: middle">Amount</th>
                                                                <th style="text-align: center; vertical-align: middle" id="otherCurrency_th">Currency</th>
                                                                <!--<th style="text-align: center; vertical-align: middle;width: 6%">Approve</th>-->
                                                                <th style="text-align: center; vertical-align: middle;width: 7%">Add New</th>
                                                                <!--<input type="hidden" name="othersCount" id="othersCount" value="1"/>-->
                                                            </tr>
                                                            <c:choose>
                                                                <c:when test="${not empty othersList}">
                                                                    <c:forEach var="otherList1" items="${othersList}" varStatus="countVal">
                                                                        <input type="hidden" name="othersCount" id="othersCount" value="${fn:length(othersList)}"/>
                                                                        <tr>
                                                                            <td style="text-align: center">${countVal.count}</td>
                                                                            <td style="width: 20%">
                                                                                <input class="form-control" size="16" type="text" id="billDate${countVal.count}" name="billDate${countVal.count}" value="${otherList1.billDate}" onclick="clickToPicker('${countVal.count}');">
                                                                                <!--<div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-format="dd/mm/yyyy" data-link-field="dtp_input1">-->
                                                                                    <!--<input class="form-control" name="billDate${countVal.count}" size="16" type="text" value="${otherList1.billDate}" readonly>-->
                                                                                <!--<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>-->
                                                                                <!--</div>-->
                                                                            </td>
                                                                            <td><input type="text" name="billNo${countVal.count}" class="form-control" value="${otherList1.bilNo}"></td>
                                                                            <td><input type="text" name="policyAmount${countVal.count}" id="policyAmount${countVal.count}" class="form-control" value="${otherList1.amount}" onchange="calculateAmount();"></td>
                                                                            <td id="otherCurrency_td${countVal.count}"><div>
                                                                                    <select id="currencyOtherDiv${countVal.count}" name="otherCurrency${countVal.count}" class="form-control" onchange="changeAmount1(this.value);">
                                                                                        <c:forEach var="currency" items="${currencyMap}">
                                                                                            <c:choose>
                                                                                                <c:when test="${otherList1.currency == currency.key}">
                                                                                                    <option value="${currency.key}" selected="selected">${currency.value}</option>
                                                                                                </c:when>
                                                                                                <c:otherwise>
                                                                                                    <option value="${currency.key}" >${currency.value}</option>
                                                                                                </c:otherwise>
                                                                                            </c:choose>
                                                                                        </c:forEach>
                                                                                    </select>
                                                                                </div></td>
                                                                            <!--                                                                            <td style="text-align: center">
                                                                                                                                                            <span><input type="checkbox"/></span>
                                                                                                                                                        </td>-->
                                                                            <td style="text-align: center">
                                                                                <c:if test="${countVal.last}">
                                                                                    <span style='margin-top: 5px;'>
                                                                                        <input type="button" value="+" id="addButtonOtherTableId" />
                                                                                    </span>
                                                                                </c:if>
                                                                            </td>
                                                                        </tr>
                                                                    </c:forEach>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <tr>
                                                                        <td style="text-align: center">1</td>
                                                                        <td style="width: 20%">
                                                                            <input class="form-control" size="16" type="text" id="billDate1" name="billDate1" value="" >
                                                                            <!--                                                                            <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                                                                                                            <input class="form-control" name="billDate1" size="16" type="text" value="" readonly>
                                                                                                                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                                                                                                        </div>-->
                                                                        </td>
                                                                        <td><input type="text" name="billNo1" class="form-control"></td>
                                                                        <td><input type="text" name="policyAmount1" id="policyAmount1" class="form-control" onchange="calculateAmount(
                                                                                        );"></td>
                                                                        <td id="otherCurrency_td1"><div>
                                                                                <select id="currencyOtherDiv1" name="otherCurrency1" class="form-control" onchange="changeAmount1(this.value
                                                                                                );">
                                                                                    <c:forEach var="currency" items="${currencyMap}">
                                                                                        <option value="${currency.key}">${currency.value}</option>
                                                                                    </c:forEach>
                                                                                </select>
                                                                            </div></td>
                                                                        <!--                                                                        <td style="text-align: center">
                                                                                                                                                    <span><input type="checkbox"/></span>
                                                                                                                                                </td>-->
                                                                        <td style="text-align: center">
                                                                            <span style='margin-top: 5px;'>
                                                                                <input type="button" value="+" id="addButtonOtherTableId" />
                                                                            </span>
                                                                        </td>
                                                                    </tr>
                                                                    <input type="hidden" name="othersCount" id="othersCount" value="1"/>
                                                                </c:otherwise>
                                                            </c:choose>

                                                        </table>
                                                    </div>

                                                </div>
                                                <!--                                                <div class="form-group" style="padding-left: 100px" >
                                                                                                    <label class="col-lg-9 control-label">Sub Total:</label>
                                                                                                    <div class="col-lg-3" style="width: 19.2%">
                                                                                                        <input type="text" class="form-control" >
                                                                                                    </div>
                                                                                                </div>
                                                                                                <div class="form-group" style="padding-left: 100px" >
                                                                                                    <label class="col-lg-9 control-label">Total Expenses:</label>
                                                                                                    <div class="col-lg-3" style="width: 19.2%">
                                                                                                        <input type="text" class="form-control" >
                                                                                                    </div>
                                                                                                </div>-->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <!--Travel detail completes here-->
                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">Summary Reconciliation Detail:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun4()"><i class="fa fa-plus" id="minusId4"></i></button>
                                            </div>
                                        </div>
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <!--                                                    <div id="fill1" class=" col-sm-12" align="right">
                                                                                                            <input type="button" class="btn btn-primary" value="Fill Data" style="width: 100px;" onclick="fillData();">
                                                                                                        </div>
                                                                                                        <br/>
                                                                                                        <br/>-->
                                                    <div class="table-responsive">
                                                        <table id="demo_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >

                                                            <tr id="cell1">
                                                                <th style="text-align: left">Summary Reconciliation</th>

                                                                <c:forEach var="currency" items="${currencyMap}" varStatus="status">
                                                                <input type="hidden" id="currencyCount_${status.count}" value="${currency.key}">
                                                                <th style="text-align: center;" id="display_${currency.key}">Amount (<label id="lab_${currency.key}">${currency.value}</label>)</th>
                                                                <!--<th style="text-align: center;" id="display2">Amount (<label id="lab2"></label>)</th>-->
                                                                <!--<th style="text-align: center;" id="display3">Amount (<label id="lab3"></label>)</th>-->
                                                            </c:forEach>
                                                            </tr>
                                                            <tr id="cell2">
                                                                <td style="vertical-align: middle">Expense in this Report</td>
                                                                <c:forEach var="currency" items="${currencyMap}" varStatus="status">
                                                                    <c:set var="tempSt" value ="true"/>
                                                                    <c:forEach var="expenseReconsilationList" items="${expenseReconsilationList}" varStatus="status">
                                                                        <%--<c:choose>--%>
                                                                        <%--<c:when test="${expenseReconsilationList.currencyType == currency.key}">--%>
                                                                        <c:if test="${tempSt}">
                                                                            <c:if test="${(currency.key).toString() eq (expenseReconsilationList.currencyType).toString()}">
                                                                                <td id="displayExpense_${currency.key}" ><input type="text" name="totalAmount_${currency.key}" id="totalAmount_${currency.key}" value="${expenseReconsilationList.expenseInReport}" class="form-control" readonly="" disabled="true"/></td>
                                                                                    <c:set var="tempSt" value ="false"/>
                                                                                </c:if>

                                                                            <%--</c:when>--%>
                                                                            <%--<c:otherwise>--%>
                                                                            <c:if test="${(currency.key).toString() ne (expenseReconsilationList.currencyType).toString()}">
                                                                                <td id="displayExpense_${currency.key}" ><input type="text" name="totalAmount_${currency.key}" id="totalAmount_${currency.key}" value="0.0" class="form-control" readonly="" disabled="true"/></td>
                                                                                    <c:set var="tempSt" value ="false"/>
                                                                                </c:if>
                                                                            </c:if>

                                                                        <%--</c:otherwise>--%>
                                                                        <%--</c:choose>--%>


                                                                    </c:forEach>


                                                                </c:forEach>
                                                                <!--<td id="display2" ><input type="text"  class="form-control"/></td>-->
                                                                <!--<td id="display3" ><input type="text"  class="form-control"/></td>-->
                                                            </tr>
                                                            <tr id="cell3">
                                                                <td style="vertical-align: middle">Expense paid by Company<span style="color: red;font-size: 16px;">*</span></td>
                                                                <c:forEach var="currency" items="${currencyMap}" varStatus="status">
                                                                    <c:set var="tempSt" value ="false"/>
                                                                    <c:set var="counter" value ="0"/>
                                                                    <c:set var="counter1" value ="0"/>
                                                                    <c:forEach var="expenseReconsilationList" items="${expenseReconsilationList}" varStatus="status">
                                                                        <c:if test="${((currency.key).toString() ne (expenseReconsilationList.currencyType).toString())}">
                                                                            <c:set var="counter" value ="${counter+1}"/>
                                                                        </c:if>
                                                                        <c:set var="counter1" value ="${counter1+1}"/>
                                                                    </c:forEach>
                                                                    <c:if test="${counter == counter1}">
                                                                        <c:set var="tempSt" value ="true"/>
                                                                    </c:if>
                                                                    <c:forEach var="expenseReconsilationList" items="${expenseReconsilationList}" varStatus="status">
                                                                        <%--<c:choose>--%>
                                                                        <c:if test="${((currency.key).toString() eq (expenseReconsilationList.currencyType).toString())}">
                                                                            <c:set var="tempSt" value ="true"/>
                                                                        </c:if>
                                                                        <c:if test="${tempSt}">

                                                                            <c:if test="${(currency.key).toString() eq (expenseReconsilationList.currencyType).toString()}">

                                                                                <td id="paidByCompany_${currency.key}" ><input type="number" name="paidByCompany${currency.key}" id="paidByCompany${currency.key}" min="0" class="form-control" value="${expenseReconsilationList.expensePaid}" onchange="calculateVariance(${currency.key}
                                                                                        );"/></td>
                                                                                    <%--</c:when>--%>
                                                                                    <c:set var="tempSt" value ="false"/>
                                                                                </c:if>
                                                                                <c:if test="${(currency.key).toString() ne (expenseReconsilationList.currencyType).toString()}">

                                                                                <%--<c:otherwise>--%>
                                                                                <td id="paidByCompany_${currency.key}" ><input type="number" name="paidByCompany${currency.key}" id="paidByCompany${currency.key}" min="0" class="form-control" onchange="calculateVariance(${currency.key}
                                                                                        );"/></td>
                                                                                    <c:set var="tempSt" value ="false"/>
                                                                                </c:if>
                                                                            </c:if>
                                                                            <%--</c:otherwise>--%>

                                                                        <%--</c:choose>--%>
                                                                    </c:forEach>
                                                                </c:forEach>
                                                                <!--<td id="display2" style="display: none;"><input type="text"  class="form-control"/></td>-->
                                                                <!--<td id="display3" style="display: none;"><input type="text"  class="form-control"/></td>-->
                                                            </tr>
                                                            <tr id="cell4">
                                                                <td style="vertical-align: middle">Cash Advance<span style="color: red;font-size: 16px;">*</span></td>
                                                                <c:forEach var="currency" items="${currencyMap}" varStatus="status">
                                                                    <c:set var="tempSt" value ="false"/>
                                                                    <c:set var="counter" value ="0"/>
                                                                    <c:set var="counter1" value ="0"/>
                                                                    <c:forEach var="expenseReconsilationList" items="${expenseReconsilationList}" varStatus="status">
                                                                        <c:if test="${((currency.key).toString() ne (expenseReconsilationList.currencyType).toString())}">
                                                                            <c:set var="counter" value ="${counter+1}"/>
                                                                        </c:if>
                                                                        <c:set var="counter1" value ="${counter1+1}"/>
                                                                    </c:forEach>
                                                                    <c:if test="${counter == counter1}">
                                                                        <c:set var="tempSt" value ="true"/>
                                                                    </c:if>
                                                                    <c:forEach var="expenseReconsilationList" items="${expenseReconsilationList}" varStatus="status">
                                                                        <%--<c:choose>--%>
                                                                        <c:if test="${((currency.key).toString() eq (expenseReconsilationList.currencyType).toString())}">
                                                                            <c:set var="tempSt" value ="true"/>
                                                                        </c:if>
                                                                        <c:if test="${tempSt}">

                                                                            <c:if test="${(currency.key).toString() eq (expenseReconsilationList.currencyType).toString()}">
                                                                                <td id="advanceCash_${currency.key}" ><input type="number" name="advanceCash${currency.key}" id="advanceCash${currency.key}" min="0" class="form-control" value="${expenseReconsilationList.cashAdvance}" onchange="calculateVariance(${currency.key}
                                                                                        );"/></td>
                                                                                    <c:set var="tempSt" value ="false"/>
                                                                                </c:if>
                                                                                <%--</c:when>--%>
                                                                                <%--<c:otherwise>--%>
                                                                                <c:if test="${(currency.key).toString() ne (expenseReconsilationList.currencyType).toString()}">
                                                                                <td id="advanceCash_${currency.key}" ><input type="number" name="advanceCash${currency.key}" id="advanceCash${currency.key}" min="0" class="form-control" onchange="calculateVariance(${currency.key}
                                                                                        );"/></td>
                                                                                    <c:set var="tempSt" value ="false"/>
                                                                                </c:if>
                                                                            </c:if>

                                                                        <%--</c:otherwise>--%>
                                                                        <%--</c:choose>--%>

                                                                    </c:forEach>
                                                                </c:forEach>
                                                                <!--<td id="display2" ><input type="text"  class="form-control"/></td>-->
                                                                <!--<td id="display3" ><input type="text"  class="form-control"/></td>-->
                                                            </tr>
                                                            <tr id="cell5">
                                                                <td style="vertical-align: middle">Cash Returned<span style="color: red;font-size: 16px;">*</span></td>
                                                                <c:forEach var="currency" items="${currencyMap}" varStatus="status">
                                                                    <c:set var="tempSt" value ="false"/>
                                                                    <c:set var="counter" value ="0"/>
                                                                    <c:set var="counter1" value ="0"/>
                                                                    <c:forEach var="expenseReconsilationList" items="${expenseReconsilationList}" varStatus="status">
                                                                        <c:if test="${((currency.key).toString() ne (expenseReconsilationList.currencyType).toString())}">
                                                                            <c:set var="counter" value ="${counter+1}"/>
                                                                        </c:if>
                                                                        <c:set var="counter1" value ="${counter1+1}"/>
                                                                    </c:forEach>
                                                                    <c:if test="${counter == counter1}">
                                                                        <c:set var="tempSt" value ="true"/>
                                                                    </c:if>
                                                                    <c:forEach var="expenseReconsilationList" items="${expenseReconsilationList}" varStatus="status">
                                                                        <c:if test="${((currency.key).toString() eq (expenseReconsilationList.currencyType).toString())}">
                                                                            <c:set var="tempSt" value ="true"/>
                                                                        </c:if>

                                                                        <c:if test="${tempSt}">

                                                                            <c:if test="${(currency.key).toString() eq (expenseReconsilationList.currencyType).toString()}">

                                                                                <td id="cashReturned_${currency.key}" ><input type="number" name="cashReturned${currency.key}" id="cashReturned${currency.key}" min="0" class="form-control" value="${expenseReconsilationList.cashReturned}" onchange="calculateVariance(${currency.key}
                                                                                        );"/></td>
                                                                                    <c:set var="tempSt" value ="false"/>
                                                                                </c:if>
                                                                                <%--<c:otherwise>--%>
                                                                                <c:if test="${(currency.key).toString() ne (expenseReconsilationList.currencyType).toString()}">
                                                                                <td id="cashReturned_${currency.key}" ><input type="number" name="cashReturned${currency.key}" id="cashReturned${currency.key}" min="0" class="form-control" onchange="calculateVariance(${currency.key}
                                                                                        );" /></td>
                                                                                    <%--</c:otherwise>--%>
                                                                                    <c:set var="tempSt" value ="false"/>
                                                                                </c:if>
                                                                            </c:if>
                                                                            <%--</c:choose>--%>


                                                                    </c:forEach>
                                                                </c:forEach>
                                                                <!--<td id="display2" ><input type="text"  class="form-control"/></td>-->
                                                                <!--<td id="display3" ><input type="text"  class="form-control"/></td>-->
                                                            </tr>
                                                            <tr id="cell6">
                                                                <td style="vertical-align: middle">Variance Owed to Employee</td>
                                                                <c:forEach var="currency" items="${currencyMap}" varStatus="status">
                                                                    <c:set var="tempSt" value ="false"/>
                                                                    <c:set var="counter" value ="0"/>
                                                                    <c:set var="counter1" value ="0"/>
                                                                    <c:forEach var="expenseReconsilationList" items="${expenseReconsilationList}" varStatus="status">
                                                                        <c:if test="${((currency.key).toString() ne (expenseReconsilationList.currencyType).toString())}">
                                                                            <c:set var="counter" value ="${counter+1}"/>
                                                                        </c:if>
                                                                        <c:set var="counter1" value ="${counter1+1}"/>
                                                                    </c:forEach>
                                                                    <c:if test="${counter == counter1}">
                                                                        <c:set var="tempSt" value ="true"/>
                                                                    </c:if>
                                                                    <c:forEach var="expenseReconsilationList" items="${expenseReconsilationList}" varStatus="status">
                                                                        <c:if test="${((currency.key).toString() eq (expenseReconsilationList.currencyType).toString())}">
                                                                            <c:set var="tempSt" value ="true"/>
                                                                        </c:if>
                                                                        <c:if test="${tempSt}">
                                                                            <c:if test="${((currency.key).toString() eq (expenseReconsilationList.currencyType).toString()) and ((expenseReconsilationList.varianceOwed).toString() ne '')}">
                                                                                <td id="variance_${currency.key}" ><input type="number" name="variance${currency.key}" id="variance${currency.key}" min="0" class="form-control" value="${expenseReconsilationList.varianceOwed}" readonly=""/></td>
                                                                                    <c:set var="tempSt" value ="false"/>
                                                                                </c:if>
                                                                                <%--</c:when>--%>
                                                                                <%--<c:otherwise>--%>
                                                                                <c:if test="${((currency.key).toString() ne (expenseReconsilationList.currencyType).toString())}">

                                                                                <td id="variance_${currency.key}" ><input type="number"  name="variance${currency.key}" id="variance${currency.key}" min="0" class="form-control" readonly=""/></td>
                                                                                    <c:set var="tempSt" value ="false"/>
                                                                                </c:if>
                                                                            </c:if>
                                                                            <%--</c:otherwise>--%>
                                                                            <%--</c:choose>--%>
                                                                        </c:forEach>
                                                                    </c:forEach>
                                                                <!--<td id="display2" style="display: none;"><input type="text"  class="form-control"/></td>-->
                                                                <!--<td id="display3" style="display: none;"><input type="text"  class="form-control"/></td>-->
                                                            </tr>





                                                            <input type='hidden' id='var1' name='var1' value=''>
                                                            <input type='hidden' id='var2' name='var2' value=''>
                                                            <input type='hidden' id='var3' name='var3' value=''>
                                                            <input type='hidden' id='count11' name='count11' value='0'>
                                                            <input type='hidden' id='count12' name='count12' value='0'>
                                                        </table>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!--Travel detail completes here-->
                                    <!--                                    <div class="box box-info collapsed-box">
                                                                            <div class="box-header">
                                                                                <h3 class="box-title">Summary Reconciliation Detail:</h3>
                                                                                <div class="box-tools pull-right">
                                                                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
                                                                                </div>
                                                                            </div> /.box-header
                                                                            <div class="box-body no-padding">
                                                                                <div class="row">
                                                                                    <div class="col-md-12 col-sm-12">
                                                                                                                                            <div id="fill1" class=" col-sm-12" align="right">
                                                                                                                                                <input type="button" class="btn btn-primary" value="Fill Data" style="width: 100px;" onclick="fillData();">
                                                                                                                                            </div>
                                                                                                                                            <br/>
                                                                                                                                            <br/>
                                                                                        <div class="table-responsive">
                                                                                            <table id="demo_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >

                                                                                                <tr id="cell1">
                                                                                                    <th style="text-align: center">Summary Reconciliation</th>
                                                                                                    <th style="text-align: center">Amount (INR)</th>

                                                                                                </tr>
                                                                                                <tr id="cell2">
                                                                                                    <td style="vertical-align: middle">Expense in this Report</td>
                                                                                                    <td><input type="text"  class="form-control"/></td>
                                                                                                </tr>
                                                                                                <tr id="cell3">
                                                                                                    <td style="vertical-align: middle">Expense paid by Company</td>
                                                                                                    <td><input type="text"  class="form-control"/></td>
                                                                                                </tr>
                                                                                                <tr id="cell4">
                                                                                                    <td style="vertical-align: middle">Cash Advance</td>
                                                                                                    <td><input type="text"  class="form-control"/></td>
                                                                                                </tr>
                                                                                                <tr id="cell5">
                                                                                                    <td style="vertical-align: middle">Cash Returned</td>
                                                                                                    <td><input type="text"  class="form-control"/></td>
                                                                                                </tr>
                                                                                                <tr id="cell6">
                                                                                                    <td style="vertical-align: middle">Variance Owed to Employee</td>
                                                                                                    <td><input type="text"  class="form-control"/></td>
                                                                                                </tr>
                                                                                                <input type='hidden' id='count11' name='count11' value='0'>
                                                                                                <input type='hidden' id='count12' name='count12' value='0'>


                                                                                            </table>
                                                                                        </div>

                                                                                    </div> /.col
                                                                                </div> /.row
                                                                            </div> /.box-body
                                                                        </div>-->
                                    <!--Reason In Detail completes Here-->
                                    <div class="form-group">
                                        <div class="col-sm-6" style="text-align: left">
                                            <button type="submit" class="btn btn-warning" name="btnType" data-original-title="" title="" value="Save" style="width: 100px">SAVE</button>
                                            <!--<input type="submit" class="btn btn-success"  name="btnType" value="Save" style="width: 100px">-->
                                        </div>
                                        <!--                                        <div class="col-sm-2">
                                                                                    <input type="submit" class="btn btn-success"  name="btnType"  value="Save" style="width: 100px" onclick="saveSubmit(this.value)">
                                                                                </div>-->
                                        <div class="col-sm-6" style="text-align: right">
                                            <button type="submit" class="btn btn-primary" name="btnType" data-original-title="" title="" value="Submit" style="width: 100px">SUBMIT</button>
                                            <!--<input type="submit" class="btn btn-primary" name="btnType" value="Submit" style="width: 100px">-->
                                        </div>
                                        <!--<div class=" col-sm-3">-->
                                        <!--<input type="submit" class="btn btn-primary" name="btnType"  value="Submit" style="width: 100px" onclick="saveSubmit(this.value)">-->
                                        <!--</div>-->
                                    </div>
                                </form:form>
                                <!--form horizontal ends here-->
                            </div><!-- /.tab-content -->
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
            </section><!-- /.content -->
        </div>
    </body>
    <script type="text/javascript">
        $('.form_datetime').datetimepicker({
            language: 'fr',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        }
        );</script>
     <script type="text/javascript">
        $('.form_datetime1').datetimepicker({
            //language:  'fr',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            forceParse: 0,
            showMeridian: 1
        });</script>
        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <script>
        function calculateAmount() {
            var countFirst = document.getElementById("countFirst").value;
            var countSecond = document.getElementById("countSecond").value;
            var othersCount = document.getElementById("othersCount").value;
            var countFirstRelo = document.getElementById("countFirstRelo").value;
            var countSecondRelo = document.getElementById("countSecondRelo").value;
            var countSecondOther = document.getElementById("countSecondOther").value;
            var currencyMapId = document.getElementById("currencyMapId").value;
            var currencyRelocationDiv;
            var currencyTravelDivId;
            var currencyOtherDiv;
            var currencyRelocationDivPolicy;
            var currencyTravelDivRelo;
            var currencyRelocationDivRelo;
            var expenseType = document.getElementById("expenseType").value;
            for (var j = 1; j <= currencyMapId; j++) {

                var currencyCount = document.getElementById("currencyCount_" + j).value;
                var finalCheck = 0;
                if (expenseType === "Travel") {

                    for (var i = 1; i <= countFirst; i++) {

                        currencyTravelDivId = document.getElementById("currencyTravelDivId" + i).value;
                        try {
                            var amount = parseFloat(document.getElementById("amount" + i).value);
                            if (isNaN(amount)) {
                                amount = 0;
                            }
                            if (currencyTravelDivId === currencyCount) {
                                finalCheck += parseFloat(amount);
                            }
                        } catch (e) {
                        }

                    }

                    for (var i = 1; i <= countSecond; i++) {
                        currencyRelocationDiv = document.getElementById("currencyRelocationDivId" + i).value;
                        try {
                            var otherAmount = parseFloat(document.getElementById("otherAmount" + i).value);
                            if (isNaN(otherAmount)) {
                                otherAmount = 0;
                            }
                            if (currencyRelocationDiv === currencyCount) {
                                finalCheck += parseFloat(otherAmount);
                            }
                        } catch (e) {

                        }
                    }
                }
                //                alert(othersCount);
                if (expenseType === "Others") {
                    //                    alert("ajay");

                    for (var i = 1; i <= othersCount; i++) {
                        currencyOtherDiv = document.getElementById("currencyOtherDiv" + i).value;
                        //                        alert(currencyOtherDiv);
                        try {
                            var policyAmount = parseFloat(document.getElementById("policyAmount" + i).value);
                            //                            alert(policyAmount);
                            if (isNaN(policyAmount)) {
                                policyAmount = 0;
                            }
                            //                            alert(policyAmount + "aaa");
                            if (currencyOtherDiv === currencyCount) {
                                finalCheck += parseFloat(policyAmount);
                            }
                        } catch (e) {
                        }
                    }
                }
                //                alert(countSecondOther + "aaaaaaaaaaaaaaaaaaaaaaaaa");
                if (expenseType === "PolicyReimbursements") {
                    //
                    for (var i = 1; i <= countSecondOther; i++) {
                        currencyRelocationDivPolicy = document.getElementById("currencyRelocationDivPolicy" + i).value;
                        //                    alert(currencyRelocationDivPolicy + "wwwww");
                        try {
                            var otherAmountPolicy = parseFloat(document.getElementById("otherAmountPolicy" + i).value);
                            //                        alert(otherAmountPolicy + "qqqq");
                            if (isNaN(otherAmountPolicy)) {
                                otherAmountPolicy = 0;
                            }
                            if (currencyRelocationDivPolicy === currencyCount) {
                                finalCheck += parseFloat(otherAmountPolicy);
                            }
                        } catch (e) {
                        }
                    }
                }
                if (expenseType === "Relocation") {

                    for (var i = 1; i <= countFirstRelo; i++) {
                        currencyTravelDivRelo = document.getElementById("currencyTravelDivRelo" + i).value;
                        try {
                            var amountRelo = parseFloat(document.getElementById("amountRelo" + i).value);
                            if (isNaN(amountRelo)) {
                                amountRelo = 0;
                            }
                            if (currencyTravelDivRelo === currencyCount) {
                                finalCheck += parseFloat(amountRelo);
                            }
                        } catch (e) {
                        }
                    }
                    for (var i = 1; i <= countSecondRelo; i++) {
                        currencyRelocationDivRelo = document.getElementById("currencyRelocationDivRelo" + i).value;
                        try {
                            var otherAmountRelo = parseFloat(document.getElementById("otherAmountRelo" + i).value);
                            if (isNaN(otherAmountRelo)) {
                                otherAmountRelo = 0;
                            }
                            if (currencyRelocationDivRelo === currencyCount) {
                                finalCheck += parseFloat(otherAmountRelo);
                            }
                        } catch (e) {
                        }
                    }
                }
                document.getElementById("totalAmount_" + currencyCount).value = finalCheck;

                calculateVariance(currencyCount);
            }
        }
    </script>
    <script>
        var currency = new Array();
        function changeAmount1(val) {
            var currencyMapId = document.getElementById("currencyMapId").value;
            var expenseType = document.getElementById("expenseType").value;
            //            alert('val' + currencyMapId);
            for (var z = 1; z <= currencyMapId; z++) {
                try {

                    var currencyCount = document.getElementById("currencyCount_" + z).value;
                    //                    alert(expenseType + "   " + currencyCount);

                    document.getElementById("display_" + currencyCount).style.display = 'none';
                    document.getElementById("displayExpense_" + currencyCount).style.display = 'none';
                    document.getElementById("paidByCompany_" + currencyCount).style.display = 'none';
                    document.getElementById("advanceCash_" + currencyCount).style.display = 'none';
                    document.getElementById("cashReturned_" + currencyCount).style.display = 'none';
                    document.getElementById("variance_" + currencyCount).style.display = 'none';
                } catch (e) {

                }

            }

            var currencyTravelDiv = [];
            var currencyRelocationDiv = [];
            var currencyOtherDiv = [];
            var currencyTravelDivRelo = [];
            var currencyRelocationDivRelo = [];
            var currencyRelocationDivPolicy = [];
            var finalNew = [];
            var countFirst = document.getElementById("countFirst").value;
            var countSecond = document.getElementById("countSecond").value;
            var othersCount = document.getElementById("othersCount").value;
            var countFirstRelo = document.getElementById("countFirstRelo").value;
            var countSecondRelo = document.getElementById("countSecondRelo").value;
            var countSecondOther = document.getElementById("countSecondOther").value;
            if (expenseType === "Travel") {

                for (var i = 1; i <= countFirst; i++) {
                    try {
                        currencyTravelDiv.push(document.getElementById("currencyTravelDivId" + i).value);
                    } catch (e) {

                    }
                }
                for (var i = 1; i <= countSecond; i++) {
                    try {
                        currencyRelocationDiv.push(document.getElementById("currencyRelocationDivId" + i).value);
                    } catch (e) {

                    }

                }
            }
            if (expenseType === "Others") {
                //                alert("qqqqqqqqqqqqqqq");

                for (var i = 1; i <= othersCount; i++) {
                    try {
                        currencyOtherDiv.push(document.getElementById("currencyOtherDiv" + i).value);
                    } catch (e) {

                    }
                }
            }
            if (expenseType === "Relocation") {

                for (var i = 1; i <= countFirstRelo; i++) {
                    try {
                        currencyTravelDivRelo.push(document.getElementById("currencyTravelDivRelo" + i).value);
                    } catch (e) {

                    }
                }
                for (var i = 1; i <= countSecondRelo; i++) {
                    try {
                        currencyRelocationDivRelo.push(document.getElementById("currencyRelocationDivRelo" + i).value);
                    } catch (e) {

                    }
                }
            }
            if (expenseType === "PolicyReimbursements") {

                for (var i = 1; i <= countSecondOther; i++) {
                    try {
                        currencyRelocationDivPolicy.push(document.getElementById("currencyRelocationDivPolicy" + i).value);
                    } catch (e) {

                    }
                }
            }

            var finalArray = [];
            var otherfinalArray = [];
            var otherLastfinalArray = [];
            var otherLastfinalArray11 = [];
            otherfinalArray = currencyTravelDivRelo.concat(currencyRelocationDivRelo)
            otherLastfinalArray = otherfinalArray.concat(currencyRelocationDivPolicy)
            finalNew = currencyRelocationDiv.concat(currencyTravelDiv);
            otherLastfinalArray11 = otherLastfinalArray.concat(finalNew);
            finalArray = otherLastfinalArray11.concat(currencyOtherDiv);
            var newArrayList = [];
            finalArray.sort();
            for (i = 0; i < finalArray.length; i++) {
                if (finalArray[i] === finalArray[i + 1]) {
                    continue;
                }
                if (finalArray[i] !== 'undefined' || finalArray[i] !== null || finalArray[i] !== "") {
                    newArrayList.push(finalArray[i]);
                }
            }
            for (var j = 0; j < newArrayList.length; j++) {
                try {
                    if (newArrayList[j] !== 'undefined' || newArrayList[j] !== null || newArrayList[j] !== '') {
                        var aa = document.getElementById("display_" + newArrayList[j]);
                        document.getElementById("display_" + newArrayList[j]).style.display = '';
                        document.getElementById("totalAmount_" + newArrayList[j]).disabled = false;
                        document.getElementById("displayExpense_" + newArrayList[j]).style.display = '';
                        document.getElementById("paidByCompany_" + newArrayList[j]).style.display = '';
                        document.getElementById("advanceCash_" + newArrayList[j]).style.display = '';
                        document.getElementById("cashReturned_" + newArrayList[j]).style.display = '';
                        document.getElementById("variance_" + newArrayList[j]).style.display = '';

                        // Validation Fields Start
                        document.getElementById("paidByCompany" + newArrayList[j]).required = true;
                        document.getElementById("advanceCash" + newArrayList[j]).required = true;
                        document.getElementById("cashReturned" + newArrayList[j]).required = true;
                        // Validation Fields End
                    }

                } catch (e) {

                }
            }
            calculateAmount();
        }
    </script>
    <script>
        function calculateVariance(key) { //                alert("ajay" + key);
            var totalAmount = document.getElementById("totalAmount_" + key).value;
            if (totalAmount == '') {
                totalAmount = 0;
            }
            //                alert("totalAmount" + totalAmount);
            var paidByCompany = document.getElementById("paidByCompany" + key).value;
            if (paidByCompany == '') {
                paidByCompany = 0;
            }
            //                alert("paidByCompany" + paidByCompany);
            var advanceCash = document.getElementById("advanceCash" + key).value;
            if (advanceCash == '') {
                advanceCash = 0;
            }
            //                alert("advanceCash" + advanceCash);
            var cashReturned = document.getElementById("cashReturned" + key).value;
            if (cashReturned == '') {
                cashReturned = 0;
            }
            //                alert("cashReturned" + cashReturned);
            document.getElementById("variance" + key).value = parseFloat(totalAmount) - parseFloat(paidByCompany) - parseFloat(advanceCash) + parseFloat(cashReturned);
        }</script>

</html>
