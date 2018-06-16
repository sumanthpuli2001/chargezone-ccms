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
                                                                <th class="noborder">Designation:</th>
                                                                <td class="noborder">${employeeMaster.designationMaster.designationName}</td>
                                                            </tr>
                                                            <tr class="noborder">
                                                                <th class="noborder">Level:</th>
                                                                <td class="noborder">${employeeMaster.levelMaster.level}</td>
                                                                <th class="noborder">Reporting Manager:</th>
                                                                <td class="noborder">${reportingLevel1}</td>
                                                            </tr>
                                                            <tr class="noborder">
                                                                <th class="noborder">Work Location:</th>
                                                                <td class="noborder">${employeeMaster.locationMaster.location}</td>
                                                            </tr>
                                                            <tr class="noborder">
                                                                <td colspan="4" class="noborder"><h3 class="box-title">Assessment Period:</h3><td>
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
                                                            <td colspan="12" class="noborder"> <h3 class="box-title">What are the jobs being handled by the employee?</h3></td>
                                                        </tr>
                                                        <tr class="noborder">
                                                            <td colspan="12" class="noborder">${ptc.jobHandled}</td>
                                                        </tr>
                                                         </table>
                                                        <div >
                                                            <table  style="width:95%;">
                                                                <tr >
                                                                    <th colspan="8" >Behaviour</th>
                                                                    <th colspan="2" >Satisfactory</th>
                                                                    <th colspan="2" >Not-Satisfactory</th>
                                                                </tr>
                                                                <tr></tr>
                                                                <tr>
                                                                    <th colspan="8">C 1: Concentration</th>
                                                                        <c:if test="${ptc.concentration eq 'true'}">
                                                                        <th colspan="2" rowspan="7">
                                                                            <input type="radio" name="concentration" id="Yes" value="Yes" checked style="width: 15px;height: 15px" > Yes
                                                                        </th>
                                                                        <th colspan="2" rowspan="7">
                                                                        </th>
                                                                    </c:if>
                                                                    <c:if test="${ptc.concentration eq 'false'}">
                                                                        <th colspan="2" rowspan="7"> 
                                                                        </th>
                                                                        <th colspan="2" rowspan="7">
                                                                            <input type="radio" name="concentration" id="NO" value="No" checked  style="width: 15px;height: 15px" > No
                                                                        </th>
                                                                    </c:if>
                                                                </tr>
                                                                <tr>
                                                                    <td  colspan="8">Concentration on the work</td>
                                                                </tr>
                                                                <tr>
                                                                    <td  colspan="8">Attention in detailing of work</td>
                                                                </tr>
                                                                <tr>
                                                                    <td  colspan="8">targeting the highest standard of excellence</td>
                                                                </tr>
                                                                <tr>
                                                                    <td  colspan="8">doing better than yesterday</td>
                                                                </tr>
                                                                <tr>
                                                                    <td  colspan="8">Respect every employee</td>
                                                                </tr>
                                                                <tr>
                                                                    <td  colspan="8">concentrtaion on performance achievement and individual development</td>
                                                                </tr>
                                                                <tr>
                                                                    <th colspan="8">C 2: Consistency</th>
                                                                        <c:if test="${ptc.consistency eq 'true'}">
                                                                        <th colspan="2" rowspan="3">
                                                                            <input type="radio" name="consistency" id="Yes" value="Yes" checked style="width: 15px;height: 15px" > Yes
                                                                        </th>
                                                                        <th colspan="2" rowspan="3">
                                                                        </th>
                                                                    </c:if>
                                                                    <c:if test="${ptc.consistency eq 'false'}">
                                                                        <th colspan="2" rowspan="3"> 
                                                                        </th>
                                                                        <th colspan="2" rowspan="3">
                                                                            <input type="radio" name="consistency" id="NO" value="No" checked  style="width: 15px;height: 15px" > No
                                                                        </th>
                                                                    </c:if>    
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="8">Consistency in building system and for organizations betterment</td>
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="8">to maintain consistency in respect with organization's future, mission and vision, safety and security of employees</td>
                                                                </tr>
                                                                <tr>
                                                                    <th colspan="8">C 3: Cooperation</th>
                                                                        <c:if test="${ptc.cooperation eq 'true'}">
                                                                        <th colspan="2" rowspan="3">
                                                                            <input type="radio" name="cooperation" id="Yes" value="Yes" checked style="width: 15px;height: 15px" > Yes
                                                                        </th>
                                                                        <th colspan="2" rowspan="3">
                                                                        </th>
                                                                    </c:if>
                                                                    <c:if test="${ptc.cooperation eq 'false'}">
                                                                        <th colspan="2" rowspan="3"> 
                                                                        </th>
                                                                        <th colspan="2" rowspan="3">
                                                                            <input type="radio" name="cooperation" id="NO" value="No" checked  style="width: 15px;height: 15px" > No
                                                                        </th>
                                                                    </c:if>
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="8">Conduct of the highest ethical standard, intellectual , financial and moral . </td>
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="8">Conduct which builds and maintains teamwork</td>
                                                                </tr>
                                                                <tr>
                                                                    <th colspan="12" style="text-align: center;">Job Knowledge & Working Standards</th>
                                                                </tr>
                                                                <tr>
                                                                    <th colspan="8">1. Job Knowledge</th>
                                                                        <c:if test="${ptc.knowledge eq 'true'}">
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="knowledge" id="Yes" value="Yes" checked style="width: 15px;height: 15px" > Yes
                                                                        </th>
                                                                        <th colspan="2" rowspan="2">
                                                                        </th>
                                                                    </c:if>
                                                                    <c:if test="${ptc.knowledge eq 'false'}">
                                                                        <th colspan="2" rowspan="2"> 
                                                                        </th>
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="knowledge" id="NO" value="No" checked  style="width: 15px;height: 15px" > No
                                                                        </th>
                                                                    </c:if>
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="8">Knowledge to perform the task</td>
                                                                </tr>
                                                                <tr>
                                                                    <th colspan="8">2. Discipline</th>
                                                                        <c:if test="${ptc.discipline eq 'true'}">
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="discipline" id="Yes" value="Yes" checked style="width: 15px;height: 15px" > Yes
                                                                        </th>
                                                                        <th colspan="2" rowspan="2">
                                                                        </th>
                                                                    </c:if>
                                                                    <c:if test="${ptc.discipline eq 'false'}">
                                                                        <th colspan="2" rowspan="2"> 
                                                                        </th>
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="discipline" id="NO" value="No" checked  style="width: 15px;height: 15px" > No
                                                                        </th>
                                                                    </c:if>      
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="8">Way of thinking, belief or opinion of approval and disapproval towards the organization decision and action. The way in which one acts or conducts oneself, especially towards others, respects for others, Eagerness to help others.</td>
                                                                </tr>
                                                                <tr>
                                                                    <th colspan="8">3. Leadership Quality</th>
                                                                        <c:if test="${ptc.leadership eq 'true'}">
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="leadership" id="Yes" value="Yes" checked style="width: 15px;height: 15px" > Yes
                                                                        </th>
                                                                        <th colspan="2" rowspan="2">
                                                                        </th>
                                                                    </c:if>
                                                                    <c:if test="${ptc.leadership eq 'false'}">
                                                                        <th colspan="2" rowspan="2"> 
                                                                        </th>
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="leadership" id="NO" value="No" checked  style="width: 15px;height: 15px" > No
                                                                        </th>
                                                                    </c:if> 
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="8">Deliver result on time, build relationship & develop others & possess good decision making skills</td>
                                                                </tr>
                                                                <tr>
                                                                    <th colspan="8">4. Communication </th>
                                                                        <c:if test="${ptc.communication eq 'true'}">
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="communication" id="Yes" value="Yes" checked style="width: 15px;height: 15px" > Yes
                                                                        </th>
                                                                        <th colspan="2" rowspan="2">
                                                                        </th>
                                                                    </c:if>
                                                                    <c:if test="${ptc.communication eq 'false'}">
                                                                        <th colspan="2" rowspan="2"> 
                                                                        </th>
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="communication" id="NO" value="No" checked  style="width: 15px;height: 15px" > No
                                                                        </th>
                                                                    </c:if>                                                                         
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="8">Express ideas and concerns clearly Proficient and confident in presentation Flexible and effective writing skills </td>
                                                                </tr>
                                                                <tr>
                                                                    <th colspan="8">5. 5S and Safety Norms </th>
                                                                        <c:if test="${ptc.safety eq 'true'}">
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="safety" id="Yes" value="Yes" checked style="width: 15px;height: 15px" > Yes
                                                                        </th>
                                                                        <th colspan="2" rowspan="2">
                                                                        </th>
                                                                    </c:if>
                                                                    <c:if test="${ptc.safety eq 'false'}">
                                                                        <th colspan="2" rowspan="2"> 
                                                                        </th>
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="safety" id="NO" value="No" checked  style="width: 15px;height: 15px" > No
                                                                        </th>
                                                                    </c:if>
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="8">Cleanliness of own self, work premises, retrieval of data, safe working practice, safety knowledge</td>
                                                                </tr>
                                                                <tr>
                                                                    <th colspan="8">6. Team Work </th>
                                                                        <c:if test="${ptc.team eq 'true'}">
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="team" id="Yes" value="Yes" checked style="width: 15px;height: 15px" > Yes
                                                                        </th>
                                                                        <th colspan="2" rowspan="2">
                                                                        </th>
                                                                    </c:if>
                                                                    <c:if test="${ptc.team eq 'false'}">
                                                                        <th colspan="2" rowspan="2"> 
                                                                        </th>
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="team" id="NO" value="No" checked  style="width: 15px;height: 15px" > No
                                                                        </th>
                                                                    </c:if>
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="8">The extent to which the employee successfully collaborates with others to accomplish departmental and Organizational goals.<br> Target achieved through team work.</td>
                                                                </tr>
                                                                <tr>
                                                                    <th colspan="8">7. Integrity/Ethics </th>
                                                                        <c:if test="${ptc.integrity eq 'true'}">
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="integrity" id="Yes" value="Yes" checked style="width: 15px;height: 15px" > Yes
                                                                        </th>
                                                                        <th colspan="2" rowspan="2">
                                                                        </th>
                                                                    </c:if>
                                                                    <c:if test="${ptc.integrity eq 'false'}">
                                                                        <th colspan="2" rowspan="2"> 
                                                                        </th>
                                                                        <th colspan="2" rowspan="2">
                                                                            <input type="radio" name="integrity" id="NO" value="No" checked  style="width: 15px;height: 15px" > No
                                                                        </th>
                                                                    </c:if>
                                                                </tr>
                                                            </table>
                                                        </div>

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
                                                                    <c:if test="${ptc.performanceRating eq 'NeedsImprovement'}">
                                                                        <input type="radio" name="performanceRating" id="NeedsImprovement" checked value="NeedsImprovement" style="width: 15px;height: 15px">Needs Improvement
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
