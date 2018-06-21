<%--
    Document   : UserRight
    Created on : Oct 17, 2015, 5:18:26 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Right</title>
    </head>
    <script>
        var flag3 = true;
        function saveSubmit11() {
            if (flag3) {
                flag3 = false;
                document.getElementById('saveSubmit1').innerHTML = 'Saving ... .. .';
                document.form1.submit();
                return true;
            } else {
                return false;
            }
        }
    </script>
    <script>
        $(function () {
            $('[data-toggle="tooltip"]').tooltip();
        });
    </script>


    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>RIGHTS MANAGEMENT:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Rights Management</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="userRightMaster.htm?act=createSubmit" method="post" commandName="userRightMaster"
                   name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
            <form:hidden path="userMaster.id"></form:hidden>

                <!--<form class="form-horizontal" role="form" commandName>-->

                <!--Read only entries Starts here-->
                <!--<div class="box box-info collapsed-box ">-->
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Custom Tabs -->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">

                                    <div class="box-header">

                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class=" col-sm-6">
                                                        <label>User Role Management:</label>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="hr"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" id="1" >HR Head</label>

                                                </div>
                                                <div class="col-sm-3">
                                                    <form:checkbox path="employee"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" id="2" >Employee</label>

                                                </div>

                                                <div class="col-sm-3">
                                                    <form:checkbox path="travelAdmin"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Travel Admin</label>

                                                </div>

                                                <div class="col-sm-3">
                                                    <form:checkbox path="itAdmin"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >IT Admin</label>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <form:checkbox path="travelExpenseAdmin"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Finance Department Admin</label>

                                                </div>
                                                <div class="col-sm-3">
                                                    <form:checkbox path="poolCarAdmin"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >PoolCarAdmin</label>

                                                </div>
                                                <div class="col-sm-3">
                                                    <form:checkbox path="security"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Security</label>
                                                </div>
                                                <div class="col-sm-3">
                                                    <form:checkbox path="cafeteriaAdmin"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Cafeteria Admin</label>

                                                </div>

                                            </div><!-- /.col -->
                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <form:checkbox path="employeeManagement"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Employee Management</label>

                                                </div>
                                                <div class="col-sm-3">
                                                    <form:checkbox path="leaveManagement"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Leave Management</label>

                                                </div>
                                                <div class="col-sm-3">
                                                    <form:checkbox path="shiftManagement"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Shift Management</label>
                                                </div>
                                                <div class="col-sm-3">
                                                    <form:checkbox path="appraisalPmp"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Appraisal PMP</label>

                                                </div>

                                            </div><!-- /.col -->
                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <form:checkbox path="appraisal360"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >360 Appraisal</label>

                                                </div>
                                                <div class="col-sm-3">
                                                    <form:checkbox path="probationToConfirmation"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Probation To Confirmation</label>

                                                </div>
                                                <div class="col-sm-3">
                                                    <form:checkbox path="employeeExit"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Employee Exit</label>
                                                </div>
                                                <div class="col-sm-3">
                                                    <form:checkbox path="employeeReferral"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Employee Referral</label>

                                                </div>

                                            </div><!-- /.col -->
                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <form:checkbox path="temporaryShiftAssign"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Temporary Shift Assign</label>

                                                </div>
                                                <div class="col-sm-3">
                                                    <form:checkbox path="exitInterview"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Exit Interview</label>

                                                </div>
                                                <div class="col-sm-3">
                                                    <form:checkbox path="noDue"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >No Due</label>
                                                </div>
                                                <div class="col-sm-3">
                                                    <form:checkbox path="attendanceReport"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Attendance Management</label>
                                                </div>
                                            </div><!-- /.col -->
                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <form:checkbox path="cashAdvanceView"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Cash Advance View</label>

                                                </div>
                                                <div class="col-sm-3">
                                                    <form:checkbox path="departmentWiseAttendance"></form:checkbox>
                                                        
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Department Wise Attendance</label>

                                                </div>
                                            </div>
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div><!-- /.tab-content -->
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <div class=" col-sm-6">
                                                    <label>User Rights Management:</label>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <form:checkbox path="faceTofaceInterview"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Face To Face InterView</label>

                                                </div>
                                                <div class="col-sm-3">
                                                    <form:checkbox path="candidateList"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Candidate List</label>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <form:checkbox path="mpr"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >MPR Create</label>

                                                </div>
                                                <div class="col-sm-3">
                                                    <form:checkbox path="budget"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >MPP Budget Create</label>

                                                </div>
                                                <div class="col-sm-3">
                                                    <form:checkbox path="vacancy"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Vacancy</label>

                                                </div>
                                                <div class="col-sm-3">
                                                    <form:checkbox path="candidateInduction"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Candidate Induction</label>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <form:checkbox path="assessmentReview"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Assessment Review</label>

                                                </div>
                                                <div class="col-sm-3">
                                                    <form:checkbox path="mppApproval"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >MPP Budget Approval</label>

                                                </div>
                                                <div class="col-sm-3">
                                                    <form:checkbox path="mprApproval"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >MPR Approval</label>

                                                </div>
                                                <div class="col-sm-3">
                                                    <form:checkbox path="faceTofaceApproval"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Face To Face Approval</label>

                                                </div>


                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <form:checkbox path="payroll"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Payroll</label>

                                                </div>
                                                <div class="col-sm-3">
                                                    <form:checkbox path="training"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Training</label>

                                                </div>
                                                <div class="col-sm-3">
                                                    <form:checkbox path="kaizenApproval"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >kaizen Approval</label>

                                                </div>
                                            </div>
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div><!-- /.tab-content -->

                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <div class=" col-sm-6">
                                                    <label>Report Rights:</label>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <form:checkbox path="employeeMasterReport"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >employee Master Report</label>


                                                </div>
                                                <div class="col-sm-3">
                                                    <form:checkbox path="employeeAttendanceReport"></form:checkbox>
                                                        
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >employee Attendance Report</label>

                                                </div>

                                                <div class="col-sm-3">
                                                    <form:checkbox path="monthlyAttendanceReport"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >monthly Attendance Report</label>

                                                </div>

                                                <div class="col-sm-3">
                                                    <form:checkbox path="dailyPresentReport"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >daily Present Report</label>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <form:checkbox path="searchEmployeeLeaveDetail"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >search employee Leave</label>


                                                </div>
                                                <div class="col-sm-3">
                                                    <form:checkbox path="searchEmployeeLeaveBalance"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Employee Leave Balance</label>

                                                </div>

                                                <div class="col-sm-3">
                                                    <form:checkbox path="searchTravelReques"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >search Travel Request</label>

                                                </div>

                                                <div class="col-sm-3">
                                                    <form:checkbox path="searchExpenseRequest"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Search Expense Request</label>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <form:checkbox path="formSixteen"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Form Sixteen</label>


                                                </div>
                                                <div class="col-sm-3">
                                                    <form:checkbox path="pf"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >PF</label>

                                                </div>

                                                <div class="col-sm-3">
                                                    <form:checkbox path="pt"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >PT</label>

                                                </div>

                                                <div class="col-sm-3">
                                                    <form:checkbox path="salarySlip"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Salary Slip</label>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <!-- <div class="col-sm-3">
                                                <%--<form:checkbox path="policy"></form:checkbox>--%>
                                                    &nbsp;&nbsp;&nbsp;
                                                <label style="font-weight: normal">Policy</label>


                                                </div>-->
                                                <div class="col-sm-3">
                                                    <form:checkbox path="govtFormatPF"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Govt. Format PF</label>


                                                </div>
                                                <div class="col-sm-3">
                                                    <form:checkbox path="companyMonthlyReport"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Company Monthly Report</label>

                                                </div>

                                                <div class="col-sm-3">
                                                    <form:checkbox path="ptStatement"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >PT Slab By Summary</label>

                                                </div>

                                                <div class="col-sm-3">
                                                    <form:checkbox path="bankStatement"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Bank Statement</label>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <form:checkbox path="eSICDeductionStatement"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >ESIC Deduction Statement</label>


                                                </div>
                                                <div class="col-sm-3">
                                                    <form:checkbox path="overTimeReport"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Over Time Report</label>

                                                </div>

                                                <div class="col-sm-3">
                                                    <form:checkbox path="pfChallen"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >PF Challen</label>

                                                </div>

                                                <div class="col-sm-3">
                                                    <form:checkbox path="loan"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Loan</label>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <form:checkbox path="attendance"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Attendance</label>


                                                </div>
                                                <div class="col-sm-3">
                                                    <form:checkbox path="employeeSalaryYearly"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Employee Salary Yearly</label>

                                                </div>
                                                <div class="col-sm-3">
                                                    <form:checkbox path="pMPReport"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >PMP Report</label>


                                                </div>
                                                <div class="col-sm-3">
                                                    <form:checkbox path="appraisalReport360"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >360 Appraisal Report</label>

                                                </div>
                                            </div>
                                            <!--                                                <div class="form-group">
                                                                                                <div class="col-sm-3">
                                            <%--<form:checkbox path="govtFormatPF"></form:checkbox>--%>
                                            &nbsp;&nbsp;&nbsp;
                                            <label style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" title="${userDescription[0].govtFormatPfDescription}">Govt. Format PF</label>

                                        </div>
                                    </div>-->
                                        </div>
                                    </div>
                                </div>


                                <br/>
                                <div class="form-group">
                                    <div class="col-sm-6 col-sm-offset-5">
                                        <button type="submit" class="btn btn-primary" id="saveSubmit1" >Submit</button>
                                    </div>
                                </div>
                            </div><!-- nav-tabs-custom -->
                        </div><!-- /.col -->
                    </div>
            </section>                            
        </form:form>
        <!--</div>-->
        <!--Employee detail completes here-->
        <!--read only entries ends here-->

    </div>

    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>


