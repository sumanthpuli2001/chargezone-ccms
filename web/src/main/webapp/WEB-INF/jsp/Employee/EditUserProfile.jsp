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
        <title>Employee Edit</title>
    </head>
    <script>
        function selectsubtype(typeId) {

            var employeeId = document.getElementById("id").value;
            //            document.getElementById('EmployeeId').innerHTML = "Fetching ... .. .";
            $.post("employeeMaster.htm?act=readEmpTypeAjax",
                    {
                        typeId: typeId,
                        employeeId: employeeId
                    }, function (responseTxt, statusTxt, xhr) {
                if (statusTxt === "success") {
                    ("responseTxt" + responseTxt);
                    document.getElementById('employeeSubTypeId').innerHTML = responseTxt;
                }
                if (statusTxt === "error")
                    ("Error: " + xhr.status + ": " + xhr.statusText);
            });
        }


        $(document).ready(function () {
            var empTypeId = document.getElementById("employeeTypeMaster.id").value;
            selectsubtype(empTypeId);

        });

    </script>
    <script>
        var tempCount3 = 1;
        $(function () {
            tempCount3 = document.getElementById('policyCount').value;
            $("#policyCloneid").on("click", function () {
                tempCount3++;
                var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"
                        + "<td style=\"text-align: center\">" + tempCount3 + "</td>"
                        + "<td><div><select id=\"policyId" + tempCount3 + "\" name='policyId" + tempCount3 + "' class=\"form-control\">"
                        + "<option value =\"\"> --SELECT-- </option>"
                        + "</select>"
                        + "</div><span id=\"policyError" + tempCount3 + "\" style=\"color: red;\"></span></td>"
//                        + "<td style=\"text-align: center\"><input type=\"text\" name='policyNumber" + tempCount3 + "' id='policyNumber" + tempCount3 + "'  class=\"form-control\"></td>"
                        + "<td style=\"text-align: center\"><input type=\"number\" name='amount" + tempCount3 + "' id='amount" + tempCount3 + "'  min=\"0\" class=\"form-control\"></td>"
                        + "<td style=\"text-align: center\"><input type=\"checkbox\" name='taxable" + tempCount3 + "' id='taxable" + tempCount3 + "'</td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\"value=\"-\"  onclick=\"removePolicy('addmoreFile" + tempCount3 + "');\"/>"
                        + "</span>"
                        + "</td>"
                        + "</tr>";
                $("#policyTable").append(clone);
                document.getElementById('policyCount').value = tempCount3;
                addAPolicy(tempCount3);

            });
        });

        function addAPolicy(id) {
            var element2 = document.getElementById('policyId1');
            var obj2 = document.getElementById("policyId" + id);
            for (var i2 = 0; i2 < element2.options.length; i2++) {
                var opt2 = document.createElement("option");
                opt2.value = element2.options[i2].value;
                opt2.text = element2.options[i2].text;
                obj2.appendChild(opt2);
            }
        }

        function removePolicy(policyDiv) {
            try {
                tempCount3--;
                var val = document.getElementById("policyCount").value;
                val = val - 1;
                document.getElementById("policyCount").value = val;
                var element1 = document.getElementById(policyDiv);
                element1.parentNode.removeChild(element1);
            } catch (e) {

            }
        }

    </script>
    <script>
        var tempCount4 = 1;
        $(function () {
            $("#ctcCloneid").on("click", function () {
                tempCount4++;
                //                alert(tempCount3);
                var clone = "<tr id='addmoreFile1" + tempCount4 + "' style='clear:both;'>"
                        + "<td style=\"text-align: center\">" + tempCount4 + "</td>"
                        + "<td id=\"ctcTd" + tempCount4 + "\"><div><select id='ctcId" + tempCount4 + "' name='ctcId" + tempCount4 + "' class=\"form-control\">"
                        + "</select>"
                        + "</div><span id=\"ctcError" + tempCount4 + "\" style=\"color: red;\"></span></td>"
                        //                        + "<td style=\"text-align: center\"><input type=\"text\" name='policyNumber" + tempCount3 + "' id='policyNumber" + tempCount3 + "'  class=\"form-control\"></td>"
                        + "<td style=\"text-align: center\"><input type=\"number\" name='ctcamount" + tempCount4 + "' id='ctcamount" + tempCount4 + "'  min=\"0\" class=\"form-control\"></td>"
                        + "<td style=\"text-align: center\"><input type=\"checkbox\" name='taxable" + tempCount3 + "' id='taxable" + tempCount3 + "'</td>"
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
                var start = 1990;
                var end = 2050;
                var options11 = "";

                for (var year1 = end; year1 >= start; year1--) {
                    options11 += "<option>" + year1 + "</option>";
                }
                //                alert(tempCount4);
                document.getElementById('year2').innerHTML = options11;
                document.getElementById('year3').innerHTML = options11;
                document.getElementById('year4').innerHTML = options11;
                document.getElementById('year5').innerHTML = options11;
                document.getElementById('year6').innerHTML = options11;
                document.getElementById('year7').innerHTML = options11;

            });
        });

        function addActc(id) {
            //                alert(id);
            var element2 = document.getElementById('ctcId1');
            var obj2 = document.getElementById("ctcId" + id);
            for (var i2 = 0; i2 < element2.options.length; i2++) {
                var opt2 = document.createElement("option");
                opt2.value = element2.options[i2].value;
                opt2.text = element2.options[i2].text;
                obj2.appendChild(opt2);
            }
        }

        function removectc(policyDiv) {
            try {
                tempCount4--;
                var val = document.getElementById("ctcCount").value;
                val = val - 1;
                document.getElementById("ctcCount").value = val;
                var element1 = document.getElementById(policyDiv);
                element1.parentNode.removeChild(element1);
            } catch (e) {

            }
        }

    </script>
    <script>
