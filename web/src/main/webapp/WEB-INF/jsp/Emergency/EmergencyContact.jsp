<%-- 
    Document   : EmergencyContact
    Created on : May 3, 2018, 1:59:37 PM
    Author     : DELL3
--%>

<%-- 
    Document   : ApplayLoginpage
    Created on : 23 Feb, 2018, 11:59:06 AM
    Author     : Vikas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Emergency Contact</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Emergency Contact:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Emergency Contact Create/Update</li>
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
                                <c:if test="${!empty faliureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${faliureMessage}</div>
                                </c:if>
                                <form:form class="form-horizontal" method="post" commandName="emergencyContact" action="emergencyContact.htm?act=contactCreateUpdate">
                                    <form:hidden path="id"/>
                                    <form:hidden path="createdBy"/>
                                    <form:hidden path="createdDate"/>
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                            <label>Emergency Contact Description:<span style="color: red;font-size: 12px;">*</span></label>
                                            <form:textarea  path="contactDescription" id="editor" ></form:textarea>
                                            <form:errors path="contactDescription" cssClass="errorDiv"/>
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
