
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNewPrint.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tender Information</title>
<!--        <style>
             @media print {
    @page {
        margin: 0;
    }

    body {
        margin: 0;
        padding: 0;
    }
    #table_2 {
        margin-top: -75px;
    }
}
@media print {
    .no-print {
        display: none !important;
    }
}
        </style> -->
    </head>



    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action=".htm?act=" commandName="departmentMaster" method="post">



                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0 no-print">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2  d-print-none">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0  no-print"> ${tenderPhase} Part -${tenderMaster.refNo}</h5>
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
                                    Tender View
                                </td>
                            </tr>
                        </tbody>
                    </table>
<br>
                    <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover " style="" align="Center"  >
                        <tr class="table-title">
                            <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                Tender Details
                            </td>
                        </tr>

                        <tr style="font-size:11px; height:20px;">
                            <td colspan="1" style="padding:3px 5px;"><strong>Item Category:</strong></td>
                            <td colspan="2"style="padding:3px 5px;">${tenderMaster.type}</td>
                            <td colspan="1"  style="padding:3px 5px;"><strong>Tender Reference No:</strong></td>
                            <td colspan="2" style="padding:3px 5px;">${tenderMaster.refNo}</td>
                        </tr>

                        <tr style="font-size:11px; height:20px;">
                            <td colspan="1" style="padding:3px 5px;"><strong>Title:</strong></td>
                            <td colspan="2" style="padding:3px 5px;">${tenderMaster.title}</td>
                            <td colspan="1" style="padding:3px 5px;"><strong>ID:</strong></td>
                            <td colspan="2" style="padding:3px 5px;">${tenderMaster.projectId}</td>
                        </tr>

                        <tr style="font-size:11px; height:20px;">
                            <td colspan="1"  style="padding:3px 5px;"><strong>Tender Value:</strong></td>
                            <td colspan="2"  style="padding:3px 5px;">${tenderMaster.value}</td>
                            <td colspan="1"  style="padding:3px 5px;"><strong>Tender Classification:</strong></td>
                            <td colspan="2"  style="padding:3px 5px;">${tenderMaster.categoryId}</td>
                        </tr>

                        <tr style="font-size:11px; height:20px;">
                            <td colspan="1"  style="padding:3px 5px;"><strong>Tender Fee:</strong></td>
                            <td colspan="2"  style="padding:3px 5px;">${tenderMaster.docCost}</td>
                            <td colspan="1"  style="padding:3px 5px;"><strong>Tender EMD:</strong></td>
                            <td colspan="2"  style="padding:3px 5px;">${tenderMaster.emd}</td>
                        </tr>

                        <tr style="font-size:11px; height:20px;">
                            <td style="padding:3px 5px;"><strong>Tender Location:</strong></td>
                            <td colspan="7" style="padding:3px 5px;">${tenderMaster.location}</td>
                        </tr>

                        <tr style="font-size:11px; height:20px;">
                            <td colspan="1"  style="padding:3px 5px;"><strong>Tender Start Date:</strong></td>
                            <td colspan="2"  style="padding:3px 5px;">${tenderMaster.announceDate}</td>
                            <td colspan="1"  style="padding:3px 5px;"><strong>Tender End Date:</strong></td>
                            <td colspan="2"  style="padding:3px 5px;">${tenderMaster.submitLastdate}</td>
                        </tr>

                        <tr style="font-size:11px;">
                            <td style="padding:3px 5px;"><strong>Tender Subject Description:</strong></td>
                            <td colspan="7" style="padding:3px 5px;">${tenderMaster.workDesc}</td>
                        </tr>

                        <tr style="font-size:11px; height:20px;">
                            <td  colspan="1"  style="padding:3px 5px;"><strong>PR No:</strong></td>
                            <td colspan="2"  style="padding:3px 5px;">${tenderMaster.prNo}</td>
                            <td colspan="1"  style="padding:3px 5px;"><strong>PR Item No:</strong></td>
                            <td colspan="2"  style="padding:3px 5px;">${tenderMaster.prItemNo}</td>
                        </tr>

                        <tr style="font-size:11px; height:20px;">
                            <td colspan="1"  style="padding:3px 5px;"><strong>Created By:</strong></td>
                            <td colspan="2"  style="padding:3px 5px;">${tenderMaster.contactPerson}</td>
                            <td colspan="1"  style="padding:3px 5px;"><strong>Created Contact No:</strong></td>
                            <td colspan="2"  style="padding:3px 5px;">${tenderMaster.tenderAdminContactNumber}</td>
                        </tr>

                        <tr style="font-size:11px; height:20px;">
                            <td colspan="1"  style="padding:3px 5px;"><strong>End User Name:</strong></td>
                            <td colspan="2"  style="padding:3px 5px;">${tenderMaster.endUserName}</td>
                            <td colspan="1"  style="padding:3px 5px;"><strong>End User Number:</strong></td>
                            <td colspan="2"  style="padding:3px 5px;">${tenderMaster.endUserNumber}</td>
                        </tr>                 
                        
                        
                        <tr class="table-title">
                            <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                               Item Details
                            </td>
                        </tr>  
                        
                        <tr>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 4px;  white-space: nowrap;">Sr. No</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Item Code</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Item Description</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Purpose</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">UOM</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Qty</th>
                        </tr>
                        <tbody>
                            <c:forEach var="tenderItemMaster" items="${tenderItemMaster}" varStatus="status">
                                <tr style="" >
                                    <td style="font-size: 9px; padding: 3px 5px;">${status.count}</td> 
                                    <td style="font-size: 9px; padding: 3px 5px;"> ${tenderItemMaster.itemCode}</td> 
                                    <td style="font-size: 9px; padding: 3px 5px;">${tenderItemMaster.itemDescription}</td> 
                                    <td style="font-size: 9px; padding: 3px 5px;">${tenderItemMaster.deliveryScheduleDate}</td> 
                                    <td style="font-size: 9px; padding: 3px 5px;">${tenderItemMaster.uom}</td> 
                                    <td style="font-size: 9px; padding: 3px 5px;">${tenderItemMaster.qty}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                        
                        <c:if test="${not empty tenderServiceItemMaster}">
                            <tr class="table-title">
                                <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                    Item Details For Service
                                </td>
                            </tr>  

                            <tr>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 4px;  white-space: nowrap;">Sr. No</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Item Code</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Item Description</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Purpose</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">UOM</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Qty</th>
                            </tr>
                            
                            <tbody>
                                <c:forEach var="tenderServiceItemMaster" items="${tenderServiceItemMaster}" varStatus="status">
                                    <tr style="" >
                                        <td style="font-size: 9px; padding: 3px 5px;">${status.count}</td> 
                                        <td style="font-size: 9px; padding: 3px 5px;"> ${tenderServiceItemMaster.itemCode}</td> 
                                        <td style="font-size: 9px; padding: 3px 5px;">${tenderServiceItemMaster.itemDescription}</td> 
                                        <td style="font-size: 9px; padding: 3px 5px;">${tenderServiceItemMaster.deliveryScheduleDate}</td> 
                                        <td style="font-size: 9px; padding: 3px 5px;">${tenderServiceItemMaster.uom}</td> 
                                        <td style="font-size: 9px; padding: 3px 5px;">${tenderServiceItemMaster.qty}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </c:if>

                        <c:if test="${not empty generalDocs}">
                            <tr class="table-title">
                                <td colspan="7" style="background-color:#e0e7ff; padding:3px 5px; font-size:11px;">
                                    General Terms & Conditions Attachment
                                </td>
                            </tr>

                            <tbody>
                                <c:forEach var="doc" items="${generalDocs}">
                                    <tr style="font-size:10px;">
                                        <td colspan="7" style="padding:3px 5px;">
                                            <a>${doc.document}</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </c:if>

                        <c:if test="${not empty additionalDocs}">

                            <tr class="table-title">
                                <td colspan="7" style=" background-color:#e0e7ff; padding:3px 5px; font-size: 11px;">
                                 Tender Additional Document Attachment
                                </td>
                            </tr> 
                            <tbody>
                                <c:forEach var="additionalDocs" items="${additionalDocs}" varStatus="status">
                                    <tr style="font-size: 10px; padding: 3px 5px;">
                                        <td colspan="7" style="font-size: 10px; padding: 3px 5px;">
                                            <a> ${additionalDocs.document}</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </c:if>
                                
                        <c:if test="${not empty technicalDocs}">

                            <tr class="table-title">
                                <td colspan="7" style=" background-color:#e0e7ff; padding:3px 5px; font-size: 11px;">
                                 Tender Technical Document Attachment
                                </td>
                            </tr> 
                            <tbody>
                                <c:forEach var="technicalDocs" items="${technicalDocs}" varStatus="status">
                                    <tr style="font-size: 10px; padding: 3px 5px;">
                                        <td colspan="7" style="font-size: 10px; padding: 3px 5px;">
                                            <a  > ${technicalDocs.document}</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                       </c:if>
                            
                        <c:if test="${tenderPhase != '1'}">

                            <tr class="table-title">
                                <td colspan="7" style=" font-size: 11px;padding: 3px 5px;">Technical Detail / Specification Required From Vendor</td>
                            </tr>                                            

                            
                            <tbody>
                                <tr style="font-size: 10px; padding: 3px 5px;">
                                    <td colspan="7" style="font-size: 10px; padding: 3px 5px;">
                                        <span id="requireDocument4">${tenderTechnicalDoc}</span>
                                    </td>
                                </tr>
                            </tbody> 

                        </c:if>

                        <tr>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Tender Remark</strong></td>
                            <td colspan="7" style="font-size: 9px; padding: 3px 4px;"><p class="break-after-80"> ${tenderMaster.tenderRemark}</p></td>
                        </tr>

                        <tr class="table-title">
                            <th colspan="7" style="text-align: center; vertical-align: middle;padding: 3px 4px; background-color: #e0e7ff; font-size: 9px;">Vendor Details</th>
                        </tr>
                        
                        <tr>
                            <th colspan="1"  style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px;">Vendor Code</th>
                            <th colspan="1"  style="text-align: center; vertical-align: middle ; font-size: 9px; padding: 3px 5px;">Vendor Name</th>
                            <th colspan="1"  style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px;">Address</th>
                            <th colspan="2"  style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px;">E-mail ID</th>
                            <th colspan="1"   style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px;">Mobile No</th>
                        </tr>

                        <tbody>
                            <c:forEach var="tenderVendor" items="${tenderVendor}" varStatus="status">
                                <tr style="" >
                                    <td colspan="1"  style="font-size: 9px; padding: 3px 5px;">${tenderVendor.vendorCode}</td> 
                                    <td colspan="1"  style="font-size: 9px; padding: 3px 5px;">${tenderVendor.vendorName}</td> 
                                    <td colspan="1"  style="font-size: 9px; padding: 3px 5px;">${tenderVendor.address}</td> 
                                    <td colspan="2"  style="font-size: 9px; padding: 3px 5px;">${tenderVendor.emailId}
                                        <input type="hidden" class="form-control" name="vendor_code" value="${tenderVendor.vendorCode}">
                                    </td> 
                                    <td colspan="1"   style="font-size: 9px; padding: 3px 5px;">${tenderVendor.mobileNo}</td> 

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooterPrint.jsp"%>
</html>
