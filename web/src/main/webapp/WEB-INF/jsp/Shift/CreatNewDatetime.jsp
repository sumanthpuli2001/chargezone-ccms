<%-- 
    Document   : CreatNewDatetime
    Created on : 10 May, 2019, 4:06:50 PM
    Author     : Teja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%--<%@include file="/WEB-INF/jsp/Common/Header.jsp"%>--%>
    <%--<%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>--%>
    <script src="StorageYard/Plugins/datatables/jquery.dataTables.min.js"></script>
    <script src="StorageYard/Plugins/datatables/dataTables.bootstrap.min.js"></script>
    <%@include file="/WEB-INF/jsp/Common/Top.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Date and Time Add</title>
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




    <!--<div class="content-wrapper">-->
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>DATE AND TIME ADD </h1>
<!--            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Edit</li>
            </ol>-->
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="attendanceRegularizationMaster.htm?act=newSubmit" method="post" commandName="employeeDatetimeData"
                   name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
            <%--<form:hidden path="id"></form:hidden>--%>
            <%--<form:hidden path="employeeMaster.id"></form:hidden>--%>
            <input type="hidden" name="empId" id="empId" value="${empId}" />
            <input type="hidden" name="id" id="id" value="${empId}" />
            <input type="hidden" name="date" id="date" value="${date}" />
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
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                            <label>Date and Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy h:i:ss" data-link-field="dtp_input1">
                                                            <form:input path="dateTime" class="form-control" size="16" value="" readonly="true"></form:input>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        <%--<form:errors path="dateOfJoining" cssClass="errorDiv"></form:errors>--%>
                                                        </div>
                                                </div>
                                                <!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                        <hr/>
                                        <div class="col-md-12" style="text-align: center;">
                                            <button type="submit" class="btn btn-primary" id="saveSubmit1" >Submit</button>
                                        </div>
                                    </div><!-- /.tab-content -->
                                </div><!-- nav-tabs-custom -->
                            </div><!-- /.col -->
                        </div>
                    </div>
                </section>

        </form:form>
       
        <!--<div class="tab-pane" id="tab_3"></div> /.tab-pane -->
        <!-- /.content -->
    <!--</div>-->
    <script type="text/javascript">
    $('.form_datetime').datetimepicker({
        //language:  'fr',
        weekStart: 1,
        showMeridian: 1,
//        startDate: new Date(),
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 0,
        maxView: 1,
        forceParse: 0
    });</script>
    <%--<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>--%>
</html>
