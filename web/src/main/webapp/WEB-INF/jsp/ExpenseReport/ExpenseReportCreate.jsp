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
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script>

        $(function () {
            $("#expenseType").on("change", function () {

                var selectedValue = this.value;
                var countFirst = document.getElementById("countFirst").value;
                var countSecond = document.getElementById("countSecond").value;
                var othersCount = document.getElementById("othersCount").value;
                for (var i = 1; i <= countFirst; i++) {
                    document.getElementById("amount" + i).value = "";
                }
                for (var i = 1; i <= countSecond; i++) {
                    document.getElementById("otherAmount" + i).value = "";
                }
                for (var i = 1; i <= othersCount; i++) {
                    document.getElementById("policyAmount" + i).value = "";
                }

                if (selectedValue === "Travel") {
                    $('#travelAppDateDiv_id').show();
                    $('#applicationDivId').show();
                    $('#demo').show();
                    $('#demo2').show();
                    $('#otherDivId').hide();
                    $('#demo3').hide();
                    $('.travelGEId').show();
                    $('.RelocationGTEId').hide();
                    $('#policyDivId').hide();
                    $('#localTravelId').hide();

                    for (var i = 1; i <= countFirst; i++) {
//                        var travelType = document.getElementById("travelType").value;
//                        if (travelType == 'International') {
//                            var element2 = document.getElementById("currencyTravelDivId" + i);
//                            for (var i2 = 0; i2 < element2.options.length; i2++) {
//                                var currencyVal = element2.options[i2].value;
////                            alert("currencyVal" + currencyVal);
//                                var currencyText = element2.options[i2].text;
//                                try {
//                                    currencyText = currencyText.split('(');
//                                    var currencyText11 = currencyText[1];
////                                alert("currencyText11" + currencyText11);
//                                    currencyText11 = currencyText11.split(')');
//                                    if (currencyText11[0] === 'INR') {
////                                    alert("currencyText" + currencyText11[0]);
//                                        $("#currencyTravelDivId" + i).children('option').hide();
//                                        document.getElementById("currencyTravelDivId" + i).options[i2].selected = "true";
//
//                                    }
//                                } catch (e) {
//
//                                }
//                            }
//
//                        } else {
                        $("#currencyTravelDivId" + i).children('option').show();
//                        }

                        document.getElementById("relocationCurrency_td_" + i).style.display = 'block';
                        document.getElementById("relocationCurrencyId").style.display = 'block';
//                        alert("Insid Trvel");

                    }
                    for (var i = 1; i <= countSecond; i++) {
                        $("#currencyRelocationDivId" + i).children('option').show();
                        document.getElementById("otherCurrrency_th").style.display = 'block';
                        document.getElementById("otherCurrrency_td_" + i).style.display = 'block';
                    }
                    var val = 0;
                    changeAmount1(val);

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
                    $('#travelAppDateDiv_id').hide();
                    $('#localTravelId').hide();

                    for (var i = 1; i <= othersCount; i++) {
                        var element2 = document.getElementById("currencyOtherDiv" + i);
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
                                    $("#currencyOtherDiv" + i).children('option').hide();
                                    document.getElementById("currencyOtherDiv" + i).options[i2].selected = "true";

                                }
                            } catch (e) {

                            }
                        }
                        document.getElementById("currency_div_th").style.display = 'none';
                        document.getElementById("currency_div_td_" + i).style.display = 'none';
                    }
                    var val;
                    changeAmount1(val);

                }
                else if (selectedValue === "Relocation") {
                    $('#demo').show();
                    $('#demo2').show();
                    $('#demo3').hide();
                    $('#otherDivId').hide();
                    $('#applicationDivId').hide();
                    $('.travelGEId').hide();
                    $('.RelocationGTEId').show();
                    $('#policyDivId').hide();
                    $('#travelAppDateDiv_id').hide();
                    $('#localTravelId').hide();
                    var countFirst = document.getElementById("countFirst").value;

//                    alert("countSecond" + countSecond);
                    for (var i = 1; i <= countFirst; i++) {


                        var element2 = document.getElementById("currencyTravelDivId" + i);
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
                                    $("#currencyTravelDivId" + i).children('option').hide();
                                    document.getElementById("currencyTravelDivId" + i).options[i2].selected = "true";

                                }
                            } catch (e) {

                            }
                        }
                        document.getElementById("relocationCurrency_td_" + i).style.display = 'none';
                        document.getElementById("relocationCurrencyId").style.display = 'none';

