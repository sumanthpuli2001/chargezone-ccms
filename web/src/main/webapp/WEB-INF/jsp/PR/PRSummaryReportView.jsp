
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PR SUMMARY REPORT</title>
        

    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form method="post">
                    <input type="hidden" name="id" value="${id}">  
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">PR SUMMARY REPORT</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                            <a href="prMaster.htm?act=prSummaryReportViewPrint&id=${id}" class="btn theme-btn">
                                <i class="fa fa-print"></i> Print
                            </a>

                        </div>
                    </div>

                    <c:forEach var="list2" items="${list2}" varStatus="status">
                        <h5 class="fw-600 mt-3">PR Details</h5>
                        <hr>
                        <div class="rounded-4 mt-4"> 
                            <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                                <div class="row buyer-info">
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>PR Reference No.</label>
                                            <p class="fw-600">${list2.prNo}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Item Category</label>
                                            <p class="fw-600">${list2.type}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>PR Classification</label>
                                            <p class="fw-600">${list2.categoryId}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-8 pb-1">
                                        <div class="form-group">
                                            <label>Project Name</label>
                                            <p class="fw-600">${list2.title}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-8 pb-1">
                                        <div class="form-group">
                                            <label>Project ID</label>
                                            <p class="fw-600">${list2.projectId}</p>
                                            <span class="text-right" style="display: block;">${!empty list2.projectIdUpdateDate ? 'Updated : '.concat(list2.projectIdUpdateDate) : ''}</span>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>PR Subject Description</label>
                                            <p class="fw-600">${list2.workDesc}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Plant</label>
                                            <p class="fw-600">${list2.plant}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Billing Location</label>
                                            <p class="fw-600">${list2.billingLocation}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Created By </label>
                                            <p class="fw-600">${list2.contactPerson}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>PR Date </label>
                                            <p class="fw-600">${list2.announceDate}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Created Contact Number </label>
                                            <p class="fw-600">${list2.prAdminContactNumber}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group ">
                                            <label>Technical Person Name </label>
                                            <p class="fw-600 text-break">${list2.technicalContactName}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Technical Person Contact Number </label>
                                            <p class="fw-600">${list2.technicalContactNo}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>PR Estimate Cost With GST </label>
                                            <p class="fw-600 currency">${list2.value}</p>
                                            <span class="text-right" style="display: block;">${!empty list2.budgetAmountUpdateDate ? 'Updated : '.concat(list2.budgetAmountUpdateDate) : ''}</span>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Min Quotes Required </label>
                                            <p class="fw-600">${list2.quotes}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Business Type </label>
                                            <p class="fw-600">${list2.businessType}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Project Type </label>
                                            <p class="fw-600">${list2.projectType}</p>
                                        </div>
                                    </div>                                        
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Delivery Period</label>
                                            <p class="fw-600">${list2.deliveryPeriod}</p>
                                        </div>
                                    </div>                                        
                                </div>
                            </div>
                        </div>
                    </c:forEach>             
                    
                    <c:if test="${!empty list6}">
                        <h5 class="fw-600">Site Address</h5>
                        <hr>
                        <table id="commonNoPageTable" class="table  table-striped bg-white" style="min-width: 100%" align="Center"  >
                            <thead>
                                <tr>
                                    <th>Sr. No.</th>
                                    <th>Address1</th>
                                    <th>Address2</th>
                                    <th>City</th>
                                    <th>State</th>
                                    <th>PIN Code</th>
                                    <th>Remarks</th>
                                </tr>
                            </thead>
                            <c:set var="count" value="0" scope="page" />
                            <tbody>
                                <c:forEach var="list6" items="${list6}" varStatus="status">
                                    <tr>
                                        <td style="text-align: center;">${status.count}</td>
                                        <td style="text-align: center;">${list6.address1}</td>
                                        <td style="text-align: center;">${list6.address2}</td>
                                        <td style="text-align: center;">${list6.city}</td>
                                        <td style="text-align: center;">${list6.state}</td>
                                        <td style="text-align: center;">${list6.pincode}</td>
                                        <td style="text-align: center;">${list6.remark}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table> 
                        <br>
                    </c:if>
                        
                    <c:if test="${!empty approvalList}">
                        <h5 class="fw-600">PR Approval Details </h5>
                        <hr>
                        <table id="commonNoPageTable0" class="table  table-striped bg-white" style="width: 100%" align="Center"  >
                            <thead>
                                <tr>
                                    <th>Sr No.</th>
                                    <th>User</th>
                                    <th>Date Time</th>
                                    <th>Comment </th>
                                    <th>Approval Status</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="approvalList" items="${approvalList}" varStatus="status">
                                    <tr> 
                                        <td>${status.count}</td>
                                        <td>${approvalList.userId}</td>
                                        <td>${approvalList.dateTime}</td>
                                        <td>${approvalList.comment}</td>
                                        <td>${approvalList.approvalStatus}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <br>
                    </c:if>
                    
                    <c:if test="${!empty tenderMaster.refNo}">   
                        <h5 class="fw-600">Tender Assign Details</h5>
                        <hr>
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
                                            <label>Tender Assign User</label>
                                            <p class="fw-600">${prMaster.tenderAssignUser}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Tender Assign User Date</label>
                                            <p class="fw-600">${prMaster.tenderAssignDate}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-8 pb-1">
                                        <div class="form-group">
                                            <label>Tender Creator</label>
                                            <p class="fw-600">${prMaster.tenderCreaterUser}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-8 pb-1">
                                        <div class="form-group">
                                            <label>Tender Creator Date Time</label>
                                            <p class="fw-600">${prMaster.tenderCreaterDate}</p>
                                        </div>
                                    </div>                                                                       
                                </div>
                            </div>
                        </div> 

                        <h5 class="fw-600">Tender Details</h5>
                        <hr>
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
                                            <label>Tender Phase</label>
                                            <p class="fw-600">${tenderMaster.tenderPhase} Part</p>
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
                                            <label>Project Name</label>
                                            <p class="fw-600">${tenderMaster.title}</p>
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
                                            <label>Tender Date</label>
                                            <p class="fw-600">${tender_date}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Tender Due Date</label>
                                            <p class="fw-600">${tender_due_date}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Mode Of Transport</label>
                                            <p class="fw-600">${tenderMaster.modeOfTransport}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Terms Of Payment</label>
                                            <p class="fw-600">${tenderMaster.termsOfPayment}</p>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </c:if>
                        
                    <c:if test="${!empty tenderVendorList}">
                        <h5 class="fw-600">Details of Invited Vendors</h5>
                        <hr>
                        <table id="commonNoPageTable1" class="table  table-striped bg-white" style="width: 100%" align="Center"  >
                            <thead>
                                <tr>
                                    <th>Sr No.</th>
                                    <th>Vendor Id</th>
                                    <th>Vendor Name</th>
                                    <th>Vendor Address</th>
                                    <th>E-mail ID</th>
                                    <th>Mobile No</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="tenderVendor1" items="${tenderVendorList}" varStatus="status">
                                    <tr> 
                                        <td>${status.count}</td>
                                        <td>${tenderVendor1.vendorCode}</td>
                                        <td>${tenderVendor1.vendorName}</td>
                                        <td>${tenderVendor1.address}</td>
                                        <td>${tenderVendor1.emailId}</td>
                                        <td>${tenderVendor1.mobileNo}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <br>
                    </c:if>
                    
                    <c:if test="${tenderMaster.tenderPhase == 2 && !empty prMaster.techBidOpenUser}">
                        <h5 class="fw-600">Technical Bid Details</h5>
                        <hr>
                        <div class="rounded-4 mt-4"> 
                            <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                                <div class="row buyer-info">
                                    <div class="col-xxl-3 col-lg-3 col-md-3 pb-1">
                                        <div class="form-group">
                                            <label>Technical Bid Open By</label>
                                            <p class="fw-600">${prMaster.techBidOpenUser}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-3 col-lg-3 col-md-3 pb-1">
                                        <div class="form-group">
                                            <label>Technical Bid Open Date</label>
                                            <p class="fw-600">${prMaster.techBidOpenDate}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-3 col-lg-3 col-md-3 pb-1">
                                        <div class="form-group">
                                            <label>Technical Bid Approve By</label>
                                            <p class="fw-600">${prMaster.techBidApproveUser}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-3 col-lg-3 col-md-3 pb-1">
                                        <div class="form-group">
                                            <label>Technical Bid Approve Date</label>
                                            <p class="fw-600">${prMaster.techBidApproveDate}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <c:if test="${!empty techBidOpenList}">
                            <h5 class="fw-600">Details of Qualified Vendors for Technical Bid</h5>
                            <hr>
                            <table id="commonNoPageTable2" class="table  table-striped bg-white" style="width: 100%" align="Center"  >
                                <thead>
                                    <tr>
                                        <th>Sr No.</th>
                                        <th>Vendor Id</th>
                                        <th>Vendor Name</th>
                                        <th>Vendor Email Id</th>
                                        <th>Percentage</th>
                                        <th>Approve</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="list1" items="${techBidOpenList}" varStatus="status">
                                        <tr> 
                                            <td>${status.count}</td>
                                            <td>${list1[1]}</td>
                                            <td>${list1[2]}</td>
                                            <td>${list1[5]}</td>
                                            <td>${!empty list1[6] ? list1[6] : 'Not Qualified'}</td>
                                            <td>${!empty list1[8] ? (list1[8] == 1 ? 'Yes' : 'No') : 'Not Qualified'}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <br>
                        </c:if>
                    </c:if>
                    <c:if test="${!empty prMaster.priceBidOpenUser}">   
                        <h5 class="fw-600">Price Bid Details</h5>
                        <hr>
                        <div class="rounded-4 mt-4"> 
                            <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                                <div class="row buyer-info">
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Price Bid Initiate By</label>
                                            <p class="fw-600">${prMaster.priceBidStartUser}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Price Bid Initiate Date</label>
                                            <p class="fw-600">${prMaster.priceBidStartDate}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Price Bid Open By</label>
                                            <p class="fw-600">${prMaster.priceBidOpenUser}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Price Bid Open Date</label>
                                            <p class="fw-600">${prMaster.priceBidOpenDate}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Tender Final Close By</label>
                                            <p class="fw-600">${prMaster.finalCloseUser}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Tender Final Close Date</label>
                                            <p class="fw-600">${prMaster.finalCloseDate}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <c:if test="${!empty techBidOpenList}">
                            <h5 class="fw-600">Details of Qualified Vendors for Price Bid</h5>
                            <hr>
                            <table id="commonNoPageTable3" class="table  table-striped bg-white" style="width: 100%" align="Center"  >
                                <thead>
                                    <tr>
                                        <th>Sr No.</th>
                                        <th>Vendor Id</th>
                                        <th>Vendor Name</th>
                                        <th>Vendor Email Id</th>
                                        <th>Price</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="list1" items="${priceBidOpenList}" varStatus="status">
                                        <tr> 
                                            <td>${status.count}</td>
                                            <td>${list1[1]}</td>
                                            <td>${list1[2]}</td>
                                            <td>${list1[5]}</td>
                                            <td class="${!empty list1[7] ? 'currency' : '' }">${!empty list1[7] ? list1[7] : 'Not Qualified'}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <br>
                        </c:if>
                    </c:if>
                                    
                    <c:if test="${!empty vendorTenderBidItem1}">
                        <h5 class="fw-600">Price Bid Comparison With Revise Bid For Item</h5>
                        <hr>

                        <table id="commonNoPageTable4" class="table table-striped bg-white" style="min-width: 100%" align="Center" >

                            <thead>
                                <tr data-dt-order="disable" class="text-center">
                                    <th rowspan="3" style="min-width: 100px;">Sr No.</th>
                                    <th colspan="4">Vendor Code</th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <th colspan="2">${vendor_code1}</th>
                                        <c:if test="${rev_submit_flag1 == '1'}">
                                            <th colspan="2">${vendor_code1}</th>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <th colspan="2">${vendor_code2}</th>
                                        <c:if test="${rev_submit_flag2 == '1'}">
                                            <th colspan="2">${vendor_code2}</th>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <th colspan="2">${vendor_code3}</th>
                                        <c:if test="${rev_submit_flag3 == '1'}">
                                            <th colspan="2">${vendor_code3}</th>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <th colspan="2">${vendor_code4}</th>
                                        <c:if test="${rev_submit_flag4 == '1'}">
                                            <th colspan="2">${vendor_code4}</th>
                                        </c:if>
                                    </c:if>                                    
                                </tr>
                                
                                <tr data-dt-order="disable" class="text-center">
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
                                
                                <tr data-dt-order="disable">
                                    <th>Item Code</th>
                                    <th style="min-width: 250px;">Description</th>
                                    <th>Qty</th>
                                    <th>UOM</th>                                    
                                    <c:if test="${vendor_code1 != ''}">
                                        <th style="min-width: 100px;">Unit Price</th>
                                        <th style="min-width: 100px;">Value</th>
                                        <c:if test="${rev_submit_flag1 == '1'}">
                                            <th style="min-width: 100px;">Unit Price</th>
                                            <th style="min-width: 100px;">Value</th>
                                        </c:if>
                                    </c:if>                                       
                                    <c:if test="${vendor_code2 != ''}">
                                        <th style="min-width: 100px;">Unit Price</th>
                                        <th style="min-width: 100px;">Value</th>
                                        <c:if test="${rev_submit_flag2 == '1'}">
                                            <th style="min-width: 100px;">Unit Price</th>
                                            <th style="min-width: 100px;">Value</th>
                                        </c:if>
                                    </c:if>                                    
                                    <c:if test="${vendor_code3 != ''}">
                                        <th style="min-width: 100px;">Unit Price</th>
                                        <th style="min-width: 100px;">Value</th>
                                        <c:if test="${rev_submit_flag3 == '1'}">
                                            <th style="min-width: 100px;">Unit Price</th>
                                            <th style="min-width: 100px;">Value</th>
                                        </c:if>
                                    </c:if>                                    
                                    <c:if test="${vendor_code4 != ''}">
                                        <th style="min-width: 100px;">Unit Price</th>
                                        <th style="min-width: 100px;">Value</th>
                                        <c:if test="${rev_submit_flag4 == '1'}">
                                            <th style="min-width: 100px;">Unit Price</th>
                                            <th style="min-width: 100px;">Value</th>
                                        </c:if>
                                    </c:if>                                           
                                </tr>
                                
                            </thead>

                            <tbody>

                                <c:forEach var="item1" items="${vendorTenderBidItem1}" varStatus="status">
                                    <tr>
                                        <td class="text-center">${status.count}</td>
                                        <td>${item1[1]}</td>
                                        <td>${item1[2]}</td>
                                        <td>${item1[4]}</td>
                                        <td>${item1[3]}</td>

                                        <c:if test="${vendor_code1 != ''}">
                                            <td class="currency"> ${item1[5]}</td>
                                            <td class="currency"> ${item1[6]}</td>

                                            <c:if test="${rev_submit_flag1 == '1'}">

                                                <c:set var="revFound1" value="false" />

                                                <c:forEach var="rev1" items="${reviseVendorTenderBidItem1}">
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

                                            <c:forEach var="item2" items="${vendorTenderBidItem2}">
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

                                                <c:forEach var="rev2" items="${reviseVendorTenderBidItem2}">
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

                                            <c:forEach var="item3" items="${vendorTenderBidItem3}">
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

                                                <c:set var="revFound3" value="false" />

                                                <c:forEach var="rev3" items="${reviseVendorTenderBidItem3}">
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

                                            <c:forEach var="item4" items="${vendorTenderBidItem4}">
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

                                                <c:forEach var="rev4" items="${reviseVendorTenderBidItem4}">
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
                                    
                            </tbody>
                            <tfoot>
                                
                                <tr>
                                    <th colspan="5"><b>Ex-work Price/FOB</b></th>
                                    
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
                                    <th colspan="5"><b>Packing & Forwarding</b></th>
                                    
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
                                    <th  colspan="5"><b>Charges</b></th>
                                    
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
                                    <th colspan="5"><b>Insurance</b></th>
                                    
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
                                    <th  colspan="5"><b>Erection Commision</b></th>
                                    
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
                                    <th colspan="5"><b>Discount</b></th>
                                    
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
                                    <th colspan="5"><b>Final Evaluated Price without GST</b></th>
                                    
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
                                    <th colspan="5"><b>GST</b></th>
                                    
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
                                    <th colspan="5"><b>Final Evaluated Price</b></th>
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
                                    <th  colspan="5"><b>Rating</b></th>
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
                                    <th  colspan="5"><b>No Of Item Regret</b></th>
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

                            </tfoot>
                        </table>
                    </c:if>
                        
                    <c:if test = "${tenderMaster.type == 'Contract' || tenderMaster.type == 'Contract Civil' || tenderMaster.type == 'Contract Electrical'}">    
                        <c:if test="${!empty ServicevendorTenderBidItem1}">
                            <br>
                            <h5 class="fw-600">Price Bid Comparison With Revise Bid For Service</h5>
                            <hr>

                            <table id="commonNoPageTable5" class="table table-striped bg-white" style="min-width: 100%" align="Center" >

                                <thead>
                                    <tr data-dt-order="disable" class="text-center">
                                        <th rowspan="3" style="min-width: 100px;">Sr No.</th>
                                        <th colspan="4">Vendor Code</th>
                                            <c:if test="${vendor_code1 != ''}">
                                            <th colspan="2">${vendor_code1}</th>
                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                <th colspan="2">${vendor_code1}</th>
                                                </c:if>
                                            </c:if>
                                            <c:if test="${vendor_code2 != ''}">
                                            <th colspan="2">${vendor_code2}</th>
                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                <th colspan="2">${vendor_code2}</th>
                                                </c:if>
                                            </c:if>
                                            <c:if test="${vendor_code3 != ''}">
                                            <th colspan="2">${vendor_code3}</th>
                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                <th colspan="2">${vendor_code3}</th>
                                                </c:if>
                                            </c:if>
                                            <c:if test="${vendor_code4 != ''}">
                                            <th colspan="2">${vendor_code4}</th>
                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                <th colspan="2">${vendor_code4}</th>
                                                </c:if>
                                            </c:if>                                    
                                    </tr>

                                    <tr data-dt-order="disable" class="text-center">
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

                                    <tr data-dt-order="disable">
                                        <th>Item Code</th>
                                        <th style="min-width: 250px;">Description</th>
                                        <th>Qty</th>
                                        <th>UOM</th>                                    
                                            <c:if test="${vendor_code1 != ''}">
                                            <th style="min-width: 100px;">Unit Price</th>
                                            <th style="min-width: 100px;">Value</th>
                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                <th style="min-width: 100px;">Unit Price</th>
                                                <th style="min-width: 100px;">Value</th>
                                                </c:if>
                                            </c:if>                                       
                                            <c:if test="${vendor_code2 != ''}">
                                            <th style="min-width: 100px;">Unit Price</th>
                                            <th style="min-width: 100px;">Value</th>
                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                <th style="min-width: 100px;">Unit Price</th>
                                                <th style="min-width: 100px;">Value</th>
                                                </c:if>
                                            </c:if>                                    
                                            <c:if test="${vendor_code3 != ''}">
                                            <th style="min-width: 100px;">Unit Price</th>
                                            <th style="min-width: 100px;">Value</th>
                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                <th style="min-width: 100px;">Unit Price</th>
                                                <th style="min-width: 100px;">Value</th>
                                                </c:if>
                                            </c:if>                                    
                                            <c:if test="${vendor_code4 != ''}">
                                            <th style="min-width: 100px;">Unit Price</th>
                                            <th style="min-width: 100px;">Value</th>
                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                <th style="min-width: 100px;">Unit Price</th>
                                                <th style="min-width: 100px;">Value</th>
                                                </c:if>
                                            </c:if>                                           
                                    </tr>

                                </thead>

                                <tbody>

                                    <c:forEach var="item1" items="${ServicevendorTenderBidItem1}" varStatus="status">
                                        <tr>
                                            <td class="text-center">${status.count}</td>
                                            <td>${item1[1]}</td>
                                            <td>${item1[2]}</td>
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

                                                    <c:set var="revFound3" value="false" />

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

                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th colspan="5"><b>Ex-work Price/FOB</b></th>

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
                                        <th colspan="5"><b>Discount</b></th>

                                        <c:if test="${vendor_code1 != ''}">
                                            <td>${serviceDiscountValue1}%</td>
                                            <td class="currency">${serviceDiscountValueFinal1}</td>

                                            <c:if test="${rev_submit_flag1 == '1'}">
                                                <td>${revserviceDiscountValue1}%</td>
                                                <td class="currency">${revserviceDiscountValueFinal1}</td>
                                            </c:if>
                                        </c:if>

                                        <c:if test="${vendor_code2 != ''}">
                                            <td>${serviceDiscountValue2}%</td>
                                            <td class="currency">${serviceDiscountValueFinal2}</td>

                                            <c:if test="${rev_submit_flag2 == '1'}">
                                                <td>${revserviceDiscountValue2}%</td>
                                                <td class="currency">${revserviceDiscountValueFinal2}</td>
                                            </c:if>
                                        </c:if>

                                        <c:if test="${vendor_code3 != ''}">
                                            <td>${serviceDiscountValue3}%</td>
                                            <td class="currency">${serviceDiscountValueFinal3}</td>

                                            <c:if test="${rev_submit_flag3 == '1'}">
                                                <td>${revserviceDiscountValue3}%</td>
                                                <td class="currency">${revserviceDiscountValueFinal3}</td>
                                            </c:if>
                                        </c:if>

                                        <c:if test="${vendor_code4 != ''}">
                                            <td>${serviceDiscountValue4}%</td>
                                            <td class="currency">${serviceDiscountValueFinal4}</td>

                                            <c:if test="${rev_submit_flag4 == '1'}">
                                                <td>${revserviceDiscountValue4}%</td>
                                                <td class="currency">${revserviceDiscountValueFinal4}</td>
                                            </c:if>
                                        </c:if>
                                    </tr>

                                    <tr>
                                        <th colspan="5"><b>Final Evaluated Price without GST</b></th>

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
                                        <th colspan="5"><b>GST</b></th>

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
                                        <th colspan="5"><b>Final Evaluated Price</b></th>
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
                                        <th  colspan="5"><b>Rating</b></th>
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
                                        <th  colspan="5"><b>No Of Item Regret</b></th>
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
                                </tfoot>
                            </table>
                        </c:if>
                        <br>            
                    </c:if>                    
                    <c:if test="${!empty vendor_code1}">    
                        <h5 class="fw-600 mt-3">Commercial Summary Comparison Vendor Wise</h5>
                        <hr>
                        <table id="commonNoPageTable6" class="table table-striped bg-white" style="min-width:100%" align="center">
                            <thead>
                                <tr data-dt-order="disable">
                                    <th>Vendor Code</th>
                                    <th>Vendor Name</th>
                                    <th style="min-width: 120px;">Supply Part</th>
                                    <th style="min-width: 120px;">Service Part</th>
                                    <th style="min-width: 120px;">Basic Total</th>
                                    <th style="min-width: 120px;">GST Value</th>
                                    <th style="min-width: 120px;">Total including Tax</th>
                                    <th style="min-width: 200px;">Budget Value</th>
                                    <th>Difference Between Budget Value VS Received Proposal</th>
                                    <th>Difference In Percentage</th>
                                </tr>
                            </thead>      
                            <tbody>
                                <tr>
                                    <td>${vendor_code1}</td>
                                    <td>${vendor_name1}</td>
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
                                        <td>${vendor_code1} Revise</td>
                                        <td>${vendor_name1}</td>
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
                                        <td>${vendor_code2}</td>
                                        <td>${vendor_name2}</td>
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
                                            <td>${vendor_code2} Revise</td>
                                            <td>${vendor_name2}</td>
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
                                        <td>${vendor_code3}</td>
                                        <td>${vendor_name3}</td>
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
                                            <td>${vendor_code3} Revise</td>
                                            <td>${vendor_name3}</td>
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
                                        <td>${vendor_code4}</td>
                                        <td>${vendor_name4}</td>
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
                                            <td>${vendor_code4} Revise</td>
                                            <td>${vendor_name4}</td>
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
                        <br>
                    </c:if>
                        
                    <c:if test="${!empty vendorTermsCondition1}">
                        <h5 class="fw-600">Terms & Condition Comparison</h5>
                        <hr>
                        <table id="commonNoPageTable7" class="table table-striped bg-white" style="min-width:100%" align="center">

                            <thead>

                                <tr class="text-center" data-dt-order="disable">

                                    <th rowspan="3">Sr No.</th>
                                    <th colspan="2">Vendor Code</th>                                    

                                    <c:if test="${vendor_code1 != ''}">
                                        <th colspan="2">${vendor_code1}</th>

                                        <c:if test="${rev_submit_flag1 == '1'}">
                                            <th colspan="2">${vendor_code1} Rev</th>
                                            </c:if>
                                        </c:if>

                                    <c:if test="${vendor_code2 != ''}">
                                        <th colspan="2">${vendor_code2}</th>

                                        <c:if test="${rev_submit_flag2 == '1'}">
                                            <th colspan="2">${vendor_code2} Rev</th>
                                            </c:if>
                                        </c:if>

                                    <c:if test="${vendor_code3 != ''}">
                                        <th colspan="2">${vendor_code3}</th>

                                        <c:if test="${rev_submit_flag3 == '1'}">
                                            <th colspan="2">${vendor_code3} Rev</th>
                                            </c:if>
                                        </c:if>

                                    <c:if test="${vendor_code4 != ''}">
                                        <th colspan="2">${vendor_code4}</th>

                                        <c:if test="${rev_submit_flag4 == '1'}">
                                            <th colspan="2">${vendor_code4} Rev</th>
                                            </c:if>
                                        </c:if>

                                </tr>

                                <tr class="text-center" data-dt-order="disable">
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

                                <tr class="text-center" data-dt-order="disable">
                                    <th style="min-width: 250px;">Terms Condition</th>
                                    <th style="min-width: 300px;">Description</th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <th>Response</th>
                                        <th>Remark</th>

                                        <c:if test="${rev_submit_flag1 == '1'}">
                                            <th>Response</th>
                                            <th>Remark</th>
                                            </c:if>
                                        </c:if>

                                    <c:if test="${vendor_code2 != ''}">
                                        <th>Response</th>
                                        <th>Remark</th>

                                        <c:if test="${rev_submit_flag2 == '1'}">
                                            <th>Response</th>
                                            <th>Remark</th>
                                            </c:if>
                                        </c:if>

                                    <c:if test="${vendor_code3 != ''}">
                                        <th>Response</th>
                                        <th>Remark</th>

                                        <c:if test="${rev_submit_flag3 == '1'}">
                                            <th>Response</th>
                                            <th>Remark</th>
                                            </c:if>
                                        </c:if>

                                    <c:if test="${vendor_code4 != ''}">
                                        <th>Response</th>
                                        <th>Remark</th>

                                        <c:if test="${rev_submit_flag4 == '1'}">
                                            <th>Response</th>
                                            <th>Remark</th>
                                            </c:if>
                                        </c:if>

                                </tr>

                            </thead>

                            <tbody>

                                <c:forEach var="vendorTermsCondition1" items="${vendorTermsCondition1}" varStatus="status">

                                    <tr>

                                        <td>${status.count}</td>
                                        <td>${vendorTermsCondition1.termsCondition}</td>
                                        <td>${vendorTermsCondition1.description}</td>


                                        <c:if test="${vendor_code1 != ''}">

                                            <c:set var="found1" value="false"/>

                                            <c:forEach var="v1" items="${vendorTermsConditionPriceBid1}">

                                                <c:if test="${vendorTermsCondition1.termsCondition == v1.termsCondition && vendorTermsCondition1.description == v1.description}">

                                                    <td>
                                                        <c:choose>
                                                            <c:when test="${v1.response == 0}">
                                                                Accept
                                                            </c:when>
                                                            <c:otherwise>
                                                                Reject
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>

                                                    <td>${v1.comment}</td>

                                                    <c:set var="found1" value="true"/>

                                                </c:if>

                                            </c:forEach>

                                            <c:if test="${found1 == false}">
                                                <td>-</td>
                                                <td>-</td>
                                            </c:if>


                                            <c:if test="${rev_submit_flag1 == '1'}">

                                                <c:set var="revFound1" value="false"/>

                                                <td>
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

                                            </c:if>

                                        </c:if>


                                        <c:if test="${vendor_code2 != ''}">

                                            <c:set var="found2" value="false"/>

                                            <c:forEach var="v2" items="${vendorTermsConditionPriceBid2}">

                                                <c:if test="${vendorTermsCondition1.termsCondition == v2.termsCondition && vendorTermsCondition1.description == v2.description}">

                                                    <td>
                                                        <c:choose>
                                                            <c:when test="${v2.response == 0}">
                                                                Accept
                                                            </c:when>
                                                            <c:otherwise>
                                                                Reject
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>

                                                    <td>${v2.comment}</td>

                                                    <c:set var="found2" value="true"/>

                                                </c:if>

                                            </c:forEach>

                                            <c:if test="${found2 == false}">
                                                <td>-</td>
                                                <td>-</td>
                                            </c:if>


                                            <c:if test="${rev_submit_flag2 == '1'}">

                                                <c:set var="revFound2" value="false"/>

                                                <c:forEach var="r2" items="${vendorTermsCondition2}">

                                                    <c:if test="${vendorTermsCondition1.termsCondition == r2.termsCondition}">

                                                        <td>
                                                            <c:choose>
                                                                <c:when test="${r2.response == 0}">
                                                                    Accept
                                                                </c:when>
                                                                <c:otherwise>
                                                                    Reject
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </td>

                                                        <td>${r2.comment}</td>

                                                        <c:set var="revFound2" value="true"/>

                                                    </c:if>

                                                </c:forEach>

                                                <c:if test="${revFound2 == false}">
                                                    <td>-</td>
                                                    <td>-</td>
                                                </c:if>

                                            </c:if>

                                        </c:if>


                                        <c:if test="${vendor_code3 != ''}">

                                            <c:set var="found3" value="false"/>

                                            <c:forEach var="v3" items="${vendorTermsConditionPriceBid3}">

                                                <c:if test="${vendorTermsCondition1.termsCondition == v3.termsCondition && vendorTermsCondition1.description == v3.description}">

                                                    <td>
                                                        <c:choose>
                                                            <c:when test="${v3.response == 0}">
                                                                Accept
                                                            </c:when>
                                                            <c:otherwise>
                                                                Reject
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>

                                                    <td>${v3.comment}</td>

                                                    <c:set var="found3" value="true"/>

                                                </c:if>

                                            </c:forEach>

                                            <c:if test="${found3 == false}">
                                                <td>-</td>
                                                <td>-</td>
                                            </c:if>


                                            <c:if test="${rev_submit_flag3 == '1'}">

                                                <c:set var="revFound3" value="false"/>

                                                <c:forEach var="r3" items="${vendorTermsCondition3}">

                                                    <c:if test="${vendorTermsCondition1.termsCondition == r3.termsCondition}">

                                                        <td>
                                                            <c:choose>
                                                                <c:when test="${r3.response == 0}">
                                                                    Accept
                                                                </c:when>
                                                                <c:otherwise>
                                                                    Reject
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </td>

                                                        <td>${r3.comment}</td>

                                                        <c:set var="revFound3" value="true"/>

                                                    </c:if>

                                                </c:forEach>

                                                <c:if test="${revFound3 == false}">
                                                    <td>-</td>
                                                    <td>-</td>
                                                </c:if>

                                            </c:if>

                                        </c:if>


                                        <c:if test="${vendor_code4 != ''}">

                                            <c:set var="found4" value="false"/>

                                            <c:forEach var="v4" items="${vendorTermsConditionPriceBid4}">

                                                <c:if test="${vendorTermsCondition1.termsCondition == v4.termsCondition && vendorTermsCondition1.description == v4.description}">

                                                    <td>
                                                        <c:choose>
                                                            <c:when test="${v4.response == 0}">
                                                                Accept
                                                            </c:when>
                                                            <c:otherwise>
                                                                Reject
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>

                                                    <td>${v4.comment}</td>

                                                    <c:set var="found4" value="true"/>

                                                </c:if>

                                            </c:forEach>

                                            <c:if test="${found4 == false}">
                                                <td>-</td>
                                                <td>-</td>
                                            </c:if>


                                            <c:if test="${rev_submit_flag4 == '1'}">

                                                <c:set var="revFound4" value="false"/>

                                                <c:forEach var="r4" items="${vendorTermsCondition4}">

                                                    <c:if test="${vendorTermsCondition1.termsCondition == r4.termsCondition}">

                                                        <td>
                                                            <c:choose>
                                                                <c:when test="${r4.response == 0}">
                                                                    Accept
                                                                </c:when>
                                                                <c:otherwise>
                                                                    Reject
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </td>

                                                        <td>${r4.comment}</td>

                                                        <c:set var="revFound4" value="true"/>

                                                    </c:if>

                                                </c:forEach>

                                                <c:if test="${revFound4 == false}">
                                                    <td>-</td>
                                                    <td>-</td>
                                                </c:if>

                                            </c:if>

                                        </c:if>

                                    </tr>

                                </c:forEach>

                            </tbody>
                        </table>
                    </c:if>
                        
                    <c:if test="${!empty poDetails}">
                        <h5 class="fw-600 mt-3">MAN Approval Details</h5>
                        <hr>
                        <div class="rounded-4 mt-4"> 
                            <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                                <div class="row buyer-info">
                                    <div class="col-xxl-4 col-lg-4 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Approval Initiated By</label>
                                            <p class="fw-600">${tenderPriceApproval5.userId}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-5 col-lg-5 col-md-5 pb-1">
                                        <div class="form-group">
                                            <label>Approval Initiated Remark</label>
                                            <p class="fw-600">${tenderPriceApproval5.approvalRemark}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-3 col-lg-3 col-md-3 pb-1">
                                        <div class="form-group">
                                            <label>Approval Initiated On</label>
                                            <p class="fw-600">${tenderPriceApproval5.dateTime}</p>
                                        </div>
                                    </div>                                    
                                </div>
                            </div>
                        </div>
                        <c:if test="${!empty tenderPriceApproval7 || !empty tenderPriceApproval8}">
                            <h5 class="fw-600 mt-3">Price Bid Approval History</h5>
                            <hr>
                            <table id="commonNoPageTable8" class="table table-striped bg-white" style="width: 100%" align="Center"  >
                                <thead>                              
                                    <tr>
                                        <th>Sr No</th>
                                        <th>Approved By</th>
                                        <th>Approval Remarks</th>
                                        <th>Approved On</th>
                                    </tr>
                                </thead>                              
                                <tbody>                              

                                    <c:forEach var="tenderPriceApproval7" items="${tenderPriceApproval7}" varStatus="status1">
                                        <tr>
                                            <td>${status1.count}</td>
                                            <td>${tenderPriceApproval7.userId}</td>
                                            <td>${tenderPriceApproval7.approvalComment}</td>
                                            <td>${tenderPriceApproval7.dateTime}</td>
                                        </tr>
                                    </c:forEach>
                                        
                                    <c:forEach var="tenderPriceApproval8" items="${tenderPriceApproval8}" varStatus="status1">
                                        <tr>
                                            <td>${status1.count}</td>
                                            <td>${tenderPriceApproval8.userId}</td>
                                            <td>${tenderPriceApproval8.approvalComment}</td>
                                            <td>${tenderPriceApproval8.dateTime}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>                    
                        </c:if>
                    </c:if>
                    
                    <c:if test="${!empty poDetails}">
                        <h5 class="fw-600">PO Details</h5>
                        <hr>
                        <table id="commonNoPageTable9" class="table  table-striped bg-white" style="width: 100%" align="Center"  >
                            <thead>
                                <tr>
                                    <th>Sr No</th>
                                    <th>PO Number</th>
                                    <th>PO Date</th>
                                    <th>PO Value</th>
                                    <th>Vendor Code</th>
                                    <th>Vendor Name</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${poDetails}" varStatus="status">
                                    <tr>
                                        <td>${status.count}</td>
                                        <td>${list.poNo}</td>
                                        <td>${list.poDate}</td>
                                        <td class="currency">${list.poValue}</td>
                                        <td>${list.vendorCode}</td>
                                        <td>${list.vendorName}</td>
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
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
