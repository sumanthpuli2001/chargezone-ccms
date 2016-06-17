<%--
    Document   : TravelRequestviewByAdmin
    Created on : Oct 30, 2015, 5:16:20 PM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Travel Request</title>
        <style>
            .tooltip-inner{
                max-width: 100% !important; /* Max Width of the popover (depending on the container!) */
            }
        </style>
    </head>
    <script>
        function viewClick(id, empId) {
            window.location = 'travelRequestMaster.htm?act=approveRequestManagerSide&id=' + id + "&empId=" + empId;
        }

    </script>



    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Travel Request: </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Travel Request</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <form:form class="form-horizontal" role="form" action="travelRequestMaster.htm?act=searchTravelRequestSubmit" commandName="employeeMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--<span style="color: red;font-size: 14px;">* indicates mandatory field.</span>-->
                                <!--form horizontal starts here-->

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
                                                        <label>Travel Type<span style="color: red;font-size: 12px;"></span></label>
                                                        <select name="travelType" id="travelType" onchange="cashRequired()" class="form-control">
                                                            <option value="" label="--Select--">--Select--</option>
                                                            <option value="Domestic" label="Domestic">Domestic</option>
                                                            <option value="International" label="International">International</option>
                                                            <option value="Local" label="Local">Local</option>
                                                        </select>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Start Date:<span style="color: red;font-size: 12px;"></span></label>
                                                        <!--<div class="input-group date form_datetime" data-date-format="dd/mm/yyyy-hh:ii" data-link-field="dtp_input1">-->
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                            <input type="text" id="startDate" name="startDate" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" />
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>End Date<span style="color: red;font-size: 12px;"></span></label>
                                                        <!--<div class="input-group date form_datetime" data-date-format="dd/mm/yyyy-hh:ii" data-link-field="dtp_input1">-->
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <!--<input class="form-control" size="16" type="text" value="" readonly>-->
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
                                            <button type="submit" class="btn btn-primary" data-original-title="" title="" style="width: 100px;">SEARCH</button>
                                        </div>
                                    </div>

                                    <div class="tab-pane" id="tab_3"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
        </form:form>
        <!-- Main content -->
        <form:form action="leaveEmployeeDetail.htm?act=deleteLeaveRequest" method="post" commandName="leaveEmployeeDetail"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="box-header" style="text-align: right;">
                                    <button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" title="Export To Excel" onclick="window.location = 'travelRequestMaster.htm?act=exportToExcelTravel'"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">
                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${empty list}">
                                                            <tr>
                                                                <td align="center">
                                                                    <c:out value="There is no record found."></c:out>
                                                                    </td>
                                                                </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <!--                                                                <tr>
                                                                                                                                    <th><input type="text" id="text_empId" class="form-control"/></th>
                                                                                                                                    <th><input type="text" id="text_empName" class="form-control"/></th>
                                                                                                                                    <th><input type="text" id="text_travelType" class="form-control"/></th>
                                                                                                                                    <th><input type="text" id="text_travelNo" class="form-control"/></th>
                                                                                                                                    <th><input type="text" id="text_sDate" class="form-control"/></th>
                                                                                                                                    <th><input type="text" id="text_eDate" class="form-control"/></th>
                                                                                                                                    <th><input type="text" id="text_status" class="form-control"/></th>
                                                                                                                                    <th><input type="text" id="" class="form-control"/></th>
                                                                                                                                </tr>-->
                                                                <tr>
                                                                    <th>Employee Id</th>
                                                                    <th>Employee Name</th>
                                                                    <th>Travel Type</th>
                                                                    <th>Travel Request No.</th>
                                                                    <th>Start Date Time</th>
                                                                    <th>End Date Time</th>
                                                                    <th>Status</th>
                                                                    <th>Action</th>
                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="list" items="${list11}">
                                                            <c:set var="string2" value="${fn:split(list[10], '~')}" />
                                                            <tr>
                                                                <td>${list[0]}</td>
                                                                <td>${list[1]}</td>
                                                                <td>${list[2]}</td>
                                                                <td>${list[3]}</td>
                                                                <td>${list[4]}</td>
                                                                <td>${list[5]}</td>
                                                                <%--<c:if test="${list[8] eq 3}"><td>Travel Request</td></c:if>--%>
                                                                <%--<c:if test="${list[8] eq 6}"><td>Withdraw Request</td></c:if>--%>
                                                                <!--<td>-->
                                                                <%--<c:if test="${list[8] eq 0}"><span class="badge">Pending</span></c:if>--%>
                                                                <%--<c:if test="${list[8] eq 10}"><span class="badge"> Return Pending</span></c:if>--%>
                                                                <%--<c:if test="${list[8] eq 1}"><span class="label label-danger">Rework</span></c:if>--%>
                                                                <%--<c:if test="${list[8] eq 2}"><span class="label label-danger">Reject</span></c:if>--%>
                                                                <%--<c:if test="${list[8] eq 3}"><span class="label label-success">Approved By Manager</span></c:if>--%>
                                                                <%--<c:if test="${list[8] eq 6}"><span class="label label-success">Approved By Functional Head</span></c:if>--%>
                                                                <%--<c:if test="${list[8] eq 4}"><span class="badge">Withdraw</span></c:if>--%>
                                                                <%--<c:if test="${list[8] eq 5}"><span class="label label-success">Final Approved</span></c:if>--%>

                                                                <c:if test="${list[8] eq 0}">
                                                                    <td><span class="badge" rel="tooltip" data-html="true" data-toggle="tooltip" data-placement="top"
                                                                              data-title="<table bgcolor='#000000' style='border: none'>
                                                                              <tr bgcolor='#000000'><th bgcolor='#000000'>Approver</th><th bgcolor='#000000'>Status</th><th bgcolor='#000000'>DateTime</th>
                                                                              <c:forEach var="qq" items="${string2}"> <c:set var="string3" value="${fn:split(qq, '_')}" /><tr bgcolor='#000000'><th bgcolor='#000000'>${string3[0]}</th>
                                                                                  <c:if test="${string3[1] eq 'Pending'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Pending</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '0'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Pending</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '1'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Reworked</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '2'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Rejected</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '3'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '4'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      WithDraw</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '5'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Final Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '6'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '8'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <th bgcolor='#000000'>${string3[2]}</th></tr></c:forEach>
                                                                                  </table>">Pending</span>
                                                                        </td>
                                                                </c:if>

                                                                <c:if test="${list[8] eq 3}">
                                                                    <%--<c:choose>--%>
                                                                    <%--<c:when test="${list[13] eq 0}">--%>
                                                                    <%--<c:if test="${list[1].returnFlag eq 0}">--%>
                                                                    <td><span class="label label-success" rel="tooltip" data-html="true" data-toggle="tooltip" data-placement="top"
                                                                              data-title="<table bgcolor='#000000' style='border: none'>
                                                                              <tr bgcolor='#000000'><th bgcolor='#000000'>Approver</th><th bgcolor='#000000'>Status</th><th bgcolor='#000000'>DateTime</th>
                                                                              <c:forEach var="qq" items="${string2}"><c:set var="string3" value="${fn:split(qq, '_')}" /><tr bgcolor='#000000'><th bgcolor='#000000'>${string3[0]}</th>
                                                                                  <c:if test="${string3[1] eq 'Pending'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Pending</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '0'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Pending</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '1'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Reworked</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '2'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Rejected</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '3'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '4'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      WithDraw</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '5'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Final Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '6'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '8'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <th bgcolor='#000000'>${string3[2]}</th></tr></c:forEach>
                                                                              </table>">Approved by ${list[9]}</span>
                                                                    </td>
                                                                    <%--</c:if>--%>
                                                                    <%--</c:when>--%>
                                                                    <%--<c:otherwise>--%>
                                                                    <!--<td><span class="badge">Pending</span></td>-->
                                                                    <%--</c:otherwise>--%>
                                                                    <%--</c:choose>--%>
                                                                </c:if>
                                                                <c:if test="${list[8] eq 10}">
                                                                    <td><span class="badge" rel="tooltip" data-html="true" data-toggle="tooltip" data-placement="top"
                                                                              data-title="<table bgcolor='#000000' style='border: none'>
                                                                              <tr bgcolor='#000000'><th bgcolor='#000000'>Approver</th><th bgcolor='#000000'>Status</th><th bgcolor='#000000'>DateTime</th>
                                                                              <c:forEach var="qq" items="${string2}"> <c:set var="string3" value="${fn:split(qq, '_')}" /><tr bgcolor='#000000'><th bgcolor='#000000'>${string3[0]}</th><th bgcolor='#000000'> ${string3[1]}</th><th bgcolor='#000000'>${string3[2]}</th></tr></c:forEach>
                                                                                  </table>">Return Request Pending</span></td>
                                                                    </c:if>
                                                                    <c:if test="${list[8] eq 2}">
                                                                    <td><span class="label label-danger" rel="tooltip" data-html="true" data-toggle="tooltip" data-placement="top"
                                                                              data-title="<table bgcolor='#000000' style='border: none'>
                                                                              <tr bgcolor='#000000'><th bgcolor='#000000'>Approver</th><th bgcolor='#000000'>Status</th><th bgcolor='#000000'>DateTime</th>
                                                                              <c:forEach var="qq" items="${string2}"> <c:set var="string3" value="${fn:split(qq, '_')}" /><tr bgcolor='#000000'><th bgcolor='#000000'>${string3[0]}</th>
                                                                                  <c:if test="${string3[1] eq 'Pending'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Pending</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '0'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Pending</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '1'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Reworked</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '2'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Rejected</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '3'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '4'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      WithDraw</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '5'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Final Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '6'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '8'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <th bgcolor='#000000'>${string3[2]}</th></tr></c:forEach>
                                                                              </table>">Rejected by ${list[9]}</span></td>
                                                                    </c:if>
                                                                    <c:if test="${list[8] eq 1}">
                                                                    <td><span class="label label-warning" rel="tooltip" data-html="true" data-toggle="tooltip" data-placement="top"
                                                                              data-title="<table bgcolor='#000000' style='border: none'>
                                                                              <tr bgcolor='#000000'><th bgcolor='#000000'>Approver</th><th bgcolor='#000000'>Status</th><th bgcolor='#000000'>DateTime</th>
                                                                              <c:forEach var="qq" items="${string2}"> <c:set var="string3" value="${fn:split(qq, '_')}" /><tr bgcolor='#000000'><th bgcolor='#000000'>${string3[0]}</th>
                                                                                  <c:if test="${string3[1] eq 'Pending'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Pending</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '0'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Pending</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '1'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Reworked</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '2'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Rejected</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '3'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '4'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      WithDraw</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '5'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Final Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '6'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '8'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <th bgcolor='#000000'>${string3[2]}</th></tr></c:forEach>
                                                                              </table>">Rework by ${list[9]}</span></td>
                                                                    </c:if>
                                                                    <c:if test="${list[8] eq 4}">
                                                                    <td><span class="badge" rel="tooltip" data-html="true" data-toggle="tooltip" data-placement="top"
                                                                              data-title="<table bgcolor='#000000' style='border: none'>
                                                                              <tr bgcolor='#000000'><th bgcolor='#000000'>Approver</th><th bgcolor='#000000'>Status</th><th bgcolor='#000000'>DateTime</th>
                                                                              <c:forEach var="qq" items="${string2}"> <c:set var="string3" value="${fn:split(qq, '_')}" />
                                                                                  <tr bgcolor='#000000'><th bgcolor='#000000'>${string3[0]}</th>
                                                                                  <c:if test="${string3[1] eq 'Pending'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Pending</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '0'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Pending</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '1'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Reworked</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '2'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Rejected</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '3'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '4'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      WithDraw</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '5'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Final Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '6'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '8'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <th bgcolor='#000000'>${string3[2]}</th></tr></c:forEach>
                                                                                  </table>">WithDraw</span></td>
                                                                    </c:if>
                                                                    <c:if test="${list[8] eq 5}">
                                                                    <td><span class="label label-success" rel="tooltip" data-html="true" data-toggle="tooltip" data-placement="top"
                                                                              data-title="<table bgcolor='#000000' style='border: none'>
                                                                              <tr bgcolor='#000000'>
                                                                              <th bgcolor='#000000'>Approver</th><th bgcolor='#000000'>Status</th><th bgcolor='#000000'>DateTime</th></tr>
                                                                              <c:forEach var="qq" items="${string2}"> <c:set var="string3" value="${fn:split(qq, '_')}" />
                                                                                  <tr bgcolor='#000000'><th bgcolor='#000000'>${string3[0]}</th>
                                                                                  <c:choose>

                                                                                      <c:when test="${list[8] eq 5}">
                                                                                          <th bgcolor='#000000'>
                                                                                          Approved</th>
                                                                                      </c:when>
                                                                                      <c:otherwise>
                                                                                          <c:if test="${string3[1] eq 'Pending'}">
                                                                                              <th bgcolor='#000000'>
                                                                                              Pending</th>
                                                                                          </c:if>
                                                                                          <c:if test="${string3[1] eq '0'}">
                                                                                              <th bgcolor='#000000'>
                                                                                              Pending</th>
                                                                                          </c:if>
                                                                                          <c:if test="${string3[1] eq '1'}">
                                                                                              <th bgcolor='#000000'>
                                                                                              Reworked</th>
                                                                                          </c:if>
                                                                                          <c:if test="${string3[1] eq '2'}">
                                                                                              <th bgcolor='#000000'>
                                                                                              Rejected</th>
                                                                                          </c:if>
                                                                                          <c:if test="${string3[1] eq '3'}">
                                                                                              <th bgcolor='#000000'>
                                                                                              Approved</th>
                                                                                          </c:if>
                                                                                          <c:if test="${string3[1] eq '4'}">
                                                                                              <th bgcolor='#000000'>
                                                                                              WithDraw</th>
                                                                                          </c:if>
                                                                                          <c:if test="${string3[1] eq '5'}">
                                                                                              <th bgcolor='#000000'>
                                                                                              Final Approved</th>
                                                                                          </c:if>
                                                                                          <c:if test="${string3[1] eq '6'}">
                                                                                              <th bgcolor='#000000'>
                                                                                              Approved</th>
                                                                                          </c:if>
                                                                                          <c:if test="${string3[1] eq '8'}">
                                                                                              <th bgcolor='#000000'>
                                                                                              Approved</th>
                                                                                          </c:if>
                                                                                      </c:otherwise>
                                                                                  </c:choose>
                                                                                  <th bgcolor='#000000'>${string3[2]}</th></tr></c:forEach>
                                                                              </table>">Final Approved by ${list[9]}</span></td>
                                                                    </c:if>
                                                                    <c:if test="${list[8] eq 6}">
                                                                    <td><span class="label label-success" rel="tooltip" data-html="true" data-toggle="tooltip" data-placement="top"
                                                                              data-title="<table bgcolor='#000000' style='border: none'>
                                                                              <tr bgcolor='#000000'><th bgcolor='#000000'>Approver</th><th bgcolor='#000000'>Status</th><th bgcolor='#000000'>DateTime</th>
                                                                              <c:forEach var="qq" items="${string2}"> <c:set var="string3" value="${fn:split(qq, '_')}" /><tr bgcolor='#000000'><th bgcolor='#000000'>${string3[0]}</th>
                                                                                  <c:if test="${string3[1] eq 'Pending'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Pending</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '0'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Pending</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '1'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Reworked</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '2'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Rejected</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '3'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '4'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      WithDraw</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '5'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Final Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '6'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '8'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <th bgcolor='#000000'>${string3[2]}</th></tr></c:forEach>
                                                                              </table>">Approved by ${list[9]}</span></td>
                                                                    </c:if>
                                                                    <%--<c:if test="${list[8] eq 4}"></c:if>--%>

                                                                <!--</td>-->
                                                                <td>
                                                                    <div class="btn-group">
                                                                        <button type="button" class="btn btn-default" onclick="viewClick(${list[6]}, ${list[7]});">
                                                                            &nbsp;&nbsp;View</button>
                                                                    </div>
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

        <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
        <!-- /.content -->
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

    <!--    <script>
            $(document).ready(function () {
    //                    $('#table_1').DataTable({
    //                        "ordering": false
    //                    });
                var otable = $('#table_1').DataTable();
                $("#table_1 #text_empName").on('keyup change', function () {
                    otable
                            .column($(this).parent().index() + ':visible')
                            .search(this.value)
                            .draw();

                });
            });
        </script>-->
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
    <!--    <script>
            $(document).ready(function () {
                $('#table_2').DataTable();
            })
        </script>-->
</html>

