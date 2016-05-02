<%--
    Document   : TravelRequestResult
    Created on : Oct 26, 2015, 12:33:55 PM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Travel Request Result</title>
        <style>
            .tooltip-inner{
                max-width: 100% !important; /* Max Width of the popover (depending on the container!) */
            }
        </style>
    </head>
    <script>
        function viewClick(id) {
            window.location = 'travelRequestMaster.htm?act=viewRequest&id=' + id;
        }

        function deleteCheck11() {
            var checkboxes = "";
            checkboxes = document.getElementsByName('checkId');
//            alert(checkboxes.length);
            for (var i = 0, n = checkboxes.length; i < n; i++) {
                if (checkboxes[i].checked) {
                    return true;
                }
            }
            alert("Please, Select one or more record(s).");
            return false;
        }
    </script>


    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Travel Request </h1>
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
        <section class="content">

            <form:form class="form-horizontal" role="form" action="travelRequestMaster.htm?act=searchOwnTravelRequestSubmit" commandName="employeeMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="box-header">
                                    <button type="button" class="btn btn-primary" style="float: right;width: 100px" onclick="window.location = 'travelRequestMaster.htm?act=applyClick'"><i class="fa fa-plus"></i>&nbsp&nbsp;NEW</button>
                                </div>

                                <!--<span style="color: red;font-size: 14px;">* indicates mandatory field.</span>-->
                                <!--form horizontal starts here-->

                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <div class="col-sm-6"><span style="color: red;font-size: 12px;"></span>
                                                    <label>Employee Name:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:input path="employeeName" class="form-control" readonly="true"></form:input>
                                                        <form:errors path="employeeName" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Travel Type<span style="color: red;font-size: 12px;"></span></label>
                                                        <select name="travelType" id="travelType" onchange="cashRequired()" class="form-control">
                                                            <option value="" label="--SELECT--">--SELECT--</option>
                                                            <option value="Domestic" label="Domestic">Domestic</option>
                                                            <option value="International" label="International">International</option>
                                                            <option value="Local" label="Local">Local</option>
                                                        </select>
                                                    </div>

                                                </div>

                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Start Date:<span style="color: red;font-size: 12px;"></span></label>
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy-hh:ii" data-link-field="dtp_input1">
                                                            <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                            <input type="text" id="startDate" name="startDate" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" />
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>End Date<span style="color: red;font-size: 12px;"></span></label>
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy-hh:ii" data-link-field="dtp_input1">
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
                                            <button type="submit" class="btn btn-primary" data-original-title="" title="" style="width: 100px;" >SEARCH</button>
                                        </div>
                                    </div>

                                    <div class="tab-pane" id="tab_3"></div>
                                </div>
                            </div>
                        </div>
                    </div>
            </form:form>

        </section>

        <!-- Main content -->
        <form:form action="travelRequestMaster.htm?act=deleteSubmit" method="post" commandName="travelRequestMaster"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--<button type="submit" class="btn btn-danger" ><i class="fa fa-trash"></i>&nbsp&nbsp;Delete</button>-->
                                <!--<div class="box-header">-->
                                <!--<button type="button" class="btn btn-primary" style="float: right" onclick="window.location = 'travelRequestMaster.htm?act=applyClick'"><i class="fa fa-plus"></i>&nbsp&nbsp;New</button>-->
                                <!--</div>-->

                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">
                                                <c:set var="Status" value="0"></c:set>
                                                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                    <c:choose>
                                                        <c:when test="${empty resultList}">
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
                                                                    <th>Employee Id </th>
                                                                    <th>Employee Name </th>
                                                                    <th>Travel Type</th>
                                                                    <th>Travel Request No.</th>
                                                                    <th>Start Date</th>
                                                                    <th>End Date</th>
                                                                    <th>Status</th>
                                                                    <th>Action</th>
                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="list" items="${resultList}">
                                                            <c:set var="string2" value="${fn:split(list[9], '~')}" />





                                                            <tr>
                                                                <!--<td align="center"><input type="checkbox" name="checkId" id="empLeaveId" value="${list[5]}"/></td>-->
                                                                <td>${list[7]}</td>
                                                                <td>${list[8]}</td>
                                                                <td>${list[0]}</td>
                                                                <td><b>${list[1]}</b></td>
                                                                <td>${list[2]}</td>
                                                                <td>${list[3]}</td>
                                                                <c:if test="${list[4] eq 0}">
                                                                    <!--                                                                    <span rel="tooltip" data-html="true" data-toggle="tooltip" data-placement="top"
                                                                                                                                                  data-title="<table bgcolor='#000000'>
                                                                                                                                                  <tr bgcolor='#000000'><th bgcolor='#000000'>ajay</th><th bgcolor='#000000'>Parmar</th><th bgcolor='#000000'>mike</th></tr>

                                                                                                                                                  </table>">Pending</span>-->

                                                                    <td>

                                                                        <span class="badge" rel="tooltip" data-html="true" data-toggle="tooltip" data-placement="top"
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
                                                                                  </table>">Pending</span></td>

                                                                </c:if>
                                                                <c:if test="${list[4] eq 10}">
                                                                    <td><span class="badge" rel="tooltip" data-html="true" data-toggle="tooltip" data-placement="top"
                                                                              data-title="<table bgcolor='#000000' style='border: none'>
                                                                              <tr bgcolor='#000000'><th bgcolor='#000000'>Approver</th><th bgcolor='#000000'>Status</th><th bgcolor='#000000'>DateTime</th>
                                                                              <c:forEach var="qq" items="${string2}"> <c:set var="string3" value="${fn:split(qq, '_')}" /><tr bgcolor='#000000'><th bgcolor='#000000'>${string3[0]}</th><th bgcolor='#000000'> ${string3[1]}</th><th bgcolor='#000000'>${string3[2]}</th></tr></c:forEach>
                                                                                  </table>">Pending</span></td>
                                                                    </c:if>
                                                                    <c:if test="${list[4] eq 3}">
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
                                                                              </table>">Approved by ${list[6]} </span></td>
                                                                    </c:if>
                                                                    <c:if test="${list[4] eq 8}">
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
                                                                              </table>">Approved by ${list[6]}</span></td>
                                                                    </c:if>
                                                                    <c:if test="${list[4] eq 2}">
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
                                                                              </table>">Rejected by ${list[6]}</span></td>
                                                                    </c:if>
                                                                    <c:if test="${list[4] eq 1}">
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
                                                                              </table>">Rework by ${list[6]}</span></td>
                                                                    </c:if>
                                                                    <c:if test="${list[4] eq 4}">
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
                                                                                  </table>">WithDraw</span></td>
                                                                    </c:if>
                                                                    <c:if test="${list[4] eq 5}">
                                                                    <td><span class="label label-success" rel="tooltip" data-html="true" data-toggle="tooltip" data-placement="top"
                                                                              data-title="<table bgcolor='#000000' style='border: none'>
                                                                              <tr bgcolor='#000000'><th bgcolor='#000000'>Approver</th><th bgcolor='#000000'>Status</th><th bgcolor='#000000'>DateTime</th>
                                                                              <c:forEach var="qq" items="${string2}"> <c:set var="string3" value="${fn:split(qq, '_')}" /><tr bgcolor='#000000'><th bgcolor='#000000'>${string3[0]}</th>
                                                                                  <%--<c:if test="${string3[0]}"></c:if>--%>

                                                                                  <c:choose>

                                                                                      <c:when test="${list[4] eq 5}">
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
                                                                              </table>">Final Approved by ${list[6]}</span></td>
                                                                    </c:if>
                                                                    <c:if test="${list[4] eq 6}">
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
                                                                              </table>">Approved By ${list[6]}</span></td>
                                                                    </c:if>
                                                                <!--<td>$//{list[5]}</td>-->
                                                                <%--<c:if test="${list[4] ne 5}">--%>
                                                                <td>
                                                                    <div class="btn-group">
                                                                        <button type="button" class="btn btn-default dropdown-toggle" aria-haspopup="true" aria-expanded="false" onclick="viewClick(${list[5]});">
                                                                            &nbsp;&nbsp;View
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
            forceParse: 0,
            showMeridian: 1
        });
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <!--    <script>
            $(document).ready(function () {
                $('#table_2').DataTable();
            })
        </script>-->
</html>


