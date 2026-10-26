<%-- 
    Document   : AcceptanceTenderView
    Created on : 22 Nov, 2024, 9:45:32 AM
    Author     : Bulwark-5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarVendor.jsp"%>
 


    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendor Summary Bid View</title>

        <script language="javascript" type="text/javascript">
            function gettender()
            {

                var t = document.getElementById("refNo").value;
                var tenderPhase = document.getElementById("tenderPhase").value;
                window.location = 'tenderMaster.htm?act=getTender&refNo=' + t + '&tenderPhase=' + tenderPhase;
            }

        </script>

    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Vendor Summary</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Vendor Summary</li>
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
                                    <input type="hidden" name="refNo" value="${refNo}">
                                    <img src="StorageYard/Images/logo.png" style="/* height:50px; *//* padding-bottom: 8px; *//* border-color: white !important; *//* border: 4px !important; */background-color: white;">
                                    <br>
                                    Tender information

                                    <hr>

                                    <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                        <tr>
                                            <th>Tender No.</th>
                                            <td>${refNo}</td>
                                            <th>Project Name</th>
                                            <td>${title}</td>
                                        </tr>

                                        <tr>
                                            <th>Vendor Name</th>
                                            <td>${vendorCode} ${vendorName}</td>
                                            <th></th>
                                            <td> </td>
                                        </tr>
                                        <tr>
                                            <th>Offer No.</th>
                                            <td>${offerNo}</td>
                                            <th>Offer Date</th>
                                            <td>${offerDate}</td>
                                        </tr>
                                        <tr>
                                            <th>Tender Date Time</th>
                                            <td>${announceDate}</td>
                                            <th>Due Date Time</th>
                                            <td>${submitLastdate}</td>
                                        </tr>
                                        <tr>
                                            <th>PR No.</th> 
                                            <td>${tenderMaster.prNo}</td>
                                            <th>Site Address</th> 
                                            <td>
                                                <c:forEach var="MultipleAddress" items="${MultipleAddress}" varStatus="status">
                                                    ${MultipleAddress.address1} ${MultipleAddress.address2} ${MultipleAddress.city} ${MultipleAddress.state} ${MultipleAddress.pincode} <br><br>
                                                </c:forEach>
                                            </td>
                                        </tr>
                                    </table>








                                    Item Details
                                    <hr>
                                    <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                        <thead>
                                            <tr>
                                                <th>Sr No.</th>
                                                <th>Item Code</th>
                                                <th>Item Description</th>
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
                                                <td></td>

                                                <td></td>
                                                <td></td>
                                            </tr>
                                        </tbody>

                                    </table>

                                 
                                    
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
                                  
                                                


                                    <c:if test="${tenderMaster.type == 'Contract'}">        

                                        <div class="pagebreak"> </div>
                                        <style>
                                            @media print {
    .pagebreak {
        clear: both;
        page-break-after: always;
    }
}
                                        </style>
                                        <img src="StorageYard/Images/logo.png" style="/* height:50px; *//* padding-bottom: 8px; *//* border-color: white !important; *//* border: 4px !important; */background-color: white;">
                                    <br>
                                    Tender information

                                    <hr>

                                    <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                        <tr>
                                            <th>Tender No.</th>
                                            <td>${refNo}</td>
                                            <th>Project Name</th>
                                            <td>${title}</td>
                                        </tr>

                                        <tr>

                                            <th>Vendor Name</th>
                                            <td>${vendorCode} ${vendorName}</td>
                                        </tr>
                                        <tr>
                                            <th>Offer No.</th>
                                            <td>${offerNo}</td>
                                            <th>Offer Date</th>
                                            <td>${offerDate}</td>
                                        </tr>
                                        <tr>
                                            <th>Tender Date Time</th>
                                            <td>${announceDate}</td>
                                            <th>Due Date Time</th>
                                            <td>${submitLastdate}</td>
                                        </tr>
                                        <tr>
                                            <td>PR No.</td> 
                                            <td>${tenderMaster.prNo}</td>
                                            <td></td> 
                                            <td></td>
                                        </tr>
                                    </table>
                                            
                                        Item Service Details
                                        <hr>
                                        <table id="table_12" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                            <thead>
                                                <tr>
                                                    <th>Sr No.</th>
                                                    <th>Item Code</th>
                                                    <th>Item Description</th>
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

                                                    <td></td>
                                                </tr>
                                            </tbody>

                                        </table>

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
                                    <BR>
                                    
                                    
                                    Vendor Terms & Condition
                                    <hr>


                                    <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
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
                                    
                                    <div class="form-group">
                                        <div class="col-sm-1"></div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Remark:</label>
                                        </div>
                                        <div class="col-sm-7">
                                            <textarea name="remark" class="form-control"></textarea>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;" formaction="vendor.htm?act=acceptanceTenderSubmit" title="" value="Accept" >
                                            <input type="submit" class="btn btn-primary" style="width: 100px;" formaction="vendor.htm?act=acceptanceTenderReject" title="" value="Reject" >
                                        </div>
                                    </div>



                                </form:form>

                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
     <body >
        
    </body>
    <!--datetime-->
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>

</html>


