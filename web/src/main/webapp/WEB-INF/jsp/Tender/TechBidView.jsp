<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>

    <html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp" %>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>VENDER TECHNICAL VIEW</title>
        </head>
                       <style>
        .buyer-info .form-group p {
    white-space: normal;
    overflow-wrap: anywhere;
}
    </style>
        <script language="javascript" type="text/javascript">
            function gettender() {
                var t = document.getElementById("refNo").value;
                var tenderPhase = document.getElementById("tenderPhase").value;
                window.location = 'tenderMaster.htm?act=getTender&refNo=' + t + '&tenderPhase=' + tenderPhase;
            }

        </script>
        <script>
            function initResultContent(selector, obj = {}) {
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

        <body>
            <main class="d-flex align-items-end justify-content-end">
                <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp" %>
                <section class="main-content">
                    <form:form action="vendor.htm?act=techBidAccept" method="post" enctype="multipart/form-data" commandName="tenderMaster" 
                               name="myform" class="form-horizontal" role="form" onsubmit="return validation();">

                        <input type="hidden" name="itemDetailsSize" value="${itemDetailsSize}">
                        <input type="hidden" name="itemDetailsForServiceSize" value="${itemDetailsForServiceSize}">
                        <input type="hidden" name="attachmentCount" value="${attachmentCount}">
                        <input type="hidden" name="id" value="${id}">
                        <input type="hidden" name="refNo" id="refNo" value="${refNo}">
                        <input type="hidden" name="vendorCode" id="vendorCode" value="${vendorCode}">

                        <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                            <div class="page-title d-flex align-items-center">
                                <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                    <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                                    <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                                </div>

                                <h5 class="fw-600 mb-0">VENDER TECHNICAL VIEW</h5>
                            </div>

                            <div class="cta d-flex align-items-center">
                                <c:choose>
                                    <c:when test="${tenderMaster.authorizedBuyerFlag != 1 && tenderMaster.authorizedBuyerFlag != 2}">
                                        <div class="form-group">
                                            <div style="display: flex; justify-content: center;">
                                                <a onclick="history.back()" class="btn theme-btn light-btn">Back</a>
                                            </div>
                                        </div>
                                    </c:when>

                                    <c:otherwise>
                                        <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Cancel</a>
                                    </c:otherwise>
                                </c:choose>

                            </div>
                        </div>
                        <hr>

        

                        <h5 class="fw-600">Tender information</h5>   
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
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Vendor Code</label>
                                        <p class="fw-600">${vendorCode}- ${vendorName}</p>
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
                                        <label>Tender Date Time</label>
                                        <p class="fw-600">${tenderMaster.announceDate}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Due Date Time</label>
                                        <p class="fw-600">${tenderMaster.submitLastdate}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>PR No</label>
                                        <p class="fw-600">${tenderMaster.prNo}</p>
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
                        

                        <h5 class="fw-600"> Tender Contact Person</h5>
                        <hr>
                        <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                            <div class="row buyer-info">
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Created by</label>
                                        <p class="fw-600">${contactPerson}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Number</label>
                                        <p class="fw-600">${tenderAdminContactNumber}</p>
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
                            
                        <br>
                        <h5 class="fw-600">Vendor Attachment - ${vendorAttachment.size()}</h5>
                        <hr>
                        <table id="commonNoPageTable4" class="table table-striped bg-white" style="min-width: 100%" align="Center"  >
                            <thead>
                                <tr>
                                    <th>Attachment</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="vendorAttachment" items="${vendorAttachment}" varStatus="status">
                                    <tr>
                                        <td>
                                            <a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=downloadTenderVendorFile&amp;fileName=${vendorAttachment.attachment}&RefNo=${refNo}&vendor_code=${vendorCode}">
                                                ${vendorAttachment.attachment}
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <br>

                        <c:if test="${tenderMaster.type == 'Contract Civil'}">
                            <h5 class="fw-600">Civil Details</h5>
                        </c:if>
                        <c:if test="${tenderMaster.type != 'Contract Civil'}">
                            <c:if test="${tenderMaster.type == 'Service'}">
                                <h5 class="fw-600">Items Details For Service</h5>
                            </c:if>
                            <c:if test="${tenderMaster.type != 'Service'}">
                                <h5 class="fw-600">Item Details</h5>
                            </c:if>
                        </c:if>
                        <hr>

                        <table id="iteamDetailsTab" class="table table-striped bg-white dt-scroll" style="width: 100%" align="Center">
                            <thead>
                                <tr>
                                    <th> Sr. No. </th>
                                    <th style="min-width: 530px;"> Item Description </th>
                                    <th style="min-width: 230px;"> Make </th>
                                    <th> Purpose </th>
                                    <th style="min-width: 230px;"> Vendor Response </th>
                                    <th style="min-width: 230px;"> Vendor Remark </th>
                                    <th data-dt-order="disable" class="text-center"> Accept
                                        <input type="radio" name="techAccept" value="1" onclick="return techdata(1);" />
                                    </th>
                                    <th data-dt-order="disable" class="text-center"> Reject
                                        <input type="radio" name="techAccept" value="2" onclick="return techdata1(1);" />
                                    </th>
                                    <th data-dt-order="disable" style="min-width: 230px;"> Technical Committee
                                        Member Remark
                                    </th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach var="vendorTechnicalBidTech" items="${vendorTechnicalBidTech}"
                                    varStatus="status">
                                    <tr>
                                        <td> ${status.count}</td>
                                        <td>${vendorTechnicalBidTech.description}</td>
                                        <td>${vendorTechnicalBidTech.details}</td>
                                        <td>${vendorTechnicalBidTech.attachmentRequired}</td>
                                        <td>
                                            <c:if test="${vendorTechnicalBidTech.vendorResponse == 0}">
                                                Yes
                                            </c:if>
                                            <c:if test="${vendorTechnicalBidTech.vendorResponse == 1}">
                                                No
                                            </c:if>
                                            <c:if test="${vendorTechnicalBidTech.vendorResponse == 2}">
                                                NA
                                            </c:if>
                                        </td>
                                        <td>${vendorTechnicalBidTech.remark}</td>
                                        <td class="text-center">
                                            <c:if test="${vendorTechnicalBidTech.buyerResponse == 1}">
                                                <input type="radio" name="techradion${status.count}" id="1techradion${status.count}" value="1" checked />
                                            </c:if>
                                            <c:if test="${vendorTechnicalBidTech.buyerResponse != 1}">
                                                <input type="radio" name="techradion${status.count}" id="1techradion${status.count}" value="1" />
                                            </c:if>
                                        </td>
                                        <td class="text-center">

                                            <c:if test="${vendorTechnicalBidTech.buyerResponse == 2}">
                                                <input type="radio" name="techradion${status.count}" id="2techradion${status.count}" value="2" checked />
                                            </c:if>
                                            <c:if test="${vendorTechnicalBidTech.buyerResponse != 2}">
                                                <input type="radio" name="techradion${status.count}" id="2techradion${status.count}" value="2" />
                                            </c:if>
                                        </td>
                                        <td>
                                            <textarea type="text" name="tech_vendor_remark${status.count}" id="tech_vendor_remark${status.count}" maxlength="250" class="textarea-field ">${vendorTechnicalBidTech.buyerRemark}</textarea>

                                            <small id="charCount_tech_vendor_remark${status.count}" style="font-size: 12px; color: green;">
                                                250 characters remaining
                                            </small>

                                            <script type="text/javascript">
                                                document.addEventListener("DOMContentLoaded", function () {
                                                    var input = document.getElementById("tech_vendor_remark${status.count}");
                                                    var counter = document.getElementById("charCount_tech_vendor_remark${status.count}");
                                                    var maxChars = 250;

                                                    function updateCounter() {
                                                        var count = input.value.length;
                                                        var remaining = maxChars - count;
                                                        counter.textContent = remaining + " characters remaining";

                                                        if (remaining <= 20) {
                                                            counter.style.color = "red";
                                                        } else {
                                                            counter.style.color = "green";
                                                        }
                                                    }

                                                    updateCounter();
                                                    input.addEventListener("input", updateCounter);
                                                });
                                            </script>


                                        </td>

                                        <input type="hidden" name="vendor_tech_desc" id="vendor_tech_desc" value="${vendorTechnicalBidTech.description}" class="form-control" />
                                        <input type="hidden" name="vendor_tech_remark" id="vendor_tech_remark" value="${vendorTechnicalBidTech.details}" class="form-control" />
                                        <input type="hidden" name="vendor_tech_comp" id="vendor_tech_comp" value="${vendorTechnicalBidTech.attachmentRequired}" class="form-control">
                                        <input type="hidden" name="1vendor_tech_comp${status.count}" id="1vendor_tech_comp${status.count}" value="${vendorTechnicalBidTech.attachmentRequired}" class="form-control">

                                        <input type="hidden" name="tech_sr_no" id="vendor_terms_desc" value="${vendorTechnicalBidTech.srNo}" class="form-control" />
                                        <input type="hidden" name="tech_item_code" id="vendor_terms_desc" value="${vendorTechnicalBidTech.itemCode}" class="form-control" />
                                        <input type="hidden" name="tech_uom" id="vendor_terms_desc" value="${vendorTechnicalBidTech.uom}" class="form-control" />
                                        <input type="hidden" name="tech_qty" id="vendor_terms_desc" value="${vendorTechnicalBidTech.qty}" class="form-control" />

                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>

                        <c:choose>
                            <c:when test="${empty vendorTechnicalBidTerms}"> </c:when>
                            <c:otherwise>
                                <c:if test="${tenderMaster.type == 'Contract' || tenderMaster.type == 'Contract Civil' || tenderMaster.type == 'Contract Electrical'}">
                                    <c:if test="${tenderMaster.type == 'Contract Civil'}">
                                        <h5 class="fw-600">Steel Details </h5>
                                    </c:if>
                                    <c:if test="${tenderMaster.type != 'Contract Civil'}">
                                        <h5 class="fw-600">Item Details For Service</h5>
                                    </c:if>
                                </c:if>
                                <hr>
                                <table id="commonNoPageTable" class="table table-striped bg-white" style="width: 100%" align="Center">
                                    <thead>
                                        <tr>
                                            <th> Sr. No. </th>
                                            <th style="min-width: 530px;"> Item Description </th>
                                            <th style="min-width: 230px;"> Make </th>
                                            <th> Purpose </th>
                                            <th style="min-width: 230px;"> Vendor Response </th>
                                            <th style="min-width: 230px;"> Remark </th>
                                            <th data-dt-order="disable"> Accept
                                                <input type="radio" name="termsAccept" value="1" onclick="return termsdata(1);" />
                                            </th>
                                            <th data-dt-order="disable"> Reject
                                                <input type="radio" name="termsAccept" value="2" onclick="return termsdata1(1);" />
                                            </th>
                                            <th style="min-width: 230px;"> Technical Committee Member Remark </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="vendorTechnicalBidTerms" items="${vendorTechnicalBidTerms}" varStatus="status">
                                            <tr>
                                                <td>${status.count}</td>
                                                <td>${vendorTechnicalBidTerms.description}</td>
                                                <td>${vendorTechnicalBidTerms.details}</td>
                                                <td>${vendorTechnicalBidTerms.attachmentRequired}</td>
                                                <td>
                                                    <c:if test="${vendorTechnicalBidTerms.vendorResponse == 0}">
                                                        Yes
                                                    </c:if>
                                                    <c:if test="${vendorTechnicalBidTerms.vendorResponse == 1}">
                                                        No
                                                    </c:if>
                                                    <c:if test="${vendorTechnicalBidTerms.vendorResponse == 2}">
                                                        NA
                                                    </c:if>
                                                </td>
                                                <td>${vendorTechnicalBidTerms.remark}</td>
                                                <td>

                                                    <c:if test="${vendorTechnicalBidTerms.buyerResponse == 1}">
                                                        <input type="radio" name="termsradion${status.count}" id="1termsradion${status.count}" value="1" checked />
                                                    </c:if>
                                                    <c:if test="${vendorTechnicalBidTerms.buyerResponse != 1}">
                                                        <input type="radio" name="termsradion${status.count}" id="1termsradion${status.count}" value="1" />
                                                    </c:if>
                                                    </div>
                                                </td>
                                                <td>
                                                    <c:if test="${vendorTechnicalBidTerms.buyerResponse == 2}">
                                                        <input type="radio" name="termsradion${status.count}" id="2termsradion${status.count}" value="2" checked />
                                                    </c:if>
                                                    <c:if test="${vendorTechnicalBidTerms.buyerResponse != 2}">
                                                        <input type="radio" name="termsradion${status.count}" id="2termsradion${status.count}" value="2" />
                                                    </c:if>
                                                    </div>
                                                </td>
                                                <td>
                                                    <textarea name="terms_vendor_remark${status.count}" id="terms_vendor_remark${status.count}" class="textarea-field  remark-textarea" maxlength="250">${vendorTechnicalBidTerms.buyerRemark}</textarea>
                                                    <small id="charCount_terms_vendor_remark" style="font-size: 12px; color: green;">
                                                        250 characters remaining
                                                    </small>

                                                    <script>
                                                        document.addEventListener("DOMContentLoaded", function () {
                                                            var textarea = document.getElementById("terms_vendor_remark${status.count}");
                                                            var counter = document.getElementById("charCount_terms_vendor_remark");
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

                                                <input type="hidden" name="vendor_terms_desc" id="vendor_terms_desc" value="${vendorTechnicalBidTerms.description}" class="form-control" />
                                                <input type="hidden" name="vendor_terms_remark" id="vendor_terms_remark" value="${vendorTechnicalBidTerms.details}" class="form-control" />
                                                <input type="hidden" name="vendor_terms_comp" id="vendor_terms_comp" value="${vendorTechnicalBidTerms.uom}" class="form-control">
                                                <input type="hidden" name="1vendor_terms_comp${status.count}" id="1vendor_terms_comp${status.count}" value="${vendorTechnicalBidTerms.uom}" class="form-control">
                                                <input type="hidden" name="terms_sr_no" id="vendor_terms_desc" value="${vendorTechnicalBidTerms.srNo}" class="form-control" />
                                                <input type="hidden" name="terms_item_code" id="vendor_terms_desc" value="${vendorTechnicalBidTerms.itemCode}" class="form-control" />
                                                <input type="hidden" name="terms_uom" id="vendor_terms_desc" value="${vendorTechnicalBidTerms.uom}" class="form-control" />
                                                <input type="hidden" name="terms_qty" id="vendor_terms_desc" value="${vendorTechnicalBidTerms.qty}" class="form-control" />
                                                <input type="hidden" name="buyer_terms_response" id="vendor_terms_desc" value="${buyerResponse}" class="form-control" />
                                                <input type="hidden" name="buyer_terms_remark" id="vendor_terms_desc" value="${buyerremark}" class="form-control" />
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>

                            </c:otherwise>
                        </c:choose>
                                <br>
                        <h5 class="fw-600">Attachment By Vendor</h5>
                        <hr>
                        <table id="AttachmentVendorTable" class="table  table-striped bg-white dt-scroll" style="min-width: 100%" align="Center">
                            <thead>
                                <tr>
                                    <th> Sr. No. </th>
                                    <th style="min-width: 230px;"> Item Description </th>
                                    <th> Document </th>
                                    <th> Vender Response </th>
                                    <th style="min-width: 230px;"> Vender Remark </th>
                                    <th> Attachment </th>
                                    <th data-dt-order="disable" class="text-center">
                                        <div>Accept</div>
                                        <input type="radio" name="vendorAccept" value="1" onclick="return termsdata111(1);" />
                                    </th>
                                    <th data-dt-order="disable" class="text-center">
                                        <div>Reject</div>
                                        <input type="radio" name="vendorAccept" value="2" onclick="return termsdata222(1);" />
                                    </th>
                                    <th data-dt-order="disable" style="min-width: 230px;"> Remark</th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach var="vendorTechnicalBidAttachment"
                                    items="${vendorTechnicalBidAttachment}" varStatus="status">
                                    <tr>
                                        <input type="hidden" name="vendorDescription" id="vendorDescription" value="${vendorTechnicalBidAttachment.description}" class="form-control" />
                                        <td> ${status.count}</td>
                                        <td>
                                            <input type="hidden" class="form-control" name="descriptionvendor" id="descriptionvendor" readonly="true" value="${vendorTechnicalBidAttachment.description}">${vendorTechnicalBidAttachment.description}
                                        </td>
                                        <td>${vendorTechnicalBidAttachment.document}</td>
                                        
                                        <c:if test="${vendorTechnicalBidAttachment.venderResponse== '0'}">
                                            <td>Yes</td>
                                        </c:if>
                                        <c:if test="${vendorTechnicalBidAttachment.venderResponse== '1'}">
                                            <td>No</td>
                                        </c:if>
                                            
                                        <td>
                                            <input type="hidden" class="form-control" readonly="true" value="${vendorTechnicalBidAttachment.remark}">${vendorTechnicalBidAttachment.remark}
                                        </td>
                                        <td>
                                            <a  class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=downloadTenderVendorFile&amp;fileName=${vendorTechnicalBidAttachment.attachment}&RefNo=${refNo}&vendor_code=${vendorCode}">${vendorTechnicalBidAttachment.attachment}</a>
                                        </td>
                                        
                                        <c:if test="${vendorTechnicalBidAttachment.buyerResponse == '1'}">
                                            <td class="text-center">
                                                <input type="radio" name="buyerAccept${status.count}" value="1" id="buyerAccept${status.count}" checked="true" />
                                            </td>
                                        </c:if>
                                            
                                        <c:if test="${vendorTechnicalBidAttachment.buyerResponse != '1'}">
                                            <td class="text-center">
                                                <input type="radio" name="buyerAccept${status.count}" value="1" id="buyerAccept${status.count}" />
                                            </td>
                                        </c:if>

                                        <c:if test="${vendorTechnicalBidAttachment.buyerResponse == '2'}">
                                            <td class="text-center">
                                                <input type="radio" name="buyerAccept${status.count}" id="buyerReject${status.count}" value="2" checked="true" />
                                            </td>
                                        </c:if>
                                            
                                        <c:if test="${vendorTechnicalBidAttachment.buyerResponse != '2'}">
                                            <td class="text-center">
                                                <input type="radio" name="buyerAccept${status.count}" id="buyerReject${status.count}" value="2" />
                                            </td>
                                        </c:if>

                                        <td>

                                            <textarea name="buyerRemark${status.count}" id="buyerRemark${status.count}" class="textarea-field buyer-remark-textarea" maxlength="250">${vendorTechnicalBidAttachment.buyerRemark}</textarea>
                                            <small id="charCount_buyerRemark${status.count}" style="font-size: 12px; color: green;">
                                                250 characters remaining
                                            </small>

                                            <script>
                                                document.addEventListener("DOMContentLoaded", function () {
                                                    var textarea = document.getElementById("buyerRemark${status.count}");
                                                    var counter = document.getElementById("charCount_buyerRemark${status.count}");
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
                            </tbody>
                        </table>
                        <br>
                        <h5 class="fw-600"> Vendor Remark For Technical</h5>
                        <hr>
                        <table id="commonDocTable1" class="table  table-striped bg-white dt-scroll" style="min-width: 100%" align="Center">
                            <thead>
                                <tr>
                                    <th>Technical Bid Deviation?</th>
                                    <c:if test="${technicalBidDeviation != ''}">
                                        <th>Deviation</th>
                                    </c:if>
                                    <th>Remark</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <c:if test="${technicalBidDeviation == ''}">
                                            No
                                        </c:if>
                                        <c:if test="${technicalBidDeviation != ''}">
                                            Yes
                                        </c:if>
                                    </td>
                                    <c:if test="${technicalBidDeviation != ''}">
                                        <td>
                                            ${technicalBidDeviation}
                                        </td>
                                    </c:if>
                                    <td>${technicalBidRemark}</td>
                                </tr>
                            </tbody>

                        </table>

                        <div class="form-group">
                            <div class="content-top mb-3 d-flex align-items-center justify-content-between">
                                <div class="d-flex align-items-center">
                                    <h5 class="fw-600"> Tender Technical Document </h5>
                                </div>

                                <button type="button" class="btn theme-btn d-flex align-items-center" data-toggle="modal" data-target="#tenderTechnicalUpload" onclick="requestDocTenderTechnicalTab();">
                                    <img src="StorageYard/assets/images/attachment.svg" class="attachment mr-1 d-inline" onload="SVGInject(this)" alt="User Image">
                                    Attachment
                                </button>

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


                        <h5 class="fw-600">Technical Remark</h5>
                        <hr>
                        <div class="col-12 p-0">
                            <div class="form-group comment-box">
                                <label class="control-label">Comment :</label>
                                <textarea type="text" maxlength="250" class="textarea-field buyer-remark" id="technicalRemark" name="technicalRemark">${technicalBidRemark}</textarea>
                                <small id="charCount_technicalRemark" style="font-size: 12px; color: green;">250 characters remaining</small>
                            </div>
                        </div>

                        <script>
                            document.addEventListener("DOMContentLoaded", function () {
                                var textarea = document.getElementById("technicalRemark");
                                var counter = document.getElementById("charCount_technicalRemark");
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

                        <c:if test="${tenderMaster.authorizedBuyerFlag != 1 && tenderMaster.authorizedBuyerFlag != 2}">
                            <div class="form-group">
                                <div style="display: flex;  justify-content: center;">
                                    <button type="submit" class="btn theme-btn mr-3" formaction="vendor.htm?act=techBidAccept" onsubmit="return validation();">Accept</button>
                                    <button type="submit" class="btn theme-btn" formaction="vendor.htm?act=techBidSendToVendor" onsubmit="return validation();">Send To Vendor</button>
                                </div>
                            </div>
                        </c:if>

                    </form:form>
                    <form:form id="myForm" enctype="multipart/form-data" commandName="prMaster" name="form"
                        class="form-horizontal" role="form">
                        <input type="hidden" name="refNo" id="refNo1" value="${refNo}">
                        <input type="hidden" name="vendorCode" id="vendorCode" value="${vendorCode}">
                       
                        <div class="modal fade" id="tenderTechnicalUpload" data-backdrop="static"
                            data-keyboard="false" tabindex="-1" aria-labelledby="tenderTechnicalUploadLabel"
                            aria-hidden="true">
                            <div class="modal-dialog modal-sm">
                                <div class="modal-content">

                                    <div class="modal-header align-items-center">
                                        <h5 class="modal-title" id="tenderTechnicalUploadLabel">Attach Document
                                        </h5>
                                        <div class="cta-btn d-flex align-items-center">
                                            <button type="button" class="btn theme-btn light-btn"
                                                onclick="showuser7(id);" data-dismiss="modal">Close</button>
                                            <button type="button" class="btn theme-btn ml-3"
                                                id="tenderTechnicalSubmitBtn">Submit</button>
                                        </div>
                                    </div>

                                    <div class="modal-body">


                                        <table id="commonDocTable2" class="table table-striped bg-white dt-scroll"
                                            style="min-width: 100%" align="center">
                                            <thead>
                                                <tr>
                                                    <th>Vendor Attachment</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>
                                                        <div class="col-md-12">
                                                            <input type="file" name="generalsfiles"
                                                                id="generalsfiles" class="input-field py-2 fs-12i">
                                                        </div>
                                                    </td>

                                                </tr>
                                            </tbody>
                                        </table>
                                        <div id="AjaxtenderTechnicalDiv" class="p-1"></div>
                                    </div>
                                </div>
                            </div>


                        </div>
                        <script>
                            

                        </script>
                        <script type="text/javascript">
                            const fileInputs = document.getElementById("generalsfiles");
                            const bootoast2 = window.Bootoast2;

                            // Submit file with FormData
                            document.getElementById('tenderTechnicalSubmitBtn').addEventListener('click', function () {

                                const refNoValue = document.getElementById('tender_no')?.value;
                                if (!fileInputs || fileInputs.files.length === 0) {

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
                                formData.append('policyCount', 1);
                                //            console.log(refNoValue);
                                //            if (refNoValue) {
                                //                formData.append('ref_no', refNoValue);
                                //            }

                                const xhr = new XMLHttpRequest();
                                xhr.open('POST', 'tenderMaster.htm?act=addTechnicalFileDetailsSubmit', true);

                                xhr.onload = function () {
                                    if (xhr.status === 200) {
                                        const uploadedFileNames = fileInputs.files[0].name;
                                        Swal.fire({
                                            icon: 'success',
                                            title: 'Added Attachment Tender Technical Document Successfully.',
                                            timer: 3000,
                                            showConfirmButton: false,
                                            position: 'top'
                                        });
                                        requestDocTenderTechnicalTab();
                                        // Hide modal
                                        // $('#techDocsUpload').modal('hide');
                                        // Reset file input
                                        fileInputs.value = '';
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
                                setupImportTenderTechnicalDocument();
                            });
                            //            function initResultContent() {
                            //          }
                        </script>


                        <script type="text/javascript">

                            var str7 = document.getElementById("refNo1").value;

                            function requestDocTenderTechnicalTab(str) {

                                str = document.getElementById("refNo1").value;

                                var vendorCode = document.getElementById("vendorCode").value;
                                str7 = str;

                                var xreq, ID;
                                if (str == "") {
                                    document.getElementById("AjaxtenderTechnicalDiv").innerHTML = "";
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
                                        document.getElementById("AjaxtenderTechnicalDiv").innerHTML = xreq.responseText;

                                        if ($('#AjaxtenderTechnicalTab').length) {
                                            const table1 = initDocTable('#AjaxtenderTechnicalTab');
                                        }

                                    }
                                }

                                xreq.open("Get", "tenderMaster.htm?act=addTechnicalFileDetails&refNo=" + str7 + "&vendorCode=" + vendorCode, true);
                                xreq.send();
                                window.clearInterval(ID);
                            }

                            var ID = window.setInterval(requestDocTenderTechnicalTab(str7), 1000);
                        </script>


                        <script>
                            $(document).on('click', '.delete-doc-row', function (e) {
                                e.preventDefault();

                                var $row = $(this).closest('tr');
                                var id = $(this).data('id');
                                var fieldOne = $('#pr_no').val();

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
                                            url: 'tenderMaster.htm?act=technicalFileDetailsDelete',
                                            type: 'POST',
                                            data: {
                                                id: id,
                                                ref_no: fieldOne,
                                            },
                                            //                        contentType: 'application/json',
                                            success: function (response) {
                                                Swal.fire({
                                                    icon: 'success',
                                                    title: 'Deleted!',
                                                    text: response.message || 'Record has been deleted.'
                                                });
                                                $('#AjaxtenderTechnicalTab')
                                                    .DataTable()
                                                    .row($row)
                                                    .remove()
                                                    .draw();
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
        <script language="javascript" type="text/javascript">
            function initItemsTable(selector, obj = {}) {
                return $(selector).DataTable({
                    paging: false,
                    lengthChange: false,
                    searching: true,
                    info: true,
                    autoWidth: true,
                    ordering: true,
                    scrollX: true,
                    dom: 't<"table-bottom-info d-flex align-items-center justify-content-between pt-3"i p>',
                    ...obj,
                });
            }
            if ($("#iteamDetailsTab").length) {
              const table1 = initItemsTable("#iteamDetailsTab");
            }

            function techdata(a) {
                var table = $('#iteamDetailsTab').DataTable();
                table.rows().every(function () {
                    var row = this.node();
                    $(row).find('input[type="radio"][value="1"]').prop('checked', true);
                });
            }
            function techdata1(a) {
                var table = $('#iteamDetailsTab').DataTable();
                table.rows().every(function () {
                    var row = this.node();
                    $(row).find('input[type="radio"][value="2"]').prop('checked', true);
                });
            }

//            function techdata(a) {
//                var i1 = 0;
//                var j1 = 1;
//                var k1 = 0;
//                while (i1 < document.myform.vendor_tech_desc.length) {
//                    var cremark1 = '1techradion' + j1;
//                    var cremark2 = '2techradion' + j1;
//                    document.getElementById(cremark1).checked = true;
//                    i1++;
//                    j1++;
//                }
//            }
//
//            function techdata1(a) {
//                var i1 = 0;
//                var j1 = 1;
//                var k1 = 0;
//                while (i1 < document.myform.vendor_tech_desc.length) {
//                    var cremark1 = '1techradion' + j1;
//                    var cremark2 = '2techradion' + j1;
//                    document.getElementById(cremark2).checked = true;
//                    i1++;
//                    j1++;
//                }
//            }

            function termsdata(a) {
                var i1 = 0;
                var j1 = 1;
                var k1 = 0;
                while (i1 < document.myform.vendor_terms_desc.length) {
                    var cremark1 = '1termsradion' + j1;
                    var cremark2 = '2termsradion' + j1;
                    document.getElementById(cremark1).checked = true;

                    i1++;
                    j1++;
                }
            }

            function termsdata1(a) {
                var i1 = 0;
                var j1 = 1;
                var k1 = 0;
                while (i1 < document.myform.vendor_terms_desc.length) {
                    var cremark1 = '1termsradion' + j1;
                    var cremark2 = '2termsradion' + j1;
                    document.getElementById(cremark2).checked = true;

                    i1++;
                    j1++;
                }
            }



                function initItemsVenorTable(selector, obj = {}) {
                              return $(selector).DataTable({
                                  paging: false,
                                  lengthChange: false,
                                  searching: true,
                                  info: true,
                                  autoWidth: true,
                                  ordering: true,
                                  scrollX: true,
                                  dom: 't<"table-bottom-info d-flex align-items-center justify-content-between pt-3"i p>',
                                  ...obj,
                              });
                          }
                          if ($("#AttachmentVendorTable").length) {
                            const table1 = initItemsVenorTable("#AttachmentVendorTable");
                          }





                          function termsdata111(a) {
                  var table = $('#AttachmentVendorTable').DataTable();

                  table.rows().every(function () {
                      var row = this.node();
                      var acceptRadio = row.querySelector('input[id^="buyerAccept"]');
                      if (acceptRadio) {
                          acceptRadio.checked = true;
                      }
                  });
              }


            function termsdata222(a) {
                var table = $('#AttachmentVendorTable').DataTable();
                table.rows().every(function () {
                    var row = this.node();
                    var rejectRadio = row.querySelector('input[id^="buyerReject"]');
                    if (rejectRadio) {
                        rejectRadio.checked = true;
                    }
                });
            }


                        function validation() {
                            // =========================
                            // TECHNICAL TABLE VALIDATION
                            // =========================
                            var techRadios = document.querySelectorAll("input[name^='techradion']");
                            var techNames = [];

                            techRadios.forEach(function (radio) {
                                if (!techNames.includes(radio.name)) {
                                    techNames.push(radio.name);
                                }
                            });

                            for (var i = 0; i < techNames.length; i++) {

                                var selectedTech = document.querySelector(
                                    "input[name='" + techNames[i] + "']:checked"
                                );

                                document.querySelectorAll("input[name='" + techNames[i] + "']").forEach(function (r) {
                                    r.style.outline = "";
                                });

                                if (!selectedTech) {

                                    document.querySelectorAll("input[name='" + techNames[i] + "']").forEach(function (r) {
                                        r.style.outline = "2px solid red";
                                    });

                                    Swal.fire({
                                        icon: 'warning',
                                        title: 'Selection Required',
                                        text: 'Please select Accept or Reject for all Technical items.'
                                    });

                                    document.querySelector("input[name='" + techNames[i] + "']").focus();

                                    event.preventDefault();
                                    return false;
                                }

                                if (selectedTech.value === "2") {

                                    var techRemark = document.getElementById(
                                        "tech_vendor_remark" + (i + 1)
                                    );

                                    techRemark.style.border = "";

                                    if (!techRemark.value.trim()) {

                                        techRemark.style.border = "2px solid red";
                                        techRemark.focus();

                                        Swal.fire({
                                            icon: 'warning',
                                            title: 'Remark Required',
                                            text: 'Please enter Technical Committee Remark.'
                                        });

                                        event.preventDefault();
                                        return false;
                                    }
                                }
                            }


                            // =========================
                            // TERMS TABLE VALIDATION
                            // =========================
                            var termsRadios = document.querySelectorAll("input[name^='termsradion']");
                            var termsNames = [];

                            termsRadios.forEach(function (radio) {
                                if (!termsNames.includes(radio.name)) {
                                    termsNames.push(radio.name);
                                }
                            });

                            for (var j = 0; j < termsNames.length; j++) {

                                var selectedTerms = document.querySelector(
                                    "input[name='" + termsNames[j] + "']:checked"
                                );

                                document.querySelectorAll("input[name='" + termsNames[j] + "']").forEach(function (r) {
                                    r.style.outline = "";
                                });

                                if (!selectedTerms) {

                                    document.querySelectorAll("input[name='" + termsNames[j] + "']").forEach(function (r) {
                                        r.style.outline = "2px solid red";
                                    });

                                    Swal.fire({
                                        icon: 'warning',
                                        title: 'Selection Required',
                                        text: 'Please select Accept or Reject for all Terms items.'
                                    });

                                    document.querySelector("input[name='" + termsNames[j] + "']").focus();

                                    event.preventDefault();
                                    return false;
                                }

                                if (selectedTerms.value === "2") {

                                    var termsRemark = document.getElementById(
                                        "terms_vendor_remark" + (j + 1)
                                    );

                                    termsRemark.style.border = "";

                                    if (!termsRemark.value.trim()) {

                                        termsRemark.style.border = "2px solid red";
                                        termsRemark.focus();

                                        Swal.fire({
                                            icon: 'warning',
                                            title: 'Remark Required',
                                            text: 'Please enter Technical Committee Remark.'
                                        });

                                        event.preventDefault();
                                        return false;
                                    }
                                }
                            }


                            // =========================
                            // ATTACHMENT TABLE VALIDATION
                            // =========================
                            var attachRadios = document.querySelectorAll("input[name^='buyerAccept']");
                            var attachNames = [];

                            attachRadios.forEach(function (radio) {
                                if (!attachNames.includes(radio.name)) {
                                    attachNames.push(radio.name);
                                }
                            });

                            for (var k = 0; k < attachNames.length; k++) {

                                var selectedAttach = document.querySelector(
                                    "input[name='" + attachNames[k] + "']:checked"
                                );

                                document.querySelectorAll("input[name='" + attachNames[k] + "']").forEach(function (r) {
                                    r.style.outline = "";
                                });

                                if (!selectedAttach) {

                                    document.querySelectorAll("input[name='" + attachNames[k] + "']").forEach(function (r) {
                                        r.style.outline = "2px solid red";
                                    });

                                    Swal.fire({
                                        icon: 'warning',
                                        title: 'Selection Required',
                                        text: 'Please select Accept or Reject for all Attachments.'
                                    });

                                    document.querySelector("input[name='" + attachNames[k] + "']").focus();

                                    event.preventDefault();
                                    return false;
                                }

                                if (selectedAttach.value === "2") {

                                    var buyerRemark = document.getElementById(
                                        "buyerRemark" + (k + 1)
                                    );

                                    buyerRemark.style.border = "";

                                    if (!buyerRemark.value.trim()) {

                                        buyerRemark.style.border = "2px solid red";
                                        buyerRemark.focus();

                                        Swal.fire({
                                            icon: 'warning',
                                            title: 'Remark Required',
                                            text: 'Please enter Attachment Remark.'
                                        });

                                        event.preventDefault();
                                        return false;
                                    }
                                }
                            }
                 var i1 = 0;
                 var j1 = 1;
                 var k1 = 0;
                 while (i1 < document.myform.vendorDescription.length) {
                     var cremark1 = 'buyerAccept' + j1;
                     var cremark2 = 'buyerReject' + j1;

                     var vvv = 'buyerRemark' + j1
                     if (document.getElementById(cremark1).checked != true && document.getElementById(cremark2).checked != true) {
                         swal("Error", "Please Select Buyer Response Specification", "warning");
                         return false;
                     }
                     if (document.getElementById(cremark1).checked == false) {
                         if (document.getElementById(vvv).value == '') {
                             swal("Error", "Please add buyer remark", "warning");
                             return false;
                         }
                     }

                     var vvv1 = 'vendor_tech_attach' + j1
                     var vvv2 = '1vendor_tech_comp' + j1
                     if (document.getElementById(vvv2).value == 'Yes') {
                         if (document.getElementById(vvv1).value == '0' || document.getElementById(vvv1).value == '') {
                             swal("Error", "Please attach document", "warning");
                             return false;
                         }
                     }

                     i1++;
                     j1++;
                 }

                 i1 = 0;
                 j1 = 1;
                 k1 = 0;
                 while (i1 < document.myform.vendor_tech_desc.length) {
                     var cremark1 = '1techradion' + j1;
                     var cremark2 = '2techradion' + j1;

                     var vvv = 'tech_vendor_remark' + j1
                     if (document.getElementById(cremark1).checked != true && document.getElementById(cremark2).checked != true) {
                         swal("Error", "Please Select Technical Specification", "warning");
                         return false;
                     }
                     if (document.getElementById(cremark1).checked == false) {
                         if (document.getElementById(vvv).value == '') {
                             swal("Error", "Please add remark", "warning");
                             return false;
                         }
                     }

                     var vvv1 = 'vendor_tech_attach' + j1
                     var vvv2 = '1vendor_tech_comp' + j1
                     if (document.getElementById(vvv2).value == 'Yes') {
                         if (document.getElementById(vvv1).value == '0' || document.getElementById(vvv1).value == '') {
                             swal("Error", "Please attach document", "warning");
                             return false;
                         }
                     }

                     i1++;
                     j1++;
                 }

                 i1 = 0;
                 j1 = 1;
                 k1 = 0;
                 while (i1 < document.myform.vendor_terms_desc.length) {
                     var cremark1 = '1termsradion' + j1;
                     var cremark2 = '2termsradion' + j1;
                     var vvv = 'terms_vendor_remark' + j1
                     if (document.getElementById(cremark1).checked != true && document.getElementById(cremark2).checked != true) {
                         swal("Error", "Please Select Terms & Condition", "warning");
                         return false;
                     }
                     if (document.getElementById(cremark1).checked == false) {
                         if (document.getElementById(vvv).value == '') {
                             swal("Error", "Please add remark", "warning");
                             return false;
                         }
                     }

                     var vvv1 = 'vendor_terms_attach' + j1
                     var vvv2 = '1vendor_terms_comp' + j1
                     if (document.getElementById(vvv2).value == 'Yes') {
                         if (document.getElementById(vvv1).value == '0' || document.getElementById(vvv1).value == '') {
                             swal("Error", "Please attach document", "warning");
                             return false;
                         }
                     }

                     i1++;
                     j1++;
                 }
             }

        </script>
        <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp" %>

    </html>