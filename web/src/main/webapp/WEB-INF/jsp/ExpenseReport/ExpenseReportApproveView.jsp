<%--
    Document   : ExpenseReportApproveView
    Created on : 12 Dec, 2015, 4:33:39 PM
    Author     : dhruv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Expense Report</title>
        <style type="text/css" media="print">
            @page { margin: 0; }
        </style>
    </head>
    <script>

        function dropDown() {
            var selectedValue = document.getElementById("expenseType").value;
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
                    showOnlyOtherBox(i);
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
                }



            }
            else {
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
            travelAppNoAjax();
        }
    </script>

    <script>
        function travelAppNoAjax() {
            var travelNo = document.getElementById("travelNo").value;
//            alert("aa" + travelNo);
            $.ajax({
                type: "POST",
                url: "travelRequestMaster.htm?act=getTravelDatesAjax",
                data: {"travelNo": travelNo},
                dataType: "text",
                success: function (responseTxt) {
                    var newText = responseTxt.split("~");
//                    document.getElementById("travelStartDate").value = newText[0];
//                    document.getElementById("travelEndDate").value = newText[1];
                    document.getElementById("travelType").value = newText[2];

                    var countFirst = document.getElementById("countFirst").value;
                    var countSecond = document.getElementById("countSecond").value;
//                    alert(newText[2]);
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
//                    alert('Error occured');
                }
            });
        }

    </script>
    <script>
        $(document).ready(function () {

            dropDown();
        });
    </script>
    <script>
        var i1First = 1;
        var tempCountFirst = 1;
