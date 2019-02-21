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
        function rejectClick() {
            var id = document.getElementById("id").value;
//            alert(id);
//            var remark = document.getElementById("remark").value;
//              alert(remark);
            window.location = 'shiftRotationMaster.htm?act=rejectSubmitByAdmincoff&id=' + id;
        }
    </script>
    <script>
        function reworkClick() {
            var id = document.getElementById("id").value;
//            var remark = document.getElementById("remark").value;
            window.location = 'shiftRotationMaster.htm?act=reworkSubmitByAdminCoff&id=' + id;
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
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>LIEU DAY ADDITION FORM  </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">LIEU DAY ADDITION</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form" action="shiftRotationMaster.htm?act=approvalEditCoffSubmitByAdmin" commandName="coffRegularization" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>

            <form:hidden path="id"></form:hidden>
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Custom Tabs -->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
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
                                                            <input type="hidden" class="form-control" id="empid" name="empid" value="${employeeMaster[0]}">
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
                                        </div><!-- /.box-body -->
                                    </div>
                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">Date & Time:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2()"><i class="fa fa-plus" id="minusId2"></i></button>
                                            </div>
                                        </div>
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">

                                                    <div class="form-group">
                                                        <div class="col-sm-6" >
                                                            <label>Start Date:<span style="color: red;font-size: 12px;">*</span></label>

                                                            <div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy hh:mm" data-link-field="dtp_input1" >
                                                                <form:input path="startDateCoff" class="form-control" size="16" value="" readonly="true" ></form:input>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-6" >
                                                                <label>End Date:<span style="color: red;font-size: 12px;">*</span></label>

                                                                <div class="input-group date form_datetime"    data-date-format="dd/mm/yyyy hh:mm" data-link-field="dtp_input1" >
                                                                <form:input path="endDateCoff" class="form-control" size="16" value="" readonly="true" ></form:input>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                </div>
                                                            </div>

                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-sm-6">
                                                                <label>Lieu Day Type:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <form:select path="coffType" class="form-control">
                                                                <!--<option value="">--SELECT--</option>-->
                                                                <form:option value="" label="-- Select --" ></form:option>
                                                                <form:option value="Half Lieu Day" label="Half Lieu Day"></form:option>
                                                                <form:option value="Full Lieu Day" label="Full Lieu Day"></form:option>
                                                            </form:select>
                                                            <%--<form:errors path="shiftType" cssClass="errorDiv"></form:errors>--%>
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
                                                            <form:textarea  path="approvalComment" class="form-control" rows="6"/>
                                                            <form:errors path="approvalComment" cssClass="errorDiv"></form:errors>
                                                            </div>
                                                        </div>
                                                    </div><!-- /.col -->
                                                </div><!-- /.row -->
                                            </div><!-- /.box-body -->
                                        </div>




                                    <c:if test="${status eq 3}">
                                        <div class="box box-info collapsed-box">
                                            <div class="box-header">
                                                <h3 class="box-title">Manager Remarks:</h3>
                                                <div class="box-tools pull-right">
                                                    <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun3()"><i class="fa fa-plus" id="minusId3"></i></button>
                                                </div>
                                            </div><!-- /.box-header -->
                                            <div class="box-body no-padding">
                                                <div class="row">
                                                    <div class="col-md-12 col-sm-12">
                                                        <div class="form-group">
                                                            <label class="col-sm-3 control-label">Manager Remark:</label>
                                                            <div class="col-sm-7">
                                                                <textarea class="form-control" rows="6" id="remark" name="remark" placeholder="Enter Remark" disabled="true">${remarkNmame}</textarea>
                                                            </div>
                                                        </div>
                                                    </div><!-- /.col -->
                                                </div><!-- /.row -->
                                            </div><!-- /.box-body -->
                                        </div>
                                    </c:if>
                                    <!--Reason In Detail completes Here-->
                                    <c:if test="${status eq 0}">
                                        <!--                                        <div class="box box-info collapsed-box">
                                                                                    <div class="box-header">
                                                                                        <h3 class="box-title">Manager Remarks:</h3>
                                                                                        <div class="box-tools pull-right">
                                                                                            <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun4()"><i class="fa fa-plus" id="minusId4"></i></button>
                                                                                        </div>
                                                                                    </div> /.box-header 
                                                                                    <div class="box-body no-padding">
                                                                                        <div class="row">
                                                                                            <div class="col-md-12 col-sm-12">
                                                                                                <div class="form-group">
                                                                                                    <label class="col-sm-3 control-label">Manager Remark:</label>
                                                                                                    <div class="col-sm-7">
                                                                                                        <textarea class="form-control" rows="6" id="remark" name="remark" placeholder="Enter Remark" ></textarea>
                                                                                                    </div>
                                                                                                </div>
                                                                                            </div> /.col 
                                                                                        </div> /.row 
                                                                                    </div> /.box-body 
                                                                                </div>-->
                                        <div class="form-group" id="sub_btn">
                                            <div class="col-sm-5  ">
                                                <button type="submit" class="btn btn-success" style="width: 100px;" data-original-title="" title="">APPROVE</button>
                                            </div>
                                            <div class="col-sm-3 ">
                                                <button type="button" class="btn btn-danger" style="width: 100px;" onclick="rejectClick();" data-original-title="">REJECT</button>
                                            </div>
                                            <div class="col-sm-4 ">
                                                <button type="button" class="btn btn-warning" style="width: 100px;float: right;" onclick="reworkClick();" data-original-title="">REWORK</button>
                                            </div>
                                        </div>
                                    </c:if>
                                    <%--<c:if test="${status eq 1}">--%>
                                    <!--                                        <div class="form-group" id="sub_btn">
                                                                                <div class="col-sm-5  ">
                                                                                    <button type="submit" class="btn btn-primary" style="width: 100px;background-color: #00b050;border-radius: 6px;font-weight: bold;  " data-original-title="" title="">APPROVE</button>
                                                                                </div>
                                                                                <div class="col-sm-3 ">
                                                                                    <button type="button" class="btn btn-danger" style="width: 100px;border-radius: 6px;font-weight: bold;" onclick="rejectClick();" data-original-title="">REJECT</button>
                                                                                </div>
                                                                                <div class="col-sm-4 ">
                                                                                    <button type="button" class="btn btn-warning" style="width: 100px;border-radius: 6px;font-weight: bold;float: right;" onclick="reworkClick();" data-original-title="">REWORK</button>
                                                                                </div>
                                                                            </div>-->
                                    <%--</c:if>--%>
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
            forceParse: 0,
            showMeridian: 1
        });
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
