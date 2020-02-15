<%-- 
    Document   : PaymentStatusResult
    Created on : Feb 14, 2020, 5:12:12 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%--<%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>--%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment Status</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Payment Status</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>

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
                                <!--<span style="color: red;font-size: 14px;">* indicates mandatory field.</span>-->
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <form:form class="form-horizontal" method="post" action="payment.html?act=gotoHome" commandName="paymentStatus" >
                                    <div>

                                        <div class="form-group">

                                            <div class="col-sm-2">
                                                <label>Order Id3:</label>
                                            </div>
                                            <div class="col-sm-4">
                                               <form:input path="orderId" class="form-control" ></form:input>
                                            </div>
                                            <div class="col-sm-2">
                                                <label>Status:</label>
                                            </div>
                                            <div class="col-sm-4">
                                                <form:input path="status" class="form-control" ></form:input>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                

                        </form:form>




                    </div><!-- /.tab-pane -->
                </div><!-- /.tab-content -->
            </div><!-- nav-tabs-custom -->
    <!-- /.col -->
</section><!-- /.content -->
</div><!-- /.content-wrapper -->
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

</html>
