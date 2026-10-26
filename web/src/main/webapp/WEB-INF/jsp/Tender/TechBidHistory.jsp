
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VENDER TECHNICAL VIEW</title>
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

                            <h5 class="fw-600 mb-0">VENDER TECHNICAL VIEW</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                        </div>
                    </div>

                    <br>
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
                                        <p class="fw-600">${vendorCode}</p>
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


                            </div>
                        </div>  
                    </div>
                    
                    <h5 class="fw-600">Vendor Item Details</h5>
                    <hr>
                    <table id="commonTable" class="table  table-striped bg-white" style="width: 100%" align="Center"  >
                        <thead>
                            <tr>

                                <th>Bid Details</th>
                                <th data-dt-order="disable">View</th>

                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach var="reviseVendorTechnicalBid" items="${reviseVendorTechnicalBid}" >
                                <tr>
                                    <td>${reviseVendorTechnicalBid.dateTime}</td>
                                    <td><a href="tenderMaster.htm?act=techBidHistoryView&refNo=${refNo}&vendorCode=${vendorCode}&rid=${reviseVendorTechnicalBid.id}">View</a></td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td>Original Bid</td>
                                <td><a href="tenderMaster.htm?act=techBidHistoryView&refNo=${refNo}&vendorCode=${vendorCode}&rid=0">View</a></td>
                            </tr>
                        </tbody>
                    </table>


                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
