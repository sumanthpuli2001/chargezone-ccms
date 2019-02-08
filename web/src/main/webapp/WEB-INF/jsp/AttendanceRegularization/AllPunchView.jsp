<%-- 
    Document   : AllPunchView
    Created on : 10 Jan, 2019, 2:40:35 PM
    Author     : Teja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Date Time Edit</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>EDIT DATE TIME</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Edit</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                                <form:form class="form-horizontal" method="post"
                                           commandName="employeeDatetimeData" action="attendanceRegularizationMaster.htm?act=editSubmit1">
                                    <form:hidden path="id"></form:hidden>
                                    <form:hidden path="employeeMaster.id"></form:hidden>
                                    <form:hidden path="deviceMaster.id"></form:hidden>

                                   <div class="form-group">
                                        <div class="col-sm-6">
                                            <label>Date and Time:</label>
                                            <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy hh:ii:ss" data-link-field="dtp_input1">
                                                <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                            <form:input path="dateTime" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                            </div>
                                        </div>
                                   </div>                 
                                        <div class="form-group">
                                            <div class="col-sm-6 col-sm-offset-5">
                                                <input type="submit" class="btn btn-primary" style="width: 100px;" title="" value="SUBMIT">
                                            </div>

                                        </div>
                                </form:form>
                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->

    <script type="text/javascript">
        var dt = new Date();
        dt.setFullYear(new Date().getFullYear() - 10);
        var dt1 = new Date();
        dt1.setFullYear(new Date().getFullYear() + 10);
        $('.form_datetime').datetimepicker({
            format: 'dd/mm/yyyy hh:ii:ss',
//            language: 'pt-BR',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            forceParse: 0,
            showMeridian: 0,
            startDate: dt,
            endDate: dt1
        });
    </script>
    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
       
</html>
