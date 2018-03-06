<%-- 
    Document   : CandidateApproval
    Created on : 26 Feb, 2018, 9:41:01 AM
    Author     : Vikas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Candidate Approval Assessment</title>
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Candidate Approval Assessment</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Approval Assessment</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="box-header">
                            </div>
                            <div class="box-body no-padding">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12">
                                        <div class="table table-bordered">
                                        </div>
                                        <!--<div class="form-group">-->


                                        <form:form class="form-horizontal" method="post"
                                                   commandName="candidateApplyJob" action="recruitment.htm?act=assessmentClick">
                                            <input type="hidden" id="empreqid" name="empreqid" value="${mprMaster.id}">



                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Candidate Name:</label>
                                                    <form:input path="name" class="form-control" placeholder="Name" readonly="true"></form:input>
                                                    <form:errors path="name" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Candidate D.O.B:</label>
                                                    <form:input path="dob" class="form-control" placeholder="Description" readonly="true"></form:input>
                                                    <form:errors path="dob" cssClass="errorDiv"></form:errors>
                                                    </div>

                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Father Name:</label>
                                                    <form:input path="fatherName" class="form-control" placeholder="Description" readonly="true"></form:input>
                                                    <form:errors path="fatherName" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Father D.O.B:</label>
                                                    <form:input path="fatherDob" class="form-control" placeholder="Description" readonly="true"></form:input>
                                                    <form:errors path="fatherDob" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Mother Name:</label>
                                                    <form:input path="motherName" class="form-control" placeholder="Number Of Position" readonly="true"></form:input>
                                                    <form:errors path="motherName" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Mother D.O.B:</label>
                                                    <form:input path="motherDob" class="form-control" placeholder="Experience" readonly="true"></form:input>
                                                    <form:errors path="motherDob" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Sex:</label>
                                                    <form:input path="sex" class="form-control" placeholder="Description" readonly="true"></form:input>
                                                    <form:errors path="sex" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>photograph:</label>
                                                    <form:input path="photograph" class="form-control" placeholder="Description" readonly="true"></form:input>
                                                    <form:errors path="photograph" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Present Address:</label>
                                                    <form:input path="presentAddress" class="form-control" placeholder="Description" readonly="true"></form:input>
                                                    <form:errors path="presentAddress" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Permanent Address:</label>
                                                    <form:input path="permanentAddress" class="form-control" placeholder="Description" readonly="true"></form:input>
                                                    <form:errors path="permanentAddress" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>city:</label>
                                                    <form:input path="city" class="form-control" placeholder="Description" readonly="true"></form:input>
                                                    <form:errors path="city" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Blood Group:</label>
                                                    <form:input path="bloodGroup" class="form-control" placeholder="Description" readonly="true"></form:input>
                                                    <form:errors path="bloodGroup" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Email Id:</label>
                                                    <form:input path="emailId" class="form-control" placeholder="Description" readonly="true"></form:input>
                                                    <form:errors path="emailId" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>contact No:</label>
                                                    <form:input path="contactNo" class="form-control" placeholder="Description" readonly="true"></form:input>
                                                    <form:errors path="contactNo" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Emergency Contact Person:</label>
                                                    <form:input path="emergencyContactPerson" class="form-control" placeholder="Description" readonly="true"></form:input>
                                                    <form:errors path="emergencyContactPerson" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Emergency Contact No:</label>
                                                    <form:input path="emergencyContactNo" class="form-control" placeholder="Description" readonly="true"></form:input>
                                                    <form:errors path="emergencyContactNo" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Highest Education Qualification:</label>
                                                    <form:input path="highestEducationQualification" class="form-control" placeholder="Description" readonly="true"></form:input>
                                                    <form:errors path="highestEducationQualification" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Experiance Date Joining Year:</label>
                                                    <form:input path="experianceDateJoiningYear" class="form-control" placeholder="Description" readonly="true"></form:input>
                                                    <form:errors path="experianceDateJoiningYear" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Experiance Date Joining Month:</label>
                                                    <form:input path="experianceDateJoiningMonth" class="form-control" placeholder="Description" readonly="true"></form:input>
                                                    <form:errors path="experianceDateJoiningMonth" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Certificate Attach:</label>
                                                    <form:input path="certificateAttach" class="form-control" placeholder="Description" readonly="true"></form:input>
                                                    <form:errors path="certificateAttach" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-md-12" style="text-align: right">
                                                    <%--<c:if test="${status != 1}">--%>
                                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">&nbsp; F To F</button>
                                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModalOnline">&nbsp; online</button>
                                                    <button type="submit" class="btn btn-success" id="btnType1" name="btnType" value="AssessMent" style="width: 100px" >assessment</button>
                                                    <%--</c:if>--%>
                                                </div>


                                            </div>
                                        </form:form>
                                        <!--</div>-->

                                    </div><!-- /.col -->
                                </div><!-- /.row -->
                            </div>
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section>
    </div>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    
        <div class="container">
        <div class="modal fade" id="myModalOnline" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Online</h4>
                    </div>
                    <div class="modal-body">
                        <p>Online Assessment</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- FACE TO FACE FORE MODAL -->
    <div class="container">
        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Face To Face</h4>
                    </div>
                    <div class="modal-body">
                        <p>Face To Face Assessment</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
</html>
