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
        <title>Employee Create</title>
    </head>


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
                }
                else if (selectedValue == "ShiftBase") {
                    $('#shiftNameDiv').show();
                    $('#shiftRotationNameDiv').show();
                    $('#shiftRotationDateDiv').show();
                    $('#hourlyBaseTitleDiv').hide();
                    $('#shiftHoursId').val("");
                    //blanks another values on changes
                }
                else {
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
//                alert("this is submit form  " + document.getElementById('shiftHoursId').value);
                if ($('#shiftType').find("option:selected").val() == "HourlyBase" && $('#shiftHoursId').val() == "") {
                    document.getElementById('shiftHoursIdError').innerHTML = '-It must not be empty.';
                    return false;
                }
                if ($('#shiftType').find("option:selected").val() == "ShiftBase" && (($('#shiftId').val() == '') || ($('#shiftRotationDate').val() == '') || ($('#shiftMasterId').val() == ''))) {
                    if ($('#shiftId').val() == '') {
                        document.getElementById('shiftIdError').innerHTML = '-It must not be empty.';
//                        return false;
                    }
                    if ($('#shiftRotationDate').val() == '') {
                        document.getElementById('shiftRotationDateError').innerHTML = '-It must not be empty.';
//                        return false;
                    }
                    if ($('#shiftMasterId').val() == '') {
                        document.getElementById('shiftMasterIdError').innerHTML = '-It must not be empty.';
//                        return false;
                    }
                    return false;
                }
//                else {
//                    document.getElementById('saveSubmit1').innerHTML = 'Saving ... .. .';
//                    document.form1.submit();
//                    return true;
//                }
//                var photograph = document.getElementById('photograph').value;
////                var password = document.getElementById('password').value;
//                if (photograph == '') {
//                    flag3 = false;
//                    sessionStorage.setItem("photographErrorStorage", "- It must not be empty or whitespace");
//                    document.getElementById('photographError').innerHTML = sessionStorage.getItem("photographErrorStorage");
//                }
////                if (password == '') {
////                    flag3 = false;
////                    sessionStorage.setItem("passErrorStorage", "<p style='color: red'>It must not be empty or whitespace</p>");
////                    document.getElementById('passError').innerHTML = sessionStorage.getItem("passErrorStorage");
////                }
//                else {
//                }
            } else {
                return false;
            }
        }

