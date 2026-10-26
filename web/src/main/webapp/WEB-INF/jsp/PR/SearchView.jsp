
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PR DETAILS</title>
         <script>
        function cancelClick() {
            window.location = 'prMaster.htm?act=pendingPRList';
        }
    </script>
    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="prMaster.htm?act=approvePR" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                           class="form-horizontal" role="form"><div>

                        <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                            <div class="page-title d-flex align-items-center">
                                <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                    <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                         alt="Menu collapse">
                                    <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                         alt="Menu collapse">
                                </div>

                                <h5 class="fw-600 mb-0">${prNo}</h5>
                            </div>
                        <input type="hidden" name="id" value="${id}">  

                            <div class="cta d-flex align-items-center">
                                <a onclick="cancelClick();" class="btn theme-btn light-btn mr-3">Back</a>
                                <button type="button" class="btn theme-btn mr-3" title=""  onclick="window.location = 'prMaster.htm?act=ExportToExcel&id=${id}'"><i class=""></i>Export Excel</button>
                                <c:if test="${fn:contains(sessionScope.userRights.employeeMgt,'1') || sessionScope.user.loginName == prMaster.prAdmin}">	
                                <button type="button" class="btn theme-btn mr-3" title=""  onclick="window.location = 'tenderMaster.htm?act=changeProjectIdView&refNo=${prNo}'">Change  PR</button>
                                </c:if>
                                <button type="button" class="btn theme-btn" onclick="window.location='prMaster.htm?act=prPrint&id=${id}'">
                                     PR Print
                                </button>
                              </div>
                        </div>
                                     
                                     <c:if test="${!empty failureMessage}">                        
                        <div class="fadeOutEffect alert alert-danger mt-2 mb-2" style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                            <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                            <div>
                                <strong>Note:</strong> <strong class="text-danger fs-13">${failureMessage} </strong><br>                            
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${!empty successMessage}">                       
                        <div class="fadeOutEffect alert alert-info mt-2 mb-2" style="display: flex; align-items: center; gap: 12px; background: #F0FFF4; color: #0F5132; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #198754; box-shadow: 2px 2px 10px rgba(25, 135, 84, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">                        
                            <div style="background: #198754; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px; ">✓</div>  
                            <div>                             
                                <strong>Note:</strong> <strong class="text-success fs-13">${successMessage} </strong><br>                            
                            </div>
                        </div>
                    </c:if>
                        <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                        <hr>

                        <c:forEach var="list2" items="${list2}" varStatus="status">                      
                            <div class="rounded-4 mt-4"> 
                                <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                                    <div class="row buyer-info">
                                        <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                            <div class="form-group">
                                                <label>PR Reference No.</label>
                                                <p class="fw-600">${list2.prNo}</p>
                                            </div>
                                        </div>
                                        <c:if test="${omsMaster != null}">
                                            <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                                <div class="form-group">
                                                    <label>OMS Ticket Id</label>
                                                    <p class="fw-600">${omsMaster.ticketId}</p>
                                                    <input type="hidden" name="omsMasterId" id="omsMasterId" class="input-field" value="${omsMaster.id}" />
                                                </div>
                                            </div>
                                            <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                                <div class="form-group">
                                                    <label>OMS PR Id</label>
                                                    <p class="fw-600">${omsMaster.omsPrId}</p>
                                                </div>
                                            </div>
                                        </c:if>
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
                                                <label>PR Date </label>
                                                <p class="fw-600">${list2.announceDate}</p>
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
                                                <label>Created Contact Number </label>
                                                <p class="fw-600">${list2.prAdminContactNumber}</p>
                                            </div>
                                        </div>
                                        <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                            <div class="form-group">
                                                <label>Technical Person Name </label>
                                                <p class="fw-600">${list2.technicalContactName}</p>
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
                                                <p class="fw-600">${list2.value}</p>
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
                                                <label>Delivery Period </label>
                                                <p class="fw-600">${list2.deliveryPeriod}</p>
                                            </div>
                                        </div>
                                        <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                            <div class="form-group">
                                                <label>Technical Reviewer</label>
                                                <p class="fw-600">${list2.technicalCommittee}</p>
                                            </div>
                                        </div>
                                            <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                            <div class="form-group">
                                                <label>Name of Location Partner</label>
                                                <p class="fw-600">${list2.nameofLocationPartner}</p>
                                            </div>
                                        </div>
                                        <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                            <div class="form-group">
                                                <label>Mobile No Location Partner</label>
                                                <p class="fw-600">${list2.mobileNoLocationPartner}</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>  
                    </div> 
                                   
                        <c:if test="${not empty list6}">
                       <h6 class="fw-600">Site Address</h6>
                        <table id="commonNoPageTable1" class="table  table-striped bg-white" style="min-width: 100%" align="Center"  >
                            <thead>
                                <tr>
                                    <th>Sr. No.</th>
                                    <th>Address1</th>
                                    <th>Address2</th>
                                    <th>City</th>
                                    <th>State</th>
                                    <th>PinCode</th>
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
                        </c:if>
                        <c:if test="${prMaster.singleQuoteFlag== 1}">
                        <br>    
                            <h6 class="fw-600">Single Quote Attachment </h6>
                            <table id="commonNoPageTable2" class="table table-striped bg-white dt-scroll" style="min-width: 100%" align="center">
                                <thead>
                                    <tr>
                                        <th>Attachment:</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>
                                            <a class="fw-600 text-break gradient-text" href="prMaster.htm?act=downloadPrSingleQuoteAttachment&prNo=${prMaster.prNo}&id=${prMaster.id}&page=viewapprovePR">
                                                ${prMaster.singleQuoteAttachment}
                                            </a>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </c:if> 
                            <br>
                            <c:if test="${not empty prVendor}">
                        <h6  class="fw-600">Vendor Details </h6>
                        <table id="commonNoPageTable3" class="table  table-striped bg-white" style="min-width: 100%" align="Center"  >
                            <thead>
                                <tr>
                                    <th>Vendor Code</th>
                                    <th>Vendor Name</th>
                                    <th>Vendor Address</th>
                                    <th>Vendor EmailId</th>
                                    <th>Vendor Mobile No </th>
                                </tr>
                            </thead>
                            <c:set var="count" value="0" scope="page" />
                            <tbody>
                                <c:forEach var="prVendor" items="${prVendor}" varStatus="status">
                                    <tr>
                                        <td>${prVendor.vendorCode}</td>
                                        <td>${prVendor.vendorName}</td>
                                        <td>${prVendor.address}</td>
                                        <td>${prVendor.emailId}</td>
                                        <td>${prVendor.mobileNo}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                            </c:if>
                            <br>
                        <c:if test="${prMaster.type == 'Contract Civil'}">
                            <h6 class="fw-600">Civil Details </h6>
                        </c:if>
                        <c:if test="${prMaster.type != 'Contract Civil'}">
                            <c:if test="${prMaster.type == 'Service'}">
                                <h6 class="fw-600">Items Details For Service </h6>
                            </c:if>
                            <c:if test="${prMaster.type != 'Service'}">
                                <h6 class="fw-600">Item Details </h6>
                            </c:if>
                        </c:if>                         

                        <table id="commonNoPageTable4" class="table table-striped bg-white" style="width: 100%;" align="center">
                            <thead>
                                <tr>
                                    <th>Sr. No.</th>
                                    <th style="min-width: 180px;">Item Code</th>
                                    <th style="min-width: 530px;">Item Description</th>
                                    <th style="min-width: 180px;">Purpose</th>
                                    <th style="min-width: 180px;">Make</th>
                                    <th>UOM</th>
                                    <th>Qty</th>
                                    <th>Account Category</th>
                                    <th>Account Value</th>
                                    <th>Product Type</th>
                                    <th>Product Group</th>
                                    <th>TAX Code</th>
                                    <th>Price</th>
                                    <th style="min-width: 180px;">Delivery Date</th>
                                    <th style="min-width: 180px;">Start Date</th>
                                    <th style="min-width: 180px;">End Date</th>
                                </tr>
                            </thead>
                            <c:set var="count" value="0" scope="page" />
                            <tbody>
                                <c:forEach var="list4" items="${list4}" varStatus="status">
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
                    </div>
                            <br>
                    <c:if test="${prMaster.type == 'Contract' || prMaster.type == 'Contract Civil' || prMaster.type == 'Contract Electrical'}">

                        <c:if test="${prMaster.type == 'Contract Civil'}">
                            <h6  class="fw-600">Steel Details </h6>
                        </c:if>
                        <c:if test="${prMaster.type != 'Contract Civil'}"> 
                            &nbsp; <h6 class="fw-600">Item Details For Service</h6> 
                        </c:if>
                    </c:if>
                    <c:if test="${not empty list5}">
                        <table id="commonNoPageTable5" class="table table-striped bg-white" style=" width: 100%;" align="center">
                            <thead>
                                <tr >
                                    <th >Sr. No.</th>
                                    <th style="min-width: 180px;">Item Code</th>
                                    <th style="min-width: 530px;">Item Description</th>
                                    <th style="min-width: 180px;">Purchase</th>
                                    <th >Make</th>
                                    <th >UOM</th> 
                                    <th >Qty</th>   
                                    <th >Account Category</th>
                                    <th >Account Value</th>
                                    <th >Product Type</th>
                                    <th >Product Group</th>
                                    <th>TAX Code</th>
                                    <th >Price</th>
                                    <th style="min-width: 180px;">Delivery Date</th>
                                    <th style="min-width: 180px;">Start Date</th>
                                    <th style="min-width: 180px;">End Date</th>
                                </tr>
                            </thead>
                            <c:set var="count" value="0" scope="page" />
                            <tbody>
                                <c:forEach var="list4" items="${list5}" varStatus="status">
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
                    <c:if test="${not empty prDoc}">
                    <h6 class="fw-600">Technical Document </h6>
                    <table id="commonNoPageTable6" class="table  table-striped bg-white" style="min-width: 100%" align="Center"  >
                        <thead>
                            <tr>
                                <th>Sr. No.</th>
                                <th>Document</th>
                                <th >Attachment Required From Vendor</th>
                            </tr>
                        </thead>
                        <c:set var="count" value="0" scope="page" />
                        <tbody>
                            <c:forEach var="prDoc" items="${prDoc}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td><a class="fw-600 text-break gradient-text" href="prMaster.htm?act=downloadPrFile&amp;fileName=${prDoc.docName}&RefNo=${prDoc.refNo}">${prDoc.docName}</a></td>
                                    <td>
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
                    <h6 class="fw-600">PR Approval  Details </h6>
                    <table id="commonNoPageTable7" class="table  table-striped bg-white" style="width: 100%" align="Center"  >
                        <thead>
                            <tr>
                                <th>PR No.</th>
                                <th>Created By</th>
                                <th>Created Date</th>
                                <th>Created Person Comment </th>
                                <th>Total Approval Level</th>
                                <th>Approval Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="list1" items="${list1}" varStatus="status">
                            <input type="hidden" name="id" id="id" value="${list1.id}">
                            <tr> 
                                <td>${list1.prNo}</td>
                                <td>${list1.userId}</td>
                                <td>${list1.dateTime}</td>
                                <td>${list1.approvalRemark}</td>
                                <td>${list1.totalApproval}</td>
                                <c:if test="${list1.approvalStatus == 0}">
                                    <td>Pending</td>
                                </c:if>

                                <c:if test="${list1.approvalStatus == 1}">
                                    <td>Approve</td>
                                </c:if>

                                <c:if test="${list1.approvalStatus == 2}">
                                    <td>Rework</td>
                                </c:if>

                                <c:if test="${list1.approvalStatus == 3}">
                                    <td>Reject</td>
                                </c:if>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    </c:if>
                    <br>
                    <c:if test="${not empty approvalList}">
                    <h6 class="fw-600">PR Approval History</h6>
                    <table id="commonNoPageTable8" class="table  table-striped bg-white" style="min-width: 100%" align="Center"  >
                        <thead>
                            <tr>
                                <th>PR No.</th>
                                <th>User</th>
                                <th>Date Time</th>
                                <th>Comment </th>
                                <th>Approval Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="approvalList" items="${approvalList}" varStatus="status">
                                <tr> 
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
                  
                    <h6 class="fw-600">Remark </h6>
                    <div class="col-12 p-0">
                        <div class="form-group comment-box">
                            <c:forEach var="list2" items="${list2}">
                                <textarea type="text" maxlength="250" class="textarea-field comment"  readonly="true">${list2.remarks}</textarea>
                            </c:forEach>
                        </div>
                    </div>  
                 </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
