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

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Rights Management:</h1>
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
                                                        <label>User Right Management:</label>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="hr"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label style="font-weight: normal">HR</label>


                                                    </div>
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="employee"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">Employee</label>

                                                    </div>

                                                    <div class="col-sm-3">
                                                    <form:checkbox path="travelAdmin"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">Travel Admin</label>

                                                    </div>

                                                    <div class="col-sm-3">
                                                    <form:checkbox path="itAdmin"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">IT Admin</label>

                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="travelExpenseAdmin"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">Finance Department Admin</label>

                                                    </div>
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="poolCarAdmin"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">PoolCarAdmin</label>

                                                    </div>
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="security"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">Security</label>
                                                    </div>
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="cafeteriaAdmin"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">Cafeteria Admin</label>

                                                    </div>

                                                </div><!-- /.col -->
                                                <div class="form-group">
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="employeeManagement"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">Employee Management</label>

                                                    </div>
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="leaveManagement"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">Leave Management</label>

                                                    </div>
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="shiftManagement"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">Shift Management</label>
                                                    </div>
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="appraisalPmp"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">Appriasal PMP</label>

                                                    </div>

                                                </div><!-- /.col -->
                                                <div class="form-group">
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="appraisal360"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">360 Appraisal</label>

                                                    </div>
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="probationToConfirmation"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">Probation To Confirmation</label>

                                                    </div>
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="employeeExit"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">Employee Exit</label>
                                                    </div>
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="employeeReferral"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">Employee Referral</label>

                                                    </div>

                                                </div><!-- /.col -->
                                                <div class="form-group">
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="temporaryShiftAssign"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">Temporary Shift Assign</label>

                                                    </div>
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="exitInterview"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">Exit Interview</label>

                                                    </div>
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="noDue"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">No Due</label>
                                                    </div>
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="attendanceReport"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">Attendance Mgt.</label>
                                                    </div>
                                                </div><!-- /.col -->
                                                <div class="form-group">
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="cashAdvanceView"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">Cash Advance View</label>

                                                    </div>
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="departmentWiseAttendance"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">Department Wise Attendance</label>

                                                    </div>
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="faceTofaceInterview"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">Face To Face InterView</label>

                                                    </div>
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="candidateList"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">Candidate List</label>

                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="mpr"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">MPR Create</label>

                                                    </div>
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="budget"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">MPP Budget Create</label>

                                                    </div>
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="vacancy"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">Vacancy</label>

                                                    </div>
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="candidateInduction"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">Candidate Induction</label>

                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="assessmentReview"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">Assessment Review</label>

                                                    </div>
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="mppApproval"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">MPP Budget Approval</label>

                                                    </div>
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="mprApproval"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">MPR Approval</label>

                                                    </div>
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="faceTofaceApproval"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">Face To Face Approval</label>

                                                    </div>


                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="payroll"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">Payroll</label>

                                                    </div>
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="training"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">Training</label>

                                                    </div>
                                                    <div class="col-sm-3">
                                                    <form:checkbox path="kaizenApproval"></form:checkbox>
                                                        &nbsp;&nbsp;&nbsp;
                                                        <label  style="font-weight: normal">kaizen Approval</label>

                                                    </div>
                                                </div>
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div><!-- /.tab-content -->
                                    <br/>
                                    <button type="submit" class="btn btn-primary" id="saveSubmit1" >Submit</button>
                                </div><!-- nav-tabs-custom -->
                            </div><!-- /.col -->
                        </div>
                </section>

        </form:form>
        <!--</div>-->
        <!--Employee detail completes here-->
        <!--read only entries ends here-->

        <!--form horizontal ends here-->
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
</html>


