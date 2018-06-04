<%--
    Document   : LeaveApplicationResult
    Created on : Oct 16, 2015, 4:07:58 PM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Leave Application Result</title>
    </head>
    <script>
        function viewClick(id) {
            window.location = 'leaveEmployeeDetail.htm?act=viewLeaveRequest&id=' + id;
        }
        function viewWithDrawClick(id) {
            window.location = 'leaveEmployeeDetail.htm?act=viewWithDrawLeaveRequest&id=' + id;
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
            <h1>Leave Application: </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Leave Application</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="leaveEmployeeDetail.htm?act=searchOwnLeaveRequestResultOfEmployee" method="post" commandName="employeeMaster"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="content">
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
                                        <label>Leave Type:<span style="color: red;font-size: 12px;"></span></label>
                                        <select name="leaveType" id="leaveType" class="form-control">
                                            <option value="">--Select--</option>
                                        <c:forEach var="map" items="${leaveTypemap11}">
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
                        <button type="submit" class="btn btn-primary" data-original-title="" title="" >Search</button>
                    </div>
                </div>
            </section>

        </form:form>
        <form:form action="" method="post" commandName=""
                   name='form1' class="form-horizontal" role="form">
              <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                             <h3>RESULT </h3>
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--<button type="submit" class="btn btn-danger" ><i class="fa fa-trash"></i>&nbsp&nbsp;Delete</button>-->
                                    <div style="clear: both"></div>
                                <div class="box-header">
                                <button type="button" class="btn btn-primary" style="float: right" onclick="window.location = 'leaveEmployeeDetail.htm?act=applyClick'"><i class="fa fa-plus"></i>&nbsp&nbsp;New</button>
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
                                                                    <th align="center" style="width: 1px;"><input type="checkbox" id="toggleId"/></th>
                                                                    <th>Leave Type</th>
                                                                    <th>Start Date</th>
                                                                    <th>End Date</th>
                                                                    <th>No Of Days</th>
                                                                    <th>Date of submission</th>
                                                                    <th>Status</th>
                                                                    <th>Action</th>
                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="list" items="${list}">
                                                            <tr>
                                                                <td align="center"><input type="checkbox" name="checkId" id="empLeaveId" value="${list[4]}"/></td>
                                                                <td>${list[0]}</td>
                                                                <td>${list[1]}</td>
                                                                <td>${list[2]}</td>
                                                                <td>${list[3]}</td>
                                                                <c:if test="${list[5] eq 0}">
                                                                    <td>Pending</td>
                                                                </c:if>
                                                                <c:if test="${list[5] eq 3}">
                                                                    <td>Approved</td>
                                                                </c:if>
                                                                <c:if test="${list[5] eq 2}">
                                                                    <td>Rejected</td>
                                                                </c:if>
                                                                <c:if test="${list[5] eq 1}">
                                                                    <td>Rework</td>
                                                                </c:if>
                                                                <c:if test="${list[5] eq 4}">
                                                                    <td>WithDraw</td>
                                                                </c:if>
                                                                <!--<td>$//{list[5]}</td>-->
                                                                <td>${list[6]}</td>
                                                                <td>
                                                                    <div class="btn-group">
                                                                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                            Action <span class="caret"></span>
                                                                        </button>
                                                                        <ul class="dropdown-menu">
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
        </form:form>

        <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
        <!-- /.content -->
    </div>

    <script type="text/javascript">
        $('.form_datetime').datetimepicker({
            //            language: 'fr',
            weekStart: 1,
            //            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 1,
            minView: 0,
            maxView: 1,
            forceParse: 0
        });
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <!--    <script>
            $(document).ready(function () {
                $('#table_2').DataTable();
            })
        </script>-->
</html>


