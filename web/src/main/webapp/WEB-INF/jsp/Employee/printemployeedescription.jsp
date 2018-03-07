<%-- 
    Document   : printemployeedescription
    Created on : 28 Feb, 2018, 11:07:59 AM
    Author     : Dell-1
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
<!--    <script>
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
    </script>-->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Job Description:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Job Description</li>
           </ol>
        </section>
        <div class="col-sm-6" style="text-align: right;">
            <span style="alignment-adjust: middle;">
                <button type="button" id="mycmd" class="btn btn-primary" style="width: 100px;text-align: center;alignment-adjust: central;">PRINT</button>
            </span>
        </div>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form" action="employeeMaster.htm?act=editSubmit" commandName="employeeMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Custom Tabs -->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
<!--                                    <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>-->
                                    <!--form horizontal starts here-->
<!--                                    <div class="box box-info collapsed-box "id="printArea1">
                                        <div class="box-header">
                                            <h3 class="box-title">Personal Detail:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId1">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun1();"><i class="fa fa-plus" id="minusId1" ></i></button>
                                                                                                <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
                                            </div>
                                        </div>
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    
                                                        <div class="form-group">
                                                            <div class="col-sm-2">
                                                                <label>Employee No.:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                                <input type="Text" value="${employeeMaster.employeeId}" class="form-control" readonly/>
                                                            <input type="hidden" value="${employeeMaster.employeeId}" id="empid" name="empid"/>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label>Employee Name:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" value="${employeeMaster.employeeName}" class="form-control" readonly/>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Designation:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" value="${designationMaster.designationName}" class="form-control" readonly/>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label>Level:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" value="${levelMaster.level}" class="form-control" readonly/>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Department:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" value="${departmentMaster.departmentName}" class="form-control" readonly/>
                                                        </div>

                                                        <div class="col-sm-2">
                                                            <label>Reports To:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" value="${employeeMaster.reportingManagerLevel1}" class="form-control" readonly/>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Joining date:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" value="${employeeMaster.dateOfJoining}" class="form-control" readonly/>
                                                        </div>
                                                    </div>
                                            </div> /.col 
                                        </div> /.row 
                                    </div> /.box-body 
                                </div>-->
                                <div  id="printArea2">
<!--                                    <div class="box-header">
                                        <h3 class="box-title">Employee Certificate Attachments</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId8">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2();"><i class="fa fa-plus" id="minusId8" ></i></button>
                                            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
                                        </div>
                                    </div> /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                            <div class="box-body no-padding">
                                                <div class="row">
                                                        <div class="col-md-12 col-sm-12">
                                                            ${employeeMaster.jobDescription}
                                                        </div>
                                                        </div>
                                            </div>
                                                    
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                                        <div class="form-group">
                                                            <div class="col-sm-6" style="text-align: right;">
                                                    <button type="button" value="back" onclick="window.history.back()" id="buttonPressed" class="btn btn-warning" data-original-title="" style="width: 100px">BACK</button>
                                                </div>
                                                        </div>

                                </div>


                                <div class="tab-pane" id="tab_3"></div>
                            </div>
                        </div>
                    </div>
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
        $('#mycmd').click(function () {

//            var printContents = $("#printArea1").html();
            var printContents1 = $("#printArea2").html();
            var popupWin = window.open('', '_blank');
            var allLinks = $("#printCss").html();
            popupWin.document.open();
            var keepColors = '<style>body {-webkit-print-color-adjust: exact !important; }</style>';

            popupWin.document.write('<html><head><title></title>' + keepColors + allLinks + '</head><body onload="setTimeout(function(){window.print();},3000);">' + printContents1 + '</body></html>');
            popupWin.document.close();

        });



    </script>


</html>

