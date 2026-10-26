
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tendor Approve Price Bid View</title>
    </head>
    <body>
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="tenderMaster.htm?act=approveBid" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                           class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">Tendor Approve Price Bid View</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                            <button type="submit" class="btn theme-btn mr-3"  onclick="approve();"   value="">Approve</button>
                               <button type="submit" class="btn theme-btn mr-3"  formaction="tenderMaster.htm?act=reworkBid"  onclick="rework();" value="">Rework </button>
                            <button type="submit" class="btn theme-btn mr-3"  formaction="tenderMaster.htm?act=reworkBidToBuyer"  onclick="rework();" value="">Rework To Buyer </button>
                        
                        <a class="btn theme-btn" href="tenderMaster.htm?act=viewapprovePriceBidPrint&id=${id}" class="btn btn-primary" onclick="printCustom()" title="Print this page">
                            <i class="fa fa-arrow-right"></i>&nbsp;&nbsp;Print
                        </a>
                        </div>
                    </div>
                    <hr>
                    <input type="hidden" name="policyCount" id="policyCount" value="1"/> 
                    <input type="hidden" name="id" value="${id}">
                    <h5 class="fw-600">PR Details </h5>
                    <div class="rounded-4 mt-4"> 
                        <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                            <div class="row buyer-info">
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>PR Reference No</label>
                                        <p class="fw-600">${prMaster.prNo}</p>
                                    </div>
                                </div>    
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Item Category</label>
                                        <p class="fw-600">${prMaster.type}</p>
                                    </div>
                                </div>    
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>PR classification</label>
                                        <p class="fw-600">${prMaster.categoryId}</p>
                                    </div>
                                </div>    
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Project Name</label>
                                        <p class="fw-600">${prMaster.title}</p>
                                    </div>
                                </div>    
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Project ID</label>
                                        <p class="fw-600">${prMaster.projectId}</p>
                                    </div>
                                </div>    
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>PR Subject Description</label>
                                        <p class="fw-600">${prMaster.workDesc}</p>
                                    </div>
                                </div>    
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Plant</label>
                                        <p class="fw-600">${prMaster.plant}</p>
                                    </div>
                                </div>    
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Billing Location</label>
                                        <p class="fw-600">${prMaster.billingLocation}</p>
                                    </div>
                                </div>    
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>PR Date</label>
                                        <p class="fw-600">${prMaster.announceDate}</p>
                                    </div>
                                </div>    
                            </div>    
                        </div>    
                    </div>    
                    <div class="rounded-4 mt-4"> 
                        <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                            <div class="row buyer-info">
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Created By</label>
                                        <p class="fw-600">${prMaster.contactPerson}</p>

                                    </div>
                                </div>   
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Created Contact Number</label>
                                        <p class="fw-600">${prMaster.prAdminContactNumber}</p>

                                    </div>
                                </div>   
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Technical Person Name</label>
                                        <p class="fw-600">${prMaster.technicalContactName}</p>

                                    </div>
                                </div>   
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Technical Person Contact No</label>
                                        <p class="fw-600">${prMaster.technicalContactNo}</p>

                                    </div>
                                </div>   
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>PR Estimate Cost With GST</label>
                                        <p class="fw-600">${prMaster.value}</p>

                                    </div>
                                </div>   
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Min Quotes Required</label>
                                        <p class="fw-600">${prMaster.quotes}</p>

                                    </div>
                                </div>   
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Business Type</label>
                                        <p class="fw-600">${prMaster.businessType}</p>

                                    </div>
                                </div>   
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Project Type</label>
                                        <p class="fw-600">${prMaster.projectType}</p>

                                    </div>
                                </div>   
                            </div>   
                        </div>   
                    </div>   
                    <table id="commonDocTable" class="table  table-striped bg-white dt-scroll" style="width: 100%" align="Center"  >
                        <thead>
                            <tr>
                                <th>Delivery Period</th>
                                <th>Technical committee</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>${prMaster.deliveryPeriod}</td>
                                <td>${prMaster.technicalCommittee}</td>
                            </tr>
                        </tbody>
                    </table>
                    <c:if test="${not empty item1}">
                        <c:if test="${prMaster.type == 'Contract Civil'}">
                            <h5 class="fw-600">Civil Details </h5><hr>
                        </c:if>
                        <c:if test="${prMaster.type != 'Contract Civil'}">
                            <c:if test="${prMaster.type == 'Service'}">
                                <h5 class="fw-600">Items Details For Service </h5><hr>
                            </c:if>
                            <c:if test="${prMaster.type != 'Service'}">
                                <h5 class="fw-600">Item Details </h5><hr>
                            </c:if>
                        </c:if>
                        <table id="commonNoPageTable" class="table table-striped bg-white" style="width: 100%;" align="center">
                            <thead>
                                <tr>
                                    <th>Sr. No.</th>
                                    <th style="min-width: 190px;">Item Code</th>
                                    <th style="min-width: 530px;">Item Description</th>
                                    <th style="min-width: 190px;">Purpose</th>
                                    <th>Make</th>
                                    <th>UOM</th>
                                    <th>Qty</th>
                                    <th style="min-width: 190px;">Account Category</th>
                                    <th>Account Value</th>
                                    <th>Product Type</th>
                                    <th>Product Group</th>
                                    <th>TAX Code</th>
                                    <th>Price</th>
                                    <th style="min-width: 190px;">Delivery Date</th>
                                    <th style="min-width: 190px;">Start Date</th>
                                    <th style="min-width: 190px;">End Date</th>
                                </tr>
                            </thead>
                            <c:set var="count" value="0" scope="page" />
                            <tbody>
                                <c:forEach var="list4" items="${item1}" varStatus="status">
                                    <tr>
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
                    <c:if test="${prMaster.type == 'Contract' || prMaster.type == 'Contract Civil' || prMaster.type == 'Contract Electrical'}">

                        <c:if test="${prMaster.type == 'Contract Civil'}">
                            <h5 class="fw-600">Steel Details </h5><hr>
                        </c:if>
                        <c:if test="${prMaster.type != 'Contract Civil'}"> 
                            <h5 class="fw-600">Item Details For Service</h5><hr>
                        </c:if>
                    </c:if>
                    <c:if test="${not empty item2}">
                        <table id="commonNoPageTable0" class="table table-striped bg-white" style=" width: 100%;" align="center">
                            <thead>
                                <tr >
                                    <th>Sr. No.</th>
                                    <th style="min-width: 190px;">Item Code</th>
                                    <th style="min-width: 530px;">Item Description</th>
                                    <th style="min-width: 190px;">Purchase</th>
                                    <th>Make</th>
                                    <th>Qty</th>   
                                    <th>UOM</th> 
                                    <th style="min-width: 190px;">Account Category</th>
                                    <th>Account Value</th>
                                    <th>Product Type</th>
                                    <th>Product Group</th>
                                    <th>TAX Code</th>
                                    <th>Price</th>
                                    <th style="min-width: 190px;">Delivery Date</th>
                                    <th style="min-width: 190px;">Start Date</th>
                                    <th style="min-width: 190px;">End Date</th>
                                </tr>
                            </thead>
                            <c:set var="count" value="0" scope="page" />
                            <tbody>
                                <c:forEach var="list4" items="${item2}" varStatus="status">
                                    <tr>
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
                    <h5 class="fw-600">Vendor Bid Details</h5> 
                    <table id="commonTable2" class="table table-striped bg-white" style="width: 100%" align="Center"  >
                        <thead>
                            <tr>
                                <th style="min-width: 190px;">Tender Ref No.</th>
                                <th style="min-width: 190px;">Vendor Id</th>
                                <th style="min-width: 190px;">Vendor Name</th>
                                <th style="min-width: 190px;">Vendor Email Id</th>
                                <th>Vendor Location</th>
                                <th>Total Amount</th>
                                <th style="min-width: 190px;" data-dt-order="disable">View All Attachment</th>
                                <th style="min-width: 190px;" data-dt-order="disable">View</th>
                                <th style="min-width: 190px;" data-dt-order="disable">Print</th>
                            </tr>
                        </thead>
                        <c:set var="count" value="0" scope="page" />
                        <tbody>
                            <c:forEach var="list1" items="${list2}" varStatus="status">
                                <tr>

                                    <td>${list1[0]}</td>
                                    <td>${list1[1]}</td>
                                    <td>${list1[2]}</td>
                                    <td>${list1[5]}</td>
                                    <td>${list1[3]}</td>
                                    <td>${list1[7]}</td>
                                    <td>
                                        <a href="#" onclick="loadAllvendorattach('${list1[0]}', '${list1[1]}')" data-toggle="modal" data-target="#vendorAttach">View</a>
