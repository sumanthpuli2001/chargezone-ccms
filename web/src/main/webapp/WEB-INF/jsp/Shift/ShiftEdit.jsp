<%--
    Document   : ShiftEdit
    Created on : Oct 9, 2015, 4:40:36 PM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shift Edit</title>
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

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>SHIFT EDIT </h1>

        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="shiftMaster.htm?act=editSubmit" method="post" commandName="shiftMaster"
                   name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">

            <!--<form class="form-horizontal" role="form" commandName>-->
            <form:hidden path="id"></form:hidden>
            <input type="hidden" name="id" id="id" value="${shiftMaster.id}">

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

                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Shift Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="shiftName" class="form-control" placeholder="Enter shiftName"></form:input>
                                                    </div>
                                                    <div class=" col-sm-6">
                                                        <label>Start-Time:<span style="color: red;font-size: 12px;">*</span></label>

                                                        <div class="input-group date form_datetime" data-date-format="hh:ii " data-link-field="dtp_input1">
                                                        <form:input path="startTime" class="form-control" placeholder="StartTime"></form:input>
                                                        <form:errors path="startTime" cssClass="errorDiv"></form:errors>
                                                        <%--<form:input path="startTime" class="form-control" size="16" type="text" value=""></form:input>--%>
                                                        <!--<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>-->
                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class=" col-sm-6">
                                                    <label>End-Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="input-group date form_datetime" data-date-format="hh:ii " data-link-field="dtp_input1">
                                                        <form:input path="endTime" class="form-control" size="16" type="text" value=""></form:input>
                                                        <form:errors path="endTime" cssClass="errorDiv"></form:errors>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    </div>
                                                    <div class=" col-sm-6">
                                                        <label>Late-Hours:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="input-group date form_datetime" data-date-format="hh:ii " data-link-field="dtp_input1">
                                                        <form:input path="lateHours" class="form-control" size="16" type="text" value=""></form:input>
                                                        <form:errors path="lateHours" cssClass="errorDiv"></form:errors>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!--                                                <div class="form-group">
                                                                                                    <div class=" col-sm-6">
                                                                                                        <label>Early-Hours:<span style="color: red;font-size: 12px;">*</span></label>
                                                                                                        <div class="input-group date form_datetime" data-date-format="hh:ii " data-link-field="dtp_input1">
                                            <%--<form:input path="earlyHours" class="form-control" size="16" type="text" value=""></form:input>--%>
                                            <%--<form:errors path="earlyHours" cssClass="errorDiv"></form:errors>--%>
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                            </div>
                                        </div>
                                    </div>-->
                                            <div class="form-group">
                                                <div class=" col-sm-6">
                                                    <label>1st Half:</label>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class=" col-sm-6">
                                                    <label>Start Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="input-group date form_datetime" data-date-format="hh:ii " data-link-field="dtp_input1">
                                                        <form:input path="halfStartTime1" class="form-control" size="16" type="text" value=""></form:input>
                                                        <form:errors path="halfStartTime1" cssClass="errorDiv"></form:errors>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    </div>
                                                    <div class=" col-sm-6">
                                                        <label>End Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="input-group date form_datetime" data-date-format="hh:ii " data-link-field="dtp_input1">
                                                        <form:input path="halfEndTime1" class="form-control" size="16" type="text" value=""></form:input>
                                                        <form:errors path="halfEndTime1" cssClass="errorDiv"></form:errors>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class=" col-sm-6">
                                                        <label>2nd Half:</label>
                                                    </div>
                                                </div>
                                                <div class="form-group">

                                                    <div class=" col-sm-6">
                                                        <label>Start Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="input-group date form_datetime" data-date-format="hh:ii " data-link-field="dtp_input1">
                                                        <form:input path="halfStartTime2" class="form-control" size="16" type="text" value=""></form:input>
                                                        <form:errors path="halfStartTime2" cssClass="errorDiv"></form:errors>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>End Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="input-group date form_datetime" data-date-format="hh:ii " data-link-field="dtp_input1">
                                                        <form:input path="halfEndTime2" class="form-control" size="16" type="text" value=""></form:input>
                                                        <form:errors path="halfEndTime2" cssClass="errorDiv"></form:errors>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class=" col-sm-6">
                                                        <label>Week Off:</label>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-3">
                                                        <label style="font-weight: normal;">Monday:</label>
                                                        &nbsp;&nbsp;&nbsp;
                                                    <c:choose>
                                                        <%--<c:forEach var="list" items="${ofDayList}">--%>

                                                        <c:when test="${weekOf.contains('monday')}">
                                                            <input type="checkbox" value="monday" name="weekOf" id="weekOf" style="height: 15px;width: 15px" checked="true">
                                                        </c:when>
                                                        <c:otherwise>
                                                            <input type="checkbox" value="monday" name="weekOf" id="weekOf" style="height: 15px;width: 15px">
                                                        </c:otherwise>
                                                    </c:choose>

                                                </div>
                                                <div class="col-sm-3">
                                                    <label style="font-weight: normal;">Tuesday:</label>
                                                    &nbsp;&nbsp;&nbsp;
                                                    <c:choose>
                                                        <c:when test="${weekOf.contains('tuesday')}">
                                                            <input type="checkbox" value="tuesday" name="weekOf" id="weekOf" style="height: 15px;width: 15px" checked="">
                                                        </c:when>
                                                        <c:otherwise>
                                                            <input type="checkbox" value="tuesday" name="weekOf" id="weekOf" style="height: 15px;width: 15px">
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                                <div class="col-sm-3">
                                                    <label style="font-weight: normal;">Wednesday:</label>
                                                    &nbsp;&nbsp;&nbsp;
                                                    <c:choose>
                                                        <c:when test="${weekOf.contains('wednesday')}">
                                                            <input type="checkbox" value="wednesday" name="weekOf" id="weekOf" style="height: 15px;width: 15px" checked="">
                                                        </c:when>
                                                        <c:otherwise>
                                                            <input type="checkbox" value="wednesday" name="weekOf" id="weekOf" style="height: 15px;width: 15px">
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                                <div class="col-sm-3">
                                                    <label style="font-weight: normal;">Thursday:</label>
                                                    &nbsp;&nbsp;&nbsp;
                                                    <c:choose>
                                                        <c:when test="${weekOf.contains('thursday')}">
                                                            <input type="checkbox" value="thursday" name="weekOf" id="weekOf" style="height: 15px;width: 15px" checked="">
                                                        </c:when>
                                                        <c:otherwise>
                                                            <input type="checkbox" value="thursday" name="weekOf" id="weekOf" style="height: 15px;width: 15px">
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <label style="font-weight: normal;">Friday:</label>
                                                    &nbsp;&nbsp;&nbsp;
                                                    <c:choose>
                                                        <c:when test="${weekOf.contains('friday')}">
                                                            <input type="checkbox" value="friday" name="weekOf" id="weekOf" style="height: 15px;width: 15px" checked="">
                                                        </c:when>
                                                        <c:otherwise>
                                                            <input type="checkbox" value="friday" name="weekOf" id="weekOf" style="height: 15px;width: 15px">
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                                <div class="col-sm-3">
                                                    <label style="font-weight: normal;">Saturday:</label>
                                                    &nbsp;&nbsp;&nbsp;
                                                    <c:choose>
                                                        <c:when test="${weekOf.contains('saturday')}">
                                                            <input type="checkbox" value="saturday" name="weekOf" id="weekOf" style="height: 15px;width: 15px" checked="">
                                                        </c:when>
                                                        <c:otherwise>

                                                            <input type="checkbox" value="saturday" name="weekOf" id="weekOf" style="height: 15px;width: 15px">
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                                <div class="col-sm-3">
                                                    <label style="font-weight: normal;">Sunday:</label>
                                                    &nbsp;&nbsp;&nbsp;
                                                    <c:choose>
                                                        <c:when test="${weekOf.contains('sunday')}">

                                                            <input type="checkbox" value="sunday" name="weekOf" id="weekOf" style="height: 15px;width: 15px" checked="">
                                                        </c:when>
                                                        <c:otherwise>
                                                            <input type="checkbox" value="sunday" name="weekOf" id="weekOf" style="height: 15px;width: 15px" >

                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>



                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                                    <div class="col-sm-12" style="text-align: center;">
                                        <button type="submit" class="btn btn-primary" id="saveSubmit1" >Submit</button>
                                    </div>
                                </div><!-- /.box-body -->
                                <!--                                <hr/>-->
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
            //            language: 'fr',
            weekStart: 1,
            //            todayBtn: 1,
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
