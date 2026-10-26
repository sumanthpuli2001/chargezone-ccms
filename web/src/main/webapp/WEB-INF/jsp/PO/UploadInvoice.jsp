<%-- 
    Document   : UploadInvoice
    Created on : 29 Sep, 2026, 5:08:55 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload Document</title>
        <style>
            #policyTable {
                border-collapse: collapse;
                width: 100%;
            }
            #policyTable thead tr {
                border-bottom: 2px solid #dee2e6;
            }
            #policyTable tr {
                border-bottom: 1px solid #dee2e6;
            }
            #policyTable th,
            #policyTable td {
                padding: 10px 8px;
                vertical-align: middle;
            }
        </style>
    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNewVendor.jsp"%>
            <section class="main-content">
                <form:form action="poDetails.htm?act=submitInvoice" method="post" commandName="poDetails"
                           enctype="multipart/form-data"
                           class="form-horizontal" role="form">
                    <input type="hidden" value="${id}" name="id">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Upload Document</h5>
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
                    <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.
                        </div>
                    </div>
                    <div class="rounded-4 mt-4">

                        <table id="policyTable" class="table dt-scroll" style="max-width: 100%" align="center">
                            <thead>
                                <tr>
                                    <th>Document Type <span style="color:#D8000C;">*</span></th>
                                    <th>Document No <span style="color:#D8000C;">*</span></th>
                                    <th id="extraTh" style="display:none;">Invoice Amount *</th>
                                    <th>Attach Document <span style="color:#D8000C;">*</span></th>
                                    <th>Add New</th>
                                    <input type="hidden" name="policyCount" id="policyCount" value="1"/>
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
                                        <img src="StorageYard/assets/images/clone-btn.svg" onload="SVGInject(this)" alt="Clone Btn" />
                                    </div>
                                </td>   
                            </tr>
                        </table>

                    </div>
                    <br>
                    <div class="form-group">    
                        <div style="display: flex; justify-content: center;">
                            <button type="submit" class="btn theme-btn">Submit</button>
                        </div>
                    </div>
                </form:form>
            </section>
        </main>

        <script>
            var tempCount3 = 1;

            $(function () {
                $("#policyCloneid").on("click", function () {
                    tempCount3++;

                    // reuse the options rendered in the first select (includes "Other")
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
                            + "<img src='StorageYard/assets/images/clone-delete-btn.svg' onload='SVGInject(this)' alt='Remove'>"
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
                $("#policyTable").closest("form").on("submit", function (e) {
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
            document.addEventListener("DOMContentLoaded", function () {
                var textarea = document.getElementById("comment");
                var counter = document.getElementById("charCount_comment");
                if (!textarea || !counter) {
                    return; // no comment field on this page
                }
                var maxChars = 250;
                function updateCounter() {
                    var remaining = maxChars - textarea.value.length;
                    counter.textContent = remaining + " characters remaining";
                    counter.style.color = remaining <= 20 ? "red" : "green";
                }

                updateCounter();
                textarea.addEventListener("input", updateCounter);
            });
        </script>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
