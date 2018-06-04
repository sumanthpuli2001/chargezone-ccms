<%--
    Document   : NoDuesRequestsListView
    Created on : Mar 19, 2016, 11:20:40 AM
    Author     : Irfan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>No Dues Requests</title>
    </head>
    <script>
        function viewClick(employeeId, reportingManager) {
          
//            window.location = 'employeeMaster.htm?act=viewClick&id=' + id;
            window.location = 'noDueMaster.htm?act=viewNoDueRequest&employeeId=' + employeeId + '&reportingManager=' + reportingManager;
        }
//        function createClick(id) {
//            window.location = 'userRightMaster.htm?act=createClick&id=' + id;
//        }
//        function changeShiftClick(id) {
//            window.location = 'employeeMaster.htm?act=changeEmployeeShift&id=' + id;
//        }
//        function editRotation(id) {
//            window.location = 'shiftRotationInfo.htm?act=viewRotationClick&id=' + id;
//        }
//
//        function deleteCheck11() {
//            var checkboxes = "";
//            checkboxes = document.getElementsByName('checkId');
//            for (var i = 0, n = checkboxes.length; i < n; i++) {
//                if (checkboxes[i].checked) {
//                    return true;
//                }
//            }
//            alert("Please, Select one or more record(s).");
//            return false;
//        }
    </script>



    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>NO DUE REQUESTS </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">No Due Requests</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                             <div class="box-header" style="text-align: right;">
                                    <button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" title="Export To Excel" onclick="window.location = 'noDueMaster.htm?act=exportToExcelResignation'"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>
                                </div>
                            <div class="box-body no-padding">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12">
                                        <div class="table table-bordered">
                                            <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                <c:choose>
                                                    <c:when test="${empty employeesListOfList}">
                                                        <tr>
                                                            <td align="center">
                                                                <c:out value="There is no record found."></c:out>
                                                                </td>
                                                            </tr>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <thead>
                                                            <tr>

                                                                <!--<th>user id</th>-->
                                                                <th style="width: 50px;">Employee ID</th>
                                                                <th style="width: 50px;">Employee Name</th>
                                                                <th style="width: 50px;">Department</th>
                                                                <th style="width: 50px;">Designation</th>
                                                                <th style="width: 50px;">Date of Relieving</th>
                                                                <th style="width: 50px;">Status</th>
                                                                    <%--<c:if test="${sessionScope.userRight.hr}">--%>
                                                                <th style="width: 50px;">Action</th>
                                                                    <%--</c:if>--%>

                                                            </tr>
                                                        </thead>
                                                    </c:otherwise>
                                                </c:choose>
                                                <tbody>
                                                    <c:forEach var="employeesListOfListOuter" items="${employeesListOfList}">
                                                        <c:forEach var="list" items="${employeesListOfListOuter}">
                                                            <!--//$list[7]} means reporting MAnager-->
                                                            <%--<c:if test="${(sessionScope.employeeInfo.id eq list[7]) or (sessionScope.userRight.noDue) or (sessionScope.userRight.itAdmin) or (sessionScope.userRight.travelExpenseAdmin)}">--%>
                                                            <c:if test="${(sessionScope.employeeInfo.id eq list[7]) or (sessionScope.userRight.employeeExit) or (sessionScope.userRight.itAdmin) or (sessionScope.userRight.travelExpenseAdmin)}">
                                                                <%--<c:if test="${(!list[8]) or(!list[9]) or (!list[10]) or (!list[11]) or (sessionScope.userRight.noDue && sessionScope.userRight.itAdmin && sessionScope.userRight.travelExpenseAdmin)}">--%>
                                                                <%--<c:if test="${(!list[8]) or(!list[9]) or (!list[10]) or (!list[11]) or (sessionScope.userRight.employeeExit)}">--%>

                                                                <tr>

                                                                    <!--<td>/</td>-->
                                                                    <td>${list[1]}</td>
                                                                    <td>${list[2]}</td>
                                                                    <td>${list[3]}</td>
                                                                    <td>${list[4]}</td>
                                                                    <td>${list[12]}</td>
                                                                    <td>
                                                                        <c:set var="count" value="0" scope="page"/>
                                                                        <c:choose>
                                                                            <c:when test="${sessionScope.employeeInfo.id eq list[7]}">
                                                                                <!--check it that reporting manager or not-->
                                                                                <c:choose>
                                                                                    <c:when test="${list[8]}">
                                                                                        <c:set var="count" scope="page" value="${count + 1}" />
                                                                                        <c:if test="${count eq 1}">
                                                                                            <span class="label label-success label-as-badge">
                                                                                                Completed
                                                                                            </span>
                                                                                        </c:if>
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        <c:set var="count" scope="page" value="${count + 1}" />
                                                                                        <c:if test="${count eq 1}">
                                                                                            <span class="label label-default label-as-badge">
                                                                                                Pending
                                                                                            </span>
                                                                                        </c:if>
                                                                                    </c:otherwise>
                                                                                </c:choose>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <%--<c:if test="${sessionScope.userRight.noDue}">--%>
                                                                                <c:if test="${sessionScope.userRight.employeeExit}">
                                                                                    <c:choose>
                                                                                        <c:when test="${list[9]}">
                                                                                            <c:set var="count" scope="page" value="${count + 1}" />
                                                                                            <c:if test="${count eq 1}">
                                                                                                <span class="label label-success label-as-badge">
                                                                                                    Completed
                                                                                                </span>
                                                                                            </c:if>
                                                                                        </c:when>
                                                                                        <c:otherwise>
                                                                                            <c:set var="count" scope="page" value="${count + 1}" />
                                                                                            <c:if test="${count eq 1}">
                                                                                                <span class="label label-default label-as-badge">
                                                                                                    Pending
                                                                                                </span>
                                                                                            </c:if>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                </c:if>
                                                                                <c:if test="${sessionScope.userRight.itAdmin}">
                                                                                    <c:choose>
                                                                                        <c:when test="${list[10]}">
                                                                                            <c:set var="count" scope="page" value="${count + 1}" />
                                                                                            <c:if test="${count eq 1}">
                                                                                                <span class="label label-success label-as-badge">
                                                                                                    Completed
                                                                                                </span>
                                                                                            </c:if>
                                                                                        </c:when>
                                                                                        <c:otherwise>
                                                                                            <c:set var="count" scope="page" value="${count + 1}" />
                                                                                            <c:if test="${count eq 1}">
                                                                                                <span class="label label-default label-as-badge">
                                                                                                    Pending
                                                                                                </span>
                                                                                            </c:if>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                </c:if>
                                                                                <c:if test="${sessionScope.userRight.travelExpenseAdmin}">
                                                                                    <c:choose>
                                                                                        <c:when test="${list[11]}">
                                                                                            <c:set var="count" scope="page" value="${count + 1}" />
                                                                                            <c:if test="${count eq 1}">
                                                                                                <span class="label label-success label-as-badge">
                                                                                                    Completed
                                                                                                </span>
                                                                                            </c:if>
                                                                                        </c:when>
                                                                                        <c:otherwise>
                                                                                            <c:set var="count" scope="page" value="${count + 1}" />
                                                                                            <c:if test="${count eq 1}">
                                                                                                <span class="label label-default label-as-badge">
                                                                                                    Pending
                                                                                                </span>
                                                                                            </c:if>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                </c:if>
                                                                            </c:otherwise>

                                                                        </c:choose>
                                                                    </td>
                                                                <!--<td>${list[8]},${list[9]},${list[10]},${list[11]}</td>-->
                                                                    <%--<c:if test="${sessionScope.userRight.hr}">--%>
                                                                    <td>
                                                                        <div class="btn-group">
                                                                            <button type="button" class="btn btn-default dropdown-toggle" onclick="viewClick(${list[0]},${list[7]});" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                                View
                                                                            </button>
                                                                        </div>
                                                                    </td>
                                                                    <%--</c:if>--%>
                                                                </tr>
                                                                <%--</c:if>--%>
                                                            </c:if>
                                                        </c:forEach>
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


        <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
        <!-- /.content -->
    </div>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <!--    <script>
            $(document).ready(function () {
                $('#table_2').DataTable();
            })
        </script>-->
</html>
