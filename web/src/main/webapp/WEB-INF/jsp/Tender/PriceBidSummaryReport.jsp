
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendor Summary</title>
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

                            <h5 class="fw-600 mb-0">Vendor Summary</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                            <a href="tenderMaster.htm?act=priceBidSummaryReportPrint&refNo=${tenderMaster.refNo}&vendorCode=${vendorCode}" class="btn theme-btn">
                                Print
                            </a>
                        </div>
                    </div>

                    <hr>

                     <h5 class="fw-600">Tender information</h5>   
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
                    <h5 class="fw-600">Item Details</h5>

                    <table id="commonNoPageTable" class="table  table-striped bg-white" style="width: 100%" align="Center"  >
                        <thead>
                            <tr>
                                <th>Sr No.</th>
                                <th style="min-width: 180px;">Item Code</th>
                                <th style="min-width: 530px;">Item Description</th>
                                <th style="min-width: 180px;">Item Details</th>
                                <th>UOM</th>
                                <th>Quantity</th>
                                <th>Unit Rate</th>
                                <th>Amount</th>
                                <th style="min-width: 180px;">Make / Model</th>
                                <th style="min-width: 180px;">HSN No.</th>
                                    <c:if test="${tenderMaster.tenderPhase == 1}">
                                    <th>Regret</th>
                                    </c:if>
                                    <c:if test="${vendorTechnicalBidTech.size() > 0}">
                                    <th>Technical Response From Vendor</th>
                                    <th>Technical Remark From Vendor</th>
                                    <th>Technical Response From Technical User</th>
                                    </c:if>
                            </tr>
                        </thead>
                        <tbody>

                            <c:if test="${reviseVendorTenderBidItem.size() > 0}">
                                <c:forEach var="vendorTenderBidItem" items="${reviseVendorTenderBidItem}" varStatus="status">
                                    <tr>
                                        <td> ${status.count}</td>
                                        <td>${vendorTenderBidItem.itemCode}</td>
                                        <td>${vendorTenderBidItem.itemDescription}</td>
                                        <td>${vendorTenderBidItem.deliveryScheduleDate}</td>
                                        <td>${vendorTenderBidItem.uom}</td>

                                        <td>${vendorTenderBidItem.qty}</td>
                                        <td>${vendorTenderBidItem.rate}</td>
                                        <td>${vendorTenderBidItem.netRate}</td>

                                        <td>${vendorTenderBidItem.vendorRemark}</td>
                                        <td>${vendorTenderBidItem.hsnNo}</td>
                                        <c:if test="${tenderMaster.tenderPhase == 1}">
                                            <td>
                                                <c:if test="${vendorTenderBidItem.itemRegret == '1'}">
                                                    Yes
                                                </c:if>

                                            </td>
                                        </c:if>
                                        <c:forEach var="vendorTechnicalBidTech" items="${vendorTechnicalBidTech}" varStatus="status1">
                                            <c:if test="${vendorTechnicalBidTech.srNo == vendorTenderBidItem.srNo}">
                                                <td>
                                                    <c:if test="${vendorTechnicalBidTech.vendorResponse == 0}" >
                                                        Yes
                                                    </c:if>
                                                    <c:if test="${vendorTechnicalBidTech.vendorResponse == 1}" >
                                                        No
                                                    </c:if>    
                                                </td>
                                                <td>${vendorTechnicalBidTech.remark}</td>
                                                <td>
                                                    <c:if test="${vendorTechnicalBidTech.buyerResponse == 1}" >
                                                        Yes
                                                    </c:if>
                                                    <c:if test="${vendorTechnicalBidTech.buyerResponse == 0}" >
                                                        No
                                                    </c:if>    
                                                </td>
                                            </c:if>
                                        </c:forEach>

                                    </tr>
                                </c:forEach>
                            </c:if>
                            <c:if test="${reviseVendorTenderBidItem.size() == 0}">
                                <c:forEach var="vendorTenderBidItem" items="${vendorTenderBidItem}" varStatus="status">
                                    <tr>
                                        <td> ${status.count}</td>
                                        <td>${vendorTenderBidItem.itemCode}</td>
                                        <td>${vendorTenderBidItem.itemDescription}</td>
                                        <td>${vendorTenderBidItem.deliveryScheduleDate}</td>
                                        <td>${vendorTenderBidItem.uom}</td>

                                        <td>${vendorTenderBidItem.qty}</td>
                                        <td>${vendorTenderBidItem.rate}</td>
                                        <td>${vendorTenderBidItem.netRate}</td>

                                        <td>${vendorTenderBidItem.vendorRemark}</td>
                                        <td>${vendorTenderBidItem.hsnNo}</td>
                                        <c:if test="${tenderMaster.tenderPhase == 1}">
                                            <td>
                                                <c:if test="${vendorTenderBidItem.itemRegret == '1'}">
                                                    Yes
                                                </c:if>

                                            </td>
                                        </c:if>
                                        <c:forEach var="vendorTechnicalBidTech" items="${vendorTechnicalBidTech}" varStatus="status1">
                                            <c:if test="${vendorTechnicalBidTech.srNo == vendorTenderBidItem.srNo}">
                                                <td>
                                                    <c:if test="${vendorTechnicalBidTech.vendorResponse == 0}" >
                                                        Yes
                                                    </c:if>
                                                    <c:if test="${vendorTechnicalBidTech.vendorResponse == 1}" >
                                                        No
                                                    </c:if>
                                                </td>
                                                <td>${vendorTechnicalBidTech.remark}</td>
                                                <td>
                                                    <c:if test="${vendorTechnicalBidTech.buyerResponse == 1}" >
                                                        Yes
                                                    </c:if>
                                                    <c:if test="${vendorTechnicalBidTech.buyerResponse == 0}" >
                                                        No
                                                    </c:if>    
                                                </td>
                                            </c:if>
                                        </c:forEach>
                                    </tr>
                                </c:forEach>
                            </c:if>
                        </tbody>
                        <tfoot>
                            <tr>
                                <td> Total</td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>

                                <td></td>
                                <td></td>
                                <td>${itemTotal}</td>
                                <td></td>
                                <c:if test="${tenderMaster.tenderPhase == 1}">
                                    <td></td>
                                </c:if>
                                <c:if test="${vendorTechnicalBidTech.size() > 0}">
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </c:if>
                            </tr>
                        </tfoot>
                    </table>    

                    <h5 class="fw-600">Select Common Tax</h5>                  
                    <table id="commonDocTable" class="table  table-striped bg-white dt-scroll" style="width: 100%" align="Center"  >
                        <thead>
                            <tr>
                                <th>Type</th>
                                <th>(*) / Value</th>
                                <th>Value</th>
                                <th>Amount</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Packing</td>
                                <td>
                                    <c:if test="${packingType == 0}">
                                        (%)
                                    </c:if>
                                    <c:if test="${packingType == 1}">
                                        Value
                                    </c:if>
                                </td>
                                <td>${packingValue}</td>
                                <td>${packingValueFinal}</td>
                            </tr>

                            <tr>
                                <td>Freight</td>
                                <td>
                                    (%)
                                </td>
                                <td>${chargesValue}</td>
                                <td>${chargesValueFinal}</td>
                            </tr>

                            <tr>
                                <td>Insurance</td>
                                <td>
                                    (%)
                                </td>
                                <td>${insuranceValue}</td>
                                <td>${insuranceValueFinal}</td>
                            </tr>

                            <tr>
                                <td>Errection</td>
                                <td>
                                    (%)
                                </td>
                                <td>${errectionValue}</td>
                                <td>${errectionValueFinal}</td>
                            </tr>
                            <tr>
                                <td>Total Value After Tax</td>
                                <td>

                                </td>
                                <td></td>
                                <td>${String.format("%.2f",grandTotal - igstValueFinal + discountValueFinal)}</td>
                            </tr>
                            <tr>
                                <td>Discount</td>
                                <td>
                                    <c:if test="${discountType == 0}">
                                        (%)
                                    </c:if>
                                    <c:if test="${discountType == 1}">
                                        Value
                                    </c:if>
                                </td>
                                <td>${discountValue}</td>
                                <td>${discountValueFinal}</td>
                            </tr>

                            <tr>
                                <td>Total Value With Discount</td>
                                <td>

                                </td>
                                <td></td>
                                <td>${String.format("%.2f",grandTotal - igstValueFinal)}</td>
                            </tr>


                            <tr>
                                <td>GST</td>
                                <td>
                                    (%)
                                </td>
                                <td>${igstValue}</td>
                                <td>${igstValueFinal}</td>
                            </tr>

                            <tr>
                                <td>Total Amount</td>
                                <td>

                                </td>
                                <td></td>
                                <td>${grandTotal}</td>
                            </tr>
                        </tbody>
                    </table>

                    <c:if test="${tenderMaster.type == 'Contract' || tenderMaster.type == 'Contract Electrical' || tenderMaster.type == 'Contract Civil'}">        

                    <!--                        <div class="pagebreak"> </div>
                                            <style>
                                                @media print {
                                                    .pagebreak {
                                                        clear: both;
                                                        page-break-after: always;
                                                    }
                                                }
                                            </style>
                                            <img src="StorageYard/Images/logo.png" style="/* height:50px; *//* padding-bottom: 8px; *//* border-color: white !important; *//* border: 4px !important; */background-color: white;">
                                            <br>-->


