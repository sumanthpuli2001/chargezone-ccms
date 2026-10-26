<%-- 
    Document   : closeprview
    Created on : Feb 16, 2026, 11:44:18 AM
    Author     : Sumanth
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Close PR View</title>
    </head>

    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form class="form-horizontal" role="form1" action="prMaster.htm?act=closePrSubmit" method="post" enctype="multipart/form-data" name='form' onsubmit='return saveSubmit11();'>

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Close PR View</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>

                        </div>
                    </div>
                    <input type="hidden" name="id"  value="${id}" />
                    
                    <h6 class="fw-600 mt-3">Close Pr Details</h6>
                    <hr>

                    <div class="rounded-4 mt-4"> 
                        <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                            <div class="row buyer-info">
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>PR Reference No</label>
                                        <p class="fw-600">${prMaster.prNo}</p>

                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Item Category</label>
                                        <p class="fw-600">${prMaster.type}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-8 pb-1">
                                    <div class="form-group">
                                        <label>PR classification</label>
                                        <p class="fw-600">${prMaster.categoryId}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Project Name</label>
                                        <p class="fw-600">${prMaster.title}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Project ID</label>
                                        <p class="fw-600">${prMaster.projectId}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>PR Subject Description</label>
                                        <p class="fw-600">${prMaster.workDesc}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Plant</label>
                                        <p class="fw-600">${prMaster.plant}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Billing Location</label>
                                        <p class="fw-600">${prMaster.billingLocation}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>PR Date</label>
                                        <p class="fw-600">${prMaster.announceDate}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Created By</label>
                                        <p class="fw-600">${prMaster.contactPerson}</p>

                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Created Contact Number</label>
                                        <p class="fw-600">${prMaster.prAdminContactNumber}</p>
                                    </div>
                                </div>     
                                <div class="col-xxl-2 col-lg-3 col-md-8 pb-1">
                                    <div class="form-group">
                                        <label>Technical Person Name</label>
                                        <p class="fw-600">${prMaster.technicalContactName}</p>
                                    </div>
                                </div>    
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Technical Person Contact No</label>
                                        <p class="fw-600">${prMaster.technicalContactNo}</p>
                                    </div>
                                </div>   
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>PR Estimate Cost With GST</label>
                                        <p class="fw-600">${prMaster.value}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Min Quotes Required</label>
                                        <p class="fw-600">${prMaster.quotes}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Business Type</label>
                                        <p class="fw-600">${prMaster.businessType}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Project Type</label>
                                        <p class="fw-600">${prMaster.projectType}</p>
                                    </div>
                                </div>
                            </div>
                        </div>  
                    </div>


                    <h6 class="fw-600">Close Pr Details</h6>
                    <hr>
                    <div class="rounded-4 mt-4"> 
                        <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                            <div class="row buyer-info">
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Po No</label>
                                        <p class="fw-600">${closePr.tenderNo}</p>

                                    </div>
                                </div>

                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Vendor Detail</label>
                                        <p class="fw-600">${closePr.vendorDetail}</p>

                                    </div>
                                </div>

                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Remark</label>
                                        <p class="fw-600">${closePr.remark}</p>

                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Closed By</label>
                                        <p class="fw-600">${closePr.closedBy}</p>

                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Date And Time</label>
                                        <p class="fw-600">${closePr.dateTime}</p>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <h6 class="fw-600">Close Pr Attachments</h6>
                    <hr>
                    <div class="table-responsive">

                        <table id="commonNoPageTable0" class="table table-striped bg-white" style="width:100%">
                            <thead >
                                <tr>
                                    <th>Sr. No.</th>
                                    <th>Attachment</th>
                                </tr>
                            <thead> 
                            <tbody>
                                <c:set var="count" value="0" scope="page" />
                                <c:forEach var="closeprAttchment" items="${closeprAttchment}" varStatus="status">
                                    <tr>
                                        <td >${status.count}</td>
                                        <td>
                                            <a class="fw-600 text-break gradient-text"
                                               href="prMaster.htm?act=downloadPrFile&fileName=${closeprAttchment.attachment}&RefNo=${prMaster.prNo}">
                                                ${closeprAttchment.attachment}
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>               

                    </div>


                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>

