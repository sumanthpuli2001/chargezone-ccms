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

                                            <div class="box box-info collapsed-box ">
                                                <div class="box-header">
                                                    <h3 class="box-title">Man Power Requisition Detail:</h3>
                                                    <div class="box-tools pull-right">
                                                        <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onClick="buttonFun4()"><i class="fa fa-plus" id="minusId1"></i></button>
                                                    </div>
                                                </div>
                                                <div class="box-body">
                                                    <div class="row">
                                                        <div class="col-md-12 col-sm-12">
                                                            <div class="form-group">
                                                                <div class="col-sm-6">
                                                                    <label>MPR Name:</label> &nbsp;&nbsp;&nbsp;
                                                                    <span> ${vacancyName}</span>
                                                                </div>
                                                                <div class="col-sm-6">
                                                                    <label>MPR Budget:</label> &nbsp;&nbsp;&nbsp;
                                                                    <span> ${Mprbudget}</span>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <div class="col-sm-6">
                                                                    <label>Job Type:</label> &nbsp;&nbsp;&nbsp;
                                                                    <span>${jobtypeNAme1}</span>    
                                                                </div>
                                                                <div class="col-sm-6">
                                                                    <label>Job Role:</label>  &nbsp;&nbsp;&nbsp;
                                                                    <span >${designationName1}</span>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <div class="col-sm-6">
                                                                    <label>Location:</label>  &nbsp;&nbsp;&nbsp;
                                                                    <span >${locationName1}</span>
                                                                </div>
                                                                <div class="col-sm-6">
                                                                    <label>Department:</label> &nbsp;&nbsp;&nbsp;
                                                                    <span>${departmentName1}</span>   
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <div class="col-sm-6">
                                                                    <label>Number Of Position:</label> &nbsp;&nbsp;&nbsp;
                                                                    <span> ${numberOfPositionMpr}</span>
                                                                </div>
                                                                <div class="col-sm-6">
                                                                    <label>Work Experience(In Years): </label> &nbsp;&nbsp;&nbsp;
                                                                    <span>${MprExperience}</span>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <div class="col-sm-6">
                                                                    <label>Description:</label> &nbsp;&nbsp;&nbsp;
                                                                    <span> ${Mprdescription}</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="box box-info collapsed-box ">
                                                <div class="box-header">
                                                    <h3 class="box-title">Vacancy Detail:</h3>
                                                    <div class="box-tools pull-right">
                                                        <span id="spanId1">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onClick="buttonFun1()"><i class="fa fa-plus" id="minusId1"></i></button>
                                                    </div>
                                                </div>
                                                <div class="box-body">
                                                    <div class="row">
                                                        <div class="col-md-12 col-sm-12">
                                                            <div class="form-group">
                                                                <div class="col-sm-6">
                                                                    <label>Vacancy Name:</label> &nbsp;&nbsp;&nbsp;
                                                                    <span> ${vacancyName}</span>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <div class="col-sm-6">
                                                                    <label>Vacancy Created Date:</label> &nbsp;&nbsp;&nbsp;
                                                                    <span> ${fromDate}</span>
                                                                </div>
                                                                <div class="col-sm-6">
                                                                    <label>Vacancy End Date:</label> &nbsp;&nbsp;&nbsp;
                                                                    <span>${toDate}</span>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <div class="col-sm-6">
                                                                    <label>Location:</label> &nbsp;&nbsp;&nbsp;
                                                                    <span> ${locationName}</span>
                                                                </div>
                                                                <div class="col-sm-6">
                                                                    <label>Number Of Position:</label> &nbsp;&nbsp;&nbsp;
                                                                    <span>${position}</span>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <div class="col-sm-6">
                                                                    <label>Job Type:</label>  &nbsp;&nbsp;&nbsp;
                                                                    <span >${jobtypeNAme}</span>
                                                                </div>
                                                                <div class="col-sm-6">
                                                                    <label>Department:</label> &nbsp;&nbsp;&nbsp;
                                                                    <span>${departmentName}</span>    
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <div class="col-sm-6">
                                                                    <label>Job Role:</label>  &nbsp;&nbsp;&nbsp;
                                                                    <span >${designationName}</span>
                                                                </div>
                                                                <div class="col-sm-6">
                                                                    <label>Work Experience(In Years):</label> &nbsp;&nbsp;&nbsp;
                                                                    <span>${experiance}</span>   
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <div class="col-sm-6">
                                                                    <label>Description:</label> &nbsp;&nbsp;&nbsp;
                                                                    <span>${description}</span>
                                                                </div>
                                                                <div class="col-sm-6">
                                                                    <label>Number Of Position:</label> &nbsp;&nbsp;&nbsp;
                                                                    <span>${position}</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="box box-info collapsed-box ">
                                                <div class="box-header">
                                                    <h3 class="box-title">Candidate Detail:</h3>
                                                    <div class="box-tools pull-right">
                                                        <span id="spanId1">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onClick="buttonFun1()"><i class="fa fa-plus" id="minusId1"></i></button>
                                                    </div>
                                                </div>
                                                <div class="box-body">
                                                    <div class="row">
                                                        <div class="col-md-12 col-sm-12">
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
                                                                    <label>Photograph:</label> &nbsp;&nbsp;&nbsp;
                                                                    <span><img src="StorageYard/candidateimage/${candidateApplyJob.photograph}" width="50px; !important" height="50px; !important">&nbsp;&nbsp;${candidateApplyJob.photograph}</span>
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
                                                                    <label>City:</label> &nbsp;&nbsp;&nbsp;
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
                                                                    <label>Experience Date Joining Year:</label> &nbsp;&nbsp;&nbsp;
                                                                    <span>${candidateApplyJob.experianceDateJoiningYear}</span>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <div class="col-sm-6">
                                                                    <label>Experience Date Joining Month:</label> &nbsp;&nbsp;&nbsp;
                                                                    <span>${candidateApplyJob.experianceDateJoiningMonth}</span>
                                                                </div>
                                                                <div class="col-sm-6">
                                                                    <label>Resume Attach:</label> &nbsp;&nbsp;&nbsp;
                                                                    <span data="StorageYard/CertificateAttach/${candidateApplyJob.certificateAttach}" type="application/pdf" width="500" height="300">
                                                                        <a href="StorageYard/CertificateAttach/${candidateApplyJob.certificateAttach}">${candidateApplyJob.certificateAttach}</a>
                                                                    </span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-md-12" style="text-align: right">
                                                    <c:if test="${candidateJobApplication.status eq 1}">
                                                        <button type="button" class="btn btn-danger" onclick="return reject(${candidateJobApplication.id},${candidateApplyJob.id});" value="Reject">Reject</button>
                                                    </c:if>
                                                    <c:if test="${candidateJobApplication.status eq 1}">
                                                        <button type="button" class="btn btn-primary" onclick="shortlisted(${candidateJobApplication.id},${candidateApplyJob.id});">Shortlist</button>
                                                    </c:if>
                                                    <c:if test="${candidateJobApplication.status eq 11}">
                                                        <button type="button" class="btn btn-primary" onclick="induction(${candidateJobApplication.id},${candidateApplyJob.id});">&nbsp; Induction</button>
                                                    </c:if>
                                                    <c:if
                                                        test="${candidateJobApplication.status eq 2}">
                                                        <button type="button" class="btn btn-default" onclick="sendToF2F(${candidateJobApplication.id},${candidateApplyJob.id});">&nbsp; F To F Interview</button>
                                                    </c:if>    
                                                    <c:if
                                                        test="${candidateJobApplication.status eq 6}">
                                                        <button type="button" class="btn btn-default" onclick="sendToF2F(${candidateJobApplication.id},${candidateApplyJob.id});">&nbsp; F To F Interview</button>
                                                    </c:if>    
                                                    <c:if test="${candidateJobApplication.status eq 2}">
                                                        <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModalOnline">Online Assessment</button>
                                                    </c:if>
                                                    <c:if test="${candidateJobApplication.status eq 4}">
                                                        <button type="button" class="btn btn-default" id="btnType1" onclick="goToAns(${candidateJobApplication.id},${candidateApplyJob.id})" name="btnType" value="AssessMent"  >Check Assessment</button>
                                                    </c:if>
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
                        <h4 class="modal-title">Online Assessment</h4>
                    </div>
                    <form:form class="form-horizontal" method="post" commandName="onlineAssessment" action="onlineAssessment.htm?act=submitAssessment"
                               onsubmit='return checkBoxCheck();'>
                        <section class="content">
                            <!--<div class="col-md-12">-->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-4">
                                                        <form:input path="id" id="id" class="form-control" type="hidden"></form:input>
                                                        <input type="hidden" value="${candidateJobApplication.id}" name="candidateJobApplicationId"/>
                                                        <label>Question Paper Name :<span style="color: red;font-size: 12px;"></span></label>

                                                        <select name="questions" class="form-control" id="questions" onchange="getTotalMarksAndNoOfQue(this);" required="true">
                                                            <option value="">--Select--</option>
                                                            <c:forEach items="${questions}" var="questions">
                                                                <option value="${questions.key}">${questions.value}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <label>Passing Percentage : <span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="passingPercentage" id="passingPercentage" class="form-control" placeholder="Enter Passing Percentage" 
                                                                    required="true" onkeypress="return isNumberKey(event)"></form:input>
                                                        <form:errors path="passingPercentage" cssClass="errorDiv"></form:errors>

                                                        </div>
                                                        <div class="col-sm-4">
                                                            <label>Duration (In Minutes):<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="duration" id="duration" class="form-control" placeholder="Enter Duration" required="true"
                                                                    onkeypress="return isNumberKey(event)"></form:input>
                                                        <form:errors path="duration" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-4">
                                                        <%--<form:input path="id" id="id" class="form-control" type="hidden"></form:input>--%>

                                                        <label>Validity From :<span style="color: red;font-size: 12px;"></span></label>
                                                        <input type="text" id="datetimepicker2" class="form-control" placeholder="Please select From Date" name="validityFrom" readonly="true" required="true"/>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <%--<form:input path="id" id="id" class="form-control" type="hidden"></form:input>--%>

                                                        <label>Validity To :<span style="color: red;font-size: 12px;"></span></label>
                                                        <input type="text" id="datetimepicker1" class="form-control" name="validityTo" placeholder="Please select To Date" readonly="true" required="true"/>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <label>Number Of Attempts :<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="noOfAttampt" id="noOfAttampt" class="form-control" placeholder="Enter Number Of Attempt" required="true"
                                                                    onkeypress="return isNumberKey(event)"></form:input>
                                                        <form:errors path="noOfAttampt" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-4">
                                                        <%--<form:input path="id" id="id" class="form-control" type="hidden"></form:input>--%>

                                                        <label>Number of Questions :<span style="color: red;font-size: 12px;" ></span></label>
                                                        <label id="test" name="test"></label>
                                                        <input type="hidden" id="NoOfQue" name="NoOfQue" >
                                                    </div>
                                                    <div class="col-sm-4">

                                                        <label>Total Marks :<span style="color: red;font-size: 12px;"></span></label>
                                                        <label id="test2" name="test2"></label>
                                                        <input type="hidden" id="totalMarks" name="totalMarks" >

                                                    </div>


                                                </div>

                                            </div>



                                            <!--<div class="row">-->
                                            <div class="form-group">
                                                <div class=" col-sm-5 col-sm-offset-5">
                                                    <button type="submit" class="btn btn-primary" data-original-title="" title="" >Submit</button>
                                                </div>
                                            </div>
                                            <div style="float: right;">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--</div>-->
                            <!--</div>-->

                        </section>
                    </form:form>
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
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"/>
    <script>
        function buttonFun1() {
            var className = $('#minusId1').attr('class');
            if (className == 'fa fa-plus') {
                document.getElementById('spanId1').innerHTML = 'Minimize';
            } else {
                document.getElementById('spanId1').innerHTML = 'Expand';
            }
        }
        function buttonFun2() {
            var className = $('#minusId2').attr('class');
            if (className == 'fa fa-plus') {
                document.getElementById('spanId2').innerHTML = 'Minimize';
            } else {
                document.getElementById('spanId2').innerHTML = 'Expand';
            }
        }
        function buttonFun3() {
            var className = $('#minusId3').attr('class');
            if (className == 'fa fa-plus') {
                document.getElementById('spanId3').innerHTML = 'Minimize';
            } else {
                document.getElementById('spanId3').innerHTML = 'Expand';
            }
        }
        function buttonFun4() {
            var className = $('#minusId4').attr('class');
            if (className == 'fa fa-plus') {
                document.getElementById('spanId4').innerHTML = 'Minimize';
            } else {
                document.getElementById('spanId4').innerHTML = 'Expand';
            }
        }
    </script>

