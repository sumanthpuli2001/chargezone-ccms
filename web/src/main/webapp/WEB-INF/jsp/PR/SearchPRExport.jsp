<%@ page contentType="text/html;application/vnd.ms-excel; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<%
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("ddMMyyyy");
    String currentDate = sdf.format(new java.util.Date());
    response.setContentType("application/vnd.ms-excel");
    response.setHeader("Content-Disposition", "attachment; filename=prList_" + currentDate + ".xls");
%>



<html>
    <head>
        <title>Search PR</title>
    </head>
    
    <div class="content-wrapper">
        
          <form:form action="prMaster.htm?act=searchPRList" method="post" commandName="employeeMaster"
                   name='form1'  class="form-horizontal" role="form">
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

                                            <table border="1px">

                                                <thead>
                                                    <tr>
                                                        <th>Sr. No.</th>
                                                        <th>PR Number</th>
                                                        <th>Project Name</th>
                                                        <th>Project ID</th>
                                                        <th>PR Subject Description</th>
                                                        <th>Department</th>
                                                        <th>Billing Location</th>
                                                        <th>Created By</th>
                                                        <th>PR Date Time</th>
                                                        <th>PR Approval User</th>
                                                        <th>PR Approval Date</th>
                                                        <th>Tender Assign To</th>
                                                        <th>Tender Assign By</th>
                                                        <th>Tender Assign Date</th>
                                                        <th>Tender Create By</th>
                                                        <th>Tender Create Date</th>
                                                        <th>Technical Bid Open By</th>
                                                        <th>Technical Bid Open Date</th>
                                                        <th>Technical Bid Approve By</th>
                                                        <th>Technical Bid Approve Date</th>
                                                        <th>Price Bid Initiate By</th>
                                                        <th>Price Bid Initiate Date</th>
                                                        <th>Price Bid Open By</th>
                                                        <th>Price Bid Open Date</th>
                                                        <th>Tender Award By</th>
                                                        <th>Tender Award Date</th>
                                                        <th>Accept By</th>
                                                        <th>Accept Date</th>
                                                        <th>Final Close By</th>
                                                        <th>Final Close Date</th>
                                                        <th>Approval Status</th>
                                                    </tr>
                                                </thead>

                                                <tbody>

                                                    <c:set var="count" value="0" scope="page" />

                                                    <c:forEach var="pr" items="${list}">

                                                        <tr>

                                                            <c:set var="count" value="${count + 1}" scope="page"/>

                                                            <td>${count}</td>

                                                            <td>${pr.prNo}</td>

                                                            <td>${pr.title}</td>

                                                            <td>${pr.projectId}</td>

                                                            <td>${pr.workDesc}</td>

                                                            <td>${pr.department}</td>

                                                            <td>${pr.billingLocation}</td>

                                                            <td>${pr.contactPerson}</td>

                                                            <td>${pr.announceDate}</td>

                                                            <td>${pr.prAuthorizeUser}</td>

                                                            <td>${pr.prAuthorizeDate}</td>

                                                            <td>${pr.tenderCreaterId}</td>

                                                            <td>${pr.tenderAssignUser}</td>

                                                            <td>${pr.tenderAssignDate}</td>

                                                            <td>${pr.tenderCreaterUser}</td>

                                                            <td>${pr.tenderCreaterDate}</td>

                                                            <td>${pr.techBidOpenUser}</td>

                                                            <td>${pr.techBidOpenDate}</td>

                                                            <td>${pr.techBidApproveUser}</td>

                                                            <td>${pr.techBidApproveDate}</td>

                                                            <td>${pr.priceBidStartUser}</td>

                                                            <td>${pr.priceBidStartDate}</td>

                                                            <td>${pr.priceBidOpenUser}</td>

                                                            <td>${pr.priceBidOpenDate}</td>

                                                            <td>${pr.tenderAwardUser}</td>

                                                            <td>${pr.tenderAwardDate}</td>

                                                            <td>${pr.tenderAcceptUser}</td>

                                                            <td>${pr.tenderAcceptDate}</td>

                                                            <td>${pr.finalCloseUser}</td>

                                                            <td>${pr.finalCloseDate}</td>

                                                            <td>

                                                                <c:choose>

                                                                    <c:when test="${not empty pr.finalCloseDate}">
                                                                        Po Closed
                                                                    </c:when>

                                                                    <c:when test="${pr.authorizeFlag == 0}">
                                                                        Pending
                                                                    </c:when>

                                                                    <c:when test="${pr.authorizeFlag == 1}">
                                                                        Approve
                                                                    </c:when>

                                                                    <c:when test="${pr.authorizeFlag == 2}">
                                                                        Rework
                                                                    </c:when>

                                                                    <c:when test="${pr.authorizeFlag == 3}">
                                                                        Reject
                                                                    </c:when>

                                                                    <c:when test="${pr.authorizeFlag == 6}">
                                                                        Tender Created
                                                                    </c:when>

                                                                    <c:otherwise>
                                                                        Unknown Status
                                                                    </c:otherwise>

                                                                </c:choose>

                                                            </td>

                                                        </tr>

                                                    </c:forEach>

                                                </tbody>

                                            </table>


                                        </div>

                                    </div><!-- /.tab-pane -->
                                </div>
                            </div><!-- /.tab-content -->

                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
            </section>
        </form:form>
    </div>
</html>
