<%-- 
    Document   : priceBidComparisonSummaryViewPrint
    Created on : Apr 3, 2026, 10:35:50 AM
    Author     : Sumanth
--%>







<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNewPrint.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TENDER PRICE BID COMPARISON WITH REVISE REPORT</title>


        
    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="" commandName="departmentMaster" method="post">

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between  sticky-model0 no-print">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2  d-print-none">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0  no-print">TENDER PRICE BID COMPARISON WITH REVISE REPORT</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3 no-print">Back</a>

                            <a href="#" onclick="window.print();" class="btn btn theme-btn no-print" style="background-color: #4CAF50; border-color: #4CAF50;" >
                                <i class="fa fa-print"></i>&nbsp;&nbsp;Print
                            </a>  

                        </div>
                    </div>
                    <br>
                    <table class="table table-bordered printup" id="table_1" style="width: 100%; border-collapse: collapse;">
                        <tbody>
                            <tr>
                                <td colspan="3" style="height: 40px; text-align: center; vertical-align: middle;border: 1px solid black !important;">
                                    <img src="StorageYard/Images/logoCZ.png" style="max-height: 60px; height: auto; width: auto;">
                                </td>

                                <td colspan="4" style="text-align: center; vertical-align: middle; padding: 6px; font-weight: bold; font-size: 30px !important; border: 1px solid black !important;">
                                    TENDER PRICE BID COMPARISON WITH REVISE REPORT
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <br>
                    
                    <table class="flex-table" class="table table-bordered" style="" align="Center"  >
                        <thead>                            
                            <tr class="table-title">
                                <th colspan="8" style="text-align: center; font-size: 12px; padding: 3px 5px;">Tender Details</th>
                            </tr>
                        </thead>
                        <tbody>

                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                <th colspan="1" style="padding: 3px 5px;"><strong>Tender No</strong></th>
                                <td colspan="2" style="padding: 3px 5px;">${tenderMaster.refNo}</td>

                                <th colspan="2" style="padding: 3px 5px;"><strong>Project ID</strong></th>
                                <td colspan="3" style="padding: 3px 5px;">${tenderMaster.projectId}</td>
                            </tr>

                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                <th colspan="1" style="padding: 3px 5px;"><strong>Project Name</strong></th>
                                <td colspan="7" style="padding: 3px 5px;">${tenderMaster.title}</td>
                            </tr>

                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                <th colspan="1" style="padding: 3px 5px;"><strong>Vendor Code</strong></th>
                                <td colspan="2" style="padding: 3px 5px;">${vendorCode}- ${vendorName}</td>

                                <th colspan="2" style="padding: 3px 5px;"><strong>Department</strong></th>
                                <td colspan="3" style="padding: 3px 5px;">${tenderMaster.department}</td>
                            </tr>

                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                <th colspan="1" style="padding: 3px 5px;"><strong>Tender Date</strong></th>
                                <td colspan="2" style="padding: 3px 5px;">${tender_date}</td>

                                <th colspan="2" style="padding: 3px 5px;"><strong>Tender Due Date</strong></th>
                                <td colspan="3" style="padding: 3px 5px;">${tender_due_date}</td>
                            </tr>

                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                <th colspan="1" style="padding: 3px 5px;"><strong>PR No</strong></th>
                                <td colspan="2" style="padding: 3px 5px;">${tenderMaster.prNo}</td>

                                <th colspan="2" style="padding: 3px 5px;"><strong>Mode Of Transport</strong></th>
                                <td colspan="3" style="padding: 3px 5px;">${tenderMaster.modeOfTransport}</td>
                            </tr>

<!--                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                <th colspan="1" style="padding: 3px 5px;"><strong>Bid Sent From No. Of Vendor</strong></th>
                                <td colspan="2" style="padding: 3px 5px;">${total_vendor}</td>

                                <th colspan="2" style="padding: 3px 5px;"><strong>Bid Received From No. Of Vendor</strong></th>
                                <td colspan="3" style="padding: 3px 5px;">${total_bid}</td>
                            </tr>-->
                        </tbody>

                    </table>
                    <br>
                    <table class="flex-table" class="table table-bordered" style="" align="Center"  >
                        <thead>                            
                            <tr class="table-title">
                                <th colspan="7" style="text-align: center; font-size: 12px; padding: 3px 5px;">Vendor Details</th>
                            </tr>
                            <tr style="font-size: 11px; height: 20px;">
                                <th style="padding: 3px 5px;">Vendor Code</th>
                                <th style="padding: 3px 5px;">Contact Person</th>
                                <th style="padding: 3px 5px;">Contact Email Id</th>
                                <th style="padding: 3px 5px;">Contact No.</th>
                                <th style="padding: 3px 5px;">Quotation No.</th>
                                <th style="padding: 3px 5px;">Grand Total</th>
                                <th style="padding: 3px 5px;">Rank</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach var="list1" items="${list4}" varStatus="status">
                                <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                    <td style="padding: 3px 5px;">${list1.vendorCode}</td>
                                    <td style="padding: 3px 5px;">${list1.contactPerson}</td>
                                    <td style="padding: 3px 5px;">${list1.conactEmail}</td>
                                    <td style="padding: 3px 5px;">${list1.contactNo}</td>
                                    <td style="padding: 3px 5px;">${list1.offerNo}</td>
                                    <td style="padding: 3px 5px;" class="currency">${list1.finalTotal}</td>
                                    <td style="padding: 3px 5px;"> ${status.count}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>                    
                </form:form>
            </section>
        </main>
        <script>
          CurrencyHandler.init({ currency: '${prMaster.currency}' });
        </script>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUiComparisonFooterPrint.jsp"%>
</html>




