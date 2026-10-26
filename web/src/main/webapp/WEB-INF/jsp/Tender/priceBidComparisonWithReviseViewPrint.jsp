<%--
Document   : priceBidComparisonWithReviseViewPrint
Created on : Apr 1, 2026, 3:41:47 PM
Author     : Sumanth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNewPrint.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PRICE BID COMPARISON WITH REVISE</title>
        
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

                            <h5 class="fw-600 mb-0  no-print">PRICE BID COMPARISON WITH REVISE</h5>
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
                                    PRICE BID COMPARISON WITH REVISE
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
                        <table class="flex-table" class="table" style="" align="Center"  >
                            <thead style="font-size: 12px;">
                                <tr class="table-title">
                                    <th colspan="21" style="text-align: center;">Price Bid Comparison With Revise Bid For Item</th>
                                </tr>                               

                                <tr>

                                    <th rowspan="2">Sr No.</th>
                                    
                                    <th colspan="4">Vendor Name</th>

                                    <c:if test="${vendor_code1 != ''}">
                                        <th colspan="2">${vendor_name1}</th>

                                        <c:if test="${rev_submit_flag1 == '1'}">
                                            <th colspan="2">${vendor_name1}</th>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code2 != ''}">
                                        <th colspan="2">${vendor_name2}</th>

                                        <c:if test="${rev_submit_flag2 == '1'}">
                                            <th colspan="2">${vendor_name2}</th>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code3 != ''}">
                                        <th colspan="2">${vendor_name3}</th>

                                        <c:if test="${rev_submit_flag3 == '1'}">
                                            <th colspan="2">${vendor_name3}</th>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code4 != ''}">
                                        <th colspan="2">${vendor_name4}</th>

                                        <c:if test="${rev_submit_flag4 == '1'}">
                                            <th colspan="2">${vendor_name4}</th>
                                        </c:if>
                                    </c:if>

                                </tr>

                                <tr>

                                    <th>Item Code</th>
                                    <th>Description</th>
                                    <th>Qty</th>
                                    <th>UOM</th>
                                    
                                    <c:if test="${vendor_code1 != ''}">
                                        <th>Unit Price</th>
                                        <th>Value</th>
                                        <c:if test="${rev_submit_flag1 == '1'}">
                                            <th>Rev Unit Price</th>
                                            <th>Rev Value</th>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code2 != ''}">
                                        <th>Unit Price</th>
                                        <th>Value</th>
                                        <c:if test="${rev_submit_flag2 == '1'}">
                                            <th>Rev Unit Price</th>
                                            <th>Rev Value</th>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code3 != ''}">
                                        <th>Unit Price</th>
                                        <th>Value</th>
                                        <c:if test="${rev_submit_flag3 == '1'}">
                                            <th>Rev Unit Price</th>
                                            <th>Rev Value</th>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code4 != ''}">
                                        <th>Unit Price</th>
                                        <th>Value</th>
                                        <c:if test="${rev_submit_flag4 == '1'}">
                                            <th>Rev Unit Price</th>
                                            <th>Rev Value</th>
                                        </c:if>
                                    </c:if>
                                </tr>
                            </thead>
                            
                            <tbody style="font-size: 9px;">
                                <c:forEach var="item1" items="${vendorTenderBidItem1}" varStatus="status">

                                    <tr>
                                        <td>${status.count}</td>
                                        <td>${item1[1]}</td>
                                        <td style="min-width: 200px; font-size: 8px;">${item1[2]}</td>
                                        <td>${item1[4]}</td>
                                        <td>${item1[3]}</td>
                                        <c:if test="${vendor_code1 != ''}">
                                            <td class="currency">${item1[5]}</td>
                                            <td class="currency">${item1[6]}</td>
                                            <c:if test="${rev_submit_flag1 == '1'}">
                                                <c:set var="revFound1" value="false"/>
                                                <c:forEach var="rev1" items="${reviseVendorTenderBidItem1}">
                                                    <c:if test="${item1[0] == rev1[0]}">
                                                        <td class="currency">${rev1[5]}</td>
                                                        <td class="currency">${rev1[6]}</td>
                                                        <c:set var="revFound1" value="true"/>
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${!revFound1}">
                                                    <td>-</td>
                                                    <td>-</td>
                                                </c:if>
                                            </c:if>
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
                                            <c:if test="${rev_submit_flag2 == '1'}">
                                                <c:set var="revFound2" value="false"/>
                                                <c:forEach var="rev2" items="${reviseVendorTenderBidItem2}">
                                                    <c:if test="${item1[0] == rev2[0]}">
                                                        <td class="currency">${rev2[5]}</td>
                                                        <td class="currency">${rev2[6]}</td>
                                                        <c:set var="revFound2" value="true"/>
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${!revFound2}">
                                                    <td>-</td>
                                                    <td>-</td>
                                                </c:if>
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
                                            <c:if test="${rev_submit_flag3 == '1'}">
                                                <c:set var="revFound3" value="false"/>
                                                <c:forEach var="rev3" items="${reviseVendorTenderBidItem3}">
                                                    <c:if test="${item1[0] == rev3[0]}">
                                                        <td class="currency">${rev3[5]}</td>
                                                        <td class="currency">${rev3[6]}</td>
                                                        <c:set var="revFound3" value="true"/>
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${!revFound3}">
                                                    <td>-</td>
                                                    <td>-</td>
                                                </c:if>
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
                                            <c:if test="${rev_submit_flag4 == '1'}">
                                                <c:set var="revFound4" value="false"/>
                                                <c:forEach var="rev4" items="${reviseVendorTenderBidItem4}">
                                                    <c:if test="${item1[0] == rev4[0]}">
                                                        <td class="currency">${rev4[5]}</td>
                                                        <td class="currency">${rev4[6]}</td>
                                                        <c:set var="revFound4" value="true"/>
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${!revFound4}">
                                                    <td>-</td>
                                                    <td>-</td>
                                                </c:if>
                                            </c:if>
                                        </c:if>
                                    </tr>
                                </c:forEach>
                                    
                                <tr>
                                    <th colspan="5">Ex-work Price/FOB</th>

                                    <c:if test="${vendor_code1 != ''}">
                                        <td></td>
                                        <td class="currency">${total_value1}</td>
                                        <c:if test="${rev_submit_flag1 == '1'}">
                                            <td></td>
                                            <td class="currency">${rev_total_value1}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code2 != ''}">
                                        <td></td>
                                        <td class="currency">${total_value2}</td>
                                        <c:if test="${rev_submit_flag2 == '1'}">
                                            <td></td>
                                            <td class="currency">${rev_total_value2}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code3 != ''}">
                                        <td></td>
                                        <td class="currency">${total_value3}</td>

                                        <c:if test="${rev_submit_flag3 == '1'}">
                                            <td></td>
                                            <td class="currency">${rev_total_value3}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code4 != ''}">
                                        <td></td>
                                        <td class="currency">${total_value4}</td>

                                        <c:if test="${rev_submit_flag4 == '1'}">
                                            <td></td>
                                            <td class="currency">${rev_total_value4}</td>
                                        </c:if>
                                    </c:if>
                                </tr>

                                <tr>
                                    <th colspan="5">Packing & Forwarding</th>

                                    <c:if test="${vendor_code1 != ''}">
                                        <td>${packingValue1}%</td>
                                        <td class="currency">${packingValueFinal1}</td>

                                        <c:if test="${rev_submit_flag1 == '1'}">
                                            <td>${revpackingValue1}%</td>
                                            <td class="currency">${revpackingValueFinal1}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code2 != ''}">
                                        <td>${packingValue2}%</td>
                                        <td class="currency">${packingValueFinal2}</td>

                                        <c:if test="${rev_submit_flag2 == '1'}">
                                            <td>${revpackingValue2}%</td>
                                            <td class="currency">${revpackingValueFinal2}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code3 != ''}">
                                        <td>${packingValue3}%</td>
                                        <td class="currency">${packingValueFinal3}</td>

                                        <c:if test="${rev_submit_flag3 == '1'}">
                                            <td>${revpackingValue3}%</td>
                                            <td class="currency">${revpackingValueFinal3}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code4 != ''}">
                                        <td>${packingValue4}%</td>
                                        <td class="currency">${packingValueFinal4}</td>

                                        <c:if test="${rev_submit_flag4 == '1'}">
                                            <td>${revpackingValue4}%</td>
                                            <td class="currency">${revpackingValueFinal4}</td>
                                        </c:if>
                                    </c:if>
                                </tr>

                                <tr>
                                    <th colspan="5">Charges</th>

                                    <c:if test="${vendor_code1 != ''}">
                                        <td>${chargesValue1}%</td>
                                        <td class="currency">${chargesValueFinal1}</td>

                                        <c:if test="${rev_submit_flag1 == '1'}">
                                            <td>${revchargesValue1}%</td>
                                            <td class="currency">${revchargesValueFinal1}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code2 != ''}">
                                        <td>${chargesValue2}%</td>
                                        <td class="currency">${chargesValueFinal2}</td>

                                        <c:if test="${rev_submit_flag2 == '1'}">
                                            <td>${revchargesValue2}%</td>
                                            <td class="currency">${revchargesValueFinal2}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code3 != ''}">
                                        <td>${chargesValue3}%</td>
                                        <td class="currency">${chargesValueFinal3}</td>

                                        <c:if test="${rev_submit_flag3 == '1'}">
                                            <td>${revchargesValue3}%</td>
                                            <td class="currency">${revchargesValueFinal3}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code4 != ''}">
                                        <td>${chargesValue4}%</td>
                                        <td class="currency">${chargesValueFinal4}</td>

                                        <c:if test="${rev_submit_flag4 == '1'}">
                                            <td>${revchargesValue4}%</td>
                                            <td class="currency">${revchargesValueFinal4}</td>
                                        </c:if>
                                    </c:if>
                                </tr>

                                <tr>
                                    <th colspan="5">Insurance</th>

                                    <c:if test="${vendor_code1 != ''}">
                                        <td>${insuranceValue1}%</td>
                                        <td class="currency">${insuranceValueFinal1}</td>

                                        <c:if test="${rev_submit_flag1 == '1'}">
                                            <td>${revinsuranceValue1}%</td>
                                            <td class="currency">${revinsuranceValueFinal1}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code2 != ''}">
                                        <td>${insuranceValue2}%</td>
                                        <td class="currency">${insuranceValueFinal2}</td>

                                        <c:if test="${rev_submit_flag2 == '1'}">
                                            <td>${revinsuranceValue2}%</td>
                                            <td class="currency">${revinsuranceValueFinal2}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code3 != ''}">
                                        <td>${insuranceValue3}%</td>
                                        <td class="currency">${insuranceValueFinal3}</td>

                                        <c:if test="${rev_submit_flag3 == '1'}">
                                            <td>${revinsuranceValue3}%</td>
                                            <td class="currency">${revinsuranceValueFinal3}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code4 != ''}">
                                        <td>${insuranceValue4}%</td>
                                        <td class="currency">${insuranceValueFinal4}</td>

                                        <c:if test="${rev_submit_flag4 == '1'}">
                                            <td>${revinsuranceValue4}%</td>
                                            <td class="currency">${revinsuranceValueFinal4}</td>
                                        </c:if>
                                    </c:if>
                                </tr>

                                <tr>
                                    <th colspan="5">Erection Commission</th>

                                    <c:if test="${vendor_code1 != ''}">
                                        <td>${errectionValue1}%</td>
                                        <td class="currency">${errectionValueFinal1}</td>

                                        <c:if test="${rev_submit_flag1 == '1'}">
                                            <td>${reverrectionValue1}%</td>
                                            <td class="currency">${reverrectionValueFinal1}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code2 != ''}">
                                        <td>${errectionValue2}%</td>
                                        <td class="currency">${errectionValueFinal2}</td>

                                        <c:if test="${rev_submit_flag2 == '1'}">
                                            <td>${reverrectionValue2}%</td>
                                            <td class="currency">${reverrectionValueFinal2}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code3 != ''}">
                                        <td>${errectionValue3}%</td>
                                        <td class="currency">${errectionValueFinal3}</td>

                                        <c:if test="${rev_submit_flag3 == '1'}">
                                            <td>${reverrectionValue3}%</td>
                                            <td class="currency">${reverrectionValueFinal3}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code4 != ''}">
                                        <td>${errectionValue4}%</td>
                                        <td class="currency">${errectionValueFinal4}</td>

                                        <c:if test="${rev_submit_flag4 == '1'}">
                                            <td>${reverrectionValue4}%</td>
                                            <td class="currency">${reverrectionValueFinal4}</td>
                                        </c:if>
                                    </c:if>
                                </tr>

                                <tr>
                                    <th colspan="5">Discount</th>

                                    <c:if test="${vendor_code1 != ''}">
                                        <td>${discountValue1}%</td>
                                        <td class="currency">${discountValueFinal1}</td>

                                        <c:if test="${rev_submit_flag1 == '1'}">
                                            <td>${revdiscountValue1}%</td>
                                            <td class="currency">${revdiscountValueFinal1}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code2 != ''}">
                                        <td>${discountValue2}%</td>
                                        <td class="currency">${discountValueFinal2}</td>

                                        <c:if test="${rev_submit_flag2 == '1'}">
                                            <td>${revdiscountValue2}%</td>
                                            <td class="currency">${revdiscountValueFinal2}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code3 != ''}">
                                        <td>${discountValue3}%</td>
                                        <td class="currency">${discountValueFinal3}</td>

                                        <c:if test="${rev_submit_flag3 == '1'}">
                                            <td>${revdiscountValue3}%</td>
                                            <td class="currency">${revdiscountValueFinal3}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code4 != ''}">
                                        <td>${discountValue4}%</td>
                                        <td class="currency">${discountValueFinal4}</td>

                                        <c:if test="${rev_submit_flag4 == '1'}">
                                            <td>${revdiscountValue4}%</td>
                                            <td class="currency">${revdiscountValueFinal4}</td>
                                        </c:if>
                                    </c:if>
                                </tr>

                                <tr>
                                    <th colspan="5">Final Evaluated Price without GST</th>

                                    <c:if test="${vendor_code1 != ''}">
                                        <td></td>
                                        <td class="currency">${Total1 - igstValueFinal1}</td>

                                        <c:if test="${rev_submit_flag1 == '1'}">
                                            <td></td>
                                            <td class="currency">${revTotal1 - revigstValueFinal1}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code2 != ''}">
                                        <td></td>
                                        <td class="currency">${Total2 - igstValueFinal2}</td>

                                        <c:if test="${rev_submit_flag2 == '1'}">
                                            <td></td>
                                            <td class="currency">${revTotal2 - revigstValueFinal2}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code3 != ''}">
                                        <td></td>
                                        <td class="currency">${Total3 - igstValueFinal3}</td>

                                        <c:if test="${rev_submit_flag3 == '1'}">
                                            <td></td>
                                            <td class="currency">${revTotal3 - revigstValueFinal3}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code4 != ''}">
                                        <td></td>
                                        <td class="currency">${Total4 - igstValueFinal4}</td>

                                        <c:if test="${rev_submit_flag4 == '1'}">
                                            <td></td>
                                            <td class="currency">${revTotal4 - revigstValueFinal4}</td>
                                        </c:if>
                                    </c:if>
                                </tr>

                                <tr>
                                    <th colspan="5">GST</th>

                                    <c:if test="${vendor_code1 != ''}">
                                        <td>${igstValue1}%</td>
                                        <td class="currency">${igstValueFinal1}</td>

                                        <c:if test="${rev_submit_flag1 == '1'}">
                                            <td>${revigstValue1}%</td>
                                            <td class="currency">${revigstValueFinal1}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code2 != ''}">
                                        <td>${igstValue2}%</td>
                                        <td class="currency">${igstValueFinal2}</td>

                                        <c:if test="${rev_submit_flag2 == '1'}">
                                            <td>${revigstValue2}%</td>
                                            <td class="currency">${revigstValueFinal2}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code3 != ''}">
                                        <td>${igstValue3}%</td>
                                        <td class="currency">${igstValueFinal3}</td>

                                        <c:if test="${rev_submit_flag3 == '1'}">
                                            <td>${revigstValue3}%</td>
                                            <td class="currency">${revigstValueFinal3}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code4 != ''}">
                                        <td>${igstValue4}%</td>
                                        <td class="currency">${igstValueFinal4}</td>

                                        <c:if test="${rev_submit_flag4 == '1'}">
                                            <td>${revigstValue4}%</td>
                                            <td class="currency">${revigstValueFinal4}</td>
                                        </c:if>
                                    </c:if>

                                </tr>
                                <tr>

                                    <th colspan="5">Final Evaluated Price</th>

                                    <c:if test="${vendor_code1 != ''}">
                                        <td></td>
                                        <td class="currency">${Total1}</td>

                                        <c:if test="${rev_submit_flag1 == '1'}">
                                            <td></td>
                                            <td class="currency">${revTotal1}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code2 != ''}">
                                        <td></td>
                                        <td class="currency">${Total2}</td>

                                        <c:if test="${rev_submit_flag2 == '1'}">
                                            <td></td>
                                            <td class="currency">${revTotal2}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code3 != ''}">
                                        <td></td>
                                        <td class="currency">${Total3}</td>

                                        <c:if test="${rev_submit_flag3 == '1'}">
                                            <td></td>
                                            <td class="currency">${revTotal3}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code4 != ''}">
                                        <td></td>
                                        <td class="currency">${Total4}</td>

                                        <c:if test="${rev_submit_flag4 == '1'}">
                                            <td></td>
                                            <td class="currency">${revTotal4}</td>
                                        </c:if>
                                    </c:if>
                                </tr>
                                
                                <tr>
                                    <th colspan="5">Rating</th>

                                    <c:if test="${vendor_code1 != ''}">
                                        <td></td>
                                        <td>${rank1}</td>

                                        <c:if test="${rev_submit_flag1 == '1'}">
                                            <td></td>
                                            <td>${rank1}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code2 != ''}">
                                        <td></td>
                                        <td>${rank2}</td>

                                        <c:if test="${rev_submit_flag2 == '1'}">
                                            <td></td>
                                            <td>${rank2}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code3 != ''}">
                                        <td></td>
                                        <td>${rank3}</td>

                                        <c:if test="${rev_submit_flag3 == '1'}">
                                            <td></td>
                                            <td>${rank3}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code4 != ''}">
                                        <td></td>
                                        <td>${rank4}</td>

                                        <c:if test="${rev_submit_flag4 == '1'}">
                                            <td></td>
                                            <td>${rank4}</td>
                                        </c:if>
                                    </c:if>
                                </tr>

                                <tr>
                                    <th colspan="5">No Of Item Regret</th>

                                    <c:if test="${vendor_code1 != ''}">
                                        <td></td>
                                        <td>${regret1}</td>

                                        <c:if test="${rev_submit_flag1 == '1'}">
                                            <td></td>
                                            <td>${regret1}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code2 != ''}">
                                        <td></td>
                                        <td>${regret2}</td>

                                        <c:if test="${rev_submit_flag2 == '1'}">
                                            <td></td>
                                            <td>${regret2}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code3 != ''}">
                                        <td></td>
                                        <td>${regret3}</td>

                                        <c:if test="${rev_submit_flag3 == '1'}">
                                            <td></td>
                                            <td>${regret3}</td>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code4 != ''}">
                                        <td></td>
                                        <td>${regret4}</td>

                                        <c:if test="${rev_submit_flag4 == '1'}">
                                            <td></td>
                                            <td>${regret4}</td>
                                        </c:if>
                                    </c:if>

                                </tr>
                            </tbody>
                        </table>
                        </div>
                    </c:if>  
                        

                    <c:if test = "${tenderMaster.type == 'Contract' || tenderMaster.type == 'Contract Civil' || tenderMaster.type == 'Contract Electrical'}">    
                        <br>
                        <div class="table-responsive">
                            <table class="flex-table page-break-section" class="table table-bordered" style="" align="Center"  >
                                <thead style="font-size: 12px;">
                                    
                                    <tr class="table-title">
                                        <th colspan="21" style="text-align: center;">Price Bid Comparison With Revise Bid For Service</th>
                                    </tr>                               

                                    <tr>

                                        <th rowspan="2">Sr No.</th>
                                        <th colspan="4">Vendor Name</th>

                                        <c:if test="${vendor_code1 != ''}">
                                            <th colspan="2">${vendor_name1}</th>
                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                <th colspan="2">${vendor_name1}</th>
                                                </c:if>
                                            </c:if>

                                        <c:if test="${vendor_code2 != ''}">
                                            <th colspan="2">${vendor_name2}</th>
                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                <th colspan="2">${vendor_name2}</th>
                                                </c:if>
                                            </c:if>

                                        <c:if test="${vendor_code3 != ''}">
                                            <th colspan="2">${vendor_name3}</th>
                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                <th colspan="2">${vendor_name3}</th>
                                                </c:if>
                                            </c:if>

                                        <c:if test="${vendor_code4 != ''}">
                                            <th colspan="2">${vendor_name4}</th>
                                            <c:if test="${rev_submit_flag4 == '1'}">
                                                <th colspan="2">${vendor_name4}</th>
                                            </c:if>
                                        </c:if>
                                    </tr>

                                    <tr>

                                        <th>Item Code</th>
                                        <th>Description</th>
                                        <th>Qty</th>
                                        <th>UOM</th>

                                        <c:if test="${vendor_code1 != ''}">
                                            <th>Unit Price</th>
                                            <th>Value</th>
                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                <th>Rev Unit Price</th>
                                                <th>Rev Value</th>
                                                </c:if>
                                            </c:if>

                                        <c:if test="${vendor_code2 != ''}">
                                            <th>Unit Price</th>
                                            <th>Value</th>
                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                <th>Rev Unit Price</th>
                                                <th>Rev Value</th>
                                                </c:if>
                                            </c:if>

                                        <c:if test="${vendor_code3 != ''}">
                                            <th>Unit Price</th>
                                            <th>Value</th>
                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                <th>Rev Unit Price</th>
                                                <th>Rev Value</th>
                                                </c:if>
                                            </c:if>

                                        <c:if test="${vendor_code4 != ''}">
                                            <th>Unit Price</th>
                                            <th>Value</th>
                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                <th>Rev Unit Price</th>
                                                <th>Rev Value</th>
                                                </c:if>
                                            </c:if>

                                    </tr>
                                </thead>

                                <tbody style="font-size: 9px;">

                                    <c:forEach var="item1" items="${ServicevendorTenderBidItem1}" varStatus="status">

                                        <tr>
                                            <td>${status.count}</td>
                                            <td>${item1[1]}</td>
                                            <td style="min-width: 200px; font-size: 8px;">${item1[2]}</td>
                                            <td>${item1[4]}</td>
                                            <td>${item1[3]}</td>

                                            <c:if test="${vendor_code1 != ''}">
                                                <td class="currency">${item1[5]}</td>
                                                <td class="currency">${item1[6]}</td>

                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                    <c:set var="revFound1" value="false" />
                                                    <c:forEach var="rev1" items="${revServicevendorTenderBidItem1}">
                                                        <c:if test="${item1[0] == rev1[0]}">
                                                            <td class="currency">${rev1[5]}</td>
                                                            <td class="currency">${rev1[6]}</td>
                                                            <c:set var="revFound1" value="true" />
                                                        </c:if>
                                                    </c:forEach>
                                                    <c:if test="${!revFound1}">
                                                        <td>-</td>
                                                        <td>-</td>
                                                    </c:if>
                                                </c:if>

                                            </c:if>

                                            <c:if test="${vendor_code2 != ''}">
                                                <c:set var="found2" value="false" />
                                                <c:forEach var="item2" items="${ServicevendorTenderBidItem2}">
                                                    <c:if test="${item1[0] == item2[0]}">
                                                        <td class="currency">${item2[5]}</td>
                                                        <td class="currency">${item2[6]}</td>
                                                        <c:set var="found2" value="true" />
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${!found2}">
                                                    <td>-</td>
                                                    <td>-</td>
                                                </c:if>
                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                    <c:set var="revFound2" value="false" />
                                                    <c:forEach var="rev2" items="${revServicevendorTenderBidItem2}">
                                                        <c:if test="${item1[0] == rev2[0]}">
                                                            <td class="currency">${rev2[5]}</td>
                                                            <td class="currency">${rev2[6]}</td>
                                                            <c:set var="revFound2" value="true" />
                                                        </c:if>
                                                    </c:forEach>
                                                    <c:if test="${!revFound2}">
                                                        <td>-</td>
                                                        <td>-</td>
                                                    </c:if>
                                                </c:if>
                                            </c:if>

                                            <c:if test="${vendor_code3 != ''}">
                                                <c:set var="found3" value="false" />
                                                <c:forEach var="item3" items="${ServicevendorTenderBidItem3}">
                                                    <c:if test="${item1[0] == item3[0]}">
                                                        <td class="currency">${item3[5]}</td>
                                                        <td class="currency">${item3[6]}</td>
                                                        <c:set var="found3" value="true" />
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${!found3}">
                                                    <td>-</td>
                                                    <td>-</td>
                                                </c:if>
                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                    <c:set var="revFound3" value="false"/>
                                                    <c:forEach var="rev3" items="${revServicevendorTenderBidItem3}">
                                                        <c:if test="${item1[0] == rev3[0]}">
                                                            <td class="currency">${rev3[5]}</td>
                                                            <td class="currency">${rev3[6]}</td>
                                                            <c:set var="revFound3" value="true" />
                                                        </c:if>
                                                    </c:forEach>
                                                    <c:if test="${!revFound3}">
                                                        <td>-</td>
                                                        <td>-</td>
                                                    </c:if>
                                                </c:if>
                                            </c:if>

                                            <c:if test="${vendor_code4 != ''}">
                                                <c:set var="found4" value="false" />
                                                <c:forEach var="item4" items="${ServicevendorTenderBidItem4}">
                                                    <c:if test="${item1[0] == item4[0]}">
                                                        <td class="currency">${item4[5]}</td>
                                                        <td class="currency">${item4[6]}</td>
                                                        <c:set var="found4" value="true" />
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${!found4}">
                                                    <td>-</td>
                                                    <td>-</td>
                                                </c:if>
                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                    <c:set var="revFound4" value="false" />
                                                    <c:forEach var="rev4" items="${revServicevendorTenderBidItem4}">
                                                        <c:if test="${item1[0] == rev4[0]}">
                                                            <td class="currency">${rev4[5]}</td>
                                                            <td class="currency">${rev4[6]}</td>
                                                            <c:set var="revFound4" value="true" />
                                                        </c:if>
                                                    </c:forEach>
                                                    <c:if test="${!revFound4}">
                                                        <td>-</td>
                                                        <td>-</td>
                                                    </c:if>
                                                </c:if>
                                            </c:if>
                                        </tr>
                                    </c:forEach>

                                    <tr>

                                        <th colspan="5">Ex-work Price/FOB</th>

                                        <c:if test="${vendor_code1 != ''}">
                                            <td></td>
                                            <td class="currency">${serviceTotalFinal1}</td>

                                            <c:if test="${rev_submit_flag1 == '1'}">
                                                <td></td>
                                                <td class="currency">${revserviceTotalFinal1}</td>
                                            </c:if>
                                        </c:if>

                                        <c:if test="${vendor_code2 != ''}">
                                            <td></td>
                                            <td class="currency">${serviceTotalFinal2}</td>

                                            <c:if test="${rev_submit_flag2 == '1'}">
                                                <td></td>
                                                <td class="currency">${revserviceTotalFinal2}</td>
                                            </c:if>
                                        </c:if>

                                        <c:if test="${vendor_code3 != ''}">
                                            <td></td>
                                            <td class="currency">${serviceTotalFinal3}</td>

                                            <c:if test="${rev_submit_flag3 == '1'}">
                                                <td></td>
                                                <td class="currency">${revserviceTotalFinal3}</td>
                                            </c:if>
                                        </c:if>

                                        <c:if test="${vendor_code4 != ''}">
                                            <td></td>
                                            <td class="currency">${serviceTotalFinal4}</td>

                                            <c:if test="${rev_submit_flag4 == '1'}">
                                                <td></td>
                                                <td class="currency">${revserviceTotalFinal4}</td>
                                            </c:if>
                                        </c:if>

                                    </tr>

                                    <tr>
                                        <th colspan="5">Discount</th>
                                            <c:if test="${vendor_code1 != ''}">
                                            <td>${serviceDiscountValue1}</td>
                                            <td class="currency">${serviceDiscountValueFinal1}</td>

                                            <c:if test="${rev_submit_flag1 == '1'}">
                                                <td >${revserviceDiscountValue1}</td>
                                                <td class="currency">${revserviceDiscountValueFinal1}</td>
                                            </c:if>

                                        </c:if>

                                        <c:if test="${vendor_code2 != ''}">
                                            <td>${serviceDiscountValue2}</td>
                                            <td class="currency">${serviceDiscountValueFinal2}</td>

                                            <c:if test="${rev_submit_flag2 == '1'}">
                                                <td>${revserviceDiscountValue2}</td>
                                                <td class="currency">${revserviceDiscountValueFinal2}</td>
                                            </c:if>

                                        </c:if>

                                        <c:if test="${vendor_code3 != ''}">
                                            <td>${serviceDiscountValue3}%</td>
                                            <td class="currency">${revserviceDiscountValueFinal2}</td>

                                            <c:if test="${rev_submit_flag3 == '1'}">
                                                <td>${revserviceDiscountValue3}%</td>
                                                <td class="currency">${revserviceDiscountValueFinal3}</td>
                                            </c:if>

                                        </c:if>

                                        <c:if test="${vendor_code4 != ''}">
                                            <td>${serviceDiscountValue4}%</td>
                                            <td class="currency">${serviceDiscountValueFinal4}</td>

                                            <c:if test="${rev_submit_flag4 == '1'}">
                                                <td>${revserviceDiscountValue4}</td>
                                                <td class="currency">${revserviceDiscountValueFinal4}</td>
                                            </c:if>

                                        </c:if>
                                    </tr>

                                    <tr>
                                        <th colspan="5">Final Evaluated Price Without GST</th>

                                        <c:if test="${vendor_code1 != ''}">
                                            <td></td>
                                            <td class="currency">${serviceTaxTotal1 - servicegstFinal1}</td>

                                            <c:if test="${rev_submit_flag1 == '1'}">
                                                <td></td>
                                                <td class="currency">${revserviceTaxTotal1 - revservicegstFinal1}</td>
                                            </c:if>

                                        </c:if>

                                        <c:if test="${vendor_code2 != ''}">
                                            <td></td>
                                            <td class="currency">${serviceTaxTotal2 - servicegstFinal2}</td>

                                            <c:if test="${rev_submit_flag2 == '1'}">
                                                <td></td>
                                                <td class="currency">${revserviceTaxTotal2 - revservicegstFinal2}</td>
                                            </c:if>

                                        </c:if>

                                        <c:if test="${vendor_code3 != ''}">
                                            <td></td>
                                            <td class="currency">${serviceTaxTotal3 - servicegstFinal3}</td>


                                            <c:if test="${rev_submit_flag3 == '1'}">
                                                <td></td>
                                                <td class="currency">${revserviceTaxTotal3 - revservicegstFinal3}</td>
                                            </c:if>

                                        </c:if>

                                        <c:if test="${vendor_code4 != ''}">
                                            <td></td>
                                            <td class="currency">${serviceTaxTotal4 - servicegstFinal4}</td>

                                            <c:if test="${rev_submit_flag4 == '1'}">
                                                <td></td>
                                                <td class="currency">${revserviceTaxTotal4 - revservicegstFinal4}</td>
                                            </c:if>
                                        </c:if>
                                    </tr>

                                    <tr>
                                        <th colspan="5">GST</th>

                                        <c:if test="${vendor_code1 != ''}">
                                            <td>${servicegst1}%</td>
                                            <td class="currency">${servicegstFinal1}</td>

                                            <c:if test="${rev_submit_flag1 == '1'}">
                                                <td>${revservicegst1}%</td>
                                                <td class="currency">${revservicegstFinal1}</td>
                                            </c:if>
                                        </c:if>

                                        <c:if test="${vendor_code2 != ''}">
                                            <td>${servicegst2}%</td>
                                            <td class="currency">${servicegstFinal2}</td>

                                            <c:if test="${rev_submit_flag2 == '1'}">
                                                <td>${revservicegst2}%</td>
                                                <td class="currency">${revservicegstFinal2}</td>
                                            </c:if>

                                        </c:if>

                                        <c:if test="${vendor_code3 != ''}">
                                            <td>${servicegst3}%</td>
                                            <td class="currency">${servicegstFinal3}</td>

                                            <c:if test="${rev_submit_flag3 == '1'}">
                                                <td>${revservicegst3}%</td>
                                                <td class="currency">${revservicegstFinal3}</td>
                                            </c:if>
                                        </c:if>

                                        <c:if test="${vendor_code4 != ''}">
                                            <td>${servicegst4}%</td>
                                            <td class="currency">${servicegstFinal4}</td>

                                            <c:if test="${rev_submit_flag4 == '1'}">
                                                <td>${revservicegst4}%</td>
                                                <td class="currency">${revservicegstFinal4}</td>
                                            </c:if>
                                        </c:if>
                                    </tr>

                                    <tr>
                                        <th colspan="5">Final Evaluated Price</th>
                                            <c:if test="${vendor_code1 != ''}">
                                            <td></td>
                                            <td class="currency">${serviceTaxTotal1}</td>

                                            <c:if test="${rev_submit_flag1 == '1'}">
                                                <td></td>
                                                <td class="currency">${revserviceTaxTotal1}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code2 != ''}">
                                            <td></td>
                                            <td class="currency">${serviceTaxTotal2}</td>

                                            <c:if test="${rev_submit_flag2 == '1'}">
                                                <td></td>
                                                <td class="currency">${revserviceTaxTotal2}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code3 != ''}">
                                            <td></td>
                                            <td class="currency">${serviceTaxTotal3}</td>


                                            <c:if test="${rev_submit_flag3 == '1'}">
                                                <td></td>
                                                <td class="currency">${revserviceTaxTotal3}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code4 != ''}">
                                            <td></td>
                                            <td class="currency">${serviceTaxTotal4}</td>

                                            <c:if test="${rev_submit_flag4 == '1'}">
                                                <td></td>
                                                <td class="currency">${revserviceTaxTotal4}</td>
                                            </c:if>

                                        </c:if>
                                    </tr>

                                    <tr>
                                        <th colspan="5">Rating</th>

                                        <c:if test="${vendor_code1 != ''}">
                                            <td></td>
                                            <td>${rank1}</td>

                                            <c:if test="${rev_submit_flag1 == '1'}">
                                                <td></td>
                                                <td>${rank1}</td>
                                            </c:if>
                                        </c:if>

                                        <c:if test="${vendor_code2 != ''}">
                                            <td></td>
                                            <td>${rank2}</td>

                                            <c:if test="${rev_submit_flag2 == '1'}">
                                                <td></td>
                                                <td>${rank2}</td>
                                            </c:if>
                                        </c:if>

                                        <c:if test="${vendor_code3 != ''}">
                                            <td></td>
                                            <td>${rank3}</td>

                                            <c:if test="${rev_submit_flag3 == '1'}">
                                                <td></td>
                                                <td>${rank3}</td>
                                            </c:if>
                                        </c:if>

                                        <c:if test="${vendor_code4 != ''}">
                                            <td></td>
                                            <td>${rank4}</td>

                                            <c:if test="${rev_submit_flag4 == '1'}">
                                                <td></td>
                                                <td>${rank4}</td>
                                            </c:if>                                                
                                        </c:if>
                                    </tr>

                                    <tr>
                                        <th colspan="5">No. Of Item Regreted</th>
                                            <c:if test="${vendor_code1 != ''}">
                                            <td></td>
                                            <td>${regret1}</td>

                                            <c:if test="${rev_submit_flag1 == '1'}">
                                                <td></td>
                                                <td>${regret1}</td>
                                            </c:if>
                                        </c:if>

                                        <c:if test="${vendor_code2 != ''}">
                                            <td></td>
                                            <td>${regret2}</td>

                                            <c:if test="${rev_submit_flag2 == '1'}">
                                                <td></td>
                                                <td>${regret2}</td>
                                            </c:if>
                                        </c:if>

                                        <c:if test="${vendor_code3 != ''}">
                                            <td></td>
                                            <td>${regret3}</td>


                                            <c:if test="${rev_submit_flag3 == '1'}">
                                                <td></td>
                                                <td>${regret3}</td>
                                            </c:if>
                                        </c:if>

                                        <c:if test="${vendor_code4 != ''}">
                                            <td></td>
                                            <td>${regret4}</td>


                                            <c:if test="${rev_submit_flag4 == '1'}">
                                                <td></td>
                                                <td>${regret4}</td>
                                            </c:if>
                                        </c:if>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </c:if>
                        
                    <br>
                    <div class="table-responsive">
                        <table class="flex-table page-break-section" class="table table-bordered" style="" align="Center"  >

                            <thead style="font-size: 12px;">

                                <tr class="table-title">
                                    <th colspan="19" style="text-align: center;">Terms & Condition Comparison</th>
                                </tr>                            

                                <tr>
                                    <th rowspan="2">Sr No.</th>
                                    <th colspan="2">Vendor Name</th>

                                    <c:if test="${vendor_code1 != ''}">
                                        <th colspan="2">${vendor_name1}</th>
                                        <c:if test="${rev_submit_flag1 == '1'}">
                                            <th colspan="2">${vendor_name1}</th>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code2 != ''}">
                                        <th colspan="2">${vendor_name2}</th>
                                        <c:if test="${rev_submit_flag2 == '1'}">
                                            <th colspan="2">${vendor_name2}</th>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code3 != ''}">
                                        <th colspan="2">${vendor_name3}</th>
                                        <c:if test="${rev_submit_flag3 == '1'}">
                                            <th colspan="2">${vendor_name3}</th>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code4 != ''}">
                                        <th colspan="2">${vendor_name4}</th>
                                        <c:if test="${rev_submit_flag4 == '1'}">
                                            <th colspan="2">${vendor_name4}</th>
                                        </c:if>
                                    </c:if>
                                </tr>

                                <tr>

                                    <th>Terms Condition</th>
                                    <th>Description</th>

                                    <c:if test="${vendor_code1 != ''}">
                                        <th>Response</th>
                                        <th>Remark</th>
                                        <c:if test="${rev_submit_flag1 == '1'}">
                                            <th>Rev Response</th>
                                            <th>Rev Remark</th>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code2 != ''}">
                                        <th>Response</th>
                                        <th>Remark</th>
                                        <c:if test="${rev_submit_flag2 == '1'}">
                                            <th>Rev Response</th>
                                            <th>Rev Remark</th>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code3 != ''}">
                                        <th>Response</th>
                                        <th>Remark</th>
                                        <c:if test="${rev_submit_flag3 == '1'}">
                                            <th>Rev Response</th>
                                            <th>Rev Remark</th>
                                        </c:if>
                                    </c:if>

                                    <c:if test="${vendor_code4 != ''}">
                                        <th>Response</th>
                                        <th>Remark</th>
                                        <c:if test="${rev_submit_flag4 == '1'}">
                                            <th>Rev Response</th>
                                            <th>Rev Remark</th>
                                        </c:if>
                                    </c:if>

                                </tr>

                            </thead>

                            <tbody style="font-size: 10px;">

                                <c:forEach var="vendorTermsCondition1" items="${vendorTermsCondition1}" varStatus="status">

                                    <tr>
                                        <td>${status.count}</td>
                                        <td>${vendorTermsCondition1.termsCondition}</td>
                                        <td style="min-width: 180px; font-size: 8px;">${vendorTermsCondition1.description}</td>

                                        <c:if test="${vendor_code1 != ''}">
                                            <c:forEach var="vendorTermsConditionPriceBid1" items="${vendorTermsConditionPriceBid1}">
                                                <c:if test="${vendorTermsCondition1.termsCondition == vendorTermsConditionPriceBid1.termsCondition && vendorTermsCondition1.description == vendorTermsConditionPriceBid1.description}">
                                                    <td>${vendorTermsConditionPriceBid1.response == 0 ? 'Accept' : vendorTermsConditionPriceBid1.response == 1 ? 'Reject' : 'NA'}</td>
                                                    <td>${vendorTermsConditionPriceBid1.comment}</td>
                                                </c:if>
                                            </c:forEach>
                                            <c:if test="${rev_submit_flag1 == '1'}">
                                                <td>${vendorTermsCondition1.response == 0 ? 'Accept' : vendorTermsCondition1.response == 1 ? 'Reject' : 'NA'}</td>                                                
                                                <td>${vendorTermsCondition1.comment}</td>
                                            </c:if>
                                        </c:if>

                                        <c:if test="${vendor_code2 != ''}">
                                            <c:forEach var="vendorTermsConditionPriceBid2" items="${vendorTermsConditionPriceBid2}" varStatus="status1">
                                                <c:if test="${vendorTermsCondition1.termsCondition == vendorTermsConditionPriceBid2.termsCondition && vendorTermsCondition1.description == vendorTermsConditionPriceBid2.description}">
                                                    <td>${vendorTermsConditionPriceBid2.response == 0 ? 'Accept' : vendorTermsConditionPriceBid2.response == 1 ? 'Reject' : 'NA'}</td>                                                                                                    
                                                    <td>${vendorTermsConditionPriceBid2.comment}</td>
                                                </c:if>
                                            </c:forEach>
                                                    
                                            <c:if test="${rev_submit_flag2 == '1'}">
                                                <c:forEach var="vendorTermsCondition2" items="${vendorTermsCondition2}" varStatus="status1">
                                                    <c:if test="${vendorTermsCondition1.termsCondition == vendorTermsCondition2.termsCondition}">
                                                        <td>${vendorTermsCondition2.response == 0 ? 'Accept' : vendorTermsCondition2.response == 1 ? 'Reject' : 'NA'}</td>                                                                                                    
                                                        <td>${vendorTermsCondition2.comment}</td>
                                                    </c:if>
                                                </c:forEach>
                                            </c:if>
                                        </c:if>

                                        <c:if test="${vendor_code3 != ''}">
                                            <c:forEach var="vendorTermsConditionPriceBid3" items="${vendorTermsConditionPriceBid3}" varStatus="status1">
                                                <c:if test="${vendorTermsCondition1.termsCondition == vendorTermsConditionPriceBid3.termsCondition && vendorTermsCondition1.description == vendorTermsConditionPriceBid3.description}">
                                                    <td>${vendorTermsConditionPriceBid3.response == 0 ? 'Accept' : vendorTermsConditionPriceBid3.response == 1 ? 'Reject' : 'NA'}</td>                                                                                                    
                                                    <td>${vendorTermsConditionPriceBid3.comment}</td>
                                                </c:if>
                                            </c:forEach>

                                            <c:if test="${rev_submit_flag3 == '1'}">
                                                <c:forEach var="vendorTermsCondition3" items="${vendorTermsCondition3}" varStatus="status1">
                                                    <c:if test="${vendorTermsCondition1.termsCondition == vendorTermsCondition3.termsCondition}">
                                                        <td>${vendorTermsCondition3.response == 0 ? 'Accept' : vendorTermsCondition3.response == 1 ? 'Reject' : 'NA'}</td>                                                                                                    
                                                        <td>${vendorTermsCondition3.comment}</td>
                                                    </c:if>
                                                </c:forEach>
                                            </c:if>
                                        </c:if>

                                        <c:if test="${vendor_code4 != ''}">
                                            <c:forEach var="vendorTermsConditionPriceBid4" items="${vendorTermsConditionPriceBid4}" varStatus="status1">
                                                <c:if test="${vendorTermsCondition1.termsCondition == vendorTermsConditionPriceBid4.termsCondition && vendorTermsCondition1.description == vendorTermsConditionPriceBid4.description}">
                                                    <td>${vendorTermsConditionPriceBid4.response == 0 ? 'Accept' : vendorTermsConditionPriceBid4.response == 1 ? 'Reject' : 'NA'}</td>                                                    
                                                    <td>${vendorTermsConditionPriceBid4.comment}</td>
                                                </c:if>
                                            </c:forEach>

                                            <c:if test="${rev_submit_flag4 == '1'}">
                                                <c:forEach var="vendorTermsCondition4" items="${vendorTermsCondition4}" varStatus="status1">
                                                    <c:if test="${vendorTermsCondition1.termsCondition == vendorTermsCondition4.termsCondition}">
                                                        <td>${vendorTermsCondition4.response == 0 ? 'Accept' : vendorTermsCondition4.response == 1 ? 'Reject' : 'NA'}</td>
                                                        <td>${vendorTermsCondition4.comment}</td>
                                                    </c:if>
                                                </c:forEach>
                                            </c:if>
                                        </c:if>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <br>
                    <div class="table-responsive">
                        <table  class="flex-table page-break-section" class="table table-bordered" style="" align="Center"  >

                            <thead style="font-size: 12px;">

                                <tr class="table-title">
                                    <th colspan="10" style="text-align: center;">Commercial Summary Comparison</th>
                                </tr>

                                <tr>
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

                                <tr>
                                    <th>${vendor_code1}</th>
                                    <th>${vendor_name1}</th>
                                    <td class="currency">${Total1 - igstValueFinal1}</td>
                                    <td class="currency">${serviceTaxTotal1 - servicegstFinal1}</td>
                                    <td class="currency">${(serviceTaxTotal1 - servicegstFinal1) + (Total1 - igstValueFinal1)}</td>
                                    <td class="currency">${servicegstFinal1 + igstValueFinal1}</td>
                                    <td class="currency">${Total1 + serviceTaxTotal1}</td>
                                    <td class="currency">${tenderMaster.value}</td>
                                    <td class="currency">${tenderMaster.value - Total1 - serviceTaxTotal1}</td>
                                    <td><fmt:formatNumber value="${((tenderMaster.value - (Total1 + serviceTaxTotal1)) * 100) / tenderMaster.value}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2"/>%</td>
                                </tr>

                                <c:if test="${rev_submit_flag1 == '1'}">

                                    <tr>

                                        <th>${vendor_code1} Revise</th>
                                        <th>${vendor_name1}</th>
                                        <td class="currency">${revTotal1 - revigstValueFinal1}</td>
                                        <td class="currency">${revserviceTaxTotal1 - revservicegstFinal1}</td>
                                        <td class="currency">${(revserviceTaxTotal1 - revservicegstFinal1) + (revTotal1 - revigstValueFinal1)}</td>
                                        <td class="currency">${revservicegstFinal1 + revigstValueFinal1}</td>
                                        <td class="currency">${revTotal1 + revserviceTaxTotal1}</td>
                                        <td class="currency">${tenderMaster.value}</td>
                                        <td class="currency">${tenderMaster.value - revTotal1 - revserviceTaxTotal1}</td>
                                        <td><fmt:formatNumber value="${((tenderMaster.value - (revTotal1 + revserviceTaxTotal1)) * 100) / tenderMaster.value}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2"/>%</td>
                                    </tr>
                                </c:if>

                                <c:if test="${vendor_code2 != ''}">

                                    <tr>
                                        <th>${vendor_code2}</th>
                                        <th>${vendor_name2}</th>
                                        <td class="currency">${Total2 - igstValueFinal2}</td>
                                        <td class="currency">${serviceTaxTotal2 - servicegstFinal2}</td>
                                        <td class="currency">${(serviceTaxTotal2 - servicegstFinal2) + (Total2 - igstValueFinal2)}</td>
                                        <td class="currency">${servicegstFinal2 + igstValueFinal2}</td>
                                        <td class="currency">${Total2 + serviceTaxTotal2}</td>
                                        <td class="currency">${tenderMaster.value}</td>
                                        <td class="currency">${tenderMaster.value - Total2 - serviceTaxTotal2}</td>
                                        <td><fmt:formatNumber value="${((tenderMaster.value - (Total2 + serviceTaxTotal2)) * 100) / tenderMaster.value}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2"/>%</td>
                                    </tr>

                                    <c:if test="${rev_submit_flag2 == '1'}">

                                        <tr>
                                            <th>${vendor_code2} Revise</th>
                                            <th>${vendor_name2}</th>
                                            <td class="currency">${revTotal2 - revigstValueFinal2}</td>
                                            <td class="currency">${revserviceTaxTotal2 - revservicegstFinal2}</td>
                                            <td class="currency">${(revserviceTaxTotal2 - revservicegstFinal2) + (revTotal2 - revigstValueFinal2)}</td>
                                            <td class="currency">${revservicegstFinal2 + revigstValueFinal2}</td>
                                            <td class="currency">${revTotal2 + revserviceTaxTotal2}</td>
                                            <td class="currency">${tenderMaster.value}</td>
                                            <td class="currency">${tenderMaster.value - revTotal2 - revserviceTaxTotal2}</td>
                                            <td><fmt:formatNumber value="${((tenderMaster.value - (revTotal2 + revserviceTaxTotal2)) * 100) / tenderMaster.value}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2"/>%</td>
                                        </tr>
                                    </c:if>
                                </c:if>

                                <c:if test="${vendor_code3 != ''}">

                                    <tr>
                                        <th>${vendor_code3}</th>
                                        <th>${vendor_name3}</th>
                                        <td class="currency">${Total3 - igstValueFinal3}</td>
                                        <td class="currency">${serviceTaxTotal3 - servicegstFinal3}</td>
                                        <td class="currency">${(serviceTaxTotal3 - servicegstFinal3) + (Total3 - igstValueFinal3)}</td>
                                        <td class="currency">${servicegstFinal3 + igstValueFinal3}</td>
                                        <td class="currency">${Total3 + serviceTaxTotal3}</td>
                                        <td class="currency">${tenderMaster.value}</td>
                                        <td class="currency">${tenderMaster.value - Total3 - serviceTaxTotal3}</td>
                                        <td><fmt:formatNumber value="${((tenderMaster.value - (Total3 + serviceTaxTotal3)) * 100) / tenderMaster.value}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2"/>%</td>
                                    </tr>

                                    <c:if test="${rev_submit_flag3 == '1'}">

                                        <tr>
                                            <th>${vendor_code3} Revise</th>
                                            <th>${vendor_name3}</th>
                                            <td class="currency">${revTotal3 - revigstValueFinal3}</td>
                                            <td class="currency">${revserviceTaxTotal3 - revservicegstFinal3}</td>
                                            <td class="currency">${(revserviceTaxTotal3 - revservicegstFinal3) + (revTotal3 - revigstValueFinal3)}</td>
                                            <td class="currency">${revservicegstFinal3 + revigstValueFinal3}</td>
                                            <td class="currency">${revTotal3 + revserviceTaxTotal3}</td>
                                            <td class="currency">${tenderMaster.value}</td>
                                            <td class="currency">${tenderMaster.value - revTotal3 - revserviceTaxTotal3}</td>
                                            <td><fmt:formatNumber value="${((tenderMaster.value - (revTotal3 + revserviceTaxTotal3)) * 100) / tenderMaster.value}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2"/>%</td>
                                        </tr>
                                    </c:if>
                                </c:if>

                                <c:if test="${vendor_code4 != ''}">

                                    <tr>
                                        <th>${vendor_code4}</th>
                                        <th>${vendor_name4}</th>
                                        <td class="currency">${Total4 - igstValueFinal4}</td>
                                        <td class="currency">${serviceTaxTotal4 - servicegstFinal4}</td>
                                        <td class="currency">${(serviceTaxTotal4 - servicegstFinal4) + (Total4 - igstValueFinal4)}</td>
                                        <td class="currency">${servicegstFinal4 + igstValueFinal4}</td>
                                        <td class="currency">${Total4 + serviceTaxTotal4}</td>
                                        <td class="currency">${tenderMaster.value}</td>
                                        <td class="currency">${tenderMaster.value - Total4 - serviceTaxTotal4}</td>
                                        <td><fmt:formatNumber value="${((tenderMaster.value - (Total4 + serviceTaxTotal4)) * 100) / tenderMaster.value}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2"/>%</td>
                                    </tr>
                                    
                                    <c:if test="${rev_submit_flag4 == '1'}">
                                        <tr>
                                            <th>${vendor_code4} Revise</th>
                                            <th>${vendor_name4}</th>
                                            <td class="currency">${revTotal4 - revigstValueFinal4}</td>
                                            <td class="currency">${revserviceTaxTotal4 - revservicegstFinal4}</td>
                                            <td class="currency">${(revserviceTaxTotal4 - revservicegstFinal4) + (revTotal4 - revigstValueFinal4)}</td>
                                            <td class="currency">${revservicegstFinal4 + revigstValueFinal4}</td>
                                            <td class="currency">${revTotal4 + revserviceTaxTotal4}</td>
                                            <td class="currency">${tenderMaster.value}</td>
                                            <td class="currency">${tenderMaster.value - revTotal4 - revserviceTaxTotal4}</td>
                                            <td><fmt:formatNumber value="${((tenderMaster.value - (revTotal4 + revserviceTaxTotal4)) * 100) / tenderMaster.value}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2"/>%</td>
                                        </tr>
                                    </c:if>
                                </c:if>
                            </tbody>
                        </table>
                    </div>

                </form:form>
            </section>
        </main>
        <script>
          CurrencyHandler.init({ currency: '${prMaster.currency}' });
        </script>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUiComparisonFooterPrint.jsp"%>
   
</html>


