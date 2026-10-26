<%-- 
    Document   : VendorPolicy
    Created on : 28 Oct, 2025, 03:00:57 PM
    Author     : fnp
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>Technical Bid</title>
        <style>
            .textarea-field:disabled {
                background-color: #d6d8db !important;
                color: #495057 !important;           
                border: 1px solid #6c757d !important;
                opacity: 1;                          
            }
        </style>
        <script>
            function initDocTable(selector, obj = {}) {
            return $(selector).DataTable({
            paging: false,
                    lengthChange: false,
                    searching: false,
                    info: false,
                    autoWidth: true,
                    ordering: false,
                    scrollX: false,
                    dom: 't<"table-bottom-info d-flex align-items-center justify-content-between pt-3"i p>',
                    ...obj,
            });
            }
        </script>
    </head>

    <body>
        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNewVendor.jsp"%>

            <section id="printSection" class="main-content">
                <form:form action="vendor.htm?act=bidTenderForTechnicalReviseBidSubmit" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                           name="form"  class="form-horizontal" role="form" onsubmit="return validation();">              
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">Technical Bid</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a> 
                            <!--<button type="submit" class="btn theme-btn"  value="SUBMIT">Submit</button>-->
                        </div>
                    </div>
                    <hr>
                    <c:if test="${!empty successMessage}">
                        <div id="successMsg" class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                    </c:if>
                    <c:if test="${!empty failureMessage}">
                        <div id="failureMsg" class="fadeOutEffect alert alert-danger" style="padding: 0px" role="alert">${failureMessage}</div>
                    </c:if>

                   <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <strong>Note:</strong> Ensure your file size is within <strong>5MB</strong> for a smooth upload. <br>
                            <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.
                        </div>
                    </div>

                    
                    <br>
                    

                    <h5 class="fw-600"> Technical Bid</h5>
                    <hr>
                    <input type="hidden" name="itemDetailsSize" value="${itemDetailsSize}">
                    <input type="hidden" name="itemDetailsForServiceSize" value="${itemDetailsForServiceSize}">
                    <input type="hidden" name="attachmentCount" value="${attachmentCount}">
                    <input type="hidden" name="tenderPhase" id="tenderPhase" value="${tenderPhase}">
                    <input type="hidden" name="refNo" id="refNo" value="${refNo}">

                    <div class="card-box rounded-3 mb-4 pt-3 pb-2">
                        <div class="row buyer-info">

                            <!-- Row 1 -->
                            <div class="col-lg-4 col-md-4 pb-2">
                                <label class="text-muted">Tender Number</label>
                                <div class="fw-600">${tenderMaster.refNo}</div>
                            </div>

                            <div class="col-lg-4 col-md-4 pb-2">
                                <label class="text-muted">Project Name</label>
                                <div class="fw-600">${tenderMaster.title}</div>
                            </div>

                            <div class="col-lg-4 col-md-4 pb-2">
                                <label class="text-muted">Tender Revision</label>
                                <div class="fw-600">${rivision}</div>
                            </div>

                            <!-- Row 2 -->
                            <div class="col-lg-4 col-md-4 pb-2">
                                <label class="text-muted">Tender Date</label>
                                <div class="fw-600">${tenderMaster.announceDate}</div>
                            </div>

                            <div class="col-lg-4 col-md-4 pb-2">
                                <label class="text-muted">Tender Due Date</label>
                                <div class="fw-600">${tenderMaster.submitLastdate}</div>
                            </div>

                            <div class="col-lg-4 col-md-4 pb-2">
                                <label class="text-muted">Tender Subject Description</label>
                                <div class="fw-600">${tenderMaster.workDesc}</div>
                            </div>

                            <!-- Row 3 -->
                            <div class="col-lg-4 col-md-4 pb-2">
                                <label class="text-muted">Billing Location</label>
                                <div class="fw-600">${tenderMaster.location}</div>
                            </div>
                            <div class="col-lg-8 col-md-4 pb-2">
                                <label class="text-muted">Tender Remark</label>
                                <div class="fw-600">${tenderMaster.tenderRemark}</div>
                            </div>


                        </div>
                    </div>                   

                    <h5 class="fw-600">Tender Contact Person</h5> 
                    <hr>
                    <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                        <div class="row buyer-info">
                            <!-- Created By -->
                            <div class="col-xxl-3 col-lg-3 col-md-3 pb-1">
                                <div class="form-group">
                                    <label>Created By</label>
                                    <p class="fw-600">${tenderMaster.contactPerson}</p>
                                </div>
                            </div>
                            <!-- Contact Number -->
                            <div class="col-xxl-3 col-lg-3 col-md-3 pb-1">
                                <div class="form-group">
                                    <label class="d-block">Contact Number</label>
                                    <a href="tel:${tenderAdminContactNumber}"
                                       class="fw-600 fs-13">${tenderMaster.tenderAdminContactNumber}</a>
                                </div>
                            </div>
                            <!-- End User Name -->
                            <div class="col-xxl-3 col-lg-3 col-md-3 pb-1">
                                <div class="form-group">
                                    <label>End User Name</label>
                                    <p class="fw-600">${tenderMaster.endUserName}</p>
                                </div>
                            </div>
                            <!-- End User Contact No -->
                            <div class="col-xxl-3 col-lg-3 col-md-3 pb-1">
                                <div class="form-group">
                                    <label class="d-block">End User Contact No</label>
                                    <a href="tel:${endUserNumber}"
                                       class="fw-600 fs-13">${tenderMaster.endUserNumber}</a>
                                </div>
                            </div>
                            <!-- Technical Person Contact Name -->
                            <div class="col-xxl-3 col-lg-3 col-md-3 pb-1">
                                <div class="form-group">
                                    <label>Technical Person Contact Name</label>
                                    <p class="fw-600">${tenderMaster.technicalContactName}</p>
                                </div>
                            </div>
                            <!-- Technical Person Contact Number -->
                            <div class="col-xxl-3 col-lg-3 col-md-3 pb-1">
                                <div class="form-group">
                                    <label class="d-block">Technical Person Contact Number</label>
                                    <a href="tel:${technicalContactNo}"
                                       class="fw-600 fs-13">${tenderMaster.technicalContactNo}</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <h5 class="fw-600">Site Address</h5>
                    <hr>
                    <table id="commonNoPageTable3" class="table  table-striped bg-white" style="min-width: 100%" align="Center"  >
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
                        <c:forEach var="multipleAddress" items="${multipleAddress}" varStatus="status">
                            <tr>
                                <td>${status.count}</td>
                                <td>${multipleAddress.address1}</td>
                                <td>${multipleAddress.address2}</td>
                                <td>${multipleAddress.city}</td>
                                <td>${multipleAddress.state}</td>
                                <td>${multipleAddress.pincode}</td>
                                <td>${multipleAddress.remark}</td>
                            </tr>
                        </c:forEach>
                    </table>
                    
                    <c:if test="${doc_cost != '0' && tenderPhase1 == '2'}" >
                        <br>
                        <h5>Tender Fee Detail (Not Refundable)</h5>
                        <hr>
                        <div class="row mb-3">
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">Date :</label>
                                    <input name="fee_date" type="text" class="input-field form_datetime" value="${fee_date}" placeholder="${fee_date}"  maxlength="30" required/>                                                                               
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">Amount :</label>
                                    <input name="fee_amount" class="input-field" value="${doc_cost}"  maxlength="30" readonly="true"/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">Drawee Bank :</label>
                                    <input name="fee_drawee_bank" class="input-field" value="${fee_drawee_bank}"  maxlength="30" required/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">${fee_attach}
                                    <label class="label">Attach Scan Copy Of Fee :</label>
                                    <c:if test="${fee_attach != ''}">
                                        <input type="file" name="fee_attach" class="input-field" />
                                    </c:if>
                                    <c:if test="${fee_attach == ''}">
                                        <input type="file" name="fee_attach" class="input-field" required/>
                                    </c:if>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">Cash/DD/Banker Cheque :</label><br>
                                    <input type="radio" id="cash" name="cash_cheque" value="cash" class="radio-inline mr-3" <c:if test="${cash_cheque != 'cheque'}">checked </c:if> onchange="toggleChequeDiv();"/><label class="label" for="cash">Cash</label><br>
                                    <input type="radio" id="cheque" name="cash_cheque" value="cheque" class="radio-inline mr-3" <c:if test="${cash_cheque == 'cheque'}">checked</c:if> onchange="toggleChequeDiv();"/><label class="label" for="cheque">Cheque</label>                                    
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6" id="chequeChecked">
                                    <div class="form-group">
                                        <label class="label">Receipt/DD/Banker Cheque Number :<span style="color: red;font-size: 12px;">*</span></label>
                                        <input name="fee_cheque_no" value="${fee_cheque_no}" class="input-field"   maxlength="30" required/>
                                </div>
                            </div>
                        </div>

                        <script>
                            function toggleChequeDiv() {
                                var chequeRadio = document.getElementById("cheque");
                                var chequeDiv = document.getElementById("chequeChecked");
                                if (chequeRadio.checked) {
                                    chequeDiv.style.display = "block";
                                } else {
                                    chequeDiv.style.display = "none";
                                }
                            }
                            document.addEventListener("DOMContentLoaded", function () {
                            toggleChequeDiv();
                            });
                        </script>
                    </c:if> 

                    <c:if test="${emd != '0' && tenderPhase1 == '2'}">
                        <br>
                        <h5 class="fw-600">EMD Detail (Refundable)</h5>
                        <hr>
                        <div class="row mb-3">
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">Date :</label>
                                    <input name="emd_date" value="${emd_date}" placeholder="${emd_date}" class="input-field form_datetime" maxlength="30" required/>
                                </div>
                            </div>                                    
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">Amount :</label>
                                    <input name="emd_amount" value="${emd}" class="input-field"   maxlength="30" readonly="true"/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">Drawee Bank :</label>
                                    <input name="emd_drawee_bank" class="input-field" value="${emd_drawee_bank}"  maxlength="30" required/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group"> 
                                    <label class="label">Attach Scan Copy Of EMD :</label>${emd_attach}
                                    <input type="file" name="emd_attach" class="input-field" <c:if test="${emd_attach == ''}">required</c:if>/>                                        
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6">
                                    <div class="form-group">
                                        <label class="label">Receipt/DD/Banker Cheque Number :<span class="text-danger">*</span></label>
                                        <input name="emd_cheque_no" value="${emd_cheque_no}" class="input-field" required/>
                                </div>
                            </div>
                        </div>                                    
                    </c:if> 

                    <script type="text/javascript">
                        $(function () {
                            const input = document.querySelector(".form_datetime");
                            const fp = flatpickr(input, {
                                enableTime: false,
                                dateFormat: "d-m-Y",
                                allowInput: true,
                                defaultDate: new Date(),
                                clickOpens: true,
                                onChange: function(selectedDates, dateStr, instance) {
                                    document.getElementById("selectedDateCell").innerText = dateStr;
                                }
                            });
                            document.getElementById("selectedDateCell").innerText = fp.input.value;
                        });
                    </script> 

                    <br>
                    <h5 class="fw-600">Tender Attachment</h5>
                    <hr>
                    <c:if test="${not empty generalDocs}">
                        <table id="commonDocTable" class="table table-striped bg-white dt-scroll" style="min-width: 100%" align="Center"  >
                            <thead>
                                <tr>
                                    <th data-dt-order="disable" ><h5>Tender Commercial Docs</h5></th>
                            </tr>
                            </thead>

                            <tbody>
                                <c:forEach var="generalDocs" items="${generalDocs}" varStatus="status">
                                    <tr>
                                        <td>
                                            <a class="fw-600 text-break gradient-text"href="tenderMaster.htm?act=downloadTenderFile&amp;fileName=${generalDocs.document}&RefNo=${generalDocs.rfqNo}">${generalDocs.document}</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <c:forEach var="tenderVendorDocs" items="${tenderVendorDocs}" varStatus="status">
                                    <c:if test="${tenderVendorDocs.documentType == '1'}">
                                        <tr>
                                            <td>
                                                <a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=downloadTenderFile&amp;fileName=${tenderVendorDocs.document}&RefNo=${rfqNo}">${tenderVendorDocs.document}</a>
                                            </td>
                                        </tr>
                                    </c:if>
                                </c:forEach>

                            </tbody>

                        </table>                                    
                    </c:if>
                    <br>
                    <table  id="commonDocTable1"class="table  table-striped bg-white dt-scroll" style="min-width: 100%" align="Center"  >
                        <thead>
                            <tr>
                                <th data-dt-order="disable"><h5 >Tender Technical Docs</h5></th>
                        </tr>
                        </thead>

                        <tbody>
                            <c:forEach var="prDoc" items="${prDoc}" varStatus="status">
                                <tr>
                                    <td>
                                        <a class="fw-600 text-break gradient-text" href="prMaster.htm?act=downloadPrFile&amp;fileName=${prDoc.docName}&RefNo=${prDoc.refNo}">${prDoc.docName}</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            <c:forEach var="technicalDocs" items="${technicalDocs}" varStatus="status">
                                <tr>
                                    <td>
                                        <a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=downloadTenderFile&amp;fileName=${technicalDocs.document}&RefNo=${refNo}">${technicalDocs.document}</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            <c:forEach var="tenderVendorDocs" items="${tenderVendorDocs}" varStatus="status">
                                <c:if test="${tenderVendorDocs.documentType == '3'}">
                                    <tr>
                                        <td>
                                            <a class="fw-600 text-break gradient-text"href="tenderMaster.htm?act=downloadTenderFile&amp;fileName=${tenderVendorDocs.document}&RefNo=${refNo}">${tenderVendorDocs.document}</a>
                                        </td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                    </table>
                    <br>
                    <c:choose>
                        <c:when test="${empty vendorTechnicalBidTech1}"></c:when>
                        <c:otherwise>

                            <c:if test="${tenderMaster.type == 'Contract Civil'}">
                                <h5 class="fw-600">Civil Details </h5>
                            </c:if>
                            <c:if test="${tenderMaster.type != 'Contract Civil'}">
                                <c:if test="${tenderMaster.type == 'Service'}">
                                    <h5 class="fw-600">Service Details </h5>
                                </c:if>
                                <c:if test="${tenderMaster.type != 'Service'}">
                                    <h5 class="fw-600">Item Details</h5>
                                </c:if>
                            </c:if>
                            
                            <hr>

                            <table id="commonNoPageTable4"class="table table-striped bg-white" style="width: 100%;" align="center">   
                                <thead>
                                    <tr>
                                        <th>Sr No.</th>
                                        <th style="min-width: 190px;">Item Code</th>
                                        <th style="min-width: 530px">Item Details</th>
                                        <th style="min-width: 230px;">Purpose</th>
                                        <th style="min-width: 230px;">Make</th>
                                        <th>UOM</th>
                                        <th>Quantity</th>
                                        <th data-dt-order="disable">Yes</th>
                                        <th data-dt-order="disable">No</th>
                                        <th data-dt-order="disable" style="min-width: 230px;">Vendor Remark</th>
                                        <th style="min-width: 230px;">Technical Committee Member Response</th>
                                        <th style="min-width: 230px;">Technical Committee Member Remark</th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <c:choose>
                                        <c:when test="${!empty vendorTechnicalBidTech}">

                                            <c:forEach var="vendorTechnicalBidTech1" items="${vendorTechnicalBidTech1}" varStatus="status">
                                                <c:set var="vendorResponse" value="2"/>
                                                <c:set var="remark" value=""/>
                                                <c:set var="buyerResponse" value="0"/>
                                                <c:set var="buyerremark" value=""/>
                                                <c:set var="i" value="0"/>
                                                <c:forEach var="vendorTechnicalBidTech" items="${vendorTechnicalBidTech}" varStatus="status1">
                                                    <c:if test="${vendorTechnicalBidTech.srNo == vendorTechnicalBidTech1.srNo && vendorTechnicalBidTech.itemCode == vendorTechnicalBidTech1.itemCode && vendorTechnicalBidTech.uom == vendorTechnicalBidTech1.uom && vendorTechnicalBidTech.qty == vendorTechnicalBidTech1.qty}">
                                                        <c:set var="vendorResponse" value="${vendorTechnicalBidTech.vendorResponse}"/>
                                                        <c:set var="remark" value="${vendorTechnicalBidTech.remark}"/>
                                                        <c:set var="buyerResponse" value="${vendorTechnicalBidTech.buyerResponse}"/>
                                                        <c:set var="buyerremark" value="${vendorTechnicalBidTech.buyerRemark}"/>
                                                        <c:set var="i" value="1"/>
                                                    </c:if>
                                                </c:forEach>
                                                <tr>
                                                    <c:if test="${i == 0}">
                                                        <td style="background-color: lightblue;">
                                                        </c:if>
                                                        <c:if test="${i == 1}">
                                                        <td>
                                                        </c:if>
                                                        ${vendorTechnicalBidTech1.srNo}</td>
                                                        <c:if test="${i == 0}">
                                                        <td style="background-color: lightblue;">
                                                        </c:if>
                                                        <c:if test="${i == 1}">
                                                        <td>
                                                        </c:if>${vendorTechnicalBidTech1.itemCode}</td>
                                                        <c:if test="${i == 0}">
                                                        <td style="background-color: lightblue;">
                                                        </c:if>
                                                        <c:if test="${i == 1}">
                                                        <td>
                                                        </c:if>${vendorTechnicalBidTech1.itemDescription}</td>
                                                        <c:if test="${i == 0}">
                                                        <td style="background-color: lightblue;">
                                                        </c:if>
                                                        <c:if test="${i == 1}">
                                                        <td>
                                                        </c:if>${vendorTechnicalBidTech1.deliveryScheduleQty}</td>
                                                        <c:if test="${i == 0}">
                                                        <td style="background-color: lightblue;">
                                                        </c:if>
                                                        <c:if test="${i == 1}">
                                                        <td>
                                                        </c:if>${vendorTechnicalBidTech1.deliveryScheduleDate}</td>
                                                        <c:if test="${i == 0}">
                                                        <td style="background-color: lightblue;">
                                                        </c:if>
                                                        <c:if test="${i == 1}">
                                                        <td>
                                                        </c:if>${vendorTechnicalBidTech1.uom}</td>
                                                        <c:if test="${i == 0}">
                                                        <td style="background-color: lightblue;">
                                                        </c:if>
                                                        <c:if test="${i == 1}">
                                                        <td>
                                                        </c:if>${vendorTechnicalBidTech1.qty}</td>



                                                    <c:if test="${i == 0}">
                                                        <td style="background-color: lightblue;">
                                                        </c:if>
                                                        <c:if test="${i == 1}">
                                                        <td>
                                                        </c:if>

                                                        <c:if test="${vendorResponse == 0}">
                                                            <input type="radio" name="techradion${status.count}" id="1techradion${status.count}" value="0" checked  /> 
                                                        </c:if>
                                                        <c:if test="${vendorResponse != 0}">
                                                            <input type="radio" name="techradion${status.count}" id="1techradion${status.count}" value="0"  /> 
                                                        </c:if>
                                                    </td>
                                                    <c:if test="${i == 0}">
                                                        <td style="background-color: lightblue;">
                                                        </c:if>
                                                        <c:if test="${i == 1}">
                                                        <td>
                                                        </c:if>
                                                        <c:if test="${vendorResponse == 1}">
                                                            <input type="radio" name="techradion${status.count}" id="2techradion${status.count}" value="1" checked  /> 
                                                        </c:if>
                                                        <c:if test="${vendorResponse != 1}">
                                                            <input type="radio" name="techradion${status.count}" id="2techradion${status.count}" value="1"  /> 
                                                        </c:if>
                                                    </td>

                                                    <c:if test="${i == 0}">
                                                        <td style="background-color: lightblue;">
                                                        </c:if>
                                                        <c:if test="${i == 1}">
                                                        <td>
                                                        </c:if>
                                                        <div class="col-12 p-0">
                                                            <div class="form-group comment-box">
                                                                <textarea type="text" maxlength="250" class="textarea-field comment" id="tech_vendor_remark${status.count}" name="tech_vendor_remark${status.count}" >${remark}</textarea>
                                                            </div>
                                                        </div>                                                        

                                                        <small id="charCount_tech_vendor_remark${status.count}" style="font-size: 12px; color: green;">
                                                            250 characters remaining
                                                        </small>

                                                        <script>
                                                                    document.addEventListener("DOMContentLoaded", function () {
                                                                    var textarea = document.getElementById("tech_vendor_remark${status.count}");
                                                                            var counter = document.getElementById("charCount_tech_vendor_remark${status.count}");
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

                                                                    updateCounter();
                                                                            textarea.addEventListener("input", updateCounter);
                                                                    });</script>
                                                    </td>
                                                    <c:if test="${i == 0}">
                                                        <td style="background-color: lightblue;">
                                                        </c:if>
                                                        <c:if test="${i == 1}">
                                                        <td>
                                                        </c:if>
                                                        <c:if test="${buyerResponse == '1'}">
                                                            Accept
                                                        </c:if>
                                                        <c:if test="${buyerResponse == '2'}">
                                                            Not Accept
                                                        </c:if>    
                                                    </td>
                                                    <c:if test="${i == 0}">
                                                        <td style="background-color: lightblue;">
                                                        </c:if>
                                                        <c:if test="${i == 1}">
                                                        <td>
                                                        </c:if>${buyerremark}</td>
                                            <input type="hidden" name="vendor_tech_desc" id="vendor_tech_desc" value="${vendorTechnicalBidTech1.itemDescription}" class="form-control" />
                                            <input type="hidden" name="vendor_tech_remark" id="vendor_tech_remark" value="${vendorTechnicalBidTech1.remark}" class="form-control" />
                                            <input type="hidden" name="vendor_tech_comp" id="vendor_tech_comp" value="${vendorTechnicalBidTech1.uom}" class="form-control" >
                                            <input type="hidden" name="1vendor_tech_comp${status.count}" id="1vendor_tech_comp${status.count}" value="${vendorTechnicalBidTech1.uom}" class="form-control" >
                                            <input type="hidden" name="vendor_tech_attach${status.count}" id="vendor_tech_attach${status.count}" value="" class="form-control" >
                                            <input type="hidden" name="tech_sr_no" id="vendor_terms_desc" value="${vendorTechnicalBidTech1.srNo}" class="form-control" />
                                            <input type="hidden" name="tech_item_code" id="vendor_terms_desc" value="${vendorTechnicalBidTech1.itemCode}" class="form-control" />
                                            <input type="hidden" name="tech_uom" id="vendor_terms_desc" value="${vendorTechnicalBidTech1.uom}" class="form-control" />
                                            <input type="hidden" name="tech_qty" id="vendor_terms_desc" value="${vendorTechnicalBidTech1.qty}" class="form-control" />
                                            <input type="hidden" name="buyer_tech_response" id="vendor_terms_desc" value="${buyerResponse}" class="form-control" />
                                            <input type="hidden" name="buyer_tech_remark" id="vendor_terms_desc" value="${buyerremark}" class="form-control" />
                                            </td>
                                            </tr>
                                        </c:forEach>
                                    </c:when>

                                    <c:otherwise>
                                        <c:forEach var="vendorTechnicalBidTech" items="${vendorTechnicalBidTech}" varStatus="status">
                                            <tr>
                                                <td>${vendorTechnicalBidTech.srNo}</td>
                                                <td>${vendorTechnicalBidTech.itemCode}</td>
                                                <td>${vendorTechnicalBidTech.description}</td>
                                                <td>${vendorTechnicalBidTech.remark} </td>
                                                <td>${vendorTechnicalBidTech.uom} </td>
                                                <td>${vendorTechnicalBidTech.qty} </td>

                                                <td>
                                                    <c:if test="${vendorTechnicalBidTech.vendorResponse == 0}">
                                                        <input type="radio" name="techradion${status.count}" id="1techradion${status.count}" value="0" checked  /> 
                                                    </c:if>
                                                    <c:if test="${vendorTechnicalBidTech.vendorResponse != 0}">
                                                        <input type="radio" name="techradion${status.count}" id="1techradion${status.count}" value="0"  /> 
                                                    </c:if>
                                                </td>
                                                <td>
                                                    <c:if test="${vendorTechnicalBidTech.vendorResponse == 1}">
                                                        <input type="radio" name="techradion${status.count}" id="2techradion${status.count}" value="1" checked  /> 
                                                    </c:if>
                                                    <c:if test="${vendorTechnicalBidTech.vendorResponse != 1}">
                                                        <input type="radio" name="techradion${status.count}" id="2techradion${status.count}" value="1"  /> 
                                                    </c:if>
                                                </td>

                                                <td>
                                                    <input type="hidden" name="vendor_tech_desc" id="vendor_tech_desc" value="${vendorTechnicalBidTech.description}" class="form-control" />
                                                    <input type="hidden" name="vendor_tech_remark" id="vendor_tech_remark" value="${vendorTechnicalBidTech.details}" class="form-control" />
                                                    <input type="hidden" name="vendor_tech_comp" id="vendor_tech_comp" value="${vendorTechnicalBidTech.attachmentRequired}" class="form-control" >
                                                    <input type="hidden" name="1vendor_tech_comp${status.count}" id="1vendor_tech_comp${status.count}" value="${vendorTechnicalBidTech.attachmentRequired}" class="form-control" >
                                                    <!--<input type="text" name="tech_vendor_remark${status.count}" id="tech_vendor_remark${status.count}" value="${vendorTechnicalBidTech.remark}"  class="form-control" >-->    
                                                    <!--                                                    <textarea 
                                                                                                            name="tech_vendor_remark${status.count}" 
                                                                                                            id="tech_vendor_remark${status.count}" 
                                                                                                            class="form-control" 
                                                                                                            maxlength="250"
                                                                                                            >${vendorTechnicalBidTech.remark}</textarea>-->
                                                    <div class="col-12 p-0">
                                                        <div class="form-group comment-box">
                                                            <textarea type="text" maxlength="250" class="textarea-field comment" id="tech_vendor_remark${status.count}" name="tech_vendor_remark${status.count}" >${remark}</textarea>
                                                        </div>
                                                    </div>


                                                    <small id="charCount_tech_vendor_remark${status.count}" style="font-size: 12px; color: green;">
                                                        250 characters remaining
                                                    </small>

                                                    <script>
                                                                document.addEventListener("DOMContentLoaded", function () {
                                                                var textarea = document.getElementById("tech_vendor_remark${status.count}");
                                                                        var counter = document.getElementById("charCount_tech_vendor_remark${status.count}");
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

                                                                updateCounter();
                                                                        textarea.addEventListener("input", updateCounter);
                                                                });
                                                </script>
                                                    <input type="hidden" name="tech_sr_no" id="vendor_terms_desc" value="${vendorTechnicalBidTech.srNo}" class="form-control" />
                                                    <input type="hidden" name="tech_item_code" id="vendor_terms_desc" value="${vendorTechnicalBidTech.itemCode}" class="form-control" />
                                                    <input type="hidden" name="tech_uom" id="vendor_terms_desc" value="${vendorTechnicalBidTech.uom}" class="form-control" />
                                                    <input type="hidden" name="tech_qty" id="vendor_terms_desc" value="${vendorTechnicalBidTech.qty}" class="form-control" />
                                            </tr>
                                        </c:forEach>       
                                    </c:otherwise>
                                </c:choose>
                                </tbody>
                            </table>
                        </c:otherwise>
                    </c:choose>

                    <c:choose>
                        <c:when test="${empty vendorTechnicalBidTerms1}"></c:when>
                        <c:otherwise>

                            <c:if test="${tenderMaster.type == 'Contract' || tenderMaster.type == 'Contract Civil' || tenderMaster.type == 'Contract Electrical'}">

                                <c:if test="${tenderMaster.type == 'Contract Civil'}">
                                    <h5 class="fw-600">Steel Details</h5>
                                </c:if>
                                <c:if test="${tenderMaster.type != 'Contract Civil'}"> 
                                    <h5 class="fw-600">Item Details For Service</h5> 
                                </c:if>
                            </c:if>
                            <hr>

                            <table id="commonNoPageTable5" class="table table-striped bg-white" style="min-width: 100%" align="Center"  >
                                <thead>
                                    <tr>
                                        <th>Sr No.</th>
                                        <th style="min-width: 190px;">Item Code</th>
                                        <th style="min-width: 530px">Item Details</th>
                                        <th style="min-width: 230px;">Purpose</th>
                                        <th style="min-width: 230px;">Make</th>
                                        <th>UOM</th>
                                        <th>Quantity</th>
                                        <th data-dt-order="disable">Yes</th>
                                        <th data-dt-order="disable">No</th>
                                        <th data-dt-order="disable" style="min-width: 230px;">Vendor Remark</th>
                                        <th style="min-width: 230px;">Technical Committee Member Response</th>
                                        <th style="min-width: 230px;">Technical Committee Member Remark</th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <c:choose>
                                        <c:when test="${!empty vendorTechnicalBidTerms}">
                                            <c:forEach var="vendorTechnicalBidTerms1" items="${vendorTechnicalBidTerms1}" varStatus="status">
                                                <tr>
                                                    <c:set var="vendorResponse" value="2"/>
                                                    <c:set var="remark" value=""/>
                                                    <c:set var="buyerResponse" value="0"/>
                                                    <c:set var="buyerremark" value=""/>
                                                    <c:set var="i" value="0"/>
                                                    <c:forEach var="vendorTechnicalBidTerms" items="${vendorTechnicalBidTerms}" varStatus="status1">
                                                        <c:if test="${vendorTechnicalBidTerms.srNo == vendorTechnicalBidTerms1.srNo && vendorTechnicalBidTerms.itemCode == vendorTechnicalBidTerms1.itemCode && vendorTechnicalBidTerms.uom == vendorTechnicalBidTerms1.uom && vendorTechnicalBidTerms.qty == vendorTechnicalBidTerms1.qty}">
                                                            <c:set var="vendorResponse" value="${vendorTechnicalBidTerms.vendorResponse}"/>
                                                            <c:set var="remark" value="${vendorTechnicalBidTerms.remark}"/>
                                                            <c:set var="buyerResponse" value="${vendorTechnicalBidTerms.buyerResponse}"/>
                                                            <c:set var="buyerremark" value="${vendorTechnicalBidTerms.buyerRemark}"/>
                                                            <c:set var="i" value="1"/>
                                                        </c:if>
                                                    </c:forEach>

                                                    <c:if test="${i == 0}">
                                                        <td style="background-color: lightblue;">
                                                        </c:if>
                                                        <c:if test="${i == 1}">
                                                        <td>
                                                        </c:if>${vendorTechnicalBidTerms1.srNo}</td>
                                                        <c:if test="${i == 0}">
                                                        <td style="background-color: lightblue;">
                                                        </c:if>
                                                        <c:if test="${i == 1}">
                                                        <td>
                                                        </c:if>${vendorTechnicalBidTerms1.itemCode}</td>
                                                        <c:if test="${i == 0}">
                                                        <td style="background-color: lightblue;">
                                                        </c:if>
                                                        <c:if test="${i == 1}">
                                                        <td>
                                                        </c:if>${vendorTechnicalBidTerms1.itemDescription}</td>
                                                        <c:if test="${i == 0}">
                                                        <td style="background-color: lightblue;">
                                                        </c:if>
                                                        <c:if test="${i == 1}">
                                                        <td>
                                                        </c:if>${vendorTechnicalBidTerms1.deliveryScheduleQty} </td>
                                                        <c:if test="${i == 0}">
                                                        <td style="background-color: lightblue;">
                                                        </c:if>
                                                        <c:if test="${i == 1}">
                                                        <td>
                                                        </c:if>${vendorTechnicalBidTerms1.deliveryScheduleDate} </td>
                                                        <c:if test="${i == 0}">
                                                        <td style="background-color: lightblue;">
                                                        </c:if>
                                                        <c:if test="${i == 1}">
                                                        <td>
                                                        </c:if>${vendorTechnicalBidTerms1.uom} </td>
                                                        <c:if test="${i == 0}">
                                                        <td style="background-color: lightblue;">
                                                        </c:if>
                                                        <c:if test="${i == 1}">
                                                        <td>
                                                        </c:if>${vendorTechnicalBidTerms1.qty} </td>

                                                    <c:if test="${i == 0}">
                                                        <td style="background-color: lightblue;">
                                                        </c:if>
                                                        <c:if test="${i == 1}">
                                                        <td>
                                                        </c:if>
                                                        <c:if test="${vendorResponse == 0}">
                                                            <input type="radio" name="termsradion${status.count}" id="1termsradion${status.count}" value="0" checked  /> 
                                                        </c:if>
                                                        <c:if test="${vendorResponse != 0}">
                                                            <input type="radio" name="termsradion${status.count}" id="1termsradion${status.count}" value="0"  /> 
                                                        </c:if>
                                                    </td>
                                                    <c:if test="${i == 0}">
                                                        <td style="background-color: lightblue;">
                                                        </c:if>
                                                        <c:if test="${i == 1}">
                                                        <td>
                                                        </c:if>
                                                        <c:if test="${vendorResponse == 1}">
                                                            <input type="radio" name="termsradion${status.count}" id="2termsradion${status.count}" value="1" checked  /> 
                                                        </c:if>
                                                        <c:if test="${vendorResponse != 1}">
                                                            <input type="radio" name="termsradion${status.count}" id="2termsradion${status.count}" value="1"  /> 
                                                        </c:if>
                                                    </td>
                                                    <c:if test="${i == 0}">
                                                        <td style="background-color: lightblue;">
                                                        </c:if>
                                                        <c:if test="${i == 1}">
                                                        <td>
                                                        </c:if>
                                                        <input type="hidden" name="vendor_terms_desc" id="vendor_terms_desc" value="${vendorTechnicalBidTerms1.itemDescription}" class="form-control" />
                                                        <input type="hidden" name="vendor_terms_remark" id="vendor_terms_remark" value="${vendorTechnicalBidTerms1.remark}" class="form-control" />
                                                        <input type="hidden" name="vendor_terms_comp" id="vendor_terms_comp" value="${vendorTechnicalBidTerms1.uom}" class="form-control" >
                                                        <input type="hidden" name="1vendor_terms_comp${status.count}" id="1vendor_terms_comp${status.count}" value="${vendorTechnicalBidTerms1.uom}" class="form-control" >
                                                        <textarea type="text" name="terms_vendor_remark${status.count}" id="terms_vendor_remark${status.count}" maxlength="250"  class="textarea-field" >${remark}</textarea>    
                                                        <small id="charCount_terms_vendor_remark${status.count}" style="font-size: 12px; color: green;">
                                                            250 characters remaining
                                                        </small>
                                                        <script>
                                                                    document.addEventListener("DOMContentLoaded", function () {
                                                                    var textarea = document.getElementById("terms_vendor_remark${status.count}");
                                                                            var counter = document.getElementById("charCount_terms_vendor_remark${status.count}");
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

                                                                    updateCounter();
                                                                            textarea.addEventListener("input", updateCounter);
                                                                    });
                                                                                                                                        </script>

                                                        <input type="hidden" name="terms_sr_no" id="vendor_terms_desc" value="${vendorTechnicalBidTerms1.srNo}" class="form-control" />
                                                        <input type="hidden" name="terms_item_code" id="vendor_terms_desc" value="${vendorTechnicalBidTerms1.itemCode}" class="form-control" />
                                                        <input type="hidden" name="terms_uom" id="vendor_terms_desc" value="${vendorTechnicalBidTerms1.uom}" class="form-control" />
                                                        <input type="hidden" name="terms_qty" id="vendor_terms_desc" value="${vendorTechnicalBidTerms1.qty}" class="form-control" />
                                                        <input type="hidden" name="buyer_terms_response" id="vendor_terms_desc" value="${buyerResponse}" class="form-control" />
                                                        <input type="hidden" name="buyer_terms_remark" id="vendor_terms_desc" value="${buyerremark}" class="form-control" />
                                                    </td>

                                                    <c:if test="${i == 0}">
                                                        <td style="background-color: lightblue;">
                                                        </c:if>
                                                        <c:if test="${i == 1}">
                                                        <td>
                                                        </c:if>
                                                        <c:if test="${buyerResponse == '1'}">
                                                            Accept
                                                        </c:if>
                                                        <c:if test="${buyerResponse == '2'}">
                                                            Not Accept
                                                        </c:if>    
                                                    </td>
                                                    <c:if test="${i == 0}">
                                                        <td style="background-color: lightblue;">
                                                        </c:if>
                                                        <c:if test="${i == 1}">
                                                        <td>
                                                        </c:if>${buyerremark}</td>
                                                </tr>
                                            </c:forEach>
                                        </c:when>
                                        <c:otherwise>
                                            <c:forEach var="vendorTechnicalBidTerms" items="${vendorTechnicalBidTerms}" varStatus="status">
                                                <tr>
                                                    <td>${vendorTechnicalBidTerms.srNo}</td>
                                                    <td>${vendorTechnicalBidTerms.itemCode}</td>
                                                    <td>${vendorTechnicalBidTerms.description}</td>
                                                    <td>${vendorTechnicalBidTerms.details} </td>
                                                    <td>${vendorTechnicalBidTerms.uom} </td>
                                                    <td>${vendorTechnicalBidTerms.qty} </td>
                                                    <td>
                                                        <c:if test="${vendorTechnicalBidTerms.vendorResponse == 0}">
                                                            <input type="radio" name="termsradion${status.count}" id="1termsradion${status.count}" value="0" checked  /> 
                                                        </c:if>
                                                        <c:if test="${vendorTechnicalBidTerms.vendorResponse != 0}">
                                                            <input type="radio" name="termsradion${status.count}" id="1termsradion${status.count}" value="0"  /> 
                                                        </c:if>
                                                    </td>
                                                    <td>   
                                                        <c:if test="${vendorTechnicalBidTerms.vendorResponse == 1}">
                                                            <input type="radio" name="termsradion${status.count}" id="2termsradion${status.count}" value="1" checked  /> 
                                                        </c:if>
                                                        <c:if test="${vendorTechnicalBidTerms.vendorResponse != 1}">
                                                            <input type="radio" name="termsradion${status.count}" id="2termsradion${status.count}" value="1"  /> 
                                                        </c:if>
                                                    </td>

                                                    <td>
                                                        <input type="hidden" name="vendor_terms_desc" id="vendor_terms_desc" value="${vendorTechnicalBidTerms.description}" class="form-control" />
                                                        <input type="hidden" name="vendor_terms_remark" id="vendor_terms_remark" value="${vendorTechnicalBidTerms.details}" class="form-control" />
                                                        <input type="hidden" name="vendor_terms_comp" id="vendor_terms_comp" value="${vendorTechnicalBidTerms.attachmentRequired}" class="form-control" >
                                                        <input type="hidden" name="1vendor_terms_comp${status.count}" id="1vendor_terms_comp${status.count}" value="${vendorTechnicalBidTerms.attachmentRequired}" class="form-control" >
                                                        <textarea type="text" name="terms_vendor_remark${status.count}" id="terms_vendor_remark${status.count}" maxlength="250" class="form-control" >${vendorTechnicalBidTerms.remark}</textarea>
                                                        <small id="charCount_terms_vendor_remark${status.count}" style="font-size: 12px; color: green;">
                                                            250 characters remaining
                                                        </small>

                                                        <script>
                                                                    document.addEventListener("DOMContentLoaded", function () {
                                                                    var textarea = document.getElementById("terms_vendor_remark${status.count}");
                                                                            var counter = document.getElementById("charCount_terms_vendor_remark${status.count}");
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

                                                                    updateCounter();
                                                                            textarea.addEventListener("input", updateCounter);
                                                                    });</script>

                                                        <input type="hidden" name="terms_sr_no" id="vendor_terms_desc" value="${vendorTechnicalBidTerms.srNo}" class="form-control" />
                                                        <input type="hidden" name="terms_item_code" id="vendor_terms_desc" value="${vendorTechnicalBidTerms.itemCode}" class="form-control" />
                                                        <input type="hidden" name="terms_uom" id="vendor_terms_desc" value="${vendorTechnicalBidTerms.uom}" class="form-control" />
                                                        <input type="hidden" name="terms_qty" id="vendor_terms_desc" value="${vendorTechnicalBidTerms.qty}" class="form-control" />
                                                    </td>
                                                </tr>
                                            </c:forEach>       
                                        </c:otherwise>
                                    </c:choose>
                                </tbody>
                            </table>
                        </c:otherwise>
                    </c:choose>
                    <br>
                    <div class="form-group">
                        <div class="content-top mb-3 d-flex align-items-center justify-content-between">
                            <div class="d-flex align-items-center">
                                <h5 class="fw-600 mr-4">Add Attachment By Vendor</h5>
                                <span id="requireDocument3">${vendorAttachment.size()}</span>
                            </div>
                            <button type="button" class="btn theme-btn d-flex align-items-center" data-toggle="modal"
                                    data-target="#generalTermsUpload" onclick="requestDocTechTab();">
                                <img src="StorageYard/assets/images/attachment.svg" class="attachment mr-1 d-inline"
                                     onload="SVGInject(this)" alt="User Image">
                                Attachment
                            </button>
                        </div>
                    </div>
                    <br>

                    <h5 class="fw-600">Attachment Of Vendor</h5>

                    <table id="commonNoPageTable2" class="table   table-striped  bg-white" style="min-width: 100%" align="Center"  >
                        <thead>
                            <tr>
                                <th>Sr No.</th>
                                <th>Document Specification</th>
                                <th style="min-width: 170px;">Document</th>
                                <th data-dt-order="disable">Yes</th>
                                <th data-dt-order="disable">No</th>
                                <th data-dt-order="disable" style="min-width: 190px;">Vender Remark</th>
                                <th data-dt-order="disable" style="min-width: 190px;">Attachment</th>
                                <th data-dt-order="disable" style="min-width: 190px;">Technical Committee Response </th>
                                <th data-dt-order="disable" style="min-width: 190px;">Technical Committee remark</th>
                        </tr>
                        </thead>
                        <tbody>

                            <c:forEach var="vendorTechnicalBidAttachment" items="${vendorTechnicalBidAttachment}" varStatus="status">
                                <tr>
                            <input type="hidden" id="ids${status.count}" name="ids" value="${vendorTechnicalBidAttachment.id}">

                            <td>${status.count}</td>
                            <td>${vendorTechnicalBidAttachment.description}</td>
                            <td><a style="cursor: pointer;" class="fw-600 text-break gradient-text" href="vendor.htm?act=downloadVenderAttachFile&amp;fileName=${vendorTechnicalBidAttachment.document}&RefNo=${vendorTechnicalBidAttachment.refNo}">${vendorTechnicalBidAttachment.document}</a></td>

                            <td  style="text-align: center">
                                <c:if test="${vendorTechnicalBidAttachment.venderResponse == 0}">
                                    <input type="radio" name="documentYes${status.count}" id="yes${status.count}" value="0"  checked/>
                                </c:if>
                                <c:if test="${vendorTechnicalBidAttachment.venderResponse != 0}">
                                    <input type="radio" name="documentYes${status.count}" id="yes${status.count}" value="0"  />
                                </c:if>
                            </td>

                            <td  style="text-align: center">
                                <c:if test="${vendorTechnicalBidAttachment.venderResponse == 1}">
                                    <input type="radio" name="documentYes${status.count}" id="no${status.count}" value="1"  checked/>
                                </c:if>
                                <c:if test="${vendorTechnicalBidAttachment.venderResponse != 1}">
                                    <input type="radio" name="documentYes${status.count}" id="no${status.count}" value="1"  />
                                </c:if>
                            </td>
                            <td> 
                                <textarea type="text" maxlength="250" class="textarea-field comment" id="remarks${status.count}" name="remarks"   >${vendorTechnicalBidAttachment.remark}</textarea>
                                <small id="charCount_remarks${status.count}" style="font-size: 12px; color: green;">
                                    250 characters remaining
                                </small>

                                <script>
                                            document.addEventListener("DOMContentLoaded", function () {
                                            var textarea = document.getElementById("remarks${status.count}");
                                                    var counter = document.getElementById("charCount_remarks${status.count}");
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

                                            updateCounter();
                                                    textarea.addEventListener("input", updateCounter);
                                            });</script>
                            </td>
                            <td>
                                <a class="fw-600 text-break gradient-text" href="vendor.htm?act=downloadVenderAttachFile&amp;fileName=${vendorTechnicalBidAttachment.attachment}&RefNo=${vendorTechnicalBidAttachment.refNo}">${vendorTechnicalBidAttachment.attachment}</a>
                                <input type="hidden" name="tech_attachment_desc" id="tech_attachment_desc" value="${vendorTechnicalBidAttachment.description}" class="form-control" />
                                <input type="hidden" name="tech_attachment_comp" id="tech_attachment_comp" value="${vendorPreBidAttachment.attachmentRequired}" class="form-control" />

                                <c:if test="${vendorTechnicalBidAttachment.attachment != ''}">
                                    <input type="file" name="tech_attachment${status.count}" id="tech_attachment${status.count}" class="input-field" />
                                </c:if>
                            </td>

                            <td style="text-align: center">
                                <input type="hidden" name="buyerAccept${status.count}" value="${vendorTechnicalBidAttachment.buyerResponse}">
                                <c:choose>
                                    <c:when test="${vendorTechnicalBidAttachment.buyerResponse == 1}">
                                        Accept
                                    </c:when>
                                    <c:when test="${vendorTechnicalBidAttachment.buyerResponse == 2}">
                                        Not Accept
                                    </c:when>
                                </c:choose>
                            </td>
                            

                            <td>
                                <input type="hidden" class="input-field" id="remark1${status.count}" name="remark1" value="${vendorTechnicalBidAttachment.buyerRemark}"/>
                                ${vendorTechnicalBidAttachment.buyerRemark}
                            </td>   

                            </tr>
                        </c:forEach>       

                        </tbody>

                    </table>

                    <br>
                    <div class="form-group">
                            <div class="content-top mb-3 d-flex align-items-center justify-content-between">
                                <div class="d-flex align-items-center">
                                    <h5 class="fw-600"> Tender Technical Document </h5>
                                </div>
                            </div>
                            <hr>
                            <div id="showtext7"></div>

                        </div>
                        <script type="text/javascript">
                            var str7 = document.getElementById("refNo").value;
                            function showuser7(str) {
                                str = document.getElementById("refNo").value;
                                str7 = str;
                                var xreq, ID;
                                if (str == "") {
                                    document.getElementById("showtext7").innerHTML = "";
                                    return;
                                }
                                if (window.XMLHttpRequest) {
                                    xreq = new XMLHttpRequest();
                                } else {
                                    xreq = new ActiveXObject("Microsoft.XMLHTTP");
                                }
                                xreq.onreadystatechange = function () {
                                    if ((xreq.readyState == 4) && (xreq.status == 200)) {
                                        document.getElementById("showtext7").innerHTML = xreq.responseText;
                                        if ($('#tenderTechnicalTable').length) {
                                            const table1 = initTable('#tenderTechnicalTable');
                                        }
                                    }
                                }
                                xreq.open("Get", "tenderMaster.htm?act=agaxTechnicalFileDetails&vendorCode=${vendorCode}&q=" + str7, true);
                                xreq.send();
                                window.clearInterval(ID);
                            }
                            var ID = window.setInterval(function () {
                                showuser7(str7);
                            }, 1000);
                        </script>
                    
                                                
                    <div class="col-12 p-0">
                        <div class="form-group comment-box">
                            <label class="label">Technical Remark :</label>
                            <textarea type="text" maxlength="250" class="textarea-field comment" id="technicalRemark" name="technicalRemark"  readonly>${technicalBidRemark}</textarea>
                        </div>
                    </div>
                    
                       

                    <h5 class="fw-600">Vendor Remark For Technical Bid</h5>

                    <div class="col-12 p-0">
                        <div class="form-group comment-box">
                            <label class="control-label">Technical Bid Deviation :<span class="text-danger">*</span></label>
                            <textarea  name="technicalBidDeviation" type="text" maxlength="250" class="textarea-field comment" id="technicalBidDeviation"   required="true">${technicalBidDeviation}</textarea>
                            <small id="charCount_technicalBidDeviation" style="font-size: 12px; color: green;">
                                250 characters remaining
                            </small>
                        </div>
                    </div>  
                    <div class="col-12 p-0">
                        <div class="form-group comment-box">
                            <label class="control-label">Technical Bid Remark :<span class="text-danger">*</span></label>
                            <textarea  name="technicalBidRemark" type="text" maxlength="250" class="textarea-field comment" id="technicalBidRemark"   required="true">${technicalBidRemark}</textarea>
                            <small id="charCount_technicalBidRemark" style="font-size: 12px; color: green;">
                                250 characters remaining
                            </small>
                        </div>
                    </div>  



                    <script type="text/javascript">
                                document.addEventListener("DOMContentLoaded", function () {
                                var textarea = document.getElementById("technicalBidDeviation");
                                        var counter = document.getElementById("charCount_technicalBidDeviation");
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

                                updateCounter(); // run initially for pre-filled value
                                        textarea.addEventListener("input", updateCounter);
                                });</script>




                    <script type="text/javascript">
                                document.addEventListener("DOMContentLoaded", function () {
                                var textarea = document.getElementById("technicalBidRemark");
                                        var counter = document.getElementById("charCount_technicalBidRemark");
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

                                updateCounter(); // for pre-filled text
                                        textarea.addEventListener("input", updateCounter);
                                });</script>
                    <div class="form-group">
                        <div style="display: flex;  justify-content: center;">
                            <button type="submit" class="btn theme-btn"  value="SUBMIT">Submit</button>
                        </div>
                    </div>
                </form:form>
                <form:form id="myForm" enctype="multipart/form-data" commandName="tenderMaster" name="form"
                           class="form-horizontal" role="form">
                    <input type="hidden" name="refNo" id="refNo" value="${refNo}">
                    <input type="hidden" name="vendor_code" id="vendor_code" value="${vendor_code}">

                    <div class="modal fade" id="generalTermsUpload" data-backdrop="static" data-keyboard="false"
                         tabindex="-1" aria-labelledby="generalTermsUploadLabel" aria-hidden="true">
                        <div class="modal-dialog modal-sm">
                            <div class="modal-content">

                                <div class="modal-header align-items-center">
                                    <h5 class="modal-title" id="generalTermsUploadLabel">Attach Document
                                    </h5>
                                    <div class="cta-btn d-flex align-items-center">
                                        <button type="button" class="btn theme-btn light-btn"
                                                data-dismiss="modal">Close</button>
                                        <button type="button" class="btn theme-btn ml-3"
                                                id="uploadSubmitBtn">Submit</button>
                                    </div>
                                </div>

                                <div class="modal-body">


                                    <table id="commonDocTable3" class="table table-striped bg-white dt-scroll" style="min-width: 100%" align="center">
                                        <thead>
                                            <tr>
                                                <th>Vendor Attachment</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>
                                                    <div class="col-md-12">
                                                        <input type="file" name="generalfile1" id="generalfile" class="input-field py-2 fs-12i">
                                                    </div>
                                                </td>

                                            </tr>
                                        </tbody>
                                    </table>
                                    <div id="AjaxTechDiv" class="p-1"></div>    
                                </div>
                            </div>
                        </div>


                        <script type="text/javascript">

                                    const bootoast = window.Bootoast;
                                    document.getElementById('uploadSubmitBtn').addEventListener('click', function () {
                            const fileInput = document.getElementById("generalfile");
                                    const refNoValue = document.getElementById('refNo')?.value;
                                    const vendor_code = document.getElementById('vendor_code')?.value;
                                    if (!fileInput || fileInput.files.length === 0) {

                            Swal.fire({
                            icon: 'warning',
                                    title: 'Please select a file to upload.',
                                    timer: 3000,
                                    showConfirmButton: false,
                                    position: 'top'
                            });
                                    return;
                            }

                            var form = document.getElementById('myForm');
                                    var formData = new FormData(form);
                                    formData.append('generalfile', fileInput.files[0]);
                                    formData.append('policyCount', 1);
                                    const xhr = new XMLHttpRequest();
                                    xhr.open('POST', 'vendor.htm?act=vendorAttachSubmit', true);
                                    xhr.onload = function () {
                                    if (xhr.status === 200) {
                                    const uploadedFileName = fileInput.files[0].name;
                                            Swal.fire({
                                            icon: 'success',
                                                    title: 'Attachment Added Successfully.',
                                                    timer: 3000,
                                                    showConfirmButton: false,
                                                    position: 'top'
                                            });
                                            requestDocTechTab();
                                            fileInput.value = '';
                                    } else {
                                    Swal.fire({
                                    icon: 'error',
                                            title: 'Upload failed: ' + xhr.statusText,
                                            timer: 4000,
                                            showConfirmButton: false,
                                            position: 'top'
                                    });
                                    }
                                    };
                                    xhr.onerror = function () {
                                    console.error('Network error.');
                                            Swal.fire({
                                            icon: 'error',
                                                    title: 'Network error occurred.',
                                                    timer: 4000,
                                                    showConfirmButton: false,
                                                    position: 'top'
                                            });
                                    };
                                    xhr.send(formData);
                                    setupImportTechnicalDocument();
                            });</script> 

                        <script type="text/javascript">

                                    var str7 = document.getElementById("refNo").value;
                                    function requestDocTechTab(str) {

                                    str = document.getElementById("refNo").value;
                                            str7 = str;
                                            var xreq, ID;
                                            if (str == "") {
                                    document.getElementById("AjaxTechDiv").innerHTML = "";
                                            return;
                                    }
                                    if (window.XMLHttpRequest) {
                                    xreq = new XMLHttpRequest();
                                    }
                                    else {
                                    xreq = new ActiveXObject("Microsoft.XMLHTTP");
                                    }
                                    xreq.onreadystatechange = function () {
                                    if ((xreq.readyState == 4) && (xreq.status == 200)) {
                                    document.getElementById("AjaxTechDiv").innerHTML = xreq.responseText;
                                            if ($('#AjaxVendorAttachTab').length) {
                                    const table1 = initDocTable('#AjaxVendorAttachTab');
                                    }

                                    }
                                    }

                                    xreq.open("Get", "vendor.htm?act=vendorAttach&refNo=" + str7, true);
                                            xreq.send();
                                            window.clearInterval(ID);
                                    }

                            var ID = window.setInterval(requestDocTechTab(str7), 1000);</script>
                    </div> 

                     <script>
                            $(document).on('click', '.delete-doc-row', function (e) {
                                e.preventDefault();

                                var $row = $(this).closest('tr');
                                var id = $(this).data('id');

                                var fieldOne = $('#refNo').val();
                                var vendor_code = $('#vendor_code').val();

                                Swal.fire({
                                    title: 'Are you sure you want to delete this?',
                                    text: 'You will not be able to recover this record!',
                                    icon: 'warning',
                                    showCancelButton: true,
                                    confirmButtonText: 'Yes, delete it!',
                                    cancelButtonText: 'No, cancel',
                                    reverseButtons: true,
                                    customClass: {
                                        confirmButton: 'confirm-delete',
                                        cancelButton: 'theme-btn light-btn'
                                    }
                                }).then((result) => {
                                    if (result.isConfirmed) {
                                        $.ajax({
                                            url: 'vendor.htm?act=vendorAttachDelete',
                                            type: 'POST',
                                            data: {
                                                id: id,
                                                refNo: fieldOne,
                                                vendor_code: vendor_code,
                                            },
                    //                        contentType: 'application/json',
                                            success: function (response) {
                                                Swal.fire({
                                                    icon: 'success',
                                                    title: 'Deleted!',
                                                    text: response.message || 'Record has been deleted.'
                                                });
                                                $('#AjaxVendorAttachTab').DataTable().row($row).remove().draw();
                                            },
                                            error: function (xhr) {
                                                Swal.fire({
                                                    icon: 'error',
                                                    title: 'Error!',
                                                    text: 'Error deleting record: ' + xhr.responseText
                                                });
                                            }
                                        });
                                    }
                                });
                            });
                        </script>   
                    </form:form>
            </section>
        </main> 

    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
    <script language="javascript" type="text/javascript">

                function validation()
                {

                // last one 

                var i1 = 0;
                        var j1 = 1;
                        var k1 = 0;
                        while (i1 < document.form.tech_attachment_desc.length)
                        //                                            alert(document.form.tech_attachment_desc.length);
                        {
                        var cremark1 = 'yes' + j1;
                                var cremark2 = 'no' + j1;
                                var vvv = 'remarks' + j1
                                if (document.getElementById(cremark1).checked != true && document.getElementById(cremark2).checked != true)
                        {
                        alert("Please Select attachment Specification");
                                return false;
                        }
                        if (document.getElementById(cremark1).checked == false)
                        {
                        if (document.getElementById(vvv).value == '')
                        {
                        alert("Please add vendor remark");
                                return false;
                        }
                        }



                        i1++;
                                j1++;
                        }



                var i1 = 0;
                        var j1 = 1;
                        var k1 = 0;
                        while (i1 < document.form.vendor_tech_desc.length)
                {
                var cremark1 = '1techradion' + j1;
                        var cremark2 = '2techradion' + j1;
                        var vvv = 'tech_vendor_remark' + j1
                        if (document.getElementById(cremark1).checked != true && document.getElementById(cremark2).checked != true)
                {
                alert("Please Select Technical Specification");
                        return false;
                }
                if (document.getElementById(cremark1).checked == false)
                {
                if (document.getElementById(vvv).value == '')
                {
                alert("Please add vendor remark");
                        return false;
                }
                }

                var vvv1 = 'vendor_tech_attach' + j1
                        var vvv2 = '1vendor_tech_comp' + j1
                        if (document.getElementById(vvv2).value == 'Yes')
                {
                if (document.getElementById(vvv1).value == '0' || document.getElementById(vvv1).value == '')
                {
                alert("Please attach document");
                        return false;
                }
                }
                i1++;
                        j1++;
                }
                i1 = 0;
                        j1 = 1;
                        k1 = 0;
                        while (i1 < document.form.vendor_terms_desc.length)

                {
                var cremark1 = '1termsradion' + j1;
                        var cremark2 = '2termsradion' + j1;
                        var vvv = 'terms_vendor_remark' + j1
                        if (document.getElementById(cremark1).checked != true && document.getElementById(cremark2).checked != true)
                {
                alert("Please Select Terms & Condition");
                        return false;
                }
                if (document.getElementById(cremark1).checked == false)
                {
                if (document.getElementById(vvv).value == '')
                {
                alert("Please add vendor remark");
                        return false;
                }
                }

                var vvv1 = 'vendor_terms_attach' + j1
                        var vvv2 = '1vendor_terms_comp' + j1
                        if (document.getElementById(vvv2).value == 'Yes')
                {
                if (document.getElementById(vvv1).value == '0' || document.getElementById(vvv1).value == '')
                {
                alert("Please attach document");
                        return false;
                }
                }


                i1++;
                        j1++;
                }

                }
        function validateCheck() {
        alert("Click"); // Test alert to check if function is called



                // If all checks pass, you might want to submit the form or perform other actions
                // Example: document.getElementById('yourFormId').submit();
                return true; // Returning true because all validations passed
        }
    </script>
    <script type="text/javascript">
        $(document).on('click', '#generalTermsUpload [data-dismiss="modal"]', function () {
        var count = $('#AjaxVendorAttachTab tbody tr').length;
                $('#requireDocument3').text(count);
        });
    </script>
</html>


