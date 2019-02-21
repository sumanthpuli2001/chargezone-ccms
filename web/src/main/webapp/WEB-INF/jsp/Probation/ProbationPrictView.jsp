<%--
    Document   : ProbationHrView
    Created on : Dec 21, 2015, 5:56:05 PM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Probation To Confirmation</title>

    </head>
    <script>
        window.print();
    </script>
    <body>
        <span class="logo-lg"><img src="StorageYard/Images/logo.png" style="width: 160px;float: left;"/></span>
        <br/>
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>Probation To Confirmation Form : </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Probation To Confirmation</li>
                </ol>
                <input type="hidden" id="id" name="id" value="${id}">
                <input type="hidden" id="empId" name="empId" value="${empId}">
            </section>

            <!-- Main content -->
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <form:hidden path="id"></form:hidden>
                                <form:form method="post" commandName="ptc"
                                           name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="table" style="margin-left: 2%">
                                                        <table style="width:100%;" class="noborder">
                                                            <tr class="noborder">
                                                                <td colspan="2"  class="noborder"><h3 class="box-title">Employee Detail:</h3></td>
                                                            </tr>
                                                            <tr class="noborder">
                                                                <th class="noborder">Employee No:</th>
                                                                <td class="noborder">${employeeMaster.employeeId}</td>
                                                                <th class="noborder">Employee Name:</th>
                                                                <td class="noborder">${employeeMaster.employeeName}</td>
                                                            </tr>
                                                            <tr class="noborder">
                                                                <th class="noborder">Department:</th>
                                                                <td class="noborder">${employeeMaster.departmentMaster.departmentName}</td>
                                                                <th class="noborder">Reporting Manager:</th>
                                                                <td class="noborder">${reportingLevel1}</td>
                                                                
                                                            </tr>
                                                            <tr class="noborder">
                                                                <th class="noborder">Designation:</th>
                                                                <td class="noborder">${employeeMaster.designationMaster.designationName}</td>
                                                                <th class="noborder">Sub Team:</th>
                                                                <td class="noborder">${employeeMaster.employeeSubType.subType}</td>
                                                                
                                                            </tr>
                                                            <tr class="noborder">
                                                                <th class="noborder">Level:</th>
                                                                <td class="noborder">${employeeMaster.levelMaster.level}</td>
                                                                <th class="noborder">Work Location:</th>
                                                                <td class="noborder">${employeeMaster.locationMaster.location}</td>
                                                            </tr>
                                                            <tr class="noborder">
                                                                <td colspan="4" class="noborder"><h3 class="box-title">Assessment Period:</h3><td>
                                                            </tr>
                                                            <tr class="noborder">
                                                                <th class="noborder">Form Issue Date:</th>
                                                                <td class="noborder">${ptc.formIssueDate}</td>
                                                            </tr>
                                                            <tr class="noborder">
                                                                <th class="noborder">From Date:</th>
                                                                <td class="noborder">${ptc.assessmentFromDate}</td>
                                                            </tr>
                                                            <tr class="noborder">
                                                                <th class="noborder">To Date:</th>
                                                                <td class="noborder">${ptc.assessmentToDate}</td>
                                                            </tr>
                                                       <tr class="noborder">
                                                                <td colspan="2"  class="noborder"><h3 class="box-title">General:</h3></td>
                                                            </tr>

                                                        <tr class="noborder">
                                                            <td colspan="12" class="noborder"> <h4 class="box-title">Brief description of role handled by Employee</h4></td>
                                                        </tr>
                                                        <tr class="noborder">
                                                            <td colspan="12" class="noborder">${ptc.jobHandled}</td>
                                                        </tr>
                                                        <tr class="noborder">
                                                            <td colspan="12" class="noborder"> <h4 class="box-title">Describe the extent to which Employee has fulfilled the requirement of role</h4></td>
                                                        </tr>
                                                        <tr class="noborder">
                                                            <td colspan="12" class="noborder">${ptc.employeeFullfill}</td>
                                                        </tr>
                                                        <tr class="noborder">
                                                            <td colspan="12" class="noborder"> <h4 class="box-title">Describe areas of Employee’s strengths</h4></td>
                                                        </tr>
                                                        <tr class="noborder">
                                                            <td colspan="12" class="noborder">${ptc.employeeStrengths}</td>
                                                        </tr>
                                                        <tr class="noborder">
                                                            <td colspan="12" class="noborder"> <h4 class="box-title">Describe areas where Employee can improve upon</h4></td>
                                                        </tr>
                                                        <tr class="noborder">
                                                            <td colspan="12" class="noborder">${ptc.employeeImprove}</td>
                                                        </tr>
                                                        <tr class="noborder">
                                                            <td colspan="12" class="noborder"> <h4 class="box-title">Training programs attended by Employee during probation period</h4></td>
                                                        </tr>
                                                        <tr class="noborder">
                                                            <td colspan="12" class="noborder">${ptc.employeeTrainingAttend}</td>
                                                        </tr>
                                                         </table>
                                                        <div >
                                                            <tr class="noborder">
                                                                <td colspan="2"  class="noborder"><h3 class="box-title">Competency Assessment:</h3></td>
                                                            </tr>
                                                            <label>Rate the Employee’s performance during their probation period. Based on the Team Leader’s evaluation and observations during the probation period, evaluate the Employee on a 5-point scale where 5 is an indicator of excellence and 1 signifies poor performance.</label>
                                                            <table class="noborder" style="width:95%; ">
                                                                
                                <tr>
                                    <th class="noborder" style="text-align: center"><h4 class="box-title"><b>Job Knowledge</b></h4></th>

                            </tr>
                            <tr>
                                <td  class="noborder">Understanding of job requirements</td>
                                <td class="noborder">${ptc.jobKnowledge1}</td>
                            </tr>
                            <tr>
                                <td  class="noborder">Demonstrated a desire to learn and accepted role</td>
                                <td class="noborder">${ptc.jobKnowledge2}</td>
                            </tr>
                            <tr>
                                <td  class="noborder">Desire to acquire knowledge of key aspect of job</td>
                                <td class="noborder">${ptc.jobKnowledge3}</td>
                            </tr>
                            <tr>
                                <td  class="noborder">Understanding the need to complete the job smoothly and efficiently</td>
                                <td class="noborder">${ptc.jobKnowledge4}</td>
                            </tr>
                            <tr>
                                <td  class="noborder">Understanding of co-ordination and effective working between teams</td>
                                <td class="noborder">${ptc.jobKnowledge5}</td>
                            </tr>
                                <tr>
                                    <th class="noborder" style="text-align: center"><h4 class="box-title"><b>Quality</b></h4></th>

                            </tr>
                            <tr>
                                <td  class="noborder">Understanding of quality parameters of the job</td>
                                <td class="noborder">${ptc.quality1}</td>
                            </tr>
                            <tr>
                                <td  class="noborder">Work accurate and deadlines achieved</td>
                                <td class="noborder">${ptc.quality2}</td>
                            </tr>
                            <tr>
                                <td  class="noborder">Correct use of resources available</td>
                                <td class="noborder">${ptc.quality3}</td>
                            </tr>
                            <tr>
                                <td  class="noborder">Establishing work standards for self and department</td>
                                <td class="noborder">${ptc.quality4}</td>
                            </tr>
                            <tr>
                                <td  class="noborder">Accurate and legible documentation</td>
                                <td class="noborder">${ptc.quality5}</td>
                            </tr>
                                <tr>
                                    <th class="noborder" style="text-align: center"><h4 class="box-title"><b>Learning</b></h4> </th>

                            </tr>
                            <tr>
                                <td  class="noborder">Desire to learn new projects</td>
                                <td class="noborder">${ptc.learning1}</td>
                            </tr>
                            <tr>
                                <td  class="noborder">Asks questions & gives feedback</td>
                                <td class="noborder">${ptc.learning2}</td>
                            </tr>
                            <tr>
                                <td  class="noborder">Tries to explore new ideas</td>
                                <td class="noborder">${ptc.learning3}</td>
                            </tr>
                            <tr>
                                <td  class="noborder">Learns from past experiences</td>
                                <td class="noborder">${ptc.learning4}</td>
                            </tr>
                            <tr>
                                <td  class="noborder">Looks for continual improvement</td>
                                <td class="noborder">${ptc.learning5}</td>
                            </tr>
                                <tr>
                                    <th class="noborder" style="text-align: center"><h4 class="box-title"><b>General</b></h4> </th>

                            </tr>
                            <tr>
                                <td  class="noborder">Co-operative and approachable</td>
                                <td class="noborder">${ptc.general1}</td>
                            </tr>
                            <tr>
                                <td  class="noborder">Reliable and trustworthy</td>
                                <td class="noborder">${ptc.general2}</td>
                            </tr>
                            <tr>
                                <td  class="noborder">Ability to work within a team</td>
                                <td class="noborder">${ptc.general3}</td>
                            </tr>
                            <tr>
                                <td  class="noborder">Reliable and punctual</td>
                                <td class="noborder">${ptc.general4}</td>
                            </tr>
                            <tr>
                                <td  class="noborder">Communication skills</td>
                                <td class="noborder">${ptc.general5}</td>
                            </tr>
                        </table>
                                                        </div>
                            <tr class="noborder">
                                       <td colspan="2"  class="noborder"><h3 class="box-title">Overall Comments and Review by Team Leader:</h3></td>
                            </tr>
                                                    <table  style="width:90%;" class="noborder">
                                                        <tr class="noborder">
                                                            <td colspan="12" class="noborder"> <h4 class="box-title">Comments about overall performance of Employee during probation period</h4></td>
                                                        </tr>
                                                        <tr class="noborder">
                                                            <td colspan="12" class="noborder">${ptc.overallPerformance}</td>
                                                        </tr>
                                                    </table>
                                                        <table  style="width:90%;" class="noborder">
                                                            <tr class="noborder">
                                                                <td  class="noborder"> <h3 class="box-title" style="display: inline-block">Performance Rating:</h3>
                                                                    <c:if test="${ptc.performanceRating eq 'Excellent'}">
                                                                        <input type="radio" name="performanceRating" id="Excellent" value="Excellent" checked style="width: 15px;height: 15px;float: left;" > Excellent
                                                                    </c:if>
                                                                    <c:if test="${ptc.performanceRating eq 'Very Good'}">
                                                                        <input type="radio" name="performanceRating" id="Very Good" value="Very Good" checked style="width: 15px;height: 15px;float: left;"> Very Good
                                                                    </c:if>
                                                                    <c:if test="${ptc.performanceRating eq 'Good'}">
                                                                        <input type="radio" name="performanceRating" id="Good"  value="Good" checked style="width: 15px;height: 15px;float: left;">Good
                                                                    </c:if>
                                                                    <c:if test="${ptc.performanceRating eq 'Average'}">
                                                                        <input  type="radio" name="performanceRating" id="Average" value="Average" checked style="width: 15px;height: 15px;float: left;">Average
                                                                    </c:if>
                                                                    <c:if test="${ptc.performanceRating eq 'Poor'}">
                                                                        <input type="radio" name="performanceRating" id="NeedsImprovement" checked value="Poor" style="width: 15px;height: 15px">Poor
                                                                    </c:if> 
                                                                </td>
                                                            </tr>
                                                        </table>
                                                        <table class="noborder" style="width: 100%;">
                                                            <tr class="noborder">
                                                                <td  class="noborder" style="text-align: left !important;"><h3>Can The Employee Be Confirmed Based On Present Performance?</h3></td>
                                                            </tr>
                                                            <tr class="noborder">
                                                                <td class="noborder" ><b>REPORTING MANAGER (RECOMMENDATION):</b>&nbsp; ${ptc.recommendationSelect}</td>
                                                            </tr>
                                                            <tr class="noborder">
                                                                <td class="noborder"><b>FUNCTIONAL HEAD (RECOMMENDATION):</b>&nbsp; ${ptc.approvalSelect}</td>
                                                            </tr>
                                                            <tr class="noborder">
                                                                <td class="noborder"><b>Hr Select:</b>&nbsp; ${ptc.hrSelect}</td>
                                                            </tr>
                                                            <tr class="noborder">
                                                                <td class="noborder"><b>Hr Extended Period:</b>&nbsp; ${ptc.hrExtendPeriod}</td>
                                                            </tr>
                                                            <tr class="noborder">
                                                                <td class="noborder"><b>Hr Approval Remark:</b>&nbsp; ${ptc.hrApprovalRemark}</td>
                                                            </tr>
                                                            <tr class="noborder">
                                                                <td class="noborder"><b>Manager Justification:</b>&nbsp; ${ptc.managerJustification}</td>
                                                            </tr>

                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>





                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
        <script>
            $(function () {
                $("#hrSelectId").on("change", function () {
                    var selectedValue = this.value;
                    if (selectedValue == "Extend") {
                        $('#hrExtPeriodId').show();
                        $('#hrExtSelectId').show();
                        $('#hrRemarkId').show();
                        $('#hrRemarkTxtId').show();
                    }
                    else if (selectedValue == "No") {
                        $('#hrExtPeriodId').hide();
                        $('#hrExtSelectId').hide();
                        $('#hrRemarkId').show();
                        $('#hrRemarkTxtId').show();
                    }
                    else {
                        $('#hrExtPeriodId').hide();
                        $('#hrExtSelectId').hide();
                        $('#hrRemarkId').hide();
                        $('#hrRemarkTxtId').hide();
                    }
                });
            });</script>
        <!--                        <style>
                                    .border{
                                        border:2px solid black;
                                    }
                                </style>-->
        <style>
            table, th, th {
                border: 2px solid black;
                border-collapse: collapse;
            }
            th, th {
                padding: 15px;
            }
            td{
                border: 1px solid black;
                border-collapse: collapse;

            }
            .noborder{
                border-bottom: 0px !important;
                border-left: 0px !important;
                border-top: 0px !important;
                border-right: 0px !important;
                padding: 0px !important;
            }

        </style>
        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    </body>
</html>
