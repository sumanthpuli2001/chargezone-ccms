<%-- 
    Document   : SpecialCouponCreate
    Created on : Jun 20, 2020, 4:11:04 PM
    Author     : Aman Bahukhandi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Coupon</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Create Coupon</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Create Coupon</li>
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
                                <form:form action="specialCoupon.htm?act=submitSpecialCouponMaster" method="post" commandName="specialCouponMaster"
                                           class="form-horizontal" role="form">
                                    <form:hidden path="srNo"></form:hidden>
                                    <form:hidden path="dRow" ></form:hidden>
                                        <div class="form-group">
                                            <div class="col-sm-3">
                                                <label class="control-label">Coupon type :<span style="color: red;font-size: 12px;">*</span></label>
                                            </div>
                                            <div class="col-sm-3">
                                            <form:select path="couponType"  class="form-control " required="required">
                                                <c:forEach var="couponList" items="${couponType}">
                                                    <c:choose>
                                                        <c:when test="${couponList eq  specialCouponMaster.couponType}">
                                                            <form:option value="${couponList}" selected="true">${couponList}</form:option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:option value="${couponList}">${couponList}</form:option>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:forEach>
                                            </form:select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Designation<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:select path="designation"  class="form-control " required="required">
                                                <c:forEach var="designationList" items="${designationType}">
                                                    <c:choose>
                                                        <c:when test="${designationList eq  specialCouponMaster.designation}">
                                                            <form:option value="${designationList}" selected="true">${designationList}</form:option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:option value="${designationList}">${designationList}</form:option>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:forEach>
                                            </form:select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Limitation per Day :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="limitDay" type="number" class="form-control"   maxlength="30" required="required"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Limitation per month :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="limitMonth" type="number" class="form-control"   maxlength="30" required="required"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">After Per Day Limit:<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-4">
                                            <form:radiobutton path="changeAfterDayLimit"  value="1"/>First Subsidise
                                            <form:radiobutton path="changeAfterDayLimit"  value="2"/> Second Subsidise 
                                            <form:radiobutton path="changeAfterDayLimit" value="3"/>Actual
                                        </div>
                                    </div>



                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
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

</html>