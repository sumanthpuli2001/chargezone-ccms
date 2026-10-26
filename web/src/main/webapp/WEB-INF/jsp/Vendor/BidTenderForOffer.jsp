a<%-- 
    Document   : CreateDepartment
    Created on : 29 March, 2025, 9:35:37 AM
    Author     : Prachi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendor Offer</title>

    </head>

    <body>
       
        <script>
            $('#select_all').on('change', function () {
            $('.switch-input').prop('checked', this.checked).trigger('change');
            });     
                       </script>
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
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNewVendor.jsp"%>
            <section class="main-content">
                <form:form action="vendor.htm?act=bidTenderForOfferSubmit" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                           name="form"  class="form-horizontal" role="form" onsubmit="return validation();">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Vendor Offer</h5>
                        </div>


                       <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-2">Back</a>
                            <!--<button type="submit" class="btn theme-btn mr-2" value="SAVE AND NEXT">Save And Next</button>-->
                            <input type="button" class="btn theme-btn" style="width: 170px!important;" onclick="window.location.href='tenderMaster.htm?act=tenderPrint1&id=${tenderMaster.id}'"  title="" value="Tender Info Print" >

                        </div>
                    </div>

                    <hr>
                    
                    <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.
                        </div>
                    </div>
                    <br>
                    <h5 class="fw-600">Financial Bid</h5>
                    <input type="hidden" name="tenderPhase" id="tenderPhase" value="${tenderPhase}">
                    <input type="hidden" name="refNo" id="refNo" value="${tenderMaster.refNo}">
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


                            <div class="col-lg-8 col-md-4 pb-2">
                                <label class="text-muted">Tender Remark</label>
                                <div class="fw-600">${tenderMaster.tenderRemark}</div>
                            </div>


                        </div>
                    </div>
                            
                    <h5 class="fw-600">Site Address</h5>
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
                        <c:forEach var="multipleAddList" items="${multipleAddList}" varStatus="status">
                            <tr>
                                <td style="text-align: center;">${status.count}</td>
                                <td style="text-align: center;">${multipleAddList.address1}</td>
                                <td style="text-align: center;">${multipleAddList.address2}</td>
                                <td style="text-align: center;">${multipleAddList.city}</td>
                                <td style="text-align: center;">${multipleAddList.state}</td>
                                <td style="text-align: center;">${multipleAddList.pincode}</td>
                                <td style="text-align: center;">${multipleAddList.remark}</td>
                            </tr>
                        </c:forEach>
                    </table>
                            
                    <h5 class="fw-600">Tender Contact Person</h5> 

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
                                
                            <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                            <div class="form-group">
                                                <label>Name of Location Partner</label>
                                                <p class="fw-600">${prm.nameofLocationPartner}</p>
                                            </div>
                                        </div>
                                        <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                            <div class="form-group">
                                                <label>Mobile No Location Partner</label>
                                                <p class="fw-600">${prm.mobileNoLocationPartner}</p>
                                            </div>
                                        </div>    
                                
                                

                        </div>
                    </div>  


                    <c:if test="${doc_cost != '0' && tenderPhase1 == '1'}" >      
                        <h5 class="fw-600">Tender Fee Detail (Not Refundable)</h5>

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
                                    });                        </script>
                    </c:if> 
                    <c:if test="${emd != '0' && tenderPhase1 == '1'}">
                        <h5 class="fw-600">EMD Detail (Refundable)</h5>
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
                                    <label class="label">Attach Scan Copy Of EMD :</label>
                                    ${emd_attach}<input type="file" name="emd_attach" class="input-field" <c:if test="${emd_attach == ''}">required</c:if>/>                                        
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
                                        });                    </script>

                    <h5 class="fw-600" >Vendor Quotation Details</h5>
                    <div class="row mb-3">
                        <div class="col-lg-4 col-md-6">
                            <div class="form-group">
                                <label class="label">Quotation No. :<span class="text-danger">*</span></label>
                                <input name="offer_no" value="${offer_no}" class="input-field"   maxlength="30" required/>
                            </div>
                        </div>                                    
                        <div class="col-lg-4 col-md-6">
                            <div class="form-group">
                                <label class="label">Quotation Date :<span class="text-danger">*</span></label>
                                <input name="offer_date" value="${offer_date}" placeholder="${offer_date}" class="input-field form_datetime1" maxlength="30" required/>                                    </div>
                        </div>
                        <div class="col-lg-4 col-md-6">
                            <div class="form-group">
                                <label class="label">Contact Person :<span class="text-danger">*</span></label>
                                <input name="contact_person" value="${contact_person}" class="input-field"   maxlength="30" required/>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6">
                            <div class="form-group"> 
                                <label class="label">Contact No. :<span class="text-danger">*</span></label>
                                <input name="contact_no" value="${contact_no}" class="input-field"   maxlength="30" required/>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6">
                            <div class="form-group">
                                <label class="label">Contact Email ID :<span class="text-danger">*</span></label>
                                <input name="contact_email" value="${contact_email}" class="input-field"   maxlength="30" required/>
                            </div>
                        </div>
                    </div>
                    <script type="text/javascript">
                                        $(function () {
                                        const input = document.querySelector(".form_datetime1");
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
                                        });                    </script>



                    <h5 class="fw-600">Tender Attachment</h5>
                    <br>
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
                                <th data-dt-order="disable"><h5  >Tender Technical Docs</h5></th>
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
                    </div>

                    <div class="form-group">
                        <div style="display: flex;  justify-content: center;">
                            <button type="submit" class="btn theme-btn" value="SAVE AND NEXT">SAVE AND NEXT</button>
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
                                                data-dismiss="modal" >Close</button>
                                        <button type="button" class="btn theme-btn ml-3"
                                                id="uploadSubmitBtn">Submit</button>
                                    </div>
                                </div>
                                <div class="modal-body">
                                    <table id="commonDocTable" class="table table-striped bg-white dt-scroll " style="min-width: 100%" align="center">
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
                                    });                      
                                </script> 

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
            <script type="text/javascript">
                $(document).on('click', '#generalTermsUpload [data-dismiss="modal"]', function () {
                    var count = $('#AjaxVendorAttachTab tbody tr').length;
                    $('#requireDocument3').text(count);
                });
            </script>

    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
