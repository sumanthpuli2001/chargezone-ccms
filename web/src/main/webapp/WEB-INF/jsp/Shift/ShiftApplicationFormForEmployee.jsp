<%--
    Document   : attendanceRegularizationFormForEmployee
    Created on : Oct 6, 2015, 10:38:59 AM
    Author     : Dhaval Patel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <script>
        var flag3 = true;
        function saveSubmit11() {
//            alert("vxcvxcvjk");
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
        $(document).ready(function () {
            shift();
            var rotationId = document.getElementById("shiftId").value;
            selectShift(rotationId);
        });

        function shift() {
            var selectedValue = document.getElementById('WorkTypeSelectId').value;
            if (selectedValue == "HourlyBase") {
                $('#hourlyBaseTitleDiv').show();
                $('#shiftNameDiv').hide();
                $('#shiftMasterId').hide();
                $('#shiftRotationDateDiv').hide();
            } else if (selectedValue == "ShiftBase") {
                $('#shiftNameDiv').show();
                $('#shiftMasterId').show();
                $('#hourlyBaseTitleDiv').hide();
                $('#shiftRotationDateDiv').show();
            } else {
                $('#hourlyBaseTitleDiv').hide();
                $('#shiftNameDiv').hide();
                $('#shiftMasterId').hide();
                $('#shiftRotationDateDiv').hide();
            }
        }
//        function selectShift(rotationId) {
//
//            var userId = document.getElementById("userId").value;
////            document.getElementById('shiftMasterId').innerHTML = "Fetching ... .. .";
//            $.post("shiftRotationMaster.htm?act=readRotationAjax",
//                    {
//                        rotationId: rotationId, userId: userId
//                    }, function (responseTxt, statusTxt, xhr) {
//                if (statusTxt === "success") {
//                    document.getElementById('shiftMasterId').innerHTML = responseTxt;
//                }
//                if (statusTxt === "error")
//                    alert("Error: " + xhr.status + ": " + xhr.statusText);
//            });
//        }
        function selectShiftChange(date) {
//----------------------------------------//
           
//            var shiftId = document.getElementById("shiftId").value;
           
            $("#newShift option").remove();
            $.ajax({
//                 date: date, rotationId: shiftId,
                type: "POST",
                data: {"date": date, 'shiftId': " "},
                url: "shiftRotationMaster.htm?act=readRotationAjaxShiftCHange",
                success: function (content)
                {
                    var obj = JSON.parse(content);
                    var count = Object.keys(obj['shiftAjaxMap']).length;
                    var data = "";
                    var desigJSON = obj['shiftAjaxMap'];
                    var desigJSONKey = Object.keys(obj['shiftAjaxMap']);
                    for (var i = 0; i < count; i++) {
                       
                        if (desigJSONKey[i] === obj['firstShiftId']) {
                               document.getElementById('newShift').value = obj['firstShiftId'];
                            data += "<option selected value=" + desigJSONKey[i] + ">" + desigJSON[desigJSONKey[i]] + "</option>";
                        } else {
//                            data += "<option value=" + year + ">" + year + "</option>";
                            data += "<option value=" + desigJSONKey[i] + " >" + desigJSON[desigJSONKey[i]] + "</option>";
                        }
//                        data += "<option value=" + desigJSONKey[i] + " >" + desigJSON[desigJSONKey[i]] + "</option>";
                    }
//                    console.log(obj)
//                    var data = obj['firstShiftId'];
                    $(data).appendTo('#newShift');
//                        $('#newShift').val(data);
                 
                }
            });
        }
// -----------------------------------------//
//            alert(date);
//            var shiftId = document.getElementById("shiftId").value;
////            document.getElementById('shiftMasterId').innerHTML = "Fetching ... .. .";
//            $.post("shiftRotationMaster.htm?act=readRotationAjaxShiftCHange",
//                    {
//                        date: date, rotationId: shiftId
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
    </script>
    <script>
        function calculateDayByAjax() {
            try {
                var strDate = document.getElementById("startDateTime").value;
                var enDate = document.getElementById("endDateTime").value;
                if (strDate != '') {
                    $.ajax({
                        type: "POST",
                        url: "leaveEmployeeDetail.htm?act=checkWeekOffOrHolidayForSDate&strDate=" + strDate,
                        data: {},
                        dataType: "text",
                        success: function (responseTxt) {
                            document.getElementById("woandHlerrorDiv").innerHTML = responseTxt;
                            if (responseTxt != '') {
                                document.getElementById("startDateTime").value = "";
                                document.getElementById("endDateTime").value = "";
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
                            document.getElementById("endwoandHlerrorDiv").innerHTML = responseTxt;
                            if (responseTxt != '') {
                                document.getElementById("startDateTime").value = "";
                                document.getElementById("endDateTime").value = "";
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
        function checkDateByAjax() {
            try {
                var strDate = document.getElementById("startDateTime").value;
                if (strDate != '') {
                    $.ajax({
                        type: "POST",
                        url: "attendanceRegularizationMaster.htm?act=checkPunchtime&strDate=" + strDate,
                        data: {},
                        dataType: "text",
                        success: function (responseTxt) {
                            document.getElementById("woandHlerrorDiv1").innerHTML = responseTxt;
                            if (responseTxt != '') {
                                document.getElementById("startDateTime").value = "";
                            }
                        },
                        error: function () {

                        }
                    });
                }
            } catch (e) {

            }
        }
    </script>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>SHIFT REGULARIZATION FORM  </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Attendance Regularization</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form" action="shiftRotationMaster.htm?act=createSubmitShiftRegurization" commandName="shiftRegularization" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>


            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                <!--form horizontal starts here-->
                                <form class="form-horizontal" role="form">

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
                                                            <input type="hidden" id="empid" name="empid" value="${employeeMaster[0]}">
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
                                                            <input type="Text"  class="form-control" value="${employeeMaster[11]}" readonly>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label>Sub-Team:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control" value="${employeeMaster[12]}" readonly>
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
                                        </div><!-- /.box-body -->
                                    </div>


                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">Change Shift:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2()"><i class="fa fa-plus" id="minusId2"></i></button>
                                            </div>
                                        </div>
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group" >
                                                        <div class="col-sm-6">
                                                            <label>Work Type:</label>
                                                            <select name="shiftType" id="shiftType" class="form-control" onchange="shift();" >
                                                                <c:if test="${shiftType eq 'HourlyBase'}">
                                                                    <option value="HourlyBase" selected="">Hourly Base</option>
                                                                    <option value="ShiftBase">Shift Base</option>
                                                                </c:if>
                                                                <c:if test="${shiftType eq 'ShiftBase'}">
                                                                    <option value="ShiftBase" selected="">Shift Base</option>
                                                                    <!--<option value="HourlyBase">Hourly Base</option>-->
                                                                </c:if>
                                                                <c:if test="${shiftType eq ''}">
                                                                    <option value="" label="-- Select --" ></option>
                                                                    <!--<option value="HourlyBase" label="Hourly Base"></option>-->
                                                                    <option value="ShiftBase" label="Shift Base"></option>
                                                                </c:if>

                                                            </select>
                                                        </div>
                                                        <div class="col-sm-6" id="shiftRotationDateDiv">
                                                            <label>Shift Rotation Date:<span style="color: red;font-size: 12px;">*</span></label>

                                                            <div class="input-group date form_datetime"  name="shiftIdChange" id="shiftIdChange"  data-date-format="dd/mm/yyyy" data-link-field="dtp_input1" >
                                                                <form:input path="rotationDate" class="form-control" size="16" value="" readonly="true" onchange="selectShiftChange(this.value)"></form:input>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                </div>
                                                            </div>
                                                            <!--<input type="hidden" name="preciousShiftId" id="preciousShiftId"/>-->
                                                        
<!--                                                        <div class="col-sm-6" >
                                                            <label>Shift Rotation Name:<span style="color: red;font-size: 12px;">*</span></label>

                                                            <select name="shiftName1" id="shiftName1" value="{shiftList}" class="form-control" onclick="rotationNameOFShift(this.value)" >
                                                                <option value="" label="-- Select --" ></option>
                                                            </select>
                                                        </div>-->
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6" id="shiftMasterId">
                                                            <label>Shift Name:<span style="color: red;font-size: 12px;"></span></label>
                                                            <select readonly="true" name="newShift"  id="newShift" class="form-control">
                                                              <option value="" >${newShift}</option>
                                                           </select>
                                                        </div> 
                                                        <div class="col-sm-6" >
                                                            <label>Shift Rotation Name:<span style="color: red;font-size: 12px;">*</span></label>

                                                            <select  name="shiftMasterCurrent" id="shiftMasterCurrent" value="${shiftMasterCurrent}" class="form-control">
                                                                <option value="" label="-- Select --" ></option>
                                                                    <c:forEach var="shift1" items="${shift}">
                                                                    <option value="${shift1.key}" >${shift1.value}</option>
                                                                    </c:forEach>    
                                                            <select>
                                                        </div>
                                                    </div>


                                                </div>
                                            </div>
                                        </div>
                                    </div>
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
                                                        <label class="col-sm-3 control-label">Reason for Request:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="col-sm-7">
                                                            <form:textarea  path="comment" class="form-control" rows="6"/>
                                                            <form:errors path="comment" cssClass="errorDiv"></form:errors>
                                                            </div>
                                                        </div>
                                                    </div><!-- /.col -->
                                                </div><!-- /.row -->
                                            </div><!-- /.box-body -->
                                        </div>
                                        <!--Reason In Detail completes Here-->
                                        <div class="form-group">
                                            <div class="col-sm-12" style="text-align: center;">
                                                <button type="submit" class="btn btn-primary" data-original-title="" style="width: 100px;" title="">SUBMIT</button>
                                            </div>
                                        </div>
                                    </form>
                                    <!--form horizontal ends here-->
                                    <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
                                </div><!-- /.tab-content -->
                            </div><!-- nav-tabs-custom -->
                        </div><!-- /.col -->
                    </div>
                </section><!-- /.content -->
        </form:form>
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
//            maxView: 1,
            forceParse: 0
        });
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
