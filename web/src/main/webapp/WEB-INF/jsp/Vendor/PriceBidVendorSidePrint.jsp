
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNewPrint.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VENDOR PRICE BID VIEW</title>

    </head>



    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNewVendor.jsp"%>
            <section class="main-content">
                <form:form action=".htm?act=" commandName="departmentMaster" method="post">



                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2  d-print-none">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0  no-print">VENDOR PRICE BID VIEW</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a href="#" onclick="history.back();" class="btn theme-btn light-btn mr-3 no-print">Back</a>
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
                            <td colspan="10" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                Tender information
                            </td>
                        </tr>

                        <tr style="font-size:11px; height:20px;">
                            <td colspan="2" style="padding:3px 5px;"><strong>Tender No:</strong></td>
                            <td colspan="1"style="padding:3px 5px;">${refNo}</td>
                            <td colspan="2"  style="padding:3px 5px;"><strong>Project Name:</strong></td>
                            <td colspan="5" style="padding:3px 5px;">${title}</td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="2" style="padding:3px 5px;"><strong>Plant Name:</strong></td>
                            <td colspan="1"style="padding:3px 5px;">${tenderMaster.plantName}</td>
                            <td colspan="2"  style="padding:3px 5px;"><strong>Project Name:</strong></td>
                            <td colspan="5" style="padding:3px 5px;">${tenderMaster.plantName}</td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="2" style="padding:3px 5px;"><strong>Vendor Name:</strong></td>
                            <td colspan="1"style="padding:3px 5px;">${vendorCode} ${vendorName}</td>
                            <td colspan="2"  style="padding:3px 5px;"><strong>Tender Date Time:</strong></td>
                            <td colspan="5" style="padding:3px 5px;">${announceDate}</td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="2" style="padding:3px 5px;"><strong>Due Date Time:</strong></td>
                            <td colspan="1"style="padding:3px 5px;">${submitLastdate}</td>
                            <td colspan="2"  style="padding:3px 5px;"><strong>PR No:</strong></td>
                            <td colspan="5" style="padding:3px 5px;">${tenderMaster.prNo}</td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="2" style="padding:3px 5px;"><strong>PR Item No</strong></td>
                            <td colspan="9"style="padding:3px 5px;">${tenderMaster.prItemNo}</td>

                        </tr>

                        <tr class="table-title">
                            <td colspan="10" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                Tender Contact Person
                            </td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="2" style="padding:3px 5px;"><strong>Created by:</strong></td>
                            <td colspan="1"style="padding:3px 5px;">${contactPerson}</td>
                            <td colspan="2"  style="padding:3px 5px;"><strong>End User Name</strong></td>
                            <td colspan="5" style="padding:3px 5px;">${tenderMaster.endUserName} </td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="2" style="padding:3px 5px;"><strong>Name of Location Partner:</strong></td>
                            <td colspan="1"style="padding:3px 5px;">${prm.nameofLocationPartner}</td>
                            <td colspan="2"  style="padding:3px 5px;"><strong>Mobile No Location Partner</strong></td>
                            <td colspan="5" style="padding:3px 5px;">${prm.mobileNoLocationPartner} </td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="2"  style="padding:3px 5px;"><strong>End User No</strong></td>
                            <td colspan="9" style="padding:3px 5px;">${tenderMaster.endUserNumber} </td>
                        </tr>
                        <tr class="table-title">
                            <td colspan="10" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                Vendor Quotation Details
                            </td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="2" style="padding:3px 5px;"><strong>Quotation No</strong></td>
                            <td colspan="1"style="padding:3px 5px;">${offerNo}</td>
                            <td colspan="2"  style="padding:3px 5px;"><strong>Date</strong></td>
                            <td colspan="5" style="padding:3px 5px;">${offerDate} </td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="2" style="padding:3px 5px;"><strong>Contact Person</strong></td>
                            <td colspan="1"style="padding:3px 5px;">${contact_person}</td>
                            <td colspan="2"  style="padding:3px 5px;"><strong>Contact Number</strong></td>
                            <td colspan="5" style="padding:3px 5px;">${contact_no} </td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="2"  style="padding:3px 5px;"><strong>Contact Email</strong></td>
                            <td colspan="9" style="padding:3px 5px;">${contact_email} </td>
                        </tr>
                        <c:if test="${fee != '0'}">
                            <tr class="table-title">
                                <td colspan="10" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                    Fee Details
                                </td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="2" style="padding:3px 5px;"><strong>Fee</strong></td>
                                <td colspan="1"style="padding:3px 5px;">${fee}</td>
                                <td colspan="2"  style="padding:3px 5px;"><strong>Fee Date</strong></td>
                                <td colspan="5" style="padding:3px 5px;">${fee_date} </td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="2" style="padding:3px 5px;"><strong>Drawee Bank</strong></td>
                                <td colspan="1"style="padding:3px 5px;">${fee_drawee_bank}</td>
                                <td colspan="2"  style="padding:3px 5px;"><strong>Cheque No</strong></td>
                                <td colspan="5" style="padding:3px 5px;">${fee_cheque_no} </td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="2" style="padding:3px 5px;"><strong>Attachment</strong></td>
                                <td colspan="9"style="padding:3px 5px;">${fee_attach}</td>
                            </tr>                        
                        </c:if>
                        <c:if test="${emd != '0'}">
                            <tr class="table-title">
                                <td colspan="10" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                    EMD Details
                                </td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="2" style="padding:3px 5px;"><strong>EMD</strong></td>
                                <td colspan="1"style="padding:3px 5px;">${emd}</td>
                                <td colspan="2"  style="padding:3px 5px;"><strong>EMD Date</strong></td>
                                <td colspan="5" style="padding:3px 5px;">${emd_date} </td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="2" style="padding:3px 5px;"><strong>Drawee Bank</strong></td>
                                <td colspan="1"style="padding:3px 5px;">${emd_drawee_bank}</td>
                                <td colspan="2"  style="padding:3px 5px;"><strong>Cheque No</strong></td>
                                <td colspan="5" style="padding:3px 5px;">${emd_cheque_no} </td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="2" style="padding:3px 5px;"><strong>Cash / Cheque</strong></td>
                                <td colspan="1"style="padding:3px 5px;">${cash_cheque}</td>
                                <td colspan="2"  style="padding:3px 5px;"><strong>Attachment</strong></td>
                                <td colspan="5" style="padding:3px 5px;">${emd_attach} </td>
                            </tr>
                        </c:if>
                            
                    </table>
                        <br>
                    <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >

                        <c:if test="${tenderMaster.type == 'Contract Civil'}">
                            <tr class="table-title">
                                <td colspan="${tenderMaster.tenderPhase == 1 ? 11 : 10}"  style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                    Civil Details
                                </td>
                            </tr>  
                        </c:if>
                        <c:if test="${tenderMaster.type != 'Contract Civil'}">
                            <c:if test="${tenderMaster.type == 'Service'}">
                                <tr class="table-title">
                                    <td colspan="${tenderMaster.tenderPhase == 1 ? 11 : 10}"  style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                    Items Details For Service
                                    </td>
                                </tr> 
                            </c:if>
                            <c:if test="${tenderMaster.type != 'Service'}">
                                <tr class="table-title">
                                    <td colspan="${tenderMaster.tenderPhase == 1 ? 11 : 10}"  style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                        Item Details
                                    </td>
                                </tr> 
                            </c:if>
                        </c:if>
                                
                                
                        <tr>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 4px;">Sr. No.</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Item code</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Item Description</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Make</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">UOM</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Quantity</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Unit Rate</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Amount</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Make / Model</th>
                            <th  style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">HSN No</th>
                                <c:if test="${tenderMaster.tenderPhase == 1}">
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Regret</th>
                                </c:if>
                        </tr>
                        <tbody>
                            <c:forEach var="vendorTenderBidItem" items="${vendorTenderBidItem}" varStatus="status">
                                <tr>
                                    <td style="font-size: 9px; padding: 3px 5px;"> ${status.count}</td>
                                    <td style="font-size: 9px; padding: 3px 5px;">${vendorTenderBidItem.itemCode}</td>
                                    <td style="font-size: 9px; padding: 3px 5px;">${vendorTenderBidItem.itemDescription}</td>
                                    <td style="font-size: 9px; padding: 3px 5px;">${vendorTenderBidItem.deliveryScheduleDate}</td>
                                    <td style="font-size: 9px; padding: 3px 5px;">${vendorTenderBidItem.uom}</td>
                                    <td style="font-size: 9px; padding: 3px 5px;">${vendorTenderBidItem.qty}</td>
                                    <td style="font-size: 9px; padding: 3px 5px;">${vendorTenderBidItem.rate}</td>
                                    <td style="font-size: 9px; padding: 3px 5px;">${vendorTenderBidItem.netRate}</td>
                                    <td style="font-size: 9px; padding: 3px 5px;">${vendorTenderBidItem.vendorRemark}</td>
                                    <td style="font-size: 9px; padding: 3px 5px;">${vendorTenderBidItem.hsnNo}</td>
                                    <c:if test="${tenderMaster.tenderPhase == 1}">
                                        <td style="font-size: 9px; padding: 3px 5px;">
                                            <c:if test="${vendorTenderBidItem.itemRegret == '1'}">
                                                Yes
                                            </c:if>
                                        </td>
                                    </c:if>
                                </tr>
                            </c:forEach>
                        </tbody>
                        <tr>
                            <td style="font-size: 9px; padding: 3px 5px;"> Total</td>
                            <td style="font-size: 9px; padding: 3px 5px;"></td>
                            <td style="font-size: 9px; padding: 3px 5px;"></td>
                            <td style="font-size: 9px; padding: 3px 5px;"></td>
                            <td style="font-size: 9px; padding: 3px 5px;"></td>
                            <td style="font-size: 9px; padding: 3px 5px;"></td>
                            <td style="font-size: 9px; padding: 3px 5px;"></td>
                            <td style="font-size: 9px; padding: 3px 5px;">${itemTotal}</td>
                            <td style="font-size: 9px; padding: 3px 5px;"></td>
                            <td style="font-size: 9px; padding: 3px 5px;"></td>
                            <c:if test="${tenderMaster.tenderPhase == 1}">
                                <td style="font-size: 9px; padding: 3px 5px;"></td>
                            </c:if>
                        </tr>
                         </table>
                        <br>
                    <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >

                        
                        <c:if test="${selectCommon == 1}">
                            <tr class="table-title">
                                <td colspan="${tenderMaster.tenderPhase == 1 ? 11 : 10}"  style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                    Select Common Tax
                                </td>
                            </tr>
                            <tr >
                                <th colspan="2" style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Type</th>
                                <th colspan="1" style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">(*) / Value</th>
                                <th colspan="2" style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Value</th>
                                <th colspan="5" style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Amount</th>
                            </tr>
                            <tbody>
                                <tr>
                                    <td colspan="2" style="font-size: 9px; padding: 3px 5px;">Packing</td>
                                    <td colspan="1" style="font-size: 9px; padding: 3px 5px;">
                                        <c:if test="${packingType == 0}">
                                            (%)
                                        </c:if>
                                        <c:if test="${packingType == 1}">
                                            Value
                                        </c:if>
                                    </td>
                                    <td colspan="2" style="font-size: 9px; padding: 3px 5px;">${packingValue}</td>
                                    <td colspan="5" style="font-size: 9px; padding: 3px 5px;">${packingValueFinal}</td>
                                </tr>
                                <tr>
                                    <td colspan="2" style="font-size: 9px; padding: 3px 5px;">Freight</td>
                                    <td colspan="1" style="font-size: 9px; padding: 3px 5px;">
                                        (%)
                                    </td>
                                    <td colspan="2" style="font-size: 9px; padding: 3px 5px;">${chargesValue}</td>
                                    <td colspan="5" style="font-size: 9px; padding: 3px 5px;">${chargesValueFinal}</td>
                                </tr>
                                <tr>
                                    <td colspan="2" style="font-size: 9px; padding: 3px 5px;">Insurance</td>
                                    <td colspan="1" style="font-size: 9px; padding: 3px 5px;">
                                        (%)
                                    </td>
                                    <td colspan="2" style="font-size: 9px; padding: 3px 5px;">${insuranceValue}</td>
                                    <td colspan="5" style="font-size: 9px; padding: 3px 5px;">${insuranceValueFinal}</td>
                                </tr>
                                <tr>
                                    <td colspan="2" style="font-size: 9px; padding: 3px 5px;">Errection</td>
                                    <td colspan="1" style="font-size: 9px; padding: 3px 5px;">
                                        (%)
                                    </td>
                                    <td colspan="2" style="font-size: 9px; padding: 3px 5px;">${errectionValue}</td>
                                    <td colspan="5" style="font-size: 9px; padding: 3px 5px;">${errectionValueFinal}</td>
                                </tr>
                                <tr>
                                    <td colspan="2" style="font-size: 9px; padding: 3px 5px;">Total Without Discount</td>
                                    <td colspan="1" style="font-size: 9px; padding: 3px 5px;">
                                    </td>
                                    <td colspan="2" style="font-size: 9px; padding: 3px 5px;"></td>
                                    <td colspan="5" style="font-size: 9px; padding: 3px 5px;">${String.format("%.2f",grandTotal - igstValueFinal + discountValueFinal)}</td>
                                </tr>
                                <tr>
                                    <td colspan="2" style="font-size: 9px; padding: 3px 5px;">Discount</td>
                                    <td colspan="1" style="font-size: 9px; padding: 3px 5px;">
                                        <c:if test="${discountType == 0}">
                                            (%)
                                        </c:if>
                                        <c:if test="${discountType == 1}">
                                            Value
                                        </c:if>
                                    </td>
                                    <td colspan="2" style="font-size: 9px; padding: 3px 5px;">${discountValue}</td>
                                    <td colspan="5" style="font-size: 9px; padding: 3px 5px;">${discountValueFinal}</td>
                                </tr>
                                <tr>
                                    <td colspan="2" style="font-size: 9px; padding: 3px 5px;">Total Without GST</td>
                                    <td colspan="1" style="font-size: 9px; padding: 3px 5px;">

                                    </td>
                                    <td colspan="2" style="font-size: 9px; padding: 3px 5px;"></td>
                                    <td colspan="5" style="font-size: 9px; padding: 3px 5px;">${String.format("%.2f",grandTotal - igstValueFinal)}</td>
                                </tr>
                                <tr>
                                    <td colspan="2" style="font-size: 9px; padding: 3px 5px;">GST</td>
                                    <td colspan="1" style="font-size: 9px; padding: 3px 5px;">
                                        (%)
                                    </td>
                                    <td colspan="2" style="font-size: 9px; padding: 3px 5px;">${igstValue}</td>
                                    <td colspan="5" style="font-size: 9px; padding: 3px 5px;">${igstValueFinal}</td>
                                </tr>
                                <tr>
                                    <td colspan="2"  style="font-size: 9px; padding: 3px 5px;">Total Amount</td>
                                    <td colspan="1"  style="font-size: 9px; padding: 3px 5px;"></td>
                                    <td colspan="2" style="font-size: 9px; padding: 3px 5px;"></td>
                                    <td colspan="5" style="font-size: 9px; padding: 3px 5px;">${grandTotal}</td>
                                </tr>
                            </tbody>
                        </c:if>
                             </table>
                        
                        
                        <br>
                    <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >

                        <c:if test="${selectCommon == 0}">
                            <tr class="table-title">
                                <td colspan="10" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                    Select Individual Tax
                                </td>
                            </tr>
                            <tr>
                                <th colspan="3" style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Type</th>
                                <th colspan="7" style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Amount</th>
                            </tr>
                            <tbody>
                                <tr>
                                    <td colspan="3"  style="font-size: 9px; padding: 3px 5px;">Discount</td>
                                    <td colspan="7"  style="font-size: 9px; padding: 3px 5px;">${discountValueFinal}</td>
                                </tr>
                                <tr>
                                    <td colspan="3"  style="font-size: 9px; padding: 3px 5px;">Packing</td>
                                    <td colspan="7"  style="font-size: 9px; padding: 3px 5px;">${packingValueFinal}</td>
                                </tr>
                                <tr>
                                    <td colspan="3"  style="font-size: 9px; padding: 3px 5px;">Errection</td>
                                    <td colspan="7"  style="font-size: 9px; padding: 3px 5px;">${errectionValueFinal}</td>
                                </tr>
                                <tr>
                                    <td colspan="3"  style="font-size: 9px; padding: 3px 5px;">Other Charges</td>
                                    <td colspan="7"  style="font-size: 9px; padding: 3px 5px;">${chargesValueFinal}</td>
                                </tr>
                                <tr>
                                    <td colspan="3"  style="font-size: 9px; padding: 3px 5px;">GST</td>
                                    <td colspan="7"  style="font-size: 9px; padding: 3px 5px;">${igstValueFinal}</td>
                                </tr>
                                <tr>
                                    <td colspan="3"  style="font-size: 9px; padding: 3px 5px;">Insurance</td>
                                    <td colspan="7"  style="font-size: 9px; padding: 3px 5px;">${insuranceValueFinal}</td>
                                </tr>
                                <tr>
                                    <td colspan="3"  style="font-size: 9px; padding: 3px 5px;">Total Amount</td>
                                    <td colspan="7"  style="font-size: 9px; padding: 3px 5px;">${grandTotal}</td>
                                </tr>
                            </tbody>
                            <tr class="table-title">
                                <td colspan="10" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                    Individual Item Details
                                </td>
                            </tr>
                            <tr>
                                <th colspan="1" style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Sr No.</th>
                                <th colspan="2" style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Item Code</th>
                                <th colspan="2" style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Item Detail</th>
                                <th colspan="1" style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">UOM</th>
                                <th colspan="1" style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Quantity</th>
                                <th colspan="1" style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Unit Rate</th>
                                <th colspan="1" style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Amount</th>
                                <th colspan="1" style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Make / Model</th>
                            </tr> 
                            <tbody>
                                <c:forEach var="vbi" items="${vbi}" varStatus="status">
                                    <tr>
                                        <td colspan="1" style="font-size: 9px; padding: 3px 5px;"> ${status.count}</td>
                                        <td colspan="2" style="font-size: 9px; padding: 3px 5px;">${vbi.itemCode}</td>
                                        <td colspan="2" style="font-size: 9px; padding: 3px 5px;">${vbi.itemDesciption}</td>
                                        <td colspan="1" style="font-size: 9px; padding: 3px 5px;">${vbi.uom}</td>
                                        <td colspan="1" style="font-size: 9px; padding: 3px 5px;">${vbi.qty}</td>
                                        <td colspan="1" style="font-size: 9px; padding: 3px 5px;">${vbi.rate}</td>
                                        <td colspan="1" style="font-size: 9px; padding: 3px 5px;">${vbi.individualNetTotal}</td>
                                        <td colspan="1" style="font-size: 9px; padding: 3px 5px;">${vbi.vendorRemark}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                            <tr>
                                <th colspan="1" style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Type</th>
                                <th colspan="3" style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">(*) / Value</th>
                                <th colspan="3" style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Value</th>
                                <th colspan="3" style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Amount</th>
                            </tr>
                            <tbody>
                                <c:forEach var="vbi" items="${vbi}" varStatus="status">
                                    <tr>
                                        <td colspan="1" style="font-size: 9px; padding: 3px 5px;">Discount</td>
                                        <td colspan="3" style="font-size: 9px; padding: 3px 5px;">
                                            <c:if test="${vbi.individualDiscountType == 0}">
                                                (%)
                                            </c:if>
                                            <c:if test="${vbi.individualDiscountType == 1}">
                                                Value
                                            </c:if>
                                        </td>
                                        <td colspan="3" style="font-size: 9px; padding: 3px 5px;">${vbi.individualDiscountValue}</td>
                                        <td colspan="3" style="font-size: 9px; padding: 3px 5px;">${vbi.individualDiscountValueFinal}</td>
                                    </tr>
                                    <tr>
                                        <td colspan="1" style="font-size: 9px; padding: 3px 5px;">Packing</td>
                                        <td colspan="3" style="font-size: 9px; padding: 3px 5px;">
                                            <c:if test="${vbi.individualPackingType == 0}">
                                                (%)
                                            </c:if>
                                            <c:if test="${vbi.individualPackingType == 1}">
                                                Value
                                            </c:if>
                                        </td>
                                        <td colspan="3" style="font-size: 9px; padding: 3px 5px;">${vbi.individualPackingValue}</td>
                                        <td colspan="3" style="font-size: 9px; padding: 3px 5px;">${vbi.individualPackingValueFinal}</td>
                                    </tr>
                                    <tr>
                                        <td colspan="1" style="font-size: 9px; padding: 3px 5px;">Errection</td>
                                        <td colspan="3" style="font-size: 9px; padding: 3px 5px;">
                                            (%)
                                        </td>
                                        <td colspan="3" style="font-size: 9px; padding: 3px 5px;">${vbi.individualErrectionValue}</td>
                                        <td colspan="3" style="font-size: 9px; padding: 3px 5px;">${vbi.individualErrectionValueFinal}</td>
                                    </tr>
                                    <tr>
                                        <td colspan="1" style="font-size: 9px; padding: 3px 5px;">Other Charges</td>
                                        <td colspan="3" style="font-size: 9px; padding: 3px 5px;">
                                            (%)
                                        </td>
                                        <td colspan="3" style="font-size: 9px; padding: 3px 5px;">${vbi.individualChargesValue}</td>
                                        <td colspan="3" style="font-size: 9px; padding: 3px 5px;">${vbi.individualChargesValueFinal}</td>
                                    </tr>
                                    <tr>
                                        <td colspan="1" style="font-size: 9px; padding: 3px 5px;">GST</td>
                                        <td colspan="3" style="font-size: 9px; padding: 3px 5px;">
                                            (%)
                                        </td>
                                        <td colspan="3" style="font-size: 9px; padding: 3px 5px;">${vbi.individualIgstValue}</td>
                                        <td colspan="3" style="font-size: 9px; padding: 3px 5px;">${vbi.individualIgstValueFinal}</td>
                                    </tr>
                                    <tr>
                                        <td colspan="1" style="font-size: 9px; padding: 3px 5px;">Insurance</td>
                                        <td colspan="3" style="font-size: 9px; padding: 3px 5px;">
                                            (%)
                                        </td>
                                        <td colspan="3" style="font-size: 9px; padding: 3px 5px;">${vbi.individualInsuranceValue}</td>
                                        <td colspan="3" style="font-size: 9px; padding: 3px 5px;">${vbi.individualInsuranceValueFinal}</td>
                                    </tr>
                                    <tr>
                                        <td colspan="1" style="font-size: 9px; padding: 3px 5px;">Total Amount</td>
                                        <td colspan="3" style="font-size: 9px; padding: 3px 5px;">
                                        </td>
                                        <td colspan="3" style="font-size: 9px; padding: 3px 5px;"></td>
                                        <td colspan="3" style="font-size: 9px; padding: 3px 5px;">${vbi.individualgrandTotal}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </c:if>
                            </table>
                      
                    <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >

                        <c:if test="${tenderMaster.type == 'Contract'  || tenderMaster.type == 'Contract Civil' || tenderMaster.type == 'Contract Electrical'}">        
                            <c:if test="${tenderMaster.type == 'Contract Civil'}">
                                <tr class="table-title">
                                    <td  colspan="${tenderMaster.tenderPhase == 1 ? 11 : 10}"  style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                        Steel  Details
                                    </td>
                                </tr>
                            </c:if>
                            <c:if test="${tenderMaster.type != 'Contract Civil'}"> 
                                <tr class="table-title">
                                    <td  colspan="${tenderMaster.tenderPhase == 1 ? 11 : 10}"  style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                        Item Details For Service
                                    </td>
                                </tr>
                            </c:if>
                            <tr>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 4px;  white-space: nowrap;">Sr No.</th>
                                <th  style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Item Code</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Item Description</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Item Details</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">UOM</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Quantity</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Unit Rate</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Amount</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Make / Model</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">HSN No.</th>
                                    <c:if test="${tenderMaster.tenderPhase == 1}">
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Regret</th>
                                    </c:if>
                            </tr>   
                            <tbody>
                                <c:forEach var="vendorTenderBidItem" items="${vendorTenderBidItem1}" varStatus="status">
                                    <tr>
                                        <td style="font-size: 9px; padding: 3px 5px;"> ${status.count}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${vendorTenderBidItem.itemCode}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${vendorTenderBidItem.itemDescription}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${vendorTenderBidItem.deliveryScheduleDate}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${vendorTenderBidItem.uom}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${vendorTenderBidItem.qty}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${vendorTenderBidItem.rate}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${vendorTenderBidItem.netRate}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${vendorTenderBidItem.vendorRemark}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${vendorTenderBidItem.hsnNo}</td>
                                        <c:if test="${tenderMaster.tenderPhase == 1}">
                                            <td style="font-size: 9px; padding: 3px 5px;">
                                                <c:if test="${vendorTenderBidItem.itemRegret == '1'}">
                                                    Yes
                                                </c:if>
                                            </td>
                                        </c:if>

                                    </tr>
                                </c:forEach>
                            </tbody>
                            <tr>
                                <td style="font-size: 9px; padding: 3px 5px;"> Total</td>
                                <td style="font-size: 9px; padding: 3px 5px;"></td>
                                <td style="font-size: 9px; padding: 3px 5px;"></td>
                                <td style="font-size: 9px; padding: 3px 5px;"></td>
                                <td style="font-size: 9px; padding: 3px 5px;"></td>
                                <td style="font-size: 9px; padding: 3px 5px;"></td>
                                <td style="font-size: 9px; padding: 3px 5px;"></td>
                                <td style="font-size: 9px; padding: 3px 5px;">${serviceTotal}</td>
                                <td style="font-size: 9px; padding: 3px 5px;"></td>
                                <td style="font-size: 9px; padding: 3px 5px;"></td>
                                <c:if test="${tenderMaster.tenderPhase == 1}">
                                    <td style="font-size: 9px; padding: 3px 5px;"></td>
                                </c:if>
                            </tr>
                            <c:if test="${selectCommon == 1}">
                                <tr class="table-title">
                                    <td colspan="10" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                        Select Common Tax
                                    </td>
                                </tr>
                                <tr>
                                    <th colspan="2" style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Type</th>
                                    <th  colspan="1" style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">(*) / Value</th>
                                    <th colspan="2"  style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Value</th>
                                    <th colspan="5"  style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Amount</th>
                                </tr>
                                <tbody>
                                    <tr>
                                        <td  colspan="2" style="font-size: 9px; padding: 3px 5px;">Discount</td>
                                        <td  colspan="1" style="font-size: 9px; padding: 3px 5px;">
                                            <c:if test="${discountType == 0}">
                                                (%)
                                            </c:if>
                                            <c:if test="${discountType == 1}">
                                                Value
                                            </c:if>
                                        </td>
                                        <td colspan="2" style="font-size: 9px; padding: 3px 5px;">${serviceDiscountValue}</td>
                                        <td colspan="5" style="font-size: 9px; padding: 3px 5px;">${serviceDiscountValueFinal}</td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" style="font-size: 9px; padding: 3px 5px;">Total Without GST</td>
                                        <td colspan="1" style="font-size: 9px; padding: 3px 5px;">

                                        </td>
                                        <td colspan="2" style="font-size: 9px; padding: 3px 5px;"></td>
                                        <td colspan="5" style="font-size: 9px; padding: 3px 5px;">${String.format("%.2f",serviceTaxTotal - servicegstFinal)}</td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" style="font-size: 9px; padding: 3px 5px;">GST</td>
                                        <td colspan="1" style="font-size: 9px; padding: 3px 5px;">
                                            (%)
                                        </td>
                                        <td colspan="2" style="font-size: 9px; padding: 3px 5px;">${igstValue}</td>
                                        <td colspan="5" style="font-size: 9px; padding: 3px 5px;">${servicegstFinal}</td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" style="font-size: 9px; padding: 3px 5px;">Total Amount</td>
                                        <td colspan="1" style="font-size: 9px; padding: 3px 5px;">
                                        </td>
                                        <td colspan="2" style="font-size: 9px; padding: 3px 5px;"></td>
                                        <td colspan="5" style="font-size: 9px; padding: 3px 5px;">${serviceTaxTotal}</td>
                                    </tr>
                                </tbody>
                            </c:if>
                        </c:if>
                                </table>
                      
                    <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >

                        <tr class="table-title">
                            <td colspan="10" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                Vendor Terms & Condition
                            </td>
                        </tr>
                        <tr>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px; width: 20%;" >Terms Condition</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px; width: 50%;">Description</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px; width: 5%;">Response</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px; width: 25%;">Remark</th>
                        </tr>
                        <tbody>
                            <c:forEach items="${vendorTermsCondition1}" var="vendorTermsCondition1" varStatus="status">
                                <tr>
                                    <td  style="font-size: 9px; padding: 3px 5px;"><input type="hidden" name="termsCondition" id="termsCondition" value="${vendorTermsCondition1.termsCondition}" readonly="true" class="form-control">${vendorTermsCondition1.termsCondition}</td>
                                    <td  style="font-size: 9px; padding: 3px 5px;"><input type="hidden" name="description" id="description" value="${vendorTermsCondition1.description}" readonly="true" class="form-control">${vendorTermsCondition1.description}</td>
                                    <td style="font-size: 9px; padding: 3px 5px;">
                                        <c:choose>
                                            <c:when test="${vendorTermsCondition1.response == 0}">
                                                Accept
                                            </c:when>
                                            <c:otherwise>
                                                Reject
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td  style="font-size: 9px; padding: 3px 5px;"><input readonly="true" type="hidden" class="form-control" name="remarks" id="remarks${status.count}" value="${vendorTermsCondition1.comment}">${vendorTermsCondition1.comment}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                        </table>
                        <br>
                    <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >

                             
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="2" style="padding:3px 5px;"><strong>Terms of Payment:</strong></td>
                            <td colspan="1"style="padding:3px 5px;">${termsOfPayment}</td>
                            <td colspan="2"  style="padding:3px 5px;"><strong>Mode of Transport</strong></td>
                            <td colspan="5" style="padding:3px 5px;">${modeOfTransport} </td>
                        </tr>      
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="2" style="padding:3px 5px;"><strong>Inco Terms:</strong></td>
                            <td colspan="1"style="padding:3px 5px;">${incoTerms}</td>
                            <td colspan="2"  style="padding:3px 5px;"><strong>Delivery Period (In Weeks)</strong></td>
                            <td colspan="5" style="padding:3px 5px;">${deliveryPeriod} </td>
                        </tr>      
                       <tr style="font-size:11px; height:20px;">
                           
                             <td colspan="2"  style="padding:3px 5px;"><strong>Vendor Remark</strong></td>
                            <td colspan="5" style="padding:3px 5px;">${vendorTenderBid.remarkByVendor} </td>
                        </tr> 
                    </table>
                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooterPrint.jsp"%>
</html>
