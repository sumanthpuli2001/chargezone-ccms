<%--
    Document   : LeaveApplicationFormEdit
    Created on : Oct 16, 2015, 4:36:08 PM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Withdraw Leave Application</title>
    </head>
    <script>
        $(function () {
            var previous;
            var strUser;
            var leaveTypes = document.getElementById("leaveTypeMaster.id");
            $(leaveTypes).focus(function () {
//                alert('ssss');
                previous = leaveTypes.options[leaveTypes.selectedIndex].text;
                var strUser1 = previous.split('(');
                strUser = strUser1[0]

//                alert('ajay11zzzzzzzzz' + strUser1[0]);
//                alert('xxxxxxxxxxxx' + document.getElementById(strUser).innerHTML);
                document.getElementById(strUser).innerHTML = 0;
                document.getElementById(strUser + "2").innerHTML = 0;
            })
        });
//        $(function () {



        function leaveSetting() {
            var leaveStartDate = document.getElementById("startDate").value;
            var leaveStartDate_SelectFullOrHalf = document.getElementById("leaveStartDate_SelectFullOrHalfId").value;
            var leaveEndDate = document.getElementById("endDate").value;
            var leaveEndDate_SelectFullOrHalf = document.getElementById("leaveEndDate_SelectFullOrHalfId").value;

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
            }
        }

        function leaveTypecheck() {
            var leaveType = document.getElementById("leaveTypeMaster.id");
            var selectedText = leaveType.options[leaveType.selectedIndex].text;
            var selectedTextArray = selectedText.split('(');
            selectedText = selectedTextArray[0];
            var leaveStartDate = document.getElementById("startDate").value;
            var leaveEndDate = document.getElementById("endDate").value;
            leaveStartDate = leaveStartDate.split('/');
            leaveEndDate = leaveEndDate.split('/');
            leaveStartDate = new Date(leaveStartDate[2], leaveStartDate[1], leaveStartDate[0]);
            leaveEndDate = new Date(leaveEndDate[2], leaveEndDate[1], leaveEndDate[0]);

//            var leaveDays = ((leaveEndDate - leaveStartDate) / (1000 * 60 * 60 * 24)) + 1;
            var leaveDays = document.getElementById("hiddenDays").value;
            var days = document.getElementById("noOfDays").value = leaveDays;

            if (selectedText == 'Casual Leave') {
                if (days > 3) {
                    $("#calsualLeaveDiv").show();
                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = '';
                    setTimeout(function () {
                        $("#calsualLeaveDiv").fadeOut();
                    }, 10000);
                }

            }

            if (selectedText == 'Sick Leave') {
                if (days > 3) {
                    $("#sickLeaveDiv").show();
                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = '';
                    setTimeout(function () {
                        $("#sickLeaveDiv").fadeOut();
                    }, 10000);
                }

            }
            if (selectedText == 'Paternity Leave') {
                if (days > 3) {
                    $("#paternityLeaveDiv").show();
                    document.getElementById("leaveEndDate_SelectFullOrHalfId").value = '';
                    setTimeout(function () {
                        $("#paternityLeaveDiv").fadeOut();
                    }, 10000);
                }

            }
            if (selectedText == 'Leave Without Pay') {
                if (days > 60) {
                    $("#leaveWithoutPayLeaveDiv").show();
                    document.getElementById("endDate").value = '';
                    setTimeout(function () {
                        $("#leaveWithoutPayLeaveDiv").fadeOut();
                    }, 10000);
                }

            }

        }

        var count = 0;
        var count1 = 0;
        function daysCount() {
        var skillsSelect = document.getElementById("leaveTypeMaster.id");
                var selectedText = skillsSelect.options[skillsSelect.selectedIndex].text;
                var selectedTextArray = selectedText.split('(');
                selectedText = selectedTextArray[0];
                if (selectedText == 'Short Leave') {

        $("#NoshortLeave").hide();
                $("#shortLeave").show();
        } else {
        if ('${leaveType}' == 'Short Leave' && count == 0) {
        count = count + 1;
                var today = new Date();
                var dd = today.getDate();
                var mm = today.getMonth() + 1; //January is 0!
                var yyyy = today.getFullYear();
                if (dd < 10) {
        dd = '0' + dd
        }
        if (mm < 10) {
        mm = '0' + mm
        }
        today = dd + '/' + mm + '/' + yyyy;
                document.getElementById("startDate").value = '';
                document.getElementById("endDate").value = '';
                var leaveStartDate_Copy = '';
                var leaveEndDate_Copy = '';
        }
        if (count1 == 1) {
        document.getElementById('leaveStartDate_SelectFullOrHalfId').value = "";
                document.getElementById('leaveEndDate_SelectFullOrHalfId').value = "";
                count1 = count1 + 1;
        } else if (count1 == 0) {
        count1 = count1 + 1;
        }


        $("#NoshortLeave").show();
                $("#shortLeave").hide();
                var leaveStartDate = document.getElementById("startDate").value;
                var leaveStartDate_Copy = document.getElementById("startDate").value;
                var leaveEndDate = document.getElementById("endDate").value;
                calculateDayByAjax();
                var leaveEndDate_Copy = document.getElementById("endDate").value;
                var leaveStartDate_SelectFullOrHalf = document.getElementById("leaveStartDate_SelectFullOrHalfId").value;
                var leaveEndDate_SelectFullOrHalf = document.getElementById("leaveEndDate_SelectFullOrHalfId").value;
// First we split the values to arrays date1[0] is the day, [1] the month and [2] the year
                leaveStartDate = leaveStartDate.split('/');
                leaveEndDate = leaveEndDate.split('/');
// Now we convert the array to a Date object, which has several helpful methods
                leaveStartDate = new Date(leaveStartDate[2], leaveStartDate[1], leaveStartDate[0]);
                leaveEndDate = new Date(leaveEndDate[2], leaveEndDate[1], leaveEndDate[0]);
//                var leaveDays = ((leaveEndDate - leaveStartDate) / (1000 * 60 * 60 * 24)) + 1;
                var leaveDays = document.getElementById("hiddenDays").value;
//            alert("leave year" + (leaveStartDate[2] == leaveEndDate[2]));
//            alert("leave date" + (leaveStartDate[1] == leaveEndDate[1]));
//            alert(document.getElementById("table_1").rows[4].cells.item(1).innerHTML);
                var strUser;
                var strUser1;
                var leaveTypes = document.getElementById("leaveTypeMaster.id");
//            alert(leaveTypes.length);
//            $('#leaveTypeMaster not(:selected)')
//            var $el = $(leaveTypes).prev().find('option:selected');
//            alert($el.value);
//            var selHistory = [];
//            selHistory[selHistory.length] = leaveTypes.options[leaveTypes.selectedIndex].text;
//            alert(leaveTypes.options[leaveTypes.selectedIndex]);

//            alert(leaveTypes.options[selHistory[selHistory.length - 2]].text);
                var newstrDate = leaveTypes.options[leaveTypes.selectedIndex].text;
                strUser1 = newstrDate.split('(');
                strUser = strUser1[0];
                var strUser2 = strUser1[1];
                strUser2 = strUser2.split(')');
                var leaveBalance = strUser2[0];
                if (leaveBalance != 0){
//            document.getElementById(strUser).innerHTML = 0;
//            alert('ajay' + strUser);
//            alert(document.getElementById(strUser + "1").innerHTML);
//document.getElementById(strUser).value
//            if ((leaveStartDate[2] == leaveEndDate[2]) && (leaveStartDate[0] == leaveEndDate[0]) && (leaveStartDate[1] == leaveEndDate[1])) {
        if (leaveEndDate_Copy == leaveStartDate_Copy) {
        if (leaveStartDate_SelectFullOrHalf == "Fullday") {
        document.getElementById("noOfDays").value = leaveDays;
                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
//                    alert('xyzzzzzzzz' + document.getElementById("noOfDays").value);
//                    alert(document.getElementById(strUser).innerHTML);
                if (document.getElementById(strUser).innerHTML > document.getElementById(strUser + "1").innerHTML) {
//                            alert("Please enter days less or equal current available Balance");
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
        if (leaveStartDate_SelectFullOrHalf == "FirstHalf") {
        document.getElementById("noOfDays").value = leaveDays - 0.5;
                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                if (document.getElementById(strUser).innerHTML > document.getElementById(strUser + "1").innerHTML) {
//                            alert("Please enter days less or equal current available Balance");
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
        if (leaveStartDate_SelectFullOrHalf == "SecondHalf") {
        document.getElementById("noOfDays").value = leaveDays - 0.5;
                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                if (document.getElementById(strUser).innerHTML > document.getElementById(strUser + "1").innerHTML) {
//                            alert("Please enter days less or equal current available Balance");
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
        } else if (leaveEndDate_Copy != '' && leaveEndDate_Copy < leaveStartDate_Copy) {


        alert('please select Start Date After End Date.');
                document.getElementById(strUser).innerHTML = 0;
                document.getElementById("noOfDays").value = "";
                document.getElementById(strUser + "2").innerHTML = 0;
                document.getElementById("startDate").value = "";
                document.getElementById("endDate").value = "";
        }
        else {
        if (leaveStartDate_SelectFullOrHalf == "Fullday" && leaveEndDate_SelectFullOrHalf == "Fullday" && selectedText != 'Privilege Leave') {
        document.getElementById("noOfDays").value = leaveDays;
                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
//                    alert('ajay1234');
                if (document.getElementById(strUser).innerHTML > document.getElementById(strUser + "1").innerHTML) {
//                            alert("Please enter days less or equal current available Balance");
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
        if (leaveStartDate_SelectFullOrHalf == "Fullday" && leaveEndDate_SelectFullOrHalf == "FirstHalf") {
        //                    alert('ajay' + (leaveDays - 0.5));
        document.getElementById("noOfDays").value = leaveDays - 0.5;
                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                if (document.getElementById(strUser).innerHTML > document.getElementById(strUser + "1").innerHTML) {
//                            alert("Please enter days less or equal current available Balance");
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
        //                if (leaveStartDate_SelectFullOrHalf == "FirstHalf" && leaveEndDate_SelectFullOrHalf == "Fullday") {
        //                    document.getElementById("noOfDays").value = leaveDays - 0.5;
//                }
        if (leaveStartDate_SelectFullOrHalf == "SecondHalf" && leaveEndDate_SelectFullOrHalf == "FirstHalf") {
        document.getElementById("noOfDays").value = leaveDays - 1;
                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                if (document.getElementById(strUser).innerHTML > document.getElementById(strUser + "1").innerHTML) {
//                            alert("Please enter days less or equal current available Balance");
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
        if (leaveStartDate_SelectFullOrHalf == "SecondHalf" && leaveEndDate_SelectFullOrHalf == "Fullday") {
//                        alert("Mike" + leaveDays);
//                        alert("Ajay" + strUser);
        document.getElementById("noOfDays").value = leaveDays - 0.5;
                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                if (document.getElementById(strUser).innerHTML > document.getElementById(strUser + "1").innerHTML) {
//                            alert("Please enter days less or equal current available Balance");
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
        } else{
        document.getElementById("noOfDays").value = leaveDays;
        }
        }



        function fillEnddate(Enddate) {
        var strUser;
                var strUser1;
                var leaveTypes = document.getElementById("leaveTypeMaster.id");
                var newstrDate = leaveTypes.options[leaveTypes.selectedIndex].text;
                strUser1 = newstrDate.split('(');
                strUser = strUser1[1].split(')');
                if (parseFloat(strUser[0]) >= 1) {
        var now = new Date();
                var Enddate1 = Enddate.split(' - ');
                var n_date = Enddate1[0];
                n_date = n_date.split("/");
                n_date = n_date[1] + "/" + n_date[0] + "/" + n_date[2];
                if (new Date(n_date) < now) {
        document.getElementById("startDateShort").value = '';
                document.getElementById("endDateShort").value = '';
                // selected date is in the past
        } else {
        var parts = Enddate.split('/');
                var parts1 = parts[2].split(' - ');
                var parts2 = parts1[1].split(':');
                // new Date(year, month [, day [, hours[, minutes[, seconds[, ms]]]]])
                var d2 = new Date(parts1[0], (parts[1] - 1), parts[0], parts2[0], parts2[1]);
//            alert('hii' + d2.getHours());
//            alert('aaaaa' + '${shortLeaveHoursNo}');
                d2.setTime(d2.getTime() + ('${shortLeaveHoursNo}' * 60 * 60 * 1000));
//            alert('khurhz' +);
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
//    alert("aaaaaaaaaaaaaaaaajay"+aaaaa);
        document.getElementById('endDateShort').value = aDate + "/" + aMonth + "/" + d2.getFullYear() + " - " + aHours + ":" + aMinutes;
        }
        } else {
//                alert('Please enter days less or equal current available Balance');
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
        function ajaxdaysCount() {
        var skillsSelect = document.getElementById("leaveTypeMaster.id");
                var selectedText = skillsSelect.options[skillsSelect.selectedIndex].text;
                var selectedTextArray = selectedText.split('(');
                selectedText = selectedTextArray[0];
                if (selectedText == 'Short Leave') {

        $("#NoshortLeave").hide();
                $("#shortLeave").show();
        } else {
        if ('${leaveType}' == 'Short Leave' && count == 0) {
        count = count + 1;
                var today = new Date();
                var dd = today.getDate();
                var mm = today.getMonth() + 1; //January is 0!
                var yyyy = today.getFullYear();
                if (dd < 10) {
        dd = '0' + dd
        }
        if (mm < 10) {
        mm = '0' + mm
        }
        today = dd + '/' + mm + '/' + yyyy;
                document.getElementById("startDate").value = '';
                document.getElementById("endDate").value = '';
                var leaveStartDate_Copy = '';
                var leaveEndDate_Copy = '';
        }
        if (count1 == 1) {
        document.getElementById('leaveStartDate_SelectFullOrHalfId').value = "";
                document.getElementById('leaveEndDate_SelectFullOrHalfId').value = "";
                count1 = count1 + 1;
        } else if (count1 == 0) {
        count1 = count1 + 1;
        }


        $("#NoshortLeave").show();
                $("#shortLeave").hide();
                var leaveStartDate = document.getElementById("startDate").value;
                var leaveStartDate_Copy = document.getElementById("startDate").value;
                var leaveEndDate = document.getElementById("endDate").value;
                var leaveEndDate_Copy = document.getElementById("endDate").value;
                var leaveStartDate_SelectFullOrHalf = document.getElementById("leaveStartDate_SelectFullOrHalfId").value;
                var leaveEndDate_SelectFullOrHalf = document.getElementById("leaveEndDate_SelectFullOrHalfId").value;
// First we split the values to arrays date1[0] is the day, [1] the month and [2] the year
                leaveStartDate = leaveStartDate.split('/');
                leaveEndDate = leaveEndDate.split('/');
// Now we convert the array to a Date object, which has several helpful methods
                leaveStartDate = new Date(leaveStartDate[2], leaveStartDate[1], leaveStartDate[0]);
                leaveEndDate = new Date(leaveEndDate[2], leaveEndDate[1], leaveEndDate[0]);
//                var leaveDays = ((leaveEndDate - leaveStartDate) / (1000 * 60 * 60 * 24)) + 1;
                var leaveDays = document.getElementById("hiddenDays").value;
//                alert("hiddenDays" + leaveDays);

//            alert("leave year" + (leaveStartDate[2] == leaveEndDate[2]));
//            alert("leave date" + (leaveStartDate[1] == leaveEndDate[1]));
//            alert(document.getElementById("table_1").rows[4].cells.item(1).innerHTML);
                var strUser;
                var strUser1;
                var leaveTypes = document.getElementById("leaveTypeMaster.id");
//            alert(leaveTypes.length);
//            $('#leaveTypeMaster not(:selected)')
//            var $el = $(leaveTypes).prev().find('option:selected');
//            alert($el.value);
//            var selHistory = [];
//            selHistory[selHistory.length] = leaveTypes.options[leaveTypes.selectedIndex].text;
//            alert(leaveTypes.options[leaveTypes.selectedIndex]);

//            alert(leaveTypes.options[selHistory[selHistory.length - 2]].text);
                var newstrDate = leaveTypes.options[leaveTypes.selectedIndex].text;
                strUser1 = newstrDate.split('(');
                strUser = strUser1[0];
//            document.getElementById(strUser).innerHTML = 0;
//                alert('ajay' + leaveEndDate_Copy == leaveStartDate_Copy);
//            alert(document.getElementById(strUser + "1").innerHTML);
//document.getElementById(strUser).value
//            if ((leaveStartDate[2] == leaveEndDate[2]) && (leaveStartDate[0] == leaveEndDate[0]) && (leaveStartDate[1] == leaveEndDate[1])) {
                if (leaveEndDate_Copy == leaveStartDate_Copy) {

        if (leaveStartDate_SelectFullOrHalf == "Fullday") {
        document.getElementById("noOfDays").value = leaveDays;
                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
//                    alert('xyzzzzzzzz' + document.getElementById("noOfDays").value);
//                    alert(document.getElementById(strUser).innerHTML);
                if (document.getElementById(strUser).innerHTML > document.getElementById(strUser + "1").innerHTML) {
//                            alert("Please enter days less or equal current available Balance");
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
        if (leaveStartDate_SelectFullOrHalf == "FirstHalf") {
        document.getElementById("noOfDays").value = leaveDays - 0.5;
                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                if (document.getElementById(strUser).innerHTML > document.getElementById(strUser + "1").innerHTML) {
//                            alert("Please enter days less or equal current available Balance");
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
        if (leaveStartDate_SelectFullOrHalf == "SecondHalf") {
        document.getElementById("noOfDays").value = leaveDays - 0.5;
                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                if (document.getElementById(strUser).innerHTML > document.getElementById(strUser + "1").innerHTML) {
//                            alert("Please enter days less or equal current available Balance");
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
//                else if (leaveEndDate_Copy != '' && leaveEndDate_Copy < leaveStartDate_Copy) {
//               alert("A"+leaveEndDate_Copy < leaveStartDate_Copy);
//                    alert("b"+leaveEndDate_Copy != '');
//                    alert('please select Start Date After End Date.');
//                    document.getElementById(strUser).innerHTML = 0;
//                    document.getElementById("noOfDays").value = "";
//                    document.getElementById(strUser + "2").innerHTML = 0;
//                    document.getElementById("startDate").value = "";
//                    document.getElementById("endDate").value = "";
//
//                }
        else {
//                    alert("leaveStartDate_SelectFullOrHalf" + leaveStartDate_SelectFullOrHalf);
//                    alert("leaveEndDate_SelectFullOrHalf" + leaveEndDate_SelectFullOrHalf);
        if (leaveStartDate_SelectFullOrHalf == "Fullday" && leaveEndDate_SelectFullOrHalf == "Fullday") {
//                        alert("FullDay" + leaveDays);
        document.getElementById("noOfDays").value = leaveDays;
                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
//                    alert('ajay1234');
                if (document.getElementById(strUser).innerHTML > document.getElementById(strUser + "1").innerHTML) {
//                            alert("Please enter days less or equal current available Balance");
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
        if (leaveStartDate_SelectFullOrHalf == "Fullday" && leaveEndDate_SelectFullOrHalf == "FirstHalf") {
        //                    alert('ajay' + (leaveDays - 0.5));
        document.getElementById("noOfDays").value = leaveDays - 0.5;
                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                if (document.getElementById(strUser).innerHTML > document.getElementById(strUser + "1").innerHTML) {
//                            alert("Please enter days less or equal current available Balance");
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
        //                if (leaveStartDate_SelectFullOrHalf == "FirstHalf" && leaveEndDate_SelectFullOrHalf == "Fullday") {
        //                    document.getElementById("noOfDays").value = leaveDays - 0.5;
//                }
        if (leaveStartDate_SelectFullOrHalf == "SecondHalf" && leaveEndDate_SelectFullOrHalf == "FirstHalf") {
        document.getElementById("noOfDays").value = leaveDays - 1;
                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                if (document.getElementById(strUser).innerHTML > document.getElementById(strUser + "1").innerHTML) {
//                            alert("Please enter days less or equal current available Balance");
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
        if (leaveStartDate_SelectFullOrHalf == "SecondHalf" && leaveEndDate_SelectFullOrHalf == "Fullday") {
//                        alert("Mike" + leaveDays);
//                        alert("Ajay" + strUser);
        document.getElementById("noOfDays").value = leaveDays - 0.5;
                document.getElementById(strUser).innerHTML = document.getElementById("noOfDays").value;
                if (document.getElementById(strUser).innerHTML > document.getElementById(strUser + "1").innerHTML) {
//                            alert("Please enter days less or equal current available Balance");
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
        }
        }
    </script>
    <script>
        function calculateDayByAjax() {
        try {
        var strDate = document.getElementById("startDate").value;
                var enDate = document.getElementById("endDate").value;
//                alert("enDate" + enDate);
                var sDateStatus = document.getElementById("leaveStartDate_SelectFullOrHalfId").value;
                var eDateStatus = document.getElementById("leaveEndDate_SelectFullOrHalfId").value;
//                && sDateStatus != '' && eDateStatus != ''

                if (strDate != '' && enDate != '') {
//                    alert("wwww" + strDate);
//                    alert("sDateStatus" + sDateStatus);
        $.ajax({
        type: "POST",
                url: "leaveEmployeeDetail.htm?act=getActualDayByAjax&strDate=" + strDate + "&enDate=" + enDate + "&sDateStatus=" + sDateStatus + "&eDateStatus=" + eDateStatus,
                data: {},
                dataType: "text",
                success: function (responseTxt) {
//                            document.getElementById("noOfDays").value = responseTxt;
//                            alert("responseTxt" + responseTxt);
                document.getElementById("hiddenDays").value = responseTxt;
                        ajaxdaysCount();
                },
                error: function () {
                alert('Error occured');
                }
        });
        }
        } catch (e) {

        }
        }

    </script>
    <script>
// A $( document ).ready() block.
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
//            calculateDayByAjax();
//            leaveSetting();
//            leaveTypecheck();
//            daysCount();
//            fillEnddate();
        });

    </script>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Leave Application Edit:</h1>
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
                            <form:form action="leaveEmployeeDetail.htm?act=editLeaveRequest" method="post" commandName="leaveEmployeeDetail"
                                       name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
                                <form:hidden path="id"></form:hidden>
                                <form:hidden path="status"></form:hidden>
                                <input type="hidden" id="oldLeaveId" name="oldLeaveId" value="${oldLeaveId}"/>
                                <!--Read only entries Starts here-->
                                <div class="box box-info collapsed-box ">
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
                                                        <input type="Text" class="form-control" value="${employeeMaster[0]}" readonly>
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
                                                        <label>Department:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control"  value="${employeeMaster[4]}" readonly>
                                                    </div>

                                                    <div class="col-sm-2">
                                                        <label>Work Location:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control"  value="${employeeMaster[5]}" readonly>
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
                                    </div>
                                </div>
                                <!--Employee detail completes here-->
                                <!--read only entries ends here-->

                                <div class="box box-info collapsed-box">

                                    <div class="box-header">
                                        <h3 class="box-title">Leave Detail:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2()"><i class="fa fa-plus" id="minusId2"></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-12">
                                                        <label>Leave Type:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:select path="leaveTypeMaster.id" class="form-control" onchange="daysCount();" style="pointer-events: none; cursor: default;">
                                                            <form:option value="" label="-- Select --" />
                                                            <form:options items="${leaveTypemap}" />
                                                        </form:select>
                                                        <%--<form:select path="" id="poolCarRequestSelectId" class="form-control ">--%>
                                                    </div>
                                                </div>
                                                <div id="NoshortLeave">


                                                    <div class="form-group">
                                                        <div class=" col-sm-4">
                                                            <label>Leave Start Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <!--<div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">-->
                                                            <%--<form:input path="leaveStartDateId" class="form-control" size="16" type="text" value="" onchange="leaveSetting(); daysCount();" readonly="true"></form:input>--%>
                                                            <form:input path="startDate" class="form-control" size="16" type="text" value="" onchange="calculateDayByAjax();leaveSetting();
                                                                        daysCount();" readonly="true"></form:input>
                                                                <!--<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>-->
                                                                <!--</div>-->
                                                            </div>
                                                            <div class="col-sm-2">
                                                                <label></label>
                                                                <select id="leaveStartDate_SelectFullOrHalfId" name="leaveStartDate_SelectFullOrHalfId" style="margin-top:5px;pointer-events: none;cursor: default;" class="form-control" onchange="leaveSetting();
                                                                                    daysCount();">
                                                                    <option value="">--SELECT--</option>
                                                                <c:choose>
                                                                    <c:when test="${strDateStatus.contains('Fullday')}">
                                                                        <option value="Fullday" selected="">Full Day</option>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <option value="Fullday">Full Day</option>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                                <c:choose>
                                                                    <c:when test="${strDateStatus.contains('FirstHalf')}">
                                                                        <option value="FirstHalf" selected="">First Half</option>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <option value="FirstHalf">First Half</option>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                                <c:choose>
                                                                    <c:when test="${strDateStatus.contains('SecondHalf')}">
                                                                        <option value="SecondHalf" selected="">Second Half</option>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <option value="SecondHalf">Second Half</option>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </select>
                                                        </div>
                                                        <div class=" col-sm-4">
                                                            <label>Leave End Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <!--<div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">-->
                                                            <%--<form:input id="leaveEndDateId" class="form-control" size="16" type="text" value="" onchange="leaveSetting(); daysCount();" readonly="true"></form:input>--%>
                                                            <form:input path="endDate" class="form-control" size="16" type="text" value="" onchange="calculateDayByAjax();leaveSetting();
                                                                        daysCount();" readonly="true"></form:input>
                                                                <!--<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>-->
                                                                <!--</div>-->
                                                            </div>
                                                            <div class="col-sm-2">
                                                                <label></label>
                                                                <select id="leaveEndDate_SelectFullOrHalfId" name="leaveEndDate_SelectFullOrHalfId" style="margin-top:5px;pointer-events: none;cursor: default;" class="form-control" onchange="daysCount();
                                                                                    leaveTypecheck()">
                                                                    <option value="">--SELECT--</option>
                                                                <c:choose>
                                                                    <c:when test="${endDateStatus.contains('Fullday')}">
                                                                        <option value="Fullday" selected="">Full Day</option>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <option value="Fullday">Full Day</option>
                                                                    </c:otherwise>
                                                                </c:choose><c:choose>
                                                                    <c:when test="${endDateStatus.contains('FirstHalf')}">
                                                                        <option value="FirstHalf" selected="">First Half</option>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <option value="FirstHalf">First Half</option>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                                <c:choose>
                                                                    <c:when test="${endDateStatus.contains('SecondHalf')}">
                                                                        <option style="display: none" value="SecondHalf" selected="">Second Half</option>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <option style="display: none" value="SecondHalf">Second Half</option>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                                <!--                                                                <option value="Fullday">Full Day</option>-->
                                                                <!--<option value="FirstHalf">First Half</option>-->
                                                                <!--<option style="display: none" value="SecondHalf">Second Half</option>-->
                                                            </select>
                                                        </div>

                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                            <label>Number Of Days:</label>
                                                            <%--<form:input path="leaveDays" type="number" class="form-control" readonly="true"></form:input>--%>
                                                            <form:input path="noOfDays" type="number" class="form-control" readonly="true"></form:input>
                                                                <input type="hidden" name="hiddenDays" id="hiddenDays" value="">
                                                            </div>
                                                            <div  id="calsualLeaveDiv" name="calsualLeaveDiv" style="color: red; display: none; margin-left: 20px;">In Casual Leave You Apply Max. 3 days.If you wan't to apply More Days of leave Then Apply For PL.</div>
                                                            <div  id="sickLeaveDiv" name="sickLeaveDiv" style="color: red; display: none; margin-left: 20px;">In Sick Leave You Apply Max. 3 days.If you wan't to apply More Days of Leave Then Doctor's Certificate</div>
                                                            <div  id="paternityLeaveDiv" name="paternityLeaveDiv" style="color: red; display: none; margin-left: 20px;">In Paternity Leave You Apply Max. 3 days.</div>
                                                            <div  id="leaveWithoutPayLeaveDiv" name="leaveWithoutPayLeaveDiv" style="color: red; display: none; margin-left: 20px;">In Leave Without Pay Only Apply When All leave is not in balance. And Max OF 60 Days.</div>
                                                            <div  id="balanceDiv" name="balanceDiv" style="color: red; display: none; margin-left: 20px;">Please enter days less or equal current available Balance</div>
                                                        </div>
                                                    </div>
                                                    <div id="shortLeave" style="display: none;">
                                                        <div class="form-group">
                                                            <div class=" col-sm-4">
                                                                <label>Leave Start Date & Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <!--<div class="input-group date "  id="shortLeaveStartDate"  data-date-format="dd/mm/yyyy - hh:ii " data-link-field="dtp_input1">-->
                                                            <%--<form:input path="leaveStartDateId" class="form-control" size="16" type="text" value="" onchange="leaveSetting(); daysCount();" readonly="true"></form:input>--%>
                                                            <input type="text" name="startDateShort" id="startDateShort" class="form-control" size="16" type="text" value="${startDateStr}" onchange="fillEnddate(this.value);"  readonly="true"/>
                                                            <!--<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>-->
                                                            <!--</div>-->
                                                        </div>


                                                        <div class=" col-sm-4">
                                                            <label>Leave End Date & Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <!--<div class="input-group date" id="shortLeaveEndDate"   data-date-format="dd/mm/yyyy - hh:ii " data-link-field="dtp_input1">-->
                                                            <%--<form:input id="leaveEndDateId" class="form-control" size="16" type="text" value="" onchange="leaveSetting(); daysCount();" readonly="true"></form:input>--%>
                                                            <input type="text"  name="endDateShort" id="endDateShort" class="form-control" size="16" type="text" value="${endDateStr}"  readonly="true"/>
                                                            <!--<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>-->
                                                            <!--</div>-->
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
                                            <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun3()"><i class="fa fa-plus" id="minusId3"></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">Reason For Leave:</label>
                                                    <div class="col-sm-7">
                                                        <form:textarea path="empRemark" class="form-control" rows="6" readonly="true"></form:textarea>
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
                                                <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun4()"><i class="fa fa-plus" id="minusId4"></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="table-responsive">
                                                        <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                            <tr>
                                                                <th>Leave</th>
                                                                <c:forEach var="remain" items="${listRemain}">
                                                                <th>${remain.key}</th>
                                                                </c:forEach>
                                                        </tr>
                                                        <tr>
                                                            <td>Leave Balance In Start Of The Year</td>
                                                            <c:forEach var="totalDays" items="${totalDaysMap}">

                                                                <td>${totalDays.value}</td>
                                                            </c:forEach>

                                                        </tr>
                                                        <tr>
                                                            <td>No. Of Leaves Applied During The Year</td>
                                                            <c:forEach var="empreq" items="${empReqMap}">
                                                                <td>${empreq.value}</td>
                                                            </c:forEach>

                                                        </tr>
                                                        <tr>
                                                            <td>Current Available Balance</td>
                                                            <c:forEach var="remain" items="${listRemain}">
                                                                <td id="${remain.key}1">${remain.value}</td>

                                                            </c:forEach>
                                                        </tr>
                                                        <tr>
                                                            <td>No. Of Leaves Applied In This Application</td>
                                                            <c:forEach var="remain" items="${listRemain}">
                                                                <c:choose>
                                                                    <c:when test="${(remain.key eq leaveType)}">
                                                                        <td id="${remain.key}">${leaveEmployeeDetail.noOfDays}</td>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                      <td id="${remain.key}">0</td>
                                                                    </c:otherwise>
                                                                  </c:choose>
                                                            </c:forEach>

                                                        </tr>
                                                        <tr>
                                                            <th>Projected Balance After This Application Approval</th>

                                                            <c:forEach var="remain" items="${listRemain}">
                                                                <c:choose>
                                                                    <c:when test="${(remain.key eq leaveType)}">
                                                                        <td id="${remain.key}2"><b>${remain.value - leaveEmployeeDetail.noOfDays}</b></td>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                            <th id="${remain.key}2"><b>${remain.value}</b></th>
                                                                    </c:otherwise>
                                                                  </c:choose>
                                                                </c:forEach>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                                <!--Leave Balance Shit In Detail completes Here-->
                                <c:if test="${(flag ne '4')}">
                                    <div class="form-group">

                                        <div class="col-sm-12" style="text-align: center">
                                            <button type="submit" name="btnSubmit" id="btnSubmit" class="btn btn-warning" data-original-title="" title="Withdraw" value="Withdraw">WITHDRAW</button>
                                        </div>
                                    </div>
                                </c:if>
                            </form:form>

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
                autoclose: 1,
                todayHighlight: 1,
                startView: 2,
                minView: 2,
                forceParse: 0,
                showMeridian: 1
        });    </script>
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
        });
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
