<%-- 
    Document   : PaymentTypeCreate.jsp
    Created on : Jan 30, 2020, 3:11:12 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment Type Create</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>ADD NEW PAYMENT TYPE</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Add NEW PAYMENT TYPE</li>
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
                              <form:form class="form-horizontal" method="post"
                                           modelAttribute="employeeTypeMaster" action="payment.html?act=createSubmit">
                                    <form:hidden path="id"></form:hidden>

                                        <div class="form-group">
                                            <div class="col-sm-3">
                                                <label class="control-label">Enter Payment Type:<span style="color: red;font-size: 12px;">*</span></label>
                                            </div>
                                            <div class="col-sm-7">
                                            <form:input path="typeOfEmployee" class="form-control"  placeholder="Enter Payment Type"  maxlength="30"/>
                                            <form:errors path="typeOfEmployee" cssClass="errorDiv"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
                                        </div>
                                        <!--                                        <div class=" col-sm-offset-2 col-sm-3 ">
                                                                                    <button type="button" class="btn btn-danger" data-original-title="" title="" onclick="window.location = 'departmentMaster.htm?act=showList'">Cancel</button>
                                                                                </div>-->
                                    </div>
                                </form:form>
                            
                           <%-- <form action = "payment.html?act=createSubmit" method = "POST">
                               <!-- <input type="hidden" name = "id" value="${id}">-->
                                <div class="form-group">
                                    <div class="col-sm-3">
                                        <label class="control-label">Enter Payment Type:<span style="color: red;font-size: 12px;">*</span></label>
                                    </div>
                                    <div class="col-sm-7">
                                        <input type="text" name = "payment_Type">
                                    </div>
                                </div>
                                <!--<br />
                                Last Name: <input type = "text" name = "last_name" />-->
                                <input type = "submit" value = "Submit" />
                             </form>--%>
                                
                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    
</html>