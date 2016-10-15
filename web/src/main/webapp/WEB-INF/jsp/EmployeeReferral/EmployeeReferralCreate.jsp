<%-- 
    Document   : EmployeeReferralCreate
    Created on : Nov 16, 2015, 11:49:09 AM
    Author     : Irfan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee referral</title>
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

        </script>

        <c:if test="${((sessionScope.employeeInfo.id eq finalApprover) or sessionScope.userRight.employeeReferral) && employeeReferral.status ne 0}">
            <script>
                $(document).ready(function () {
                    $('#referringCandidateDiv input').attr('readonly', true);
                    $('#referringCandidateDiv textarea').attr('readonly', true);
                });</script>
            </c:if>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Employee Referral Form:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Employee Referral</li>
            </ol>
        </section>
        <div class="col-md-12" style="text-align: center;">
            <span style="alignment-adjust: middle;">
                <button type="button" id="mycmd" class="btn btn-primary" style="width: 100px;text-align: center;alignment-adjust: central;">PRINT</button>
            </span>
        </div>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">

                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">

                        <div class="tab-content">

                            <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                            <c:if test="${!empty successMessage}">
                                <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                            </c:if>
                            <c:if test="${!empty failureMessage}">
                                <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                            </c:if>
                            <br/>
                            <br/>
                            <!--form horizontal starts here-->
                            <form:form method="post" commandName="employeeReferral" name='form1' id="referralForm" enctype="multipart/form-data" class="form-horizontal" role="form">
                                <form:hidden path="id"></form:hidden>
                                <%--<spring:bind path="streetName.value">--%>
                                <!--<input type="hidden" name="" value="" />-->
                                <%--</spring:bind>--%>
                                <div class="box box-info collapsed-box " id="printArea1">
                                    <div class="box-header">
                                        <h3 class="box-title">Referring Employee Details:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId1">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun1();"><i class="fa fa-plus" id="minusId1" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <c:if test="${not empty employeeDetail}">
                                                    <form:hidden path="statusRemark" value="Pending At HR"></form:hidden>
                                                    <form:hidden path="employeeMaster.id" value="${employeeDetail[7]}"></form:hidden>

                                                        <div class="form-group">
                                                            <div class="col-sm-2">
                                                                <label>Employee No.:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                                <input type="Text" value="${employeeDetail[0]}" class="form-control" readonly/>
                                                            <input type="hidden" value="${employeeDetail[0]}" id="empid" name="empid"/>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label>Employee Name:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" value="${employeeDetail[1]}" class="form-control" readonly/>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Designation:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" value="${employeeDetail[2]}" class="form-control" readonly/>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label>Level:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" value="${employeeDetail[3]}" class="form-control" readonly/>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Department:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" value="${employeeDetail[4]}" class="form-control" readonly/>
                                                        </div>

                                                        <div class="col-sm-2">
                                                            <label>Work Location:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" value="${employeeDetail[5]}" class="form-control" readonly/>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Reporting Manager:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" value="${employeeDetail[6]}" class="form-control" readonly/>
                                                        </div>
                                                    </div>
                                                </c:if>
                                                <c:if test="${not empty employeeRefList}">

                                                    <form:hidden path="employeeMaster.id" value="${employeeRefList[1]}"></form:hidden>
                                                        <div class="form-group">
                                                            <div class="col-sm-2">
                                                                <label>Employee No.:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                                <input type="Text" value="${employeeRefList[2]}" class="form-control" readonly/>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label>Employee Name:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" value="${employeeRefList[3]}" class="form-control" readonly/>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Designation:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" value="${employeeRefList[5]}" class="form-control" readonly/>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label>Level:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" value="${employeeRefList[6]}" class="form-control" readonly/>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Department:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" value="${employeeRefList[8]}" class="form-control" readonly/>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label>Work Location:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" value="${employeeRefList[12]}" class="form-control" readonly/>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Reporting Manager:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" value="${employeeRefList[11]}" class="form-control" readonly/>
                                                        </div>
                                                    </div>
                                                </c:if>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                                <!--Employee detail completes here-->
                                <div class="box box-info collapsed-box" id="printArea2">
                                    <div class="box-header">
                                        <h3 class="box-title">Referred Candidate Details:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2();"><i class="fa fa-plus" id="minusId2" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12" id="referringCandidateDiv">
                                                <div class="form-group">
                                                    <form:label path="candidateName" class="col-lg-4 control-label">Name:<span style="color: red;font-size: 12px;">*</span></form:label>
                                                        <div class="col-lg-6">
                                                        <c:choose>
                                                            <%--<c:if test="${not empty employeeRefList}">--%>
                                                            <c:when test="${(sessionScope.employeeInfo.id eq employeeRefList[1])or(sessionScope.employeeInfo.id eq employeeDetail[7])}">
                                                                <form:input path="candidateName" class="form-control" ></form:input>
                                                            </c:when>
                                                            <%--</c:if>--%>
                                                            <c:otherwise>
                                                                <form:input path="candidateName" class="form-control" readonly="true"></form:input>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <form:errors path="candidateName" cssClass="errorDiv" readonly="true"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                    <form:label path="candidateContactNo" class="col-lg-4 control-label">Contact No.:<span style="color: red;font-size: 12px;">*</span></form:label>
                                                        <div class="col-lg-6">
                                                        <c:choose>
                                                            <%--<c:if test="${not empty employeeRefList}">--%>
                                                            <c:when test="${(sessionScope.employeeInfo.id eq employeeRefList[1])or(sessionScope.employeeInfo.id eq employeeDetail[7])}">
                                                                <form:input path="candidateContactNo" class="form-control" maxlength="10"></form:input>

                                                            </c:when>
                                                            <%--</c:if>--%>
                                                            <c:otherwise>
                                                                <form:input path="candidateContactNo" class="form-control" maxlength="10" readonly="true"></form:input>
                                                            </c:otherwise>
                                                        </c:choose>

                                                        <form:errors path="candidateContactNo" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                    <form:label path="candidatePositionReferredFor" class="col-lg-4 control-label">Position Referred For:<span style="color: red;font-size: 12px;">*</span></form:label>
                                                        <div class="col-lg-6">
                                                        <c:choose>
                                                            <%--<c:if test="${not empty employeeRefList}">--%>
                                                            <c:when test="${(sessionScope.employeeInfo.id eq employeeRefList[1])or(sessionScope.employeeInfo.id eq employeeDetail[7])}">
                                                                <form:select path="candidatePositionReferredFor" class="form-control" placeholder="---Select---">
                                                                    <form:option value="" label="-- Select --" />
                                                                    <form:options items="${positionReferMap}"/>
                                                                </form:select>

                                                            </c:when>
                                                            <%--</c:if>--%>
                                                            <c:otherwise>

                                                                <c:set var="countFirst" value="0"/>
                                                                <c:forEach var="positionReferMap" items="${positionReferMap}">
                                                                    <c:choose>
                                                                        <c:when test="${(positionReferMap.key) eq employeeReferral.candidatePositionReferredFor}">
                                                                            <c:set var="countFirst" value="${countFirst+1}"/>
                                                                            <input type="text" name="candidatePositionReferredForValue" id="candidatePositionReferredForValue" class="form-control" value="${positionReferMap.value}" readonly/>
                                                                            <input type="hidden" name="candidatePositionReferredFor" id="candidatePositionReferredFor" class="form-control" value="${positionReferMap.key}"/>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </c:forEach>
                                                                <c:if test="${countFirst eq 0}">
                                                                    <input type="text" name="candidatePositionReferredForValue" id="candidatePositionReferredForValue" class="form-control" readonly/>
                                                                    <!--<input type="hidden" name="candidatePositionReferredFor" id="candidatePositionReferredFor" class="form-control" value="${positionReferMap.key}" readonly/>-->
                                                                </c:if>
                                                            </c:otherwise>
                                                        </c:choose>

                                                        <%--<form:hidden path="candidatePositionReferredFor" class="form-control" value=""></form:hidden>--%>
                                                        <form:errors path="candidatePositionReferredFor" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                    <form:label path="candidateRelation" class="col-lg-4 control-label">Relation With Employee:<span style="color: red;font-size: 12px;">*</span></form:label>
                                                        <div class="col-lg-6">
                                                        <c:choose>
                                                            <%--<c:if test="${not empty employeeRefList}">--%>
                                                            <c:when test="${(sessionScope.employeeInfo.id eq employeeRefList[1])or(sessionScope.employeeInfo.id eq employeeDetail[7])}">
                                                                <form:input path="candidateRelation" class="form-control"></form:input>
                                                            </c:when>
                                                            <%--</c:if>--%>
                                                            <c:otherwise>
                                                                <form:input path="candidateRelation" class="form-control" readonly="true"></form:input>
                                                            </c:otherwise>
                                                        </c:choose>

                                                        <form:errors path="candidateRelation" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-lg-4 control-label">Upload Resume:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="col-lg-6">
                                                        <c:if test="${((sessionScope.employeeInfo.id eq finalApprover) or sessionScope.userRight.employeeReferral)&&(employeeReferral.id eq null)}">
                                                            <input type="file" name="candidateCV" id="candidateCV" class="form-control" onchange="checkFileSize(this);"/>
                                                        </c:if>
                                                        <c:choose>
                                                            <c:when test="${!((sessionScope.employeeInfo.id eq finalApprover) or sessionScope.userRight.employeeReferral)&&(employeeReferral.id eq null)}">
                                                                <input type="file" name="candidateCV" id="candidateCV" class="form-control" onchange="checkFileSize(this);"/>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <c:if test="${((sessionScope.user.userName eq employeeDetail[0])or(sessionScope.user.userName eq employeeRefList[2]))&&(employeeReferral.id ne null)&& !((sessionScope.employeeInfo.id eq finalApprover) or sessionScope.userRight.employeeReferral)}">
                                                                    <input type="text" name="candidateCVfileName" id="candidateCVfileName" class="form-control" value="${candidateCVFileName}" readonly/>
                                                                    <c:if test="${isFileRemoved eq 'notRemoved'}">
                                                                        <a href="${candidateCVFile}" target="_blank">Download And Check</a>
                                                                    </c:if>
                                                                </c:if>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <span style="font-size: 14px; color: red;" id="candidateCVError"></span>
                                                        <!--<input type="hidden" id="candidateCVfileName" name="candidateCVfileName" value=""/>-->
                                                        <c:if test="${((sessionScope.employeeInfo.id eq finalApprover) or sessionScope.userRight.employeeReferral)&&(employeeReferral.id ne null)}">
                                                            <input type="text" name="candidateCVfileName" id="candidateCVfileName" class="form-control" value="${candidateCVFileName}" readonly/>
                                                            <c:if test="${isFileRemoved eq 'notRemoved'}">
                                                                <div id="downloadRemoveDiv">
                                                                    <div class="col-sm-3"><h3><span class="label label label-primary"><span class="fa fa-save">&nbsp;&nbsp;<a href="employeeReferral.htm?act=getCandidateCVFile&amp;candidateCV=${candidateCVFileName}&amp;candidateName=${employeeReferral.getCandidateName()}&amp;id=${param.id}"><font color="white">Download</font></a></span></span></h3></div>
                                                                    <!--<div class="col-sm-3"><h3><span class="label label label-primary"><span class="fa fa-save">&nbsp;&nbsp;<a href="javascript:getCandidateCV();"><font color="white">Download</font></a></span></span></h3></div>-->
                                                                    <!--<div class="col-sm-3"><h3><span class="label label label-danger"><span class="fa fa-remove">&nbsp;&nbsp;<a href="javascript:removeCandidateCV()"><font color="white">Remove</font></a></span></span></h3></div>-->
                                                                    <div class="col-sm-3"><h3><span class="label label label-danger"><span class="fa fa-remove">&nbsp;&nbsp;<a href="javascript:removeCandidateCV();"><font color="white">Remove</font></a></span></span></h3></div>
                                                                </div>
                                                            </c:if>
                                                        </c:if>
                                                        <%--<form:errors path="candidateRelation" cssClass="errorDiv"></form:errors>--%>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <form:label path="candidateReferingReason" class="col-lg-4 control-label">Reason For Referring:<span style="color: red;font-size: 12px;">*</span></form:label>
                                                        <div class="col-lg-6">
                                                        <c:choose>
                                                            <%--<c:if test="${not empty employeeRefList}">--%>
                                                            <c:when test="${(sessionScope.employeeInfo.id eq employeeRefList[1])or(sessionScope.employeeInfo.id eq employeeDetail[7])}">
                                                                <form:textarea path="candidateReferingReason" class="form-control" rows="3"></form:textarea>

                                                            </c:when>
                                                            <%--</c:if>--%>
                                                            <c:otherwise>
                                                                <form:textarea path="candidateReferingReason" class="form-control" rows="3" readonly="true"></form:textarea>

                                                            </c:otherwise>
                                                        </c:choose>
                                                        <form:errors path="candidateReferingReason" cssClass="errorDiv" readonly="true"></form:errors>
                                                        </div>
                                                    </div>
                                                <%--<c:if test="${employeeReferral.status eq 5 && !(sessionScope.userRight.hr or sessionScope.userRight.employeeReferral)}">--%>
                                                <c:if test="${(employeeReferral.status eq 2 or employeeReferral.status eq 5) &&!((sessionScope.employeeInfo.id eq finalApprover) or sessionScope.userRight.employeeReferral)}">

                                                    <div class="form-group">
                                                        <form:label path="hrRemark" class="col-lg-4 control-label">Remark By HR:</form:label>
                                                            <div class="col-lg-6">
                                                            <form:textarea path="hrRemark" class="form-control" rows="3" readonly="true"></form:textarea>
                                                            <form:errors path="hrRemark" cssClass="errorDiv"></form:errors>
                                                            </div>
                                                        </div>
                                                </c:if>

                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                                <c:if test="${employeeReferral.id ne null}">
                                    <c:choose>
                                        <c:when test="${(sessionScope.userRight.employeeReferral) and ((sessionScope.employeeInfo.id ne employeeRefList[1])or(sessionScope.employeeInfo.id ne employeeDetail[7]))}">
                                            <div class="form-group">
                                                <c:if test="${ employeeReferral.status eq 0}">
                                                    <div class="col-sm-6" style="text-align: left;">
                                                        <button type="submit" value="Accept" id="buttonPressed" class="btn btn-success" data-original-title="" onclick="cickToSubmit(this.value);" style="width: 100px">ACCEPT</button>
                                                    </div>
                                                    <!--<div class="col-sm-4" style="text-align: center;">-->
                                                    <div class="col-sm-6" style="text-align: right;">
                                                        <button type="button" data-toggle="modal" data-target="#myModal" class="btn btn-danger" data-original-title="" style="width: 100px;" title="">REJECT</button>
                                                    </div>
                                                    <!--                                                <div class="col-sm-4" style="text-align: right;">
                                                                                                        <button type="submit" value="return" id="buttonPressed" class="btn btn-warning" data-original-title="" onclick="cickToSubmit(this.value);" style="width: 100px;" title="">RETURN</button>
                                                                                                    </div>-->
                                                </c:if>
                                            </div>
                                        </c:when>
                                        <c:otherwise>

                                        </c:otherwise>
                                    </c:choose>
                                </c:if>
                                <!--Travel request and type detail completes here-->
                                <%--<c:if test="${sessionScope.userRight.hr or sessionScope.userRight.employeeReferral}">--%>
                                <c:if test="${((sessionScope.employeeInfo.id eq finalApprover) or sessionScope.userRight.employeeReferral) && ((employeeReferral.status eq 1) or (employeeReferral.status eq 2) or (employeeReferral.status eq 3))}">
                                    <div class="box box-info collapsed-box" id="printArea3">
                                        <div class="box-header">
                                            <h3 class="box-title">Joiner Detail:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun3();"><i class="fa fa-plus" id="minusId3" ></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <c:choose>
                                                        <c:when test="${(sessionScope.employeeInfo.id eq finalApprover)}">
                                                            <div class="form-group">
                                                                <form:label path="joinerName" class="col-lg-4 control-label">Name of the Joiner:</form:label>
                                                                    <div class="col-lg-6">
                                                                    <form:input path="joinerName" class="form-control" readonly="true"></form:input>
                                                                    <form:errors path="joinerName" cssClass="errorDiv"></form:errors>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                <form:label path="joinerDateOfJoining" class="col-lg-4 control-label">Date Of Joining:</form:label>
                                                                    <div class="col-lg-6">
                                                                        <input type="text" name="joinerDateOfJoining" id="joinerDateOfJoining" class="form-control" value="${employeeReferral.joinerDateOfJoining}" readonly/>
                                                                    <form:errors path="joinerDateOfJoining" cssClass="errorDiv"></form:errors>
                                                                    </div>
                                                                </div>
                                                                <!--</div>-->
                                                                <div class="form-group">
                                                                <form:label path="joinerEmployeeNo" class="col-lg-4 control-label">Employee No.:</form:label>
                                                                    <div class="col-lg-6">
                                                                    <form:input path="joinerEmployeeNo" class="form-control" maxlength="10" readonly="true"></form:input>
                                                                    <form:errors path="joinerEmployeeNo" cssClass="errorDiv"></form:errors>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                <form:label path="joinerDepartment" class="col-lg-4 control-label">Department:</form:label>
                                                                    <div class="col-lg-6">
                                                                    <c:set var="count" value="0"/>
                                                                    <c:forEach var="departmentMap" items="${departmentMap}">
                                                                        <c:choose>
                                                                            <c:when test="${(departmentMap.key) eq employeeReferral.joinerDepartment}">
                                                                                <c:set var="count" value="${count+1}"/>
                                                                                <input type="text" name="joinerDepartmentValue" id="joinerDepartmentValue" class="form-control" value="${departmentMap.value}" readonly/>
                                                                                <input type="hidden" name="joinerDepartment" id="joinerDepartment" class="form-control" value="${employeeReferral.joinerDepartment}"/>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </c:forEach>
                                                                    <c:if test="${count eq 0}">
                                                                        <input type="text" name="joinerDepartmentValue" id="joinerDepartmentValue" class="form-control" value="" readonly/>
                                                                    </c:if>
                                                                    <form:errors path="joinerDepartment" cssClass="errorDiv"></form:errors>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                <form:label path="joinersPosition" class="col-lg-4 control-label">Job Title/Position:</form:label>
                                                                    <div class="col-lg-6">
                                                                    <c:set var="counter" value="0"/>
                                                                    <c:forEach var="designationMap" items="${designationMap}">
                                                                        <c:choose>
                                                                            <c:when test="${(designationMap.key) eq employeeReferral.joinersPosition}">
                                                                                <c:set var="counter" value="${counter+1}"/>
                                                                                <input type="text" name="joinersPositionValue" id="joinersPositionValue" class="form-control" value="${designationMap.value}" readonly/>
                                                                                <input type="hidden" name="joinersPosition" id="joinersPosition" class="form-control" value="${employeeReferral.joinersPosition}"/>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </c:forEach>
                                                                    <c:if test="${counter eq 0}">
                                                                        <input type="text" name="joinersPositionValue" id="joinersPositionValue" class="form-control" value="" readonly/>
                                                                    </c:if>
                                                                    <form:errors path="joinersPosition" cssClass="errorDiv"></form:errors>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                <form:label path="joinersLocation" class="col-lg-4 control-label">Location Of Posting:</form:label>
                                                                    <div class="col-lg-6">
                                                                    <form:input path="joinersLocation" class="form-control" readonly="true"></form:input>
                                                                    <form:errors path="joinersLocation" cssClass="errorDiv"></form:errors>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                <form:label path="referralAward" class="col-lg-4 control-label">Referral Award:</form:label>
                                                                    <div class="col-lg-6">
                                                                    <form:input path="referralAward" class="form-control" readonly="true"></form:input>
                                                                    <form:errors path="referralAward" cssClass="errorDiv"></form:errors>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                <form:label path="hrRemark" class="col-lg-4 control-label">Remarks, If Any:</form:label>
                                                                    <div class="col-lg-6">
                                                                    <form:textarea path="hrRemark" class="form-control" rows="3" readonly="true"></form:textarea>
                                                                    <form:errors path="hrRemark" cssClass="errorDiv"></form:errors>
                                                                    </div>
                                                                </div>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <div class="form-group">
                                                                <form:label path="joinerName" class="col-lg-4 control-label">Name of the Joiner:</form:label>
                                                                    <div class="col-lg-6">
                                                                    <form:input path="joinerName" class="form-control"></form:input>
                                                                    <form:errors path="joinerName" cssClass="errorDiv"></form:errors>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                <form:label path="joinerDateOfJoining" class="col-lg-4 control-label">Date Of Joining:</form:label>
                                                                    <div class="col-lg-6">
                                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                        <form:input path="joinerDateOfJoining" class="form-control" size="16" type="text" readonly="true"></form:input>
                                                                        <form:errors path="joinerDateOfJoining" cssClass="errorDiv"></form:errors>
                                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                <form:label path="joinerEmployeeNo" class="col-lg-4 control-label">Employee No.:</form:label>
                                                                    <div class="col-lg-6">
                                                                    <form:input path="joinerEmployeeNo" class="form-control" maxlength="10"></form:input>
                                                                    <form:errors path="joinerEmployeeNo" cssClass="errorDiv"></form:errors>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                <form:label path="joinerDepartment" class="col-lg-4 control-label">Department:</form:label>
                                                                    <div class="col-lg-6">
                                                                    <form:select path="joinerDepartment" class="form-control">
                                                                        <form:option value="" label="-- Select --" />
                                                                        <form:options items="${departmentMap}"/>
                                                                    </form:select>
                                                                    <form:errors path="joinerDepartment" cssClass="errorDiv"></form:errors>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                <form:label path="joinersPosition" class="col-lg-4 control-label">Job Title/Position:</form:label>
                                                                    <div class="col-lg-6">
                                                                    <form:select path="joinersPosition" class="form-control">
                                                                        <form:option value="" label="-- Select --" />
                                                                        <form:options items="${designationMap}"/>
                                                                    </form:select>
                                                                    <form:errors path="joinersPosition" cssClass="errorDiv"></form:errors>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                <form:label path="joinersLocation" class="col-lg-4 control-label">Location Of Posting:</form:label>
                                                                    <div class="col-lg-6">
                                                                    <form:input path="joinersLocation" class="form-control"></form:input>
                                                                    <form:errors path="joinersLocation" cssClass="errorDiv"></form:errors>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                <form:label path="referralAward" class="col-lg-4 control-label">Referral Award:</form:label>
                                                                    <div class="col-lg-6">
                                                                    <form:input path="referralAward" class="form-control"></form:input>
                                                                    <form:errors path="referralAward" cssClass="errorDiv"></form:errors>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                <form:label path="hrRemark" class="col-lg-4 control-label">Remarks, If Any:</form:label>
                                                                    <div class="col-lg-6">
                                                                    <form:textarea path="hrRemark" class="form-control" rows="3"></form:textarea>
                                                                    <form:errors path="hrRemark" cssClass="errorDiv"></form:errors>
                                                                    </div>
                                                                </div>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div><!-- /.box-body -->
                                </c:if>
                                <!--Joiner Detail Fill Up Completes Here-->
                                <!--                                status = 0 means pending forapproval
                                                                status = 1 means Approved
                                                                status = 2 means returned By Hr
                                                                status = 3 means withdraw by employee
                                                                status = 4 means withdraw approve
                                                                status = 5 means canceled by employee-->
                                <c:choose>
                                    <c:when test="${sessionScope.userRight.employeeReferral or (sessionScope.employeeInfo.id eq finalApprover)}">
                                        <div class="form-group">
                                            <c:if test="${employeeReferral.id eq null}">
                                                <div class="col-sm-6" style="text-align: left;">
                                                    <button type="submit" value="Submit" id="buttonPressed" class="btn btn-primary" data-original-title="" onclick="cickToSubmit(this.value);" style="width: 100px">SUBMIT</button>
                                                </div>
                                                <div class="col-sm-6" style="text-align: right;">
                                                    <button type="button" value="back" onclick="window.history.back()" id="buttonPressed" class="btn btn-warning" data-original-title="" style="width: 100px">BACK</button>
                                                </div>
                                            </c:if>
                                            <c:if test="${ (employeeReferral.status eq 1) && !(sessionScope.employeeInfo.id eq finalApprover)}">
                                                <div class="col-sm-12" style="text-align: center;">
                                                    <button type="submit" value="SubmitByEmpRef" id="buttonPressed" class="btn btn-primary" data-original-title="" onclick="cickToSubmit(this.value);" style="width: 100px">SUBMIT</button>
                                                </div>
                                                <!--<div class="col-sm-4" style="text-align: center;">-->
                                                <!--                                                <div class="col-sm-6" style="text-align: right;">
                                                                                                    <button type="button" onclick="window.location.href = 'employeeReferral.htm?act=cancelReferrl&id=${param.id}'" value="reject" class="btn btn-danger" data-original-title="" style="width: 100px;" title="">REJECT</button>
                                                                                                </div>-->
                                                <!--                                                <div class="col-sm-4" style="text-align: right;">
                                                                                                    <button type="submit" value="return" id="buttonPressed" class="btn btn-warning" data-original-title="" onclick="cickToSubmit(this.value);" style="width: 100px;" title="">RETURN</button>
                                                                                                </div>-->
                                            </c:if>
                                               
                                            <c:if test="${ (employeeReferral.status eq 2) && (sessionScope.employeeInfo.id eq finalApproverByHeHead)}">
                                                <div class="col-sm-12" style="text-align: center;">
                                                    <button type="Submit" value="ApproveFinalByHr" id="buttonPressed" class="btn btn-success" data-original-title="" onclick="cickToSubmit(this.value);" style="width: 100px">APPROVE</button>
                                                </div>
                                            </c:if >
                                            <%--<c:if test="${ employeeReferral.status eq 3}">--%>
                                            <!--<div class="col-sm-6" style="text-align: left;">-->
                                                <!--<button type="button" onclick="window.location.href = 'employeeReferral.htm?act=approveWithdraw&id=${param.id}'" value="approveWithdraw" id="buttonPressed" class="btn btn-success" data-original-title="" style="width: 100px">APPROVE</button>-->
                                            <!--</div>-->
                                            <!--<div class="col-sm-6" style="text-align: right;">-->
                                                <!--<button type="button" onclick="window.location.href = 'employeeReferral.htm?act=cancelReferrl&id=${param.id}'" value="return"  class="btn btn-danger" data-original-title="" style="width: 100px" title="">CANCEL</button>-->
                                            <!--</div>-->
                                            <%--</c:if>--%>                                        
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="form-group">
                                            <%--<c:if test="${ (employeeReferral.status eq 0 and not empty param.id) or (employeeReferral.status eq 1 and not empty param.id)}">--%>
                                            <!--<div class="col-sm-12" style="text-align: center;">-->
                                                <!--<button type="button" value="withdraw" onclick="window.location.href = 'employeeReferral.htm?act=withdrawReferral&id=${param.id}'" id="buttonPressed" class="btn btn-warning" data-original-title="" style="width: 100px">WITHDRAW</button>-->
                                            <!--</div>-->
                                            <%--</c:if>--%>
                                            <%--<c:if test="${employeeReferral.status eq 2 and not empty param.id}">--%>
                                            <%--<form:hidden path="status" value="2"></form:hidden>--%>
                                            <!--<div class="col-sm-6" style="text-align: left;">-->
                                            <!--<button type="submit" value="submitAgain" id="buttonPressed" class="btn btn-primary" data-original-title="" onclick="cickToSubmit(this.value);" style="width: 100px" >SUBMIT</button>-->
                                            <!--</div>-->
                                            <!--<div class="col-sm-6" style="text-align: right;">-->
                                                <!--<button type="button" value="withdraw" onclick="window.location.href = 'employeeReferral.htm?act=withdrawReferral&id=${param.id}'" id="buttonPressed" class="btn btn-warning" data-original-title="" style="width: 100px">WITHDRAW</button>-->
                                            <!--</div>-->
                                            <%--</c:if>--%>
                                            <c:if test="${empty param.id}">
                                                <div class="col-sm-6" style="text-align: left;">
                                                    <button type="submit" value="Submit" id="buttonPressed" class="btn btn-primary" data-original-title="" onclick="cickToSubmit(this.value);" style="width: 100px">SUBMIT</button>
                                                </div>
                                                <div class="col-sm-6" style="text-align: right;">
                                                    <button type="button" value="back" onclick="window.history.back()" id="buttonPressed" class="btn btn-warning" data-original-title="" style="width: 100px">BACK</button>
                                                </div>
                                            </c:if>
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                                <div class="modal fade" id="myModal" role="dialog">
                                    <div class="modal-dialog">

                                        <!-- Modal content-->
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                <h4 class="modal-title">
                                                    <label class="col-lg-4 control-label">Remarks, If Any:
                                                        <span style="color: red;font-size: 12px;">*</span>
                                                    </label>
                                                </h4>
                                            </div>
                                            <div class="modal-body">
                                                <textarea name="rejectRemark" id="rejectRemark" class="form-control" rows="3"></textarea>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                <button type="button" class="btn btn-default" onclick="regejcrRequest();" >Ok</button>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </form:form>
                            <!--form horizontal ends here-->
                            <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <script>
        //        function getCandidateCV() {
        //            var posting = $.post('employeeReferral.htm?act=getCandidateCVFile',
        //                    {candidateCV: '${candidateCVFileName}',
        //                        candidateName: '${employeeReferral.getCandidateName()}'
        //                    });
        //            posting.done(function (data) {
        //                alert("hi");
        //            });
        //        }
        function removeCandidateCV() {
            var posting = $.post('employeeReferral.htm?act=removeCandidateCVFile',
                    {candidateCV: '${candidateCVFileName}',
                        candidateName: '${employeeReferral.getCandidateName()}'
                    });
            posting.done(function (data) {
                document.getElementById("candidateCVfileName").value = "";
                document.getElementById("downloadRemoveDiv").style.display = "none";
                location.reload(); // then reload the page.(3)
            });
        }
        function regejcrRequest() {
            var hrRemarkRejection = document.getElementById("rejectRemark").value;
            window.location = "employeeReferral.htm?act=cancelReferrl&id=${param.id}&hrRemark=" + hrRemarkRejection;
        }
    </script>
    <script>
        function checkFileSize(sender) {
            if (typeof FileReader !== "undefined" && document.getElementById('candidateCV').value !== '') {
                var fileSize = document.getElementById('candidateCV').files[0].size;

                var validExts = new Array(".docx", ".doc", ".pdf");
                var fileExt = sender.value;
                fileExt = fileExt.substring(fileExt.lastIndexOf('.'));
                //                alert("" + fileExt);
                //                alert("" + validExts.indexOf(fileExt));
                if (validExts.indexOf(fileExt) < 0) {
                    alert("Invalid file selected, valid files are of " +
                            validExts.toString() + " types.");
                    document.getElementById('candidateCV').value = '';
                    return false;
                    //                    $("#uploadDiv").hide();
                }
                if (true) {
                    //                    alert("my File size is   " + fileSize);
                    if (fileSize > 1024 * 1024) {
                        document.getElementById('candidateCV').value = '';
                        document.getElementById('candidateCVError').innerHTML = "- It must not more than 100kb";
                        return false;
                    } else {
                        document.getElementById('candidateCVError').innerHTML = '';
                        return true;
                    }
                    // check file size
                }
            }
        }
    </script>
    <script type="text/javascript">
        function cickToSubmit(buttonPressed) {
            var formAction = "";
            if (buttonPressed == "Submit") {
                formAction = "submitReferralByEmpolyee";
            }
            if (buttonPressed == "Accept") {
                formAction = "approveReferral";
            }
            if (buttonPressed == "SubmitByEmpRef") {
                formAction = "submitByEmpRef";
            }
            if (buttonPressed == "SubmitByEmpRef") {
                formAction = "submitByEmpRef";
            }
            if (buttonPressed == "ApproveFinalByHr") {
                formAction = "finalApproveByHr";
            }
            //            if (buttonPressed == "submitAgain") {
            //                formAction = "submitAgain";
            //            }
            //            if (buttonPressed == "return") {
            //                formAction = "returnReferrl";
            //            }
            $("#referralForm").attr("action", "employeeReferral.htm?act=" + formAction);
        }
        $('.form_datetime').datetimepicker({
            //language:  'fr',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0,
            showMeridian: 1

        }
        );
    </script>
    <script type="text/javascript">
        $('#mycmd').click(function () {

            var printContents = $("#printArea1").html();
            var printContents1 = $("#printArea2").html();
            var printContents2 = $("#printArea3").html();
            var popupWin = window.open('', '_blank');
            var allLinks = $("#printCss").html();
            popupWin.document.open();
            var keepColors = '<style>body {-webkit-print-color-adjust: exact !important; }</style>';

            popupWin.document.write('<html><head><title></title>' + keepColors + allLinks + '</head><body onload="setTimeout(function(){window.print();},3000);">' + printContents + printContents1 + printContents2 + '</body></html>');
            popupWin.document.close();

        });



    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
