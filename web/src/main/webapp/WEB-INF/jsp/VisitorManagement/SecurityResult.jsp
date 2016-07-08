<%-- 
    Document   : SecurityResult
    Created on : Nov 16, 2015, 2:46:32 PM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Approve Visitor Request</title>
        <script>
            function viewClick(id, empId) {
                window.location = "visitorManagement.htm?act=viewSecurityClick&id=" + id + "&empId=" + empId;
            }
        </script>
    </head>
    <body>
        <div class="content-wrapper">
            
            <section class="content-header">
                <h1>Approve Visitor Request: </h1>
                <div style="float: right"></div>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Approve Visitor Request</li>
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
                                <form:form class="form-horizontal" role="form" action="visitorManagement.htm?act=searchAdminResult" commandName="employeeMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
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
                                                                                    <option value="2">Approved</option>
                                                                                    <option value="8">Withdrawn</option>
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

                                                            <div class="form-group">
                                                                <div class=" col-sm-2">
                                                                    <button type="submit" class="btn btn-primary" style="width: 100px" data-original-title="" title="" >SEARCH</button>
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
        <!--</div>-->
        
        <!--<div class="content-wrapper">-->
            <!-- Content Header (Page header) -->
            <form:form action="visitorManagement.htm?act=searchSubmit" method="post" commandName="visitorManagement"
                       name='form1' class="form-horizontal" role="form">
                <form:hidden path="id"></form:hidden>
                    <section class="content">
                        <div class="row">
                            <div class="col-md-12">
                                <!-- Custom Tabs -->
                                <div class="nav-tabs-custom">
                                    <div class="tab-content">
            <button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;margin-left:960px;" onclick="window.location = 'visitorManagement.htm?act=exportToExcel'"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>
                                        <!--<button type="submit" class="btn btn-danger" ><i class="fa fa-trash-o"></i>&nbsp;&nbsp;Delete</button>-->
                                        <div class="box-header">
                                        </div>
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="table table-bordered">
                                                        <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <c:choose>
                                                            <c:when test="${empty Approverlist}">
                                                                <tr>
                                                                    <td align="center">
                                                                        <c:out value="There is no record found."></c:out>
                                                                        </td>
                                                                    </tr>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <thead>
                                                                    <tr>
                                                                        <!--<th align="center" style="width: 1px;"><input type="checkbox" id="toggleId"/></th>-->
                                                                        <th>Employee Id</th>
                                                                        <th>Employee Name</th>
                                                                        <th>Visitor Name</th>
                                                                        <th>Visiting Date And Time</th>
                                                                        <th>Requested Date</th>
                                                                        <th>Status</th>
                                                                        <th>Action</th>
                                                                    </tr>
                                                                </thead>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <tbody>
                                                            <c:forEach var="list" items="${Approverlist}">
                                                                <tr>
                                                                    <%--<c:if test="${list[6] eq 2}">--%>
                                                                        <!--<td align="center"><input type="checkbox" name="checkId" value="${list[0]}"/></td>-->
                                                                    <td>${list[1]}</td>
                                                                    <td>${list[2]}</td>
                                                                    <td>${list[3]}</td>
                                                                    <td>${list[4]}</td>
                                                                    <td>${list[8]}</td>
                                                                    <td>
                                                                        <c:if test="${list[6] eq 1}"><span class="badge">Pending</span>
                                                                        </c:if>
                                                                        <c:if test="${list[6] eq 2}"><span class="label label-success">Approved by ${list[7]}</span>
                                                                        </c:if>
                                                                        <c:if test="${list[6] eq 8}"><span class="label label-warning">Withdrawn</span>
                                                                        </c:if>
                                                                        <%--<c:if test="${list[6] eq 5}">--%>
                                                                        <!--<span class="badge">Pending</span>-->
                                                                        <%--</c:if>--%>
                                                                        <%--<c:if test="${list[6] eq 6}">--%>
                                                                        <!--<span class="badge">Withdraw Pending</span>-->
                                                                        <%--</c:if>--%>
                                                                        <%--<c:if test="${list[6] eq 10}">--%>
                                                                        <!--<span class="badge">Withdraw Pending</span>-->
                                                                        <%--</c:if>--%>
                                                                    </td>
                                                                    <td>
                                                                        <div class="btn-group">
                                                                            <button type="button" style="width: 75px;" class="btn btn-default " onclick="viewClick(${list[0]},${list[5]});">
                                                                                View
                                                                            </button>                                                                                
                                                                        </div>
                                                                    </td>
                                                                    <%--</c:if>--%>
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
        </div>
        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

    </body>
</html>