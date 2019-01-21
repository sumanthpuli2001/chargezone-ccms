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
//            alert("hii");
            try {
                var strDate = document.getElementById("startDateTime").value;
                var enDate = document.getElementById("endDateTime").value;
//                alert(strDate);
//                alert(enDate);
                if (strDate != '') {
                    $.ajax({
                        type: "POST",
                        url: "attendanceRegularizationMaster.htm?act=differentForSDate&strDate=" + strDate + "&enDate=" + enDate,
                        data: {},
                        dataType: "text",
                        success: function (responseTxt) {
//                            alert(responseTxt);
                            document.getElementById("differentCompare").value = responseTxt;

//                            if (responseTxt != '') {
//                                document.getElementById("startDateTime").value = "";
//                                document.getElementById("endDateTime").value = "";
//                            }
                        },
                        error: function () {

                        }
                    });
                }
//                if (enDate != '') {
//                    $.ajax({
//                        type: "POST",
//                        url: "leaveEmployeeDetail.htm?act=checkWeekOffOrHolidayForEDate&enDate=" + enDate,
//                        data: {},
//                        dataType: "text",
//                        success: function (responseTxt) {
//                            document.getElementById("endwoandHlerrorDiv").innerHTML = responseTxt;
//                            if (responseTxt != '') {
//                                document.getElementById("startDateTime").value = "";
//                                document.getElementById("endDateTime").value = "";
//                            }
//                        },
//                        error: function () {
////                            alert('Error occured');
//                        }
//                    });
//                }
//                && sDateStatus != '' && eDateStatus != ''


            } catch (e) {

            }
        }
    </script>



    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>OT REGULARIZATION FORM  </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">OT Regularization</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form" action="shiftRotationMaster.htm?act=editSubmitOtRequest" commandName="otRegularization" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>


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
                                        </div><!-- /.box-body -->
                                    </div>

                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">Time In Detail:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2()"><i class="fa fa-plus" id="minusId2"></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <div class="col-sm-4">
                                                            <label>Start Date & Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy  hh:ii" data-link-field="dtp_input1">
                                                                <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                                <form:input path="startDateTime" id="startDateTime" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" onchange="calculateDayByAjax();"></form:input>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                </div>
                                                            <form:errors path="startDateTime" cssClass="errorDiv"></form:errors>
                                                                <span id="woandHlerrorDiv" style="color: red;"></span>
                                                                <span id="woandHlerrorDiv1" style="color: red;"></span>

                                                            </div>
                                                            <div class="col-sm-4">
                                                                <label>End Date & Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy  hh:ii" data-link-field="dtp_input1">
                                                                    <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                                <form:input path="endDateTime"  id="endDateTime" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" onchange="calculateDayByAjax();"></form:input>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                </div>
                                                            <form:errors path="endDateTime" cssClass="errorDiv"></form:errors>
                                                                <span id="endwoandHlerrorDiv" style="color: red;"></span>
                                                            </div>
                                                            <div class="col-sm-4">
                                                                <label>Time Difference(HH:MM):<span style="color: red;font-size: 12px;"></span></label>
                                                                <form:input path="differentCompare" id="differentCompare" class="form-control"  readonly="true" ></form:input>
                                                                <!--<input type="Text" name="differentCompare" id="endwoandHlerrorDivvvvv" class="form-control" value="" readonly>-->
                                                            </div>




                                                        </div>
                                                        <div class="col-md-12 col-sm-12">
                                                            <div class="form-group">
                                                                <div class="col-sm-4">
                                                                    <label>UK Manager Name:<span style="color: red;font-size: 12px;"></span></label>
                                                                    <form:input path="arType"  class="form-control"   ></form:input> 
                                                                </div>
                                                                <div class="col-sm-4">
                                                                    <label>Client:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <form:select path="clientDetailsMaster.id" class="form-control ">
                                                                    <%--<form:option value="" label="-- Select --" ></form:option>--%>
                                                                    <form:options items="${clientMaster}"></form:options>
                                                                </form:select>
                                                                <%--<form:errors path="locationMaster.id" cssClass="errorDiv"></form:errors>--%>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- /.col -->
                                                </div><!-- /.row -->
                                            </div><!-- /.box-body -->
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
                                                                <form:textarea  path="reason" class="form-control" rows="6"/>
                                                                <form:errors path="reason" cssClass="errorDiv"></form:errors>
                                                                </div>
                                                            </div>
                                                        </div><!-- /.col -->
                                                    </div><!-- /.row -->
                                                </div><!-- /.box-body -->
                                            </div>
                                            <!--Reason In Detail completes Here-->
                                        <c:if test="${status eq 7}">
                                            <div class="box box-info collapsed-box">
                                                <div class="box-header">
                                                    <h3 class="box-title">Manager Remarks:</h3>
                                                    <div class="box-tools pull-right">
                                                        <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun4()"><i class="fa fa-plus" id="minusId4"></i></button>
                                                    </div>
                                                </div><!-- /.box-header -->
                                                <div class="box-body no-padding">
                                                    <div class="row">
                                                        <div class="col-md-12 col-sm-12">
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Manager Remarks:</label>
                                                                <div class="col-sm-7">
                                                                    <textarea class="form-control" rows="6" id="remark" name="remark" disabled="true">${remark}</textarea>
                                                                </div>
                                                            </div>
                                                        </div><!-- /.col -->
                                                    </div><!-- /.row -->
                                                </div><!-- /.box-body -->
                                            </div>
                                            <div class="row">
                                                <div class="col-sm-6">

                                                    <button type="submit" class="btn btn-primary " data-original-title="" title="" value="Submit" name="btnSubmit" id="btnSubmit" style="width: 100px;text-align:center;">SUBMIT</button>
                                                </div>
                                                <div class="col-sm-6 ">
                                                    <button type="submit" class="btn btn-warning" data-original-title="" title="" value="Withdraw" name="btnSubmit" id="btnSubmit" style="width: 100px;text-align:center;float: right;">WITHDRAW</button>
                                                </div>
                                            </div>

                                        </c:if>
                                        <c:if test="${status eq 0}">
                                            <!--                                                                                    <div class="col-sm-6">
    
                                                                                                                                    <button type="submit" class="btn btn-primary " data-original-title="" title="" style="width: 100px;text-align:center;">SUBMIT</button>
                                                                                                                                </div>-->
                                            <div class="row">
                                                <div class="col-sm-6 col-sm-offset-5">
                                                    <button type="submit" class="btn btn-warning" data-original-title="" title="" value="Withdraw" name="btnSubmit" id="btnSubmit" style="width: 100px;text-align:center;">WITHDRAW</button>
                                                </div>
                                            </div>

                                        </c:if>
                                        <c:if test="${status eq 18}">
                                            <!--                                                                                    <div class="col-sm-6">
    
                                                                                                                                    <button type="submit" class="btn btn-primary " data-original-title="" title="" style="width: 100px;text-align:center;">SUBMIT</button>
                                                                                                                                </div>-->
                                            <div class="row">
                                                <div class="col-sm-6 col-sm-offset-5">
                                                    <button type="submit" class="btn btn-warning" data-original-title="" title="" value="Withdraw" name="btnSubmit" id="btnSubmit" style="width: 100px;text-align:center;">WITHDRAW</button>
                                                </div>
                                            </div>

                                        </c:if>
                                        <c:if test="${status eq null}">
                                            <div class="row">
                                                <div class="col-sm-6">

                                                    <button type="submit" class="btn btn-primary " data-original-title="" title="" value="Submit" name="btnSubmit" id="btnSubmit" style="width: 100px;text-align:center;">SUBMIT</button>
                                                </div>
                                                <div class="col-sm-6 ">
                                                    <button type="submit" class="btn btn-warning" data-original-title="" title="" value="Withdraw" name="btnSubmit" id="btnSubmit" style="width: 100px;text-align:center;float: right;">WITHDRAW</button>
                                                </div>
                                            </div>

                                        </c:if>
                                        <c:if test="${status eq 2}">
                                            <div class="box box-info collapsed-box">
                                                <div class="box-header">
                                                    <h3 class="box-title">Manager Remarks:</h3>
                                                    <div class="box-tools pull-right">
                                                        <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun4()"><i class="fa fa-plus" id="minusId4"></i></button>
                                                    </div>
                                                </div><!-- /.box-header -->
                                                <div class="box-body no-padding">
                                                    <div class="row">
                                                        <div class="col-md-12 col-sm-12">
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Manager Remarks:</label>
                                                                <div class="col-sm-7">
                                                                    <textarea class="form-control" rows="6" id="remark" name="remark" disabled="true">${remark}</textarea>

                                                                </div>
                                                            </div>
                                                        </div><!-- /.col -->
                                                    </div><!-- /.row -->
                                                </div><!-- /.box-body -->
                                            </div>
                                            <!--                                                                                <div class="row">
                                                                                                                                <div class="col-sm-6">
    
                                                                                                                                    <button type="submit" class="btn btn-primary " data-original-title="" title="" style="width: 100px;text-align:center;">SUBMIT</button>
                                                                                                                                </div>
                                                                                                                                <div class="col-sm-6">
                                                                                                                                    <button type="submit" class="btn btn-warning" data-original-title="" title="" style="width: 100px;text-align:center;float: right;">WITHDRAW</button>
                                                                                                                                </div>
                                                                                                                            </div>-->

                                        </c:if>
                                        <c:if test="${status eq 1}">

                                            <div class="box box-info collapsed-box">
                                                <div class="box-header">
                                                    <h3 class="box-title">Manager Remarks:</h3>
                                                    <div class="box-tools pull-right">
                                                        <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun4()"><i class="fa fa-plus" id="minusId4"></i></button>
                                                    </div>
                                                </div><!-- /.box-header -->
                                                <div class="box-body no-padding">
                                                    <div class="row">
                                                        <div class="col-md-12 col-sm-12">
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Manager Remarks:</label>
                                                                <div class="col-sm-7">
                                                                    <textarea class="form-control" rows="6" id="remark" name="remark" disabled="true">${remark}</textarea>
                                                                </div>
                                                            </div>
                                                        </div><!-- /.col -->
                                                    </div><!-- /.row -->
                                                </div><!-- /.box-body -->
                                            </div>
                                            <!--                                            <div class="col-sm-6">
    
                                                                                            <button type="submit" class="btn btn-primary " data-original-title="" title="" style="width: 100px;text-align:center;">SUBMIT</button>
                                                                                        </div>-->
                                            <div class="row">
                                                <div class="col-sm-6 col-sm-offset-5">
                                                    <button type="submit" class="btn btn-warning" data-original-title="" title="" value="Withdraw" name="btnSubmit" id="btnSubmit" style="width: 100px;text-align:center;">WITHDRAW</button>
                                                </div>
                                            </div>

                                            <!--                                            <div class="col-sm-6">
    
                                                                                            <button type="submit" class="btn btn-primary " data-original-title="" title="" style="width: 100px;text-align:center;">SUBMIT</button>
                                                                                        </div>
                                                                                        <div class="col-sm-6">
                                                                                            <button type="submit" class="btn btn-warning" data-original-title="" title="" style="width: 100px;text-align:center;float: right;">WITHDRAW</button>
                                                                                        </div>-->

                                        </c:if>
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
        $('#business').hide();
        $('.form_datetime').datetimepicker({
            //language:  'fr',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            forceParse: 0,
            showMeridian: 1,
//            endDate: new Date()
        });
    </script>

    <script>
        $(document).ready(function () {
            $('#purpose').on('change', function () {
                if (this.value == 'Compassion')
                        //.....................^.......
                        {
                            $("#business").show();
                        }
                else
                {
                    $("#business").hide();
                }
            });
        });
    </script>


    <!--    <script>
            $('#start_time,#end_time').on('change', function ()
            {
                //            var start_time = 0;
                //            var end_time = 0;
                var start_time = $('#start_time').val();
                var end_time = $('#end_time').val();
    
                var diff = new Date(end_time) - new Date(start_time);
                var num = isNaN(parseInt(diff)) ? 0 : parseInt(diff);
    
    
    
                //              var  diff_time = diff/(60*60*1000);______________________
    
                var seconds = Math.floor(diff / 1000); //______________ignore any left over units smaller than a second
                var minutes = Math.floor(seconds / 60);
                seconds = seconds % 60;
                var hours = Math.floor(minutes / 60);
                minutes = minutes % 60;
    
    
                //               alert("Diff = " + hours + ":" + minutes + ":" + seconds);______________________________
    
                $('#setup_hours').val(+hours + ":" + minutes + ":" + seconds);
    
            });
    
        </script>-->

    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