//                        $('relocationCurrency_td_' + i).hide();
//                        $('relocationCurrencyId').hide();
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
                        document.getElementById("otherCurrrency_th").style.display = 'none';
                        document.getElementById("otherCurrrency_td_" + i).style.display = 'none';
                    }
                    //                }

                    var val;
                    changeAmount1(val);

                }
                else if (selectedValue === "PolicyReimbursements") {
                    $('#demo').hide();
                    $('#demo2').show();
                    $('#demo3').hide();
                    $('#applicationDivId').hide();
                    $('#otherDivId').hide();
                    $('.travelGEId').hide();
                    $('.RelocationGTEId').hide();
                    $('#policyDivId').show();
                    $('#travelAppDateDiv_id').hide();
                    $('#localTravelId').show();
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
                        document.getElementById("otherCurrrency_th").style.display = 'none';
                        document.getElementById("otherCurrrency_td_" + i).style.display = 'none';
                    }
                    var val;
                    changeAmount1(val);
                }
                else {
                    $('#demo').hide();
                    $('#demo2').show();
                    $('#demo3').hide();
                    $('#applicationDivId').hide();
                    $('#otherDivId').hide();
                    $('.travelGEId').hide();
                    $('.RelocationGTEId').hide();
                    $('#policyDivId').hide();
                    $('#travelAppDateDiv_id').hide();
                     $('#localTravelId').hide();
                }
            });
        });</script>


    <script>
        var i1 = 1;
        var tempCount = 1;
        $(function () {
            $("#addRowButtonId").on("click", function () {
                //                alert(i1);
                i1++;
                tempCount++;
                //                alert(tempCount);
                var clone = "<tr id='1moreFile" + i1 + "' style='clear:both;'>"
                        + "<td style=\"text-align: center\">" + i1 + "</td>"
                        + "<td><input type=\"Text\" name='fromCity" + tempCount + "' id='fromCity" + tempCount + "' class=\"form-control\" ><span id=\"fromCityError" + tempCount + "\" style=\"color: red;\"></span></td>"
                        + "<td><input type=\"Text\" name='toCity" + tempCount + "' id='toCity" + tempCount + "' class=\"form-control\" ><span id=\"toCityError" + tempCount + "\" style=\"color: red;\"></span></td>"
                        + "<td>"
                        + "<input class=\"form-control\" size=\"16\" name='travelDate" + tempCount + "' id='datepickerr" + tempCount + "' type=\"text\"  id=\"datepickerr" + tempCount + "\"  style=\"width: 95px\" onchange=\"expenseDateValidate(" + i1 + ");\">"
                        + "<span id=\"travelDateError" + tempCount + "\" style=\"color: red;\"></span><span id=\"traveldateValidateError" + i1 + "\" style=\"color: red;display: none\">Select Date Between Start & End Date</span></td>"
                        + "<td><div><select id=\"WorkTypeSelectId" + tempCount + "\" name='WorkTypeSelect" + tempCount + "' class=\"form-control\" >"
                        + "<option value=\"\"> --SELECT-- </option>"
                        + "<option value=\"Air\"> Air </option>"
                        + "<option value =\"Train\"> Train </option>"
                        + "<option value =\"Bus\"> Bus </option>"
                        + "<option value =\"Cab\"> Cab </option>"
                        + "<option value =\"AutoRickshaw\"> Auto Rickshaw </option>"
                        + "</select>"
                        + "</div><span id=\"WorkTypeSelectIdError" + tempCount + "\" style=\"color: red;\"></span></td>"
                        + "<td style=\"width: 125px\"><input type=\"number\" name='amount" + tempCount + "' id='amount" + tempCount + "' class=\"form-control\" onchange=\"calculateAmount();\"  min=\"0\"><span id=\"amountError" + tempCount + "\" style=\"color: red;\"></span></td>"
                        + "<td id=\"relocationCurrency_td_" + tempCount + "\"><div><select id='currencyTravelDivId" + tempCount + "' class=\"form-control\" name='currencyTravelDiv" + tempCount + "' onchange=\"changeAmount1(this.value);\" >"
                        + "</select>"
                        + "</div><span id=\"currencyTravelDivIdError" + tempCount + "\" style=\"color: red;\"></span></td>"
                        //                        + "<td style=\"text-align: center\"><span></span></td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\" value=\"-\" id=\"removeRowButtonId\" onclick=\"removeChild3('1moreFile" + i1 + "','" + tempCount + "');\">"
                        + "</span>"
                        + "</td>"
                        + "</tr>";
                document.getElementById('countFirst').value = tempCount;
                $("#demo").append(clone);
                optionsAdd(tempCount);
                $("#datepickerr" + tempCount).datepicker({dateFormat: 'dd/mm/yy'});


                var expenseType = document.getElementById('expenseType').value;
                //                alert(expenseType);
                if (expenseType == "Relocation") {
                    var element2 = document.getElementById("currencyTravelDivId" + tempCount);
                    for (var i2 = 0; i2 < element2.options.length; i2++) {
                        var opt2 = document.createElement("option");
                        var currencyVal = element2.options[i2].value;
                        //                            alert("currencyVal" + currencyVal);
                        var currencyText = element2.options[i2].text;
                        try {
                            currencyText = currencyText.split('(');

                            var currencyText11 = currencyText[1];
                            currencyText11 = currencyText11.split(')');
                            if (currencyText11[0] == 'INR') {
                                $("#currencyTravelDivId" + tempCount).children('option').hide();
                                document.getElementById("currencyTravelDivId" + tempCount).options[i2].selected = "true";

                            }
                        } catch (e) {

                        }
                    }
                    document.getElementById("relocationCurrency_td_" + tempCount).style.display = 'none';
                    document.getElementById("relocationCurrencyId").style.display = 'none';
                    //                    }
                }
                if (document.getElementById('travelType').value == 'Domestic') {
                    var element2 = document.getElementById("currencyTravelDivId" + tempCount);
                    for (var i2 = 0; i2 < element2.options.length; i2++) {
                        var currencyVal = element2.options[i2].value;
                        //                        alert("currencyVal" + currencyVal);
                        var currencyText = element2.options[i2].text;
                        try {
                            currencyText = currencyText.split('(');
                            var currencyText11 = currencyText[1];
                            //                            alert("currencyText11" + currencyText11);
                            currencyText11 = currencyText11.split(')');
                            if (currencyText11[0] === 'INR') {
                                //                                alert("currencyText" + currencyText11[0]);
                                $("#currencyTravelDivId" + tempCount).children('option').hide();
                                document.getElementById("currencyTravelDivId" + tempCount).options[i2].selected = "true";

                            }
                        } catch (e) {

                        }
                    }

                } else {
                    $("#currencyTravelDivId" + tempCount).children('option').show();
                }


            });
        });
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

        function removeChild3(removeRowId, currentCount) {
            //            alert("ajay" + removeRowId);
            tempCount--;
            i1--;
            try {

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
        }
        function removeChildOther(removeRowId, currentCount) {
            //            alert("ajay" + removeRowId);
            i3--;
            tempCount1--;
            try {

                var currencyOtherDiv = document.getElementById("currencyOtherDiv" + currentCount).value;
                var policyAmount = parseFloat(document.getElementById("policyAmount" + currentCount).value);
                var totalAmount = document.getElementById("totalAmount_" + currencyOtherDiv).value;

                var finalTotal = parseFloat(totalAmount) - parseFloat(policyAmount);
                // Removes an element from the document
                document.getElementById("totalAmount_" + currencyOtherDiv).value = finalTotal;
            } catch (e) {

            }
            //            tempCount--;
            // Removes an element from the document
            var element = document.getElementById(removeRowId);
            element.parentNode.removeChild(element);
            var id;
            changeAmount1(id);
        }</script>
    <script>
        $(function () {
            $("#datepickerr1").datepicker({dateFormat: 'dd/mm/yy'});
        });
        $(function () {
            $("#datepicker1").datepicker({dateFormat: 'dd/mm/yy'});
        });
        $(function () {
            $("#otherExpenseDate1").datepicker({dateFormat: 'dd/mm/yy'});
        });
    </script>
    <script>
        var tempCount3 = 1;
        $(function () {
            $("#addButtonFoodCategoryId").on("click", function () {
                //                alert(i1);

                tempCount3++;
                //                alert(tempCount3);
                var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"
                        + "<td style=\"text-align: center\">" + tempCount3 + "</td>"
                        + "<td><input class='form-control' size='16' type='text' id='otherExpenseDate" + tempCount3 + "' name='otherExpenseDate" + tempCount3 + "' value=''>"
                        + "<span id='otherExpenseDateError"+tempCount3+"' style='color: red;'></span>"
                        + "</td>"
                        + "<td><div><select id=\"RentAndFoodDiv" + tempCount3 + "\" name='RentAndFoodDiv" + tempCount3 + "' class=\"form-control\" onchange=otherEnble(" + tempCount3 + "); >"
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
                        + "</div><span id=\"RentAndFoodDivError" + tempCount3 + "\" style=\"color: red;\"></span></td>"
                        + "<td><input type=\"Text\" name=\"purpose" + tempCount3 + "\" class=\"form-control\" id=\"otherOptionId" + tempCount3 + "\" style=\"display: none\" placeholder=\"(Please Specify In case of Other)\" ></td>"
                        + "<td><input type=\"number\" name='otherAmount" + tempCount3 + "' id='otherAmount" + tempCount3 + "' min=\"0\" class=\"form-control\" onchange=\"calculateAmount();\"><span id=\"otherAmountError" + tempCount3 + "\" style=\"color: red;\"></span></td>"
                        + "<td id=\"otherCurrrency_td_" + tempCount3 + "\"><div><select id='currencyRelocationDivId" + tempCount3 + "' name='currencyRelocationDiv" + tempCount3 + "' class=\"form-control\" onchange=\"changeAmount1(this.value);\" >"
                        + "</select>"
                        + "</div><span id=\"currencyRelocationDivIdError" + tempCount3 + "\" style=\"color: red;\"></span></td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\"value=\"-\" id=\"removeRowButtonId\" onclick=\"removeChild2('addmoreFile" + tempCount3 + "','" + tempCount3 + "');\">"
                        + "</span>"
                        + "</td>"
                        + "</tr>";
                $("#demo2").append(clone);
                document.getElementById('countSecond').value = tempCount3;
                var expenseType = document.getElementById('expenseType').value;
                optionsAdd1(tempCount3);
                $("#otherExpenseDate" + tempCount3).datepicker({dateFormat: 'dd/mm/yy'});
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

                    var otherCount = document.getElementById('othersCount').value;
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


                //                for (var i = 1; i <= countSecond; i++) {
                var expenseType = document.getElementById('expenseType').value;
                //                alert(expenseType);
                if (expenseType == "Relocation" || expenseType == "PolicyReimbursements") {
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
                    document.getElementById("otherCurrrency_th").style.display = 'none';
                    document.getElementById("otherCurrrency_td_" + tempCount3).style.display = 'none';
                }

                var countFirst = document.getElementById("countFirst").value;
                var countSecond = document.getElementById("countSecond").value;
//                    alert(countFirst);
//                for (var i = 1; i <= countFirst; i++) {
                //                    var travelType = document.getElementById("travelType").value;
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

//                }


            });
        });
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

        function removeChild2(removeRowId, currentCount) {
            //            alert("currentCount" + currentCount);
            tempCount3--;
            try {

                var currencyRelocationDiv = document.getElementById("currencyRelocationDivId" + currentCount).value;
                var otherAmount = parseFloat(document.getElementById("otherAmount" + currentCount).value);
                var totalAmount = document.getElementById("totalAmount_" + currencyRelocationDiv).value;

                var finalTotal = parseFloat(totalAmount) - parseFloat(otherAmount);
                // Removes an element from the document
                document.getElementById("totalAmount_" + currencyRelocationDiv).value = finalTotal;
            } catch (e) {

            }
            var element = document.getElementById(removeRowId);
            element.parentNode.removeChild(element);
            var id;
            changeAmount1(id);
            //            calculateAmount();

            //            });
        }
    </script>
    <script>
        var i3 = 1;
        tempCount1 = 1;
        $(function () {
            $("#addButtonOtherTableId").on("click", function () {
                tempCount1++;
                i3++;
                var clone3 = "<tr id='addmoreFile" + i3 + "' style='clear:both;'>"
                        + "<td style=\"text-align: center\">" + i3 + "</td>"
                        + "<td style=\"width: 20%\">"
                        //        <div class=\"input-group date form_datetime\" data-date-format=\"dd/mm/yyyy\" data-link-format=\"dd/mm/yyyy\" data-link-field=\"dtp_input1\">"
                        //                        + "<input class=\"form-control\" name='billDate" + tempCount1 + "' size=\"16\" type=\"text\" value=\"\" readonly>"
                        + "<input class=\"form-control\" size=\"16\" type=\"text\" id=\"datepicker" + tempCount1 + "\" name='billDate" + tempCount1 + "' value=\"\" >"
                        //                        + "<span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-th\"></span></span>"
                        //                        + "</div>\n\
                        + "<span id=\"billDateError" + tempCount1 + "\" style=\"color: red;\"></span></td>"
                        + "<td><input type=\"Text\" name='billNo" + tempCount1 + "' id='billNo" + tempCount1 + "'  class=\"form-control\" ><span id=\"billNoError" + tempCount1 + "\" style=\"color: red;\"></span></td>"
                        + "<td><input type=\"number\" name='policyAmount" + tempCount1 + "' id='policyAmount" + tempCount1 + "' min=\"0\" class=\"form-control\" onchange=\"calculateAmount();\" ><span id=\"policyAmountError" + tempCount1 + "\" style=\"color: red;\"></span></td>"
                        + "<td id=\"currency_div_td_" + tempCount1 + "\"><div>"
                        + "<select id='currencyOtherDiv" + tempCount1 + "' name='otherCurrency" + tempCount1 + "' class=\"form-control\" onchange=\"changeAmount1(this.value);\" >"
                        + "</select>"
                        + "</div></td>"
                        //                        + "<td style=\"text-align: center\"><span></span></td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\"value=\"-\" id=\"removeRowButtonId\" onclick=\"removeChildOther('addmoreFile" + i3 + "','" + tempCount1 + "');\">"
                        + "</span>"
                        + "</td>"
                        + "</tr>"
                $("#demo3").append(clone3);
                document.getElementById('othersCount').value = tempCount1;
                //                alert(tempCount1);
                optionsAdd2(tempCount1);
                $("#datepicker" + tempCount1).datepicker({dateFormat: 'dd/mm/yy'});

                var element2 = document.getElementById("currencyOtherDiv" + tempCount1);
                for (var i2 = 0; i2 < element2.options.length; i2++) {
                    var currencyVal = element2.options[i2].value;
                    var currencyText = element2.options[i2].text;
                    try {
                        currencyText = currencyText.split('(');
                        var currencyText11 = currencyText[1];
                        //                        alert("currencyText11" + currencyText11);
                        currencyText11 = currencyText11.split(')');
                        if (currencyText11[0] === 'INR') {
                            //                            alert("currencyText" + currencyText11[0]);
                            $("#currencyOtherDiv" + tempCount1).children('option').hide();
                            //                            alert(document.getElementById("currencyOtherDiv" + tempCount1).options[i2] + "qqqq");
                            document.getElementById("currencyOtherDiv" + tempCount1).options[i2].selected = "true";

                        }
                    } catch (e) {

                    }
                }
                document.getElementById("currency_div_th").style.display = 'none';
                document.getElementById("currency_div_td_" + tempCount1).style.display = 'none';

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
    </script>
    <script>
        $(function () {
            $("#RentAndFoodDiv1").on("change", function () {
                var selectedValue = this.value;
                if (selectedValue == "Other") {
                    $('#otherOptionId').show();
                    $('#otherPurposeId').show();
                }
                else {
                    $('#otherOptionId').hide();
                    $('#otherPurposeId').hide();
                }
            });
        });

        function otherEnble(id) {
            var selectedVal = document.getElementById("RentAndFoodDiv" + id).value;
            if (selectedVal == "Other") {
                $('#otherOptionId' + id).show();
            } else {
                $('#otherOptionId' + id).hide();
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



        function saveSubmit11() {
            var flag3 = true;
            var travelNo = document.getElementById("travelNo").value;
            var expenseType = document.getElementById("expenseType").value;
            var countFirst = document.getElementById("countFirst").value;
            var countSecond = document.getElementById("countSecond").value;
            var othersCount = document.getElementById("othersCount").value;
            if (expenseType == 'Travel') {

                if (travelNo == '') {
                    document.getElementById("travelNoError").innerHTML = '- Please Select Travel Request Application No.';
                    flag3 = false;
                } else {
                    document.getElementById("travelNoError").innerHTML = '';
                }

                for (var i = 1; i <= countFirst; i++) {
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
                for (var i = 1; i <= countSecond; i++) {

                    if (document.getElementById("RentAndFoodDiv" + i).value == '') {
                        document.getElementById("RentAndFoodDivError" + i).innerHTML = '- It must not be empty or whitespace';
                        flag3 = false;
                    } else {
                        document.getElementById("RentAndFoodDivError" + i).innerHTML = '';
                    }
                    if (document.getElementById("otherAmount" + i).value == '') {
                        document.getElementById("otherAmountError" + i).innerHTML = '- It must not be empty or whitespace';
                        flag3 = false;
                    } else {
                        document.getElementById("otherAmountError" + i).innerHTML = '';
                    }
                    if (document.getElementById("currencyRelocationDivId" + i).value == '') {
                        document.getElementById("currencyRelocationDivIdError" + i).innerHTML = '- It must not be empty or whitespace';
                        flag3 = false;
                    } else {
                        document.getElementById("currencyRelocationDivIdError" + i).innerHTML = '';
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

                for (var i = 1; i <= countSecond; i++) {

                    if (document.getElementById("RentAndFoodDiv" + i).value == '') {
                        document.getElementById("RentAndFoodDivError" + i).innerHTML = '- It must not be empty or whitespace';
                        flag3 = false;
                    } else {
                        document.getElementById("RentAndFoodDivError" + i).innerHTML = '';
                    }
                    if (document.getElementById("otherAmount" + i).value == '') {
                        document.getElementById("otherAmountError" + i).innerHTML = '- It must not be empty or whitespace';
                        flag3 = false;
                    } else {
                        document.getElementById("otherAmountError" + i).innerHTML = '';
                    }

                }

            } else if (expenseType == 'Others') {
//                var specify = document.getElementById("Specify").value = '';
                if (document.getElementById("Specify").value == '') {
                    document.getElementById("specifyError").innerHTML = '- It must not be empty or whitespace';
                    flag3 = false;
                } else {
                    document.getElementById("specifyError").innerHTML = '';
                }
                for (var i = 1; i <= othersCount; i++) {
                    if (document.getElementById("datepicker" + i).value == '') {
                        document.getElementById("billDateError" + i).innerHTML = '- It must not be empty or whitespace';
                        flag3 = false;
                    } else {
                        document.getElementById("billDateError" + i).innerHTML = '';
                    }
                    if (document.getElementById("billNo" + i).value == '') {
                        document.getElementById("billNoError" + i).innerHTML = '- It must not be empty or whitespace';
                        flag3 = false;
                    } else {
                        document.getElementById("billNoError" + i).innerHTML = '';
                    }
                    if (document.getElementById("policyAmount" + i).value == '') {
                        document.getElementById("policyAmountError" + i).innerHTML = '- It must not be empty or whitespace';
                        flag3 = false;
                    } else {
                        document.getElementById("policyAmountError" + i).innerHTML = '';
                    }

                }


            } else if (expenseType == 'Relocation') {
                for (var i = 1; i <= countFirst; i++) {
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

                }
                for (var i = 1; i <= countSecond; i++) {

                    if (document.getElementById("RentAndFoodDiv" + i).value == '') {
                        document.getElementById("RentAndFoodDivError" + i).innerHTML = '- It must not be empty or whitespace';
                        flag3 = false;
                    } else {
                        document.getElementById("RentAndFoodDivError" + i).innerHTML = '';
                    }
                    if (document.getElementById("otherAmount" + i).value == '') {
                        document.getElementById("otherAmountError" + i).innerHTML = '- It must not be empty or whitespace';
                        flag3 = false;
                    } else {
                        document.getElementById("otherAmountError" + i).innerHTML = '';
                    }

                }
            }

//            var currencyMapId = document.getElementById("currencyMapId").value;
//            alert("currencyMapId" + currencyMapId);

//            for (var z = 1; z <= currencyMapId; z++) {
//                var currencyCount = document.getElementById("currencyCount_" + z).value;
//                try {
//                    alert("zzzzzz" + z);
////                    var paidByCompany = document.getElementById("paidByCompany" + z).value;
////                    var advanceCash = document.getElementById("advanceCash" + z).value;
////                    var cashReturned = document.getElementById("cashReturned" + z).value;
//                    if (document.getElementById("paidByCompany" + z).value == "") {
//                        document.getElementById("paidByCompanyError" + z).innerHTML = "- It must not be empty or whitespace";
//                        flag3 = false;
//                    } else {
//                        document.getElementById("paidByCompanyError" + z).innerHTML = "";
//                    }
//                    if (document.getElementById("advanceCash" + z).value == "") {
//                        document.getElementById("advanceCashError" + z).innerHTML = "- It must not be empty or whitespace";
//                        flag3 = false;
//                    } else {
//                        document.getElementById("advanceCashError" + z).innerHTML = "";
//                    }
//                    if (document.getElementById("cashReturned" + z).value == "") {
//                        document.getElementById("cashReturnedError" + z).innerHTML = "- It must not be empty or whitespace";
//                        flag3 = false;
//                    } else {
//                        document.getElementById("cashReturnedError" + z).innerHTML = "";
//                    }
//                } catch (e) {
//
//                }
////                var displayExpense_ = document.getElementById("displayExpense_" + z).value;
////                alert("displayExpense_" + displayExpense_);
//
//            }

            if (flag3) {
                flag3 = false;
                document.getElementById('saveSubmit1').innerHTML = 'Saving ... .. .';
                document.form1.submit();
                return true;
            } else {
                return false;
            }

        }</script>

    <script>
        function travelAppNoAjax() {
            var travelNo = document.getElementById("travelNo").value;

            $.ajax({
                type: "POST",
                url: "travelRequestMaster.htm?act=getTravelDatesAjax",
                data: {"travelNo": travelNo},
                dataType: "text",
                success: function (responseTxt) {
                    var newText = responseTxt.split("~");
                    //                    alert(newText);
                    document.getElementById("travelStartDate").value = newText[0];
                    document.getElementById("travelEndDate").value = newText[1];
                    document.getElementById("travelType").value = newText[2];
                    //                    alert(newText[2]);
                    var countFirst = document.getElementById("countFirst").value;
                    var countSecond = document.getElementById("countSecond").value;
//                    alert(countFirst);
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

//                        document.getElementById("relocationCurrency_td_" + i).style.display = 'block';
//                        document.getElementById("relocationCurrencyId").style.display = 'block';



                },
                error: function () {
                    alert('Error occured');
                }
            });

        }

        function expenseDateValidate(id) {
            var expenseType = document.getElementById('expenseType').value;
            var datepickerr = document.getElementById('datepickerr' + id).value;
            var travelStartDate = document.getElementById('travelStartDate').value;
            var travelEndDate = document.getElementById('travelEndDate').value;
            if (expenseType == 'Travel') {
                travelStartDate = travelStartDate.split('-');
                var newStartDate = travelStartDate[0].split("/");
                newStartDate = new Date(newStartDate[2], newStartDate[1] - 1, newStartDate[0]);

                travelEndDate = travelEndDate.split('-');
                var newEndDate = travelEndDate[0].split("/");
                newEndDate = new Date(newEndDate[2], newEndDate[1] - 1, newEndDate[0]);

                datepickerr = datepickerr.split('/');
                datepickerr = new Date(datepickerr[2], datepickerr[1] - 1, datepickerr[0]);

                if (datepickerr < newStartDate || datepickerr > newEndDate) {

                    $('#traveldateValidateError' + id).show();
                    setTimeout(function () {
                        $("#traveldateValidateError" + id).fadeOut();
                    }, 5000);
                    setTimeout(function () {
                        document.getElementById("datepickerr" + id).value = "";
                    }, 5200);

                }

            }

        }
    </script>


    <body>
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>Expense Report:</h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Expense Report</li>
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
                                <form:form action="expenseMaster.htm?act=submitExpenseReport" method="post" commandName="expenseMaster" name='form1' class="form-horizontal" role="form" onsubmit='return saveSubmit11();'>
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
                                                            <input type="Text" class="form-control" value="${employeeMaster.employeeId}" readonly="true">
                                                            <input type="hidden" name="empId" value="${employeeMaster.id}">
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label>Employee Name:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control" value="${employeeMaster.employeeName}" readonly="true">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Designation:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control" value="${employeeMaster.designationMaster.designationName}" readonly="true">
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label>Level:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control" value="${employeeMaster.levelMaster.level}" readonly="true">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Department:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control" value="${employeeMaster.departmentMaster.departmentName}" readonly="true">
                                                        </div>

                                                        <div class="col-sm-2">
                                                            <label>Work Location:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control" value="${employeeMaster.locationMaster.location}" readonly="true">
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
                                                            <input type="Text" class="form-control" value="${employeeMaster.child1}" readonly="true">
                                                            <input type="hidden" name="ApproverId1" value="${employeeMaster.reportingManagerLevel1}">
                                                            <input type="hidden" name="ApproverId2" value="${employeeMaster.reportingManagerLevel2}">
                                                        </div>
                                                        <!--<div class="col-sm-2">-->
                                                        <!--<label>Date of Form Submit:</label>-->
                                                        <!--</di/v>-->
                                                        <!--<div class="col-sm-4">-->
                                                        <!--<div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">-->
                                                        <jsp:useBean id="now" class="java.util.Date" />
                                                        <fmt:formatDate type="date"  value="${now}" var="today" pattern="dd/MM/yyyy" />
                                                        <form:hidden class="form-control" path="dateOfSubmit" value="${today}" />
                                                        <!--<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>-->
                                                        <!--</div>-->
                                                        <!--</div>-->
                                                    </div>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <!--Employee detail completes here-->
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

                                                            <form:select path="expenseType" id="expenseType" class="form-control" >
                                                                <form:option  label="--Select--" value=""></form:option>
                                                                <form:option  label="Travel" value="Travel"></form:option>
                                                                <form:option  label="Relocation" value="Relocation"></form:option>
                                                                <form:option  label="Policy Reimbursements" value="PolicyReimbursements"></form:option>
                                                                <form:option label="Others" value="Others"></form:option>
                                                            </form:select>
                                                            <span id="expenseTypeError" style="color: red;"></span>
                                                        </div>
                                                    </div>
                                                    <div class="form-group" id="otherDivId" style="display: none">
                                                        <label class="col-sm-3 control-label">Please Specify:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="col-sm-7">
                                                            <textarea class="form-control" name="Specify" id="Specify" placeholder="(Please Specify Other Here.)" ></textarea>
                                                            <span id="specifyError" style="color: red;"></span>
                                                        </div>
                                                    </div>
                                                    <div class="form-group" id="applicationDivId" style="display: none">
                                                        <label class="col-sm-3 control-label">Travel Request Application No.:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="col-sm-7">
                                                            <select name="travelNo" id="travelNo" class="form-control" onchange="travelAppNoAjax(
                                                                            );">
                                                                <option value="" label="-- Select --" />
                                                                <c:forEach var="travel" items="${travelNo}">
                                                                    <option value="${travel.key}">${travel.value}</option>
                                                                </c:forEach>
                                                            </select>
                                                            <span id="travelNoError" style="color: red;"></span>
                                                        </div>
                                                    </div>
                                                    <div class="form-group" id="policyDivId" style="display: none">
                                                        <label class="col-sm-3 control-label">Please Specify:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="col-sm-7">
                                                            <textarea class="form-control" name="policyNo" id="policyNo" placeholder="(Please Specify Other Here.)"></textarea>
                                                            <span id="policyNoError" style="color: red;"></span>
                                                        </div>
                                                    </div>

                                                    <div class="form-group" id="travelAppDateDiv_id" style="display: none">
                                                        <div class="col-sm-3" style="text-align: right">
                                                            <label>Start Date:</label>
                                                        </div>
                                                        <div class="col-sm-3" style="text-align: right">
                                                            <div class="input-group date form_datetime1" data-date-format="dd/mm/yyyy - hh:ii " data-link-field="dtp_input1">
                                                            <input type="Text" name="travelStartDate" id="travelStartDate" class="form-control" value="" readonly="true">
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        </div>

                                                        <div class="col-sm-1" style="text-align: right">
                                                            <label>End Date:</label>
                                                        </div>
                                                        <div class="col-sm-3" style="text-align: right">
                                                            <div class="input-group date form_datetime1" data-date-format="dd/mm/yyyy - hh:ii " data-link-field="dtp_input1">
                                                            <input type="Text" name="travelEndDate" id="travelEndDate" class="form-control" value="" readonly="true">
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
                                                    <div class="table-responsive">
                                                        <table id="demo" class="table table-bordered table-striped table-hover" style="display: none" align="Center"  >
                                                            <tr>
                                                                <th style="text-align: center; vertical-align: middle;width: 5%">Sr.No.</th>
                                                                <th style="text-align: center; vertical-align: middle">From City <span style="color: red;font-size: 12px;">*</span></th>
                                                                <th style="text-align: center; vertical-align: middle">To City <span style="color: red;font-size: 12px;">*</span></th>
                                                                <th style="text-align: center; vertical-align: middle">Date <span style="color: red;font-size: 12px;">*</span></th>
                                                                <th style="text-align: center; vertical-align: middle">Mode of Travel <span style="color: red;font-size: 12px;">*</span></th>
                                                                <th style="text-align: center; vertical-align: middle">Amount <span style="color: red;font-size: 12px;">*</span></th>
                                                                <th style="text-align: center; vertical-align: middle" id="relocationCurrencyId">Currency <span style="color: red;font-size: 12px;">*</span></th>
                                                                <!--<th style="text-align: center; vertical-align: middle;width: 6%">Approve</th>-->
                                                                <th style="text-align: center; vertical-align: middle;width: 7%">Add New</th>
                                                            <input type="hidden" name="TravelExpCount" value="1"/>
                                                            </tr>
                                                            <tr>
                                                            <input type="hidden" name="countFirst" id="countFirst" value="1"/>
                                                            <input type="hidden" name="countSecond" id="countSecond" value="1"/>
                                                            <td style="text-align: center">1</td>
                                                            <td><input type="Text" name="fromCity1" id="fromCity1" class="form-control" >
                                                                <span id="fromCityError1" style="color: red;"></span>
                                                            </td>
                                                            <td><input type="Text" name="toCity1" id="toCity1" class="form-control" >
                                                                <span id="toCityError1" style="color: red;"></span>
                                                            </td>
                                                            <td style="width: 10px">
                                                                <input class="form-control" size="16" type="text" id="datepickerr1" name="travelDate1" value=""  style="width: 95px" onchange="expenseDateValidate(1
                                                                                );" >
                                                                <span id="travelDateError1" style="color: red;"></span>
                                                                <span id="traveldateValidateError1" style="color: red;display: none">Select Date Between Start Date & End Date</span>
                                                                <!--                                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>-->
                                                            </td>

                                                            <td><div>
                                                                    <select id="WorkTypeSelectId1" name="WorkTypeSelect1" class="form-control" >
                                                                        <option value="">--SELECT--</option>
                                                                        <option value="Air">Air</option>
                                                                        <option value="Train">Train</option>
                                                                        <option value="Bus">Bus</option>
                                                                        <option value="Cab">Cab</option>
                                                                        <option value="AutoRickshaw">Auto Rickshaw</option>
                                                                    </select>
                                                                </div>
                                                                <span id="WorkTypeSelectIdError1" style="color: red;"></span>
                                                            </td>
                                                            <td style="width: 125px"><input type="number" name="amount1" id="amount1" min="0" class="form-control" onchange="calculateAmount(
                                                                            );" >
                                                                <span id="amountError1" style="color: red;"></span>
                                                            </td>
                                                            <input type="hidden" id="currencyMapId" name="currencyMapId" value="${fn:length(currencyMap)}">
                                                            <td id="relocationCurrency_td_1"><div>
                                                                    <select id="currencyTravelDivId1" name="currencyTravelDiv1" class="form-control"  onchange="changeAmount1(this.value)">
                                                                        <option value="">--SELECT--</option>
                                                                        <c:forEach var="currency" items="${currencyMap}">
                                                                            <option value="${currency.key}">${currency.value}</option>
                                                                        </c:forEach>
                                                                    </select>
                                                                </div>
                                                                <span id="currencyTravelDivIdError1" style="color: red;"></span>
                                                            </td>
                                                            <!--<td style="text-align: center"><span></span></td>-->
                                                            <td style="text-align: center">
                                                                <span style='margin-top: 5px;'>
                                                                    <input type="button" value="+" id="addRowButtonId" />
                                                                </span>
                                                            </td>
                                                            </tr>

                                                        </table>
                                                    </div>

                                                </div><!-- /.col -->
                                                <!--                                                <div class="form-group" style="padding-left: 100px" >
                                                                                                    <label class="col-lg-9 control-label">Sub Total:</label>
                                                                                                    <div class="col-lg-3" style="width: 19.2%">
                                                                                                        <input type="text" class="form-control" >
                                                                                                    </div>
                                                                                                </div>-->
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="table-responsive">
                                                        <table id="demo2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                            <tr>
                                                                <th style="text-align: center; vertical-align: middle;width: 5%">Sr.No.</th>
                                                                <th style="text-align: center; vertical-align: middle;width: 12%">Date<span style="color: red;font-size: 12px;">*</span></th>
                                                                <th style="text-align: center; vertical-align: middle">Other Expense<span style="color: red;font-size: 12px;">*</span></th>
                                                                <th style="text-align: center; vertical-align: middle"><span id="otherPurposeId" style="display: none">Purpose</span></th>
                                                                <th style="text-align: center; vertical-align: middle;width: 12%">Amount<span style="color: red;font-size: 12px;">*</span></th>
                                                                <th style="text-align: center; vertical-align: middle" id="otherCurrrency_th">Currency<span style="color: red;font-size: 12px;">*</span></th>
                                                                <!--<th style="text-align: center; vertical-align: middle;width: 6%">Approve</th>-->
                                                                <th style="text-align: center; vertical-align: middle;width: 7%">Add New</th>
                                                            <input type="hidden" name="OtherExpCount" value="1"/>
                                                            </tr>
                                                            <tr>
                                                                <td style="text-align: center">1</td>
                                                                <td>
                                                                    <input class="form-control" size="16" type="text" id="otherExpenseDate1" name="otherExpenseDate1" value="" >
                                                                    <span id="otherExpenseDateError1" style="color: red;"></span>
                                                                </td>
                                                                <td><div>
                                                                        <select id="RentAndFoodDiv1" name='RentAndFoodDiv1' class="form-control" onchange="otherEnble(1);">
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
                                                                    </div>
                                                                    <span id="RentAndFoodDivError1" style="color: red;"></span>
                                                                </td>
                                                                <td><input type="Text" name="purpose1" class="form-control" id="otherOptionId1" style="display: none" placeholder="(Please Specify In case of Other)" ></td>
                                                                <!--<td><input type="Text" name="otherAmount1" id="otherAmount1"  class="form-control" ></td>-->
                                                                <td><input type="number" name="otherAmount1" id="otherAmount1" min="0" class="form-control" onchange="calculateAmount();">
                                                                    <span id="otherAmountError1" style="color: red;"></span>
                                                                </td>
                                                                <td  id="otherCurrrency_td_1"><div>
                                                                        <select id="currencyRelocationDivId1" name="currencyRelocationDiv1" class="form-control" onchange="changeAmount1(this.value);" >
                                                                            <option value="">--SELECT--</option>
                                                                            <c:forEach var="currency" items="${currencyMap}">
                                                                                <option value="${currency.key}">${currency.value}</option>
                                                                            </c:forEach>
                                                                        </select>
                                                                    </div>
                                                                    <span id="currencyRelocationDivIdError1" style="color: red;"></span>
                                                                </td>
                                                                <!--                                                                <td style="text-align: center">
                                                                                                                                    <span></span>
                                                                                                                                </td>-->
                                                                <td style="text-align: center">
                                                                    <span style='margin-top: 5px;'>
                                                                        <input type="button" value="+" id="addButtonFoodCategoryId" />
                                                                    </span>
                                                                </td>
                                                            </tr>

                                                        </table>
                                                    </div>

                                                </div>
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="table-responsive">
                                                        <table id="demo3" class="table table-bordered table-striped table-hover" style="display: none" align="Center"  >
                                                            <tr>
                                                                <th style="text-align: center; vertical-align: middle;width: 5%">Sr.No.</th>
                                                                <th style="text-align: center; vertical-align: middle;width: 12%">Invoice/Bill Date<span style="color: red;font-size: 12px;">*</span></th>
                                                                <th style="text-align: center; vertical-align: middle">Invoice/Bill No.<span style="color: red;font-size: 12px;">*</span></th>
                                                                <th style="text-align: center; vertical-align: middle">Amount<span style="color: red;font-size: 12px;">*</span></th>
                                                                <th style="text-align: center; vertical-align: middle" id="currency_div_th">Currency</th>
                                                                <!--<th style="text-align: center; vertical-align: middle;width: 6%">Approve</th>-->
                                                                <th style="text-align: center; vertical-align: middle;width: 7%">Add New</th>
                                                            </tr>
                                                            <tr>
                                                            <input type="hidden" name="othersCount" id="othersCount" value="1"/>
                                                            <td style="text-align: center">1</td>
                                                            <td>
                                                                <input class="form-control" size="16" type="text" id="datepicker1" name="billDate1" value="">
                                                                <span id="billDateError1" style="color: red;"></span>
                                                            </td>
                                                            <td><input type="Text" name="billNo1" id="billNo1" class="form-control" >
                                                                <span id="billNoError1" style="color: red;"></span>
                                                            </td>
                                                            <td><input type="number" name="policyAmount1" id="policyAmount1" min="0" class="form-control" onchange="calculateAmount();" >
                                                                <span id="policyAmountError1" style="color: red;"></span>
                                                            </td>
                                                            <td id="currency_div_td_1"><div>
                                                                    <select id="currencyOtherDiv1" name="otherCurrency1" class="form-control" onchange="changeAmount1(this.value);" >
                                                                        <option value="">--SELECT--</option>
                                                                        <c:forEach var="currency" items="${currencyMap}">
                                                                            <option value="${currency.key}">${currency.value}</option>
                                                                        </c:forEach>
                                                                    </select>
                                                                </div>
                                                                <span id="currencyOtherDivError1" style="color: red;"></span>
                                                            </td>
                                                            <!--                                                            <td style="text-align: center">
                                                                                                                            <span></span>
                                                                                                                        </td>-->
                                                            <td style="text-align: center">
                                                                <span style='margin-top: 5px;'>
                                                                    <input type="button" value="+" id="addButtonOtherTableId" />
                                                                </span>
                                                            </td>
                                                            </tr>

                                                        </table>
                                                    </div>

                                                </div>
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
                                                                <th style="text-align: center;display: none" id="display_${currency.key}">Amount (<label id="lab_${currency.key}" >${currency.value}</label>)</th>
                                                                <!--<th style="text-align: center;" id="display2">Amount (<label id="lab2"></label>)</th>-->
                                                                <!--<th style="text-align: center;" id="display3">Amount (<label id="lab3"></label>)</th>-->
                                                            </c:forEach>
                                                            </tr>
                                                            <tr id="cell2">
                                                                <td style="vertical-align: middle">Expense in this Report</td>
                                                                <c:forEach var="currency" items="${currencyMap}" varStatus="status">
                                                                    <td id="displayExpense_${currency.key}" style="display: none;" ><input type="number" name="totalAmount_${currency.key}" id="totalAmount_${currency.key}" value="0.0" class="form-control"  readonly="" disabled="true"  min="0"/></td>
                                                                    </c:forEach>
                                                                <!--<td id="display2" ><input type="text"  class="form-control"/></td>-->
                                                                <!--<td id="display3" ><input type="text"  class="form-control"/></td>-->
                                                            </tr>
                                                            <tr id="cell3">
                                                                <td style="vertical-align: middle">Expense paid by Company<span style="color: red;font-size: 16px;">*</span></td>
                                                                <c:forEach var="currency" items="${currencyMap}" varStatus="status">
                                                                    <td id="paidByCompany_${currency.key}" style="display: none;" ><input type="number" name="paidByCompany${currency.key}" id="paidByCompany${currency.key}" min="0"  class="form-control" onchange="calculateVariance(${currency.key}

                                                                            );" />
                                                                        <span id="paidByCompanyError${currency.key}" style="color: red;"></span>
                                                                    </td>
                                                                </c:forEach>
                                                                <!--<td id="display2" style="display: none;"><input type="text"  class="form-control"/></td>-->
                                                                <!--<td id="display3" style="display: none;"><input type="text"  class="form-control"/></td>-->
                                                            </tr>
                                                            <tr id="cell4">
                                                                <td style="vertical-align: middle">Cash Advance<span style="color: red;font-size: 16px;">*</span></td>
                                                                <c:forEach var="currency" items="${currencyMap}" varStatus="status">

                                                                    <td id="advanceCash_${currency.key}" style="display: none;" ><input type="number" name="advanceCash${currency.key}" id="advanceCash${currency.key}" min="0" class="form-control" onchange="calculateVariance(${currency.key}
                                                                            );" />
                                                                        <span id="advanceCashError${currency.key}" style="color: red;"></span>
                                                                    </td>
                                                                </c:forEach>
                                                                <!--<td id="display2" ><input type="text"  class="form-control"/></td>-->
                                                                <!--<td id="display3" ><input type="text"  class="form-control"/></td>-->
                                                            </tr>
                                                            <tr id="cell5">
                                                                <td style="vertical-align: middle">Cash Returned<span style="color: red;font-size: 16px;">*</span></td>
                                                                <c:forEach var="currency" items="${currencyMap}" varStatus="status">
                                                                    <td id="cashReturned_${currency.key}" style="display: none;" ><input type="number" name="cashReturned${currency.key}" id="cashReturned${currency.key}" min="0" class="form-control" onchange="calculateVariance(${currency.key}
                                                                            );" />
                                                                        <span id="cashReturnedError${currency.key}" style="color: red;"></span>
                                                                    </td>
                                                                </c:forEach>
                                                                <!--<td id="display2" ><input type="text"  class="form-control"/></td>-->
                                                                <!--<td id="display3" ><input type="text"  class="form-control"/></td>-->
                                                            </tr>
                                                            <tr id="cell6">
                                                                <td style="vertical-align: middle">Variance Owed to Employee</td>
                                                                <c:forEach var="currency" items="${currencyMap}" varStatus="status">
                                                                    <td id="variance_${currency.key}" style="display: none;" ><input type="number" name="variance${currency.key}" id="variance${currency.key}" min="0" class="form-control" onchange="calculateVariance(${currency.key}

                                                                            );" readonly=""/>

                                                                    </td>
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
                                        <div class="col-sm-6" style="text-align: left">
                                            <button type="submit" class="btn btn-warning" name="btnType" data-original-title="" title="" value="Save" style="width: 100px">SAVE</button>
                                            <!--<input type="submit" class="btn btn-success"  name="btnType" value="Save" style="width: 100px">-->
                                        </div>
                                        <div class="col-sm-6" style="text-align: right">
                                            <button type="submit" class="btn btn-primary" name="btnType" data-original-title="" title="" value="Submit" style="width: 100px">SUBMIT</button>
                                            <!--<input type="submit" class="btn btn-primary" name="btnType" value="Submit" style="width: 100px">-->
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
                language: 'fr', weekStart: 1,
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
//                alert("calculateAmount");
                var countFirst = document.getElementById("countFirst").value;
//                alert("countFirst 11 :" + countFirst);
                var countSecond = document.getElementById("countSecond").value;
//                alert("countSecond 22 :" + countSecond);
                var othersCount = document.getElementById("othersCount").value;
//                alert("othersCount 33 :" + othersCount);
                var currencyMapId = document.getElementById("currencyMapId").value;
//                alert("currencyMapId" + currencyMapId);

                var currencyRelocationDiv;
                var currencyTravelDivId;
                var currencyOtherDiv;
                for (var j = 1; j <= currencyMapId; j++) {
//                    alert("currencyCount1");

                    var currencyCount = document.getElementById("currencyCount_" + j).value;
//                    alert("currencyCount" + currencyCount);
                    var finalCheck = 0;

                    for (var i = 1; i <= countFirst; i++) {
                        currencyTravelDivId = document.getElementById("currencyTravelDivId" + i).value;
                        try {
                            var amount = parseFloat(document.getElementById("amount" + i).value);
//                            alert("amount" + amount);
                            if (isNaN(amount)) {
                                amount = 0;
                            }
                            //                            alert("Amount 1: " + amount);
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
//                            alert("otherAmount" + otherAmount);
                            if (isNaN(otherAmount)) {
                                otherAmount = 0;
                            }
                            //                            alert("Amount 2: " + otherAmount);
                            if (currencyRelocationDiv === currencyCount) {
                                finalCheck += parseFloat(otherAmount);
                            }
                        } catch (e) {

                        }
                    }
                    for (var i = 1; i <= othersCount; i++) {
                        currencyOtherDiv = document.getElementById("currencyOtherDiv" + i).value;
                        try {
                            var policyAmount = parseFloat(document.getElementById("policyAmount" + i).value);
//                            alert("policyAmount" + policyAmount);
                            if (isNaN(policyAmount)) {
                                policyAmount = 0;
                            }
                            if (currencyOtherDiv === currencyCount) {
                                finalCheck += parseFloat(policyAmount);
                            }
                        } catch (e) {
                        }
                    }
//                    alert("fi" + finalCheck);
                    document.getElementById("totalAmount_" + currencyCount).value = finalCheck;
                    calculateVariance(currencyCount);
                }
            }
        </script>
        <script>
            var currency = new Array();
            function changeAmount1(val) {
                //                                alert('val' + val);
                try {
                    var currencyMapId = document.getElementById("currencyMapId").value;

                    for (var z = 1; z <= currencyMapId; z++) {
                        var currencyCount = document.getElementById("currencyCount_" + z).value;

                        document.getElementById("display_" + currencyCount).style.display = 'none';
                        document.getElementById("displayExpense_" + currencyCount).style.display = 'none';
                        document.getElementById("paidByCompany_" + currencyCount).style.display = 'none';
                        document.getElementById("advanceCash_" + currencyCount).style.display = 'none';
                        document.getElementById("cashReturned_" + currencyCount).style.display = 'none';
                        document.getElementById("variance_" + currencyCount).style.display = 'none';
                    }

                    var currencyTravelDiv = [];
                    var currencyRelocationDiv = [];
                    var currencyOtherDiv = [];
                    var finalNew = [];
                    var countFirst = document.getElementById("countFirst").value;
                    var countSecond = document.getElementById("countSecond").value;
                    var othersCount = document.getElementById("othersCount").value;
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
                    for (var i = 1; i <= othersCount; i++) {
                        try {
                            currencyOtherDiv.push(document.getElementById("currencyOtherDiv" + i).value);
                        } catch (e) {

                        }
                    }
                    var finalArray = [];
                    finalNew = currencyRelocationDiv.concat(currencyTravelDiv);
                    finalArray = finalNew.concat(currencyOtherDiv);
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
                } catch (e) {
//                    alert("Catch Call");
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
