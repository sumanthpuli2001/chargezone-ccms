<%--
    Document   : LeaveApprovalRequest
    Created on : Oct 16, 2015, 5:49:02 PM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Leave Request</title>
    </head>
    <script>
        function viewClick(id, userId) {
            window.location = 'leaveEmployeeDetail.htm?act=viewReqDetailByAdmin&id=' + id + '&userId=' + userId;
        }

        function searchSubmit() {
            var checkboxes = "";
            checkboxes = document.getElementsByName('checkId');
            for (var i = 0, n = checkboxes.length; i < n; i++) {
                if (checkboxes[i].checked) {
                    return true;
                }
            }
            return false;
        }
    </script>



    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>LEAVE REQUEST </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Leave Request Of Subordinates</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="leaveEmployeeDetail.htm?act=searchOwnLeaveRequestResult" method="post" commandName="employeeMaster"
                   name='form1'  class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <div class="col-sm-6"><span style="color: red;font-size: 12px;"></span>
                                                    <label>Employee Name:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:input path="employeeName" class="form-control" ></form:input>
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
                                        <button type="submit" class="btn btn-primary" style="width: 100px;" data-original-title="" title="" >SEARCH</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </section>

        </form:form>
        <form:form action="" method="post" commandName=""
                   name='form1' class="form-horizontal" role="form">
            <div class="row" >
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <h3>&nbsp;&nbsp;&nbsp;Result :</h3>
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
                                                                <th>Employee Name</th>
                                                                <th>Sub Team</th>
                                                                <th>Type Of Leave</th>
                                                                <th>Start Date</th>
                                                                <th>End Date</th>
                                                                <th>No Of Days</th>
                                                                <th>Date of Submission</th>
                                                                <th>Status</th>
                                                                <th>Action</th>
                                                            </tr>
                                                        </thead>
                                                    </c:otherwise>
                                                </c:choose>
                                                <tbody>
                                                    <c:forEach var="list" items="${list1}">
                                                        <tr>
                                                            <td>${list[0]}</td>
                                                            <td>${list[10]}</td>
                                                            <td>${list[1]}</td>
                                                            <td>${list[2]}</td>
                                                            <td>${list[3]}</td>
                                                            <td>${list[4]}</td>
                                                            <td>${list[8]}</td>
                                                            <c:if test="${list[6] eq 0}">
                                                                <td><span class="badge">Pending</span></td>
                                                            </c:if>
                                                            <c:if test="${list[6] eq 3}">
                                                                <td><span class="label label-success">Approved</span></td>
                                                            </c:if>
                                                            <c:if test="${list[6] eq 2}">
                                                                <td><span class="label label-danger">Rejected</span></td>
                                                            </c:if>
                                                            <c:if test="${list[6] eq 1}">
                                                                <td><span class="label label-warning">Reworked</span></td>
                                                            </c:if>
                                                            <c:if test="${list[6] eq 4}">
                                                                <td><span class="label label-info">WithDraw Request</span></td>
                                                            </c:if>
                                                            <c:if test="${list[6] eq 5}">
                                                                <td><span class="badge">Withdrawn</span></td>
                                                            </c:if>
                                                            <c:if test="${list[6] eq 6}">
                                                                <td><span class="label label-success">Approved By HR</span></td>
                                                            </c:if>
                                                            <c:if test="${list[6] eq 7}">
                                                                <td><span class="label label-danger">Rejected By HR</span></td>
                                                            </c:if>
                                                            <c:if test="${list[6] eq 8}">
                                                                <td><span class="label label-warning">Reworked By HR</span></td>
                                                            </c:if>    
                                                            <!--<td>$//{list[5]}</td>-->
                                                            <td>
                                                                <div class="btn-group">
                                                                    <button type="button"  onclick="viewClick(${list[5]},${list[7]});"  class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                        View
                                                                    </button>
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
    <!--    <script>
            $(document).ready(function () {
                $('#table_2').DataTable();
            })
        </script>-->
</html>



