<%--
    Document   : HoursBasisEdit
    Created on : Oct 10, 2015, 10:57:13 AM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hours Basis Edit</title>
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
            <h1>Hours Basis Edit </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>Home</a></li>
                <li class="active">Edit</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="hoursBasis.htm?act=editSubmit" method="post" commandName="hoursBasis"
                   name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
            <form:hidden path="id"></form:hidden>

                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Custom Tabs -->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                    <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                    <div class="box-header">

                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Title:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="title" class="form-control" placeholder="Enter Title"></form:input>
                                                    </div>
                                                    <div class=" col-sm-6">
                                                        <label>No Of Hours:<span style="color: red;font-size: 12px;">*</span></label>

                                                        <div class="input-group date form_datetime" data-date-format="hh:ii " data-link-field="dtp_input1">
                                                        <form:input path="noOfHours" class="form-control" ></form:input>
                                                        <form:errors path="noOfHours" cssClass="errorDiv"></form:errors>
                                                        <%--<form:input path="startTime" class="form-control" size="16" type="text" value=""></form:input>--%>
                                                        <!--<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>-->
                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class=" col-sm-6">
                                                    <label>Half No Of Hours:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="input-group date form_datetime" data-date-format="hh:ii " data-link-field="dtp_input1">
                                                        <form:input path="halfNoOfHours" class="form-control" size="16" type="text" value=""></form:input>
                                                        <form:errors path="halfNoOfHours" cssClass="errorDiv"></form:errors>
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
                                                        <label  style="font-weight: normal">Monday:</label>
                                                        &nbsp;&nbsp;&nbsp;
                                                    <c:choose>
                                                        <c:when test="${weekOf.contains('monday')}">
                                                            <input type="checkbox" value="monday" name="weekOf" id="weekOf" checked="true">
                                                        </c:when>
                                                        <c:otherwise>
                                                            <input type="checkbox" value="monday" name="weekOf" id="weekOf">
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                                <div class="col-sm-3">
                                                    <label  style="font-weight: normal">Tuesday:</label>
                                                    &nbsp;&nbsp;&nbsp;
                                                    <c:choose>
                                                        <c:when test="${weekOf.contains('tuesday')}">
                                                            <input type="checkbox" value="tuesday" name="weekOf" id="weekOf" checked="">
                                                        </c:when>
                                                        <c:otherwise>
                                                            <input type="checkbox" value="tuesday" name="weekOf" id="weekOf">
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                                <div class="col-sm-3">
                                                    <label  style="font-weight: normal">Wednesday:</label>
                                                    &nbsp;&nbsp;&nbsp;
                                                    <c:choose>
                                                        <c:when test="${weekOf.contains('wednesday')}">
                                                            <input type="checkbox" value="wednesday" name="weekOf" id="weekOf" checked="">
                                                        </c:when>
                                                        <c:otherwise>
                                                            <input type="checkbox" value="wednesday" name="weekOf" id="weekOf">
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                                <div class="col-sm-3">
                                                    <label  style="font-weight: normal">Thursday:</label>
                                                    &nbsp;&nbsp;&nbsp;
                                                    <c:choose>
                                                        <c:when test="${weekOf.contains('thursday')}">
                                                            <input type="checkbox" value="thursday" name="weekOf" id="weekOf" checked="">
                                                        </c:when>
                                                        <c:otherwise>
                                                            <input type="checkbox" value="thursday" name="weekOf" id="weekOf">
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <label  style="font-weight: normal">Friday:</label>
                                                    &nbsp;&nbsp;&nbsp;
                                                    <c:choose>
                                                        <c:when test="${weekOf.contains('friday')}">
                                                            <input type="checkbox" value="friday" name="weekOf" id="weekOf" checked="">
                                                        </c:when>
                                                        <c:otherwise>
                                                            <input type="checkbox" value="friday" name="weekOf" id="weekOf">
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                                <div class="col-sm-3">
                                                    <label  style="font-weight: normal">Saturday:</label>
                                                    &nbsp;&nbsp;&nbsp;
                                                    <c:choose>
                                                        <c:when test="${weekOf.contains('saturday')}">
                                                            <input type="checkbox" value="saturday" name="weekOf" id="weekOf" checked="">
                                                        </c:when>
                                                        <c:otherwise>

                                                            <input type="checkbox" value="saturday" name="weekOf" id="weekOf">
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                                <div class="col-sm-3">
                                                    <label  style="font-weight: normal">Sunday:</label>
                                                    &nbsp;&nbsp;&nbsp;
                                                    <c:choose>
                                                        <c:when test="${weekOf.contains('sunday')}">

                                                            <input type="checkbox" value="sunday" name="weekOf" id="weekOf" checked="">
                                                        </c:when>
                                                        <c:otherwise>
                                                            <input type="checkbox" value="sunday" name="weekOf" id="weekOf" >

                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div><!-- /.col -->
                                            <%--</c:forEach>--%>
                                            <%--</c:forEach>--%>
                                        </div><!-- /.row -->
                                        <div class="col-md-12" style="text-align: center;">
                                            <button type="submit" class="btn btn-primary" id="saveSubmit1" >Submit</button>
                                        </div>
                                    </div><!-- /.box-body -->
                                </div><!-- /.tab-content -->
                            </div><!-- nav-tabs-custom -->
                        </div><!-- /.col -->
                    </div>
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

