<%-- 
    Document   : PaymentTypeMasterCreate
    Created on : Jan 31, 2020, 1:36:39 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%--<%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>--%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment Type Create</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Payment Type Master Form</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Add New Payment Type Master Form</li>
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
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                              <form:form class="form-horizontal" method="post"
                                           modelAttribute="employeeTypeMaster" action="payment.html?act=createPaymentTypeMasterSubmit">
                                    <form:hidden path="id"></form:hidden>
                                        
                                        <div class="form-group">
                                            <div class="col-sm-3">
                                                <label class="control-label">Select Type of Payment:<span style="color: red;font-size: 12px;">*</span></label>
                                            </div>
                                           
                                            <div class="col-sm-7">
                                                <select name="typeOfPayment" id="typeOfPayment" class="form-control">
                                                    <option value="">-- Select --</option>
                                                    <c:forEach var="shift1" items="${paymentTypeMap}">
                                                        <%--<c:if test="${shift1.key eq employeeMaster.shiftHoursId}">
                                                            <option value="${shift1.key}" selected="">${shift1.value}</option>
                                                        </c:if>
                                                        <c:if test="${shift1.key ne employeeMaster.shiftHoursId}">
                                                            --%><option value="${shift1.key}" >${shift1.value}</option>

                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                            
                                        <div class="form-group">
                                            <div class="col-sm-3">
                                                <label class="control-label">Enter Party Code:<span style="color: red;font-size: 12px;">*</span></label>
                                            </div>
                                            <div class="col-sm-7">
                                                <form:input path="partyCode" class="form-control"  placeholder="Enter Party Code"  maxlength="30"/>
                                                <form:errors path="partyCode" cssClass="errorDiv"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-3">
                                                <label class="control-label">Enter Name of Party: <span style="color: red;font-size: 12px;">*</span></label>
                                            </div>
                                            <div class="col-sm-7">
                                                <form:input path="nameOfParty" class="form-control"  placeholder="Enter Name of Party"  maxlength="30"/>
                                                <form:errors path="nameOfParty" cssClass="errorDiv"/>
                                            </div>
                                        </div>
                                            <div class="form-group">
                                            <div class="col-sm-3">
                                                <label class="control-label">Enter GST No:<span style="color: red;font-size: 12px;">*</span></label>
                                            </div>
                                            <div class="col-sm-7">
                                                <form:input path="gstNo" class="form-control"  placeholder="Enter GST No"  maxlength="30"/>
                                                <form:errors path="gstNo" cssClass="errorDiv"/>
                                            </div>
                                        </div>
                                            <div class="form-group">
                                            <div class="col-sm-3">
                                                <label class="control-label">Enter PAN No:<span style="color: red;font-size: 12px;">*</span></label>
                                            </div>
                                            <div class="col-sm-7">
                                                <form:input path="panNo" class="form-control"  placeholder="Enter Pan No"  maxlength="30"/>
                                                <form:errors path="panNo" cssClass="errorDiv"/>
                                            </div>
                                        </div>
                                            <div class="form-group">
                                            <div class="col-sm-3">
                                                <label class="control-label">Enter Email Id:<span style="color: red;font-size: 12px;">*</span></label>
                                            </div>
                                            <div class="col-sm-7">
                                                <form:input path="emailId" class="form-control"  placeholder="Enter Email Id"  maxlength="30"/>
                                                <form:errors path="emailId" cssClass="errorDiv"/>
                                            </div>
                                        </div>
                                            <div class="form-group">
                                            <div class="col-sm-3">
                                                <label class="control-label">Enter Phone Number:<span style="color: red;font-size: 12px;">*</span></label>
                                            </div>
                                            <div class="col-sm-7">
                                                <form:input path="phoneNo" class="form-control"  placeholder="Enter Phone Number"  maxlength="30"/>
                                                <form:errors path="phoneNo" cssClass="errorDiv"/>
                                            </div>
                                        </div>
                                            <div class="form-group">
                                            <div class="col-sm-3">
                                                <label class="control-label">Enter Mobile Number:<span style="color: red;font-size: 12px;">*</span></label>
                                            </div>
                                            <div class="col-sm-7">
                                                <form:input path="mobileNo" class="form-control"  placeholder="Enter Mobile Number"  maxlength="30"/>
                                                <form:errors path="mobileNo" cssClass="errorDiv"/>
                                            </div>
                                        </div>
                                            <div class="form-group">
                                            <div class="col-sm-3">
                                                <label class="control-label">Enter Address:<span style="color: red;font-size: 12px;">*</span></label>
                                            </div>
                                            <div class="col-sm-7">
                                                <form:input path="address" class="form-control"  placeholder="Enter Address"  maxlength="30"/>
                                                <form:errors path="address" cssClass="errorDiv"/>
                                            </div>
                                        </div>
                                            
                                            
                                        <div class="form-group">
                                            <div class="col-sm-3">
                                                <label class="control-label">Select Location:<span style="color: red;font-size: 12px;">*</span></label>
                                            </div> 
                                            
                                            <div class="col-sm-7">
                                            <select name="location" id="location" class="form-control">
                                                <option value="">-- Select --</option>
                                                <c:forEach var="shift1" items="${locationTypeMap}">
                                                    <%--<c:if test="${shift1.key eq employeeMaster.shiftHoursId}">
                                                        <option value="${shift1.key}" selected="">${shift1.value}</option>
                                                    </c:if>
                                                    <c:if test="${shift1.key ne employeeMaster.shiftHoursId}">
                                                        --%><option value="${shift1.key}" >${shift1.value}</option>
                                                    
                                                </c:forEach>
                                            </select>
                                            </div>
                                        </div>
                                            
                                        <div class="form-group">
                                            <div class="col-sm-3">
                                                <label class="control-label">Enter Payment amount:<span style="color: red;font-size: 12px;">*</span></label>
                                            </div>
                                            <div class="col-sm-7">
                                                <form:input path="paymentAmount" class="form-control"  placeholder="Enter Payment amount"  maxlength="30"/>
                                                <form:errors path="paymentAmount" cssClass="errorDiv"/>
                                            </div>
                                        </div>
                                            <div class="form-group">
                                            <div class="col-sm-3">
                                                <label class="control-label">Enter Additional remarks:<span style="color: red;font-size: 12px;">*</span></label>
                                            </div>
                                            <div class="col-sm-7">
                                                <form:input path="additionalRemarks" class="form-control"  placeholder="Enter Additional remarks"  maxlength="30"/>
                                                <form:errors path="additionalRemarks" cssClass="errorDiv"/>
                                            </div>
                                        </div>
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="NEXT">
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