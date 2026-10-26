<%-- 
    Document   : ViewInvoice
    Created on : 3 Oct, 2026, 11:28:07 AM
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
            <%@include file="/WEB-INF/jsp/Common/NavbarNewVendor.jsp"%>
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
                        <a href="poDetails.htm?act=poDetails" class="btn theme-btn light-btn">Back</a>
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
                        <div style="background: #198754; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px; ">✓</div>  
                        <div>
                            <strong>Note:</strong> <strong class="text-success fs-13">${successMessage} </strong><br>
                        </div>
                    </div>
                </c:if>
                <hr>

                <%-- a column is shown only if at least one record has data in it --%>
                <c:set var="showAmount" value="false"/>
                <c:set var="showOther" value="false"/>
                <c:set var="showBuyer" value="false"/>
                <c:set var="showVendorRemark" value="false"/>
                <c:set var="hasRecycle" value="false"/>
                <c:forEach items="${invoiceAttachmentList}" var="d">
                    <c:if test="${!empty d.invoiceAmount}"><c:set var="showAmount" value="true"/></c:if>
                    <c:if test="${!empty d.otherDocumentNo}"><c:set var="showOther" value="true"/></c:if>
                    <c:if test="${!empty d.buyerAttachment || !empty d.buyerComment}"><c:set var="showBuyer" value="true"/></c:if>
                    <c:if test="${!empty d.vendorComment}"><c:set var="showVendorRemark" value="true"/></c:if>
                    <c:if test="${d.status==3}"><c:set var="hasRecycle" value="true"/></c:if>
                </c:forEach>

                <form id="reuploadForm" action="poDetails.htm?act=reuploadDocument" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="id" value="${empty id ? param.id : id}">
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
                    <div class="rounded-4 mt-4">
                        <table id="commonTable1" class="table dt-scroll table-striped bg-white" style="max-width: 100%" align="center">
                            <thead>
                                <tr>
                                    <th>Sr No</th>
                                    <th>Document Type</th>
                                    <th>Document No</th>
                                    <c:if test="${showAmount}"><th>Invoice Amount</th></c:if>
                                    <th style="min-width: 200px;">Vendor Document</th>
                                    <c:if test="${showVendorRemark}"><th style="min-width: 200px;">Vendor Remark</th></c:if>
                                    <c:if test="${showBuyer}">
                                        <th style="min-width: 200px;">Buyer Attachment</th>
                                        <th style="min-width: 200px;">Buyer Remark</th>
                                    </c:if>
                                    <th>Status</th>
                                    <c:if test="${hasRecycle}"><th>Re-upload</th></c:if>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${invoiceAttachmentList}" var="doc" varStatus="status">
                                    <tr>
                                        <td>${status.count}</td>
                                       <td>
                                            <c:choose>
                                            <c:when test="${doc.documentType=='Other' || doc.documentType=='other'}">
                                                ${doc.otherDocumentNo}
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

                                        

                                        <td>
                                            <c:if test="${!empty doc.invoiceAttachment}">
                                                <a href="poDetails.htm?act=downloadPOAttachFile&id=${doc.poId}&fileName=${doc.invoiceAttachment}" class="fw-600 text-break gradient-text">
                                                    <c:out value="${doc.invoiceAttachment}"/>
                                                </a>
                                            </c:if>
                                        </td>

                                        <c:if test="${showVendorRemark}">
                                            <td>
                                                <c:choose>
                                                    <c:when test="${!empty doc.vendorComment}"><c:out value="${doc.vendorComment}"/></c:when>
                                                    <c:otherwise></c:otherwise>
                                                </c:choose>
                                            </td>
                                        </c:if>

                                        <c:if test="${showBuyer}">
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
                                            <td>
                                                <c:choose>
                                                    <c:when test="${!empty doc.buyerComment}"><c:out value="${doc.buyerComment}"/></c:when>
                                                    <c:otherwise></c:otherwise>
                                                </c:choose>
                                            </td>
                                        </c:if>

                                        <td>
                                            <c:if test="${doc.status==0}">
                                                <b class="text-info">Document Uploaded</b>
                                            </c:if>

                                            <c:if test="${doc.status==2}">
                                                <b class="text-success">Document Accepted</b>
                                            </c:if>

                                            <c:if test="${doc.status==3}">
                                                <b class="text-warning">Document Recycle</b>
                                            </c:if>

                                            <c:if test="${doc.status==4}">
                                                <b class="text-danger">Document Rejected</b>
                                            </c:if>
                                        </td>

                                        <%-- vendor can upload the document again only when the buyer recycled it --%>
                                        <c:if test="${hasRecycle}">
                                            <td>
                                                <c:choose>
                                                    <c:when test="${doc.status==3}">
                                                        <div style="min-width:220px;">
                                                            <input type="file" id="reFile_${doc.id}" name="reFile_${doc.id}"
                                                                   class="input-field rowInput" data-doc="${doc.id}" />
                                                          <textarea id="reRemark_${doc.id}" name="reRemark_${doc.id}" maxlength="250" rows="2"
                                                              placeholder="Remark *" class="input-field rowInput mt-2" data-doc="${doc.id}"></textarea>
                                                            <div id="charCount_reRemark_${doc.id}" style="font-size:11px; color:green;">250 characters remaining</div>
                                                                      <button type="button" class="btn theme-btn mt-2" onclick="reuploadDoc(${doc.id})">Re-upload</button>
                                                        </div>
                                                    </c:when>
                                                    <c:otherwise>-</c:otherwise>
                                                </c:choose>
                                            </td>
                                        </c:if>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </form>

                <%-- Add New Document button now sits below the list --%>
                <div class="d-flex justify-content-center mt-4 mb-3">
                    <button type="button" id="addDocBtn" class="btn theme-btn">Add New Document</button>
                </div>

                <%-- ================= ADD NEW DOCUMENT (hidden until the button is clicked) ================= --%>
                <div id="addDocSection" style="display:none;" class="mb-4">
                    <form id="addDocForm" action="poDetails.htm?act=submitInvoice" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="id" value="${empty id ? param.id : id}">
                        <input type="hidden" name="policyCount" id="policyCount" value="1"/>

                        <h6 class="fw-600 mb-2">Add New Document</h6>

                        <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                            <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                            <div>
                                <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.
                            </div>
                        </div>

                        <div class="rounded-4 mt-3">
                            <table id="policyTable" class="table dt-scroll" style="max-width: 100%" align="center">
                                <thead>
                                    <tr>
                                        <th>Document Type <span style="color:#D8000C;">*</span></th>
                                        <th>Document No <span style="color:#D8000C;">*</span></th>
                                        <th id="extraTh" style="display:none;">Invoice Amount *</th>
                                        <th>Attach Document <span style="color:#D8000C;">*</span></th>
                                        <th>Add New</th>
                                    </tr>
                                </thead>
                                <tr id="addmoreFile1">
                                    <td>
                                        <select id="documentName1" name="documentName1" class="select-input">
                                            <option value="">Select Document Type</option>
                                            <c:forEach items="${documentTypeList}" var="docType">
                                                <option value="${docType.name}">${docType.name}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td><input type="text" id="documentNo1" name="documentNo1" placeholder="Document No *" class="input-field" /></td>
                                    <%-- Invoice Amount appears for invoice types, Other Document Type appears for "Other" --%>
                                    <td class="extraCol" style="display:none;">
                                        <input type="text" id="invoiceAmount1" name="invoiceAmount1" placeholder="Invoice Amount *" class="input-field" style="display:none;" disabled />
                                        <input type="text" id="otherDocumentType1" name="otherDocumentType1" placeholder="Other Document Type *" class="input-field" style="display:none;" disabled />
                                    </td>
                                    <td><input type="file" id="attachDocument1" name="attachDocument1" class="input-field" /></td>

                                    <td style="text-align: center" class="d-flex justify-content-center align-items-center">
                                        <div class="clone-action clone-new-field mb-2" id="policyCloneid" style="cursor:pointer;">
                                            <img src="StorageYard/assets/images/clone-btn.svg" alt="Add more" style="width:34px; height:34px; display:block;" />
                                        </div>
                                    </td>   
                                </tr>
                            </table>
                        </div>

                        <div class="d-flex justify-content-center mt-3" style="gap:14px;">
                            <button type="submit" class="btn theme-btn">Submit</button>
                            <button type="button" id="cancelAddDoc" class="btn theme-btn light-btn">Cancel</button>
                        </div>
                    </form>
                </div>

            </section>
        </main>

    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>

    <script>
        // ---------- show / hide the "Add New Document" section (no server call, no page load) ----------
        $(document).off("click.addDoc", "#addDocBtn").on("click.addDoc", "#addDocBtn", function (e) {
            e.preventDefault();
            var section = $("#addDocSection");

            if (section.is(":visible")) {
                // already open -> hide it
                section.stop(true, true).hide();
                $(this).text("Add New Document");
            } else {
                // closed -> show it
                section.stop(true, true).show();
                $('.select-input').selectpicker("refresh");           // select was hidden when the page loaded
                $(this).text("Hide");
                $("html, body").animate({scrollTop: section.offset().top - 120}, 200);
            }
        });

        // Cancel inside the form also hides it and resets the button text
        $(document).off("click.addDoc", "#cancelAddDoc").on("click.addDoc", "#cancelAddDoc", function () {
            $("#addDocSection").stop(true, true).hide();
            $("#addDocBtn").text("Add New Document");
        });
    </script>

    <script>
        // ---------- re-upload of a recycled document ----------
        // clear red borders once the user fixes the field
        $("#commonTable1").on("input change", "input[id^='reRemark_'], input[id^='reFile_']", function () {
            $(this).css("border", "");
        });

        // docId = the id of the recycled row being re-uploaded
        function reuploadDoc(docId) {
            var fileBox = document.getElementById("reFile_" + docId);
            var remarkBox = $("#reRemark_" + docId);
            var remark = $.trim(remarkBox.val());

            var hasFile = fileBox.files && fileBox.files.length > 0;

            if (!hasFile || remark === "") {
                if (!hasFile) {
                    $(fileBox).css("border", "1px solid #D8000C");
                }
                if (remark === "") {
                    remarkBox.css("border", "1px solid #D8000C");
                }
                Swal.fire({
                    icon: "warning",
                    title: "Details Required",
                    text: "Please attach the document and enter a remark.",
                    confirmButtonText: "OK"
                });
                return;
            }

            Swal.fire({
                icon: "question",
                title: "Are you sure?",
                text: "Do you want to upload this document again?",
                showCancelButton: true,
                confirmButtonText: "Yes, Upload",
                cancelButtonText: "Cancel",
                reverseButtons: true,
                customClass: {
                    cancelButton: "btn theme-btn light-btn"
                }
            }).then(function (result) {
                if (result.isConfirmed) {
                    $("#docIds").val(docId);

                    // send only this row's file/remark (disabled inputs are not submitted)
                    $(".rowInput").not("[data-doc='" + docId + "']").prop("disabled", true);

                    document.getElementById("reuploadForm").submit();
                }
            });
        }
    </script>

    <script>
        // ---------- add-document table (clone rows, show Invoice Amount / Other type, validation) ----------
        var tempCount3 = 1;

        $(function () {
            $("#policyCloneid").on("click", function () {
                tempCount3++;

                // reuse the options rendered in the first select
                var docTypeOptions = $("#documentName1").html();

                var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"
                        + "<td><select id='documentName" + tempCount3 + "' name='documentName" + tempCount3 + "' class='select-input'>"
                        + docTypeOptions
                        + "</select></td>"
                        + "<td><input type='text' id='documentNo" + tempCount3 + "' name='documentNo" + tempCount3 + "' placeholder='Document No *' class='input-field' /></td>"
                        + "<td class='extraCol' style='display:none;'>"
                        + "<input type='text' id='invoiceAmount" + tempCount3 + "' name='invoiceAmount" + tempCount3 + "' placeholder='Invoice Amount *' class='input-field' style='display:none;' disabled />"
                        + "<input type='text' id='otherDocumentType" + tempCount3 + "' name='otherDocumentType" + tempCount3 + "' placeholder='Other Document Type *' class='input-field' style='display:none;' disabled />"
                        + "</td>"
                        + "<td><input type='file' name='attachDocument" + tempCount3 + "' id='attachDocument" + tempCount3 + "' class='input-field' /></td>"
                        + "<td class=\"d-flex justify-content-center align-items-center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<div class='clone-action delete-parent-field' title='Remove' style='cursor: pointer; display:inline-block;'>"
                        + "<img src='StorageYard/assets/images/clone-delete-btn.svg' alt='Remove' style='width:34px; height:34px; display:block;'>"
                        + "</div>"
                        + "</span>"
                        + "</td>"
                        + "</tr>";

                $("#policyTable").append(clone);
                updateExtraCol();
                $('.select-input').selectpicker("refresh");
                document.getElementById('policyCount').value = tempCount3;
            });
        });

        // show Invoice Amount for invoice types, Other Document Type for "Other" (same cell, same row)
        $("#policyTable").on("change", "select[name^='documentName']", function () {
            var idx = this.id.replace("documentName", "");
            var val = ($(this).val() || "").toString();

            var isInvoice = val.toLowerCase().indexOf("invoice") !== -1;
            var isOther = (val === "Other");

            var invoiceInput = $("#invoiceAmount" + idx);
            var otherInput = $("#otherDocumentType" + idx);

            invoiceInput.prop("disabled", !isInvoice).toggle(isInvoice);
            otherInput.prop("disabled", !isOther).toggle(isOther);

            // clear the disabled field so stale values are not kept
            if (!isInvoice) {
                invoiceInput.val("");
            }
            if (!isOther) {
                otherInput.val("");
            }

            updateExtraCol();
        });

        $("#policyTable").on("click", ".delete-parent-field", function () {
            var row = $(this).closest("tr");
            row.remove();
            // policyCount stays at the highest row number used; the controller skips removed rows
            updateExtraCol();
        });

        // ---------- required validation ----------
        function addError(el, msg) {
            el.closest("td").append("<div class='err-msg' style='color:#D8000C;font-size:12px;margin-top:4px;'>" + msg + "</div>");
        }

        // clear a cell's error as soon as the user fixes it
        $("#policyTable").on("change input", "select, input", function () {
            $(this).closest("td").find(".err-msg").remove();
        });

        $(function () {
            $("#addDocForm").on("submit", function (e) {
                var valid = true;
                $("#policyTable .err-msg").remove();

                $("#policyTable tr[id^='addmoreFile']").each(function () {
                    var idx = this.id.replace("addmoreFile", "");

                    var type = $("#documentName" + idx);
                    if (!type.val()) {
                        addError(type, "Please select document type");
                        valid = false;
                    }

                    var docNo = $("#documentNo" + idx);
                    if ($.trim(docNo.val()) === "") {
                        addError(docNo, "Document No is required");
                        valid = false;
                    }

                    var invoice = $("#invoiceAmount" + idx);
                    if (!invoice.prop("disabled")) {
                        var amt = $.trim(invoice.val());
                        if (amt === "") {
                            addError(invoice, "Invoice Amount is required");
                            valid = false;
                        } else if (!/^\d+(\.\d{1,2})?$/.test(amt)) {
                            addError(invoice, "Enter a valid amount");
                            valid = false;
                        }
                    }

                    var other = $("#otherDocumentType" + idx);
                    if (!other.prop("disabled") && $.trim(other.val()) === "") {
                        addError(other, "Other Document Type is required");
                        valid = false;
                    }

                    var file = $("#attachDocument" + idx);
                    if (!file.val()) {
                        addError(file, "Please attach a document");
                        valid = false;
                    }
                });

                if (!valid) {
                    e.preventDefault();
                    var first = $("#policyTable .err-msg").first();
                    if (first.length) {
                        $("html, body").animate({scrollTop: first.offset().top - 150}, 200);
                    }
                }
            });
        });

        // show the extra column (th + cells) only while some row needs it
        function updateExtraCol() {
            var hasInvoice = $("#policyTable input[name^='invoiceAmount']:not(:disabled)").length > 0;
            var hasOther = $("#policyTable input[name^='otherDocumentType']:not(:disabled)").length > 0;
            var show = hasInvoice || hasOther;

            var title = (hasInvoice && hasOther ? "Invoice Amount / Other Document Type"
                    : (hasOther ? "Other Document Type" : "Invoice Amount")) + " *";

            $("#extraTh").text(title).toggle(show);
            $("#policyTable .extraCol").toggle(show);
        }
    </script>
     <script type="text/javascript">
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

    // works for every recycled row, including rows added later
    $(document).on("input", "textarea[id^='reRemark_']", function () {
        updateRemarkCounter(this);
    });

    // set the starting text for each box when the page loads
    document.addEventListener("DOMContentLoaded", function () {
        $("textarea[id^='reRemark_']").each(function () {
            updateRemarkCounter(this);
        });
    });
</script>
</html>
