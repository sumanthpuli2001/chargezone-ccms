<%-- 
    Document   : EmployeeCreate
    Created on : Jun 11, 2020, 2:39:39 PM
    Author     : Aman Bahukhandi
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
                                    
                                    
                                    <c:forEach var="vendorTenderBid" items="${vendorTenderBid}" varStatus="statuscount">
                                        
                                    
                                    
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
                                            <td>
                                                    ${offerNo[statuscount-1]}
                                                 
                                            </td>
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
                                            <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                <thead>
                                                                <tr>
                                                                    <th>Sr No.</th>
                                                                    <th>Item Description</th>
                                                                    <th>Item Detail</th>
                                                                    <th>UOM</th>
                                                                    <th>Remark</th>
                                                                    <th>Quantity</th>
                                                                    <th>Unit Rate</th>
                                                                    <th>Amount</th>
                                                                    <th>HSN No.</th>
                                                                    <th>Item Wise Docs</th>
                                                                    <th>Vendor Remark</th>
                                                                    <th>Regret</th>
                                                                </tr>
                                                </thead>
                                                <tbody>
                                                         
                                                    <c:forEach var="vendorTenderBidItem" items="${vendorTenderBidItem}" varStatus="status">
                                                        <tr>
                                                            <td> ${status.count}</td>
                                                            <td>${vendorTenderBidItem.itemCode}</td>
                                                            <td>${vendorTenderBidItem.itemDescription}</td>
                                                            <td>${vendorTenderBidItem.uom}</td>
                                                            <td>${vendorTenderBidItem.remark}</td>
                                                            <td>${vendorTenderBidItem.qty}</td>
                                                            <td>${vendorTenderBidItem.rate}</td>
                                                            <td>${vendorTenderBidItem.netRate}</td>
                                                            <td>${vendorTenderBidItem.hsnNo}</td>
                                                            <td></td>
                                                            <td>${vendorTenderBidItem.vendorRemark}</td>
                                                            <td>${vendorTenderBidItem.itemRegret}</td>
                                                        </tr>
                                                        </c:forEach>
                                                </tbody>
                                            </table>
                                        <c:if test="${selectCommon == 1}">
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
                                                                <c:if test="${freightType == 0}">
                                                                    (%)
                                                                </c:if>
                                                                <c:if test="${freightType == 1}">
                                                                    Value
                                                                </c:if>
                                                            </td>
                                                            <td>${freightValue}</td>
                                                            <td>${freightValueFinal}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Errection</td>
                                                            <td>
                                                                Value
                                                            </td>
                                                            <td>${errectionValue}</td>
                                                            <td>${errectionValueFinal}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Other Charges</td>
                                                            <td>
                                                                Value
                                                            </td>
                                                            <td>${chargesValue}</td>
                                                            <td>${chargesValueFinal}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>IGST</td>
                                                            <td>
                                                                (%)
                                                            </td>
                                                            <td>${igstValue}</td>
                                                            <td>${igstValueFinal}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>CGST</td>
                                                            <td>
                                                                (%)
                                                            </td>
                                                            <td>${cgstValue}</td>
                                                            <td>${cgstValueFinal}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>SGST</td>
                                                            <td>
                                                                (%)
                                                            </td>
                                                            <td>${sgstValue}</td>
                                                            <td>${sgstValueFinal}</td>
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
                                                            <td>${discountValueFinal}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Packing</td>
                                                            <td>${packingValueFinal}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Freight</td>
                                                            <td>${freightValueFinal}</td>
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
                                                            <td>IGST</td>
                                                            <td>${igstValueFinal}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>CGST</td>
                                                            <td>${cgstValueFinal}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>SGST</td>
                                                            <td>${sgstValueFinal}</td>
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
                                                        
                                            Individual Item Details
                                            <hr>
                                            
                                            <c:forEach var="vbi" items="${vbi}" varStatus="status">
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
                                    
                                    </c:forEach>
                                    
                                    
                                </form:form>

                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <body onload="window.print();">
        
    </body>
    
<!--datetime-->
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
    
</html>
