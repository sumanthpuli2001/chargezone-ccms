
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VENDOR REVISE PRICE BID VIEW</title>
    </head>
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

                            <h5 class="fw-600 mb-0">VENDOR REVISE PRICE BID VIEW</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
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
                                        <label>Plant Name</label>
                                        <p class="fw-600">${tenderMaster.plantName}</p>
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
                                        <label>PR Item No</label>
                                        <p class="fw-600"${tenderMaster.prItemNo} </p>
                                    </div>
                                </div>
                            </div>
                        </div>  
                    </div> 
                    <h5 class="fw-600">Tender Contact Person</h5>                     
                    <div class="rounded-4 mt-4"> 
                        <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                            <div class="row buyer-info">
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Created by</label>
                                        <p class="fw-600">${contactPerson}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>End User Name</label>
                                        <p class="fw-600">${tenderMaster.endUserName}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>End User No</label>
                                        <p class="fw-600">${tenderMaster.endUserNumber}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <h5 class="fw-600">Tender Contact Person</h5>                     
                    <div class="rounded-4 mt-4"> 
                        <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                            <div class="row buyer-info">
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Quotation No</label>
                                        <p class="fw-600">${offerNo}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Date</label>
                                        <p class="fw-600">${offerDate}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Contact Person</label>
                                        <p class="fw-600">${contact_person}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Contact Number</label>
                                        <p class="fw-600">${contact_no}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Contact Email</label>
                                        <p class="fw-600">${contact_email}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <c:if test="${fee != '0'}">
                        <h5 class="fw-600">Fee Details</h5> 
                        <div class="rounded-4 mt-4"> 
                            <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                                <div class="row buyer-info">
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Fee</label>
                                            <p class="fw-600">${fee}</p>
                                        </div>
                                    </div>             
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Fee Date</label>
                                            <p class="fw-600">${fee_date}</p>
                                        </div>
                                    </div>             
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Drawee Bank</label>
                                            <p class="fw-600">${fee_drawee_bank}</p>
                                        </div>
                                    </div>             
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Cheque No</label>
                                            <p class="fw-600">${fee_cheque_no}</p>
                                        </div>
                                    </div>             
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Attachment</label>
                                            <p class="fw-600" class="fw-600 text-break gradient-text">${fee_attach}</p>
                                        </div>
                                    </div>  

                                </div>             
                            </div>             
                        </div>             
                    </c:if>                

                    <c:if test="${emd != '0'}">
                        <h5 class="fw-600">EMD Details</h5> 
                        <div class="rounded-4 mt-4"> 
                            <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                                <div class="row buyer-info">
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>EMD</label>
                                            <p class="fw-600">${emd}</p>
                                        </div>
                                    </div> 
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>EMD Date</label>
                                            <p class="fw-600">${emd_date}</p>
                                        </div>
                                    </div> 
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Drawee Bank</label>
                                            <p class="fw-600">${emd_drawee_bank}</p>
                                        </div>
                                    </div> 
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Cheque No</label>
                                            <p class="fw-600">${emd_cheque_no}</p>
                                        </div>
                                    </div> 
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Cash / Cheque</label>
                                            <p class="fw-600">${cash_cheque}</p>
                                        </div>
                                    </div> 
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Attachment</label>
                                            <p class="fw-600" class="fw-600 text-break gradient-text">${emd_attach}</p>
                                        </div>
                                    </div> 
                                </div> 
                            </div> 
                        </div> 
                    </c:if>

                    <c:if test="${tenderMaster.type == 'Contract Civil'}">
                        <h5 class="fw-600">Civil Details</h5>
                    </c:if>
                    <c:if test="${tenderMaster.type != 'Contract Civil'}">
                        <c:if test="${tenderMaster.type == 'Service'}">

                            <h5 class="fw-600">Service Details</h5>
                        </c:if>
                        <c:if test="${tenderMaster.type != 'Service'}">

                            <h5 class="fw-600">Item Details</h5>
                        </c:if>
                    </c:if>

                    <hr>
                    <table id="commonTable" class="table  table-striped bg-white" style="width: 100%" align="Center"  >
                        <thead>
                            <tr>
                                <th>Sr No.</th>
                                <th style="min-width: 180px;">Item Code</th>
                                <th style="min-width: 230px;">Item Description</th>
                                <th style="min-width: 180px;">Item Details</th>
                                <th>UOM</th>
                                <th>Quantity</th>
                                <th  style="min-width: 180px;">Unit Rate</th>
                                <th  style="min-width: 180px;">Amount</th>
                                <th  style="min-width: 180px;">Make / Model</th>
                                <th  style="min-width: 180px;">HSN No.</th>
                                    <c:if test="${tenderMaster.tenderPhase == 1}">
                                    <th  style="min-width: 180px;"> Regret</th>
                                    </c:if>
                            </tr>
                        </thead>
                        <tbody>
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

                                </tr>
                            </c:forEach>
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
                                <td></td>
                                <c:if test="${tenderMaster.tenderPhase == 1}">
                                    <td></td>
                                </c:if>
                            </tr>
                        </tfoot>

                    </table>

                    <c:if test="${selectCommon == 1}">

                        <h5 class="fw-600">Select Common Tax</h5>

                        <hr>
                        <table id="commonDocTable" class="table table-striped bg-white dt-scroll" style="width: 100%" align="Center"  >
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
                                    <td>Total Without Discount</td>
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
                                    <td>Total Without GST</td>
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
                    </c:if>

                    <c:if test="${selectCommon == 0}">

                        <h5 class="fw-600">Select Individual Tax</h5> 
                        <hr>
                        <table id="commonDocTable1" class="table table-striped bg-white dt-scroll" style="width: 100%" align="Center"  >
                            <thead>
                                <tr>
                                    <th>Type</th>
                                    <th>Amount</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Discount</td>
                                    <td>${discountValueFinal}</td>
                                </tr>
                                <tr>
                                    <td>Packing</td>
                                    <td>${packingValueFinal}</td>
                                </tr>

                                <tr>
                                    <td>Errection</td>
                                    <td>${errectionValueFinal}</td>
                                </tr>
                                <tr>
                                    <td>Other Charges</td>
                                    <td>${chargesValueFinal}</td>
                                </tr>
                                <tr>
                                    <td>GST</td>
                                    <td>${igstValueFinal}</td>
                                </tr>
                                <tr>
                                    <td>Insurance</td>
                                    <td>${insuranceValueFinal}</td>
                                </tr>
                                <tr>
                                    <td>Total Amount</td>
                                    <td>${grandTotal}</td>
                                </tr>
                            </tbody>
                        </table>



                        <h5 class="fw-600">Individual Item Details</h5> 
                        <hr>
                        <c:forEach var="vbi" items="${vbi}" varStatus="status">
                            <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                <thead>
                                    <tr>
                                        <th>Sr No.</th>
                                        <th>Item Code</th>
                                        <th>Item Detail</th>
                                        <th>UOM</th>
                                        <th>Quantity</th>
                                        <th>Unit Rate</th>
                                        <th>Amount</th>
                                        <th>Make / Model</th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <tr>
                                        <td> ${status.count}</td>
                                        <td>${vbi.itemCode}</td>
                                        <td>${vbi.itemDesciption}</td>
                                        <td>${vbi.uom}</td>
                                        <td>${vbi.qty}</td>
                                        <td>${vbi.rate}</td>
                                        <td>${vbi.individualNetTotal}</td>
                                        <td>${vbi.vendorRemark}</td>
                                    </tr>

                                </tbody>
                            </table>

                            <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
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
                                            <c:if test="${vbi.individualDiscountType == 0}">
                                                (%)
                                            </c:if>
                                            <c:if test="${vbi.individualDiscountType == 1}">
                                                Value
                                            </c:if>
                                        </td>
                                        <td>${vbi.individualDiscountValue}</td>
                                        <td>${vbi.individualDiscountValueFinal}</td>
                                    </tr>
                                    <tr>
                                        <td>Packing</td>
                                        <td>
                                            <c:if test="${vbi.individualPackingType == 0}">
                                                (%)
                                            </c:if>
                                            <c:if test="${vbi.individualPackingType == 1}">
                                                Value
                                            </c:if>
                                        </td>
                                        <td>${vbi.individualPackingValue}</td>
                                        <td>${vbi.individualPackingValueFinal}</td>
                                    </tr>

                                    <tr>
                                        <td>Errection</td>
                                        <td>
                                            (%)
                                        </td>
                                        <td>${vbi.individualErrectionValue}</td>
                                        <td>${vbi.individualErrectionValueFinal}</td>
                                    </tr>
                                    <tr>
                                        <td>Other Charges</td>
                                        <td>
                                            (%)
                                        </td>
                                        <td>${vbi.individualChargesValue}</td>
                                        <td>${vbi.individualChargesValueFinal}</td>
                                    </tr>
                                    <tr>
                                        <td>GST</td>
                                        <td>
                                            (%)
                                        </td>
                                        <td>${vbi.individualIgstValue}</td>
                                        <td>${vbi.individualIgstValueFinal}</td>
                                    </tr>
                                    <tr>
                                        <td>Insurance</td>
                                        <td>
                                            (%)
                                        </td>
                                        <td>${vbi.individualInsuranceValue}</td>
                                        <td>${vbi.individualInsuranceValueFinal}</td>
                                    </tr>
                                    <tr>
                                        <td>Total Amount</td>
                                        <td>

                                        </td>
                                        <td></td>
                                        <td>${vbi.individualgrandTotal}</td>
                                    </tr>
                                </tbody>
                            </table>

                        </c:forEach>


                    </c:if>


                    <c:if test="${tenderMaster.type == 'Contract'  || tenderMaster.type == 'Contract Civil' || tenderMaster.type == 'Contract Electrical'}">        

                        <c:if test="${tenderMaster.type == 'Contract Civil'}">
                            <h5 class="fw-600">Steel Details</h5>
                        </c:if>
                        <c:if test="${tenderMaster.type != 'Contract Civil'}"> 

                            <h5 class="fw-600">Item Details For Service</h5>
                        </c:if>
                        <hr>
                        <table id="commonTable1" class="table  table-striped bg-white" style="width: 100%" align="Center"  >
                            <thead>
                                <tr>
                                    <th>Sr No.</th>
                                    <th style="min-width: 190px;">Item Code</th>
                                    <th style="min-width: 230px;">Item Description</th>
                                    <th style="min-width: 190px;">Item Details</th>
                                    <th>UOM</th>
                                    <th>Quantity</th>
                                    <th>Unit Rate</th>
                                    <th style="min-width: 190px;">Amount</th>
                                    <th>Make / Model</th>
                                    <th style="min-width: 190px;">HSN No.</th>
                                        <c:if test="${tenderMaster.tenderPhase == 1}">
                                        <th>Regret</th>
                                        </c:if>
                                </tr>
                            </thead>
                            <tbody>
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
                                    </tr>
                                </c:forEach>
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
                                </tr>
                            </tfoot>

                        </table>

                        <c:if test="${selectCommon == 1}">
                            <h5 class="fw-600">Select Common Tax</h5> 
                            <hr>
                            <table id="commonDocTable2" class="tabletable-striped bg-white" style="width: 100%" align="Center"  >
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
                                        <td>Total Without GST</td>
                                        <td>
                                        </td>
                                        <td></td>
                                        <td>${String.format("%.2f",serviceTaxTotal - servicegstFinal)}</td>
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
                    </c:if> 

                    <h5 class="fw-600">Vendor Terms & Condition</h5>
                    <hr>
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
                                    <td><input type="hidden" name="termsCondition" id="termsCondition" value="${vendorTermsCondition1.termsCondition}" readonly="true" class="form-control">${vendorTermsCondition1.termsCondition}</td>
                                    <td><input type="hidden" name="description" id="description" value="${vendorTermsCondition1.description}" readonly="true" class="form-control">${vendorTermsCondition1.description}</td>
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
                                    <td><input readonly="true" type="hidden" class="form-control" name="remarks" id="remarks${status.count}" value="${vendorTermsCondition1.comment}">${vendorTermsCondition1.comment}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                    <div class="rounded-4 mt-4"> 
                        <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                            <div class="row buyer-info">
                               
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Delivery Period (In Weeks)</label>
                                        <p class="fw-600">${deliveryPeriod}</p>

                                    </div>
                                </div>  
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Terms of Payment</label>
                                        <p class="fw-600">${termsOfPayment}</p>

                                    </div>
                                </div>  
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Mode of Transport</label>
                                        <p class="fw-600">${modeOfTransport}</p>

                                    </div>
                                </div>  
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Inco Terms</label>
                                        <p class="fw-600">${incoTerms}</p>

                                    </div>
                                </div>  
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Vendor Remark</label>
                                        <p class="fw-600">${vendorTenderBid.remarkByVendor}</p>

                                    </div>
                                </div>  
                            </div>  
                        </div>  
                    </div>  





                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