//        alert(i1);
//        alert(tempCountFirst);
        $(function () {
            $("#addRowButtonId").on("click", function () {
//                alert(i1);
                i1First = document.getElementById('countFirst').value;
                i1First++;
                tempCountFirst = document.getElementById('countFirst').value;
                tempCountFirst++;
//                alert(tempCountFirst);
                var clone = "<tr id='countFirstFile" + i1First + "' style='clear:both;'>"
                        + "<td style=\"text-align: center\">" + i1First + "</td>"
                        + "<td><input type=\"text\" name='fromCity" + tempCountFirst + "' class=\"form-control\"></td>"
                        + "<td><input type=\"text\" name='toCity" + tempCountFirst + "' class=\"form-control\"></td>"
                        + "<td>"
                        + "<input class=\"form-control\" size=\"16\" name='travelDate" + tempCountFirst + "' type=\"text\"  id=\"datepickerr" + tempCountFirst + "\" onclick=\"clickToPickData(" + tempCountFirst + ");\" style=\"width: 141px\">"
                        + "</td>"
                        + "<td><div><select id=\"WorkTypeSelectId\" name='WorkTypeSelect" + tempCountFirst + "' class=\"form-control\">"
                        + "<option value=\"\"> --SELECT-- </option>"
                        + "<option value=\"Air\"> Air </option>"
                        + "<option value =\"Train\"> Train </option>"
                        + "<option value =\"Bus\"> Bus </option>"
                        + "<option value =\"Cab\"> Cab </option>"
                        + "<option value =\"AutoRickshaw\"> Auto Rickshaw </option>"
                        + "</select>"
                        + "</div></td>"
                        + "<td><input type=\"text\" name='amount" + tempCountFirst + "' id='amount" + tempCountFirst + "' class=\"form-control\" onchange=\"calculateAmount();\"></td>"
                        + "<td><div><select id='currencyTravelDivId" + tempCountFirst + "' class=\"form-control\" name='currencyTravelDiv" + tempCountFirst + "' onchange=\"changeAmount1(this.value);\">"
                        + "</select>"
                        + "</div></td>"
//                        + "<td style=\"text-align: center\"><span></span></td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\" value=\"-\" id=\"removeRowButtonId\" onclick=\"removeChild3First('countFirstFile" + i1First + "','" + tempCountFirst + "');\">"
                        + "</span>"
                        + "</td>"
                        + "</tr>";
                document.getElementById('countFirst').value = tempCountFirst;
                $("#demo").append(clone);
                optionsAdd(tempCountFirst);
                alert("aaa");
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
        function optionsAdd(id) {
//            alert(id);
            var element2 = document.getElementById('finalCurrencyMasterId');
            var obj2 = document.getElementById("currencyTravelDivId" + id);
            for (var i2 = 0; i2 < element2.options.length; i2++) {
                var opt2 = document.createElement("option");
                opt2.value = element2.options[i2].value;
                opt2.text = element2.options[i2].text;
                obj2.appendChild(opt2);
            }
        }

        function removeChild3First(removeRowId, currentCount) {

            i1First--;
            tempCountFirst--;
//            document.getElementById('countFirst').value = tempCountFirst;
            document.getElementById('countFirst').value = i1First;
            try {

                var travelTypeId = document.getElementById("travelTypeId" + currentCount).value;
                $.ajax({
                    type: "POST",
                    url: "expenseMaster.htm?act=expenseTravelTypeMethod",
                    data: {"reloTypeId": travelTypeId},
                    dataType: "text",
                    success: function (responseTxt) {
                        //                        alert(responseTxt);
                    },
                    error: function () {
                        alert('Error occured');
                    }
                });

                var currencyTravelDivId = document.getElementById("currencyTravelDivId" + currentCount).value;
                var amount = parseFloat(document.getElementById("amount" + currentCount).value);
                var totalAmount = document.getElementById("totalAmount_" + currencyTravelDivId).value;

                var finalTotal = parseFloat(totalAmount) - parseFloat(amount);
                // Removes an element from the document
                document.getElementById("totalAmount_" + currencyTravelDivId).value = finalTotal;
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
        var i1 = 1;
        var tempCount = 1;
        $(function () {
            $("#addRowButtonId1").on("click", function () {
//                alert(i1);
                var i1 = document.getElementById('countFirstRelo').value;
                i1++;
                var tempCount = document.getElementById('countFirstRelo').value;
                tempCount++;
//                alert(tempCount);
                var clone = "<tr id='1moreFile" + i1 + "' style='clear:both;'>"
                        + "<td style=\"text-align: center\">" + i1 + "</td>"
                        + "<td><input type=\"text\" name='fromCityRelo" + tempCount + "' class=\"form-control\"></td>"
                        + "<td><input type=\"text\" name='toCityRelo" + tempCount + "' class=\"form-control\"></td>"
                        + "<td><input class=\"form-control\" size=\"16\" type=\"text\" id=\"datepicker" + tempCount + "\" name=\"travelDateRelo" + tempCount + "\" value=\"\"  style=\"width: 141px\" onclick=\"clickToPicker(" + tempCount + ");\"></td>"
                        + "<td><div><select id=\"WorkTypeSelectId\" name='WorkTypeSelectRelo" + tempCount + "' class=\"form-control\">"
                        + "<option value=\"\"> --SELECT-- </option>"
                        + "<option value=\"Air\"> Air </option>"
                        + "<option value =\"Train\"> Train </option>"
                        + "<option value =\"Bus\"> Bus </option>"
                        + "<option value =\"Cab\"> Cab </option>"
                        + "<option value =\"AutoRickshaw\"> Auto Rickshaw </option>"
                        + "</select>"
                        + "</div></td>"
                        + "<td><input type=\"text\" name='amountRelo" + tempCount + "' id='amountRelo" + tempCount + "' class=\"form-control\" onchange=\"calculateAmount();\"></td>"
                        + "<td id=\"currencyTravelRelo_td" + tempCount + "\"><div><select id='currencyTravelDivRelo" + tempCount + "' class=\"form-control\" name='currencyTravelDivRelo" + tempCount + "' onchange=\"changeAmount1(this.value);\">"
                        + "</select>"
                        + "</div></td>"
//                        + "<td style=\"text-align: center\"><span></span></td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\" value=\"-\" id=\"removeRowButtonId\" onclick=\"removeChild3FirstRelo('1moreFile" + i1 + "');\">"
                        + "</span>"
                        + "</td>"
                        + "</tr>";
                document.getElementById('countFirstRelo').value = tempCount;
                $("#demo8").append(clone);
                optionsAdd_1(tempCount);
                var selectedValue = document.getElementById("expenseType").value;
                if (selectedValue === "Relocation") {

                    var element2 = document.getElementById("currencyTravelDivRelo" + tempCount);
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
                                $("#currencyTravelDivRelo" + tempCount).children('option').hide();
                                document.getElementById("currencyTravelDivRelo" + tempCount).options[i2].selected = "true";

                            }
                        } catch (e) {

                        }
                    }
                    document.getElementById("currencyTravelRelo_td" + tempCount).style.display = 'none';
                    document.getElementById("currencyTravelRelo_th").style.display = 'none';
                }

            });
        });
//            $("#removeRowButtonId").on("click", function () {
        function optionsAdd_1(id) {
//                alert(id);
            var element2 = document.getElementById('finalCurrencyMasterId');
            var obj2 = document.getElementById("currencyTravelDivRelo" + id);
            for (var i2 = 0; i2 < element2.options.length; i2++) {
                var opt2 = document.createElement("option");
                opt2.value = element2.options[i2].value;
                opt2.text = element2.options[i2].text;
                obj2.appendChild(opt2);
            }
        }

        function removeChild3FirstRelo(removeRowId, currentCount) {
//            alert(removeRowId);

            i1--;
            try {

                var reloTypeId = document.getElementById("reloTypeId" + currentCount).value;
                $.ajax({
                    type: "POST",
                    url: "expenseMaster.htm?act=expenseTravelTypeMethod",
                    data: {"reloTypeId": reloTypeId},
                    dataType: "text",
                    success: function (responseTxt) {
                        //                        alert(responseTxt);
                    },
                    error: function () {
                        alert('Error occured');
                    }
                });
//                alert(reloTypeId);
                var currencyTravelDivId = document.getElementById("currencyTravelDivRelo" + currentCount).value;
                var amount = parseFloat(document.getElementById("amountRelo" + currentCount).value);
                var totalAmount = document.getElementById("totalAmount_" + currencyTravelDivId).value;

                var finalTotal = parseFloat(totalAmount) - parseFloat(amount);
                // Removes an element from the document
                document.getElementById("totalAmount_" + currencyTravelDivId).value = finalTotal;
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
        function otherExpenseDatePic(pick1) {

            $("#otherExpenseDate" + pick1).datepicker({dateFormat: 'dd/mm/yy'});
        }
        function travelOtherExpenseDatePic(pick1) {

            $("#travelotherExpenseDate" + pick1).datepicker({dateFormat: 'dd/mm/yy'});
        }
        function reloOtherExpenseDatePic(pick1) {

            $("#travelotherExpenseDate" + pick1).datepicker({dateFormat: 'dd/mm/yy'});
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

        function showOnlyOtherBox(id) {
            var selectedValue = document.getElementById("RentAndFoodDivRelo" + id).value;
            if (selectedValue === "Other") {
                document.getElementById("purposeRelo" + id).style.display = 'block';
                $('#otherPurposeId').show();
            }
            else {
                document.getElementById("purposeRelo" + id).style.display = 'none';
                $('#otherPurposeId').hide();
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
    </script>
    <script>
        var tempCount3Second = 1;
        $(function () { 
            $("#addButtonFoodCategoryId").on("click", function () {
//                alert(i1);
                tempCount3Second = document.getElementById('countSecond').value;
                tempCount3Second++;
//                alert(tempCount3Second);
                var clone = "<tr id='countSecondFile" + tempCount3Second + "' style='clear:both;'>"
                        + "<td style=\"text-align: center\">" + tempCount3Second + "</td>"
                        + "<td><input class='form-control' size='16' type='text' id='travelotherExpenseDate" + tempCount3Second + "' name='travelotherExpenseDate" + tempCount3Second + "' value='' onclick='travelOtherExpenseDatePic("+tempCount3Second+");'>"
                        + "<span id='travelotherExpenseDateError" + tempCount3Second + "' style='color: red;'></span>"
                        + "</td>"
                        + "<td><div><select id=\"RentAndFoodDiv" + tempCount3Second + "\" name='RentAndFoodDiv" + tempCount3Second + "' class=\"form-control\" onchange=travelOtherBox(" + tempCount3Second + ");>"
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
                        + "<td><input type=\"text\" name=\"purpose" + tempCount3Second + "\" class=\"form-control\" id=\"travelotherOptionId" + tempCount3Second + "\" style=\"display: none\" placeholder=\"(Please Specify In case of Other)\"></td>"
                        + "<td><input type=\"text\" name='otherAmount" + tempCount3Second + "' id='otherAmount" + tempCount3Second + "' class=\"form-control\" onchange=\"calculateAmount();\"></td>"
                        + "<td><div><select id='currencyRelocationDivId" + tempCount3Second + "' name='currencyRelocationDiv" + tempCount3Second + "' class=\"form-control\" onchange=\"changeAmount1(this.value);\">"
                        + "</select>"
                        + "</div></td>"
//                        + "<td style=\"text-align: center\">"
////                        + "<span><input type=\"checkbox\"/></span>"
//                        + "</td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\"value=\"-\" id=\"removeRowButtonId\" onclick=\"removeChild3Second('countSecondFile" + tempCount3Second + "','" + tempCount3Second + "');\">"
                        + "</span>"
                        + "</td>"
                        + "</tr>";
                $("#demo2").append(clone);
                document.getElementById('countSecond').value = tempCount3Second;
                optionsAdd1_2(tempCount3Second);
                   $("#travelotherExpenseDate" + tempCount3).datepicker({dateFormat: 'dd/mm/yy'});
                var expenseType = document.getElementById('expenseType').value;

                if (expenseType === "Travel") {
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
                    var element2 = document.getElementById("currencyRelocationDivId" + tempCount3Second);
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
                                $("#currencyRelocationDivId" + tempCount3Second).children('option').hide();
                                document.getElementById("currencyRelocationDivId" + tempCount3Second).options[i2].selected = "true";

                            }
                        } catch (e) {

                        }
                    }
//                                document.getElementById("otherCurrrency_th").style.display = 'none';
//                                document.getElementById("otherCurrrency_td_" + i).style.display = 'none';
//                        }

                } else {
                    $("#currencyRelocationDivId" + tempCount3Second).children('option').show();
                }

            });
        });
//            $("#removeRowButtonId").on("click", function () {
        function optionsAdd1_2(id) {
//                alert(id);
            var element2 = document.getElementById('finalCurrencyMasterId');
            var obj2 = document.getElementById("currencyRelocationDivId" + id);
            for (var i2 = 0; i2 < element2.options.length; i2++) {
                var opt2 = document.createElement("option");
                opt2.value = element2.options[i2].value;
                opt2.text = element2.options[i2].text;
                obj2.appendChild(opt2);
            }
        }

        function removeChild3Second(removeRowId, currentCount) {
//            tempCount3Second--;
//            document.getElementById('countSecond').value = tempCount3Second;
            try {
                var travelOtherId = document.getElementById("travelOtherId" + currentCount).value;
//                alert("This is Ajay" + travelOtherId);
                $.ajax({
                    type: "POST",
                    url: "expenseMaster.htm?act=relocationOrOtherExpense",
                    data: {"reloOtherId": travelOtherId},
                    dataType: "text",
                    success: function (responseTxt) {
                        //                        alert(responseTxt);
                    },
                    error: function () {
                        alert('Error occured');
                    }
                });

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
        var tempCount3 = 1;
        $(function () {
            $("#addButtonFoodCategoryId1").on("click", function () {
//                alert(i1);
                var tempCount3 = document.getElementById('countSecondRelo').value;
                tempCount3++;
//                alert(tempCount3);
                var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"
                        + "<td style=\"text-align: center\">" + tempCount3 + "</td>"
                        + "<td><input class='form-control' size='16' type='text' id='reloOtherExpenseDate" + tempCount3 + "' name='reloOtherExpenseDate" + tempCount3 + "' value=''>"
                        + "<span id='reloOtherExpenseDateError" + tempCount3 + "' style='color: red;'></span>"
                        + "</td>"
                        + "<td><div><select id=\"RentAndFoodDivRelo" + tempCount3 + "\" name='RentAndFoodDivRelo" + tempCount3 + "' class=\"form-control\" onchange=showOnlyOtherBox(" + tempCount3 + ");>"
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
                        + "<td><input type=\"text\" name=\"purposeRelo" + tempCount3 + "\" class=\"form-control\" id=\"purposeRelo" + tempCount3 + "\" style=\"display: none\" placeholder=\"(Please Specify In case of Other)\"></td>"
                        + "<td><input type=\"text\" name='otherAmountRelo" + tempCount3 + "' id='otherAmountRelo" + tempCount3 + "' class=\"form-control\" onchange=\"calculateAmount();\"></td>"
                        + "<td id=\"currencyRelocationDiv_td" + tempCount3 + "\"><div><select id='currencyRelocationDivRelo" + tempCount3 + "' name='currencyRelocationDivRelo" + tempCount3 + "' class=\"form-control\" onchange=\"changeAmount1(this.value);\">"
                        + "</select>"
                        + "</div></td>"
//                        + "<td style=\"text-align: center\">"
//                        + "<span><input type=\"checkbox\"/></span>"
//                        + "</td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\"value=\"-\" id=\"removeRowButtonId\" onclick=\"removeChild3('addmoreFile" + tempCount3 + "','" + tempCount3 + "');\">"
                        + "</span>"
                        + "</td>"
                        + "</tr>";
                $("#demo9").append(clone);
                document.getElementById('countSecondRelo').value = tempCount3;
                optionsAdd1_id(tempCount3);
                $("#reloOtherExpenseDate" + tempCount3).datepicker({dateFormat: 'dd/mm/yy'});
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
                    var element2 = document.getElementById("currencyRelocationDivRelo" + tempCount3);
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
                                $("#currencyRelocationDivRelo" + tempCount3).children('option').hide();
                                document.getElementById("currencyRelocationDivRelo" + tempCount3).options[i2].selected = "true";

                            }
                        } catch (e) {

                        }
                    }
                    document.getElementById("currencyRelocationDiv_td" + tempCount3).style.display = 'none';
                    document.getElementById("currencyRelocationDiv_th").style.display = 'none';
                }

            });
        });
//            $("#removeRowButtonId").on("click", function () {
        function optionsAdd1_id(id) {
//                alert(id);
            var element2 = document.getElementById('finalCurrencyMasterId');
            var obj2 = document.getElementById("currencyRelocationDivRelo" + id);
            for (var i2 = 0; i2 < element2.options.length; i2++) {
                var opt2 = document.createElement("option");
                opt2.value = element2.options[i2].value;
                opt2.text = element2.options[i2].text;
                obj2.appendChild(opt2);
            }
        }

        function removeChild3(removeRowId, currentCount) {
//            alert("ajay" + currentCount);
            tempCount3--;

            try {

                var reloOtherId = document.getElementById("reloOtherId" + currentCount).value;

                $.ajax({
                    type: "POST",
                    url: "expenseMaster.htm?act=relocationOrOtherExpense",
                    data: {"reloOtherId": reloOtherId},
                    dataType: "text",
                    success: function (responseTxt) {
                        //                        alert(responseTxt);
                    },
                    error: function () {
                        alert('Error occured');
                    }
                });
//                alert(reloOtherId);
                var currencyTravelDivId = document.getElementById("currencyRelocationDivRelo" + currentCount).value;
                var amount = parseFloat(document.getElementById("otherAmountRelo" + currentCount).value);
                var totalAmount = document.getElementById("totalAmount_" + currencyTravelDivId).value;

                var finalTotal = parseFloat(totalAmount) - parseFloat(amount);
                // Removes an element from the document
                document.getElementById("totalAmount_" + currencyTravelDivId).value = finalTotal;
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
        var tempCount3 = 1;
        $(function () {
            $("#addButtonFoodCategoryId2").on("click", function () {
//                alert(i1);
                tempCount3 = document.getElementById('countSecondOther').value;
                tempCount3++;
//                alert(tempCount3);
                var clone = "<tr id='addmoreSecondOtherFile" + tempCount3 + "' style='clear:both;'>"
                        + "<td style=\"text-align: center\">" + tempCount3 + "</td>"
                        + "<td><input class='form-control' size='16' type='text' id='otherExpenseDate" + tempCount3 + "' name='otherExpenseDate" + tempCount3 + "' onclick='otherExpenseDatePic(" + tempCount3 + ")' value=''>"
                        + "<span id='otherExpenseDateError" + tempCount3 + "' style='color: red;'></span>"
                        + "</td>"
                        + "<td><div><select id=\"RentAndFoodDivPolicy" + tempCount3 + "\" name='RentAndFoodDivPolicy" + tempCount3 + "' class=\"form-control\" onchange=otherEnble(" + tempCount3 + ");>"
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
                        + "<td><input type=\"text\" name=\"purposePolicy" + tempCount3 + "\" class=\"form-control\" id=\"purposePolicy" + tempCount3 + "\" style=\"display: none\" placeholder=\"(Please Specify In case of Other)\"></td>"
                        + "<td><input type=\"text\" name='otherAmountPolicy" + tempCount3 + "' id='otherAmountPolicy" + tempCount3 + "' class=\"form-control\" onchange=\"calculateAmount();\"></td>"
                        + "<td id=\"policyReimbCurrency_td" + tempCount3 + "\"><div><select id='currencyRelocationDivPolicy" + tempCount3 + "' name='currencyRelocationDivPolicy" + tempCount3 + "' class=\"form-control\" onchange=\"changeAmount1(this.value);\">"
                        + "</select>"
                        + "</div></td>"
//                        + "<td style=\"text-align: center\">"
//                        + "<span><input type=\"checkbox\"/></span>"
//                        + "</td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\"value=\"-\" id=\"removeRowButtonId\" onclick=\"removeChild3SecondOther('addmoreSecondOtherFile" + tempCount3 + "','" + tempCount3 + "');\">"
                        + "</span>"
                        + "</td>"
                        + "</tr>";
                $("#demo7").append(clone);
                document.getElementById('countSecondOther').value = tempCount3;
                optionsAdd1(tempCount3);
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
                    var element2 = document.getElementById("currencyRelocationDivPolicy" + tempCount3);
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
                                $("#currencyRelocationDivPolicy" + tempCount3).children('option').hide();
                                document.getElementById("currencyRelocationDivPolicy" + tempCount3).options[i2].selected = "true";

                            }
                        } catch (e) {

                        }
                    }
                    document.getElementById("policyReimbCurrency_td" + tempCount3).style.display = 'none';
                    document.getElementById("policyReimbCurrency_th").style.display = 'none';
                }

            });
        });
//            $("#removeRowButtonId").on("click", function () {
        function optionsAdd1(id) {
//                alert(id);
            var element2 = document.getElementById('finalCurrencyMasterId');
            var obj2 = document.getElementById("currencyRelocationDivPolicy" + id);
            for (var i2 = 0; i2 < element2.options.length; i2++) {
                var opt2 = document.createElement("option");
                opt2.value = element2.options[i2].value;
                opt2.text = element2.options[i2].text;
                obj2.appendChild(opt2);
            }
        }

        function removeChild3SecondOther(removeRowId, currentCount) {
            tempCount3--;

            try {

                var policyOtherId = document.getElementById("policyOtherId" + currentCount).value;
                $.ajax({
                    type: "POST",
                    url: "expenseMaster.htm?act=relocationOrOtherExpense",
                    data: {"reloOtherId": policyOtherId},
                    dataType: "text",
                    success: function (responseTxt) {
                        //                        alert(responseTxt);
                    },
                    error: function () {
                        alert('Error occured');
                    }
                });

                var currencyTravelDivId = document.getElementById("currencyRelocationDivPolicy" + currentCount).value;
                var amount = parseFloat(document.getElementById("otherAmountPolicy" + currentCount).value);
                var totalAmount = document.getElementById("totalAmount_" + currencyTravelDivId).value;

                var finalTotal = parseFloat(totalAmount) - parseFloat(amount);
                // Removes an element from the document
                document.getElementById("totalAmount_" + currencyTravelDivId).value = finalTotal;
            } catch (e) {

            }


            // Removes an element from the document
            var element = document.getElementById(removeRowId);
            element.parentNode.removeChild(element);
//            });
        }


    </script>

    <script>
        var i3 = 1;
        tempCountOther = 1;
        $(function () {
            $("#addButtonOtherTableId").on("click", function () {
                i3 = document.getElementById('othersCount').value;
                i3++;
                tempCountOther = document.getElementById('othersCount').value;
                tempCountOther++;
                var clone3 = "<tr id='addmoreOhterFile" + i3 + "' style='clear:both;'>"
                        + "<td style=\"text-align: center\">" + i3 + "</td>"
//                        + "<td style=\"width: 20%\"><div class=\"input-group date form_datetime\" data-date-format=\"dd/mm/yyyy\" data-link-format=\"dd/mm/yyyy\" data-link-field=\"dtp_input1\">"
//                        + "<input class=\"form-control\" name='billDate" + tempCountOther + "' size=\"16\" type=\"text\" value=\"\" readonly>"
//                        + "<span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-th\"></span></span>"
//                        + "</div></td>"
                        + "<td style=\"width: 20%\">"
                        + "<input class=\"form-control\" size=\"16\" type=\"text\" id=\"datepickerr" + tempCountOther + "\" name='billDate" + tempCountOther + "' value=\"\"  style=\"width: 141px;\" onclick=\"clickToPickData('" + tempCountOther + "');\">"
                        + "</td>"
                        + "<td><input type=\"text\" name='billNo" + tempCountOther + "' class=\"form-control\"></td>"
                        + "<td><input type=\"text\" name='policyAmount" + tempCountOther + "' id='policyAmount" + tempCountOther + "' class=\"form-control\" onchange=\"calculateAmount();\"></td>"
                        + "<td id=\"otherCurrency_td" + tempCountOther + "\"><div>"
                        + "<select id='currencyOtherDiv" + tempCountOther + "' name='otherCurrency" + tempCountOther + "' class=\"form-control\" onchange=\"changeAmount1(this.value);\">"
                        + "</select>"
                        + "</div></td>"
//                        + "<td style=\"text-align: center\"><span></span></td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\"value=\"-\" id=\"removeRowButtonId\" onclick=\"removeChild3Other('addmoreOhterFile" + i3 + "');\">"
                        + "</span>"
                        + "</td>"
                        + "</tr>"
                $("#demo3").append(clone3);
                optionsAdd2(tempCountOther);
//                alert(tempCountOther);
                document.getElementById('othersCount').value = tempCountOther;
//                alert("1");
                var element2 = document.getElementById("currencyOtherDiv" + tempCountOther);
//                alert("2");
                for (var i2 = 0; i2 < element2.options.length; i2++) {
                    var currencyVal = element2.options[i2].value;
//                    alert("currencyVal" + currencyVal);
                    var currencyText = element2.options[i2].text;
                    try {
                        currencyText = currencyText.split('(');
                        var currencyText11 = currencyText[1];
//                                alert("currencyText11" + currencyText11);
                        currencyText11 = currencyText11.split(')');
                        if (currencyText11[0] === 'INR') {
//                            alert("currencyText" + currencyText11[0]);
                            $("#currencyOtherDiv" + tempCountOther).children('option').hide();
                            document.getElementById("currencyOtherDiv" + tempCountOther).options[i2].selected = "true";

                        }
                    } catch (e) {

                    }
                }
//                alert("otherCurrency_td" + tempCountOther);
                document.getElementById("otherCurrency_td" + tempCountOther).style.display = 'none';
                document.getElementById("otherCurrency_th").style.display = 'none';
            });
        });
        function optionsAdd2(id) {
//            alert("hiiii" + id);
            var element2 = document.getElementById('finalCurrencyMasterId');
//            alert("hi111111");
            var obj2 = document.getElementById("currencyOtherDiv" + id);
//            alert("hi2222" + element2.options.length);
            for (var i2 = 0; i2 < element2.options.length; i2++) {
                var opt2 = document.createElement("option");
                opt2.value = element2.options[i2].value;
                opt2.text = element2.options[i2].text;
                obj2.appendChild(opt2);
            }
        }

        function removeChild3Other(removeRowId, currentCount) {
            i3--;
            tempCountOther--;
//            document.getElementById('othersCount').value = i3;
//            document.getElementById('othersCount').value = tempCountOther;

            try {

                var otherListId = document.getElementById("otherListId" + currentCount).value;
                $.ajax({
                    type: "POST",
                    url: "expenseMaster.htm?act=expenseOtherTypeMethod",
                    data: {"otherListId": otherListId},
                    dataType: "text",
                    success: function (responseTxt) {
                        //                        alert(responseTxt);
                    },
                    error: function () {
                        alert('Error occured');
                    }
                });

                var currencyOtherDiv = document.getElementById("currencyOtherDiv" + currentCount).value;
                var otherAmount = parseFloat(document.getElementById("policyAmount" + currentCount).value);
                var totalAmount = document.getElementById("totalAmount_" + currencyOtherDiv).value;

                var finalTotal = parseFloat(totalAmount) - parseFloat(otherAmount);
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

            $("#datepicker" + pick1).datepicker({dateFormat: 'dd/mm/yy'});
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



        function saveSubmit11() {
            var flag3 = true;
            var travelNo = document.getElementById("travelNo").value;
            var expenseType = document.getElementById("expenseType").value;
//            alert('aa' + expenseType);
            if (expenseType == 'Travel') {

                if (travelNo == '') {
                    document.getElementById("travelNoError").innerHTML = '- Please Select Travel Request Application No.';
                    flag3 = false;
                } else {
                    document.getElementById("travelNoError").innerHTML = '';
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
                //                var specify = document.getElementById("Specify").value = '';
                if (specify == '') {
                    document.getElementById("specifyError").innerHTML = '- It must not be empty or whitespace';
                    flag3 = false;
                } else {
                    document.getElementById("specifyError").innerHTML = '';
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


        function exportToPdf(id) {
//            alert(id);
            window.location = 'expenseMaster.htm?act=exportToPdfExpenseReport&id=' + id;

        }

    </script>




    <!--<body onload="dropDown();">-->
    <body>
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
                            <!--<button class="btn btn-success" id="" name="" style="margin-left: 11px;" tabindex="" ></button>-->
                            <div style="text-align: right;padding-right: 5px;padding-top: 5px;">
                                <a href="expenseMaster.htm?act=exportToPdfExpenseReport&id=${expenseId}" class="btn btn-success" target="_blank">Print</a>
                            </div>
                            <div class="tab-content">
                                <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                <!--form horizontal starts here-->
                                <form:form action="expenseMaster.htm?act=returnSubmitExpenseReport" method="post" commandName="expenseMaster" name='form1' id="form1" class="form-horizontal" role="form" onsubmit='return saveSubmit11();'>

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
                                                        <fmt:formatDate type="date"  value="${now}" var="today" pattern="dd/MM/yyyy" />
                                                        <form:hidden class="form-control" path="dateOfSubmit" value="${today}" readonly="true"/>
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
                                    <div style="display: none">
                                        <select id="finalCurrencyMasterId" name="finalCurrencyMasterId" class="form-control" onchange="changeAmount1(this.value);">
                                            <option value="">---Select---</option>
                                            <c:forEach var="currency" items="${currencyMap}">
                                                <option value="${currency.key}">${currency.value}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

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
                                                            <c:choose>
                                                                <c:when test="${expenseMaster.status!=1}">
                                                                    <form:select path="expenseType" id="expenseType" class="form-control"  onchange="dropDown();" disabled="true">
                                                                        <form:option  label="--Select--" value=""></form:option>
                                                                        <form:option  label="Travel" value="Travel"></form:option>
                                                                        <form:option  label="Relocation" value="Relocation"></form:option>
                                                                        <form:option  label="Policy Reimbursements" value="PolicyReimbursements"></form:option>
                                                                        <form:option label="Others" value="Others"></form:option>
                                                                    </form:select>
                                                                    <span id="expenseTypeError" style="color: red;"></span>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <form:select path="expenseType" id="expenseType" class="form-control"  onchange="dropDown();">
                                                                        <form:option  label="--Select--" value=""></form:option>
                                                                        <form:option  label="Travel" value="Travel"></form:option>
                                                                        <form:option  label="Relocation" value="Relocation"></form:option>
                                                                        <form:option  label="Policy Reimbursements" value="PolicyReimbursements"></form:option>
                                                                        <form:option label="Others" value="Others"></form:option>
                                                                            <span id="expenseTypeError" style="color: red;"></span>
                                                                    </form:select>
                                                                </c:otherwise>
                                                            </c:choose>

                                                            <input type="hidden" name="previousExpense" id="previousExpense" value="${previousExpense}"/>
                                                        </div>
                                                    </div>
                                                    <c:choose>
                                                        <c:when test="${not empty othersList}">
                                                            <div class="form-group" id="otherDivId" style="display: none">
                                                                <label class="col-sm-3 control-label">Please Specify:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <div class="col-sm-7">
                                                                    <textarea class="form-control" name="Specify" placeholder="(Please Specify Other Here.)" readonly="true">${othersList[0].specify}</textarea>
                                                                    <span id="specifyError" style="color: red;"></span>
                                                                </div>
                                                            </div>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <div class="form-group" id="otherDivId" style="display: none">
                                                                <label class="col-sm-3 control-label">Please Specify:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <div class="col-sm-7">
                                                                    <textarea class="form-control" name="Specify" placeholder="(Please Specify Other Here.)"></textarea>
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
                                                                        <!--<option value="" label="-- Select --" />-->
                                                                        <c:forEach var="travel" items="${travelNo}">
                                                                            <c:if test="${travelTypeList[0].travelApplicationNo==travel.key}">

                                                                                <option value="${travel.key}">${travel.value}</option>
                                                                            </c:if>
                                                                        </c:forEach>
                                                                    </select>
                                                                    <%--<c:forEach var="travel" items="${travelNo}">--%>

     <!--<input type="text" class="form-control" name="travelNo" id="travelNo" value="${travel.value}" readonly="true">-->
                                                                    <%--</c:if>--%>
                                                                    <%--</c:forEach>--%>
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
                                                                <th style="text-align: center; vertical-align: middle">Mode of Travel</th>
                                                                <th style="text-align: center; vertical-align: middle">Amount</th>
                                                                <th style="text-align: center; vertical-align: middle">Currency</th>
                                                                <!--<th style="text-align: center; vertical-align: middle;width: 6%">Approve</th>-->
                                                                <th style="text-align: center; vertical-align: middle;width: 7%"><c:if test="${expenseMaster.status ne 0}">
                                                                        <%--<c:if test="${countVal.last}">--%>
                                                                        <!--<td style="text-align: center">-->
                                                                        <span style='margin-top: 5px;'>
                                                                            <c:if test="${flag1 ne true }">
                                                                                <input type="button" value="+" id="addRowButtonId" title="Add New" />
                                                                            </c:if>
                                                                        </span>
                                                                        <!--</td>-->
                                                                        <%--</c:if>--%>
                                                                    </c:if></th>
                                                            <input type="hidden" name="TravelExpCount" value="1"/>
                                                            </tr>


                                                            <c:choose>
                                                                <c:when test="${not empty travelTypeList}">
                                                                    <c:forEach var="travelList" items="${travelTypeList}" varStatus="countVal">
                                                                        <input type="hidden" name="countFirst" id="countFirst" value="${fn:length(travelTypeList)}"/>
                                                                        <input type="hidden" name="travelTypeId${countVal.count}" id="travelTypeId${countVal.count}" value="${travelList.id}"/>
                                                                        <input type="hidden" name="travelTypeStatus${countVal.count}" id="travelTypeStatus${countVal.count}" value="${travelList.status}"/>
                                                                        <tr id="countFirstFile${countVal.count}">
                                                                            <td style="text-align: center">${countVal.count}</td>
                                                                            <td><input type="text" name="fromCity${countVal.count}" class="form-control" value="${travelList.fromCity}" <c:if test="${travelList.status==1}">readonly="true"</c:if>></td>
                                                                            <td><input type="text" name="toCity${countVal.count}" class="form-control" value="${travelList.toCity}" <c:if test="${travelList.status==1}">readonly="true"</c:if>></td>
                                                                                <td>
                                                                                    <input class="form-control" size="16" type="text" id="datepickerr${countVal.count}" name="travelDate${countVal.count}" value="${travelList.date}"  style="width: 141px" <c:if test="${travelList.status==1}">readonly="true"</c:if> onclick="clickToPickData('${countVal.count}');">
                                                                                    <!--<input class="form-control" size="16" type="date" name="travelDate${countVal.count}" value="${travelList.date}"  <c:if test="${travelList.status==1}">readonly="true"</c:if> style="width: 141px">-->
                                                                                    <!--                                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>-->
                                                                                </td>

                                                                                <td><div>

                                                                                        <select id="WorkTypeSelectId" name="WorkTypeSelect${countVal.count}" class="form-control" <c:if test="${travelList.status == 1}"> disabled="true"</c:if>>
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
                                                                                                <option value="Cab" selected="selected">Cab</option>
                                                                                            </c:when>
                                                                                            <c:otherwise>
                                                                                                <option value="Cab" >Cab</option>
                                                                                            </c:otherwise>
                                                                                        </c:choose>
                                                                                        <c:choose>
                                                                                            <c:when test="${travelList.travelBy == 'AutoRickshaw'}">
                                                                                                <option value="AutoRickshaw" selected="selected">Auto Rickshaw</option>
                                                                                            </c:when>
                                                                                            <c:otherwise>
                                                                                                <option value="AutoRickshaw" >Auto Rickshaw</option>
                                                                                            </c:otherwise>
                                                                                        </c:choose>


                                                                                    </select>
                                                                                </div></td>
                                                                            <td><input type="text" name="amount${countVal.count}" id="amount${countVal.count}" class="form-control" value="${travelList.amount}" <c:if test="${travelList.status==1}">readonly="true"</c:if> onchange="calculateAmount();"></td>
                                                                                <td><div>
                                                                                        <select id="currencyTravelDivId${countVal.count}" name="currencyTravelDiv${countVal.count}" class="form-control" onchange="changeAmount1(this.value);" <c:if test="${travelList.status==1}">readonly="true" disabled="true"</c:if>>
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
                                                                                </div></td>
                                                                            <td style="text-align: center">
                                                                                <c:if test="${travelList.status==1}"><span class="glyphicon glyphicon-ok" title="Approved" style="font-size: 20px; color: green;"></span>
                                                                                </c:if>
                                                                                <c:if test="${expenseMaster.status!=0}"><c:if test="${travelList.status !=1}"><span class="glyphicon glyphicon-remove" onclick="removeChild3First('countFirstFile${countVal.count}', '${countVal.count}');" title="Delete" style="font-size: 20px; color: red;"></span></c:if></c:if></td>
                                                                                <%--<c:if test="${expenseMaster.status ne 0}">--%>
                                                                                <%--<c:if test="${countVal.last}">--%>
                                                                            <!--<td style="text-align: center">-->
                                                                            <!--<span style='margin-top: 5px;'>-->
                                                                            <%--<c:if test="${flag1 ne true }">--%>
                                                                            <!--<input type="button" value="+" id="addRowButtonId" />-->
                                                                            <%--</c:if>--%>
                                                                            <!--</span>-->
                                                                            <!--</td>-->
                                                                            <%--</c:if>--%>
                                                                            <%--</c:if>--%>
                                                                        </tr>

                                                                    </c:forEach>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <tr>
                                                                        <td style="text-align: center">1</td>
                                                                        <td><input type="text" name="fromCity1" class="form-control"></td>
                                                                        <td><input type="text" name="toCity1" class="form-control"></td>
                                                                        <td>
                                                                            <input class="form-control" size="16" type="text" id="datepickerr1" name="travelDate1" value=""  style="width: 141px" onclick="clickToPickData('1');">

                                                                            <!--<input class="form-control" size="16" type="date" name="travelDate1" value=""  style="width: 141px">-->
                                                                            <!--                                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>-->
                                                                        </td>

                                                                        <td><div>
                                                                                <select id="WorkTypeSelectId" name="WorkTypeSelect1" class="form-control">
                                                                                    <option value="">--SELECT--</option>
                                                                                    <option value="Air">Air </option>
                                                                                    <option value="Bus">Bus</option>
                                                                                    <option value="Rail">Rail</option>
                                                                                    <option value="Cab/Taxi">Cab/Taxi</option>
                                                                                </select>
                                                                            </div></td>
                                                                        <td><input type="text" name="amount1" id="amount1" class="form-control" onchange="calculateAmount();"></td>
                                                                        <td><div>
                                                                                <select id="currencyTravelDivId1" name="currencyTravelDiv1" class="form-control" onchange="changeAmount1(this.value);">
                                                                                    <option value="">--SELECT--</option>
                                                                                    <c:forEach var="currency" items="${currencyMap}">
                                                                                        <option value="${currency.key}">${currency.value}</option>
                                                                                    </c:forEach>
                                                                                </select>
                                                                            </div></td>
                                                                        <td style="text-align: center">
                                                                            <!--<span><input type="checkbox"/></span>-->
                                                                        </td>
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
                                                        <div >
                                                            <div class="table-responsive">
                                                                <table id="demo2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                                    <tr>
                                                                        <th style="text-align: center; vertical-align: middle;width: 5%">Sr.No.</th>
                                                                        <th style="text-align: center; vertical-align: middle;width: 12%">Date</th>
                                                                        <th style="text-align: center; vertical-align: middle">Other Expense</th>
                                                                        <th style="text-align: center; vertical-align: middle"><span id="otherPurposeId" style="display: none">Purpose</span></th>
                                                                        <th style="text-align: center; vertical-align: middle">Amount</th>
                                                                        <th style="text-align: center; vertical-align: middle">Currency</th>
                                                                        <!--                                                                        <th style="text-align: center; vertical-align: middle;width: 6%">Approve</th>-->
                                                                        <th style="text-align: center; vertical-align: middle;width: 7%"><c:if test="${expenseMaster.status ne 0}">
                                                                                <%--<c:if test="${countVal.last}">--%>
                                                                                <!--<td style="text-align: center">-->
                                                                                <%--<c:if test="${countVal.last}">--%>
                                                                                <span style='margin-top: 5px;'>
                                                                                    <c:if test="${flag2 ne true}">
                                                                                        <input type="button" value="+" id="addButtonFoodCategoryId" />
                                                                                    </c:if>
                                                                                </span>
                                                                                <%--</c:if>--%>
                                                                                <!--</td>-->
                                                                                <%--</c:if>--%>
                                                                            </c:if></th>
                                                                    <input type="hidden" name="OtherExpCount" value="1"/>
                                                                    </tr>
                                                                    <c:choose>
                                                                        <c:when test="${not empty travelOtherTypeList}">
                                                                            <c:forEach var="otherList" items="${travelOtherTypeList}" varStatus="countVal">
                                                                                <input type="hidden" name="countSecond" id="countSecond" value="${fn:length(travelOtherTypeList)}"/>
                                                                                <input type="hidden" name="travelOtherId${countVal.count}" id="travelOtherId${countVal.count}" value="${otherList.id}"/>
                                                                                <input type="hidden" name="travelOtherStatus${countVal.count}" id="travelOtherStatus${countVal.count}" value="${otherList.status}"/>
                                                                                <tr id="countSecondFile${countVal.count}">
                                                                                    <td style="text-align: center">${countVal.count}</td>
                                                                                    <td>
                                                                                        <input class="form-control" size="16" type="text" id="travelotherExpenseDate${countVal.count}" name="travelotherExpenseDate${countVal.count}" value="${otherList.otherExpenseDate}" onclick="travelOtherExpenseDatePic('${countVal.count}');">
                                                                                        <span id="travelotherExpenseDateError${countVal.count}" style="color: red;"></span>
                                                                                    </td>
                                                                                    <td><div> 
                                                                                            <select id="RentAndFoodDiv${countVal.count}" name='RentAndFoodDiv${countVal.count}' class="form-control" onchange="travelOtherBox('${countVal.count}');"  <c:if test="${otherList.status==1}">disabled="true"</c:if>>
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
                                                                                    <td><input type="text" name="otherAmount${countVal.count}" id="otherAmount${countVal.count}" class="form-control" value="${otherList.amount}" <c:if test="${otherList.status==1}">readonly="true"</c:if> onchange="calculateAmount();"></td>
                                                                                        <td><div>
                                                                                                <select id="currencyRelocationDivId${countVal.count}" name="currencyRelocationDiv${countVal.count}" class="form-control" onchange="changeAmount1(this.value);"  <c:if test="${otherList.status==1}">disabled="true"</c:if>>
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
                                                                                    <td style="text-align: center">
                                                                                        <c:if test="${otherList.status==1}"><span class="glyphicon glyphicon-ok" title="Approved" style="font-size: 20px; color: green;"></span></c:if>
                                                                                        <c:if test="${expenseMaster.status!=0}"><c:if test="${otherList.status !=1}"><span class="glyphicon glyphicon-remove" onclick="removeChild3Second('countSecondFile${countVal.count}', '${countVal.count}');" title="Delete" style="font-size: 20px; color: red;"></span></c:if></c:if>
                                                                                            </td>
                                                                                    <%--<c:if test="${expenseMaster.status ne 0}">--%>
                                                                                    <%--<c:if test="${countVal.last}">--%>
                                                                                    <!--<td style="text-align: center">-->
                                                                                    <%--<c:if test="${countVal.last}">--%>
                                                                                    <!--<span style='margin-top: 5px;'>-->
                                                                                    <%--<c:if test="${flag2 ne true}">--%>
                                                                                    <!--<input type="button" value="+" id="addButtonFoodCategoryId" />-->
                                                                                    <%--</c:if>--%>
                                                                                    <!--</span>-->
                                                                                    <%--</c:if>--%>
                                                                                    <!--</td>-->
                                                                                    <%--</c:if>--%>
                                                                                    <%--</c:if>--%>
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
                                                                                        <select id="RentAndFoodDiv1" name='RentAndFoodDiv1' class="form-control" onchange="travelOtherBox(1);">
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
                                                                                <td style="text-align: center">
                                                                                    <!--<span><input type="checkbox"/></span>-->
                                                                                </td>
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
                                                                <th style="text-align: center; vertical-align: middle">From City</th>
                                                                <th style="text-align: center; vertical-align: middle">To City</th>
                                                                <th style="text-align: center; vertical-align: middle">Date</th>
                                                                <th style="text-align: center; vertical-align: middle">Mode of Travel</th>
                                                                <th style="text-align: center; vertical-align: middle">Amount</th>
                                                                <th style="text-align: center; vertical-align: middle" id="currencyTravelRelo_th">Currency</th>
                                                                <!--<th style="text-align: center; vertical-align: middle;width: 6%">Approve</th>-->
                                                                <th style="text-align: center; vertical-align: middle;width: 7%"><span style='margin-top: 5px;'>
                                                                        <c:if test="${expenseMaster.status ne 0}">
                                                                            <c:if test="${flag3 ne true}">
                                                                                <input type="button" value="+" id="addRowButtonId1" title="Add New" />
                                                                            </c:if>
                                                                        </c:if>
                                                                    </span></th>
                                                            <input type="hidden" name="TravelExpCount" value="1"/>
                                                            </tr>

                                                            <c:choose>
                                                                <c:when test="${not empty relocationTypeList}">
                                                                    <c:forEach var="relocationList" items="${relocationTypeList}" varStatus="countVal">
                                                                        <input type="hidden" name="countFirstRelo" id="countFirstRelo" value="${fn:length(relocationTypeList)}"/>
                                                                        <input type="hidden" name="reloTypeId${countVal.count}" id="reloTypeId${countVal.count}" value="${relocationList.id}"/>
                                                                        <input type="hidden" name="reloTypeStatus${countVal.count}" id="reloTypeStatus${countVal.count}" value="${relocationList.status}"/>
                                                                        <tr id="1moreFile${countVal.count}">
                                                                            <td style="text-align: center">${countVal.count}</td>
                                                                            <td><input type="text" name="fromCityRelo${countVal.count}" class="form-control" value="${relocationList.fromCity}" <c:if test="${relocationList.status==1}">readonly="true"</c:if>></td>
                                                                            <td><input type="text" name="toCityRelo${countVal.count}" class="form-control" value="${relocationList.toCity}" <c:if test="${relocationList.status==1}">readonly="true"</c:if> ></td>
                                                                                <td>
                                                                                    <input class="form-control" size="16" type="text" id="datepicker${countVal.count}" name="travelDateRelo${countVal.count}" value="${relocationList.date}" <c:if test="${relocationList.status==1}">readonly="true"</c:if> style="width: 141px" onclick="clickToPicker('${countVal.count}');">
                                                                                <!--<input class="form-control" size="16" type="text" name="travelDateRelo${countVal.count}" value="${relocationList.date}" <c:if test="${relocationList.status==1}">readonly="true"</c:if>  style="width: 98px">-->
                                                                                    <!--                                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>-->
                                                                                </td>

                                                                                <td><div>

                                                                                        <select id="WorkTypeSelectId" name="WorkTypeSelectRelo${countVal.count}" class="form-control" <c:if test="${relocationList.status==1}">disabled="true"</c:if> >
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
                                                                                                <option value="Cab" >Cab</option>
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
                                                                                </div></td>
                                                                            <td><input type="text" name="amountRelo${countVal.count}" id="amountRelo${countVal.count}" class="form-control" value="${relocationList.amount}" <c:if test="${relocationList.status==1}">readonly="true"</c:if> onchange="calculateAmount();"></td>
                                                                            <td id="currencyTravelRelo_td${countVal.count}"><div>
                                                                                    <select id="currencyTravelDivRelo${countVal.count}" name="currencyTravelDivRelo${countVal.count}" class="form-control"  <c:if test="${relocationList.status==1}">disabled="true"</c:if> onchange="changeAmount1(this.value);">
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
                                                                                </div></td>

                                                                            <td style="text-align: center">
                                                                                <c:if test="${relocationList.status==1}">
                                                                                    <span class="glyphicon glyphicon-ok" style="font-size: 20px; color: green;" title="Approved"></span>
                                                                                </c:if>
                                                                                <c:if test="${expenseMaster.status!=0}">
                                                                                    <c:if test="${relocationList.status ne 1}">
                                                                                        <span class="glyphicon glyphicon-remove" onclick="removeChild3FirstRelo('1moreFile${countVal.count}', '${countVal.count}');" style="font-size: 20px; color: red;" title="Delete"></span>
                                                                                    </c:if>
                                                                                </c:if>
                                                                            </td>
                                                                            <td style="text-align: center">
                                                                                <%--<c:if test="${expenseMaster.status ne 0}">--%>
                                                                                <%--<c:if test="${countVal.last}">--%>

                                                                                <!--<span style='margin-top: 5px;'>-->
                                                                                <%--<c:if test="${flag3 ne true}">--%>
                                                                                <!--<input type="button" value="+" id="addRowButtonId1" />-->
                                                                                <%--</c:if>--%>
                                                                                <!--</span>-->
                                                                                <%--</c:if>--%>
                                                                                <%--</c:if>--%>
                                                                            </td>
                                                                        </tr>
                                                                    </c:forEach>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <tr>
                                                                        <td style="text-align: center">1</td>
                                                                        <td><input type="text" name="fromCityRelo1" class="form-control"></td>
                                                                        <td><input type="text" name="toCityRelo1" class="form-control"></td>
                                                                        <td>
                                                                            <input class="form-control" size="16" type="text" id="datepicker1" name="travelDateRelo1" value=""  style="width: 141px" onclick="clickToPicker('1');">
                                                                            <!--<input class="form-control" size="16" type="date" name="travelDateRelo1" id="travelDateRelo1" value=""  style="width: 98px">-->
                                                                            <!--                                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>-->
                                                                        </td>

                                                                        <td><div>
                                                                                <select id="WorkTypeSelectId" name="WorkTypeSelectRelo1" class="form-control">
                                                                                    <option value="">--SELECT--</option>
                                                                                    <option value="Air">Air </option>
                                                                                    <option value="Bus">Bus</option>
                                                                                    <option value="Rail">Rail</option>
                                                                                    <option value="Cab/Taxi">Cab/Taxi</option>
                                                                                </select>
                                                                            </div></td>
                                                                        <td><input type="text" name="amountRelo1" id="amountRelo1" class="form-control" onchange="calculateAmount();"></td>
                                                                        <td id="currencyTravelRelo_td1"><div>
                                                                                <select id="currencyTravelDivRelo1" name="currencyTravelDivRelo1" class="form-control" onchange="changeAmount1(this.value);">
                                                                                    <option value="">--SELECT--</option>
                                                                                    <c:forEach var="currency" items="${currencyMap}">
                                                                                        <option value="${currency.key}">${currency.value}</option>
                                                                                    </c:forEach>
                                                                                </select>
                                                                            </div></td>

                                                                        <td style="text-align: center">
                                                                            <!--<span><input type="checkbox"/></span>-->
                                                                        </td>
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
                                                        <div class="col-md-12 col-sm-12">
                                                            <div class="table-responsive">
                                                                <table id="demo9" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                                    <tr>
                                                                        <th style="text-align: center; vertical-align: middle;width: 5%">Sr.No.</th>
                                                                        <th style="text-align: center; vertical-align: middle;width: 12%">Date</th>
                                                                        <th style="text-align: center; vertical-align: middle">Other Expense</th>
                                                                        <th style="text-align: center; vertical-align: middle"><span id="otherPurposeId" style="display: none">Purpose</span></th>
                                                                        <th style="text-align: center; vertical-align: middle">Amount</th>
                                                                        <th style="text-align: center; vertical-align: middle" id="currencyRelocationDiv_th">Currency</th>
                                                                        <!--<th style="text-align: center; vertical-align: middle;width: 6%">Approve</th>-->
                                                                        <th style="text-align: center; vertical-align: middle;width: 7%"><c:if test="${expenseMaster.status ne 0}">
                                                                                <%--<c:if test="${countVal.last}">--%>
                                                                                <span style='margin-top: 5px;'>
                                                                                    <c:if test="${flag4 ne true}">
                                                                                        <input type="button" value="+" id="addButtonFoodCategoryId1" title="Add New" />
                                                                                    </c:if>
                                                                                </span>
                                                                                <%--</c:if>--%>
                                                                            </c:if></th>
                                                                    <input type="hidden" name="OtherExpCount" value="1"/>
                                                                    </tr>
                                                                    <c:choose>
                                                                        <c:when test="${not empty relocationOtherTypeList}">
                                                                            <c:forEach var="relocationOtherList" items="${relocationOtherTypeList}" varStatus="countVal">
                                                                                <input type="hidden" name="countSecondRelo" id="countSecondRelo" value="${fn:length(relocationOtherTypeList)}"/>
                                                                                <input type="hidden" name="reloOtherId${countVal.count}" id="reloOtherId${countVal.count}" value="${relocationOtherList.id}"/>
                                                                                <input type="hidden" name="reloOtherStatus${countVal.count}" id="reloOtherStatus${countVal.count}" value="${relocationOtherList.status}"/>
                                                                                <tr id="addmoreFile${countVal.count}">
                                                                                    <td style="text-align: center">${countVal.count}</td>
                                                                                    <td>
                                                                                        <input class="form-control" size="16" type="text" id="reloOtherExpenseDate${countVal.count}" name="reloOtherExpenseDate${countVal.count}" value="${relocationOtherList.otherExpenseDate}"  onclick="reloOtherExpenseDatePic('${countVal.count}');">
                                                                                        <span id="reloOtherExpenseDateError${countVal.count}" style="color: red;"></span>
                                                                                    </td>
                                                                                    <td><div>
                                                                                            <select id="RentAndFoodDivRelo${countVal.count}" name='RentAndFoodDivRelo${countVal.count}' class="form-control" onchange="showOnlyOtherBox('${countVal.count}');" <c:if test="${relocationOtherList.status==1}">readonly="true"</c:if>>
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
                                                                                        </div></td>
                                                                                    <td><input type="text" name="purposeRelo${countVal.count}" class="form-control" id="purposeRelo${countVal.count}" value="${relocationOtherList.expenseOtherSpecify}" style="display: none" placeholder="(Please Specify In case of Other)"></td>
                                                                                    <td><input type="text" name="otherAmountRelo${countVal.count}" id="otherAmountRelo${countVal.count}" class="form-control" value="${relocationOtherList.amount}" <c:if test="${relocationOtherList.status==1}">readonly="true"</c:if> onchange="calculateAmount();"></td>
                                                                                    <td id="currencyRelocationDiv_td${countVal.count}"><div>
                                                                                            <select id="currencyRelocationDivRelo${countVal.count}" name="currencyRelocationDivRelo${countVal.count}" class="form-control" onchange="changeAmount1(this.value);" <c:if test="${relocationOtherList.status==1}">disabled="true"</c:if>>
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
                                                                                        </div></td>
                                                                                    <td style="text-align: center">
                                                                                        <c:if test="${relocationOtherList.status==1}"><span class="glyphicon glyphicon-ok" title="Approved" style="font-size: 20px; color: green;"></span></c:if>
                                                                                        <c:if test="${expenseMaster.status!=0}"><c:if test="${relocationOtherList.status ne 1}"><span class="glyphicon glyphicon-remove" onclick="removeChild3('addmoreFile${countVal.count}', '${countVal.count}');" title="Delete" style="font-size: 20px; color: red;"></span></c:if></c:if>
                                                                                            </td>
                                                                                            <!--<td style="text-align: center">-->

                                                                                            <!--</td>-->
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
                                                                                    </div></td>
                                                                                <td><input type="text" name="purposeRelo1" class="form-control" id="purposeRelo1" style="display: none" placeholder="(Please Specify In case of Other)"></td>
                                                                                <td><input type="text" name="otherAmountRelo1" id="otherAmountRelo1" class="form-control" onchange="calculateAmount();"></td>
                                                                                <td id="currencyRelocationDiv_td1"><div>
                                                                                        <select id="currencyRelocationDivRelo1" name="currencyRelocationDivRelo1" class="form-control" onchange="changeAmount1(this.value);">
                                                                                            <option value="">--SELECT--</option>
                                                                                            <c:forEach var="currency" items="${currencyMap}">
                                                                                                <option value="${currency.key}">${currency.value}</option>
                                                                                            </c:forEach>
                                                                                        </select>
                                                                                    </div></td>
                                                                                <td style="text-align: center">
                                                                                    <!--<span><input type="checkbox"/></span>-->
                                                                                </td>
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
                                                                <th style="text-align: center; vertical-align: middle;width: 7%"><c:if test="${expenseMaster.status ne 0}">
                                                                        <%--<c:if test="${countVal.last}">--%>
                                                                        <span style='margin-top: 5px;'>
                                                                            <c:if test="${flag5 ne true}">
                                                                                <input type="button" value="+" id="addButtonFoodCategoryId2" title="Add New"/>
                                                                            </c:if>
                                                                        </span>
                                                                        <%--</c:if>--%>
                                                                    </c:if></th>
                                                            <input type="hidden" name="OtherExpCount" value="1"/>
                                                            </tr>
                                                            <c:choose>
                                                                <c:when test="${not empty policyOtherTypeList}">
                                                                    <c:forEach var="policyOtherList" items="${policyOtherTypeList}" varStatus="countVal">
                                                                        <input type="hidden" name="countSecondOther" id="countSecondOther" value="${fn:length(policyOtherTypeList)}"/>
                                                                        <input type="hidden" name="policyOtherId${countVal.count}" id="policyOtherId${countVal.count}" value="${policyOtherList.id}"/>
                                                                        <input type="hidden" name="policyOtherStatus${countVal.count}" id="policyOtherStatus${countVal.count}" value="${policyOtherList.status}"/>
                                                                        <tr id="addmoreSecondOtherFile${countVal.count}">
                                                                            <td style="text-align: center">${countVal.count}</td>
                                                                            <td>
                                                                                <input class="form-control" size="16" type="text" id="otherExpenseDate${countVal.count}" name="otherExpenseDate${countVal.count}" onclick="otherExpenseDatePic('${countVal.count}')" value="${policyOtherList.otherExpenseDate}" />
                                                                                <span id="otherExpenseDateError${countVal.count}" style="color: red;"></span>
                                                                            </td>
                                                                            <td><div>
                                                                                    <select id="RentAndFoodDivPolicy${countVal.count}" name='RentAndFoodDivPolicy${countVal.count}' class="form-control" onchange="otherEnble('${countVal.count}');" <c:if test="${policyOtherList.status==1}">disabled="true"</c:if>>
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
                                                                            <td><input type="text" name="otherAmountPolicy${countVal.count}" id="otherAmountPolicy${countVal.count}" class="form-control" value="${policyOtherList.amount}" <c:if test="${policyOtherList.status==1}">readonly="true"</c:if> onchange="calculateAmount();"></td>
                                                                            <td id="policyReimbCurrency_td${countVal.count}"><div>
                                                                                    <select id="currencyRelocationDivPolicy${countVal.count}" name="currencyRelocationDivPolicy${countVal.count}" class="form-control" onchange="currencyClick1(1)" <c:if test="${policyOtherList.status==1}">disabled="true"</c:if> onchange="changeAmount1(this.value);">
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
                                                                            <td style="text-align: center">
                                                                                <c:if test="${policyOtherList.status==1}"><span class="glyphicon glyphicon-ok" style="font-size: 20px; color: green;" title="Approved"></span></c:if>
                                                                                <c:if test="${expenseMaster.status!=0}"><c:if test="${policyOtherList.status ne 1}"><span class="glyphicon glyphicon-remove" onclick="removeChild3SecondOther('addmoreSecondOtherFile${countVal.count}', '${countVal.count}');" style="font-size: 20px; color: red;" title="Delete"></span></c:if></c:if>
                                                                                    </td>
                                                                                    <!--<td style="text-align: center">-->
                                                                            <%--<c:if test="${expenseMaster.status ne 0}">--%>
                                                                            <%--<c:if test="${countVal.last}">--%>
                                                                            <!--<span style='margin-top: 5px;'>-->
                                                                            <%--<c:if test="${flag5 ne true}">--%>
                                                                            <!--<input type="button" value="+" id="addButtonFoodCategoryId2" />-->
                                                                            <%--</c:if>--%>
                                                                            <!--</span>-->
                                                                            <%--</c:if>--%>
                                                                            <%--</c:if>--%>
                                                                            <!--</td>-->
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
                                                                            <!--<span><input type="checkbox"/></span>-->
                                                                        </td>
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
                                                        <table id="demo3" class="table table-bordered table-striped table-hover" style="display: none" align="Center"  >
                                                            <tr>
                                                                <th style="text-align: center; vertical-align: middle;width: 5%">Sr.No.</th>
                                                                <th style="text-align: center; vertical-align: middle">Invoice/Bill Date</th>
                                                                <th style="text-align: center; vertical-align: middle">Invoice/Bill No.</th>
                                                                <th style="text-align: center; vertical-align: middle">Amount</th>
                                                                <th style="text-align: center; vertical-align: middle" id="otherCurrency_th">Currency</th>
                                                                <!--<th style="text-align: center; vertical-align: middle;width: 6%">Approve</th>-->
                                                                <th style="text-align: center; vertical-align: middle;width: 7%"><c:if test="${expenseMaster.status ne 0}">
                                                                        <%--<c:if test="${countVal.last}">--%>
                                                                        <span style='margin-top: 5px;'>
                                                                            <c:if test="${flag ne true}">
                                                                                <input type="button" value="+" id="addButtonOtherTableId" title="Add New"/>
                                                                            </c:if>
                                                                        </span>
                                                                        <%--</c:if>--%>
                                                                    </c:if></th>
                                                                <!--<input type="hidden" name="othersCount" id="othersCount" value="1"/>-->
                                                            </tr>
                                                            <c:choose>
                                                                <c:when test="${not empty othersList}">
                                                                    <c:forEach var="otherList1" items="${othersList}" varStatus="countVal">
                                                                        <input type="hidden" name="othersCount" id="othersCount" value="${fn:length(othersList)}"/>
                                                                        <input type="hidden" name="otherListId${countVal.count}" id="otherListId${countVal.count}" value="${otherList1.id}"/>
                                                                        <input type="hidden" name="otherListStatus${countVal.count}" id="otherListStatus${countVal.count}" value="${otherList1.status}"/>
                                                                        <tr id="addmoreOhterFile${countVal.count}">
                                                                            <td style="text-align: center">${countVal.count}</td>
                                                                            <td style="width: 20%">
                                                                                <input class="form-control" size="16" type="text" id="datepicker${countVal.count}" name="billDate${countVal.count}" value="${otherList1.billDate}" <c:if test="${otherList1.status==1}">readonly="true"</c:if>  style="width: 141px" onclick="clickToPicker('${countVal.count}');">
                                                                                <!--<input class="form-control" name="billDate${countVal.count}" size="16" type="date" value="${otherList1.billDate}" <c:if test="${otherList1.status==1}">readonly="true"</c:if>>-->
                                                                                </td>
                                                                                <td><input type="text" name="billNo${countVal.count}" class="form-control" value="${otherList1.bilNo}" <c:if test="${otherList1.status==1}">readonly="true"</c:if>></td>
                                                                            <td><input type="text" name="policyAmount${countVal.count}" id="policyAmount${countVal.count}" class="form-control" value="${otherList1.amount}" <c:if test="${otherList1.status==1}">readonly="true"</c:if> onchange="calculateAmount();"></td>
                                                                            <td id="otherCurrency_td${countVal.count}"><div>
                                                                                    <select name="otherCurrency${countVal.count}" id="currencyOtherDiv${countVal.count}" class="form-control" <c:if test="${otherList1.status eq 1}">disabled="true"</c:if> onchange="changeAmount1(this.value);">
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
                                                                            <td style="text-align: center">
                                                                                <c:if test="${otherList1.status==1}"><span class="glyphicon glyphicon-ok" title="Approved" style="font-size: 20px; color: green;"></span></c:if>
                                                                                <c:if test="${expenseMaster.status!=0}"><c:if test="${otherList1.status ne 1}"><span class="glyphicon glyphicon-remove" onclick="removeChild3Other('addmoreOhterFile${countVal.count}', '${countVal.count}');" title="Delete" style="font-size: 20px; color: red;"></span></c:if></c:if>
                                                                                    </td>
                                                                                    <!--<td style="text-align: center">-->
                                                                            <%--<c:if test="${expenseMaster.status ne 0}">--%>
                                                                            <%--<c:if test="${countVal.last}">--%>
                                                                            <!--<span style='margin-top: 5px;'>-->
                                                                            <%--<c:if test="${flag ne true}">--%>
                                                                            <!--<input type="button" value="+" id="addButtonOtherTableId" />-->
                                                                            <%--</c:if>--%>
                                                                            <!--</span>-->
                                                                            <%--</c:if>--%>
                                                                            <%--</c:if>--%>
                                                                            <!--</td>-->
                                                                        </tr>
                                                                    </c:forEach>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <tr>
                                                                        <td style="text-align: center">1</td>
                                                                        <td style="width: 20%">
                                                                            <input class="form-control" name="billDate1" size="16" type="date" value="" >
                                                                        </td>
                                                                        <td><input type="text" name="billNo1" class="form-control"></td>
                                                                        <td><input type="text" name="policyAmount1" id="policyAmount1" class="form-control" onchange="calculateAmount();"></td>
                                                                        <td id="otherCurrency_td1"><div>
                                                                                <select id="currencyOtherDiv1" name="otherCurrency1" class="form-control" onchange="changeAmount1(this.value);">
                                                                                    <c:forEach var="currency" items="${currencyMap}">
                                                                                        <option value="${currency.key}">${currency.value}</option>
                                                                                    </c:forEach>
                                                                                </select>
                                                                            </div></td>
                                                                        <td style="text-align: center">
                                                                            <!--<span><input type="checkbox"/></span>-->
                                                                        </td>
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
                                            <input type="hidden" id="currencyMapId" name="currencyMapId" value="${fn:length(currencyMap)}">
                                            <div class="box-tools pull-right">
                                                <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun4()"><i class="fa fa-plus" id="minusId4"></i></button>
                                            </div>
                                        </div>
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div id="fill1" class=" col-sm-12" align="right">
                                                        <!--<input type="button" class="btn btn-primary" value="Fill Data" style="width: 100px;" onclick="fillData();">-->
                                                    </div>
                                                    <br/>
                                                    <br/>
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
                                                                                <td id="displayExpense_${currency.key}" ><input type="text" name="totalAmount_${currency.key}" id="totalAmount_${currency.key}" value="${expenseReconsilationList.expenseInReport}" class="form-control" readonly="" disabled="true" /></td>
                                                                            <input type="hidden" name="reconsilationId_${currency.key}" id="reconsilationId_${currency.key}" value="${expenseReconsilationList.id}">
                                                                            <c:set var="tempSt" value ="false"/>
                                                                        </c:if>

                                                                        <%--</c:when>--%>
                                                                        <%--<c:otherwise>--%>
                                                                        <c:if test="${(currency.key).toString() ne (expenseReconsilationList.currencyType).toString()}">
                                                                            <td id="displayExpense_${currency.key}" ><input type="text" name="totalAmount_${currency.key}" id="totalAmount_${currency.key}" value="0.0" class="form-control" readonly="" disabled="true" /></td>
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
                                                                <td style="vertical-align: middle">Expense paid by Company <span style="color: red;font-size: 16px;">*</span></td>
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

                                                                                <td id="paidByCompany_${currency.key}" ><input type="text" name="paidByCompany${currency.key}" id="paidByCompany${currency.key}"  class="form-control" value="${expenseReconsilationList.expensePaid}" onchange="calculateVariance(${currency.key});"/></td>
                                                                                    <%--</c:when>--%>
                                                                                    <c:set var="tempSt" value ="false"/>
                                                                                </c:if>
                                                                                <c:if test="${(currency.key).toString() ne (expenseReconsilationList.currencyType).toString()}">

                                                                                <%--<c:otherwise>--%>
                                                                                <td id="paidByCompany_${currency.key}" ><input type="text" name="paidByCompany${currency.key}" id="paidByCompany${currency.key}"  class="form-control" onchange="calculateVariance(${currency.key});" /></td>
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
                                                                <td style="vertical-align: middle">Cash Advance <span style="color: red;font-size: 16px;">*</span></td>
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
                                                                                <td id="advanceCash_${currency.key}" ><input type="text" name="advanceCash${currency.key}" id="advanceCash${currency.key}"  class="form-control" value="${expenseReconsilationList.cashAdvance}" onchange="calculateVariance(${currency.key});"/></td>
                                                                                    <c:set var="tempSt" value ="false"/>
                                                                                </c:if>
                                                                                <%--</c:when>--%>
                                                                                <%--<c:otherwise>--%>
                                                                                <c:if test="${(currency.key).toString() ne (expenseReconsilationList.currencyType).toString()}">
                                                                                <td id="advanceCash_${currency.key}" ><input type="text" name="advanceCash${currency.key}" id="advanceCash${currency.key}"  class="form-control" onchange="calculateVariance(${currency.key});"/></td>
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
                                                                <td style="vertical-align: middle">Cash Returned <span style="color: red;font-size: 16px;">*</span></td>
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

                                                                                <td id="cashReturned_${currency.key}" ><input type="text" name="cashReturned${currency.key}" id="cashReturned${currency.key}" class="form-control" value="${expenseReconsilationList.cashReturned}" onchange="calculateVariance(${currency.key});"/></td>
                                                                                    <c:set var="tempSt" value ="false"/>
                                                                                </c:if>
                                                                                <%--<c:otherwise>--%>
                                                                                <c:if test="${(currency.key).toString() ne (expenseReconsilationList.currencyType).toString()}">
                                                                                <td id="cashReturned_${currency.key}" ><input type="text" name="cashReturned${currency.key}" id="cashReturned${currency.key}" class="form-control" onchange="calculateVariance(${currency.key});"/></td>
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
                                                                                <td id="variance_${currency.key}" ><input type="text" name="variance${currency.key}" id="variance${currency.key}"  class="form-control" value="${expenseReconsilationList.varianceOwed}" readonly=""/></td>
                                                                                    <c:set var="tempSt" value ="false"/>
                                                                                </c:if>
                                                                                <%--</c:when>--%>
                                                                                <%--<c:otherwise>--%>
                                                                                <c:if test="${((currency.key).toString() ne (expenseReconsilationList.currencyType).toString())}">

                                                                                <td id="variance_${currency.key}" ><input type="text" name="variance${currency.key}" id="variance${currency.key}"  class="form-control" readonly=""/></td>
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
                                    <!--Reason In Detail completes Here-->
                                    <div class="form-group">
                                        <div class="col-sm-12" style="text-align: center;">
                                            <c:if test="${expenseMaster.status!=0}">

                                                <c:if test="${expenseMaster.expenseType eq 'Travel'}">
                                                    <c:if test="${flag1 ne true or flag2 ne true}">
                                                        <button type="submit" class="btn btn-primary" name="btnType1" value="Submit" style="width: 100px">SUBMIT</button>
                                                    </c:if>
                                                </c:if>
                                                <c:if test="${expenseMaster.expenseType eq 'Relocation'}">
                                                    <c:if test="${flag3 ne true || flag4 ne true}">
                                                        <button type="submit" class="btn btn-primary" name="btnType1" value="Submit" style="width: 100px">SUBMIT</button>
                                                    </c:if>
                                                </c:if>
                                                <c:if test="${expenseMaster.expenseType eq 'Others'}">
                                                    <c:if test="${flag ne true}">
                                                        <button type="submit" class="btn btn-primary" name="btnType1" value="Submit" style="width: 100px">SUBMIT</button>
                                                    </c:if>
                                                </c:if>
                                                <c:if test="${expenseMaster.expenseType eq 'PolicyReimbursements'}">
                                                    <c:if test="${flag5 ne true}">
                                                        <button type="submit" class="btn btn-primary" name="btnType1" value="Submit" style="width: 100px">SUBMIT</button>
                                                    </c:if>
                                                </c:if>
                                                <!--<input type="submit" class="btn btn-danger" name="btnType1" value="Return"  />-->
                                            </c:if>
                                            <!--<input type="submit" class="btn btn-success"  name="btnType"  value="Save" style="width: 100px" onclick="saveSubmit(this.value)">-->
                                            <!--<input type="button" class="btn btn-primary" name="btnType"  value="Back" style="width: 100px" onclick="window.history.back()">-->
                                        </div>

                                    </div>
                                </form:form>
                                <!--form horizontal ends here-->
                            </div><!-- /.tab-content -->
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
            </section><!-- /.content -->
        </div>
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
            );
        </script>
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

//                alert("1");
                var currencyMapId = document.getElementById("currencyMapId").value;

                var currencyRelocationDiv;
                var currencyTravelDivId;
                var currencyOtherDiv;
                var currencyRelocationDivPolicy;
                var currencyTravelDivRelo;
                var currencyRelocationDivRelo;
                var expenseType = document.getElementById("expenseType").value;
//                alert("2");
                for (var j = 1; j <= currencyMapId; j++) {
//                    alert("3");
                    try {
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
//                        alert("4");
                        if (expenseType === "Others") {
//                            alert("ajay");

                            for (var i = 1; i <= othersCount; i++) {
                                try {
                                    currencyOtherDiv = document.getElementById("currencyOtherDiv" + i).value;
//                                    alert(currencyOtherDiv);
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
                        if (expenseType === "PolicyReimbursements") {
//                            alert(countSecondOther + "aaaaaaaaaaaaaaaaaaaaaaaaa");
                            //
                            for (var i = 1; i <= countSecondOther; i++) {
                                try {
                                    currencyRelocationDivPolicy = document.getElementById("currencyRelocationDivPolicy" + i).value;
                                    //                    alert(currencyRelocationDivPolicy + "wwwww");
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
                                try {
                                    currencyTravelDivRelo = document.getElementById("currencyTravelDivRelo" + i).value;
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
                                try {
                                    currencyRelocationDivRelo = document.getElementById("currencyRelocationDivRelo" + i).value;
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
//                        alert("www" + currencyCount);
                        document.getElementById("totalAmount_" + currencyCount).value = finalCheck;
                        calculateVariance(currencyCount);
                    } catch (e) {

                    }
                }
            }

        </script>
        <script>
            function changeAmount1(val) {
//                alert("ajay");
                var currencyMapId = document.getElementById("currencyMapId").value;
                var expenseType = document.getElementById("expenseType").value;
                //                alert('val' + currencyMapId);
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
//                alert("fianlFun");
                calculateAmount();
            }</script>
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