<%--                    <h5 class="fw-600">Tender information</h5>

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
                                <div class="col-xxl-2 col-lg-3 col-md-8 pb-1">
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
                                        <label>Offer No</label>
                                        <p class="fw-600">${offerNo}</p>
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
                            </div>
                        </div>  
                    </div> --%>

                    <h5 class="fw-600">Item Service Details</h5>

                    <table id="commonNoPageTable0" class="table table-striped bg-white" style="width: 100%" align="Center"  >
                        <thead>
                            <tr>
                                <th>Sr No.</th>
                                <th>Item Code</th>
                                <th style="min-width: 530px;">Item Description</th>
                                <th>Item Details</th>
                                <th>UOM</th>
                                <th>Quantity</th>
                                <th>Unit Rate</th>
                                <th>Amount</th>
                                <th>Make / Model</th>
                                <th>HSN No.</th>
                                    <c:if test="${tenderMaster.tenderPhase == 1}">
                                    <th>Regret</th>
                                    </c:if>
                                    <c:if test="${vendorTechnicalBidTerms.size() > 0}">
                                    <th>Technical Response From Vendor</th>
                                    <th>Technical Remark From Vendor</th>
                                    <th>Technical Response From Technical User</th>
                                    </c:if>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${revisevendorTenderBidItem1.size() > 0}">
                                <c:forEach var="vendorTenderBidItem" items="${revisevendorTenderBidItem1}" varStatus="status">
                                    <tr>
                                        <td> ${status.count}</td>
                                        <td>${vendorTenderBidItem.itemCode}</td>
                                        <td>${vendorTenderBidItem.itemDescription}</td>
                                        <td>${vendorTenderBidItem.deliveryScheduleDate}</td>
                                        <td>${vendorTenderBidItem.uom}</td>
                                        <td>${vendorTenderBidItem.qty}</td>
                                        <td>${vendorTenderBidItem.rate}</td>
                                        <td>${vendorTenderBidItem.netRate}</td>
                                        <td>${vendorTenderBidItem.vendorRemark}</td>
                                        <td>${vendorTenderBidItem.hsnNo}</td>
                                        <c:if test="${tenderMaster.tenderPhase == 1}">
                                            <td>
                                                <c:if test="${vendorTenderBidItem.itemRegret == '1'}">
                                                    Yes
                                                </c:if>

                                            </td>
                                        </c:if>

                                        <c:forEach var="vendorTechnicalBidTerms" items="${vendorTechnicalBidTerms}" varStatus="status1">
                                            <c:if test="${vendorTechnicalBidTerms.srNo == vendorTenderBidItem.srNo}">
                                                <td>
                                                    <c:if test="${vendorTechnicalBidTerms.vendorResponse == 0}" >
                                                        Yes
                                                    </c:if>
                                                    <c:if test="${vendorTechnicalBidTerms.vendorResponse == 1}" >
                                                        No
                                                    </c:if>    
                                                </td>
                                                <td>${vendorTechnicalBidTerms.remark}</td>
                                                <td>
                                                    <c:if test="${vendorTechnicalBidTerms.buyerResponse == 1}" >
                                                        Yes
                                                    </c:if>
                                                    <c:if test="${vendorTechnicalBidTerms.buyerResponse == 0}" >
                                                        No
                                                    </c:if>    
                                                </td>
                                            </c:if>
                                        </c:forEach>

                                    </tr>
                                </c:forEach>
                            </c:if>
                            <c:if test="${revisevendorTenderBidItem1.size() == 0}">
                                <c:forEach var="vendorTenderBidItem" items="${vendorTenderBidItem1}" varStatus="status">
                                    <tr>
                                        <td> ${status.count}</td>
                                        <td>${vendorTenderBidItem.itemCode}</td>
                                        <td>${vendorTenderBidItem.itemDescription}</td>
                                        <td>${vendorTenderBidItem.deliveryScheduleDate}</td>
                                        <td>${vendorTenderBidItem.uom}</td>
                                        <td>${vendorTenderBidItem.qty}</td>
                                        <td>${vendorTenderBidItem.rate}</td>
                                        <td>${vendorTenderBidItem.netRate}</td>
                                        <td>${vendorTenderBidItem.vendorRemark}</td>
                                        <td>${vendorTenderBidItem.hsnNo}</td>
                                        <c:if test="${tenderMaster.tenderPhase == 1}">
                                            <td>
                                                <c:if test="${vendorTenderBidItem.itemRegret == '1'}">
                                                    Yes
                                                </c:if>
                                            </td>
                                        </c:if>
                                        <c:forEach var="vendorTechnicalBidTerms" items="${vendorTechnicalBidTerms}" varStatus="status1">
                                            <c:if test="${vendorTechnicalBidTerms.srNo == vendorTenderBidItem.srNo}">
                                                <td>
                                                    <c:if test="${vendorTechnicalBidTerms.vendorResponse == 0}" >
                                                        Yes
                                                    </c:if>
                                                    <c:if test="${vendorTechnicalBidTerms.vendorResponse == 1}" >
                                                        No
                                                    </c:if>    
                                                </td>
                                                <td>${vendorTechnicalBidTerms.remark}</td>
                                                <td>
                                                    <c:if test="${vendorTechnicalBidTerms.buyerResponse == 1}" >
                                                        Yes
                                                    </c:if>
                                                    <c:if test="${vendorTechnicalBidTerms.buyerResponse == 0}" >
                                                        No
                                                    </c:if>    
                                                </td>
                                            </c:if>
                                        </c:forEach>
                                    </tr>
                                </c:forEach>
                            </c:if>
                        </tbody>
                        <tfoot>
                            <tr>
                                <td> Total</td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>

                                <td></td>
                                <td></td>
                                <td>${serviceTotal}</td>
                                <td></td>
                                <td></td>
                                <c:if test="${tenderMaster.tenderPhase == 1}">
                                    <td></td>
                                </c:if>
                                <c:if test="${vendorTechnicalBidTerms.size() > 0}">
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </c:if>
                            </tr>
                        </tfoot>

                    </table>

                                <br>
                    <table id="commonDocTable2" class="table  table-striped bg-white dt-scroll" style="width: 100%" align="Center"  >
                        <thead>
                            <tr>
                                <th>Type</th>
                                <th>(*) / Value</th>
                                <th>Value</th>
                                <th>Amount</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Discount</td>
                                <td>
                                    <c:if test="${discountType == 0}">
                                        (%)
                                    </c:if>
                                    <c:if test="${discountType == 1}">
                                        Value
                                    </c:if>
                                </td>
                                <td>${serviceDiscountValue}</td>
                                <td>${serviceDiscountValueFinal}</td>
                            </tr>
                            <tr>
                                <td>Total Value With Discount</td>
                                <td>

                                </td>
                                <td></td>
                                <td>${serviceTotal - serviceDiscountValueFinal}</td>
                            </tr>
                            <tr>
                                <td>GST</td>
                                <td>
                                    (%)
                                </td>
                                <td>${igstValue}</td>
                                <td>${servicegstFinal}</td>
                            </tr>
                            <tr>
                                <td>Total Amount</td>
                                <td>
                                </td>
                                <td></td>
                                <td>${serviceTaxTotal}</td>
                            </tr>
                        </tbody>
                    </table>
                    </c:if> 
                    <br>
                    <h5 class="fw-600">Vendor Terms & Condition</h5> 
                    <table id="commonTable2" class="table  table-striped bg-white" style="width: 100%" align="Center"  >
                        <thead>
                            <tr>
                                <th>Terms Condition</th>
                                <th>Description</th>
                                <th>Response</th>
                                <th>Remark</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${vendorTermsCondition1}" var="vendorTermsCondition1" varStatus="status">
                                <tr>
                                    <td>${vendorTermsCondition1.termsCondition}</td>
                                    <td>${vendorTermsCondition1.description}</td>
                                    <td style="text-align: center">
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
                                </tr>
                            </c:forEach>

                        </tbody>                               
                    </table>

                    </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
