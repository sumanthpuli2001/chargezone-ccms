<%--
    Document   : LeaveBalanceEmployeeWise
    Created on : May 6, 2016, 3:46:44 PM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Leave Balance</title>
    </head>

    <script>
        function viewClick(leaveBalId) {
            document.getElementById('viewLeaveBal_id').innerHTML = "Fetching ......";
            $.post("leaveEmployeeDetail.htm?act=readLeaveBalAjax",
                    {
                        leaveBalId: leaveBalId
                    }, function (responseTxt, statusTxt, xhr) {
                if (statusTxt === "success") {
                    document.getElementById('viewLeaveBal_id').innerHTML = responseTxt;
                }
                if (statusTxt === "error")
                    alert("Error: " + xhr.status + ": " + xhr.statusText);
            });
        }
    </script>
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
    </script>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Search Employee Leave Balance:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa a-dashboard"></i> Home</a></li>
                <li class="active">Search Leave Balance</li>
            </ol>
        </section>f
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form" action="leaveEmployeeDetail.htm?act=showEmployeeLeaveBalance" commandName="employeeMaster" method="post" name='form' onsubmit='return saveSubmit11();'>
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
        <form:form action="" method="post" commandName="leaveTypeMaster"
                   name='form1' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="box-header" style="text-align: right;">
                                    <button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" title="Export To Excel" onclick="window.location = 'leaveEmployeeDetail.htm?act=exportToExcelLeaveBalance'"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">
                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${empty employeeBalanceMap}">
                                                            <tr>
                                                                <td align="center">
                                                                    <c:out value="There is no record found."></c:out>
                                                                    </td>
                                                                </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th>Employee No</th>
                                                                    <th>Employee Name</th>
                                                                    <th>Casual Leave</th>
                                                                    <th>Sick Leave</th>
                                                                    <th>Privilege Leave</th>
                                                                    <th>Paternity Leave</th>
                                                                    <th>Action</th>
                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="employeeBalanceMap" items="${employeeBalanceMap}">
                                                            <tr>
                                                                <%--<c:forEach var="empLeaveBalance" items="${employeeBalanceMap.value}" varStatus="sCount">--%>
                                                                <td>${employeeBalanceMap.value[0]}</td>
                                                                <td>${employeeBalanceMap.value[1]}</td>
                                                                <td>${employeeBalanceMap.value[2]}</td>
                                                                <td>${employeeBalanceMap.value[3]}</td>
                                                                <td>${employeeBalanceMap.value[4]}</td>
                                                                <td>${employeeBalanceMap.value[5]}</td>
                                                                <%--</c:forEach>--%>
                                                                <td>
                                                                    <c:set var="leaveType" value="${fn:split(employeeBalanceMap.value[6], '_')}"></c:set>
                                                                        <div class="btn-group">
                                                                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                                Edit <span class="caret"></span>
                                                                            </button>
                                                                            <ul class="dropdown-menu">
                                                                                <li>
                                                                                    <a href="#" data-toggle="modal" data-target="#myModal"
                                                                                       onclick="viewClick(${leaveType[0]});">
                                                                                    &nbsp;&nbsp;CL
                                                                                </a>
                                                                            </li>
                                                                            <li>
                                                                                <a href="#" data-toggle="modal" data-target="#myModal"
                                                                                   onclick="viewClick(${leaveType[1]});">
                                                                                    &nbsp;&nbsp;SL
                                                                                </a>
                                                                            </li>
                                                                            <li>
                                                                                <a href="#" data-toggle="modal" data-target="#myModal"
                                                                                   onclick="viewClick(${leaveType[2]});">
                                                                                    &nbsp;&nbsp;PL
                                                                                </a>
                                                                            </li>
                                                                            <c:if test="${leaveType[3] ne '0'}">
                                                                                <li>
                                                                                    <a href="#" data-toggle="modal" data-target="#myModal"
                                                                                       onclick="viewClick(${leaveType[3]});">
                                                                                        &nbsp;&nbsp;PTL
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
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
            <div class="modal-dialog" role="document">
                <!--<div class="fadeOutEffect alert alert-danger" role="alert" id="alertId"></div>-->
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="myModalLabel">Leave Employee Balance</h4>
                    </div>
                    <div class="modal-body" id="viewLeaveBal_id">

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="reloadFun();">Close</button>
                        <button type="button" class="btn btn-primary" onclick="submitFormFun();">Submit</button>

                    </div>
                </div>
            </div>
        </div>
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

        function submitFormFun() {
            var empLeaveBalId = document.getElementById("empLeaveBalId").value;
            alert("empLeaveBalId" + empLeaveBalId);
            var leaveBalance = document.getElementById("leaveBalance").value;
            alert("leaveBalance" + leaveBalance);
            $.ajax({
                type: "POST",
                url: "leaveEmployeeDetail.htm?act=leaveBalUpdate&empLeaveBalId=" + empLeaveBalId,
                data: {leaveBalance: leaveBalance},
                dataType: "text",
                success: function (responseTxt) {
                    alert(responseTxt);
                    document.getElementById("alertId").innerHTML = responseTxt;
                },
                error: function () {
//                    alert('Error occured');
                }
            });
        }

        function reloadFun() {
            window.location.reload();
        }

    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>

