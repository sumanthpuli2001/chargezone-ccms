<%--
    Document   : LeaveOwnDetailSearch
    Created on : Oct 20, 2015, 10:40:17 AM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Leave Detail Search</title>
    </head>

    <script>

        var flag3 = true;
        function saveSubmit11() {
            if (flag3) {
                flag3 = false;
                document.getElementById('saveSubmit1').innerHTML = 'Searching ... .. .';
                document.form1.submit();
                return true;
            } else {
                return false;
            }
        }

        function viewClick(id) {
            window.location = 'leaveEmployeeDetail.htm?act=viewLeaveRequest&id=' + id;
        }
        function viewWithDrawClick(id) {
            window.location = 'leaveEmployeeDetail.htm?act=viewWithDrawLeaveRequest&id=' + id;
        }
    </script>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Search Leave Detail:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Search Leave Detail</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form" action="leaveEmployeeDetail.htm?act=searchOwnLeaveDetailSubmit" commandName="employeeMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--<span style="color: red;font-size: 14px;">* indicates mandatory field.</span>-->
                                <!--form horizontal starts here-->

                                <div class="box-header">
                                    <button type="button" class="btn btn-primary" style="float: right; width: 100px;" onclick="window.location = 'leaveEmployeeDetail.htm?act=applyClick'"><i class="fa fa-plus"></i>&nbsp&nbsp;NEW</button>
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <div class="col-sm-6"><span style="color: red;font-size: 12px;"></span>
                                                    <label>Employee Name:<span style="color: red;font-size: 12px;"></span></label>
                                                    <input type="text" name="employeeName" id="employeeName" class="form-control" value="${empName}" readonly=""/>
                                                    <form:errors path="employeeName" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Leave Type:<span style="color: red;font-size: 12px;"></span></label>
                                                        <select name="leaveType" id="leaveType" class="form-control">
                                                            <option value="">--Select--</option>
                                                        <c:forEach var="map" items="${leaveTypemap}">
                                                            <option value="${map.key}">${map.value}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
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

                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->

                                <div class="form-group">
                                    <div class=" col-sm-2">
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
        <form:form action="leaveTypeMaster.htm?act=deleteSubmit" method="post" commandName="leaveTypeMaster"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="content">
                <h2>Result :</h2>
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
                                                        <c:when test="${empty list}">
                                                            <tr>
                                                                <td align="center">
                                                                    <c:out value="There is no record found."></c:out>
                                                                    </td>
                                                                </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th>Leave Type</th>
                                                                    <th>Start Date</th>
                                                                    <th>End Date</th>
                                                                    <th>No Of Days</th>
                                                                    <th>Status</th>
                                                                    <th>Action</th>
                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="list" items="${list}">
                                                            <tr>
                                                                <td>${list[0]}</td>
                                                                <td>${list[1]}</td>
                                                                <td>${list[2]}</td>
                                                                <td>${list[3]}</td>
                                                                <c:if test="${list[5] eq 0}">
                                                                    <td><span class="badge">Pending</span></td>
                                                                </c:if>
                                                                <c:if test="${list[5] eq 3}">
                                                                    <td><span class="label label-success">Approved By ${list[6]}</span></td>
                                                                </c:if>
                                                                <c:if test="${list[5] eq 2}">
                                                                    <td><span class="label label-danger">Rejected By ${list[6]}</span></td>
                                                                </c:if>
                                                                <c:if test="${list[5] eq 1}">
                                                                    <td><span class="label label-warning">Reworked By ${list[6]}</span></td>
                                                                </c:if>
                                                                <c:if test="${list[5] eq 4}">
                                                                    <td><span class="label label-info">WithDraw Request</span></td>
                                                                </c:if>
                                                                <c:if test="${list[5] eq 5}">
                                                                    <td><span class="label label-info">WithDrawn By ${list[6]}</span></td>
                                                                </c:if>
                                                                <!--<td>$//{list[5]}</td>-->
                                                                <td>
                                                                    <div class="btn-group">
                                                                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                            Action <span class="caret"></span>
                                                                        </button>
                                                                        <ul class="dropdown-menu">
                                                                            <c:if test="${list[5] ne 2}">

                                                                                <li>
                                                                                    <a href="#"
                                                                                       onclick="viewClick(${list[4]});">
                                                                                        &nbsp;&nbsp;View/Edit
                                                                                    </a>
                                                                                </li>
                                                                                <li>
                                                                                    <a href="#"
                                                                                       onclick="viewWithDrawClick(${list[4]});">
                                                                                        &nbsp;&nbsp;Withdraw
                                                                                    </a>
                                                                                </li>
                                                                            </c:if>
                                                                            <c:if test="${list[5] eq 2}">
                                                                                <li>
                                                                                    <a href="#"
                                                                                       onclick="viewClick(${list[4]});">
                                                                                        &nbsp;&nbsp;View
                                                                                    </a>
                                                                                </li>

                                                                            </c:if>

                                                                        </ul>
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

        <div class="tab-pane" id="tab_3"></div>
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


    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>

