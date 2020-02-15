<%-- 
    Document   : PaymentStatusPage
    Created on : Feb 14, 2020, 4:04:04 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%--<%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>--%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment Status Search</title>
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
                                <form:form class="form-horizontal" method="post" action="payment.html?act=PaymentConfirmation" commandName="paymentStatus" >
                                    <div>

                                        <div class="form-group">
                                            <!--                            <div class="col-sm-4">
                                                                            <div for="inputPassword" class="control-label" style="color: black;font-weight: bold;margin-top:50px;">Order Id:</div>
                                                                        </div>
                                                                        <div class="col-sm-6">
                                                                            <input type="text" path="emailL1" class="form-control" style="margin-top:50px;" readonly="true">
                                                                        </div>
                                                                        <div class="col-sm-4">
                                                                            <div for="inputPassword" class="control-label" style="color: black;font-weight: bold;margin-top:50px;">Status:</div>
                                                                        </div>
                                                                        <div class="col-sm-6">
                                                                            <textarea type="text" path="emailL1" class="form-control" style="margin-top:50px;" readonly="true"></textarea>
                                                                        </div>-->

                                            <div class="col-sm-2">
                                                <label>Order Id:</label>
                                            </div>
                                            <div class="col-sm-4">
                                                <input type="Text" id="orderId" name="orderId"  style="color: black;font-weight: bold;" class="form-control"  >
                                            </div>
<!--                                            <div class="col-sm-2">
                                                <label>Status:</label>
                                            </div>
                                            <div class="col-sm-4">
                                                <textarea type="Text" class="form-control" name="status" style="color: black;font-weight: bold;" class="control-label" readonly  ></textarea>
                                            </div>-->
                                        </div>
                                    </div>

                                </div>
                                <button type="submit" class="btn btn-primary" id="saveSubmit1" >SEARCH</button>

                                <!--<hr />-->

                                <!--<button type="button" class="btn btn-primary" id="saveSubmit1" onclick="window.location = 'logIn.html?act=loginClick';">Go To Login</button>-->

                            </div>

                            <%--<spring:bind path="level">--%>
                            <%--<c:set value='${status.value}' var='levelValue' />--%>
                            <%--<c:choose>--%>
                            <%--<c:when test="${levelValue eq 1}"><script>click11();</script></c:when>--%>

                            <%--</c:choose>--%>
                            <%--</spring:bind>--%>

                        </form:form>




                    </div><!-- /.tab-pane -->
                </div><!-- /.tab-content -->
            </div><!-- nav-tabs-custom -->
    <!-- /.col -->
</section><!-- /.content -->
</div><!-- /.content-wrapper -->
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

</html>