<!--                                                <a href="#" onclick="window.open('tenderMaster.htm?act=vendorAllAttachView1&refNo=${list1[0]}&vendorCode=${list1[1]}', '', 'left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1');
                                          ">View</a>-->
                                    </td>
                                    <td>
                                        <c:if test="${tenderPhase == '3'}">
                                            <a href="tenderMaster.htm?act=preBidView&refNo=${list1[0]}&vendorCode=${list1[1]}">Pre Bid View</a><br>
                                        </c:if>
                                        <c:if test="${tenderPhase != '1'}">
                                            <a href="tenderMaster.htm?act=techBidView&refNo=${list1[0]}&vendorCode=${list1[1]}">Tech Bid View</a><br>    
                                        </c:if>
                                        <c:if test="${tender_type == 'Service Manually'}">
                                            <a href="tenderMaster.htm?act=priceBidServiceView&refNo=${list1[0]}&vendorCode=${list1[1]}">Price Bid View</a>
                                        </c:if>
                                        <c:if test="${tender_type != 'Service Manually'}">
                                            <a href="tenderMaster.htm?act=priceBidView&refNo=${list1[0]}&vendorCode=${list1[1]}">Price Bid View</a>
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:if test="${tenderPhase == '3'}">
                                            <a target="blank" href="tenderMaster.htm?act=preBidPrint&refNo=${list1[0]}&vendorCode=${list1[1]}">Pre Bid Print</a><br>
                                        </c:if>
                                        <c:if test="${tenderPhase != '1'}">
                                            <a target="blank" href="tenderMaster.htm?act=techBidPrint&refNo=${list1[0]}&vendorCode=${list1[1]}">Tech Bid Print</a><br>    
                                        </c:if>
                                        <c:if test="${tender_type == 'Service Manually'}">
                                            <a target="blank" href="tenderMaster.htm?act=priceBidServicePrint&refNo=${list1[0]}&vendorCode=${list1[1]}">Price Bid Print</a>
                                        </c:if>
                                        <c:if test="${tender_type != 'Service Manually'}">
                                            <a target="blank" href="tenderMaster.htm?act=priceBidPrint&refNo=${list1[0]}&vendorCode=${list1[1]}">Price Bid Print</a>
                                        </c:if>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <c:if test="${tenderPhase != '1'}">
                        <h5 class="fw-600"><a href="tenderMaster.htm?act=techBidComparisonView&refNo=${refNo}">Technical Comparison</a></h5><br>
                            </c:if> 
                    <h5 class="fw-600"><a href="tenderMaster.htm?act=priceBidComparisonSummaryView&refNo=${refNo}">Price Bid Comparison Summary VIew </a></h5><br>
                    <h5 class="fw-600"><a href="tenderMaster.htm?act=priceBidComparisonView&refNo=${refNo}">Price Bid Comparison VIew </a></h5><br>
                    <h5 class="fw-600"><a href="tenderMaster.htm?act=priceBidComparisonWithReviseView&refNo=${refNo}">Price Bid Comparison With Revise VIew </a></h5><br>
                    
                    <h5 class="fw-600">PR Activity Details</h5>            
                    <table id="commonNoPageTable1" class="table table-striped bg-white" style="width: 100%" align="center" >
                        <thead>
                            <tr>
                                <th style="min-width: 190px;">PR Number</th>
                                <th style="min-width: 190px;">User Id</th>
                                <th style="min-width: 190px;">Date Time</th>
                                <th style="min-width: 230px;">Remark</th>
                                <th style="min-width: 190px;">Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr> 
                                <td>${prMaster.prNo}</td>
                                <td>${prMaster.contactPerson}</td>
                                <td>${prMaster.announceDate}</td>
                                <td>PR Create</td>
                                <td></td>
                            </tr>
                            <c:forEach var="approvalList" items="${approvalList}" varStatus="status">
                                <tr> 
                                    <td>${approvalList.prNo}</td>
                                    <td>${approvalList.userId}</td>
                                    <td>${approvalList.dateTime}</td>
                                    <td>${approvalList.comment}</td>
                                    <td>${approvalList.approvalStatus}</td>
                                </tr>
                            </c:forEach>
                            <tr> 
                                <td>${prMaster.prNo}</td>
                                <td>${prMaster.prAuthorizeUser}</td>
                                <td>${prMaster.prAuthorizeDate}</td>
                                <td>PR Authorize</td>
                                <td></td>
                            </tr>
                            <c:forEach var="tenderFollowup" items="${tenderFollowup}" varStatus="status">
                                <tr> 
                                    <td>${tenderFollowup.tenderNo}</td>
                                    <td>${tenderFollowup.person}</td>
                                    <td>${tenderFollowup.activityDate}</td>
                                    <td>${tenderFollowup.activity}</td>
                                    <td></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                                <h5 class="fw-600">TENDER PRICE COMPARISON REPORT</h5>         
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
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Project ID</label>
                                        <p class="fw-600">${tenderMaster.projectId}</p>

                                    </div>
                                </div>       
                            </div>       
                        </div>       
                    </div>             
                            
                                        
                                        
                                        
                                        
                                        
                      <div style="overflow-x: auto; border: 1px solid #ddd; margin: auto;">
                        <table class="table table-bordered" style="min-width: 1500px; width: 100%;" align="center">
                            <tr>
                                <th colspan="5">Vendor Code</th>
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

                            <c:set var="count" value="0" scope="page" />

                            <tbody>
                                <tr>
                                    <th  colspan="5">Vendor Name </th>
                                        <c:if test="${vendor_code1 != ''}">
                                        <th colspan="2">${vendor_name1}</th> <!-- change here to price bid-->
                                            <c:if test="${rev_submit_flag1 == '1'}">
                                            <th colspan="2">${vendor_name1}</th>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${vendor_code2 != ''}">
                                        <th colspan="2">${vendor_name2}</th><!-- change here to price bid-->
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
                                    <th  colspan="5">Currency Name</th>
                                        <c:if test="${vendor_code1 != ''}">
                                        <th colspan="2">INR</th>
                                            <c:if test="${rev_submit_flag1 == '1'}">
                                            <th colspan="2">INR</th>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${vendor_code2 != ''}">
                                        <th colspan="2">INR</th>
                                            <c:if test="${rev_submit_flag2 == '1'}">
                                            <th colspan="2">INR</th>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${vendor_code3 != ''}">
                                        <th colspan="2">INR</th>
                                            <c:if test="${rev_submit_flag3 == '1'}">
                                            <th colspan="2">INR</th>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${vendor_code4 != ''}">
                                        <th colspan="2">INR</th>
                                            <c:if test="${rev_submit_flag4 == '1'}">
                                            <th colspan="2">INR</th>
                                            </c:if>
                                        </c:if>    
                                </tr>

                                <tr>
                                    <th  colspan="5">Exchange Rate</th>
                                        <c:if test="${vendor_code1 != ''}">
                                        <th colspan="2">1.00</th>
                                            <c:if test="${rev_submit_flag1 == '1'}">
                                            <th colspan="2">1.00</th>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${vendor_code2 != ''}">
                                        <th colspan="2">1.00</th>
                                            <c:if test="${rev_submit_flag2 == '1'}">
                                            <th colspan="2">1.00</th>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${vendor_code3 != ''}">
                                        <th colspan="2">1.00</th>
                                            <c:if test="${rev_submit_flag3 == '1'}">
                                            <th colspan="2">1.00</th>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${vendor_code4 != ''}">
                                        <th colspan="2">1.00</th>
                                            <c:if test="${rev_submit_flag4 == '1'}">
                                            <th colspan="2">1.00</th>
                                            </c:if>
                                        </c:if>    
                                </tr>

                                <tr>
                                    <th>Sr.<br>&nbsp;</th>
                                    <th>Item Code<br>&nbsp;</th>
                                    <th>Item Description<br>&nbsp;</th>
                                    <th>Quantity<br>&nbsp;</th>
                                    <th>UOM<br>&nbsp;</th>
                                        <c:if test="${vendor_code1 != ''}">
                                        <th style="width:60px">Unit Price</th>
                                        <th style="width:60px">Value</th>
                                            <c:if test="${rev_submit_flag1 == '1'}">
                                            <th style="width:60px">Unit Price</th>
                                            <th style="width:60px">Value</th>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${vendor_code2 != ''}">
                                        <th style="width:60px">Unit Price</th>
                                        <th style="width:60px">Value</th>
                                            <c:if test="${rev_submit_flag2 == '1'}">
                                            <th style="width:60px">Unit Price</th>
                                            <th style="width:60px">Value</th>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${vendor_code3 != ''}">
                                        <th style="width:60px">Unit Price</th>
                                        <th style="width:60px">Value</th>
                                            <c:if test="${rev_submit_flag3 == '1'}">
                                            <th style="width:60px">Unit Price</th>
                                            <th style="width:60px">Value</th>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${vendor_code4 != ''}">
                                        <th style="width:60px">Unit Price</th>
                                        <th style="width:60px">Value</th>
                                            <c:if test="${rev_submit_flag4 == '1'}">
                                            <th style="width:60px">Unit Price</th>
                                            <th style="width:60px">Value</th>
                                            </c:if>
                                        </c:if>    
                                </tr>

                                <c:forEach var="vendorTenderBidItem1" items="${vendorTenderBidItem1}" varStatus="status">
                                    <tr>
                                        <td style="padding: 0px 0px;">${vendorTenderBidItem1[0]}</td>
                                        <td style="padding: 0px 0px;">${vendorTenderBidItem1[1]}</td>
                                        <td style="padding: 0px 0px;">${vendorTenderBidItem1[2]}</td>
                                        <td style="padding: 0px 0px;">${vendorTenderBidItem1[4]}</td>
                                        <td style="padding: 0px 0px;">${vendorTenderBidItem1[3]}</td>
                                        <c:if test="${vendor_code1 != ''}">
                                            <td style="padding: 0px 0px;">${vendorTenderBidItem1[5]}</td>
                                            <td style="padding: 0px 0px;">${vendorTenderBidItem1[6]}</td>
                                            <c:if test="${rev_submit_flag1 == '1'}">
                                                <c:forEach var="reviseVendorTenderBidItem1" items="${reviseVendorTenderBidItem1}" varStatus="status">
                                                    <c:if test="${vendorTenderBidItem1[0] == reviseVendorTenderBidItem1[0]}">
                                                        <td style="padding: 0px 0px;">${reviseVendorTenderBidItem1[5]}</td>
                                                        <td style="padding: 0px 0px;">${reviseVendorTenderBidItem1[6]}</td>
                                                    </c:if>
                                                </c:forEach>

                                            </c:if>
                                        </c:if>
                                        <c:if test="${vendor_code2 != ''}">
                                            <c:forEach var="vendorTenderBidItem2" items="${vendorTenderBidItem2}" varStatus="status1">
                                                <c:if test="${vendorTenderBidItem1[0] == vendorTenderBidItem2[0]}">
                                                    <td style="padding: 0px 0px;">${vendorTenderBidItem2[5]}</td>
                                                    <td style="padding: 0px 0px;">${vendorTenderBidItem2[6]}</td>
                                                </c:if>
                                            </c:forEach>
                                            <c:if test="${rev_submit_flag2 == '1'}">
                                                <c:forEach var="reviseVendorTenderBidItem2" items="${reviseVendorTenderBidItem2}" varStatus="status">
                                                    <c:if test="${vendorTenderBidItem1[0] == reviseVendorTenderBidItem2[0]}">
                                                        <td style="padding: 0px 0px;">${reviseVendorTenderBidItem2[5]}</td>
                                                        <td style="padding: 0px 0px;">${reviseVendorTenderBidItem2[6]}</td>
                                                    </c:if>
                                                </c:forEach>

                                            </c:if>
                                        </c:if>
                                        <c:if test="${vendor_code3 != ''}">
                                            <c:forEach var="vendorTenderBidItem3" items="${vendorTenderBidItem3}" varStatus="status1">
                                                <c:if test="${vendorTenderBidItem1[0] == vendorTenderBidItem3[0]}">
                                                    <td style="padding: 0px 0px;">${vendorTenderBidItem3[5]}</td>
                                                    <td style="padding: 0px 0px;">${vendorTenderBidItem3[6]}</td>
                                                </c:if>
                                            </c:forEach>

                                            <c:if test="${rev_submit_flag3 == '1'}">
                                                <c:forEach var="reviseVendorTenderBidItem3" items="${reviseVendorTenderBidItem3}" varStatus="status">
                                                    <c:if test="${vendorTenderBidItem1[0] == reviseVendorTenderBidItem3[0]}">
                                                        <td style="padding: 0px 0px;">${reviseVendorTenderBidItem3[5]}</td>
                                                        <td style="padding: 0px 0px;">${reviseVendorTenderBidItem3[6]}</td>
                                                    </c:if>
                                                </c:forEach>

                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code4 != ''}">
                                            <c:forEach var="vendorTenderBidItem4" items="${vendorTenderBidItem4}" varStatus="status1">
                                                <c:if test="${vendorTenderBidItem1[0] == vendorTenderBidItem4[0]}">
                                                    <td style="padding: 0px 0px;">${vendorTenderBidItem4[5]}</td>
                                                    <td style="padding: 0px 0px;">${vendorTenderBidItem4[6]}</td>
                                                </c:if>
                                            </c:forEach>

                                            <c:if test="${rev_submit_flag4 == '1'}">
                                                <c:forEach var="reviseVendorTenderBidItem4" items="${reviseVendorTenderBidItem4}" varStatus="status">
                                                    <c:if test="${vendorTenderBidItem1[0] == reviseVendorTenderBidItem4[0]}">
                                                        <td style="padding: 0px 0px;">${reviseVendorTenderBidItem4[5]}</td>
                                                        <td style="padding: 0px 0px;">${reviseVendorTenderBidItem4[6]}</td>
                                                    </c:if>
                                                </c:forEach>

                                            </c:if>

                                        </c:if>                
                                    </tr>
                                </c:forEach>

                                <tr>
                                    <th  colspan="5">Ex-work Price/FOB</th>
                                        <c:if test="${vendor_code1 != ''}">
                                        <td></td>
                                        <td><fmt:formatNumber value="${total_value1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                        <c:if test="${rev_submit_flag1 == '1'}">
                                            <td></td>
                                            <td><fmt:formatNumber value="${rev_total_value1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td></td>
                                        <td><fmt:formatNumber value="${total_value2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                        <c:if test="${rev_submit_flag2 == '1'}">
                                            <td></td>
                                            <td><fmt:formatNumber value="${rev_total_value2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                        </c:if>

                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td></td>
                                        <td><fmt:formatNumber value="${total_value3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>


                                        <c:if test="${rev_submit_flag3 == '1'}">
                                            <td></td>
                                            <td><fmt:formatNumber value="${rev_total_value3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                        </c:if>

                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td></td>
                                        <td><fmt:formatNumber value="${total_value4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>


                                        <c:if test="${rev_submit_flag4 == '1'}">
                                            <td></td>
                                            <td><fmt:formatNumber value="${rev_total_value4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                        </c:if>

                                    </c:if>        
                                </tr>
                                <tr>
                                    <th  colspan="5">Packing & Forwarding</th>
                                        <c:if test="${vendor_code1 != ''}">
                                        <td>${packingValue1}</td>
                                        <td>${packingValueFinal1}</td>
                                        <c:if test="${rev_submit_flag1 == '1'}">
                                            <td>${revpackingValue1}</td>
                                            <td>${revpackingValueFinal1}</td>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td>${packingValue2}</td>
                                        <td>${packingValueFinal2}</td>


                                        <c:if test="${rev_submit_flag2 == '1'}">
                                            <td>${revpackingValue2}</td>
                                            <td>${revpackingValueFinal2}</td>
                                        </c:if>

                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td>${packingValue3}</td>
                                        <td>${packingValueFinal3}</td>


                                        <c:if test="${rev_submit_flag3 == '1'}">
                                            <td>${revpackingValue3}</td>
                                            <td>${revpackingValueFinal3}</td>
                                        </c:if>

                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td>${packingValue4}</td>
                                        <td>${packingValueFinal4}</td>


                                        <c:if test="${rev_submit_flag4 == '1'}">
                                            <td>${revpackingValue4}</td>
                                            <td>${revpackingValueFinal4}</td>
                                        </c:if>

                                    </c:if>
                                </tr>

                                <tr>
                                    <th  colspan="5">Charges</th>
                                        <c:if test="${vendor_code1 != ''}">
                                        <td>${chargesValue1}</td>
                                        <td>${chargesValueFinal1}</td>

                                        <c:if test="${rev_submit_flag1 == '1'}">
                                            <td>${revchargesValue1}</td>
                                            <td>${revchargesValueFinal1}</td>
                                        </c:if>

                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td>${chargesValue2}</td>
                                        <td>${chargesValueFinal2}</td>

                                        <c:if test="${rev_submit_flag2 == '1'}">
                                            <td>${revchargesValue2}</td>
                                            <td>${revchargesValueFinal2}</td>
                                        </c:if>

                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td>${chargesValue3}</td>
                                        <td>${chargesValueFinal3}</td>

                                        <c:if test="${rev_submit_flag3 == '1'}">
                                            <td>${revchargesValue3}</td>
                                            <td>${revchargesValueFinal3}</td>
                                        </c:if>

                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td>${chargesValue4}</td>
                                        <td>${chargesValueFinal4}</td>

                                        <c:if test="${rev_submit_flag4 == '1'}">
                                            <td>${revchargesValue4}</td>
                                            <td>${revchargesValueFinal4}</td>
                                        </c:if>

                                    </c:if>        
                                </tr>

                                <tr>
                                    <th  colspan="5">Insurance</th>
                                        <c:if test="${vendor_code1 != ''}">
                                        <td>${insuranceValue1}</td>
                                        <td>${insuranceValueFinal1}</td>

                                        <c:if test="${rev_submit_flag1 == '1'}">
                                            <td>${revinsuranceValue1}</td>
                                            <td>${revinsuranceValueFinal1}</td>
                                        </c:if>

                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td>${insuranceValue2}</td>
                                        <td>${insuranceValueFinal2}</td>

                                        <c:if test="${rev_submit_flag2 == '1'}">
                                            <td>${revinsuranceValue2}</td>
                                            <td>${revinsuranceValueFinal2}</td>
                                        </c:if>

                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td>${insuranceValue3}</td>
                                        <td>${insuranceValueFinal3}</td>

                                        <c:if test="${rev_submit_flag3 == '1'}">
                                            <td>${revinsuranceValue3}</td>
                                            <td>${revinsuranceValueFinal3}</td>
                                        </c:if>

                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td>${insuranceValue4}</td>
                                        <td>${insuranceValueFinal4}</td>

                                        <c:if test="${rev_submit_flag4 == '1'}">
                                            <td>${revinsuranceValue4}</td>
                                            <td>${revinsuranceValueFinal4}</td>
                                        </c:if>

                                    </c:if>        
                                </tr>

                                <tr>
                                    <th  colspan="5">Erection Commision</th>
                                        <c:if test="${vendor_code1 != ''}">
                                        <td>${errectionValue1}</td>
                                        <td>${errectionValueFinal1}</td>

                                        <c:if test="${rev_submit_flag1 == '1'}">
                                            <td>${reverrectionValue1}</td>
                                            <td>${reverrectionValueFinal1}</td>
                                        </c:if>

                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td>${errectionValue2}</td>
                                        <td>${errectionValueFinal2}</td>

                                        <c:if test="${rev_submit_flag2 == '1'}">
                                            <td>${reverrectionValue2}</td>
                                            <td>${reverrectionValueFinal2}</td>
                                        </c:if>

                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td>${errectionValue3}</td>
                                        <td>${errectionValueFinal3}</td>

                                        <c:if test="${rev_submit_flag3 == '1'}">
                                            <td>${reverrectionValue3}</td>
                                            <td>${reverrectionValueFinal3}</td>
                                        </c:if>

                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td>${errectionValue4}</td>
                                        <td>${errectionValueFinal4}</td>

                                        <c:if test="${rev_submit_flag4 == '1'}">
                                            <td>${reverrectionValue4}</td>
                                            <td>${reverrectionValueFinal4}</td>
                                        </c:if>

                                    </c:if>
                                </tr>

                                <tr>
                                    <th  colspan="5">Discount</th>
                                        <c:if test="${vendor_code1 != ''}">
                                        <td>${discountValue1}</td>
                                        <td>${discountValueFinal1}</td>

                                        <c:if test="${rev_submit_flag1 == '1'}">
                                            <td>${revdiscountValue1}</td>
                                            <td>${revdiscountValueFinal1}</td>
                                        </c:if>

                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td>${discountValue2}</td>
                                        <td>${discountValueFinal2}</td>

                                        <c:if test="${rev_submit_flag2 == '1'}">
                                            <td>${revdiscountValue2}</td>
                                            <td>${revdiscountValueFinal2}</td>
                                        </c:if>

                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td>${discountValue3}</td>
                                        <td>${discountValueFinal3}</td>


                                        <c:if test="${rev_submit_flag3 == '1'}">
                                            <td>${revdiscountValue3}</td>
                                            <td>${revdiscountValueFinal3}</td>
                                        </c:if>

                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td>${discountValue4}</td>
                                        <td>${discountValueFinal4}</td>


                                        <c:if test="${rev_submit_flag4 == '1'}">
                                            <td>${revdiscountValue4}</td>
                                            <td>${revdiscountValueFinal4}</td>
                                        </c:if>

                                    </c:if>
                                </tr>

                                <tr>
                                    <th  colspan="5">Final Evaluated Price Without GST</th>
                                        <c:if test="${vendor_code1 != ''}">
                                        <td></td>
                                        <td>${String.format("%.2f",Total1 - igstValueFinal1)}</td>

                                        <c:if test="${rev_submit_flag1 == '1'}">
                                            <td></td>
                                            <td>${String.format("%.2f",revTotal1 - revigstValueFinal1)}</td>
                                        </c:if>

                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td></td>
                                        <td>${String.format("%.2f",Total2 - igstValueFinal2)}</td>


                                        <c:if test="${rev_submit_flag2 == '1'}">
                                            <td></td>
                                            <td>${String.format("%.2f",revTotal2 - revigstValueFinal2)}</td>
                                        </c:if>

                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td></td>
                                        <td>${String.format("%.2f",Total3 - igstValueFinal3)}</td>

                                        <c:if test="${rev_submit_flag3 == '1'}">
                                            <td></td>
                                            <td>${String.format("%.2f",revTotal3 - revigstValueFinal3)}</td>
                                        </c:if>

                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td></td>
                                        <td>${String.format("%.2f",Total4 - igstValueFinal4)}</td>

                                        <c:if test="${rev_submit_flag4 == '1'}">
                                            <td></td>
                                            <td>${String.format("%.2f",revTotal4 - revigstValueFinal4)}</td>
                                        </c:if>

                                    </c:if>        
                                </tr>

                                <tr>
                                    <th  colspan="5">GST</th>
                                        <c:if test="${vendor_code1 != ''}">
                                        <td>${igstValue1}</td>
                                        <td>${igstValueFinal1}</td>

                                        <c:if test="${rev_submit_flag1 == '1'}">
                                            <td>${revigstValue1}</td>
                                            <td>${revigstValueFinal1}</td>
                                        </c:if>

                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td>${igstValue2}</td>
                                        <td>${igstValueFinal2}</td>

                                        <c:if test="${rev_submit_flag2 == '1'}">
                                            <td>${revigstValue2}</td>
                                            <td>${revigstValueFinal2}</td>
                                        </c:if>

                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td>${igstValue3}</td>
                                        <td>${igstValueFinal3}</td>

                                        <c:if test="${rev_submit_flag3 == '1'}">
                                            <td>${revigstValue3}</td>
                                            <td>${revigstValueFinal3}</td>
                                        </c:if>

                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td>${igstValue4}</td>
                                        <td>${igstValueFinal4}</td>

                                        <c:if test="${rev_submit_flag4 == '1'}">
                                            <td>${revigstValue4}</td>
                                            <td>${revigstValueFinal4}</td>
                                        </c:if>

                                    </c:if>        
                                </tr>

                                <tr>
                                    <th  colspan="5">Final Evaluated Price</th>
                                        <c:if test="${vendor_code1 != ''}">
                                        <td></td>
                                        <td>${String.format("%.2f",Total1)}</td>

                                        <c:if test="${rev_submit_flag1 == '1'}">
                                            <td></td>
                                            <td>${String.format("%.2f",revTotal1)}</td>
                                        </c:if>

                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <td></td>
                                        <td>${String.format("%.2f",Total2)}</td>


                                        <c:if test="${rev_submit_flag2 == '1'}">
                                            <td></td>
                                            <td>${String.format("%.2f",revTotal2)}</td>
                                        </c:if>

                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <td></td>
                                        <td>${String.format("%.2f",Total3)}</td>

                                        <c:if test="${rev_submit_flag3 == '1'}">
                                            <td></td>
                                            <td>${String.format("%.2f",revTotal3)}</td>
                                        </c:if>

                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <td></td>
                                        <td>${String.format("%.2f",Total4)}</td>

                                        <c:if test="${rev_submit_flag4 == '1'}">
                                            <td></td>
                                            <td>${String.format("%.2f",revTotal4)}</td>
                                        </c:if>

                                    </c:if> 
                                </tr>

                                <tr>
                                    <th  colspan="5">Rating</th>
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
                                    <th  colspan="5">No. Of Item Regreted</th>
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


                    <c:if test="${ServicevendorTenderBidItem1.size() > 0}">
  <div style="width: 100%; overflow-x: auto;">
    <table id="table_122" class="table table-bordered" style="width: 100%;" align="center">
                        <c:if test = "${tenderMaster.type == 'Contract' || tenderMaster.type == 'Contract Civil' || tenderMaster.type == 'Contract Electrical'}">
                            <table id="table_122" class="table table-bordered" style="" align="Center"  >

                                <tr>
                                    <th colspan="5">Vendor Code</th>
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

                                <c:set var="count" value="0" scope="page" />

                                <tbody>
                                    <tr>
                                        <th  colspan="5">Vendor Name </th>
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
                                        <th  colspan="5">Currency Name</th>
                                            <c:if test="${vendor_code1 != ''}">
                                            <th colspan="2">INR</th>
                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                <th colspan="2">INR</th>
                                                </c:if>
                                            </c:if>
                                            <c:if test="${vendor_code2 != ''}">
                                            <th colspan="2">INR</th>
                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                <th colspan="2">INR</th>
                                                </c:if>
                                            </c:if>
                                            <c:if test="${vendor_code3 != ''}">
                                            <th colspan="2">INR</th>
                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                <th colspan="2">INR</th>
                                                </c:if>
                                            </c:if>
                                            <c:if test="${vendor_code4 != ''}">
                                            <th colspan="2">INR</th>
                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                <th colspan="2">INR</th>
                                                </c:if>
                                            </c:if>    
                                    </tr>

                                    <tr>
                                        <th  colspan="5">Exchange Rate</th>
                                            <c:if test="${vendor_code1 != ''}">
                                            <th colspan="2">1.00</th>
                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                <th colspan="2">1.00</th>
                                                </c:if>
                                            </c:if>
                                            <c:if test="${vendor_code2 != ''}">
                                            <th colspan="2">1.00</th>
                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                <th colspan="2">1.00</th>
                                                </c:if>
                                            </c:if>
                                            <c:if test="${vendor_code3 != ''}">
                                            <th colspan="2">1.00</th>
                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                <th colspan="2">1.00</th>
                                                </c:if>
                                            </c:if>
                                            <c:if test="${vendor_code4 != ''}">
                                            <th colspan="2">1.00</th>
                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                <th colspan="2">1.00</th>
                                                </c:if>
                                            </c:if>    
                                    </tr>



                                    <tr>
                                        <th>Sr.<br>&nbsp;</th>
                                        <th>Item Code<br>&nbsp;</th>
                                        <th colspan="1">Item Description</th>
                                        <th>Quantity<br>&nbsp;</th>
                                        <th>UOM<br>&nbsp;</th>
                                            <c:if test="${vendor_code1 != ''}">
                                            <th style="width:60px">Unit Price</th>
                                            <th style="width:60px">Value</th>

                                            <c:if test="${rev_submit_flag1 == '1'}">
                                                <th style="width:60px">Unit Price</th>
                                                <th style="width:60px">Value</th>
                                                </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code2 != ''}">
                                            <th style="width:60px">Unit Price</th>
                                            <th style="width:60px">Value</th>

                                            <c:if test="${rev_submit_flag2 == '1'}">
                                                <th style="width:60px">Unit Price</th>
                                                <th style="width:60px">Value</th>
                                                </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code3 != ''}">
                                            <th style="width:60px">Unit Price</th>
                                            <th style="width:60px">Value</th>

                                            <c:if test="${rev_submit_flag3 == '1'}">
                                                <th style="width:60px">Unit Price</th>
                                                <th style="width:60px">Value</th>
                                                </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code4 != ''}">
                                            <th style="width:60px">Unit Price</th>
                                            <th style="width:60px">Value</th>

                                            <c:if test="${rev_submit_flag4 == '1'}">
                                                <th style="width:60px">Unit Price</th>
                                                <th style="width:60px">Value</th>
                                                </c:if>

                                        </c:if>        
                                    </tr>

                                    <c:forEach var="vendorTenderBidItem1" items="${ServicevendorTenderBidItem1}" varStatus="status">
                                        <tr>
                                            <td style="padding: 0px 0px;">${vendorTenderBidItem1[0]}</td>
                                            <td style="padding: 0px 0px;">${vendorTenderBidItem1[1]}</td>
                                            <td style="padding: 0px 0px;">${vendorTenderBidItem1[2]}</td>
                                            <td style="padding: 0px 0px;">${vendorTenderBidItem1[4]}</td>
                                            <td style="padding: 0px 0px;">${vendorTenderBidItem1[3]}</td>
                                            <c:if test="${vendor_code1 != ''}">
                                                <td style="padding: 0px 0px;">${vendorTenderBidItem1[5]}</td>
                                                <td style="padding: 0px 0px;">${vendorTenderBidItem1[6]}</td>
                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                    <c:forEach var="revServicevendorTenderBidItem1" items="${revServicevendorTenderBidItem1}" varStatus="status1">
                                                        <c:if test="${vendorTenderBidItem1[0] == revServicevendorTenderBidItem1[0]}">
                                                            <td style="padding: 0px 0px;">${revServicevendorTenderBidItem1[5]}</td>
                                                            <td style="padding: 0px 0px;">${revServicevendorTenderBidItem1[6]}</td>
                                                        </c:if>
                                                    </c:forEach>
                                                </c:if>
                                            </c:if>
                                            <c:if test="${vendor_code2 != ''}">
                                                <c:forEach var="vendorTenderBidItem2" items="${ServicevendorTenderBidItem2}" varStatus="status1">
                                                    <c:if test="${vendorTenderBidItem1[0] == vendorTenderBidItem2[0]}">
                                                        <td style="padding: 0px 0px;">${vendorTenderBidItem2[5]}</td>
                                                        <td style="padding: 0px 0px;">${vendorTenderBidItem2[6]}</td>
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                    <c:forEach var="revServicevendorTenderBidItem2" items="${revServicevendorTenderBidItem2}" varStatus="status1">
                                                        <c:if test="${vendorTenderBidItem1[0] == revServicevendorTenderBidItem2[0]}">
                                                            <td style="padding: 0px 0px;">${revServicevendorTenderBidItem2[5]}</td>
                                                            <td style="padding: 0px 0px;">${revServicevendorTenderBidItem2[6]}</td>
                                                        </c:if>
                                                    </c:forEach>
                                                </c:if>  
                                            </c:if>
                                            <c:if test="${vendor_code3 != ''}">
                                                <c:forEach var="vendorTenderBidItem3" items="${ServicevendorTenderBidItem3}" varStatus="status1">
                                                    <c:if test="${vendorTenderBidItem1[0] == vendorTenderBidItem3[0]}">
                                                        <td style="padding: 0px 0px;">${vendorTenderBidItem3[5]}</td>
                                                        <td style="padding: 0px 0px;">${vendorTenderBidItem3[6]}</td>
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                    <c:forEach var="revServicevendorTenderBidItem3" items="${revServicevendorTenderBidItem3}" varStatus="status1">
                                                        <c:if test="${vendorTenderBidItem1[0] == revServicevendorTenderBidItem3[0]}">
                                                            <td style="padding: 0px 0px;">${revServicevendorTenderBidItem3[5]}</td>
                                                            <td style="padding: 0px 0px;">${revServicevendorTenderBidItem3[6]}</td>
                                                        </c:if>
                                                    </c:forEach>
                                                </c:if> 
                                            </c:if>

                                            <c:if test="${vendor_code4 != ''}">
                                                <c:forEach var="vendorTenderBidItem4" items="${ServicevendorTenderBidItem4}" varStatus="status1">
                                                    <c:if test="${vendorTenderBidItem1[0] == vendorTenderBidItem4[0]}">
                                                        <td style="padding: 0px 0px;">${vendorTenderBidItem4[5]}</td>
                                                        <td style="padding: 0px 0px;">${vendorTenderBidItem4[6]}</td>
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                    <c:forEach var="revServicevendorTenderBidItem4" items="${revServicevendorTenderBidItem4}" varStatus="status1">
                                                        <c:if test="${vendorTenderBidItem1[0] == revServicevendorTenderBidItem4[0]}">
                                                            <td style="padding: 0px 0px;">${revServicevendorTenderBidItem4[5]}</td>
                                                            <td style="padding: 0px 0px;">${revServicevendorTenderBidItem4[6]}</td>
                                                        </c:if>
                                                    </c:forEach>
                                                </c:if> 
                                            </c:if>                
                                        </tr>
                                    </c:forEach>

                                    <tr>
                                        <th  colspan="5">Ex-work Price/FOB</th>
                                            <c:if test="${vendor_code1 != ''}">
                                            <td></td>
                                            <td> <fmt:formatNumber value="${serviceTotalFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" />
                                            </td>

                                            <c:if test="${rev_submit_flag1 == '1'}">
                                                <td></td>
                                                <td>
                                                    <fmt:formatNumber value="${revserviceTotalFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" />
                                                </td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code2 != ''}">
                                            <td></td>
                                            <td><fmt:formatNumber value="${serviceTotalFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                            <c:if test="${rev_submit_flag2 == '1'}">
                                                <td></td>
                                                <td><fmt:formatNumber value="${revserviceTotalFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code3 != ''}">
                                            <td></td>
                                            <td><fmt:formatNumber value="${serviceTotalFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                            <c:if test="${rev_submit_flag3 == '1'}">
                                                <td></td>
                                                <td><fmt:formatNumber value="${revserviceTotalFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code4 != ''}">
                                            <td></td>
                                            <td><fmt:formatNumber value="${serviceTotalFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                            <c:if test="${rev_submit_flag4 == '1'}">
                                                <td></td>
                                                <td><fmt:formatNumber value="${revserviceTotalFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                            </c:if>

                                        </c:if>        
                                    </tr>


                                    <tr>
                                        <th  colspan="5">Discount</th>
                                            <c:if test="${vendor_code1 != ''}">
                                            <td>${serviceDiscountValue1}</td>
                                            <td>${serviceDiscountValueFinal1}</td>

                                            <c:if test="${rev_submit_flag1 == '1'}">
                                                <td>${revserviceDiscountValue1}</td>
                                                <td>${revserviceDiscountValueFinal1}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code2 != ''}">
                                            <td>${serviceDiscountValue2}</td>
                                            <td>${serviceDiscountValueFinal2}</td>

                                            <c:if test="${rev_submit_flag2 == '1'}">
                                                <td>${revserviceDiscountValue2}</td>
                                                <td>${revserviceDiscountValueFinal2}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code3 != ''}">
                                            <td>${serviceDiscountValue3}</td>
                                            <td>${serviceDiscountValueFinal3}</td>

                                            <c:if test="${rev_submit_flag3 == '1'}">
                                                <td>${revserviceDiscountValue3}</td>
                                                <td>${revserviceDiscountValueFinal3}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code4 != ''}">
                                            <td>${serviceDiscountValue4}</td>
                                            <td>${serviceDiscountValueFinal4}</td>

                                            <c:if test="${rev_submit_flag4 == '1'}">
                                                <td>${revserviceDiscountValue4}</td>
                                                <td>${revserviceDiscountValueFinal4}</td>
                                            </c:if>

                                        </c:if>        
                                    </tr>

                                    <tr>
                                        <th  colspan="5">Final Evaluated Price Without GST</th>
                                            <c:if test="${vendor_code1 != ''}">
                                            <td></td>
                                            <td>${String.format("%.2f",serviceTaxTotal1 - servicegstFinal1)}</td>

                                            <c:if test="${rev_submit_flag1 == '1'}">
                                                <td></td>
                                                <td>${String.format("%.2f",revserviceTaxTotal1 - revservicegstFinal1)}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code2 != ''}">
                                            <td></td>
                                            <td>${String.format("%.2f",serviceTaxTotal2 - servicegstFinal2)}</td>

                                            <c:if test="${rev_submit_flag2 == '1'}">
                                                <td></td>
                                                <td>${String.format("%.2f",revserviceTaxTotal2 - revservicegstFinal2)}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code3 != ''}">
                                            <td></td>
                                            <td>${String.format("%.2f",serviceTaxTotal3 - servicegstFinal3)}</td>


                                            <c:if test="${rev_submit_flag3 == '1'}">
                                                <td></td>
                                                <td>${String.format("%.2f",revserviceTaxTotal3 - revservicegstFinal3)}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code4 != ''}">
                                            <td></td>
                                            <td>${String.format("%.2f",serviceTaxTotal4 - servicegstFinal4)}</td>


                                            <c:if test="${rev_submit_flag4 == '1'}">
                                                <td></td>
                                                <td>${String.format("%.2f",revserviceTaxTotal4 - revservicegstFinal4)}</td>
                                            </c:if>

                                        </c:if>
                                    </tr>

                                    <tr>
                                        <th  colspan="5">GST</th>
                                            <c:if test="${vendor_code1 != ''}">
                                            <td>${servicegst1}</td>
                                            <td>${servicegstFinal1}</td>

                                            <c:if test="${rev_submit_flag1 == '1'}">
                                                <td>${revservicegst1}</td>
                                                <td>${revservicegstFinal1}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code2 != ''}">
                                            <td>${servicegst2}</td>
                                            <td>${servicegstFinal2}</td>

                                            <c:if test="${rev_submit_flag2 == '1'}">
                                                <td>${revservicegst2}</td>
                                                <td>${revservicegstFinal2}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code3 != ''}">
                                            <td>${servicegst3}</td>
                                            <td>${servicegstFinal3}</td>

                                            <c:if test="${rev_submit_flag3 == '1'}">
                                                <td>${revservicegst3}</td>
                                                <td>${revservicegstFinal3}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code4 != ''}">
                                            <td>${servicegst4}</td>
                                            <td>${servicegstFinal4}</td>

                                            <c:if test="${rev_submit_flag4 == '1'}">
                                                <td>${revservicegst4}</td>
                                                <td>${revservicegstFinal4}</td>
                                            </c:if>

                                        </c:if>    
                                    </tr>

                                    <tr>
                                        <th  colspan="5">Final Evaluated Price</th>
                                            <c:if test="${vendor_code1 != ''}">
                                            <td></td>
                                            <td>${serviceTaxTotal1}</td>

                                            <c:if test="${rev_submit_flag1 == '1'}">
                                                <td></td>
                                                <td>${revserviceTaxTotal1}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code2 != ''}">
                                            <td></td>
                                            <td>${serviceTaxTotal2}</td>

                                            <c:if test="${rev_submit_flag2 == '1'}">
                                                <td></td>
                                                <td>${revserviceTaxTotal2}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code3 != ''}">
                                            <td></td>
                                            <td>${serviceTaxTotal3}</td>


                                            <c:if test="${rev_submit_flag3 == '1'}">
                                                <td></td>
                                                <td>${revserviceTaxTotal3}</td>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${vendor_code4 != ''}">
                                            <td></td>
                                            <td>${serviceTaxTotal4}</td>


                                            <c:if test="${rev_submit_flag4 == '1'}">
                                                <td></td>
                                                <td>${revserviceTaxTotal4}</td>
                                            </c:if>

                                        </c:if>    
                                    </tr>

                                    <tr>
                                        <th  colspan="5">Rating</th>
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
                                        <th  colspan="5">No. Of Item Regreted</th>
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

                        </c:if>
  </div>
                    </c:if>
