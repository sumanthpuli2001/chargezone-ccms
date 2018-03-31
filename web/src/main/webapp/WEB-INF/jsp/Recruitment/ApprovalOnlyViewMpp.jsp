<%-- 
    Document   : ApprovalOnlyViewMpp
    Created on : 23 Mar, 2018, 5:58:39 PM
    Author     : Vikas
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
            <h1>View MPR</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">View MPR</li>
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
                                        <form:form class="form-horizontal" method="post"
                                                   commandName="recruitmentMaster" action="recruitment.htm?act=detailCreateForMpr">

                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Location:</label> &nbsp;&nbsp;&nbsp;
                                                    <span> ${locationName}</span>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label>Department:</label> &nbsp;&nbsp;&nbsp;
                                                    <span>${departmentName}</span>    
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Job Type:</label>  &nbsp;&nbsp;&nbsp;
                                                    <span >${jobtypeNAme}</span>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label>Job Role:</label>  &nbsp;&nbsp;&nbsp;
                                                    <span >${designationName}</span>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Number Of Position:</label> &nbsp;&nbsp;&nbsp;
                                                    <span>${position}</span>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label>Budget(Yearly):</label> &nbsp;&nbsp;&nbsp;
                                                    <span>${budget}</span>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Work Experience(In Year):</label> &nbsp;&nbsp;&nbsp;
                                                    <span>${experiance}</span>   
                                                </div>
                                            </div>
                                        </form:form>

                                    </div>
                                </div>
                                <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">
                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="center"  >
                                                    <c:choose>
                                                        <c:when test="${empty list}">
                                                            <tr>
                                                                <td align="center">
                                                                    <c:out value="There is no record found."></c:out>
                                                                    </td>
                                                                </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <%--<c:if test="${sessionScope.userRight.hr}">--%>
                                                                        <!--<th style="width: 1px;text-align: center;"><input type="checkbox" id="toggleId"/></th>-->
                                                                        <%--</c:if>--%>
                                                                    <!--<th>user id</th>-->
                                                                    <th style="width: 50px;">Name</th>
                                                                    <th style="width: 50px;">Date</th>
                                                                    <th style="width: 50px;">Comment</th>
                                                                    <th style="width: 50px;">Status</th>
                                                                    
                                                                        <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>
                                                                        <%--</c:if>--%>

                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="list" items="${list}">
                                                            <tr>
                                                                <%--<c:if test="${sessionScope.userRight.hr}">--%>
                                                                    <!--<td align="center" style="width: 1px;"><input type="checkbox" id="checkId" name="checkId"  value="${list[0]}"  /></td>-->
                                                                    <%--</c:if>--%>
                                                                <!--<td>/</td>-->
                                                                <td>${list[3]}</td>
                                                                <td>${list[4]}</td>
                                                                <td>${list[5]}</td>
                                                                <td>
                                                                    <c:if test="${list[8] eq 1}"><span class="label label-default">New Applicant</span></c:if>
                                                                    <c:if test="${list[8] eq 2}"><span class="label label-default">Shortlisted</span></c:if>
                                                                    <c:if test="${list[8] eq 3}"><span class="label label-default">Rejected</span></c:if>
                                                                    <c:if test="${list[8] eq 4}"><span class="label label-default">Online Assessment</span></c:if>
                                                                    <c:if test="${list[8] eq 5}"><span class="label label-default">Assessment Submission </span></c:if>
                                                                    <c:if test="${list[8] eq 6}"><span class="label label-default">Assessment Pass </span></c:if>
                                                                    <c:if test="${list[8] eq 7}"><span class="label label-default">Assessment Fail</span></c:if>
                                                                    <c:if test="${list[8] eq 8}"><span class="label label-default">F2F interview Invitation</span></c:if>
                                                                    <c:if test="${list[8] eq 9}"><span class="label label-default">Candidate On hold</span></c:if>
                                                                    <c:if test="${list[8] eq 10}"><span class="label label-default">Candidate Rejected </span></c:if>
                                                                    <c:if test="${list[8] eq 11}"><span class="label label-default">Candidate Selected</span></c:if>
                                                                    <c:if test="${list[8] eq 12}"><span class="label label-default">Employee Induction</span></c:if>
                                                                    <c:if test="${list[8] eq 13}"><span class="label label-default">Employee On board </span></c:if>
                                                                    <c:if test="${list[8] eq 14}"><span class="label label-default">Send Offer Later </span></c:if>
                                                                    </td>
                                                                <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>
                                                               
                                                                <%--</c:if>--%>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>


                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>

    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

</html>
