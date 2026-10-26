<%-- 
    Document   : ViewFinancailApproval
    Created on : 10 Oct, 2026, 11:44:20 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Document</title>
    </head>

    <body>

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

                        <h5 class="fw-600 mb-0">View Document</h5>
                    </div>

                    <div class="cta d-flex align-items-center">
                        <a onclick="history.back()" class="btn theme-btn light-btn">Back</a>
                    </div>
                </div>

                <c:if test="${!empty failureMessage}">
                    <div class="fadeOutEffect alert alert-danger mt-2 mb-2" style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; 
                         padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <strong>Note:</strong> <strong class="text-danger fs-13">${failureMessage} </strong><br>
                        </div>
                    </div>
                </c:if>
                <c:if test="${!empty successMessage}">
                    <div class="fadeOutEffect alert alert-info mt-2 mb-2" style="display: flex; align-items: center; gap: 12px; background: #F0FFF4; color: #0F5132; font-size: 12px; 
                         padding: 5px 10px; border-radius: 8px; border: 1px solid #198754; box-shadow: 2px 2px 10px rgba(25, 135, 84, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #198754; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">✓</div>
                        <div>
                            <strong>Note:</strong> <strong class="text-success fs-13">${successMessage} </strong><br>
                        </div>
                    </div>
                </c:if>
                <hr>

                <%-- show a column only if at least one record has data in it; also check whether any document is still pending (0) or recycled (3) --%>
                <c:set var="showAmount" value="false"/>
                <c:set var="showOther" value="false"/>
                <c:set var="showVendorRemark" value="false"/>
                <c:set var="hasUnresolved" value="false"/>
                <c:forEach items="${invoiceAttachmentList}" var="d">
                    <c:if test="${!empty d.invoiceAmount}"><c:set var="showAmount" value="true"/></c:if>
                    <c:if test="${!empty d.otherDocumentNo}"><c:set var="showOther" value="true"/></c:if>
                    <c:if test="${!empty d.vendorComment}"><c:set var="showVendorRemark" value="true"/></c:if>
                    <c:if test="${d.financialStatus==0 || d.financialStatus==3}"><c:set var="hasUnresolved" value="true"/></c:if>
                </c:forEach>

                <form id="docActionForm" action="poDetails.htm?act=updateDocumentFinancialStatus" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="id" value="${empty id ? param.id : id}">
                    <input type="hidden" name="docAction" id="docAction" value="">
                    <input type="hidden" name="docIds" id="docIds" value="">

                    <div class="rounded-4 mt-4">
                        <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                            <div class="row buyer-info">
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Tender No.</label>
                                        <p class="fw-600">${poDetails.tenderNo}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>PO No.</label>
                                        <p class="fw-600">${poDetails.poNo}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>PO Value</label>
                                        <p class="fw-600">${poDetails.poValue}</p>
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
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Department</label>
                                        <p class="fw-600">${tenderMaster.department}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Vendor Name</label>
                                        <p class="fw-600">${poDetails.vendorName}</p>
                                    </div>
                                </div>
                                   <div class="col-xxl-6 col-lg-4 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Vendor Code</label>
                                        <p class="fw-600">${poDetails.vendorCode}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Mode Of Transport</label>
                                        <p class="fw-600">${tenderMaster.modeOfTransport}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="rounded-4 mt-2">
                        <table id="commonTable" class="table dt-scroll table-striped bg-white" style="max-width: 100%" align="center">
                            <thead>
                                <tr>
                                    <th>Sr No</th>
                                    <th>Document Type</th>
                                    <th>Document No</th>
                                    <c:if test="${showAmount}"><th>Invoice Amount</th></c:if>
                                    <th style="min-width: 200px;">Vendor Document</th>
                                    <c:if test="${showVendorRemark}"><th style="min-width: 200px;">Vendor Remark</th></c:if>
                                    <th style="min-width: 230px;">Buyer Attachment</th>
                                    <th style="min-width: 220px;">Buyer Remark</th>
                                    <th style="min-width: 220px;">GRN Executive Attachment</th>
                                    <th style="min-width: 220px;">GRN Executive Remark</th>
                                    <th style="min-width: 220px;">Financial Attachment</th>
                                    <th style="min-width: 220px;">Financial Remark</th>
                                    <th data-dt-order="disable">Action/Status</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${invoiceAttachmentList}" var="doc" varStatus="status">
                                    <tr>

                                        <td>${status.count}</td>

                                        <td>
                                            <c:choose>
                                                <c:when test="${doc.documentType=='Other' || doc.documentType=='other'}">
                                                    <c:out value="${doc.otherDocumentNo}"/>
                                                </c:when>
                                                <c:otherwise>
                                                    <c:out value="${doc.documentType}"/>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>

                                        <td><c:out value="${doc.documentNo}"/></td>

                                        <c:if test="${showAmount}">
                                            <td>
                                                <c:choose>
                                                    <c:when test="${!empty doc.invoiceAmount}"><c:out value="${doc.invoiceAmount}"/></c:when>
                                                    <c:otherwise></c:otherwise>
                                                </c:choose>
                                            </td>
                                        </c:if>

                                        <%-- Vendor document --%>
                                        <td>
                                            <c:choose>
                                                <c:when test="${!empty doc.invoiceAttachment}">
                                                    <a href="poDetails.htm?act=downloadPOAttachFile&id=${doc.poId}&fileName=${doc.invoiceAttachment}" class="fw-600 text-break gradient-text">
                                                        <c:out value="${doc.invoiceAttachment}"/>
                                                    </a>
                                                </c:when>
                                                <c:otherwise></c:otherwise>
                                            </c:choose>
                                        </td>

                                        <%-- Vendor remark --%>
                                        <c:if test="${showVendorRemark}">
                                            <td>
                                                <c:choose>
                                                    <c:when test="${!empty doc.vendorComment}"><c:out value="${doc.vendorComment}"/></c:when>
                                                    <c:otherwise></c:otherwise>
                                                </c:choose>
                                            </td>
                                        </c:if>

                                        <%-- Buyer attachment --%>
                                        <td>
                                            <c:choose>
                                                <c:when test="${!empty doc.buyerAttachment}">
                                                    <a href="poDetails.htm?act=downloadPOBuyerAttachFile&id=${doc.poId}&fileName=${doc.buyerAttachment}" class="fw-600 text-break gradient-text">
                                                        <c:out value="${doc.buyerAttachment}"/>
                                                    </a>
                                                </c:when>
                                                <c:otherwise></c:otherwise>
                                            </c:choose>
                                        </td>

                                        <%-- Buyer remark --%>
                                        <td>
                                            <c:choose>
                                                <c:when test="${!empty doc.buyerComment}"><c:out value="${doc.buyerComment}"/></c:when>
                                                <c:otherwise></c:otherwise>
                                            </c:choose>
                                        </td>

                                        <%-- GRN Attachment: optional upload while pending, download link after --%>
                                        <td>
                                          
                                                    <c:choose>
                                                        <c:when test="${!empty doc.grnAttachment}">
                                                            <a href="poDetails.htm?act=downloadPOGRNAttachFile&id=${doc.poId}&fileName=${doc.grnAttachment}" class="fw-600 text-break gradient-text">
                                                                <c:out value="${doc.grnAttachment}"/>
                                                            </a>
                                                        </c:when>
                                                        <c:otherwise></c:otherwise>
                                                    </c:choose>
                                        </td>

                                        <%-- GRN Remark: editable while pending, read-only after Accept / Recycle / Reject --%>
                                        <td>
                                            <c:choose>
                                                        <c:when test="${!empty doc.grnComment}"><c:out value="${doc.grnComment}"/></c:when>
                                                        <c:otherwise>-</c:otherwise>
                                                    </c:choose>
                                        </td>
                                        
                                        
                                         <td>
                                            <c:choose>
                                                <c:when test="${doc.financialStatus==0 && invoiceMaster.grnFlag==1}">
                                                    <c:if test="${!empty doc.financialAttachment}">
                                                        <div style="font-size:12px; color:#6c757d;">Earlier attachment:</div>
                                                        <a href="poDetails.htm?act=downloadPOFinancialAttachFile&id=${doc.poId}&fileName=${doc.financialAttachment}" class="fw-600 text-break gradient-text">
                                                            <c:out value="${doc.financialAttachment}"/>
                                                        </a>
                                                    </c:if>
                                                    <input type="file" id="actionFile_${doc.id}" name="actionFile_${doc.id}"
                                                           class="input-field rowInput mt-1" data-doc="${doc.id}" />
                                                </c:when>
                                                <c:otherwise>
                                                    <c:choose>
                                                        <c:when test="${!empty doc.financialAttachment}">
                                                            <a href="poDetails.htm?act=downloadPOFinancialAttachFile&id=${doc.poId}&fileName=${doc.financialAttachment}" class="fw-600 text-break gradient-text">
                                                                <c:out value="${doc.financialAttachment}"/>
                                                            </a>
                                                        </c:when>
                                                        <c:otherwise></c:otherwise>
                                                    </c:choose>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${doc.financialStatus==0 && invoiceMaster.grnFlag==1}">
                                                    <textarea id="remark_${doc.id}" name="remark_${doc.id}" maxlength="250" rows="2"
                                                              placeholder="Remark" class="input-field rowInput" data-doc="${doc.id}"><c:out value="${doc.financialComment}"/></textarea>
                                                    <div id="charCount_remark_${doc.id}" style="font-size:11px; color:green;">250 characters remaining</div>
                                                </c:when>
                                                <c:otherwise>
                                                    <c:choose>
                                                        <c:when test="${!empty doc.financialComment}"><c:out value="${doc.financialComment}"/></c:when>
                                                        <c:otherwise></c:otherwise>
                                                    </c:choose>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        

                                        <%-- Action / Status --%>
                                        <td>
                                            <c:if test="${doc.financialStatus==0 && invoiceMaster.grnFlag==1}">
                                                <div class="d-flex" style="gap:8px;">
                                                    <button type="button" class="btn theme-btn" onclick="submitDocAction('Accept', ${doc.id})">Accept</button>
                                                    <button type="button" class="btn theme-btn light-btn" onclick="submitDocAction('Recycle', ${doc.id})">Recycle</button>
                                                    <button type="button" class="btn recycle-btn" style="color:#D8000C;" onclick="submitDocAction('Reject', ${doc.id})">Reject</button>
                                                </div>
                                            </c:if>

                                            <c:if test="${doc.financialStatus==2}">
                                                <b class="text-success">Document Accepted</b>
                                            </c:if>

                                            <c:if test="${doc.financialStatus==3}">
                                                <b class="text-warning">Document Recycle</b>
                                            </c:if>

                                            <c:if test="${doc.financialStatus==4}">
                                                <b class="text-danger">Document Rejected</b>
                                            </c:if>
                                        </td>
                                        
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>

                </form>
                                       <c:if test="${invoiceMaster.buyerStatus==1}">
                <div class="card mt-4">

                    <div class="card-header font-weight-bold">Review Details</div>

                    <div class="card-body">

                        <%-- GRN Number & GRN Date --%>
                        <c:if test="${invoiceMaster.grnFlag==1}">
                            <div class="row mb-3">
                                <div class="col-md-6 col-lg-4 mb-2">
                                    <div class="border rounded px-3 py-2 h-100">
                                        <small class="d-block text-uppercase font-weight-bold">GRN Number</small>
                                        <span>
                                            <c:choose>
                                                <c:when test="${!empty invoiceMaster.grnNumber}"><c:out value="${invoiceMaster.grnNumber}"/></c:when>
                                                <c:otherwise>-</c:otherwise>
                                            </c:choose>
                                        </span>
                                    </div>
                                </div>

                                <div class="col-md-6 col-lg-4 mb-2">
                                    <div class="border rounded px-3 py-2 h-100">
                                        <small class="d-block text-uppercase font-weight-bold">GRN Date</small>
                                        <span>
                                            <c:choose>
                                                <c:when test="${!empty invoiceMaster.grnDate}"><c:out value="${invoiceMaster.grnDate}"/></c:when>
                                                <c:otherwise>-</c:otherwise>
                                            </c:choose>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        

                        <%-- GRN Executive Remark --%>
                        <c:if test="${invoiceMaster.grnFlag==1}">
                            <div class="border rounded px-3 py-2 mb-3">
                                <small class="d-block text-uppercase font-weight-bold mb-1">GRN Executive Remark</small>
                                <div class="text-break">
                                    <c:choose>
                                        <c:when test="${!empty invoiceMaster.grnComment}"><c:out value="${invoiceMaster.grnComment}"/></c:when>
                                        <c:otherwise>-</c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </c:if>

                        <%-- Booking No & Booking Date --%>
                        <c:if test="${invoiceMaster.financialFlag==1}">
                            <div class="row mb-3">
                                <div class="col-md-6 col-lg-4 mb-2">
                                    <div class="border rounded px-3 py-2 h-100">
                                        <small class="d-block text-uppercase font-weight-bold">Booking No</small>
                                        <span>
                                            <c:choose>
                                                <c:when test="${!empty invoiceMaster.bookingNo}"><c:out value="${invoiceMaster.bookingNo}"/></c:when>
                                                <c:otherwise>-</c:otherwise>
                                            </c:choose>
                                        </span>
                                    </div>
                                </div>

                                <div class="col-md-6 col-lg-4 mb-2">
                                    <div class="border rounded px-3 py-2 h-100">
                                        <small class="d-block text-uppercase font-weight-bold">Booking Date</small>
                                        <span>
                                            <c:choose>
                                                <c:when test="${!empty invoiceMaster.bookingDate}"><c:out value="${invoiceMaster.bookingDate}"/></c:when>
                                                <c:otherwise>-</c:otherwise>
                                            </c:choose>
                                        </span>
                                    </div>
                                </div>
                            </div>

                            <%-- Financial Comment --%>
                            <div class="border rounded px-3 py-2">
                                <small class="d-block text-uppercase font-weight-bold mb-1">Financial Comment</small>
                                <div class="text-break">
                                    <c:choose>
                                        <c:when test="${!empty invoiceMaster.financialComment}"><c:out value="${invoiceMaster.financialComment}"/></c:when>
                                        <c:otherwise>-</c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </c:if>

                    </div>
                </div>
            </c:if>

                <%-- "Send to Financial Executive" shows only when every document is Accepted or Rejected --%>
                <c:if test="${!empty invoiceAttachmentList && !hasUnresolved && invoiceMaster.financialFlag==0}">
                    <form id="grnForm" action="poDetails.htm?act=approveByFinancial" method="post">
                        <input type="hidden" name="id" value="${empty id ? param.id : id}">

                        <div class="rounded-4 mt-4">
                            
                               <!-- GRN Number & GRN Date -->
                                    <div class="row mb-3">
                                        <div class="col-lg-4 col-md-6">
                                            <div class="form-group">
                                                <label for="bookingNo" class="form-label">
                                                     Booking No :<span class="text-danger">*</span>
                                                </label>
                                                <input type="text" id="bookingNo" name="bookingNo" class="input-field"
                                                       maxlength="50" placeholder="Enter Booking number" autocomplete="off">
                                            </div>
                                        </div>

                                        <div class="col-lg-4 col-md-6">
                                        <div class="form-group">
                                            <label for="bookingDate" class="form-label">
                                                Booking Date :<span class="text-danger">*</span>
                                            </label>
                                            <input type="text" id="bookingDate" name="bookingDate" class="input-field"
                                                   placeholder="dd/mm/yyyy" autocomplete="off">
                                        </div>
                                    </div>
                                    </div>


                            <!-- Remark -->
                            <div class="row mb-1">
                                <div class="col-lg-8 col-md-12">
                                    <div class="form-group">
                                        <label for="buyerRemark" class="form-label">
                                            Financial Remark :<span class="text-danger">*</span>
                                        </label>
                                        <textarea id="buyerRemark" name="financialRemark" class="input-field" rows="3"
                                                  maxlength="250" placeholder="Enter financial remark"></textarea>
                                        <div id="charCount_buyerRemark" style="font-size:11px; color:green;">250 characters remaining</div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="d-flex justify-content-center mt-4 mb-3">
                            <button type="button" class="btn theme-btn" onclick="sendToFinancial()">Approved</button>
                        </div>
                    </form>
                </c:if>

            </section>
        </main>

        <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>

        <script>
                 flatpickr("#bookingDate", {
                dateFormat: "d-m-y",
                allowInput: false,
                disableMobile: true
            });
            var maxChars = 250;


            function updateRemarkCounter(box) {
                var counter = document.getElementById("charCount_" + box.id);
                if (!counter) {
                    return;
                }
                var remaining = maxChars - box.value.length;
                counter.textContent = remaining + " characters remaining";
                counter.style.color = remaining <= 20 ? "red" : "green";
            }

            // ---------- Event bindings ----------

            // live character counter (row remarks + GRN remark)
            $(document).on("input", "textarea[id^='remark_'], #buyerRemark", function () {
                updateRemarkCounter(this);
            });

            // clear red error border once the user edits a field
            $(document).on("input change", "textarea[id^='remark_'], #buyerRemark ,#bookingNo, #bookingDate", function () {
                $(this).css("border", "");
            });

            $(document).ready(function () {
                // initial counter text
                $("textarea[id^='remark_'], #buyerRemark").each(function () {
                    updateRemarkCounter(this);
                });

            });

            // ---------- Row action: Accept / Recycle / Reject ----------
            // docId = the id of the row whose button was clicked
            function submitDocAction(action, docId) {
                var remarkBox = $("#remark_" + docId);
                var remark = $.trim(remarkBox.val());

                // remark is mandatory for Recycle and Reject
                if ((action === "Recycle" || action === "Reject") && remark === "") {
                    remarkBox.css("border", "1px solid #D8000C").focus();
                    Swal.fire({
                        icon: "warning",
                        title: "Remark Required",
                        text: "Please enter a remark to " + action.toLowerCase() + " this document.",
                        confirmButtonText: "OK"
                    });
                    return;
                }

                Swal.fire({
                    icon: "question",
                    title: "Are you sure?",
                    text: "Do you want to " + action + " this document?",
                    showCancelButton: true,
                    confirmButtonText: "Yes, " + action,
                    cancelButtonText: "Cancel",
                    reverseButtons: true,
                    customClass: {cancelButton: "btn theme-btn light-btn"}
                }).then(function (result) {
                    if (result.isConfirmed) {
                        $("#docAction").val(action);
                        $("#docIds").val(docId);

                        // submit only this row's remark/file (disabled inputs are not sent)
                        $(".rowInput").not("[data-doc='" + docId + "']").prop("disabled", true);

                        document.getElementById("docActionForm").submit();
                    }
                });
            }

            // ---------- Send to Financial Executive ----------
            function sendToFinancial() {
                var remarkBox = $("#buyerRemark");  
                 var bookingNumberBox = $("#bookingNo");
                var bookingDateBox = $("#bookingDate");
                var remark = $.trim(remarkBox.val());
                 var bookingNo = $.trim(bookingNumberBox.val());
                var bookingdate = $.trim(bookingDateBox.val());
                remarkBox.css("border", "");
                 bookingNumberBox.css("border", "");
                bookingDateBox.css("border", "");
       // GRN Number is mandatory
                if (bookingNo === "") {
                    bookingNumberBox.css("border", "1px solid #D8000C").focus();
                    Swal.fire({
                        icon: "warning",
                        title: "Booking Number Required",
                        text: "Please enter the Booking Number",
                        confirmButtonText: "OK"
                    });
                    return;
                }

                // GRN Date is mandatory
                if (bookingdate === "") {
                    bookingDateBox.css("border", "1px solid #D8000C").focus();
                    Swal.fire({
                        icon: "warning",
                        title: "Booking Date Required",
                        text: "Please select the booking Date.",
                        confirmButtonText: "OK"
                    });
                    return;
                }
                // GRN Executive Remark is mandatory
                if (remark === "") {
                    remarkBox.css("border", "1px solid #D8000C").focus();
                    Swal.fire({
                        icon: "warning",
                        title: "Remark Required",
                        text: "Please enter a Financial Remark before Approved.",
                        confirmButtonText: "OK"
                    });
                    return;
                }

                // Final confirmation
                Swal.fire({
                    icon: "question",
                    title: "Are you sure?",
                    text: "Do you want to Approve?",
                    showCancelButton: true,
                    confirmButtonText: "Yes, Send",
                    cancelButtonText: "Cancel",
                    reverseButtons: true,
                    customClass: {cancelButton: "btn theme-btn light-btn"}
                }).then(function (result) {
                    if (result.isConfirmed) {
                        document.getElementById("grnForm").submit();
                    }
                });
            }
        </script>
    </body>

</html>