<br>            
                                
         <div style="overflow-x: auto; border: 1px solid #ddd; margin: auto;">
                        <table class="table table-bordered" style="min-width: 1500px; width: 100%;" align="center">
                            <tr>
                                <th colspan="5">Vendor Code</th>
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

                            <c:set var="count" value="0" scope="page" />

                            <tbody>
                                <tr>
                                    <th  colspan="5">Vendor Name </th>
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

                                    <th>Terms Condition<br>&nbsp;</th>
                                    <th colspan="4">Description<br>&nbsp;</th>

                                    <c:if test="${vendor_code1 != ''}">
                                        <th style="width:60px">Response</th>
                                        <th style="width:60px">Remark</th>
                                            <c:if test="${rev_submit_flag1 == '1'}">
                                            <th style="width:60px">Response</th>
                                            <th style="width:60px">Remark</th>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${vendor_code2 != ''}">
                                        <th style="width:60px">Response</th>
                                        <th style="width:60px">Remark</th>
                                            <c:if test="${rev_submit_flag2 == '1'}">
                                            <th style="width:60px">Response</th>
                                            <th style="width:60px">Remark</th>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${vendor_code3 != ''}">
                                        <th style="width:60px">Response</th>
                                        <th style="width:60px">Remark</th>
                                            <c:if test="${rev_submit_flag3 == '1'}">
                                            <th style="width:60px">Response</th>
                                            <th style="width:60px">Remark</th>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${vendor_code4 != ''}">
                                        <th style="width:60px">Response</th>
                                        <th style="width:60px">Remark</th>
                                            <c:if test="${rev_submit_flag4 == '1'}">
                                            <th style="width:60px">Response</th>
                                            <th style="width:60px">Remark</th>
                                            </c:if>
                                        </c:if>        
                                </tr>


                                <c:forEach var="vendorTermsCondition1" items="${vendorTermsCondition1}" varStatus="status">
                                    <tr>
                                        <td style="padding: 0px 0px;">${vendorTermsCondition1.termsCondition}</td>
                                        <td style="padding: 0px 0px;" colspan="4">${vendorTermsCondition1.description}</td>


                                        <!-- /vendor 1/ start here-->

                                        <c:if test="${vendor_code1 != ''}">
                                            <c:forEach var="vendorTermsConditionPriceBid1" items="${vendorTermsConditionPriceBid1}">
                                                <c:if test="${vendorTermsCondition1.termsCondition==vendorTermsConditionPriceBid1.termsCondition && vendorTermsCondition1.description==vendorTermsConditionPriceBid1.description}">

                                                    <td style="padding: 0px 0px;"> 

                                                        <c:choose>
                                                            <c:when test="${vendorTermsConditionPriceBid1.response == 0}">
                                                                Accept
                                                            </c:when>
                                                            <c:otherwise>
                                                                Reject
                                                            </c:otherwise>
                                                        </c:choose>

                                                    </td>
                                                    <td style="padding: 0px 0px;">${vendorTermsConditionPriceBid1.comment}</td>
                                                </c:if>
                                            </c:forEach>
                                            <c:if test="${rev_submit_flag1 == '1'}">


                                                <td style="padding: 0px 0px;"> 
                                                    <c:choose>
                                                        <c:when test="${vendorTermsCondition1.response == 0}">
                                                            Accept
                                                        </c:when>
                                                        <c:otherwise>
                                                            Reject
                                                        </c:otherwise>
                                                    </c:choose>
                                                </td>

                                                <td style="padding: 0px 0px;">${vendorTermsCondition1.comment}</td>
                                            </c:if>

                                        </c:if>

                                        <!-- /vendor 1/ end here-->

                                        <!-- /vendor 2/ Start here-->

                                        <c:if test="${vendor_code2 != ''}">
                                            <c:forEach var="vendorTermsConditionPriceBid2" items="${vendorTermsConditionPriceBid2}" varStatus="status1">
                                                <c:if test="${vendorTermsCondition1.termsCondition == vendorTermsConditionPriceBid2.termsCondition && vendorTermsCondition1.description==vendorTermsConditionPriceBid2.description}">

                                                    <td style="padding: 0px 0px;">
                                                        <c:choose>
                                                            <c:when test="${vendorTermsConditionPriceBid2.response == 0}">
                                                                Accept
                                                            </c:when>
                                                            <c:otherwise>
                                                                Reject
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>
                                                    <td style="padding: 0px 0px;">${vendorTermsConditionPriceBid2.comment}</td>
                                                </c:if>
                                            </c:forEach>
                                            <c:if test="${rev_submit_flag2 == '1'}">
                                                <c:forEach var="vendorTermsCondition2" items="${vendorTermsCondition2}" varStatus="status1">
                                                    <c:if test="${vendorTermsCondition1.termsCondition == vendorTermsCondition2.termsCondition}">

                                                        <td style="padding: 0px 0px;">
                                                            <c:choose>
                                                                <c:when test="${vendorTermsCondition2.response == 0}">
                                                                    Accept
                                                                </c:when>
                                                                <c:otherwise>
                                                                    Reject
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </td>
                                                        <td style="padding: 0px 0px;">${vendorTermsCondition2.comment}</td>
                                                    </c:if>
                                                </c:forEach>
                                            </c:if>
                                        </c:if>
                                        <!-- /vendor 2/ end here-->

                                        <!-- /vendor 3/ Start here-->

                                        <c:if test="${vendor_code3 != ''}">
                                            <c:forEach var="vendorTermsConditionPriceBid3" items="${vendorTermsConditionPriceBid3}" varStatus="status1">
                                                <c:if test="${vendorTermsCondition1.termsCondition == vendorTermsConditionPriceBid3.termsCondition && vendorTermsCondition1.description==vendorTermsConditionPriceBid3.description}">

                                                    <td style="padding: 0px 0px;">
                                                        <c:choose>
                                                            <c:when test="${vendorTermsConditionPriceBid3.response == 0}">
                                                                Accept
                                                            </c:when>
                                                            <c:otherwise>
                                                                Reject
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>
                                                    <td style="padding: 0px 0px;">${vendorTermsConditionPriceBid3.comment}</td>
                                                </c:if>
                                            </c:forEach>
                                            <c:if test="${rev_submit_flag3 == '1'}">
                                                <c:forEach var="vendorTermsCondition3" items="${vendorTermsCondition3}" varStatus="status1">
                                                    <c:if test="${vendorTermsCondition1.termsCondition == vendorTermsCondition3.termsCondition}">
                                                        <td style="padding: 0px 0px;">
                                                            <c:choose>
                                                                <c:when test="${vendorTermsCondition3.response == 0}">
                                                                    Accept
                                                                </c:when>
                                                                <c:otherwise>
                                                                    Reject
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </td>
                                                        <td style="padding: 0px 0px;">${vendorTermsCondition3.comment}</td>
                                                    </c:if>
                                                </c:forEach>
                                            </c:if>
                                        </c:if>

                                        <!-- /vendor 3/ end here-->  

                                        <!-- /vendor 4/ Start here-->

                                        <c:if test="${vendor_code4 != ''}">
                                            <c:forEach var="vendorTermsConditionPriceBid4" items="${vendorTermsConditionPriceBid4}" varStatus="status1">
                                                <c:if test="${vendorTermsCondition1.termsCondition == vendorTermsConditionPriceBid4.termsCondition && vendorTermsCondition1.description==vendorTermsConditionPriceBid4.description}">

                                                    <td style="padding: 0px 0px;">
                                                        <c:choose>
                                                            <c:when test="${vendorTermsConditionPriceBid4.response == 0}">
                                                                Accept
                                                            </c:when>
                                                            <c:otherwise>
                                                                Reject
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>
                                                    <td style="padding: 0px 0px;">${vendorTermsConditionPriceBid4.comment}</td>
                                                </c:if>
                                            </c:forEach>
                                            <c:if test="${rev_submit_flag4 == '1'}">
                                                <c:forEach var="vendorTermsCondition4" items="${vendorTermsCondition4}" varStatus="status1">
                                                    <c:if test="${vendorTermsCondition1.termsCondition == vendorTermsCondition4.termsCondition}">

                                                        <td style="padding: 0px 0px;">
                                                            <c:choose>
                                                                <c:when test="${vendorTermsCondition4.response == 0}">
                                                                    Accept
                                                                </c:when>
                                                                <c:otherwise>
                                                                    Reject
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </td>
                                                        <td style="padding: 0px 0px;">${vendorTermsCondition4.comment}</td>
                                                    </c:if>
                                                </c:forEach>
                                            </c:if>
                                        </c:if>

                                        <!-- /vendor 4/ end here-->
                                    </tr>

                                </c:forEach>





                            </tbody>


                        </table>
                    </div>
                            <br>                       
                                
                         <table id="commonNoPageTable5" class="table table-striped bg-white dt-scroll" style="width: 100%" align="Center" >
    <thead>
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
     <tbody>
                            <tr>
                                <td>${vendor_code1}</td>
                                <td>${vendor_name1}</td>

                                <c:if test="${(Total1 - igstValueFinal1) > 0}">
                                    <td>
                                        <fmt:formatNumber value="${Total1 - igstValueFinal1}" type="number" minFractionDigits="2" maxFractionDigits="2"/>
                                    </td>
                                </c:if>
                                <c:if test="${(Total1 - igstValueFinal1) <= 0}">
                                    <td></td> 
                                </c:if>

                                <td><fmt:formatNumber value="${serviceTaxTotal1 - servicegstFinal1}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                <td><fmt:formatNumber value="${(serviceTaxTotal1 - servicegstFinal1) + (Total1 - igstValueFinal1)}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                <td><fmt:formatNumber value="${servicegstFinal1 + igstValueFinal1}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                <td><fmt:formatNumber value="${Total1 + serviceTaxTotal1}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                <td><fmt:formatNumber value="${tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                <td><fmt:formatNumber value="${tenderMaster.value - Total1 - serviceTaxTotal1}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                <td></td>
                            </tr>
                            <c:if test="${rev_submit_flag1 == '1'}">
                                <tr>
                                    <td>${vendor_code1} Revise</td>
                                    <td>${vendor_name1}</td>
                                    <td><fmt:formatNumber value="${revTotal1 - revigstValueFinal1}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td><fmt:formatNumber value="${revserviceTaxTotal1 - revservicegstFinal1}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td><fmt:formatNumber value="${(revserviceTaxTotal1 - revservicegstFinal1) + (revTotal1 - revigstValueFinal1)}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td><fmt:formatNumber value="${revservicegstFinal1 + revigstValueFinal1}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td><fmt:formatNumber value="${revTotal1 + revserviceTaxTotal1}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td><fmt:formatNumber value="${tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td><fmt:formatNumber value="${tenderMaster.value - revTotal1 - revserviceTaxTotal1}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td></td>
                                </tr>
                            </c:if>
                            <c:if test="${vendor_code2 != ''}">
                                <tr>
                                    <td>${vendor_code2}</td>
                                    <td>${vendor_name2}</td>
                                    <td><fmt:formatNumber value="${Total2 - igstValueFinal2}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td><fmt:formatNumber value="${serviceTaxTotal2 - servicegstFinal2}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td><fmt:formatNumber value="${(serviceTaxTotal2 - servicegstFinal2) + (Total2 - igstValueFinal2)}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td><fmt:formatNumber value="${servicegstFinal2 + igstValueFinal2}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td><fmt:formatNumber value="${Total2 + serviceTaxTotal2}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td><fmt:formatNumber value="${tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td><fmt:formatNumber value="${tenderMaster.value - Total2 - serviceTaxTotal2}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td></td>
                                </tr>
                                <c:if test="${rev_submit_flag2 == '1'}">
                                    <tr>
                                        <td>${vendor_code2} Revise</td>
                                        <td>${vendor_name2}</td>
                                        <td><fmt:formatNumber value="${revTotal2 - revigstValueFinal2}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td><fmt:formatNumber value="${revserviceTaxTotal2 - revservicegstFinal2}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td><fmt:formatNumber value="${(revserviceTaxTotal2 - revservicegstFinal2) + (revTotal2 - revigstValueFinal2)}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td><fmt:formatNumber value="${revservicegstFinal2 + revigstValueFinal2}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td><fmt:formatNumber value="${revTotal2 + revserviceTaxTotal2}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td><fmt:formatNumber value="${tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td><fmt:formatNumber value="${tenderMaster.value - revTotal2 - revserviceTaxTotal2}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td></td>
                                    </tr>
                                </c:if>
                            </c:if>
                            <c:if test="${vendor_code3 != ''}">
                                <tr>
                                    <td>${vendor_code3}</td>
                                    <td>${vendor_name3}</td>
                                    <td><fmt:formatNumber value="${Total3 - igstValueFinal3}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td><fmt:formatNumber value="${serviceTaxTotal3 - servicegstFinal3}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td><fmt:formatNumber value="${(serviceTaxTotal3 - servicegstFinal3) + (Total3 - igstValueFinal3)}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td><fmt:formatNumber value="${servicegstFinal3 + igstValueFinal3}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td><fmt:formatNumber value="${Total3 + serviceTaxTotal3}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td><fmt:formatNumber value="${tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td><fmt:formatNumber value="${tenderMaster.value - Total3 - serviceTaxTotal3}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td></td>
                                </tr>
                                <c:if test="${rev_submit_flag3 == '1'}">
                                    <tr>
                                        <td>${vendor_code3} Revise</td>
                                        <td>${vendor_name3}</td>
                                        <td><fmt:formatNumber value="${revTotal3 - revigstValueFinal3}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td><fmt:formatNumber value="${revserviceTaxTotal3 - revservicegstFinal3}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td><fmt:formatNumber value="${(revserviceTaxTotal3 - revservicegstFinal3) + (revTotal3 - revigstValueFinal3)}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td><fmt:formatNumber value="${revservicegstFinal3 + revigstValueFinal3}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td><fmt:formatNumber value="${revTotal3 + revserviceTaxTotal3}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td><fmt:formatNumber value="${tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td><fmt:formatNumber value="${tenderMaster.value - revTotal3 - revserviceTaxTotal3}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td></td>
                                    </tr>
                                </c:if>
                            </c:if>

                            <c:if test="${vendor_code4 != ''}">
                                <tr>
                                    <td>${vendor_code4}</td>
                                    <td>${vendor_name4}</td>
                                    <td><fmt:formatNumber value="${Total4 - igstValueFinal4}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td><fmt:formatNumber value="${serviceTaxTotal4 - servicegstFinal4}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td><fmt:formatNumber value="${(serviceTaxTotal4 - servicegstFinal4) + (Total4 - igstValueFinal4)}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td><fmt:formatNumber value="${servicegstFinal4 + igstValueFinal4}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td><fmt:formatNumber value="${Total4 + serviceTaxTotal4}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td><fmt:formatNumber value="${tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td><fmt:formatNumber value="${tenderMaster.value - Total4 - serviceTaxTotal4}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td></td>
                                </tr>
                                <c:if test="${rev_submit_flag4 == '1'}">
                                    <tr>
                                        <td>${vendor_code4} Revise</td>
                                        <td>${vendor_name4}</td>
                                        <td><fmt:formatNumber value="${revTotal4 - revigstValueFinal4}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td><fmt:formatNumber value="${revserviceTaxTotal4 - revservicegstFinal4}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td><fmt:formatNumber value="${(revserviceTaxTotal4 - revservicegstFinal4) + (revTotal4 - revigstValueFinal4)}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td><fmt:formatNumber value="${revservicegstFinal4 + revigstValueFinal4}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td><fmt:formatNumber value="${revTotal4 + revserviceTaxTotal4}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td><fmt:formatNumber value="${tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td><fmt:formatNumber value="${tenderMaster.value - revTotal4 - revserviceTaxTotal4}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                        <td></td>
                                    </tr>
                                </c:if>
                            </c:if>  
                                    </tbody>
                        </table>
            <br>       
                
                    <div class="rounded-4 mt-4"> 
                        <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                            <div class="row buyer-info">
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
                                        <label>Bid Sent From No. Of Vendor</label>
                                        <p class="fw-600">${total_vendor}</p>

                                    </div>
                                </div>       
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Bid Received From No. Of Vendor</label>
                                        <p class="fw-600">${total_bid}</p>

                                    </div>
                                </div>       

                            </div>       
                        </div>       
                    </div>             
                        
                    <h5 class="fw-600">Activity Milestone</h5>
                    <table id="commonNoPageTable3" class="table table-striped bg-white" style="width: 100%" align="center" >
                        <thead>
                            <tr>
                                <th>Sr No.</th>
                                <th>Activity</th>
                                <th>Activity By</th>
                                <th>Date</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>PR Create</td>
                                <td>${prMaster.contactPerson}</td>
                                <td>${prMaster.announceDate}</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>PR Approve</td>
                                <td>${prMaster.prAuthorizeUser}</td>
                                <td>${prMaster.prAuthorizeDate}</td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>Tender Assign By</td>
                                <td>${prMaster.tenderAssignUser}</td>
                                <td>${prMaster.tenderAssignDate}</td>
                            </tr>
                            <tr>
                                <td>4</td>
                                <td>Tender Create</td>
                                <td>${prMaster.tenderCreaterUser}</td>
                                <td>${prMaster.tenderCreaterDate}</td>
                            </tr>
                            <tr>
                                <td>5</td>
                                <td>Technical Bid Open</td>
                                <td>${prMaster.techBidOpenUser}</td>
                                <td>${prMaster.techBidOpenDate}</td>
                            </tr>
                            <tr>
                                <td>6</td>
                                <td>Technical Bid Approve</td>
                                <td>${prMaster.techBidApproveUser}</td>
                                <td>${prMaster.techBidApproveDate}</td>
                            </tr>
                            <tr>
                                <td>7</td>
                                <td>Price Bid Initiate</td>
                                <td>${prMaster.priceBidStartUser}</td>
                                <td>${prMaster.priceBidStartDate}</td>
                            </tr>
                            <tr>
                                <td>8</td>
                                <td>Price Bid Open</td>
                                <td>${prMaster.priceBidOpenUser}</td>
                                <td>${prMaster.priceBidOpenDate}</td>
                            </tr>
                        </tbody>
                    </table>                
                    <h5 class="fw-600">User Approval List</h5>
                    <table id="commonNoPageTable2" class="table table-striped bg-white" style="width: 100%" align="Center"  >
                        <thead>
                            <tr>
                                <th>Tender Ref No.</th>
                                <th>Comment</th>
                                <th>Attachment</th>
                                <th data-dt-order="disable">View</th>
                            </tr>
                        </thead>
                        <c:set var="count" value="0" scope="page" />
                        <tbody>
                            <tr>
                                <td>${tenderPriceApproval.tenderNo}</td>
                                <td>${tenderPriceApproval.approvalRemark}</td>
                                <td><a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=vendorListViewDownload&id=${tenderPriceApproval.id}&refNo=${refNo}">${tenderPriceApproval.attachment}</a></td>
                                <td><a href="tenderMaster.htm?act=viewApproveUserList&id=${tenderPriceApproval.id}">View</a></td>
                            </tr>
                        </tbody>
                    </table>
                            <br> 
                          <c:if test="${not empty list3}">
  
                    <h5 class="fw-600">Approval Comments</h5>
                    <table id="commonNoPageTable4" class="table table-striped bg-white" style="width: 100%" align="Center"  >
                        <thead>
                            <tr>
                                <th>User Id</th>
                                <th>Comment</th>
                                <th>Date Time</th>
                            </tr>
                        </thead>
                        <c:set var="count" value="0" scope="page" />
                        <tbody>
                            <c:forEach var="list2" items="${list3}" varStatus="status">
                                <tr>
                                    <td>${list2.userId}</td>
                                    <td>${list2.approvalComment}</td>
                                    <td>${list2.dateTime}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                          </c:if>
                    <h5 class="fw-600"> Tendor Approve Price Bid View</h5>
                    <div class="col-12 p-0">
                        <div class="form-group comment-box">
                            <label class="control-label">Comment :<span class="text-danger">*</span></label>
                            <textarea type="text" maxlength="250" class="textarea-field comment" id="comment" name="comment"  required="true"></textarea>
                            <small id="charCount_comment" style="font-size: 12px; color: green;">250 characters remaining</small>
                            <script type="text/javascript">
                                        document.addEventListener("DOMContentLoaded", function () {
                                        var textarea = document.getElementById("comment");
                                                var counter = document.getElementById("charCount_comment");
                                                var maxChars = 250;
                                                function updateCounter() {
                                                var count = textarea.value.length;
                                                        var remaining = maxChars - count;
                                                        counter.textContent = remaining + " characters remaining";
                                                        if (remaining <= 20) {
                                                counter.style.color = "red";
                                                } else {
                                                counter.style.color = "green";
                                                }
                                                }

                                        updateCounter(); // For pre-filled remarks in edit mode
                                                textarea.addEventListener("input", updateCounter);
                                        });</script>
                        </div>
                    </div>                     
                    <div class="form-group">
                       <div style="display: flex;  justify-content: center;">

                           <button type="submit" class="btn theme-btn mr-3"  onclick="approve();"   value="">Approve</button>
                               <button type="submit" class="btn theme-btn mr-3"  formaction="tenderMaster.htm?act=reworkBid"  onclick="rework();" value="">Rework </button>
                            <button type="submit" class="btn theme-btn mr-3"  formaction="tenderMaster.htm?act=reworkBidToBuyer"  onclick="rework();" value="">Rework To Buyer </button>
                        </div>
                    </div>
                </form:form>
                <form:form id="myForm" enctype="multipart/form-data" commandName="prMaster" name="form" class="form-horizontal" role="form"> 
                    <div class="modal fade" id="vendorAttach" data-backdrop="static" data-keyboard="false" tabindex="-1"
                         aria-labelledby="vendorAttachLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">

                                <div class="modal-header align-items-center">
                                    <h5 class="modal-title" id="vendorAttachLabel">Vendor All Attachment</h5>
                                    <div class="cta-btn d-flex align-items-center">
                                        <button type="button" class="btn theme-btn light-btn" data-dismiss="modal" onclick="event.preventDefault();">Close</button>
                                    </div>
                                </div>

                                <div class="modal-body">
                                    <input type="hidden" id="tender_no" name="tender_no" />
                                    <input type="hidden" id="vendorCode" name="vendorCode" />
                                    <input type="hidden" id="refNo" name="refNo" />
                                </div>

                                <div id="resultDiv" class="bg-white">
                                    <script>

                                                function loadAllvendorattach(refNo, vendorCode) {
                                                // Set input values
                                                document.getElementById("tender_no").value = refNo;
                                                        document.getElementById("vendorCode").value = vendorCode;
                                                        document.getElementById("refNo").value = refNo;
                                                        // AJAX request
                                                        $.ajax({
                                                        url: 'tenderMaster.htm?act=vendorAllAttachView1',
                                                                type: 'GET',
                                                                data: {
                                                                refNo: refNo,
                                                                        vendorCode: vendorCode
                                                                },
                                                                success: function(response) {
                                                                document.getElementById("resultDiv").innerHTML = response;
                                                                        $('#vendorAttach').modal('show');
                                                                        setTimeout(function () {
                                                                        if ($('#VendorCommercialAttachment').length) {
                                                                        const table1 = initTable('#VendorCommercialAttachment');
                                                                        }
                                                                        if ($('#technicalSpecificationTable').length) {
                                                                        const table2 = initTable('#technicalSpecificationTable');
                                                                        }
                                                                        if ($('#priceSpecificationTable').length) {
                                                                        const table3 = initTable('#priceSpecificationTable');
                                                                        }
                                                                        if ($('#reviseSpecificationTable').length) {
                                                                        const table4 = initTable('#reviseSpecificationTable');
                                                                        }
                                                                        if ($('#revisePriceSpecificationTable').length) {
                                                                        const table5 = initTable('#revisePriceSpecificationTable');
                                                                        }
                                                                        }, 100);
//                                                                        
                                                                },
                                                                error: function(xhr, status, error) {
                                                                console.error("AJAX Error:", error);
                                                                }
                                                        });
                                                        return false;
                                                }



                                    </script>
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
