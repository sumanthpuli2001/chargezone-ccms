<%-- 
    Document   : SearchOrderId
    Created on : Feb 21, 2020, 9:42:04 AM
    Author     : admin
--%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Punch Data</title>
    </head>
    <style>
        .checkbox-grid li {
            display: block;
            float: left;
            width: 25%;
        }
    </style>


    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Payment Search </h1>

        </section>
        <%--<c:if test="${!empty successMessage}">--%>
            <!--<div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>-->
        <%--</c:if>--%>
        <%--<c:if test="${!empty failureMessage}">--%>
            <!--<div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>-->
        <%--</c:if>--%>
        <!-- Main content -->
        <form:form  method="post" 
                    name='form1' class="form-horizontal" action="payment.html?act=showOwnAttandanceOfSubordinate"  role="form">
 <!--<input type="hidden" name="id" id="id" value="${id}">-->

            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="form-group">
                                    <div class="col-md-12">
                                        <div><button type="button" class="btn-primary"  onclick="window.history.back();" title="View">Back</button></div>
                                    </div>
                                </div>
                                <div class="form-group">

                                    <div class="col-sm-6">
                                        <label>Start Date<span style="color: red;font-size: 12px;">*</span></label>
                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" >
                                            <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                            <input path="inDateTime"  class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <label>End Date<span style="color: red;font-size: 12px;">*</span></label>
                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy">
                                            <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                            <input path="outDateTime"  class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" >                                  <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                        </div>
                                    </div>
                                </div>
                                </div>
                             </div>
                                
                                <button type="button" class="btn btn-primary" style="float: left; width: 100px;" >&nbsp&nbsp;Search</button>
                                <!--<button type="submit" style="width: 100px;" sclass="btn btn-primary" style="width: 100px;">SEARCH</button>-->

                    </div>
                </div>
            </section>
        </div>
    </form:form>

</html>
<script type="text/javascript">
    $('.form_datetime').datetimepicker({
        //language:  'fr',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0,
        endDate: new Date()
    });</script>