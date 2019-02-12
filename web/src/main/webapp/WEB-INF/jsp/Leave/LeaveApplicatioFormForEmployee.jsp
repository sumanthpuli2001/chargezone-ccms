<%--
    Document   : LeaveApplicatioFormForEmployee
    Created on : Oct 6, 2015, 11:17:03 AM
    Author     : Irfan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <script>
        $(function () {
            $('#uAsSickId').hide();
        });

    </script>
    <script>
        function checkDaysValidation(id) {
//            alert("hello" + id);
        }
    </script>
    <script>
        function pat() {

            bootbox.dialog({
                title: "<h1>Important Policy Notes</h1>",
                size: 'large',
                //            message: "Oh ! Your Weightage Score is Not Valid…",
                message: '<b>You should be legally married for availing this benefit\
                    <br>  You can avail PT Leave benefit only for a maximum of two times during your employment\
                    <br>You can avail a maximum of 3 Leaves at once before or after the delivery of your child\
                    <br>If you avail less than 3 leaves, one slot of 3 leaves will be deducted from your PT Leave Balance\
                    <br><br><br><div><input type="checkbox" style="width: 20px;height: 20px;" id="Public_Web" onclick="pat1(this);">&nbsp;<font size="4">I have read and understood the Important Policy Notes pertaining to Paternity Leave and I agree to follow the same.</font></div></b>\
                     <div id="accept_button_id" style="display: none;"> <p align="center"><button type="button" onclick="abClick();"  class="btn btn-primary" style="width: 100px;" data-original-title="" title="">Accept</button></p></div>',
                callback: function () { /* your callback code */
                }
            })
//            bootbox.alert("Hello world!", function () {
//                Example.show("Hello world callback");
//            });
        }





    </script>
    <script>
        function abClick() {
            bootbox.hideAll();
            document.getElementById("sunmit_button").disabled = false;
        }
        function pat1(cb) {
            if (cb.checked) {
                $("#accept_button_id").show();
            } else {
                $("#accept_button_id").hide();
            }
        }
    </script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Leave Application</title>
    </head>

    <script>
        var flag3 = true;
        var flagco = true;
        function saveSubmit11() {
            var skillsSelect = document.getElementById("leaveTypeMaster.id");
            var selectedText = skillsSelect.options[skillsSelect.selectedIndex].text;
            var selectedTextArray = selectedText.split('(');
            selectedText = selectedTextArray[0];
//            alert(selectedText);
            if (document.getElementById("leaveTypeMaster.id").value == '') {
                document.getElementById("leaveTypeMasterError").innerHTML = "- It must not be empty or whitespace";
                setTimeout(function () {
                    $("#leaveTypeMasterError").fadeOut();
                }, 10000);
                flag3 = false;
            } else {
                document.getElementById("leaveTypeMasterError").innerHTML = "";
            }
            if (document.getElementById("empRemark").value == '') {
                document.getElementById("empRemarkError").innerHTML = "- It must not be empty or whitespace";
                flag3 = false;
            } else {
                document.getElementById("empRemarkError").innerHTML = "";
            }
            if (selectedText !== 'Short Leave' && selectedText !== 'C Off Leave') {
                if (document.getElementById("startDate").value == '') {
                    document.getElementById("startDateError").innerHTML = "- It must be Selected";
                    flag3 = false;
                } else {
                    document.getElementById("startDateError").innerHTML = "";
                }
                if (document.getElementById("leaveStartDate_SelectFullOrHalfId").value == '') {
                    document.getElementById("startDateSelectFullOrHalfError").innerHTML = "- It must be Selected";
                    flag3 = false;
                } else {
                    document.getElementById("startDateSelectFullOrHalfError").innerHTML = "";
                }
                if (document.getElementById("endDate").value == '') {
                    document.getElementById("endDateError").innerHTML = "- It must be Selected";
                    flag3 = false;
                } else {
                    document.getElementById("endDateError").innerHTML = "";
                }
                if ((document.getElementById("startDate").value == '' && document.getElementById("endDate").value == '')) {
                    if (document.getElementById("leaveEndDate_SelectFullOrHalfId").value == '') {
                        document.getElementById("endDateSelectFullOrHalfError").innerHTML = "- It must be Selected";
                        flag3 = false;
                    } else {
                        document.getElementById("endDateSelectFullOrHalfError").innerHTML = "";
                    }
                } else if ((document.getElementById("startDate").value == document.getElementById("endDate").value)) {
                    document.getElementById("endDateSelectFullOrHalfError").innerHTML = "";
                }
                else {
                    if ((document.getElementById("startDate").value !== document.getElementById("endDate").value)) {
                        if (document.getElementById("leaveEndDate_SelectFullOrHalfId").value == '') {
                            document.getElementById("endDateSelectFullOrHalfError").innerHTML = "- It must be Selected";
                            flag3 = false;
                        } else {
                            document.getElementById("endDateSelectFullOrHalfError").innerHTML = "";
                        }
                    }
                }
            }
            if (selectedText == 'Short Leave') {
                if (document.getElementById("endDateShort").value == '') {
                    document.getElementById("shortleaveendDateError").innerHTML = "- It must be Selected";
                    flag3 = false;
                } else {
                    document.getElementById("shortleaveendDateError").innerHTML = "";
                }
                if (document.getElementById("startDateShort").value == '') {
                    document.getElementById("shortleavestartDateError").innerHTML = "- It must be Selected";
                    flag3 = false;
                } else {
                    document.getElementById("shortleavestartDateError").innerHTML = "";
                }
            }



            //             if (document.getElementById("empRemark").value == '') {
            //                    document.getElementById("empRemarkError").innerHTML = "- It must not be empty or whitespace";
            //                    setTimeout(function () {
            //                        $("#empRemarkError").fadeOut();
            //                    }, 10000);
            //                    flag3 = false;
            //                } else {
            //                    document.getElementById("empRemarkError").innerHTML = "";
            //                }
            //            }

//            if (document.getElementById("noOfDays").value == '') {
//                document.getElementById("noOfDaysError").innerHTML = "You Cannot Apply Leave on Week Off or Holiday";
//                setTimeout(function () {
//                    $("#noOfDaysError").fadeOut();
//                }, 10000);
//                flag3 = false;
//            } else {
//                document.getElementById("noOfDaysError").innerHTML = "";
//            }
//            if (selectedText !== 'Short Leave') {
//
//                if (document.getElementById("startDate").value == '') {
//                    document.getElementById("startDateError").innerHTML = "- It must not be empty or whitespace";
//                    flag3 = false;
//                    setTimeout(function () {
//                        $("#startDateError").fadeOut();
//                    }, 10000);
//                } else {
//                    document.getElementById("startDateError").innerHTML = "";
//                }
//                if (document.getElementById("endDate").value == '') {
//                    document.getElementById("endDateError").innerHTML = "- It must not be empty or whitespace";
//                    setTimeout(function () {
//                        $("#endDateError").fadeOut();
//                    }, 10000);
//                    flag3 = false;
//                } else {
//                    document.getElementById("endDateError").innerHTML = "";
//                }
//                if (document.getElementById("empRemark").value == '') {
//                    document.getElementById("empRemarkError").innerHTML = "- It must not be empty or whitespace";
//                    setTimeout(function () {
//                        $("#empRemarkError").fadeOut();
//                    }, 10000);
//                    flag3 = false;
//                } else {
//                    document.getElementById("empRemarkError").innerHTML = "";
//                }
//            }
//alert("flag3"+flag3);
            if (flag3) {
                flag3 = false;
                document.getElementById('saveSubmit1').innerHTML = 'Saving ... .. .';
                document.form1.submit();
                return true;
            } else {
                return false;
            }
        }

        $(function () {
            var previous;
            var strUser;
            $('#leaveTypeMaster.id').focus(function () {
                previous = $("#leaveTypeMaster.id option:selected").text();
                var strUser1 = previous.split('(');
                strUser = strUser1[0]

                //                alert('ajay11zzzzzzzzz' + strUser1[0]);
                //                alert('xxxxxxxxxxxx' + document.getElementById(strUser).innerHTML);
                document.getElementById(strUser).innerHTML = 0;
                document.getElementById(strUser + "2").innerHTML = 0;
            }).change(function () {

            })
        })();
        //        $(document).ready(function () {
        //            $('#leaveTypeMaster.id').on('focus', 'select', function () {
        //                var previous = $(this).children('option').filter(':selected').val();
        //                alert('ajay' + previous);
        //            });
        //        });




        //        $(function () {
        function leaveSetting() {
//            alert("2Aman");
            var leaveStartDate = document.getElementById("startDate").value;
            var leaveStartDate_SelectFullOrHalf = document.getElementById("leaveStartDate_SelectFullOrHalfId").value;
//            alert("flagco" + flagco);

            if (flagco) {
                if (document.getElementById("startDate").value !== '' && document.getElementById("endDate").value == '') {
                    document.getElementById("endDate").value = document.getElementById("startDate").value;
//                document.getElementById("noOfDays").value = 1;
                    document.getElementById("leaveEndDate_SelectFullOrHalfId").style.display = 'none';
                    flagco = false;
                }
            } else {
                document.getElementById("noOfDays").value = '';
                if (document.getElementById("endDate").value == document.getElementById("startDate").value) {
//                    document.getElementById("noOfDays").value = 1;
                    document.getElementById("leaveEndDate_SelectFullOrHalfId").style.display = 'none';
                } else {
                    document.getElementById("leaveEndDate_SelectFullOrHalfId").style.display = 'block';
                }
            }
            var leaveEndDate = document.getElementById("endDate").value;
            var leaveEndDate_SelectFullOrHalf = document.getElementById("leaveEndDate_SelectFullOrHalfId").value;
            var leaveType = document.getElementById("leaveTypeMaster.id");
            var selectedText = leaveType.options[leaveType.selectedIndex].text;
            var selectedTextArray = selectedText.split('(');
            selectedText = selectedTextArray[0];
            document.getElementById('Sick Leave1').innerHTML;
            document.getElementById('Casual Leave1').innerHTML;
            if (selectedText == "Paternity Leave") {
                if (leaveEndDate == leaveStartDate) {
                    $("#leaveStartDate_SelectFullOrHalfId option[value='Fullday']").show();
                    $("#leaveEndDate_SelectFullOrHalfId option[value='FirstHalf']").hide();
                    $("#leaveEndDate_SelectFullOrHalfId option[value='SecondHalf']").hide();
                    $("#leaveStartDate_SelectFullOrHalfId option[value='FirstHalf']").hide();
                    $("#leaveStartDate_SelectFullOrHalfId option[value='SecondHalf']").hide();
                } else if (leaveEndDate == "") {
                    $("#leaveEndDate_SelectFullOrHalfId option[value='Fullday']").show();
                    $("#leaveEndDate_SelectFullOrHalfId option[value='FirstHalf']").hide();
                    $("#leaveEndDate_SelectFullOrHalfId option[value='SecondHalf']").hide();
                    $("#leaveStartDate_SelectFullOrHalfId option[value='FirstHalf']").hide();
                    $("#leaveStartDate_SelectFullOrHalfId option[value='SecondHalf']").hide();
                }
                else {
                    $("#leaveEndDate_SelectFullOrHalfId option[value='Fullday']").show();
                    $("#leaveEndDate_SelectFullOrHalfId option[value='FirstHalf']").hide();
                    $("#leaveEndDate_SelectFullOrHalfId option[value='SecondHalf']").hide();
                    $("#leaveStartDate_SelectFullOrHalfId option[value='FirstHalf']").hide();
                    $("#leaveStartDate_SelectFullOrHalfId option[value='SecondHalf']").hide();
                }
            } else if (selectedText == "Privilege Leave") {
                var plFlag = ${plBalCheck};
                if (leaveEndDate == leaveStartDate) {
                    if (document.getElementById('Sick Leave1').innerHTML <= 0 && document.getElementById('Casual Leave1').innerHTML <= 0) {
                        $("#leaveStartDate_SelectFullOrHalfId option[value='Fullday']").show();
                        $("#leaveEndDate_SelectFullOrHalfId option[value='FirstHalf']").show();
                        $("#leaveEndDate_SelectFullOrHalfId option[value='SecondHalf']").show();
                        $("#leaveStartDate_SelectFullOrHalfId option[value='FirstHalf']").show();
                        $("#leaveStartDate_SelectFullOrHalfId option[value='SecondHalf']").show();
                    } else {
                        $("#leaveStartDate_SelectFullOrHalfId option[value='Fullday']").show();
                        if (plFlag == true) {

                            $("#leaveStartDate_SelectFullOrHalfId option[value='FirstHalf']").show();
                            $("#leaveStartDate_SelectFullOrHalfId option[value='SecondHalf']").show();
                        } else {
                            $("#leaveStartDate_SelectFullOrHalfId option[value='FirstHalf']").hide();
                            $("#leaveStartDate_SelectFullOrHalfId option[value='SecondHalf']").hide();
                        }
                        $("#leaveEndDate_SelectFullOrHalfId option[value='FirstHalf']").show();
                        $("#leaveEndDate_SelectFullOrHalfId option[value='SecondHalf']").hide();
                    }

                } else if (leaveEndDate == "") {
                    if (document.getElementById('Sick Leave1').innerHTML <= 0 && document.getElementById('Casual Leave1').innerHTML <= 0) {
                        $("#leaveEndDate_SelectFullOrHalfId option[value='Fullday']").show();
                        $("#leaveEndDate_SelectFullOrHalfId option[value='FirstHalf']").show();
                        $("#leaveEndDate_SelectFullOrHalfId option[value='SecondHalf']").show();
                        $("#leaveStartDate_SelectFullOrHalfId option[value='FirstHalf']").show();
                        $("#leaveStartDate_SelectFullOrHalfId option[value='SecondHalf']").show();
                    } else {
                        $("#leaveEndDate_SelectFullOrHalfId option[value='Fullday']").show();
                        if (plFlag == true) {
                            $("#leaveStartDate_SelectFullOrHalfId option[value='FirstHalf']").show();
                            $("#leaveStartDate_SelectFullOrHalfId option[value='SecondHalf']").show();
                        } else {
                            $("#leaveStartDate_SelectFullOrHalfId option[value='FirstHalf']").hide();
                            $("#leaveStartDate_SelectFullOrHalfId option[value='SecondHalf']").hide();
                        }
                        $("#leaveEndDate_SelectFullOrHalfId option[value='FirstHalf']").hide();
                        $("#leaveEndDate_SelectFullOrHalfId option[value='SecondHalf']").hide();
                    }

                }
                else {
                    if (document.getElementById('Sick Leave1').innerHTML <= 0 && document.getElementById('Casual Leave1').innerHTML <= 0) {
                        $("#leaveEndDate_SelectFullOrHalfId option[value='Fullday']").show();
                        $("#leaveEndDate_SelectFullOrHalfId option[value='FirstHalf']").show();
                        $("#leaveEndDate_SelectFullOrHalfId option[value='SecondHalf']").show();
                        $("#leaveStartDate_SelectFullOrHalfId option[value='FirstHalf']").show();
                        $("#leaveStartDate_SelectFullOrHalfId option[value='SecondHalf']").show();
                    } else {
                        $("#leaveEndDate_SelectFullOrHalfId option[value='Fullday']").show();
                        if (plFlag == true) {
                            $("#leaveStartDate_SelectFullOrHalfId option[value='FirstHalf']").show();
                            $("#leaveStartDate_SelectFullOrHalfId option[value='SecondHalf']").show();
                        } else {
                            $("#leaveStartDate_SelectFullOrHalfId option[value='FirstHalf']").hide();
                            $("#leaveStartDate_SelectFullOrHalfId option[value='SecondHalf']").hide();
                        }
                        $("#leaveEndDate_SelectFullOrHalfId option[value='FirstHalf']").hide();
                        $("#leaveEndDate_SelectFullOrHalfId option[value='SecondHalf']").hide();
                    }

                }

            } else {
                if (leaveEndDate == leaveStartDate) {
                    $("#leaveStartDate_SelectFullOrHalfId option[value='Fullday']").show();
                    $("#leaveStartDate_SelectFullOrHalfId option[value='FirstHalf']").show();
                    $("#leaveStartDate_SelectFullOrHalfId option[value='SecondHalf']").show();
                    if (leaveStartDate_SelectFullOrHalf == "Fullday") {
                        $("#leaveEndDate_SelectFullOrHalfId option[value='Fullday']").show();
                        $("#leaveEndDate_SelectFullOrHalfId option[value='FirstHalf']").hide();
                        $("#leaveEndDate_SelectFullOrHalfId option[value='SecondHalf']").hide();
                    }
                    if (leaveStartDate_SelectFullOrHalf == "FirstHalf") {
//                    alert("its fh");
                        $("#leaveEndDate_SelectFullOrHalfId option[value='FirstHalf']").show();
                        $("#leaveEndDate_SelectFullOrHalfId option[value='Fullday']").hide();
                        $("#leaveEndDate_SelectFullOrHalfId option[value='SecondHalf']").hide();
                    }
                    if (leaveStartDate_SelectFullOrHalf == "SecondHalf") {
//                    alert("its sh");
                        $("#leaveEndDate_SelectFullOrHalfId option[value='SecondHalf']").show();
                        $("#leaveEndDate_SelectFullOrHalfId option[value='Fullday']").hide();
                        $("#leaveEndDate_SelectFullOrHalfId option[value='FirstHalf']").hide();
                    }
                }
                else if (leaveEndDate == "") {
                    $("#leaveEndDate_SelectFullOrHalfId option[value='Fullday']").show();
                    $("#leaveEndDate_SelectFullOrHalfId option[value='FirstHalf']").show();
                    $("#leaveEndDate_SelectFullOrHalfId option[value='SecondHalf']").hide();
                    $("#leaveStartDate_SelectFullOrHalfId option[value='Fullday']").show();
                    $("#leaveStartDate_SelectFullOrHalfId option[value='FirstHalf']").hide();
                    $("#leaveStartDate_SelectFullOrHalfId option[value='SecondHalf']").show();
                }
                else {
                    $("#leaveEndDate_SelectFullOrHalfId option[value='Fullday']").show();
                    $("#leaveEndDate_SelectFullOrHalfId option[value='FirstHalf']").show();
                    $("#leaveEndDate_SelectFullOrHalfId option[value='SecondHalf']").hide();
                    $("#leaveStartDate_SelectFullOrHalfId option[value='Fullday']").show();
                    $("#leaveStartDate_SelectFullOrHalfId option[value='FirstHalf']").hide();
                    $("#leaveStartDate_SelectFullOrHalfId option[value='SecondHalf']").show();
                    if (document.getElementById("leaveStartDate_SelectFullOrHalfId").value == 'FirstHalf') {
                        document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
                    }
                }
            }

            //                }
            //            catch (e) {
            //            }
            //            daysCount();
        }

        function modelopenpopup() {
            var leaveType = document.getElementById("leaveTypeMaster.id");
            var selectedText = leaveType.options[leaveType.selectedIndex].text;
            var selectedTextArray = selectedText.split('(');
            selectedText = selectedTextArray[0];
            if (selectedText == "Paternity Leave") {
                document.getElementById("sunmit_button").disabled = true;
                pat();
            }

        }


        function leaveTypecheck() {
//            alert("3Aman");
            var leaveType = document.getElementById("leaveTypeMaster.id");
            var selectedText = leaveType.options[leaveType.selectedIndex].text;
            var selectedTextArray = selectedText.split('(');
            selectedText = selectedTextArray[0];
            var leaveTypeDays = selectedTextArray[1];
            leaveTypeDays = leaveTypeDays.replace(')', '');
            var leaveStartDate = document.getElementById("startDate").value;
            var leaveEndDate = document.getElementById("endDate").value;
            calculateDayByAjax();
            leaveStartDate = leaveStartDate.split('/');
            leaveEndDate = leaveEndDate.split('/');
            leaveStartDate = new Date(leaveStartDate[2], leaveStartDate[1], leaveStartDate[0]);
            leaveEndDate = new Date(leaveEndDate[2], leaveEndDate[1], leaveEndDate[0]);
            var leaveDays = document.getElementById("hiddenDays").value;
            var days = document.getElementById("noOfDays").value = leaveDays;
//        if (selectedText == 'Leave Without Pay') {
//        if (days > 60) {
//        $("#leaveWithoutPayLeaveDiv").show();
//        document.getElementById("endDate").value = '';
//        setTimeout(function () {
//        $("#leaveWithoutPayLeaveDiv").fadeOut();
//        }, 5000);
//        }
//
//        }
        }

        function daysCount() {
//            alert("4Aman");
            var skillsSelect = document.getElementById("leaveTypeMaster.id");
            var selectedText = skillsSelect.options[skillsSelect.selectedIndex].text;
            var selectedTextArray = selectedText.split('(');
            selectedText = selectedTextArray[0];
            if (selectedText == 'Short Leave') {

                $("#NoshortLeave").hide();
                $("#shortLeave").show();
                document.getElementById('Sick Leave').innerHTML = "0";
                document.getElementById('Sick Leave2').innerHTML = document.getElementById('Sick Leave1').innerHTML;
                document.getElementById('Casual Leave').innerHTML = "0";
                document.getElementById('Casual Leave2').innerHTML = document.getElementById('Casual Leave1').innerHTML;
                document.getElementById('Privilege Leave').innerHTML = "0";
                document.getElementById('Privilege Leave2').innerHTML = document.getElementById('Privilege Leave1').innerHTML;
            } else {
                $("#NoshortLeave").show();
                $("#shortLeave").hide();
                var now = new Date();
                var n_date = document.getElementById("startDate").value;
                n_date = n_date.split("/");
                n_date = n_date[1] + "/" + n_date[0] + "/" + n_date[2];
                var leaveStartDate = document.getElementById("startDate").value;
                var leaveStartDateForSat = document.getElementById("startDate").value;
                var leaveStartDate_Copy = document.getElementById("startDate").value;
                var leaveEndDate = document.getElementById("endDate").value;
                var leaveEndDate_Copy = document.getElementById("endDate").value;
                var leaveStartDate_SelectFullOrHalf = document.getElementById("leaveStartDate_SelectFullOrHalfId").value;
                var leaveEndDate_SelectFullOrHalf = document.getElementById("leaveEndDate_SelectFullOrHalfId").value;
// First we split the values to arrays date1[0] is the day, [1] the month and [2] the year
                leaveStartDate = leaveStartDate.split('/');
                leaveStartDateForSat = leaveStartDateForSat.split('/');
                leaveEndDate = leaveEndDate.split('/');
// Now we convert the array to a Date object, which has several helpful methods
                leaveStartDate = new Date(leaveStartDate[2], leaveStartDate[1], leaveStartDate[0]);
                leaveStartDateForSat = new Date(leaveStartDateForSat[2], (leaveStartDateForSat[1] - 1), leaveStartDateForSat[0]);
                leaveEndDate = new Date(leaveEndDate[2], leaveEndDate[1], leaveEndDate[0]);
                var leaveDays = ((leaveEndDate - leaveStartDate) / (1000 * 60 * 60 * 24)) + 1;
                var leaveDays1 = document.getElementById("hiddenDays").value;
                var strUser;
                var strUser1;
                var leaveTypes = document.getElementById("leaveTypeMaster.id");
                var newstrDate = leaveTypes.options[leaveTypes.selectedIndex].text;
                strUser1 = newstrDate.split('(');
                strUser = strUser1[0];
                var strUser2 = strUser1[1];
                strUser2 = strUser2.split(')');
                var leaveBalance = strUser2[0];
                if (strUser == 'Short Leave' || strUser == 'Paternity Leave' || strUser == 'C Off Leave' || strUser == 'Leave Without Pay' || strUser == 'Maternity Leave') {
                    document.getElementById('Sick Leave').innerHTML = "0";
                    document.getElementById('Sick Leave2').innerHTML = document.getElementById('Sick Leave1').innerHTML;
                    document.getElementById('Casual Leave').innerHTML = "0";
                    document.getElementById('Casual Leave2').innerHTML = document.getElementById('Casual Leave1').innerHTML;
                    document.getElementById('Privilege Leave').innerHTML = "0";
                    document.getElementById('Privilege Leave2').innerHTML = document.getElementById('Privilege Leave1').innerHTML;
                }
                if (document.getElementById("startDate").value != "" && document.getElementById("endDate").value != "") {


                    if (leaveEndDate_Copy == leaveStartDate_Copy) {
                        if (leaveStartDate_SelectFullOrHalf == "Fullday") {
                            if (leaveDays1 == 0) {
                                document.getElementById("noOfDays").value = "";
                            } else {

                                document.getElementById("noOfDays").value = leaveDays1;
                            }

                            if (strUser == "Sick Leave") {

                                if (parseFloat(document.getElementById("noOfDays").value) > 3) {
                                    $("#sickLeaveDiv").show();
                                    setTimeout(function () {
                                        $("#sickLeaveDiv").fadeOut();
                                    }, 5000);
                                }
                                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                                document.getElementById('Casual Leave').innerHTML = "0";
                                document.getElementById('Casual Leave2').innerHTML = document.getElementById('Casual Leave1').innerHTML;
                                document.getElementById('Privilege Leave').innerHTML = "0";
                                document.getElementById('Privilege Leave2').innerHTML = document.getElementById('Privilege Leave1').innerHTML;
                            }
                            if (strUser == "Casual Leave") {
                                if (parseFloat(document.getElementById("noOfDays").value) > 2) {
                                    $("#calsualLeaveDiv").show();
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = '';
                                    setTimeout(function () {
                                        $("#calsualLeaveDiv").fadeOut();
                                    }, 5000);
                                    document.getElementById("noOfDays").value = "";
                                }
                                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                                document.getElementById('Sick Leave').innerHTML = "0";
                                document.getElementById('Sick Leave2').innerHTML = document.getElementById('Sick Leave1').innerHTML;
                                document.getElementById('Privilege Leave').innerHTML = "0";
                                document.getElementById('Privilege Leave2').innerHTML = document.getElementById('Privilege Leave1').innerHTML;
                            }
                            var plBalFlag = ${plBalCheck};
                            if (strUser == "Privilege Leave") {
                                if (document.getElementById('Sick Leave1').innerHTML > 0 && plBalFlag == true) {
                                    if (parseFloat(document.getElementById("noOfDays").value) < 3) {
////                                        alert("1hussain");
////                                        $("#plDiv").show();
//                                        setTimeout(function () {
//                                            $("#plDiv").fadeOut();
//                                        }, 5000);
//                                        document.getElementById("noOfDays").value = "";
//                                        document.getElementById("startDate").value = "";
//                                        document.getElementById("endDate").value = "";
//                                        document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
//                                        document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                                    }

                                }
                                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                                document.getElementById('Casual Leave').innerHTML = "0";
                                document.getElementById('Casual Leave2').innerHTML = document.getElementById('Casual Leave1').innerHTML;
                                document.getElementById('Sick Leave').innerHTML = "0";
                                document.getElementById('Sick Leave2').innerHTML = document.getElementById('Sick Leave1').innerHTML;
                            }
//        if (strUser == "Leave Without Pay") {
//        if (parseFloat(document.getElementById("noOfDays").value) > 60) {
//        $("#leaveWithoutPayLeaveDiv").show();
//        document.getElementById("endDate").value = '';
//        document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
//        setTimeout(function () {
//        $("#leaveWithoutPayLeaveDiv").fadeOut();
//        }, 5000);
//        }
//        if (parseFloat(leaveDays1) > parseFloat(leaveBalance)) {
//        $("#balanceDiv").show();
//        setTimeout(function () {
//        $("#balanceDiv").fadeOut();
//        }, 5000);
//        document.getElementById("noOfDays").value = "";
//        document.getElementById("startDate").value = "";
//        document.getElementById("endDate").value = "";
//        document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
//        document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
//        }
//        }

                            if (strUser == "Paternity Leave") {
                                if (parseFloat(document.getElementById("noOfDays").value) > 3) {
                                    $("#paternityLeaveDiv").show();
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = '';
                                    setTimeout(function () {
                                        $("#paternityLeaveDiv").fadeOut();
                                    }, 5000);
                                    document.getElementById("noOfDays").value = "";
                                }
                                if (parseFloat(leaveDays1) > parseFloat(leaveBalance)) {
                                    $("#balanceDiv").show();
                                    setTimeout(function () {
                                        $("#balanceDiv").fadeOut();
                                    }, 5000);
                                    document.getElementById("noOfDays").value = "";
                                    document.getElementById("startDate").value = "";
                                    document.getElementById("endDate").value = "";
                                    document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                                }
                            } else {

                                if (parseFloat(document.getElementById(strUser).innerHTML) > parseFloat(document.getElementById(strUser + "1").innerHTML)) {
                                    $("#balanceDiv").show();
                                    setTimeout(function () {
                                        $("#balanceDiv").fadeOut();
                                    }, 5000);
                                    document.getElementById(strUser).innerHTML = 0;
                                    document.getElementById("noOfDays").value = "";
                                    document.getElementById(strUser + "2").innerHTML = 0;
                                    document.getElementById("startDate").value = "";
                                    document.getElementById("endDate").value = "";
                                    document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                                } else {
                                    document.getElementById(strUser + "2").innerHTML = document.getElementById(strUser + "1").innerHTML - document.getElementById(strUser).innerHTML;
                                }
                            }
                        }
                        if (leaveStartDate_SelectFullOrHalf == "FirstHalf") {
                            if (leaveDays1 == 0) {
                                document.getElementById("noOfDays").value = " ";
                            } else {
                                document.getElementById("noOfDays").value = parseFloat(leaveDays1) - 0.5;
                            }
                            if (strUser == "Sick Leave") {

                                if (parseFloat(document.getElementById("noOfDays").value) > 3) {
                                    $("#sickLeaveDiv").show();
                                    setTimeout(function () {
                                        $("#sickLeaveDiv").fadeOut();
                                    }, 5000);
                                }
                                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                                document.getElementById('Casual Leave').innerHTML = "0";
                                document.getElementById('Casual Leave2').innerHTML = document.getElementById('Casual Leave1').innerHTML;
                                document.getElementById('Privilege Leave').innerHTML = "0";
                                document.getElementById('Privilege Leave2').innerHTML = document.getElementById('Privilege Leave1').innerHTML;
                            }
                            if (strUser == "Casual Leave") {

                                if (parseFloat(document.getElementById("noOfDays").value) > 2) {
                                    $("#calsualLeaveDiv").show();
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = '';
                                    setTimeout(function () {
                                        $("#calsualLeaveDiv").fadeOut();
                                    }, 5000);
                                    document.getElementById("noOfDays").value = "";
                                }
                                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                                document.getElementById('Sick Leave').innerHTML = "0";
                                document.getElementById('Sick Leave2').innerHTML = document.getElementById('Sick Leave1').innerHTML;
                                document.getElementById('Privilege Leave').innerHTML = "0";
                                document.getElementById('Privilege Leave2').innerHTML = document.getElementById('Privilege Leave1').innerHTML;
                            }
                            if (strUser == "Privilege Leave") {
                                var plBalFlag = ${plBalCheck};
                                if (document.getElementById('Sick Leave1').innerHTML > 0 && plBalFlag == true) {
                                    if (parseFloat(document.getElementById("noOfDays").value) < 3) {
//                                        alert("2hussaalertin");
                                        $("#plDiv").show();
                                        setTimeout(function () {
                                            $("#plDiv").fadeOut();
                                        }, 5000);
                                        document.getElementById("noOfDays").value = "";
                                        document.getElementById("startDate").value = "";
                                        document.getElementById("endDate").value = "";
                                        document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
                                        document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                                    }

                                }
                                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                                document.getElementById('Casual Leave').innerHTML = "0";
                                document.getElementById('Casual Leave2').innerHTML = document.getElementById('Casual Leave1').innerHTML;
                                document.getElementById('Sick Leave').innerHTML = "0";
                                document.getElementById('Sick Leave2').innerHTML = document.getElementById('Sick Leave1').innerHTML;
                            }

                            //        if (strUser == "Leave Without Pay") {
                            //        if (parseFloat(document.getElementById("noOfDays").value) > 60) {
                            //        $("#leaveWithoutPayLeaveDiv").show();
                            //        document.getElementById("endDate").value = '';
                            //        document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                            //        setTimeout(function () {
                            //        $("#leaveWithoutPayLeaveDiv").fadeOut();
                            //        }, 5000);
                            //        }
                            //        if (parseFloat(leaveDays1) > parseFloat(leaveBalance)) {
                            //        $("#balanceDiv").show();
                            //        setTimeout(function () {
                            //        $("#balanceDiv").fadeOut();
                            //        }, 5000);
                            //        document.getElementById("noOfDays").value = "";
                            //        document.getElementById("startDate").value = "";
                            //        document.getElementById("endDate").value = "";
                            //        document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
                            //        document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                            //        }
                            //        }


                            if (strUser == "Paternity Leave") {
                                if (parseFloat(document.getElementById("noOfDays").value) > 3) {
                                    $("#paternityLeaveDiv").show();
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = '';
                                    setTimeout(function () {
                                        $("#paternityLeaveDiv").fadeOut();
                                    }, 5000);
                                    document.getElementById("noOfDays").value = "";
                                }
                                if (parseFloat(leaveDays1) > parseFloat(leaveBalance)) {
                                    $("#balanceDiv").show();
                                    setTimeout(function () {
                                        $("#balanceDiv").fadeOut();
                                    }, 5000);
                                    document.getElementById("noOfDays").value = "";
                                    document.getElementById("startDate").value = "";
                                    document.getElementById("endDate").value = "";
                                    document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                                }
                            } else {
                                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                                if (parseFloat(document.getElementById(strUser).innerHTML) > parseFloat(document.getElementById(strUser + "1").innerHTML)) {
                                    $("#balanceDiv").show();
                                    setTimeout(function () {
                                        $("#balanceDiv").fadeOut();
                                    }, 10000);
                                    document.getElementById(strUser).innerHTML = 0;
                                    document.getElementById("noOfDays").value = "";
                                    document.getElementById(strUser + "2").innerHTML = 0;
                                    document.getElementById("startDate").value = "";
                                    document.getElementById("endDate").value = "";
                                    document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                                } else {
                                    document.getElementById(strUser + "2").innerHTML = document.getElementById(strUser + "1").innerHTML - document.getElementById(strUser).innerHTML;
                                }
                            }

                        }
                        if (leaveStartDate_SelectFullOrHalf == "SecondHalf") {

                            if (leaveDays1 == 0) {
                                document.getElementById("noOfDays").value = "";
                            } else {
                                document.getElementById("noOfDays").value = parseFloat(leaveDays1) - 0.5;
                            }

                            if (strUser == "Sick Leave") {
                                if (parseFloat(document.getElementById("noOfDays").value) > 3) {
                                    $("#sickLeaveDiv").show();
                                    setTimeout(function () {
                                        $("#sickLeaveDiv").fadeOut();
                                    }, 5000);
                                }
                                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                                document.getElementById('Casual Leave').innerHTML = "0";
                                document.getElementById('Casual Leave2').innerHTML = document.getElementById('Casual Leave1').innerHTML;
                                document.getElementById('Privilege Leave').innerHTML = "0";
                                document.getElementById('Privilege Leave2').innerHTML = document.getElementById('Privilege Leave1').innerHTML;
                            }
                            if (strUser == "Casual Leave") {
                                if (parseFloat(document.getElementById("noOfDays").value) > 2) {
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = '';
                                    setTimeout(function () {
                                        $("#calsualLeaveDiv").fadeOut();
                                    }, 5000);
                                    document.getElementById("noOfDays").value = "";
                                }
                                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                                document.getElementById('Sick Leave').innerHTML = "0";
                                document.getElementById('Sick Leave2').innerHTML = document.getElementById('Sick Leave1').innerHTML;
                                document.getElementById('Privilege Leave').innerHTML = "0";
                                document.getElementById('Privilege Leave2').innerHTML = document.getElementById('Privilege Leave1').innerHTML;
                            }
                            if (strUser == "Privilege Leave") {
                                var plBalFlag = ${plBalCheck};
                                if (document.getElementById('Sick Leave1').innerHTML > 0 && plBalFlag == true) {
                                    if (parseFloat(document.getElementById("noOfDays").value) < 3) {
//                                         alert("3hussain");
                                        $("#plDiv").show();
                                        setTimeout(function () {
                                            $("#plDiv").fadeOut();
                                        }, 5000);
                                        document.getElementById("noOfDays").value = "";
                                        document.getElementById("startDate").value = "";
                                        document.getElementById("endDate").value = "";
                                        document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
                                        document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                                    }

                                }
                                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                                document.getElementById('Casual Leave').innerHTML = "0";
                                document.getElementById('Casual Leave2').innerHTML = document.getElementById('Casual Leave1').innerHTML;
                                document.getElementById('Sick Leave').innerHTML = "0";
                                document.getElementById('Sick Leave2').innerHTML = document.getElementById('Sick Leave1').innerHTML;
                            }
//        if (strUser == "Leave Without Pay") {
//        if (parseFloat(document.getElementById("noOfDays").value) > 60) {
//        $("#leaveWithoutPayLeaveDiv").show();
//        document.getElementById("endDate").value = '';
//        document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
//        setTimeout(function () {
//        $("#leaveWithoutPayLeaveDiv").fadeOut();
//        }, 5000);
//        }
//        if (parseFloat(leaveDays1) > parseFloat(leaveBalance)) {
//        $("#balanceDiv").show();
//        setTimeout(function () {
//        $("#balanceDiv").fadeOut();
//        }, 5000);
//        document.getElementById("noOfDays").value = "";
//        document.getElementById("startDate").value = "";
//        document.getElementById("endDate").value = "";
//        document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
//        document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
//        }
//        }

                            if (strUser == "Paternity Leave") {
                                if (parseFloat(document.getElementById("noOfDays").value) > 3) {
                                    $("#paternityLeaveDiv").show();
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = '';
                                    setTimeout(function () {
                                        $("#paternityLeaveDiv").fadeOut();
                                    }, 5000);
                                    document.getElementById("noOfDays").value = "";
                                }
                                if (parseFloat(leaveDays1) > parseFloat(leaveBalance)) {
                                    $("#balanceDiv").show();
                                    setTimeout(function () {
                                        $("#balanceDiv").fadeOut();
                                    }, 5000);
                                    document.getElementById("noOfDays").value = "";
                                    document.getElementById("startDate").value = "";
                                    document.getElementById("endDate").value = "";
                                    document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                                }
                            } else {
                                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                                if (parseFloat(document.getElementById(strUser).innerHTML) > parseFloat(document.getElementById(strUser + "1").innerHTML)) {

                                    $("#balanceDiv").show();
                                    setTimeout(function () {
                                        $("#balanceDiv").fadeOut();
                                    }, 10000);
                                    document.getElementById(strUser).innerHTML = 0;
                                    document.getElementById("noOfDays").value = "";
                                    document.getElementById(strUser + "2").innerHTML = 0;
                                    document.getElementById("startDate").value = "";
                                    document.getElementById("endDate").value = "";
                                    document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                                } else {
                                    document.getElementById(strUser + "2").innerHTML = document.getElementById(strUser + "1").innerHTML - document.getElementById(strUser).innerHTML;
                                }
                            }


                        }
                    } else if (leaveDays <= 0) {
                        alert('please select Start Date After End Date.');
                        try {
                            document.getElementById(strUser).innerHTML = 0;
                            document.getElementById(strUser + "2").innerHTML = 0;
                        } catch (e) {

                        }
                        document.getElementById("startDate").value = "";
                        document.getElementById("endDate").value = "";
                    } else if (leaveStartDate_SelectFullOrHalf != "" && leaveEndDate_SelectFullOrHalf == "") {
                        document.getElementById("noOfDays").value = "";
                    } else if (leaveStartDate_SelectFullOrHalf == "" && leaveEndDate_SelectFullOrHalf == "") {
                        document.getElementById("noOfDays").value = "";
                    }
                    else {
                        if (leaveStartDate_SelectFullOrHalf == "Fullday" && leaveEndDate_SelectFullOrHalf == "Fullday") {
                            if (leaveDays1 == 0) {
                                document.getElementById("noOfDays").value = " ";
                            } else {
                                document.getElementById("noOfDays").value = leaveDays1;
                            }
                            if (strUser == "Sick Leave") {
                                if (parseFloat(document.getElementById("noOfDays").value) > 3) {
                                    $("#sickLeaveDiv").show();
                                    setTimeout(function () {
                                        $("#sickLeaveDiv").fadeOut();
                                    }, 5000);
                                }
                                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                                document.getElementById('Casual Leave').innerHTML = "0";
                                document.getElementById('Casual Leave2').innerHTML = document.getElementById('Casual Leave1').innerHTML;
                                document.getElementById('Privilege Leave').innerHTML = "0";
                                document.getElementById('Privilege Leave2').innerHTML = document.getElementById('Privilege Leave1').innerHTML;
                            }
                            if (strUser == "Casual Leave") {
                                if (parseFloat(document.getElementById("noOfDays").value) > 2) {
                                    $("#calsualLeaveDiv").show();
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = '';
                                    setTimeout(function () {
                                        $("#calsualLeaveDiv").fadeOut();
                                    }, 5000);
                                    document.getElementById("noOfDays").value = "";
                                }
                                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                                document.getElementById('Sick Leave').innerHTML = "0";
                                document.getElementById('Sick Leave2').innerHTML = document.getElementById('Sick Leave1').innerHTML;
                                document.getElementById('Privilege Leave').innerHTML = "0";
                                document.getElementById('Privilege Leave2').innerHTML = document.getElementById('Privilege Leave1').innerHTML;
                            }
                            if (strUser == "Privilege Leave") {
                                var plBalFlag = ${plBalCheck};
                                if (document.getElementById('Sick Leave1').innerHTML > 0 && plBalFlag == true) {
                                    if (parseFloat(document.getElementById("noOfDays").value) < 3) {
//                                         alert("4hussain");
                                        $("#plDiv").show();
                                        setTimeout(function () {
                                            $("#plDiv").fadeOut();
                                        }, 5000);
                                        document.getElementById("noOfDays").value = "";
                                        document.getElementById("startDate").value = "";
                                        document.getElementById("endDate").value = "";
                                        document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
                                        document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                                    }

                                }
                                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                                document.getElementById('Casual Leave').innerHTML = "0";
                                document.getElementById('Casual Leave2').innerHTML = document.getElementById('Casual Leave1').innerHTML;
                                document.getElementById('Sick Leave').innerHTML = "0";
                                document.getElementById('Sick Leave2').innerHTML = document.getElementById('Sick Leave1').innerHTML;
                            }
//        if (strUser == "Leave Without Pay") {
//        if (parseFloat(document.getElementById("noOfDays").value) > 60) {
//        $("#leaveWithoutPayLeaveDiv").show();
//        document.getElementById("endDate").value = '';
//        document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
//        setTimeout(function () {
//        $("#leaveWithoutPayLeaveDiv").fadeOut();
//        }, 5000);
//        }
//        if (parseFloat(leaveDays1) > parseFloat(leaveBalance)) {
//        $("#balanceDiv").show();
//        setTimeout(function () {
//        $("#balanceDiv").fadeOut();
//        }, 5000);
//        document.getElementById("noOfDays").value = "";
//        document.getElementById("startDate").value = "";
//        document.getElementById("endDate").value = "";
//        document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
//        document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
//        }
//        }

                            if (strUser == "Paternity Leave") {
                                if (parseFloat(document.getElementById("noOfDays").value) > 3) {
                                    $("#paternityLeaveDiv").show();
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = '';
                                    setTimeout(function () {
                                        $("#paternityLeaveDiv").fadeOut();
                                    }, 5000);
                                    document.getElementById("noOfDays").value = "";
                                }
                                if (parseFloat(leaveDays1) > parseFloat(leaveBalance)) {
                                    $("#balanceDiv").show();
                                    setTimeout(function () {
                                        $("#balanceDiv").fadeOut();
                                    }, 5000);
                                    document.getElementById("noOfDays").value = "";
                                    document.getElementById("startDate").value = "";
                                    document.getElementById("endDate").value = "";
                                    document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                                }
                            } else {

                                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                                if (parseFloat(document.getElementById(strUser).innerHTML) > parseFloat(document.getElementById(strUser + "1").innerHTML)) {
                                    $("#balanceDiv").show();
                                    setTimeout(function () {
                                        $("#balanceDiv").fadeOut();
                                    }, 10000);
//                            }
                                    document.getElementById(strUser).innerHTML = 0;
                                    document.getElementById("noOfDays").value = "";
                                    document.getElementById(strUser + "2").innerHTML = 0;
                                    document.getElementById("startDate").value = "";
                                    document.getElementById("endDate").value = "";
                                    document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                                } else {
                                    document.getElementById(strUser + "2").innerHTML = document.getElementById(strUser + "1").innerHTML - document.getElementById(strUser).innerHTML;
                                }
                            }
                        }
                        if (leaveStartDate_SelectFullOrHalf == "Fullday" && leaveEndDate_SelectFullOrHalf == "FirstHalf") {
                            if (leaveDays1 == 0) {
                                document.getElementById("noOfDays").value = "";
                            } else {
                                document.getElementById("noOfDays").value = parseFloat(leaveDays1) - 0.5;
                            }
                            if (strUser == "Sick Leave") {
                                if (parseFloat(document.getElementById("noOfDays").value) > 3) {
                                    $("#sickLeaveDiv").show();
                                    setTimeout(function () {
                                        $("#sickLeaveDiv").fadeOut();
                                    }, 5000);
                                }
                                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                                document.getElementById('Casual Leave').innerHTML = "0";
                                document.getElementById('Casual Leave2').innerHTML = document.getElementById('Casual Leave1').innerHTML;
                                document.getElementById('Privilege Leave').innerHTML = "0";
                                document.getElementById('Privilege Leave2').innerHTML = document.getElementById('Privilege Leave1').innerHTML;
                            }
                            if (strUser == "Casual Leave") {
                                if (parseFloat(document.getElementById("noOfDays").value) > 2) {
                                    $("#calsualLeaveDiv").show();
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = '';
                                    setTimeout(function () {
                                        $("#calsualLeaveDiv").fadeOut();
                                    }, 5000);
                                    document.getElementById("noOfDays").value = "";
                                }
                                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                                document.getElementById('Sick Leave').innerHTML = "0";
                                document.getElementById('Sick Leave2').innerHTML = document.getElementById('Sick Leave1').innerHTML;
                                document.getElementById('Privilege Leave').innerHTML = "0";
                                document.getElementById('Privilege Leave2').innerHTML = document.getElementById('Privilege Leave1').innerHTML;
                            }
                            if (strUser == "Privilege Leave") {
                                var plBalFlag = ${plBalCheck};
                                if (document.getElementById('Sick Leave1').innerHTML > 0 && plBalFlag == true) {
                                    if (parseFloat(document.getElementById("noOfDays").value) < 3) {
//                                         alert("5hussain");
                                        $("#plDiv").show();
                                        setTimeout(function () {
                                            $("#plDiv").fadeOut();
                                        }, 5000);
                                        document.getElementById("noOfDays").value = "";
                                        document.getElementById("startDate").value = "";
                                        document.getElementById("endDate").value = "";
                                        document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
                                        document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                                    }

                                }
                                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                                document.getElementById('Casual Leave').innerHTML = "0";
                                document.getElementById('Casual Leave2').innerHTML = document.getElementById('Casual Leave1').innerHTML;
                                document.getElementById('Sick Leave').innerHTML = "0";
                                document.getElementById('Sick Leave2').innerHTML = document.getElementById('Sick Leave1').innerHTML;
                            }

                            //        if (strUser == "Leave Without Pay") {
                            //        if (parseFloat(document.getElementById("noOfDays").value) > 60) {
                            //        $("#leaveWithoutPayLeaveDiv").show();
                            //        document.getElementById("endDate").value = '';
                            //        document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                            //        setTimeout(function () {
                            //        $("#leaveWithoutPayLeaveDiv").fadeOut();
                            //        }, 5000);
                            //        }
                            //        if (parseFloat(leaveDays1) > parseFloat(leaveBalance)) {
                            //        $("#balanceDiv").show();
                            //        setTimeout(function () {
                            //        $("#balanceDiv").fadeOut();
                            //        }, 5000);
                            //        document.getElementById("noOfDays").value = "";
                            //        document.getElementById("startDate").value = "";
                            //        document.getElementById("endDate").value = "";
                            //        document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
                            //        document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                            //        }
                            //        }

                            if (strUser == "Paternity Leave") {
                                if (parseFloat(document.getElementById("noOfDays").value) > 3) {
                                    $("#paternityLeaveDiv").show();
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = '';
                                    setTimeout(function () {
                                        $("#paternityLeaveDiv").fadeOut();
                                    }, 5000);
                                    document.getElementById("noOfDays").value = "";
                                }
                                if (parseFloat(leaveDays1) > parseFloat(leaveBalance)) {
                                    $("#balanceDiv").show();
                                    setTimeout(function () {
                                        $("#balanceDiv").fadeOut();
                                    }, 5000);
                                    document.getElementById("noOfDays").value = "";
                                    document.getElementById("startDate").value = "";
                                    document.getElementById("endDate").value = "";
                                    document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                                }
                            } else {
//
                                if (parseFloat(document.getElementById(strUser).innerHTML) > parseFloat(document.getElementById(strUser + "1").innerHTML)) {
                                    $("#balanceDiv").show();
                                    setTimeout(function () {
                                        $("#balanceDiv").fadeOut();
                                    }, 10000);
//                            }

                                    document.getElementById(strUser).innerHTML = 0;
                                    document.getElementById("noOfDays").value = "";
                                    document.getElementById(strUser + "2").innerHTML = 0;
                                    document.getElementById("startDate").value = "";
                                    document.getElementById("endDate").value = "";
                                    document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                                } else {
                                    document.getElementById(strUser + "2").innerHTML = document.getElementById(strUser + "1").innerHTML - document.getElementById(strUser).innerHTML;
                                }
                            }
                        }
                        if (leaveStartDate_SelectFullOrHalf == "SecondHalf" && leaveEndDate_SelectFullOrHalf == "FirstHalf") {

                            if (leaveDays1 == 0) {
                                document.getElementById("noOfDays").value = "";
                            } else {
                                document.getElementById("noOfDays").value = parseFloat(leaveDays1) - 1;
                            }
                            if (strUser == "Sick Leave") {
                                if (parseFloat(document.getElementById("noOfDays").value) > 3) {
                                    $("#sickLeaveDiv").show();
                                    setTimeout(function () {
                                        $("#sickLeaveDiv").fadeOut();
                                    }, 5000);
                                }
                                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                                document.getElementById('Casual Leave').innerHTML = "0";
                                document.getElementById('Casual Leave2').innerHTML = document.getElementById('Casual Leave1').innerHTML;
                                document.getElementById('Privilege Leave').innerHTML = "0";
                                document.getElementById('Privilege Leave2').innerHTML = document.getElementById('Privilege Leave1').innerHTML;
                            }
                            if (strUser == "Casual Leave") {

                                if (parseFloat(document.getElementById("noOfDays").value) > 2) {
                                    $("#calsualLeaveDiv").show();
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = '';
                                    setTimeout(function () {
                                        $("#calsualLeaveDiv").fadeOut();
                                    }, 5000);
                                    document.getElementById("noOfDays").value = "";
                                }

                                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                                document.getElementById('Sick Leave').innerHTML = "0";
                                document.getElementById('Sick Leave2').innerHTML = document.getElementById('Sick Leave1').innerHTML;
                                document.getElementById('Privilege Leave').innerHTML = "0";
                                document.getElementById('Privilege Leave2').innerHTML = document.getElementById('Privilege Leave1').innerHTML;
                            }
                            if (strUser == "Privilege Leave") {
                                var plBalFlag = ${plBalCheck};
                                if (document.getElementById('Sick Leave1').innerHTML > 0 && plBalFlag == true) {
                                    if (parseFloat(document.getElementById("noOfDays").value) < 3) {
//                                         alert("6hussain");
                                        $("#plDiv").show();
                                        setTimeout(function () {
                                            $("#plDiv").fadeOut();
                                        }, 5000);
                                        document.getElementById("noOfDays").value = "";
                                        document.getElementById("startDate").value = "";
                                        document.getElementById("endDate").value = "";
                                        document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
                                        document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                                    }

                                }
                                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                                document.getElementById('Casual Leave').innerHTML = "0";
                                document.getElementById('Casual Leave2').innerHTML = document.getElementById('Casual Leave1').innerHTML;
                                document.getElementById('Sick Leave').innerHTML = "0";
                                document.getElementById('Sick Leave2').innerHTML = document.getElementById('Sick Leave1').innerHTML;
                            }

                            //        if (strUser == "Leave Without Pay") {
                            //        if (parseFloat(document.getElementById("noOfDays").value) > 60) {
                            //        $("#leaveWithoutPayLeaveDiv").show();
                            //        document.getElementById("endDate").value = '';
                            //        document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                            //        setTimeout(function () {
                            //        $("#leaveWithoutPayLeaveDiv").fadeOut();
                            //        }, 5000);
                            //        }
                            //        if (parseFloat(leaveDays1) > parseFloat(leaveBalance)) {
                            //        $("#balanceDiv").show();
                            //        setTimeout(function () {
                            //        $("#balanceDiv").fadeOut();
                            //        }, 5000);
                            //        document.getElementById("noOfDays").value = "";
                            //        document.getElementById("startDate").value = "";
                            //        document.getElementById("endDate").value = "";
                            //        document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
                            //        document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                            //        }
                            //        }

                            if (strUser == "Paternity Leave") {
                                if (parseFloat(document.getElementById("noOfDays").value) > 3) {
                                    $("#paternityLeaveDiv").show();
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = '';
                                    setTimeout(function () {
                                        $("#paternityLeaveDiv").fadeOut();
                                    }, 5000);
                                    document.getElementById("noOfDays").value = "";
                                }
                                if (parseFloat(leaveDays1) > parseFloat(leaveBalance)) {
                                    $("#balanceDiv").show();
                                    setTimeout(function () {
                                        $("#balanceDiv").fadeOut();
                                    }, 5000);
                                    document.getElementById("noOfDays").value = "";
                                    document.getElementById("startDate").value = "";
                                    document.getElementById("endDate").value = "";
                                    document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                                }
                            } else {
                                if (parseFloat(document.getElementById(strUser).innerHTML) > parseFloat(document.getElementById(strUser + "1").innerHTML)) {
                                    $("#balanceDiv").show();
                                    setTimeout(function () {
                                        $("#balanceDiv").fadeOut();
                                    }, 5000);
                                    document.getElementById(strUser).innerHTML = 0;
                                    document.getElementById("noOfDays").value = "";
                                    document.getElementById(strUser + "2").innerHTML = 0;
                                    document.getElementById("startDate").value = "";
                                    document.getElementById("endDate").value = "";
                                    document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                                } else {

                                    document.getElementById(strUser + "2").innerHTML = document.getElementById(strUser + "1").innerHTML - document.getElementById(strUser).innerHTML;
                                }
                            }
                        }
                        if (leaveStartDate_SelectFullOrHalf == "SecondHalf" && leaveEndDate_SelectFullOrHalf == "Fullday") {
                            if (leaveDays1 == 0) {
                                document.getElementById("noOfDays").value = "";
                            } else {
                                document.getElementById("noOfDays").value = parseFloat(leaveDays1) - 0.5;
                            }

                            if (strUser == "Sick Leave") {
                                if (parseFloat(document.getElementById("noOfDays").value) > 3) {
                                    $("#sickLeaveDiv").show();
                                    setTimeout(function () {
                                        $("#sickLeaveDiv").fadeOut();
                                    }, 5000);
                                }
                                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                                document.getElementById('Casual Leave').innerHTML = "0";
                                document.getElementById('Casual Leave2').innerHTML = document.getElementById('Casual Leave1').innerHTML;
                                document.getElementById('Privilege Leave').innerHTML = "0";
                                document.getElementById('Privilege Leave2').innerHTML = document.getElementById('Privilege Leave1').innerHTML;
                            }
                            if (strUser == "Casual Leave") {
                                if (parseFloat(document.getElementById("noOfDays").value) > 2) {
                                    $("#calsualLeaveDiv").show();
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = '';
                                    setTimeout(function () {
                                        $("#calsualLeaveDiv").fadeOut();
                                    }, 5000);
                                    document.getElementById("noOfDays").value = "";
                                }
                                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                                document.getElementById('Sick Leave').innerHTML = "0";
                                document.getElementById('Sick Leave2').innerHTML = document.getElementById('Sick Leave1').innerHTML;
                                document.getElementById('Privilege Leave').innerHTML = "0";
                                document.getElementById('Privilege Leave2').innerHTML = document.getElementById('Privilege Leave1').innerHTML;
                            }
                            if (strUser == "Privilege Leave") {
                                var plBalFlag = ${plBalCheck};
                                if (document.getElementById('Sick Leave1').innerHTML > 0 && plBalFlag == true) {
                                    if (parseFloat(document.getElementById("noOfDays").value) < 3) {
//                                         alert("7hussain");
                                        $("#plDiv").show();
                                        setTimeout(function () {
                                            $("#plDiv").fadeOut();
                                        }, 5000);
                                        document.getElementById("noOfDays").value = "";
                                        document.getElementById("startDate").value = "";
                                        document.getElementById("endDate").value = "";
                                        document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
                                        document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                                    }

                                }
                                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                                document.getElementById('Casual Leave').innerHTML = "0";
                                document.getElementById('Casual Leave2').innerHTML = document.getElementById('Casual Leave1').innerHTML;
                                document.getElementById('Sick Leave').innerHTML = "0";
                                document.getElementById('Sick Leave2').innerHTML = document.getElementById('Sick Leave1').innerHTML;
                            }

//        if (strUser == "Leave Without Pay") {
//        if (parseFloat(document.getElementById("noOfDays").value) > 60) {
//        $("#leaveWithoutPayLeaveDiv").show();
//        document.getElementById("endDate").value = '';
//        document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
//        setTimeout(function () {
//        $("#leaveWithoutPayLeaveDiv").fadeOut();
//        }, 5000);
//        }
//        if (parseFloat(leaveDays1) > parseFloat(leaveBalance)) {
//        $("#balanceDiv").show();
//        setTimeout(function () {
//        $("#balanceDiv").fadeOut();
//        }, 5000);
//        document.getElementById("noOfDays").value = "";
//        document.getElementById("startDate").value = "";
//        document.getElementById("endDate").value = "";
//        document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
//        document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
//        }
//        }
                            if (strUser == "Paternity Leave") {
                                if (parseFloat(document.getElementById("noOfDays").value) > 3) {
                                    $("#paternityLeaveDiv").show();
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = '';
                                    setTimeout(function () {
                                        $("#paternityLeaveDiv").fadeOut();
                                    }, 5000);
                                    document.getElementById("noOfDays").value = "";
                                }
                                if (parseFloat(leaveDays1) > parseFloat(leaveBalance)) {
                                    $("#balanceDiv").show();
                                    setTimeout(function () {
                                        $("#balanceDiv").fadeOut();
                                    }, 5000);
                                    document.getElementById("noOfDays").value = "";
                                    document.getElementById("startDate").value = "";
                                    document.getElementById("endDate").value = "";
                                    document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                                }
                            } else {
                                if (parseFloat(document.getElementById(strUser).innerHTML) > parseFloat(document.getElementById(strUser + "1").innerHTML)) {
                                    $("#balanceDiv").show();
                                    setTimeout(function () {
                                        $("#balanceDiv").fadeOut();
                                    }, 5000);
                                    document.getElementById(strUser).innerHTML = 0;
                                    document.getElementById("noOfDays").value = "";
                                    document.getElementById(strUser + "2").innerHTML = 0;
                                    document.getElementById("startDate").value = "";
                                    document.getElementById("endDate").value = "";
                                    document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                                } else {
                                    document.getElementById(strUser + "2").innerHTML = document.getElementById(strUser + "1").innerHTML - document.getElementById(strUser).innerHTML;
                                }
                            }
                        }
                        if (leaveStartDate_SelectFullOrHalf == "FirstHalf" && leaveEndDate_SelectFullOrHalf == "Fullday") {
                            if (leaveDays1 == 0) {
//                                alert("2 Hussain");
                                document.getElementById("noOfDays").value = "";
                            } else {
//                                alert("3 Hussain");
                                var zydexLocation = document.getElementById("zydexLocation").value;
                                if (zydexLocation == 'HO' || zydexLocation == 'R&D') {
                                    var days = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
                                    var dayName = days[leaveStartDateForSat.getDay()];
                                    var firstDay = new Date(leaveStartDateForSat.getFullYear(), leaveStartDateForSat.getMonth(), 1).getDay();
                                    var noOfWeek = Math.ceil((leaveStartDateForSat.getDate() + firstDay) / 7);
//                                    var noOfWeek=Math.ceil((leaveStartDateForSat)/7);
                                    if (dayName == 'Saturday' && noOfWeek == 2) {

                                        document.getElementById("noOfDays").value = parseFloat(leaveDays1) - 1.5;
                                    } else {

                                    }
                                }
                            }
                            document.getElementById("noOfDays").value = parseFloat(leaveDays1) - 0.5;

                            if (strUser == "Sick Leave") {
                                if (parseFloat(document.getElementById("noOfDays").value) > 3) {
                                    $("#sickLeaveDiv").show();
                                    setTimeout(function () {
                                        $("#sickLeaveDiv").fadeOut();
                                    }, 5000);
                                }
                                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                                document.getElementById('Casual Leave').innerHTML = "0";
                                document.getElementById('Casual Leave2').innerHTML = document.getElementById('Casual Leave1').innerHTML;
                                document.getElementById('Privilege Leave').innerHTML = "0";
                                document.getElementById('Privilege Leave2').innerHTML = document.getElementById('Privilege Leave1').innerHTML;
                            }
                            if (strUser == "Casual Leave") {
                                if (parseFloat(document.getElementById("noOfDays").value) > 2) {
                                    $("#calsualLeaveDiv").show();
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = '';
                                    setTimeout(function () {
                                        $("#calsualLeaveDiv").fadeOut();
                                    }, 5000);
                                    document.getElementById("noOfDays").value = "";
                                }
                                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                                document.getElementById('Sick Leave').innerHTML = "0";
                                document.getElementById('Sick Leave2').innerHTML = document.getElementById('Sick Leave1').innerHTML;
                                document.getElementById('Privilege Leave').innerHTML = "0";
                                document.getElementById('Privilege Leave2').innerHTML = document.getElementById('Privilege Leave1').innerHTML;
                            }
                            if (strUser == "Privilege Leave") {
                                var plBalFlag = ${plBalCheck};
                                if (document.getElementById('Sick Leave1').innerHTML > 0 && plBalFlag == true) {
                                    if (parseFloat(document.getElementById("noOfDays").value) < 3) {
//                                         alert("8hussain");
                                        $("#plDiv").show();
                                        setTimeout(function () {
                                            $("#plDiv").fadeOut();
                                        }, 5000);
                                        document.getElementById("noOfDays").value = "";
                                        document.getElementById("startDate").value = "";
                                        document.getElementById("endDate").value = "";
                                        document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
                                        document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                                    }

                                }
                                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                                document.getElementById('Casual Leave').innerHTML = "0";
                                document.getElementById('Casual Leave2').innerHTML = document.getElementById('Casual Leave1').innerHTML;
                                document.getElementById('Sick Leave').innerHTML = "0";
                                document.getElementById('Sick Leave2').innerHTML = document.getElementById('Sick Leave1').innerHTML;
                            }

//        if (strUser == "Leave Without Pay") {
//        if (parseFloat(document.getElementById("noOfDays").value) > 60) {
//        $("#leaveWithoutPayLeaveDiv").show();
//        document.getElementById("endDate").value = '';
//        document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
//        setTimeout(function () {
//        $("#leaveWithoutPayLeaveDiv").fadeOut();
//        }, 5000);
//        }
//        if (parseFloat(leaveDays1) > parseFloat(leaveBalance)) {
//        $("#balanceDiv").show();
//        setTimeout(function () {
//        $("#balanceDiv").fadeOut();
//        }, 5000);
//        document.getElementById("noOfDays").value = "";
//        document.getElementById("startDate").value = "";
//        document.getElementById("endDate").value = "";
//        document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
//        document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
//        }
//        }
                            if (strUser == "Paternity Leave") {
                                if (parseFloat(document.getElementById("noOfDays").value) > 3) {
                                    $("#paternityLeaveDiv").show();
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = '';
                                    setTimeout(function () {
                                        $("#paternityLeaveDiv").fadeOut();
                                    }, 5000);
                                    document.getElementById("noOfDays").value = "";
                                }
                                if (parseFloat(leaveDays1) > parseFloat(leaveBalance)) {
                                    $("#balanceDiv").show();
                                    setTimeout(function () {
                                        $("#balanceDiv").fadeOut();
                                    }, 5000);
                                    document.getElementById("noOfDays").value = "";
                                    document.getElementById("startDate").value = "";
                                    document.getElementById("endDate").value = "";
                                    document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                                }
                            } else {
                                if (parseFloat(document.getElementById(strUser).innerHTML) > parseFloat(document.getElementById(strUser + "1").innerHTML)) {
                                    $("#balanceDiv").show();
                                    setTimeout(function () {
                                        $("#balanceDiv").fadeOut();
                                    }, 5000);
                                    document.getElementById(strUser).innerHTML = 0;
                                    document.getElementById("noOfDays").value = "";
                                    document.getElementById(strUser + "2").innerHTML = 0;
                                    document.getElementById("startDate").value = "";
                                    document.getElementById("endDate").value = "";
                                    document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
                                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                                } else {
                                    document.getElementById(strUser + "2").innerHTML = document.getElementById(strUser + "1").innerHTML - document.getElementById(strUser).innerHTML;
                                }
                            }
                        }
                        if (document.getElementById("leaveStartDate_SelectFullOrHalfId").value == '') {
                            document.getElementById("noOfDays").value = "";
                        }
                        if (document.getElementById("leaveEndDate_SelectFullOrHalfId").value == '') {
                            document.getElementById("noOfDays").value = "";
                        }

                    }
                } else {
                    document.getElementById("noOfDays").value = "";
                }
            }
        }
        function fillEnddate(Enddate) {
            var strUser;
            var strUser1;
            var leaveTypes = document.getElementById("leaveTypeMaster.id");
            var selectedText = leaveTypes.options[leaveTypes.selectedIndex].text;
            var selectedTextArray = selectedText.split('(');
            selectedText = selectedTextArray[0];
            var newstrDate = leaveTypes.options[leaveTypes.selectedIndex].text;
            strUser1 = newstrDate.split('(');
            strUser = strUser1[1].split(')');
            if (selectedText == 'Short Leave') {
            } else {
                if (parseFloat(strUser[0]) >= 0) {
                    var now = new Date();
                    var Enddate1 = Enddate.split(' - ');
                    var n_date = Enddate1[0];
                    n_date = n_date.split("/");
                    n_date = n_date[1] + "/" + n_date[0] + "/" + n_date[2];
                    var parts = Enddate.split('/');
                    var parts1 = parts[2].split(' - ');
                    var parts2 = parts1[1].split(':');
                    // new Date(year, month [, day [, hours[, minutes[, seconds[, ms]]]]])

                    var d2 = new Date(parts1[0], (parts[1] - 1), parts[0], parts2[0], parts2[1]);
                    if (selectedText == 'Short Leave') {

//        d2.setTime(d2.getTime() + ('${shortLeaveHoursNo}' * 60 * 60 * 1000));    // This line for add 3 hr short leave
                        d2.setTime(d2.getTime() + (01 * 60 * 60 * 1000)); // This line for add 1 hr short leave
                    }
                    var aDate = d2.getDate();
                    var aMonth = d2.getMonth() + 1;
                    var aHours = d2.getHours();
                    var aMinutes = d2.getMinutes();
                    if (aDate.toString().length === 1) {
                        aDate = "0" + aDate;
                    }
                    if (aMonth.toString().length === 1) {
                        aMonth = "0" + aMonth;
                    }
                    if (aHours.toString().length === 1) {
                        aHours = "0" + aHours;
                    }
                    if (aMinutes.toString().length === 1) {
                        aMinutes = "0" + aMinutes;
                    }
//                alert(aDate + "/" + aMonth + "/" + d2.getFullYear() + " - " + aHours + ":" + aMinutes);
                    document.getElementById('endDateShort').value = aDate + "/" + aMonth + "/" + d2.getFullYear() + " - " + aHours + ":" + aMinutes;
                } else {
                    $("#balanceDiv").show();
                    setTimeout(function () {
                        $("#balanceDiv").fadeOut();
                    }, 10000);
                    document.getElementById('startDateShort').value = '';
                    document.getElementById('endDateShort').value = '';
                    document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                }
            }
        }

    </script>
    <script>
        function   shortLeaveEndCount(Enddate) {
            document.getElementById('shortleaveendDateError').innerHTML = '';
            var startDate = document.getElementById('startDateShort').value;
            var Strdate1 = startDate.split(' - ');
            var s_date = Strdate1[0];
            s_date = s_date.split("/");
            var strmonth = s_date[1];
            var strDate = s_date[0];
            s_date = s_date[1] + "/" + s_date[0] + "/" + s_date[2];
            var strts = startDate.split('/');
            var strts1 = strts[2].split(' - ');
            var strts2 = strts1[1].split(':');
            var strHr = strts2[0];
            var hrCal = strHr * 60 * 60;
            var strMin = strts2[1];
            var minCal = strMin * 60;
            var strTotal = hrCal + minCal;
            //..................................// 

            var Enddate1 = Enddate.split(' - ');
            var n_date = Enddate1[0];
            n_date = n_date.split("/");
            var EndMonth = n_date[1];
            var EndDate = n_date[0];
            n_date = n_date[1] + "/" + n_date[0] + "/" + n_date[2];
            var parts = Enddate.split('/');
            var parts1 = parts[2].split(' - ');
            var parts2 = parts1[1].split(':');
            var endHr = parts2[0];
            var endHrCal = endHr * 60 * 60;
            var endMin = parts2[1];
            var EndMinCal = endMin * 60;
            var EndTotal = endHrCal + EndMinCal;
            //...............................//
            if (strmonth == EndMonth && strDate == EndDate) {
                var checkTime = strTotal + 10800;
                if (checkTime >= EndTotal && strTotal <= EndTotal) {
                    if ((EndTotal - strTotal) <= 3600) {
                        document.getElementById('noOfDayLeave').value = '1';
                    }
                    if (((EndTotal - strTotal) >= 3601) && ((EndTotal - strTotal) <= 7200)) {
                        document.getElementById('noOfDayLeave').value = '2';
                    }
                    if ((EndTotal - strTotal) >= 7201 && ((EndTotal - strTotal) <= 10800)) {
                        document.getElementById('noOfDayLeave').value = '3';
                    }
                }
                else {
                    document.getElementById('endDateShort').value = '';
                    document.getElementById('shortleaveendDateError').innerHTML = 'Maximum 3 Hour Short Leave Allow';
                }

            } else {

                document.getElementById('shortleaveendDateError').innerHTML = 'Please Select Valid Date';
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
    </script>
    <script>
        function calculateDayByAjax() {
            try {
                var strDate = document.getElementById("startDate").value;
                var enDate = document.getElementById("endDate").value;
                var leaveTypeMaster = document.getElementById("leaveTypeMaster.id").value;
                var sDateStatus = document.getElementById("leaveStartDate_SelectFullOrHalfId").value;
                var eDateStatus = document.getElementById("leaveEndDate_SelectFullOrHalfId").value;
//                var useSickLeave = document.getElementById("useAsSickLeave").value;
                var useSickLeave = $("input[name='useAsSickLeave']:checked").val();
                if (strDate != '') {
                    $.ajax({
                        type: "POST",
                        url: "leaveEmployeeDetail.htm?act=checkWeekOffOrHolidayForSDate&strDate=" + strDate,
                        data: {},
                        dataType: "text",
                        success: function (responseTxt) {
                            document.getElementById("sDateHolidayError").innerHTML = responseTxt;
                            if (responseTxt != '') {
                                document.getElementById("startDate").value = "";
                            }

                        },
                        error: function () {

                        }
                    });
                }
                if (enDate != '') {
                    $.ajax({
                        type: "POST",
                        url: "leaveEmployeeDetail.htm?act=checkWeekOffOrHolidayForEDate&enDate=" + enDate,
                        data: {},
                        dataType: "text",
                        success: function (responseTxt) {
                            document.getElementById("eDateHolidayError").innerHTML = responseTxt;
                            if (responseTxt != '') {
                                document.getElementById("endDate").value = "";
                            }
                        },
                        error: function () {
                            //                            alert('Error occured');
                        }
                    });
                }
                //                && sDateStatus != '' && eDateStatus != ''

                if (strDate != '' && enDate != '' && sDateStatus != '' && leaveTypeMaster != "" && useSickLeave != "") {
                    //                    alert("wwww" + strDate);
                    //                    alert("sDateStatus" + sDateStatus);
                    $.ajax({
                        type: "POST",
                        url: "leaveEmployeeDetail.htm?act=getActualDayByAjax&strDate=" + strDate + "&enDate=" + enDate + "&sDateStatus=" + sDateStatus + "&eDateStatus=" + eDateStatus + "&leaveType=" + leaveTypeMaster + "&useSickLeave=" + useSickLeave,
                        data: {},
                        dataType: "text",
                        success: function (responseTxt) {
                            if (responseTxt == 0.0 && leaveTypeMaster == 7) {
                                $("#futureDateSelect").show();
                                setTimeout(function () {
                                    $("#futureDateSelect").fadeOut();
                                }, 5000);
                            } else {
                                document.getElementById("hiddenDays").value = responseTxt;
                            }
                            daysCount();
                        },
                        error: function () {
                        }
                    });
                }
                if (strDate != '' && enDate != '' && '' == sDateStatus) {
//                            alert("wwww" + strDate);
                    //                    alert("sDateStatus" + sDateStatus);
                    document.getElementById("hiddenDays").value = '';
                }
            } catch (e) {

            }
        }
        function checkStartDateFun() {
//            alert("1Aman");
            document.getElementById("noOfDays").value = "";
            document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
            document.getElementById("endDateSelectFullOrHalfError").innerHTML = "";
        }
        function checkEndDateFun() {
            document.getElementById("noOfDays").value = "";
            document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
            document.getElementById("endDateSelectFullOrHalfError").innerHTML = "";
        }

        $(document).ready(function () {
            var skillsSelect = document.getElementById("leaveTypeMaster.id");
            var selectedText = skillsSelect.options[skillsSelect.selectedIndex].text;
            var selectedTextArray = selectedText.split('(');
            selectedText = selectedTextArray[0];
            if (selectedText == 'Short Leave') {
                $("#NoshortLeave").hide();
                $("#shortLeave").show();
            } else {
                $("#NoshortLeave").show();
                $("#shortLeave").hide();
            }
            calculateDayByAjax();
            leaveTypecheck();
            modelopenpopup();
            leaveSetting();
            daysCount();
            fillEnddate();
        });</script>

    <script>
        function checkPresentAjax() {
            try {
                var strDate = document.getElementById("startDate").value;
                var enDate = document.getElementById("endDate").value;
//                alert("enDate" + enDate);
                var sDateStatus = document.getElementById("leaveStartDate_SelectFullOrHalfId").value;
                var eDateStatus = document.getElementById("leaveEndDate_SelectFullOrHalfId").value;
                if (strDate != '') {
                    $.ajax({
                        type: "POST",
                        url: "leaveEmployeeDetail.htm?act=checkPresentOnSDate&strDate=" + strDate + "&sDateStatus=" + sDateStatus,
                        data: {},
                        dataType: "text",
                        success: function (responseTxt) {
                            document.getElementById("presetErrorDiv").innerHTML = responseTxt;
                            if (responseTxt != '') {
                                document.getElementById("startDate").value = "";
                                document.getElementById("endDate").value = "";
                                document.getElementById("noOfDays").value = "";
                                document.getElementById("leaveStartDate_SelectFullOrHalfId").value = "";
                                document.getElementById("startDate").value = "";
                            }

                        },
                        error: function () {

                        }
                    });
                }
                if (enDate != '') {
                    $.ajax({
                        type: "POST",
                        url: "leaveEmployeeDetail.htm?act=checkPresentOneDate&enDate=" + enDate + "&eDateStatus=" + eDateStatus,
                        data: {},
                        dataType: "text",
                        success: function (responseTxt) {
                            document.getElementById("endpresetErrorDiv").innerHTML = responseTxt;
                            if (responseTxt != '') {
                                document.getElementById("endDate").value = "";
                                document.getElementById("noOfDays").value = "";
                                document.getElementById("leaveEndDate_SelectFullOrHalfId").value = "";
                            }
                        },
                        error: function () {
//                            alert('Error occured');
                        }
                    });
                }
//                && sDateStatus != '' && eDateStatus != ''


            } catch (e) {

            }
        }
    </script>
    <script>
        //        function calculateSecondSatByAjax() {
        //        try {
        //
        //        var strDate = document.getElementById("startDate").value;
        //        var enDate = document.getElementById("endDate").value;
        //        //                && sDateStatus != '' && eDateStatus != ''
        //
        //        if (strDate != '' && enDate != '') {
        //        //                    alert("wwww" + strDate);
        //        //                    alert("sDateStatus" + sDateStatus);
        //        $.ajax({
        //        type: "POST",
        //                url: "leaveEmployeeDetail.htm?act=getSecondSatDayByAjax&strDate=" + strDate + "&enDate=" + enDate,
        //                data: {},
        //                dataType: "text",
        //                success: function (responseTxt) {
        //                if (responseTxt == '0'){
        //                $("#leaveStartDate_SelectFullOrHalfId option[value='Fullday']").hide();
        //                $("#leaveStartDate_SelectFullOrHalfId option[value='FirstHalf']").show();
        //                $("#leaveStartDate_SelectFullOrHalfId option[value='SecondHalf']").hide();
        //                }
        //                if (responseTxt == '1'){
        //                $("#leaveEndDate_SelectFullOrHalfId option[value='Fullday']").hide();
        //                $("#leaveEndDate_SelectFullOrHalfId option[value='FirstHalf']").show();
        //                $("#leaveEndDate_SelectFullOrHalfId option[value='SecondHalf']").hide();
        //                }
        //
        //                },
        //                error: function () {
        //                }
        //        });
        //        }
        //        } catch (e) {
        //
        //        }
        //        }

    </script>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>LEAVE APPLICATION </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Leave Request</li>
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
                            <!--Read only entries Starts here-->
                            <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                            <form:form action="leaveEmployeeDetail.htm?act=applySubmit" method="post" commandName="leaveEmployeeDetail"
                                       name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
                                <div class="box box-info collapsed-box ">
                                    <div class="box-header">
                                        <h3 class="box-title">Employee Detail:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId1">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onClick="buttonFun1()"><i class="fa fa-plus" id="minusId1"></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label>Employee ID:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text"  class="form-control" value="${employeeMaster[0]}" readonly>
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <label>Employee Name:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" value="${employeeMaster[1]}" readonly>
                                                    </div>
                                                </div>
                                                     <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label>Team:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text"  class="form-control" value="${employeeMaster[10]}" readonly>
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <label>Sub-Team:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" value="${employeeMaster[11]}" readonly>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label>Designation:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" value="${employeeMaster[2]}" readonly>
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <label>Level:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" value="${employeeMaster[3]}" readonly>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    

                                                    <div class="col-sm-2">
                                                        <label>Work Location:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control"  value="${employeeMaster[5]}" readonly>
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
                                    </div>
                                </div>
                                <!--Employee detail completes here-->
                                <!--read only entries ends here-->
                                <input type="hidden" name="zydexLocation" id="zydexLocation" class="form-control" value="${employeeMaster[9]}" readonly>
                                <div class="box box-info collapsed-box">

                                    <div class="box-header" >
                                        <h3 class="box-title">Leave Detail:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onClick="buttonFun2()"><i class="fa fa-plus" id="minusId2"></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-12">
                                                        <label>Leave Type:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:select path="leaveTypeMaster.id" class="form-control" onchange="modelopenpopup();daysCount();leaveSetting();getUseAsSickLevave(this.value);">
                                                            <form:option value="" label="-- Select --"/>
                                                            <form:options items="${leaveTypemap}" />
                                                        </form:select>
                                                        <span id="leaveTypeMasterError" style="color: red;"></span>
                                                        <%--<form:errors path="leaveTypeMaster" cssClass="errorDiv"></form:errors>--%>
                                                    </div>
                                                </div>
                                                <div id="uAsSickId">
                                                    <div class="col-sm-12">
                                                        <label>Use As a Sick Leave:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <fieldset id="group1">
                                                            <form:radiobutton path="useAsSickLeave" id="useAsSickLeave" onclick="checkDaysValidation(this.value);" value="true"/>Yes&nbsp;&nbsp;
                                                            <form:radiobutton path="useAsSickLeave" id="useAsSickLeave" onclick="checkDaysValidation(this.value);" value="false" checked="checked"/>No
                                                            <!--                                                            <input type="radio" name="useAsSickLeave" value="true" > Yes
                                                                                                                        <input type="radio" name="useAsSickLeave" value="false" checked> No-->
                                                        </fieldset>
                                                    </div>
                                                </div>
                                                <div id="NoshortLeave">

                                                    <div class="form-group">
                                                        <div class=" col-sm-4">
                                                            <label>Leave Start Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                <%--<form:input path="leaveStartDateId" class="form-control" size="16" type="text" value="" onchange="leaveSetting(); daysCount();" readonly="true"></form:input>--%>
                                                                <form:input path="startDate" class="form-control" size="16" type="text" value="" onchange="checkStartDateFun();leaveSetting();leaveTypecheck();
                                                                            daysCount();calculateSecondSatByAjax();" readonly="true"></form:input>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                </div>
                                                                <span id="startDateError" style="color: red;"></span>
                                                                <span id="sDateHolidayError" style="color: red;"></span>
                                                                <span id="presetErrorDiv" style="color: red;"></span>
                                                            <%--<form:errors path="startDate" cssClass="errorDiv"></form:errors>--%>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label></label>
                                                            <select id="leaveStartDate_SelectFullOrHalfId" name="leaveStartDate_SelectFullOrHalfId" style="margin-top:5px" class="form-control" onChange="leaveTypecheck();
                                                                    checkPresentAjax();
                                                                    daysCount();">
                                                                <option value="">--SELECT--</option>
                                                                <!--<option value="Fullday">Full Day</option>-->
                                                                <!--<option value="FirstHalf">First Half</option>-->
                                                                <!--<option value="SecondHalf">Second Half</option>-->
                                                                <c:choose>
                                                                    <c:when test="${(leaveEmployeeDetail.startDateStatus).contains('Fullday')}">
                                                                        <option value="Fullday" selected="">Full Day</option>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <option value="Fullday">Full Day</option>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                                <c:choose>
                                                                    <c:when test="${(leaveEmployeeDetail.startDateStatus).contains('FirstHalf')}">
                                                                        <option value="FirstHalf" selected="">First Half</option>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <option value="FirstHalf">First Half</option>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                                <c:choose>
                                                                    <c:when test="${(leaveEmployeeDetail.startDateStatus).contains('SecondHalf')}">
                                                                        <option value="SecondHalf" selected="">Second Half</option>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <option value="SecondHalf">Second Half</option>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </select>
                                                            <span id="startDateSelectFullOrHalfError" style="color: red;"></span>
                                                        </div>

                                                        <div class=" col-sm-4">
                                                            <label>Leave End Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                <%--<form:input id="leaveEndDateId" class="form-control" size="16" type="text" value="" onchange="leaveSetting(); daysCount();" readonly="true"></form:input>--%>
                                                                <form:input path="endDate" class="form-control" onchange="checkEndDateFun();leaveSetting();leaveTypecheck();
                                                                            daysCount();calculateSecondSatByAjax();" readonly="true"></form:input>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                </div>
                                                                <span id="endDateError" style="color: red;"></span>
                                                                <span id="eDateHolidayError" style="color: red;"></span>
                                                                <span id="endpresetErrorDiv" style="color: red;"></span>
                                                            <%--<form:errors path="endDate" cssClass="errorDiv"></form:errors>--%>

                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label></label>
                                                            <select id="leaveEndDate_SelectFullOrHalfId" name="leaveEndDate_SelectFullOrHalfId" style="margin-top:5px" class="form-control" onChange="leaveTypecheck();
                                                                    checkPresentAjax();
                                                                    daysCount();">
                                                                <option value="">--SELECT--</option>
                                                                <c:choose>
                                                                    <c:when test="${(leaveEmployeeDetail.endDateStatus).contains('Fullday')}">
                                                                        <option value="Fullday" selected="">Full Day</option>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <option value="Fullday">Full Day</option>
                                                                    </c:otherwise>
                                                                </c:choose><c:choose>
                                                                    <c:when test="${(leaveEmployeeDetail.endDateStatus).contains('FirstHalf')}">
                                                                        <option value="FirstHalf" selected="">First Half</option>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <option value="FirstHalf">First Half</option>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                                <c:choose>
                                                                    <c:when test="${(leaveEmployeeDetail.endDateStatus).contains('SecondHalf')}">
                                                                        <option style="display: none" value="SecondHalf" selected="">Second Half</option>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <option style="display: none" value="SecondHalf">Second Half</option>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                                <!--<option value="Fullday">Full Day</option>-->
                                                                <!--<option value="FirstHalf">First Half</option>-->
                                                                <!--<option style="display: none" value="SecondHalf">Second Half</option>-->
                                                            </select>
                                                            <span id="endDateSelectFullOrHalfError" style="color: red;"></span>
                                                        </div>

                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                            <label>Number Of Days:</label>
                                                            <%--<form:input path="leaveDays" type="number" class="form-control" readonly="true"></form:input>--%>
                                                            <form:input path="noOfDays" type="number" class="form-control" readonly="true"></form:input>
                                                                <input type="hidden" name="hiddenDays" id="hiddenDays" value="">
                                                                <span id="noOfDaysError" style="color: red;"></span>
                                                            </div>
                                                            <div  id="calsualLeaveDiv" name="calsualLeaveDiv" style="color: red; display: none; margin-left: 20px;">In Case If You want to Apply Leave For More than 2 Days for Casual/Personal/Any Other except for Sickness.Please Apply PL.</div>
                                                            <!--<div  id="calsualLeaveDiv" name="calsualLeaveDiv" style="color: red; display: none; margin-left: 20px;">In Casual Leave You Apply Max. 3 days.If you wan't to apply More Days of leave Then Apply For PL.</div>-->
                                                            <div  id="sickLeaveDiv" name="sickLeaveDiv" style="color: red; display: none; margin-left: 20px;">You taken More than 3 of days sick leave. So for that doctor's authorize certificate submit when come at office. </div>
                                                            <div  id="paternityLeaveDiv" name="paternityLeaveDiv" style="color: red; display: none; margin-left: 20px;">In Paternity Leave You can Apply Max. 3 days.</div>
                                                            <div  id="leaveWithoutPayLeaveDiv" name="leaveWithoutPayLeaveDiv" style="color: red; display: none; margin-left: 20px;">In Leave Without Pay Only Apply When All leave is not in balance. And Max OF 60 Days.</div>
                                                            <div  id="balanceDiv" name="Please enter days less or equal current available Balance" style="color: red; display: none; margin-left: 20px;">Please enter days less or equal current available Balance</div>
                                                            <div  id="plDiv" name="plDiv" style="color: red; display: none; margin-left: 20px;">SL Balance is available so in that case u can't apply PL less than 3 Days</div>
                                                            <div  id="futureDateSelect" name="futureDateSelect" style="color: red; display: none; margin-left: 20px;">Future Date Must be Selected</div>
                                                        </div>
                                                    </div>
                                                    <div id="shortLeave" style="display: none;">
                                                        <div class="form-group">
                                                            <div class=" col-sm-4">
                                                                <label>Leave Start Date & Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <div class="input-group date "  id="shortLeaveStartDate"  data-date-format="dd/mm/yyyy - hh:ii " data-link-field="dtp_input1">
                                                                <%--<form:input path="leaveStartDateId" class="form-control" size="16" type="text" value="" onchange="leaveSetting(); daysCount();" readonly="true"></form:input>--%>
                                                                <input type="text" name="startDateShort" id="startDateShort" class="form-control" size="16" type="text" value="" onchange="fillEnddate(this.value);"  readonly="true"/>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                            <span id="shortleavestartDateError" style="color: red;"></span>
                                                        </div>


                                                        <div class=" col-sm-4">
                                                            <label>Leave End Date & Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <div class="input-group date" id="shortLeaveEndDate"   data-date-format="dd/mm/yyyy - hh:ii " data-link-field="dtp_input1">
                                                                <%--<form:input id="leaveEndDateId" class="form-control" size="16" type="text" value="" onchange="leaveSetting(); daysCount();" readonly="true"></form:input>--%>
                                                                <input type="text"  name="endDateShort" id="endDateShort" class="form-control" size="16" onchange="shortLeaveEndCount(this.value);" type="text" value=""  readonly="true"/>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                            <span id="shortleaveendDateError" style="color: red;"></span>
                                                            <input type="hidden" name="noOfDayLeave" id="noOfDayLeave" >
                                                        </div>
                                                    </div>
                                                </div>

                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                                <!--Leave Detail completes Here-->
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Reason In Detail:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onClick="buttonFun3()"><i class="fa fa-plus" id="minusId3"></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">Reason For Leave:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="col-sm-7">
                                                        <form:textarea path="empRemark" class="form-control" rows="6"></form:textarea>
                                                            <span id="empRemarkError" style="color: red;"></span>
                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <!--Reason For Leave In Detail completes Here-->
                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">Leave Balance Sheet In Detail:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onClick="buttonFun4()"><i class="fa fa-plus" id="minusId4"></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row" style="margin: auto">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="table-responsive">
                                                        <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                            <tr>
                                                                <th>Leave</th>
                                                                <c:forEach var="remain" items="${listRemain}">
                                                                <th style="text-align: center;">${remain.key}</th>
                                                                </c:forEach>
                                                        </tr>
                                                        <tr>
                                                            <td>Leave Balance In Start Of The Year</td>
                                                            <c:forEach var="totalDays" items="${totalDaysMap}">

                                                                <td style="text-align: center;">${totalDays.value}</td>
                                                            </c:forEach>

                                                        </tr>
                                                        <tr>
                                                            <td>No. Of Leaves Applied During The Year</td>
                                                            <c:forEach var="empreq" items="${empReqMap}">
                                                                <td style="text-align: center;">${empreq.value}</td>
                                                            </c:forEach>

                                                        </tr>
                                                        <tr>
                                                            <td>Current Available Balance</td>
                                                            <c:forEach var="remain" items="${listRemain}">
                                                                <td id="${remain.key}1" style="text-align: center;">${remain.value}</td>

                                                            </c:forEach>
                                                        </tr>
                                                        <tr>
                                                            <td>No. Of Leaves Applied In This Application</td>
                                                            <c:forEach var="remain" items="${listRemain}">
                                                                <td id="${remain.key}" style="text-align: center;">0</td>
                                                            </c:forEach>

                                                        </tr>
                                                        <tr>
                                                            <th>Projected Balance After This Application Approval</th>

                                                            <c:forEach var="remain" items="${listRemain}">
                                                                <th id="${remain.key}2" style="text-align: center;">${remain.value}</th>
                                                                </c:forEach>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div><!-- /.col
                                        </div><!-- /.row -->
                                        </div><!-- /.box-body -->

                                    </div>
                                    <br/>

                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12" style="text-align: center;">
                                        <button type="submit" id="sunmit_button" class="btn btn-primary" style="width: 100px;" data-original-title="" title="">SUBMIT</button>
                                    </div>
                                </div>

                            </form:form>

                            <div id="myModal" class="modal fade" role="dialog">
                                <div class="modal-dialog">

                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title">Modal Header</h4>
                                        </div>
                                        <div class="modal-body">
                                            <p>Some text in the modal.</p>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>

                                </div>
                            </div>
                            <!--form horizontal ends here-->
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
            autoclose: 2,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0,
            showMeridian: 1
        });</script>

    <script type="text/javascript">
        $('#shortLeaveStartDate').datetimepicker({
            //        language:  'fr',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            forceParse: 0,
            showMeridian: 1
        });</script>
    <script type="text/javascript">
        $('#shortLeaveEndDate').datetimepicker({
            //        language:  'fr',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            forceParse: 0,
            showMeridian: 1
        });</script>

    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <style>
        .class-with-width { width: 150px !important; }
    </style>    
    <script>
        function getUseAsSickLevave(id) {
            $.post("leaveEmployeeDetail.htm?act=readleaveTypeMaster",
                    {
                        id: id,
                    }, function (responseTxt, statusTxt, xhr) {
                if (statusTxt === "success") {
                    ("responseTxt" + responseTxt);
                    var obj1 = JSON.parse(responseTxt);
                    var desigJSON1 = obj1['useSickLeave'];
//                    alert("desigJSON1  " + desigJSON1)
//                    var desigJSONKey1 = Object.keys(obj1['useSickLeave']);
//                    alert("desigJSONKey1  " + desigJSONKey1);
                    if (desigJSON1 == "0") {
//                        alert('in');
                        $('#uAsSickId').show();
                    } else if (desigJSON1 == "1") {
//                        alert('out');
                        $('#uAsSickId').show();
                    } else {
//                        alert('Final out');
                        $('#uAsSickId').hide();
                    }
                }
                if (statusTxt === "error")
                    ("Error: " + xhr.status + ": " + xhr.statusText);
            });
        }


    </script>
    <script type="text/javascript" src="StorageYard/Plugins/alert/bootbox.min.js"></script>  
</html>
