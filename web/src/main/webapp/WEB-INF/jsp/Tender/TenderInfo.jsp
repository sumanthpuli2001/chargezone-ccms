
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tender Info</title>
    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action=".htm?act=" commandName="departmentMaster" method="post">

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Tender Info- ${tenderPhase} Part Tender Information</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                        </div>
                    </div>

                    <hr>

                    <div class="rounded-4 mt-4"> 
                        <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                            <div class="row buyer-info">
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Tender No</label>
                                        <p class="fw-600">${tenderMaster.type}</p>

                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Tender Reference No</label>
                                        <p class="fw-600">${tenderMaster.refNo}</p>

                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Title </label>
                                        <p class="fw-600">${tenderMaster.title}</p>

                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Tender Value </label>
                                        <p class="fw-600">${tenderMaster.value}</p>

                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Tender classification </label>
                                        <p class="fw-600">${tenderMaster.categoryId}</p>

                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Tender Fee</label>
                                        <p class="fw-600">${tenderMaster.docCost}</p>

                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Tender EMD</label>
                                        <p class="fw-600">${tenderMaster.emd}</p>

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
                                        <label>Tender Date</label>
                                        <p class="fw-600">${tenderMaster.announceDate}</p>

                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Tender Due  Date</label>
                                        <p class="fw-600">${tenderMaster.submitLastdate}</p>

                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Tender Subject Description</label>
                                        <p class="fw-600">${tenderMaster.workDesc}</p>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <h5 class="fw-600">Tender Contact Person</h5>
                    <div class="rounded-4 mt-4"> 
                        <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                            <div class="row buyer-info">
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Created By </label>
                                        <p class="fw-600">${tenderMaster.contactPerson}</p>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <h5 class="fw-600">Item Details</h5>

                    <table id="commonTable1" class="table table-striped bg-white" style="width: 100%" align="Center"  >
                        <thead>
                            <tr>
                                <th>Sr. No.</th>
                                <th> Item Code</th>
                                <th> Item Description</th>
                                <th> Remark</th>
                                <th> UoM</th>
                                <th> Quantity</th>
                                <th> Item Details</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="tenderItemMaster" items="${tenderItemMaster}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${tenderItemMaster.itemCode}</td>
                                    <td>${tenderItemMaster.itemDescription}</td>
                                    <td>${tenderItemMaster.remark}</td>
                                    <td>${tenderItemMaster.uom}</td>
                                    <td>${tenderItemMaster.qty}</td>
                                    <td>${tenderItemMaster.deliveryScheduleQty}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                    <h5 class="fw-600">Tender Attachment</h5>

                    <table id="commonDocTable" class="table  table-striped bg-white dt-scroll" style="width: 100%" align="Center"  >
                        <thead>                    
                            <tr>
                                <th >Sr.No</th>
                                <th >Attachment</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="generalDocs" items="${generalDocs}" varStatus="status">
                                <tr>
                                    <td>
                                        ${status.count}
                                    </td>
                                    <td>
                                        <a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=downloadTenderFile&amp;fileName=${generalDocs.document}&RefNo=${refNo}">${generalDocs.document}</a>
                                    </td>
                                </tr>
                            </tbody>
                        </c:forEach>
                    </table>


                    <h5 class="fw-600">Tender Additional Document</h5>

                    <table id="commonDocTable1" class="table  table-striped bg-white dt-scroll" style="width: 100%" align="Center"  >
                        <thead>                    
                            <tr>
                                <th >Sr.No</th>
                                <th >Attachment</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="additionalDocs" items="${additionalDocs}" varStatus="status">
                                <tr>
                                    <td>
                                        ${status.count}
                                    </td>
                                    <td>
                                        <a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=downloadTenderFile&amp;fileName=${additionalDocs.document}&RefNo=${refNo}">${additionalDocs.document}</a>
                                    </td>
                                </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                    <h5 class="fw-600">Tender Technical Document</h5>

                    <table id="commonDocTable2" class="table  table-striped bg-white dt-scroll" style="width: 100%" align="Center"  >
                        <thead>                    
                            <tr>
                                <th >Sr.No</th>
                                <th >Attachment</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="technicalDocs" items="${technicalDocs}" varStatus="status">
                                <tr>
                                    <td>
                                        ${status.count}
                                    </td>
                                    <td>
                                        <a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=downloadTenderFile&amp;fileName=${technicalDocs.document}&RefNo=${refNo}">${technicalDocs.document}</a>
                                    </td>
                                </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                    <h5 class="fw-600">Vendor Details</h5>
                    <table id="commonTable" class="table  table-striped bg-white" style="width: 100%" align="Center"  >
                        <thead>
                            <tr>

                                <th style="min-width: 230px;">Code</th>
                                <th style="min-width: 230px;">Name</th>
                                <th style="min-width: 230px;" >Address</th>
                                <th style="min-width: 180px;">E-mail ID</th>
                                <th style="min-width: 230px;">Mobile No.</th>

                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach var="tenderVendor" items="${tenderVendor}" varStatus="status">
                                <tr>

                                    <td>${tenderVendor.vendorCode}</td>
                                    <td>${tenderVendor.vendorName}</td>
                                    <td>${tenderVendor.address}</td>
                                    <td>${tenderVendor.emailId}
                                        <input type="hidden" class="form-control" name="vendor_code" value="${tenderVendor.vendorCode}">
                                    </td>
                                    <td>${tenderVendor.mobileNo}</td>

                                </tr>
                            </c:forEach>
                        </tbody>


                    </table>

                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
