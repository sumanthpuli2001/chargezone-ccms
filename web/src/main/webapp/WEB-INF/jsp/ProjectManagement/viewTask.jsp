<%-- 
    Document   : viewTask
    Created on : Jul 7, 2018, 12:22:19 PM
    Author     : Aman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>View MPR</title>
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>VIEW TASK</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">View Task</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>

        <form:form class="form-horizontal" method="post"
                   commandName="mprMaster" action="recruitment.htm?act=detailCreateForMpr">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <h3>&nbsp; Basic:</h3>
                            <div class="tab-content">
                                <div class="form-group">
                                    <div class="col-sm-6">
                                        <label>Project Name:</label> &nbsp;&nbsp;&nbsp;
                                        <span>${createTask.name}</span> 
                                    </div>
                                    <div class="col-sm-6">
                                        <label>Planned Start:</label> &nbsp;&nbsp;&nbsp;
                                        <span>${createTask.plannedStart}</span> 
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-6">
                                        <label>Planned Finish:</label> &nbsp;&nbsp;&nbsp;
                                        <span>${createTask.plannedFinish}</span> 
                                    </div>
                                    <div class="col-sm-6">
                                        <label>Manually Schedule:</label> &nbsp;&nbsp;&nbsp;
                                        <c:if test="${createTask.manuallySchedule eq true}">
                                            Yes
                                        </c:if>
                                        <c:if test="${createTask.manuallySchedule eq false}">
                                            No
                                        </c:if>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-6">
                                        <label>Duration:</label> &nbsp;&nbsp;&nbsp;
                                        <span>${createTask.duration}</span> 
                                    </div>
                                    <div class="col-sm-6">
                                        <label>Planned Effort:</label> &nbsp;&nbsp;&nbsp;
                                        <span>${createTask.plannedEffort}</span> 
                                    </div>
                                </div>

                                <!--</div>-->
                                <h3> Advanced</h3>
                                <!--<div class="tab-content">-->
                                <div class="form-group">
                                    <div class="col-sm-6">
                                        <label> Task % Completed:</label> &nbsp;&nbsp;&nbsp;
                                        <span>${createTask.taskCompleted}</span> 
                                    </div>
                                    <div class="col-sm-6">
                                        <label>Priority:</label> &nbsp;&nbsp;&nbsp;
                                        <span>${priorityMaster.name}</span> 
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-6">
                                        <label> Allow Time Logging:</label> &nbsp;&nbsp;&nbsp;
                                        <c:if test="${createTask.timeLogging eq true}">
                                            Yes
                                        </c:if>
                                        <c:if test="${createTask.timeLogging eq false}">
                                            No
                                        </c:if>
                                    </div>
                                    <div class="col-sm-6">
                                        <label>Actual Start:</label> &nbsp;&nbsp;&nbsp;
                                        <span>${createTask.actualStart}</span> 
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-6">
                                        <label>Actual Finish:</label> &nbsp;&nbsp;&nbsp;
                                        <span>${createTask.actualFinish}</span> 
                                    </div>

                                </div>
                                <h3> Financial</h3>
                                <div class="form-group">
                                    <div class="col-sm-6">
                                        <label>Budget:</label> &nbsp;&nbsp;&nbsp;
                                        <span>${createTask.budget}</span> 
                                    </div>
                                    <div class="col-sm-6">
                                        <label>Planned Labor Cost:</label> &nbsp;&nbsp;&nbsp;
                                        <span>${createTask.plannedLabourCost}</span> 
                                    </div>

                                </div>
                                <div class="form-group">
                                    <div class="col-sm-6">
                                        <label>Planned Fixed Cost:</label> &nbsp;&nbsp;&nbsp;
                                        <span>${createTask.plannedFixedCost}</span> 
                                    </div>
                                    <div class="col-sm-6">
                                        <label>Billing Type:</label> &nbsp;&nbsp;&nbsp;
                                        <span>${createTask.billingType}</span> 
                                    </div>
                                </div>
                                <h3>Resources</h3>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">
                                                <table class="table table-bordered table-striped table-hover" >
                                                    <c:choose>
                                                        <c:when test="${empty list}">
                                                            <tr>
                                                                <td align="center">
                                                                    <c:out value="There is no Resources found."></c:out>
                                                                    </td>
                                                                </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>
                                                                    <%--</c:if>--%>
                                                                    <th style="width: 50px;">Department</th>
                                                                    <th style="width: 50px;">Employee</th>
                                                                    <th style="width: 50px;">Authorize</th>
                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="list" items="${list}">
                                                            <tr>
                                                                <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>
                                                                <%--</c:if>--%>
                                                                <!--<td>/</td>-->
                                                                <td>${list[1]}</td>
                                                                <td>${list[2]}</td>
                                                                <td>
                                                                    <c:if test="${list[3] eq true}">
                                                                        Yes
                                                                    </c:if>
                                                                    <c:if test="${list[3] eq false}">
                                                                        No
                                                                    </c:if>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>  
                                <!--</div>-->
                                <h3> Attachment</h3>
                                <!--<div class="tab-content">-->
                                <c:choose>
                                    <c:when test="${empty attachementList}">
                                        <c:out value="(Their is No Attachement)"></c:out>
                                    </c:when>
                                </c:choose>
                                <c:forEach var="list" items="${attachementList}">
                                    <a href="${list[0]}">${list[1]}</a><br>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form:form>
    </div>

    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

</html>
