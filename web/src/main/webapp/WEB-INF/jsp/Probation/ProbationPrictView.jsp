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
                                <form:form method="post" commandName="ptc"
                                           name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
                                    <form:hidden path="id"></form:hidden>
                                        <!--<span style="color: red;font-size: 14px;">* indicates mandatory field.</span>-->

                                        <div class="box-header">
                                            <h3 class="box-title">Employee Detail:</h3>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Employee No.:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                        <form:input path="" class="form-control" size="16" type="text" value="${employeeMaster.employeeId}" readonly="true"></form:input>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label>Employee Name:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                        <form:input path="" class="form-control" size="16" type="text" value="${employeeMaster.employeeName}" readonly="true"></form:input>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Department:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                        <form:input path="" class="form-control" size="16" type="text" value="${employeeMaster.departmentMaster.departmentName}" readonly="true"></form:input>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label>Designation:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                        <form:input path="" class="form-control" size="16" type="text" value="${employeeMaster.designationMaster.designationName}" readonly="true"></form:input>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Level:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                        <form:input path="" class="form-control" size="16" type="text" value="${employeeMaster.levelMaster.level}" readonly="true"></form:input>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label>Reporting Manager:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                        <form:input path="" class="form-control" size="16" type="text" value="${reportingLevel1}" readonly="true"></form:input>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class=" col-sm-2">
                                                            <label>Work Location:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                        <form:input path="" class="form-control" size="16" type="text" value="${employeeMaster.locationMaster.location}" readonly="true"></form:input>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="box-header">
                                            <h3 class="box-title">Assessment Period:</h3>

                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label">From Date:</label>
                                                        <div class=" col-sm-7">
                                                            <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy hh:ii " data-link-field="dtp_input1">
                                                            <form:input path="assessmentFromDate" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                            <form:errors path="assessmentFromDate" cssClass="errorDiv"></form:errors>
                                                                
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                    <c:choose>
                                                        <c:when test="${ptc.hrSelect eq 'Extend'  && !sessionScope.userRight.hr}">
                                                            <label class="col-sm-3 control-label">Extended Date:</label>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <label class="col-sm-3 control-label">To Date:</label>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <div class=" col-sm-7">
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy hh:ii" data-link-field="dtp_input1">
                                                            <form:input path="assessmentToDate" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                            <form:errors path="assessmentToDate" cssClass="errorDiv"></form:errors>
                                                                
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->

                                        <div class="box-header">
                                            <h3 class="box-title">What are the jobs being handled by the employee?</h3>

                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">

                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                            <table>
                                                                <tr>
                                                                    <td>${ptc.jobHandled}</td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->

                                    <div class="box-header">
                                        <h3 class="box-title">Performance Rating:</h3>

                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-md-3 col-sm-3"></div>
                                                    <fieldset id="performanceRating">
                                                        <!--<label class="col-sm-3 control-label">Name of the Joiner:</label>-->
                                                        <div class="col-sm-10 " >
                                                            <c:if test="${ptc.performanceRating eq 'Excellent'}">
                                                                <input type="radio" name="performanceRating" id="Excellent" value="Excellent" checked style="width: 15px;height: 15px" > Excellent
                                                            </c:if>
                                                            <c:if test="${ptc.performanceRating eq 'Very Good'}">
                                                                <input type="radio" name="performanceRating" id="Very Good" value="Very Good" checked style="width: 15px;height: 15px"> Very Good
                                                            </c:if>
                                                            <c:if test="${ptc.performanceRating eq 'Good'}">
                                                                <input type="radio" name="performanceRating" id="Good"  value="Good" checked style="width: 15px;height: 15px">Good
                                                            </c:if>
                                                            <c:if test="${ptc.performanceRating eq 'Average'}">
                                                                <input type="radio" name="performanceRating" id="Average" value="Average" checked style="width: 15px;height: 15px">Average
                                                            </c:if>
                                                            <c:if test="${ptc.performanceRating eq 'NeedsImprovement'}">
                                                                <input type="radio" name="performanceRating" id="NeedsImprovement" checked value="NeedsImprovement" style="width: 15px;height: 15px">Needs Improvement
                                                            </c:if>

                                                        </div>
                                                    </fieldset>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->

                                    <div class="box-header">
                                        <h3 class="box-title">Can The Employee Be Confirmed Based On Present Performance?</h3>

                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="table-responsive">
                                                    <table id="demo" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <tr>
                                                            <td >REPORTING MANAGER (RECOMMENDATION)</td>
                                                            <td>
                                                                <form:input path="recommendationSelect"  class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                </td>
                                                            <c:if test="${ptc.recommendationSelect eq 'Extend'}">
                                                                <td id="RecomendationExtPeriodId" >Extention Period</td>
                                                                <td id="RecomendationExtSelectId" >
                                                                    ${ptc.recommendationExtendPeriod}
                                                                    </td>
                                                            </c:if>
                                                            <c:if test="${ptc.recommendationSelect eq 'Extend' || ptc.recommendationSelect eq 'No'}">
                                                                <td id="RecomendationRemarkId" >Remark</td>
                                                                <td id="RecomendationRemarkTxtId">
                                                                      ${ptc.recommendationRemark}
                                                                </c:if>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td >FUNCTIONAL HEAD (RECOMMENDATION)</td>
                                                            <td>
                                                                <form:input path="approvalSelect"  class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                </td>
                                                            <c:if test="${ptc.approvalSelect eq 'Extend'}">
                                                                <td id="ApprovalExtPeriodId" >Extention Period</td>
                                                                <td id="ApprovalExtSelectId" >
                                                                      ${ptc.approvalExtendPeriod}
                                                                    </td>
                                                            </c:if>
                                                            <c:if test="${ptc.approvalSelect eq 'Extend' || ptc.approvalSelect eq 'No'}">
                                                                <td id="ApprovalRemarkId" >Remark</td>
                                                                <td id="ApprovalRemarkTxtId">
                                                                      ${ptc.approvalRemark}
                                                                </c:if>
                                                            </td>
                                                        </tr>
                                                        <c:if test="${sessionScope.userRight.probationToConfirmation}">
                                                            <c:if test="${ptc.status ne 4 && ptc.status ne 5}">
                                                                <tr>
                                                                    <td >HR (APPROVAL)</td>
                                                                    <td>
                                                                        <form:select path="hrSelect" id="hrSelectId" class="form-control ">
                                                                            <form:option value="">--SELECT--</form:option>
                                                                            <form:option value="Yes">Yes</form:option>
                                                                            <form:option value="No">No</form:option>
                                                                            <form:option value="Extend">Extend</form:option>
                                                                        </form:select>
                                                                        <span id="hrSelectError" style="color: red;"></span>
                                                                    </td>
                                                                    <td id="hrExtPeriodId" style="display: none">Extention Period</td>
                                                                    <td id="hrExtSelectId" style="display: none">
                                                                        <form:select path="hrExtendPeriod" id="hrextendmonth" name="hrextendmonth" class="form-control ">
                                                                            <form:option value="">--SELECT--</form:option>
                                                                            <form:option value="1Month">1 Month</form:option>
                                                                            <form:option value="2Month">2 Month</form:option>
                                                                            <form:option value="3Month">3 Month</form:option>
                                                                            <form:option value="4Month">4 Month</form:option>
                                                                            <form:option value="5Month">5 Month</form:option>
                                                                            <form:option value="6Month">6 Month</form:option>
                                                                            <form:option value="7Month">7 Month</form:option>
                                                                            <form:option value="8Month">8 Month</form:option>
                                                                            <form:option value="9Month">9 Month</form:option>
                                                                        </form:select>
                                                                        <span id="hrExtendPeriodError" style="color: red;"></span>

                                                                    </td>
                                                                    <c:if test="${ptc.status ne 3}">
                                                                        <td id="hrRemarkId" style="display: none">Remark</td>
                                                                        <td id="hrRemarkTxtId" style="display: none">
                                                                            ${ptc.hrremark}
                                                                        </td></c:if>
                                                                    <c:if test="${ptc.status eq 3}">
                                                                        <td id="hrRemarkId" >Remark</td>
                                                                        <td id="hrRemarkTxtId" >
                                                                            ${ptc.hrApprovalRemark}
                                                                        </td></c:if>
                                                                    </tr>
                                                            </c:if>
                                                            <c:if test="${ptc.status eq 4 || ptc.status eq 5}">
                                                                <tr>
                                                                    <td>HR (APPROVAL)</td>
                                                                    <td>
                                                                        <form:input path="hrSelect"  class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                        </td>
                                                                    <c:if test="${ptc.hrSelect eq 'Extend'}">
                                                                        <td id="hrExtPeriodId" >Extention Period</td>
                                                                        <td id="hrExtSelectId">
                                                                            <form:input path="hrExtendPeriod"  class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                            </td>
                                                                    </c:if>
                                                                    <c:if test="${ptc.hrSelect eq 'Extend' || ptc.hrSelect eq 'No'}">
                                                                        <td id="hrRemarkId">Remark</td>
                                                                        <td id="hrRemarkTxtId">
                                                                            ${ptc.hrApprovalRemark}
                                                                            </td>
                                                                    </c:if>
                                                                </tr>
                                                            </c:if>
                                                        </c:if>
                                                        <c:if test="${!sessionScope.userRight.probationToConfirmation}">
                                                            <tr>
                                                                <td>HR (APPROVAL)</td>
                                                                <td>
                                                                    <form:input path="hrSelect"  class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                    </td>
                                                                <c:if test="${ptc.hrSelect eq 'Extend'}">
                                                                    <td id="hrExtPeriodId" >Extention Period</td>
                                                                    <td id="hrExtSelectId">
                                                                        <form:input path="hrExtendPeriod"  class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                        </td>
                                                                </c:if>
                                                                <c:if test="${ptc.hrSelect eq 'Extend' || ptc.hrSelect eq 'No'}">
                                                                    <td id="hrRemarkId">Remark</td>
                                                                    <td id="hrRemarkTxtId">
                                                                        ${ptc.hrApprovalRemark}
                                                                        </td>
                                                                </c:if>
                                                            </tr>
                                                        </c:if>
                                                        <tr>
                                                            <td colspan="9"><b>In case your answer is in negative, please comment. What are the areas identified for improvement & please communicate the same to appraisee. Also write the strategy / steps to overcome the areas of improvement.</b></td>
                                                        </tr>
                                                        <tr>
                                                            <c:if test="${sessionScope.userRight.probationToConfirmation}">
                                                                <c:if test="${ptc.status eq 4 || ptc.status eq 5}">
                                                                    <td colspan="9"> ${ptc.improvementComment}</td>
                                                                </c:if>
                                                                <c:if test="${ptc.status ne 4 && ptc.status ne 5}">
                                                                    <td colspan="9">  ${ptc.improvementComment}</td>
                                                                </c:if>
                                                            </c:if>
                                                            <c:if test="${!sessionScope.userRight.probationToConfirmation}">
                                                                <td colspan="9"> ${ptc.improvementComment}</td>
                                                            </c:if>
                                                        </tr>
                                                        <tr>
                                                            <td>RECOMMENDATION BY HR (IF ANY):</td>
                                                            <td colspan="5" >
                                                                <c:if test="${sessionScope.userRight.probationToConfirmation}">
                                                                    <c:if test="${ptc.status eq 4 || ptc.status eq 5}">
                                                                       ${ptc.recomendationByHr}</td>
                                                                    </c:if>
                                                                    <c:if test="${ptc.status ne 4 && ptc.status ne 5}">
                                                                       ${ptc.recomendationByHr}</td>
                                                                </c:if>
                                                            </c:if>
                                                            <c:if test="${!sessionScope.userRight.probationToConfirmation}">
                                                                ${ptc.recomendationByHr}</td>
                                                            </c:if>
                                                        </tr>
                                                    </table>
                                                </div><!-- /.col -->
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->



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
            <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    </body>
</html>
