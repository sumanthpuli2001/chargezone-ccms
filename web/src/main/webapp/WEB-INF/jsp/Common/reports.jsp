<%-- 
    Document   : reports
    Created on : May 5, 2018, 5:39:23 PM
    Author     : Aman
--%>

<%@page import="com.bul.zydex.model.EmployeeMaster"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head onload="rrshowSlides(1);">
        <title>Report</title>
    </head>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <c:if test="${!empty successMessage}">
            <div class="alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>REPORTS</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Report</a></li>
                <li class="active"></li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div  style="border: 1px #3c8dbc solid;border-radius: 5px;">
                            <div class="box-header" style="background-color: #006fad !important;text-align: center;">
                                <h3 class="box-title"style="font-size: 30px;color: white;font-weight:700;font-size:16px;">ATTENDANCE REPORT</h3>
                            </div>
                            <div class="box-body">
                                <div class="tab-content">
                                    <div class="row">
                                        <c:choose>
                                            <c:when test="{}">
                                                <div align="center">
                                                    <c:out value="'Access Denied'"></c:out>
                                                    </div>
                                            </c:when>
                                            <c:otherwise>
                                                <div class="col-xs-4 col-sm-4 col-md-4">
                                                    <c:if test="${sessionScope.userRight.employeeMasterReport}">
                                                        <a style="font-size: 14px;text-align: left;color: #2c3e50;" href="shiftRotationMaster.htm?act=employeeDataSearch">Employee Master Report</a>
                                                    </c:if>
                                                </div>
                                                <div  class="col-xs-4 col-sm-4 col-md-4">
                                                    <c:if test="${sessionScope.userRight.employeeAttendanceReport}">
                                                        <a style="font-size: 14px;text-align: left;color: #2c3e50;" href="shiftRotationMaster.htm?act=employeeDataSearch2">Employee Attendance Report</a>
                                                    </c:if>
                                                </div>
                                                <div class="col-xs-4 col-sm-4 col-md-4">
                                                    <c:if test="${sessionScope.userRight.monthlyAttendanceReport}">
                                                        <a style="font-size: 14px;text-align: left;color: #2c3e50;" href="shiftRotationMaster.htm?act=employeeAttandanceDataSearch">Monthly Attendance Report</a>
                                                    </c:if>
                                                </div>
                                                <div class="col-xs-4 col-sm-4 col-md-4">
                                                    <c:if test="${sessionScope.userRight.monthlyAttendanceReport}">
                                                        <a style="font-size: 14px;text-align: left;color: #2c3e50;" href="shiftRotationMaster.htm?act=employeeDataSearchWorkingHours">Monthly Attendance Report(Working Hours)</a>
                                                    </c:if>
                                                </div>
                                                <div class="col-xs-4 col-sm-4 col-md-4">
                                                    <c:if test="${sessionScope.userRight.dailyPresentReport}">
                                                        <a style="font-size: 14px;text-align: left;color: #2c3e50;" href="shiftRotationMaster.htm?act=employeePresentSearch">Daily Present Report</a>
                                                    </c:if>
                                                </div>
                                                <div class="col-xs-4 col-sm-4 col-md-4">
                                                    <c:if test="${sessionScope.userRight.dailyPresentReport}">
                                                        <a style="font-size: 14px;text-align: left;color: #2c3e50;" href="shiftRotationMaster.htm?act=getShiftForReport">Shift Report</a>
                                                    </c:if>
                                                </div>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                    <br>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="nav-tabs-custom">
                        <!--<h3 style="text-align: center;"> Payroll Report</h3>-->
                        <div  style="border: 1px #3c8dbc solid;border-radius: 5px;">
                            <div class="box-header" style="background-color: #006fad !important;text-align: center;">
                                <h3 class="box-title"style="font-size: 30px;color: white;font-weight:700;font-size:16px;">PAYROLL REPORT</h3>
                            </div>
                            <div class="box-body">
                                <div class="tab-content">
                                    <div class="row">
                                        <div class="col-xs-4 col-sm-4 col-md-4">
                                            <c:if test="${sessionScope.userRight.formSixteen}">
                                                <a  style="font-size: 14px;text-align: left;color: #2c3e50;"  href="payrollEmployeeFormSixteen.htm?act=redirectToFormSexteen&search=none">
                                                    Form Sixteen
                                                </a>
                                            </c:if>
                                        </div>
                                        <div  class="col-xs-4 col-sm-4 col-md-4">
                                            <c:if test="${sessionScope.userRight.pf}">
                                                <a  style="font-size: 14px;text-align: left;color: #2c3e50;"   href="employeePfCheck.htm?act=searchSalaryPfDetail&search=none">
                                                    PF
                                                </a>
                                            </c:if>
                                        </div>
                                        <div class="col-xs-4 col-sm-4 col-md-4">
                                            <c:if test="${sessionScope.userRight.pt}">
                                                <!--<a class="label label-primary" style="font-size: 20px" href="hrServiceRequest.htm?act=searchSubmit">-->
                                                <a  style="font-size: 14px;text-align: left;color: #2c3e50;"  href="employeePtCheck.htm?act=searchSalaryPtDetail&search=none">
                                                    PT
                                                </a>
                                            </c:if>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-xs-4 col-sm-4 col-md-4">
                                            <c:if test="${sessionScope.userRight.salarySlip}">
                                                <a style="font-size: 14px;text-align: left;color: #2c3e50;"  href="employeeSalarySlip.htm?act=searchSalarySlipDetail&search=none">
                                                    Salary Slip 
                                                </a>
                                            </c:if>
                                        </div>
                                        <!--<div class="col-xs-4 col-sm-4 col-md-4">-->
                                            <%--<c:if test="${sessionScope.userRight.policy}">--%>
                                                <!--<a  style="font-size: 14px;text-align: left;color: #2c3e50;"   href="policyMaster.htm?act=searchPolicyDetail&search=none">-->
                                                    <!--Policy-->
                                                <!--</a>-->
                                            <%--</c:if>--%>
                                        <!--</div>-->
                                        <div class="col-xs-4 col-sm-4 col-md-4">
                                            <c:if test="${sessionScope.userRight.companyMonthlyReport}">
                                                <a  style="font-size: 14px;text-align: left;color: #2c3e50;"   href="companyMonthlyReport.htm?act=searchCompanyMonthlyReport&search=none">
                                                    Company Monthly Report
                                                </a>
                                            </c:if>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-xs-4 col-sm-4 col-md-4">
                                            <c:if test="${sessionScope.userRight.ptStatement}">
                                                <a  style="font-size: 14px;text-align: left;color: #2c3e50;"   href="companyPTReport.htm?act=searchCompanyPTReport&search=none">
                                                    PT Slab by Summary
                                                </a>
                                            </c:if>
                                        </div>
                                        <div class="col-xs-4 col-sm-4 col-md-4">
                                            <c:if test="${sessionScope.userRight.bankStatement}">
                                                <a  style="font-size: 14px;text-align: left;color: #2c3e50;"   href="bankStatement.htm?act=searchBankStatementDetail&search=none">
                                                    Bank Statement 
                                                </a>
                                            </c:if>
                                        </div>
                                        <div class="col-xs-4 col-sm-4 col-md-4">
                                            <c:if test="${sessionScope.userRight.eSICDeductionStatement}">
                                                <a  style="font-size: 14px;text-align: left;color: #2c3e50;"  href="esicDeductionStatement.htm?act=searchEsicDetail&search=none">
                                                    ESIC Deduction Statement 
                                                </a>
                                            </c:if>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-xs-4 col-sm-4 col-md-4">
                                            <c:if test="${sessionScope.userRight.overTimeReport}">
                                                <a  style="font-size: 14px;text-align: left;color: #2c3e50;"   href="overTime.htm?act=searchOTDetail&search=none">
                                                    Over Time Report
                                                </a>
                                            </c:if>
                                        </div>
                                        <div class="col-xs-4 col-sm-4 col-md-4">
                                            <c:if test="${sessionScope.userRight.loan}">
                                                <a  style="font-size: 14px;text-align: left;color: #2c3e50;"  href="loanReport.htm?act=searchLoanData&search=none">
                                                    Loan 
                                                </a>
                                            </c:if>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-xs-4 col-sm-4 col-md-4">
                                            <c:if test="${sessionScope.userRight.attendance}">
                                                <a  style="font-size: 14px;text-align: left;color: #2c3e50;"   href="attendanceReport.htm?act=searchAttendanceData&search=none">
                                                    Attendance
                                                </a>
                                            </c:if>
                                        </div>
                                        <div class="col-xs-4 col-sm-4 col-md-4">
                                            <c:if test="${sessionScope.userRight.employeeSalaryYearly}">
                                                <a  style="font-size: 14px;text-align: left;color: #2c3e50;"   href="employeeSalarySlip.htm?act=searchSalaryYearDetail&search=none">
                                                    Employee Salary Yearly  
                                                </a>
                                            </c:if>
                                        </div>
                                        <div class="col-xs-4 col-sm-4 col-md-4">
                                            <c:if test="${sessionScope.userRight.esicChalan}">
                                                <a  style="font-size: 14px;text-align: left;color: #2c3e50;"   href="payrollESIC.htm?act=esicChalan&search=none">
                                                    ESIC Chalan
                                                </a>
                                            </c:if>
                                        </div>

                                    </div>
                                    <br>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="nav-tabs-custom">
                        <!--<h3 style="text-align: center;"> Leave Management</h3>-->
                        <div  style="border: 1px #3c8dbc solid;border-radius: 5px;">
                            <div class="box-header" style="background-color: #006fad !important;text-align: center;">
                                <h3 class="box-title"style="font-size: 30px;color: white;font-weight:700;font-size:16px;">LEAVE MANAGEMENT</h3>
                            </div>
                            <div class="box-body">
                                <div class="tab-content">
                                    <div class="row">
                                        <div class="col-xs-4 col-sm-4 col-md-4">
                                            <c:if test="${sessionScope.userRight.searchEmployeeLeaveDetail}">
                                                <a  style="font-size: 14px;text-align: left;color: #2c3e50;" href="leaveEmployeeDetail.htm?act=searchEmpLeaveDetail">
                                                    Search Employee Leave Detail
                                                </a>
                                            </c:if>
                                        </div>
                                        <div  class="col-xs-4 col-sm-4 col-md-4">
                                            <c:if test="${sessionScope.userRight.searchEmployeeLeaveBalance}">
                                                <a  style="font-size: 14px;text-align: left;color: #2c3e50;" href="leaveEmployeeDetail.htm?act=searchEmployeeLeaveBalance">
                                                    Search Employee Leave Balance
                                                </a>
                                            </c:if>
                                        </div>
                                    </div>
                                    <br>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="nav-tabs-custom">
                        <!--<h3 style="text-align: center;">Employee Service</h3>-->
                        <div  style="border: 1px #3c8dbc solid;border-radius: 5px;">
                            <div class="box-header" style="background-color: #006fad !important;text-align: center;">
                                <h3 class="box-title"style="font-size: 30px;color: white;font-weight:700;font-size:16px;">EMPLOYEE SERVICE</h3>
                            </div>
                            <div class="box-body"> 
                                <div class="tab-content">
                                    <div class="row">

                                        <div class="col-xs-4 col-sm-4 col-md-4">
                                            <c:if test="${sessionScope.userRight.searchTravelReques}">
                                                <a  style="font-size: 14px;text-align: left;color: #2c3e50;"href="travelRequestMaster.htm?act=viewRequestAdminSubmit">
                                                    Search Travel Request 
                                                </a>
                                            </c:if>
                                        </div>
                                        <div  class="col-xs-4 col-sm-4 col-md-4">
                                            <c:if test="${sessionScope.userRight.searchExpenseRequest}">
                                                <a style="font-size: 14px;text-align: left;color: #2c3e50;" href="expenseMaster.htm?act=searchExpenseRequest">
                                                    Search Expense Request
                                                </a>
                                            </c:if>
                                        </div>
                                    </div>
                                    <br>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="nav-tabs-custom">
                        <!--<h3 style="text-align: center;">Performance Management</h3>-->
                        <div  style="border: 1px #3c8dbc solid;border-radius: 5px;">
                            <div class="box-header" style="background-color: #006fad !important;text-align: center;">
                                <h3 class="box-title"style="font-size: 30px;color: white;font-weight:700;font-size:16px;">PERFORMANCE MANAGEMENT</h3>
                            </div>
                            <div class="box-body"> 
                                <div class="tab-content">
                                    <div class="row">
                                        <div class="col-xs-4 col-sm-4 col-md-4">
                                            <c:if test="${sessionScope.userRight.pMPReport}">
                                                <a  style="font-size: 14px;text-align: left;color: #2c3e50;" href="appraisalPerformance.htm?act=searchAppraisalPerformanceReoprtStageWise">
                                                    PMP-Report
                                                </a>
                                            </c:if>
                                        </div>
                                        <div  class="col-xs-4 col-sm-4 col-md-4">
                                            <c:if test="${sessionScope.userRight.appraisalReport360}">
                                                <a  style="font-size: 14px;text-align: left;color: #2c3e50;" href="appraisal360.htm?act=searchAppraisalPerformance360Reoprt">
                                                    360 Appraisal Report
                                                </a>
                                            </c:if>
                                        </div>
                                    </div>
                                    <br>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="nav-tabs-custom">
                        <!--<h3 style="text-align: center;">Performance Management</h3>-->
                        <div  style="border: 1px #3c8dbc solid;border-radius: 5px;">
                            <div class="box-header" style="background-color: #006fad !important;text-align: center;">
                                <h3 class="box-title"style="font-size: 30px;color: white;font-weight:700;font-size:16px;">STATUTORY REPORT</h3>
                            </div>
                            <div class="box-body"> 
                                <div class="tab-content">
                                    <div class="row">
                                        <div class="col-xs-4 col-sm-4 col-md-4">
                                            <c:if test="${sessionScope.userRight.govtFormatPF}">
                                                <a  style="font-size: 14px;text-align: left;color: #2c3e50;"  href="employeePfCheck.htm?act=searchSalaryPfGovDetail&search=none">
                                                    Govt. Format PF
                                                </a>
                                            </c:if>
                                        </div>
                                        <div class="col-xs-4 col-sm-4 col-md-4">
                                            <c:if test="${sessionScope.userRight.govtFormatPF}">
                                                <a  style="font-size: 14px;text-align: left;color: #2c3e50;"  href="esicDeductionStatement.htm?act=searchEsicDetailGovt&search=none">
                                                    Govt. Format Esic Deduction 
                                                </a>
                                            </c:if>
                                        </div>
                                        <div class="col-xs-4 col-sm-4 col-md-4">
                                            <c:if test="${sessionScope.userRight.pfChallen}">
                                                <a  style="font-size: 14px;text-align: left;color: #2c3e50;"   href="pFChallen.htm?act=searchPfChallenDetail&search=none">
                                                    PF Challen  
                                                </a>
                                            </c:if>
                                        </div>
                                    </div>
                                    <br>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="nav-tabs-custom">
                        <div  style="border: 1px #3c8dbc solid;border-radius: 5px;">
                            <div class="box-header" style="background-color: #006fad !important;text-align: center;">
                                <h3 class="box-title"style="font-size: 30px;color: white;font-weight:700;font-size:16px;">EMPLOYEE DETAIL INFORMATION</h3>
                            </div>
                            <div class="box-body"> 
                                <div class="tab-content">
                                    <div class="row">
                                        <div class="col-xs-4 col-sm-4 col-md-4">
                                            <%--<c:if test="${sessionScope.userRight.pMPReport}">--%>
                                            <a  style="font-size: 14px;text-align: left;color: #2c3e50;" href="homeController.htm?act=redirectToAllReports">
                                                Employee Detailed Information
                                            </a>
                                            <%--</c:if>--%>
                                        </div>
                                    </div>
                                    <br>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="nav-tabs-custom">
                        <div  style="border: 1px #3c8dbc solid;border-radius: 5px;">
                            <div class="box-header" style="background-color: #006fad !important;text-align: center;">
                                <h3 class="box-title"style="font-size: 30px;color: white;font-weight:700;font-size:16px;">POLICY</h3>
                            </div>
                            <div class="box-body"> 
                                <div class="tab-content">
                                    <div class="row">
                                        <div class="col-xs-4 col-sm-4 col-md-4">
                                            <c:if test="${sessionScope.userRight.policyViewDetail}">
                                                <a  style="font-size: 14px;text-align: left;color: #2c3e50;" href="policyMaster.htm?act=policyReport">
                                                    Policy Report View
                                                </a>
                                            </c:if>
                                        </div>
                                    </div>
                                    <br>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
</section>
</div>
<%@include file="/WEB-INF/jsp/Dashboard/ChartIncludeCss.jsp"%>
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>








</html>




