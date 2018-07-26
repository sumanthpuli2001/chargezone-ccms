<%-- 
    Document   : EmployeeBySearchCriteria
    Created on : Jun 6, 2018, 10:28:09 AM
    Author     : DELL3
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>

    <head>
        <title>Employee Detailed Information</title>
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Employee Detailed Information</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Employee Detailed Information</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <%--<form:form class="form-horizontal" role="form1" action="homeController.htm?act=onSearchClick" method="post" id='myForm' onsubmit='return saveSubmit11();'>--%>
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                            <!--form horizontal starts here-->

                            <div class="box-header">

                            </div>
                            <div class="box-body no-padding">
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="form-group">
                                            <div class="col-sm-6">
                                                <label>Categories<span style="color: red;font-size: 12px;">*</span></label>
                                                <select name="searchCategory" id="searchCategory" class="form-control " onchange="getCategory(this.value)">
                                                    <option value="">--Select Category--</option>
                                                    <option value="employee">Employee Information</option>
                                                    <option value="leave">Leave Information</option>
                                                    <option value="attendance">Attendance Information</option>
                                                    <option value="probation">Probation To Confirmation</option>
                                                    <option value="expense">Expense Information</option>
                                                    <option value="training">Training Information</option>
                                                    <option value="recruitment">Recruitment Information</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-12">
                                        <div class="employee showBox content">
                                            <form:form class="form-horizontal" role="form1" action="homeController.htm?act=onSearchClick" method="post" id='myForm' onsubmit='return saveSubmit11();'>
                                                <h3 style="text-align: center">Employee Information</h3>
                                                <div class="col-sm-12">
                                                    </br>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Employee Code:</label>
                                                            <input type="text" name="employeeCode" class="form-control" size="16" placeholder="DD/MM/YYYY" />
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Employee Name:</label>
                                                            <input type="text" id="employeeMasterId" name="employeeMasterId" class="form-control">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-sm-12">
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Joining Start Date:</label>
                                                            <div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                <input type="text" name="joiningStartDate" placeholder="DD/MM/YYYY" id="joiningStartDate" class="form-control" size="16" value="" readonly="true">
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Joining End Date:</label>
                                                            <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                <input type="text" name="joiningEndDate"  placeholder="DD/MM/YYYY" id="joiningStartDate" class="form-control" size="16" value="" readonly="true">
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-sm-12">
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Location:</label>
                                                            <select id="locationDropDown" name="locationDropDown" class="form-control">
                                                                <option value="" label="-- Select --"/>
                                                            </select>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Department:</label>
                                                            <select name="departmentDropDown" id="departmentDropDown" class="form-control">
                                                                <option value="" label="-- Select --"/>    
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-sm-12">
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Designation:</label>
                                                            <select name="designationDropDown" id="designationDropDown" class="form-control">
                                                                <option value="" label="-- Select --" />
                                                            </select>
                                                        </div>
                                                        <div class="col-sm-6" style="padding-top: 30px;text-align: center">
                                                            <button type="button" class="btn btn-reddit btn-sm" data-toggle="modal" data-target="#myModal">Add / Select More Fields</button>
                                                        </div>
                                                    </div>
                                                    </br>
                                                    <label style="font-size: 12px">is Former Employee?</label></span>&emsp;
                                                    <input type="radio" value="true" name="isFormerEmployee" class="isFormerEmployee" id="isFormerEmployee" />Yes &nbsp; <span>
                                                        <input type="radio" value="false" name="isFormerEmployee" class="isFormerEmployee" id="isFormerEmployee" checked="true"/>No<span>
                                                            </div>
                                                            <div class="col-sm-12" id="employeeExitDiv">
                                                                <div class="form-group">
                                                                    <div class="col-sm-6">
                                                                        <label>Employee Exit Start Date:</label>
                                                                        <div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                            <input type="text" name="exitStartDate" placeholder="DD/MM/YYYY" id="exitStartDate" class="form-control" size="16" value="" readonly="true">
                                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-sm-6">
                                                                        <label>Employee Exit End Date:</label>
                                                                        <div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                            <input type="text" name="exitEndDate" placeholder="DD/MM/YYYY" id="exitEndDate" class="form-control" size="16" value="" readonly="true">
                                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>

                                                            <div class="col-sm-12">
                                                                <div class="modal fade" id="myModal" role="dialog">
                                                                    <div class="modal-dialog" style="width:1150px;">
                                                                        <div class="modal-content">
                                                                            <div class="modal-header">
                                                                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                                                <h4 class="modal-title">Add / Select Fields To be Display</h4>
                                                                            </div>
                                                                            <div class="modal-body">
                                                                                <section class="content">
                                                                                    <div class="row">
                                                                                        <div class="form-group">
                                                                                            <div class="col-sm-12">
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="selecctall" id="selecctall" value="allSelect" name="allSelect"/>
                                                                                                    <label>All Select</label>
                                                                                                </div>
                                                                                                </br></br></br>
                                                                                            </div>
                                                                                            <div class="col-sm-12">
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="employeeId"/>
                                                                                                    <label>Employee No.</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="employeeName"/>
                                                                                                    <label>Employee Name</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="fatherName"/>
                                                                                                    <label>Father's Name</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="motherName" />
                                                                                                    <label>Mother's Name</label>
                                                                                                </div>
                                                                                            </div>
                                                                                            <div class="col-sm-12">
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="gender" />
                                                                                                    <label>Gender</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="maritalStatus" />
                                                                                                    <label>Marital Status</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="spouseName" />
                                                                                                    <label>Spouse Name</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="dateOfBirth" />
                                                                                                    <label>Date Of Birth</label> 
                                                                                                </div>
                                                                                            </div>
                                                                                            <div class="col-sm-12">
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="presentAddress" />
                                                                                                    <label>Present Address</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="permanentAddress"/>
                                                                                                    <label>Permanent Address</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="bloodGroups" />
                                                                                                    <label>Blood Groups</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="emailAddress" />
                                                                                                    <label>Email Id</label>
                                                                                                </div>
                                                                                            </div>
                                                                                            <div class="col-sm-12">
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="contactNo1" />
                                                                                                    <label>Contact No.1</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="contactNo2" />
                                                                                                    <label>Contact No.2</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="emergencyContactPerson" />
                                                                                                    <label>Emergency Contact Person</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="emergencyContactNo" />
                                                                                                    <label>Emergency Contact No</label>
                                                                                                </div>
                                                                                            </div>
                                                                                            <div class="col-sm-12">
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="panCard" />
                                                                                                    <label>PAN Card No</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="passportNo" />
                                                                                                    <label>Passport No</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="passportIssueDate" />
                                                                                                    <label>Passport Issue Date</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="passportExpiryDate" />
                                                                                                    <label>Passport Expiry Date</label>
                                                                                                </div>
                                                                                            </div>
                                                                                            <div class="col-sm-12">
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="adharCard" />
                                                                                                    <label>Aadhar Card</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="officeEmailId" />
                                                                                                    <label>Official E-Mail ID</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="highestEducationDetails" />
                                                                                                    <label>Highest Education Details</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="experienceYearOnDoj" />
                                                                                                    <label>Exp. On Date Of Joining Year</label>
                                                                                                </div>
                                                                                            </div>
                                                                                            <div class="col-sm-12">
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="experienceMonthOnDoj" />
                                                                                                    <label>Exp. On Date Of Joining Month</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="company" />
                                                                                                    <label>Company</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="zydexLocation" />
                                                                                                    <label> Location</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="workLocation" />
                                                                                                    <label>Work Location</label>
                                                                                                </div>
                                                                                            </div>
                                                                                            <div class="col-sm-12">
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="level" />
                                                                                                    <label>Level</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="department" />
                                                                                                    <label>Department</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="designation" />
                                                                                                    <label>Designation</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="role" />
                                                                                                    <label>Role</label>
                                                                                                </div>
                                                                                            </div>
                                                                                            <div class="col-sm-12">
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="dateOfJoining" name="dateOfJoining" />
                                                                                                    <label>Date Of Joining</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="employeeType" />
                                                                                                    <label>Employee Type</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="bankName" />
                                                                                                    <label>Bank Name</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="bankAccountNo" />
                                                                                                    <label>Bank Account No</label>
                                                                                                </div>
                                                                                            </div>
                                                                                            <div class="col-sm-12">
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="bankIfscCode" />
                                                                                                    <label>IFSC Code</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="reportingManager" />
                                                                                                    <label>Reporting Manager</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="cityOfEmployee" />
                                                                                                    <label>City </label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="child1" />
                                                                                                    <label>Child 1 </label>
                                                                                                </div>
                                                                                            </div>
                                                                                            <div class="col-sm-12">
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="child2" />
                                                                                                    <label>Child 2 </label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="dateOfBirthOfEmpFather" />
                                                                                                    <label>Father's Date Of Birth </label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="dateOfBirthOfEmpMother" />
                                                                                                    <label>Mother's Date Of Birth </label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="dateOfBirthOfEmpSpous" />
                                                                                                    <label>Spouse's Date Of Birth</label>
                                                                                                </div>
                                                                                            </div>
                                                                                            <div class="col-sm-12">
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="dateOfBirthOfEmpChilld1" />
                                                                                                    <label>Child1's Date Of Birth</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="dateOfBirthOfEmpChild2" />
                                                                                                    <label>Child2's Date Of Birth</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="dateOfTransferOfEntity" />
                                                                                                    <label>Date Of Transfer Of Entity</label>
                                                                                                </div>
                                                                                                <div class="col-sm-3">
                                                                                                    <input type="checkbox"  class="checkbox1" value="true" name="dateOfLeaving" />
                                                                                                    <label>Date Of Leaving</label>
                                                                                                </div>
                                                                                            </div>
                                                                                        </div>
                                                                                    </div>
                                                                                </section>
                                                                            </div>
                                                                            <div class="modal-footer">
                                                                                <button type="button" id="modalCloseClear" class="btn btn-primary" data-dismiss="modal">Select</button>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-12" style="text-align: center">
                                                                <div class="form-group">
                                                                    <button type="button" class="btn btn-primary" id="submitButton">Submit</button>
                                                                </div>
                                                            </div>
                                                            <script>
                                                                $(function () {
                                                                    $('#selecctall').on('ifChecked', function (event) {
                                                                        $('.checkbox1').iCheck('check');
                                                                    });
                                                                    $('#selecctall').on('ifUnchecked', function (event) {
                                                                        $('.checkbox1').iCheck('uncheck');
                                                                    });
                                                                });
                                                            </script>
                                                        </form:form>    
                                                        </div>
                                                        <div class="col-sm-12 leave showBox">You have selected <strong>Leave Information</strong> so i am here

                                                        </div>
                                                        <div class="col-sm-12 attendance showBox">You have selected <strong>Attendance Information</strong> so i am here</div>        
                                                        <div class="col-sm-12 probation showBox">You have selected <strong>Probation To Confirmation</strong> so i am here</div>        
                                                        <div class="col-sm-12 expense showBox">You have selected <strong>Expense Information</strong> so i am here</div>        
                                                        <div class="col-sm-12 training showBox">You have selected <strong>Training Information</strong> so i am here</div>        
                                                        <div class="col-sm-12 recruitment showBox">You have selected <strong>Recruitment Information</strong> so i am here</div>        
                                                        </div>
                                                        </div><!-- /.col -->
                                                        </div><!-- /.row -->
                                                        </div><!-- /.box-body -->
                                                        </div>
                                                        </div>

                                                        <div class=" col-sm-12">
                                                            <div class=" col-sm-4"></div>
                                                            <div class=" col-sm-4" style="text-align:center">
                                                                <h4 id="empH4"><b>Employee Information</b></h4>
                                                            </div>
                                                            <div class=" col-sm-4" style="text-align:right">
                                                                <button type="button" style="text-align: right" class="btn btn-dropbox" id="empExcelButton" onclick="ExportToExcel();"><i class="fa fa-file-excel-o"></i> Export</button>
                                                            </div>
                                                            <div class="table table-responsive" id="showEmpDivData">
                                                                <table class="table table-bordered table-responsive" style="text-align: center;width: 100%; height: auto" id="showEmpData" align="Center"  >
                                                                    <thead id="trHeaderList" style="text-align: center">
                                                                    </thead>
                                                                    <tbody id="trDataList" style="text-align: center">
                                                                    </tbody>
                                                                </table>
                                                            </div>
                                                        </div><!-- /.col -->
                                                        </div>
                                                        </section>
                                                        </div>
                                                        <%--</form:form>--%>


                                                        <script>
                                                            $(function () {
                                                                $("#submitButton").click(function () {
                                                                    var len = $(".checkbox1:checked").length;
                                                                    if (len > 1) {
                                                                        $(this).button("loading").delay(1000).queue(function () {
                                                                            $(this).button("reset");
                                                                            $(this).dequeue();
                                                                        });
                                                                        getEmployeeDetails();
                                                                    } else {
                                                                        $("#empH4").hide();
                                                                        $("#empExcelButton").hide();
                                                                        $("#trHeaderList").remove();
                                                                        $("#trDataList").remove();
                                                                        alert("Error: Please select more than 1 field.");
                                                                    }
                                                                });
                                                            });
                                                        </script>
                                                        
                                                        <script>
                                                            function getEmployeeDetails() {
                                                                $("#trHeaderList").remove();
                                                                $("#trDataList").remove();
                                                                $.ajax({
                                                                    type: "GET",
                                                                    dataType: "JSON",
                                                                    data: $("#myForm").serialize(),
                                                                    url: "homeController.htm?act=onSearchClick",
                                                                    success: function (content) {

                                                                        $("#empH4").show();
                                                                        $("#empExcelButton").show();

                                                                        var headData = content['headerList'];
                                                                        var rowData = content['employeeList'];

                                                                        var headingRow;

                                                                        for (var i = 0; i < headData.length; i++) {
                                                                            if (i === 0) {
                                                                                headingRow = '<thead id="trHeaderList"><tr><th>' + headData[i] + '</th>';
                                                                            } else {
                                                                                headingRow += '<th>' + headData[i] + '</th>';
                                                                            }
                                                                        }
                                                                        headingRow += "</tr></thead>";
                                                                        $("#showEmpData").append(headingRow);

                                                                        var DataRow = "<tbody id='trDataList'>";
                                                                        for (var i = 0; i < rowData.length; i++) {
//                                                                            if (i === 0) {
//                                                                                alert("in");
//                                                                                DataRow = "<tbody id='trDataList'>"<tr>";
//                                                                            } else {
                                                                            DataRow += "<tr>";
//                                                                            }
                                                                            var fullRowDataArray = rowData[i];
                                                                            for (var y = 0; y < fullRowDataArray.length; y++) {

                                                                                if (fullRowDataArray[y] === null || fullRowDataArray[y] === "") {
                                                                                    DataRow += '<td>-</td>';
                                                                                } else if (headData.length === 1) {
                                                                                    //for splitted string values of single column
                                                                                    DataRow += '<td>' + rowData[i] + '</td>';
                                                                                    break;
                                                                                } else {
                                                                                    DataRow += '<td>' + fullRowDataArray[y] + '</td>';
                                                                                }
                                                                            }
                                                                            DataRow += "</tr>";

                                                                        }
                                                                        DataRow += "</tbody>";
                                                                        $("#showEmpData").append(DataRow);
                                                                    },
                                                                    error: function (error) {
                                                                        alert("error : " + JSON.stringify(error));
                                                                    }
                                                                });
                                                            }
                                                        </script>
                                                        <script>
                                                            $(document).ready(function () {

                                                                $("#empExcelButton").hide();
                                                                $("#empH4").hide();
                                                                $("#employeeExitDiv").hide();

                                                                $('input[name=isFormerEmployee]').on('ifChecked', function (event) {
                                                                    if (this.value === "true") {
                                                                        $("#employeeExitDiv").show(400);
                                                                    } else {
                                                                        $("#employeeExitDiv").hide(400);
                                                                    }
                                                                });

                                                                $("#searchCategory").change(function () {
                                                                    $("#empH4").hide();
                                                                    $("#empExcelButton").hide();
                                                                    $("#trHeaderList").remove();
                                                                    $("#trDataList").remove();
                                                                    $(this).find("option:selected").each(function () {
                                                                        var optionValue = $(this).attr("value");
                                                                        if (optionValue) {
                                                                            $(".showBox").not("." + optionValue).hide();
                                                                            $("." + optionValue).show();
                                                                        } else {
                                                                            $(".showBox").hide();
                                                                        }
                                                                    });
                                                                }).change();

                                                            });
                                                        </script>
                                                        <script>
                                                            function getCategory(category) {
                                                                $.ajax({
                                                                    type: "GET",
                                                                    data: 'category=' + category,
                                                                    url: "homeController.htm?act=setSearchCriteriaData",
                                                                    success: function (content)
                                                                    {
                                                                        //to convert response in JSON
                                                                        var obj = JSON.parse(content);

                                                                        //for designation dropdownlist
                                                                        var count = Object.keys(obj['designationKey']).length;
                                                                        var data = null;
                                                                        //contains value
                                                                        var desigJSON = obj['designationKey'];
                                                                        //contains key
                                                                        var desigJSONKey = Object.keys(obj['designationKey']);

                                                                        for (var i = 0; i < count; i++) {
                                                                            if (i === 0) {
                                                                                data = "<option value=" + desigJSONKey[i] + ">" + desigJSON[desigJSONKey[i]] + "</option>";
                                                                            } else {
                                                                                data += "<option value=" + desigJSONKey[i] + ">" + desigJSON[desigJSONKey[i]] + "</option>";
                                                                            }
                                                                        }
                                                                        $(data).appendTo('#designationDropDown');


                                                                        //for department dropdown list
                                                                        var count1 = Object.keys(obj['departmentKey']).length;
                                                                        var data1 = null;
                                                                        //contains value
                                                                        var desigJSON1 = obj['departmentKey'];
                                                                        //contains key
                                                                        var desigJSONKey1 = Object.keys(obj['departmentKey']);

                                                                        for (var j = 0; j < count1; j++) {
                                                                            if (j === 0) {
                                                                                data1 = "<option value=" + desigJSONKey1[j] + ">" + desigJSON1[desigJSONKey1[j]] + "</option>";
                                                                            } else {
                                                                                data1 += "<option value=" + desigJSONKey1[j] + ">" + desigJSON1[desigJSONKey1[j]] + "</option>";
                                                                            }
                                                                        }
                                                                        $(data1).appendTo('#departmentDropDown');


                                                                        //for company dropdown list
                                                                        var count2 = Object.keys(obj['locationKey']).length;
                                                                        var data2 = null;
                                                                        //contains value
                                                                        var desigJSON2 = obj['locationKey'];
                                                                        //contains key
                                                                        var desigJSONKey2 = Object.keys(obj['locationKey']);

                                                                        for (var k = 0; k < count2; k++) {
                                                                            if (k > 0) {
                                                                                data2 += "<option value='" + desigJSONKey2[k] + "'>" + desigJSON2[desigJSONKey2[k]] + "</option>";
                                                                            } else {
                                                                                data2 = "<option value=" + desigJSONKey2[k] + ">" + desigJSON2[desigJSONKey2[k]] + "</option>";
                                                                            }
                                                                        }
                                                                        $(data2).appendTo('#locationDropDown');

                                                                    }
                                                                });
                                                            }
                                                        </script>

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
                                                                jQuery("#employeeMasterId").tokenInput(${list}, {
                                                                    preventDuplicates: true,
                                                                    noResultsText: "No Result",
                                                                    tokenLimit: "1",
                                                                    searchingText: "Searching ... .. .",
                                                                });
                                                            });
                                                        </script>


                                                        <script type="text/javascript">
                                                            function ExportToExcel() {
                                                                var htmltable = document.getElementById('showEmpData');
                                                                var html = htmltable.outerHTML;
                                                                window.open('data:application/vnd.ms-excel,' + encodeURIComponent(html));
                                                            }
                                                        </script>

                                                        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
                                                        </html>
