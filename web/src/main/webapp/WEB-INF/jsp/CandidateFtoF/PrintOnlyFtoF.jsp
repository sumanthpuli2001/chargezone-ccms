<%-- 
    Document   : PrintOnlyFtoF
    Created on : 22 Aug, 2018, 6:09:18 PM
    Author     : Dell-1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>FACE TO FACE INVITATION APPROVAL</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">F2F Invitation</li>
            </ol>
        </section>
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                                <form:form class="form-horizontal" method="post"
                                           commandName="candidateF2FRequest" action="candidateF2FApproval.htm?act=SubmitFtoFByHr" onsubmit="return saveSubmit()" >
                                    <input type="hidden" id="applicationId" name="applicationId" value="${applicationId}">   
                                    <div class="box box-info collapsed-box ">
                                        <div class="box-header">
                                            <h3 class="box-title">Candidate F2F Observations :</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onClick="buttonFun3()"><i class="fa fa-plus" id="minusId3"></i></button>
                                            </div>
                                        </div>
                                        <div class="box-body">
                                            <div class="row">
                                                <div class="box-header" style="text-align: right;">
                                                    <button class="btn btn-facebook "  style="width: 100px;" onclick="printDivtwo('printableAreatwo')">Print &nbsp;<span><i class="fa fa-print"></i></span></button>
                                                </div>
                                                <div id="printableAreatwo">
                                                    <div class="col-md-12 col-sm-12">
                                                        <div class="box-header" style="text-align: right;">
                                                            <span><img src="StorageYard/Images/logo.png"  style="text-align: right;"/></span>
                                                        </div>
                                                        <div class="box-body no-padding">
                                                            <div class="col-sm-6">
                                                                <label>Position:</label> &nbsp;&nbsp;&nbsp;
                                                                <span>${candidateF2FRequest.vacancyMaster.name}</span>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <label>Date Of Interview  :</label> &nbsp;&nbsp;&nbsp;
                                                                <span>${candidateF2FRequest.dateOfInterview}</span>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">

                                                            <div class="col-sm-6">
                                                                <label>Name of the candidate:</label> &nbsp;&nbsp;&nbsp;
                                                                <span>${candidateF2FRequest.candidateApplyJob.name}</span>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <label>Venue :</label> &nbsp;&nbsp;&nbsp;
                                                                <span>${candidateF2FRequest.location}</span>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <table>
                                                                <tr>
                                                                    <td><label>&nbsp;&nbsp;&nbsp;&nbsp; Interview Panel Member:</label></td>
                                                                    <td>
                                                                <c:forEach  var="test" items="${comitteeList}">

                                                                    &nbsp;&nbsp;&nbsp; &nbsp;<span>${test.employeeMaster.employeeName}</span>
                                                                    <br>
                                                                </c:forEach>
                                                                </td>
                                                                </tr>
                                                            </table>

                                                        </div>
                                                        <div class="form-group">

                                                            <div class="col-sm-6">
                                                                <label>Interview Evaluation &nbsp;&nbsp;-:-</label> &nbsp;&nbsp;&nbsp;
                                                            </div>
                                                        </div>
                                                        <div class="col-md-12 col-sm-12">
                                                            <!--<div class="table-responsive">-->
                                                            <table id="questionTable" class="table" style="" align="Center"  >
                                                                <tr>
                                                                    <th style="text-align: center; vertical-align: middle">Rating</th>
                                                                    <th style="text-align: center; vertical-align: middle">Excellent</th>
                                                                    <th style="text-align: center; vertical-align: middle">Very Good</th>
                                                                    <th style="text-align: center; vertical-align: middle">Acceptable</th>
                                                                    <th style="text-align: center; vertical-align: middle">Not Suitable</th>
                                                                </tr>
                                                                <tr>
                                                                    <td style="text-align: center">Technical knowledge<span style="color: red;font-size: 20px;">*</span></td>
                                                                    <td style="text-align: center">
                                                                <form:radiobutton path="technicalKnowledge" required="required"  value="1" />
                                                                </td>
                                                                <td style="text-align: center">
                                                                <form:radiobutton path="technicalKnowledge" required="required"  value="2" />
                                                                </td>
                                                                <td style="text-align: center">
                                                                <form:radiobutton path="technicalKnowledge" required="required"  value="3" />
                                                                </td>
                                                                <td style="text-align: center">
                                                                <form:radiobutton path="technicalKnowledge" required="required"  value="4" />
                                                                </td>
                                                                </tr>
                                                                <tr>
                                                                    <td style="text-align: center">Experience<span style="color: red;font-size: 20px;">*</span></td>
                                                                    <td style="text-align: center">
                                                                <form:radiobutton path="experience" required="required"  value="1"  />
                                                                </td>
                                                                <td style="text-align: center">
                                                                <form:radiobutton path="experience" required="required"  value="2"  />
                                                                </td>
                                                                <td style="text-align: center">
                                                                <form:radiobutton path="experience" required="required"  value="3" />
                                                                </td>
                                                                <td style="text-align: center">
                                                                <form:radiobutton path="experience" required="required"  value="4"  />
                                                                </td>
                                                                </tr>
                                                                <tr>
                                                                    <td style="text-align: center">Communication Skills<span style="color: red;font-size: 20px;">*</span></td>
                                                                    <td style="text-align: center">
                                                                <form:radiobutton path="commSkill" required="required"  value="1"  />
                                                                </td>
                                                                <td style="text-align: center">
                                                                <form:radiobutton path="commSkill" required="required"  value="2"  />
                                                                </td>
                                                                <td style="text-align: center">
                                                                <form:radiobutton path="commSkill" required="required"  value="3" />
                                                                </td>
                                                                <td style="text-align: center">
                                                                <form:radiobutton path="commSkill" required="required"  value="4"  />
                                                                </td>
                                                                </tr>
                                                                <tr>
                                                                    <td style="text-align: center">Inter-Personal Skills<span style="color: red;font-size: 20px;">*</span></td>
                                                                    <td style="text-align: center">
                                                                <form:radiobutton path="interPerSkill" required="required"  value="1"  />
                                                                </td>
                                                                <td style="text-align: center">
                                                                <form:radiobutton path="interPerSkill" required="required"  value="2" />
                                                                </td>
                                                                <td style="text-align: center">
                                                                <form:radiobutton path="interPerSkill" required="required"  value="3" />
                                                                </td>
                                                                <td style="text-align: center">
                                                                <form:radiobutton path="interPerSkill" required="required"  value="4"  />
                                                                </td>
                                                                </tr>
                                                                <tr>
                                                                    <td style="text-align: center">Leadership Skills<span style="color: red;font-size: 20px;">*</span></td>
                                                                    <td style="text-align: center">
                                                                <form:radiobutton path="leaderSkill" required="required"  value="1"  />
                                                                </td>
                                                                <td style="text-align: center">
                                                                <form:radiobutton path="leaderSkill" required="required"  value="2"  />
                                                                </td>
                                                                <td style="text-align: center">
                                                                <form:radiobutton path="leaderSkill" required="required"  value="3" />
                                                                </td>
                                                                <td style="text-align: center">
                                                                <form:radiobutton path="leaderSkill" required="required"  value="4"  />
                                                                </td>
                                                                </tr>
                                                            </table>
                                                        </div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <div class="form-group">

                                                            <div class="col-sm-6">
                                                                <label>Area for Training Required &nbsp;&nbsp;-:-</label> &nbsp;&nbsp;&nbsp;
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-sm-6">
                                                                <label>Strengths :<span style="color: red;font-size: 15px;">*</span></label>
                                                                <form:textarea path="strengths" id="strengths" class="form-control" placeholder="Employee Strengths" onchange="trainerOnchangeFunction('strengthsError');"></form:textarea>
                                                                <form:errors path="strengths" cssClass="errorDiv"></form:errors>
                                                                <span style="font-size: 14px; color: #dd4b39;" id="strengthsError"></span>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <label>Weaknesses :<span style="color: red;font-size: 15px;">*</span></label>
                                                                <form:textarea path="weaknesses" id="weaknesses" class="form-control" placeholder="Employee Weaknesses" onchange="trainerOnchangeFunction('weaknessesError');"></form:textarea>
                                                                <form:errors path="weaknesses" cssClass="errorDiv"></form:errors>
                                                                <span style="font-size: 14px; color: #dd4b39;" id="weaknessesError"></span>
                                                            </div>
                                                        </div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <div class="form-group">
                                                            <div class="col-sm-8">
                                                                <label>Type Of Training :<span style="color: red;font-size: 15px;">*</span></label>
                                                                <form:input path="typeOfTraining" id="typeOfTraining" class="form-control" placeholder="typeOfTraining" onchange="trainerOnchangeFunction('typeOfTrainingError');"></form:input>
                                                                <form:errors path="typeOfTraining" cssClass="errorDiv"></form:errors>
                                                                <span style="font-size: 14px; color: #dd4b39;" id="typeOfTrainingError"></span>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-sm-8">
                                                                <label>Technical Areas :<span style="color: red;font-size: 15px;">*</span></label>
                                                                <form:input path="technicalareas" id="technicalareas" class="form-control" placeholder="technicalareas" onchange="trainerOnchangeFunction('technicalareasError');"></form:input>
                                                                <form:errors path="technicalareas" cssClass="errorDiv"></form:errors>
                                                                <span style="font-size: 14px; color: #dd4b39;" id="technicalareasError"></span>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-sm-8">
                                                                <label>Other Areas(Soft Skills/behavioral) :<span style="color: red;font-size: 15px;">*</span></label>
                                                                <form:input path="otherSkills" id="otherSkills" class="form-control" placeholder="otherSkills" onchange="trainerOnchangeFunction('otherSkillsError');"></form:input>
                                                                <form:errors path="otherSkills" cssClass="errorDiv"></form:errors>
                                                                <span style="font-size: 14px; color: #dd4b39;" id="otherSkillsError"></span>

                                                            </div>
                                                        </div>
                                                        <div class="form-group">

                                                            <div class="col-sm-6">
                                                                <label>Overall Rating <span style="color: red;font-size: 15px;">*</span>&nbsp;&nbsp;-:-</label> &nbsp;&nbsp;&nbsp;
                                                            </div>
                                                        </div>
                                                        <table id="questionTable" class="table" style="" align="Center"  >
                                                            <tr>
                                                                <td style="text-align: center"> <label>Excellent:</label>
                                                            <form:radiobutton path="excellent" required="required" readonly="true" value="1" />
                                                            </td>
                                                            <td style="text-align: center"><label>Very Good:</label>
                                                            <form:radiobutton path="excellent" required="required" readonly="true"  value="2" />
                                                            </td>
                                                            <td style="text-align: center"><label>Acceptable:</label>
                                                            <form:radiobutton path="excellent" required="required" readonly="true"  value="3" />
                                                            </td>
                                                            <td style="text-align: center"><label>Not Suitable:</label>
                                                            <form:radiobutton path="excellent" required="required" readonly="true"  value="4" />
                                                            </td>
                                                            </tr>
                                                        </table>
                                                        <c:forEach  var="comment" items="${commentlist}" varStatus="loop">
                                                            <div class="form-group">
                                                                <c:if test="${loop.index eq 0}">
                                                                    <div class="col-sm-2">
                                                                        <label>Interviewer:</label>
                                                                    </div>
                                                                </c:if>
                                                                <c:if test="${loop.index ne 0}">
                                                                    <div class="col-sm-2">

                                                                    </div>
                                                                </c:if>
                                                                <div class="col-sm-8">
                                                                    <label>${comment[2]}</label>
                                                                </div>

                                                            </div>
                                                        </c:forEach>
                                                        <div class="form-group">
                                                            <div class="col-sm-2">
                                                                <label>Comment:</label> &nbsp;&nbsp;&nbsp;
                                                            </div>
                                                            <div class="col-sm-8">
                                                                <div>${candidateF2FRequest.message}</div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form:form>
                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
    </div>
</head>
</html>
