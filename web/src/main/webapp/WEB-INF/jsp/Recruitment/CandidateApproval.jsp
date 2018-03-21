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
                                                    <label>Certificate Attach:</label> &nbsp;&nbsp;&nbsp;
                                                    <span>${candidateApplyJob.certificateAttach}</span>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-md-12" style="text-align: right">
                                                    <%--<c:if test="${status != 1}">--%>
                                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">&nbsp; F To F</button>
                                                    <c:if test="${candidateJobApplication.status eq 2}">

                                                        <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModalOnline">Online Assessment</button>
                                                    </c:if>
                                                    <c:if test="${candidateJobApplication.status eq 5}">
                                                        <button type="button" class="btn btn-primary" id="btnType1" onclick="goToAns(${candidateJobApplication.id},${candidateApplyJob.id})" name="btnType" value="AssessMent" style="width: 100px" >Ans</button>
                                                    </c:if>
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

                                                        <select name="questions" class="form-control" id="questions" onchange="getTotalMarksAndNoOfQue(this);">
                                                            <option value="">--Select--</option>
                                                            <c:forEach items="${questions}" var="questions">
                                                                <option value="${questions.key}">${questions.value}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <label>Passing Percentage : <span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="passingPercentage" id="passingPercentage" class="form-control" placeholder="Enter Passing Percentage"></form:input>
                                                        <form:errors path="passingPercentage" cssClass="errorDiv"></form:errors>

                                                        </div>
                                                        <div class="col-sm-4">
                                                            <label>Duration (In Minutes):<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="duration" id="duration" class="form-control" placeholder="Enter Duration"></form:input>
                                                        <form:errors path="duration" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-4">
                                                        <%--<form:input path="id" id="id" class="form-control" type="hidden"></form:input>--%>

                                                        <label>Validity From :<span style="color: red;font-size: 12px;"></span></label>
                                                        <input type="text" id="datetimepicker2" class="form-control" placeholder="Please select From Date" name="validityFrom" readonly="true"/>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <%--<form:input path="id" id="id" class="form-control" type="hidden"></form:input>--%>

                                                        <label>Validity To :<span style="color: red;font-size: 12px;"></span></label>
                                                        <input type="text" id="datetimepicker1" class="form-control" name="validityTo" placeholder="Please select To Date" readonly="true"/>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <label>Number Of Attempts :<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="noOfAttampt" id="noOfAttampt" class="form-control" placeholder="Enter Number Of Attempt"></form:input>
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
                    $('#test2').html(responseTxt.check).modal('show');
                    $('#test').html(responseTxt.val2).modal('show');

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
