
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TENDER PRICE COMPARISON</title>
    </head>
   <style>
        .buyer-info .form-group p {
            white-space: normal;
            overflow-wrap: anywhere;
        }
    </style>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action=".htm?act=" commandName="departmentMaster" method="post">

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">TENDER PRICE COMPARISON</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                            <a class=" btn theme-btn  mr-3" href="tenderMaster.htm?act=priceBidComparisonExport&refNo=${refNo}">Export To Excel</a>
                            <a class="btn theme-btn" href="tenderMaster.htm?act=priceBidComparisonViewPrint&refNo=${refNo}" class="btn btn-primary" onclick="printCustom()" title="Print this page">
                                <i class="fa fa-arrow-right"></i>&nbsp;&nbsp;Print
                            </a>                        
                        </div>
                    </div>

                    <br>
                    <input type="hidden" name="refNo" value="${refNo}">
                    <input type="hidden" name="omsMasterId" value="${omsMaster.id}" />
         

                        <h5 class="fw-600">Tender information</h5> 
                        <hr>
                        <div class="rounded-4 mt-4"> 
                        <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                            <div class="row buyer-info">
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Tender No</label>
                                        <p class="fw-600">${tenderMaster.refNo}</p>

                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Project Name</label>
                                        <p class="fw-600">${tenderMaster.title}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Project ID</label>
                                        <p class="fw-600">${tenderMaster.projectId}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Vendor Code</label>
                                        <p class="fw-600">${vendorCode}- ${vendorName}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Department</label>
                                        <p class="fw-600">${tenderMaster.department}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Tender Date Time</label>
                                        <p class="fw-600">${tenderMaster.announceDate}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Due Date Time</label>
                                        <p class="fw-600">${tenderMaster.submitLastdate}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>PR No</label>
                                        <p class="fw-600">${tenderMaster.prNo}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Mode Of Transport</label>
                                        <p class="fw-600">${tenderMaster.modeOfTransport}</p>
                                    </div>
                                </div>


                            </div>
                        </div>  
                    </div>
    
                    <c:if test="${!empty vendorTenderBidItem1}">
                        <h5 class="fw-600">Price Bid Comparison For Item</h5>
                        <hr>

                        <table id="commonNoPageTable" class="table table-striped bg-white" style="min-width: 100%" align="Center" >

                            <thead>
                                <tr data-dt-order="disable">
                                    <th rowspan="3" style="min-width: 80px;">Sr No.</th>
                                    <th colspan="4">Vendor Code</th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <th colspan="2">${vendor_code1}</th>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <th colspan="2">${vendor_code2}</th>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <th colspan="2">${vendor_code3}</th>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <th colspan="2">${vendor_code4}</th>
                                    </c:if>                                    
                                </tr>
                                <tr data-dt-order="disable">
                                    <th colspan="4">Vendor Name</th>
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
                                
                                <tr data-dt-order="disable">
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

                            <tbody>

                                <c:forEach var="item1" items="${vendorTenderBidItem1}" varStatus="status">
                                    <tr>
                                        <td class="text-center">${status.count}</td>
                                        <td>${item1[1]}</td>
                                        <td>${item1[2]}</td>
                                        <td>${item1[4]}</td>
                                        <td>${item1[3]}</td>

                                        <c:if test="${vendor_code1 != ''}">
                                            <td>₹ ${item1[5]}</td>
                                            <td class="format-2dec">₹ ${item1[6]}</td>
                                        </c:if>

                                        <c:if test="${vendor_code2 != ''}">
                                            <c:set var="found2" value="false" />

                                            <c:forEach var="item2" items="${vendorTenderBidItem2}">
                                                <c:if test="${item1[0] == item2[0]}">
                                                    <td>₹ ${item2[5]}</td>
                                                    <td class="format-2dec">₹ ${item2[6]}</td>
                                                    <c:set var="found2" value="true" />
                                                </c:if>
                                            </c:forEach>

                                            <c:if test="${!found2}">
                                                <td>-</td>
                                                <td>-</td>
                                            </c:if>
                                        </c:if>

                                        <c:if test="${vendor_code3 != ''}">
                                            <c:set var="found3" value="false" />

                                            <c:forEach var="item3" items="${vendorTenderBidItem3}">
                                                <c:if test="${item1[0] == item3[0]}">
                                                    <td>₹ ${item3[5]}</td>
                                                    <td class="format-2dec">₹ ${item3[6]}</td>
                                                    <c:set var="found3" value="true" />
                                                </c:if>
                                            </c:forEach>

                                            <c:if test="${!found3}">
                                                <td>-</td>
                                                <td>-</td>
                                            </c:if>                                            
                                        </c:if>

                                        <c:if test="${vendor_code4 != ''}">
                                            <c:set var="found4" value="false" />

                                            <c:forEach var="item4" items="${vendorTenderBidItem4}">
                                                <c:if test="${item1[0] == item4[0]}">
                                                    <td>₹ ${item4[5]}</td>
                                                    <td class="format-2dec">₹ ${item4[6]}</td>
                                                    <c:set var="found4" value="true" />
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
                            <tfoot>
                                
                                <tr>
                                    <th colspan="5"><b>Ex-work Price/FOB</b></th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <td></td>
                                        <td>₹ <fmt:formatNumber value="${total_value1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td></td>
                                        <td>₹ <fmt:formatNumber value="${total_value2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td></td>
                                        <td>₹ <fmt:formatNumber value="${total_value3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td></td>
                                        <td>₹ <fmt:formatNumber value="${total_value4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>    
                                </tr>
                                
                                <tr>
                                    <th colspan="5"><b>Packing & Forwarding</b></th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <td>${packingValue1}%</td>
                                        <td>₹ <fmt:formatNumber value="${packingValueFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td>${packingValue2}%</td>
                                        <td>₹ <fmt:formatNumber value="${packingValueFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td>${packingValue3}%</td>
                                        <td>₹ <fmt:formatNumber value="${packingValueFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td>${packingValue4}%</td>
                                        <td>₹ <fmt:formatNumber value="${packingValueFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>    
                                </tr>
                                
                                <tr>
                                    <th  colspan="5"><b>Charges</b></th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <td>${chargesValue1}%</td>
                                        <td>₹ <fmt:formatNumber value="${chargesValueFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td>${chargesValue2}%</td>
                                        <td>₹ <fmt:formatNumber value="${chargesValueFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td>${chargesValue3}%</td>
                                        <td>₹ <fmt:formatNumber value="${chargesValueFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td>${chargesValue4}%</td>
                                        <td>₹ <fmt:formatNumber value="${chargesValueFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                </tr>

                                <tr>
                                    <th colspan="5"><b>Insurance</b></th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <td>${insuranceValue1}%</td>
                                        <td>₹ <fmt:formatNumber value="${insuranceValueFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td>${insuranceValue2}%</td>
                                        <td>₹ <fmt:formatNumber value="${insuranceValueFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td>${insuranceValue3}%</td>
                                        <td>₹ <fmt:formatNumber value="${insuranceValueFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td>${insuranceValue4}%</td>
                                        <td>₹ <fmt:formatNumber value="${insuranceValueFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                </tr>

                                <tr>
                                    <th  colspan="5"><b>Erection Commision</b></th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <td>${errectionValue1}%</td>
                                        <td>₹ <fmt:formatNumber value="${errectionValueFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td>${errectionValue2}%</td>
                                        <td>₹ <fmt:formatNumber value="${errectionValueFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td>${errectionValue3}%</td>
                                        <td>₹ <fmt:formatNumber value="${errectionValueFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td>${errectionValue4}%</td>
                                        <td>₹ <fmt:formatNumber value="${errectionValueFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                </tr>

                                <tr>
                                    <th colspan="5"><b>Discount</b></th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <td>${discountValue1}%</td>
                                        <td>₹ <fmt:formatNumber value="${discountValueFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td>${discountValue2}%</td>
                                        <td>₹ <fmt:formatNumber value="${discountValueFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td>${discountValue3}%</td>
                                        <td>₹ <fmt:formatNumber value="${discountValueFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td>${discountValue4}%</td>
                                        <td>₹ <fmt:formatNumber value="${discountValueFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                </tr>

                                <tr>
                                    <th colspan="5"><b>Final Evaluated Price without GST</b></th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <td></td>
                                        <td>₹ ${String.format("%.2f",Total1 - igstValueFinal1)}</td>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td></td>
                                        <td>₹ ${String.format("%.2f",Total2 - igstValueFinal2)}</td>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td></td>
                                        <td>₹ ${String.format("%.2f",Total3 - igstValueFinal3)}</td>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td></td>
                                        <td>₹ ${String.format("%.2f",Total4 - igstValueFinal4)}</td>
                                    </c:if>
                                </tr>

                                <tr>
                                    <th colspan="5"><b>GST</b></th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <td>${igstValue1}%</td>
                                        <td>₹ ${String.format("%.2f",igstValueFinal1)}</td>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td>${igstValue2}%</td>
                                        <td>₹ ${String.format("%.2f",igstValueFinal2)}</td>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td>${igstValue3}%</td>
                                        <td>₹ ${String.format("%.2f",igstValueFinal3)}</td>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td>${igstValue4}%</td>
                                        <td>₹ ${String.format("%.2f",igstValueFinal4)}</td>
                                    </c:if>
                                </tr>

                                <tr>
                                    <th colspan="5"><b>Final Evaluated Price</b></th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <td></td>
                                        <td>₹ ${String.format("%.2f",Total1)}</td>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td></td>
                                        <td>₹ ${String.format("%.2f",Total2)}</td>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td></td>
                                        <td>₹ ${String.format("%.2f",Total3)}</td>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td></td>
                                        <td>₹ ${String.format("%.2f",Total4)}</td>
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

                            </tfoot>
                        </table>
                    </c:if>
                        

                    <c:if test = "${tenderMaster.type == 'Contract' || tenderMaster.type == 'Contract Civil' || tenderMaster.type == 'Contract Electrical'}">
                        <br>
                        <h5 class="fw-600">Price Bid Comparison For Service</h5>
                        <hr>
                        <table id="commonNoPageTable1" class="table table-striped bg-white" style="min-width: 100%" align="Center" >

                           <thead>
                               <tr data-dt-order="disable">
                                    <th rowspan="3">Sr No.</th>
                                    <th colspan="4">Item Details</th>

                                    <c:if test="${vendor_code1 != ''}">
                                       <th colspan="2">${vendor_code1}</th>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                       <th colspan="2">${vendor_code2}</th>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                       <th colspan="2">${vendor_code3}</th>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                       <th colspan="2">${vendor_code4}</th>
                                    </c:if>
                               </tr>

                                <tr data-dt-order="disable">
                                    <th colspan="4">Vendor Name</th>

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

                                <tr data-dt-order="disable">
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

                           <tbody>
                               <c:forEach var="item1" items="${ServicevendorTenderBidItem1}" varStatus="status1">
                                   <tr>
                                       <td>${status1.count}</td>
                                       <td>${item1[1]}</td>
                                       <td>${item1[2]}</td>
                                       <td>${item1[4]}</td>
                                       <td>${item1[3]}</td>

                                       <c:if test="${vendor_code1 != ''}">
                                           <td>₹ ${item1[5]}</td>
                                           <td class="format-2dec">₹ ${item1[6]}</td>
                                       </c:if>

                                       <c:if test="${vendor_code2 != ''}">
                                           <c:set var="found2" value="false"/>
                                           <c:forEach var="item2" items="${ServicevendorTenderBidItem2}">
                                               <c:if test="${item1[0] == item2[0]}">
                                                   <td>₹ ${item2[5]}</td>
                                                   <td class="format-2dec">₹ ${item2[6]}</td>
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
                                                   <td>₹ ${item3[5]}</td>
                                                   <td class="format-2dec">₹ ${item3[6]}</td>
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
                                                   <td>₹ ${item4[5]}</td>
                                                   <td class="format-2dec">₹ ${item4[6]}</td>
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

                            <tfoot>
                                <tr>
                                    <th colspan="5"><b>Ex-work Price/FOB</b></th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <td></td>
                                        <td>₹ <fmt:formatNumber value="${serviceTotalFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" />
                                        </td>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td></td>
                                        <td>₹ <fmt:formatNumber value="${serviceTotalFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td></td>
                                        <td>₹ <fmt:formatNumber value="${serviceTotalFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td></td>
                                        <td>₹ <fmt:formatNumber value="${serviceTotalFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>    
                                </tr>


                                <tr>
                                    <th colspan="5"><b>Discount</b></th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <td>${serviceDiscountValue1}%</td>
                                        <td>₹ <fmt:formatNumber value="${serviceDiscountValueFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td>${serviceDiscountValue2}%</td>
                                        <td>₹ <fmt:formatNumber value="${serviceDiscountValueFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td>${serviceDiscountValue3}%</td>
                                        <td>₹ <fmt:formatNumber value="${serviceDiscountValueFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td>${serviceDiscountValue4}%</td>
                                        <td>₹ <fmt:formatNumber value="${serviceDiscountValueFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>    
                                </tr>

                                <tr>
                                    <th colspan="5"><b>Final Evaluated Price Without GST</b></th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <td></td>
                                        <td>₹ ${String.format("%.2f",serviceTaxTotal1 - servicegstFinal1)}</td>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td></td>
                                        <td>₹ ${String.format("%.2f",serviceTaxTotal2 - servicegstFinal2)}</td>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td></td>
                                        <td>₹ ${String.format("%.2f",serviceTaxTotal3 - servicegstFinal3)}</td>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td></td>
                                        <td>₹ ${String.format("%.2f",serviceTaxTotal4 - servicegstFinal4)}</td>
                                    </c:if>    
                                </tr>

                                <tr>
                                    <th  colspan="5"><b>GST</b></th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <td>${servicegst1}%</td>
                                        <td>₹ <fmt:formatNumber value="${servicegstFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td>${servicegst2}%</td>
                                        <td>₹ <fmt:formatNumber value="${servicegstFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td>${servicegst3}%</td>
                                        <td>₹ <fmt:formatNumber value="${servicegstFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td>${servicegst4}%</td>
                                        <td>₹ <fmt:formatNumber value="${servicegstFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                </tr>

                                <tr>
                                    <th colspan="5"><b>Final Evaluated Price</b></th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <td></td>
                                        <td>₹ <fmt:formatNumber value="${serviceTaxTotal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td></td>
                                        <td>₹ <fmt:formatNumber value="${serviceTaxTotal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td></td>
                                        <td>₹ <fmt:formatNumber value="${serviceTaxTotal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td></td>
                                        <td>₹ <fmt:formatNumber value="${serviceTaxTotal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
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
                                    <th colspan="5"><b>No Of Item Regret</b></th>
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
                            </tfoot>

                       </table>
                    </c:if>

                    <c:if test="${!empty vendorTermsCondition1}">
                        <br>
                        <h5 class="fw-600">Terms & Condition Comparison</h5>
                        <hr>
                        <table id="commonNoPageTable2" class="table table-striped bg-white" style="min-width: 100%" align="Center" >

                            <thead>
                                <tr data-dt-order="disable">
                                    <th rowspan="3">Sr No.</th>
                                    <th rowspan="3">Terms Condition</th>
                                    <th rowspan="3">Description</th>

                                    <c:if test="${vendor_code1 != ''}">
                                        <th colspan="2">${vendor_code1}</th>
                                        </c:if>
                                        <c:if test="${vendor_code2 != ''}">
                                        <th colspan="2">${vendor_code2}</th>
                                        </c:if>
                                        <c:if test="${vendor_code3 != ''}">
                                        <th colspan="2">${vendor_code3}</th>
                                        </c:if>
                                        <c:if test="${vendor_code4 != ''}">
                                        <th colspan="2">${vendor_code4}</th>
                                        </c:if>
                                </tr>

                                <tr data-dt-order="disable">
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

                                <tr data-dt-order="disable">
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

                            <tbody>
                                <c:forEach var="vendorTermsCondition1" items="${vendorTermsCondition1}" varStatus="status2">
                                    <tr>
                                        <td>${status2.count}</td>
                                        <td>${vendorTermsCondition1.termsCondition}</td>
                                        <td>${vendorTermsCondition1.description}</td>

                                        <c:if test="${vendor_code1 != ''}">
                                            <td>
                                                <c:choose>
                                                    <c:when test="${vendorTermsCondition1.response == 0}">Accept</c:when>
                                                    <c:otherwise>Reject</c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>${vendorTermsCondition1.comment}</td>
                                        </c:if>

                                        <c:if test="${vendor_code2 != ''}">
                                            <c:set var="found2" value="false"/>
                                            <c:forEach var="vendorTermsCondition2" items="${vendorTermsCondition2}">
                                                <c:if test="${vendorTermsCondition1.termsCondition == vendorTermsCondition2.termsCondition}">
                                                    <td>
                                                        <c:choose>
                                                            <c:when test="${vendorTermsCondition2.response == 0}">Accept</c:when>
                                                            <c:otherwise>Reject</c:otherwise>
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
                                            <c:forEach var="vendorTermsCondition3" items="${vendorTermsCondition3}">
                                                <c:if test="${vendorTermsCondition1.termsCondition == vendorTermsCondition3.termsCondition}">
                                                    <td>
                                                        <c:choose>
                                                            <c:when test="${vendorTermsCondition3.response == 0}">Accept</c:when>
                                                            <c:otherwise>Reject</c:otherwise>
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
                                            <c:forEach var="vendorTermsCondition4" items="${vendorTermsCondition4}">
                                                <c:if test="${vendorTermsCondition1.termsCondition == vendorTermsCondition4.termsCondition}">
                                                    <td>
                                                        <c:choose>
                                                            <c:when test="${vendorTermsCondition4.response == 0}">Accept</c:when>
                                                            <c:otherwise>Reject</c:otherwise>
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
                    </c:if>
                        
                    <br>
                    <h5 class="fw-600">Vendor Comparison</h5>
                    <hr>
                    <table id="commonNoPageTable3" class="table table-striped bg-white" style="width: 100%" align="Center">
                        <thead>
                            <tr data-dt-order="disable">
                                <th>Sr No.</th>
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

                        <tbody>

                            <c:set var="sn" value="0" />

                            <c:set var="sn" value="${sn + 1}" />
                            <tr>
                                <td>${sn}</td>
                                <td>${vendor_code1}</td>
                                <td>${vendor_name1}</td>
                                <td>${String.format("%.2f",Total1 - igstValueFinal1)}</td>
                                <td>${String.format("%.2f",serviceTaxTotal1 - servicegstFinal1)}</td>
                                <td>${String.format("%.2f",serviceTaxTotal1 - servicegstFinal1 + Total1 - igstValueFinal1)}</td>
                                <td>${String.format("%.2f",servicegstFinal1 + igstValueFinal1)}</td>
                                <td>${String.format("%.2f",Total1 + serviceTaxTotal1)}</td>
                                <td>${tenderMaster.value}</td>
                                <td>${String.format("%.2f",tenderMaster.value - Total1 - serviceTaxTotal1)}</td>
                                <td>${String.format("%.2f",((tenderMaster.value - (Total1 + serviceTaxTotal1)) * 100) / tenderMaster.value)}%</td> 
                            </tr>

                            <c:if test="${vendor_code2 != ''}">
                                <c:set var="sn" value="${sn + 1}" />
                                <tr>
                                    <td>${sn}</td>
                                    <td>${vendor_code2}</td>
                                    <td>${vendor_name2}</td>
                                    <td>${String.format("%.2f",Total2 - igstValueFinal2)}</td>
                                    <td>${String.format("%.2f",serviceTaxTotal2 - servicegstFinal2)}</td>
                                    <td>${String.format("%.2f",serviceTaxTotal2 - servicegstFinal2 + Total2 - igstValueFinal2)}</td>
                                    <td>${String.format("%.2f",servicegstFinal2 + igstValueFinal2)}</td>
                                    <td>${String.format("%.2f",Total2 + serviceTaxTotal2)}</td>
                                    <td>${tenderMaster.value}</td>
                                    <td>${String.format("%.2f",tenderMaster.value - Total2 - serviceTaxTotal2)}</td>
                                    <td>${String.format("%.2f",((tenderMaster.value - (Total2 + serviceTaxTotal2)) * 100) / tenderMaster.value)}%</td> 
                                </tr>
                            </c:if>

                            <c:if test="${vendor_code3 != ''}">
                                <c:set var="sn" value="${sn + 1}" />
                                <tr>
                                    <td>${sn}</td>
                                    <td>${vendor_code3}</td>
                                    <td>${vendor_name3}</td>
                                    <td>${String.format("%.2f",Total3 - igstValueFinal3)}</td>
                                    <td>${String.format("%.2f",serviceTaxTotal3 - servicegstFinal3)}</td>
                                    <td>${String.format("%.2f",serviceTaxTotal3 - servicegstFinal3 + Total3 - igstValueFinal3)}</td>
                                    <td>${String.format("%.2f",servicegstFinal3 + igstValueFinal3)}</td>
                                    <td>${String.format("%.2f",Total3 + serviceTaxTotal3)}</td>
                                    <td>${tenderMaster.value}</td>
                                    <td>${String.format("%.2f",tenderMaster.value - Total3 - serviceTaxTotal3)}</td>
                                    <td>${String.format("%.2f",((tenderMaster.value - (Total3 + serviceTaxTotal3)) * 100) / tenderMaster.value)}%</td> 
                                </tr>
                            </c:if>

                            <c:if test="${vendor_code4 != ''}">
                                <c:set var="sn" value="${sn + 1}" />
                                <tr>
                                    <td>${sn}</td>
                                    <td>${vendor_code4}</td>
                                    <td>${vendor_name4}</td>
                                    <td>${String.format("%.2f",Total4 - igstValueFinal4)}</td>
                                    <td>${String.format("%.2f",serviceTaxTotal4 - servicegstFinal4)}</td>
                                    <td>${String.format("%.2f",serviceTaxTotal4 - servicegstFinal4 + Total4 - igstValueFinal4)}</td>
                                    <td>${String.format("%.2f",servicegstFinal4 + igstValueFinal4)}</td>
                                    <td>${String.format("%.2f",Total4 + serviceTaxTotal4)}</td>
                                    <td>${tenderMaster.value}</td>
                                    <td>${String.format("%.2f",tenderMaster.value - Total4 - serviceTaxTotal4)}</td>
                                    <td>${String.format("%.2f",((tenderMaster.value - (Total4 + serviceTaxTotal4)) * 100) / tenderMaster.value)}%</td> 
                                </tr>
                            </c:if>

                        </tbody>
                    </table>
                  
                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