//        function passwordVal() {
//            alert("hjhgfjhgjh");
//            var pass = document.getElementById('password').value;
//            if (pass === "") {
//                document.getElementById('passError').innerHTML = "- It must not be empty or whitespace";
//                return false;
//            } else {
//                return true;
//            }
//        }
    </script>
    <script>
        $(document).ready(function () {
            userName1();
        });
        function userName1() {
            var abc = document.getElementById("employeeId").value;
            document.getElementById("userName").value = abc;
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
                if (fileSize > 102400) {
                    document.getElementById('photograph').value = '';
                    document.getElementById('photographError').innerHTML = "- It must not more than 100kb";
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
            getDesignation();
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
            $("#policyCloneid").on("click", function () {
                tempCount3++;
                //                alert(tempCount3);
                var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"
                        + "<td style=\"text-align: center\">" + tempCount3 + "</td>"
                        + "<td id=\"policyTd" + tempCount3 + "\"><div><select id='policyId" + tempCount3 + "' name='policyId" + tempCount3 + "' class=\"form-control\">"
                        + "</select>"
                        + "</div><span id=\"policyError" + tempCount3 + "\" style=\"color: red;\"></span></td>"
                        + "<td style=\"text-align: center\"><input type=\"text\" name='policyNumber" + tempCount3 + "' id='policyNumber" + tempCount3 + "'  class=\"form-control\"></td>"
                        + "<td style=\"text-align: center\"><input type=\"number\" name='amount" + tempCount3 + "' id='amount" + tempCount3 + "'  min=\"0\" class=\"form-control\"></td>"
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

            });
        });

        function addAPolicy(id) {
            //                alert(id);
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
        function setDesignation() {

            var designationMasterId = document.getElementById('designationMasterByLevelId').value;
//            alert("this is designation for it   " + designationMasterId);
            document.getElementById('designationMaster.id').value = designationMasterId;
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
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form" action="employeeMaster.htm?act=createSubmit" commandName="employeeMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
            <section class="content">
                <input type="hidden" name="shiftName" id="shiftName" value="${shiftName}">
                <div class="row">
                    <div class="col-md-12">
                         Custom Tabs 
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                form horizontal starts here
                                <div class="box box-info collapsed-box" id="empInfo_id">
                                    <div class="box-header">
                                        <h3 class="box-title">Question Detail:</h3>
<!--                                        <div class="box-tools pull-right">
                                            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
                                            <span id="spanId1">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun1();"><i class="fa fa-plus" id="minusId1" ></i></button>
                                        </div>-->
                                    </div>
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-6" id="employeeSubTypeId">
                                                            <label>category:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <input type="hidden" name="subTypeId" id="subTypeId" value="${employeeMaster.employeeSubType.id}">
                                                        <%--<form:select path="employeeSubType.id" class="form-control">--%>
                                                            <%--<form:option value="" label="-- Select --" ></form:option>--%> 
                                                        <%--</form:select>--%>
                                                        <%--<form:errors path="employeeSubType.id" cssClass="errorDiv"></form:errors>--%>


                                                        </div>

                                                        <div class="col-sm-6">
                                                        <label>Question:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <%--<form:textarea path="question" class="form-control"></form:textarea>--%>
                                                        <%--<form:errors path="question" cssClass="errorDiv"></form:errors>--%>
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                        <label>Question Type:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <%--<form:select path="questionType" id="questionType" class="form-control ">--%>
                                                            <%--<form:option value="0" label="Essay"></form:option>--%>
                                                            <%--<form:option value="1" label="MCQ"></form:option>--%>
                                                        <%--</form:select>--%>
                                                    </div>

                                                        <div class="col-sm-6">
                                                            <label>Marks:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <%--<form:input path="marks" class="form-control"></form:input>--%>
                                                        <%--<form:errors path="marks" cssClass="errorDiv"></form:errors>--%>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <div class="col-sm-3">
                                                            <label>Status:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <fieldset>
                                                                <input type="radio" name="status" id="status" value="true" checked>Active&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                <input type="radio" name="status" id="status" value="false">InActive
                                                            </fieldset>
                                                        </div>
                                                        </div>

                                                    </div>
                                                          <div class="col-md-12 col-sm-12">
                                                    <div class="table-responsive">
                                                        <table id="policyTable" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                            <tr>
                                                                <th style="text-align: center; vertical-align: middle;width: 5%">Sr.No.</th>
                                                                <th style="text-align: center; vertical-align: middle">Select Policy</th>
                                                                <th style="text-align: center; vertical-align: middle">Policy Number</th>
                                                                <th style="text-align: center; vertical-align: middle">Amount</th>
                                                                <th style="text-align: center; vertical-align: middle">Add New</th>
                                                            <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                                                            </tr>
                                                            <tr>
                                                                <td style="text-align: center">1</td>
                                                                <td id="policyTd1"><div>
                                                                        <select id="policyId1"  name="policyId1"  class="form-control">
                                                                            <option value="">--SELECT--</option>
                                                                            <%--<c:forEach var="comp" items="${policy}" varStatus = "status">--%>
                                                                                <option value="${comp.key}">${comp.value}</option>
                                                                            <%--</c:forEach>--%>
                                                                        </select>
                                                                    </div>
                                                                    <span id="policyError1" style="color: red;"></span>
                                                                </td>
                                                                <td style="text-align: center">
                                                                    <input type="text" name="policyNumber1" id="policyNumber1"  class="form-control">
                                                                </td>
                                                                <td style="text-align: center">
                                                                    <input type="number" name="amount1" id="amount1" min="0" class="form-control">
                                                                </td>
                                                                <td style="text-align: center">
                                                                    <span style='margin-top: 5px;'>
                                                                        <input type="button" value="+" id="policyCloneid" />
                                                                    </span>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>
                                                </div> 
                                            </div>  
                                        </div>
                                    </div>
                                <div class="tab-pane" id="tab_3"></div>
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
            }
            else if (textVal == "Level 1") {
                $('#levelIdDiv1').show();
                $('#levelIdDiv2').hide();
                $('#levelIdDiv3').hide();
                $('#levelIdDiv4').hide();
                $('#levelIdDiv5').hide();
                $('#levelIdDiv6').hide();
            }
            else if (textVal == "Level 2") {
                $('#levelIdDiv1').show();
                $('#levelIdDiv2').show();
                $('#levelIdDiv3').hide();
                $('#levelIdDiv4').hide();
                $('#levelIdDiv5').hide();
                $('#levelIdDiv6').hide();
            }
            else if (textVal == "Level 3") {
                $('#levelIdDiv1').show();
                $('#levelIdDiv2').show();
                $('#levelIdDiv3').show();
                $('#levelIdDiv4').hide();
                $('#levelIdDiv5').hide();
                $('#levelIdDiv6').hide();
            }
            else if (textVal == "Level 4") {
                $('#levelIdDiv1').show();
                $('#levelIdDiv2').show();
                $('#levelIdDiv3').show();
                $('#levelIdDiv4').show();
                $('#levelIdDiv5').hide();
                $('#levelIdDiv6').hide();
            }
            else if (textVal == "Level 5") {
                $('#levelIdDiv1').show();
                $('#levelIdDiv2').show();
                $('#levelIdDiv3').show();
                $('#levelIdDiv4').show();
                $('#levelIdDiv5').show();
                $('#levelIdDiv6').hide();
            }
            else if (textVal == "Level 6") {
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
                }
                else if ($('#shiftType').find("option:selected").val() == "ShiftBase") {
                    $('#shiftNameDiv').show();
                    $('#shiftRotationNameDiv').show();
                    $('#shiftRotationDateDiv').show();
                    $('#hourlyBaseTitleDiv').hide();
                    $('#shiftHoursId').val("");
                    //blanks another values on changes
                }
                else {
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
                var name = $('#empInfo_id').attr('class');
                if (name == 'box box-info collapsed-box') {
                    $("#empInfo_id").attr('class', 'box box-info');
                    document.getElementById('spanId1').innerHTML = 'Minimize';
                    $('#minusId1').attr('class', 'fa fa-minus');
                }
            }
            if (document.getElementById('motherName.errors').innerHTML) {
                var name = $('#empInfo_id').attr('class');
                if (name == 'box box-info collapsed-box') {
                    $("#empInfo_id").attr('class', 'box box-info');
                    document.getElementById('spanId1').innerHTML = 'Minimize';
                    $('#minusId1').attr('class', 'fa fa-minus');
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
                var name = $('#empInfo_id').attr('class');
                if (name == 'box box-info collapsed-box') {
                    $("#empInfo_id").attr('class', 'box box-info');
                    document.getElementById('spanId1').innerHTML = 'Minimize';
                    $('#minusId1').attr('class', 'fa fa-minus');
                }
            }
            if (document.getElementById('permanentAddress.errors').innerHTML) {
                var name = $('#empInfo_id').attr('class');
                if (name == 'box box-info collapsed-box ') {
                    $("#empInfo_id").attr('class', 'box box-info');
                    document.getElementById('spanId1').innerHTML = 'Minimize';
                    $('#minusId1').attr('class', 'fa fa-minus');
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
                var name = $('#personal_Detail_id').attr('class');
                if (name == 'box box-info collapsed-box') {
                    $("#personal_Detail_id").attr('class', 'box box-info');
                    document.getElementById('spanId2').innerHTML = 'Minimize';
                    $('#minusId2').attr('class', 'fa fa-minus');
                }
            }
            if (document.getElementById('panCard.errors').innerHTML) {
                var name = $('#document_detail_id').attr('class');
                if (name == 'box box-info collapsed-box ') {
                    $("#document_detail_id").attr('class', 'box box-info');
                    document.getElementById('spanId3').innerHTML = 'Minimize';
                    $('#minusId3').attr('class', 'fa fa-minus');
                }
            }
            if (document.getElementById('adharCard.errors').innerHTML) {
                var name = $('#document_detail_id').attr('class');
                if (name == 'box box-info collapsed-box') {
                    $("#document_detail_id").attr('class', 'box box-info');
                    document.getElementById('spanId3').innerHTML = 'Minimize';
                    $('#minusId3').attr('class', 'fa fa-minus');
                }
            }
            if (document.getElementById('officeEmailId.errors').innerHTML) {
                var name = $('#org_detail_id').attr('class');
                if (name == 'box box-info collapsed-box ') {
                    $("#org_detail_id").attr('class', 'box box-info');
                    document.getElementById('spanId4').innerHTML = 'Minimize';
                    $('#minusId4').attr('class', 'fa fa-minus');
                }
            }
            if (document.getElementById('highestEducationDetails.errors').innerHTML) {
                var name = $('#org_detail_id').attr('class');
                if (name == 'box box-info collapsed-box') {
                    $("#org_detail_id").attr('class', 'box box-info');
                    document.getElementById('spanId4').innerHTML = 'Minimize';
                    $('#minusId4').attr('class', 'fa fa-minus');
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
                var name = $('#org_detail_id').attr('class');
                if (name == 'box box-info collapsed-box') {
                    $("#org_detail_id").attr('class', 'box box-info');
                    document.getElementById('spanId4').innerHTML = 'Minimize';
                    $('#minusId4').attr('class', 'fa fa-minus');
                }
            }
            if (document.getElementById('dateOfJoining.errors').innerHTML) {
                var name = $('#org_detail_id').attr('class');
                if (name == 'box box-info collapsed-box ') {
                    $("#org_detail_id").attr('class', 'box box-info');
                    document.getElementById('spanId4').innerHTML = 'Minimize';
                    $('#minusId4').attr('class', 'fa fa-minus');
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


</html>

