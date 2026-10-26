<%-- 
    Document   : VendorRequestApprovalView
    Created on : 22 Jan, 2025, 2:51:28 PM
    Author     : bulwarks-2
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendor Request Approval</title>


    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">

            <div style="display: flex; height: 25px;
                 justify-content: space-between;
                 align-items: center;">
                <h3 style="margin-top: 1px;">Vendor Request Approval</h3>
                <input type="button"  class="btn btn-primary" style="" onclick="history.back();" title="" value="Back" >
            </div>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">

                            <div class="tab-pane active" id="tab_1">
                                <span style="color: red;font-size: 14px;">* Indicates Mandatory Field.</span>
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                                <form:form action="vendorInvitation.htm?act=vendorRequestApprovalSubmit" method="post" commandName="vendorRequestDetails"
                                           class="form-horizontal" role="form">
                                    <input name = "id" type="hidden" id="id" value="${id1}">
                                    <div class="form-group">
                                        <div class="col-sm-2">
                                            <label class="control-label">Company Name :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="company" class="form-control" readonly="true"  maxlength="30" required="required"/>
                                        </div>
                                        
                                        <div class="col-sm-2">
                                            <label class="control-label">Contact Name :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">                                            

                                            <form:input path="contactaName" class="form-control" readonly="true"  maxlength="30" required="required"/>
                                        </div>
                                  
                                    </div>
                                        

                                    <div class="form-group">
                                        <div class="col-sm-2">
                                            <label class="control-label">Email ID :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">                                            

                                            <form:input path="email" class="form-control" readonly="true"  maxlength="30" required="required"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Contact No :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">                                            

                                            <form:input path="phoneNo" class="form-control" readonly="true"   maxlength="30" required="required"/>
                                        </div>
                                    </div>
                                     <div class="form-group">
                                        <div class="col-sm-2">
                                            <label class="control-label">Address :<span style="color: red;font-size: 12px;"></span></label>
                                        </div>
                                        <div class="col-sm-3">                                            

                                            <form:input path="address" class="form-control" readonly="true"  maxlength="30" />
                                        </div>
                                       
                                    </div>
                                        
                                         <div class="form-group">
                                        <div class="col-sm-2">
                                            <label class="control-label">Justification for Recommendation :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">                                            

                                            <form:input path="description" class="form-control" readonly="true"  maxlength="30" required="required"/>
                                        </div>
                                       
                                    </div>
                                

                                           
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Comment:<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <textarea type="text"  required="true" class="form-control" id="comment" name="comment"></textarea>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">

                                            <input type="submit" class="btn btn-primary" style="width: 100px;" value="Approve">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;" formaction="vendorInvitation.htm?act=vendorRequestRecycle" title="" value="Rework" >
                                            <input type="submit" class="btn btn-primary" style="width: 100px;" formaction="vendorInvitation.htm?act=vendorRequestReject" title="" value="Reject" >
                                        </div>
                                    </div>
                                        </div>
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
<%@include file="/WEB-INF/jsp/Common/Footer1.jsp"%>
<script src="StorageYard/JS/login/jquery.backstretch.min.js"></script>
</html>

