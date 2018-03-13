<%-- 
    Document   : RegistrationTrainer
    Created on : Mar 9, 2018, 2:29:57 PM
    Author     : Aman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Create Budget</title>
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Trainer Create</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Budget Create</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="box-header">
                            </div>
                            <div class="box-body no-padding">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12">
                                        <div class="table table-bordered">
                                        </div>
                                        <!--<div class="form-group">-->


                                        <form:form class="form-horizontal" method="post" onsubmit='return deleteCheck11();'
                                                   commandName="trainer" action="trainer.htm?act=trainerCreate">
                                            <form:hidden path="id"/>
                                            <form:hidden path="createdBy"/>
                                            <form:hidden path="createdDate"/>
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Trainer Name :<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="trainerName" class="form-control" placeholder="Enter Trainer Name"></form:input>
                                                    <form:errors path="trainerName" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>User Name :<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="userName" class="form-control" placeholder="Enter UserName"></form:input>
                                                    <form:errors path="userName" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <!--<div class="form-group">-->
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Password :<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="password" class="form-control"></form:input>
                                                    <form:errors path="password" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Email Id :<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="emailId" pattern="[^ @]*@[^ @]*" class="form-control" placeholder="abc@domain.com" required=""></form:input>
                                                    <form:errors path="emailId" cssClass="errorDiv"></form:errors>
                                                    </div>

                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Status<span style="color: red;font-size: 12px;">*</span></label>
                                                    <%--<form:input path="status" class="form-control" placeholder="Number Of Position"></form:input>--%>
                                                    <fieldset id="group1">
                                                        <form:radiobutton path="status" value="1"/>Active&nbsp;&nbsp;
                                                        <form:radiobutton path="status" value="0"/>InActive
                                                    </fieldset>
                                                    <form:errors path="status" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6 col-sm-offset-5">
                                                        <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
                                                    </div>

                                                </div>
                                        </form:form>
                                        <!--</div>-->

                                    </div><!-- /.col -->
                                </div><!-- /.row -->
                            </div>
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section>
    </div>
    <script type="text/javascript">
        $('.form_datetime').datetimepicker({
            //language:  'fr',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });

    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
