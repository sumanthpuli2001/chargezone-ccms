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
            <h1>Report</h1>
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
                        <h3 style="text-align: center;"> Attendance Report</h3>
                        <div class="tab-content">
                            <div class="row">
                                <c:choose>
                                    <c:when test="${empty sessionScope.userRight.employeeMasterReport eq sessionScope.userRight.employeeAttendanceReport eq sessionScope.userRight.monthlyAttendanceReport eq sessionScope.userRight.dailyPresentReport}">
                                        <tr>
                                            <td align="center">
                                                <c:out value="'Access Denied'"></c:out>
                                                </td>
                                            </tr>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="col-xs-4 col-sm-4 col-md-4">
                                            <c:if test="${sessionScope.userRight.employeeMasterReport}">
                                                <a  style="font-size: 15px" href="shiftRotationMaster.htm?act=employeeDataSearch">
                                                    <strong>Employee Master Report</strong>
                                                </a>
                                            </c:if>
                                        </div>
                                        <div  class="col-xs-4 col-sm-4 col-md-4">
                                            <c:if test="${sessionScope.userRight.employeeAttendanceReport}">
                                                <a  style="font-size: 15px"  href="shiftRotationMaster.htm?act=employeeDataSearch2">
                                                    <strong>Employee Attendance Report</strong>
                                                </a>
                                            </c:if>
                                        </div>
                                        <div class="col-xs-4 col-sm-4 col-md-4">
                                            <c:if test="${sessionScope.userRight.monthlyAttendanceReport}">
                                                <a  style="font-size: 15px" href="shiftRotationMaster.htm?act=employeeAttandanceDataSearch">
                                                    &nbsp<strong>Monthly Attendance Report</strong>
                                                </a>
                                            </c:if>
                                        </div>
                                        <div class="col-xs-4 col-sm-4 col-md-4">
                                            <c:if test="${sessionScope.userRight.dailyPresentReport}">
                                                <a  style="font-size: 15px"  href="shiftRotationMaster.htm?act=employeePresentSearch" target="_blank">
                                                    &nbsp<strong>Daily Present Report</strong>
                                                </a>
                                            </c:if>
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <br>
                        </div>
                    </div>
                    <div class="nav-tabs-custom">
                        <h3 style="text-align: center;"> Payroll Report</h3>
                        <div class="tab-content">
                            <div class="row">
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <c:if test="${sessionScope.userRight.formSixteen}">
                                        <a  style="font-size: 15px" href="payrollEmployeeFormSixteen.htm?act=redirectToFormSexteen&search=none">
                                            <strong>Form Sixteen</strong>
                                        </a>
                                    </c:if>
                                </div>
                                <div  class="col-xs-4 col-sm-4 col-md-4">
                                    <c:if test="${sessionScope.userRight.pf}">
                                        <a  style="font-size: 15px"  href="employeePfCheck.htm?act=searchSalaryPfDetail&search=none">
                                            <strong>PF</strong>
                                        </a>
                                    </c:if>
                                </div>
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <c:if test="${sessionScope.userRight.pt}">
                                        <!--<a class="label label-primary" style="font-size: 20px" href="hrServiceRequest.htm?act=searchSubmit">-->
                                        <a  style="font-size: 15px" href="employeePtCheck.htm?act=searchSalaryPtDetail&search=none">
                                            &nbsp<strong>PT</strong>
                                        </a>
                                    </c:if>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <c:if test="${sessionScope.userRight.salarySlip}">
                                        <a  style="font-size: 15px"  href="employeeSalarySlip.htm?act=searchSalarySlipDetail&search=none">
                                            &nbsp<strong>Salary Slip </strong>
                                        </a>
                                    </c:if>
                                </div>
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <c:if test="${sessionScope.userRight.policy}">
                                        <a  style="font-size: 15px"  href="policyMaster.htm?act=searchPolicyDetail&search=none">
                                            &nbsp<strong>Policy</strong>
                                        </a>
                                    </c:if>
                                </div>
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <c:if test="${sessionScope.userRight.companyMonthlyReport}">
                                        <a  style="font-size: 15px"  href="companyMonthlyReport.htm?act=searchCompanyMonthlyReport&search=none">
                                            &nbsp<strong>Company Monthly Report</strong>
                                        </a>
                                    </c:if>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <c:if test="${sessionScope.userRight.ptStatement}">
                                        <a  style="font-size: 15px"  href="companyPTReport.htm?act=searchCompanyPTReport&search=none">
                                            &nbsp<strong>PT Statement </strong>
                                        </a>
                                    </c:if>
                                </div>
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <c:if test="${sessionScope.userRight.bankStatement}">
                                        <a  style="font-size: 15px"  href="bankStatement.htm?act=searchBankStatementDetail&search=none">
                                            &nbsp<strong>Bank Statement </strong>
                                        </a>
                                    </c:if>
                                </div>
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <c:if test="${sessionScope.userRight.eSICDeductionStatement}">
                                        <a  style="font-size: 15px" href="esicDeductionStatement.htm?act=searchEsicDetail&search=none">
                                            &nbsp<strong>ESIC Deduction Statement </strong>
                                        </a>
                                    </c:if>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <c:if test="${sessionScope.userRight.overTimeReport}">
                                        <a  style="font-size: 15px"  href="overTime.htm?act=searchOTDetail&search=none">
                                            &nbsp<strong>Over Time Report</strong>
                                        </a>
                                    </c:if>
                                </div>
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <c:if test="${sessionScope.userRight.pfChallen}">
                                        <a  style="font-size: 15px"  href="pFChallen.htm?act=searchPfChallenDetail&search=none">
                                            &nbsp<strong>PF Challen  </strong>
                                        </a>
                                    </c:if>
                                </div>
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <c:if test="${sessionScope.userRight.loan}">
                                        <a  style="font-size: 15px" href="loanReport.htm?act=searchLoanData&search=none">
                                            &nbsp<strong>Loan </strong>
                                        </a>
                                    </c:if>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <c:if test="${sessionScope.userRight.attendance}">
                                        <a  style="font-size: 15px"  href="attendanceReport.htm?act=searchAttendanceData&search=none">
                                            &nbsp<strong>Attendance</strong>
                                        </a>
                                    </c:if>
                                </div>
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <c:if test="${sessionScope.userRight.employeeSalaryYearly}">
                                        <a  style="font-size: 15px"  href="employeeSalarySlip.htm?act=searchSalaryYearDetail&search=none">
                                            &nbsp<strong>Employee Salary Yearly  </strong>
                                        </a>
                                    </c:if>
                                </div>
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <c:if test="${sessionScope.userRight.govtFormatPF}">
                                        <a  style="font-size: 15px" href="employeePfCheck.htm?act=searchSalaryPfGovDetail&search=none">
                                            &nbsp<strong>Govt. Format PF </strong>
                                        </a>
                                    </c:if>
                                </div>
                            </div>
                            <br>
                        </div>
                    </div>
                    <div class="nav-tabs-custom">
                        <h3 style="text-align: center;"> Leave Management</h3>
                        <div class="tab-content">
                            <div class="row">
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <c:if test="${sessionScope.userRight.searchEmployeeLeaveDetail}">
                                        <a  style="font-size: 15px" href="leaveEmployeeDetail.htm?act=searchEmpLeaveDetail">
                                            <strong>Search Employee Leave Detail</strong>
                                        </a>
                                    </c:if>
                                </div>
                                <div  class="col-xs-4 col-sm-4 col-md-4">
                                    <c:if test="${sessionScope.userRight.searchEmployeeLeaveBalance}">
                                        <a  style="font-size: 15px" href="leaveEmployeeDetail.htm?act=searchEmployeeLeaveBalance">
                                            <strong>Search Employee Leave Balance</strong>
                                        </a>
                                    </c:if>
                                </div>
                            </div>
                            <br>
                        </div>
                    </div>
                    <div class="nav-tabs-custom">
                        <h3 style="text-align: center;">Employee Service</h3>
                        <div class="tab-content">
                            <div class="row">
                                <c:choose>
                                    <c:when test="${empty sessionScope.userRight.searchTravelReques eq sessionScope.userRight.searchExpenseRequest}">
                                        <tr>
                                            <td align="center">
                                                <c:out value="'Access Denied'"></c:out>
                                                </td>
                                            </tr>
                                    </c:when>
                                    <c:otherwise>
                                        <c:if test="${sessionScope.userRight.searchTravelReques}">
                                            <div class="col-xs-4 col-sm-4 col-md-4">
                                                <a  style="font-size: 15px" href="travelRequestMaster.htm?act=viewRequestAdminSubmit">
                                                    <strong>Search Travel Request </strong>
                                                </a>
                                            </c:if>
                                        </div>
                                        <div  class="col-xs-4 col-sm-4 col-md-4">
                                            <c:if test="${sessionScope.userRight.searchExpenseRequest}">
                                                <a  style="font-size: 15px" href="expenseMaster.htm?act=searchExpenseRequest">
                                                    <strong>Search Expense Request</strong>
                                                </a>
                                            </c:if>
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <br>
                        </div>
                    </div>
                    <div class="nav-tabs-custom">
                        <h3 style="text-align: center;">Performance Management</h3>
                        <div class="tab-content">
                            <div class="row">
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <c:if test="${sessionScope.userRight.pMPReport}">
                                        <a  style="font-size: 15px" href="appraisalPerformance.htm?act=searchAppraisalPerformanceReoprtStageWise">
                                            <strong>PMP-Report</strong>
                                        </a>
                                    </c:if>
                                </div>
                                <div  class="col-xs-4 col-sm-4 col-md-4">
                                    <c:if test="${sessionScope.userRight.appraisalReport360}">
                                        <a  style="font-size: 15px" href="appraisal360.htm?act=searchAppraisalPerformance360Reoprt">
                                            <strong>360 Appraisal Report</strong>
                                        </a>
                                    </c:if>
                                </div>
                            </div>
                            <br>
                        </div>
                    </div>
                    <div class="nav-tabs-custom">
                        <h3 style="text-align: center;">Statutory Report</h3>
                        <div class="tab-content">
                            <div class="row">
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <%--<c:if test="${sessionScope.userRight.pMPReport}">--%>
                                        <a  style="font-size: 15px" href="homeController.htm?act=form5">
                                            <strong>Form 5</strong>
                                        </a>
                                    <%--</c:if>--%>
                                </div>
                                <div  class="col-xs-4 col-sm-4 col-md-4">
                                    <%--<c:if test="${sessionScope.userRight.appraisalReport360}">--%>
                                        <a  style="font-size: 15px" href="homeController.htm?act=form10">
                                            <strong>Form 10</strong>
                                        </a>
                                    <%--</c:if>--%>
                                </div>
                            </div>
                            <br>
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




