<%-- 
    Document   : EmployeeReferralListForHR
    Created on : Dec 11, 2015, 5:09:42 PM
    Author     : Irfan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Referral List</title>
        <script>
            function viewClick(id) {
                window.location = 'employeeReferral.htm?act=createViewReferral&id=' + id;
            }
//            function dateValidator() {
//                var startDate = document.getElementById("holidayFromDate").value;
//                var endDate = document.getElementById("holidayToDate").value;
//                if (startDate) {
//                    var startDatearray = startDate.split("/");
//                    var endDatearray = endDate.split("/");
//                    var sDate = new Date(startDatearray[2], startDatearray[1] - 1, startDatearray[0]);
//                    var eDate = new Date(endDatearray[2], endDatearray[1] - 1, endDatearray[0]);
//                    if (sDate >= eDate) {
//                        document.getElementById("holidayToDate").value = "";
//                        alert("End date should be greater than Start date");
//                        return false;
//                    }
//                } else {
//                    document.getElementById("holidayToDate").value = "";
//                    alert("startdate must not be empty");
//                }
//            }
        </script>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>EMPLOYEE REFERRAL LIST </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>Home</a></li>
                <li class="active">Employee Referral List</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->

        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <!--                                <button type="button" class="btn btn-primary" title="" style="float: right" onclick="window.location = 'holidayMaster.htm?act=createOrUpdateClick'"><i class="fa fa-plus"></i>&nbsp;&nbsp;Holiday</button>
                                                            <button type="submit" class="btn btn-danger" title=""><i class="fa fa-trash"></i>&nbsp;&nbsp;Delete</button>-->
                            <div style="clear: both"></div>
                            <div class="box-header" style="text-align: right;">
                                <button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" title="Export To Excel" onclick="window.location = 'employeeReferral.htm?act=exportToExcel'"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>
                            </div>
                            <div class="box-body no-padding">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12">
                                        <div class="table table-bordered">

                                            <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="center">
                                                <c:choose>
                                                    <c:when test="${empty employeeRefList}">
                                                        <tr>
                                                            <td align="center">There Is No Any Record</td>
                                                        </tr>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <thead>
                                                            <tr>
                                                                <!--<th style="width: 1px !important;" align="enter"><input type="checkbox" id="toggleId" align="center"/></th>-->
                                                                <th>Sr.No.</th>
                                                                <th>Employee Name</th>
                                                                <th>Department</th>
                                                                <th>Designation</th>
                                                                <th>Candidate Name</th>
                                                                <th>Candidate Contact No.</th>
                                                                <th>Position Referred For</th>
                                                                <th>Status</th>
                                                                <th>Action</th>
                                                            </tr>
                                                        </thead>
                                                        <c:set var="count" value="0" scope="page" />
                                                        <tbody>
                                                            <c:forEach  var="employeeRefList" items="${employeeRefList}" varStatus="index">
                                                                <c:if test="${((sessionScope.employeeInfo.id eq finalApprover) or sessionScope.userRight.employeeReferral) or sessionScope.employeeInfo.employeeName eq employeeRefList[3]}">
                                                                    <c:set var="count" value="${count + 1}" scope="page"/>
                                                                    <tr>
                                                                        <!--<td align="center">-->
                                                                        <!--<input type="checkbox" name="checkId" id="deptCheckId" value="">--> 
                                                                        <!--</td>-->
                                                                        <td>
                                                                            ${count}
                                                                            <!--$count+1}-->
                                                                        </td>
                                                                        <td>
                                                                            ${employeeRefList[3]}
                                                                        </td>
                                                                        <td>
                                                                            ${employeeRefList[8]}
                                                                        </td>
                                                                        <td>
                                                                            ${employeeRefList[5]}
                                                                        </td>
                                                                        <td>
                                                                            ${employeeRefList[0].candidateName}
                                                                        </td>
                                                                        <td>
                                                                            ${employeeRefList[0].candidateContactNo}
                                                                        </td>
                                                                        <td>
                                                                            ${employeeRefList[13]}-${employeeRefList[14]}
                                                                        </td>
                                                                        <td>
                                                                            <c:if test="${employeeRefList[0].status eq 0}">
                                                                            <span class="label label-default">${employeeRefList[0].statusRemark}</span>
                                                                            </c:if>
                                                                            <c:if test="${employeeRefList[0].status eq 1}">
                                                                            <span class="label label-success">${employeeRefList[0].statusRemark}</span>
                                                                            </c:if>
                                                                            <c:if test="${employeeRefList[0].status eq 5}">
                                                                            <span class="label label-danger">${employeeRefList[0].statusRemark}</span>
                                                                            </c:if>
                                                                            <c:if test="${employeeRefList[0].status eq 2}">
                                                                            <span class="label label-info">${employeeRefList[0].statusRemark}</span>
                                                                            </c:if>
                                                                            <c:if test="${employeeRefList[0].status eq 3}">
                                                                            <span class="label label-success">${employeeRefList[0].statusRemark}</span>
                                                                            </c:if>
                                                                        </td>
                                                                        <td>
                                                                            <div class="btn-group">
                                                                                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" onclick="viewClick(${employeeRefList[0].id});">
                                                                                    View
                                                                                </button>
                                                                            </div>
                                                                        </td>
                                                                    </tr>
                                                                </c:if>
                                                            </c:forEach>
                                                        </tbody>
                                                    </c:otherwise>
                                                </c:choose>
                                            </table>
                                        </div>
                                    </div>
                                </div><!-- /.tab-pane -->
                            </div>
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section>
        <!-- /.content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>