</html>
<script>
    $(document).ready(function () {
        $('#datetimepicker1').datepicker({
        });
    });
</script>
<script>
    $(document).ready(function () {
        $('#datetimepicker2').datepicker({
        });
    });
</script>
<script>

    function getTotalMarksAndNoOfQue(id) {

        try {

            $.ajax({
                type: "POST",
                url: "onlineAssessment.htm?act=getTotalMarksAndNoOfQue&id=" + id.value,
                data: {},
                dataType: "json",
                success: function (responseTxt) {
                    //                    document.getElementById("name").value = JSON.stringify(responseTxt.check);
                    //                    document.getElementById("email").value = JSON.stringify(responseTxt.val2);
                    //                    document.getElementById("name").value = responseTxt
                    var v1 = JSON.stringify(responseTxt.check);
                    var v2 = JSON.stringify(responseTxt.val2);
                    //                    $('#test2').html(responseTxt.check).modal('show');
                    //                    $('#test').html(responseTxt.val2).modal('show');
                    document.getElementById("test2").innerHTML = responseTxt.check;
                    document.getElementById("test").innerHTML = responseTxt.val2;

                    document.getElementById("NoOfQue").value = responseTxt.val2;
                    document.getElementById("totalMarks").value = responseTxt.check;
                    //                    $('#NoOfQue').val(v1);
                    //                    $('#totalMarks').val(v2);
                    //                    alert(JSON.stringify(responseTxt.check));

                    //                    document.getElementById("").innerHTML = responseTxt;
                    if (responseTxt != '') {
                        document.getElementById("").value = "";


                    }
                },
                error: function () {

                }
            });



        } catch (e) {

        }


    }

