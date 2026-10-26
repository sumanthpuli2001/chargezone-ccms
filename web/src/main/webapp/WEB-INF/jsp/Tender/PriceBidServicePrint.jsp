
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNewPrint.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendor  Price Bid View</title>
        <script language="javascript" type="text/javascript">
            function gettender()
            {

                var t = document.getElementById("refNo").value;
                var tenderPhase = document.getElementById("tenderPhase").value;
                window.location = 'tenderMaster.htm?act=getTender&refNo=' + t + '&tenderPhase=' + tenderPhase;
            }

        </script>
    </head>
    <body>
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNewVendor.jsp"%>
            <section class="main-content">
                <form:form action="tenderMaster.htm?act=submitTenderMaster" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                           class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2  d-print-none">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0  no-print">Vendor  Price Bid View</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3 no-print">Back</a>
                            <a href="" onclick="window.print();" class="btn btn theme-btn no-print" style="background-color: #4CAF50; border-color: #4CAF50;" >
                                <i class="fa fa-print"></i>&nbsp;&nbsp;Print
                            </a>

                        </div>
                    </div>
                    <br>
                    <table class="table table-bordered printup" id="table_1" style="width: 100%; border-collapse: collapse;">
                        <tbody>
                            <tr>
                                <td colspan="3" style="height: 40px; text-align: center; vertical-align: middle; border: 1px solid black !important;">
                                    <img src="StorageYard/Images/logo.png" style="max-height: 30px;">
                                </td>

                                <td colspan="4" style="text-align: center; vertical-align: middle; padding: 6px; font-weight: bold; font-size: 16px; border: 1px solid black !important;">
                                    Price Bid View
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <br>
                    <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                        <tr class="table-title">
                            <td colspan="12" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                Tender information
                            </td>
                        </tr>

                        <tr style="font-size:11px; height:20px;">
                            <td colspan="1" style="padding:3px 5px;"><strong>Tender No:</strong></td>
                            <td colspan="9"style="padding:3px 5px;">${refNo}</td>

                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="1"  style="padding:3px 5px;"><strong>Project Name</strong></td>
                            <td colspan="2" style="padding:3px 5px;">${title}</td>
                            <td colspan="3" style="padding:3px 5px;"><strong>Project ID</strong></td>
                            <td colspan="2"style="padding:3px 5px;">${projectId}</td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="1" style="padding:3px 5px;"><strong>RFQ No.</strong></td>
                            <td colspan="2"style="padding:3px 5px;">${rfqNo}</td>
                            <td colspan="3"  style="padding:3px 5px;"><strong>Vendor Name</strong></td>
                            <td colspan="2" style="padding:3px 5px;">${vendorCode} ${vendorName}</td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="1"  style="padding:3px 5px;"><strong>Tender Date Time</strong></td>
                            <td colspan="2" style="padding:3px 5px;">${announceDate} </td>
                            <td colspan="3" style="padding:3px 5px;"><strong>Due Date Time:</strong></td>
                            <td colspan="2"style="padding:3px 5px;">${submitLastdate}</td>

                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="1"  style="padding:3px 5px;"><strong>PR No</strong></td>
                            <td colspan="9" style="padding:3px 5px;">${prNo} </td>
                        </tr>
                        </table>
                        <br>
                            <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="12" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                    Tender Contact Person
                                </td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Created by:</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${contactPerson}</td>
                                <td colspan="3"  style="padding:3px 5px;"><strong>Number</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${tenderAdminContactNumber} </td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Authorize by:</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${tenderAuthorizePerson}</td>
                                <td colspan="3"  style="padding:3px 5px;"><strong>Number</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${tenderAuthorizeContactNo} </td>
                            </tr>
                        </table>
                        <br>
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="12" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                    Vendor Quotation Details
                                </td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Quotation No:</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${offerNo}</td>
                                <td colspan="3"  style="padding:3px 5px;"><strong>Date</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${offerDate} </td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Contact Person:</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${contact_person}</td>
                                <td colspan="3"  style="padding:3px 5px;"><strong>Contact Number</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${contact_no} </td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Contact Email:</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${contact_email}</td>
                                <td colspan="3"  style="padding:3px 5px;"><strong>GST No</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${gst_no} </td>
                            </tr> 
                        </table>
                        <br>
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="12" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;"> Item Details
                                    </th>
                            </tr>
                            <tr>
                                <th colspan="1"  style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;   ">Sr. No.</th>
                                <th colspan="1" style=" vertical-align: middle; font-size: 9px; padding:3px 5px;">Item Description</th>                                   
                                <th colspan="1"  style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">UOM</th>
                                <th colspan="1" style=" vertical-align: middle; font-size: 9px; padding:3px 5px;">Quantity </th> 
                                <th colspan="1" style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Unit Rate </th> 
                                <th colspan="1"  style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Amount </th> 
                                <th colspan="1" style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">HSN No. </th> 
                                <th colspan="1"  style=" vertical-align: middle; font-size: 9px; padding:3px 5px;">Vendor Remark </th> 
                            </tr>
                            <tbody>
                                <c:forEach var="serviceVendorTenderBidItem1" items="${serviceVendorTenderBidItem11_1}" varStatus="status">
                                    <tr>
                                        <td style="font-size: 9px; padding: 3px 5px;"> ${status.count}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${serviceVendorTenderBidItem1.itemDesc}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${serviceVendorTenderBidItem1.uom}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${serviceVendorTenderBidItem1.quantity}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${serviceVendorTenderBidItem1.rate}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${serviceVendorTenderBidItem1.netRate}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${serviceVendorTenderBidItem1.hsnNo}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${serviceVendorTenderBidItem1.vendorRemark}</td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                        <br>
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="12" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">Vendor Terms & Condition </th>
                            </tr>    
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Delivery Location</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${deliveryLocation}</td>
                                <td colspan="3"  style="padding:3px 5px;"><strong>Delivery Period (In Weeks)</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${deliveryPeriod} </td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Terms of Payment</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${termsOfPayment}</td>
                                <td colspan="3"  style="padding:3px 5px;"><strong>Validity Period</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${validityPeriod} </td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Mode of Transport</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${modeOfTransport}</td>
                                <td colspan="3"  style="padding:3px 5px;"><strong>Inco Terms</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${incoTerms} </td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Insurance</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${insurance}</td>
                                <td colspan="3"  style="padding:3px 5px;"><strong>Freight</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${freight} </td>
                            </tr> 
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Total</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${total1}</td>
                                <td colspan="3"  style="padding:3px 5px;"><strong>Total in word</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${total_word} </td>
                            </tr>                             
                        </table>
                    </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooterPrint.jsp"%>
</html>
