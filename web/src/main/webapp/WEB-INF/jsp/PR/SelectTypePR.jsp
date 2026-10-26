<%-- 
    Document   : EmployeeCreate
    Created on : Jun 11, 2020, 2:39:39 PM
    Author     : Prachi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Select Type</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Select Type</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Select Type</li>
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
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                                <form:form action="tenderMaster.htm?act=createTender" method="post" commandName="tenderMaster"
                                           class="form-horizontal" role="form">
                                    
                                        <div class="form-group">
                                            <div class="col-sm-3">
                                                <a href="prMaster.htm?act=selectPR&prType=Service&ref_no=${ref_no}">Service PR</a>
                                            </div>
                                        </div>
                                    
                                        <div class="form-group">
                                            <div class="col-sm-3">
                                                <a href="tenderMaster.htm?act=selectManualTender">Material PR</a>
                                            </div>
                                        </div>
                                    
                                    <!--<div class="form-group">
                                        <div class="col-sm-3">
                                            <a href="tenderMaster.htm?act=selectServiceTypeTender">Service</a>
                                        </div>
                                    </div> -->
                                        
                                    
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
