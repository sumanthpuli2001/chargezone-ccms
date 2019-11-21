<%--
    Document   : EmployeeRegistrationForm
    Created on : Oct 3, 2015, 10:16:00 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Employee Registration Form</title>
    </head>
    <style>
        #tabs{ margin: 20px -20px; border: none; }
        #tabs, #ui-datepicker-div, .ui-datepicker{ font-size: 85%; }
        .clear{ clear: both; }

        /*.example-container{ background-color: #f4f4f4; border-bottom: solid 2px #777777; margin: 0 0 20px 40px; padding: 20px; }*/
        /*.example-container input{ border: solid 1px #aaa; padding: 4px; width: 175px; }*/
    </style>

    <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">

    <script>
        $(document).ready(function () {
            window.onload = changetotalButton();
            window.onload = changetotalButtonNewCTC();
        });

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
        function buttonFun9() {
            var className = $('#minusId9').attr('class');
            if (className == 'fa fa-plus') {
                document.getElementById('spanId9').innerHTML = 'Minimize';
            } else {
                document.getElementById('spanId9').innerHTML = 'Expand';
            }
        }

        function buttonFun10() {
            var className = $('#minusId10').attr('class');
            if (className == 'fa fa-plus') {
                document.getElementById('spanId10').innerHTML = 'Minimize';
            } else {
                document.getElementById('spanId10').innerHTML = 'Expand';
            }
        }

    </script>
    <script>
        var i1 = 1;
        $(function () {
            $("#step1cloneid").on("click", function () {
                i1 = document.getElementById("firstStepCount").value;
                i1++;
                if (i1 <= 8) {
                    var clone = "<tr id='cloneTr_Id" + i1 + "'>"
                            + "<td style=\"text-align: center\">" + i1 + "</td>"
                            + "<td><input type=\"file\" class=\"form-control\" accept='image/jpg,image/jpeg,image/png' id='certificateId" + i1 + "' name='certificateId" + i1 + "' onchange='checkCertificateFileSize(" + i1 + ")'/></td>"
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
    </script>
    <script>

        $(function () {
//            options show on worktype basis hourly or shift
            $("#shiftType").on("change", function () {
                var selectedValue = this.value;
                if (selectedValue == "HourlyBase") {
                    $('#hourlyBaseTitleDiv').show();
                    $('#shiftNameDiv').hide();
                    $('#shiftRotationNameDiv').hide();
                    $('#shiftRotationDateDiv').hide();
                    $('#shiftId').val("");
                    $('#shiftRotationDate').val("");
                    $('#shiftMasterId').val("");
                    //blanks another values on changes
                } else if (selectedValue == "ShiftBase") {
                    $('#shiftNameDiv').show();
                    $('#shiftRotationNameDiv').show();
                    $('#shiftRotationDateDiv').show();
                    $('#hourlyBaseTitleDiv').hide();
                    $('#shiftHoursId').val("");
                    //blanks another values on changes
                } else {
                    $('#hourlyBaseTitleDiv').hide();
                    $('#shiftNameDiv').hide();
                    $('#shiftRotationNameDiv').hide();
                    $('#shiftRotationDateDiv').hide();
                    $('#shiftId').val("");
                    $('#shiftRotationDate').val("");
                    $('#shiftMasterId').val("");
                    $('#shiftHoursId').val("");
                    //blanks all values on changes as not selected yet.
                }
            });
//            spous name show for married selected
            $('input:radio[name="group2"]').change(function () {
                if ($(this).is(':checked') && $(this).val() == 'married') {
                    $('#spousNameDiv').show();
                } else {
                    $('#spousNameDiv').hide();
                }
            });
        });</script>

   
    
        <script>
        var flag3 = true;
        function saveSubmit11() {
//            alert("vxcvxcvjk");
            if (flag3) {
                var radioValue = $("input[name='nameStatus']:checked").val();
                    if(radioValue == "false"){
//                       alert("passportttttt");
                        if (document.getElementById("passportNo").value == ""){
                            document.getElementById('passportNoError').innerHTML = '-It must not be empty.';
                            document.getElementById('errormsg').innerHTML = '-Enter all the details of Passport Fields.';
                            $("#errormsg").delay(0).fadeIn(0);
                            $("#errormsg").delay(3200).fadeOut(300);
                            $("#passportNoError").delay(0).fadeIn(0);
                            $("#passportNoError").delay(3200).fadeOut(300);
                            return false;
                        }
                        else if (document.getElementById("countryOfIssue").value == ""){
                            document.getElementById('countryOfIssueError').innerHTML = '-It must not be empty.';
                            document.getElementById('errormsg').innerHTML = '-Enter all the details of Passport Fields.';
                            $("#errormsg").delay(0).fadeIn(0);
                            $("#errormsg").delay(3200).fadeOut(300);
                            $("#countryOfIssueError").delay(0).fadeIn(0);
                            $("#countryOfIssueError").delay(3200).fadeOut(300);
                             return false;
                        }
                        else if (document.getElementById("firstName").value == ""){
                            document.getElementById('firstNameError').innerHTML = '-It must not be empty.';
                            document.getElementById('errormsg').innerHTML = '-Enter all the details of Passport Fields.';
                            $("#errormsg").delay(0).fadeIn(0);
                            $("#errormsg").delay(3200).fadeOut(300);
                            $("#firstNameError").delay(0).fadeIn(0);
                            $("#firstNameError").delay(3200).fadeOut(300);
                             return false;
                        }
                        else if (document.getElementById("middleName").value == ""){
                            document.getElementById('middleNameError').innerHTML = '-It must not be empty.';
                            document.getElementById('errormsg').innerHTML = '-Enter all the details of Passport Fields.';
                            $("#errormsg").delay(0).fadeIn(0);
                             $("#errormsg").delay(3200).fadeOut(300);
                             $("#middleNameError").delay(0).fadeIn(0);
                            $("#middleNameError").delay(3200).fadeOut(300);
                             return false;
                        }
                        else if (document.getElementById("lastName").value == ""){
                            document.getElementById('lastNameError').innerHTML = '-It must not be empty.';
                            document.getElementById('errormsg').innerHTML = '-Enter all the details of Passport Fields.';
                            $("#errormsg").delay(0).fadeIn(0);
                             $("#errormsg").delay(3200).fadeOut(300);
                             $("#lastNameError").delay(0).fadeIn(0);
                            $("#lastNameError").delay(3200).fadeOut(300);
                             return false;
                        }
                        else if (document.getElementById("passportIssueDate").value == ""){
                            document.getElementById('passportIssueDateError').innerHTML = '-It must not be empty.';
                            document.getElementById('errormsg').innerHTML = '-Enter all the details of Passport Fields.';
                            $("#errormsg").delay(0).fadeIn(0);
                             $("#errormsg").delay(3200).fadeOut(300);
                             $("#passportIssueDateError").delay(0).fadeIn(0);
                            $("#passportIssueDateError").delay(3200).fadeOut(300);
                            
                             return false;
                        }
                        else if (document.getElementById("passportExpiryDate").value == ""){
                            document.getElementById('passportExpiryDateError').innerHTML = '-It must not be empty.';
                            document.getElementById('errormsg').innerHTML = '-Enter all the details of Passport Fields.';
                            $("#errormsg").delay(0).fadeIn(0);
                             $("#errormsg").delay(3200).fadeOut(300);
                             $("#passportExpiryDateError").delay(0).fadeIn(0);
                            $("#passportExpiryDateError").delay(3200).fadeOut(300);
                             return false;
                        }

                    }
                    else if(radioValue == "true"){
//                       alert("aadhar");
                       if (document.getElementById("adharCard").value == ""){
                            document.getElementById('adharCardError').innerHTML = '-It must not be empty.';
                            document.getElementById('errormsg').innerHTML = '-Enter Aadhar Card details.';
                            $("#errormsg").delay(0).fadeIn(0);
                             $("#errormsg").delay(3200).fadeOut(300);
                             $("#adharCardError").delay(0).fadeIn(0);
                            $("#adharCardError").delay(3200).fadeOut(300);
                            return false;
                        }else if (document.getElementById("firstName").value == ""){
                            document.getElementById('firstNameError').innerHTML = '-It must not be empty.';
                            document.getElementById('errormsg').innerHTML = '-Enter all the details of First, Middle & Last Name as per Aadhar Card Fields.';
                             $("#errormsg").delay(0).fadeIn(0);
                             $("#errormsg").delay(3200).fadeOut(300);
                             $("#firstNameError").delay(0).fadeIn(0);
                            $("#firstNameError").delay(3200).fadeOut(300);
                            return false;
                        }
                        else if (document.getElementById("middleName").value == ""){
                            document.getElementById('middleNameError').innerHTML = '-It must not be empty.';
                            document.getElementById('errormsg').innerHTML = '-Enter all the details of First, Middle & Last Name as per Aadhar Card Fields.';
                             $("#errormsg").delay(0).fadeIn(0);
                             $("#errormsg").delay(3200).fadeOut(300);
                             $("#middleNameError").delay(0).fadeIn(0);
                            $("#middleNameError").delay(3200).fadeOut(300);
                            return false;
                        }
                        else if (document.getElementById("lastName").value == ""){
                            document.getElementById('lastNameError').innerHTML = '-It must not be empty.';
                            document.getElementById('errormsg').innerHTML = '-Enter all the details of First, Middle & Last Name as per Aadhar Card Fields.';
                             $("#errormsg").delay(0).fadeIn(0);
                            $("#errormsg").delay(3200).fadeOut(300);
                            $("#lastNameError").delay(0).fadeIn(0);
                             $("#lastNameError").delay(3200).fadeOut(300);
                            return false;
                        }
                    } 
            }
        }

    </script>
    
    <script>
        $(document).ready(function () {
            userName1();
        });
        function userName1() {
            var abc = document.getElementById("employeeId").value;
            document.getElementById("userName").value = abc;
            //alert("Username is"+abc);
        }
//        function showTxt(info) {
//            alert("Dhaval");
////            if (info === "Married") {
////                $("#hideInfo1").show(500);
////                $("#hideInfo2").show(500);
////            } else {
////                $("#hideInfo1").hide(500);
////                $("#hideInfo2").hide(500);
////            }
////             if (info === "Other") {
////                $("#otherMaritalStatusId").hide(500);
////                $("#hideInfo1").hide(500);
////                $("#hideInfo2").hide(500);
////            }
//        }
    </script>
    <script>
        /*function changetotalButton() {
//            alert("hii");
            var total = 0;
            var Ctctotal = 0;
            var element = document.getElementById('amount1').value;
//            var conyance = parseInt(document.getElementById("conveysAmount").value);
            var basicSalary = parseInt(document.getElementById("basicSalary").value);
            if (parseInt(element) > 0) {
                total = total + parseInt(element);
            }
//            if (parseInt(conyance) > 0) {
//                total = total + parseInt(conyance);
//            }
            if (parseInt(basicSalary) > 0) {
                total = total + parseInt(basicSalary);

            }
            document.getElementById("txtresult").value = total;
            document.getElementById("txtresultCTC").value = total;


//            var conyance = document.getElementById("leaveStartDate_SelectFullOrHalfId").value;
        }*/
     function changetotalButton() {
//            alert("hii");
            var total = 0;
            var sum = 0;
            var sum1 = 0;
            var element1 = 0;

//            var element = document.getElementById('amount1').value;
            var element15 = document.getElementById('policyCount').value;
            for (var i = 1; i <= element15; i++) {
//                alert('hi' + document.getElementById('amount' + i).value);
                var elementCheck = document.getElementById('amount' + i);
                if (elementCheck)
                {
                    var element = document.getElementById('amount' + i).value;
//                 alert(element)
                    sum += parseInt(element);
                }
            }

            var element16 = document.getElementById('ctcCount').value;
            for (var i = 1; i <= element16; i++) {
                var element12 = document.getElementById('ctcamount' + i).value;
                sum1 += parseInt(element12);
            }
//            var conyance = parseInt(document.getElementById("conveysAmount").value);
            var basicSalary = parseInt(document.getElementById("basicSalary").value);

            if (parseInt(sum) > 0) {
                total = total + parseInt(sum);
            }
//            if (parseInt(conyance) > 0) {
//                total = total + parseInt(conyance);
//            }
            if (parseInt(basicSalary) > 0) {
                total = total + parseInt(basicSalary);

            }
            document.getElementById("txtresult").value = total;
            element1 = document.getElementById('txtresultCTC').value;
            sum = parseInt(sum) + parseInt(sum1) + basicSalary;

            document.getElementById("txtresultCTC").value = sum;

//            var conyance = document.getElementById("leaveStartDate_SelectFullOrHalfId").value;
        }
        /*function totalValueChange(ele, oldvalue) {

            var element = document.getElementById('txtresult').value;
            var element1 = document.getElementById('txtresultCTC').value;
            document.getElementById('txtresult').value = '';
            document.getElementById('txtresult').value = parseInt(ele.value) + parseInt(element) - oldvalue;
            document.getElementById('txtresultCTC').value = '';
            document.getElementById('txtresultCTC').value = parseInt(ele.value) + parseInt(element1) - oldvalue;
//            var conyance = document.getElementById("leaveStartDate_SelectFullOrHalfId").value;
        }*/
    
        function totalValueChange(ele, oldvalue) {
//      alert("hi");
            alert("ele: " + parseInt(ele.value));
            //alert("oldvalue: "+document.getElementById(oldvalue).value);

            var oldvalueNum = document.getElementById(oldvalue).value;

            var element = document.getElementById('txtresult').value;
            var element1 = document.getElementById('txtresultCTC').value;

            //alert("element: "+parseInt(element));
            //alert("oldvalnum: "+oldvalueNum);

            alert('-------: ' + (parseInt(ele.value) + parseInt(element) - parseInt(oldvalueNum)));
            document.getElementById('txtresult').value = '';
            document.getElementById('txtresult').value = parseInt(ele.value) + parseInt(element) - oldvalueNum;
            document.getElementById('txtresultCTC').value = '';
            document.getElementById('txtresultCTC').value = parseInt(ele.value) + parseInt(element1) - oldvalueNum;
//            var conyance = document.getElementById("leaveStartDate_SelectFullOrHalfId").value;
        }
//        function totalValueChange1(ele) {
//            alert(parseInt(ele.value));
//            var element = document.getElementById('txtresult').value;
//            alert(parseInt(element);
//                    document.getElementById('txtresult').value = '';
//            document.getElementById('txtresult').value = parseInt(element) - parseInt(ele.value);
////            var conyance = document.getElementById("leaveStartDate_SelectFullOrHalfId").value;
//        }
    </script>
    <script>
       function changetotalButtonCTC() {
            var total = 0;


            var element = document.getElementById('ctcamount1').value;



//            var conyance = parseInt(document.getElementById("conveysAmount").value);
            var basicSalary = parseInt(document.getElementById("txtresult").value);
            if (parseInt(element) > 0) {
                total = total + parseInt(element);
            }
//            if (parseInt(conyance) > 0) {
//                total = total + parseInt(conyance);
//            }
            if (parseInt(basicSalary) > 0) {
                total = total + parseInt(basicSalary);

            }
            document.getElementById("txtresultCTC").value = total;


//            var conyance = document.getElementById("leaveStartDate_SelectFullOrHalfId").value;
        }
          function totalValueChangeCTC(ele, oldvalue) {

            var element = document.getElementById('txtresultCTC').value;
            document.getElementById('txtresultCTC').value = '';
            document.getElementById('txtresultCTC').value = parseInt(ele.value) + parseInt(element) - oldvalue;
//            var conyance = document.getElementById("leaveStartDate_SelectFullOrHalfId").value;
        }
//        function totalValueChange1(ele) {
//            alert(parseInt(ele.value));
//            var element = document.getElementById('txtresult').value;
//            alert(parseInt(element);
//                    document.getElementById('txtresult').value = '';
//            document.getElementById('txtresult').value = parseInt(element) - parseInt(ele.value);
////            var conyance = document.getElementById("leaveStartDate_SelectFullOrHalfId").value;
//        }
    </script>
    <script>
        function selectShift(rotationId) {
//            alert('Call Ajax');
            var shiftMasterId = document.getElementById("shiftName").value;
            document.getElementById('shiftMasterId').innerHTML = "Fetching ... .. .";
            $.post("shiftRotationMaster.htm?act=readRotationAjax",
                    {
                        rotationId: rotationId, shiftMasterId: shiftMasterId
                    }, function (responseTxt, statusTxt, xhr) {
                if (statusTxt === "success") {
                    document.getElementById('shiftMasterId').innerHTML = responseTxt;
                }
                if (statusTxt === "error")
                    alert("Error: " + xhr.status + ": " + xhr.statusText);
            });
        }

        function checkFileSize() {
            if (typeof FileReader !== "undefined") {
                var fileSize = document.getElementById('photograph').files[0].size;
//                alert("my File size is   " + fileSize);
                if (fileSize > 1048576) {
                    document.getElementById('photograph').value = '';
                    document.getElementById('photographError').innerHTML = "- It must not be more than 1 MB";
                } else {
                    document.getElementById('photographError').innerHTML = '';
                }
                // check file size
            }


        }
        function checkCertificateFileSize(id) {
            if (typeof FileReader !== "undefined") {
                var fileSize = document.getElementById('certificateId' + id).files[0].size;
//                alert("my File size is   " + fileSize);
                if (fileSize > 1048576) {
                    document.getElementById('certificateId' + id).value = '';
                    document.getElementById('certificateError').innerHTML = "- It must not more than 1mb";
                } else {
                    document.getElementById('certificateError').innerHTML = '';
                }
                // check file size
            }


        }
        jQuery(document).ready(function () {
            //getDesignation();
            var rotationId = document.getElementById("shiftId").value;
            selectShift(rotationId)
        });
        function getDesignation() {
            var levelMasterId = document.getElementById('levelMaster.id').value;
//            alert("levelmaster id    " + levelMasterId);
            if (levelMasterId != "") {
                $.get("employeeMaster.htm?act=getDesignationByLevel",
                        {
                            levelMasterId: levelMasterId
                        },
                        function (responseJson) {
////                    $(".result").html(data);
//                    alert("response     " + responseJson);
//                    var tempjson = JSON.parse(responseJson);
//                    alert("jsosnsnssnsn    "+tempjson[0]);
                            var $select = $('#designationMasterByLevelId'); // Locate HTML DOM element with ID "someselect".
//                    alert("this is my select    " + select);
                            $select.find("option").remove(); // Find all child elements with tag name "option" and remove them (just to prevent duplicate options when button is pressed again).
                            $.each(responseJson, function (key, value) {               // Iterate over the JSON object.
//                        alert(key + '     ' + value);

                                $('#designationMasterByLevelId')
                                        .append($("<option></option>")
                                                .attr("value", key)
                                                .text(value));

//                        var opt = document.createElement('option');
//                        opt.value = key;
//                        opt.innerHTML = value;
//                        select.appendChild(opt);
////                        $("<option>").val(key).text(value).appendTo($select);

//                        alert("Load was performed.");
                            });
                            setDesignation();
                        });
////                alert("response     " + responseJson);
//            }
            }


        }
    </script>
    <script>
        function selectsubtype(typeId) {

            var empSubTypeId = document.getElementById("subTypeId").value;
//            document.getElementById('EmployeeId').innerHTML = "Fetching ... .. .";
            $.post("employeeMaster.htm?act=readEmpTypeAjax",
                    {
                        typeId: typeId,
                        empSubTypeId: empSubTypeId
                    }, function (responseTxt, statusTxt, xhr) {
                if (statusTxt === "success") {
                    ("responseTxt" + responseTxt);
//                    alert(responseTxt);
                    document.getElementById('employeeSubTypeId').innerHTML = responseTxt;
                }
                if (statusTxt === "error")
//                    alert(";;"+statusTxt);
                    ("Error: " + xhr.status + ": " + xhr.statusText);
            });
        }

        $(document).ready(function () {
            var empTypeId = document.getElementById("employeeTypeMaster.id").value;
            selectsubtype(empTypeId);
        });
    </script>
    <script>
        //var tempCount4 = 1;
        $(function () {
            /*
            $("#ctcCloneid").on("click", function () {
                tempCount4++;
                //                alert(tempCount3);
                var clone = "<tr id='addmoreFile1" + tempCount4 + "' style='clear:both;'>"
                        + "<td style=\"text-align: center\">" + tempCount4 + "</td>"
                        + "<td id=\"ctcTd" + tempCount4 + "\"><div><select id='ctcId" + tempCount4 + "' name='ctcId" + tempCount4 + "' class=\"form-control\">"
                        + "</select>"
                        + "</div><span id=\"ctcError" + tempCount4 + "\" style=\"color: red;\"></span></td>"
                        //                        + "<td style=\"text-align: center\"><input type=\"text\" name='policyNumber" + tempCount3 + "' id='policyNumber" + tempCount3 + "'  class=\"form-control\"></td>"
                        + "<td style=\"text-align: center\"><input type=\"number\" name='ctcamount" + tempCount4 + "' id='ctcamount" + tempCount4 + "'   onFocus=\"(this.id=this.value)\" onchange=\"totalValueChangeCTC(this,this.id);\" min=\"0\" value=\"0\" class=\"form-control\"></td>"
                        + "<td style=\"text-align: center\"><input type=\"checkbox\" name='ctctaxable" + tempCount4 + "' id='ctctaxable" + tempCount4 + "'</td>"
                        + "<td id=\"monthTd" + tempCount4 + "\"><div><select id='month" + tempCount4 + "' name='month" + tempCount4 + "' class=\"form-control\">"
                        + "<option value=\"\">--SELECT--</option>"
                        + "<option value=\"01\">January</option>"
                        + "<option value=\"02\">February</option>"
                        + "<option value=\"03\">March</option>"
                        + "<option value=\"04\">April</option>"
                        + "<option value=\"05\">May</option>"
                        + "<option value=\"06\">June</option>"
                        + "<option value=\"07\">July</option>"
                        + "<option value=\"08\">August</option>"
                        + "<option value=\"09\">September</option>"
                        + "<option value=\"10\">October</option>"
                        + "<option value=\"11\">November</option>"
                        + "<option value=\"12\">December</option></select>"
                        + "</div></td>"
                        + "<td id=\"monthTd" + tempCount4 + "\"><div><select id='year" + tempCount4 + "' name='year" + tempCount4 + "' class=\"form-control\">"
                        + "</div></td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\"value=\"-\"  onclick=\"removectc('addmoreFile1" + tempCount4 + "');\"/>"
                        + "</span>"
                        + "</td>"
                        + "</tr>";
                $("#ctcTable").append(clone);
                document.getElementById('ctcCount').value = tempCount4;
                //                var expenseType = document.getElementById('expenseType').value;
                addActc(tempCount4);
                window.onload = init;
                function init() {
                    document.form1.month.options[new Date().getMonth()].selected = true;
                }
                var start = new Date().getFullYear();
                var end = 2050;
                var options11 = "";
//        var objSelect = document.getElementById("yearBase").value;
                for (var year1 = start; year1 <= end; year1++) {
                    options11 += "<option>" + year1 + "</option>";
                }
//                alert(tempCount4);
                document.getElementById('year2').innerHTML = options11;
                document.getElementById('year3').innerHTML = options11;
                document.getElementById('year4').innerHTML = options11;
                document.getElementById('year5').innerHTML = options11;
                document.getElementById('year6').innerHTML = options11;
                document.getElementById('year7').innerHTML = options11;
                
            });*/
        
        var tempCount4 = document.getElementById('ctcCount').value;
            var tempCountArray4 = [tempCount4];
            //console.log("test tempcount"+tempCount4);
            $("#ctcCloneid").on("click", function () {
                //console.log("test tempcount"+tempCount4);
                tempCount4++;
                // alert("ctcCount: "+document.getElementById('ctcCount').value);
                var ansArraybool4 = tempCountArray4.includes(tempCount4);
                //var ansArraybool = tempCountArray.includes(2);
                while (ansArraybool4)
                {
                    //console.log("CAUTION!!!");
                    tempCount4++;
                    ansArraybool4 = tempCountArray4.includes(tempCount4);
                }
                tempCountArray4.push(tempCount4);
                //console.log("tempCountArray4"+tempCount4);
                // tempCountArray4.forEach(myFunction4);

                var clone = "<tr id='addmoreFile1" + tempCount4 + "' style='clear:both;'>"
                        + "<td style=\"text-align: center\">" + tempCount4 + "</td>"
                        + "<td id=\"ctcTd" + tempCount4 + "\"><div><select id='ctcId" + tempCount4 + "' name='ctcId" + tempCount4 + "' class=\"form-control\">"
                        + "</select>"
                        + "</div><span id=\"ctcError" + tempCount4 + "\" style=\"color: red;\"></span></td>"
                        //  onFocus=\"(this.id=this.value)\"                      + "<td style=\"text-align: center\"><input type=\"text\" name='policyNumber" + tempCount3 + "' id='policyNumber" + tempCount3 + "'  class=\"form-control\"></td>"
//  // changetotalButtonNewCTC       + "<td style=\"text-align: center\"><input type=\"number\" name='ctcamount" + tempCount4 + "' id='ctcamount" + tempCount4 + "'  value=\"0\"  onchange=\"totalValueChangeCTC(this,this.id);\" min=\"0\" class=\"form-control\"></td>"
                        + "<td style=\"text-align: center\"><input type=\"number\" name='ctcamount" + tempCount4 + "' id='ctcamount" + tempCount4 + "'  value=\"0\" onchange=\"changetotalButtonNewCTC(this);\" min=\"0\" class=\"form-control\"></td>"
                        + "<td style=\"text-align: center\"><input type=\"checkbox\" name='taxablectc" + tempCount4 + "' id='taxablectc" + tempCount4 + "' value=\"off\" ></td>"
                        + "<td id=\"monthTd" + tempCount4 + "\"><div><select id='month" + tempCount4 + "' name='month" + tempCount4 + "' class=\"form-control\">"
                        + "<option value=\"\">--SELECT--</option>"
                        + "<option value=\"01\">January</option>"
                        + "<option value=\"02\">February</option>"
                        + "<option value=\"03\">March</option>"
                        + "<option value=\"04\">April</option>"
                        + "<option value=\"05\">May</option>"
                        + "<option value=\"06\">June</option>"
                        + "<option value=\"07\">July</option>"
                        + "<option value=\"08\">August</option>"
                        + "<option value=\"09\">September</option>"
                        + "<option value=\"10\">October</option>"
                        + "<option value=\"11\">November</option>"
                        + "<option value=\"12\">December</option></select>"
                        + "</div></td>"
                        + "<td id=\"monthTd" + tempCount4 + "\"><div><select id='year" + tempCount4 + "' name='year" + tempCount4 + "' class=\"form-control\">"
                        + "</div></td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\"value=\"-\"  onclick=\"removectc('" + tempCount4 + "');\"/>"
                        + "</span>"
                        + "</td>"
                        + "</tr>";
                $("#ctcTable").append(clone);
                document.getElementById('ctcCount').value = tempCount4;
                //                var expenseType = document.getElementById('expenseType').value;
                addActc(tempCount4);
                window.onload = init;
                function init() {
                    document.form1.month.options[new Date().getMonth()].selected = true;
                }
                var start = new Date().getFullYear();
                var end = start + 50;
                var options11 = "";
                for (var yearloop = start; yearloop <= end; yearloop++) {
                    options11 += "<option>" + yearloop + "</option>";
                }
                //                alert(tempCount4);
                document.getElementById('year' + tempCount4).innerHTML = options11;
                //document.getElementById('year1').innerHTML = options11;
               });
        });

        function addActc(id) {
            //                alert(id);
            var element2 = document.getElementById('ctcId1');
            var obj2 = document.getElementById("ctcId" + id);
            for (var i22 = 0; i22 < element2.options.length; i22++) {
                var opt22 = document.createElement("option");
                opt22.value = element2.options[i22].value;
                opt22.text = element2.options[i22].text;
                obj2.appendChild(opt22);
            }
        }


       function removedefaultctc(id) {

            //------------- ---------------------
            var ele = document.getElementsByName("ctcamount" + id)[0].value;//document.getElementById("ctcamount" + val).value;

            var ele2 = document.getElementById('txtresultCTC').value;

            document.getElementById('txtresultCTC').value = '';
            document.getElementById('txtresultCTC').value = parseInt(ele2) - parseInt(ele);

            document.getElementsByName("ctcamount" + id)[0].value = 0;
            //--------------------------------------------
            var element1 = document.getElementById("removectcDefault" + id);
            element1.parentNode.removeChild(element1);
            //console.log("- button clicked"+id);
        }
        
        function changeAmountButtonNewCTC(id) {

            document.getElementById("year" + id).value = total;
        }
        
        function changetotalButtonNewCTC(id) {
            //      alert('hi');
            var sum = 0;
            var total = 0;
            var element15 = document.getElementById('ctcCount').value;
            for (var i = 1; i <= element15; i++) {
//                alert('hi' + document.getElementById('amount' + i).value);
                var elementCheck = document.getElementById('ctcamount' + i);
                if (elementCheck)
                {
                    var element = document.getElementById('ctcamount' + i).value;
                    sum += parseInt(element);
                }
            }
//            var conyance = parseInt(document.getElementById("conveysAmount").value);
            var basicSalary = parseInt(document.getElementById("txtresult").value);
            if (parseInt(sum) > 0) {
                total = total + parseInt(sum);
            }
//            if (parseInt(conyance) > 0) {
//                total = total + parseInt(conyance);
//            }
            if (parseInt(basicSalary) > 0) {
                total = total + parseInt(basicSalary);

            }
            document.getElementById("txtresultCTC").value = total;
            document.getElementsByName("ctcTotal").value = total;
//            var conyance = document.getElementById("leaveStartDate_SelectFullOrHalfId").value;
        }
        function removectc(policyDiv) {
            try {
                var str = policyDiv;
                var array = str.replace("addmoreFile1", "");
                var element = document.getElementsByName("ctcamount" + policyDiv)[0].value;//document.getElementById("ctcamount" + val).value;

                //  console.log("Amount removectc"+parseInt(element));
                //tempCount4--; these will cause problem
                var element2 = document.getElementById('txtresultCTC').value;
                // console.log("element 2 value*****:"+parseInt(element2));

                document.getElementById('txtresultCTC').value = '';
                document.getElementById('txtresultCTC').value = parseInt(element2) - parseInt(element);

                //console.log("element 1 value*****:");
                //--------------------------------------------
                //After amount minus we can make it zero to avoid in total sum
                document.getElementsByName("ctcamount" + policyDiv)[0].value = 0;
                //--------------------------------------------
                //document.getElementById("ctcCount").value = val;
                //console.log("element 1 value*****:");
                var element1 = document.getElementById("addmoreFile1" + policyDiv);

                //  console.log("element 1 value*****:"+parseInt(element1));

                element1.parentNode.removeChild(element1);

                
            } catch (e) {

            }
        }

    </script>
    <script>
        //var tempCount3 = 1;
        $(function () {
           /* $("#policyCloneid").on("click", function () {
                tempCount3++;
                //                alert(tempCount3);
                var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"
                        + "<td style=\"text-align: center\">" + tempCount3 + "</td>"
                        + "<td id=\"policyTd" + tempCount3 + "\"><div><select id='policyId" + tempCount3 + "' name='policyId" + tempCount3 + "' class=\"form-control\">"
                        + "</select>"
                        + "</div><span id=\"policyError" + tempCount3 + "\" style=\"color: red;\"></span></td>"
//                        + "<td style=\"text-align: center\"><input type=\"text\" name='policyNumber" + tempCount3 + "' id='policyNumber" + tempCount3 + "'  class=\"form-control\"></td>"
                        + "<td style=\"text-align: center\"><input type=\"number\" name='amount" + tempCount3 + "' id='amount" + tempCount3 + "' onFocus=\"(this.id=this.value)\" onchange=\"totalValueChange(this,this.id);\" min=\"0\" value=\"0\" class=\"form-control\"></td>"
                        + "<td style=\"text-align: center\"><input type=\"checkbox\" name='taxable" + tempCount3 + "' id='taxable" + tempCount3 + "'</td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\"value=\"-\"  onclick=\"removePolicy('addmoreFile" + tempCount3 + "');\"/>"
                        + "</span>"
                        + "</td>"
                        + "</tr>";
                $("#policyTable").append(clone);
                document.getElementById('policyCount').value = tempCount3;
//                var expenseType = document.getElementById('expenseType').value;
                addAPolicy(tempCount3);

            });*/
        
        
            tempCount3 = document.getElementById('policyCount').value;
            var tempCountArray3 = [tempCount3];
            $("#policyCloneid").on("click", function () {
                // alert(tempCount3);
                tempCount3++;
                var ansArraybool3 = tempCountArray3.includes(tempCount3);
                //var ansArraybool = tempCountArray.includes(2);
                while (ansArraybool3)
                {
                    tempCount3++;
                    ansArraybool3 = tempCountArray3.includes(tempCount3);
                }
                tempCountArray3.push(tempCount3);
                //console.log("Temp Count: "+tempCount3);
                //tempCountArray4.forEach(myFunction4);

                var clone = "<tr id='" + tempCount3 + "' style='clear:both;'>"
                        + "<td style=\"text-align: center\">" + tempCount3 + "</td>"
                        + "<td><div><select id=\"policyId" + tempCount3 + "\" name='policyId" + tempCount3 + "' class=\"form-control\">"
                        + "<option value =\"\"> --SELECT-- </option>"
                        + "</select>"
                        + "</div><span id=\"policyError" + tempCount3 + "\" style=\"color: red;\"></span></td>"
//                        + "<td style=\"text-align: center\"><input type=\"text\" name='policyNumber" + tempCount3 + "' id='policyNumber" + tempCount3 + "'  class=\"form-control\"></td>"
                        + "<td style=\"text-align: center\"><input type=\"number\" name='amount" + tempCount3 + "' id='amount" + tempCount3 + "' onchange=\"changetotalButtonNew(this);\" min=\"0\" value=\"0\" class=\"form-control\"></td>"
//                        + "<td style=\"text-align: center\"><input type=\"number\" name='amount" + tempCount3 + "' id='amount" + tempCount3 + "' onFocus=\"(this.id=this.value)\" onchange=\"changetotalButtonNew()\" min=\"0\" class=\"form-control\"></td>"
                        + "<td style=\"text-align: center\"><input type=\"checkbox\" name='taxable" + tempCount3 + "' id='taxable" + tempCount3 + "' value=\"off\" ></td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\"value=\"-\"  onclick=\"removePolicy('" + tempCount3 + "');\"/>"
                        + "</span>"
                        + "</td>"
                        + "</tr>";
                $("#policyTable").append(clone);
                document.getElementById('policyCount').value = tempCount3;
                addAPolicy(tempCount3);
                /*var elementCheck2 = document.getElementById('amount' + tempCount3);
                 if(elementCheck2)
                 {
                 console.log("Id Found"+document.getElementById('amount' + tempCount3).value);
                 }
                 else
                 {
                 console.log("Id NOT Found");
                 }
                 console.log("txt result ctc; "+document.getElementById("txtresultCTC").value);
                 */
                changetotalButtonNew();
//                alert(tempCount3);
            });
        });

        function addAPolicy(id) {
            var element2 = document.getElementById('policyId1');
            //console.log("element2.options.length: "+element2.options.length);
            var obj2 = document.getElementById("policyId" + id);
            for (var i2 = 0; i2 < element2.options.length; i2++) {
                var opt2 = document.createElement("option");
                opt2.value = element2.options[i2].value;
                opt2.text = element2.options[i2].text;
                obj2.appendChild(opt2);
            }
        }
        
        
        //change profile picture.
        function changeButton() {
            var className = document.getElementById("photographUpdate").value;
            var employeeId = document.getElementById("userName").value;
            if(employeeId == "")
            {
                alert("Fill Employee No First");
            }
            else if (className != null || className != '') {
//                document.getElementById('imageSrc').innerHTML = "<button naem='updateImg' class='btn btn-primary' onclick='updatePP();'> update</botton>";
                if (typeof FileReader !== "undefined") {
                    var fileSize = document.getElementById('photographUpdate').files[0].size;
//                alert("my File size is   " + fileSize);
                    if (fileSize > 102400) {
                        document.getElementById('photographUpdate').value = '';
                        document.getElementById('photographError').innerHTML = "- It must not more than 100kb";
                    } else {
                        document.getElementById('photographError').innerHTML = '';
                        var photographUpdate = document.getElementById("photographUpdate").files[0];
                        var userName = '${param.userid}';
                        var fd = new FormData();
                        //fd.append('userName', '${param.userid}');
                        fd.append('userName', employeeId);
                        //alert("username"+employeeId)
                        fd.append('photographUpdate', photographUpdate);
                        $.ajax({
                            url: 'employeeMaster.htm?act=displayPictureCreateForm',
                            data: fd,
                            processData: false,
                            contentType: false,
                            type: 'POST',
                            success: function (result) {
                                $("#photograph").attr("src", result);
                            }
                        });
                    }
                    // check file size
                }

            }
            else
            {
                alert("else");
            }
        }

        
        
        function changetotalButtonNew(id) {
            //alert('hi');
            var sum = 0;
            var sum1 = 0;
            var total = 0;
            var element15 = document.getElementById('policyCount').value;
            //console.log("Policy Count value: "+element15);
            for (var i = 1; i <= element15; i++) {
//                alert('hi' + document.getElementById('amount' + i).value);
                var elementCheck = document.getElementById('amount' + i);
                if (elementCheck)
                {
                    var element = document.getElementById('amount' + i).value;
                    sum += parseInt(element);
                }
                else
                {
                    // console.log("Index not found: "+i);
                }
//                alert(sum);
            }

            var element16 = document.getElementById('ctcCount').value;
            for (var i = 1; i <= element16; i++) {
//                alert('hi' + document.getElementById('amount' + i).value);
                var element12 = document.getElementById('ctcamount' + i).value;
                sum1 += parseInt(element12);
            }
//            alert(sum);

//            var conyance = parseInt(document.getElementById("conveysAmount").value);
            var basicSalary = parseInt(document.getElementById("basicSalary").value);
            if (parseInt(sum) > 0) {
                total = total + parseInt(sum);
            }
//            if (parseInt(conyance) > 0) {
//                total = total + parseInt(conyance);
//            }
            if (parseInt(basicSalary) > 0) {
                total = total + parseInt(basicSalary);

            }
            document.getElementById("txtresult").value = total;
            document.getElementById("txtresultCTC").value = total + sum1;

            //console.log("sum is: "+sum);

//            var conyance = document.getElementById("leaveStartDate_SelectFullOrHalfId").value;
        }
        
        
        function removePolicy(policyDiv) {
            try {
                //--------------------------------------
                var str = policyDiv;
                var array = str.replace("addmoreFile7", "");
                var element = document.getElementsByName("amount" + policyDiv)[0].value;

                tempCount3--;
                // console.log("element value:"+parseInt(element));

                var element2 = document.getElementById('txtresult').value;
                document.getElementById('txtresult').value = '';
                document.getElementById('txtresult').value = parseInt(element2) - parseInt(element);
                var element21 = document.getElementById('txtresultCTC').value;
                document.getElementById('txtresultCTC').value = '';
                document.getElementById('txtresultCTC').value = parseInt(element21) - parseInt(element);

                //--------------------------------------------
                //After amount minus we can make it zero to avoid in total sum
                document.getElementsByName("amount" + policyDiv)[0].value = 0;
                //--------------------------------------------
                var element1 = document.getElementById(policyDiv);

                //console.log("element 1 value*****:"+parseInt(element1));
                element1.parentNode.removeChild(element1);
               
            } catch (e) {

            }
        }
        
        /*function removePolicy(policyDiv) {

//            try {
//                tempCount3--;
//                var val = document.getElementById("policyCount").value;
//                val = val - 1;
//                document.getElementById("policyCount").value = val;
//                var element1 = document.getElementById(policyDiv);
//                element1.parentNode.removeChild(element1);
//            } catch (e) {
//
//            }
            try {
                tempCount3--;

                var val = document.getElementById("policyCount").value;


                var element = document.getElementsByName("amount" + val)[0].value;

//                    alert(document.getElementById("amount" + val).value);

                val = val - 1;

                var element2 = document.getElementById('txtresult').value;
                document.getElementById('txtresult').value = '';
                document.getElementById('txtresult').value = parseInt(element2) - parseInt(element);
                var element21 = document.getElementById('txtresultCTC').value;
                document.getElementById('txtresultCTC').value = '';
                document.getElementById('txtresultCTC').value = parseInt(element21) - parseInt(element);

                document.getElementById("policyCount").value = val;
                element1 = document.getElementById(policyDiv);

                element1.parentNode.removeChild(element1);
            } catch (e) {

            }
        }*/



    </script>


    <script>
        function setDesignation() {

            var designationMasterId = document.getElementById('designationMasterByLevelId').value;
//            alert("this is designation for it   " + designationMasterId);
            document.getElementById('designationMaster.id').value = designationMasterId;
        }
    </script>
    <script>
        var tempCount = 1;
        $(function () {
            $("#visaCloneid").on("click", function () {
                tempCount++;
                //                alert(tempCount3);
                var clone = "<tr id='addmoreTR" + tempCount + "' style='clear:both;'>"
                        + "<td style=\"text-align: center\">" + tempCount + "</td>"
                        + "<td id=\"visaIssueCountry" + tempCount + "\"><input type =\"text\" name='visaIssueCountry" + tempCount + "' id='visaIssueCountry" + tempCount + "' class =\"form-control\" />"
                        + "<td style=\"text-align: center\">"
                        + "<input type=\"text\" name='visaIssueDate" + tempCount + "' id='visaIssueDate" + tempCount + "' size=\"16\"  class=\"form-control\">"
                        + "</td>"
                        + "<td style=\"text-align: center\">"
                        + "<input type=\"text\" name='visaValidTillDate" + tempCount + "' id='visaValidTillDate" + tempCount + "' class=\"form-control\" size=\"16\">"
                        + "</td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\"value=\"-\"  onclick=\"removevisadoc('addmoreTR" + tempCount + "');\"/>"
                        + "</span>"
                        + "</td>"
                        + "</tr>";
                $("#visaTable").append(clone);
                document.getElementById('visaCount').value = tempCount;
                $("#visaIssueDate" + tempCount + "").datepicker({dateFormat: 'dd/mm/yy'});
                $("#visaValidTillDate" + tempCount + "").datepicker({dateFormat: 'dd/mm/yy'});
                //                $("#ui-datepicker-div").css("z-index",2);
                //                window.onload = init;
                //                function init() {
                //                    document.form1.month.options[new Date().getMonth()].selected = true;
                //                }


            });
        });
        $(function () {
            $("#visaIssueDate1").datepicker({dateFormat: 'dd/mm/yy'});
        });
        $(function () {
            $("#visaValidTillDate1").datepicker({dateFormat: 'dd/mm/yy'});
        });
    </script>
    <script>
        function removevisadoc(addmoreTR) {
            --tempCount;
            document.getElementById('visaCount').value = tempCount;
            var element1 = document.getElementById(addmoreTR);
            element1.parentNode.removeChild(element1);
        }

    </script>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>EMPLOYEE REGISTRATION FORM</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Employee Registration Form</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        
        <!-- Main content -->
        <form:form class="form-horizontal" role="form" action="employeeMaster.htm?act=createSubmit" commandName="employeeMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
            <section class="content">
                <c:if test="${!empty failureMessage}">
                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}
                        <br/><form:errors path="*" cssClass="errorDiv"></form:errors>
                        
                            <%--<form:errors path="failureMessageExtension" cssClass="errorDiv"></form:errors>
                        
                            <input type="text" name="firstName" value="${list.firstName}" id="firstName">
                            --%>    
                            
                            <font class="errorDiv" color="#dd4b39"> ${failureMessageExtension} </font>
                    </div>
                </c:if>
                <input type="hidden" name="shiftName" id="shiftName" value="${shiftName}">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                <!--form horizontal starts here-->
                                <div class="box box-info collapsed-box" id="empInfo_id">
                                    <div class="box-header">
                                        <h3 class="box-title">Employee Official Details:</h3>
                                        <div class="box-tools pull-right">
                                            <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                            <span id="spanId1">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun1();"><i class="fa fa-plus" id="minusId1" ></i></button>
                                        </div>
                                    </div>
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Employee No:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="employeeId" class="form-control" onchange="userName1();" ></form:input>
                                                        <form:errors path="employeeId" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label>Employee Name (First & Last Name only):<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="employeeName" class="form-control"></form:input>
                                                        <form:errors path="employeeName" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Date Of Joining:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <form:input path="dateOfJoining" class="form-control" size="16" value="" readonly="true"></form:input>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        <form:errors path="dateOfJoining" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Date Of Birth:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <div class="input-group date form_datetime_dob" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                            <form:input path="dateOfBirth" id="dob" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        <form:errors path="dateOfBirth" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">    
                                                        <div class="col-sm-6">
                                                            <label>Department:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:select path="employeeTypeMaster.id" id="employeeTypeMaster.id" onchange="selectsubtype(this.value);" class="form-control">
                                                            <form:option value="None" label="-- Select --" ></form:option>
                                                            <form:options items="${EmployeeTypeList}"></form:options>
                                                        </form:select>
                                                        <form:errors path="employeeTypeMaster.id" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-6" id="employeeSubTypeId">
                                                            <label>Division:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <input type="hidden" name="subTypeId" id="subTypeId" value="${employeeMaster.employeeSubType.id}">
                                                        <form:select path="employeeSubType.id" class="form-control">
                                                            <form:option value="" label="-- Select --" ></form:option> 
                                                        </form:select>
                                                        <form:errors path="employeeSubType.id" cssClass="errorDiv"></form:errors>
                                                        </div>    
                                                    </div>
                                                    <div class="form-group">   
                                                        <div class="col-sm-6">
                                                            <label>Designation:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <select name="designationMasterByLevelId" id="designationMasterByLevelId" class="form-control" onchange="setDesignation()">
                                                                <option value="" label="-- Select --" ></option>    
                                                                <c:forEach var="desn" items="${desigList}">
                                                                    <c:if test="${designationMasterByLevelId eq desn.key}">
                                                                        <option value="${desn.key}" selected="">${desn.value}</option>
                                                                    </c:if>
                                                                    <c:if test="${designationMasterByLevelId ne desn.key}">
                                                                        <option value="${desn.key}">${desn.value}</option>
                                                                    </c:if>
                                                                </c:forEach>
                                                            </select>
                                                            <form:hidden path="designationMaster.id" class="form-control"></form:hidden>
                                                            <form:errors path="designationMaster.id" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Gender:<span style="color: red;font-size: 12px;">*</span></label>&nbsp;&nbsp;
                                                        <%--<form:select path="gender" id="gender" class="form-control">--%>
                                                        <fieldset id="group1">
                                                            <form:radiobutton path="gender" value="false"/>Male&nbsp;&nbsp;
                                                            <form:radiobutton path="gender" value="true"/>Female
                                                            <%--<form:option value="">--SELECT--</form:option>--%>
                                                            <%--<form:option value="0">Male</form:option>--%>
                                                            <%--<form:option value="1">Female</form:option>--%>
                                                        </fieldset>
                                                        <%--</form:select>--%>
                                                        <form:errors path="gender" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                         <div class="col-sm-6">
                                                            <label>Marital Status:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <fieldset id="group2">
                                                            <form:radiobutton path="maritalStatus"  value="UnMarried"/>UnMarried
                                                            <form:radiobutton path="maritalStatus"  value="Married"/>Married
                                                            <form:radiobutton path="maritalStatus" value="Other"/>Other

                                                        </fieldset>

                                                        <div style="display: none;" class="col-sm-6" id="otherMaritalStatusId">
                                                            <form:input type="text" path="maritalStatusOthers" class="form-control"/>
                                                        </div>
                                                        <form:errors path="maritalStatus" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>


                                                    <div class="form-group">  
                                                        <div class="col-sm-3">
                                                            <label>Photograph:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <img src="${imgFile}" id="photograph" name="photograph" width="150px" height="150px"/>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <label>Photograph:</label>

                                                            <%--<input type="file" class="form-control" id="photograph" name="photograph" value="${photographpresist}"accept="image/jpg,image/jpeg,image/png" onchange="checkFileSize();">
                                                            --%>
                                                            <input type="file" class="form-control" id="photographUpdate" name="photographUpdate" onchange="changeButton();" accept="image/jpg,image/jpeg,image/png">
                                                                
                                                            <span style="font-size: 14px; color: red;" id="photographError"></span>

                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Official E - Mail ID:</label>
                                                        <form:input path="officeEmailId" id="officeEmailId" class="form-control"></form:input>
                                                        <form:errors path="officeEmailId" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        
                                                    </div>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                    <!--Employee Official Details starts here-->

                                    <div class="box box-info collapsed-box" id="personal_Detail_id">
                                        <div class="box-header">
                                            <h3 class="box-title">Legal Documents:</h3>
                                            <div class="box-tools pull-right">
                                                <!--<button  class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                                <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2();"><i class="fa fa-plus" id="minusId2" ></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Employee Name (First Name, Middle Name, Last Name as per Aadhar card)<span style="color: red;font-size: 12px;">*</span></label>
<!--                                                            <fieldset id="group11">
                                                                <input type="radio" name="nameStatus" id="nameStatus" checked="true" value="false"/>Passport
                                                                <input type="radio" name="nameStatus" id="nameStatus" value="true"/>AadharCard
                                                            </fieldset>
                                                            <span style="font-size: 14px; color: red;" id="errormsg"></span>-->
                                                        </div>
                                                        
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>PAN Card No:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="panCard" class="form-control"  style="text-transform: uppercase" placeholder="(1-5: alphabets, 6-9: digits, 10th: alphabet) Example: ASDFG4567A"></form:input>
                                                        <form:errors path="panCard" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-6">

                                                            <label>Nationality:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <input type="text" name="nationality" id="nationality" value="${nationality}" style="text-transform:uppercase" class="form-control">
                                                      
                                                            <c:if test="${!empty Nati}">
                                                                <font class="errorDiv" color="#dd4b39"> ${Nati} </font>
                                                            </c:if>
                                                        </div>

                                                    </div>  

<!--                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Passport No:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <%--<form:input path="passportNo" id="passportNo" class="form-control"></form:input>--%>
                                                        <span style="font-size: 14px; color: red;" id="passportNoError"></span>
                                                        </div>
                                                        <div class="col-sm-6">

                                                            <label>Country Of Issue:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <input type="text" name="countryOfIssue" id="countryOfIssue"  placeholder="Passport Issue Country" class="form-control">
                                                             <span style="font-size: 14px; color: red;" id="countryOfIssueError"></span>
                                                        </div>
                                                    </div>-->
                                                    

                                                    <div class="form-group">
                                                        <div class="col-sm-6">

                                                            <label>First Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <input type="text" name="firstName" id="firstName" value="${firstName}" class="form-control">
                                                            <span style="font-size: 14px; color: red;" id="firstNameError"></span>
                                                            
                                                            <c:if test="${!empty Firs}">
                                                                <font class="errorDiv" color="#dd4b39"> ${Firs} </font>
                                                            </c:if>
                                                        </div>
                                                        <div class="col-sm-6">

                                                            <label>Middle Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <input type="text" name="middleName" id="middleName" value="${middleName}" class="form-control">
                                                            <span style="font-size: 14px; color: red;" id="middleNameError"></span>
                                                            <c:if test="${!empty Midd}">
                                                                <font class="errorDiv" color="#dd4b39"> ${Midd} </font>
                                                            </c:if>
                                                        </div>
                                                    </div>
<!--                                                    <div class="form-group">
                                                        <div class="col-sm-6">

                                                            <label>Last Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <input type="text" name="lastName" id="lastName"  class="form-control">
                                                            <span style="font-size: 14px; color: red;" id="lastNameError"></span>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Passport Issue Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <div class="input-group date form_datetime_passport_issue"  data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <%--<form:input path="passportIssueDate" id="passportIssueDate" class="form-control" size="16" readonly="true"></form:input>--%>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                                <span style="font-size: 14px; color: red;" id="passportIssueDateError"></span>
                                                        <%--<form:errors path="passportIssueDate" cssClass="errorDiv"></form:errors>--%>
                                                        </div>
                                                    </div>-->
                                                    <div class="form-group">
<!--                                                        <div class=" col-sm-6">
                                                            <label>Passport Expiry Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <div class="input-group date form_datetime_passport_expiry"   data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                <input class="form-control" size="16" type="text" value="" readonly>
                                                            <%--<form:input path="passportExpiryDate" id="passportExpiryDate"  class="form-control" size="16" readonly="true"></form:input>--%>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                
                                                            </div>
                                                                <span style="font-size: 14px; color: red;" id="passportExpiryDateError"></span>
                                                        </div>-->
                                                        <div class="col-sm-6">

                                                            <label>Last Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <input type="text" name="lastName" id="lastName" value="${lastName}" class="form-control">
                                                            <span style="font-size: 14px; color: red;" id="lastNameError"></span>
                                                            <c:if test="${!empty Last}">
                                                                <font class="errorDiv" color="#dd4b39"> ${Last} </font>
                                                            </c:if>
                                                        </div>
                                                            <div class="col-sm-6">
                                                            <label >Aadhar Card:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="adharCard" id="adharCard" class="form-control"></form:input>
                                                        <form:errors path="adharCard"  cssClass="errorDiv"></form:errors>
                                                        <span style="font-size: 14px; color: red;" id="adharCardError"></span>
                                                        </div>
<!--                                                        <div class="col-sm-6">

                                                            <label >Driving Licence No:</label>
                                                            <input type="text" name="drivingLicence" id="drivingLicence" class="form-control" >
                                                            <%--<form:input path="drivingLicence" type="text" class="form-control" placeholder="Please Specify No."></form:input>--%>
                                                        </div>-->
                                                    </div>
                                                    <!--<div class="form-group">-->
<!--                                                        <div class="col-sm-6">
                                                            <label>Driving Licence Type:<span style="color: red;font-size: 12px;"></span></label>
                                                            <select name="drivingLicenceType" id="drivingLicenceType" class="form-control">
                                                                <option value="">-- Select --</option>
                                                                <option value="2Wheeler">2 Wheeler</option>
                                                                <option value="4Wheeler">4 Wheeler</option>
                                                                <option value="Both">Both</option>
                                                            </select>
                                                        </div>-->
                                                        
                                                        
                                                    <!--</div>-->

<!--                                                    <div class="form-group">

                                                        <div class="col-sm-6">

                                                            <label>Election Card:<span style="color: red;font-size: 12px;"></span></label>
                                                            <input type="text" name="electionCard" id="electionCard" class="form-control">

                                                        </div>

                                                        <label style="padding-left:15px;">Any Other Government Document Photo Id Proof:</label>
                                                        <div class="col-sm-3">
                                                            
                                                            <div class="col-sm-6">
                                                            <%--<form:input path="govLicenceName" type="text" class="form-control" placeholder="Please Specify Photo ID Name" style="width:250px;"></form:input>--%>
                                                            </div>
                                                            <div class="col-sm-6">
</div>
 <div class="col-sm-3">
                                                           <input type="text" name="documentIdNo" id="documentIdNo" class="form-control" placeholder="Photo ID No" style="width:150px;"/>
                                                            </div>
                                                        </div>
                                                    </div>-->
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <!--Employee Official Details completes here-->    
                                    <!--Document visa detail starts here--> 
<!--                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">Visa Details:</h3>
                                            <div class="box-tools pull-right">
                                                <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
                                                <span id="spanId9">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun9();"><i class="fa fa-plus" id="minusId9" ></i></button>
                                            </div>
                                        </div> /.box-header 
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="table-responsive">
                                                        <table id="visaTable" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                            <tr>
                                                                <th style="text-align: center; vertical-align: middle;width: 5%">Sr.No.</th>
                                                                <th style="text-align: center; vertical-align: middle">Visa Issue Country</th>
                                                                <th style="text-align: center; vertical-align: middle">Visa Issue Date</th>
                                                                <th style="text-align: center; vertical-align: middle">Visa Valid till Date</th>
                                                                <th style="text-align: center; vertical-align: middle">Add New</th>
                                                            <input type="hidden" name="visaCount" id="visaCount" value="1"/>
                                                            </tr>
                                                            <tr>
                                                                <td style="text-align: center">1</td>
                                                                <td style="text-align: center">
                                                                    <input name="visaIssueCountry1" id="visaIssueCountry1" class="form-control">
                                                                </td>
                                                                <td style="text-align: center">
                                                                    <input type="text" name="visaIssueDate1" id="visaIssueDate1"  size="16"  class="form-control">
                                                                </td>
                                                                <td style="text-align: center">
                                                                    <input type="text" name="visaValidTillDate1" id="visaValidTillDate1" class="form-control" size="16" >
                                                                </td>
                                                                <td style="text-align: center">
                                                                    <span style='margin-top: 5px;'>
                                                                        <input type="button" value="+" id="visaCloneid" />
                                                                    </span>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div> /.col 
                                            </div> /.row 
                                        </div> /.box-body 
                                    </div>-->
                                    <!--Document visa detail completes here-->                    
                                    <!--Personal Contact Detail starts here-->        
                                    <div class="box box-info collapsed-box" id="personal_Detail_id">
                                        <div class="box-header">
                                            <h3 class="box-title">Personal Contact Details:</h3>
                                            <div class="box-tools pull-right">
                                                <!--<button  class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                                <span id="spanId10">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun10();"><i class="fa fa-plus" id="minusId10" ></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Personal Email Id:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="emailAddress" pattern="[^ @]*@[^ @]*" class="form-control" placeholder="abc@domain.com" required=""></form:input>

                                                        <%--<form:input path="emailAddress" class="form-control"></form:input>--%>
                                                        <form:errors path="emailAddress" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <!--                                                        <div class="col-sm-6">
                                                                                                                    
                                                                                                                    <label>FLYdocs Email Id:</label>
                                                                                                                <input type="text" name="flyDocsEmailId" id="flyDocsEmailId" pattern="[^ @]*@[^ @]*"  placeholder="abc@domain.com" required="" class="form-control">
                                                        
                                                                                                                
                                                                                                                </div>-->
                                                        <div class="col-sm-6">
                                                            <label >Personal Contact No:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="contactNo1" id="contactNo1" maxlength="14" data-fv-numeric="true" data-fv-numeric-message="Please enter valid number" data-fv-phone-country11="IN" class="form-control"></form:input>
                                                        <form:errors path="contactNo1" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label >Contact No.2:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:input path="contactNo2" id="contactNo1"  maxlength="14" data-fv-numeric="true" data-fv-numeric-message="Please enter valid number" data-fv-phone-country11="IN" class="form-control"></form:input>
                                                        <%--<form:errors path="contactNo2" cssClass="errorDiv"></form:errors>--%>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Blood Group:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <%--<form:input path="bloodGroups" class="form-control"></form:input>--%>
                                                        <form:select path="bloodGroups" id="bloodGroups" class="form-control ">
                                                            <option value="">--Select--</option>
                                                            <form:option value="A +ve">A +ve</form:option>
                                                            <form:option value="A -ve">A -ve</form:option>
                                                            <form:option value="B +ve">B +ve</form:option>
                                                            <form:option value="B -ve">B -ve</form:option>
                                                            <form:option value="AB +ve">AB +ve</form:option>
                                                            <form:option value="AB -ve">AB -ve</form:option>
                                                            <form:option value="O +ve">O +ve</form:option>
                                                            <form:option value="O -ve">O -ve</form:option>
                                                        </form:select>
                                                    </div>

                                                </div>
                                                <div class="form-group">
<!--                                                    <div class="col-sm-6">

                                                        <label>Religion:</label>
                                                        <input type="text" name="religion" id="religion" class="form-control">
                                                    </div>-->
                                                    <div class="col-sm-6">

                                                        <label>Languages known:</label>
                                                        <input type="text" name="languagesKnown" id="languagesKnown" value="${languagesKnown}" class="form-control">

                                                    </div>
                                                    <div class="col-sm-6">

                                                        <label>Disclosed Health Concerns:</label>
                                                        <input type="text" name="disclosedHealthConcerns" id="disclosedHealthConcerns" value="${disclosedHealthConcerns}" class="form-control">

                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    
                                                    <div class="col-sm-6">

                                                        <label>Hobbies:</label>
                                                        <input name="hobbies" id="hobbies" value="${hobbies}" class="form-control">

                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Highest Education Details:<span style="color: red;font-size: 12px;"></span></label>
                                                            <form:input path="highestEducationDetails" id="highestEducationDetails" class="form-control"></form:input>
                                                            <form:errors path="highestEducationDetails" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                </div>

                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <!--Personal Contact Detail completes here--> 
                                    <!--Family Background starts here-->
                                    <div class="box box-info collapsed-box" id="document_detail_id">
                                        <div class="box-header">
                                            <h3 class="box-title">Family Background:</h3>
                                            <div class="box-tools pull-right">
                                                <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                                <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun3();"><i class="fa fa-plus" id="minusId3" ></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">

                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Father's Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="fatherName" class="form-control"></form:input>
                                                        <form:errors path="fatherName" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Father's Date Of Birth:</label>
                                                            <div class="input-group date form_datetime_dob" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">

                                                            <form:input path="dateOfBirthOfEmpFather" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        <form:errors path="dateOfBirthOfEmpFather" cssClass="errorDiv"></form:errors>
                                                        </div>



                                                    </div>
                                                    <div class="form-group"> 
                                                        <div class="col-sm-6">
                                                            <label>Mother's Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="motherName" class="form-control"></form:input>
                                                        <form:errors path="motherName" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label>Mother's Date Of Birth:</label>
                                                            <div class="input-group date form_datetime_dob" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">

                                                            <form:input path="dateOfBirthOfEmpMother" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        <form:errors path="dateOfBirthOfEmpMother" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>

                                                    <div id="hideInfo1" style="display: none;margin-left: 2px;">
                                                        <div class="form-group" id="">
                                                            <div class="col-sm-6">
                                                                <label>Spouse Name:</label>
                                                            <form:input path="spouseName" class="form-control"></form:input>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <label>Spouse's Date Of Birth:</label>
                                                                <div class="input-group date form_datetime_dob" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">

                                                                <form:input path="dateOfBirthOfEmpSpous" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-sm-6">

                                                                <label>Spouse's Gender:<span style="color: red;font-size: 12px;"></span></label>&nbsp;&nbsp;
                                                                <fieldset id="group10">
                                                                    <input type="radio" name="SpouseGender" id="SpouseGender" checked="true" value="false"/>Male&nbsp;&nbsp;
                                                                    <input type="radio" name="SpouseGender" id="SpouseGender" value="true"/>Female
                                                                </fieldset>
                                                            </div>
                                                            
                                                        </div>
                                                    </div>  

                                                    <div id="hideInfo2" style="display: none;margin-left: 2px;">
                                                        <div class="form-group" id="">

                                                            <div class="col-sm-6">
                                                                <label>Child Name1:</label>
                                                            <form:input path="child1" class="form-control"></form:input>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <label>Child1's Date Of Birth:</label>
                                                                <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">

                                                                <form:input path="dateOfBirthOfEmpChilld1" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-sm-6">

                                                                <label>Child1's Gender:<span style="color: red;font-size: 12px;"></span></label>&nbsp;&nbsp;
                                                                <fieldset id="group6">
                                                                    <input type="radio" name="childOneGender" id="childOneGender" checked="true" value="false"/>Male&nbsp;&nbsp;
                                                                    <input type="radio" name="childOneGender" id="childOneGender" value="true"/>Female
                                                                </fieldset>
                                                            </div> 
                                                            
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-sm-6">
                                                                <label>Child Name2:</label>
                                                            <form:input path="child2" class="form-control"></form:input>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <label>Child2's Date Of Birth:</label>
                                                                <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">

                                                                <form:input path="dateOfBirthOfEmpChild2" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                </div>
                                                            </div>
                                                            
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-sm-6">

                                                                <label>Child2's Gender:<span style="color: red;font-size: 12px;"></span></label>&nbsp;&nbsp;
                                                                <fieldset id="group6">
                                                                    <input type="radio" name="childTwoGender" id="childTwoGender" checked="true" value="false"/>Male&nbsp;&nbsp;
                                                                    <input type="radio" name="childTwoGender" id="childTwoGender" value="true"/>Female
                                                                </fieldset>
                                                            </div>
                                                            
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Present Address:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:textarea path="presentAddress" class="form-control"></form:textarea>
                                                        <form:errors path="presentAddress" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <form>
                                                                <label>Street/Road/Area:<span style="color: red;font-size: 12px;">*</span></label>

                                                                <textarea name="presentAddress2" id="presentAddress2" class="form-control">${presentAddress2}</textarea>
                                                                <c:if test="${!empty Pres}">
                                                                    <font class="errorDiv" color="#dd4b39"> ${Pres} </font>
                                                                </c:if>
                                                            </form>
                                                        <%--  <form:errors path="" cssClass="errorDiv"></form:errors>--%>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">

                                                        <label>Present City:</label>
                                                        <input type="text" name="presentCity" id="presentCity" value="${presentCity}" class="form-control">

                                                    </div>
                                                    <div class="col-sm-6">

                                                        <label>Present State:</label>
                                                        <input type="text" name="presentState" id="presentState" value="${presentState}" class="form-control">

                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">

                                                        <label>Present Postal Code:</label>
                                                        <input type="text" name="presentPostalCode" id="presentPostalCode" value="${presentPostalCode}" class="form-control">

                                                    </div>
                                                    <div class="col-sm-6">

                                                        <label>Present Country:</label>
                                                        <input type="text" name="presentCountry" id="presentCountry" value="${presentCountry}" class="form-control">

                                                    </div>
                                                </div>             

                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Permanent Address:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:textarea path="permanentAddress" class="form-control"></form:textarea>
                                                        <form:errors path="permanentAddress" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-6">

                                                            <label>Street/Road/Area:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <!--                                                            <input type="textarea" name="permanentAddress2" id="permanentAddress2" class="form-control">-->
                                                            <textarea name="permanentAddress2" id="permanentAddress2" class="form-control">${permanentAddress2}</textarea>
                                                            <c:if test="${!empty Perm}">
                                                                    <font class="errorDiv" color="#dd4b39"> ${Perm} </font>
                                                            </c:if>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">

                                                            <label>Permanent City:</label>
                                                            <input type="text" name="permanentCity" id="permanentCity" value="${permanentCity}"  class="form-control">

                                                        </div>
                                                        <div class="col-sm-6">

                                                            <label>Permanent State:</label>
                                                            <input type="text" name="permanentState" id="permanentState" value="${permanentState}" class="form-control">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">

                                                            <label>Permanent Postal Code:</label>
                                                            <input type="text" name="permanentPostalCode" id="permanentPostalCode" value="${permanentPostalCode}" class="form-control">

                                                        </div>
                                                        <div class="col-sm-6">

                                                            <label>Permanent Country:</label>
                                                            <input type="text" name="permanentCountry" id="permanentCountry" value="${permanentCountry}" class="form-control">

                                                        </div>
                                                    </div>
                                                    <div class="form-group">

                                                        <div class="col-sm-6">
                                                            <label>Emergency Contact No:<span style="color: red;font-size: 12px;"></span></label>
                                                            <form:input path="emergencyContactNo"  maxlength="14" data-fv-numeric="true" data-fv-numeric-message="Please enter valid number" data-fv-phone-country11="IN" class="form-control"></form:input>
                                                            <form:errors path="emergencyContactNo" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label >Emergency Contact Person:<span style="color: red;font-size: 12px;"></span></label>
                                                            <form:input path="emergencyContactPerson" class="form-control"></form:input>
                                                            <form:errors path="emergencyContactPerson" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">

                                                            <label>Relationship:<span style="color: red;font-size: 12px;"></span></label>
                                                            <input type="text" name="RelationShip" id="RelationShip" value="${RelationShip}" maxlength="14" class="form-control" >

                                                        </div>

                                                        <div class="col-sm-6">

                                                            <label>Emergency Contact Address:<span style="color: red;font-size: 12px;"></span></label>
                                                            <input type="text" name="emergencyContactAddress" id="emergencyContactAddress" value="${emergencyContactAddress}" maxlength="14" class="form-control">

                                                        </div>

                                                    </div>
                                                    <div class="form-group">
                                                        
                                                        <div class="col-sm-6">

                                                            <label>Other important information relating to your emergency contact:<span style="color: red;font-size: 12px;"></span></label>
                                                            <input type="text" name="otherImpInfo" id="otherImpInfo" value="${otherImpInfo}" class="form-control">

                                                        </div> 
                                                    </div>


                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <!--Family Background completes here-->
                                    <!--Organization Specific Detail starts here-->
                                    <div class="box box-info collapsed-box" id="org_detail_id">
                                        <div class="box-header">
                                            <h3 class="box-title">Organization Specific Detail:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun4();"><i class="fa fa-plus" id="minusId4" ></i></button>
                                                <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Name of Previous company:</label>
                                                            <input type="text" name="nameOfPreviousCompany" id="nameOfPreviousCompany" value="${nameOfPreviousCompany}" class="form-control">

                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Previous Company Location:</label>
                                                            <input type="text" name="previousCompanyLocation" id="previousCompanyLocation" value="${previousCompanyLocation}" class="form-control">

                                                        </div>
                                                    </div>
                                                    <div class="form-group">

                                                        <div class="col-sm-6">
                                                            <label>Experience On Date Of Joining: Year:<span style="color: red;font-size: 12px;"></span></label>
                                                            <form:select path="experienceYearOnDoj" class="form-control ">
                                                                <c:forEach begin="0" end="50" var="counter">
                                                                    <form:option value="${counter}">${counter}</form:option>
                                                                </c:forEach>
                                                            </form:select>
                                                            <form:errors path="experienceYearOnDoj" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Experience On Date Of Joining: Month:<span style="color: red;font-size: 12px;"></span></label>
                                                            <form:select path="experienceMonthOnDoj" class="form-control ">
                                                                <c:forEach begin="0" end="11" var="counter">
                                                                    <form:option value="${counter}">${counter}</form:option>
                                                                </c:forEach>
                                                            </form:select>
                                                            <form:errors path="experienceMonthOnDoj" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>

<!--                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Company:<span style="color: red;font-size: 12px;"></span></label>
                                                            <%--<form:select path="company"  class="form-control ">--%>
                                                                <%--<form:option label="-- Select --"  value="" ></form:option>--%>
                                                                <%--<c:forEach var="comp" items="${company}" >--%>
                                                                    <%--<form:option value="${comp.value}">${comp.value}</form:option>--%>
                                                                <%--</c:forEach>--%>
                                                            <%--</form:select>--%>
                                                            <%--<form:errors path="company" cssClass="errorDiv"></form:errors>--%>
                                                        </div>
                                                        <input type="hidden" name="typeOfEmployee" id="typeOfEmployee" value="${employeeTypeMaster.typeOfEmployee}">
                                                            <div class="col-sm-6">
                                                        <label> Location:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <%--<form:select path="zydexLocationMaster.id" class="form-control ">--%>
                                                            <%--<form:option value="" label="-- Select --" ></form:option>--%>
                                                            <%--<form:options items="${zydexLocationMap}"></form:options>--%>
                                                        <%--</form:select>--%>
                                                        <%--<form:errors path="zydexLocationMaster.id" cssClass="errorDiv"></form:errors>--%>
                                                        </div>
                                                </div>-->

                                                <div class="form-group">
                                                    
                                                        <div class="col-sm-6">
                                                            <label>Level:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <%-- onchange="getDesignation(); --%>
                                                        <form:select path="levelMaster.id" class="form-control">
                                                            <form:option value="" label="-- Select --" ></form:option>
                                                            <form:options items="${level}"></form:options>
                                                        </form:select>
                                                        <form:errors path="levelMaster.id" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Work Location:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:select path="locationMaster.id" class="form-control ">
                                                            <form:option value="" label="-- Select --" ></form:option>
                                                            <form:options items="${location}"></form:options>
                                                        </form:select>
                                                        <form:errors path="locationMaster.id" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        
                                                        <div class="col-sm-6">
                                                            <label>Business Unit:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:select path="departmentMaster.id" class="form-control">
                                                            <form:option value="" label="-- Select --" ></form:option>
                                                            <form:options items="${deptMap}"></form:options>
                                                        </form:select>
                                                        <form:errors path="departmentMaster.id" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Type of Employment:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:select path="employeeType" id="employeeType" class="form-control ">
                                                            <form:option value="Probation" label="Probation"></form:option>
                                                            <form:option value="Confirmed" label="Confirmed"></form:option>
                                                            <form:option value="Interns" label="Interns"></form:option>
                                                        </form:select>
                                                    </div>
                                                    </div>
                                                    <!--<div class="form-group">-->

                                                       
                                                    
<!--                                                        <div class="col-sm-6">
                                                            <label >Official Contact No.:</label>
                                                        <input type="text" name="officialContactNumber" id="officialContactNumber" class="form-control">
                                                        </div>-->
                                                    <!--</div>-->


<!--                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Sub Team Transfer Date:</label>
                                                            <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">

                                                                <input type="text" name="subteamTransferDate" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"/>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        </div>

                                                    </div>-->
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                        <label>Role:</label>
                                                        <form:input path="role" class="form-control"></form:input>
                                                    </div>
                                                        
                                                        <div class="col-sm-6">
                                                            <label>Work Type:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:select path="shiftType" class="form-control">
                                                            <!--<option value="">--SELECT--</option>-->
                                                            <form:option value="" label="-- Select --" ></form:option>
                                                            <form:option value="HourlyBase" label="Hourly Base"></form:option>
                                                            <form:option value="ShiftBase" label="Shift Base"></form:option>
                                                        </form:select>
                                                        <form:errors path="shiftType" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        
                                                        <div class="col-sm-6" id="hourlyBaseTitleDiv" style="display: none">
                                                            <label>Hourly Base Title:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <select name="shiftHoursId" id="shiftHoursId" class="form-control">
                                                                <option value="" label="-- Select --" ></option>
                                                            <c:forEach var="hours1" items="${hours}">
                                                                <c:if test="${hours1.key eq employeeMaster.shiftHoursId}">
                                                                    <option value="${hours1.key}" selected="">${hours1.value}</option>
                                                                </c:if>
                                                                <c:if test="${hours1.key ne employeeMaster.shiftHoursId}">
                                                                    <option value="${hours1.key}">${hours1.value}</option>
                                                                </c:if>
                                                            </c:forEach>
                                                        </select>
                                                        <span style="font-size: 14px; color: red;" id="shiftHoursIdError"></span>
                                                        <form:errors path="shiftHoursId" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-6" id="shiftRotationDateDiv" style="display: none">
                                                        <label>Shift Rotation Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="input-group date form_datetime_shift_rotation"   data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <form:input path="shiftRotationDate" class="form-control" size="16" value="" readonly="true"></form:input>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                            <span style="font-size: 14px; color: #dd4b39;" id="shiftRotationDateError"></span>
                                                        <form:errors path="shiftRotationDate" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">

                                                        
                                                        <div class="col-sm-6" id="shiftRotationNameDiv" style="display: none">
                                                            <label>Shift Rotation Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <select name="shiftId" id="shiftId" class="form-control" onchange="selectShift(this.value);
                                                                    selectedShift(this.value)">
                                                                <option value="">-- Select --</option>
                                                            <c:forEach var="shift1" items="${rotationMap}">
                                                                <c:if test="${shift1.key eq employeeMaster.shiftHoursId}">
                                                                    <option value="${shift1.key}" selected="">${shift1.value}</option>
                                                                </c:if>
                                                                <c:if test="${shift1.key ne employeeMaster.shiftHoursId}">
                                                                    <option value="${shift1.key}" >${shift1.value}</option>
                                                                </c:if>
                                                            </c:forEach>
                                                        </select>
                                                        <span style="font-size: 14px; color: #dd4b39;" id="shiftIdError"></span>
                                                    </div>
                                                    <div  id="shiftNameDiv" style="display: none">
                                                            <div class="col-sm-6" id="shiftMasterDivId" >
                                                                <label>Shift Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <select name="shiftMasterId" id="shiftMasterId" class="form-control">
                                                                    <option value="">--Select--</option>
                                                                </select>
                                                                <span style="font-size: 14px; color: #dd4b39;" id="shiftMasterIdError"></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    


                                                    <div class="form-group">

                                                        <div class="col-sm-6">
                                                            <label>Basic Salary:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="basicSalary"  id="basicSalary" class="form-control"  placeholder="Enter Basic Salary" onchange="changetotalButton();" />
                                                        <form:errors path="basicSalary" cssClass="errorDiv"/>
                                                    </div>

                                                    <div class="col-sm-6">
                                                        <label>ESIC No<span style="color: red;font-size: 12px;"></span></label>
                                                            <form:input path="esicNo" class="form-control"  placeholder="Enter ESIC No"/>
                                                            <form:errors path="esicNo" cssClass="errorDiv"/>
                                                    </div>


                                                </div>
                                                <div  class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>PF Amount(By Employee Basic Salary):</label>
                                                        <form:input path="pfAmount" type="number" min="0" placeholder="Enter Amount" class="form-control"></form:input>
                                                        <form:errors path="pfAmount" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>PF Amount(By Employer Basic Salary):</label>
                                                        <form:input path="pfAmountEmployer" type="number" min="0" placeholder="Enter Amount" class="form-control"></form:input>
                                                        <form:errors path="pfAmountEmployer" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>    
                                                <div  class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Hours Mandatory:</label>
                                                        <form:input path="hoursMadatory" type="text" placeholder="Enter Hours" class="form-control"></form:input>
                                                        <form:errors path="hoursMadatory" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        
                                                    </div>    
                                                    <div class="form-group">
                                                        <div class="col-sm-4">
                                                            <label>Provident Fund:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <fieldset>
                                                            <form:radiobutton path="pf"   value="false" checked="checked"/>NO&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            <form:radiobutton path="pf" value="true"/>YES
                                                        </fieldset>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <label>Professional Tax:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <fieldset>
                                                            <form:radiobutton path="pt"   value="false" checked="checked"/>NO&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            <form:radiobutton path="pt" value="true"/>YES
                                                        </fieldset>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <label>ESIC:<span style="color: red;font-size: 12px;">*</span></label>&nbsp;&nbsp;
                                                        <fieldset>
                                                            <form:radiobutton path="esic" value="false" checked="checked"/>NO&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            <form:radiobutton path="esic" value="true"/>YES
                                                        </fieldset>
                                                        <form:errors path="esic" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-4">
                                                            <label>Salary Base:<span style="color: red;font-size: 12px;">*</span></label>&nbsp;&nbsp;
                                                            <fieldset>
                                                            <form:radiobutton path="salaryBase" value="false" checked="checked"/>Month&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            <form:radiobutton path="salaryBase" value="true"/>Day
                                                        </fieldset>
                                                        <form:errors path="salaryBase" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <label>OT:<span style="color: red;font-size: 12px;">*</span></label>&nbsp;&nbsp;
                                                            <fieldset>
                                                            <form:radiobutton path="ot" value="false" checked="checked"/>YES&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            <form:radiobutton path="ot" value="true"/>NO
                                                        </fieldset>
                                                        <form:errors path="ot" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <label>Odd Punch Required:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <fieldset>
                                                            <form:radiobutton path="oddPunch" value="false" checked="checked"/>NO&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            <form:radiobutton path="oddPunch" value="true"/>YES
                                                        </fieldset>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-4">
                                                        <label>Payroll:<span style="color: red;font-size: 12px;">*</span></label>&nbsp;&nbsp;
                                                        <fieldset>
                                                            <form:radiobutton path="payroll" value="false" checked="checked"/>No&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            <form:radiobutton path="payroll" value="true"/>Yes
                                                        </fieldset>
                                                        <form:errors path="payroll" cssClass="errorDiv"></form:errors>
                                                        </div>


                                                    </div>
                                                    <%--<div class="col-md-12 col-sm-12">
                                                        <div class="table-responsive">
                                                            <table id="policyTable" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                                <tr>
                                                                    <th style="text-align: center; vertical-align: middle;width: 5%">Sr.No.</th>
                                                                    <th style="text-align: center; vertical-align: middle">Select Allowance</th>
                                                                    <!--<th style="text-align: center; vertical-align: middle">Policy Number</th>-->
                                                                    <th style="text-align: center; vertical-align: middle">Amount</th>
                                                                    <th style="text-align: center; vertical-align: middle">Taxable</th>
                                                                    <th style="text-align: center; vertical-align: middle">Add New</th>
                                                                <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                                                                </tr>
                                                                <tr>
                                                                    <td style="text-align: center">1</td>
                                                                    <td id="policyTd1"><div>
                                                                            <select id="policyId1"  name="policyId1"  class="form-control">
                                                                                <option value="">--SELECT--</option>
                                                                            <c:forEach var="comp" items="${policy}" varStatus = "status">
                                                                                <option value="${comp.key}">${comp.value}</option>
                                                                            </c:forEach>
                                                                        </select>
                                                                    </div>
                                                                    <span id="policyError1" style="color: red;"></span>
                                                                </td>
                                                                <!--                                                                <td style="text-align: center">
                                                                                                                                    <input type="text" name="policyNumber1" id="policyNumber1"  class="form-control">
                                                                                                                                </td>-->
                                                                <td style="text-align: center">
                                                                    <input name="amount1" id="amount1" min="0" onchange="changetotalButton();"class="form-control" >
                                                                </td>
                                                                <td style="text-align: center">
                                                                    <input type="checkbox" name="taxable1" id="taxable1" >
                                                                </td>
                                                                <td style="text-align: center">
                                                                    <span style='margin-top: 5px;'>
                                                                        <input type="button" value="+" id="policyCloneid" />
                                                                    </span>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>--%>
                                                
                                                 <div class="col-md-12 col-sm-12">
                                                    <div class="table-responsive">
                                                        <table id="policyTable" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                            <tr>
                                                                <th style="text-align: center; vertical-align: middle;width: 5%">Sr.No.</th>
                                                                <th style="text-align: center; vertical-align: middle">Select Allowance</th>
                                                                <!--<th style="text-align: center; vertical-align: middle">Policy Number</th>-->
                                                                <th style="text-align: center; vertical-align: middle">Amount</th>
                                                                <th style="text-align: center; vertical-align: middle">Taxable</th>
                                                                <th style="text-align: center; vertical-align: middle">Add New</th>
                                                                    <c:choose>
                                                                        <c:when test="${not empty finalPolicyList}">
                                                                    <input type="hidden" name="policyCount" id="policyCount"  value="${fn:length(finalPolicyList)}"/>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <input type="hidden" name="policyCount" id="policyCount"  value="1"/>
                                                                </c:otherwise>
                                                            </c:choose>
                                                            </tr>
                                                            <c:choose>
                                                                <c:when test="${not empty finalPolicyList}">
                                                                    <c:forEach var="comp" items="${finalPolicyList}" varStatus = "countVal">
                                                                        <input type="hidden" name="countSecond" id="countSecond" value="${fn:length(finalPolicyList)}"/>
                                                                        <tr id="removepolicyDefault${countVal.count}">

                                                                            <td style="text-align: center">${countVal.count}</td>
                                                                            <td><div>
                                                                                    <select id="policyId${countVal.count}"  name="policyId${countVal.count}"  class="form-control">
                                                                                        <option value="">--SELECT-- ${comp[5]}</option>
                                                                                        <c:forEach var="policyData" items="${policy}" varStatus = "status">
                                                                                            <c:choose>
                                                                                                <c:when test="${comp[1] == policyData.value}">
                                                                                                    <option value="${policyData.key}" selected="selected">${comp[1]}</option>
                                                                                                </c:when>
                                                                                                <c:otherwise>
                                                                                                    <option value="${policyData.key}" >${policyData.value}</option>
                                                                                                </c:otherwise>
                                                                                            </c:choose>
                                                                                        </c:forEach>
                                                                                    </select>
                                                                                </div>
                                                                                <span id="policyError${countVal.count}" style="color: red;"></span>
                                                                            </td>
                                                                            <!--</td>-->
                                                                            <!--                                                                            <td style="text-align: center">
                                                                                                                                                            <input type="text" name="policyNumber${countVal.count}" id="policyNumber${countVal.count}"  class="form-control"  value="${comp[2]}">
                                                                                                                                                        </td>-->
                                                                            <td style="text-align: center">
                                                                                <input type="number" name="amount${countVal.count}" id="amount${countVal.count}" min="0" onchange="changetotalButtonNew();" class="form-control" value="${comp[3]}">
                                                                               
                                                                            </td>

                                                                            <!--  <input type="checkbox" id="mycheckbox">
                                                                            -->

                                                                            <!--<p id="addCheckBox"></p>-->
                                                                            <c:if test="${comp[4] eq 1}">
                                                                                <td style="text-align: center">

                                                                                    <input type="checkbox" name="taxable${countVal.count}" id="taxable${countVal.count}" checked="true" value="off">                                                                             

                                                                                </td>
                                                                            </c:if>
                                                                            <c:if test="${comp[4] ne 1}">
                                                                                <td style="text-align: center">

                                                                                    <input type="checkbox" name="taxable${countVal.count}" id="taxable${countVal.count}" value="off" >
                                                                                </td>                                                                              
                                                                            </c:if>
                                                                            <td style="text-align: center">
                                                                                <%--<c:choose>--%>
                                                                                <%--<c:when test="${countVal.first}">--%>
                                                                                <!--<span style='margin-top: 5px;'>-->
                                                                                <!--<input type="button" value="+" id="policyCloneid" />-->
                                                                                <!--</span>-->
                                                                                <%--</c:if>--%>
                                                                                <%--</c:when>--%>
                                                                                <%--<c:otherwise>--%>
                                                                                <!--                                                                                <span style='margin-top: 5px;'>
                                                                                                                                                                <input type="button" value="-" id="policyRemoveid" onclick="removeForEdit()"/>
                                                                                                                                                                </span>-->
                                                                                <%--</c:otherwise>--%>
                                                                                <%--</c:choose>
                                                                                <c:if test="${countVal.last}">
                                                                                    <c:if test="${countVal.last}">
                                                                                        <span style='margin-top: 5px;'>
                                                                                       
                                                                                            <input type="button" value="+" id="policyCloneid" />
                                                                                        </span>
                                                                                    </c:if>
                                                                                </c:if>--%>
                                                                                <c:if test="${countVal.count eq 1}">
                                                                                    <span style='margin-top: 5px;'>
                                                                                        <input type="button" value="+" id="policyCloneid" />
                                                                                    </span>
                                                                                </c:if>
                                                                                <c:if test="${countVal.count ne 1}">
                                                                                    <span style='margin-top: 5px;'>
                                                                                        <input type="button" value="-" onClick="removedefaultpolicy(${countVal.count})" />
                                                                                    </span>
                                                                                </c:if>
                                                                                <%--<c:if test="${!countVal.last}">--%>
                                                                                <%--<c:if test="${!countVal.last}">--%>
                                                                                <!--<span style='margin-top: 5px;'>-->
                                                                                <!--<input type="button" value="-" id="policyRemoveid" onclick="removePolicyEdit(tempCount3)"/>-->
                                                                                <!--</span>-->
                                                                                <%--</c:if>--%>
                                                                                <%--</c:if>--%>
                                                                            </td>
                                                                        </tr>
                                                                    </c:forEach>
                                                                </c:when>
                                                                <c:otherwise>

                                                                    <%--<c:forEach var="comp" items="${finalPolicyList}" varStatus = "countVal">--%>
    <!--                                                                        <input type="hidden" name="countSecond" id="countSecond" value="${fn:length(finalPolicyList)}"/>-->
                                                                    <tr>
                                                                        <td style="text-align: center">1</td>
                                                                        <td><div>
                                                                                <select id="policyId1"  name="policyId1"  class="form-control">
                                                                                    <option value="">--SELECT--</option>
                                                                                    <c:forEach var="policyData" items="${policy}" varStatus = "status">
                                                                                        <option value="${policyData.key}" >${policyData.value}</option>
                                                                                    </c:forEach>
                                                                                </select>
                                                                            </div>
                                                                            <span id="policyError1" style="color: red;"></span>
                                                                        </td>
                                                                        <!--                                                                        <td style="text-align: center">
                                                                                                                                                    <input type="text" name="policyNumber1" id="policyNumber1"  class="form-control"  value="">
                                                                                                                                                </td>-->
                                                                        <td style="text-align: center">
                                                                            
                                                                            <input type="number" name="amount1" id="amount1" value="0" min="0" onchange="changetotalButton();"class="form-control" value="">
                                                                        </td>
                                                                        <td style="text-align: center">
                                                                            <input type="checkbox" name="taxable1" id="taxable1" >
                                                                        </td>
                                                                        <td style="text-align: center">
                                                                            <span style='margin-top: 5px;'>
                                                                                <input type="button" value="+" id="policyCloneid" />
                                                                            </span>
                                                                        </td>
                                                                    </tr>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </table>
                                                    </div>
                                                </div>   
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    <%--
                                                <div class="form-group">
                                                    <div class="col-sm-6">

                                                    </div>
                                                    <div class="col-sm-2">

                                                    </div>
                                                    <div class="col-sm-4">
                                                        <label>Gross Total:<span style="color: red;font-size: 12px;"></span></label>
                                                        <input  id="txtresult" name="txtresult" class="form-control" readonly="true"  />

                                                    </div>
                                                </div>--%>
                                                    
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <!--<label>Total:<span style="color: red;font-size: 12px;"></span></label>-->
                                                        <%--<form:input path="tdsAmount" class="form-control"  placeholder="Enter TDS Amount"/>--%>
                                                        <%--<form:errors path="tdsAmount" cssClass="errorDiv"/>--%>
                                                    </div>
                                                    <div class="col-sm-2">

                                                    </div>
                                                    <div class="col-sm-4">
                                                        <label>Gross Total:<span style="color: red;font-size: 12px;"></span></label>
                                                            <form:input path="grossTotal"  id="txtresult" class="form-control" readonly="true" />
                                                    </div>
                                                </div>
                                                    <%--
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="table-responsive">
                                                        <table id="ctcTable" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                            <tr>
                                                                <th style="text-align: center; vertical-align: middle;width: 5%">Sr.No.</th>
                                                                <th style="text-align: center; vertical-align: middle">Select CTC Component</th>
                                                                <!--<th style="text-align: center; vertical-align: middle">Policy Number</th>-->
                                                                <th style="text-align: center; vertical-align: middle">Amount</th>
                                                                <th style="text-align: center; vertical-align: middle">Taxable</th>
                                                                <th style="text-align: center; vertical-align: middle">Month</th>
                                                                <th style="text-align: center; vertical-align: middle">Year</th>
                                                                <th style="text-align: center; vertical-align: middle">Add New</th>
                                                            <input type="hidden" name="ctcCount" id="ctcCount" value="1"/>
                                                            </tr>
                                                            <tr>
                                                                <td style="text-align: center">1</td>
                                                                <td id="policyTd1"><div>
                                                                        <select id="ctcId1"  name="ctcId1"  class="form-control">
                                                                            <option value="">--SELECT--</option>
                                                                            <c:forEach var="comp" items="${ctc}" varStatus = "status">
                                                                                <option value="${comp.key}">${comp.value}</option>
                                                                            </c:forEach>
                                                                        </select>
                                                                    </div>
                                                                    <span id="ctcError1" style="color: red;"></span>
                                                                </td>
                                                                <!--                                                                <td style="text-align: center">
                                                                                                                                    <input type="text" name="policyNumber1" id="policyNumber1"  class="form-control">
                                                                                                                                </td>-->
                                                                <td style="text-align: center">
                                                                    <input type="number" name="ctcamount1" id="ctcamount1" min="0" onchange="changetotalButtonCTC();"class="form-control" >
                                                                </td>
                                                                <td style="text-align: center">
                                                                    <input type="checkbox" name="ctctaxable1" id="ctctaxable1" >
                                                                </td>
                                                                <td id="monthTd1"><div>
                                                                        <!--<label>Months:<span style="color: red;font-size: 12px;">*</span></label>-->
                                                                        <%--<form:input path="bloodGroups" class="form-control"></form:input>-->
                                                                        <select id="month1" name="month1"  class="form-control ">
                                                                            <option value="">--Select--</option>
                                                                            <option value="01">January</option>
                                                                            <option value="02">February</option>
                                                                            <option value="03">March </option>
                                                                            <option value="04">April</option>
                                                                            <option value="05">May</option>
                                                                            <option value="06">June</option>
                                                                            <option value="07">July</option>
                                                                            <option value="08">August</option>
                                                                            <option value="09">September</option>
                                                                            <option value="10">October </option>
                                                                            <option value="11">November </option>
                                                                            <option value="12">December</option>

                                                                        </select>
                                                                    </div>
                                                                </td>

                                                                <td style="text-align: center">

                                                                    <select name="year1" id="year1" class="form-control ">

                                                                    </select>
                                                                </td>
                                                                <td style="text-align: center">
                                                                    <span style='margin-top: 5px;'>
                                                                        <input type="button" value="+" id="ctcCloneid" />
                                                                    </span>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>--%>
                                                                        
                                                 <%-- ----------------------------------------------------- --%>
                                                 
                                                 <div class="col-md-12 col-sm-12">
                                                    <div class="table-responsive">
                                                        <table id="ctcTable" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                            <tr>
                                                                <th style="text-align: center; vertical-align: middle;width: 5%">Sr.No.</th>
                                                                <th style="text-align: center; vertical-align: middle">Select CTC Component</th>
                                                                <!--<th style="text-align: center; vertical-align: middle">Policy Number</th>-->
                                                                <th style="text-align: center; vertical-align: middle">Amount</th>
                                                                <th style="text-align: center; vertical-align: middle">Taxable</th>
                                                                <th style="text-align: center; vertical-align: middle">Month</th>
                                                                <th style="text-align: center; vertical-align: middle">Year</th>
                                                                <th style="text-align: center; vertical-align: middle">Add New</th>
                                                                    <c:choose>
                                                                        <c:when test="${not empty finalPolicyList}">
                                                                    <input type="hidden" name="ctcCount" id="ctcCount"  value="${fn:length(finalctcList)}"/>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <input type="hidden" name="ctcCount" id="ctcCount"  value="1"/>
                                                                </c:otherwise>
                                                            </c:choose>
                                                            </tr>
                                                            <td>
                                                                <!--   <input type="radio" name="taxable" id="taxable" onClick="onClickFunction();" >
                                                               <input type="button" id="checkboxID">-->
                                                            </td>
                                                            <c:choose>
                                                                <c:when test="${not empty finalctcList}">
                                                                    <c:forEach var="comp" items="${finalctcList}" varStatus = "countVal">
                                                                        <input type="hidden" name="countSecond" id="countSecond" value="${fn:length(finalctcList)}"/>

                                                                        <tr id="removectcDefault${countVal.count}">


                                                                            <td style="text-align: center">${countVal.count}</td>
                                                                            <td><div>

                                                                                    <select id="ctcId${countVal.count}"  name="ctcId${countVal.count}"  class="form-control">
                                                                                        <option value="">--SELECT--</option>
                                                                                        <c:forEach var="policyData" items="${ctc}" varStatus = "status">
                                                                                            <c:choose>
                                                                                                <c:when test="${comp[1] == policyData.value}">
                                                                                                    <option value="${policyData.key}" selected="selected">${comp[1]}</option>
                                                                                                </c:when>
                                                                                                <c:otherwise>
                                                                                                    <option value="${policyData.key}" >${policyData.value}</option>
                                                                                                </c:otherwise>
                                                                                            </c:choose>
                                                                                        </c:forEach>
                                                                                    </select>
                                                                                </div>
                                                                                <span id="ctcError${countVal.count}" style="color: red;"></span>
                                                                            </td>
                                                                            <!--</td>-->
                                                                            <!--                                                                            <td style="text-align: center">
                                                                                                                                                            <input type="text" name="policyNumber${countVal.count}" id="policyNumber${countVal.count}"  class="form-control"  value="${comp[2]}">
                                                                                                                                                        </td>-->

                                                                            <c:choose>
                                                                                <c:when test="${!empty comp[2] }">
                                                                                    <td style="text-align: center">
                                                                                        <input type="number" name="ctcamount${countVal.count}" id="ctcamount${countVal.count}" min="0" onchange="changetotalButtonNewCTC(${countVal.count});" class="form-control" value="${comp[2]}">
                                                                                        <script>//console.log("comp not empty@"+ ${comp[2]} );</script>
                                                                                    </td>
                                                                                </c:when>
                                                                                <c:otherwise>
                                                                                    <td style="text-align: center">
                                                                                        <input type="number" name="ctcamount${countVal.count}" id="ctcamount${countVal.count}" min="0" onchange="changetotalButtonNewCTC(${countVal.count});" class="form-control" value="0">
                                                                                        <script>//console.log("comp empty");</script>
                                                                                    </td>
                                                                                </c:otherwise>
                                                                            </c:choose>



                                                                            <c:if test="${comp[3] eq 1}">
                                                                                <td style="text-align: center">
                                                                                    <input type="checkbox" name="taxablectc${countVal.count}" id="taxablectc${countVal.count}" checked="true" value="off" >
                                                                                </td>
                                                                            </c:if>
                                                                            <c:if test="${comp[3] ne 1}">
                                                                                <td style="text-align: center">
                                                                                    <input type="checkbox" name="taxablectc${countVal.count}" id="taxablectc${countVal.count}" value="off" >
                                                                                </td>
                                                                            </c:if>



                                                                        <script>//console.log("Taxable: "+ ${comp[3]} );</script>
                                                                        <td ><div>
                                                                                <!--<label>Months:<span style="color: red;font-size: 12px;">*</span></label>-->
                                                                                <%--<form:input path="bloodGroups" class="form-control"></form:input>--%>
                                                                                <select id="month${countVal.count}" name="month${countVal.count}"  class="form-control ">

                                                                                    <c:choose>

                                                                                        <c:when test="${comp[4] eq 01}">
                                                                                            <!--<option value="01" selected="selected">January</option>-->
                                                                                            <option value="01" selected="selected">January</option>
                                                                                            <option value="02">February</option>
                                                                                            <option value="03">March </option>
                                                                                            <option value="04">April</option>
                                                                                            <option value="05">May</option>
                                                                                            <option value="06">June</option>
                                                                                            <option value="07">July</option>
                                                                                            <option value="08">August</option>
                                                                                            <option value="09">September</option>
                                                                                            <option value="10">October </option>
                                                                                            <option value="11">November </option>
                                                                                            <option value="12">December</option>
                                                                                        </c:when>
                                                                                        <c:when test="${comp[4] eq 02}">
                                                                                            <!--<option value="02" selected="selected">February</option>-->
                                                                                            <option value="01">January</option>
                                                                                            <option value="02" selected="selected">February</option>
                                                                                            <option value="03">March </option>
                                                                                            <option value="04">April</option>
                                                                                            <option value="05">May</option>
                                                                                            <option value="06">June</option>
                                                                                            <option value="07">July</option>
                                                                                            <option value="08">August</option>
                                                                                            <option value="09">September</option>
                                                                                            <option value="10">October </option>
                                                                                            <option value="11">November </option>
                                                                                            <option value="12">December</option>
                                                                                        </c:when>
                                                                                        <c:when test="${comp[4] eq 03}">
                                                                                            <!--<option value="03" selected="selected">March</option>-->
                                                                                            <option value="01">January</option>
                                                                                            <option value="02">February</option>
                                                                                            <option value="03" selected="selected">March </option>
                                                                                            <option value="04">April</option>
                                                                                            <option value="05">May</option>
                                                                                            <option value="06">June</option>
                                                                                            <option value="07">July</option>
                                                                                            <option value="08">August</option>
                                                                                            <option value="09">September</option>
                                                                                            <option value="10">October </option>
                                                                                            <option value="11">November </option>
                                                                                            <option value="12">December</option>
                                                                                        </c:when>
                                                                                        <c:when test="${comp[4] eq 04}">
                                                                                            <!--<option value="04" selected="selected">April</option>-->
                                                                                            <option value="01">January</option>
                                                                                            <option value="02">February</option>
                                                                                            <option value="03">March </option>
                                                                                            <option value="04" selected="selected">April</option>
                                                                                            <option value="05">May</option>
                                                                                            <option value="06">June</option>
                                                                                            <option value="07">July</option>
                                                                                            <option value="08">August</option>
                                                                                            <option value="09">September</option>
                                                                                            <option value="10">October </option>
                                                                                            <option value="11">November </option>
                                                                                            <option value="12">December</option>
                                                                                        </c:when>
                                                                                        <c:when test="${comp[4] eq 05}">
                                                                                            <!--<option value="05" selected="selected">May</option>-->
                                                                                            <option value="01">January</option>
                                                                                            <option value="02">February</option>
                                                                                            <option value="03">March </option>
                                                                                            <option value="04">April</option>
                                                                                            <option value="05" selected="selected">May</option>
                                                                                            <option value="06">June</option>
                                                                                            <option value="07">July</option>
                                                                                            <option value="08">August</option>
                                                                                            <option value="09">September</option>
                                                                                            <option value="10">October </option>
                                                                                            <option value="11">November </option>
                                                                                            <option value="12">December</option>
                                                                                        </c:when>
                                                                                        <c:when test="${comp[4] eq 06}">
                                                                                            <!--<option value="06" selected="selected">June</option>-->
                                                                                            <option value="01">January</option>
                                                                                            <option value="02">February</option>
                                                                                            <option value="03">March </option>
                                                                                            <option value="04">April</option>
                                                                                            <option value="05">May</option>
                                                                                            <option value="06" selected="selected">June</option>
                                                                                            <option value="07">July</option>
                                                                                            <option value="08">August</option>
                                                                                            <option value="09">September</option>
                                                                                            <option value="10">October </option>
                                                                                            <option value="11">November </option>
                                                                                            <option value="12">December</option>
                                                                                        </c:when>
                                                                                        <c:when test="${comp[4] eq 07}">
                                                                                            <!--<option value="07" selected="selected">July</option>-->
                                                                                            <option value="01">January</option>
                                                                                            <option value="02">February</option>
                                                                                            <option value="03">March </option>
                                                                                            <option value="04">April</option>
                                                                                            <option value="05">May</option>
                                                                                            <option value="06">June</option>
                                                                                            <option value="07" selected="selected">July</option>
                                                                                            <option value="08">August</option>
                                                                                            <option value="09">September</option>
                                                                                            <option value="10">October </option>
                                                                                            <option value="11">November </option>
                                                                                            <option value="12">December</option>
                                                                                        </c:when>
                                                                                        <c:when test="${comp[4] eq 08}">
                                                                                            <!--<option value="08" selected="selected">August</option>-->
                                                                                            <option value="01">January</option>
                                                                                            <option value="02">February</option>
                                                                                            <option value="03">March </option>
                                                                                            <option value="04">April</option>
                                                                                            <option value="05">May</option>
                                                                                            <option value="06">June</option>
                                                                                            <option value="07">July</option>
                                                                                            <option value="08" selected="selected">August</option>
                                                                                            <option value="09">September</option>
                                                                                            <option value="10">October </option>
                                                                                            <option value="11">November </option>
                                                                                            <option value="12">December</option>
                                                                                        </c:when>
                                                                                        <c:when test="${comp[4] eq 09}">
                                                                                            <!--<option value="09" selected="selected">September</option>-->
                                                                                            <option value="01">January</option>
                                                                                            <option value="02">February</option>
                                                                                            <option value="03">March </option>
                                                                                            <option value="04">April</option>
                                                                                            <option value="05">May</option>
                                                                                            <option value="06">June</option>
                                                                                            <option value="07">July</option>
                                                                                            <option value="08">August</option>
                                                                                            <option value="09" selected="selected">September</option>
                                                                                            <option value="10">October </option>
                                                                                            <option value="11">November </option>
                                                                                            <option value="12">December</option>
                                                                                        </c:when>
                                                                                        <c:when test="${comp[4] eq 10}">
                                                                                            <!--<option value="10" selected="selected">October</option>-->
                                                                                            <option value="01">January</option>
                                                                                            <option value="02">February</option>
                                                                                            <option value="03">March </option>
                                                                                            <option value="04">April</option>
                                                                                            <option value="05">May</option>
                                                                                            <option value="06">June</option>
                                                                                            <option value="07">July</option>
                                                                                            <option value="08">August</option>
                                                                                            <option value="09">September</option>
                                                                                            <option value="10" selected="selected">October </option>
                                                                                            <option value="11">November </option>
                                                                                            <option value="12">December</option>
                                                                                        </c:when>
                                                                                        <c:when test="${comp[4] eq 11}">
                                                                                            <!--<option value="11" selected="selected">November</option>-->
                                                                                            <option value="01">January</option>
                                                                                            <option value="02">February</option>
                                                                                            <option value="03">March </option>
                                                                                            <option value="04">April</option>
                                                                                            <option value="05">May</option>
                                                                                            <option value="06">June</option>
                                                                                            <option value="07">July</option>
                                                                                            <option value="08">August</option>
                                                                                            <option value="09">September</option>
                                                                                            <option value="10">October </option>
                                                                                            <option value="11" selected="selected">November </option>
                                                                                            <option value="12">December</option>
                                                                                        </c:when>
                                                                                        <c:when test="${comp[4] eq 12}">
                                                                                            <!--<option value="12" selected="selected">December</option>-->
                                                                                            <option value="01">January</option>
                                                                                            <option value="02">February</option>
                                                                                            <option value="03">March </option>
                                                                                            <option value="04">April</option>
                                                                                            <option value="05">May</option>
                                                                                            <option value="06">June</option>
                                                                                            <option value="07">July</option>
                                                                                            <option value="08">August</option>
                                                                                            <option value="09">September</option>
                                                                                            <option value="10">October </option>
                                                                                            <option value="11">November </option>
                                                                                            <option value="12" selected="selected">December</option>
                                                                                        </c:when>
                                                                                        <c:when test="${empty comp[4] }">
                                                                                            <option value="">--Select--</option>
                                                                                            <option value="01">January</option>
                                                                                            <option value="02">February</option>
                                                                                            <option value="03">March </option>
                                                                                            <option value="04">April</option>
                                                                                            <option value="05">May</option>
                                                                                            <option value="06">June</option>
                                                                                            <option value="07">July</option>
                                                                                            <option value="08">August</option>
                                                                                            <option value="09">September</option>
                                                                                            <option value="10">October </option>
                                                                                            <option value="11">November </option>
                                                                                            <option value="12">December</option>
                                                                                        </c:when>
                                                                                        <c:otherwise>
                                                                                            <option value="">--Select--</option>
                                                                                            <option value="01">January</option>
                                                                                            <option value="02">February</option>
                                                                                            <option value="03">March </option>
                                                                                            <option value="04">April</option>
                                                                                            <option value="05">May</option>
                                                                                            <option value="06">June</option>
                                                                                            <option value="07">July</option>
                                                                                            <option value="08">August</option>
                                                                                            <option value="09">September</option>
                                                                                            <option value="10">October </option>
                                                                                            <option value="11">November </option>
                                                                                            <option value="12">December</option>
                                                                                        </c:otherwise>
                                                                                    </c:choose>


                                                                                </select>
                                                                            </div>
                                                                        </td>
                                                                        <td>
                                                                            <div>

                                                                                <!-- ------------------------------------ -->
                                                                                <script>
                                                                                    //console.log("NOT Empty...@@"+${comp[5]});
                                                                                    //var year1Data = document.getElementById("year1").value;
                                                                                </script>
                                                                                <input  type="hidden" class="form-control" id="yearBase" value="${comp[5]}">

           <!--  <input type="number" name="year${countVal.count}" id="year${countVal.count}" min="0" class="form-control"  value="${comp[5]}">
                                                                                --> <script>
                                                                                    //    console.log("NOT Empty...@@"+${comp[5]});
                                                                                </script>



                                                                                <select name="year${countVal.count}" id="year${countVal.count}"  class="form-control" >

                                                                                    <!-- <script>
                                                                                     var start = new Date().getFullYear();
                                                                                     var end = start+50;
                                                                                     var options11 = "";
                                                                                     for (var yearloop = start; yearloop <= end; yearloop++) {
                                                                                         optiosLoop = "<option> name=\"year${countVal.count}\" id=\"year${countVal.count}\" value="+yearloop+">yearloop "</option>";
                                                                                         
                                                                                         document.getElementById('year'+tempCount4).innerHTML = optiosLoop;
                                                                                     }
                                                                                     //                alert(tempCount4);
                                                                                    </script>-->

                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="${comp[5]}">${comp[5]}</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2018">2018</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2019">2019</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2020">2020</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2021">2021</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2022">2022</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2023">2023</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2024">2024</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2025">2025</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2026">2026</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2027">2027</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2028">2028</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2029">2029</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2030">2030</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2031">2031</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2032">2032</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2033">2033</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2034">2034</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2035">2035</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2036">2036</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2037">2037</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2038">2038</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2039">2039</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2040">2040</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2041">2041</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2042">2042</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2043">2043</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2044">2044</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2045">2045</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2046">2046</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2047">2047</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2048">2048</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2049">2049</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2050">2050</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2051">2051</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2052">2052</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2053">2053</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2054">2054</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2055">2055</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2056">2056</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2057">2057</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2058">2058</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2059">2059</option> 
                                                                                    <option  name="year${countVal.count}" id="year${countVal.count}"  value="2060">2060</option> 


                                                                                    <script>//initDropdownList( 'year2' );</script>
                                                                                    </select><!--onchange="changeAmountButtonNewCTC(${countVal.count});"-->
                                                                                <!-- ------------------------------------ -->


                                                                            </div>
                                                                        </td>




                                                                        <td style="text-align: center">
                                                                            <%--<c:choose>--%>
                                                                            <%--<c:when test="${countVal.first}">--%>
                                                                            <!--<span style='margin-top: 5px;'>-->
                                                                            <!--<input type="button" value="+" id="policyCloneid" />-->
                                                                            <!--</span>-->
                                                                            <%--</c:if>--%>
                                                                            <%--</c:when>--%>
                                                                            <%--<c:otherwise>--%>
                                                                            <!--<span style='margin-top: 5px;'>-->
                                                                            <!--<input type="button" value="-" id="policyRemoveid" onclick="removeForEdit()"/>-->
                                                                            <!--</span>-->
                                                                            <%--</c:otherwise>--%>
                                                                            <%--<c:when test="${countVal.last}">--%>
                                                                            <%--<c:if test="${countVal.last}">
                                                                                <span style='margin-top: 5px;'>
                                                                                    <input type="button" value="+" id="ctcCloneid" />
                                                                                </span>
                                                                            </c:if>--%>

                                                                            <c:if test="${countVal.count eq 1}">
                                                                                <span style='margin-top: 5px;'>
                                                                                    <input type="button" value="+" id="ctcCloneid" />
                                                                                </span>
                                                                            </c:if>
                                                                            <c:if test="${countVal.count ne 1}">
                                                                                <span style='margin-top: 5px;'>
                                                                                    <input type="button" value="-" onClick="removedefaultctc(${countVal.count})" />
                                                                                </span>
                                                                            </c:if>


                                                                        </td>
                                                                        </tr>
                                                                    </c:forEach>
                                                                </c:when>
                                                                <c:otherwise>

                                                                    <%--<c:forEach var="comp" items="${finalPolicyList}" varStatus = "countVal">--%>
                                                                            <!--<input type="hidden" name="countSecond" id="countSecond" value="${fn:length(finalPolicyList)}"/>-->
                                                                    <tr>

                                                                        <td style="text-align: center">1</td>
                                                                        <td><div>
                                                                                <select id="ctcId1"  name="ctcId1"  class="form-control">
                                                                                    <option value="">--SELECT--</option>
                                                                                    <c:forEach var="policyData" items="${ctc}" varStatus = "status">
                                                                                        <option value="${policyData.key}" >${policyData.value}</option>
                                                                                    </c:forEach>
                                                                                </select>
                                                                            </div>
                                                                            <span id="ctcError1" style="color: red;"></span>
                                                                        </td>
                                                                        <!--                                                                        <td style="text-align: center">
                                                                                                                                                    <input type="text" name="policyNumber1" id="policyNumber1"  class="form-control"  value="">
                                                                                                                                                </td>-->
                                                                        <td style="text-align: center">
                                                                            <input type="number" name="ctcamount1" id="ctcamount1" min="0" onchange="changetotalButtonCTC();"class="form-control" value="0">
                                                                        </td>
                                                                        <td style="text-align: center">
                                                                            <input type="checkbox" name="taxablectc1" id="taxablectc1" >
                                                                        </td>
                                                                        <td id="monthTd1"><div>
                                                                                <!--<label>Months:<span style="color: red;font-size: 12px;">*</span></label>-->
                                                                                <%--<form:input path="bloodGroups" class="form-control"></form:input>--%>
                                                                                <select id="month1" name="month1"  class="form-control ">
                                                                                    <option value="">--Select--</option>
                                                                                    <option value="01">January</option>
                                                                                    <option value="02">February</option>
                                                                                    <option value="03">March </option>
                                                                                    <option value="04">April</option>
                                                                                    <option value="05">May</option>
                                                                                    <option value="06">June</option>
                                                                                    <option value="07">July</option>
                                                                                    <option value="08">August</option>
                                                                                    <option value="09">September</option>
                                                                                    <option value="10">October </option>
                                                                                    <option value="11">November </option>
                                                                                    <option value="12">December</option>

                                                                                </select>
                                                                            </div>
                                                                        </td>
                                                                        <td style="text-align: center">

                                                                            <select id="year1" name="year1" class="form-control "><!--Select-->



                                                                                <option  name="year${countVal.count}" id="year${countVal.count}"  value="2018">2018</option> 
                                                                                <option  name="year${countVal.count}" id="year${countVal.count}"  value="2019">2019</option> 
                                                                                <option  name="year${countVal.count}" id="year${countVal.count}"  value="2020">2020</option> 
                                                                                <option  name="year${countVal.count}" id="year${countVal.count}"  value="2021">2021</option> 
                                                                                <option  name="year${countVal.count}" id="year${countVal.count}"  value="2022">2022</option> 
                                                                                <option  name="year${countVal.count}" id="year${countVal.count}"  value="2023">2023</option> 
                                                                                <option  name="year${countVal.count}" id="year${countVal.count}"  value="2024">2024</option> 
                                                                                <option  name="year${countVal.count}" id="year${countVal.count}"  value="2025">2025</option> 
                                                                                <option  name="year${countVal.count}" id="year${countVal.count}"  value="2026">2026</option> 
                                                                                <option  name="year${countVal.count}" id="year${countVal.count}"  value="2027">2027</option> 
                                                                                <option  name="year${countVal.count}" id="year${countVal.count}"  value="2028">2028</option> 
                                                                                <option  name="year${countVal.count}" id="year${countVal.count}"  value="2029">2029</option> 
                                                                                <option  name="year${countVal.count}" id="year${countVal.count}"  value="2030">2030</option> 
                                                                                <option  name="year${countVal.count}" id="year${countVal.count}"  value="2031">2031</option> 
                                                                                <option  name="year${countVal.count}" id="year${countVal.count}"  value="2032">2032</option> 
                                                                                <option  name="year${countVal.count}" id="year${countVal.count}"  value="2033">2033</option> 
                                                                                <option  name="year${countVal.count}" id="year${countVal.count}"  value="2034">2034</option> 
                                                                                <option  name="year${countVal.count}" id="year${countVal.count}"  value="2035">2035</option> 
                                                                                <option  name="year${countVal.count}" id="year${countVal.count}"  value="2036">2036</option> 
                                                                                <option  name="year${countVal.count}" id="year${countVal.count}"  value="2037">2037</option> 
                                                                            </select>
                                                                        </td>
                                                                        <td style="text-align: center">
                                                                            <span style='margin-top: 5px;'>
                                                                                <input type="button" value="+" id="ctcCloneid" />
                                                                            </span>
                                                                        </td>
                                                                    </tr>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </table>
                                                    </div>
                                                </div>
                                                                        
                                                                        
                                                                        
                                                <div class="form-group">
                                                    <div class="col-sm-6">

                                                    </div>
                                                    <div class="col-sm-2">

                                                    </div>
                                                    <div class="col-sm-4">
                                                        <label>CTC Total:<span style="color: red;font-size: 12px;"></span></label>
                                                        <input id="txtresultCTC" name="txtresultCTC" class="form-control" readonly="true"  />

                                                    </div>
                                                </div>
                                                <div class="col-md-12 col-sm-12">
                                                    <label>JOB Description:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:textarea  path="jobDescription" id="editor"></form:textarea>
                                                    <form:errors path="jobDescription" cssClass="errorDiv"/>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                                <!--organization detail completes here-->



                                <div class="box box-info collapsed-box" id="empInfo_id">
                                    <div class="box-header">
                                        <h3 class="box-title">Employee's Bank Account Detail:</h3>
                                        <div class="box-tools pull-right">
                                            <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                            <span id="spanId7">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun7();"><i class="fa fa-plus" id="minusId7"></i></button>
                                        </div>
                                    </div>
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Bank Name:</label>
                                                        <form:input path="bankName" class="form-control"></form:input>
                                                        <form:errors path="bankName" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label>Bank Account No.:</label>
                                                        <form:input path="bankAccountNo" class="form-control"></form:input>
                                                        <form:errors path="bankAccountNo" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>IFSC Code:</label>
                                                        <form:input path="bankIfscCode" class="form-control" placeholder="(1-4: alphabets, 5th: reserved as 0, 6-11: digits) Example: SBIN0898965"></form:input>
                                                        <form:errors path="bankIfscCode" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Payment Type:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:select path="paymentType" id="paymentType" class="form-control ">
                                                            <option value="">--Select--</option>
                                                            <form:option value="Bank">Bank</form:option>
                                                            <form:option value="Check">Check</form:option>

                                                        </form:select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>PF No(Previous):<span style="color: red;font-size: 12px;"></span></label>
                                                            <form:input path="pfNo" id="pfNo" class="form-control"></form:input>
                                                            <%--<form:errors path="pfNo" cssClass="errorDiv"></form:errors>--%>
                                                    </div>
                                                    <div class="col-sm-6">

                                                        <label>PF No(VNC):<span style="color: red;font-size: 12px;"></span></label>
                                                        <input type="text" name="pfNoFlydocs" id="pfNoFlydocs" value="${pfNoFlydocs}" class="form-control">

                                                    </div>  
                                                </div>  
                                                <div class="form-group">
                                                    <div class="col-sm-6">

                                                        <label>PF Withdrawal Date:</label>
                                                        <div class="input-group date form_datetime_passport_issue"  data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <input type="text" name="withdrawalDate" id="withdrawalDate" value="${withdrawalDate}" size="16" readonly="true" class="form-control">
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>

                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>UAN No:<span style="color: red;font-size: 12px;"></span></label>
                                                            <form:input path="uanNo" id="uanNo"  class="form-control"></form:input>
                                                            <%--<form:errors path="uanNo" cssClass="errorDiv"></form:errors>--%>
                                                    </div> 

                                                </div>
                                            </div>
                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->
                                <!--bank detail complete-->
                                <div class="box box-info collapsed-box" id="reporting_level_id">
                                    <div class="box-header">
                                        <h3 class="box-title">Reporting Detail:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId5">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun5();"><i class="fa fa-plus" id="minusId5" ></i></button>
                                            <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <!--<label class="col-sm-2 control-label" style="float: left;">Reporting Manager:</label>-->
                                                    <!--                                                        <div class="col-sm-12">
                                                                                                                <label>Reporting Manager:</label>
                                                                                                            </div>-->
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6" id="levelIdDiv1">
                                                        <label>Reporting Manager:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="reportingManagerLevel1" class="form-control" onchange="reportingLevelSet();"></form:input>
                                                        <form:errors path="reportingManagerLevel1" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class="col-sm-6" id="levelIdDiv2" >
                                                            <label>Level 2:</label>
                                                        <form:hidden path="reportingManagerLevel2"></form:hidden>
                                                            <input type="text" name="reportingManagerLevel2Name" id="reportingManagerLevel2Name" class="form-control" readonly="true"/>
                                                        </div>
                                                    </div>
                                                    <div>
                                                        <div class="form-group">
                                                            <div class="col-sm-6" id="levelIdDiv3">
                                                                <label>Level 3:</label>
                                                            <form:hidden path="reportingManagerLevel3"></form:hidden>
                                                                <input type="text" name="reportingManagerLevel3Name" id="reportingManagerLevel3Name" class="form-control" readonly="true"/>
                                                            </div>

                                                            <div class="col-sm-6" id="levelIdDiv4">
                                                                <label>Level 4:</label>
                                                            <form:hidden path="reportingManagerLevel4"></form:hidden>
                                                                <input type="text" name="reportingManagerLevel4Name" id="reportingManagerLevel4Name" class="form-control" readonly="true"/>
                                                            </div>
                                                        </div>
                                                        <div class="form-group" id="levelIdDiv5">
                                                            <div class="col-sm-6">
                                                                <label>Functional Head:</label>
                                                            <form:hidden path="reportingManagerLevel5"></form:hidden>
                                                                <input type="text" name="reportingManagerLevel5Name" id="reportingManagerLevel5Name" class="form-control" readonly="true"/>
                                                            </div>

                                                            <div class="col-sm-6" id="levelIdDiv6">
                                                                <label>CEO/Proprietor/MD:</label>
                                                            <form:hidden path="reportingManagerLevel6"></form:hidden>
                                                                <input type="text" name="reportingManagerLevel6Name" id="reportingManagerLevel6Name" class="form-control" readonly="true"/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <!--Reporting Detail completes Here-->
                                    <div class="box box-info collapsed-box" id="login_detail_id">
                                        <div class="box-header">
                                            <h3 class="box-title">Login Detail:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId6">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun6();"><i class="fa fa-plus" id="minusId6" ></i></button>
                                                <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">

                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>UserName:</label>
                                                            <input name="userName" id="userName" type="text" readonly="" class="form-control"></input>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label>Password:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="userMaster.password" class="form-control" ></form:input>
                                                        <form:errors path="userMaster.password" cssClass="errorDiv"></form:errors>

                                                            <!--<input type="password" name="password" id="password" class="form-control"></input>-->
                                                        <%--<form:input path="reasonForLeaving" type="password" class="form-control"></form:input>--%>
                                                        <%--<form:errors path="reasonForLeaving" cssClass="errorDiv"></form:errors>--%>
                                                        <!--<input name="password" id="password" type="text" class="form-control" onsubmit="return checkvalue(this)"></input>-->
                                                        <!--<span style="font-size: 14px; color: red;" id="passError"></span>-->
                                                        <div id="passError"></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="box box-info collapsed-box" id="login_detail_id">
                                    <div class="box-header">
                                        <h3 class="box-title">Employee Certificate Attachments:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId8">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun8();"><i class="fa fa-plus" id="minusId8" ></i></button>
                                            <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">

                                                <div class="form-group">
                                                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                        <tr>
                                                            <th style="text-align: center;width:55px">Sr No.</th>
                                                            <th style="text-align: center;">Certificate Attach</th>
                                                            <th style="text-align: center;width:55px"></th>
                                                        </tr>
                                                        <input type="hidden" name="firstStepCount" id="firstStepCount" value="1">
                                                        <tr id="cloneTr_Id">
                                                            <td style="text-align: center">1</td>
                                                            <td>
                                                                <input type="file" class="form-control" id="certificateId1" name="certificateId1" accept="image/jpg,image/jpeg,image/png" onchange="checkCertificateFileSize(1);">
                                                                <span style="font-size: 14px; color: red;" id="certificateError"></span>
                                                            </td>
                                                            <td style="text-align: center"><span style='margin-top: 5px;'>
                                                                    <input type="button" value="+" id="step1cloneid" />  </span>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class=" col-sm-6 col-sm-offset-5">
                                        <button type="submit" class="btn btn-primary" style="width: 100px;" data-original-title="" title="" >SUBMIT</button>
                                    </div>
                                </div>

                                <div class="tab-pane" id="tab_3"></div>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
    </div>
</section>
</form:form>
</div>

<script type="text/javascript">
    $('.form_datetime').datetimepicker({
        //language:  'fr',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });</script>
<script type="text/javascript">
    $('.form_datetime_shift_rotation').datetimepicker({
        //language:  'fr',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0,
        startDate: new Date()
    });</script>

<script type="text/javascript">
    var dt = new Date();
    dt.setFullYear(new Date().getFullYear() - 18);
    var dt1 = new Date();
    dt1.setFullYear(new Date().getFullYear() - 100);
    $('.form_datetime_dob').datetimepicker({
        //language:  'fr',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        startDate: dt1,
        endDate: dt,
        forceParse: 0
    });</script>

<script type="text/javascript">
    var dt = new Date();
    dt.setFullYear(new Date().getFullYear() - 10);
    var dt1 = new Date();
    dt1.setFullYear(new Date().getFullYear() + 10);
    $('.form_datetime_passport_issue').datetimepicker({
        //language:  'fr',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        startDate: dt,
        endDate: dt1,
        forceParse: 0
    });</script>

<script type="text/javascript">
    var dt = new Date();
    var dt1 = new Date();
    dt1.setFullYear(new Date().getFullYear() + 10);
    $('.form_datetime_passport_expiry').datetimepicker({
        //language:  'fr',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        startDate: dt,
        endDate: dt1,
        forceParse: 0
    });</script>

<script>
    jQuery.noConflict();
    jQuery(document).ready(function () {
        jQuery("#reportingManagerLevel1").tokenInput(${list}, {
            preventDuplicates: true,
            noResultsText: "No Result",
            tokenLimit: "1",
            searchingText: "Searching ......",
            prePopulate: ${preList}

        });
    });
    jQuery(document).ready(function () {
        reportingLevelSet();
    });
    function reportingLevelSet() {
        var level = document.getElementById("reportingManagerLevel1").value;
        if (level != null && level != '') {
            $.ajax({
                url: 'employeeMaster.htm?act=readReportingHierarchy&id=' + level,
                type: 'GET',
                success: function (result) {
                    //                        alert("this is result String    " + result);
                    var array = result.split("~");
                    //blank whole fields before put new data
                    document.getElementById("reportingManagerLevel2").value = '';
                    document.getElementById("reportingManagerLevel3").value = '';
                    document.getElementById("reportingManagerLevel4").value = '';
                    document.getElementById("reportingManagerLevel5").value = '';
                    document.getElementById("reportingManagerLevel6").value = '';
                    document.getElementById("reportingManagerLevel2Name").value = '';
                    document.getElementById("reportingManagerLevel3Name").value = '';
                    document.getElementById("reportingManagerLevel4Name").value = '';
                    document.getElementById("reportingManagerLevel5Name").value = '';
                    document.getElementById("reportingManagerLevel6Name").value = '';
                    document.getElementById("reportingManagerLevel2").value = array[0];
                    document.getElementById("reportingManagerLevel3").value = array[1];
                    document.getElementById("reportingManagerLevel4").value = array[2];
                    //this conditions checks for level 5 and level 6 if these are empty then set conditional values(for id in databese)
                    if ((array[4] == "" || array[4] == null) && (array[5] == "" || array[5] == null)) {
                        if (array[2] == "" || array[2] == null) {
                            document.getElementById("reportingManagerLevel6").value = level;
                        } else {
                            document.getElementById("reportingManagerLevel5").value = level;
                            document.getElementById("reportingManagerLevel6").value = array[2];
                        }
                    } else {
                        //                            document.getElementById("reportingManagerLevel5").value = level;
                        if (array[4] == "" || array[4] == null) {
                            document.getElementById("reportingManagerLevel5").value = level;

                        } else {
                            document.getElementById("reportingManagerLevel5").value = array[4];
                        }
                        document.getElementById("reportingManagerLevel6").value = array[5];
                        //                            if (array[4] != "" || array[4] != null) {

                        //                            }

                    }
                    document.getElementById("reportingManagerLevel2Name").value = array[6];
                    document.getElementById("reportingManagerLevel3Name").value = array[7];
                    document.getElementById("reportingManagerLevel4Name").value = array[8];
                    //this conditions checks for level 5 and level 6 if these are empty then set conditional values(for values display on jsp)
                    if ((array[10] == "" || array[10] == null) && (array[11] == "" || array[11] == null)) {
                        if (array[6] == "" || array[6] == null) {
                            document.getElementById("reportingManagerLevel6Name").value = array[12];
                            //array[12] is for employee name od reporting manager.
                        } else {
                            document.getElementById("reportingManagerLevel5Name").value = array[12];
                            document.getElementById("reportingManagerLevel6Name").value = array[6];
                        }
                    } else {
                        if (array[10] == "" || array[10] == null) {
                            document.getElementById("reportingManagerLevel5Name").value = array[12];

                        } else {
                            document.getElementById("reportingManagerLevel5Name").value = array[10];
                        }
                        document.getElementById("reportingManagerLevel6Name").value = array[11];
                    }
                }
            });
        }
    }

    //        jQuery(document).ready(function () {
    //            jQuery("#reportingManagerLevel2").tokenInput(${list}, {
    //                preventDuplicates: true,
    //                noResultsText: "No Result",
    //                tokenLimit: "1",
    //                searchingText: "Searching ... .. .",
    //            });
    //        });
    //        jQuery(document).ready(function () {
    //            jQuery("#reportingManagerLevel3").tokenInput(${list}, {
    //                preventDuplicates: true,
    //                noResultsText: "No Result",
    //                tokenLimit: "1",
    //                searchingText: "Searching ... .. .",
    //            });
    //        });
    //        jQuery(document).ready(function () {
    //            jQuery("#reportingManagerLevel4").tokenInput(${list}, {
    //                preventDuplicates: true,
    //                noResultsText: "No Result",
    //                tokenLimit: "1",
    //                searchingText: "Searching ... .. .",
    //            });
    //        });
    //        jQuery(document).ready(function () {
    //            jQuery("#reportingManagerLevel5").tokenInput(${list}, {
    //                preventDuplicates: true,
    //                noResultsText: "No Result",
    //                tokenLimit: "1",
    //                searchingText: "Searching ... .. .",
    //            });
    //        });
    //        jQuery(document).ready(function () {
    //            jQuery("#reportingManagerLevel6").tokenInput(${list}, {
    //                preventDuplicates: true,
    //                noResultsText: "No Result",
    //                tokenLimit: "1",
    //                searchingText: "Searching ... .. .",
    //            });
    //        });
    $("#levelMasterId").on('change', function () {
        var textVal = $("#levelMasterId option:selected").text();
        //            alert(textVal);
        if (textVal == "Level 0") {
            //$('#levelIdDiv1').show();
            $('#levelIdDiv1').hide();
            $('#levelIdDiv2').hide();
            $('#levelIdDiv3').hide();
            $('#levelIdDiv4').hide();
            $('#levelIdDiv5').hide();
            $('#levelIdDiv6').hide();
        } else if (textVal == "Level 1") {
            $('#levelIdDiv1').show();
            $('#levelIdDiv2').hide();
            $('#levelIdDiv3').hide();
            $('#levelIdDiv4').hide();
            $('#levelIdDiv5').hide();
            $('#levelIdDiv6').hide();
        } else if (textVal == "Level 2") {
            $('#levelIdDiv1').show();
            $('#levelIdDiv2').show();
            $('#levelIdDiv3').hide();
            $('#levelIdDiv4').hide();
            $('#levelIdDiv5').hide();
            $('#levelIdDiv6').hide();
        } else if (textVal == "Level 3") {
            $('#levelIdDiv1').show();
            $('#levelIdDiv2').show();
            $('#levelIdDiv3').show();
            $('#levelIdDiv4').hide();
            $('#levelIdDiv5').hide();
            $('#levelIdDiv6').hide();
        } else if (textVal == "Level 4") {
            $('#levelIdDiv1').show();
            $('#levelIdDiv2').show();
            $('#levelIdDiv3').show();
            $('#levelIdDiv4').show();
            $('#levelIdDiv5').hide();
            $('#levelIdDiv6').hide();
        } else if (textVal == "Level 5") {
            $('#levelIdDiv1').show();
            $('#levelIdDiv2').show();
            $('#levelIdDiv3').show();
            $('#levelIdDiv4').show();
            $('#levelIdDiv5').show();
            $('#levelIdDiv6').hide();
        } else if (textVal == "Level 6") {
            $('#levelIdDiv1').show();
            $('#levelIdDiv2').show();
            $('#levelIdDiv3').show();
            $('#levelIdDiv4').show();
            $('#levelIdDiv5').show();
            $('#levelIdDiv6').show();
        }

    });</script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
<!--    <script>
        $(document).ready(function () {
            showHide();
        });
        $("#levelMasterId").on('change', function () {
            showHide();
        });
        $("#WorkTypeSelectId").on("change", function () {
            shift();
        });
        function showHide() {
            var textVal = $("#levelMasterId option:selected").text();
            $('#levelIdDiv1').hide();
            $('#levelIdDiv2').hide();
            $('#levelIdDiv3').hide();
            $('#levelIdDiv4').hide();
            $('#levelIdDiv5').hide();
            $('#levelIdDiv6').hide();
            if (textVal === "Level 1") {
                $('#levelIdDiv1').show();

            } else if (textVal === "Level 2") {
                $('#levelIdDiv1').show();
                $('#levelIdDiv2').show();

            } else if (textVal === "Level 3") {
                $('#levelIdDiv1').show();
                $('#levelIdDiv2').show();
                $('#levelIdDiv3').show();

            } else if (textVal === "Level 4") {
                $('#levelIdDiv1').show();
                $('#levelIdDiv2').show();
                $('#levelIdDiv3').show();
                $('#levelIdDiv4').show();

            } else if (textVal === "Level 5") {
                $('#levelIdDiv1').show();
                $('#levelIdDiv2').show();
                $('#levelIdDiv3').show();
                $('#levelIdDiv4').show();
                $('#levelIdDiv5').show();

            } else if (textVal === "Level 6") {
                $('#levelIdDiv1').show();
                $('#levelIdDiv2').show();
                $('#levelIdDiv3').show();
                $('#levelIdDiv4').show();
                $('#levelIdDiv5').show();
                $('#levelIdDiv6').show();
            }
        }

    </script>-->
<script>
    $(document).ready(function () {

        if ($('.checked input[name=maritalStatus]')) {
            if ($('.checked input[name=maritalStatus]').val() === "Married") {
                $("#hideInfo1").show(500);
                $("#hideInfo2").show(500);
                $("#otherMaritalStatusId").hide(500);
            } else {

                $("#hideInfo1").hide(500);
                $("#hideInfo2").hide(500);
                $("#otherMaritalStatusId").hide(500);
            }
            if ($('.checked input[name=maritalStatus]').val() === "Other") {
                $("#hideInfo1").hide(500);
                $("#hideInfo2").hide(500);
                $("#otherMaritalStatusId").show(500);
            }
        }

        if ($('#shiftType').find("option:selected")) {
            if ($('#shiftType').find("option:selected").val() == "HourlyBase") {
                $('#hourlyBaseTitleDiv').show();
                $('#shiftNameDiv').hide();
                $('#shiftRotationNameDiv').hide();
                $('#shiftRotationDateDiv').hide();
                $('#shiftId').val("");
                $('#shiftRotationDate').val("");
                $('#shiftMasterId').val("");
                //blanks another values on changes
            } else if ($('#shiftType').find("option:selected").val() == "ShiftBase") {
                $('#shiftNameDiv').show();
                $('#shiftRotationNameDiv').show();
                $('#shiftRotationDateDiv').show();
                $('#hourlyBaseTitleDiv').hide();
                $('#shiftHoursId').val("");
                //blanks another values on changes
            } else {
                $('#hourlyBaseTitleDiv').hide();
                $('#shiftNameDiv').hide();
                $('#shiftRotationNameDiv').hide();
                $('#shiftRotationDateDiv').hide();
                $('#shiftId').val("");
                $('#shiftRotationDate').val("");
                $('#shiftMasterId').val("");
                $('#shiftHoursId').val("");
                //blanks all values on changes as not selected yet.
            }
        }
        //            });

    });
    $('input[name=maritalStatus]').on('ifChecked', function (event) {
        if (this.value === "Married") {
            $("#hideInfo1").show(500);
            $("#hideInfo2").show(500);
            $("#otherMaritalStatusId").hide(500);
        } else {

            $("#hideInfo1").hide(500);
            $("#hideInfo2").hide(500);
            $("#otherMaritalStatusId").hide(500);
        }
        if (this.value === "Other") {
            $("#hideInfo1").hide(500);
            $("#hideInfo2").hide(500);
            $("#otherMaritalStatusId").show(500);
        }


    });</script>

<script>
    jQuery(document).ready(function () {
        errorDivOpen();
    });
    function errorDivOpen() {
        if (document.getElementById('employeeId.errors').innerHTML) {
            var name = $('#empInfo_id').attr('class');
            if (name == 'box box-info collapsed-box') {
                $("#empInfo_id").attr('class', 'box box-info');
                document.getElementById('spanId1').innerHTML = 'Minimize';
                $('#minusId1').attr('class', 'fa fa-minus');
            }
        }
        if (document.getElementById('employeeName.errors').innerHTML) {
            var name = $('#empInfo_id').attr('class');
            if (name == 'box box-info collapsed-box') {
                $("#empInfo_id").attr('class', 'box box-info');
                document.getElementById('spanId1').innerHTML = 'Minimize';
                $('#minusId1').attr('class', 'fa fa-minus');
            }
        }
        if (document.getElementById('fatherName.errors').innerHTML) {
            var name = $('#document_detail_id').attr('class');
            if (name == 'box box-info collapsed-box') {
                $("#document_detail_id").attr('class', 'box box-info');
                document.getElementById('spanId1').innerHTML = 'Minimize';
                $('#minusId3').attr('class', 'fa fa-minus');
            }
        }
        if (document.getElementById('motherName.errors').innerHTML) {
            var name = $('#document_detail_id').attr('class');
            if (name == 'box box-info collapsed-box') {
                $("#document_detail_id").attr('class', 'box box-info');
                document.getElementById('spanId1').innerHTML = 'Minimize';
                $('#minusId3').attr('class', 'fa fa-minus');
            }
        }
        if (document.getElementById('gender.errors').innerHTML) {
            var name = $('#empInfo_id').attr('class');
            if (name == 'box box-info collapsed-box') {
                $("#empInfo_id").attr('class', 'box box-info');
                document.getElementById('spanId1').innerHTML = 'Minimize';
                $('#minusId1').attr('class', 'fa fa-minus');
            }
        }
        if (document.getElementById('maritalStatus.errors').innerHTML) {
            var name = $('#empInfo_id').attr('class');
            if (name == 'box box-info collapsed-box') {
                $("#empInfo_id").attr('class', 'box box-info');
                document.getElementById('spanId1').innerHTML = 'Minimize';
                $('#minusId1').attr('class', 'fa fa-minus');
            }
        }
        if (document.getElementById('dateOfBirth.errors').innerHTML) {
            var name = $('#empInfo_id').attr('class');
            if (name == 'box box-info collapsed-box') {
                $("#empInfo_id").attr('class', 'box box-info');
                document.getElementById('spanId1').innerHTML = 'Minimize';
                $('#minusId1').attr('class', 'fa fa-minus');
            }
        }
        if (document.getElementById('presentAddress.errors').innerHTML) {
            var name = $('#document_detail_id').attr('class');
            if (name == 'box box-info collapsed-box') {
                $("#document_detail_id").attr('class', 'box box-info');
                document.getElementById('spanId1').innerHTML = 'Minimize';
                $('#minusId3').attr('class', 'fa fa-minus');
            }
        }
        if (document.getElementById('permanentAddress.errors').innerHTML) {
            var name = $('#document_detail_id').attr('class');
            if (name == 'box box-info collapsed-box ') {
                $("#document_detail_id").attr('class', 'box box-info');
                document.getElementById('spanId1').innerHTML = 'Minimize';
                $('#minusId3').attr('class', 'fa fa-minus');
            }
        }
        if (document.getElementById('emailAddress.errors').innerHTML) {
            var name = $('#personal_Detail_id').attr('class');
            if (name == 'box box-info collapsed-box') {
                $("#personal_Detail_id").attr('class', 'box box-info');
                document.getElementById('spanId2').innerHTML = 'Minimize';
                $('#minusId2').attr('class', 'fa fa-minus');
            }
        }
        if (document.getElementById('contactNo1.errors').innerHTML) {
            var name = $('#personal_Detail_id').attr('class');
            if (name == 'box box-info collapsed-box ') {
                $("#personal_Detail_id").attr('class', 'box box-info');
                document.getElementById('spanId2').innerHTML = 'Minimize';
                $('#minusId2').attr('class', 'fa fa-minus');
            }
        }
        if (document.getElementById('emergencyContactPerson.errors').innerHTML) {
            var name = $('#document_detail_id').attr('class');
            if (name == 'box box-info collapsed-box') {
                $("#document_detail_id").attr('class', 'box box-info');
                document.getElementById('spanId2').innerHTML = 'Minimize';
                $('#minusId3').attr('class', 'fa fa-minus');
            }
        }
        if (document.getElementById('panCard.errors').innerHTML) {
            var name = $('#personal_Detail_id').attr('class');
            if (name == 'box box-info collapsed-box ') {
                $("#personal_Detail_id").attr('class', 'box box-info');
                document.getElementById('spanId3').innerHTML = 'Minimize';
                $('#minusId2').attr('class', 'fa fa-minus');
            }
        }
        if (document.getElementById('adharCard.errors').innerHTML) {
            var name = $('#personal_Detail_id').attr('class');
            if (name == 'box box-info collapsed-box') {
                $("#personal_Detail_id").attr('class', 'box box-info');
                document.getElementById('spanId3').innerHTML = 'Minimize';
                $('#minusId2').attr('class', 'fa fa-minus');
            }
        }
        if (document.getElementById('officeEmailId.errors').innerHTML) {
            var name = $('#empInfo_id').attr('class');
            if (name == 'box box-info collapsed-box ') {
                $("#empInfo_id").attr('class', 'box box-info');
                document.getElementById('spanId4').innerHTML = 'Minimize';
                $('#minusId1').attr('class', 'fa fa-minus');
            }
        }
        if (document.getElementById('highestEducationDetails.errors').innerHTML) {
            var name = $('#personal_Detail_id').attr('class');
            if (name == 'box box-info collapsed-box') {
                $("#personal_Detail_id").attr('class', 'box box-info');
                document.getElementById('spanId4').innerHTML = 'Minimize';
                $('#minusId2').attr('class', 'fa fa-minus');
            }
        }
        if (document.getElementById('company.errors').innerHTML) {
            var name = $('#org_detail_id').attr('class');
            if (name == 'box box-info collapsed-box ') {
                $("#org_detail_id").attr('class', 'box box-info');
                document.getElementById('spanId4').innerHTML = 'Minimize';
                $('#minusId4').attr('class', 'fa fa-minus');
            }
        }
        if (document.getElementById('zydexLocationMaster.errors').innerHTML) {
            var name = $('#org_detail_id').attr('class');
            if (name == 'box box-info collapsed-box') {
                $("#org_detail_id").attr('class', 'box box-info');
                document.getElementById('spanId4').innerHTML = 'Minimize';
                $('#minusId4').attr('class', 'fa fa-minus');
            }
        }
        if (document.getElementById('locationMaster.id.errors').innerHTML) {
            var name = $('#org_detail_id').attr('class');
            if (name == 'box box-info collapsed-box ') {
                $("#org_detail_id").attr('class', 'box box-info');
                document.getElementById('spanId4').innerHTML = 'Minimize';
                $('#minusId4').attr('class', 'fa fa-minus');
            }
        }
        if (document.getElementById('levelMaster.id.errors').innerHTML) {
            var name = $('#org_detail_id').attr('class');
            if (name == 'box box-info collapsed-box') {
                $("#org_detail_id").attr('class', 'box box-info');
                document.getElementById('spanId4').innerHTML = 'Minimize';
                $('#minusId4').attr('class', 'fa fa-minus');
            }
        }
        if (document.getElementById('departmentMaster.id.errors').innerHTML) {
            var name = $('#org_detail_id').attr('class');
            if (name == 'box box-info collapsed-box ') {
                $("#org_detail_id").attr('class', 'box box-info');
                document.getElementById('spanId4').innerHTML = 'Minimize';
                $('#minusId4').attr('class', 'fa fa-minus');
            }
        }
        if (document.getElementById('designationMaster.id.errors').innerHTML) {
            var name = $('#empInfo_id').attr('class');
            if (name == 'box box-info collapsed-box') {
                $("#empInfo_id").attr('class', 'box box-info');
                document.getElementById('spanId4').innerHTML = 'Minimize';
                $('#minusId1').attr('class', 'fa fa-minus');
            }
        }
        if (document.getElementById('dateOfJoining.errors').innerHTML) {
            var name = $('#empInfo_id').attr('class');
            if (name == 'box box-info collapsed-box ') {
                $("#empInfo_id").attr('class', 'box box-info');
                document.getElementById('spanId4').innerHTML = 'Minimize';
                $('#minusId1').attr('class', 'fa fa-minus');
            }
        }
        if (document.getElementById('reportingManagerLevel1.errors').innerHTML) {
            var name = $('#reporting_level_id').attr('class');
            if (name == 'box box-info collapsed-box') {
                $("#reporting_level_id").attr('class', 'box box-info');
                document.getElementById('spanId5').innerHTML = 'Minimize';
                $('#minusId5').attr('class', 'fa fa-minus');
            }
        }
        if (document.getElementById('userMaster.password.errors').innerHTML) {
            var name = $('#login_detail_id').attr('class');
            if (name == 'box box-info collapsed-box') {
                $("#login_detail_id").attr('class', 'box box-info');
                document.getElementById('spanId6').innerHTML = 'Minimize';
                $('#minusId6').attr('class', 'fa fa-minus');
            }
        }
    }</script>


<script src="StorageYard/Plugins/ckeditor/ckeditor.js"></script>
<script src="StorageYard/Plugins/ckeditor/samples/js/sample.js"></script>
<!--<link rel="stylesheet" href="StorageYard/Plugins/ckeditor/samples/css/samples.css">-->
<link rel="stylesheet" href="StorageYard/Plugins/ckeditor/samples/toolbarconfigurator/lib/codemirror/neo.css">
<script>
    initSample();


</script>
<script type="text/javascript">
    window.onload = init;
    function init() {
        document.form1.month.options[new Date().getMonth()].selected = true;
    }
    var start = new Date().getFullYear();
    var end = 2050;
    var options11 = "";
//        var objSelect = document.getElementById("yearBase").value;
    for (var year1 = start; year1 <= end; year1++) {
        options11 += "<option>" + year1 + "</option>";
    }
    document.getElementById('year1').innerHTML = options11;
</script>

</html>