//        $(document).ready(function () {
//            shift();
//            var rotationId = document.getElementById("shiftId").value;
//            selectShift(rotationId);
//        });
//
//        function shift() {
//
//            var selectedValue = document.getElementById('WorkTypeSelectId').value;
//            if (selectedValue == "HourlyBase") {
//                $('#hourlyBaseTitleDiv').show();
//                $('#shiftRotationNameDiv').hide();
//                $('#shiftRotationDateDiv').hide();
//                $('#shiftNameDiv').hide();
//            } else if (selectedValue == "ShiftBase") {
//                $('#shiftRotationNameDiv').show();
//                $('#shiftRotationDateDiv').show();
//                $('#shiftNameDiv').show();
//                $('#hourlyBaseTitleDiv').hide();
//            }
        //});
//            spous name show for married selected
//            $('input:radio[name="group2"]').change(function () {
//                if ($(this).is(':checked') && $(this).val() == 'married') {
//                    $('#spousNameDiv').show();
//                } else {
//                    $('#spousNameDiv').hide();
//                }
//            });

//        }
    </script>

    <script>
        var flag3 = true;
        function saveSubmit11() {
//            alert("vxcvxcvjk");
            if (flag3) {
                flag3 = false;
                if (passwordVal()) {
                    document.getElementById('saveSubmit1').innerHTML = 'Saving ... .. .';
                    document.form1.submit();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        function passwordVal() {
            var pass = document.getElementById('password').value;
            if (pass === "") {
                document.getElementById('passError').innerHTML = "- It must not be empty or whitespace";
                return false;
            } else {
                return true;
            }
        }
    </script>
    <script>
        function userName1(val) {
            var abc = document.getElementById("employeeId").value;
            document.getElementById("userName").value = abc;
        }
        function showTxt(info) {
            if (info === "Married") {
                $("#hideInfo1").show(500);
                $("#hideInfo2").show(500);
            } else {
                $("#hideInfo1").hide(500);
                $("#hideInfo2").hide(500);
            }
        }
    </script>
    <script>
//        function selectShift(rotationId) {
////            alert('Call Ajax');
//            document.getElementById('shiftMasterId').innerHTML = "Fetching ... .. .";
//            $.post("shiftRotationMaster.htm?act=readRotationAjax",
//                    {
//                        rotationId: rotationId
//                    }, function (responseTxt, statusTxt, xhr) {
//                if (statusTxt === "success") {
//                    document.getElementById('shiftMasterId').innerHTML = responseTxt;
//                }
//                if (statusTxt === "error")
//                    alert("Error: " + xhr.status + ": " + xhr.statusText);
//            });
//        }
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
        function buttonFun7() {
            var className = $('#minusId7').attr('class');
            if (className == 'fa fa-plus') {
                document.getElementById('spanId7').innerHTML = 'Minimize';
            } else {
                document.getElementById('spanId7').innerHTML = 'Expand';
            }
        }

        //change profile picture.
        function changeButton() {
            var className = document.getElementById("photographUpdate").value;
            if (className != null || className != '') {
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
                        fd.append('userName', '${param.userid}');
                        fd.append('photographUpdate', photographUpdate);
                        $.ajax({
                            url: 'employeeMaster.htm?act=displayPicture',
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
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Employee Registration Form:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Employee Registration Form</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role=" ">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form" action="employeeMaster.htm?act=editSubmit" commandName="employeeMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
            <form:hidden path="userMaster.id"></form:hidden>
            <form:hidden path="id"></form:hidden>
            <form:hidden path="shiftType"></form:hidden>
            <form:hidden path="shiftHoursId"></form:hidden>
            <form:hidden path="shiftRotationDate"></form:hidden>
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Custom Tabs -->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                    <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                    <!--form horizontal starts here-->
                                    <div class="box box-info collapsed-box ">
                                        <div class="box-header">
                                            <h3 class="box-title">Personal Detail:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId1">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun1();"><i class="fa fa-plus" id="minusId1" ></i></button>
                                                <!--                                                <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                            </div>
                                        </div>
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Employee Id:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="employeeId" class="form-control" ></form:input>
                                                        <form:errors path="employeeId" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label>Employee Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="employeeName" class="readItOnly form-control"></form:input>
                                                        <form:errors path="employeeName" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Father's Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="fatherName" class=" form-control"></form:input>
                                                        <form:errors path="fatherName" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label>Mother's Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="motherName" class=" form-control" ></form:input>
                                                        <form:errors path="motherName" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Father's Date Of Birth:</label>
                                                            <div class="input-group date form_datetime_dob" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                            <form:input path="dateOfBirthOfEmpFather" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        <form:errors path="dateOfBirthOfEmpFather" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label>Mother's Date Of Birth:</label>
                                                            <div class="input-group date form_datetime_dob" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                            <form:input path="dateOfBirthOfEmpMother" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        <form:errors path="dateOfBirthOfEmpMother" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Sex:<span style="color: red;font-size: 12px;">*</span></label>&nbsp;&nbsp;
                                                            <fieldset id="group1">

                                                            <form:radiobutton path="gender" value="false" />Male&nbsp;&nbsp;
                                                            <form:radiobutton path="gender" value="true" />Female&nbsp;&nbsp;

                                                        </fieldset>
                                                        <form:errors path="gender" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <input type="hidden" name="mriStatus" id="mriStatus" value="${mriStatus}">
                                                        <label>Marital Status:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <fieldset id="group2">
                                                            <form:radiobutton path="maritalStatus"  value="Married"/>Married
                                                            <form:radiobutton path="maritalStatus"  value="UnMarried"/>UnMarried
                                                            <form:radiobutton path="maritalStatus" value="Other"/>Other

                                                        </fieldset>

                                                        <div style="display: none;" class="col-sm-6" id="otherMaritalStatusId">
                                                            <form:input type="text" path="maritalStatusOthers" class="form-control"/>
                                                        </div>

                                                    </div>
                                                </div>
                                                <div class="form-group">
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
                                                        <div class="col-sm-3">
                                                            <label>Photograph:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <img src="${imgFile}" id="photograph" name="photograph" width="150px" height="150px"/>
                                                    </div>
                                                    <div class="col-sm-3">
                                                        <label>Update Photo:</label>
                                                        <div id="imageSrc">
                                                            <input type="file" class="form-control" id="photographUpdate" name="photographUpdate" onchange="changeButton();" accept="image/jpg,image/jpeg,image/png">
                                                            <span style="font-size: 14px; color: red;" id="photographError"></span>
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
                                                            <label>Permanent Address<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:textarea path="permanentAddress" class="form-control"></form:textarea>
                                                        <form:errors path="permanentAddress" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>

                                                    <div class="form-group" id="hideInfo1" style="display: none;">
                                                        <div class="col-sm-6">
                                                            <label>Spouse Name:</label>
                                                        <form:input path="spouseName" class="form-control"></form:input>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Spouse's Date Of Birth:</label>
                                                            <div class="input-group date form_datetime_dob" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                            <form:input path="dateOfBirthOfEmpSpous" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div id="hideInfo2" style="display: none;">
                                                        <div class="form-group">
                                                            <div class="col-sm-6">
                                                                <label>Child Name1:</label>
                                                            <form:input path="child1" class="form-control"></form:input>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <label>Child1's Date Of Birth:</label>
                                                                <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                    <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                                <form:input path="dateOfBirthOfEmpChilld1" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                </div>
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
                                                                    <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                                <form:input path="dateOfBirthOfEmpChild2" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>City:</label>
                                                        <form:input path="cityOfEmployee" class="form-control"></form:input>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label>Blood Groups:<span style="color: red;font-size: 12px;">*</span></label>

                                                        <form:select path="bloodGroups" id="bloodGroups" class="form-control" >
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
                                                        <%--<form:hidden path="bloodGroups"/>--%>
                                                    </div>
                                                </div>


                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                                <!--pesonal detail complete-->
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Contact Detail:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2();"><i class="fa fa-plus" id="minusId2" ></i></button>
                                            <!--<button  class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label >Email Id:</label>
                                                        <form:input path="emailAddress" pattern="[^ @]*@[^ @]*" class="form-control" placeholder="abc@domain.com" required=""></form:input>
                                                        <form:errors path="emailAddress" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label >Contact No.1:</label>
                                                        <form:input path="contactNo1" id="contactNo1" maxlength="14" data-fv-numeric="true" data-fv-numeric-message="Please enter valid number" data-fv-phone-country11="IN" class="form-control"></form:input>
                                                        <form:errors path="contactNo1" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label >Emergency Contact Person:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="emergencyContactPerson" class="form-control"></form:input>
                                                        <form:errors path="emergencyContactPerson" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Emergency Contact No:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="emergencyContactNo"  maxlength="14" data-fv-numeric="true" data-fv-numeric-message="Please enter valid number" data-fv-phone-country11="IN" class="form-control"></form:input>
                                                        <form:errors path="emergencyContactNo" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <!--contact detail completes here-->
                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">Document Detail:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun3();"><i class="fa fa-plus" id="minusId3" ></i></button>
                                                <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">

                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>PAN Card No.:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="panCard" style="text-transform:uppercase" id="pancard" class="form-control" placeholder="(1-5: alphabets, 6-9: digits, 10th: alphabet) Example: ASDFG4567A"></form:input>
                                                        <form:errors path="panCard" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label >Passport No.:</label>
                                                        <form:input path="passportNo" id="passportNo" class="form-control"></form:input>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Passport Issue Date:</label>
                                                            <div class="input-group date form_datetime_passport_issue"  data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <form:input path="passportIssueDate" class="form-control" size="16"></form:input>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        <form:errors path="passportIssueDate" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class=" col-sm-6">
                                                            <label>Passport Expiry Date:</label>
                                                            <div class="input-group date form_datetime_passport_expiry"   data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                            <form:input path="passportExpiryDate" class="form-control" size="16"></form:input>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label >Aadhar Card:</label>
                                                        <form:input path="adharCard" class="form-control"></form:input>
                                                        <form:errors path="adharCard" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Any Other Government Document Photo Id Proof:</label>
                                                            <div class="col-sm-6">
                                                            <form:input path="govLicenceName" type="text" class="form-control" placeholder="Please Specify Photo ID Name"></form:input>
                                                            </div>
                                                            <div class="col-sm-6">
                                                            <form:input path="drivingLicence" type="text" class="form-control" placeholder="Please Specify No."></form:input>
                                                            </div>
                                                        </div>
                                                    </div><!-- /.col -->
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <!--Document detail completes here-->
                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">Organization Specific Detail:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun4();"><i class="fa fa-plus" id="minusId4"></i></button>
                                                <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">

                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Official E - Mail ID:</label>
                                                        <form:input path="officeEmailId" id="officeEmailId" class="form-control"></form:input>
                                                        <form:errors path="officeEmailId" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label>Highest Education Details<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="highestEducationDetails" id="highestEducationDetails" class="form-control"></form:input>
                                                        <form:errors path="highestEducationDetails" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <div class="col-sm-6">
                                                                <label>Exp. on Date Of Joining:  Year:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <form:select path="experienceYearOnDoj" class="form-control ">
                                                                <c:forEach begin="0" end="50" var="counter">
                                                                    <form:option value="${counter}">${counter}</form:option>
                                                                </c:forEach>
                                                            </form:select>
                                                            <form:errors path="experienceYearOnDoj" cssClass="errorDiv"></form:errors>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <label>Exp. on Date Of Joining: Month:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <form:select path="experienceMonthOnDoj" class="form-control">
                                                                <c:forEach begin="0" end="11" var="counter">
                                                                    <form:option value="${counter}">${counter}</form:option>
                                                                </c:forEach>
                                                            </form:select>
                                                            <form:errors path="experienceMonthOnDoj" cssClass="errorDiv"></form:errors>
                                                            </div>
                                                        </div>


                                                        <div class="col-sm-6">
                                                            <label>Company:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <select id="companyId" name="companyId" class="form-control ">
                                                            <c:choose>
                                                                <c:when test="${company.contains('SPC Life Science')}">

                                                                    <option value="SPC Life Science" selected="">SPC Life Science</option>
                                                                </c:when>
                                                                <c:otherwise>

                                                                    <option value="SPC Life Science">SPC Life Science.</option>
                                                                </c:otherwise>
                                                            </c:choose>
                                                            <c:choose>
                                                                <c:when test="${company.contains('SPC Life Science')}">

                                                                    <option value="SPC Life Science" selected="">SPC Life Science</option>
                                                                </c:when>
                                                                <c:otherwise>

                                                                    <option value="SPC Life Science">SPC Life Science</option>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </select>

                                                        <form:errors path="company" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <input type="hidden" name="typeOfEmployee" id="typeOfEmployee" value="${employeeTypeMaster.typeOfEmployee}">
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Type of Employee :<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:select path="employeeTypeMaster.id"  onchange="selectsubtype(this.value);" class="form-control">
                                                            <form:option value="" label="-- Select --" ></form:option>
                                                            <form:options items="${EmployeeTypeList}"></form:options>
                                                        </form:select>
                                                        <form:errors path="employeeTypeMaster.id" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-6" id="employeeSubTypeId">
                                                            <label>Employee SubType:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <select name="subTypeId" id="subTypeId"class="form-control ">
                                                                <option value="" label="-- Select --" ></option>
                                                            <%--<form:options items="${EmployeeSubTypeList}"></form:options>--%>
                                                        </select>


                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label> Location:<span style="color: red;font-size: 12px;">*</span></label>

                                                        <form:select path="zydexLocationMaster.id" class="form-control">
                                                            <%--<form:option value="" label="-- Select --" ></form:option>--%>
                                                            <form:options items="${zydexLocationMap}"></form:options>
                                                        </form:select>
                                                        <form:errors path="zydexLocationMaster.id" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label>Work Location:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:select path="locationMaster.id" class="form-control">
                                                            <%--<form:option value="" label="-- Select --" ></form:option>--%>
                                                            <form:options items="${location}"></form:options>
                                                        </form:select>

                                                        <form:errors path="locationMaster.id" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Level:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:select path="levelMaster.id" class="form-control" onchange="getDesignation();">
                                                            <form:options items="${level}" ></form:options>
                                                        </form:select>
                                                        <form:errors path="levelMaster.id" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label>Department:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:select path="departmentMaster.id" class="form-control">
                                                            <%--<form:option value="" label="-- Select --" ></form:option>--%>
                                                            <form:options items="${deptMap}"></form:options>
                                                        </form:select>
                                                        <form:errors path="departmentMaster.id" cssClass="errorDiv"></form:errors>

                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Designation:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <select name="designationMasterByLevelId" id="designationMasterByLevelId" class="form-control" onchange="setDesignation()">
                                                            <c:forEach var="desn" items="${desigList}">
                                                                <c:if test="${desn['key'] eq employeeMaster.designationMaster.id}">
                                                                    <option value="${desn['key']}" label="${desn['value']}" selected="true"></option>
                                                                </c:if>
                                                            </c:forEach>
                                                            <%--<form:options items="${desigList}"></form:options>--%>
                                                        </select>
                                                        <form:hidden path="designationMaster.id" class="form-control"></form:hidden>

                                                        <form:errors path="designationMaster.id" cssClass="errorDiv"></form:errors>

                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label>Role:</label>
                                                        <form:input path="role" class="form-control"></form:input>
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
                                                    <c:if test="${sessionScope.userRight.hr == true}" >
                                                        <div class="col-sm-6">
                                                            <label>Last Year's Performance Rating:</label>
                                                            <input type="text" class="form-control" value="${lastYearPerformanceRatingsOfEmployee}" readonly="true">
                                                            <%--<form:hidden path="lastYearPerformanceRating" class="form-control"></form:input>--%>
                                                        </div>
                                                    </c:if>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Employee Type:<span style="color: red;font-size: 12px;">*</span></label>

                                                        <select name="employeeType" id="employeeType" class="form-control ">
                                                            <c:choose>
                                                                <c:when test="${employeeType.contains('Probation')}">

                                                                    <option value="Probation" selected="">Probation</option>
                                                                </c:when>
                                                                <c:otherwise>

                                                                    <option value="Probation">Probation</option>
                                                                </c:otherwise>
                                                            </c:choose>
                                                            <c:choose>
                                                                <c:when test="${employeeType.contains('Confirmed')}">

                                                                    <option value="Confirmed" selected="">Confirmed</option>
                                                                </c:when>
                                                                <c:otherwise>

                                                                    <option value="Confirmed">Confirmed</option>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </select>

                                                        <!--<option value="">--SELECT--</option>-->


                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label >Contact No.:</label>
                                                        <form:input path="contactNo2" id="contactNo2" maxlength="14" data-fv-numeric="true" data-fv-numeric-message="Please enter valid number" data-fv-phone-country11="IN" class="form-control"></form:input>
                                                        <form:errors path="contactNo2" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div><!-- /.col -->
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Date Of Transfer Of Entity:</label>
                                                            <div class="input-group date date_of_transfer"   data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <form:input path="dateOfTransferOfEntity" class="form-control" size="16" value="" readonly="true"></form:input>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Competency Evaluation:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <select name="competencyEvaluationId" id="competencyEvaluationId" class="form-control">
                                                                <option value="">--SELECT--</option>
                                                            <c:forEach var="competencyMap" items="${competencyMap}">
                                                                <c:if test="${competencyMap.key eq employeeMaster.competencyEvaluationId}">
                                                                    <option value="${competencyMap.key}" selected="">${competencyMap.value}</option>
                                                                </c:if>
                                                                <c:if test="${competencyMap.key ne employeeMaster.competencyEvaluationId}">
                                                                    <option value="${competencyMap.key}" >${competencyMap.value}</option>
                                                                </c:if>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </div><!-- /.col -->
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>PF Amount:</label>
                                                        <form:input path="pfAmount" type="number" min="0" placeholder="Enter Amount" class="form-control"></form:input>
                                                        <form:errors path="pfAmount" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>ESIC No<span style="color: red;font-size: 12px;"></span></label>
                                                            <form:input path="esicNo" class="form-control"    placeholder="Enter ESIC No"/>
                                                            <form:errors path="esicNo" cssClass="errorDiv"/>
                                                    </div>
                                                </div>
                                                <div class="form-group">

                                                    <div class="col-sm-6">
                                                        <label>Basic Salary:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="basicSalary" class="form-control"  placeholder="Enter Basic Salary"/>
                                                        <form:errors path="basicSalary" cssClass="errorDiv"/>
                                                    </div>
                                                </div>


                                                <!--</div>-->
                                                <div class="form-group">
                                                    <div class="col-sm-4">
                                                        <label>Provident Fund:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <fieldset>
                                                            <c:if test="${checkPf eq 'false'}">
                                                                <input type="radio" name="pf" id="pf" value="false" checked="true">NO
                                                                <input type="radio" name="pf" id="pf" value="true">YES
                                                            </c:if>
                                                            <c:if test="${checkPf eq 'true'}">
                                                                <input type="radio" name="pf" id="pf" value="false" >NO
                                                                <input type="radio" name="pf" id="pf" value="true" checked="true">YES
                                                            </c:if>

                                                        </fieldset>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <label>Provident Tax:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <fieldset>
                                                            <c:if test="${checkPt eq 'false'}">
                                                                <input type="radio" name="pt" id="pt" value="false" checked="true">NO
                                                                <input type="radio" name="pt" id="pt" value="true">YES
                                                            </c:if>
                                                            <c:if test="${checkPt eq 'true'}">
                                                                <input type="radio" name="pt" id="pt" value="false" >NO
                                                                <input type="radio" name="pt" id="pt" value="true" checked="true">YES
                                                            </c:if>
                                                        </fieldset>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <label>ESIC:<span style="color: red;font-size: 12px;">*</span></label>&nbsp;&nbsp;
                                                        <fieldset>
                                                            <form:radiobutton path="esic" value="false"/>NO&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
                                                                        <tr>
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
                                                                                <input type="number" name="amount${countVal.count}" id="amount${countVal.count}" min="0" class="form-control" value="${comp[3]}">
                                                                            </td>

                                                                            <c:if test="${comp[4] eq 1}">

                                                                                <td style="text-align: center">
                                                                                    <input type="checkbox" name="taxable${countVal.count}" id="taxable${countVal.count}" checked="true">
                                                                                </td>
                                                                            </c:if>
                                                                            <c:if test="${comp[4] ne 1}">
                                                                                <td style="text-align: center">
                                                                                    <input type="checkbox" name="taxable${countVal.count}" id="taxable${countVal.count}" >
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
                                                                                <!--<span style='margin-top: 5px;'>-->
                                                                                <!--<input type="button" value="-" id="policyRemoveid" onclick="removeForEdit()"/>-->
                                                                                <!--</span>-->
                                                                                <%--</c:otherwise>--%>
                                                                                <%--</c:choose>--%>
                                                                                <c:if test="${countVal.last}">
                                                                                    <c:if test="${countVal.last}">
                                                                                        <span style='margin-top: 5px;'>
                                                                                            <input type="button" value="+" id="policyCloneid" />
                                                                                        </span>
                                                                                    </c:if>
                                                                                </c:if>
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
                                                                            <input type="number" name="amount1" id="amount1" min="0" class="form-control" value="">
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
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="table-responsive">
                                                        <table id="ctcTable" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                            <tr>
                                                                <th style="text-align: center; vertical-align: middle;width: 5%">Sr.No.</th>
                                                                <th style="text-align: center; vertical-align: middle">Select CTC</th>
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
                                                            <c:choose>
                                                                <c:when test="${not empty finalctcList}">
                                                                    <c:forEach var="comp" items="${finalctcList}" varStatus = "countVal">
                                                                        <input type="hidden" name="countSecond" id="countSecond" value="${fn:length(finalctcList)}"/>
                                                                        <tr>
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
                                                                            <td style="text-align: center">
                                                                                <input type="number" name="ctcamount${countVal.count}" id="ctcamount${countVal.count}" min="0" class="form-control" value="${comp[2]}">
                                                                            </td>
                                                                            <c:if test="${comp[3] eq 1}">

                                                                                <td style="text-align: center">
                                                                                    <input type="checkbox" name="taxable${countVal.count}" id="taxable${countVal.count}" checked="true">
                                                                                </td>
                                                                            </c:if>
                                                                            <c:if test="${comp[3] ne 1}">
                                                                                <td style="text-align: center">
                                                                                    <input type="checkbox" name="taxable${countVal.count}" id="taxable${countVal.count}" >
                                                                                </td>
                                                                            </c:if>
                                                                            <td ><div>
                                                                                    <!--<label>Months:<span style="color: red;font-size: 12px;">*</span></label>-->
                                                                                    <%--<form:input path="bloodGroups" class="form-control"></form:input>--%>
                                                                                    <select id="month${countVal.count}" name="month${countVal.count}"  class="form-control ">
                                                                                        <c:choose>
                                                                                            <c:when test="${comp[4] eq 01}">
                                                                                                <option value="01" selected="selected">January</option>
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
                                                                                            <c:when test="${comp[4] eq 02}">
                                                                                                <option value="02" selected="selected">February</option>
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
                                                                                            <c:when test="${comp[4] eq 03}">
                                                                                                <option value="03" selected="selected">March</option>
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
                                                                                            <c:when test="${comp[4] eq 04}">
                                                                                                <option value="04" selected="selected">April</option>
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
                                                                                            <c:when test="${comp[4] eq 05}">
                                                                                                <option value="05" selected="selected">May</option>
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
                                                                                            <c:when test="${comp[4] eq 06}">
                                                                                                <option value="06" selected="selected">June</option>
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
                                                                                            <c:when test="${comp[4] eq 07}">
                                                                                                <option value="07" selected="selected">July</option>
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
                                                                                            <c:when test="${comp[4] eq 08}">
                                                                                                <option value="08" selected="selected">August</option>
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
                                                                                            <c:when test="${comp[4] eq 09}">
                                                                                                <option value="09" selected="selected">September</option>
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
                                                                                            <c:when test="${comp[4] eq 10}">
                                                                                                <option value="10" selected="selected">October</option>
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
                                                                                            <c:when test="${comp[4] eq 11}">
                                                                                                <option value="11" selected="selected">November</option>
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
                                                                                            <c:when test="${comp[4] eq 12}">
                                                                                                <option value="12" selected="selected">December</option>
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
                                                                                                <!--<option value="">--Select--</option>-->
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
                                                                            <td ><div>

                                                                                    <!--<label>Months:<span style="color: red;font-size: 12px;">*</span></label>-->
                                                                                    <%--<form:input path="bloodGroups" class="form-control"></form:input>--%>
                                                                                    <input   class="form-control" value="${comp[5]}"></select>
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
                                                                                <%--</c:choose>--%>
                                                                                <c:if test="${countVal.last}">
                                                                                    <c:if test="${countVal.last}">
                                                                                        <span style='margin-top: 5px;'>
                                                                                            <input type="button" value="+" id="ctcCloneid" />
                                                                                        </span>
                                                                                    </c:if>
                                                                                </c:if>
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
                                                                            <input type="number" name="ctcamount1" id="ctcamount1" min="0" class="form-control" value="">
                                                                        </td>
                                                                        <td style="text-align: center">
                                                                            <input type="checkbox" name="taxable1" id="taxable1" >
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

                                                                            <select name="year1" id="year1" class="form-control ">

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

                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
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
                                                            <label>Payment Type:</label>
                                                        <form:select path="paymentType"  class="form-control ">

                                                            <option value="">--Select--</option>
                                                            <form:option value="0">Cheque</form:option>
                                                            <form:option value="1">Cash</form:option>

                                                        </form:select>
                                                    </div>
                                                </div>

                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                    <!--bank detail complete-->
                                    <div class="box box-info collapsed-box collapsed-box">
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
                                                        <div class="col-sm-6" id="levelIdDiv1">
                                                            <label>Reporting Manager:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <form:input path="reportingManagerLevel1" class="form-control" onchange="reportingLevelSet();"></form:input>
                                                            <form:errors path="reportingManagerLevel1" cssClass="errorDiv"></form:errors>

                                                            </div>
                                                            <div id="reportingHirarchy_div">
                                                                <div class="col-sm-6" id="levelIdDiv2">
                                                                    <label>Level 2:</label>
                                                                <form:hidden path="reportingManagerLevel2"></form:hidden>
                                                                    <input type="text" name="reportingManagerLevel2Name" id="reportingManagerLevel2Name" class="form-control" readonly="true"/>
                                                                </div>
                                                            </div>
                                                        </div>

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
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                    <div class="box box-info collapsed-box" id="login_detail_id">
                                        <div class="box-header">
                                            <h3 class="box-title">Employee Certificate Attachments</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId8">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun8();"><i class="fa fa-plus" id="minusId8" ></i></button>
                                                <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">

                                                    <div class="form-group">
                                                    <c:forEach var="certificatesList" items="${certificatesList}">

                                                        <div class="col-sm-12">
                                                            <span>[ <a href="employeeMaster.htm?act=downloadEmployeeCertificates&amp;fileName=${certificatesList}&userId=${employeeMaster.userMaster.id}">${certificatesList}</a> ]</span>
                                                        </div>
                                                    </c:forEach>

                                                </div>
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
                                                            </div></div>
                                                        <div class="col-md-12 col-sm-12">
                                                            <label>JOB Description:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <form:textarea  path="jobDescription" id="editor"></form:textarea>
                                                            <form:errors path="jobDescription" cssClass="errorDiv"/>
                                                        </div>
                                                    </div></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <c:if test="${!(employeeMaster.employeeName eq  'Admin')}">
                                    <div class="form-group">
                                        <div class=" col-sm-12" style="text-align: center;">
                                            <button type="submit" class="btn btn-primary" data-original-title="" title="" style="width: 100px;">SUBMIT</button>
                                        </div>
                                    </div>
                                </c:if>
                            </div>

                        </div>


                        <div class="tab-pane" id="tab_3"></div>
                    </div>
                    <!--                        </div>
                                        </div>-->
            </section>
        </form:form>
    </div>
    <script type="text/javascript">
        $('.date_of_transfer').datetimepicker({
            //language:  'fr',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });
    </script>
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
                searchingText: "Searching ... .. .",
                prePopulate: ${preList}
            });
        });
        jQuery(document).ready(function () {
            reportingLevelSet();
            if ($('#mriStatus').val() === "Married") {
                $("#hideInfo1").show(500);
                $("#hideInfo2").show(500);
                $("#otherMaritalStatusId").hide(500);
            } else {

                $("#hideInfo1").hide(500);
                $("#hideInfo2").hide(500);
                $("#otherMaritalStatusId").hide(500);
            }
            if ($('#mriStatus').val() === "Other") {
                $("#hideInfo1").hide(500);
                $("#hideInfo2").hide(500);
                $("#otherMaritalStatusId").show(500);
            }
        }); //when document loaded it loads based on erlier reporting manager
        function reportingLevelSet() {

            var level = document.getElementById("reportingManagerLevel1").value;

            if (level != null && level != '') {
                $.ajax({
                    url: 'employeeMaster.htm?act=readReportingHierarchy&id=' + level,
                    type: 'GET',
                    success: function (result) {
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
                            if (array[4] == "" || array[4] == null) {
                                document.getElementById("reportingManagerLevel5").value = level;
                            } else {
                                document.getElementById("reportingManagerLevel5").value = array[4];
                            }
                            document.getElementById("reportingManagerLevel6").value = array[5];
                        }
                        document.getElementById("reportingManagerLevel2Name").value = array[6];
                        document.getElementById("reportingManagerLevel3Name").value = array[7];
                        document.getElementById("reportingManagerLevel4Name").value = array[8];
                        //this conditions checks for level 5 and level 6 if these are empty then set conditional values(for values display on jsp)
                        if ((array[10] == "" || array[10] == null) && (array[11] == "" || array[11] == null)) {
                            if (array[6] == "" || array[6] == null) {
                                document.getElementById("reportingManagerLevel6Name").value = array[12];
                                //array[12] is for employee name reporting manager.
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

        //this script is comented because only first level reporting manager is only required.
        //        jQuery(document).ready(function () {
        //            jQuery("#reportingManagerLevel2").tokenInput(${list}, {
        //                preventDuplicates: true,
        //                noResultsText: "No Result",
        //                tokenLimit: "1",
        //                searchingText: "Searching ... .. .",
        //                prePopulate: ${preList2}
        //            });
        //        });
        //        jQuery(document).ready(function () {
        //            jQuery("#reportingManagerLevel3").tokenInput(${list}, {
        //                preventDuplicates: true,
        //                noResultsText: "No Result",
        //                tokenLimit: "1",
        //                searchingText: "Searching ... .. .",
        //                prePopulate: ${preList3}
        //            });
        //        });
        //        jQuery(document).ready(function () {
        //            jQuery("#reportingManagerLevel4").tokenInput(${list}, {
        //                preventDuplicates: true,
        //                noResultsText: "No Result",
        //                tokenLimit: "1",
        //                searchingText: "Searching ... .. .",
        //                prePopulate: ${preList4}
        //            });
        //        });
        //        jQuery(document).ready(function () {
        //            jQuery("#reportingManagerLevel5").tokenInput(${list}, {
        //                preventDuplicates: true,
        //                noResultsText: "No Result",
        //                tokenLimit: "1",
        //                searchingText: "Searching ... .. .",
        //                prePopulate: ${preList5}
        //            });
        //        });
        //        jQuery(document).ready(function () {
        //            jQuery("#reportingManagerLevel6").tokenInput(${list}, {
        //                preventDuplicates: true,
        //                noResultsText: "No Result",
        //                tokenLimit: "1",
        //                searchingText: "Searching ... .. .",
        //                prePopulate: ${preList6}
        //            });
        //        });
    </script>
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

            //            if ($('.checked input[name=maritalStatus]')) {

            //            }

            if ($('#shiftType').find("option:selected")) {
                if ($('#shiftType').find("option:selected").val() == "HourlyBase") {
                    $('#hourlyBaseTitleDiv').show();
                    $('#shiftNameDiv').hide();
                    $('#shiftRotationNameDiv').hide();
                    $('#shiftRotationDateDiv').hide();
                } else if ($('#shiftType').find("option:selected").val() == "ShiftBase") {
                    $('#shiftNameDiv').show();
                    $('#shiftRotationNameDiv').show();
                    $('#shiftRotationDateDiv').show();
                    $('#hourlyBaseTitleDiv').hide();
                } else {
                    $('#hourlyBaseTitleDiv').hide();
                    $('#shiftNameDiv').hide();
                    $('#shiftRotationNameDiv').hide();
                    $('#shiftRotationDateDiv').hide();
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

        });
        //        $('#gender1').iCheck('check');
    </script>

    <script>
        var setOptionRemoveFlag = true;
        jQuery(document).ready(function () {
            setOptionRemoveFlag = false;
            getDesignation();
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
                    if (setOptionRemoveFlag) {
                        $select.find("option").remove(); // Find all child elements with tag name "option" and remove them (just to prevent duplicate options when button is pressed again).
                        alert("I have been called   " + setOptionRemoveFlag + " times");
                    }
                    $.each(responseJson, function (key, value) {               // Iterate over the JSON object.
                        //                        alert(key + '     ' + value);
                        if (!setOptionRemoveFlag && $("#designationMasterByLevelId option:first").val() != key) {
                            //this conditions check will remove duplicates from list.
                            $('#designationMasterByLevelId')
                                    .append($("<option></option>")
                                            .attr("value", key)
                                            .text(value));
                        }
                        if (setOptionRemoveFlag) {
                            $('#designationMasterByLevelId')
                                    .append($("<option></option>")
                                            .attr("value", key)
                                            .text(value));
                        }
                    });
                    setDesignation();
                    setOptionRemoveFlag = true; //this is setted again to true for option remove function call on onchange() event.
                });
                ////                alert("response     " + responseJson);
                //            }
            }


        }
    </script>
    <script>
        function setDesignation() {

            var designationMasterId = document.getElementById('designationMasterByLevelId').value;
            //            alert("this is designation for it   " + designationMasterId);
            document.getElementById('designationMaster.id').value = designationMasterId;
        }
    </script>
    <script>
        <c:if test="${!sessionScope.userRight.hr}">

        $('.readItOnly').attr('readonly', true);
        </c:if>

    </script>
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
        var start = 1990;
        var end = 2050;
        var options11 = "";

        for (var year1 = end; year1 >= start; year1--) {
            options11 += "<option>" + year1 + "</option>";
        }
        document.getElementById('year1').innerHTML = options11;
    </script>

</html>

