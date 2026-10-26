
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNewPrint.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendor Pre Qualification View</title>
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
                            <h5 class="fw-600 mb-0  no-print">Vendor Pre Qualification View</h5>
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
                                    Vendor Pre Qualification View
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <br>
                    <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                        <tr class="table-title">
                            <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                Tender information
                            </td>
                        </tr>

                        <tr style="font-size:11px; height:20px;">
                            <td colspan="1" style="padding:3px 5px;"><strong>Tender No:</strong></td>
                            <td colspan="2"style="padding:3px 5px;">${refNo}</td>
                            <td colspan="1"  style="padding:3px 5px;"><strong>Tender Title</strong></td>
                            <td colspan="2" style="padding:3px 5px;">${title}</td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="1" style="padding:3px 5px;"><strong>RFQ No.</strong></td>
                            <td colspan="2"style="padding:3px 5px;">${rfqNo}</td>
                            <td colspan="1"  style="padding:3px 5px;"><strong>Vendor Name</strong></td>
                            <td colspan="2" style="padding:3px 5px;">${vendorCode} ${vendorName}</td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="1"  style="padding:3px 5px;"><strong>Tender Date Time</strong></td>
                            <td colspan="2" style="padding:3px 5px;">${announceDate} </td>
                            <td colspan="1" style="padding:3px 5px;"><strong>Due Date Time:</strong></td>
                            <td colspan="2"style="padding:3px 5px;">${submitLastdate}</td>

                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="1"  style="padding:3px 5px;"><strong>PR No</strong></td>
                            <td colspan="9" style="padding:3px 5px;">${prNo} </td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td style="padding:3px 5px;"><strong>Tender Pre Qualification Remark</strong></td>
                            <td colspan="7" style="padding:3px 5px;">${preQualificationRemark}</td>
                        </tr>
                    </table>
                    <br>
                    <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                        <tr class="table-title">
                            <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                Tender Contact Person
                            </td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="1" style="padding:3px 5px;"><strong>Created by:</strong></td>
                            <td colspan="2"style="padding:3px 5px;">${contactPerson}</td>
                            <td colspan="1"  style="padding:3px 5px;"><strong>Number</strong></td>
                            <td colspan="2" style="padding:3px 5px;">${tenderAdminContactNumber} </td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="1" style="padding:3px 5px;"><strong>Authorize by:</strong></td>
                            <td colspan="2"style="padding:3px 5px;">${tenderAuthorizePerson}</td>
                            <td colspan="1"  style="padding:3px 5px;"><strong>Number</strong></td>
                            <td colspan="2" style="padding:3px 5px;">${tenderAuthorizeContactNo} </td>
                        </tr>
                    </table>
                        <br>
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                    Vendor Quotation Details
                                </td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Quotation No:</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${offerNo}</td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>Date</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${offerDate} </td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Contact Person:</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${contact_person}</td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>Contact Number</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${contact_no} </td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Contact Email:</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${contact_email}</td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>GST No</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${gst_no} </td>
                            </tr>
                        </table>
                        <br>
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">Attachment By Vendor
                             </tr>
                            <tr>
                                <th colspan="1" style=" vertical-align: middle; font-size: 9px; padding: 3px 4px;  white-space: nowrap;">Sr. No.</th>
                                <th colspan="2" style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Item Description</th>                                   
                                <th colspan="1" style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Attachment Required</th>
                                <th colspan="2" style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Attachment </th> 
                            </tr>
                            <tbody>
                                <c:forEach var="vendorPreBidAttachment" items="${vendorPreBidAttachment}" varStatus="status">
                                    <tr>
                                        <td style="font-size: 9px; padding: 3px 5px;"> ${status.count}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${vendorPreBidAttachment.description}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${vendorPreBidAttachment.attachmentRequired}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${vendorPreBidAttachment.attachment}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <br>
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">Vendor Terms & Condition </th>
                            </tr>    
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Delivery Location</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${deliveryLocation}</td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>Delivery Period (In Weeks)</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${deliveryPeriod} </td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Terms of Payment</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${termsOfPayment}</td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>Validity Period</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${validityPeriod} </td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Mode of Transport</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${modeOfTransport}</td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>Inco Terms</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${incoTerms} </td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Insurance</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${insurance}</td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>Freight</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${freight} </td>
                            </tr> 
                            <tr class="table-title">
                                <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">Vendor  Vendor Remark For Technical</th>
                            </tr> 
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Deviation</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${preBidDeviation}</td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>Remark</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${preBidRemark} </td>
                            </tr>  
                        </table>
                    </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooterPrint.jsp"%>
</html>
