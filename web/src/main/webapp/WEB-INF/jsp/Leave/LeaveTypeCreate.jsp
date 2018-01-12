<%--
    Document   : LeaveTypeCreate
    Created on : Oct 14, 2015, 10:11:47 AM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Leave Type Create</title>
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
            <h1>Leave Type Create: </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Leave Type Create</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="leaveTypeMaster.htm?act=createSubmit" method="post" commandName="leaveTypeMaster"
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

                                </div><!-- /.box-header -->
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Leave Type:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="leaveType" class="form-control" placeholder="Enter Leave Type"></form:input>
                                                    <form:errors path="leaveType" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class=" col-sm-6">
                                                        <label>No Of Leave:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="noOfLeave" class="form-control" type="number" min="0"></form:input>
                                                    <form:errors path="noOfLeave" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class=" col-sm-6">
                                                        <label>Max Days Allowed Leave:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="maxDayAllowedLeave" class="form-control" size="16" type="number" value="" min="0"></form:input>
                                                    <form:errors path="maxDayAllowedLeave" cssClass="errorDiv"></form:errors>
                                                    </div>

                                                </div>
                                                <div class="col-sm-6">
                                                    <label>SandWich Leave Apply:<span style="color: red;font-size: 12px;"></span></label>&nbsp;&nbsp;
                                                    <%--<form:select path="gender" id="gender" class="form-control">--%>
                                                <fieldset id="group1">
                                                    <form:radiobutton path="sandwichLeave" value="true"/>Yes&nbsp;&nbsp;
                                                    <form:radiobutton path="sandwichLeave" value="false"/>No
                                                    <%--<form:option value="">--SELECT--</form:option>--%>
                                                    <%--<form:option value="0">Male</form:option>--%>
                                                    <%--<form:option value="1">Female</form:option>--%>
                                                </fieldset>
                                                <%--</form:select>--%>
                                                <form:errors path="" cssClass="errorDiv"></form:errors>

                                                </div>
                                                <div class="form-group">
                                                    <div class=" col-sm-6">
                                                        <label>Carried Forward:</label>&nbsp;&nbsp;<form:checkbox path="carriedForwardStatus"></form:checkbox>
                                                    </div>
                                                </div>

                                                <div class="form-group" id="chechBoxDivId" style="display: none">
                                                    <div class=" col-sm-6">
                                                        <label>No Of Leave Carried Forward:</label>
                                                    <form:input path="noOfCarriedForwardLeave" class="form-control" size="16" type="number" value="" min="0"></form:input>
                                                    <form:errors path="noOfCarriedForwardLeave" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>

                                                <!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div><!-- /.tab-content -->
                                    <br/>
                                    <div class="form-group">
                                        <div class=" col-sm-12" style="text-align: center;">
                                            <button type="submit" class="btn btn-primary" id="saveSubmit1" style="width: 100px;">SUBMIT</button>
                                        </div>                                    
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
                <script>
                    $('#carriedForwardStatus1').on('ifChecked', function (event) {
                        $('#chechBoxDivId').show(500);
                    });
                    $('#carriedForwardStatus1').on('ifUnchecked', function (event) {
                        $('#chechBoxDivId').hide(500);
                    });


                </script>
                </html>
