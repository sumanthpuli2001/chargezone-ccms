<%-- 
    Document   : priceBidComparisonViewPrint
    Created on : Apr 1, 2026, 10:09:57 AM
    Author     : Sumanth
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNewPrint.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PRICE BID COMPARISON</title>        
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

                            <h5 class="fw-600 mb-0  no-print">PRICE BID COMPARISON</h5>
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
                                    PRICE BID COMPARISON
                                </td>
                                
                            </tr>
                        </tbody>
                    </table>
                    <br>

                    <table class="flex-table" class="table table-bordered" style="" align="Center"  >
                        <thead style="font-size: 12px;">
                            <tr class="table-title">
                                <th colspan="7" style="text-align: center;">Tender Details</th>
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

                    <c:if test="${!empty vendorTenderBidItem1}">
                    <br>
                    <div class="table-responsive">
                    <table class="flex-table" class="table table-bordered" style="" align="Center"  >
                        <thead style="font-size: 12px;">
                                <tr class="table-title">
                                    <th colspan="13" style="text-align: center;">Price Bid Comparison For Item</th>
                                </tr>                                

                                <tr>
                                    <th colspan="5">Vendor Name</th>

                                    <c:if test="${vendor_code1 != ''}">
                                        <th colspan="2">${vendor_name1}</th>
                                    </c:if>

                                    <c:if test="${vendor_code2 != ''}">
                                        <th colspan="2">${vendor_name2}</th>
                                    </c:if>

                                    <c:if test="${vendor_code3 != ''}">
                                        <th colspan="2">${vendor_name3}</th>
                                    </c:if>

                                    <c:if test="${vendor_code4 != ''}">
                                        <th colspan="2">${vendor_name4}</th>
                                    </c:if>
                                </tr>                                

                                <tr>
                                    <th>Sr.</th>
                                    <th>Item Code</th>
                                    <th>Description</th>
                                    <th>Qty</th>
                                    <th>UOM</th>

                                    <c:if test="${vendor_code1 != ''}">
                                        <th>Unit Price</th>
                                        <th>Value</th>
                                    </c:if>

                                    <c:if test="${vendor_code2 != ''}">
                                        <th>Unit Price</th>
                                        <th>Value</th>
                                    </c:if>

                                    <c:if test="${vendor_code3 != ''}">
                                        <th>Unit Price</th>
                                        <th>Value</th>
                                    </c:if>

                                    <c:if test="${vendor_code4 != ''}">
                                        <th>Unit Price</th>
                                        <th>Value</th>
                                    </c:if>
                                </tr>

                            </thead>
                            <tbody  style="font-size: 10px;">

                                <c:forEach var="item1" items="${vendorTenderBidItem1}">

                                    <tr>
                                        <td>${item1[0]}</td>
                                        <td>${item1[1]}</td>
                                        <td>${item1[2]}</td>
                                        <td>${item1[4]}</td>
                                        <td>${item1[3]}</td>

                                        <c:if test="${vendor_code1 != ''}">
                                            <td class="currency">${item1[5]}</td>
                                            <td class="currency">${item1[6]}</td>
                                        </c:if>

                                        <c:if test="${vendor_code2 != ''}">
                                            <c:set var="found2" value="false"/>
                                            <c:forEach var="item2" items="${vendorTenderBidItem2}">
                                                <c:if test="${item1[0] == item2[0]}">
                                                    <td class="currency">${item2[5]}</td>
                                                    <td class="currency">${item2[6]}</td>
                                                    <c:set var="found2" value="true"/>
                                                </c:if>
                                            </c:forEach>
                                            <c:if test="${!found2}">
                                                <td>-</td>
                                                <td>-</td>
                                            </c:if>
                                        </c:if>

                                        <c:if test="${vendor_code3 != ''}">
                                            <c:set var="found3" value="false"/>
                                            <c:forEach var="item3" items="${vendorTenderBidItem3}">
                                                <c:if test="${item1[0] == item3[0]}">
                                                    <td class="currency">${item3[5]}</td>
                                                    <td class="currency">${item3[6]}</td>
                                                    <c:set var="found3" value="true"/>
                                                </c:if>
                                            </c:forEach>
                                            <c:if test="${!found3}">
                                                <td>-</td>
                                                <td>-</td>
                                            </c:if>
                                        </c:if>

                                        <c:if test="${vendor_code4 != ''}">
                                            <c:set var="found4" value="false"/>
                                            <c:forEach var="item4" items="${vendorTenderBidItem4}">
                                                <c:if test="${item1[0] == item4[0]}">
                                                    <td class="currency">${item4[5]}</td>
                                                    <td class="currency">${item4[6]}</td>
                                                    <c:set var="found4" value="true"/>
                                                </c:if>
                                            </c:forEach>
                                            <c:if test="${!found4}">
                                                <td>-</td>
                                                <td>-</td>
                                            </c:if>
                                        </c:if>

                                    </tr>

                                </c:forEach>
                            
                                <tr>
                                    <th colspan="5"><b>Ex-work Price/FOB</b></th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <td></td>
                                        <td class="currency">${total_value1}</td>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td></td>
                                        <td class="currency">${total_value2}</td>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td></td>
                                        <td class="currency">${total_value3}</td>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td></td>
                                        <td class="currency">${total_value4}</td>
                                    </c:if>    
                                </tr>
                                
                                <tr>
                                    <th colspan="5"><b>Packing & Forwarding</b></th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <td>${packingValue1}%</td>
                                        <td class="currency">${packingValueFinal1}</td>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td>${packingValue2}%</td>
                                        <td class="currency">${packingValueFinal2}</td>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td>${packingValue3}%</td>
                                        <td class="currency">${packingValueFinal3}</td>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td>${packingValue4}%</td>
                                        <td class="currency">${packingValueFinal4}</td>
                                    </c:if>    
                                </tr>
                                
                                <tr>
                                    <th  colspan="5"><b>Charges</b></th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <td>${chargesValue1}%</td>
                                        <td class="currency">${chargesValueFinal1}</td>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td>${chargesValue2}%</td>
                                        <td class="currency">${chargesValueFinal2}</td>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td>${chargesValue3}%</td>
                                        <td class="currency">${chargesValueFinal3}</td>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td>${chargesValue4}%</td>
                                        <td class="currency">${chargesValueFinal4}</td>
                                    </c:if>
                                </tr>

                                <tr>
                                    <th colspan="5"><b>Insurance</b></th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <td>${insuranceValue1}%</td>
                                        <td class="currency">${insuranceValueFinal1}</td>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td>${insuranceValue2}%</td>
                                        <td class="currency">${insuranceValueFinal2}</td>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td>${insuranceValue3}%</td>
                                        <td class="currency">${insuranceValueFinal3}</td>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td>${insuranceValue4}%</td>
                                        <td class="currency">${insuranceValueFinal4}</td>
                                    </c:if>
                                </tr>

                                <tr>
                                    <th  colspan="5"><b>Erection Commision</b></th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <td>${errectionValue1}%</td>
                                        <td class="currency">${errectionValueFinal1}</td>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td>${errectionValue2}%</td>
                                        <td class="currency">${errectionValueFinal2}</td>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td>${errectionValue3}%</td>
                                        <td class="currency">${errectionValueFinal3}</td>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td>${errectionValue4}%</td>
                                        <td class="currency">${errectionValueFinal4}</td>
                                    </c:if>
                                </tr>

                                <tr>
                                    <th colspan="5"><b>Discount</b></th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <td>${discountValue1}%</td>
                                        <td class="currency">${discountValueFinal1}</td>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td>${discountValue2}%</td>
                                        <td class="currency">${discountValueFinal2}</td>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td>${discountValue3}%</td>
                                        <td class="currency">${discountValueFinal3}</td>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td>${discountValue4}%</td>
                                        <td class="currency">${discountValueFinal4}</td>
                                    </c:if>
                                </tr>

                                <tr>
                                    <th colspan="5"><b>Final Evaluated Price without GST</b></th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <td></td>
                                        <td class="currency">${Total1 - igstValueFinal1}</td>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td></td>
                                        <td class="currency">${Total2 - igstValueFinal2}</td>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td></td>
                                        <td class="currency">${Total3 - igstValueFinal3}</td>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td></td>
                                        <td class="currency">${Total4 - igstValueFinal4}</td>
                                    </c:if>
                                </tr>

                                <tr>
                                    <th colspan="5"><b>GST</b></th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <td>${igstValue1}%</td>
                                        <td class="currency">${igstValueFinal1}</td>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td>${igstValue2}%</td>
                                        <td class="currency">${igstValueFinal2}</td>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td>${igstValue3}%</td>
                                        <td class="currency">${igstValueFinal3}</td>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td>${igstValue4}%</td>
                                        <td class="currency">${igstValueFinal4}</td>
                                    </c:if>
                                </tr>

                                <tr>
                                    <th colspan="5"><b>Final Evaluated Price</b></th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <td></td>
                                        <td class="currency">${Total1}</td>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td></td>
                                        <td class="currency">${Total2}</td>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td></td>
                                        <td class="currency">${Total3}</td>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td></td>
                                        <td class="currency">${Total4}</td>
                                    </c:if>
                                </tr>

                                <tr>
                                    <th  colspan="5"><b>Rating</b></th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <td></td>
                                        <td>${rank1}</td>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td></td>
                                        <td>${rank2}</td>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td></td>
                                        <td>${rank3}</td>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td></td>
                                        <td>${rank4}</td>
                                    </c:if>
                                </tr>

                                <tr>
                                    <th  colspan="5"><b>No Of Item Regret</b></th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <td></td>
                                        <td>${regret1}</td>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td></td>
                                        <td>${regret2}</td>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td></td>
                                        <td>${regret3}</td>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td></td>
                                        <td>${regret4}</td>
                                    </c:if>
                                </tr>
                    </tbody>
                        </table>
                    </div>
                    </c:if>                          
                    
                    <c:if test="${tenderMaster.type == 'Contract' || tenderMaster.type == 'Contract Civil' || tenderMaster.type == 'Contract Electrical'}">
                        <br>
                        <div class="table-responsive">
                        <table class="flex-table page-break-section" class="table table-bordered" style="" align="Center"  >

                            <thead style="font-size: 12px;">
                                <tr class="table-title">
                                    <th colspan="13" style="text-align:center;">Price Bid Comparison For Service</th>
                                </tr>                                

                                <tr>
                                    <th colspan="5">Vendor Name</th>

                                    <c:if test="${vendor_code1 != ''}">
                                        <th colspan="2">${vendor_name1}</th>
                                    </c:if>

                                    <c:if test="${vendor_code2 != ''}">
                                        <th colspan="2">${vendor_name2}</th>
                                    </c:if>

                                    <c:if test="${vendor_code3 != ''}">
                                        <th colspan="2">${vendor_name3}</th>
                                    </c:if>

                                    <c:if test="${vendor_code4 != ''}">
                                        <th colspan="2">${vendor_name4}</th>
                                    </c:if>
                                </tr>                               

                                <tr>
                                    <th>Sr.</th>
                                    <th>Item Code</th>
                                    <th>Description</th>
                                    <th>Qty</th>
                                    <th>UOM</th>

                                    <c:if test="${vendor_code1 != ''}">
                                        <th>Unit Price</th>
                                        <th>Value</th>
                                    </c:if>

                                    <c:if test="${vendor_code2 != ''}">
                                        <th>Unit Price</th>
                                        <th>Value</th>
                                    </c:if>

                                    <c:if test="${vendor_code3 != ''}">
                                        <th>Unit Price</th>
                                        <th>Value</th>
                                    </c:if>

                                    <c:if test="${vendor_code4 != ''}">
                                        <th>Unit Price</th>
                                        <th>Value</th>
                                    </c:if>
                                </tr>

                            </thead>
                            
                            <tbody style="font-size: 10px;">

                                <c:forEach var="item1" items="${ServicevendorTenderBidItem1}">

                                    <tr>
                                        <td>${item1[0]}</td>
                                        <td>${item1[1]}</td>
                                        <td>${item1[2]}</td>
                                        <td>${item1[4]}</td>
                                        <td>${item1[3]}</td>

                                        <c:if test="${vendor_code1 != ''}">
                                            <td class="currency">${item1[5]}</td>
                                            <td class="currency">${item1[6]}</td>
                                        </c:if>

                                        <c:if test="${vendor_code2 != ''}">
                                            <c:set var="found2" value="false"/>

                                            <c:forEach var="item2" items="${ServicevendorTenderBidItem2}">
                                                <c:if test="${item1[0] == item2[0]}">
                                                    <td class="currency">${item2[5]}</td>
                                                    <td class="currency">${item2[6]}</td>
                                                    <c:set var="found2" value="true"/>
                                                </c:if>
                                            </c:forEach>

                                            <c:if test="${!found2}">
                                                <td>-</td>
                                                <td>-</td>
                                            </c:if>
                                        </c:if>

                                        <c:if test="${vendor_code3 != ''}">
                                            <c:set var="found3" value="false"/>

                                            <c:forEach var="item3" items="${ServicevendorTenderBidItem3}">
                                                <c:if test="${item1[0] == item3[0]}">
                                                    <td class="currency">${item3[5]}</td>
                                                    <td class="currency">${item3[6]}</td>
                                                    <c:set var="found3" value="true"/>
                                                </c:if>
                                            </c:forEach>

                                            <c:if test="${!found3}">
                                                <td>-</td>
                                                <td>-</td>
                                            </c:if>
                                        </c:if>

                                        <c:if test="${vendor_code4 != ''}">
                                            <c:set var="found4" value="false"/>

                                            <c:forEach var="item4" items="${ServicevendorTenderBidItem4}">
                                                <c:if test="${item1[0] == item4[0]}">
                                                    <td class="currency">${item4[5]}</td>
                                                    <td class="currency">${item4[6]}</td>
                                                    <c:set var="found4" value="true"/>
                                                </c:if>
                                            </c:forEach>

                                            <c:if test="${!found4}">
                                                <td>-</td>
                                                <td>-</td>
                                            </c:if>
                                        </c:if>

                                    </tr>

                                </c:forEach>

                                <tr>
                                    <th colspan="5"><b>Ex-work Price/FOB</b></th>

                                    <c:if test="${vendor_code1 != ''}">
                                        <td></td>
                                        <td class="currency">${serviceTotalFinal1}</td>
                                    </c:if>

                                    <c:if test="${vendor_code2 != ''}">
                                        <td></td>
                                        <td class="currency">${serviceTotalFinal2}</td>
                                    </c:if>

                                    <c:if test="${vendor_code3 != ''}">
                                        <td></td>
                                        <td class="currency">${serviceTotalFinal3}</td>
                                    </c:if>

                                    <c:if test="${vendor_code4 != ''}">
                                        <td></td>
                                        <td class="currency">${serviceTotalFinal4}</td>
                                    </c:if>
                                </tr>

                                <tr>
                                    <th colspan="5"><b>Discount</b></th>

                                    <c:if test="${vendor_code1 != ''}">
                                        <td>${serviceDiscountValue1}</td>
                                        <td class="currency">${serviceDiscountValueFinal1}</td>
                                    </c:if>

                                    <c:if test="${vendor_code2 != ''}">
                                        <td>${serviceDiscountValue2}</td>
                                        <td class="currency">${serviceDiscountValueFinal2}</td>
                                    </c:if>

                                    <c:if test="${vendor_code3 != ''}">
                                        <td>${serviceDiscountValue3}</td>
                                        <td class="currency">${serviceDiscountValueFinal3}</td>
                                    </c:if>

                                    <c:if test="${vendor_code4 != ''}">
                                        <td>${serviceDiscountValue4}</td>
                                        <td class="currency">${serviceDiscountValueFinal4}</td>
                                    </c:if>
                                </tr>

                                <tr>
                                    <th colspan="5"><b>Final Evaluated Price Without GST</b></th>

                                    <c:if test="${vendor_code1 != ''}">
                                        <td></td>
                                        <td class="currency">${serviceTaxTotal1 - servicegstFinal1}</td>
                                    </c:if>

                                    <c:if test="${vendor_code2 != ''}">
                                        <td></td>
                                        <td class="currency">${serviceTaxTotal2 - servicegstFinal2}</td>
                                    </c:if>

                                    <c:if test="${vendor_code3 != ''}">
                                        <td></td>
                                        <td class="currency">${serviceTaxTotal3 - servicegstFinal3}</td>
                                    </c:if>

                                    <c:if test="${vendor_code4 != ''}">
                                        <td></td>
                                        <td class="currency">${serviceTaxTotal4 - servicegstFinal4}</td>
                                    </c:if>
                                </tr>

                                <tr>
                                    <th colspan="5"><b>GST</b></th>

                                    <c:if test="${vendor_code1 != ''}">
                                        <td>${servicegst1}%</td>
                                        <td class="currency">${servicegstFinal1}</td>
                                    </c:if>

                                    <c:if test="${vendor_code2 != ''}">
                                        <td>${servicegst2}%</td>
                                        <td class="currency">${servicegstFinal2}</td>
                                    </c:if>

                                    <c:if test="${vendor_code3 != ''}">
                                        <td>${servicegst3}%</td>
                                        <td class="currency">${servicegstFinal3}</td>
                                    </c:if>

                                    <c:if test="${vendor_code4 != ''}">
                                        <td>${servicegst4}%</td>
                                        <td class="currency">${servicegstFinal4}</td>
                                    </c:if>
                                </tr>

                                <tr>
                                    <th colspan="5"><b>Final Evaluated Price</b></th>

                                    <c:if test="${vendor_code1 != ''}">
                                        <td></td>
                                        <td class="currency">${serviceTaxTotal1}</td>
                                    </c:if>

                                    <c:if test="${vendor_code2 != ''}">
                                        <td></td>
                                        <td class="currency">${serviceTaxTotal2}</td>
                                    </c:if>

                                    <c:if test="${vendor_code3 != ''}">
                                        <td></td>
                                        <td class="currency">${serviceTaxTotal3}</td>
                                    </c:if>

                                    <c:if test="${vendor_code4 != ''}">
                                        <td></td>
                                        <td class="currency">${serviceTaxTotal4}</td>
                                    </c:if>
                                </tr>

                                <tr>
                                    <th colspan="5"><b>Rating</b></th>

                                    <c:if test="${vendor_code1 != ''}">
                                        <td></td>
                                        <td>${rank1}</td>
                                    </c:if>

                                    <c:if test="${vendor_code2 != ''}">
                                        <td></td>
                                        <td>${rank2}</td>
                                    </c:if>

                                    <c:if test="${vendor_code3 != ''}">
                                        <td></td>
                                        <td>${rank3}</td>
                                    </c:if>

                                    <c:if test="${vendor_code4 != ''}">
                                        <td></td>
                                        <td>${rank4}</td>
                                    </c:if>
                                </tr>

                                <tr>
                                    <th colspan="5"><b>No. Of Item Regreted</b></th>

                                    <c:if test="${vendor_code1 != ''}">
                                        <td></td>
                                        <td>${regret1}</td>
                                    </c:if>

                                    <c:if test="${vendor_code2 != ''}">
                                        <td></td>
                                        <td>${regret2}</td>
                                    </c:if>

                                    <c:if test="${vendor_code3 != ''}">
                                        <td></td>
                                        <td>${regret3}</td>
                                    </c:if>

                                    <c:if test="${vendor_code4 != ''}">
                                        <td></td>
                                        <td>${regret4}</td>
                                    </c:if>
                                </tr>
                            </tbody>

                        </table>
                        </div>
                    </c:if>
                        <br>

                        <table class="flex-table page-break-section" class="table table-bordered" style="" align="Center"  >
                            <thead style="font-size: 12px;">
                                <tr class="table-title">
                                    <th colspan="13" style="text-align:center;">Terms & Condition Comparison</th>
                                </tr>                            

                                <tr>

                                    <th colspan="2">Vendor Name</th>

                                    <c:if test="${vendor_code1 != ''}">
                                        <th colspan="2">${vendor_name1}</th>
                                        </c:if>

                                    <c:if test="${vendor_code2 != ''}">
                                        <th colspan="2">${vendor_name2}</th>
                                        </c:if>

                                    <c:if test="${vendor_code3 != ''}">
                                        <th colspan="2">${vendor_name3}</th>
                                        </c:if>

                                    <c:if test="${vendor_code4 != ''}">
                                        <th colspan="2">${vendor_name4}</th>
                                        </c:if>

                                </tr>

                                <tr>

                                    <th>Terms Condition</th>
                                    <th>Description</th>

                                    <c:if test="${vendor_code1 != ''}">
                                        <th>Response</th>
                                        <th>Remark</th>
                                        </c:if>

                                    <c:if test="${vendor_code2 != ''}">
                                        <th>Response</th>
                                        <th>Remark</th>
                                        </c:if>

                                    <c:if test="${vendor_code3 != ''}">
                                        <th>Response</th>
                                        <th>Remark</th>
                                        </c:if>

                                    <c:if test="${vendor_code4 != ''}">
                                        <th>Response</th>
                                        <th>Remark</th>
                                        </c:if>

                                </tr>

                            </thead>
                            <tbody style="font-size: 10px;">
                                <c:forEach var="vendorTermsCondition1" items="${vendorTermsCondition1}" varStatus="status">
                                    <tr>
                                        <td style="min-width: 180px;">${vendorTermsCondition1.termsCondition}</td>
                                        <td style="min-width: 200px;">${vendorTermsCondition1.description}</td>

                                        <c:if test="${vendor_code1 != ''}">

                                            <td>
                                                <c:choose>
                                                    <c:when test="${vendorTermsCondition1.response == 0}">
                                                        Accept
                                                    </c:when>
                                                    <c:otherwise>
                                                        Reject
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>

                                            <td>${vendorTermsCondition1.comment}</td>

                                        </c:if>

                                        <c:if test="${vendor_code2 != ''}">

                                            <c:set var="found2" value="false"/>

                                            <c:forEach var="vendorTermsCondition2" 
                                                       items="${vendorTermsCondition2}">

                                                <c:if test="${vendorTermsCondition1.termsCondition == vendorTermsCondition2.termsCondition}">

                                                    <td>
                                                        <c:choose>
                                                            <c:when test="${vendorTermsCondition2.response == 0}">
                                                                Accept
                                                            </c:when>
                                                            <c:otherwise>
                                                                Reject
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>

                                                    <td>${vendorTermsCondition2.comment}</td>

                                                    <c:set var="found2" value="true"/>

                                                </c:if>

                                            </c:forEach>

                                            <c:if test="${!found2}">
                                                <td>-</td>
                                                <td>-</td>
                                            </c:if>

                                        </c:if>

                                        <c:if test="${vendor_code3 != ''}">

                                            <c:set var="found3" value="false"/>

                                            <c:forEach var="vendorTermsCondition3" 
                                                       items="${vendorTermsCondition3}">

                                                <c:if test="${vendorTermsCondition1.termsCondition == vendorTermsCondition3.termsCondition}">

                                                    <td>
                                                        <c:choose>
                                                            <c:when test="${vendorTermsCondition3.response == 0}">
                                                                Accept
                                                            </c:when>
                                                            <c:otherwise>
                                                                Reject
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>

                                                    <td>${vendorTermsCondition3.comment}</td>

                                                    <c:set var="found3" value="true"/>

                                                </c:if>

                                            </c:forEach>

                                            <c:if test="${!found3}">
                                                <td>-</td>
                                                <td>-</td>
                                            </c:if>

                                        </c:if>

                                        <c:if test="${vendor_code4 != ''}">

                                            <c:set var="found4" value="false"/>

                                            <c:forEach var="vendorTermsCondition4" 
                                                       items="${vendorTermsCondition4}">

                                                <c:if test="${vendorTermsCondition1.termsCondition == vendorTermsCondition4.termsCondition}">

                                                    <td>
                                                        <c:choose>
                                                            <c:when test="${vendorTermsCondition4.response == 0}">
                                                                Accept
                                                            </c:when>
                                                            <c:otherwise>
                                                                Reject
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>

                                                    <td>${vendorTermsCondition4.comment}</td>

                                                    <c:set var="found4" value="true"/>

                                                </c:if>

                                            </c:forEach>

                                            <c:if test="${!found4}">
                                                <td>-</td>
                                                <td>-</td>
                                            </c:if>

                                        </c:if>

                                    </tr>

                                </c:forEach>

                            </tbody>
                        </table>
                        
                        <br>
                        <table class="flex-table page-break-section" class="table table-bordered" style="" align="Center"  >
                            <thead style="font-size: 12px;">

                                <tr class="table-title">
                                    <th colspan="13" style="text-align:center;">Vendor Comparison</th>
                                </tr>

                                <tr>
                                    <th>Sr No</th>
                                    <th>Vendor Code</th>
                                    <th>Vendor Name</th>
                                    <th>Supply Part</th>
                                    <th>Service Part</th>
                                    <th>Basic Total</th>
                                    <th>GST Value</th>
                                    <th>Total including Tax</th>
                                    <th>Budget Value</th>
                                    <th>Difference Between Budget Value VS Received Proposal</th>
                                    <th>Difference In Percentage</th>
                                </tr>

                            </thead>
                            <tbody  style="font-size: 10px;">
                                <c:set var="sn" value="0" />
                                <c:set var="sn" value="${sn + 1}" />
                                <tr>
                                    <td>${sn}</td>
                                    <td>${vendor_code1}</td>
                                    <td>${vendor_name1}</td>
                                    <td class="currency">${Total1 - igstValueFinal1}</td>
                                    <td class="currency">${serviceTaxTotal1 - servicegstFinal1}</td>
                                    <td class="currency">${serviceTaxTotal1 - servicegstFinal1 + Total1 - igstValueFinal1}</td>
                                    <td class="currency">${servicegstFinal1 + igstValueFinal1}</td>
                                    <td class="currency">${Total1 + serviceTaxTotal1}</td>
                                    <td class="currency">${tenderMaster.value}</td>
                                    <td class="currency">${tenderMaster.value - Total1 - serviceTaxTotal1}</td>
                                    <td><fmt:formatNumber value="${((tenderMaster.value - (Total1 + serviceTaxTotal1)) * 100) / tenderMaster.value}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2"/>%</td>
                                </tr>

                                <c:if test="${vendor_code2 != ''}">
                                    <c:set var="sn" value="${sn + 1}" />
                                    <tr>
                                        <td>${sn}</td>
                                        <td>${vendor_code2}</td>
                                        <td>${vendor_name2}</td>
                                        <td class="currency">${Total2 - igstValueFinal2}</td>
                                        <td class="currency">${serviceTaxTotal2 - servicegstFinal2}</td>
                                        <td class="currency">${serviceTaxTotal2 - servicegstFinal2 + Total2 - igstValueFinal2}</td>
                                        <td class="currency">${servicegstFinal2 + igstValueFinal2}</td>
                                        <td class="currency">${Total2 + serviceTaxTotal2}</td>
                                        <td class="currency">${tenderMaster.value}</td>
                                        <td class="currency">${tenderMaster.value - Total2 - serviceTaxTotal2}</td>
                                        <td><fmt:formatNumber value="${((tenderMaster.value - (Total2 + serviceTaxTotal2)) * 100) / tenderMaster.value}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2"/>%</td>
                                    </tr>
                                </c:if>

                                <c:if test="${vendor_code3 != ''}">
                                    <c:set var="sn" value="${sn + 1}" />
                                    <tr>
                                        <td>${sn}</td>
                                        <td>${vendor_code3}</td>
                                        <td>${vendor_name3}</td>
                                        <td class="currency">${Total3 - igstValueFinal3}</td>
                                        <td class="currency">${serviceTaxTotal3 - servicegstFinal3}</td>
                                        <td class="currency">${serviceTaxTotal3 - servicegstFinal3 + Total3 - igstValueFinal3}</td>
                                        <td class="currency">${servicegstFinal3 + igstValueFinal3}</td>
                                        <td class="currency">${Total3 + serviceTaxTotal3}</td>
                                        <td class="currency">${tenderMaster.value}</td>
                                        <td class="currency">${tenderMaster.value - Total3 - serviceTaxTotal3}</td>
                                        <td><fmt:formatNumber value="${((tenderMaster.value - (Total3 + serviceTaxTotal3)) * 100) / tenderMaster.value}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2"/>%</td>
                                    </tr>
                                </c:if>

                                <c:if test="${vendor_code4 != ''}">
                                    <c:set var="sn" value="${sn + 1}" />
                                    <tr>
                                        <td>${sn}</td>
                                        <td>${vendor_code4}</td>
                                        <td>${vendor_name4}</td>
                                        <td class="currency">${Total4 - igstValueFinal4}</td>
                                        <td class="currency">${serviceTaxTotal4 - servicegstFinal4}</td>
                                        <td class="currency">${serviceTaxTotal4 - servicegstFinal4 + Total4 - igstValueFinal4}</td>
                                        <td class="currency">${servicegstFinal4 + igstValueFinal4}</td>
                                        <td class="currency">${Total4 + serviceTaxTotal4}</td>
                                        <td class="currency">${tenderMaster.value}</td>
                                        <td class="currency">${tenderMaster.value - Total4 - serviceTaxTotal4}</td>
                                        <td><fmt:formatNumber value="${((tenderMaster.value - (Total4 + serviceTaxTotal4)) * 100) / tenderMaster.value}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2"/>%</td>
                                    </tr>
                                </c:if>

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

