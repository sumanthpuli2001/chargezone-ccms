<%-- 
    Document   : AddDepartment
    Created on : Oct 9, 2015, 4:03:56 PM
    Author     : Irfan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Certificate Template Create</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Certificate Template:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Certificate Template</li>
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
                                <br/>
                                <br/>
                                <form:form class="form-horizontal" method="post" 
                                           commandName="certificateTemplate" action="certificateTemplate.htm?act=editSubmit">
                                    <form:hidden path="id"></form:hidden>

                                        <div class="form-group">
                                            <div class="col-sm-3">
                                                <label class="control-label">Enter Title:<span style="color: red;font-size: 12px;">*</span></label>
                                            </div>
                                            <div class="col-sm-7">
                                            <form:input path="certificateTitle" class="form-control" readonly="true"/>
                                            <form:errors path="certificateTitle" cssClass="errorDiv"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Enter Certificate Type:<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-7">
                                            <form:input path="certificateType" class="form-control" readonly="true"/>
                                            <form:errors path="certificateType" cssClass="errorDiv"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Enter Certificate Name:<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-7">
                                            <form:input path="certificateName" class="form-control" readonly="true"/>
                                            <form:errors path="certificateName" cssClass="errorDiv"/>
                                        </div>
                                    </div>
                                   
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Enter Message Script:<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-7">

                                            <div class="grid-container">
                                                <div class="grid-width-100">
                                                    <form:textarea  path="certificateBody" id="editor"></form:textarea>
                                                    <form:errors path="certificateBody" cssClass="errorDiv"/>

                                                    <!--                                                    <div id="editor">
                                                                                                            <h1>Hello world!</h1>
                                                                                                            <p>I'm an instance of <a href="http://ckeditor.com">CKEditor</a>.</p>
                                                                                                        </div>-->
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5 ">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="Submit">
                                        </div>
                                        <!--                                        <div class=" col-sm-offset-2 col-sm-3 ">
                                                                                    <button type="button" class="btn btn-danger" data-original-title="" title="" onclick="window.location = 'departmentMaster.htm?act=showList'">Cancel</button>
                                                                                </div>-->
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
    <script src="StorageYard/Plugins/ckeditor/ckeditor.js"></script>
    <script src="StorageYard/Plugins/ckeditor/samples/js/sample.js"></script>
    <!--<link rel="stylesheet" href="StorageYard/Plugins/ckeditor/samples/css/samples.css">-->
    <link rel="stylesheet" href="StorageYard/Plugins/ckeditor/samples/toolbarconfigurator/lib/codemirror/neo.css">
    <script>
        initSample();
    </script>
</html>
