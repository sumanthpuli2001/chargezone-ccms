<%-- 
    Document   : ViewMppShow
    Created on : 6 Mar, 2018, 2:12:48 PM
    Author     : Vikas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>View Man Power Planning</title>
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>View Man Power Planning</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">View MPP</li>
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
                                                    <label>Man Power Planning Budget:</label> &nbsp;&nbsp;&nbsp;
                                                    <span >${recruitmentMaster.budget}</span>   
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
                                                    <label>Work Experience(In Year): </label> &nbsp;&nbsp;&nbsp;
                                                    <span>${experiance}</span>   
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Location:</label>&nbsp;&nbsp;&nbsp;

                                                    <span> ${locationName}</span>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label>Number Of Position:</label> &nbsp;&nbsp;&nbsp;
                                                    <span>${position}</span>
                                                </div>

                                            </div>

                                            <table>
                                                <tr>
                                                    <td><label>Approval Comment:</label></td>
                                                    <td>
                                                        <c:forEach  var="test" items="${recruitmentMppApproval}">
                                                            &nbsp;&nbsp;<span>${test[1]}</span>
                                                             <br>
                                                        </c:forEach>
                                                    </td>
                                                </tr>
                                            </table>

                                        </form:form>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12 col-sm-12">
                                        <label><h3>Approval Detail</h3></label>
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
                                                            <td>${list[1]}</td>
                                                            <td>${list[6]}</td>
                                                            <td>${list[3]}</td>
                                                            <td><span class="label label-default">${list[5]} By&nbsp${list[1]}</span></td>
                                                            <!--<td>-->
                                                            <%--<c:if test="${list[4] eq 0}"><span class="label label-default">Pending</span></c:if>--%>
                                                            <%--<c:if test="${list[4] eq 2}"><span class="label label-default">Pending</span></c:if>--%>
                                                            <%--<c:if test="${list[4] eq 1}"><span class="label label-default">Recycle</span></c:if>--%>
                                                            <%--<c:if test="${list[4] eq 5}"><span class="label label-default">Approve</span></c:if>--%>
                                                            <%--<c:if test="${list[4] eq 3}"><span class="label label-default">Rejected</span></c:if>--%>
                                                            <%--<c:if test="${list[4] eq 4}"><span class="label label-default">Online Assessment</span></c:if>--%>

                                                            <!--</td>-->
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
