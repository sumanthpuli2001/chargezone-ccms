<%-- 
    Document   :
    Created on : Oct 19, 2015, 5:34:20 PM
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Edit PMP Form Status</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Edit PMP Form</li>
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
                                <form:form class="form-horizontal" method="post"   commandName="pmpFormStatusMaster" action="pmpFormStatusMaster.htm?act=editSubmit">
                                    <form:hidden path="id"></form:hidden>

                                        <div class="form-group">
                                            <div class="col-sm-3">
                                                <label class="control-label">Employee ID:</label>
                                            </div>
                                            <div class="col-sm-6">
                                            <form:input path="employeeMaster.id" class="form-control" readonly="true"></form:input>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-3">
                                                <label class="control-label">Employee Name:</label>
                                            </div>
                                            <div class="col-sm-6">
                                            <form:input path="employeeMaster.employeeName" class="form-control" readonly="true"></form:input>
                                            </div>
                                        </div>
                                        &nbsp;&nbsp;
                                        &nbsp;&nbsp;



                                        <div class="form-group">
                                            <div class="col-sm-4">
                                                <label>Start Year Status</label>&nbsp;&nbsp;
                                                <fieldset id="group1">
                                                <form:radiobutton path="startYearStatus" value="true"/>Lock
                                                <form:radiobutton path="startYearStatus" value="false"/>Unlock
                                            </fieldset>

                                        </div>

                                        <div class="col-sm-4">
                                            <label>Mid Year Status</label>&nbsp;&nbsp;
                                            <fieldset id="group1">
                                                <form:radiobutton path="midYearStatus" value="true"/>Lock
                                                <form:radiobutton path="midYearStatus" value="false"/>Unlock
                                            </fieldset>
                                        </div>

                                        <div class="col-sm-4">
                                            <label>End Year Status</label>&nbsp;&nbsp;
                                            <fieldset id="group1">
                                                <form:radiobutton path="endYearStatus" value="true"/>Lock
                                                <form:radiobutton path="endYearStatus" value="false"/>Unlock
                                            </fieldset>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-4">
                                            <label>Manager Side</label>&nbsp;&nbsp;
                                            <fieldset id="group1">
                                                <form:radiobutton path="managerSide" value="true" />Lock
                                                <form:radiobutton path="managerSide" value="false" />Unlock
                                            </fieldset>
                                        </div>

                                        <div class="col-sm-4">
                                            <label>Employee Side</label>&nbsp;&nbsp;
                                            <fieldset id="group1">
                                                <form:radiobutton path="employeeSide" value="true"/>Lock
                                                <form:radiobutton path="employeeSide" value="false"/>Unlock
                                            </fieldset>
                                        </div>

                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            &nbsp;&nbsp;
                                            <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
                                        </div>
                                    </div>

                                </form:form>
                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
