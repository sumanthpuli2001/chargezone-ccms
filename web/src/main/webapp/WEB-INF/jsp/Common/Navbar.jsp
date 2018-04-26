<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <!--        <script>
                    jQuery(document).ready(function () {
                        lSocalStorage.setItem("reportingCheck",${fn:length(reportingManagerList)>0});
                        alert("from storage     " + localStorage.getItem("reportingCheck"));

                    });
                </script>-->

    </head>

    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar" style="background-color: #fff;">
            <!-- Sidebar user panel -->
            <div class="user-panel"  style="background-color: #fff;">
                <div class="pull-left image">
                    <img src="${sessionScope.profilePicturePath}" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p style="color:#585858;">${sessionScope.employeeInfo.employeeName}</p>
                    <a href="#"></a>
                </div>
            </div>
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu">
                <c:if test="${!sessionScope.userRight.hr}">
                    <li class="active treeview">
                        <a href="userMaster.htm?act=goToDashboard">
                            <i class="fa fa-dashboard fa-lg"></i> <span>My Dashboard</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.userRight.hr}">
                    <li class="active treeview">
                        <a href="userMaster.htm?act=hrDashboard"  style="color: #fff;  background: #fff;">
                            <i class="fa fa-dashboard fa-lg" style="color: #424242;"></i> <span style="color: #424242;">My Dashboard</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${!sessionScope.userRight.hr}">
                    <li class="active treeview">
                        <a href="homeController.htm?act=openHomePage">
                            <i class="fa fa-home fa-lg"></i> <span>Homepage</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.userRight.hr}">
                    <li class="active treeview">
                        <a href="homeController.htm?act=openHomePage" style="color: #fff;  background: #fff;">
                            <i class="fa fa-home fa-lg" style="color: #424242;"></i> <span style="color: #424242;">Homepage</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.userRight.employeeManagement}">
                    <li class="treeview" style="color: #585858;">
                        <a href="#" style="background: #fff;">
                            <i class="fa fa-user fa-lg" style="color: #585858;"></i>
                            <span style="color: #585858;">Recruitment</span>
                            <i class="fa fa-angle-left pull-right"></i>
                        </a>
                        <ul class="treeview-menu">

                            <!--<li><a href="employeeMaster.htm?act=createClick"><i class="fa fa-circle-o"></i>Employee Registration</a></li>-->
                            <li><a href="recruitment.htm?act=recruitmentCreate"><i class="fa fa-circle-o"></i>MPP</a></li>
                            <li><a href="recruitment.htm?act=createMpr"><i class="fa fa-circle-o"></i>MPR</a></li>
                            <li><a href="vacancy.htm?act=vacancyDetailList"><i class="fa fa-circle-o"></i>Vacancy</a></li>
                            <li><a href="candidateF2FApproval.htm?act=candidateF2FReqListForInterviewer"><i class="fa fa-circle-o"></i>Candidate F2F  Request</a></li>

                            <!--<li><a href="vacancy.htm?act=applyJobRegistration"><i class="fa fa-circle-o"></i>Apply Job</a></li>-->
                            <!--                        <li><a href="userMaster.htm?act=createClick"><i class="fa fa-circle-o"></i>User Right</a></li>-->
                        </ul>
                    </li>
                </c:if>
                <c:if test="${!sessionScope.userRight.employeeManagement}">
                    <c:if test="${!sessionScope.userRight.hr}">
                        <li class="treeview" style="color: #585858;">
                            <a href="#" style="background: #fff;">
                                <i class="fa fa-user fa-lg" style="color: #585858;"></i>
                                <span style="color: #585858;">Recruitment</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="recruitment.htm?act=approvalMppCreate"><i class="fa fa-circle-o"></i>MPP Approval</a></li>
                                <li><a href="recruitment.htm?act=recruitmentApprovalCreate"><i class="fa fa-circle-o"></i>MPR Approval</a></li>
                                <li><a href="recruitment.htm?act=candidateList"><i class="fa fa-circle-o"></i>Candidate</a></li>
                                    <c:if test="${sessionScope.userRight.budget}">
                                    <li><a href="recruitment.htm?act=recruitmentCreate"><i class="fa fa-circle-o"></i>MPP</a></li>
                                    </c:if>
                                    <c:if test="${sessionScope.userRight.mpr}">
                                    <li><a href="recruitment.htm?act=createMpr"><i class="fa fa-circle-o"></i>MPR</a></li>
                                    </c:if>
                                    <c:if test="${sessionScope.userRight.vacancy}">
                                    <li><a href="vacancy.htm?act=vacancyDetailList"><i class="fa fa-circle-o"></i>Vacancy</a></li>
                                    </c:if>
                                <li><a href="candidateF2FApproval.htm?act=candidateF2FInterviewList"><i class="fa fa-circle-o"></i>All Candidate F2F Request</a></li>
                            </ul>
                        </li>
                    </c:if>
                </c:if>
                <c:if test="${!sessionScope.userRight.employeeManagement}">
                    <li class="treeview">
                        <a href="#">
                            <i class="fa fa-user fa-lg"></i>
                            <span>Recruitment</span>
                            <i class="fa fa-angle-left pull-right"></i>
                        </a>
                        <ul class="treeview-menu">
                            <c:if test="${sessionScope.userRight.mppApproval}">
                                <li><a href="recruitment.htm?act=approvalMppCreate"><i class="fa fa-circle-o"></i>MPP Approval</a></li>
                                </c:if>
                                <c:if test="${sessionScope.userRight.mprApproval}">
                                <li><a href="recruitment.htm?act=recruitmentApprovalCreate"><i class="fa fa-circle-o"></i>MPR Approval</a></li>
                                </c:if>
                                <c:if test="${sessionScope.userRight.candidateList}">
                                <li><a href="recruitment.htm?act=candidateList"><i class="fa fa-circle-o"></i>Candidate</a></li>
                                </c:if>
                                <c:if test="${sessionScope.userRight.vacancy}">
                                <li><a href="vacancy.htm?act=vacancyDetailList"><i class="fa fa-circle-o"></i>Vacancy</a></li>
                                </c:if>
                                <c:if test="${sessionScope.userRight.faceTofaceInterview}">
                                <li><a href="candidateF2FApproval.htm?act=candidateF2FReqListForInterviewer"><i class="fa fa-circle-o"></i>Candidate F2F  Request</a></li>
                                </c:if>
                                <c:if test="${sessionScope.userRight.faceTofaceApproval}">
                                <li><a href="candidateF2FApproval.htm?act=candidateF2FReqListForInterviewer"><i class="fa fa-circle-o"></i>Candidate F2F  Request</a></li>
                                </c:if>

                            <c:if test="${sessionScope.userRight.budget}">
                                <li><a href="recruitment.htm?act=recruitmentCreate"><i class="fa fa-circle-o"></i>MPP</a></li>
                                </c:if>
                                <c:if test="${sessionScope.userRight.mpr}">
                                <li><a href="recruitment.htm?act=createMpr"><i class="fa fa-circle-o"></i>MPR</a></li>
                                </c:if>
                        </ul>
                    </li>
                </c:if>
                <c:if test="${sessionScope.userRight.employeeManagement}">
                    <li class="treeview" style="color: #585858;">
                        <a href="#" style="background: #fff;">
                            <i class="fa fa-user fa-lg" style="color: #585858;"></i>
                            <span style="color: #585858;">Employee Management</span>
                            <i class="fa fa-angle-left pull-right"></i>
                        </a>
                        <ul class="treeview-menu">

                            <!--<li><a href="employeeMaster.htm?act=createClick"><i class="fa fa-circle-o"></i>Employee Registration</a></li>-->
                            <li><a href="employeeMaster.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>Employee Registration</a></li>
                            <li><a href="employeeMaster.htm?act=formerEmployeeRecords"><i class="fa fa-circle-o"></i>Former Employee Details</a></li>
                            <li><a href="employeeMaster.htm?act=excelUploadRegistration"><i class="fa fa-circle-o"></i>Employee Registration By Excel</a></li>
                            <!--                        <li><a href="userMaster.htm?act=createClick"><i class="fa fa-circle-o"></i>User Right</a></li>-->
                        </ul>
                    </li>
                </c:if>
                <li class="treeview" style="color: #585858;">
                    <a href="#" style="background: #fff;" >
                        <i class="fa fa-calendar fa-lg" style="color: #585858;"></i>
                        <span style="color: #585858;">Leave Management</span>
                        <i class="fa fa-angle-left pull-right" ></i>
                    </a>
                    <ul class="treeview-menu">
                        <c:if test="${sessionScope.userRight.leaveManagement}">
                            <li><a href="leaveTypeMaster.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>Leave Type</a></li>
                            <li><a href="shortLeave.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>Short Leave Setting</a></li>
                            <li><a href="coffMaster.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>C-Off Leave Setting</a></li>
                            <li><a href="leaveTypeMaster.htm?act=leaveExcelUpload"><i class="fa fa-circle-o"></i>Leave Excel Upload</a></li>
                            <li><a href="leaveEncashment.htm?act=approveNRejectResult"><i class="fa fa-circle-o"></i>Leave Encashment Request</a></li>
                            <li><a href="leaveEmployeeDetail.htm?act=employeeLeaveApplication"><i class="fa fa-circle-o"></i>Employee Leave Application</a></li>

                        </c:if>
                        <c:if test="${sessionScope.userRight.employee}">
                            <c:if test="${sessionScope.checkReportingManager}">
                                <li><a href="leaveEmployeeDetail.htm?act=searchOwnLeaveDetail"><i class="fa fa-circle-o"></i>Leave Application</a></li>
                                    <c:if test="${fn:contains(level,'4')}">
                                    <!--<li><a href="cOffLeaveRequest.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>C-Off Leave Request</a></li>-->
                                </c:if>
                                <c:if test="${fn:contains(level,'5')}">
                                    <!--<li><a href="cOffLeaveRequest.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>C-Off Leave Request</a></li>-->
                                </c:if>
                            </c:if>
                        </c:if>
                        <c:if test="${sessionScope.userRight.hr or sessionScope.userRight.leaveManagement}">
                            <li><a href="leaveEmployeeDetail.htm?act=searchEmpLeaveDetail"><i class="fa fa-circle-o"></i>Search Employee Leave Detail</a></li>
                            <li><a href="leaveEmployeeDetail.htm?act=searchEmployeeLeaveBalance"><i class="fa fa-circle-o"></i>Search Employee Leave Balance</a></li>
                            </c:if>
                            <c:if test="${sessionScope.isReportingManagerDataExist}">
                            <li><a href="leaveEmployeeDetail.htm?act=viewRequestAdminClick"><i class="fa fa-circle-o"></i>Leave Request Of Subordinates</a></li>
                            <!--<li><a href="leaveEmployeeDetail.htm?act=approverSearch"><i class="fa fa-circle-o"></i>Approver Search Leave Detail</a></li>-->
                            <!--<li><a href="cOffLeaveRequest.htm?act=coffApproveRequest"><i class="fa fa-circle-o"></i>C-Off Approve Request</a></li>-->
                        </c:if>
                        <c:if test="${sessionScope.userRight.employee}">
                            <!--<li><a href="leaveEmployeeDetail.htm?act=searchOwnLeaveDetail"><i class="fa fa-circle-o"></i>Search Leave Detail</a></li>-->
                            <!--<li><a href="leaveEncashment.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>Leave Encashment</a></li>-->
                        </c:if>
                        <!--<li><a href="attendanceRegularizationFormForEmployee.jsp"><i class="fa fa-circle-o"></i>Attendance Regularization</a></li>-->
                    </ul>
                </li>
                <li class="treeview" style="color: #585858;">
                    <a href="#" style="background: #fff;">
                        <i class="fa fa-clock-o fa-lg" style="color: #585858;"></i>
                        <span style="color: #585858;">Attendance Regularization</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>


                    <ul class="treeview-menu">
                        <c:if test="${sessionScope.userRight.employee}">

                            <c:if test="${sessionScope.checkReportingManager}">
                                <li><a href="attendanceRegularizationMaster.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>AR Application</a></li>
                                </c:if>

                            <!--<li><a href="attendanceRegularizationMaster.htm?act=employyeAttendanceApproeList"><i class="fa fa-circle-o"></i>Approved</a></li>-->
                            <li><a href="attendanceRegularizationMaster.htm?act=showOwnAttandance"><i class="fa fa-circle-o"></i>Show Attendance</a></li>

                        </c:if>
                        <c:if test="${sessionScope.userRight.attendanceReport}">
                            <li><a href="attendanceRegularizationMaster.htm?act=powerAdminApprovalList"><i class="fa fa-circle-o"></i>View All AR</a></li>
                            </c:if>
                            <c:if test="${sessionScope.isReportingManagerDataExist}">

                            <li><a href="attendanceRegularizationMaster.htm?act=approvalSubmit"><i class="fa fa-circle-o"></i>Subordinates Request</a></li>
                            <li><a href="attendanceRegularizationMaster.htm?act=subOrdinateAttendanceView"><i class="fa fa-circle-o"></i>Subordinates Attendance View</a></li>
                            <!--<li><a href="attendanceRegularizationMaster.htm?act=approvedList"><i class="fa fa-circle-o"></i>Approved Request</a></li>-->
                        </c:if>
                        <c:if test="${sessionScope.userRight.departmentWiseAttendance}">
                            <li><a href="attendanceRegularizationMaster.htm?act=departmentWiseAttendanceView"><i class="fa fa-circle-o"></i>Department Wise Attendance</a></li>

                        </c:if>
                        <li><a href="employeeDatetimeData.htm?act=searchOddPunch"><i class="fa fa-circle-o"></i>Odd Punch Report</a></li>

                    </ul>
                </li>

                <li class="treeview" style="color: #585858;">
                    <a href="#" style="background: #fff;">
                        <i class="fa fa-plane fa-lg" style="color: #585858;"></i>
                        <span style="color: #585858;">Travel Management</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <c:if test="${sessionScope.userRight.employee}">
                            <c:if test="${sessionScope.checkReportingManager}">
                                <li><a href="travelRequestMaster.htm?act=requestResult"><i class="fa fa-circle-o"></i>Travel Request</a></li>
                                </c:if>
                            </c:if>
                            <c:if test="${sessionScope.isReportingManagerDataExist}">
                            <li><a href="travelRequestMaster.htm?act=requestResult1"><i class="fa fa-circle-o"></i>Subordinates Travel Request</a></li>
                            </c:if>
                            <%--<c:if test="${sessionScope.userRight.employee}">--%>
                            <%--</c:if>--%>
                        <!--<li><a href="travelRequestMaster.htm?act=viewRequestResultManagerSide"><i class="fa fa-circle-o"></i>Subordinates Travel Report</a></li>-->
                        <c:if test="${!sessionScope.checkReportingManager}">
                            <li><a href="travelRequestMaster.htm?act=requestResultCEO"><i class="fa fa-circle-o"></i>Travel Result CEO</a></li>
                            </c:if>
                            <c:if test="${sessionScope.userRight.travelAdmin}">

                            <!--<li><a href="travelRequestMaster.htm?act=searchTravelRequest"><i class="fa fa-circle-o"></i>Search Travel Request</a></li>-->
                            <li><a href="travelRequestMaster.htm?act=viewRequestAdminSubmit"><i class="fa fa-circle-o"></i>Search Travel Request </a></li>
                            </c:if>
                            <%--<c:if test="${sessionScope.userRight.employee}">--%>
                        <!--<li><a href="travelRequestMaster.htm?act=searchOwnTravelRequest"><i class="fa fa-circle-o"></i>Own Travel Report</a></li>-->
                        <!--<li><a href="travelRequestMaster.htm?act=searchTravelRequestAdmin"><i class="fa fa-circle-o"></i>Subordinates Travel Report</a></li>-->
                        <!--<li><a href="expenseMaster.htm?act=createExpenseResult"><i class="fa fa-circle-o"></i>Expense Request</a></li>-->
                        <!--<li><a href="expenseMaster.htm?act=createExpenseApproveList"><i class="fa fa-circle-o"></i>Subordinates Expense Request</a></li>-->
                        <!--<li><a href="expenseMaster.htm?act=searchSubordinatesExpenseReport"><i class="fa fa-circle-o"></i>Subordinates Expense Report</a></li>-->
                        <%--</c:if>--%>
                        <%--<c:if test="${sessionScope.userRight.travelExpenseAdmin}">--%>
                        <!--<li><a href="expenseMaster.htm?act=viewExpenseAdminSide"><i class="fa fa-circle-o"></i>Final Expense Approve</a></li>-->
                        <!--<li><a href="expenseMaster.htm?act=searchExpenseRequest"><i class="fa fa-circle-o"></i>Search Expense Request</a></li>-->
                        <%--</c:if>--%>
                        <%--<c:if test="${sessionScope.userRight.employee}">--%>
                        <!--<li><a href="expenseMaster.htm?act=searchOwnExpenseRequest"><i class="fa fa-circle-o"></i>Own Expense Report</a></li>-->
                        <%--</c:if>--%>
                        <!--<li><a href="expenseMaster.htm?act=createExpenseResult"><i class="fa fa-circle-o"></i>Expense Report</a></li>-->
                        <%--</c:if>--%>
                    </ul>
                </li>
                <li class="treeview" style="color: #585858;">
                    <a href="#" style="background: #fff;">
                        <i class="fa fa-rupee fa-lg" style="color: #585858;"></i>
                        <span style="color: #585858;">Expense Report</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">

                        <c:if test="${sessionScope.userRight.employee}">
                            <!--<li><a href="travelRequestMaster.htm?act=searchOwnTravelRequest"><i class="fa fa-circle-o"></i>Own Travel Report</a></li>-->
                            <!--<li><a href="travelRequestMaster.htm?act=searchTravelRequestAdmin"><i class="fa fa-circle-o"></i>Subordinates Travel Report</a></li>-->
                            <c:if test="${sessionScope.checkReportingManager}">
                                <li><a href="expenseMaster.htm?act=createExpenseResult"><i class="fa fa-circle-o"></i>Expense Request</a></li>
                                </c:if>
                                <c:if test="${sessionScope.isReportingManagerDataExist}">

                                <li><a href="expenseMaster.htm?act=createExpenseApproveList"><i class="fa fa-circle-o"></i>Subordinates Expense Request</a></li>
                                </c:if>
                            <!--<li><a href="expenseMaster.htm?act=searchSubordinatesExpenseReport"><i class="fa fa-circle-o"></i>Subordinates Expense Report</a></li>-->
                        </c:if>
                        <c:if test="${sessionScope.userRight.travelExpenseAdmin}">
                            <li><a href="expenseMaster.htm?act=viewExpenseAdminSide"><i class="fa fa-circle-o"></i>Final Expense Approve</a></li>
                            <li><a href="expenseMaster.htm?act=searchExpenseRequest"><i class="fa fa-circle-o"></i>Search Expense Request</a></li>
                            <li><a href="expenseMaster.htm?act=pendingExpenseRequestList"><i class="fa fa-circle-o"></i>View Pending Expense Request</a></li>
                            </c:if>
                            <c:if test="${sessionScope.userRight.travelExpenseAdmin or sessionScope.userRight.cashAdvanceView}">
                            <li><a href="travelRequestMaster.htm?act=viewCashAdvanceSectionByAdmin"><i class="fa fa-circle-o"></i>Cash Advance Request</a></li>
                            </c:if>
                            <c:if test="${sessionScope.userRight.employee}">
                            <!--<li><a href="expenseMaster.htm?act=searchOwnExpenseRequest"><i class="fa fa-circle-o"></i>Own Expense Report</a></li>-->
                        </c:if>
                        <!--<li><a href="expenseMaster.htm?act=createExpenseResult"><i class="fa fa-circle-o"></i>Expense Report</a></li>-->
                        <%--</c:if>--%>
                    </ul>
                </li>
                <c:if test="${sessionScope.userRight.hr or sessionScope.userRight.shiftManagement or sessionScope.userRight.hr or sessionScope.userRight.temporaryShiftAssign}">
                    <li class="treeview" style="color: #585858;">
                        <a href="#" style="background: #fff;">
                            <i class="fa fa-cogs fa-lg" style="color: #585858;"></i>
                            <span style="color: #585858;">Shift Management</span>
                            <i class="fa fa-angle-left pull-right"></i>
                        </a>
                        <ul class="treeview-menu">
                            <c:if test="${sessionScope.userRight.hr or sessionScope.userRight.shiftManagement}">

                                <li><a href="shiftMaster.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>Shift</a></li>

                                <li><a href="hoursBasis.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>Hours </a></li>
                                <li><a href="maxDayLateAllowed.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>Maximum Day Late Allowed </a></li>
                                <li><a href="shiftRotationMaster.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>Shift Rotation </a></li>
                                </c:if>
                                <c:if test="${sessionScope.userRight.hr or sessionScope.userRight.temporaryShiftAssign}">
                                <li><a href="temporaryShiftAssign.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>Temporary Shift Assign </a></li>
                                </c:if>
                        </ul>
                        <ul class="treeview-menu">
                            <li><a href="shiftRotationMaster.htm?act=EmployeeShiftAssignDetail"><i class="fa fa-circle-o"></i>Employee Shift Assign</a></li>
                        </ul>
                        <ul class="treeview-menu">
                            <li><a href="shiftRotationMaster.htm?act=employeeManualPunch"><i class="fa fa-circle-o"></i>Employee Punch Entry</a></li>
                        </ul>
                        <ul class="treeview-menu">
                            <li><a href="shiftRotationMaster.htm?act=employeeShiftChangeMonthly"><i class="fa fa-circle-o"></i>Monthly Shift Assign By Excel</a></li>
                        </ul>
                    </li>
                </c:if>
                <li class="treeview" style="color: #585858;">
                    <a href="#" style="background: #fff;">
                        <i class="fa fa-bar-chart fa-lg" style="color: #585858;"></i>
                        <span style="color: #585858;">Performance Management</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <!--<li><a href="appraisalPerformance.htm?act=createClick"><i class="fa fa-circle-o"></i>Performance Appraisal </a></li>-->
                        <%--<c:if test="${sessionScope.checkReportingManager}">--%>
                        <li><a href="appraisalPerformance.htm?act=searchOwnappraisalPerformanceSubmit"><i class="fa fa-circle-o"></i>PMP Form</a></li>
                        <li><a href="performanceImprovementPlanMaster.htm?act=createClick"><i class="fa fa-circle-o"></i>PIP Form</a></li>
                            <%--</c:if>--%>
                        <li><a href="appraisalPerformance.htm?act=searchClick"><i class="fa fa-circle-o"></i>Subordinates PMP</a></li>
                        <!--<li><a href="appraisalPerformance.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>Subordinates PMP</a></li>-->
                        <li><a href="performanceImprovementPlanMaster.htm?act=viewPipListByManager"><i class="fa fa-circle-o"></i>Subordinates PIP</a></li>
                            <c:if test="${sessionScope.userRight.appraisalPmp}">
                            <li><a href="appraisalPerformance.htm?act=searchAppraisalPerformanceReoprtStageWise"><i class="fa fa-circle-o"></i>PMP-Report</a></li>
                            <li><a href="performanceImprovementPlanMaster.htm?act=viewPipListByAdmin"><i class="fa fa-circle-o"></i>View All PIP </a></li>
                            <li><a href="kraCategory.htm?act=createClick"><i class="fa fa-circle-o"></i>KRA Category</a></li>
                            <!--<li><a href="appraisalFillingData.htm?act=createClick"><i class="fa fa-circle-o"></i>Appraisal Filling Data </a></li>-->
                            <li><a href="appraisalFillingData.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>Appraisal Time-Line Data</a></li>
                            <!--<li><a href="competencyEvaluationMaster.htm?act=createClick"><i class="fa fa-circle-o"></i>Competency Evaluation</a></li>-->
                            <li><a href="competencyEvaluationMaster.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>Competency Evaluation Search</a></li>
                            <!--<li><a href="competencyEvaluationTextmaster.htm?act=createClick"><i class="fa fa-circle-o"></i>Competency Evaluation Text</a></li>-->
                            <li><a href="competencyEvaluationTextmaster.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>Competency Evaluation <br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Text Result</a></li>
                            <li class="treeview"><a href="pmpFormStatusMaster.htm?act=showpmpStatusMaster"> <i class="fa fa-circle-o"></i>Unlock PMP Form</span></a></li>
                            </c:if>
                        <li><a href="appraisal360.htm?act=dashboardResult"><i class="fa fa-circle-o"></i>360 FeedBack Form</a></li>
                            <c:if test="${sessionScope.userRight.appraisal360}">
                            <li><a href="appraisal360.htm?act=createAppraisalResult"><i class="fa fa-circle-o"></i>360 Appraisal</a></li>
                            <li><a href="appraisal360.htm?act=searchEmpAppraisal360"><i class="fa fa-circle-o"></i>360 Appraisal Search</a></li>
                            <li><a href="appraisal360.htm?act=searchAppraisalPerformance360Reoprt"><i class="fa fa-circle-o"></i>360 Appraisal Report</a></li>
                            </c:if>

                    </ul>
                </li>

                <li class="treeview" style="color: #585858;" >
                    <a href="#" style="background: #fff;">
                        <i class="fa fa-question-circle fa-lg" style="color: #585858;"></i>
                        <span style="color: #585858;">Employee Request</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
                        <c:if test="${!sessionScope.userRight.poolCarAdmin}">
                            <c:if test="${sessionScope.checkReportingManager}">

                                <li><a href="poolCarRequest.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>Pool Car Request </a></li>
                                <!--<li><a href="poolCarRequest.htm?act=searchEmpClick"><i class="fa fa-circle-o"></i>Search Pool Car Request </a></li>-->

                            </c:if>
                        </c:if>
                        <%--<c:if test="${fn:length(reportingManagerList) > 0}">--%>
                        <c:if test="${sessionScope.isReportingManagerDataExist}">
                            <%--<c:if test="${reportingManagerList.size > 0}">--%>
                            <li id="er3"><a href="poolCarRequest.htm?act=searchApproverSubmit"><i class="fa fa-circle-o"></i>Subordinates Pool Car
                                    <br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Request </a></li>
                                </c:if>

                        <c:if test="${sessionScope.userRight.poolCarAdmin}">
                            <li><a href="poolCarRequest.htm?act=adminApproveSubmit"><i class="fa fa-circle-o"></i>Pool Car Request Admin </a></li>
                            <!--<li><a href="poolCarRequest.htm?act=searchAdminClick"><i class="fa fa-circle-o"></i>Search Pool Car Request(Admin)</a></li>-->
                        </c:if>

                        <c:if test="${!sessionScope.userRight.security}">
                            <c:if test="${sessionScope.checkReportingManager}">
                                <li><a href="visitorManagement.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>Visitor Management System</a></li>
                                <!--<li><a href="visitorManagement.htm?act=searchEmpClick"><i class="fa fa-circle-o"></i>Search Visitor Request</a></li>-->
                            </c:if>
                        </c:if>
                        <%--<c:if test="${fn:length(reportingManagerList) > 0}">--%>
                        <%--<c:if test="${sessionScope.isReportingManagerDataExist}">--%>
                        <!--<li><a href="visitorManagement.htm?act=searchApproverSubmit"><i class="fa fa-circle-o"></i>Visitor Request Approve</a></li>-->
                        <%--</c:if>--%>
                        <c:if test="${sessionScope.userRight.security}">
                            <li><a href="visitorManagement.htm?act=securityApproveSubmit"><i class="fa fa-circle-o"></i>Visitor Security Approve</a></li>
                            <!--<li><a href="visitorManagement.htm?act=searchAdminClick"><i class="fa fa-circle-o"></i>Security Search Visitor Request</a></li>-->
                        </c:if>
                        <c:if test="${!sessionScope.userRight.security}">
                            <c:if test="${sessionScope.checkReportingManager}">
                                <li><a href="gatePass.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>Gate Pass Request</a></li>
                                <!--<li><a href="gatePass.htm?act=searchEmpClick"><i class="fa fa-circle-o"></i>Search Gate Pass </a></li>-->
                            </c:if>
                        </c:if>
                        <%--<c:if test="${reportingManagerList ne null}">--%>
                        <%--<c:if test="${fn:length(reportingManagerList) > 0}">--%>
                        <c:if test="${sessionScope.isReportingManagerDataExist}">
                            <li><a href="gatePass.htm?act=searchApproverSubmit"><i class="fa fa-circle-o"></i>Subordinates Gate Pass<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Request</a></li>
                                </c:if>
                                <c:if test="${sessionScope.userRight.security}">
                            <li><a href="gatePass.htm?act=securityApproveSubmit"><i class="fa fa-circle-o"></i>Gate Pass Security Approver</a></li>
                            <li><a href="gatePass.htm?act=rgpresult"><i class="fa fa-circle-o"></i>Return Gate Pass</a></li>
                            <!--<li><a href="gatePass.htm?act=searchSecurityClick"><i class="fa fa-circle-o"></i>Security Search Gate Pass </a></li>-->
                        </c:if>
                        <c:if test="${!sessionScope.userRight.cafeteriaAdmin}">
                            <c:if test="${sessionScope.checkReportingManager}">
                                <li><a href="cafeteriaRequest.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>Cafeteria Request</a></li>
                                <!--<li><a href="cafeteriaRequest.htm?act=searchEmpClick"><i class="fa fa-circle-o"></i>Search Cafeteria Request</a></li>-->
                            </c:if>
                        </c:if>
                        <%--<c:if test="${fn:length(reportingManagerList) > 0}">--%>
                        <%--<c:if test="${sessionScope.isReportingManagerDataExist}">--%>
                        <!--<li><a href="cafeteriaRequest.htm?act=searchApproverSubmit"><i class="fa fa-circle-o"></i>Cafeteria Request Approve</a></li>-->
                        <%--</c:if>--%>
                        <c:if test="${sessionScope.userRight.cafeteriaAdmin}">
                            <li><a href="cafeteriaRequest.htm?act=adminApproveSubmit"><i class="fa fa-circle-o"></i>Cafeteria Request Admin</a></li>
                            <!--<li><a href="cafeteriaRequest.htm?act=searchAdminClick"><i class="fa fa-circle-o"></i>Search Cafeteria Request Admin</a></li>-->
                        </c:if>
                        <c:if test="${!sessionScope.userRight.itAdmin}">
                            <c:if test="${sessionScope.checkReportingManager}">
                                <li><a href="itServiceRequest.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>IT Service Request</a></li>
                                <!--<li><a href="itServiceRequest.htm?act=searchEmpClick"><i class="fa fa-circle-o"></i>Search IT Service Request</a></li>-->
                            </c:if>
                        </c:if>
                        <c:if test="${sessionScope.userRight.itAdmin}">
                            <li><a href="itRequestType.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>IT Request Type</a></li>
                            <li><a href="itServiceRequest.htm?act=approverClick"><i class="fa fa-circle-o"></i>IT Service Request</a></li>
                            <!--<li><a href="itServiceRequest.htm?act=searchITClick"><i class="fa fa-circle-o"></i>Search IT Service</a></li>-->
                        </c:if>
                        <c:if test="${!sessionScope.userRight.hr}">
                            <c:if test="${sessionScope.checkReportingManager}">
                                <li><a href="hrServiceRequest.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>HR Service Request</a></li>
                                <!--<li><a href="hrServiceRequest.htm?act=searchEmpClick"><i class="fa fa-circle-o"></i>Search Hr Service Request</a></li>-->
                            </c:if>
                        </c:if>
                        <c:if test="${sessionScope.userRight.hr}">
                            <li><a href="queryType.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>Query Type</a></li>
                            <li><a href="hrServiceRequest.htm?act=approverClick"><i class="fa fa-circle-o"></i>HR Service Request </a></li>
                            <!--<li><a href="hrServiceRequest.htm?act=searchHrClick"><i class="fa fa-circle-o"></i>Search Hr Service Request(hr)</a></li>-->
                        </c:if>

                    </ul>
                </li>
                <%--<c:if test="${fn:length(finalprobationList) > 0 || fn:length(FunctionalheadList) > 0 || sessionScope.userRight.hr}">--%>
                <%--<c:if test="${sessionScope.isFinalprobationDataExist || sessionScope.isFunctionalheadDataExist || sessionScope.userRight.hr}">--%>
                <%--<c:if test="${sessionScope.userRight.hr or sessionScope.userRight.probationToConfirmation}">--%>
                <%--<c:if test="${sessionScope.userRight.probationToConfirmation}">--%>
                <li class="treeview" style="color: #585858;">
                    <a href="#" style="background: #fff;">
                        <i class="fa fa-pencil-square-o fa-lg" style="color: #585858;"></i>
                        <span style="color: #585858;">Probation To Confirmation</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <%--<c:if test="${fn:length(finalprobationList) > 0}">--%>

                        <!--                            <li><a href="probationToConfirmation.htm?act=viewProbationToConfirmation"><i class="fa fa-circle-o"></i>Probation To Confirmation List</a></li>-->

                        <c:if test="${sessionScope.isFinalprobationDataExist}">
                            <li><a href="probationToConfirmation.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>Subordinates Probation To <br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Confirmation</a></li>
                                </c:if>
                                <%--<c:if test="${fn:length(FunctionalheadList) > 0}">--%>
                                <c:if test="${sessionScope.isFunctionalheadDataExist}">
                            <li><a href="probationToConfirmation.htm?act=functionalheadResultClick"><i class="fa fa-circle-o"></i>Approve Confirmation</a></li>
                            </c:if>
                            <c:if test="${sessionScope.userRight.probationToConfirmation}">
                            <li><a href="probationPeriod.htm?act=showResult"><i class="fa fa-circle-o"></i>Probation Period</a></li>
                            <li><a href="probationToConfirmation.htm?act=hrResultClick"><i class="fa fa-circle-o"></i>HR Approve Confirmation</a></li>
                            <li><a href="probationToConfirmation.htm?act=probationconfirmedEmployee"><i class="fa fa-circle-o"></i>Probation Confirmed</a></li>
                            </c:if>
                            <c:if test="${sessionScope.isProbationEmployee}">
                            <!--<li><a href="probationToConfirmation.htm?act=empClick"><i class="fa fa-circle-o"></i>Own Confirmation Status</a></li>-->
                        </c:if>
                    </ul>
                </li>
                <%--</c:if>--%>
                <li class="treeview" style="color: #585858;">
                    <a href="#" style="background: #fff;">
                        <i class="fa fa-sign-out fa-lg" style="color: #585858;"></i>
                        <span style="color: #585858;">Employee Exit</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">

                        <%--<c:if test="${fn:length(existinglist) > 0}">--%>
                        <c:if test="${sessionScope.isExistingResignationDataExist}">
                            <li><a href="resignationMaster.htm?act=EmpResult"><i class="fa fa-circle-o"></i>Resignation Result</a></li>
                            </c:if>
                            <%--<c:if test="${fn:length(existinglist) == 0}">--%>
                            <c:if test="${not sessionScope.isExistingResignationDataExist}">
                                <c:if test="${sessionScope.checkReportingManager}">
                                <li><a href="resignationMaster.htm?act=createClick"><i class="fa fa-circle-o"></i>Resignation</a></li>
                                </c:if>
                            </c:if>
                            <%--<c:if test="${fn:length(resignationManagerlist) > 0}">--%>
                            <c:if test="${sessionScope.isResignationManagerDataExist}">
                            <li><a href="resignationMaster.htm?act=createResignationResult"><i class="fa fa-circle-o"></i>Approver Resignation Result</a></li>
                            </c:if>
                            <c:if test="${sessionScope.userRight.employeeExit}">
                                <%--<c:if test="${fn:length(resignationManagerlist) > 0}">--%>
                                <c:if test="${sessionScope.isResignationManagerDataExist}">
                                <li><a href="resignationMaster.htm?act=managerSearchResult"><i class="fa fa-circle-o"></i>Search employee resignation</a></li>
                                </c:if>
                            </c:if>
                            <c:if test="${sessionScope.userRight.employeeExit}">
                            <li><a href="resignationMaster.htm?act=HRResult"><i class="fa fa-circle-o"></i>Resignation HR Result</a></li>
                            </c:if>




                        <c:if test="${sessionScope.userRight.exitInterview}">
                            <li><a href="exitInterviewMaster.htm?act=HRResult"><i class="fa fa-circle-o"></i>Exit Interview HR Result</a></li>
                            </c:if>
                            <%--<c:if test="${sessionScope.resignationStatus eq 2 || sessionScope.resignationStatus eq 4}">--%>
                            <c:if test="${sessionScope.resignationStatus eq 4 || sessionScope.resignationStatus eq 7
                                          || sessionScope.resignationStatus eq 10 || sessionScope.resignationStatus eq 11}">
                                <%--<c:if test="${fn:length(existingExitlist) == 0}">--%>
                                <c:if test="${not sessionScope.isExistingExitDataExist}">
                                <li><a href="exitInterviewMaster.htm?act=createClick"><i class="fa fa-circle-o"></i>Exit Interview</a></li>
                                </c:if>
                                <%--<c:if test="${fn:length(existingExitlist) > 0}">--%>
                                <c:if test="${sessionScope.isExistingExitDataExist}">
                                <li><a href="exitInterviewMaster.htm?act=EmpResult"><i class="fa fa-circle-o"></i>Exit Interview Result</a></li>
                                </c:if>
                            </c:if>
                            <%--<c:if test="${fn:length(reportingManagerList) > 0}">--%>
                            <c:if test="${sessionScope.isReportingManagerDataExist}">
                            <!--                            <li><a href="exitInterviewMaster.htm?act=ExitApproveresult"><i class="fa fa-circle-o"></i>Exit Interview Approver Result</a></li>-->
                        </c:if>
                        <!--<li><a href="exitInterviewMaster.htm?act=createExitApproveList"><i class="fa fa-circle-o"></i>Exit Interview Approver Result</a></li>-->


                        <li><a href="noDueMaster.htm?act=getNoDueRequests"><i class="fa fa-circle-o"></i>Fill No Due Requests</a></li>
                            <%--<c:if test="${sessionScope.exitStatus eq 2 || sessionScope.exitStatus eq 4}">--%>
                            <c:if test="${ sessionScope.resignationStatus eq 4 || sessionScope.resignationStatus eq 7
                                           || sessionScope.resignationStatus eq 10 || sessionScope.resignationStatus eq 11}">
                                <%--<c:if test="${fn:length(existingnoduelist) == 0}">--%>
                                <c:if test="${not sessionScope.isExistingNoDueDataExist}">
                                <li><a href="noDueMaster.htm?act=createClick&employeeId=${sessionScope.employeeInfo.id}"><i class="fa fa-circle-o"></i>No Due Form</a></li>
                                </c:if>
                                <%--<c:if test="${fn:length(existingnoduelist) > 0}">--%>
                                <c:if test="${sessionScope.isExistingNoDueDataExist}">
                                <li><a href="noDueMaster.htm?act=EmpResult"><i class="fa fa-circle-o"></i>No Due Result</a></li>
                                </c:if>
                            </c:if>
                            <c:if test="${sessionScope.userRight.employeeExit}">
                            <li><a href="noDueMaster.htm?act=createNoDueApproveList"><i class="fa fa-circle-o"></i>No Due Form Result</a></li>
                            </c:if>
                            <c:if test="${sessionScope.userRight.employeeExit || sessionScope.userRight.exitInterview}">
                            <!--<li><a href="noDueMaster.htm?act=createEmployeeWiseSearch"><i class="fa fa-circle-o"></i>Employee Exit Search</a></li>-->
                            <li><a href="resignationMaster.htm?act=submitEmployeeWiseSearch"><i class="fa fa-circle-o"></i>Employee Exit Search</a></li>
                            </c:if>
                    </ul>
                </li>
                <c:if test="${sessionScope.userRight.hr}">
                    <li class="treeview" style="color: #585858;">
                        <a href="#" style="background: #fff;">
                            <i class="fa fa-wrench fa-lg" style="color: #585858;"></i>
                            <span style="color: #585858;">Setting</span>
                            <i class="fa fa-angle-left pull-right"></i>
                        </a>
                        <ul class="treeview-menu">
                            <!--<li><a href="intervalMaster.htm?act=createClick"><i class="fa fa-circle-o"></i>Interval Master</a></li>-->
                            <li><a href="modulesMaster.htm?act=showList"><i class="fa fa-circle-o"></i>Modules Master</a></li>
                            <li><a href="componentMaster.htm?act=showList"><i class="fa fa-circle-o"></i>Component Master</a></li>
                            <li><a href="approval.htm?act=approvalList"><i class="fa fa-circle-o"></i>Approval Setting</a></li>
                            <li><a href="deviceMaster.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>Device Management</a></li>
                            <li><a href="departmentMaster.htm?act=showList"><i class="fa fa-circle-o"></i>Department List</a></li>
                            <li><a href="designationMaster.htm?act=showList"><i class="fa fa-circle-o"></i>Designation List</a></li>
                            <li><a href="levelMaster.htm?act=showList"><i class="fa fa-circle-o"></i>Level Master</a></li>
                            <li><a href="locationMaster.htm?act=showList"><i class="fa fa-circle-o"></i>Location Master</a></li>
                            <li><a href="holidayMaster.htm?act=showList"><i class="fa fa-circle-o"></i>Holiday Master</a></li>
                            <li><a href="holidayMaster.htm?act=holidayExcelUpload"><i class="fa fa-circle-o"></i>Holiday Excel Import</a></li>
                            <li><a href="policyMaster.htm?act=showList"><i class="fa fa-circle-o"></i>Policy Master</a></li>
                            <li><a href="zydexLocationMaster.htm?act=showList"><i class="fa fa-circle-o"></i>Location Master</a></li>
                            <li><a href="currencyMaster.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>Currency Master</a></li>
                            <li><a href="policyDeviationForAir.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>Policy Deviation Master</a></li>
                            <li><a href="visitorVisitedLocation.htm?act=createClick"><i class="fa fa-circle-o"></i>Visitor Visited Location</a></li>
                            <li><a href="timeAttandanceFlaxibleMaster.htm?act=showList"><i class="fa fa-circle-o"></i>Time Attendance Flexible</a></li>
                            <li><a href="urlMaster.htm?act=viewUrlResult"><i class="fa fa-pie-chart fa-lg"></i>Web Service URL</a></li>
                            <li><a href="appraisalPerformance.htm?act=trasferCompatencyEvaluationInEmployeeMaster"><i class="fa fa-pie-chart fa-lg"></i>Competency Evaluation Transfer</a></li>
                            <li><a href="companyMaster.htm?act=showList"><i class="fa fa-circle-o"></i>Company Master</a></li>
                                <%--<c:if test="${!sessionScope.userRight.employeeManagement}">--%>
                                <c:if test="${sessionScope.userRight.hr}">
                                <li><a href="questionLibrary.htm?act=QuestionLibraryCreate"><i class="fa fa-circle-o"></i>Question Library</a></li>
                                <li><a href="questionLibrary.htm?act=questionPaperView"><i class="fa fa-circle-o"></i>Question Paper</a></li>
                                </c:if>
                                <%--</c:if>--%>
                            <li><a href="thoughtMaster.htm?act=createthought"><i class="fa fa-circle-o"></i>Homepage Setting</a></li>
                            <li><a href="classifiedBox.htm?act=showResult"><i class="fa fa-circle-o"></i>Classified Setting</a></li>
                            <li><a href="ctcAllowance.htm?act=showList"><i class="fa fa-circle-o"></i>CTC Master</a></li>
                            <li><a href="retirementAge.htm?act=showList"><i class="fa fa-circle-o"></i>Retirement Ages</a></li>
                        </ul>
                    </li>
                </c:if>
                <c:if test="${sessionScope.userRight.hr}">
                    <li class="treeview" style="color: #585858;">
                        <a href="#" style="background: #fff;">
                            <i class="fa fa-laptop fa-lg" style="color: #585858;"></i>
                            <span style="color: #585858;">Email Template Master</span>
                            <i class="fa fa-angle-left pull-right"></i>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="emailTemplate.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>Email Template Result</a></li>
                            <li><a href="emailAddMaster.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>Email Add Master</a></li>
                        </ul>
                    </li>
                </c:if>
                <li class="treeview" style="color: #585858;">
                    <a href="#" style="background: #fff;">
                        <i class="fa fa-laptop fa-lg" style="color: #585858;"></i>
                        <span style="color: #585858;">Employee Referral</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <c:if test="${sessionScope.userRight.employeeReferral}">
                            <li><a href="positionReferMaster.htm?act=showList"><i class="fa fa-circle-o"></i>Position Master</a></li>
                            <li><a href="employeeReferral.htm?act=currentOpeningUploadClick"><i class="fa fa-circle-o"></i>Upload Current Opening</a></li>
                            <li><a href="employeeReferral.htm?act=showList"><i class="fa fa-circle-o"></i>Employee Referral List</a></li>
                            </c:if>
                            <c:if test="${sessionScope.employeeInfo.designationMaster.id eq 114 && sessionScope.employeeInfo.departmentMaster.id  eq 59}">
                            <li><a href="employeeReferral.htm?act=finalApproveList"><i class="fa fa-circle-o"></i>Final Approve List</a></li>
                            </c:if>
                        <li><a href="employeeReferral.htm?act=createReferral"><i class="fa fa-circle-o"></i>Employee Referral</a></li>
                        <li><a href="employeeReferral.htm?act=showCurrentOpening"><i class="fa fa-circle-o"></i>Current Opening</a></li>

                    </ul>
                </li>
                <li class="treeview" style="color: #585858;">
                    <a href="#" style="background: #fff;">
                        <i class="fa fa-pie-chart fa-lg" style="color: #585858;"></i>
                        <span style="color: #585858;">Attendance Management</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <c:if test="${sessionScope.userRight.attendanceReport}">
                            <li><a href="shiftRotationMaster.htm?act=employeeDataSearch"><i class="fa fa-circle-o"></i> Employee Master Report</a></li>
                            <li><a href="shiftRotationMaster.htm?act=employeeDataSearch2"><i class="fa fa-circle-o"></i> Employee Leave Report</a></li>
                            <li><a href="shiftRotationMaster.htm?act=employeeAttandanceDataSearch"><i class="fa fa-circle-o"></i> Monthly Attendance Report  </a></li>
                            <li><a href="shiftRotationMaster.htm?act=employeePresentSearch"><i class="fa fa-circle-o"></i>Daily Present Report</a></li>
                            <li><a href="shiftRotationMaster.htm?act=attendanceExcelUpload"><i class="fa fa-circle-o"></i>Attendance Upload</a></li>
                            <!--<li><a href="shiftRotationMaster.htm?act=employeeManualPunch"><i class="fa fa-circle-o"></i>Manual Punch</a></li>-->
                        </c:if>
                        <c:if test="${sessionScope.userRight.lunaPlantAttendanceMgnt}">
                            <li><a href="shiftRotationMaster.htm?act=employeeAttendanceForLuna"><i class="fa fa-circle-o"></i>Luna Attendance Download</a></li>
                            </c:if>
                            <c:if test="${sessionScope.userRight.gavasatPlantAttendanceMgnt}">
                            <li><a href="shiftRotationMaster.htm?act=employeeAttendanceForGavasat"><i class="fa fa-circle-o"></i>Gavasat Attendance Download</a></li>
                            </c:if>
                    </ul>

                </li>

                <c:if test="${sessionScope.userRight.hr}">
                    <!--                                        <li class="treeview">
                                                                <a href="#" style="">
                                                                    <i class="fa fa-wrench fa-lg"></i>
                                                                    <span>Employee Approval </span>
                                                                    <i class="fa fa-angle-left pull-right"></i>
                                                                </a>
                                                                <ul class="treeview-menu">
                                                                    <li><a href="leaveEmployeeDetail.htm?act=viewRequestPowerAdminClick"><i class="fa fa-circle-o"></i>Leave</a></li>
                                                                    <li><a href="attendanceRegularizationMaster.htm?act=powerAdminApprovalList"><i class="fa fa-circle-o"></i>AT</a></li>
                                                                    <li><a href="designationMaster.htm?act=showList"><i class="fa fa-circle-o"></i>Travel</a></li>
                                                                    <li><a href="levelMaster.htm?act=showList"><i class="fa fa-circle-o"></i>Expense</a></li>
                                                                </ul>
                                                            </li>-->
                </c:if>
                <li class="treeview" style="color: #585858;">
                    <a href="holidayMaster.htm?act=viewHolidaysLocationWise" style="background: #fff;">
                        <i class="fa fa-pie-chart fa-lg" style="color: #585858;"></i>
                        <span style="color: #585858;">Holiday List</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                </li>
                <c:if test="${sessionScope.userRight.payroll}">
                    <li>
                        <a href="#">
                            <!---------payroll Master (if payroll right give if show a payroll) --------> 
                            <i class="fa fa-rupee" style="color: #585858;"></i>
                            <span style="color: #585858;">Payroll</span>
                            <i class="fa fa-angle-left pull-right"></i>
                        </a>
                        <ul class="treeview-menu">
                            <!--<li><a href="payrollSavingType.htm?act=showResult"><i class="fa fa-circle-o"></i>Saving Type</a></li>-->
                            <li><a href="payrollSalaryType.htm?act=showResult"><i class="fa fa-circle-o"></i>Salary Type</a></li>
                            <!--<li><a href="payrollTaxRule.htm?act=showResult"><i class="fa fa-circle-o"></i>Tax Rule</a></li>-->

                            <li><a href="payrollProfessionalTax.htm?act=showResult"><i class="fa fa-circle-o"></i>Professional Tax</a></li>
                            <li><a href="payrollProvidentFund.htm?act=showResult"><i class="fa fa-circle-o"></i>Provident Fund</a></li>
                            <!--<li><a href="payrollMaximumSavingTaxAmount.htm?act=showResult"><i class="fa fa-circle-o"></i>Maximum Saving Tax</a></li>-->
                            <li><a href="payrollFinancialYear.htm?act=showResult"><i class="fa fa-circle-o"></i>Financial Year </a></li>
                            <!--<li><a href="payrollStationWiseSavingTax.htm?act=showResult"><i class="fa fa-circle-o"></i>Saving Duration</a></li>-->
                            <li><a href="payrollFormSixteenMaster.htm?act=showResult"><i class="fa fa-circle-o"></i>Form Sixteen Master </a></li>
                            <li><a href="employeeType.htm?act=showResult"><i class="fa fa-circle-o"></i>Employee Type </a></li>
                            <li><a href="employeeSubType.htm?act=showResult"><i class="fa fa-circle-o"></i>Employee SubType </a></li>
                            <li><a href="payrollPfCheck.htm?act=showResult"><i class="fa fa-circle-o"></i>PF Check</a></li>
                            <li><a href="payrollPtCheck.htm?act=showResult"><i class="fa fa-circle-o"></i>PT Check</a></li>
                            <li><a href="employeeTypeWiseSalary.htm?act=showResult"><i class="fa fa-circle-o"></i>Assign Salary</a></li>
                            <li><a href="additionalAmountCheck.htm?act=showResult"><i class="fa fa-circle-o"></i>Additional Amount Check</a></li>
                            <li><a href="payrollEmployeeFormSixteen.htm?act=redirectToFormEmployeeSaving&search=none"><i class="fa fa-circle-o"></i>Employee Saving</a></li>
                            <li>
                                <a href="payrollTaxDeduction.htm?act=taxDeductionCreate"><i class="fa fa-circle-o"></i>Tax Deduction Master</a>
                            </li>
                            <li>
                                <a href="payrollTaxDeduction.htm?act=showTaxDeductionComponent"><i class="fa fa-circle-o"></i>Tax Deduction Component</a>
                            </li>
                        </ul>
                    </li>
                </c:if>

                <c:if test="${sessionScope.userRight.hr}">
                    <li class="treeview" style="color: #585858;">
                        <a href="#" style="background: #fff;">
                            <i class="fa fa-rupee fa-lg" style="color: #585858;"></i>
                            <span style="color: #585858;">Payroll</span>
                            <i class="fa fa-angle-left pull-right"></i>                            <i class="fa fa-angle-left pull-right"></i>

                        </a>
                        <ul class="treeview-menu">
                            <li>
                                <a href="#">
                                    <i class="fa fa-rupee fa-lg"></i>
                                    <span>Master</span>
                                    <i class="fa fa-angle-left pull-right"></i>
                                </a>
                                <ul class="treeview-menu">
                                    <!--<li><a href="payrollSavingType.htm?act=showResult"><i class="fa fa-circle-o"></i>Saving Type</a></li>-->
                                    <li><a href="payrollSalaryType.htm?act=showResult"><i class="fa fa-circle-o"></i>Salary Type</a></li>
                                    <!--<li><a href="payrollTaxRule.htm?act=showResult"><i class="fa fa-circle-o"></i>Tax Rule</a></li>-->

                                    <li><a href="payrollProfessionalTax.htm?act=showResult"><i class="fa fa-circle-o"></i>Professional Tax</a></li>
                                    <li><a href="payrollProvidentFund.htm?act=showResult"><i class="fa fa-circle-o"></i>Provident Fund</a></li>
                                    <!--<li><a href="payrollMaximumSavingTaxAmount.htm?act=showResult"><i class="fa fa-circle-o"></i>Maximum Saving Tax</a></li>-->
                                    <li><a href="payrollFinancialYear.htm?act=showResult"><i class="fa fa-circle-o"></i>Financial Year </a></li>
                                    <!--<li><a href="payrollStationWiseSavingTax.htm?act=showResult"><i class="fa fa-circle-o"></i>Saving Duration</a></li>-->
                                    <li><a href="payrollFormSixteenMaster.htm?act=showResult"><i class="fa fa-circle-o"></i>Form Sixteen Master </a></li>
                                    <li><a href="employeeType.htm?act=showResult"><i class="fa fa-circle-o"></i>Employee Type </a></li>
                                    <li><a href="employeeSubType.htm?act=showResult"><i class="fa fa-circle-o"></i>Employee SubType </a></li>
                                    <li><a href="payrollPfCheck.htm?act=showResult"><i class="fa fa-circle-o"></i>PF Check</a></li>
                                    <li><a href="payrollPtCheck.htm?act=showResult"><i class="fa fa-circle-o"></i>PT Check</a></li>
                                    <li><a href="employeeTypeWiseSalary.htm?act=showResult"><i class="fa fa-circle-o"></i>Assign Salary</a></li>
                                    <li><a href="additionalAmountCheck.htm?act=showResult"><i class="fa fa-circle-o"></i>Additional Amount Check</a></li>
                                    <li><a href="payrollEmployeeFormSixteen.htm?act=redirectToFormEmployeeSaving&search=none"><i class="fa fa-circle-o"></i>Employee Saving</a></li>
                                    <li>
                                        <a href="payrollTaxDeduction.htm?act=taxDeductionCreate"><i class="fa fa-circle-o"></i>Tax Deduction Master</a>
                                    </li>
                                    <li>
                                        <a href="payrollTaxDeduction.htm?act=showTaxDeductionComponent"><i class="fa fa-circle-o"></i>Tax Deduction Component</a>
                                    </li>
                                    <li>
                                        <a href="payrollTaxDeclaration.htm?act=showPeriod"><i class="fa fa-circle-o"></i>Tax Declaration Period</a>
                                    </li>
                                    <li>
                                        <a href="payrollTaxRate.htm?act=showTaxRateList"><i class="fa fa-circle-o"></i>Tax Rate Master</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">
                                    <i class="fa fa-rupee fa-lg"></i>
                                    <span>Loan</span>
                                    <i class="fa fa-angle-left pull-right"></i>
                                </a>
                                <ul class="treeview-menu">
                                    <li><a href="payrollLoanType.htm?act=showResult"><i class="fa fa-circle-o"></i> Loan Type</a></li>
                                    <li><a href="payrollLoanType.htm?act=showResultLoanDetail"><i class="fa fa-circle-o"></i> Loan Details</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">
                                    <i class="fa fa-rupee fa-lg"></i>
                                    <span>Wages</span>
                                    <i class="fa fa-angle-left pull-right"></i>
                                </a>
                                <ul class="treeview-menu">
                                    <li><a href="payrollBonus.htm?act=showResult"><i class="fa fa-circle-o"></i>Bonus </a></li>
                                    <!--<li><a href="payrollCommission.htm?act=showResult"><i class="fa fa-circle-o"></i>Commission </a></li>-->
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-rupee fa-lg"></i>
                                            <span>Deduction</span>
                                            <i class="fa fa-angle-left pull-right"></i>
                                        </a>
                                        <ul class="treeview-menu">
                                            <li><a href="payrollDeduction.htm?act=showResult"><i class="fa fa-circle-o"></i>Day wise</a></li>
                                            <li><a href="payrollRecurringDeduction.htm?act=showResult"><i class="fa fa-circle-o"></i>Recurring</a></li>
                                        </ul>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-rupee fa-lg"></i>
                                            <span>Additional Amount</span>
                                            <i class="fa fa-angle-left pull-right"></i>
                                        </a>
                                        <ul class="treeview-menu">
                                            <li><a href="payrollAdditionalAmount.htm?act=showResult"><i class="fa fa-circle-o"></i>Day wise</a></li>
                                            <li><a href="payrollRecurringAdditionalAmount.htm?act=showResult"><i class="fa fa-circle-o"></i>Recurring</a></li>
                                        </ul>
                                    </li>

                                </ul>
                            </li>
                            <li>
                                <a href="#">
                                    <i class="fa fa-rupee fa-lg"></i>
                                    <span>Incentive </span>
                                    <i class="fa fa-angle-left pull-right"></i>
                                </a>
                                <ul class="treeview-menu">
                                    <li><a href="employeeIncentiveMonthWise.htm?act=searchEmpSalIncentiveDetail&search=none"><i class="fa fa-circle-o"></i>Incentive Report </a></li>
                                    <li><a href="employeeIncentiveMonthWise.htm?act=searchEmpSalIncentiveMonthDetail&search=none"><i class="fa fa-circle-o"></i>Incentive Month Wise </a></li>
                                    <li><a href="employeeIncentiveMonthWise.htm?act=searchEmpSalIncentiveMonthEmployeeDetail&search=none"><i class="fa fa-circle-o"></i>Incentive For Employee </a></li>



                                </ul>
                            </li>
                            <li>
                                <a href="#">
                                    <i class="fa fa-rupee fa-lg"></i>
                                    <span>Salary</span>
                                    <i class="fa fa-angle-left pull-right"></i>
                                </a>
                                <ul class="treeview-menu">
                                    <!--<li><a href="employeeSalaryProcess.htm?act=searchEmpSalDetail&search=none"><i class="fa fa-circle-o"></i>Salary Generate</a></li>-->
                                    <li><a href="employeeSalaryProcess.htm?act=searchSalaryDetail&search=none"><i class="fa fa-circle-o"></i>Salary Search</a></li>
                                    <li><a href="employeeSalaryProcess.htm?act=salaryExcelUpload"><i class="fa fa-circle-o"></i> Salary Excel Upload</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">
                                    <i class="fa fa-rupee fa-lg"></i>
                                    <span>Salary Lock</span>
                                    <i class="fa fa-angle-left pull-right"></i>
                                </a>
                                <ul class="treeview-menu">
                                    <li><a href="payrollSalaryLock.htm?act=createClick"><i class="fa fa-circle-o"></i>Lock </a></li>

                                </ul>
                            </li>
                            <li>
                                <a href="#">
                                    <i class="fa fa-rupee fa-lg"></i>
                                    <span>Report</span>
                                    <i class="fa fa-angle-left pull-right"></i>
                                </a>
                                <ul class="treeview-menu">
                                    <li><a href="payrollEmployeeFormSixteen.htm?act=redirectToFormSexteen&search=none"><i class="fa fa-circle-o"></i>Form Sixteen </a></li>
                                    <li><a href="employeePfCheck.htm?act=searchSalaryPfDetail&search=none"><i class="fa fa-circle-o"></i>PF</a></li>
                                    <li><a href="employeePtCheck.htm?act=searchSalaryPtDetail&search=none"><i class="fa fa-circle-o"></i>PT </a></li>
                                    <li><a href="employeeSalarySlip.htm?act=searchSalarySlipDetail&search=none"><i class="fa fa-circle-o"></i>Salary Slip </a></li>
                                    <li><a href="policyMaster.htm?act=searchPolicyDetail&search=none"><i class="fa fa-circle-o"></i>Policy  </a></li>
                                    <li><a href="companyMonthlyReport.htm?act=searchCompanyMonthlyReport&search=none"><i class="fa fa-circle-o"></i>Company Monthly Report</a></li>
                                    <li><a href="companyPTReport.htm?act=searchCompanyPTReport&search=none"><i class="fa fa-circle-o"></i>PT Statement</a></li>
                                    <li><a href="bankStatement.htm?act=searchBankStatementDetail&search=none"><i class="fa fa-circle-o"></i>Bank Statement </a></li>
                                    <li><a href="esicDeductionStatement.htm?act=searchEsicDetail&search=none"><i class="fa fa-circle-o"></i>ESIC Deduction Statement </a></li>
                                    <li><a href="overTime.htm?act=searchOTDetail&search=none"><i class="fa fa-circle-o"></i>Over Time Report </a></li>
                                    <li><a href="pFChallen.htm?act=searchPfChallenDetail&search=none"><i class="fa fa-circle-o"></i>PF Challen  </a></li>
                                    <li><a href="loanReport.htm?act=searchLoanData&search=none"><i class="fa fa-circle-o"></i>Loan</a></li>
                                    <li><a href="attendanceReport.htm?act=searchAttendanceData&search=none"><i class="fa fa-circle-o"></i>Attendance</a></li>
                                    <li><a href="employeeSalarySlip.htm?act=searchSalaryYearDetail&search=none"><i class="fa fa-circle-o"></i>Employee Salary Yearly</a></li>
                                    <li><a href="employeePfCheck.htm?act=searchSalaryPfGovDetail&search=none"><i class="fa fa-circle-o"></i>Govt. Format PF</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">
                                    <i class="fa fa-rupee fa-lg"></i>
                                    <span>Master Salary</span>
                                    <i class="fa fa-angle-left pull-right"></i>
                                </a>
                                <ul class="treeview-menu">
                                    <li><a href="employeeSalaryProcess.htm?act=searchMasterEmpSalDetail&search=none"><i class="fa fa-circle-o"></i>Salary Search</a></li>

                                </ul>
                            </li>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-rupee fa-lg"></i>
                            <span>Certificate</span>
                            <i class="fa fa-angle-left pull-right"></i>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="certificateTemplate.htm?act=searchSubmit"><i class="fa fa-circle-o"></i>Certificate Template Result</a></li>
                            <li><a href="certificateTemplate.htm?act=searchEmployeeDetail&search=none"><i class="fa fa-circle-o"></i> Assign Certificate</a></li>
                        </ul>
                    </li>
                </ul>
                </li>
            </c:if>
            <c:if test="${!sessionScope.userRight.training}">
                <c:if test="${sessionScope.userRight.employeeManagement}">
                    <li class="treeview" style="color: #585858;">
                        <a href="#" style="background: #fff;">
                            <i class="fa fa-pie-chart fa-lg" style="color: #585858;"></i>
                            <span style="color: #585858;">Training</span>
                            <i class="fa fa-angle-left pull-right"></i>
                        </a>
                        <ul class="treeview-menu">
                            <li>
                                <a href="#">
                                    <i class="fa fa-rupee fa-lg"></i>
                                    <span>Master</span>
                                    <i class="fa fa-angle-left pull-right"></i>
                                </a>
                                <ul class="treeview-menu">

                                    <li><a href="trainingType.htm?act=newtraining"><i class="fa fa-circle-o"></i>Training Type</a></li>
                                    <li><a href="trainingType.htm?act=newsubtraining"><i class="fa fa-circle-o"></i>Training Sub Type</a></li>
                                    <li><a href="trainer.htm?act=createTrainerShow"><i class="fa fa-circle-o"></i>Trainer</a></li>

                                    <li><a href="trainingMaster.htm?act=showList"><i class="fa fa-circle-o"></i>Training Master</a></li>


                                </ul>
                            </li>
                            <li><a href="trainingType.htm?act=showcalendar"><i class="fa fa-circle-o"></i>calendar</a></li>
                            <li><a href="trainingIdentification.htm?act=showcalendar"><i class="fa fa-circle-o"></i>My Training List</a></li>
                            <!--<li><a href="trainingIdentification.htm?act=createTraineAssigne"><i class="fa fa-circle-o"></i>Assign Trainee</a></li>-->
                            <!--<li><a href="trainingIdentification.htm?act=showTrainingFeedbackList"><i class="fa fa-circle-o"></i>Training Feedback Details</a></li>-->
                            <li><a href="trainingAssessment.htm?act=clickassessment"><i class="fa fa-circle-o"></i>Training Assessment</a></li>


                        </ul>
                    </li>
                </c:if>
            </c:if>
                    
             <c:if test="${sessionScope.userRight.hr}">
                <li>
                    <a href="#" style="background: #fff;">
                        <i class="fa fa-pie-chart fa-lg" style="color: #585858;"></i>
                        <span style="color: #585858;">Tax Department</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="taxSavingSubmit.htm?act=viewFilledForms"><i class="fa fa-circle-o"></i>Tax Deduction Declaration</a></li>
                    </ul>
                </li>
            </c:if>
                
            <c:if test="${sessionScope.userRight.training}">
                <li>
                    <a href="#" style="background: #fff;">
                        <i class="fa fa-pie-chart fa-lg" style="color: #585858;"></i>
                        <span style="color: #585858;">Training</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">

                        <li><a href="trainingType.htm?act=newtraining"><i class="fa fa-circle-o"></i>Training Type</a></li>
                        <li><a href="trainingType.htm?act=newsubtraining"><i class="fa fa-circle-o"></i>Training Sub Type</a></li>
                        <li><a href="trainer.htm?act=createTrainerShow"><i class="fa fa-circle-o"></i>Trainer</a></li>

                        <li><a href="trainingMaster.htm?act=showList"><i class="fa fa-circle-o"></i>Training Master</a></li>


                        <li><a href="trainingType.htm?act=showcalendar"><i class="fa fa-circle-o"></i>calendar</a></li>
                    </ul>
                </li>
            </c:if>
           

        </section>
        <!-- /.sidebar -->
    </aside>
</html>
<style>
    .skin-blue .sidebar-menu>li:hover>a, .skin-blue .sidebar-menu>li.active>a {
        color: #fff;
        background: #fff;
    }
    .skin-blue .wrapper
    {
        background-color: #fff;
    }
</style>
