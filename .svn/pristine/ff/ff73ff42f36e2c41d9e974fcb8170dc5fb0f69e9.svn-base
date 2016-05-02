<%-- 
    Document   : VisitorSearch
    Created on : Nov 17, 2015, 5:05:05 PM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
          <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
           <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Visitor</title>
    </head>
             <div class="content-wrapper">
             <section class="content-header">
                <h1>Search Visitor Request: </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Search Visitor Request</li>
                </ol>
            </section>
            <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
            
             <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
        <form:form class="form-horizontal" role="form" action="visitorManagement.htm?act=searchEmpResult" commandName="employeeMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
           <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                               
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">

                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Start Date:<span style="color: red;font-size: 12px;"></span></label>
                                                    <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                        <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                        <input type="text" id="startDate" name="startDate" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" />
                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                    </div>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label>End Date<span style="color: red;font-size: 12px;"></span></label>
                                                    <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                        <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                        <input id="endDate" name="endDate" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" />
                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                    </div>
                                                </div>

                                            </div>
                                             <div class="form-group">
                                              <div class="col-sm-6">
                                                        <label>Status:<span style="color: red;font-size: 12px;"></span></label>
                                                       <select name="status" id="status" class="form-control">
                                                                <option value="">--Select--</option>
                                                                <option value="1">Requested</option>
                                                                <option value="4">Approved</option>
                                                                <option value="3">Rejected by approver</option>
                                                                <option value="5">Rejected by admin</option>
                                                                <option value="6">Returned by Approver</option>
                                                                <option value="7">Returned by admin</option>
                                                                <option value="14">Withdraw</option>
                                                    </select>
                                                </div>
                                                </div>
                                            
                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->

                                <div class="form-group">
                                    <div class=" col-sm-2">
                                        <button type="submit" class="btn btn-primary" data-original-title="" title="" >Search</button>
                                    </div>
                                </div>

                                <div class="tab-pane" id="tab_3"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form:form>
    </div>
                            </div>
                    </div>
                </div>
            </section>
        </div>
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <script type="text/javascript">
        $('.form_datetime').datetimepicker({
            //language:  'fr',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });
    </script>
</html>
