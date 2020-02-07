<%-- 
    Document   : VendorRegistrationForm
    Created on : Feb 5, 2020, 3:32:03 PM
    Author     : admin
--%>
<script>
    function myFunction(); {

    }
</script>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%--<%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>--%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendor Registration Form</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Vendor Registration Form</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>

            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <form:form class="form-horizontal" method="post" commandName="vendors" action="payment.html?act=createSubmit1">
                                    <%--<form:form class="form-horizontal" role="form" action="employeeMaster.htm?act=createSubmit" commandName="employeeMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>--%>
                                    <c:if test="${!empty failureMessage}">
                                        <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}
                                            <br/><form:errors path="*" cssClass="errorDiv"></form:errors>

                                            <%--<form:errors path="failureMessageExtension" cssClass="errorDiv"></form:errors>
                                        
                                            <input type="text" name="firstName" value="${list.firstName}" id="firstName">
                                            --%>    

                                            <font class="errorDiv" color="#dd4b39"> ${failureMessageExtension} </font>
                                        </div>
                                    </c:if>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Enter Vendor Code:<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-7">
                                            <!--<input type="text" name="vendorId" class="form-control" placeholder="Enter Vendor Code" maxlength="30"/>-->
                                            <form:input path="vendorId" class="form-control"  placeholder="Enter Vendor Code" ></form:input>
                                            <form:errors path="vendorId" cssClass="errorDiv"></form:errors>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-3">
                                                <label class="control-label">Enter Vendor Name:<span style="color: red;font-size: 12px;">*</span></label>
                                            </div>
                                            <div class="col-sm-7">
                                                <!--<input type="text" name="vendor" class="form-control" placeholder="Enter Name of Vendor" maxlength="30"/>-->
                                            <form:input path="vendor" class="form-control"  placeholder="Enter Vendor Name" ></form:input>
                                            <form:errors path="vendor" cssClass="errorDiv"></form:errors>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-3">
                                                <label class="control-label">Enter GST No:<span style="color: red;font-size: 12px;">*</span></label>
                                            </div>
                                            <div class="col-sm-7">
                                                <!--<input type="text" name="gstNo" class="form-control" placeholder="Enter GST No" maxlength="30"/>-->
                                            <form:input path="gstNo" class="form-control"  placeholder="Enter GST NO " ></form:input>
                                            <form:errors path="gstNo" cssClass="errorDiv"></form:errors>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-3">
                                                <label class="control-label">Enter PAN No:<span style="color: red;font-size: 12px;">*</span></label>
                                            </div>
                                            <div class="col-sm-7">
                                                <!--<input type="text" name="panNo" class="form-control" placeholder="Enter Pan No" maxlength="30"/>-->
                                            <form:input path="panNo" class="form-control"  style="text-transform: uppercase" placeholder="(1-5: alphabets, 6-9: digits, 10th: alphabet) Example: ASDFG4567A" ></form:input>
                                            <form:errors path="panNo" cssClass="errorDiv"></form:errors>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-3">
                                                <label class="control-label">Enter Email Id:<span style="color: red;font-size: 12px;">*</span></label>
                                            </div>
                                            <div class="col-sm-7">
                                                <!--<input type="text" name="emailId" class="form-control" placeholder="Enter Email Id" maxlength="30"/>-->
                                            <form:input path="emailId" class="form-control" pattern="[^ @]*@[^ @]*"  placeholder="abc@domain.com" ></form:input>
                                            <form:errors path="emailId" cssClass="errorDiv"></form:errors>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-3">
                                                <label class="control-label">Enter Phone Number:<span style="color: red;font-size: 12px;">*</span></label>
                                            </div>
                                            <div class="col-sm-7">
                                                <!--<input type="text" name="phoneNo" class="form-control" placeholder="Enter Phone Number" maxlength="30"/>-->
                                            <form:input path="phoneNo" class="form-control"  placeholder="Enter Phone No" ></form:input>
                                            <form:errors path="phoneNo" cssClass="errorDiv"></form:errors>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-3">
                                                <label class="control-label">Enter Mobile Number:<span style="color: red;font-size: 12px;">*</span></label>
                                            </div>
                                            <div class="col-sm-7">
                                                <!--<input type="text" name="mobileNo"  class="form-control" placeholder="Enter Mobile Number" maxlength="30"/>-->
                                            <form:input path="mobileNo" class="form-control"  placeholder="Enter Mobile No" ></form:input>
                                            <form:errors path="mobileNo" cssClass="errorDiv"></form:errors>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-3">
                                                <label class="control-label">Enter Address:<span style="color: red;font-size: 12px;">*</span></label>
                                            </div>
                                            <div class="col-sm-7">
                                                <!--<input type="text" name="address" class="form-control" placeholder="Enter Address" maxlength="30"/>-->
                                            <form:input path="address" class="form-control"  placeholder="Enter Address" ></form:input>
                                            <form:errors path="address" cssClass="errorDiv"></form:errors>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-6 col-sm-offset-5">
                                                <input type="submit" class="btn btn-primary" style="width: 100px;" onclick="myFunction()" title="" value="SUBMIT">
                                            </div>
                                            <!--                                        <div class=" col-sm-offset-2 col-sm-3 ">
                                                                                        <button type="button" class="btn btn-danger" data-original-title="" title="" onclick="window.location = 'departmentMaster.htm?act=showList'">Cancel</button>
                                                                                    </div>-->
                                        </div>
                                </form:form>

                                <%-- <form action = "payment.html?act=createSubmit" method = "POST">
                                    <!-- <input type="hidden" name = "id" value="${id}">-->
                                     <div class="form-group">
                                         <div class="col-sm-3">
                                             <label class="control-label">Enter Payment Type:<span style="color: red;font-size: 12px;">*</span></label>
                                         </div>
                                         <div class="col-sm-7">
                                             <input type="text" name = "payment_Type">
                                         </div>
                                     </div>
                                     <!--<br />
                                     Last Name: <input type = "text" name = "last_name" />-->
                                     <input type = "submit" value = "Submit" />
                                  </form>--%>

                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

</html>