</script>
<script>
    function goToAns(applicationId, candidateId) {
        window.location = 'onlineAssessment.htm?act=goToAns&id=' + applicationId + '&candidateId=' + candidateId;
    }
</script>
<script>
    function sendToF2F(applicationId, candidateId) {
        window.location = 'candidateF2FRequest.htm?act=createCandidateF2FInvitation&id=' + applicationId + '&candidateId=' + candidateId;
    }
</script>
<script>
    function induction(applicationId, candidateId) {
        window.location = 'employeeMaster.htm?act=inductionCreateClick&id=' + applicationId + '&candidateId=' + candidateId;
    }
</script>
<script>
    function shortlisted(applicationId, candidateId) {
        window.location = 'candidateF2FRequest.htm?act=CandidateShortlisted&id=' + applicationId + '&candidateId=' + candidateId;
    }
</script>
<script>
    function reject(applicationId, candidateId) {
        var checkreject = confirm("If You Reject You Can Not Edit,Submit Or View. So, Are You Sure You Want to Reject This Candidate?");
        if (checkreject) {
            checkreject = document.getElementsByName('Reject');
            window.location = 'candidateF2FRequest.htm?act=reject&id=' + applicationId + '&candidateId=' + candidateId;
            return true;
        }
        return false;
    }
</script>
<script>
    function isNumberKey(evt)
    {
        var charCode = (evt.which) ? evt.which : event.keyCode
        if (charCode != 46 && charCode > 31
                && (charCode < 48 || charCode > 57))
            return false;

        return true;
    }
</script>

