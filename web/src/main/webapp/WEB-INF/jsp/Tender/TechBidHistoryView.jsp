
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendor Technical View</title>
    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="vendor.htm?act=techBidAccept" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                           name="form"  class="form-horizontal" role="form" onsubmit="return validation();">


                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Vendor Technical View</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                        </div>
                    </div>

                    <hr>
                    <input type="hidden" name="id" value="${id}">
                    <input type="hidden" name="refNo" value="${refNo}">
                    <input type="hidden" name="vendorCode" value="${vendorCode}">    



                    <h5 class="fw-600">Tender information</h5>     
                    <hr>
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
                                <div class="col-xxl-2 col-lg-3 col-md-8 pb-1">
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
                                        <label>Tender Location</label>
                                        <p class="fw-600">${tenderMaster.location}</p>
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
                                        <label>Tender Two Phase Remark</label>
                                        <p class="fw-600">${technicalRemark}</p>
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

                    <h5 class="fw-600">Vendor Attachment - ${vendorAttachment.size()}</h5> 
                    <hr>
                    <table id="commonDocTable" class="table table-striped bg-white dt-scroll" style="min-width: 100%" align="Center"  >
                        <c:forEach var="vendorAttachment" items="${vendorAttachment}" varStatus="status">
                            <tr>
                                <td><a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=downloadTenderVendorFile&amp;fileName=${vendorAttachment.attachment}&RefNo=${refNo}&vendor_code=${vendorCode}">${vendorAttachment.attachment}</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    
                    <c:choose>
                        <c:when test="${empty vendorTechnicalBidTech}">

                        </c:when>
                        <c:otherwise>

                            <h5 class="fw-600">Item Details</h5>   

                            <hr>
                            <table id="commonNoPageTable" class="table  table-striped bg-white" style="width: 100%" align="Center"  >
                                <thead>
                                    <tr>
                                        <th>Sr. No.</th>
                                        <th style="min-width: 530px;">Item Description</th>
                                        <th style="min-width: 230px;">Item Details</th>
                                        <th style="min-width: 230px;"> Attachment Required</th>
                                        <th> Vendor Response</th>
                                        <th style="min-width: 230px;"> Remark</th>
                                        <th data-dt-order="disable" > Accept</th>
                                        <th data-dt-order="disable"> Reject</th>
                                        <th data-dt-order="disable" style="min-width: 180px;"> Buyer Remark</th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <c:forEach var="vendorTechnicalBidTech" items="${vendorTechnicalBidTech}" varStatus="status">
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
                                            <td>
                                                <c:if test="${vendorTechnicalBidTech.buyerResponse == 1}">
                                                    <input type="radio" name="techradion${status.count}" id="1techradion${status.count}" value="1" checked  disabled/> 
                                                </c:if>
                                                <c:if test="${vendorTechnicalBidTech.buyerResponse != 1}">
                                                    <input type="radio" name="techradion${status.count}" id="1techradion${status.count}" value="1" disabled/> 
                                                </c:if>

                                            </td>
                                            <td>
                                                <c:if test="${vendorTechnicalBidTech.buyerResponse == 2}">
                                                    <input type="radio" name="techradion${status.count}" id="1techradion${status.count}" value="2" checked  disabled/> 
                                                </c:if>
                                                <c:if test="${vendorTechnicalBidTech.buyerResponse != 2}">
                                                    <input type="radio" name="techradion${status.count}" id="1techradion${status.count}" value="2" disabled /> 
                                                </c:if>

                                            </td>
                                            <td>
                                                <textarea type="text" name="tech_vendor_remark${status.count}" id="tech_vendor_remark${status.count}" value="${vendorTechnicalBidTech.buyerRemark}" class="textarea-field" readonly="true" >    </textarea>
                                            </td>

                                    <input type="hidden" name="vendor_tech_desc" id="vendor_tech_desc" value="${vendorTechnicalBidTech.description}" class="form-control" />
                                    <input type="hidden" name="vendor_tech_remark" id="vendor_tech_remark" value="${vendorTechnicalBidTech.details}" class="form-control" />
                                    <input type="hidden" name="vendor_tech_comp" id="vendor_tech_comp" value="${vendorTechnicalBidTech.attachmentRequired}" class="form-control" >
                                    <input type="hidden" name="1vendor_tech_comp${status.count}" id="1vendor_tech_comp${status.count}" value="${vendorTechnicalBidTech.attachmentRequired}" class="form-control" >

                                    <input type="hidden" name="tech_sr_no" id="vendor_terms_desc" value="${vendorTechnicalBidTech.srNo}" class="form-control" />
                                    <input type="hidden" name="tech_item_code" id="vendor_terms_desc" value="${vendorTechnicalBidTech.itemCode}" class="form-control" />
                                    <input type="hidden" name="tech_uom" id="vendor_terms_desc" value="${vendorTechnicalBidTech.uom}" class="form-control" />
                                    <input type="hidden" name="tech_qty" id="vendor_terms_desc" value="${vendorTechnicalBidTech.qty}" class="form-control" />

                                    </tr>
                                </c:forEach>

                                </tbody>


                            </table>

                        </c:otherwise>
                    </c:choose>

                    <c:choose>
                        <c:when test="${empty vendorTechnicalBidTerms}"></c:when>
                        <c:otherwise>
                            <br>
                            <h5 class="fw-600">Item Details For Service</h5> 
                            <hr>
                            <div class="table-responsive">
                                <table id="commonNoPageTable0" class="table  table-striped bg-white" style="min-width: 100%" align="Center"  >
                                    <thead>
                                        <tr>
                                            <th> Sr. No.</th>
                                            <th style="min-width: 530px;"> Item Description</th>
                                            <th style="min-width: 230px;"> Item Details</th>
                                            <th style="min-width: 230px;"> Attachment Required</th>
                                            <th> Vendor Response</th>
                                            <th style="min-width: 230px;"> Remark</th>
                                            <th data-dt-order="disable" > Accept</th>
                                            <th data-dt-order="disable" > Reject</th>
                                            <th data-dt-order="disable" > Buyer Remark</th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                        <c:forEach var="vendorTechnicalBidTerms" items="${vendorTechnicalBidTerms}" varStatus="status">
                                            <tr>
                                                <td> ${status.count}</td>
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
                                                        <input type="radio" name="termsradion${status.count}" id="1techradion${status.count}" value="1" checked  disabled /> 
                                                    </c:if>
                                                    <c:if test="${vendorTechnicalBidTerms.buyerResponse != 1}">
                                                        <input type="radio" name="termsradion${status.count}" id="1techradion${status.count}" value="1" disabled /> 
                                                    </c:if>

                                                </td>
                                                <td>
                                                    <c:if test="${vendorTechnicalBidTerms.buyerResponse == 2}">
                                                        <input type="radio" name="termsradion${status.count}" id="1techradion${status.count}" value="2" checked  disabled/> 
                                                    </c:if>
                                                    <c:if test="${vendorTechnicalBidTerms.buyerResponse != 2}">
                                                        <input type="radio" name="termsradion${status.count}" id="1techradion${status.count}" value="2" disabled /> 
                                                    </c:if>

                                                </td>
                                                <td>
                                                    <input type="text" name="terms_vendor_remark${status.count}" id="tech_vendor_remark${status.count}" value="${vendorTechnicalBidTerms.buyerRemark}" class="form-control" >    
                                                </td>

                                        <input type="hidden" name="vendor_terms_desc" id="vendor_terms_desc" value="${vendorTechnicalBidTerms1.itemDescription}" class="form-control" />
                                        <input type="hidden" name="vendor_terms_remark" id="vendor_terms_remark" value="${vendorTechnicalBidTerms1.remark}" class="form-control" />
                                        <input type="hidden" name="vendor_terms_comp" id="vendor_terms_comp" value="${vendorTechnicalBidTerms1.uom}" class="form-control" >
                                        <input type="hidden" name="1vendor_terms_comp${status.count}" id="1vendor_terms_comp${status.count}" value="${vendorTechnicalBidTerms1.uom}" class="form-control" >
                                        <input type="hidden" name="terms_sr_no" id="vendor_terms_desc" value="${vendorTechnicalBidTerms1.srNo}" class="form-control" />
                                        <input type="hidden" name="terms_item_code" id="vendor_terms_desc" value="${vendorTechnicalBidTerms1.itemCode}" class="form-control" />
                                        <input type="hidden" name="terms_uom" id="vendor_terms_desc" value="${vendorTechnicalBidTerms1.uom}" class="form-control" />
                                        <input type="hidden" name="terms_qty" id="vendor_terms_desc" value="${vendorTechnicalBidTerms1.qty}" class="form-control" />
                                        <input type="hidden" name="buyer_terms_response" id="vendor_terms_desc" value="${buyerResponse}" class="form-control" />
                                        <input type="hidden" name="buyer_terms_remark" id="vendor_terms_desc" value="${buyerremark}" class="form-control" />
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </c:otherwise>
                    </c:choose>
                        <br>
                        <h5 class="fw-600">Attachment By Vendor</h5>
                        <hr>

                        <table id="commonTable2" class="table table-striped  bg-white" style="min-width: 100%" align="Center"  >
                            <thead>
                                <tr>
                                    <th> Sr. No.</th>
                                    <th> Item Description</th>
                                    <th> Attachment Required</th>
                                    <th data-dt-order="disable"> Attachment</th>
                                </tr>
                            </thead>
                            <tbody>

                            <c:forEach var="vendorTechnicalBidAttachment" items="${vendorTechnicalBidAttachment}" varStatus="status">
                                <tr>
                                    <td> ${status.count}</td>
                                    <td>${vendorTechnicalBidAttachment.description}</td>
                                    <td>${vendorTechnicalBidAttachment.attachmentRequired}</td>
                                    <td><a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=downloadTenderVendorFile&amp;fileName=${vendorTechnicalBidAttachment.attachment}&RefNo=${refNo}&vendor_code=${vendorCode}">${vendorTechnicalBidAttachment.attachment}</a></td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <br>
                    <h5 class="fw-600"> Vendor Remark For Technical</h5>   
                    <hr>
                    <table id="commonDocTable1" class="table  table-striped bg-white dt-scroll" style="min-width: 100%" align="Center"  >
                        <thead>
                            <tr>
                                <c:if test="${technicalBidDeviation != ''}">
                                    <th>Deviation</th>
                                </c:if>
                                <th>Remark</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>                                
                                <c:if test="${technicalBidDeviation != ''}">
                                    <td>
                                        ${technicalBidDeviation}
                                    </td>  
                                </c:if>
                                <td>${technicalBidRemark}</td>
                            </tr>
                        </tbody>                       
                    </table>
                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
