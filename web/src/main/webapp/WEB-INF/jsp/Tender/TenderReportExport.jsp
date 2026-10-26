 <%@ page contentType="text/html;application/vnd.ms-excel; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<%
    response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=mult_table.xls");
%> 
<html>
    <head>
        <title>Tender Report</title>
    </head>
    
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <form:form action="tenderMaster.htm?act=tenderReportList" method="post" commandName="employeeMaster"
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
                                            
<!--                                            <div class="table">-->

                                              
                                                <table  style="padding:  0px;margin-bottom: 0px;" border="1px">
                                                    <c:choose>
                                                        <c:when test="${empty list}">
                                                            <tr>
                                                                <td align="Center">There Is No Any Record</td>
                                                            </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th>Sr. No.</th>
                                                                    <th>Tender No.</th>
                                                                    
                                                                    <th>Project Name</th>
                                                                    <th>Tender Start Date</th>
                                                                    <th>Tender End Date</th>
                                                                    <th>EMD</th>
                                                                    <th>Created By</th>
                                                                    <th>Tender Type</th>
                                                                   
                                                                    <th>Bid Sent To No. Of Vendor</th>
                                                                    <th>Bid Received/Regret From No. Of Vendor</th>
                                                                    <th>Bid Status</th>
                                                                        
                                                                </tr>
                                                            </thead>
                                                            <c:set var="count" value="0" scope="page" />
                                                            <tbody>
                                                                <c:forEach var="list" items="${bs}" varStatus="status">
                                                                    <tr>
                                                                        <td>${status.count}</td>
                                                                        <td>${list.refNo}</td>
                                                                       
                                                                        <td>${list.title}</td>
                                                                        <td>${list.tender_date}</td>
                                                                        <td>${list.tender_due_date}</td>
                                                                        <td>${list.emd}</td>
                                                                        <td>${list.created_by}</td>
                                                                        <td>${list.tenderPhase} Part</td>
                                                                        
                                                                        <td>
                                                                            ${list.vendor_total}
                                                                        </td>
                                                                        <td>
                                                                            ${list.total_bid}/${list.total_regret}
                                                                        </td>
                                                                        <td>
                                                                            ${list.bid_status}
                                                                        </td>
                                                                    </tr>
                                                                </c:forEach>
                                                            </tbody>

                                                        </c:otherwise>
                                                    </c:choose>
                                                </table>
                                                
<!--                                            </div>-->
                                        </div>

                                    </div><!-- /.tab-pane -->
                                </div>
                            </div><!-- /.tab-content -->
                            
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
            </section>
        </form:form><!-- /.content -->
    </div><!-- /.content-wrapper -->
</html>


