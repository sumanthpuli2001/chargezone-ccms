<%-- 
    Document   : prSummaryReportViewPrint
    Created on : Mar 10, 2026, 5:02:21 PM
    Author     : Sumanth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNewPrint.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PR Summary Report</title>
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
                            <h5 class="fw-600 mb-0  no-print">PR SUMMARY REPORT</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a href="#" onclick="history.back();" class="btn theme-btn light-btn mr-3 no-print">Back</a>
                            <a onclick="window.print();" class="btn btn theme-btn no-print" style="background-color: #4CAF50; border-color: #4CAF50;" >
                                <i class="fa fa-print"></i>&nbsp;&nbsp;Print
                            </a> 
                        </div>
                    </div> 
                    <br>
                    <table class="table table-bordered printup" id="table_1" style="width: 100%;">
                        <tbody>
                            <tr>
                                <td colspan="4" style="width: 20%; text-align: left; vertical-align: middle; padding: 6px;">
                                    <img src="StorageYard/Images/logoCZ.png" style="max-height: 60px; height: auto; width: auto;">
                                </td>

                                <td colspan="4" style="text-align: center; vertical-align: middle; padding: 6px; font-weight: bold; font-size: 30px !important;">
                                    PR SUMMARY REPORT
                                </td>
                            </tr>
                        </tbody>
                    </table>

                    <br>

                    <table class="flex-table" class="table table-bordered" style="" align="Center"  >
                        <thead style="font-size: 12px;">
                            <tr class="table-title">
                                <th colspan="8" style="text-align: center;"> PR DETAILS</th>
                            </tr> 
                        </thead>
                        <tbody>

                            <tr style="font-size:11px; height:20px;">
                                <td colspan="2" style="padding:3px 5px;"><strong>PR Reference No:</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${prMaster.prNo}</td>
                                <td colspan="2"  style="padding:3px 5px;"><strong>Item Category:</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${prMaster.type}</td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="2" style="padding:3px 5px;"><strong>PR classification:</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${prMaster.categoryId}</td>
                                <td colspan="2"  style="padding:3px 5px;"><strong>Project Name:</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${prMaster.title}</td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="2" style="padding:3px 5px;"><strong>Project ID:</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${prMaster.projectId} 
                                    <span class="text-right" style="display: block;">${!empty prMaster.projectIdUpdateDate ? 'Updated : '.concat(prMaster.projectIdUpdateDate) : ''}</span>
                                </td>
                                
                                <td colspan="2"  style="padding:3px 5px;"><strong>PR Subject Description:</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${prMaster.workDesc}</td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="2" style="padding:3px 5px;"><strong>Plant:</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${prMaster.plant}</td>
                                <td colspan="2"  style="padding:3px 5px;"><strong>Billing Location:</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${prMaster.billingLocation}</td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="2" style="padding:3px 5px;"><strong>Created By</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${prMaster.contactPerson}</td>
                                <td colspan="2"  style="padding:3px 5px;"><strong>PR Date</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${prMaster.announceDate}</td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="2" style="padding:3px 5px;"><strong>Created Contact Number</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${prMaster.prAdminContactNumber}</td>
                                <td colspan="2"  style="padding:3px 5px;"><strong>Technical Person Name</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${prMaster.technicalContactName}</td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="2" style="padding:3px 5px;"><strong>Technical Person Contact No</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${prMaster.technicalContactNo}</td>
                                <td colspan="2"  style="padding:3px 5px;"><strong>PR Estimate Cost With GST</strong></td>
                                <td colspan="2" style="padding:3px 5px;"><span class="currency text-right"  style="display: block;">${prMaster.value}</span>
                                    <span class="text-right" style="display: block;">${!empty prMaster.budgetAmountUpdateDate ? 'Updated : '.concat(prMaster.budgetAmountUpdateDate) : ''}</span>
                                </td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="2" style="padding:3px 5px;"><strong>Min Quotes Required</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${prMaster.quotes}</td>
                                <td colspan="2"  style="padding:3px 5px;"><strong>Business Type</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${prMaster.businessType}</td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="2"  style="padding:3px 5px;"><strong>Project Type</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${prMaster.projectType}</td>
                                <td colspan="2"  style="padding:3px 5px;"><strong>Delivery Period</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${prMaster.deliveryPeriod}</td>
                            </tr>
                        </tbody>
                    </table>
                    <c:if test="${!empty list6}">
                        <br>

                        <table class="flex-table" class="table table-bordered" style="" align="Center"  >
                            <thead style="font-size: 12px;">
                                <tr class="table-title">
                                    <th colspan="7" style="text-align: center;"> SITE ADDRESS</th>
                                </tr>                            
                                <tr>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 4px;">Sr. No.</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Address1</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Address2</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">City</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">State</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">PIN Code</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Remarks</th>

                                </tr>

                            </thead>
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

                    <c:if test="${!empty approvalList}">
                        <BR>

                        <table class="flex-table" class="table table-bordered" style="" align="Center"  >
                            <thead style="font-size: 12px;">
                                <tr class="table-title">
                                    <th colspan="7" style="text-align: center;">PR APPROVAL DETAILS</th>
                                </tr>  

                                <tr>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 4px;">Sr. No.</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">User</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Date Time</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Comment</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Approval Status</th>

                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach var="approvalList" items="${approvalList}" varStatus="status">
                                    <tr>
                                        <td style="font-size: 9px; padding: 3px 5px;"> ${status.count}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${approvalList.userId}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${approvalList.dateTime}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${approvalList.comment}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${approvalList.approvalStatus}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                    <br>
                    <c:if test="${!empty tenderMaster.refNo}">
                        <table class="flex-table" class="table table-bordered" style="" align="Center"  >
                            <thead style="font-size: 12px;">
                                <tr class="table-title">
                                    <th colspan="7" style="text-align: center;"> TENDER ASSIGN DETAILS</th>
                                </tr>                            
                            </thead>

                            <tbody>
                                <tr style="font-size:11px; height:20px; padding: 3px 5px;">
                                    <td colspan="1" style="padding:3px 5px;"><strong>Tender No:</strong></td>
                                    <td colspan="2"style="padding:3px 5px;">${tenderMaster.refNo}</td>
                                    <td colspan="2"  style="padding:3px 5px;"><strong>Tender Assign User:</strong></td>
                                    <td colspan="3" style="padding:3px 5px;">${prMaster.tenderAssignUser}</td>
                                </tr> 
                                <tr style="font-size:11px; height:20px;">
                                    <td colspan="1" style="padding:3px 5px;"><strong>Tender Assign User Date:</strong></td>
                                    <td colspan="2"style="padding:3px 5px;">${prMaster.tenderAssignDate}</td>
                                    <td colspan="2"  style="padding:3px 5px;"><strong>Tender Creator:</strong></td>
                                    <td colspan="3" style="padding:3px 5px;">${prMaster.tenderCreaterUser}</td>
                                </tr> 
                                <tr style="font-size:11px; height:20px;">
                                    <td colspan="1" style="padding:3px 5px;"><strong>Tender Creator Date Time:</strong></td>
                                    <td colspan="6"style="padding:3px 5px;">${prMaster.tenderCreaterDate}</td>
                                </tr> 
                            </tbody>
                        </table>
                        <br>  
                    </c:if>
                    <c:if test="${!empty tenderMaster.refNo}">
                        <table class="flex-table" class="table table-bordered" style="" align="Center"  >
                            <thead style="font-size: 12px;">
                                <tr class="table-title">
                                    <th colspan="7" style="text-align: center;">TENDER DETAILS</th>
                                </tr>                            
                            </thead>

                            <tbody>

                                <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                    <th colspan="1" style="padding: 3px 5px;"><strong>Tender No</strong></th>
                                    <td colspan="2" style="padding: 3px 5px;">${tenderMaster.refNo}</td>

                                    <th colspan="2" style="padding: 3px 5px;"><strong>Tender Phase</strong></th>
                                    <td colspan="3" style="padding: 3px 5px;">${tenderMaster.tenderPhase} Part</td>
                                </tr>

                                <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                    <th colspan="1" style="padding: 3px 5px;"><strong>Project ID</strong></th>
                                    <td colspan="2" style="padding: 3px 5px;">${tenderMaster.projectId}</td>
                                    
                                    <th colspan="2" style="padding: 3px 5px;"><strong>Project Name</strong></th>
                                    <td colspan="3" style="padding: 3px 5px;">${tenderMaster.title}</td>
                                </tr>                                

                                <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                    <th colspan="1" style="padding: 3px 5px;"><strong>Department</strong></th>
                                    <td colspan="2" style="padding: 3px 5px;">${tenderMaster.department}</td>
                                    
                                    <th colspan="2" style="padding: 3px 5px;"><strong>Tender Date</strong></th>
                                    <td colspan="3" style="padding: 3px 5px;">${tender_date}</td>
                                </tr>

                                <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                    <th colspan="1" style="padding: 3px 5px;"><strong>Tender Due Date</strong></th>
                                    <td colspan="2" style="padding: 3px 5px;">${tender_due_date}</td>
                                    
                                    <th colspan="2" style="padding: 3px 5px;"><strong>Mode Of Transport</strong></th>
                                    <td colspan="3" style="padding: 3px 5px;">${tenderMaster.modeOfTransport}</td>
                                </tr>
                                
                                <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                    <td colspan="1"  style="padding:3px 5px;"><strong>Terms Of Payment</strong></td>
                                    <td colspan="5" style="padding:3px 5px;">${tenderMaster.termsOfPayment}</td>
                                    
                                </tr>
                            </tbody>
                        </table>
                        <br> 
                    </c:if>
                    <c:if test="${!empty tenderVendorList}">
                        <table class="flex-table" class="table table-bordered" style="" align="Center"  >
                            <thead style="font-size: 12px;">
                                <tr class="table-title">
                                    <th colspan="7" style="text-align: center;">DETAILS OF INVITED VENDORS</th>
                                </tr>
                                <tr>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 4px;">Sr No.</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 4px;">Vendor Id</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Vendor Name</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Vendor Address</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">E-mail ID</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Mobile No</th>

                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="tenderVendor1" items="${tenderVendorList}" varStatus="status">
                                    <tr>
                                        <td style="font-size: 9px; padding: 3px 5px;"> ${status.count}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;"> ${tenderVendor1.vendorCode}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${tenderVendor1.vendorName}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${tenderVendor1.address}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${tenderVendor1.emailId}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${tenderVendor1.mobileNo}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <br>
                    </c:if>
                    <c:if test="${tenderMaster.tenderPhase == 2 && !empty prMaster.techBidOpenUser}">

                        <table class="flex-table" class="table table-bordered" style="" align="Center"  >
                            <thead style="font-size: 12px;">
                                <tr class="table-title">
                                    <th colspan="7" style="text-align: center;">TECHNICAL BID DETAILS</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr style="font-size:11px; height:20px;">
                                    <td colspan="2" style="padding:3px 5px;"><strong>Technical Bid Open By:</strong></td>
                                    <td colspan="1"style="padding:3px 5px;">${prMaster.techBidOpenUser}</td>
                                    <td colspan="2"  style="padding:3px 5px;"><strong>Technical Bid Open Date:</strong></td>
                                    <td colspan="5" style="padding:3px 5px;">${prMaster.techBidOpenDate}</td>
                                </tr>  
                                <tr style="font-size:11px; height:20px;">
                                    <td colspan="2" style="padding:3px 5px;"><strong>Technical Bid Approve By:</strong></td>
                                    <td colspan="1"style="padding:3px 5px;">${prMaster.techBidApproveUser}</td>
                                    <td colspan="2"  style="padding:3px 5px;"><strong>Technical Bid Approve Date:</strong></td>
                                    <td colspan="5" style="padding:3px 5px;">${prMaster.techBidApproveDate}</td>
                                </tr>  
                            </tbody>
                        </table>
                        <br>
                        <c:if test="${!empty techBidOpenList}">
                            <table class="flex-table" class="table table-bordered" style="" align="Center"  >
                                <thead style="font-size: 12px;">
                                    <tr class="table-title">
                                        <th colspan="7" style="text-align: center;">DETAILS OF QUALIFIED VENDORS FOR TECHNICAL BID</th>
                                    </tr>
                                    <tr>
                                        <th style=" vertical-align: middle; font-size: 9px; padding: 3px 4px;">Vendor Id</th>
                                        <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Vendor Name</th>
                                        <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Vendor Email Id</th>
                                        <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Percentage</th>
                                        <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Approve</th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <c:forEach var="list1" items="${techBidOpenList}" varStatus="status">
                                        <tr>
                                            <td style="font-size: 9px; padding: 3px 5px;"> ${list1[1]}</td>
                                            <td style="font-size: 9px; padding: 3px 5px;">${list1[2]}</td>
                                            <td style="font-size: 9px; padding: 3px 5px;">${list1[5]}</td>
                                            <td style="font-size: 9px; padding: 3px 5px;">${!empty list1[6] ? list1[6] : 'Not Qualified'}</td>
                                            <td style="font-size: 9px; padding: 3px 5px;">${!empty list1[8] ? (list1[8] == 1 ? 'Yes' : 'No') : 'Not Qualified'}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </c:if>    
                        <br>
                    </c:if>    
                    <c:if test="${!empty prMaster.priceBidOpenUser}">
                        <table class="flex-table" class="table table-bordered" style="" align="Center"  >
                            <thead style="font-size: 12px;">
                                <tr class="table-title">
                                    <th colspan="8" style="text-align: center;">PRICE BID DETAILS </th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr style="font-size:11px; height:20px;">
                                    <td colspan="2" style="padding:3px 5px;"><strong>Price Bid Initiate By:</strong></td>
                                    <td colspan="2"style="padding:3px 5px;">${prMaster.priceBidStartUser}</td>
                                    <td colspan="2"  style="padding:3px 5px;"><strong>Price Bid Initiate Date:</strong></td>
                                    <td colspan="2" style="padding:3px 5px;">${prMaster.priceBidStartDate}</td>
                                </tr>  
                                <tr style="font-size:11px; height:20px;">
                                    <td colspan="2" style="padding:3px 5px;"><strong>Price Bid Open By:</strong></td>
                                    <td colspan="2"style="padding:3px 5px;">${prMaster.priceBidOpenUser}</td>
                                    <td colspan="2"  style="padding:3px 5px;"><strong>Price Bid Open Date:</strong></td>
                                    <td colspan="2" style="padding:3px 5px;">${prMaster.priceBidOpenDate}</td>
                                </tr>  
                                <tr style="font-size:11px; height:20px;">
                                    <td colspan="2" style="padding:3px 5px;"><strong>Tender Final Close By:</strong></td>
                                    <td colspan="2"style="padding:3px 5px;">${prMaster.finalCloseUser}</td>
                                    <td colspan="2"  style="padding:3px 5px;"><strong>Tender Final Close Date:</strong></td>
                                    <td colspan="2" style="padding:3px 5px;">${prMaster.finalCloseDate}</td>
                                </tr>  
                            </tbody>
                        </table>
                        <br>
                        <c:if test="${!empty priceBidOpenList}">
                            <table class="flex-table" class="table table-bordered" style="" align="Center"  >
                                <thead style="font-size: 12px;">
                                    <tr class="table-title">
                                        <th colspan="4" style="text-align: center;">DETAILS OF QUALIFIED VENDORS FOR PRICE BID</th>
                                    </tr>

                                    <tr>
                                        <th style=" vertical-align: middle; font-size: 9px; padding: 3px 4px;">Vendor Id</th>
                                        <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Vendor Name</th>
                                        <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Vendor Email Id</th>
                                        <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Price</th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <c:forEach var="list1" items="${priceBidOpenList}" varStatus="status">
                                        <tr>
                                            <td style="font-size: 9px; padding: 3px 5px;"> ${list1[1]}</td>
                                            <td style="font-size: 9px; padding: 3px 5px;">${list1[2]}</td>
                                            <td style="font-size: 9px; padding: 3px 5px;">${list1[5]}</td>
                                            <td style="font-size: 9px; padding: 3px 5px;" class="${!empty list1[7] ? 'currency' : '' }">${!empty list1[7] ? list1[7] : 'Not Qualified'}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <br>
                        </c:if>
                    </c:if>

                    <c:if test="${!empty vendorTenderBidItem1}">
                        <div class="table-responsive">
                            <table class="flex-table" class="table" style="" align="Center"  >
                                <thead style="font-size: 12px;">
                                    <tr class="table-title">
                                        <th colspan="21" style="text-align: center;">PRICE BID COMPARISON WITH REVISE BID FOR ITEMS</th>
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
                        <br>    
                    </c:if>  

                    <c:if test = "${(tenderMaster.type == 'Contract' || tenderMaster.type == 'Contract Civil' || tenderMaster.type == 'Contract Electrical') && !empty vendor_name1 }">    
                        <div class="table-responsive">
                            <table class="flex-table page-break-section" class="table table-bordered" style="" align="Center"  >
                                <thead style="font-size: 12px;">

                                    <tr class="table-title">
                                        <th colspan="21" style="text-align: center;">PRICE BID COMPARISON WITH REVISE BID FOR SERVICE</th>
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
                        <br>
                    </c:if>
                    <c:if test="${!empty vendor_code1}">
                        <div class="table-responsive">
                            <table  class="flex-table page-break-section" class="table table-bordered" style="" align="Center"  >

                                <thead style="font-size: 12px;">

                                    <tr class="table-title">
                                        <th colspan="10" style="text-align: center;">COMMERCIAL SUMMARY COMPARISON</th>
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
                                        <td><fmt:formatNumber value="${((tenderMaster.value - (Total1 + serviceTaxTotal1)) * 100) / tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/>%</td>
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
                                            <td><fmt:formatNumber value="${((tenderMaster.value - (revTotal1 + revserviceTaxTotal1)) * 100) / tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/>%</td>
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
                                            <td><fmt:formatNumber value="${((tenderMaster.value - (Total2 + serviceTaxTotal2)) * 100) / tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/>%</td>
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
                                                <td><fmt:formatNumber value="${((tenderMaster.value - (revTotal2 + revserviceTaxTotal2)) * 100) / tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/>%</td>
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
                                            <td><fmt:formatNumber value="${((tenderMaster.value - (Total3 + serviceTaxTotal3)) * 100) / tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/>%</td>
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
                                                <td><fmt:formatNumber value="${((tenderMaster.value - (revTotal3 + revserviceTaxTotal3)) * 100) / tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/>%</td>
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
                                            <td><fmt:formatNumber value="${((tenderMaster.value - (Total4 + serviceTaxTotal4)) * 100) / tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/>%</td>
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
                                                <td><fmt:formatNumber value="${((tenderMaster.value - (revTotal4 + revserviceTaxTotal4)) * 100) / tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/>%</td>
                                            </tr>
                                        </c:if>
                                    </c:if>
                                </tbody>
                            </table>
                        </div>
                        <br>
                    </c:if>

                    <c:if test="${!empty vendorTermsCondition1}">
                        <div class="table-responsive">
                            <table class="flex-table page-break-section" class="table table-bordered" style="" align="Center"  >

                                <thead style="font-size: 12px;">

                                    <tr class="table-title">
                                        <th colspan="19" style="text-align: center;">TERMS & CONDITION COMPARISON</th>
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
                    </c:if>
                    <c:if test="${!empty tenderPriceApproval5.userId}">
                        <table class="flex-table" class="table table-bordered" style="" align="Center"  >
                            <thead style="font-size: 12px;">
                                <tr class="table-title">
                                    <th colspan="12" style="text-align: center;">MAN APPROVAL DETAILS</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr style="font-size:11px; height:20px;">
                                    <td colspan="2" style="padding:3px 5px;"><strong>Approval Initiated By:</strong></td>
                                    <td colspan="2" style="padding:3px 5px;">${tenderPriceApproval5.userId}</td>
                                    <td colspan="2" style="padding:3px 5px;"><strong>Approval Initiation Remarks:</strong></td>
                                    <td colspan="2" style="padding:3px 5px;">${tenderPriceApproval5.approvalRemark}</td>
                                    <td colspan="2" style="padding:3px 5px;"><strong>Approval Initiated On:</strong></td>
                                    <td colspan="2"style="padding:3px 5px;">${tenderPriceApproval5.dateTime}</td>
                                </tr>

                                <c:if test="${!empty tenderPriceApproval7 || !empty tenderPriceApproval8}">
                                    <tr style="font-size:11px; height:20px;">
                                        <th colspan="4" style="padding: 3px 4px;">Approved By</th>
                                        <th colspan="4" style="padding: 3px 5px;">Approval Remarks</th>
                                        <th colspan="4" style="padding: 3px 5px;">Approved On</th>
                                    </tr>
                                    <c:forEach var="tenderPriceApproval7" items="${tenderPriceApproval7}" varStatus="status1">
                                        <tr style="font-size:11px; height:20px;">
                                            <td colspan="4"style="padding:3px 5px;">${tenderPriceApproval7.userId}</td>
                                            <td colspan="4"style="padding:3px 5px;">${tenderPriceApproval7.approvalComment}</td>
                                            <td colspan="4"style="padding:3px 5px;">${tenderPriceApproval7.dateTime}</td>
                                        </tr>  
                                    </c:forEach>
                                    <c:forEach var="tenderPriceApproval8" items="${tenderPriceApproval8}" varStatus="status1">
                                        <tr style="font-size:11px; height:20px;">
                                            <td colspan="4"style="padding:3px 5px;">${tenderPriceApproval8.userId}</td>
                                            <td colspan="4"style="padding:3px 5px;">${tenderPriceApproval8.approvalComment}</td>
                                            <td colspan="4"style="padding:3px 5px;">${tenderPriceApproval8.dateTime}</td>
                                        </tr>  
                                    </c:forEach>
                                </c:if>
                            </tbody>
                        </table>
                        <br>
                    </c:if>

                    <c:if test="${!empty poDetails}">
                        <table class="flex-table" class="table table-bordered" style="" align="Center"  >
                            <thead style="font-size: 12px;">
                                <tr class="table-title">
                                    <th colspan="8" style="text-align: center;">PO DETAILS</th>
                                </tr>

                                <tr>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 4px;">PO Number</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">PO Date</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">PO Value</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Vendor Code</th>
                                    <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Vendor Name</th>

                                </tr>

                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${poDetails}" varStatus="status">
                                    <tr>
                                        <td style="font-size: 9px; padding: 3px 5px;"> ${list.poNo}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${list.poDate}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;" class="currency">${list.poValue}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${list.vendorCode}</td>
                                        <td style="font-size: 9px; padding: 3px 5px;">${list.vendorName}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:if>

                </form:form>
            </section>
        </main>
        <script>
          CurrencyHandler.init({ currency: '${prMaster.currency}' });
        </script>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUiComparisonFooterPrint.jsp"%>
</html>
