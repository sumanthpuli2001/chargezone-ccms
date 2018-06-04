<%--
    Document   : HolidayCreateOrUpdate
    Created on : Oct 27, 2015, 4:51:00 PM
    Author     : Irfan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Holiday Create</title>
        <script>
            function dateValidator(counter) {
                var startDate = document.getElementById("holidayFromDate").value;
                var endDate = document.getElementById("holidayToDate").value;
                if (startDate) {
                    var startDatearray = startDate.split("/");
                    var endDatearray = endDate.split("/");
                    var sDate = new Date(startDatearray[2], startDatearray[1] - 1, startDatearray[0]);
                    var eDate = new Date(endDatearray[2], endDatearray[1] - 1, endDatearray[0]);
                    if (sDate > eDate) {
                        document.getElementById("holidayToDate").value = "";
                        alert("End date should be greater than Start date");
                        return false;
                    } else {
                        if (counter == 0) {
                            document.getElementById("holidayToDate").value = startDate;
                        }
                    }
                    counter++;
                } else {
                    document.getElementById("holidayToDate").value = "";
                    alert("startdate must not be empty");
                }
            }
        </script>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>ADD NEW HOLIDAY</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Add New Holiday</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>

                                <form:form class="form-horizontal" method="post"
                                           modelAttribute="holidayMaster" action="holidayMaster.htm?act=createOrUpdateSubmit">
                                    <form:hidden path="id"></form:hidden>

                                        <div class="form-group">
                                            <div class="col-sm-3">
                                            <form:label class="control-label" path="title">Enter Title:<span style="color: red;font-size: 12px;">*</span></form:label>
                                            </div>
                                            <div class="col-sm-7">
                                            <form:input path="title" class="form-control"/>
                                            <form:errors path="title" cssClass="errorDiv"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <form:label class="control-label" path="holidayFromDate">Start Date:<span style="color: red;font-size: 12px;">*</span></form:label>
                                            </div> 
                                            <div class="col-sm-7">
                                                <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                <form:input path="holidayFromDate" class="form-control" size="16" type="text" readonly="true" onchange="dateValidator(0);"></form:input>
                                                <form:errors path="holidayFromDate" cssClass="errorDiv"></form:errors>
                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-3">
                                            <form:label class="control-label" path="holidayToDate">End Date:<span style="color: red;font-size: 12px;">*</span></form:label>
                                            </div>
                                            <div class="col-sm-7">
                                                <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                <form:input path="holidayToDate" class="form-control" size="16" type="text" readonly="true" onchange="dateValidator(1);"></form:input>
                                                <form:errors path="holidayToDate" cssClass="errorDiv"></form:errors>
                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                </div>
                                            </div>
                                        </div>   

                                        <div class="form-group">
                                            <div class="col-sm-3">
                                            <form:label class="control-label" path="locationMaster.id">Location:<span style="color: red;font-size: 12px;">*</span></form:label>
                                            </div>
                                            <div class="col-sm-7">
                                            <form:select path="locationMaster.id" class="form-control">
                                                <form:option value="" label="-- Select --" />
                                                <form:options items="${locationMap}"/>
                                            </form:select>
                                            <form:errors path="locationMaster.id" cssClass="errorDiv"></form:errors>
                                            </div>
                                        </div>    
                                        <br/>
                                        <div class="form-group">
                                            <div class="col-sm-6 col-sm-offset-5">
                                                <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
                                            </div>
                                        </div>

                                </form:form>
                            </div>

                        </div><!-- /.col -->
                    </div><!-- /.row -->
                </div>
            </div><!-- /.tab-content -->
        </section>
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
            forceParse: 0,
            showMeridian: 1
        });
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
