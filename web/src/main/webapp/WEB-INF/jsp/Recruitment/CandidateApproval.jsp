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
                                                    <label>Candidate Name:</label> &nbsp;&nbsp;&nbsp;
                                                    <span>${candidateApplyJob.name}</span>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Candidate D.O.B:</label> &nbsp;&nbsp;&nbsp;
                                                   <span>${candidateApplyJob.dob}</span>
                                                    </div>

                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Father Name:</label> &nbsp;&nbsp;&nbsp;
                                                   <span>${candidateApplyJob.fatherName}</span>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Father D.O.B:</label> &nbsp;&nbsp;&nbsp;
                                                  <span>${candidateApplyJob.fatherDob}</span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Mother Name:</label> &nbsp;&nbsp;&nbsp;
                                                   <span>${candidateApplyJob.motherName}</span>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Mother D.O.B:</label> &nbsp;&nbsp;&nbsp;
                                                  <span>${candidateApplyJob.motherDob}</span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Sex:</label> &nbsp;&nbsp;&nbsp;
                                                <span>${candidateApplyJob.sex}</span>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>photograph:</label> &nbsp;&nbsp;&nbsp;
                                                  <span>${candidateApplyJob.photograph}</span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Present Address:</label> &nbsp;&nbsp;&nbsp;
                                              <span>${candidateApplyJob.presentAddress}</span>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Permanent Address:</label> &nbsp;&nbsp;&nbsp;
                                                <span>${candidateApplyJob.permanentAddress}</span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>city:</label> &nbsp;&nbsp;&nbsp;
                                               <span>${candidateApplyJob.city}</span>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Blood Group:</label> &nbsp;&nbsp;&nbsp;
                                              <span>${candidateApplyJob.bloodGroup}</span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Email Id:</label> &nbsp;&nbsp;&nbsp;
                                               <span>${candidateApplyJob.emailId}</span>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>contact No:</label> &nbsp;&nbsp;&nbsp;
                                               <span>${candidateApplyJob.contactNo}</span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Emergency Contact Person:</label> &nbsp;&nbsp;&nbsp;
                                            <span>${candidateApplyJob.emergencyContactPerson}</span>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Emergency Contact No:</label> &nbsp;&nbsp;&nbsp;
                                          <span>${candidateApplyJob.emergencyContactNo}</span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Highest Education Qualification:</label> &nbsp;&nbsp;&nbsp;
                                              <span>${candidateApplyJob.highestEducationQualification}</span>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Experiance Date Joining Year:</label> &nbsp;&nbsp;&nbsp;
                                              <span>${candidateApplyJob.experianceDateJoiningYear}</span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Experiance Date Joining Month:</label> &nbsp;&nbsp;&nbsp;
                                          <span>${candidateApplyJob.experianceDateJoiningMonth}</span>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Certificate Attach:</label> &nbsp;&nbsp;&nbsp;
                                              <span>${candidateApplyJob.certificateAttach}</span>
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
