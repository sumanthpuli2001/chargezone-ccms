<%-- 
    Document   : prPrint
    Created on : Mar 12, 2026, 12:56:09 PM
    Author     : Sumanth
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNewPrint.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PR Print</title>

    </head>



    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action=".htm?act=" commandName="departmentMaster" method="post">



                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2  d-print-none">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0  no-print">PR Print</h5>
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
                                    PR View
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <br>
                    <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >

                        <tr class="table-title">
                            <td colspan="10" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                PR Details
                            </td>
                        </tr>

                        <tr style="font-size:11px; height:20px;">
                            <td colspan="2" style="padding:3px 5px;"><strong>PR Reference No:</strong></td>
                            <td colspan="1"style="padding:3px 5px;">${prMaster.prNo}</td>
                            <td colspan="2"  style="padding:3px 5px;"><strong>Item Category:</strong></td>
                            <td colspan="5" style="padding:3px 5px;">${prMaster.type}</td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="2" style="padding:3px 5px;"><strong>PR classification:</strong></td>
                            <td colspan="1"style="padding:3px 5px;">${prMaster.categoryId}</td>
                            <td colspan="2"  style="padding:3px 5px;"><strong>Project Name:</strong></td>
                            <td colspan="5" style="padding:3px 5px;">${prMaster.title}</td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="2" style="padding:3px 5px;"><strong>Project ID:</strong></td>
                            <td colspan="1"style="padding:3px 5px;">${prMaster.projectId}</td>
                            <td colspan="2"  style="padding:3px 5px;"><strong>PR Subject Description:</strong></td>
                            <td colspan="5" style="padding:3px 5px;">${prMaster.workDesc}</td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="2" style="padding:3px 5px;"><strong>Plant:</strong></td>
                            <td colspan="1"style="padding:3px 5px;">${prMaster.plant}</td>
                            <td colspan="2"  style="padding:3px 5px;"><strong>Billing Location:</strong></td>
                            <td colspan="5" style="padding:3px 5px;">${prMaster.billingLocation}</td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="2" style="padding:3px 5px;"><strong>Created By</strong></td>
                            <td colspan="1"style="padding:3px 5px;">${prMaster.contactPerson}</td>
                            <td colspan="2"  style="padding:3px 5px;"><strong>PR Date</strong></td>
                            <td colspan="5" style="padding:3px 5px;">${prMaster.announceDate}</td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="2" style="padding:3px 5px;"><strong>Created Contact Number</strong></td>
                            <td colspan="1"style="padding:3px 5px;">${prMaster.prAdminContactNumber}</td>
                            <td colspan="2"  style="padding:3px 5px;"><strong>Technical Person Name</strong></td>
                            <td colspan="5" style="padding:3px 5px;">${prMaster.technicalContactName}</td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="2" style="padding:3px 5px;"><strong>Technical Person Contact No</strong></td>
                            <td colspan="1"style="padding:3px 5px;">${prMaster.technicalContactNo}</td>
                            <td colspan="2"  style="padding:3px 5px;"><strong>PR Estimate Cost With GST</strong></td>
                            <td colspan="5" style="padding:3px 5px;">${prMaster.value}</td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="2" style="padding:3px 5px;"><strong>Min Quotes Required</strong></td>
                            <td colspan="1"style="padding:3px 5px;">${prMaster.quotes}</td>
                            <td colspan="2"  style="padding:3px 5px;"><strong>Business Type</strong></td>
                            <td colspan="5" style="padding:3px 5px;">${prMaster.businessType}</td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">

                            <td colspan="2"  style="padding:3px 5px;"><strong>Project Type</strong></td>
                            <td colspan="1" style="padding:3px 5px;">${prMaster.projectType}</td>
                            <td colspan="2"  style="padding:3px 5px;"><strong>Name of Location Partner</strong></td>
                            <td colspan="5" style="padding:3px 5px;">${prMaster.nameofLocationPartner}</td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">

                            <td colspan="2"  style="padding:3px 5px;"><strong>Mobile No Location Partner</strong></td>
                            <td colspan="5" style="padding:3px 5px;">${prMaster.mobileNoLocationPartner}</td>
                           
                        </tr>

                    </table>
                    <c:if test="${!empty list6}">
                        <br>
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="10" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                    Site Address
                                </td>
                            </tr>

                            <tr>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 4px;">Sr. No.</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Address1</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Address2</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">City</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">State</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Pincode</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Remarks</th>

                            </tr>

                            <tbody>
                                <c:forEach var="list6" items="${list6}" varStatus="status">
                                    <tr>
                                        <td style="font-size: 9px; padding: 3px 5px;"> ${status.count}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${list6.address1}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${list6.address2}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${list6.city}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${list6.state}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${list6.pincode}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${list6.remark}</td>


                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                    <c:if test="${prMaster.singleQuoteFlag== 1}">
                        <br>
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="10" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                    Single Quote Attachment
                                </td>
                            </tr> 

                            <tr>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 4px;">Attachment</th>                            

                            </tr>
                            <tbody>
                                <tr>
                                    <td style="font-size: 9px; padding: 3px 5px;"> ${prMaster.singleQuoteAttachment}</td>
                                </tr>
                            </tbody>


                        </table>
                    </c:if>
                    <br>
                    <c:if test="${not empty prVendor}">
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="10" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                    Vendor Details
                                </td>
                            </tr>

                            <tr>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 4px;">Vendor Id</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Vendor Name</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Vendor Address</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">E-mail ID</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Mobile No</th>

                            </tr>

                            <tbody>
                                <c:forEach var="prVendor" items="${prVendor}" varStatus="status">
                                    <tr>
                                        <td style="font-size: 9px; padding: 3px 5px;"> ${prVendor.vendorCode}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${prVendor.vendorName}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${prVendor.address}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${prVendor.emailId}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${prVendor.mobileNo}</td>


                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:if>


                    <br>
                    <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                        <tr class="table-title">
                            <c:if test="${prMaster.type == 'Contract Civil'}">
                                <td colspan="16" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                    Civil Details
                                </td>
                            </c:if>
                            <c:if test="${prMaster.type != 'Contract Civil'}">
                                <c:if test="${prMaster.type == 'Service'}">
                                    <td colspan="16" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                        Items Details For Service
                                    </td>
                                </c:if>
                                <c:if test="${prMaster.type != 'Service'}">
                                    <td colspan="16" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                        Item Details 
                                    </td>
                                </c:if>

                            </c:if>
                        </tr>

                        <tr>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 4px;">Sr. No.</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Item Code</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Item Description</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Purpose</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Make</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">UOM</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Qty</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Account Category</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Account Value</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Product Type</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Product Group</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">TAX Code</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Price</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Delivery Date</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Start Date</th>
                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">End Date</th>

                        </tr>
                        <c:set var="count" value="0" scope="page" />
                        <tbody>
                            <c:forEach var="list4" items="${list4}" varStatus="status">
                                <tr style="font-size: 9px; padding: 3px 5px;">
                                    <td>${list4.srNo}</td>
                                    <td>${list4.itemCode}</td>
                                    <td>${list4.itemDescription}</td>
                                    <td>${list4.deliveryScheduleQty}</td>
                                    <td>${list4.deliveryScheduleDate}</td>
                                    <td>${list4.uom}</td>
                                    <td>${list4.qty}</td>
                                    <td>${list4.accountAssigmentCategory}</td>
                                    <td>${list4.accountAssigmentValue}</td>
                                    <td>${list4.productType}</td>
                                    <td>${list4.productGroup}</td>
                                    <td>${list4.taxCode}</td>
                                    <td>${list4.valuationPrice}</td>
                                    <td>${list4.deliveryDate}</td>
                                    <td>${list4.startDate}</td>
                                    <td>${list4.endDate}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <br>
                    <c:if test="${prMaster.type == 'Contract' || prMaster.type == 'Contract Civil' || prMaster.type == 'Contract Electrical'}">

                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <c:if test="${prMaster.type == 'Contract Civil'}">
                                    <td colspan="16" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                        Steel Details
                                    </td>
                                </c:if>
                                <c:if test="${prMaster.type != 'Contract Civil'}"> 
                                    <td colspan="16" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                        Item Details For Service
                                    </td>
                                </c:if>
                            </tr>
                            <c:if test="${not empty list5}">

                                <tr >
                                    <th  style=" vertical-align: middle; font-size: 9px; padding: 3px 4px;">Sr. No.</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Item Code</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Item Description</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Purchase</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Make</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">UOM</th> 
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Qty</th>   
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Account Category</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Account Value</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Product Type</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Product Group</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">TAX Code</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Price</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;"Delivery Date</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Start Date</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">End Date</th>
                                </tr>

                                <c:set var="count" value="0" scope="page" />
                                <tbody>
                                    <c:forEach var="list4" items="${list5}" varStatus="status">
                                        <tr style="font-size: 9px; padding: 3px 5px;">
                                            <td>${list4.srNo}</td>
                                            <td>${list4.itemCode}</td>
                                            <td>${list4.itemDescription}</td>
                                            <td>${list4.deliveryScheduleQty}</td>
                                            <td>${list4.deliveryScheduleDate}</td>
                                            <td>${list4.uom}</td>
                                            <td>${list4.qty}</td>
                                            <td>${list4.accountAssigmentCategory}</td>
                                            <td>${list4.accountAssigmentValue}</td>
                                            <td>${list4.productType}</td>
                                            <td>${list4.productGroup}</td>
                                            <td>${list4.taxCode}</td>
                                            <td>${list4.valuationPrice}</td>
                                            <td>${list4.deliveryDate}</td>
                                            <td>${list4.startDate}</td>
                                            <td>${list4.endDate}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>


                            </c:if>  
                        </table>
                    </c:if>
                    
                    <c:if test="${not empty prDoc}">
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="10" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                    Technical Document 
                                </td>
                            </tr>

                            <tr>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 4px;">Sr. No</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Document</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Attachment Required From Vendor</th>

                            </tr>

                            <tbody>
                                <c:forEach var="prDoc" items="${prDoc}" varStatus="status">
                                    <tr>
                                        <td style="font-size: 9px; padding: 3px 5px;"> ${status.count}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;"><a class="fw-600 text-break gradient-text" href="prMaster.htm?act=downloadPrFile&amp;fileName=${prDoc.docName}&RefNo=${prDoc.refNo}">${prDoc.docName}</a></td>
                                        <td style="font-size: 9px; padding: 3px 5px;">
                                            <c:if test="${prDoc.attachmentRequired == 1}">
                                                Yes
                                            </c:if>
                                            <c:if test="${prDoc.attachmentRequired == 0}">
                                                No
                                            </c:if>
                                        </td>


                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>   
                    </c:if>   
                    <br>
                    <c:if test="${not empty list1}">
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="10" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                    PR Approval  Details 
                                </td>
                            </tr>

                            <tr>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 4px;">PR No.</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Created By</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Created Date</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Created Person Comment </th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Total Approval Level</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Approval Status</th>
                            </tr>

                            <tbody>
                                <c:forEach var="list1" items="${list1}" varStatus="status">
                                <input type="hidden" name="id" id="id" value="${list1.id}">
                                <tr> 
                                    <td style="font-size: 9px; padding: 3px 5px;">${list1.prNo}</td>
                                    <td style="font-size: 9px; padding: 3px 5px;">${list1.userId}</td>
                                    <td style="font-size: 9px; padding: 3px 5px;">${list1.dateTime}</td>
                                    <td style="font-size: 9px; padding: 3px 5px;">${list1.approvalRemark}</td>
                                    <td style="font-size: 9px; padding: 3px 5px;">${list1.totalApproval}</td>
                                    <td style="font-size: 9px; padding: 3px 5px;">
                                        <c:if test="${list1.approvalStatus == 0}">
                                            Pending
                                        </c:if> 
                                        <c:if test="${list1.approvalStatus == 1}">
                                            Approve
                                        </c:if> 
                                        <c:if test="${list1.approvalStatus == 2}">
                                            Rework
                                        </c:if> 
                                        <c:if test="${list1.approvalStatus == 2}">
                                            Reject
                                        </c:if> 

                                    </td>

                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>    
                    </c:if>
                    <br>
                    <c:if test="${not empty approvalList}">
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="10" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                    PR Approval History
                                </td>
                            </tr>


                            <tr>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 4px;">PR No.</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">User</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Date Time</th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Comment </th>
                                <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Approval Status</th>
                            </tr>
                            <tbody>
                                <c:forEach var="approvalList" items="${approvalList}" varStatus="status">
                                    <tr style="font-size: 9px; padding: 3px 5px;"> 
                                        <td>${approvalList.prNo}</td>
                                        <td>${approvalList.userId}</td>
                                        <td>${approvalList.dateTime}</td>
                                        <td>${approvalList.comment}</td>
                                        <td>${approvalList.approvalStatus}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>    
                    </c:if>
                   
                    <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                       <tr class="table-title">
                                <td colspan="10" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                    Remark
                                </td>
                            </tr>
                        <tbody>
                            <c:forEach var="list2" items="${list2}" varStatus="status">
                                <tr style="font-size: 9px; padding: 3px 5px;"> 
                                    <td colspan="16">${list2.workDesc}</td>
                                <tr>
                                </c:forEach>
                    </table>   

                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooterPrint.jsp"%>
</html>

