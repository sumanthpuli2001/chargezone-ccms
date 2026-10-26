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
                <form:form action="vendor.htm?act=bidTenderForTechnicalSubmit" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                           name="formss"  class="form-horizontal" role="form" >  
                    
                     
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
                            <!--<button type="submit" class="btn theme-btn" onclick="return validation();"  value="SUBMIT">Submit</button>-->
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
                            <span style="font-weight: bold;color: red;">*</span> Fields marked with an asterisk are mandatory.
                        </div>
                    </div>
                    <br>
                    <h5 class="fw-600"> Technical Bid</h5>
                    <hr>
                    <input type="hidden" name="prDocAttachment" id="prDocAttachment" value="${prDocAttachment}">
                    <input type="hidden" name="itemDetailsSize" id="itemDetailsSize" value="${itemDetailsSize}">
                    <input type="hidden" name="itemDetailsForServiceSize" id="itemDetailsForServiceSize" value="${itemDetailsForServiceSize}">
                    <input type="hidden" name="tenderPhase" id="tenderPhase" value="${tenderPhase}">
                    <input type="hidden" name="refNo" id="refNo" value="${refNo}">

                    <div class="card-box rounded-3 mb-4 pt-3 pb-2">
                        <div class="row buyer-info">
                            
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
                            
                            <div class="col-xxl-3 col-lg-3 col-md-3 pb-1">
                                <div class="form-group">
                                    <label>Created By</label>
                                    <p class="fw-600">${tenderMaster.contactPerson}</p>
                                </div>
                            </div>
                                
                            <div class="col-xxl-3 col-lg-3 col-md-3 pb-1">
                                <div class="form-group">
                                    <label class="d-block">Contact Number</label>
                                    <a href="tel:${tenderAdminContactNumber}"
                                       class="fw-600 fs-13">${tenderMaster.tenderAdminContactNumber}</a>
                                </div>
                            </div>
                                
                            <div class="col-xxl-3 col-lg-3 col-md-3 pb-1">
                                <div class="form-group">
                                    <label>End User Name</label>
                                    <p class="fw-600">${tenderMaster.endUserName}</p>
                                </div>
                            </div>
                                
                            <div class="col-xxl-3 col-lg-3 col-md-3 pb-1">
                                <div class="form-group">
                                    <label class="d-block">End User Contact No</label>
                                    <a href="tel:${endUserNumber}"
                                       class="fw-600 fs-13">${tenderMaster.endUserNumber}</a>
                                </div>
                            </div>
                                
                            <div class="col-xxl-3 col-lg-3 col-md-3 pb-1">
                                <div class="form-group">
                                    <label>Technical Person Contact Name</label>
                                    <p class="fw-600">${tenderMaster.technicalContactName}</p>
                                </div>
                            </div>
                                
                            <div class="col-xxl-3 col-lg-3 col-md-3 pb-1">
                                <div class="form-group">
                                    <label class="d-block">Technical Person Contact Number</label>
                                    <a href="tel:${technicalContactNo}"
                                       class="fw-600 fs-13">${tenderMaster.technicalContactNo}</a>
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
                                
                    <h5 class="fw-600">Site Address</h5>
                    <hr>
                    <table id="commonTable" class="table  table-striped bg-white" style="min-width: 100%" align="Center"  >
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
                                <td style="text-align: center;">${status.count}</td>
                                <td style="text-align: center;">${list6.address1}</td>
                                <td style="text-align: center;">${list6.address2}</td>
                                <td style="text-align: center;">${list6.city}</td>
                                <td style="text-align: center;">${list6.state}</td>
                                <td style="text-align: center;">${list6.pincode}</td>
                                <td style="text-align: center;">${list6.remark}</td>
                            </tr>
                        </c:forEach>
                    </table>    
                        
                    <c:if test="${doc_cost != '0' && tenderPhase1 == '2'}" >      
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
                        <table id="commonDocTable1" class="table table-striped bg-white dt-scroll" style="min-width: 100%" align="Center"  >
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
                    <table  id="commonDocTable2"class="table  table-striped bg-white dt-scroll" style="min-width: 100%" align="Center"  >
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

                    <c:choose>
                        <c:when test="${empty vendorTechnicalBidTech1}"></c:when>
                        <c:otherwise>
                            <br>
                            <c:if test="${tenderMaster.type == 'Contract Civil'}">
                                <h5 class="fw-600">Civil Details </h5>
                            </c:if>
                            <c:if test="${tenderMaster.type != 'Contract Civil'}">
                                <c:if test="${tenderMaster.type == 'Service'}">
                                    <h5 class="fw-600">Items Details For Service </h5>
                                </c:if>
                                <c:if test="${tenderMaster.type != 'Service'}">
                                    <h5 class="fw-600">Item Details</h5>
                                </c:if>
                            </c:if>
                            
                            <hr>
                            
                            <table id="commonNoPageTable" class="table table-striped bg-white" style="" align="Center"  >
                                <thead>
                                    <tr>
                                        <th>Sr No.</th>
                                        <th style="min-width: 190px">Item Code</th>
                                        <th style="min-width: 530px">Item Details</th>
                                        <th style="min-width: 230px">Purpose</th>
                                        <th style="min-width: 230px">Make</th>
                                        <th>UOM</th>
                                        <th>Quantity</th>
                                        <th data-dt-order="disable">Yes</th>
                                        <th data-dt-order="disable">No</th>
                                        <th data-dt-order="disable" style="min-width: 230px">Vendor Remark</th>

                                    </tr>
                                </thead>

                                <tbody>
                                    <c:choose>
                                        <c:when test="${empty vendorTechnicalBidTech}">

                                            <c:forEach var="vendorTechnicalBidTech1" items="${vendorTechnicalBidTech1}" varStatus="status">
                                                <tr>
                                                    <td>${vendorTechnicalBidTech1.srNo}</td>
                                                    <td>${vendorTechnicalBidTech1.itemCode}</td>
                                                    <td>${vendorTechnicalBidTech1.itemDescription}</td>
                                                    <td>${vendorTechnicalBidTech1.deliveryScheduleQty} </td>
                                                    <td>${vendorTechnicalBidTech1.deliveryScheduleDate} </td>
                                                    <td>${vendorTechnicalBidTech1.uom} </td>
                                                    <td>${vendorTechnicalBidTech1.qty} </td>
                                                    <td><input type="radio" name="techradion${status.count}" id="1techradion${status.count}" value="0"   /> </td>
                                                    <td><input type="radio" name="techradion${status.count}" id="2techradion${status.count}" value="1"   /> </td>

                                                    <td>
                                                        <input type="hidden" name="vendor_tech_desc" id="vendor_tech_desc" value="${vendorTechnicalBidTech1.itemDescription}" class="input-field" />
                                                        <input type="hidden" name="vendor_tech_remark" id="vendor_tech_remark" value="${vendorTechnicalBidTech1.deliveryScheduleDate}" class="input-field" />
                                                        <input type="hidden" name="vendor_tech_comp" id="vendor_tech_comp" value="${vendorTechnicalBidTech1.deliveryScheduleQty}" class="input-field" >
                                                        <input type="hidden" name="1vendor_tech_comp${status.count}" id="1vendor_tech_comp${status.count}" value="${vendorTechnicalBidTech1.uom}" class="input-field" >

                                                        <textarea type="text"   name="tech_vendor_remark${status.count}"    id="tech_vendor_remark${status.count}"  class="textarea-field comment"  maxlength="250" ></textarea>
                                                        <small id="charCount_tech_vendor_remark${status.count}" style="font-size: 12px; color: green;">
                                                            250 characters remaining
                                                        </small>

                                                        <script type="text/javascript">
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
                                                       
                                                        <input type="hidden" name="vendor_tech_attach${status.count}" id="vendor_tech_attach${status.count}" value="" class="input-field" >
                                                        <input type="hidden" name="tech_item_code" id="vendor_terms_desc" value="${vendorTechnicalBidTech1.itemCode}" class="input-field" />
                                                        <input type="hidden" name="tech_uom" id="vendor_terms_desc" value="${vendorTechnicalBidTech1.uom}" class="input-field" />
                                                        <input type="hidden" name="tech_qty" id="vendor_terms_desc" value="${vendorTechnicalBidTech1.qty}" class="input-field" />
                                                        <input type="hidden" name="tech_sr_no" id="vendor_terms_desc" value="${vendorTechnicalBidTech1.srNo}" class="input-field" />
                                                        <span id="techDocument${status.count}"></span>
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
                                                    <td>${vendorTechnicalBidTech.attachmentRequired}</td>
                                                    <td>${vendorTechnicalBidTech.details} </td>
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
                                                        <input type="hidden" name="vendor_tech_desc" id="vendor_tech_desc" value="${vendorTechnicalBidTech.description}" class="input-field" />
                                                        <input type="hidden" name="vendor_tech_remark" id="vendor_tech_remark" value="${vendorTechnicalBidTech.details}" class="input-field" />
                                                        <input type="hidden" name="vendor_tech_comp" id="vendor_tech_comp" value="${vendorTechnicalBidTech.attachmentRequired}" class="input-field" >
                                                        <input type="hidden" name="1vendor_tech_comp${status.count}" id="1vendor_tech_comp${status.count}" value="${vendorTechnicalBidTech.attachmentRequired}" class="input-field" >
                                                        <input type="hidden" name="tech_sr_no" id="vendor_terms_desc" value="${vendorTechnicalBidTech.srNo}" class="input-field" />
                                                        <input type="hidden" name="tech_item_code" id="vendor_terms_desc" value="${vendorTechnicalBidTech.itemCode}" class="input-field" />
                                                        <input type="hidden" name="tech_uom" id="vendor_terms_desc" value="${vendorTechnicalBidTech.uom}" class="input-field" />
                                                        <input type="hidden" name="tech_qty" id="vendor_terms_desc" value="${vendorTechnicalBidTech.qty}" class="input-field" />
                                                        
                                                        <textarea type="text" name="tech_vendor_remark${status.count}" id="tech_vendor_remark${status.count}" class="input-field" maxlength="250">${vendorTechnicalBidTech.remark}</textarea>
                                                        <small id="charCount_tech_vendor_remark${status.count}" style="font-size: 12px; color: green;">250 characters remaining</small>
                                                        <script type="text/javascript">
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
                                                        </script>                                                                                                                                       </td>
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
                            <br>
                            <c:if test="${tenderMaster.type == 'Contract' || tenderMaster.type == 'Contract Civil' || tenderMaster.type == 'Contract Electrical'}">
                                <c:if test="${tenderMaster.type == 'Contract Civil'}">
                                    <h5 class="fw-600">Steel Details </h5>
                                </c:if>
                                <c:if test="${tenderMaster.type != 'Contract Civil'}"> 
                                    <h5 class="fw-600" >Item Details For Service</h5> 
                                </c:if>
                            </c:if>
                            <hr>
                            
                            <table id="commonNoPageTable0" class="table table-striped bg-white" style="" align="Center"  >
                                <thead>
                                    <tr>
                                        <th>Sr No.</th>
                                        <th style="min-width: 190px">Item Code</th>
                                        <th style="min-width: 530px">Item Details</th>
                                        <th style="min-width: 230px">Purpose</th>
                                        <th style="min-width: 230px">Make</th>
                                        <th>UOM</th>
                                        <th>Quantity</th>
                                        <th data-dt-order="disable">Yes</th>
                                        <th data-dt-order="disable">No</th>
                                        <th data-dt-order="disable" style="min-width: 230px">Vendor Remark</th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <c:choose>
                                        <c:when test="${empty vendorTechnicalBidTerms}">

                                            <c:forEach var="vendorTechnicalBidTerms1" items="${vendorTechnicalBidTerms1}" varStatus="status">
                                                <tr>
                                                    <td>${vendorTechnicalBidTerms1.srNo}</td>
                                                    <td>${vendorTechnicalBidTerms1.itemCode}</td>
                                                    <td>${vendorTechnicalBidTerms1.itemDescription}</td>
                                                    <td>${vendorTechnicalBidTerms1.deliveryScheduleQty} </td>
                                                    <td>${vendorTechnicalBidTerms1.deliveryScheduleDate} </td>
                                                    <td>${vendorTechnicalBidTerms1.uom} </td>
                                                    <td>${vendorTechnicalBidTerms1.qty} </td>
                                                    <td><input type="radio" name="termsradion${status.count}" id="1termsradion${status.count}" value="0"  /> </td>
                                                    <td><input type="radio" name="termsradion${status.count}" id="2termsradion${status.count}" value="1"  /> </td>

                                                    <td>
                                                        <input type="hidden" name="vendor_terms_desc" id="vendor_terms_desc" value="${vendorTechnicalBidTerms1.itemDescription}" class="input-field" />
                                                        <input type="hidden" name="vendor_terms_remark" id="vendor_terms_remark" value="${vendorTechnicalBidTerms1.deliveryScheduleDate}" class="input-field" />
                                                        <input type="hidden" name="vendor_terms_comp" id="vendor_terms_comp" value="${vendorTechnicalBidTerms1.deliveryScheduleQty}" class="input-field" >
                                                        <input type="hidden" name="1vendor_terms_comp${status.count}" id="1vendor_terms_comp${status.count}" value="${vendorTechnicalBidTerms1.uom}" class="input-field" >
                                                        <input type="hidden" name="terms_sr_no" id="vendor_terms_desc" value="${vendorTechnicalBidTerms1.srNo}" class="input-field" />
                                                        <input type="hidden" name="terms_item_code" id="vendor_terms_desc" value="${vendorTechnicalBidTerms1.itemCode}" class="input-field" />
                                                        <input type="hidden" name="terms_uom" id="vendor_terms_desc" value="${vendorTechnicalBidTerms1.uom}" class="input-field" />
                                                        <input type="hidden" name="terms_qty" id="vendor_terms_desc" value="${vendorTechnicalBidTerms1.qty}" class="input-field" />

                                                        <textarea type="text" name="terms_vendor_remark${status.count}" id="terms_vendor_remark${status.count}" class="input-field" maxlength="250"></textarea>
                                                        <small id="charCount_terms_vendor_remark${status.count}" style="font-size: 12px; color: green;">250 characters remaining</small>
                                                        <script type="text/javascript">
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
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </c:when>

                                        <c:otherwise>
                                            <c:forEach var="vendorTechnicalBidTerms" items="${vendorTechnicalBidTerms}" varStatus="status">
                                                <tr>
                                                    <td>${vendorTechnicalBidTerms.srNo}</td>
                                                    <td>${vendorTechnicalBidTerms.itemCode}</td>
                                                    <td>${vendorTechnicalBidTerms.description}</td>
                                                    <td>${vendorTechnicalBidTerms.attachmentRequired}</td>
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
                                                        <input type="hidden" name="vendor_terms_desc" id="vendor_terms_desc" value="${vendorTechnicalBidTerms.description}" class="input-field" />
                                                        <input type="hidden" name="vendor_terms_remark" id="vendor_terms_remark" value="${vendorTechnicalBidTerms.details}" class="input-field" />
                                                        <input type="hidden" name="vendor_terms_comp" id="vendor_terms_comp" value="${vendorTechnicalBidTerms.attachmentRequired}" class="input-field" >
                                                        <input type="hidden" name="1vendor_terms_comp${status.count}" id="1vendor_terms_comp${status.count}" value="${vendorTechnicalBidTerms.attachmentRequired}" class="input-field" >
                                                        <input type="hidden" name="terms_sr_no" id="vendor_terms_desc" value="${vendorTechnicalBidTerms.srNo}" class="input-field" />
                                                        <input type="hidden" name="terms_item_code" id="vendor_terms_desc" value="${vendorTechnicalBidTerms.itemCode}" class="input-field" />
                                                        <input type="hidden" name="terms_uom" id="vendor_terms_desc" value="${vendorTechnicalBidTerms.uom}" class="input-field" />
                                                        <input type="hidden" name="terms_qty" id="vendor_terms_desc" value="${vendorTechnicalBidTerms.qty}" class="input-field" />
                                                        
                                                        <textarea type="text" name="terms_vendor_remark${status.count}" id="terms_vendor_remark${status.count}"  class="input-field" maxlength="250">${vendorTechnicalBidTerms.remark}</textarea>
                                                        <small id="charCount_terms_vendor_remark${status.count}" style="font-size: 12px; color: green;">250 characters remaining</small>
                                                        <script type="text/javascript">
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
                            <button type="button" class="btn theme-btn d-flex align-items-center" data-toggle="modal" data-target="#generalTermsUpload" onclick="requestDocTechTab();">
                                <img src="StorageYard/assets/images/attachment.svg" class="attachment mr-1 d-inline" onload="SVGInject(this)" alt="User Image">
                                Attachment
                            </button>
                        </div>
                    </div>
                    <br>

                    <h5 class="fw-600">Attachment Of Vendor</h5>
                    <hr>

                    <table id="commonNoPageTable2" class="table table-striped bg-white " style="min-width: 100%" align="Center"  >
                        <thead>
                            <tr>
                                <th>Sr No.</th>
                                <th>Document</th>
                                <th data-dt-order="disable">Yes</th>
                                <th data-dt-order="disable">No</th>
                                <th data-dt-order="disable">Remark</th>
                                <th data-dt-order="disable" style="min-width: 230px;">Attachment</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:choose>
                                <c:when test="${empty vendorTechnicalBidAttachment}">

                                    <c:forEach var="prDoc" items="${prDoc}" varStatus="status">
                                        <tr>
                                            <td>${status.count}</td>
                                            
                                            <td><a class="fw-600 text-break gradient-text" href="prMaster.htm?act=downloadPrFile&amp;fileName=${prDoc.docName}&RefNo=${prDoc.refNo}">${prDoc.docName}</a></td>
                                            
                                            <td style="text-align: center" ><input type="radio" name="documentYes${status.count}" id="yes${status.count}" value="0"  /> </td>
                                            
                                            <td style="text-align: center"  ><input  type="radio" name="documentYes${status.count}" id="no${status.count}" value="1" /> </td>
                                            
                                            <td>
                                                <input type="hidden" name="tech_attachment_desc" id="tech_attachment_desc"  value="${prDoc.docTitle}" readonly="true"  class="input-field" >
                                                <input type="hidden" name="document" id="document" value="${prDoc.docName}">

                                                <textarea type="text" maxlength="250" class="textarea-field remarks" id="remarks${status.count}" name="remarks"></textarea>
                                                <small id="charCount_remarks${status.count}" style="font-size: 12px; color: green;">250 characters remaining</small>
                                                <script type="text/javascript">
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
                                                    });
                                                </script>
                                            </td>
                                            
                                            <td>
                                                <c:if test="${prDoc.attachmentRequired == 1}">
                                                    <input type="file" name="tech_attachment${status.count}"  class="input-field" required="true">    
                                                </c:if>
                                            </td>
                                        </tr>
                                    </c:forEach>    
                                </c:when>
                                        
                                <c:otherwise>
                                    <c:forEach var="vendorTechnicalBidAttachment" items="${vendorTechnicalBidAttachment}" varStatus="status">
                                        <tr>
                                            <input type="hidden" id="ids" name="ids" value="${vendorTechnicalBidAttachment.id}">
                                            <input type="hidden" name="tech_attachment_desc" id="tech_attachment_desc"  value="${vendorTechnicalBidAttachment.description}" readonly="true"  class="input-field" >
                                            <input type="hidden" name="document" id="document" value="${vendorTechnicalBidAttachment.document}">
                                            <input type="hidden" name="tech_attachment_comp" id="tech_attachment_comp" value="${technicalfile}" class="input-field" >
                                            
                                            <td style="text-align: center">${status.count}</td>
                                            
                                            <td  style="text-align: center"><a class="fw-600 text-break gradient-text" href="prMaster.htm?act=downloadPrFile&amp;fileName=${vendorTechnicalBidAttachment.document}&RefNo=${vendorTechnicalBidAttachment.refNo}" style="cursor: pointer;">${vendorTechnicalBidAttachment.document}</a></td>
                                            
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
                                                    <input type="radio" name="documentYes${status.count}" id="yes${status.count}" value="1"  checked/>
                                                </c:if>
                                                <c:if test="${vendorTechnicalBidAttachment.venderResponse != 1}">
                                                    <input type="radio" name="documentYes${status.count}" id="no${status.count}" value="1"  />
                                                </c:if>
                                            </td>
                                            
                                            <td> 
                                                <textarea type="text" class="input-field remarks"name="remarks" id="remarks${status.count}" maxlength="250">${vendorTechnicalBidAttachment.remark}</textarea>
                                                <small id="charCount_remarks${status.count}" style="font-size: 12px; color: green;">250 characters remaining</small>
                                                <script type="text/javascript">
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
                                                    });
                                                </script>
                                            </td>
                                            
                                            <td style="text-align: left">
                                                <span><a class="fw-600 text-break gradient-text" href="vendor.htm?act=downloadVenderAttachFile&amp;fileName=${vendorTechnicalBidAttachment.attachment}&RefNo=${vendorTechnicalBidAttachment.refNo}" style="cursor: pointer;">${vendorTechnicalBidAttachment.attachment}</a></span>
                                                <c:if test="${vendorTechnicalBidAttachment.attachment != ''}">
                                                    <input type="file" name="tech_attachment${status.count}"  class="input-field"  >
                                                </c:if>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                        </tbody>
                    </table>
                    <br>
                    <h5 class="fw-600">Vendor Remark For Technical Bid</h5>
                    <hr>
                    <div class="col-12 p-0">
                        <div class="form-group comment-box">
                            <label class="control-label">Technical Bid Deviation : <span class="text-danger">*</span></label>
                            <textarea  name="technicalBidDeviation" type="text" maxlength="250" class="textarea-field comment" id="technicalBidDeviation"   required="true">${technicalBidDeviation}</textarea>
                            <small id="charCount_technicalBidDeviation" style="font-size: 12px; color: green;">250 characters remaining</small>
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
                                    updateCounter();
                                    textarea.addEventListener("input", updateCounter);
                                });
                            </script>
                        </div>
                    </div>  
                    <div class="col-12 p-0">
                        <div class="form-group comment-box">
                            <label class="control-label">Technical Bid Remark : <span class="text-danger">*</span></label>
                            <textarea  name="technicalBidRemark" type="text" maxlength="250" class="textarea-field comment" id="technicalBidRemark"   required="true">${technicalBidRemark}</textarea>
                            <small id="charCount_technicalBidRemark" style="font-size: 12px; color: green;">
                                250 characters remaining
                            </small>
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
                                    updateCounter();
                                    textarea.addEventListener("input", updateCounter);
                                });
                            </script>
                        </div>
                    </div>
                            
                    <div class="form-group">
                        <div style="display: flex;  justify-content: center;">
                            <button type="submit" class="btn theme-btn" onclick="return validation();"  value="SUBMIT">Submit</button>
                        </div>
                    </div>
                            
                </form:form>
                    
                <form:form id="myForm" enctype="multipart/form-data" commandName="tenderMaster" name="form" class="form-horizontal" role="form">
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


                                    <table id="commonDocTable" class="table table-striped bg-white dt-scroll" style="min-width: 100%" align="center">
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

                            var ID = window.setInterval(requestDocTechTab(str7), 1000);
                                                </script>
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

        function setError(element) {

            if (element) {
                element.style.border = "2px solid red";
            }
        }

        function removeError(element) {

            if (element) {
                element.style.border = "";
            }
        }

        function validation(){
            
            // =====================================
            // TECHNICAL TABLE VALIDATION
            // =====================================

            var techRadios = document.querySelectorAll("input[name^='techradion']");

            var techNames = [];

            techRadios.forEach(function (radio) {

                if (!techNames.includes(radio.name)) {
                    techNames.push(radio.name);
                }

                radio.addEventListener("change", function () {
                    removeError(radio);
                });

            });

            for (var i = 0; i < techNames.length; i++) {

                var radioGroup = document.querySelectorAll(
                    "input[name='" + techNames[i] + "']"
                );

                var selectedRadio = document.querySelector(
                    "input[name='" + techNames[i] + "']:checked"
                );

                if (!selectedRadio) {

                    event.preventDefault();

                    radioGroup.forEach(function (r) {
                        setError(r);
                    });

                    radioGroup[0].focus();

                    Swal.fire({
                        icon: 'warning',
                        title: 'Selection Required',
                        text: 'Please select Yes or No for all Technical items.'
                    });

                    return false;
                }

                radioGroup.forEach(function (r) {
                    removeError(r);
                });

                if (selectedRadio.value === "1") {

                    var remarkBox = document.getElementById(
                        "tech_vendor_remark" + (i + 1)
                    );

                    if (!remarkBox.value.trim()) {

                        event.preventDefault();

                        setError(remarkBox);

                        remarkBox.focus();

                        Swal.fire({
                            icon: 'warning',
                            title: 'Remark Required',
                            text: 'Please enter remark for rejected Technical item.'
                        });

                        return false;
                    } else {

                        removeError(remarkBox);
                    }
                }
            }

            // =====================================
            // TERMS TABLE VALIDATION
            // =====================================

            var termsRadios = document.querySelectorAll("input[name^='termsradion']");

            var termsNames = [];

            termsRadios.forEach(function (radio) {

                if (!termsNames.includes(radio.name)) {
                    termsNames.push(radio.name);
                }

                radio.addEventListener("change", function () {
                    removeError(radio);
                });

            });

            for (var j = 0; j < termsNames.length; j++) {

                var termsGroup = document.querySelectorAll(
                    "input[name='" + termsNames[j] + "']"
                );

                var selectedTermsRadio = document.querySelector(
                    "input[name='" + termsNames[j] + "']:checked"
                );

                if (!selectedTermsRadio) {

                    event.preventDefault();

                    termsGroup.forEach(function (r) {
                        setError(r);
                    });

                    termsGroup[0].focus();

                    Swal.fire({
                        icon: 'warning',
                        title: 'Selection Required',
                        text: 'Please select Yes or No for all Terms items.'
                    });

                    return false;
                }

                termsGroup.forEach(function (r) {
                    removeError(r);
                });

                if (selectedTermsRadio.value === "1") {

                    var termsRemarkBox = document.getElementById(
                        "terms_vendor_remark" + (j + 1)
                    );

                    if (!termsRemarkBox.value.trim()) {

                        event.preventDefault();

                        setError(termsRemarkBox);

                        termsRemarkBox.focus();

                        Swal.fire({
                            icon: 'warning',
                            title: 'Remark Required',
                            text: 'Please enter remark for rejected Terms item.'
                        });

                        return false;
                    } else {

                        removeError(termsRemarkBox);
                    }
                }
            }

            // =====================================
            // ATTACHMENT TABLE VALIDATION
            // =====================================

            var attachmentRadios = document.querySelectorAll("input[name^='documentYes']");

            var attachmentNames = [];

            attachmentRadios.forEach(function (radio) {

                if (!attachmentNames.includes(radio.name)) {
                    attachmentNames.push(radio.name);
                }

                radio.addEventListener("change", function () {
                    removeError(radio);
                });

            });

            for (var k = 0; k < attachmentNames.length; k++) {

                var attachmentGroup = document.querySelectorAll(
                    "input[name='" + attachmentNames[k] + "']"
                );

                var selectedAttachmentRadio = document.querySelector(
                    "input[name='" + attachmentNames[k] + "']:checked"
                );

                if (!selectedAttachmentRadio) {

                    event.preventDefault();

                    attachmentGroup.forEach(function (r) {
                        setError(r);
                    });

                    attachmentGroup[0].focus();

                    Swal.fire({
                        icon: 'warning',
                        title: 'Selection Required',
                        text: 'Please select Yes or No for all attachment items.'
                    });

                    return false;
                }

                attachmentGroup.forEach(function (r) {
                    removeError(r);
                });

                if (selectedAttachmentRadio.value === "1") {

                    var attachmentRemark = document.getElementById(
                        "remarks" + (k + 1)
                    );

                    if (!attachmentRemark.value.trim()) {

                        event.preventDefault();

                        setError(attachmentRemark);

                        attachmentRemark.focus();

                        Swal.fire({
                            icon: 'warning',
                            title: 'Remark Required',
                            text: 'Please enter remark for rejected attachment.'
                        });

                        return false;
                    } else {

                        removeError(attachmentRemark);
                    }

                    var attachmentFile = document.querySelector(
                        "input[name='tech_attachment" + (k + 1) + "']"
                    );

                    if (attachmentFile && attachmentFile.files.length === 0) {

                        event.preventDefault();

                        setError(attachmentFile);

                        attachmentFile.focus();

                        Swal.fire({
                            icon: 'warning',
                            title: 'Attachment Required',
                            text: 'Please upload attachment for rejected document.'
                        });

                        return false;

                    } else if (attachmentFile) {

                        removeError(attachmentFile);
                    }
                }
            }


 
                        var i1 = 0;
                        var j1 = 1;
                        var k1 = 0;
                        while (i1 < document.formss.tech_sr_no.length)
//                                                               alert(document.formss.tech_sr_no.length);
                        {
                        var cremark1 = 'yes' + j1;
                                var cremark2 = 'no' + j1;
                                var vvv = 'remarks' + j1
                                if (document.getElementById(cremark1).checked != true && document.getElementById(cremark2).checked != true)
                        {
                            Swal.fire({
                            icon: 'warning',
                            title: 'Missing Attachment',
                            text: 'Please select attachment specification'
                          });
//                        alert("Please Select attachment Specification");
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
                        while (i1 < document.formss.vendor_tech_desc.length)
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
                        while (i1 < document.formss.vendor_terms_desc.length)

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

 


             
                return true; 
        }
    </script>
                <script type="text/javascript">
                $(document).on('click', '#generalTermsUpload [data-dismiss="modal"]', function () {
                    var count = $('#AjaxVendorAttachTab tbody tr').length;
                    $('#requireDocument3').text(count);
                });
                </script>
</html>


