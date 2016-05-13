<%--
    Document   : ShiftCreate
    Created on : Oct 9, 2015, 10:47:55 AM
    Author     : Dhaval Patel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shift Data Search</title>
    </head>

    <script>
        function selectDropsDown11(val) {
            if (val == 'emp') {
                $('#employeeName').show();
                $('#zydexLocationIdDiv').hide();
                $('#levelIdDiv').hide();
                $('#departmentIdDiv').hide();

            } else {
                $('#employeeName').hide();
                $('#zydexLocationIdDiv').show();
                $('#levelIdDiv').show();
                $('#departmentIdDiv').show();

            }
        }
    </script>

    <style>
        .checkbox-grid li {
            display: block;
            float: left;
            width: 25%;
        }
    </style>


    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Employee Advance Search: </h1>

        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <%--<form:form action="shiftRotationMaster.htm?act=employeeDataSearchSubmit" method="post" commandName="employeeAdvanceSearch"--%>
        <form:form action="shiftRotationMaster.htm?act=employeeDataExcelSheet" method="post" commandName="employeeAdvanceSearch"
                   name='form1' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="box-header">
                                    <!--<h3 class="box-title">Employee Detail</h3>-->
                                    <!--                                        <div class="box-tools pull-right">
                                                                                <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
                                                                            </div>-->
                                </div><!-- /.box-header -->
                                <div class="box-body no-padding">

                                    <div class="row">
                                        <!--<div class="col-md-6 col-sm-6">-->
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">

                                                <div class="col-sm-6">
                                                    <label>Start Date<span style="color : red;font-size:12px;"></span></label>
                                                    <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_form:input1">
                                                        <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                        <form:input path="inDateTime"  class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>End Date<span style="color:red;font-size:12px;"></span></label>
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_form:input1">
                                                            <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                        <form:input path="outDateTime"  class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Searching Criteria:</label>
                                                        <select name="vallist" name="vallist" class="form-control" onchange="selectDropsDown11(this.value);">
                                                            <option value="emp">Employee wise Search</option>
                                                            <option value="other">Other</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <br/>
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-6" id="employeeName">
                                                        <label>Employee Name:</label>
                                                        <input type="text" id="employeeMasterId" name="employeeMasterId" class="form-control">
                                                    </div>

                                                    <div class="col-sm-6" id="zydexLocationIdDiv" style="display: none;">
                                                        <label>Zydex Location:</label>
                                                        <input type="text" id="zydexLocationId" name="zydexLocationId" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6" id="levelIdDiv" style="display: none;">
                                                        <label>Level Name:</label>
                                                        <input type="text" id="levelId" name="levelId" class="form-control">
                                                    </div>

                                                    <div class="col-sm-6" id="departmentIdDiv" style="display: none;">
                                                        <label>Department Name:</label>
                                                        <input type="text" id="departmentId" name="departmentId" class="form-control">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class=" col-sm-6">
                                                        <label>Employee Information:</label> 
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-2" style="margin-left: 25px;">
                                                        <input type="checkbox" id="selecctall">
                                                        <label>ALL SELECT</label>
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <input type="checkbox" name="active" checked="true">
                                                        <label>Active</label>
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <input type="checkbox" name="inactive">
                                                        <label>Inactive</label>
                                                    </div>
                                                </div>           


                                                <div class="form-group">

                                                    <ul class="checkbox-grid">

                                                        <li>

                                                        <form:checkbox  class="checkbox1" value="employeeId" path="employeeId"/>
                                                        <label>Employee No.</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="employeeName" path="employeeName"/>
                                                        <label>Employee Name</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="fatherName" path="fatherName"/>
                                                        <label>Father's Name</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="motherName" path="motherName" />
                                                        <label>Mother's Name</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="gender" path="gender" />
                                                        <label>Sex</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="maritalStatus" path="maritalStatus" />
                                                        <label>Marital Status</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="dateOfBirth" path="dateOfBirth" />
                                                        <label>Date Of Birth</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="presentAddress" path="presentAddress" />
                                                        <label>Present Address</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="permanentAddress" path="permanentAddress"/>
                                                        <label>Permanent Address</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="bloodGroups" path="bloodGroups" />
                                                        <label>Blood Groups</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="emailAddress" path="emailAddress" />
                                                        <label>Email Id</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="contactNo1" path="contactNo1" />
                                                        <label>Contact No.1</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="contactNo2" path="contactNo2" />
                                                        <label>Contact No.2</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="emergencyContactPerson" path="emergencyContactPerson" />
                                                        <label>Emergency Contact Person</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="emergencyContactNo" path="emergencyContactNo" />
                                                        <label>Emergency Contact No</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="panCard" path="panCard" />
                                                        <label>PAN Card No</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="passportNo" path="passportNo" />
                                                        <label>Passport No</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="passportIssueDate" path="passportIssueDate" />
                                                        <label>Passport Issue Date</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="passportExpiryDate" path="passportExpiryDate" />
                                                        <label>Passport Expiry Date</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="adharCard" path="adharCard" />
                                                        <label>Aadhar Card</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="officeEmailId" path="officeEmailId" />
                                                        <label>Official E-Mail ID</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="highestEducationDetails" path="highestEducationDetails" />
                                                        <label>Highest Education Details</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="experienceYearOnDoj" path="experienceYearOnDoj" />
                                                        <label>Exp. On Date Of Joining Year</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="experienceMonthOnDoj" path="experienceMonthOnDoj" />
                                                        <label>Exp. On Date Of Joining Month</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="company" path="company" />
                                                        <label>Company</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="zydexLocation" path="zydexLocation" />

                                                        <label>Zydex Location</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="workLocation" path="workLocation" />
                                                        <label>Work Location</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="level" path="level" />
                                                        <label>Level</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="department" path="department" />
                                                        <label>Department</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="designation" path="designation" />
                                                        <label>Designation</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="role" path="role" />
                                                        <label>Role</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="dateOfJoining" path="dateOfJoining" />
                                                        <label>Date Of Joining</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="employeeType" path="employeeType" />
                                                        <label>Employee Type</label>
                                                    </li>

                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="bankName" path="bankName" />
                                                        <label>Bank Name</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="bankAccountNo" path="bankAccountNo" />
                                                        <label>Bank Account No</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="bankIfscCode" path="bankIfscCode" />
                                                        <label>IFSC Code</label>
                                                    </li>
                                                    <li>
                                                        <form:checkbox  class="checkbox1" value="reportingManager" path="reportingManager" />
                                                        <label>Reporting Manager</label>
                                                    </li>
                                                </ul>
                                            </div>



                                            <div class="form-group">
                                                <div class=" col-sm-12" style="text-align: center;">
                                                    <button type="submit" class="btn btn-primary" style="width: 100px;" >EXPORT</button>
                                                </div>
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
            forceParse: 0,
//            endDate: new Date()
        });</script>

    <script>
        jQuery.noConflict();
        jQuery(document).ready(function () {
            jQuery("#employeeMasterId").tokenInput(${list}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. .",
            });
        });
    </script>
    <script>
        jQuery.noConflict();
        jQuery(document).ready(function () {
            jQuery("#zydexLocationId").tokenInput(${zydexLocationList}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. .",
            });
        });
    </script>
    <script>
        jQuery.noConflict();
        jQuery(document).ready(function () {
            jQuery("#levelId").tokenInput(${levelList}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. .",
            });
        });
    </script>
    <script>
        jQuery.noConflict();
        jQuery(document).ready(function () {
            jQuery("#departmentId").tokenInput(${departmentList}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. .",
            });
        });
    </script>

    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <script>
        $('#selecctall').on('ifChecked', function (event) {
            //        if ($('.checkAll').filter(':checked').length == $('.check').length) {
            $('.checkbox1').iCheck('check');
            //        }
        });
        $('#selecctall').on('ifUnchecked', function (event) {
            $('.checkbox1').iCheck('uncheck');
        });</script>
</html>
