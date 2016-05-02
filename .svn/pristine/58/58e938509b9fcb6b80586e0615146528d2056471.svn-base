<%-- 
    Document   : IntervalMasterEditPage
    Created on : Feb 13, 2016, 5:35:00 PM
    Author     : BlackBull
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>Interval Master Page: </h1>

            </section>
            <div class="content">
                <!-- Main content -->
                <form:form action="intervalMaster.htm?act=editSubmit" method="post" commandName="intervalMaster"
                           name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
                    <form:hidden path="id"></form:hidden>
                        <!--<form class="form-horizontal" role="form" commandName>-->

                        <!--Read only entries Starts here-->
                        <!--<div class="box box-info collapsed-box ">-->
                        <div class="row">
                            <div class="col-md-12">
                                <!-- Custom Tabs -->
                                <div class="nav-tabs-custom">
                                    <div class="tab-content">
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">                                                
                                                    <div class="form-group">
                                                        <div class="col-sm-4 col-sm-offset-1">
                                                            <label>Module Name<span style="color: red;font-size: 12px;">*</span></label>
                                                            <div>
                                                            <form:select path="module" id="module" class="form-control" required="true">
                                                                <form:option value="" label="-- Select --"></form:option>
                                                                <form:option value="Expense" >Expense</form:option> 
                                                                <form:option value="GatePass">Gate Pass</form:option> 
                                                                <form:option value="Travel">Travel</form:option>
                                                                <form:option value="Leave">Leave</form:option>
                                                                <form:option value="PoolCar">Pool Car</form:option>
                                                            </form:select>
                                                        </div>

                                                        <%--<form:errors path="module" cssClass="errorDiv"></form:errors>--%>
                                                    </div>
                                                    <div class=" col-sm-4 col-sm-offset-2">
                                                        <label>No of Days<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="days" class="form-control" required="true" type="number"></form:input>
                                                        <%--<form:errors path="portNo" cssClass="errorDiv"></form:errors>--%>
                                                    </div>
                                                </div>
                                                <button  type="submit" class="btn btn-primary center-block" style="width: 100px;font-weight: bold;" id="saveSubmit1" >SUBMIT</button>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div><!-- /.tab-content -->
                            </div><!-- nav-tabs-custom -->
                        </div><!-- /.col -->
                    </div>

                </form:form>
            </div>
        </div>
    </body>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
