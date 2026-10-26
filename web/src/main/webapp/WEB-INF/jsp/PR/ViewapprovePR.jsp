<%-- 
    Document   : EmployeeCreate
    Created on : Jun 11, 2020, 2:39:39 PM
    Author     : Aman Bahukhandi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>Approve PR</title>
        
           <script language="javascript" type="text/javascript">
            function gettender()
            {

                var t = document.getElementById("refNo").value;
                var tenderPhase = document.getElementById("tenderPhase").value;
                window.location = 'tenderMaster.htm?act=getTender&refNo=' + t + '&tenderPhase=' + tenderPhase;
            }

            function approve() {
                var id = document.getElementById("id").value;
                var comment = document.getElementById("comment").value;
                window.location = 'prMaster.htm?act=approvePR&id=' + id + '&comment=' + comment;
            }

            function reject() {
                var id = document.getElementById("id").value;
                var comment = document.getElementById("comment").value;
                window.location = 'prMaster.htm?act=rejectPR&id=' + id + '&comment=' + comment;
            }

            function rework() {
                var id = document.getElementById("id").value;
                var comment = document.getElementById("comment").value;
                window.location = 'prMaster.htm?act=reworkPR&id=' + id + '&comment=' + comment;
            }

        </script>
         <script>
        function cancelClick() {
            window.location = 'prMaster.htm?act=approvePRList';
        }
    </script>
       
        
    </head>

    <body>
        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

            <section class="main-content">
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
                    <div class="cta d-flex align-items-center">
                        <a class="btn theme-btn light-btn mr-3"  onclick="cancelClick();">Back</a>
                        
                    </div>
                </div>
                <hr>
                <c:if test="${!empty successMessage}">
                    <div id="successMsg" class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                </c:if>
                <c:if test="${!empty failureMessage}">
                    <div id="failureMsg" class="fadeOutEffect alert alert-danger" style="padding: 0px" role="alert">${failureMessage}</div>
                </c:if>
                <form:form action="prMaster.htm?act=approvePR" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                           class="form-horizontal" role="form">
                    
                   <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.
                        </div>
                    </div>
 
                    <br>
                       <c:forEach var="list2" items="${list2}" varStatus="status">                      
                            <div class="rounded-4 mt-4"> 
                                <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                                    <div class="row buyer-info">
                                        <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                            <div class="form-group">
                                                <label>PR Reference No.</label>
                                                <p class="fw-600">${list2.prNo}</p>
                                                <input type="hidden" name="prNo" class="input-field" value="${list2.prNo}" />
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
                    
                    <c:if test="${prMaster.singleQuoteFlag== 1}">
                        <div class="form-group">
                                <h6 class="fw-600">Single Quote Attachment </h6>
                            </div>
                        <table id="commonDocTable" class="table table-striped bg-white dt-scroll" style="min-width: 100%;" align="center">
                            <thead>
                                <tr>
                                    <th data-dt-order="disable" style="min-width: 40%;" class="">Attachment</th>
                                    <th data-dt-order="disable"style="min-width: 50%;">File</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <label class="control-label">
                                            Attachment:
                                        </label>
                                    </td>
                                    <td>
                                        <a class="fw-600 text-break gradient-text"
                                           href="prMaster.htm?act=downloadPrSingleQuoteAttachment
                                           &prNo=${prMaster.prNo}
                                           &id=${prMaster.id}
                                           &page=viewapprovePR">
                                            ${prMaster.singleQuoteAttachment}
                                        </a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </c:if>
                       
                        <c:if test="${not empty list6}">
                            <div class="form-group">
                                <h6 class="fw-600">Site Address</h6>
                            </div>
                    <table id="commonNoPageTable2" class="table  table-striped bg-white" style="min-width: 100%" align="Center"  >
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
                        <c:forEach var="list6" items="${list6}" varStatus="status">
                            <tr>
                                <td >${status.count}</td>
                                <td >${list6.address1}</td>
                                <td >${list6.address2}</td>
                                <td >${list6.city}</td>
                                <td >${list6.state}</td>
                                <td >${list6.pincode}</td>
                                <td >${list6.remark}</td>
                            </tr>
                        </c:forEach>
                    </table>
                        </c:if>
                    <br>  
                    <div class="form-group">
                                <h6 class="fw-600">Vendor Details</h6>
                            </div>
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
                            <c:forEach var="prVendor" items="${list3}" varStatus="status">
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
                        <br>
                        <c:if test="${not empty list4}">
                            <c:if test="${prMaster.type == 'Contract Civil'}">
                               <h6 class="fw-600">Civil Details </h6><hr>
                            </c:if>
                            <c:if test="${prMaster.type != 'Contract Civil'}">
                                <c:if test="${prMaster.type == 'Service'}">
                                   <h6 class="fw-600">Items Details For Service</h6>
                                </c:if>
                                <c:if test="${prMaster.type != 'Service'}">
                                   <h6 class="fw-600">Item Details</h6>
                                </c:if>
                            </c:if>
                                   <table id="commonNoPageTable" class="table  table-striped bg-white" align="center">
                                       <thead>
                                           <tr>
                                               <th>Sr. No.</th>
                                               <th style=" min-width: 190px;">Item Code</th>
                                               <th style=" min-width: 530px;">Item Description</th>
                                               <th style=" min-width: 230px;">Purpose</th>
                                               <th style=" min-width: 230px;">Make</th>
                                               <th>UOM</th>
                                               <th>Qty</th>
                                               <th>Account Category</th>
                                               <th>Account Value</th>
                                               <th>Product Type</th>
                                               <th>Product Group</th>
                                               <th>TAX Code</th>
                                               <th>Price</th>
                                               <th style=" min-width: 190px;">Delivery Date</th>
                                               <th style=" min-width: 190px;">Start Date</th>
                                               <th style=" min-width: 190px;">End Date</th>
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
                             </c:if>
                        <br>
                        <c:if test="${prMaster.type == 'Contract' || prMaster.type == 'Contract Civil' || prMaster.type == 'Contract Electrical'}">
                            <c:if test="${prMaster.type == 'Contract Civil'}">
                                <h6 class="fw-600">Steel Details </h6>
                            </c:if>
                            <c:if test="${prMaster.type != 'Contract Civil'}"> 
                                <h6 class="fw-600">Item Details For Service</h6> 
                            </c:if>
                        </c:if>
                        <c:if test="${not empty list5}">
                            <table id="commonNoPageTable0" class="table table-striped bg-white" style=" width: 100%;" align="center">
                                <thead>
                                    <tr style="width: 5vh;">
                                        <th>Sr. No.</th>
                                        <th style=" min-width: 190px;">Item Code</th>
                                        <th style=" min-width: 530px;">Item Description</th>
                                        <th style=" min-width: 230px;">Purchase</th>
                                        <th style=" min-width: 230px;">Make</th>
                                        <th >UOM</th> 
                                        <th >Qty</th>   
                                        <th >Account Category</th>
                                        <th >Account Value</th>
                                        <th >Product Type</th>
                                        <th >Product Group</th>
                                        <th >TAX Code</th>
                                        <th >Price</th>
                                        <th style="min-width: 190px;">Delivery Date</th>
                                        <th style="min-width: 190px;">Start Date</th>
                                        <th style="min-width: 190px;">End Date</th>
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
                    <div class="form-group">
                                <h6 class="fw-600">Technical Documents</h6>
                            </div>
                    <table id="commonNoPageTable1" class="table  table-striped bg-white" style="min-width: 100%" align="Center"  >
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
                                        <c:if test="${prDoc.attachmentRequired != 1}">
                                            No
                                        </c:if>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                        </c:if>
                        <br>
                        <h6 class="fw-600 ">Remark: </h6>
                        <div class="col-12 p-0">
                            <div class="form-group comment-box">
                                <c:forEach var="list2" items="${list2}">
                                    <textarea class="textarea-field comment" readonly="true">${list2.remarks}</textarea>
                                </c:forEach>
                            </div>
                        </div>  
                        <br>
                        <c:if test="${not empty list1}">
                            
                            <div class="form-group">
                                <h6 class="fw-600">PR Approval  Details</h6>
                            </div>
                            <c:forEach var="list1" items="${list1}" varStatus="status">
                                <table id="commonNoPageTable4" class="table table-striped bg-white" style="min-width: 100%" align="Center"  >
                                    <input type="hidden" name="id" id="id" value="${list1.id}">
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
                            <div class="form-group">
                                <h6 class="fw-600">PR Approval Histroy</h6>
                            </div>
                            <table id="commonNoPageTable5" class="table  table-striped bg-white" style="min-width: 100%" align="Center"  >
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
                                            <td></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </c:if>
                    <br>
                    <h6 class="fw-600 " >Comment <span class="text-danger">*</span> </h6>
                    <div class="col-12 p-0">
                        <div class="form-group comment-box">
                            <textarea type="text" maxlength="250" class="textarea-field comment" id="comment" name="comment"  required="true"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <div style="display: flex;  justify-content: center;">
                            <button type="submit" class="btn theme-btn mr-3" style="width: 100px;" value="">Approve</button>
                            <button type="submit" class="btn theme-btn mr-3" style="width: 100px;" formaction="prMaster.htm?act=reworkPR" title="" value="" >Rework</button>
                            <button type="submit" class="btn theme-btn mr-3" style="width: 100px;" formaction="prMaster.htm?act=rejectPR" title="" value="" >Reject</button>
                        </div>
                    </div>
                </form:form>
            </section>
        </main> 
    </body>    
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
    <script>
                if ($("#ItemDetailsTab").length) {
        const table1 = initTable("#ItemDetailsTab");
        }
    </script>
    <script>
        if ($("#ItemDetailsTab1").length) {
        const table1 = initTable("#ItemDetailsTab1");
        }
    </script>
</html>


