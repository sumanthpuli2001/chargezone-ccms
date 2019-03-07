<%--
    Document   : LeaveApplicatioFormForEmployee
    Created on : Oct 6, 2015, 11:17:03 AM
    Author     : Irfan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>LEAVE APPLICATION </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Leave Request</li>
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
                            <!--form horizontal starts here-->
                            <!--Read only entries Starts here-->
                            <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                            <form:form action="leaveEmployeeDetail.htm?act=employeeLeaveApplicationClick" method="post" commandName="leaveEmployeeDetail"
                                       name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
                                <div class="box box-info">
                                    <div class="box-header">
                                        <h3 class="box-title">Employee Detail:</h3>
                                      
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-md-6" id="employeeName">
                                                        <label>Employee Name:</label>
                                                        <input type="text" id="employeeMasterId" name="employeeMasterId" class="form-control">
                                                    </div>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12" style="text-align: center;">
                                        <button type="submit" id="sunmit_button" class="btn btn-primary" style="width: 100px;" data-original-title="" title="">SUBMIT</button>
                                    </div>
                                </div>

                            </form:form>
                            <!--form horizontal ends here-->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->



    <script>
        jQuery.noConflict();
        jQuery(document).ready(function () {
        jQuery("#employeeMasterId").tokenInput(${list}, {
        preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. .",
            });
        });   
    </script>

    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <style>
        .class-with-width { width: 150px !important; }
    </style>    
    <script type="text/javascript" src="StorageYard/Plugins/alert/bootbox.min.js"></script>  
</html>
