<%-- 
    Document   : TechBidPrintVendor
    Created on : Jun 26, 2026, 3:17:08 PM
    Author     : Sumanth
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNewPrint.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendor Technical View</title>
    </head>
    <body>
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNewVendor.jsp"%>
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
                            <h5 class="fw-600 mb-0  no-print">Technical Bid View</h5>
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
                                <td colspan="3" style="height: 40px; text-align: center; vertical-align: middle; border: 1px solid black !important;">
                                    <img src="StorageYard/Images/logo.png" style="max-height: 30px;">
                                </td>

                                <td colspan="4" style="text-align: center; vertical-align: middle; padding: 6px; font-weight: bold; font-size: 16px; border: 1px solid black !important;">
                                    Technical Bid View
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <br>
                    <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                        <tr class="table-title">
                            <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                Tender information
                            </td>
                        </tr>

                        <tr style="font-size:11px; height:20px;">
                            <td colspan="1" style="padding:3px 5px;"><strong>Tender No:</strong></td>
                            <td colspan="2"style="padding:3px 5px;">${refNo}</td>
                            <td colspan="1"  style="padding:3px 5px;"><strong>Project Name:</strong></td>
                            <td colspan="2" style="padding:3px 5px;">${title}</td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="1" style="padding:3px 5px;"><strong>Project ID:</strong></td>
                            <td colspan="2"style="padding:3px 5px;">${tenderMaster.projectId}</td>
                            <td colspan="1"  style="padding:3px 5px;"><strong>Vendor Name</strong></td>
                            <td colspan="2" style="padding:3px 5px;">${vendorCode} ${vendorName}</td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="1" style="padding:3px 5px;"><strong>Tender Location:</strong></td>
                            <td colspan="2"style="padding:3px 5px;">${tenderMaster.location}</td>
                            <td colspan="1"  style="padding:3px 5px;"><strong>Tender Date Time</strong></td>
                            <td colspan="2" style="padding:3px 5px;">${announceDate} </td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="1" style="padding:3px 5px;"><strong>Due Date Time:</strong></td>
                            <td colspan="2"style="padding:3px 5px;">${submitLastdate}</td>
                            <td colspan="1"  style="padding:3px 5px;"><strong>PR No</strong></td>
                            <td colspan="2" style="padding:3px 5px;">${prNo} </td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td style="padding:3px 5px;"><strong>Tender Two Phase Remark</strong></td>
                            <td colspan="7" style="padding:3px 5px;">${technicalRemark}</td>
                        </tr>
                    </table>
                    <br>
                    <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >

                        <tr class="table-title">
                            <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                Tender Contact Person
                            </td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="1" style="padding:3px 5px;"><strong>Created by:</strong></td>
                            <td colspan="2"style="padding:3px 5px;">${contactPerson}</td>
                            <td colspan="1"  style="padding:3px 5px;"><strong>Number</strong></td>
                            <td colspan="2" style="padding:3px 5px;">${tenderAdminContactNumber} </td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="1" style="padding:3px 5px;"><strong>Name of Location Partner</strong></td>
                            <td colspan="2"style="padding:3px 5px;">${prm.nameofLocationPartner}</td>
                            <td colspan="1"  style="padding:3px 5px;"><strong>Mobile No Location Partner</strong></td>
                            <td colspan="2" style="padding:3px 5px;">${prm.mobileNoLocationPartner} </td>
                        </tr>
                    </table>
                    <br>
                    <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                        <tr class="table-title">
                            <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                Vendor Attachment - ${vendorAttachment.size()}
                            </td>
                        </tr>
                        <tr>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 4px; " >Sr. No.</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 4px; " >Attachment</th>

                        </tr>
                        <tbody>
                            <c:forEach var="vendorAttachment" items="${vendorAttachment}" varStatus="status">
                                <tr>
                                    <td style="font-size: 9px; padding: 3px 5px;"> ${status.count}</td>
                                    <td  style="font-size: 9px; padding: 3px 5px;"><a class="fw-600 text-break gradient-text"  href="tenderMaster.htm?act=downloadTenderVendorFile&amp;fileName=${vendorAttachment.attachment}&RefNo=${refNo}&vendor_code=${vendorCode}">${vendorAttachment.attachment}</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <br>
                     <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                        <c:choose>
                            <c:when test="${empty vendorTechnicalBidTech}">
                            </c:when>
                            <c:otherwise>
                                <c:if test="${tenderMaster.type == 'Contract Civil'}">
                                    <tr class="table-title">
                                        <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                            Civil Details
                                        </td>
                                    </tr> 

                                </c:if>
                                <c:if test="${tenderMaster.type != 'Contract Civil'}">
                                    <c:if test="${tenderMaster.type == 'Service'}">
                                        <tr class="table-title">
                                            <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                                Items Details For Service
                                            </td>
                                        </tr> 

                                    </c:if>
                                    <c:if test="${tenderMaster.type != 'Service'}">
                                        <tr class="table-title">
                                            <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                                Item Details
                                            </td>
                                        </tr>

                                    </c:if>
                                </c:if>
                               
                                <tr>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 4px;">Sr. No.</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Item Description</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Item Details</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Attachment Required</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Vendor Response</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Remark</th>
                                </tr>
                                <tbody>
                                    <c:forEach var="vendorTechnicalBidTech" items="${vendorTechnicalBidTech}" varStatus="status">
                                        <tr>
                                            <td style="font-size: 9px; padding: 3px 5px;"> ${status.count}</td>
                                            <td style="font-size: 9px; padding: 3px 5px;">${vendorTechnicalBidTech.description}</td>
                                            <td style="font-size: 9px; padding: 3px 5px;">${vendorTechnicalBidTech.details}</td>
                                            <td style="font-size: 9px; padding: 3px 5px;">${vendorTechnicalBidTech.attachmentRequired}</td>
                                            <td style="font-size: 9px; padding: 3px 5px;">
                                                <c:if test="${vendorTechnicalBidTech.vendorResponse == 0}">
                                                    Yes
                                                </c:if>
                                                <c:if test="${vendorTechnicalBidTech.vendorResponse == 1}">
                                                    No
                                                </c:if>
                                                <c:if test="${vendorTechnicalBidTech.vendorResponse == 2}">
                                                    NA
                                                </c:if>
                                            </td>
                                            <td style="font-size: 9px; padding: 3px 5px;">${vendorTechnicalBidTech.remark}</td>

                                        </tr>
                                    </c:forEach>

                                </tbody>

                            </c:otherwise></c:choose>


                        <c:choose>
                            <c:when test="${empty vendorTechnicalBidTerms}">

                            </c:when>
                            <c:otherwise>
                                <c:if test="${tenderMaster.type == 'Contract' || tenderMaster.type == 'Contract Civil' || tenderMaster.type == 'Contract Electrical'}">

                                    <c:if test="${tenderMaster.type == 'Contract Civil'}">
                                        <tr class="table-title">
                                            <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                                Steel Details
                                            </td>
                                        </tr> 
                                    </c:if>
                                    <c:if test="${tenderMaster.type != 'Contract Civil'}"> 
                                        <tr class="table-title">
                                            <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                                Item Details For Service
                                            </td>
                                        </tr> 

                                    </c:if>


                                </c:if>


                                <tr>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 4px;  white-space: nowrap;">Sr. No.</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Item Description</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Item Details</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Attachment Required</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Vendor Response</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Remark</th>

                                </tr>

                                <tbody>

                                    <c:forEach var="vendorTechnicalBidTerms" items="${vendorTechnicalBidTerms}" varStatus="status">
                                        <tr>
                                            <td style="font-size: 9px; padding: 3px 5px;"> ${status.count}</td>
                                            <td style="font-size: 9px; padding: 3px 5px;">${vendorTechnicalBidTerms.description}</td>
                                            <td style="font-size: 9px; padding: 3px 5px;">${vendorTechnicalBidTerms.details}</td>
                                            <td style="font-size: 9px; padding: 3px 5px;">${vendorTechnicalBidTerms.attachmentRequired}</td>
                                            <td style="font-size: 9px; padding: 3px 5px;">
                                                <c:if test="${vendorTechnicalBidTerms.vendorResponse == 0}">
                                                    Yes
                                                </c:if>
                                                <c:if test="${vendorTechnicalBidTerms.vendorResponse == 1}">
                                                    No
                                                </c:if>
                                                <c:if test="${vendorTechnicalBidTerms.vendorResponse == 2}">
                                                    NA
                                                </c:if>
                                            </td>
                                            <td style="font-size: 9px; padding: 3px 5px;">${vendorTechnicalBidTerms.remark}</td>

                                        </tr>
                                    </c:forEach>
                                </tbody>

                            </c:otherwise></c:choose>
                    </table>
                    <br>
                    <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                    
                            <tr class="table-title">
                                <th colspan="7" style="text-align: center; vertical-align: middle;padding: 3px 4px; background-color: #e0e7ff; font-size: 9px;">Attachment By Vendor</th>
                            </tr>          


                            <tr>
                                <th colspan="1"  style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px;">Sr. No</th>
                                <th colspan="2"  style="text-align: center; vertical-align: middle ; font-size: 9px; padding: 3px 5px;">Item Description</th>
                                <th colspan="1"  style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px;">Vendor Response</th>
                                <th colspan="1"  style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px;">Vendor Remark</th>
                                <th colspan="2"  style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px;">Attachment</th>
                            </tr>

                            <tbody>
                                <c:forEach var="vendorTechnicalBidAttachment" items="${vendorTechnicalBidAttachment}" varStatus="status">
                                    <tr style="">
                                        <td colspan="1"  style="font-size: 9px; padding: 3px 5px;">${status.count}</td> 
                                        <td colspan="2"  style="font-size: 9px; padding: 3px 5px;"><a class="fw-600 text-break gradient-text" href="prMaster.htm?act=downloadPrFile&amp;fileName=${vendorTechnicalBidAttachment.document}&RefNo=${vendorTechnicalBidAttachment.refNo}" style="cursor: pointer;">${vendorTechnicalBidAttachment.document}</a></td> 
                                        <td colspan="1"  style="font-size: 9px; padding: 3px 5px;">${vendorTechnicalBidAttachment.venderResponse == 0 ? 'Yes' : 'No'}</td> 
                                        <td colspan="1"  style="font-size: 9px; padding: 3px 5px;">${vendorTechnicalBidAttachment.remark}</td> 
                                        <td colspan="2"   style="font-size: 9px; padding: 3px 5px;"><a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=downloadTenderVendorFile&amp;fileName=${vendorTechnicalBidAttachment.attachment}&RefNo=${refNo}&vendor_code=${vendorCode}">${vendorTechnicalBidAttachment.attachment}</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>        

                        <tr class="table-title">
                            <th colspan="7" style="text-align: center; vertical-align: middle;padding: 3px 4px; background-color: #e0e7ff; font-size: 9px;">Vendor Remark For Technical
                            </th>
                        </tr>     
                        <tr style="font-size:11px; height:20px;">                            
                            <c:if test="${technicalBidDeviation != ''}">
                                <td colspan="1"  style="padding:3px 5px;"><strong>Deviation</strong></td>
                                <td colspan="6" style="padding:3px 5px;">${technicalBidDeviation}</td>
                            </c:if>
                        </tr>       

                        <tr style="font-size:11px; height:20px;">
                            <td style="padding:3px 5px;"><strong>Technical Bid Remark</strong></td>
                            <td colspan="7" style="padding:3px 5px;">${technicalBidRemark}</td>
                        </tr>      

                        

                    </table>

                </form:form>
            </section>
        </main>
    </body>
    
    <%@include file="/WEB-INF/jsp/Common/NewUIFooterPrint.jsp"%>
</html>
