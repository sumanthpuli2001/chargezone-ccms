<%-- 
    Document   : viewapprovePriceBidPrint
    Created on : Apr 4, 2026, 12:21:08 PM
    Author     : Sumanth
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNewPrint.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tendor Approve Price Bid View</title>
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
                            <h5 class="fw-600 mb-0  no-print">Tendor Approve Price Bid View</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a href="#" onclick="history.back();" class="btn theme-btn light-btn mr-3 no-print">Back</a>
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
                                    Price Bid Approve View
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
                            <td colspan="5" style="padding:3px 5px;">${prMaster.projectType}</td>
                        </tr>
                    </table>
                    <br>
                    <table  class="flex-table " id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                        <tr style="font-size:11px; height:20px;">
                            <th style="padding:3px 5px;">Delivery Period</th>
                            <th style="padding:3px 5px;">Technical committee</th>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td style="padding:3px 5px;">${prMaster.deliveryPeriod}</td>
                            <td style="padding:3px 5px;">${prMaster.technicalCommittee}</td>
                        </tr>
                    </table>
                    <br>
                    <c:if test="${not empty item1}">
                        <c:if test="${prMaster.type == 'Contract Civil'}">
                            <h6 class="fw-200">Civil Details </h5>
                            </c:if>
                            <c:if test="${prMaster.type != 'Contract Civil'}">
                                <c:if test="${prMaster.type == 'Service'}">
                                    <h6 class="fw-200">Items Details For Service </h6>
                                </c:if>
                                <c:if test="${prMaster.type != 'Service'}">
                                    <h6 class="fw-200">Item Details </h6>
                                </c:if>
                            </c:if>
                            <table  class="flex-table " id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >

                                <tr style="font-size:11px; height:20px;">

                                    <th style="padding:3px 5px;">Sr. No.</th>
                                    <th style="padding:3px 5px;">Item Code</th>
                                    <th style="padding:3px 5px;">Item Description</th>
                                    <th style="padding:3px 5px;">Purpose</th>
                                    <th style="padding:3px 5px;">Make</th>
                                    <th style="padding:3px 5px;">UOM</th>
                                    <th style="padding:3px 5px;">Qty</th>
                                    <th style="padding:3px 5px;">Account Category</th>
                                    <th style="padding:3px 5px;">Account Value</th>
                                    <th style="padding:3px 5px;">Product Type</th>
                                    <th style="padding:3px 5px;">Product Group</th>
                                    <th style="padding:3px 5px;">TAX Code</th>
                                    <th style="padding:3px 5px;">Price</th>
                                    <th style="padding:3px 5px;">Delivery Date</th>
                                    <th style="padding:3px 5px;">Start Date</th>
                                    <th style="padding:3px 5px;">End Date</th>
                                </tr>

                                <c:set var="count" value="0" scope="page" />

                                <c:forEach var="list4" items="${item1}" varStatus="status">
                                    <tr style="font-size:11px; height:20px;">

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

                            </table>
                        </c:if>
                        <br>
                        <c:if test="${prMaster.type == 'Contract' || prMaster.type == 'Contract Civil' || prMaster.type == 'Contract Electrical'}">

                            <c:if test="${prMaster.type == 'Contract Civil'}">
                                <h6 class="fw-200">Steel Details </h6>
                            </c:if>
                            <c:if test="${prMaster.type != 'Contract Civil'}"> 
                                <h6 class="fw-200">Item Details For Service</h6>
                            </c:if>
                        </c:if>
                        <c:if test="${not empty item2}">
                            <table  class="flex-table " id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                <tr style="font-size:11px; height:20px;">

                                    <th style="padding:3px 5px;">Sr. No.</th>
                                    <th style="padding:3px 5px;">Item Code</th>
                                    <th style="padding:3px 5px;">Item Description</th>
                                    <th style="padding:3px 5px;">Purpose</th>
                                    <th style="padding:3px 5px;">Make</th>
                                    <th style="padding:3px 5px;">UOM</th>
                                    <th style="padding:3px 5px;">Qty</th>
                                    <th style="padding:3px 5px;">Account Category</th>
                                    <th style="padding:3px 5px;">Account Value</th>
                                    <th style="padding:3px 5px;">Product Type</th>
                                    <th style="padding:3px 5px;">Product Group</th>
                                    <th style="padding:3px 5px;">TAX Code</th>
                                    <th style="padding:3px 5px;">Price</th>
                                    <th style="padding:3px 5px;">Delivery Date</th>
                                    <th style="padding:3px 5px;">Start Date</th>
                                    <th style="padding:3px 5px;">End Date</th>
                                </tr>
                                <c:set var="count" value="0" scope="page" />
                                <tbody>
                                    <c:forEach var="list4" items="${item2}" varStatus="status">
                                        <tr style="font-size:11px; height:20px;">
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
                        </c:if>
                        <br>

                        <table  class="flex-table " id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="10" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                    PR Activity Details
                                </td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <th style="padding:3px 5px;">PR Number</th>
                                <th style="padding:3px 5px;">User Id</th>
                                <th style="padding:3px 5px;">Date Time</th>
                                <th style="padding:3px 5px;">Remark</th>
                                <th style="padding:3px 5px;">Status</th>
                            </tr>
                            <tbody>
                                <tr style="font-size:11px; height:20px;">
                                    <td style="padding:3px 5px;">${prMaster.prNo}</td>
                                    <td style="padding:3px 5px;">${prMaster.contactPerson}</td>
                                    <td style="padding:3px 5px;">${prMaster.announceDate}</td>
                                    <td style="padding:3px 5px;">PR Create</td>
                                    <td style="padding:3px 5px;"></td>
                                </tr>
                                <c:forEach var="approvalList" items="${approvalList}" varStatus="status">
                                    <tr style="font-size:11px; height:20px;">
                                        <td style="padding:3px 5px;">${approvalList.prNo}</td>
                                        <td style="padding:3px 5px;">${approvalList.userId}</td>
                                        <td style="padding:3px 5px;">${approvalList.dateTime}</td>
                                        <td style="padding:3px 5px;">${approvalList.comment}</td>
                                        <td style="padding:3px 5px;">${approvalList.approvalStatus}</td>
                                    </tr>
                                </c:forEach>
                                <tr style="font-size:11px; height:20px;"> 
                                    <td style="padding:3px 5px;">${prMaster.prNo}</td>
                                    <td style="padding:3px 5px;">${prMaster.prAuthorizeUser}</td>
                                    <td style="padding:3px 5px;">${prMaster.prAuthorizeDate}</td>
                                    <td style="padding:3px 5px;">PR Authorize</td>
                                    <td style="padding:3px 5px;"></td>
                                </tr>
                                <c:forEach var="tenderFollowup" items="${tenderFollowup}" varStatus="status">
                                    <tr style="font-size:11px; height:20px;">
                                        <td style="padding:3px 5px;">${tenderFollowup.tenderNo}</td>
                                        <td style="padding:3px 5px;">${tenderFollowup.person}</td>
                                        <td style="padding:3px 5px;">${tenderFollowup.activityDate}</td>
                                        <td style="padding:3px 5px;">${tenderFollowup.activity}</td>
                                        <td style="padding:3px 5px;"></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                        <br>
                        <h6 class="fw-200">TENDER PRICE COMPARISON REPORT</h6> 
                        <table  class="flex-table " id="table_2" class="table table-bordered table-striped table-hover " style="" align="Center"  >

                            <tr class="table-title">
                                <td colspan="7" style="text-align: center; font-size: 11px;padding: 3px 5px;">Tender Details</td>
                            </tr>
                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">

                                <td colspan="1" style="padding: 3px 5px;"><strong>Tender No</strong></td>
                                <td colspan="2" style="padding: 3px 5px;">${tenderMaster.refNo}</td>

                                <td colspan="2" style="padding: 3px 5px;"><strong>Project ID</strong></td>
                                <td colspan="3" style="padding: 3px 5px;">${tenderMaster.projectId}</td>
                            </tr>
                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">

                                <td colspan="2" style="padding: 3px 5px;"><strong>Project Name</strong></td>
                                <td colspan="5" style="padding: 3px 5px;">${tenderMaster.title}</td>
                            </tr>
                        </table>
                        <br> 

                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover " style="" align="Center"  >

                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;"> 
                                <td colspan="3" style="padding: 3px 5px;"><strong>Vendor Code</strong></td>
                                <c:if test="${vendor_code1 != ''}">
                                    <td colspan="2" style="padding: 3px 5px;">${vendor_code1}</td>
                                    <c:if test="${rev_submit_flag1 == '1'}">
                                        <td colspan="2" style="padding: 3px 5px;">${vendor_code1}</td>
                                    </c:if> 
                                </c:if>
                                <c:if test="${vendor_code2 != ''}">
                                    <td colspan="2" style="padding: 3px 5px;">${vendor_code2}</td>
                                    <c:if test="${rev_submit_flag2 == '1'}">
                                        <td colspan="2" style="padding: 3px 5px;">${vendor_code2}</td>
                                    </c:if> 
                                </c:if>
                                <c:if test="${vendor_code3 != ''}">
                                    <td colspan="2" style="padding: 3px 5px;">${vendor_code3}</td>
                                    <c:if test="${rev_submit_flag3 == '1'}">
                                        <td colspan="2" style="padding: 3px 5px;">${vendor_code3}</td>
                                    </c:if> 
                                </c:if>
                                <c:if test="${vendor_code4 != ''}">
                                    <td colspan="2" style="padding: 3px 5px;">${vendor_code4}</td>
                                    <c:if test="${rev_submit_flag4 == '1'}">
                                        <td colspan="2" style="padding: 3px 5px;">${vendor_code4}</td>
                                    </c:if> 
                                </c:if>    
                            </tr>

                            <c:set var="count" value="0" scope="page" />
                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;"> 

                                <td  colspan="3"style="padding: 3px 5px;"><strong>Vendor Name</strong> </td>
                                <c:if test="${vendor_code1 != ''}">
                                    <td colspan="2" style="padding: 3px 5px;">${vendor_name1}</td> <!-- change here to price bid-->
                                    <c:if test="${rev_submit_flag1 == '1'}">
                                        <td colspan="2" style="padding: 3px 5px;">${vendor_name1}</td>
                                    </c:if>
                                </c:if>
                                <c:if test="${vendor_code2 != ''}">
                                    <td colspan="2" style="padding: 3px 5px;">${vendor_name2}</td><!-- change here to price bid-->
                                    <c:if test="${rev_submit_flag2 == '1'}">
                                        <td colspan="2" style="padding: 3px 5px;">${vendor_name2}</td>
                                    </c:if>
                                </c:if>
                                <c:if test="${vendor_code3 != ''}">
                                    <td colspan="2" style="padding: 3px 5px;">${vendor_name3}</td>
                                    <c:if test="${rev_submit_flag3 == '1'}">
                                        <td colspan="2" style="padding: 3px 5px;">${vendor_name3}</td>
                                    </c:if>
                                </c:if>
                                <c:if test="${vendor_code4 != ''}">
                                    <td colspan="2" style="padding: 3px 5px;">${vendor_name4}</td>
                                    <c:if test="${rev_submit_flag4 == '1'}">
                                        <td colspan="2" style="padding: 3px 5px;">${vendor_name4}</td>
                                    </c:if>
                                </c:if>    
                            </tr>

                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;"> 
                                <td  colspan="3"style="padding: 3px 5px;"><strong>Currency Name</strong></td>
                                <c:if test="${vendor_code1 != ''}">
                                    <td colspan="2" style="padding: 3px 5px;">INR</td>
                                    <c:if test="${rev_submit_flag1 == '1'}">
                                        <td colspan="2" style="padding: 3px 5px;">INR</td>
                                    </c:if>
                                </c:if>
                                <c:if test="${vendor_code2 != ''}">
                                    <td colspan="2" style="padding: 3px 5px;">INR</td>
                                    <c:if test="${rev_submit_flag2 == '1'}">
                                        <td colspan="2" style="padding: 3px 5px;">INR</td>
                                    </c:if>
                                </c:if>
                                <c:if test="${vendor_code3 != ''}">
                                    <td colspan="2" style="padding: 3px 5px;">INR</td>
                                    <c:if test="${rev_submit_flag3 == '1'}">
                                        <td colspan="2" style="padding: 3px 5px;">INR</td>
                                    </c:if>
                                </c:if>
                                <c:if test="${vendor_code4 != ''}">
                                    <td colspan="2" style="padding: 3px 5px;">INR</td>
                                    <c:if test="${rev_submit_flag4 == '1'}">
                                        <td colspan="2" style="padding: 3px 5px;">INR</td>
                                    </c:if>
                                </c:if>    
                            </tr>
                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;"> 
                                <td  colspan="3" style="padding: 3px 5px;"><strong>Exchange Rate</strong></td>
                                <c:if test="${vendor_code1 != ''}">
                                    <td colspan="2" style="padding: 3px 5px;">1.00</td>
                                    <c:if test="${rev_submit_flag1 == '1'}">
                                        <td colspan="2" style="padding: 3px 5px;">1.00</td>
                                    </c:if>
                                </c:if>
                                <c:if test="${vendor_code2 != ''}">
                                    <td colspan="2" style="padding: 3px 5px;">1.00</td>
                                    <c:if test="${rev_submit_flag2 == '1'}">
                                        <td colspan="2" style="padding: 3px 5px;">1.00</td>
                                    </c:if>
                                </c:if>
                                <c:if test="${vendor_code3 != ''}">
                                    <td colspan="2" style="padding: 3px 5px;">1.00</td>
                                    <c:if test="${rev_submit_flag3 == '1'}">
                                        <td colspan="2" style="padding: 3px 5px;">1.00</td>
                                    </c:if>
                                </c:if>
                                <c:if test="${vendor_code4 != ''}">
                                    <td colspan="2" style="padding: 3px 5px;">1.00</td>
                                    <c:if test="${rev_submit_flag4 == '1'}">
                                        <td colspan="2" style="padding: 3px 5px;">1.00</td>
                                    </c:if>
                                </c:if>    
                            </tr>
                        </table>
                        <br>    
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover " style="" align="Center"  >

                            <tr class="table-title" style="font-size: 11px; height: 20px; padding: 3px 5px;"> 
                                <th style="padding: 3px 5px;">Sr.</th>
                                <th style="padding: 3px 5px;">Item Code</th>
                                <th style="padding: 3px 5px;">Item Description</th>
                                <th style="padding: 3px 5px;">Quantity</th>
                                <th style="padding: 3px 5px;">UOM</th>
                                    <c:if test="${vendor_code1 != ''}">
                                    <th style="padding: 3px 5px;">Unit Price</th>
                                    <th style="padding: 3px 5px;">Value</th>
                                        <c:if test="${rev_submit_flag1 == '1'}">
                                        <th style="padding: 3px 5px;">Unit Price</th>
                                        <th style="padding: 3px 5px;">Value</th>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                    <th style="padding: 3px 5px;">Unit Price</th>
                                    <th style="padding: 3px 5px;">Value</th>
                                        <c:if test="${rev_submit_flag2 == '1'}">
                                        <th style="padding: 3px 5px;">Unit Price</th>
                                        <th style="padding: 3px 5px;">Value</th>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                    <th style="padding: 3px 5px;">Unit Price</th>
                                    <th style="padding: 3px 5px;">Value</th>
                                        <c:if test="${rev_submit_flag3 == '1'}">
                                        <th style="padding: 3px 5px;">Unit Price</th>
                                        <th style="padding: 3px 5px;">Value</th>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                    <th style="padding: 3px 5px;">Unit Price</th>
                                    <th style="padding: 3px 5px;">Value</th>
                                        <c:if test="${rev_submit_flag4 == '1'}">
                                        <th style="padding: 3px 5px;">Unit Price</th>
                                        <th style="padding: 3px 5px;">Value</th>
                                        </c:if>
                                    </c:if>    
                            </tr>

                            <c:forEach var="vendorTenderBidItem1" items="${vendorTenderBidItem1}" varStatus="status">
                                <tr  style="font-size: 11px; height: 20px; padding: 3px 5px;"> 
                                    <td style="padding: 3px 5px;">${vendorTenderBidItem1[0]}</td>
                                    <td style="padding: 3px 5px;">${vendorTenderBidItem1[1]}</td>
                                    <td style="padding: 3px 5px;">${vendorTenderBidItem1[2]}</td>
                                    <td style="padding: 3px 5px;">${vendorTenderBidItem1[4]}</td>
                                    <td style="padding: 3px 5px;">${vendorTenderBidItem1[3]}</td>
                                    <c:if test="${vendor_code1 != ''}">
                                        <td style="padding: 3px 5px;">${vendorTenderBidItem1[5]}</td>
                                        <td style="padding: 3px 5px;">${vendorTenderBidItem1[6]}</td>
                                        <c:if test="${rev_submit_flag1 == '1'}">
                                            <c:forEach var="reviseVendorTenderBidItem1" items="${reviseVendorTenderBidItem1}" varStatus="status">
                                                <c:if test="${vendorTenderBidItem1[0] == reviseVendorTenderBidItem1[0]}">
                                                    <td style="padding: 3px 5px;">${reviseVendorTenderBidItem1[5]}</td>
                                                    <td style="padding: 3px 5px;">${reviseVendorTenderBidItem1[6]}</td>
                                                </c:if>
                                            </c:forEach>

                                        </c:if>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <c:forEach var="vendorTenderBidItem2" items="${vendorTenderBidItem2}" varStatus="status1">
                                            <c:if test="${vendorTenderBidItem1[0] == vendorTenderBidItem2[0]}">
                                                <td style="padding: 3px 5px;">${vendorTenderBidItem2[5]}</td>
                                                <td style="padding: 3px 5px;">${vendorTenderBidItem2[6]}</td>
                                            </c:if>
                                        </c:forEach>
                                        <c:if test="${rev_submit_flag2 == '1'}">
                                            <c:forEach var="reviseVendorTenderBidItem2" items="${reviseVendorTenderBidItem2}" varStatus="status">
                                                <c:if test="${vendorTenderBidItem1[0] == reviseVendorTenderBidItem2[0]}">
                                                    <td style="padding: 3px 5px;">${reviseVendorTenderBidItem2[5]}</td>
                                                    <td style="padding: 3px 5px;">${reviseVendorTenderBidItem2[6]}</td>
                                                </c:if>
                                            </c:forEach>

                                        </c:if>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <c:forEach var="vendorTenderBidItem3" items="${vendorTenderBidItem3}" varStatus="status1">
                                            <c:if test="${vendorTenderBidItem1[0] == vendorTenderBidItem3[0]}">
                                                <td style="padding: 3px 5px;">${vendorTenderBidItem3[5]}</td>
                                                <td style="padding: 3px 5px;">${vendorTenderBidItem3[6]}</td>
                                            </c:if>
                                        </c:forEach>

                                        <c:if test="${rev_submit_flag3 == '1'}">
                                            <c:forEach var="reviseVendorTenderBidItem3" items="${reviseVendorTenderBidItem3}" varStatus="status">
                                                <c:if test="${vendorTenderBidItem1[0] == reviseVendorTenderBidItem3[0]}">
                                                    <td style="padding: 3px 5px;">${reviseVendorTenderBidItem3[5]}</td>
                                                    <td style="padding: 3px 5px;">${reviseVendorTenderBidItem3[6]}</td>
                                                </c:if>
                                            </c:forEach>

                                        </c:if>

                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <c:forEach var="vendorTenderBidItem4" items="${vendorTenderBidItem4}" varStatus="status1">
                                            <c:if test="${vendorTenderBidItem1[0] == vendorTenderBidItem4[0]}">
                                                <td style="padding: 3px 5px;">${vendorTenderBidItem4[5]}</td>
                                                <td style="padding: 3px 5px;">${vendorTenderBidItem4[6]}</td>
                                            </c:if>
                                        </c:forEach>

                                        <c:if test="${rev_submit_flag4 == '1'}">
                                            <c:forEach var="reviseVendorTenderBidItem4" items="${reviseVendorTenderBidItem4}" varStatus="status">
                                                <c:if test="${vendorTenderBidItem1[0] == reviseVendorTenderBidItem4[0]}">
                                                    <td style="padding: 3px 5px;">${reviseVendorTenderBidItem4[5]}</td>
                                                    <td style="padding: 3px 5px;">${reviseVendorTenderBidItem4[6]}</td>
                                                </c:if>
                                            </c:forEach>

                                        </c:if>

                                    </c:if>                
                                </tr>
                            </c:forEach>

                            <tr  style="font-size: 11px; height: 20px; padding: 3px 5px;"> 
                                <th  colspan="5" style="padding: 3px 5px;">Ex-work Price/FOB</th>
                                    <c:if test="${vendor_code1 != ''}">
                                    <td style="padding: 3px 5px;"></td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${total_value1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    <c:if test="${rev_submit_flag1 == '1'}">
                                        <td style="padding: 3px 5px;"></td>
                                        <td style="padding: 3px 5px;"><fmt:formatNumber value="${rev_total_value1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>
                                </c:if>
                                <c:if test="${vendor_code2 != ''}">
                                    <td style="padding: 3px 5px;"></td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${total_value2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                    <c:if test="${rev_submit_flag2 == '1'}">
                                        <td style="padding: 3px 5px;"></td>
                                        <td style="padding: 3px 5px;"><fmt:formatNumber value="${rev_total_value2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>

                                </c:if>
                                <c:if test="${vendor_code3 != ''}">
                                    <td style="padding: 3px 5px;"></td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${total_value3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>


                                    <c:if test="${rev_submit_flag3 == '1'}">
                                        <td style="padding: 3px 5px;"></td>
                                        <td style="padding: 3px 5px;"><fmt:formatNumber value="${rev_total_value3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>

                                </c:if>
                                <c:if test="${vendor_code4 != ''}">
                                    <td style="padding: 3px 5px;"></td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${total_value4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>


                                    <c:if test="${rev_submit_flag4 == '1'}">
                                        <td style="padding: 3px 5px;"></td>
                                        <td style="padding: 3px 5px;"><fmt:formatNumber value="${rev_total_value4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    </c:if>

                                </c:if>        
                            </tr>

                            <tr  style="font-size: 11px; height: 20px; padding: 3px 5px;"> 
                                <th  colspan="5" style="padding: 3px 5px;">Packing & Forwarding</th>
                                    <c:if test="${vendor_code1 != ''}">
                                    <td style="padding: 3px 5px;">${packingValue1}</td>
                                    <td style="padding: 3px 5px;">${packingValueFinal1}</td>
                                    <c:if test="${rev_submit_flag1 == '1'}">
                                        <td style="padding: 3px 5px;">${revpackingValue1}</td>
                                        <td style="padding: 3px 5px;">${revpackingValueFinal1}</td>
                                    </c:if>
                                </c:if>
                                <c:if test="${vendor_code2 != ''}">
                                    <td style="padding: 3px 5px;">${packingValue2}</td>
                                    <td style="padding: 3px 5px;">${packingValueFinal2}</td>


                                    <c:if test="${rev_submit_flag2 == '1'}">
                                        <td style="padding: 3px 5px;">${revpackingValue2}</td>
                                        <td style="padding: 3px 5px;">${revpackingValueFinal2}</td>
                                    </c:if>

                                </c:if>
                                <c:if test="${vendor_code3 != ''}">
                                    <td style="padding: 3px 5px;">${packingValue3}</td>
                                    <td style="padding: 3px 5px;">${packingValueFinal3}</td>


                                    <c:if test="${rev_submit_flag3 == '1'}">
                                        <td style="padding: 3px 5px;">${revpackingValue3}</td>
                                        <td style="padding: 3px 5px;">${revpackingValueFinal3}</td>
                                    </c:if>

                                </c:if>
                                <c:if test="${vendor_code4 != ''}">
                                    <td style="padding: 3px 5px;">${packingValue4}</td>
                                    <td style="padding: 3px 5px;">${packingValueFinal4}</td>


                                    <c:if test="${rev_submit_flag4 == '1'}">
                                        <td style="padding: 3px 5px;">${revpackingValue4}</td>
                                        <td style="padding: 3px 5px;">${revpackingValueFinal4}</td>
                                    </c:if>

                                </c:if>
                            </tr>

                            <tr  style="font-size: 11px; height: 20px; padding: 3px 5px;"> 
                                <th  colspan="5" style="padding: 3px 5px;">Charges</th>
                                    <c:if test="${vendor_code1 != ''}">
                                    <td style="padding: 3px 5px;">${chargesValue1}</td>
                                    <td style="padding: 3px 5px;">${chargesValueFinal1}</td>

                                    <c:if test="${rev_submit_flag1 == '1'}">
                                        <td style="padding: 3px 5px;">${revchargesValue1}</td>
                                        <td style="padding: 3px 5px;">${revchargesValueFinal1}</td>
                                    </c:if>

                                </c:if>
                                <c:if test="${vendor_code2 != ''}">
                                    <td style="padding: 3px 5px;">${chargesValue2}</td>
                                    <td style="padding: 3px 5px;">${chargesValueFinal2}</td>

                                    <c:if test="${rev_submit_flag2 == '1'}">
                                        <td style="padding: 3px 5px;">${revchargesValue2}</td>
                                        <td style="padding: 3px 5px;">${revchargesValueFinal2}</td>
                                    </c:if>

                                </c:if>
                                <c:if test="${vendor_code3 != ''}">
                                    <td style="padding: 3px 5px;">${chargesValue3}</td>
                                    <td style="padding: 3px 5px;">${chargesValueFinal3}</td>

                                    <c:if test="${rev_submit_flag3 == '1'}">
                                        <td style="padding: 3px 5px;">${revchargesValue3}</td>
                                        <td style="padding: 3px 5px;">${revchargesValueFinal3}</td>
                                    </c:if>

                                </c:if>
                                <c:if test="${vendor_code4 != ''}">
                                    <td style="padding: 3px 5px;">${chargesValue4}</td>
                                    <td style="padding: 3px 5px;">${chargesValueFinal4}</td>

                                    <c:if test="${rev_submit_flag4 == '1'}">
                                        <td style="padding: 3px 5px;">${revchargesValue4}</td>
                                        <td style="padding: 3px 5px;">${revchargesValueFinal4}</td>
                                    </c:if>

                                </c:if>        
                            </tr>  

                            <tr  style="font-size: 11px; height: 20px; padding: 3px 5px;"> 
                                <th  colspan="5" style="padding: 3px 5px;">Insurance</th>
                                    <c:if test="${vendor_code1 != ''}">
                                    <td style="padding: 3px 5px;">${insuranceValue1}</td>
                                    <td style="padding: 3px 5px;">${insuranceValueFinal1}</td>

                                    <c:if test="${rev_submit_flag1 == '1'}">
                                        <td style="padding: 3px 5px;">${revinsuranceValue1}</td>
                                        <td style="padding: 3px 5px;">${revinsuranceValueFinal1}</td>
                                    </c:if>

                                </c:if>
                                <c:if test="${vendor_code2 != ''}">
                                    <td style="padding: 3px 5px;">${insuranceValue2}</td>
                                    <td style="padding: 3px 5px;">${insuranceValueFinal2}</td>

                                    <c:if test="${rev_submit_flag2 == '1'}">
                                        <td style="padding: 3px 5px;">${revinsuranceValue2}</td>
                                        <td style="padding: 3px 5px;">${revinsuranceValueFinal2}</td>
                                    </c:if>

                                </c:if>
                                <c:if test="${vendor_code3 != ''}">
                                    <td style="padding: 3px 5px;">${insuranceValue3}</td>
                                    <td style="padding: 3px 5px;">${insuranceValueFinal3}</td>

                                    <c:if test="${rev_submit_flag3 == '1'}">
                                        <td style="padding: 3px 5px;">${revinsuranceValue3}</td>
                                        <td style="padding: 3px 5px;">${revinsuranceValueFinal3}</td>
                                    </c:if>

                                </c:if>
                                <c:if test="${vendor_code4 != ''}">
                                    <td style="padding: 3px 5px;">${insuranceValue4}</td>
                                    <td style="padding: 3px 5px;">${insuranceValueFinal4}</td>

                                    <c:if test="${rev_submit_flag4 == '1'}">
                                        <td style="padding: 3px 5px;">${revinsuranceValue4}</td>
                                        <td style="padding: 3px 5px;">${revinsuranceValueFinal4}</td>
                                    </c:if>

                                </c:if>        
                            </tr>     

                            <tr  style="font-size: 11px; height: 20px; padding: 3px 5px;"> 
                                <th  colspan="5" style="padding: 3px 5px;">Erection Commision</th>
                                    <c:if test="${vendor_code1 != ''}">
                                    <td style="padding: 3px 5px;">${errectionValue1}</td>
                                    <td style="padding: 3px 5px;">${errectionValueFinal1}</td>

                                    <c:if test="${rev_submit_flag1 == '1'}">
                                        <td style="padding: 3px 5px;">${reverrectionValue1}</td>
                                        <td style="padding: 3px 5px;">${reverrectionValueFinal1}</td>
                                    </c:if>

                                </c:if>
                                <c:if test="${vendor_code2 != ''}">
                                    <td style="padding: 3px 5px;">${errectionValue2}</td>
                                    <td style="padding: 3px 5px;">${errectionValueFinal2}</td>

                                    <c:if test="${rev_submit_flag2 == '1'}">
                                        <td style="padding: 3px 5px;">${reverrectionValue2}</td>
                                        <td style="padding: 3px 5px;">${reverrectionValueFinal2}</td>
                                    </c:if>

                                </c:if>
                                <c:if test="${vendor_code3 != ''}">
                                    <td style="padding: 3px 5px;">${errectionValue3}</td>
                                    <td style="padding: 3px 5px;">${errectionValueFinal3}</td>

                                    <c:if test="${rev_submit_flag3 == '1'}">
                                        <td style="padding: 3px 5px;">${reverrectionValue3}</td>
                                        <td style="padding: 3px 5px;">${reverrectionValueFinal3}</td>
                                    </c:if>

                                </c:if>
                                <c:if test="${vendor_code4 != ''}">
                                    <td style="padding: 3px 5px;">${errectionValue4}</td>
                                    <td style="padding: 3px 5px;">${errectionValueFinal4}</td>

                                    <c:if test="${rev_submit_flag4 == '1'}">
                                        <td style="padding: 3px 5px;">${reverrectionValue4}</td>
                                        <td style="padding: 3px 5px;">${reverrectionValueFinal4}</td>
                                    </c:if>

                                </c:if>
                            </tr>
                            <tr  style="font-size: 11px; height: 20px; padding: 3px 5px;"> 
                                <th  colspan="5" style="padding: 3px 5px;">Discount</th>
                                    <c:if test="${vendor_code1 != ''}">
                                    <td style="padding: 3px 5px;">${discountValue1}</td>
                                    <td style="padding: 3px 5px;">${discountValueFinal1}</td>

                                    <c:if test="${rev_submit_flag1 == '1'}">
                                        <td style="padding: 3px 5px;">${revdiscountValue1}</td>
                                        <td style="padding: 3px 5px;">${revdiscountValueFinal1}</td>
                                    </c:if>

                                </c:if>
                                <c:if test="${vendor_code2 != ''}">
                                    <td style="padding: 3px 5px;">${discountValue2}</td>
                                    <td style="padding: 3px 5px;">${discountValueFinal2}</td>

                                    <c:if test="${rev_submit_flag2 == '1'}">
                                        <td style="padding: 3px 5px;">${revdiscountValue2}</td>
                                        <td style="padding: 3px 5px;">${revdiscountValueFinal2}</td>
                                    </c:if>

                                </c:if>
                                <c:if test="${vendor_code3 != ''}">
                                    <td style="padding: 3px 5px;">${discountValue3}</td>
                                    <td style="padding: 3px 5px;">${discountValueFinal3}</td>


                                    <c:if test="${rev_submit_flag3 == '1'}">
                                        <td style="padding: 3px 5px;">${revdiscountValue3}</td>
                                        <td style="padding: 3px 5px;">${revdiscountValueFinal3}</td>
                                    </c:if>

                                </c:if>
                                <c:if test="${vendor_code4 != ''}">
                                    <td style="padding: 3px 5px;">${discountValue4}</td>
                                    <td style="padding: 3px 5px;">${discountValueFinal4}</td>


                                    <c:if test="${rev_submit_flag4 == '1'}">
                                        <td style="padding: 3px 5px;">${revdiscountValue4}</td>
                                        <td style="padding: 3px 5px;">${revdiscountValueFinal4}</td>
                                    </c:if>

                                </c:if>
                            </tr> 
                            <tr  style="font-size: 11px; height: 20px; padding: 3px 5px;"> 
                                <th  colspan="5" style="padding: 3px 5px;">Final Evaluated Price Without GST</th>
                                    <c:if test="${vendor_code1 != ''}">
                                    <td style="padding: 3px 5px;"></td>
                                    <td style="padding: 3px 5px;">${String.format("%.2f",Total1 - igstValueFinal1)}</td>

                                    <c:if test="${rev_submit_flag1 == '1'}">
                                        <td style="padding: 3px 5px;"></td>
                                        <td style="padding: 3px 5px;">${String.format("%.2f",revTotal1 - revigstValueFinal1)}</td>
                                    </c:if>

                                </c:if>
                                <c:if test="${vendor_code2 != ''}">
                                    <td style="padding: 3px 5px;"></td>
                                    <td style="padding: 3px 5px;">${String.format("%.2f",Total2 - igstValueFinal2)}</td>


                                    <c:if test="${rev_submit_flag2 == '1'}">
                                        <td style="padding: 3px 5px;"></td>
                                        <td style="padding: 3px 5px;">${String.format("%.2f",revTotal2 - revigstValueFinal2)}</td>
                                    </c:if>

                                </c:if>
                                <c:if test="${vendor_code3 != ''}">
                                    <td style="padding: 3px 5px;"></td>
                                    <td style="padding: 3px 5px;">${String.format("%.2f",Total3 - igstValueFinal3)}</td>

                                    <c:if test="${rev_submit_flag3 == '1'}">
                                        <td style="padding: 3px 5px;"></td>
                                        <td style="padding: 3px 5px;">${String.format("%.2f",revTotal3 - revigstValueFinal3)}</td>
                                    </c:if>

                                </c:if>
                                <c:if test="${vendor_code4 != ''}">
                                    <td style="padding: 3px 5px;"></td>
                                    <td style="padding: 3px 5px;">${String.format("%.2f",Total4 - igstValueFinal4)}</td>

                                    <c:if test="${rev_submit_flag4 == '1'}">
                                        <td style="padding: 3px 5px;"></td>
                                        <td style="padding: 3px 5px;">${String.format("%.2f",revTotal4 - revigstValueFinal4)}</td>
                                    </c:if>

                                </c:if>        
                            </tr> 

                            <tr  style="font-size: 11px; height: 20px; padding: 3px 5px;"> 
                                <th  colspan="5" style="padding: 3px 5px;">GST</th>
                                    <c:if test="${vendor_code1 != ''}">
                                    <td style="padding: 3px 5px;">${igstValue1}</td>
                                    <td style="padding: 3px 5px;">${igstValueFinal1}</td>

                                    <c:if test="${rev_submit_flag1 == '1'}">
                                        <td style="padding: 3px 5px;">${revigstValue1}</td>
                                        <td style="padding: 3px 5px;">${revigstValueFinal1}</td>
                                    </c:if>

                                </c:if>
                                <c:if test="${vendor_code2 != ''}">
                                    <td style="padding: 3px 5px;">${igstValue2}</td>
                                    <td style="padding: 3px 5px;">${igstValueFinal2}</td>

                                    <c:if test="${rev_submit_flag2 == '1'}">
                                        <td style="padding: 3px 5px;">${revigstValue2}</td>
                                        <td style="padding: 3px 5px;">${revigstValueFinal2}</td>
                                    </c:if>

                                </c:if>
                                <c:if test="${vendor_code3 != ''}">
                                    <td style="padding: 3px 5px;">${igstValue3}</td>
                                    <td style="padding: 3px 5px;">${igstValueFinal3}</td>

                                    <c:if test="${rev_submit_flag3 == '1'}">
                                        <td style="padding: 3px 5px;">${revigstValue3}</td>
                                        <td style="padding: 3px 5px;">${revigstValueFinal3}</td>
                                    </c:if>

                                </c:if>
                                <c:if test="${vendor_code4 != ''}">
                                    <td style="padding: 3px 5px;">${igstValue4}</td>
                                    <td style="padding: 3px 5px;">${igstValueFinal4}</td>

                                    <c:if test="${rev_submit_flag4 == '1'}">
                                        <td style="padding: 3px 5px;">${revigstValue4}</td>
                                        <td style="padding: 3px 5px;">${revigstValueFinal4}</td>
                                    </c:if>

                                </c:if>        
                            </tr>        

                            <tr  style="font-size: 11px; height: 20px; padding: 3px 5px;"> 

                                <th  colspan="5" style="padding: 3px 5px;">Final Evaluated Price</th>
                                    <c:if test="${vendor_code1 != ''}">
                                    <td style="padding: 3px 5px;"></td>
                                    <td style="padding: 3px 5px;">${String.format("%.2f",Total1)}</td>

                                    <c:if test="${rev_submit_flag1 == '1'}">
                                        <td style="padding: 3px 5px;"></td>
                                        <td style="padding: 3px 5px;">${String.format("%.2f",revTotal1)}</td>
                                    </c:if>

                                </c:if>
                                <c:if test="${vendor_code2 != ''}">
                                    <td style="padding: 3px 5px;"></td>
                                    <td style="padding: 3px 5px;">${String.format("%.2f",Total2)}</td>


                                    <c:if test="${rev_submit_flag2 == '1'}">
                                        <td style="padding: 3px 5px;"></td>
                                        <td style="padding: 3px 5px;">${String.format("%.2f",revTotal2)}</td>
                                    </c:if>

                                </c:if>
                                <c:if test="${vendor_code3 != ''}">
                                    <td style="padding: 3px 5px;"></td>
                                    <td style="padding: 3px 5px;">${String.format("%.2f",Total3)}</td>

                                    <c:if test="${rev_submit_flag3 == '1'}">
                                        <td style="padding: 3px 5px;"></td>
                                        <td style="padding: 3px 5px;">${String.format("%.2f",revTotal3)}</td>
                                    </c:if>

                                </c:if>
                                <c:if test="${vendor_code4 != ''}">
                                    <td style="padding: 3px 5px;"></td>
                                    <td style="padding: 3px 5px;">${String.format("%.2f",Total4)}</td>

                                    <c:if test="${rev_submit_flag4 == '1'}">
                                        <td style="padding: 3px 5px;"></td>
                                        <td style="padding: 3px 5px;">${String.format("%.2f",revTotal4)}</td>
                                    </c:if>

                                </c:if> 
                            </tr>      
                            <tr  style="font-size: 11px; height: 20px; padding: 3px 5px;"> 

                                <th  colspan="5" style="padding: 3px 5px;">Rating</th>
                                    <c:if test="${vendor_code1 != ''}">
                                    <td style="padding: 3px 5px;"></td>
                                    <td style="padding: 3px 5px;">${rank1}</td>

                                    <c:if test="${rev_submit_flag1 == '1'}">
                                        <td style="padding: 3px 5px;"></td>
                                        <td style="padding: 3px 5px;">${rank1}</td>
                                    </c:if>

                                </c:if>
                                <c:if test="${vendor_code2 != ''}">
                                    <td style="padding: 3px 5px;"></td>
                                    <td style="padding: 3px 5px;">${rank2}</td>


                                    <c:if test="${rev_submit_flag2 == '1'}">
                                        <td style="padding: 3px 5px;"></td>
                                        <td style="padding: 3px 5px;">${rank2}</td>
                                    </c:if>

                                </c:if>
                                <c:if test="${vendor_code3 != ''}">
                                    <td style="padding: 3px 5px;"></td>
                                    <td style="padding: 3px 5px;">${rank3}</td>

                                    <c:if test="${rev_submit_flag3 == '1'}">
                                        <td style="padding: 3px 5px;"></td>
                                        <td style="padding: 3px 5px;">${rank3}</td>
                                    </c:if>

                                </c:if>
                                <c:if test="${vendor_code4 != ''}">
                                    <td style="padding: 3px 5px;">${rank4}</td>

                                    <c:if test="${rev_submit_flag4 == '1'}">
                                        <td style="padding: 3px 5px;"></td>
                                        <td style="padding: 3px 5px;">${rank4}</td>
                                    </c:if>

                                </c:if>
                            </tr>

                            <tr  style="font-size: 11px; height: 20px; padding: 3px 5px;"> 
                                <th  colspan="5" style="padding: 3px 5px;">No. Of Item Regreted</th>
                                    <c:if test="${vendor_code1 != ''}">
                                    <td style="padding: 3px 5px;"></td>
                                    <td style="padding: 3px 5px;">${regret1}</td>

                                    <c:if test="${rev_submit_flag1 == '1'}">
                                        <td style="padding: 3px 5px;"></td>
                                        <td style="padding: 3px 5px;">${regret1}</td>
                                    </c:if>

                                </c:if>
                                <c:if test="${vendor_code2 != ''}">
                                    <td style="padding: 3px 5px;"></td>
                                    <td style="padding: 3px 5px;">${regret2}</td>

                                    <c:if test="${rev_submit_flag2 == '1'}">
                                        <td style="padding: 3px 5px;"></td>
                                        <td style="padding: 3px 5px;">${regret2}</td>
                                    </c:if>

                                </c:if>
                                <c:if test="${vendor_code3 != ''}">
                                    <td style="padding: 3px 5px;"></td>
                                    <td style="padding: 3px 5px;">${regret3}</td>

                                    <c:if test="${rev_submit_flag3 == '1'}">
                                        <td style="padding: 3px 5px;"></td>
                                        <td style="padding: 3px 5px;">${regret3}</td>
                                    </c:if>

                                </c:if>
                                <c:if test="${vendor_code4 != ''}">
                                    <td style="padding: 3px 5px;"></td>
                                    <td style="padding: 3px 5px;">${regret4}</td>

                                    <c:if test="${rev_submit_flag4 == '1'}">
                                        <td style="padding: 3px 5px;"></td>
                                        <td style="padding: 3px 5px;">${regret4}</td>
                                    </c:if>

                                </c:if>
                            </tr>

                        </table>

                        <br>    

                        <c:if test="${ServicevendorTenderBidItem1.size() > 0}">
                            <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover " style="" align="Center"  >
                                <c:if test = "${tenderMaster.type == 'Contract' || tenderMaster.type == 'Contract Civil' || tenderMaster.type == 'Contract Electrical'}">
                                    <tr  style="font-size: 11px; height: 20px; padding: 3px 5px;"> 

                                        <th colspan="3"style="padding: 3px 5px;"><strong>Vendor Code</strong></td>
                                            <c:if test="${vendor_code1 != ''}">
                                            <td colspan="2" style="padding: 3px 5px;">${vendor_code1}</td>
                                            <c:if test="${rev_submit_flag1 == '1'}">
                                                <td colspan="2" style="padding: 3px 5px;">${vendor_code1}</td>
                                            </c:if> 
                                        </c:if>
                                        <c:if test="${vendor_code2 != ''}">
                                            <td colspan="2" style="padding: 3px 5px;">${vendor_code2}</td>
                                            <c:if test="${rev_submit_flag2 == '1'}">
                                                <td colspan="2" style="padding: 3px 5px;">${vendor_code2}</td>
                                            </c:if> 
                                        </c:if>
                                        <c:if test="${vendor_code3 != ''}">
                                            <td colspan="2" style="padding: 3px 5px;">${vendor_code3}</td>
                                            <c:if test="${rev_submit_flag3 == '1'}">
                                                <td colspan="2" style="padding: 3px 5px;">${vendor_code3}</td>
                                            </c:if> 
                                        </c:if>
                                        <c:if test="${vendor_code4 != ''}">
                                            <td colspan="2" style="padding: 3px 5px;">${vendor_code4}</td>
                                            <c:if test="${rev_submit_flag4 == '1'}">
                                                <td colspan="2" style="padding: 3px 5px;">${vendor_code4}</td>
                                            </c:if> 
                                        </c:if>
                                    </tr>
                                    <c:set var="count" value="0" scope="page" />
                                    <tr  style="font-size: 11px; height: 20px; padding: 3px 5px;"> 
                                        <td  colspan="3" style="padding: 3px 5px;"><strong>Vendor Name</strong> </td>
                                        <c:if test="${vendor_code1 != ''}">
                                            <td colspan="2" style="padding: 3px 5px;">${vendor_name1}</td>
                                            <c:if test="${rev_submit_flag1 == '1'}">
                                                <td colspan="2" style="padding: 3px 5px;">${vendor_name1}</td>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${vendor_code2 != ''}">
                                            <td colspan="2"style="padding: 3px 5px;">${vendor_name2}</td>
                                            <c:if test="${rev_submit_flag2 == '1'}">
                                                <td colspan="2" style="padding: 3px 5px;">${vendor_name2}</td>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${vendor_code3 != ''}">
                                            <td colspan="2" style="padding: 3px 5px;">${vendor_name3}</td>
                                            <c:if test="${rev_submit_flag3 == '1'}">
                                                <td colspan="2" style="padding: 3px 5px;">${vendor_name3}</td>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${vendor_code4 != ''}">
                                            <td colspan="2" style="padding: 3px 5px;">${vendor_name4}</td>
                                            <c:if test="${rev_submit_flag4 == '1'}">
                                                <td colspan="2" style="padding: 3px 5px;">${vendor_name4}</td>
                                            </c:if>
                                        </c:if>
                                    </tr>
                                    <tr  style="font-size: 11px; height: 20px; padding: 3px 5px;"> 
                                        <td  colspan="3" style="padding: 3px 5px;"><strong>Currency Name</strong></td>
                                        <c:if test="${vendor_code1 != ''}">
                                            <td colspan="2" style="padding: 3px 5px;">INR</td>
                                            <c:if test="${rev_submit_flag1 == '1'}">
                                                <td colspan="2" style="padding: 3px 5px;">INR</td>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${vendor_code2 != ''}">
                                            <td colspan="2" style="padding: 3px 5px;">INR</td>
                                            <c:if test="${rev_submit_flag2 == '1'}">
                                                <td colspan="2">INR</td>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${vendor_code3 != ''}">
                                            <td colspan="2" style="padding: 3px 5px;">INR</td>
                                            <c:if test="${rev_submit_flag3 == '1'}">
                                                <td colspan="2" style="padding: 3px 5px;">INR</td>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${vendor_code4 != ''}">
                                            <td colspan="2" style="padding: 3px 5px;">INR</td>
                                            <c:if test="${rev_submit_flag4 == '1'}">
                                                <td colspan="2" style="padding: 3px 5px;">INR</td>
                                            </c:if>
                                        </c:if>    
                                    </tr>

                                    <tr  style="font-size: 11px; height: 20px; padding: 3px 5px;"> 
                                        <td  colspan="3" style="padding: 3px 5px;"><strong>Exchange Rate</strong></td>
                                        <c:if test="${vendor_code1 != ''}">
                                            <td colspan="2"style="padding: 3px 5px;">1.00</td>
                                            <c:if test="${rev_submit_flag1 == '1'}">
                                                <td colspan="2" style="padding: 3px 5px;">1.00</td>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${vendor_code2 != ''}">
                                            <td colspan="2"style="padding: 3px 5px;">1.00</td>
                                            <c:if test="${rev_submit_flag2 == '1'}">
                                                <td colspan="2" style="padding: 3px 5px;">1.00</td>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${vendor_code3 != ''}">
                                            <td colspan="2" style="padding: 3px 5px;">1.00</td>
                                            <c:if test="${rev_submit_flag3 == '1'}">
                                                <td colspan="2" style="padding: 3px 5px;">1.00</td>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${vendor_code4 != ''}">
                                            <td colspan="2" style="padding: 3px 5px;">1.00</td>
                                            <c:if test="${rev_submit_flag4 == '1'}">
                                                <td colspan="2" style="padding: 3px 5px;">1.00</td>
                                            </c:if>
                                        </c:if>    
                                    </tr>  
                                </table>
                                <br>

                                <table  class="flex-table " id="table_2" class="table table-bordered table-striped table-hover " style="" align="Center"  >

                                    <tr class="table-title"  style="font-size: 11px; height: 20px; padding: 3px 5px;"> 

                                        <th style="padding: 3px 5px;">Sr.</th>
                                        <th style="padding: 3px 5px;">Item Code</th>
                                        <th style="padding: 3px 5px;">Item Description</th>
                                        <th style="padding: 3px 5px;">Quantity</th>
                                        <th style="padding: 3px 5px;">UOM</th>
                                            <c:if test="${vendor_code1 != ''}">
                                            <th style="padding: 3px 5px;">Unit Price</th>
                                            <th style="padding: 3px 5px;">Value</th>

                                            <c:if test="${rev_submit_flag1 == '1'}">
                                                <th style="padding: 3px 5px;">Unit Price</th>
                                                <th style="padding: 3px 5px;">Value</th>
                                                </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code2 != ''}">
                                            <th style="padding: 3px 5px;">Unit Price</th>
                                            <th style="padding: 3px 5px;">Value</th>

                                            <c:if test="${rev_submit_flag2 == '1'}">
                                                <th style="padding: 3px 5px;">Unit Price</th>
                                                <th style="padding: 3px 5px;">Value</th>
                                                </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code3 != ''}">
                                            <th style="padding: 3px 5px;">Unit Price</th>
                                            <th style="padding: 3px 5px;">Value</th>

                                            <c:if test="${rev_submit_flag3 == '1'}">
                                                <th style="padding: 3px 5px;">Unit Price</th>
                                                <th style="padding: 3px 5px;">Value</th>
                                                </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code4 != ''}">
                                            <th style="padding: 3px 5px;">Unit Price</th>
                                            <th style="padding: 3px 5px;">Value</th>

                                            <c:if test="${rev_submit_flag4 == '1'}">
                                                <th style="padding: 3px 5px;">Unit Price</th>
                                                <th style="padding: 3px 5px;">Value</th>
                                                </c:if>

                                        </c:if>        
                                    </tr>
                                    <c:forEach var="vendorTenderBidItem1" items="${ServicevendorTenderBidItem1}" varStatus="status">
                                        <tr  style="font-size: 11px; height: 20px; padding: 3px 5px;"> 

                                            <td style="padding: 3px 5px;">${vendorTenderBidItem1[0]}</td>
                                            <td style="padding: 3px 5px;">${vendorTenderBidItem1[1]}</td>
                                            <td style="padding: 3px 5px;">${vendorTenderBidItem1[2]}</td>
                                            <td style="padding: 3px 5px;">${vendorTenderBidItem1[4]}</td>
                                            <td style="padding: 3px 5px;">${vendorTenderBidItem1[3]}</td>
                                            <c:if test="${vendor_code1 != ''}">
                                                <td style="padding: 3px 5px;">${vendorTenderBidItem1[5]}</td>
                                                <td style="padding: 3px 5px;">${vendorTenderBidItem1[6]}</td>
                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                    <c:forEach var="revServicevendorTenderBidItem1" items="${revServicevendorTenderBidItem1}" varStatus="status1">
                                                        <c:if test="${vendorTenderBidItem1[0] == revServicevendorTenderBidItem1[0]}">
                                                            <td style="padding: 3px 5px;">${revServicevendorTenderBidItem1[5]}</td>
                                                            <td style="padding: 3px 5px;">${revServicevendorTenderBidItem1[6]}</td>
                                                        </c:if>
                                                    </c:forEach>
                                                </c:if>
                                            </c:if>
                                            <c:if test="${vendor_code2 != ''}">
                                                <c:forEach var="vendorTenderBidItem2" items="${ServicevendorTenderBidItem2}" varStatus="status1">
                                                    <c:if test="${vendorTenderBidItem1[0] == vendorTenderBidItem2[0]}">
                                                        <td style="padding: 3px 5px;">${vendorTenderBidItem2[5]}</td>
                                                        <td style="padding: 3px 5px;">${vendorTenderBidItem2[6]}</td>
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                    <c:forEach var="revServicevendorTenderBidItem2" items="${revServicevendorTenderBidItem2}" varStatus="status1">
                                                        <c:if test="${vendorTenderBidItem1[0] == revServicevendorTenderBidItem2[0]}">
                                                            <td style="padding: 3px 5px;">${revServicevendorTenderBidItem2[5]}</td>
                                                            <td style="padding: 3px 5px;">${revServicevendorTenderBidItem2[6]}</td>
                                                        </c:if>
                                                    </c:forEach>
                                                </c:if>  
                                            </c:if>
                                            <c:if test="${vendor_code3 != ''}">
                                                <c:forEach var="vendorTenderBidItem3" items="${ServicevendorTenderBidItem3}" varStatus="status1">
                                                    <c:if test="${vendorTenderBidItem1[0] == vendorTenderBidItem3[0]}">
                                                        <td style="padding: 3px 5px;">${vendorTenderBidItem3[5]}</td>
                                                        <td style="padding: 3px 5px;">${vendorTenderBidItem3[6]}</td>
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                    <c:forEach var="revServicevendorTenderBidItem3" items="${revServicevendorTenderBidItem3}" varStatus="status1">
                                                        <c:if test="${vendorTenderBidItem1[0] == revServicevendorTenderBidItem3[0]}">
                                                            <td style="padding: 3px 5px;">${revServicevendorTenderBidItem3[5]}</td>
                                                            <td style="padding: 3px 5px;">${revServicevendorTenderBidItem3[6]}</td>
                                                        </c:if>
                                                    </c:forEach>
                                                </c:if> 
                                            </c:if>

                                            <c:if test="${vendor_code4 != ''}">
                                                <c:forEach var="vendorTenderBidItem4" items="${ServicevendorTenderBidItem4}" varStatus="status1">
                                                    <c:if test="${vendorTenderBidItem1[0] == vendorTenderBidItem4[0]}">
                                                        <td style="padding: 3px 5px;">${vendorTenderBidItem4[5]}</td>
                                                        <td style="padding: 3px 5px;">${vendorTenderBidItem4[6]}</td>
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                    <c:forEach var="revServicevendorTenderBidItem4" items="${revServicevendorTenderBidItem4}" varStatus="status1">
                                                        <c:if test="${vendorTenderBidItem1[0] == revServicevendorTenderBidItem4[0]}">
                                                            <td style="padding: 3px 5px;">${revServicevendorTenderBidItem4[5]}</td>
                                                            <td style="padding: 3px 5px;">${revServicevendorTenderBidItem4[6]}</td>
                                                        </c:if>
                                                    </c:forEach>
                                                </c:if> 
                                            </c:if>                
                                        </tr>
                                    </c:forEach>

                                    <tr  style="font-size: 11px; height: 20px; padding: 3px 5px;"> 
                                        <th  colspan="5" style="padding: 3px 5px;">Ex-work Price/FOB</th>
                                            <c:if test="${vendor_code1 != ''}">
                                            <td style="padding: 3px 5px;"></td>
                                            <td style="padding: 3px 5px;"> <fmt:formatNumber value="${serviceTotalFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" />
                                            </td>

                                            <c:if test="${rev_submit_flag1 == '1'}">
                                                <td style="padding: 3px 5px;"></td>
                                                <td style="padding: 3px 5px;">
                                                    <fmt:formatNumber value="${revserviceTotalFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" />
                                                </td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code2 != ''}">
                                            <td style="padding: 3px 5px;"></td>
                                            <td style="padding: 3px 5px;"><fmt:formatNumber value="${serviceTotalFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                            <c:if test="${rev_submit_flag2 == '1'}">
                                                <td style="padding: 3px 5px;"></td>
                                                <td style="padding: 3px 5px;"><fmt:formatNumber value="${revserviceTotalFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code3 != ''}">
                                            <td style="padding: 3px 5px;"></td>
                                            <td style="padding: 3px 5px;"><fmt:formatNumber value="${serviceTotalFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                            <c:if test="${rev_submit_flag3 == '1'}">
                                                <td style="padding: 3px 5px;"></td>
                                                <td style="padding: 3px 5px;"><fmt:formatNumber value="${revserviceTotalFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code4 != ''}">
                                            <td style="padding: 3px 5px;"></td>
                                            <td style="padding: 3px 5px;"><fmt:formatNumber value="${serviceTotalFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                            <c:if test="${rev_submit_flag4 == '1'}">
                                                <td style="padding: 3px 5px;"></td>
                                                <td style="padding: 3px 5px;"><fmt:formatNumber value="${revserviceTotalFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                            </c:if>

                                        </c:if>        
                                    </tr>
                                    <tr  style="font-size: 11px; height: 20px; padding: 3px 5px;"> 
                                        <th  colspan="5" style="padding: 3px 5px;">Discount</th>
                                            <c:if test="${vendor_code1 != ''}">
                                            <td style="padding: 3px 5px;">${serviceDiscountValue1}</td>
                                            <td style="padding: 3px 5px;">${serviceDiscountValueFinal1}</td>

                                            <c:if test="${rev_submit_flag1 == '1'}">
                                                <td  style="padding: 3px 5px;">${revserviceDiscountValue1}</td>
                                                <td style="padding: 3px 5px;">${revserviceDiscountValueFinal1}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code2 != ''}">
                                            <td style="padding: 3px 5px;">${serviceDiscountValue2}</td>
                                            <td style="padding: 3px 5px;">${serviceDiscountValueFinal2}</td>

                                            <c:if test="${rev_submit_flag2 == '1'}">
                                                <td style="padding: 3px 5px;">${revserviceDiscountValue2}</td>
                                                <td style="padding: 3px 5px;">${revserviceDiscountValueFinal2}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code3 != ''}">
                                            <td style="padding: 3px 5px;">${serviceDiscountValue3}</td>
                                            <td style="padding: 3px 5px;">${serviceDiscountValueFinal3}</td>

                                            <c:if test="${rev_submit_flag3 == '1'}">
                                                <td style="padding: 3px 5px;">${revserviceDiscountValue3}</td>
                                                <td style="padding: 3px 5px;">${revserviceDiscountValueFinal3}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code4 != ''}">
                                            <td style="padding: 3px 5px;">${serviceDiscountValue4}</td>
                                            <td style="padding: 3px 5px;">${serviceDiscountValueFinal4}</td>

                                            <c:if test="${rev_submit_flag4 == '1'}">
                                                <td style="padding: 3px 5px;">${revserviceDiscountValue4}</td>
                                                <td style="padding: 3px 5px;">${revserviceDiscountValueFinal4}</td>
                                            </c:if>

                                        </c:if>        
                                    </tr>

                                    <tr  style="font-size: 11px; height: 20px; padding: 3px 5px;"> 
                                        <th  colspan="5" style="padding: 3px 5px;">Final Evaluated Price Without GST</th>
                                            <c:if test="${vendor_code1 != ''}">
                                            <td style="padding: 3px 5px;"></td>
                                            <td style="padding: 3px 5px;">${String.format("%.2f",serviceTaxTotal1 - servicegstFinal1)}</td>

                                            <c:if test="${rev_submit_flag1 == '1'}">
                                                <td style="padding: 3px 5px;"></td>
                                                <td style="padding: 3px 5px;">${String.format("%.2f",revserviceTaxTotal1 - revservicegstFinal1)}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code2 != ''}">
                                            <td style="padding: 3px 5px;"></td>
                                            <td style="padding: 3px 5px;">${String.format("%.2f",serviceTaxTotal2 - servicegstFinal2)}</td>

                                            <c:if test="${rev_submit_flag2 == '1'}">
                                                <td style="padding: 3px 5px;"></td>
                                                <td style="padding: 3px 5px;">${String.format("%.2f",revserviceTaxTotal2 - revservicegstFinal2)}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code3 != ''}">
                                            <td style="padding: 3px 5px;"></td>
                                            <td style="padding: 3px 5px;">${String.format("%.2f",serviceTaxTotal3 - servicegstFinal3)}</td>


                                            <c:if test="${rev_submit_flag3 == '1'}">
                                                <td style="padding: 3px 5px;"></td>
                                                <td style="padding: 3px 5px;">${String.format("%.2f",revserviceTaxTotal3 - revservicegstFinal3)}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code4 != ''}">
                                            <td style="padding: 3px 5px;"></td>
                                            <td style="padding: 3px 5px;">${String.format("%.2f",serviceTaxTotal4 - servicegstFinal4)}</td>


                                            <c:if test="${rev_submit_flag4 == '1'}">
                                                <td style="padding: 3px 5px;"></td>
                                                <td style="padding: 3px 5px;">${String.format("%.2f",revserviceTaxTotal4 - revservicegstFinal4)}</td>
                                            </c:if>

                                        </c:if>
                                    </tr>       

                                    <tr  style="font-size: 11px; height: 20px; padding: 3px 5px;"> 
                                        <th  colspan="5" style="padding: 3px 5px;">GST</th>
                                            <c:if test="${vendor_code1 != ''}">
                                            <td style="padding: 3px 5px;">${servicegst1}</td>
                                            <td style="padding: 3px 5px;">${servicegstFinal1}</td>

                                            <c:if test="${rev_submit_flag1 == '1'}">
                                                <td style="padding: 3px 5px;">${revservicegst1}</td>
                                                <td style="padding: 3px 5px;">${revservicegstFinal1}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code2 != ''}">
                                            <td style="padding: 3px 5px;">${servicegst2}</td>
                                            <td style="padding: 3px 5px;">${servicegstFinal2}</td>

                                            <c:if test="${rev_submit_flag2 == '1'}">
                                                <td style="padding: 3px 5px;">${revservicegst2}</td>
                                                <td style="padding: 3px 5px;">${revservicegstFinal2}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code3 != ''}">
                                            <td style="padding: 3px 5px;">${servicegst3}</td>
                                            <td style="padding: 3px 5px;">${servicegstFinal3}</td>

                                            <c:if test="${rev_submit_flag3 == '1'}">
                                                <td style="padding: 3px 5px;">${revservicegst3}</td>
                                                <td style="padding: 3px 5px;">${revservicegstFinal3}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code4 != ''}">
                                            <td style="padding: 3px 5px;">${servicegst4}</td>
                                            <td style="padding: 3px 5px;">${servicegstFinal4}</td>

                                            <c:if test="${rev_submit_flag4 == '1'}">
                                                <td style="padding: 3px 5px;">${revservicegst4}</td>
                                                <td style="padding: 3px 5px;">${revservicegstFinal4}</td>
                                            </c:if>

                                        </c:if>    
                                    </tr> 
                                    <tr  style="font-size: 11px; height: 20px; padding: 3px 5px;"> 
                                        <th  colspan="5" style="padding: 3px 5px;">Final Evaluated Price</th>
                                            <c:if test="${vendor_code1 != ''}">
                                            <td style="padding: 3px 5px;"></td>
                                            <td style="padding: 3px 5px;">${serviceTaxTotal1}</td>

                                            <c:if test="${rev_submit_flag1 == '1'}">
                                                <td style="padding: 3px 5px;"></td>
                                                <td style="padding: 3px 5px;">${revserviceTaxTotal1}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code2 != ''}">
                                            <td style="padding: 3px 5px;"></td>
                                            <td style="padding: 3px 5px;">${serviceTaxTotal2}</td>

                                            <c:if test="${rev_submit_flag2 == '1'}">
                                                <td style="padding: 3px 5px;"></td>
                                                <td style="padding: 3px 5px;">${revserviceTaxTotal2}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code3 != ''}">
                                            <td style="padding: 3px 5px;"></td>
                                            <td style="padding: 3px 5px;">${serviceTaxTotal3}</td>


                                            <c:if test="${rev_submit_flag3 == '1'}">
                                                <td style="padding: 3px 5px;"></td>
                                                <td style="padding: 3px 5px;">${revserviceTaxTotal3}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code4 != ''}">
                                            <td style="padding: 3px 5px;"></td>
                                            <td style="padding: 3px 5px;">${serviceTaxTotal4}</td>


                                            <c:if test="${rev_submit_flag4 == '1'}">
                                                <td style="padding: 3px 5px;"></td>
                                                <td style="padding: 3px 5px;">${revserviceTaxTotal4}</td>
                                            </c:if>

                                        </c:if>    
                                    </tr>     
                                    <tr  style="font-size: 11px; height: 20px; padding: 3px 5px;"> 
                                        <th  colspan="5" style="padding: 3px 5px;">Rating</th>
                                            <c:if test="${vendor_code1 != ''}">
                                            <td style="padding: 3px 5px;"></td>
                                            <td style="padding: 3px 5px;">${rank1}</td>

                                            <c:if test="${rev_submit_flag1 == '1'}">
                                                <td style="padding: 3px 5px;"></td>
                                                <td style="padding: 3px 5px;">${rank1}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code2 != ''}">
                                            <td style="padding: 3px 5px;"></td>
                                            <td style="padding: 3px 5px;">${rank2}</td>

                                            <c:if test="${rev_submit_flag2 == '1'}">
                                                <td style="padding: 3px 5px;"></td>
                                                <td style="padding: 3px 5px;">${rank2}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code3 != ''}">
                                            <td style="padding: 3px 5px;"></td>
                                            <td style="padding: 3px 5px;">${rank3}</td>

                                            <c:if test="${rev_submit_flag3 == '1'}">
                                                <td style="padding: 3px 5px;"></td>
                                                <td style="padding: 3px 5px;">${rank3}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code4 != ''}">
                                            <td style="padding: 3px 5px;"></td>
                                            <td style="padding: 3px 5px;">${rank4}</td>

                                            <c:if test="${rev_submit_flag4 == '1'}">
                                                <td style="padding: 3px 5px;"></td>
                                                <td style="padding: 3px 5px;">${rank4}</td>
                                            </c:if>

                                        </c:if>    
                                    </tr>

                                    <tr  style="font-size: 11px; height: 20px; padding: 3px 5px;"> 
                                        <th  colspan="5" style="padding: 3px 5px;">No. Of Item Regreted</th>
                                            <c:if test="${vendor_code1 != ''}">
                                            <td style="padding: 3px 5px;"></td>
                                            <td style="padding: 3px 5px;">${regret1}</td>

                                            <c:if test="${rev_submit_flag1 == '1'}">
                                                <td style="padding: 3px 5px;"></td>
                                                <td style="padding: 3px 5px;">${regret1}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code2 != ''}">
                                            <td style="padding: 3px 5px;"></td>
                                            <td style="padding: 3px 5px;">${regret2}</td>

                                            <c:if test="${rev_submit_flag2 == '1'}">
                                                <td style="padding: 3px 5px;"></td>
                                                <td style="padding: 3px 5px;">${regret2}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code3 != ''}">
                                            <td style="padding: 3px 5px;"></td>
                                            <td style="padding: 3px 5px;">${regret3}</td>


                                            <c:if test="${rev_submit_flag3 == '1'}">
                                                <td style="padding: 3px 5px;"></td>
                                                <td style="padding: 3px 5px;">${regret3}</td>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${vendor_code4 != ''}">
                                            <td style="padding: 3px 5px;"></td>
                                            <td style="padding: 3px 5px;">${regret4}</td>


                                            <c:if test="${rev_submit_flag4 == '1'}">
                                                <td style="padding: 3px 5px;"></td>
                                                <td style="padding: 3px 5px;">${regret4}</td>
                                            </c:if>
                                        </c:if>    
                                    </tr>  



                                </c:if>
                            </table>
                        </c:if>
                        <br>  

                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover " style="" align="Center"  >
                            <tr  style="font-size: 11px; height: 20px; padding: 3px 5px;"> 
                                <td colspan="3" style="padding: 3px 5px;"><strong>Vendor Code</strong></td>
                                <c:if test="${vendor_code1 != ''}">
                                    <td colspan="2" style="padding: 3px 5px;">${vendor_code1}</td>
                                    <c:if test="${rev_submit_flag1 == '1'}">
                                        <td colspan="2" style="padding: 3px 5px;">${vendor_code1}</td>
                                    </c:if> 
                                </c:if>
                                <c:if test="${vendor_code2 != ''}">
                                    <td colspan="2" style="padding: 3px 5px;">${vendor_code2}</td>
                                    <c:if test="${rev_submit_flag2 == '1'}">
                                        <td colspan="2" style="padding: 3px 5px;">${vendor_code2}</td>
                                    </c:if> 
                                </c:if>
                                <c:if test="${vendor_code3 != ''}">
                                    <td colspan="2" style="padding: 3px 5px;">${vendor_code3}</td>
                                    <c:if test="${rev_submit_flag3 == '1'}">
                                        <td colspan="2" style="padding: 3px 5px;">${vendor_code3}</td>
                                    </c:if> 
                                </c:if>
                                <c:if test="${vendor_code4 != ''}">
                                    <td colspan="2" style="padding: 3px 5px;">${vendor_code4}</td>
                                    <c:if test="${rev_submit_flag4 == '1'}">
                                        <td colspan="2" style="padding: 3px 5px;">${vendor_code4}</td>
                                    </c:if> 
                                </c:if>     
                            </tr>

                            <c:set var="count" value="0" scope="page" />                          
                            <tr  style="font-size: 11px; height: 20px; padding: 3px 5px;"> 

                                <th  colspan="3" style="padding: 3px 5px;">Vendor Name </th>
                                    <c:if test="${vendor_code1 != ''}">
                                    <td colspan="2" style="padding: 3px 5px;">${vendor_name1}</td>
                                    <c:if test="${rev_submit_flag1 == '1'}">
                                        <td colspan="2" style="padding: 3px 5px;">${vendor_name1}</td>
                                    </c:if>
                                </c:if>
                                <c:if test="${vendor_code2 != ''}">
                                    <td colspan="2" style="padding: 3px 5px;">${vendor_name2}</td>
                                    <c:if test="${rev_submit_flag2 == '1'}">
                                        <td colspan="2" style="padding: 3px 5px;">${vendor_name2}</td>
                                    </c:if>
                                </c:if>
                                <c:if test="${vendor_code3 != ''}">
                                    <td colspan="2" style="padding: 3px 5px;">${vendor_name3}</td>
                                    <c:if test="${rev_submit_flag3 == '1'}">
                                        <td colspan="2" style="padding: 3px 5px;">${vendor_name3}</td>
                                    </c:if>
                                </c:if>

                                <c:if test="${vendor_code4 != ''}">
                                    <td colspan="2" style="padding: 3px 5px;">${vendor_name4}</td>
                                    <c:if test="${rev_submit_flag4 == '1'}">
                                        <td colspan="2" style="padding: 3px 5px;">${vendor_name4}</td>
                                    </c:if>
                                </c:if>    
                            </tr> 
                        </table>
                        <br>   
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover " style="" align="Center"  >

                            <tr class="table-title" style="font-size: 11px; height: 20px; padding: 3px 5px;"> 
                                <th style="padding: 3px 5px;">Terms Condition</th>
                                <th style="padding: 3px 5px;">Description</th>
                                    <c:if test="${vendor_code1 != ''}">
                                    <th style="padding: 3px 5px;">Response</th>
                                    <th style="padding: 3px 5px;">Remark</th>
                                        <c:if test="${rev_submit_flag1 == '1'}">
                                        <th style="padding: 3px 5px;">Response</th>
                                        <th style="padding: 3px 5px;">Remark</th>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                    <th style="padding: 3px 5px;">Response</th>
                                    <th style="padding: 3px 5px;">Remark</th>
                                        <c:if test="${rev_submit_flag2 == '1'}">
                                        <th style="padding: 3px 5px;">Response</th>
                                        <th style="padding: 3px 5px;">Remark</th>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                    <th style="padding: 3px 5px;">Response</th>
                                    <th style="padding: 3px 5px;">Remark</th>
                                        <c:if test="${rev_submit_flag3 == '1'}">
                                        <th style="padding: 3px 5px;">Response</th>
                                        <th style="padding: 3px 5px;">Remark</th>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                    <th style="padding: 3px 5px;">Response</th>
                                    <th style="padding: 3px 5px;">Remark</th>
                                        <c:if test="${rev_submit_flag4 == '1'}">
                                        <th style="padding: 3px 5px;">Response</th>
                                        <th style="padding: 3px 5px;">Remark</th>
                                        </c:if>
                                    </c:if>        
                            </tr>
                            <c:forEach var="vendorTermsCondition1" items="${vendorTermsCondition1}" varStatus="status">
                                <tr  style="font-size: 11px; height: 20px; padding: 3px 5px;"> 
                                    <td style="padding: 3px 5px;">${vendorTermsCondition1.termsCondition}</td>
                                    <td style="padding: 3px 5px;" >${vendorTermsCondition1.description}</td>


                                    <!-- /vendor 1/ start here-->

                                    <c:if test="${vendor_code1 != ''}">
                                        <c:forEach var="vendorTermsConditionPriceBid1" items="${vendorTermsConditionPriceBid1}">
                                            <c:if test="${vendorTermsCondition1.termsCondition==vendorTermsConditionPriceBid1.termsCondition && vendorTermsCondition1.description==vendorTermsConditionPriceBid1.description}">

                                                <td style="padding: 3px 5px;"> 

                                                    <c:choose>
                                                        <c:when test="${vendorTermsConditionPriceBid1.response == 0}">
                                                            Accept
                                                        </c:when>
                                                        <c:otherwise>
                                                            Reject
                                                        </c:otherwise>
                                                    </c:choose>

                                                </td>
                                                <td style="padding: 3px 5px;">${vendorTermsConditionPriceBid1.comment}</td>
                                            </c:if>
                                        </c:forEach>
                                        <c:if test="${rev_submit_flag1 == '1'}">


                                            <td style="padding: 3px 5px;"> 
                                                <c:choose>
                                                    <c:when test="${vendorTermsCondition1.response == 0}">
                                                        Accept
                                                    </c:when>
                                                    <c:otherwise>
                                                        Reject
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>

                                            <td style="padding: 3px 5px;">${vendorTermsCondition1.comment}</td>
                                        </c:if>

                                    </c:if>

                                    <!-- /vendor 1/ end here-->

                                    <!-- /vendor 2/ Start here-->

                                    <c:if test="${vendor_code2 != ''}">
                                        <c:forEach var="vendorTermsConditionPriceBid2" items="${vendorTermsConditionPriceBid2}" varStatus="status1">
                                            <c:if test="${vendorTermsCondition1.termsCondition == vendorTermsConditionPriceBid2.termsCondition && vendorTermsCondition1.description==vendorTermsConditionPriceBid2.description}">

                                                <td style="padding: 3px 5px;">
                                                    <c:choose>
                                                        <c:when test="${vendorTermsConditionPriceBid2.response == 0}">
                                                            Accept
                                                        </c:when>
                                                        <c:otherwise>
                                                            Reject
                                                        </c:otherwise>
                                                    </c:choose>
                                                </td>
                                                <td style="padding: 3px 5px;">${vendorTermsConditionPriceBid2.comment}</td>
                                            </c:if>
                                        </c:forEach>
                                        <c:if test="${rev_submit_flag2 == '1'}">
                                            <c:forEach var="vendorTermsCondition2" items="${vendorTermsCondition2}" varStatus="status1">
                                                <c:if test="${vendorTermsCondition1.termsCondition == vendorTermsCondition2.termsCondition}">

                                                    <td style="padding: 3px 5px;">
                                                        <c:choose>
                                                            <c:when test="${vendorTermsCondition2.response == 0}">
                                                                Accept
                                                            </c:when>
                                                            <c:otherwise>
                                                                Reject
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>
                                                    <td style="padding: 3px 5px;">${vendorTermsCondition2.comment}</td>
                                                </c:if>
                                            </c:forEach>
                                        </c:if>
                                    </c:if>
                                    <!-- /vendor 2/ end here-->

                                    <!-- /vendor 3/ Start here-->

                                    <c:if test="${vendor_code3 != ''}">
                                        <c:forEach var="vendorTermsConditionPriceBid3" items="${vendorTermsConditionPriceBid3}" varStatus="status1">
                                            <c:if test="${vendorTermsCondition1.termsCondition == vendorTermsConditionPriceBid3.termsCondition && vendorTermsCondition1.description==vendorTermsConditionPriceBid3.description}">

                                                <td style="padding: 3px 5px;">
                                                    <c:choose>
                                                        <c:when test="${vendorTermsConditionPriceBid3.response == 0}">
                                                            Accept
                                                        </c:when>
                                                        <c:otherwise>
                                                            Reject
                                                        </c:otherwise>
                                                    </c:choose>
                                                </td>
                                                <td style="padding: 3px 5px;">${vendorTermsConditionPriceBid3.comment}</td>
                                            </c:if>
                                        </c:forEach>
                                        <c:if test="${rev_submit_flag3 == '1'}">
                                            <c:forEach var="vendorTermsCondition3" items="${vendorTermsCondition3}" varStatus="status1">
                                                <c:if test="${vendorTermsCondition1.termsCondition == vendorTermsCondition3.termsCondition}">
                                                    <td style="padding: 3px 5px;">
                                                        <c:choose>
                                                            <c:when test="${vendorTermsCondition3.response == 0}">
                                                                Accept
                                                            </c:when>
                                                            <c:otherwise>
                                                                Reject
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>
                                                    <td style="padding: 3px 5px;">${vendorTermsCondition3.comment}</td>
                                                </c:if>
                                            </c:forEach>
                                        </c:if>
                                    </c:if>

                                    <!-- /vendor 3/ end here-->  

                                    <!-- /vendor 4/ Start here-->

                                    <c:if test="${vendor_code4 != ''}">
                                        <c:forEach var="vendorTermsConditionPriceBid4" items="${vendorTermsConditionPriceBid4}" varStatus="status1">
                                            <c:if test="${vendorTermsCondition1.termsCondition == vendorTermsConditionPriceBid4.termsCondition && vendorTermsCondition1.description==vendorTermsConditionPriceBid4.description}">

                                                <td style="padding: 3px 5px;">
                                                    <c:choose>
                                                        <c:when test="${vendorTermsConditionPriceBid4.response == 0}">
                                                            Accept
                                                        </c:when>
                                                        <c:otherwise>
                                                            Reject
                                                        </c:otherwise>
                                                    </c:choose>
                                                </td>
                                                <td style="padding: 3px 5px;">${vendorTermsConditionPriceBid4.comment}</td>
                                            </c:if>
                                        </c:forEach>
                                        <c:if test="${rev_submit_flag4 == '1'}">
                                            <c:forEach var="vendorTermsCondition4" items="${vendorTermsCondition4}" varStatus="status1">
                                                <c:if test="${vendorTermsCondition1.termsCondition == vendorTermsCondition4.termsCondition}">

                                                    <td style="padding: 3px 5px;">
                                                        <c:choose>
                                                            <c:when test="${vendorTermsCondition4.response == 0}">
                                                                Accept
                                                            </c:when>
                                                            <c:otherwise>
                                                                Reject
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>
                                                    <td style="padding: 3px 5px;">${vendorTermsCondition4.comment}</td>
                                                </c:if>
                                            </c:forEach>
                                        </c:if>
                                    </c:if>

                                    <!-- /vendor 4/ end here-->
                                </tr>

                            </c:forEach>
                        </table>    
                        <br>
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover " style="" align="Center"  >

                            <tr class="table-title" style="font-size: 11px; height: 20px; padding: 3px 5px;"> 
                                <th style="padding: 3px 5px;">Vendor Code</th>
                                <th style="padding: 3px 5px;">Vendor Name</th>
                                <th style="padding: 3px 5px;">Supply Part</th>
                                <th style="padding: 3px 5px;">Service Part</th>
                                <th style="padding: 3px 5px;">Basic Total</th>
                                <th style="padding: 3px 5px;">GST Value</th>
                                <th style="padding: 3px 5px;">Total including Tax</th>
                                <th style="padding: 3px 5px;">Budget Value</th>
                                <th style="padding: 3px 5px;">Difference Between Budget Value VS Received Proposal</th>
                                <th style="padding: 3px 5px;">Difference In Percentage</th>
                            </tr>
                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;"> 
                                <td style="padding: 3px 5px;">${vendor_code1}</td>
                                <td style="padding: 3px 5px;">${vendor_name1}</td>

                                <c:if test="${(Total1 - igstValueFinal1) > 0}">
                                    <td style="padding: 3px 5px;">
                                        <fmt:formatNumber value="${Total1 - igstValueFinal1}" type="number" minFractionDigits="2" maxFractionDigits="2"/>
                                    </td>
                                </c:if>
                                <c:if test="${(Total1 - igstValueFinal1) <= 0}">
                                    <td style="padding: 3px 5px;"></td> 
                                </c:if>

                                <td style="padding: 3px 5px;"><fmt:formatNumber value="${serviceTaxTotal1 - servicegstFinal1}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                <td style="padding: 3px 5px;"><fmt:formatNumber value="${(serviceTaxTotal1 - servicegstFinal1) + (Total1 - igstValueFinal1)}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                <td style="padding: 3px 5px;"><fmt:formatNumber value="${servicegstFinal1 + igstValueFinal1}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                <td style="padding: 3px 5px;"><fmt:formatNumber value="${Total1 + serviceTaxTotal1}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                <td style="padding: 3px 5px;"><fmt:formatNumber value="${tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                <td style="padding: 3px 5px;"><fmt:formatNumber value="${tenderMaster.value - Total1 - serviceTaxTotal1}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                <td style="padding: 3px 5px;"></td>
                            </tr>
                            <c:if test="${rev_submit_flag1 == '1'}">
                                <tr style="font-size: 11px; height: 20px; padding: 3px 5px;"> 
                                    <td style="padding: 3px 5px;">${vendor_code1} Revise</td>
                                    <td style="padding: 3px 5px;">${vendor_name1}</td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${revTotal1 - revigstValueFinal1}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${revserviceTaxTotal1 - revservicegstFinal1}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${(revserviceTaxTotal1 - revservicegstFinal1) + (revTotal1 - revigstValueFinal1)}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${revservicegstFinal1 + revigstValueFinal1}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${revTotal1 + revserviceTaxTotal1}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${tenderMaster.value - revTotal1 - revserviceTaxTotal1}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td style="padding: 3px 5px;"></td>
                                </tr>
                            </c:if>
                            <c:if test="${vendor_code2 != ''}">
                                <tr style="font-size: 11px; height: 20px; padding: 3px 5px;"> 
                                    <td style="padding: 3px 5px;">${vendor_code2}</td>
                                    <td style="padding: 3px 5px;">${vendor_name2}</td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${Total2 - igstValueFinal2}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${serviceTaxTotal2 - servicegstFinal2}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${(serviceTaxTotal2 - servicegstFinal2) + (Total2 - igstValueFinal2)}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${servicegstFinal2 + igstValueFinal2}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${Total2 + serviceTaxTotal2}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${tenderMaster.value - Total2 - serviceTaxTotal2}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td style="padding: 3px 5px;"></td>
                                </tr>
                                <c:if test="${rev_submit_flag2 == '1'}">
                                    <tr style="font-size: 11px; height: 20px; padding: 3px 5px;"> 

                                        <td style="padding: 3px 5px;">${vendor_code2} Revise</td>
                                        <td style="padding: 3px 5px;">${vendor_name2}</td>
                                        <td style="padding: 3px 5px;"><fmt:formatNumber value="${revTotal2 - revigstValueFinal2}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td style="padding: 3px 5px;"><fmt:formatNumber value="${revserviceTaxTotal2 - revservicegstFinal2}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td style="padding: 3px 5px;"><fmt:formatNumber value="${(revserviceTaxTotal2 - revservicegstFinal2) + (revTotal2 - revigstValueFinal2)}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td style="padding: 3px 5px;"><fmt:formatNumber value="${revservicegstFinal2 + revigstValueFinal2}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td style="padding: 3px 5px;"><fmt:formatNumber value="${revTotal2 + revserviceTaxTotal2}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td style="padding: 3px 5px;"><fmt:formatNumber value="${tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td style="padding: 3px 5px;"><fmt:formatNumber value="${tenderMaster.value - revTotal2 - revserviceTaxTotal2}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td style="padding: 3px 5px;"></td>
                                    </tr>
                                </c:if>
                            </c:if>
                            <c:if test="${vendor_code3 != ''}">
                                <tr style="font-size: 11px; height: 20px; padding: 3px 5px;"> 

                                    <td style="padding: 3px 5px;">${vendor_code3}</td>
                                    <td style="padding: 3px 5px;">${vendor_name3}</td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${Total3 - igstValueFinal3}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${serviceTaxTotal3 - servicegstFinal3}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${(serviceTaxTotal3 - servicegstFinal3) + (Total3 - igstValueFinal3)}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${servicegstFinal3 + igstValueFinal3}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${Total3 + serviceTaxTotal3}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${tenderMaster.value - Total3 - serviceTaxTotal3}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td style="padding: 3px 5px;"></td>
                                </tr>
                                <c:if test="${rev_submit_flag3 == '1'}">
                                    <tr style="font-size: 11px; height: 20px; padding: 3px 5px;"> 

                                        <td style="padding: 3px 5px;">${vendor_code3} Revise</td>
                                        <td style="padding: 3px 5px;">${vendor_name3}</td>
                                        <td style="padding: 3px 5px;"><fmt:formatNumber value="${revTotal3 - revigstValueFinal3}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td style="padding: 3px 5px;"><fmt:formatNumber value="${revserviceTaxTotal3 - revservicegstFinal3}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td style="padding: 3px 5px;"><fmt:formatNumber value="${(revserviceTaxTotal3 - revservicegstFinal3) + (revTotal3 - revigstValueFinal3)}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td style="padding: 3px 5px;"><fmt:formatNumber value="${revservicegstFinal3 + revigstValueFinal3}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td style="padding: 3px 5px;"><fmt:formatNumber value="${revTotal3 + revserviceTaxTotal3}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td style="padding: 3px 5px;"><fmt:formatNumber value="${tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td style="padding: 3px 5px;"><fmt:formatNumber value="${tenderMaster.value - revTotal3 - revserviceTaxTotal3}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td style="padding: 3px 5px;"></td>
                                    </tr>
                                </c:if>
                            </c:if>

                            <c:if test="${vendor_code4 != ''}">
                                <tr style="font-size: 11px; height: 20px; padding: 3px 5px;"> 

                                    <td style="padding: 3px 5px;">${vendor_code4}</td>
                                    <td style="padding: 3px 5px;">${vendor_name4}</td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${Total4 - igstValueFinal4}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${serviceTaxTotal4 - servicegstFinal4}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${(serviceTaxTotal4 - servicegstFinal4) + (Total4 - igstValueFinal4)}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${servicegstFinal4 + igstValueFinal4}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${Total4 + serviceTaxTotal4}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td style="padding: 3px 5px;"><fmt:formatNumber value="${tenderMaster.value - Total4 - serviceTaxTotal4}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td style="padding: 3px 5px;"></td>
                                </tr>
                                <c:if test="${rev_submit_flag4 == '1'}">
                                    <tr style="font-size: 11px; height: 20px; padding: 3px 5px;"> 

                                        <td style="padding: 3px 5px;">${vendor_code4} Revise</td>
                                        <td style="padding: 3px 5px;">${vendor_name4}</td>
                                        <td style="padding: 3px 5px;"><fmt:formatNumber value="${revTotal4 - revigstValueFinal4}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td style="padding: 3px 5px;"><fmt:formatNumber value="${revserviceTaxTotal4 - revservicegstFinal4}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td style="padding: 3px 5px;"><fmt:formatNumber value="${(revserviceTaxTotal4 - revservicegstFinal4) + (revTotal4 - revigstValueFinal4)}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td style="padding: 3px 5px;"><fmt:formatNumber value="${revservicegstFinal4 + revigstValueFinal4}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td style="padding: 3px 5px;"><fmt:formatNumber value="${revTotal4 + revserviceTaxTotal4}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td style="padding: 3px 5px;"><fmt:formatNumber value="${tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td style="padding: 3px 5px;"><fmt:formatNumber value="${tenderMaster.value - revTotal4 - revserviceTaxTotal4}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td style="padding: 3px 5px;"></td>
                                    </tr>
                                </c:if>
                            </c:if>
                        </table> 

                        <br>    

                        <table  class="flex-table" id="table_2" class="table table-bordered table-hover " style="" align="Center"  >


                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">

                                <td colspan="1" style="padding: 3px 5px;"><strong>Tender Date</strong></td>
                                <td colspan="2" style="padding: 3px 5px;">${tender_date}</td>
                                <td style="padding: 3px 5px;"><strong>Tender Due Date</strong></td>
                                <td colspan="3" style="padding: 3px 5px;">${tender_due_date}</td>

                            </tr>
                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">

                                <td colspan="1" style="padding: 3px 5px;"><strong>Bid Sent From No. Of Vendor</strong></td>
                                <td colspan="2" style="padding: 3px 5px;">${total_vendor}</td>
                                <td style="padding: 3px 5px;"><strong>Bid Received From No. Of Vendor</strong></td>
                                <td colspan="3" style="padding: 3px 5px;">${total_bid}</td>

                            </tr>

                        </table>  
                        <br>
                        <table  class="flex-table" id="table_2" class="table table-bordered table-hover " style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="10" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                    Activity Milestone
                                </td>
                            </tr>
                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">

                                <th style="padding: 3px 5px;">Sr No.</th>
                                <th style="padding: 3px 5px;">Activity</th>
                                <th style="padding: 3px 5px;">Activity By</th>
                                <th style="padding: 3px 5px;">Date</th>
                            </tr>

                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">

                                <td style="padding: 3px 5px;">1</td>
                                <td style="padding: 3px 5px;">PR Create</td>
                                <td style="padding: 3px 5px;">${prMaster.contactPerson}</td>
                                <td style="padding: 3px 5px;">${prMaster.announceDate}</td>
                            </tr>
                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">

                                <td style="padding: 3px 5px;">2</td>
                                <td style="padding: 3px 5px;">PR Approve</td>
                                <td style="padding: 3px 5px;">${prMaster.prAuthorizeUser}</td>
                                <td style="padding: 3px 5px;">${prMaster.prAuthorizeDate}</td>
                            </tr>
                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">

                                <td style="padding: 3px 5px;">3</td>
                                <td style="padding: 3px 5px;">Tender Assign By</td>
                                <td style="padding: 3px 5px;">${prMaster.tenderAssignUser}</td>
                                <td style="padding: 3px 5px;">${prMaster.tenderAssignDate}</td>
                            </tr>
                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">

                                <td style="padding: 3px 5px;">4</td>
                                <td style="padding: 3px 5px;">Tender Create</td>
                                <td style="padding: 3px 5px;">${prMaster.tenderCreaterUser}</td>
                                <td style="padding: 3px 5px;">${prMaster.tenderCreaterDate}</td>
                            </tr>
                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">

                                <td style="padding: 3px 5px;">5</td>
                                <td style="padding: 3px 5px;">Technical Bid Open</td>
                                <td style="padding: 3px 5px;">${prMaster.techBidOpenUser}</td>
                                <td style="padding: 3px 5px;">${prMaster.techBidOpenDate}</td>
                            </tr>
                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">

                                <td style="padding: 3px 5px;">6</td>
                                <td style="padding: 3px 5px;">Technical Bid Approve</td>
                                <td style="padding: 3px 5px;">${prMaster.techBidApproveUser}</td>
                                <td style="padding: 3px 5px;">${prMaster.techBidApproveDate}</td>
                            </tr>
                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">

                                <td style="padding: 3px 5px;">7</td>
                                <td style="padding: 3px 5px;">Price Bid Initiate</td>
                                <td style="padding: 3px 5px;">${prMaster.priceBidStartUser}</td>
                                <td style="padding: 3px 5px;">${prMaster.priceBidStartDate}</td>
                            </tr>
                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">

                                <td style="padding: 3px 5px;">8</td>
                                <td style="padding: 3px 5px;">Price Bid Open</td>
                                <td  style="padding: 3px 5px;">${prMaster.priceBidOpenUser}</td>
                                <td style="padding: 3px 5px;">${prMaster.priceBidOpenDate}</td>
                            </tr>

                        </table>   
                            <br>
                        <table  class="flex-table" id="table_2" class="table table-bordered table-hover " style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="10" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                    User Approval List
                                </td>
                            </tr>


                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                <th style="padding: 3px 5px;">Tender Ref No.</th>
                                <th style="padding: 3px 5px;">Comment</th>
                                <th style="padding: 3px 5px;">Attachment</th>
                                <!--<th style="padding: 3px 5px;" data-dt-order="disable">View</th>-->
                            </tr>
                            </thead>
                            <c:set var="count" value="0" scope="page" />

                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                <td style="padding: 3px 5px;">${tenderPriceApproval.tenderNo}</td>
                                <td style="padding: 3px 5px;">${tenderPriceApproval.approvalRemark}</td>
                                <td style="padding: 3px 5px;"><a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=vendorListViewDownload&id=${tenderPriceApproval.id}&refNo=${refNo}">${tenderPriceApproval.attachment}</a></td>
                                <!--<td style="padding: 3px 5px;"><a href="tenderMaster.htm?act=viewApproveUserList&id=${tenderPriceApproval.id}">View</a></td>-->
                            </tr>
                            </tbody>
                        </table>

                        <br> 
                        <c:if test="${not empty list3}">


                            <table  class="flex-table" id="table_2" class="table table-bordered table-hover " style="" align="Center"  >
                                <tr class="table-title">
                                    <td colspan="10" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                        Approval Comments
                                    </td>
                                </tr>
                                <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">

                                    <th style="padding: 3px 5px;">User Id</th>
                                    <th style="padding: 3px 5px;">Comment</th>
                                    <th style="padding: 3px 5px;">Date Time</th>
                                </tr>
                                <c:set var="count" value="0" scope="page" />

                                <c:forEach var="list2" items="${list3}" varStatus="status">
                                    <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">

                                        <td style="padding: 3px 5px;">${list2.userId}</td>
                                        <td style="padding: 3px 5px;">${list2.approvalComment}</td>
                                        <td style="padding: 3px 5px;">${list2.dateTime}</td>
                                    </tr>
                                </c:forEach>

                            </table>
                        </c:if>



                    </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooterPrint.jsp"%>
</html>
