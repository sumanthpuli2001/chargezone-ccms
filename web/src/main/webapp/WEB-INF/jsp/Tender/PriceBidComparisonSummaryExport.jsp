 <%@ page contentType="text/html;application/vnd.ms-excel; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<%
    response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=tenderPriceComparisonReport.xls");
%> 
<html>
    <head>
        <title>Tender Price Comparison</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
       
        <script src="StorageYard/assets/js/currency.js" type="text/javascript"></script>
        <!-- Main content -->
        <form:form action="employeeMaster.htm?act=disableEmployee" method="post" commandName="employeeMaster"
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
                                            <table border="1px" class="table table-bordered table-striped table-hover" style="width:100%; font-size: 12px;" align="center">

                                                <thead>
                                                    <tr>
                                                        <th colspan="7" style="text-align:center; background:#f2f2f2;">
                                                            Tender Information
                                                        </th>
                                                    </tr>
                                                </thead>

                                                <tbody>
                                                    <tr>
                                                        <td><b>Tender No</b></td>
                                                        <td>${tenderMaster.refNo}</td>

                                                        <td><b>Project Name</b></td>
                                                        <td>${tenderMaster.title}</td>

                                                        <td><b>Project ID</b></td>
                                                        <td>${tenderMaster.projectId}</td>
                                                        <td></td>
                                                    </tr>

                                                    <tr>
                                                        <td><b>PR No</b></td>
                                                        <td>${tenderMaster.prNo}</td>

                                                        <td><b>Billing Location</b></td>
                                                        <td>${tenderMaster.location}</td>

                                                        <td><b>Tender Date</b></td>
                                                        <td>${tender_date}</td>
                                                        <td></td>
                                                    </tr>

                                                    <tr>
                                                        <td><b>Tender Due Date</b></td>
                                                        <td>${tender_due_date}</td>

                                                        <td><b>Created By</b></td>
                                                        <td>${tenderMaster.contactPerson}</td>

                                                        <td><b>Contact No</b></td>
                                                        <td>${tenderMaster.tenderAdminContactNumber}</td>
                                                        <td></td>
                                                    </tr>

                                                    <tr>
                                                        <td><b>Bid Sent Vendors</b></td>
                                                        <td>${total_vendor}</td>

                                                        <td><b>Bid Received Vendors</b></td>
                                                        <td>${total_bid}</td>

                                                        <td></td>
                                                        <td></td>
                                                        <td></td>
                                                    </tr>

                                                    <tr>
                                                        <th colspan="7" style="text-align:center; background:#f2f2f2;">
                                                            Vendor Information
                                                        </th>
                                                    </tr>

                                                    <tr>
                                                        <th>Vendor Code</th>
                                                        <th>Contact Person</th>
                                                        <th>Email</th>
                                                        <th>Contact No</th>
                                                        <th>Quotation No</th>
                                                        <th>Grand Total</th>
                                                        <th>Rank</th>
                                                    </tr>

                                                    <c:forEach var="list1" items="${list4}" varStatus="status">
                                                        <tr>
                                                            <td>${list1.vendorCode}</td>
                                                            <td>${list1.contactPerson}</td>
                                                            <td>${list1.conactEmail}</td>
                                                            <td>${list1.contactNo}</td>
                                                            <td>${list1.offerNo}</td>
                                                            <td class="currency">${list1.finalTotal}</td>
                                                            <td>${status.count}</td>
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
        </form:form><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <script>
      CurrencyHandler.init({ currency: '${prMaster.currency}' });
    </script>
</html>


