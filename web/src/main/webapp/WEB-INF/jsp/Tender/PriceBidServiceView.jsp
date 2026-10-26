<%-- 
    Document   : EmployeeCreate
    Created on : Jun 3, 2022, 2:39:39 PM
    Author     : Samir Tailor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    
    
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendor Price Bid View</title>
        
<script language="javascript" type="text/javascript">
    function gettender() 
    {
        
        var t=document.getElementById("refNo").value;
        var tenderPhase = document.getElementById("tenderPhase").value;
        window.location='tenderMaster.htm?act=getTender&refNo='+t+'&tenderPhase='+tenderPhase;
    }
      
</script>

    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Vendor Price Bid View</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Vendor Price Bid View</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                                <form:form action="tenderMaster.htm?act=submitTenderMaster" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                                           class="form-horizontal" role="form">
                                    
                                    Tender information
                                    <hr>
                                    
                                    <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                        <tr>
                                            <th>Tender No.</th>
                                            <td>${refNo}</td>
                                        </tr>
                                        <tr>
                                            <th>Project Name</th>
                                            <td>${title}</td>
                                            <th>Project ID</th>
                                            <td>${projectId}</td>
                                        </tr>
                                        <tr>
                                            <th>RFQ No.</th>
                                            <td>${rfqNo}</td>
                                            <th>Vendor Name</th>
                                            <td>${vendorCode} ${vendorName}</td>
                                        </tr>
                                        <tr>
                                            <th>Tender Date Time</th>
                                            <td>${announceDate}</td>
                                            <th>Due Date Time</th>
                                            <td>${submitLastdate}</td>
                                        </tr>
                                        <tr>
                                            <th>PR No.</th>
                                            <td>${prNo}</td>
                                        </tr>
                                        
                                    </table>
                                    
                                        
                                    Tender Contact Person
                                    <hr>
                                    
                                    <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                        <tr>
                                            <th>Created by</th>
                                            <td>${contactPerson}</td>
                                            <th>Number</th>
                                            <td>${tenderAdminContactNumber}</td>
                                        </tr>
                                        <tr>
                                            <th>Authorize by</th>
                                            <td>${tenderAuthorizePerson}</td>
                                            <th>Number</th>
                                            <td>${tenderAuthorizeContactNo}</td>
                                        </tr>
                                        
                                    </table>
                                    
                                        
                                        
                                    Vendor Quotation Details
                                    <hr>
                                    
                                    <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                        <tr>
                                            <th>Quotation No</th>
                                            <td>${offerNo}</td>
                                            <th>Date</th>
                                            <td>${offerDate}</td>
                                        </tr>
                                        <tr>
                                            <th>Contact Person</th>
                                            <td>${contact_person}</td>
                                            <th>Contact Number</th>
                                            <td>${contact_no}</td>
                                        </tr>
                                        <tr>
                                            <th>Contact Email</th>
                                            <td>${contact_email}</td>
                                            <th>GST No</th>
                                            <td>${gst_no}</td>
                                        </tr>
                                        
                                    </table>
                                        
                                    Fee Details
                                    <hr>
                                    
                                    <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                        <tr>
                                            <th>Fee</th>
                                            <td>${fee}</td>
                                            <th>Fee Date</th>
                                            <td>${fee_date}</td>
                                        </tr>
                                        <tr>
                                            <th>Drawee Bank</th>
                                            <td>${fee_drawee_bank}</td>
                                            <th>Cheque No</th>
                                            <td>${fee_cheque_no}</td>
                                        </tr>
                                        <tr>
                                            <th>Attachment</th>
                                            <td>${fee_attach}</td>
                                        </tr>
                                    </table>
                                        
                                    EMD Details
                                    <hr>
                                    
                                    <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                        <tr>
                                            <th>EMD</th>
                                            <td>${emd}</td>
                                            <th>EMD Date</th>
                                            <td>${emd_date}</td>
                                        </tr>
                                        <tr>
                                            <th>Drawee Bank</th>
                                            <td>${emd_drawee_bank}</td>
                                            <th>Cheque No</th>
                                            <td>${emd_cheque_no}</td>
                                        </tr>
                                        <tr>
                                            <th>Cash / Cheque</th>
                                            <td>${cash_cheque}</td>
                                            <th>Attachment</th>
                                            <td>${emd_attach}</td>
                                        </tr>
                                    </table>
                                    
                                    
                                    Item Details
                                    <hr>
                                    
                                    <c:forEach var="fileDetail" items="${fileDetail}" varStatus="status1">
                                        ${fileDetail.title}
                                        <c:if test="${status1.count == '1'}">
                                            
                                            <c:if test="${fileDetail.serType == 'Service1' || fileDetail.serType == 'Service5'}">
                                                <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                <thead>
                                                                <tr>
                                                                    <th>Sr No.</th>
                                                                    <th>Item Description</th>
                                                                    <th>UOM</th>
                                                                    <th>Quantity</th>
                                                                    <th>Unit Rate</th>
                                                                    <th>Amount</th>
                                                                    <th>HSN No.</th>
                                                                    <th>Vendor Remark</th>
                                                                </tr>
                                                </thead>
                                                <tbody>
                                                         
                                                    <c:forEach var="serviceVendorTenderBidItem1" items="${serviceVendorTenderBidItem11_1}" varStatus="status">
                                                        <tr>
                                                            <td>${serviceVendorTenderBidItem1.srNo}</td>
                                                            <td>${serviceVendorTenderBidItem1.itemDesc}</td>
                                                            <td>${serviceVendorTenderBidItem1.uom}</td>
                                                            <td>${serviceVendorTenderBidItem1.quantity}</td>
                                                            <td>${serviceVendorTenderBidItem1.rate}</td>
                                                            <td>${serviceVendorTenderBidItem1.netRate}</td>
                                                            <td>${serviceVendorTenderBidItem1.hsnNo}</td>
                                                            <td>${serviceVendorTenderBidItem1.vendorRemark}</td>
                                                        </tr>
                                                        </c:forEach>
                                                        <tr>
                                                                <td>Total</td>
                                                                <td></td>
                                                                <td></td>
                                                                <td></td>
                                                                <td></td>
                                                                <td>${item_total1_1}</td>
                                                                <td></td>
                                                                <td></td>
                                                            </tr>
                                                </tbody>
                                            </table>
                                                
                                                  <c:if test="${selectCommon1 == 1}">
                                        Select Common Tax 
                                        <hr>
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
                                                                <c:if test="${discountType1 == 0}">
                                                                    (%)
                                                                </c:if>
                                                                <c:if test="${discountType1 == 1}">
                                                                    Value
                                                                </c:if>
                                                            </td>
                                                            <td>${discountValue1}</td>
                                                            <td>${discountValueFinal1}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Packing</td>
                                                            <td>
                                                                <c:if test="${packingType1 == 0}">
                                                                    (%)
                                                                </c:if>
                                                                <c:if test="${packingType1 == 1}">
                                                                    Value
                                                                </c:if>
                                                            </td>
                                                            <td>${packingValue1}</td>
                                                            <td>${packingValueFinal1}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Freight</td>
                                                            <td>
                                                                <c:if test="${freightType1 == 0}">
                                                                    (%)
                                                                </c:if>
                                                                <c:if test="${freightType1 == 1}">
                                                                    Value
                                                                </c:if>
                                                            </td>
                                                            <td>${freightValue1}</td>
                                                            <td>${freightValueFinal1}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Errection</td>
                                                            <td>
                                                                Value
                                                            </td>
                                                            <td>${errectionValue1}</td>
                                                            <td>${errectionValueFinal1}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Other Charges</td>
                                                            <td>
                                                                Value
                                                            </td>
                                                            <td>${chargesValue1}</td>
                                                            <td>${chargesValueFinal1}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>IGST</td>
                                                            <td>
                                                                (%)
                                                            </td>
                                                            <td>${igstValue1}</td>
                                                            <td>${igstValueFinal1}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>CGST</td>
                                                            <td>
                                                                (%)
                                                            </td>
                                                            <td>${cgstValue1}</td>
                                                            <td>${cgstValueFinal1}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>SGST</td>
                                                            <td>
                                                                (%)
                                                            </td>
                                                            <td>${sgstValue1}</td>
                                                            <td>${sgstValueFinal1}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Insurance</td>
                                                            <td>
                                                                (%)
                                                            </td>
                                                            <td>${insuranceValue1}</td>
                                                            <td>${insuranceValueFinal1}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Total Amount</td>
                                                            <td>
                                                                
                                                            </td>
                                                            <td></td>
                                                            <td>${grandTotal1}</td>
                                                        </tr>
                                                </tbody>
                                            </table>
                                        </c:if>
                                            <c:if test="${(fileDetail.taxReq == 'tax_apply_service1' && fileDetail.serType == 'Service1') || fileDetail.serType == 'Service5'}">
                                                <c:if test="${selectCommon1 == 0}">
                                        Select Individual Tax 
                                        <hr>
                                            <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                <thead>
                                                                <tr>
                                                                    <th>Type</th>
                                                                    <th>Amount</th>
                                                                </tr>
                                                </thead>
                                                <tbody>
                                                        <tr>
                                                            <td>Discount</td>
                                                            <td>${discountValueFinal1}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Packing</td>
                                                            <td>${packingValueFinal1}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Freight</td>
                                                            <td>${freightValueFinal1}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Errection</td>
                                                            <td>${errectionValueFinal1}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Other Charges</td>
                                                            <td>${chargesValueFinal1}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>IGST</td>
                                                            <td>${igstValueFinal1}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>CGST</td>
                                                            <td>${cgstValueFinal1}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>SGST</td>
                                                            <td>${sgstValueFinal1}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Insurance</td>
                                                            <td>${insuranceValueFinal1}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Total Amount</td>
                                                            <td>${grandTotal1}</td>
                                                        </tr>
                                                </tbody>
                                            </table>
                                                        
                                            Individual Item Details
                                            <hr>
                                            
                                            <c:forEach var="vbi" items="${vbi1}" varStatus="status">
                                                <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                <thead>
                                                                <tr>
                                                                    <th>Sr No.</th>
                                                                    <th>Item Code</th>
                                                                    <th>Item Detail</th>
                                                                    <th>UOM</th>
                                                                    <th>Remark</th>
                                                                    <th>Quantity</th>
                                                                    <th>Unit Rate</th>
                                                                    <th>Amount</th>
                                                                    <th>HSN No.</th>
                                                                    <th>Vendor Remark</th>
                                                                </tr>
                                                </thead>
                                                <tbody>
                                                         
                                                        <tr>
                                                            <td> ${status.count}</td>
                                                            <td>${vbi.itemCode}</td>
                                                            <td>${vbi.itemDesciption}</td>
                                                            <td>${vbi.uom}</td>
                                                            <td>${vbi.remark}</td>
                                                            <td>${vbi.qty}</td>
                                                            <td>${vbi.rate}</td>
                                                            <td>${vbi.individualNetTotal}</td>
                                                            <td>${vbi.hsnNo}</td>
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
                                                            <td>Freight</td>
                                                            <td>
                                                                <c:if test="${vbi.individualFreightType == 0}">
                                                                    (%)
                                                                </c:if>
                                                                <c:if test="${vbi.individualFreightType == 1}">
                                                                    Value
                                                                </c:if>
                                                            </td>
                                                            <td>${vbi.individualFreightValue}</td>
                                                            <td>${vbi.individualFreightValueFinal}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Errection</td>
                                                            <td>
                                                                Value
                                                            </td>
                                                            <td>${vbi.individualErrectionValue}</td>
                                                            <td>${vbi.individualErrectionValueFinal}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Other Charges</td>
                                                            <td>
                                                                Value
                                                            </td>
                                                            <td>${vbi.individualChargesValue}</td>
                                                            <td>${vbi.individualChargesValueFinal}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>IGST</td>
                                                            <td>
                                                                (%)
                                                            </td>
                                                            <td>${vbi.individualIgstValue}</td>
                                                            <td>${vbi.individualIgstValueFinal}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>CGST</td>
                                                            <td>
                                                                (%)
                                                            </td>
                                                            <td>${vbi.individualCgstValue}</td>
                                                            <td>${vbi.individualCgstValueFinal}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>SGST</td>
                                                            <td>
                                                                (%)
                                                            </td>
                                                            <td>${vbi.individualSgstValue}</td>
                                                            <td>${vbi.individualSgstValueFinal}</td>
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
                                            </c:if>
                                            </c:if>
                                            <c:if test="${fileDetail.serType == 'Service2'}">
                                                          <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    
                                                    <c:forEach var="serviceDetail" items="${serviceDetail21_1}" varStatus="status">
                                                                            <c:if test="${status.count == 1}">
                                                                                <thead>
                                                                                    <tr>
                                                                                        <th>${serviceDetail.srNo}</th>
                                                                                        <th>${serviceDetail.itemDesc}</th>
                                                                                                    <c:if test="${serviceDetail.onlyBearing1 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing1}</th>
                                                                                                        <c:set var = "i1" value="1"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing2 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing2}</th>
                                                                                                        <c:set var = "i1" value="2"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing3 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing3}</th>
                                                                                                        <c:set var = "i1" value="3"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing4 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing4}</th>
                                                                                                        <c:set var = "i1" value="4"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing5 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing5}</th>
                                                                                                        <c:set var = "i1" value="5"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing6 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing6}</th>
                                                                                                        <c:set var = "i1" value="6"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing7 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing7}</th>
                                                                                                        <c:set var = "i1" value="7"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing8 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing8}</th>
                                                                                                        <c:set var = "i1" value="8"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing9 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing9}</th>
                                                                                                        <c:set var = "i1" value="9"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing10 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing10}</th>
                                                                                                        <c:set var = "i1" value="10"/>
                                                                                                    </c:if>
                                                                                        
                                                                                    </tr>
                                                                                </thead>

                                                                                <tbody>
                                                                            </c:if>
                                                                        </c:forEach>
                                                    <tbody>
                                                         
                                                        <c:forEach var="serviceVendorTenderBidItem2" items="${serviceVendorTenderBidItem21_1}" varStatus="status">
                                                            <tr>
                                                                <td>${serviceVendorTenderBidItem2.srNo}</td>
                                                                <td>${serviceVendorTenderBidItem2.itemDesc}</td>
                                                                <c:if test="${i1 >= 1}">
                                                                    <td>${serviceVendorTenderBidItem2.onlyBearing1}</td>
                                                                </c:if>
                                                                <c:if test="${i1 >= 2}">
                                                                    <td>${serviceVendorTenderBidItem2.onlyBearing2}</td>
                                                                </c:if>
                                                                <c:if test="${i1 >= 3}">
                                                                    <td>${serviceVendorTenderBidItem2.onlyBearing3}</td>
                                                                </c:if>
                                                                <c:if test="${i1 >= 4}">
                                                                    <td>${serviceVendorTenderBidItem2.onlyBearing4}</td>
                                                                </c:if>
                                                                <c:if test="${i1 >= 5}">
                                                                    <td>${serviceVendorTenderBidItem2.onlyBearing5}</td>
                                                                </c:if>
                                                                <c:if test="${i1 >= 6}">
                                                                    <td>${serviceVendorTenderBidItem2.onlyBearing6}</td>
                                                                </c:if>
                                                                <c:if test="${i1 >= 7}">
                                                                    <td>${serviceVendorTenderBidItem2.onlyBearing7}</td>
                                                                </c:if>
                                                                <c:if test="${i1 >= 8}">
                                                                    <td>${serviceVendorTenderBidItem2.onlyBearing8}</td>
                                                                </c:if>
                                                                <c:if test="${i1 >= 9}">
                                                                    <td>${serviceVendorTenderBidItem2.onlyBearing9}</td>
                                                                </c:if>
                                                                <c:if test="${i1 >= 10}">
                                                                    <td>${serviceVendorTenderBidItem2.onlyBearing10}</td>
                                                                </c:if>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                 </table>  
                                            </c:if>
                                            <c:if test="${fileDetail.serType == 'Service3'}">
                                                <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <thead>
                                                                <tr>
                                                                    <th>Sr No.</th>
                                                                    <th>Particular</th>
                                                                    <th>Scheduled Amount</th>
                                                                    <th>Percent</th>
                                                                    <th>Percent Rate</th>
                                                                    <th>Amount Total</th>
                                                                    
                                                                </tr>
                                                    </thead>
                                                    <tbody>
                                                         
                                                        <c:forEach var="serviceVendorTenderBidItem3" items="${serviceVendorTenderBidItem31_1}" varStatus="status">
                                                            <tr>
                                                                <td>${serviceVendorTenderBidItem3.srNo}</td>
                                                                <td>${serviceVendorTenderBidItem3.particular}</td>
                                                                <td>${serviceVendorTenderBidItem3.scheduledAmount}</td>
                                                                <td>${serviceVendorTenderBidItem3.percent}</td>
                                                                <td>${serviceVendorTenderBidItem3.percentRate}</td>
                                                                <td>${serviceVendorTenderBidItem3.amountTotal}</td>
                                                            
                                                            </tr>
                                                        </c:forEach>
                                                            <tr>
                                                                <td>Total</td>
                                                                <td></td>
                                                                <td></td>
                                                                
                                                                <td></td>
                                                                <td></td>
                                                                <td>${item_total1_1}</td>
                                                            </tr>
                                                    </tbody>
                                                 </table>
                                            </c:if>
                                            <c:if test="${fileDetail.serType == 'Service4'}">
                                                         <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >        
                                                    <tbody>
                                                        <tr>
                                                            <th>Security Name</th>

                                                            <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                <th>${serviceVendorTenderBidItem4.securityName}</th>
                                                            </c:forEach>    

                                                        </tr>
                                                        <tr>
                                                            <th>No. Of Person</th>

                                                            <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                <th>${serviceVendorTenderBidItem4.noOfPerson}</th>
                                                            </c:forEach>    

                                                        </tr>
                                                        <tr>
                                                            <th>Minimum Wages (Skilled/Unskilled)/Day</th>
                                                            <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                <td>${serviceVendorTenderBidItem4.wages}</td>
                                                            </c:forEach>    
                                                        </tr>
                                                        <tr>
                                                            <th> % Statutory Obligation</th>
                                                            <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                <td>${serviceVendorTenderBidItem4.percentage}</td>
                                                            </c:forEach>
                                                        </tr>
                                                        <tr>
                                                            <th>Total</th>
                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                        <td>${serviceVendorTenderBidItem4.perTotal}</td>
                                                                    </c:forEach>    
                                                        </tr>
                                                        
                                                        
                                                                            <c:if test="${fileDetail.allowance == 'allowance_service4'}">
                                                                                <tr>
                                                                                    <th>Allowance</th>
                                                                                            <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                                                <td>${serviceVendorTenderBidItem4.allowance}</td>
                                                                                            </c:forEach>    
                                                                                </tr>
                                                                                <tr>
                                                                                    <th>Allowance Total</th>
                                                                                            <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                                                <td>${serviceVendorTenderBidItem4.allowanceTotal}</td>
                                                                                            </c:forEach>    
                                                                                    
                                                                                </tr>

                                                                            </c:if>
                                                                            <c:if test="${fileDetail.uniformTrainingCost == 'uniform_cost_service4'}">
                                                                                <tr>
                                                                                    <th>Uniform & Training Charges</th>
                                                                                            <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                                                <td>${serviceVendorTenderBidItem4.uCharges}</td>
                                                                                        </c:forEach>    
                                                                                    
                                                                                </tr>
                                                                            </c:if>
                                                                            
                                                                            <c:if test="${fileDetail.serviceCharge == 'service_charge_service4'}">
                                                                                <tr>
                                                                                    <th>Service Charge</th>
                                                                                            <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                                                <td>${serviceVendorTenderBidItem4.sCharges}</td>
                                                                                            </c:forEach>    
                                                                            
                                                                                </tr>
                                                                            </c:if>
                                                                            
                                                                            <tr>
                                                                                <th>Total per day per person</th>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.tPDPP}</td>
                                                                                        </c:forEach>    
                                                                                
                                                                            </tr>
                                                                            <tr>
                                                                                <th>Total per Month(30 Days) per person</th>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.tPMPP}</td>
                                                                                        </c:forEach>    
                                                                                
                                                                            </tr>
                                                                            <tr>
                                                                                <th>Total per Year(365 Days) per person</th>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.tPYPP}</td>
                                                                                        </c:forEach>    
                                                                                
                                                                            </tr>
                                                                            
                                                                            <c:if test="${fileDetail.dateWise == 'date_service4'}">
                                                                                <tr>
                                                                                    <th>Total per date difference per person for Date</th>
                                                                                            <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                                                <td>${serviceVendorTenderBidItem4.perDayPerPerson}</td>
                                                                                            </c:forEach>    
                                                                                </tr>
                                                                            </c:if>
                                                                            
                                                                            <tr>
                                                                                <td>Total per day</td>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.tPD}</td>
                                                                                        </c:forEach>    
                                                                            
                                                                            </tr>
                                                                            <tr>
                                                                                <th>Total per Month(30 Days)</th>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.tPM}</td>
                                                                                        </c:forEach>    
                                                                            
                                                                            </tr>
                                                                            <tr>
                                                                                <th>Total per Year(365 Days)</th>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.tDY}</td>
                                                                                        </c:forEach>    
                                                                                
                                                                            </tr>
                                                                            <c:if test="${fileDetail.dateWise == 'date_service4'}">
                                                                                <tr>
                                                                                    <th>Total per date difference  from date</th>
                                                                                            <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                                                <td${serviceVendorTenderBidItem4.perDayPerDay}</td>
                                                                                            </c:forEach>    
                                                                                    
                                                                                </tr>
                                                                            </c:if>
                                                        
                                                    </tbody>                        
                                                </table>    
                                            </c:if>
                                            <c:if test="${fileDetail.serType == 'Service6'}">
                                                <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <thead>
                                                                <tr>
                                                                    <th>Sr No.</th>
                                                                    <th>PC Type</th>
                                                                    <th>Item Description</th>
                                                                    <th>UOM</th>
                                                                    <th>Quantity</th>
                                                                    <th>AMC Required Days</th>
                                                                    <th>Rate</th>
                                                                    <th>Amount Total</th>
                                                                </tr>
                                                    </thead>
                                                    <tbody>
                                                         
                                                        <c:forEach var="serviceVendorTenderBidItem6" items="${serviceVendorTenderBidItem61_1}" varStatus="status">
                                                            <tr>
                                                                <td>${serviceVendorTenderBidItem6.srNo}</td>
                                                                <td>${serviceVendorTenderBidItem6.pcType}</td>
                                                                <td>${serviceVendorTenderBidItem6.itemDesc}</td>
                                                                <td>${serviceVendorTenderBidItem6.uom}</td>
                                                                <td>${serviceVendorTenderBidItem6.quantity}</td>
                                                                <td>${serviceVendorTenderBidItem6.amcRequiredays}</td>
                                                                <td>${serviceVendorTenderBidItem6.rate}</td>
                                                                <td>${serviceVendorTenderBidItem6.itemTotal}</td>
                                                            </tr>
                                                        </c:forEach>
                                                            <tr>
                                                                <td>Total</td>
                                                                <td></td>
                                                                <td></td>
                                                                <td></td>
                                                                <td></td>
                                                                <td></td>
                                                                <td></td>
                                                                <td>${item_total1_1}</td>
                                                            </tr>
                                                    </tbody>
                                                 </table>            
                                            </c:if>
                                        </c:if>
                                        
                                            
                                        <c:if test="${status1.count == '2'}">
                                            <c:if test="${fileDetail.serType == 'Service1' || fileDetail.serType == 'Service5'}">
                                                <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                <thead>
                                                                <tr>
                                                                    <th>Sr No.</th>
                                                                    <th>Item Description</th>
                                                                    <th>UOM</th>
                                                                    <th>Quantity</th>
                                                                    <th>Unit Rate</th>
                                                                    <th>Amount</th>
                                                                    <th>HSN No.</th>
                                                                    <th>Vendor Remark</th>
                                                                </tr>
                                                </thead>
                                                <tbody>
                                                         
                                                    <c:forEach var="serviceVendorTenderBidItem1" items="${serviceVendorTenderBidItem11_2}" varStatus="status">
                                                        <tr>
                                                            <td>${serviceVendorTenderBidItem1.srNo}</td>
                                                            <td>${serviceVendorTenderBidItem1.itemDesc}</td>
                                                            <td>${serviceVendorTenderBidItem1.uom}</td>
                                                            <td>${serviceVendorTenderBidItem1.quantity}</td>
                                                            <td>${serviceVendorTenderBidItem1.rate}</td>
                                                            <td>${serviceVendorTenderBidItem1.netRate}</td>
                                                            <td>${serviceVendorTenderBidItem1.hsnNo}</td>
                                                            <td>${serviceVendorTenderBidItem1.vendorRemark}</td>
                                                        </tr>
                                                        </c:forEach>
                                                </tbody>
                                            </table>
                                                
                                                  <c:if test="${selectCommon1 == 1}">
                                        Select Common Tax 
                                        <hr>
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
                                                                <c:if test="${discountType2 == 0}">
                                                                    (%)
                                                                </c:if>
                                                                <c:if test="${discountType2 == 1}">
                                                                    Value
                                                                </c:if>
                                                            </td>
                                                            <td>${discountValue2}</td>
                                                            <td>${discountValueFinal2}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Packing</td>
                                                            <td>
                                                                <c:if test="${packingType2 == 0}">
                                                                    (%)
                                                                </c:if>
                                                                <c:if test="${packingType2 == 1}">
                                                                    Value
                                                                </c:if>
                                                            </td>
                                                            <td>${packingValue2}</td>
                                                            <td>${packingValueFinal2}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Freight</td>
                                                            <td>
                                                                <c:if test="${freightType2 == 0}">
                                                                    (%)
                                                                </c:if>
                                                                <c:if test="${freightType2 == 1}">
                                                                    Value
                                                                </c:if>
                                                            </td>
                                                            <td>${freightValue2}</td>
                                                            <td>${freightValueFinal2}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Errection</td>
                                                            <td>
                                                                Value
                                                            </td>
                                                            <td>${errectionValue2}</td>
                                                            <td>${errectionValueFinal2}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Other Charges</td>
                                                            <td>
                                                                Value
                                                            </td>
                                                            <td>${chargesValue2}</td>
                                                            <td>${chargesValueFinal2}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>IGST</td>
                                                            <td>
                                                                (%)
                                                            </td>
                                                            <td>${igstValue2}</td>
                                                            <td>${igstValueFinal2}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>CGST</td>
                                                            <td>
                                                                (%)
                                                            </td>
                                                            <td>${cgstValue2}</td>
                                                            <td>${cgstValueFinal2}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>SGST</td>
                                                            <td>
                                                                (%)
                                                            </td>
                                                            <td>${sgstValue2}</td>
                                                            <td>${sgstValueFinal2}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Insurance</td>
                                                            <td>
                                                                (%)
                                                            </td>
                                                            <td>${insuranceValue2}</td>
                                                            <td>${insuranceValueFinal2}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Total Amount</td>
                                                            <td>
                                                                
                                                            </td>
                                                            <td></td>
                                                            <td>${grandTotal2}</td>
                                                        </tr>
                                                </tbody>
                                            </table>
                                        </c:if>
                                        <c:if test="${(fileDetail.taxReq == 'tax_apply_service1' && fileDetail.serType == 'Service1') || fileDetail.serType == 'Service5'}">
                                                <c:if test="${selectCommon2 == 0}">
                                        Select Individual Tax 
                                        <hr>
                                            <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                <thead>
                                                                <tr>
                                                                    <th>Type</th>
                                                                    <th>Amount</th>
                                                                </tr>
                                                </thead>
                                                <tbody>
                                                        <tr>
                                                            <td>Discount</td>
                                                            <td>${discountValueFinal2}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Packing</td>
                                                            <td>${packingValueFinal2}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Freight</td>
                                                            <td>${freightValueFinal2}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Errection</td>
                                                            <td>${errectionValueFinal2}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Other Charges</td>
                                                            <td>${chargesValueFinal2}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>IGST</td>
                                                            <td>${igstValueFinal2}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>CGST</td>
                                                            <td>${cgstValueFinal2}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>SGST</td>
                                                            <td>${sgstValueFinal2}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Insurance</td>
                                                            <td>${insuranceValueFinal2}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Total Amount</td>
                                                            <td>${grandTotal2}</td>
                                                        </tr>
                                                </tbody>
                                            </table>
                                                        
                                            Individual Item Details
                                            <hr>
                                            
                                            <c:forEach var="vbi" items="${vbi2}" varStatus="status">
                                                <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                <thead>
                                                                <tr>
                                                                    <th>Sr No.</th>
                                                                    <th>Item Code</th>
                                                                    <th>Item Detail</th>
                                                                    <th>UOM</th>
                                                                    <th>Remark</th>
                                                                    <th>Quantity</th>
                                                                    <th>Unit Rate</th>
                                                                    <th>Amount</th>
                                                                    <th>HSN No.</th>
                                                                    <th>Vendor Remark</th>
                                                                </tr>
                                                </thead>
                                                <tbody>
                                                         
                                                        <tr>
                                                            <td> ${status.count}</td>
                                                            <td>${vbi.itemCode}</td>
                                                            <td>${vbi.itemDesciption}</td>
                                                            <td>${vbi.uom}</td>
                                                            <td>${vbi.remark}</td>
                                                            <td>${vbi.qty}</td>
                                                            <td>${vbi.rate}</td>
                                                            <td>${vbi.individualNetTotal}</td>
                                                            <td>${vbi.hsnNo}</td>
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
                                                            <td>Freight</td>
                                                            <td>
                                                                <c:if test="${vbi.individualFreightType == 0}">
                                                                    (%)
                                                                </c:if>
                                                                <c:if test="${vbi.individualFreightType == 1}">
                                                                    Value
                                                                </c:if>
                                                            </td>
                                                            <td>${vbi.individualFreightValue}</td>
                                                            <td>${vbi.individualFreightValueFinal}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Errection</td>
                                                            <td>
                                                                Value
                                                            </td>
                                                            <td>${vbi.individualErrectionValue}</td>
                                                            <td>${vbi.individualErrectionValueFinal}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Other Charges</td>
                                                            <td>
                                                                Value
                                                            </td>
                                                            <td>${vbi.individualChargesValue}</td>
                                                            <td>${vbi.individualChargesValueFinal}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>IGST</td>
                                                            <td>
                                                                (%)
                                                            </td>
                                                            <td>${vbi.individualIgstValue}</td>
                                                            <td>${vbi.individualIgstValueFinal}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>CGST</td>
                                                            <td>
                                                                (%)
                                                            </td>
                                                            <td>${vbi.individualCgstValue}</td>
                                                            <td>${vbi.individualCgstValueFinal}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>SGST</td>
                                                            <td>
                                                                (%)
                                                            </td>
                                                            <td>${vbi.individualSgstValue}</td>
                                                            <td>${vbi.individualSgstValueFinal}</td>
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
                                        </c:if>
                                            </c:if>
                                            <c:if test="${fileDetail.serType == 'Service2'}">
                                                
                                                
                                                <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    
                                                    <c:forEach var="serviceDetail" items="${serviceDetail21_2}" varStatus="status">
                                                                            <c:if test="${status.count == 1}">
                                                                                <thead>
                                                                                    <tr>
                                                                                        <th>${serviceDetail.srNo}</th>
                                                                                        <th>${serviceDetail.itemDesc}</th>
                                                                                                    <c:if test="${serviceDetail.onlyBearing1 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing1}</th>
                                                                                                        <c:set var = "i1" value="1"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing2 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing2}</th>
                                                                                                        <c:set var = "i1" value="2"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing3 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing3}</th>
                                                                                                        <c:set var = "i1" value="3"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing4 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing4}</th>
                                                                                                        <c:set var = "i1" value="4"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing5 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing5}</th>
                                                                                                        <c:set var = "i1" value="5"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing6 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing6}</th>
                                                                                                        <c:set var = "i1" value="6"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing7 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing7}</th>
                                                                                                        <c:set var = "i1" value="7"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing8 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing8}</th>
                                                                                                        <c:set var = "i1" value="8"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing9 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing9}</th>
                                                                                                        <c:set var = "i1" value="9"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing10 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing10}</th>
                                                                                                        <c:set var = "i1" value="10"/>
                                                                                                    </c:if>
                                                                                        
                                                                                    </tr>
                                                                                </thead>

                                                                                <tbody>
                                                                            </c:if>
                                                                        </c:forEach>
                                                    <tbody>
                                                         
                                                        <c:forEach var="serviceVendorTenderBidItem2" items="${serviceVendorTenderBidItem21_2}" varStatus="status">
                                                            <tr>
                                                                <td>${serviceVendorTenderBidItem2.srNo}</td>
                                                                <td>${serviceVendorTenderBidItem2.itemDesc}</td>
                                                                <c:if test="${i1 >= 1}">
                                                                    <td>${serviceVendorTenderBidItem2.onlyBearing1}</td>
                                                                </c:if>
                                                                <c:if test="${i1 >= 2}">
                                                                    <td>${serviceVendorTenderBidItem2.onlyBearing2}</td>
                                                                </c:if>
                                                                <c:if test="${i1 >= 3}">
                                                                    <td>${serviceVendorTenderBidItem2.onlyBearing3}</td>
                                                                </c:if>
                                                                <c:if test="${i1 >= 4}">
                                                                    <td>${serviceVendorTenderBidItem2.onlyBearing4}</td>
                                                                </c:if>
                                                                <c:if test="${i1 >= 5}">
                                                                    <td>${serviceVendorTenderBidItem2.onlyBearing5}</td>
                                                                </c:if>
                                                                <c:if test="${i1 >= 6}">
                                                                    <td>${serviceVendorTenderBidItem2.onlyBearing6}</td>
                                                                </c:if>
                                                                <c:if test="${i1 >= 7}">
                                                                    <td>${serviceVendorTenderBidItem2.onlyBearing7}</td>
                                                                </c:if>
                                                                <c:if test="${i1 >= 8}">
                                                                    <td>${serviceVendorTenderBidItem2.onlyBearing8}</td>
                                                                </c:if>
                                                                <c:if test="${i1 >= 9}">
                                                                    <td>${serviceVendorTenderBidItem2.onlyBearing9}</td>
                                                                </c:if>
                                                                <c:if test="${i1 >= 10}">
                                                                    <td>${serviceVendorTenderBidItem2.onlyBearing10}</td>
                                                                </c:if>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                 </table>
                                                
                                                
                                                
                                            </c:if>
                                            <c:if test="${fileDetail.serType == 'Service3'}">
                                                <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <thead>
                                                                <tr>
                                                                    <th>Sr No.</th>
                                                                    <th>Particular</th>
                                                                    <th>Scheduled Amount</th>
                                                                    <th>Percent</th>
                                                                    <th>Percent Rate</th>
                                                                    <th>Amount Total</th>
                                                                    
                                                                </tr>
                                                    </thead>
                                                    <tbody>
                                                         
                                                        <c:forEach var="serviceVendorTenderBidItem3" items="${serviceVendorTenderBidItem31_2}" varStatus="status">
                                                            <tr>
                                                                <td>${serviceVendorTenderBidItem3.srNo}</td>
                                                                <td>${serviceVendorTenderBidItem3.particular}</td>
                                                                <td>${serviceVendorTenderBidItem3.scheduledAmount}</td>
                                                                <td>${serviceVendorTenderBidItem3.percent}</td>
                                                                <td>${serviceVendorTenderBidItem3.percentRate}</td>
                                                                <td>${serviceVendorTenderBidItem3.amountTotal}</td>
                                                            
                                                            </tr>
                                                        </c:forEach>
                                                            <tr>
                                                                <td>Total</td>
                                                                <td></td>
                                                                <td></td>
                                                                
                                                                <td></td>
                                                                <td></td>
                                                                <td>${item_total1_2}</td>
                                                            </tr>
                                                    </tbody>
                                                 </table>
                                            </c:if>
                                            <c:if test="${fileDetail.serType == 'Service4'}">
                                                            
                                            </c:if>
                                            <c:if test="${fileDetail.serType == 'Service6'}">
                                                <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <thead>
                                                                <tr>
                                                                    <th>Sr No.</th>
                                                                    <th>PC Type</th>
                                                                    <th>Item Description</th>
                                                                    <th>UOM</th>
                                                                    <th>Quantity</th>
                                                                    <th>AMC Required Days</th>
                                                                    <th>Rate</th>
                                                                    <th>Amount Total</th>
                                                                </tr>
                                                    </thead>
                                                    <tbody>
                                                         
                                                        <c:forEach var="serviceVendorTenderBidItem6" items="${serviceVendorTenderBidItem61_2}" varStatus="status">
                                                            <tr>
                                                                <td>${serviceVendorTenderBidItem6.srNo}</td>
                                                                <td>${serviceVendorTenderBidItem6.pcType}</td>
                                                                <td>${serviceVendorTenderBidItem6.itemDesc}</td>
                                                                <td>${serviceVendorTenderBidItem6.uom}</td>
                                                                <td>${serviceVendorTenderBidItem6.quantity}</td>
                                                                <td>${serviceVendorTenderBidItem6.amcRequiredays}</td>
                                                                <td>${serviceVendorTenderBidItem6.rate}</td>
                                                                <td>${serviceVendorTenderBidItem6.itemTotal}</td>
                                                            </tr>
                                                        </c:forEach>
                                                            <tr>
                                                                <td>Total</td>
                                                                <td></td>
                                                                <td></td>
                                                                <td></td>
                                                                <td></td>
                                                                <td></td>
                                                                <td></td>
                                                                <td>${item_total1_2}</td>
                                                            </tr>
                                                    </tbody>
                                                 </table>            
                                            </c:if>
                                        </c:if>    
                                            
                                            
                                            
                                            
                                            
                                            
                                            <c:if test="${status1.count == '3'}">
                                            <c:if test="${fileDetail.serType == 'Service1' || fileDetail.serType == 'Service5'}">
                                                <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                <thead>
                                                                <tr>
                                                                    <th>Sr No.</th>
                                                                    <th>Item Description</th>
                                                                    <th>UOM</th>
                                                                    <th>Quantity</th>
                                                                    <th>Unit Rate</th>
                                                                    <th>Amount</th>
                                                                    <th>HSN No.</th>
                                                                    <th>Vendor Remark</th>
                                                                </tr>
                                                </thead>
                                                <tbody>
                                                         
                                                    <c:forEach var="serviceVendorTenderBidItem1" items="${serviceVendorTenderBidItem11_3}" varStatus="status">
                                                        <tr>
                                                            <td>${serviceVendorTenderBidItem1.srNo}</td>
                                                            <td>${serviceVendorTenderBidItem1.itemDesc}</td>
                                                            <td>${serviceVendorTenderBidItem1.uom}</td>
                                                            <td>${serviceVendorTenderBidItem1.quantity}</td>
                                                            <td>${serviceVendorTenderBidItem1.rate}</td>
                                                            <td>${serviceVendorTenderBidItem1.netRate}</td>
                                                            <td>${serviceVendorTenderBidItem1.hsnNo}</td>
                                                            <td>${serviceVendorTenderBidItem1.vendorRemark}</td>
                                                        </tr>
                                                        </c:forEach>
                                                </tbody>
                                            </table>
                                                
                                                  <c:if test="${selectCommon1 == 1}">
                                        Select Common Tax 
                                        <hr>
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
                                                                <c:if test="${discountType3 == 0}">
                                                                    (%)
                                                                </c:if>
                                                                <c:if test="${discountType3 == 1}">
                                                                    Value
                                                                </c:if>
                                                            </td>
                                                            <td>${discountValue3}</td>
                                                            <td>${discountValueFinal3}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Packing</td>
                                                            <td>
                                                                <c:if test="${packingType3 == 0}">
                                                                    (%)
                                                                </c:if>
                                                                <c:if test="${packingType3 == 1}">
                                                                    Value
                                                                </c:if>
                                                            </td>
                                                            <td>${packingValue3}</td>
                                                            <td>${packingValueFinal3}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Freight</td>
                                                            <td>
                                                                <c:if test="${freightType3 == 0}">
                                                                    (%)
                                                                </c:if>
                                                                <c:if test="${freightType3 == 1}">
                                                                    Value
                                                                </c:if>
                                                            </td>
                                                            <td>${freightValue3}</td>
                                                            <td>${freightValueFinal3}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Errection</td>
                                                            <td>
                                                                Value
                                                            </td>
                                                            <td>${errectionValue3}</td>
                                                            <td>${errectionValueFinal3}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Other Charges</td>
                                                            <td>
                                                                Value
                                                            </td>
                                                            <td>${chargesValue3}</td>
                                                            <td>${chargesValueFinal3}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>IGST</td>
                                                            <td>
                                                                (%)
                                                            </td>
                                                            <td>${igstValue3}</td>
                                                            <td>${igstValueFinal3}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>CGST</td>
                                                            <td>
                                                                (%)
                                                            </td>
                                                            <td>${cgstValue3}</td>
                                                            <td>${cgstValueFinal3}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>SGST</td>
                                                            <td>
                                                                (%)
                                                            </td>
                                                            <td>${sgstValue3}</td>
                                                            <td>${sgstValueFinal3}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Insurance</td>
                                                            <td>
                                                                (%)
                                                            </td>
                                                            <td>${insuranceValue3}</td>
                                                            <td>${insuranceValueFinal3}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Total Amount</td>
                                                            <td>
                                                                
                                                            </td>
                                                            <td></td>
                                                            <td>${grandTotal3}</td>
                                                        </tr>
                                                </tbody>
                                            </table>
                                        </c:if>
                                        <c:if test="${(fileDetail.taxReq == 'tax_apply_service1' && fileDetail.serType == 'Service1') || fileDetail.serType == 'Service5'}">
                                                <c:if test="${selectCommon3 == 0}">
                                        Select Individual Tax 
                                        <hr>
                                            <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                <thead>
                                                                <tr>
                                                                    <th>Type</th>
                                                                    <th>Amount</th>
                                                                </tr>
                                                </thead>
                                                <tbody>
                                                        <tr>
                                                            <td>Discount</td>
                                                            <td>${discountValueFinal3}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Packing</td>
                                                            <td>${packingValueFinal3}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Freight</td>
                                                            <td>${freightValueFinal3}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Errection</td>
                                                            <td>${errectionValueFinal3}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Other Charges</td>
                                                            <td>${chargesValueFinal3}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>IGST</td>
                                                            <td>${igstValueFinal3}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>CGST</td>
                                                            <td>${cgstValueFinal3}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>SGST</td>
                                                            <td>${sgstValueFinal3}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Insurance</td>
                                                            <td>${insuranceValueFinal3}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Total Amount</td>
                                                            <td>${grandTotal3}</td>
                                                        </tr>
                                                </tbody>
                                            </table>
                                                        
                                            Individual Item Details
                                            <hr>
                                            
                                            <c:forEach var="vbi" items="${vbi2}" varStatus="status">
                                                <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                <thead>
                                                                <tr>
                                                                    <th>Sr No.</th>
                                                                    <th>Item Code</th>
                                                                    <th>Item Detail</th>
                                                                    <th>UOM</th>
                                                                    <th>Remark</th>
                                                                    <th>Quantity</th>
                                                                    <th>Unit Rate</th>
                                                                    <th>Amount</th>
                                                                    <th>HSN No.</th>
                                                                    <th>Vendor Remark</th>
                                                                </tr>
                                                </thead>
                                                <tbody>
                                                         
                                                        <tr>
                                                            <td> ${status.count}</td>
                                                            <td>${vbi.itemCode}</td>
                                                            <td>${vbi.itemDesciption}</td>
                                                            <td>${vbi.uom}</td>
                                                            <td>${vbi.remark}</td>
                                                            <td>${vbi.qty}</td>
                                                            <td>${vbi.rate}</td>
                                                            <td>${vbi.individualNetTotal}</td>
                                                            <td>${vbi.hsnNo}</td>
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
                                                            <td>Freight</td>
                                                            <td>
                                                                <c:if test="${vbi.individualFreightType == 0}">
                                                                    (%)
                                                                </c:if>
                                                                <c:if test="${vbi.individualFreightType == 1}">
                                                                    Value
                                                                </c:if>
                                                            </td>
                                                            <td>${vbi.individualFreightValue}</td>
                                                            <td>${vbi.individualFreightValueFinal}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Errection</td>
                                                            <td>
                                                                Value
                                                            </td>
                                                            <td>${vbi.individualErrectionValue}</td>
                                                            <td>${vbi.individualErrectionValueFinal}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Other Charges</td>
                                                            <td>
                                                                Value
                                                            </td>
                                                            <td>${vbi.individualChargesValue}</td>
                                                            <td>${vbi.individualChargesValueFinal}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>IGST</td>
                                                            <td>
                                                                (%)
                                                            </td>
                                                            <td>${vbi.individualIgstValue}</td>
                                                            <td>${vbi.individualIgstValueFinal}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>CGST</td>
                                                            <td>
                                                                (%)
                                                            </td>
                                                            <td>${vbi.individualCgstValue}</td>
                                                            <td>${vbi.individualCgstValueFinal}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>SGST</td>
                                                            <td>
                                                                (%)
                                                            </td>
                                                            <td>${vbi.individualSgstValue}</td>
                                                            <td>${vbi.individualSgstValueFinal}</td>
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
                                        </c:if>
                                            </c:if>
                                            <c:if test="${fileDetail.serType == 'Service2'}">
                                                            <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    
                                                    <c:forEach var="serviceDetail" items="${serviceDetail21_3}" varStatus="status">
                                                                            <c:if test="${status.count == 1}">
                                                                                <thead>
                                                                                    <tr>
                                                                                        <th>${serviceDetail.srNo}</th>
                                                                                        <th>${serviceDetail.itemDesc}</th>
                                                                                                    <c:if test="${serviceDetail.onlyBearing1 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing1}</th>
                                                                                                        <c:set var = "i1" value="1"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing2 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing2}</th>
                                                                                                        <c:set var = "i1" value="2"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing3 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing3}</th>
                                                                                                        <c:set var = "i1" value="3"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing4 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing4}</th>
                                                                                                        <c:set var = "i1" value="4"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing5 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing5}</th>
                                                                                                        <c:set var = "i1" value="5"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing6 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing6}</th>
                                                                                                        <c:set var = "i1" value="6"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing7 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing7}</th>
                                                                                                        <c:set var = "i1" value="7"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing8 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing8}</th>
                                                                                                        <c:set var = "i1" value="8"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing9 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing9}</th>
                                                                                                        <c:set var = "i1" value="9"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing10 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing10}</th>
                                                                                                        <c:set var = "i1" value="10"/>
                                                                                                    </c:if>
                                                                                        
                                                                                    </tr>
                                                                                </thead>

                                                                                <tbody>
                                                                            </c:if>
                                                                        </c:forEach>
                                                    <tbody>
                                                         
                                                        <c:forEach var="serviceVendorTenderBidItem2" items="${serviceVendorTenderBidItem21_3}" varStatus="status">
                                                            <tr>
                                                                <td>${serviceVendorTenderBidItem2.srNo}</td>
                                                                <td>${serviceVendorTenderBidItem2.itemDesc}</td>
                                                                <c:if test="${i1 >= 1}">
                                                                    <td>${serviceVendorTenderBidItem2.onlyBearing1}</td>
                                                                </c:if>
                                                                <c:if test="${i1 >= 2}">
                                                                    <td>${serviceVendorTenderBidItem2.onlyBearing2}</td>
                                                                </c:if>
                                                                <c:if test="${i1 >= 3}">
                                                                    <td>${serviceVendorTenderBidItem2.onlyBearing3}</td>
                                                                </c:if>
                                                                <c:if test="${i1 >= 4}">
                                                                    <td>${serviceVendorTenderBidItem2.onlyBearing4}</td>
                                                                </c:if>
                                                                <c:if test="${i1 >= 5}">
                                                                    <td>${serviceVendorTenderBidItem2.onlyBearing5}</td>
                                                                </c:if>
                                                                <c:if test="${i1 >= 6}">
                                                                    <td>${serviceVendorTenderBidItem2.onlyBearing6}</td>
                                                                </c:if>
                                                                <c:if test="${i1 >= 7}">
                                                                    <td>${serviceVendorTenderBidItem2.onlyBearing7}</td>
                                                                </c:if>
                                                                <c:if test="${i1 >= 8}">
                                                                    <td>${serviceVendorTenderBidItem2.onlyBearing8}</td>
                                                                </c:if>
                                                                <c:if test="${i1 >= 9}">
                                                                    <td>${serviceVendorTenderBidItem2.onlyBearing9}</td>
                                                                </c:if>
                                                                <c:if test="${i1 >= 10}">
                                                                    <td>${serviceVendorTenderBidItem2.onlyBearing10}</td>
                                                                </c:if>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                 </table>
                                            </c:if>
                                            <c:if test="${fileDetail.serType == 'Service3'}">
                                                <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <thead>
                                                                <tr>
                                                                    <th>Sr No.</th>
                                                                    <th>Particular</th>
                                                                    <th>Scheduled Amount</th>
                                                                    <th>Percent</th>
                                                                    <th>Percent Rate</th>
                                                                    <th>Amount Total</th>
                                                                    
                                                                </tr>
                                                    </thead>
                                                    <tbody>
                                                         
                                                        <c:forEach var="serviceVendorTenderBidItem3" items="${serviceVendorTenderBidItem31_3}" varStatus="status">
                                                            <tr>
                                                                <td>${serviceVendorTenderBidItem3.srNo}</td>
                                                                <td>${serviceVendorTenderBidItem3.particular}</td>
                                                                <td>${serviceVendorTenderBidItem3.scheduledAmount}</td>
                                                                <td>${serviceVendorTenderBidItem3.percent}</td>
                                                                <td>${serviceVendorTenderBidItem3.percentRate}</td>
                                                                <td>${serviceVendorTenderBidItem3.amountTotal}</td>
                                                            
                                                            </tr>
                                                        </c:forEach>
                                                            
                                                            <tr>
                                                                <td>Total</td>
                                                                <td></td>
                                                                <td></td>
                                                                <td></td>
                                                                <td></td>
                                                                <td>${item_total1_3}</td>
                                                            </tr>
                                                            
                                                    </tbody>
                                                 </table>
                                            </c:if>
                                            <c:if test="${fileDetail.serType == 'Service4'}">
                                                            
                                            </c:if>
                                            <c:if test="${fileDetail.serType == 'Service6'}">
                                                <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <thead>
                                                                <tr>
                                                                    <th>Sr No.</th>
                                                                    <th>PC Type</th>
                                                                    <th>Item Description</th>
                                                                    <th>UOM</th>
                                                                    <th>Quantity</th>
                                                                    <th>AMC Required Days</th>
                                                                    <th>Rate</th>
                                                                    <th>Amount Total</th>
                                                                </tr>
                                                    </thead>
                                                    <tbody>
                                                         
                                                        <c:forEach var="serviceVendorTenderBidItem6" items="${serviceVendorTenderBidItem61_3}" varStatus="status">
                                                            <tr>
                                                                <td>${serviceVendorTenderBidItem6.srNo}</td>
                                                                <td>${serviceVendorTenderBidItem6.pcType}</td>
                                                                <td>${serviceVendorTenderBidItem6.itemDesc}</td>
                                                                <td>${serviceVendorTenderBidItem6.uom}</td>
                                                                <td>${serviceVendorTenderBidItem6.quantity}</td>
                                                                <td>${serviceVendorTenderBidItem6.amcRequiredays}</td>
                                                                <td>${serviceVendorTenderBidItem6.rate}</td>
                                                                <td>${serviceVendorTenderBidItem6.itemTotal}</td>
                                                            </tr>
                                                        </c:forEach>
                                                            <tr>
                                                                <td>Total</td>
                                                                <td></td>
                                                                <td></td>
                                                                <td></td>
                                                                <td></td>
                                                                <td></td>
                                                                <td></td>
                                                                <td>${item_total1_3}</td>
                                                            </tr>
                                                    </tbody>
                                                 </table>            
                                            </c:if>
                                        </c:if>   
                                    </c:forEach>
                                    
                                    
                                          
                                      
                                    
                                            
                                    
                                    Vendor Terms & Condition
                                    <hr>
                                    
                                    <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                        <tr>
                                            <th>Delivery Location</th>
                                            <td>${deliveryLocation}</td>
                                            <th>Delivery Period (In Weeks)</th>
                                            <td>${deliveryPeriod}</td>
                                        </tr>
                                        <tr>
                                            <th>Terms of Payment</th>
                                            <td>${termsOfPayment}</td>
                                            <th>Validity Period</th>
                                            <td>${validityPeriod}</td>
                                        </tr>
                                        <tr>
                                            <th>Mode of Transport</th>
                                            <td>${modeOfTransport}</td>
                                            <th>Inco Terms</th>
                                            <td>${incoTerms}</td>
                                        </tr>
                                        <tr>
                                            <th>Insurance</th>
                                            <td>${insurance}</td>
                                            <th>Freight</th>
                                            <td>${freight}</td>
                                        </tr>
                                    </table>
                                    
                                    
                                    
                                    
                                </form:form>

                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
   
<!--datetime-->
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
    
</html>
