<%-- 
    Document   : EditPunch
    Created on : 24-Jun-2020, 10:53:00
    Author     : Aman Bahukhandi 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Punch</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Edit Punch</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Edit Punch</li>
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
                                <form action="specialCoupon.htm?act=editPunchedSubmit" method="post" commandName="punchedDataMaster"
                                      class="form-horizontal" role="form">
                                    <input type="hidden" name="srNo" id="srNo" value="${list[0][1]}"/>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Code :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input value="${list[0][2]}" class="form-control" readonly="true"  maxlength="30" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Name :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input value="${list[0][0]}" class="form-control" readonly="true"  maxlength="30" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Date :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input value="${list[0][3]}" class="form-control" readonly="true"  maxlength="30" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Time :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input value="${list[0][4]}" class="form-control" readonly="true"  maxlength="30" />
                                        </div>
                                    </div>
                                        <div class="form-group" style="pointer-events: none">
                                        <div class="col-sm-3">
                                            <label class="control-label">Item :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <select name="item" id="item" readonly="true" class="form-control"/>
                                            <c:forEach var="coupon" items="${couponMap}">
                                                <c:choose>
                                                    <c:when test="${coupon.key eq list[0][5]}">
                                                        <option value="${coupon.key}" selected="true">${coupon.value}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${coupon.key}">${coupon.value}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Price :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input id="price" name="price" value="${list[0][7]}" step="0.01" min="0" max="100" required="required"  class="form-control"   />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="Update">
                                        </div>
                                    </div>
                                </form>

                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>


</html>
