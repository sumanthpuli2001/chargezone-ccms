<%--
    Document   : ShiftCreate
    Created on : Oct 9, 2015, 10:47:55 AM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>



    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shift Create</title>
    </head>

    <script>
        var flag3 = true;
        function saveSubmit11() {
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
        function checkName() {
            var ab1 = document.getElementById("shiftName").value;
            $.post("shiftMaster.htm?act=readShiftNameAjax",
                    {
                        shiftName: ab1
                    }, function (responseTxt, statusTxt, xhr) {
                if (statusTxt === "success") {
                    if (responseTxt == 'false') {
                        document.getElementById('shiftNameExist').innerHTML = "<p style='color: red'>ShiftName Already Exists</p>";
                        document.getElementById("shiftName").value = "";
                    } else {
                        document.getElementById('shiftNameExist').innerHTML = "";
                    }
                }
                if (statusTxt === "error")
                    alert("Error: " + xhr.status + ": " + xhr.statusText);
            });
        }
    </script>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>SHIFT CREATE </h1>

        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="shiftMaster.htm?act=createSubmit" method="post" commandName="shiftMaster"
                   name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">

            <!--<form class="form-horizontal" role="form" commandName>-->

            <!--Read only entries Starts here-->
            <!--<div class="box box-info collapsed-box ">-->
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                <div class="box-header">
                                    <!--<h3 class="box-title">Employee Detail:</h3>-->
                                    <!--                                        <div class="box-tools pull-right">
                                                                                <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
                                                                            </div>-->
                                </div><!-- /.box-header -->
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="box-header">
                                                <h3 class="box-title col-sm-3">General Information:</h3>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Shift Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div>
                                                        <form:input path="shiftName" class="form-control" placeholder="Enter shiftName" onchange="checkName()"></form:input>
                                                        </div>
                                                        <div id="shiftNameExist"></div>
                                                    <form:errors path="shiftName" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class=" col-sm-6">
                                                        <label>Start-Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="input-group date form_datetime" data-date-format="hh:ii " data-link-field="dtp_input1">
                                                        <form:input path="startTime" class="form-control" size="16" type="text" value=""></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>

                                                    <form:errors path="startTime" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class=" col-sm-6">
                                                        <label>End-Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="input-group date form_datetime" data-date-format="hh:ii " data-link-field="dtp_input1">
                                                        <form:input path="endTime" class="form-control" size="16" type="text" value=""></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    <form:errors path="endTime" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class=" col-sm-6">
                                                        <label>Late-Hours:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="input-group date form_datetime" data-date-format="hh:ii " data-link-field="dtp_input1">
                                                        <form:input path="lateHours" class="form-control" size="16" type="text" value=""></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    <form:errors path="lateHours" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <!--                                                <div class="form-group">
                                                                                                    <div class=" col-sm-6">
                                                                                                        <label>Early-Hours:<span style="color: red;font-size: 12px;">*</span></label>
                                                                                                        <div class="input-group date form_datetime" data-date-format="hh:ii " data-link-field="dtp_input1">
                                            <%--<form:input path="earlyHours" class="form-control" size="16" type="text" value=""></form:input>--%>
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                            </div>
                                            <%--<form:errors path="earlyHours" cssClass="errorDiv"></form:errors>--%>
                                            </div>
                                        </div>-->
                                            <div class="box-header">
                                                <h3 class="box-title col-sm-3">1st Half:<span style="color: red;font-size: 12px;">*</span></h3>
                                            </div>
                                            <div class="form-group">
                                                <div class=" col-sm-6">
                                                    <label>Start Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="input-group date form_datetime" data-date-format="hh:ii " data-link-field="dtp_input1">
                                                        <form:input path="halfStartTime1" class="form-control" size="16" type="text" value=""></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    <form:errors path="halfStartTime1" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class=" col-sm-6">
                                                        <label>End Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="input-group date form_datetime" data-date-format="hh:ii " data-link-field="dtp_input1">
                                                        <form:input path="halfEndTime1" class="form-control" size="16" type="text" value=""></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    <form:errors path="halfEndTime1" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="box-header">
                                                    <h3 class="box-title col-sm-3">2nd Half:</h3>
                                                </div>
                                                <div class="form-group">

                                                    <div class=" col-sm-6">
                                                        <label>Start Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="input-group date form_datetime" data-date-format="hh:ii " data-link-field="dtp_input1">
                                                        <form:input path="halfStartTime2" class="form-control" size="16" type="text" value=""></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    <form:errors path="halfStartTime2" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>End Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="input-group date form_datetime" data-date-format="hh:ii " data-link-field="dtp_input1">
                                                        <form:input path="halfEndTime2" class="form-control" size="16" type="text" value=""></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    <form:errors path="halfEndTime2" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="box-header">
                                                    <h3 class="box-title col-sm-3">Week Of:</h3>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">Monday:</label>
                                                    <div class="checkbox col-sm-2">
                                                        <input type="checkbox" value="monday" name="weekOf" id="weekOf" style="height: 15px;width: 15px">
                                                    </div>
                                                    <label class="col-sm-3 control-label">Tuesday:</label>
                                                    <div class="checkbox col-sm-2">
                                                        <input type="checkbox" value="tuesday" name="weekOf" id="weekOf" style="height: 15px;width: 15px">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3  control-label">Wednesday:</label>
                                                    <div class="checkbox col-sm-2">
                                                        <input type="checkbox" value="wednesday" name="weekOf" id="weekOf" style="height: 15px;width: 15px">
                                                    </div>
                                                    <label class="col-sm-3  control-label">Thursday:</label>
                                                    <div class="checkbox col-sm-2">
                                                        <input type="checkbox" value="thursday" name="weekOf" id="weekOf" style="height: 15px;width: 15px">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3  control-label">Friday:</label>
                                                    <div class="checkbox col-sm-2">
                                                        <input type="checkbox" value="friday" name="weekOf" id="weekOf" style="height: 15px;width: 15px">
                                                    </div>
                                                    <label class="col-sm-3  control-label">Saturday:</label>
                                                    <div class="checkbox col-sm-2">
                                                        <input type="checkbox" value="saturdady" name="weekOf" id="weekOf" style="height: 15px;width: 15px">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3  control-label">Sunday:</label>
                                                    <div class="checkbox col-sm-2">
                                                        <input type="checkbox" value="sunday" name="weekOf" id="weekOf" style="height: 15px;width: 15px">
                                                    </div>
                                                </div>
                                                <div class="col-md-12" style="text-align: center;">
                                                    <button type="submit" class="btn btn-primary" id="saveSubmit1" >Submit</button>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div><!-- /.tab-content -->
                            </div><!-- nav-tabs-custom -->
                        </div><!-- /.col -->
                    </div>
                </section>

        </form:form>
        <!--</div>-->
        <!--Employee detail completes here-->
        <!--read only entries ends here-->

        <!--form horizontal ends here-->
        <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
        <!-- /.content -->
    </div>
    <script type="text/javascript">
        $('.form_datetime').datetimepicker({
            language: 'fr',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 1,
            minView: 0,
            maxView: 1,
            forceParse: 0
        });
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

</html>
