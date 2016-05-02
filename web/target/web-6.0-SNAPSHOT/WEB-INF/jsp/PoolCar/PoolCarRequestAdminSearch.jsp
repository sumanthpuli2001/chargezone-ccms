<%-- 
    Document   : PoolCarRequestAdminSearch
    Created on : Oct 29, 2015, 6:32:58 PM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PoolCarRequest Search Admin</title>
    </head>
    <body>
        <div class="content-wrapper">
            <section class="content-header">
                <h1>Pool Car Request Search: </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Pool Car Request</li>
                </ol>
            </section>
            <c:if test="${!empty successMessage}">
                <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
            </c:if>
            <c:if test="${!empty failureMessage}">
                <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
            </c:if>
            <form:form class="form-horizontal" role="form" action="poolCarRequest.htm?act=searchAdminResult" commandName="employeeMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
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
                                                    <div class="col-sm-6"><span style="color: red;font-size: 12px;"></span>
                                                        <label>Employee Name:<span style="color: red;font-size: 12px;"></span></label>
                                                            <form:input path="employeeName" class="form-control"></form:input>
                                                            <form:errors path="employeeName" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Department:<span style="color: red;font-size: 12px;"></span></label>
                                                            <form:select path="departmentMaster" id="departmentMaster" class="form-control">
                                                                <form:option value="" label="-- Select --" />
                                                                <form:options items="${deptMap}"></form:options>
                                                            </form:select>
                                                            <form:errors path="departmentMaster" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Designation:<span style="color: red;font-size: 12px;"></span></label>
                                                            <form:select path="designationMaster" id="designationMaster" class="form-control">
                                                                <form:option value="" label="-- Select --" />
                                                                <form:options items="${desigList}"></form:options>
                                                            </form:select>
                                                            <form:errors path="designationMaster" cssClass="errorDiv"></form:errors>
                                                        </div>

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

                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Start Date:<span style="color: red;font-size: 12px;"></span></label>
                                                            <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                <input type="text" id="startDate" name="startDate" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" />
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>End Date<span style="color: red;font-size: 12px;"></span></label>
                                                            <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                <input id="endDate" name="endDate" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" />
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        </div>

                                                    </div>

                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                        <br/>
                                        <div class="form-group">
                                            <div class=" col-sm-6 col-sm-offset-5">
                                                <button type="submit" class="btn btn-primary" style="width: 100px;" data-original-title="" title="" >SEARCH</button>
                                            </div>
                                        </div>

                                        <div class="tab-pane" id="tab_3"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
            </form:form>
            <form:form action="" method="post" commandName="poolCarRequest"
                       name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
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
                                                <div class="table table-bordered">
                                                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <c:choose>
                                                            <c:when test="${empty readSearchRequestList}">
                                                                <tr>
                                                                    <td align="center">
                                                                        <c:out value="There is no record found."></c:out>
                                                                        </td>
                                                                    </tr>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <thead>
                                                                    <tr>
                                                                        <th>Employee Id</th>
                                                                        <th>Employee Name</th>
                                                                        <th>Start Date</th>
                                                                        <th>End Date</th>
                                                                        <th>Status</th>
                                                                    </tr>
                                                                </thead>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <tbody>
                                                            <c:forEach var="list" items="${readSearchRequestList}">
                                                                <tr>
                                                                    <td>${list[0]}</td>
                                                                    <td>${list[1]}</td>
                                                                    <td>${list[2]}</td>
                                                                    <td>${list[3]}</td>
                                                                    <td>
                                                                        <c:if test="${list[4] eq 1}"><span class="badge">Requested</span></c:if> 
                                                                        <c:if test="${list[4] eq 2}"><span class="badge">Approval Pending</span></c:if> 
                                                                        <c:if test="${list[4] eq 4}"><span class="label label-success">Approved</span></c:if> 
                                                                        <c:if test="${list[4] eq 3 || list[4] eq 5}"><span class="label label-danger">Rejected</span></c:if> 
                                                                        <c:if test="${list[4] eq 6}"><span class="label label-danger">Returned by Approver</span></c:if> 
                                                                        <c:if test="${list[4] eq 7}"><span class="label label-danger">Returned by Admin</span></c:if> 
                                                                        <c:if test="${list[4] eq 8}"><span class="badge"> Returned Approval pending</span></c:if> 
                                                                        <c:if test="${list[4] eq 9}"><span class="badge"> Returned Admin Approval pending</span></c:if> 
                                                                        <c:if test="${list[4] eq 10}"><span class="badge">Withdraw Requested</span></c:if> 
                                                                        <c:if test="${list[4] eq 12}"><span class="badge">Withdraw Approval Pending</span></c:if> 
                                                                        <c:if test="${list[4] eq 14}"><span class="label label-success">Withdraw Approved</span></c:if> 
                                                                        <c:if test="${list[4] eq 13 || list[4] eq 15}"><span class="label label-danger">Withdraw Rejected</span></c:if> 
                                                                        <c:if test="${list[4] eq 16}"><span class="label label-danger">Withdraw Returned by Approver</span></c:if> 
                                                                        <c:if test="${list[4] eq 17}"><span class="label label-danger">Withdraw Returned by Admin</span></c:if> 
                                                                        <c:if test="${list[4] eq 18}"><span class="badge">Withdraw Approval Pending</span></c:if> 
                                                                        <c:if test="${list[4] eq 19}"><span class="badge">Withdraw Admin Approval Pending</span></c:if>     
                                                                        </td>
                                                                    </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div><!-- /.tab-content -->
                            </div><!-- nav-tabs-custom -->
                        </div><!-- /.col -->
                    </div>
                </section>

            </form:form>
        </div>

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

        <script>
            jQuery.noConflict();
            jQuery(document).ready(function () {
                jQuery("#employeeName").tokenInput(${list}, {
                    preventDuplicates: true,
                    noResultsText: "No Result",
                    tokenLimit: "1",
                    searchingText: "Searching ... .. .",
                });
            });

        </script>
        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    </body>
</html>

