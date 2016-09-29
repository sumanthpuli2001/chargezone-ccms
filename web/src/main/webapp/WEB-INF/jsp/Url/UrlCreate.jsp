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
        <title>Web Service URL</title>
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
            <h1>Web Service URL: </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Url Create</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="urlMaster.htm?act=submitClick" method="post" commandName="urlMaster"
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
                                                    <label>IP Address:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="ipAddress" class="form-control" placeholder="Enter Ip Address"></form:input>
                                                    <form:errors path="ipAddress" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    </div>
                                                        <div class="form-group">
                                                    <div class=" col-sm-6">
                                                        <label>Port Number:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="portNumber" class="form-control" placeholder="Port Number"></form:input>
                                                    <form:errors path="portNumber" cssClass="errorDiv"></form:errors>
                                                    </div>
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

                <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
                </html>
