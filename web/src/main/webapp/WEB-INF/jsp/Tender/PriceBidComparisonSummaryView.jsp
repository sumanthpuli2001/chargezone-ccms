
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tender Price Comparison</title>
    </head>
    <style>
        .buyer-info .form-group p {
    white-space: normal;
    overflow-wrap: anywhere;
}
    </style>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="" commandName="departmentMaster" method="post">

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Tender Price Comparison</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                            <a  class="btn theme-btn mr-3" href="tenderMaster.htm?act=priceBidComparisonSummaryExport&refNo=${refNo}&pageNo=${pageNo}&next=sub">Export To Excel</a>
                            <a class="btn theme-btn" href="tenderMaster.htm?act=priceBidComparisonSummaryViewPrint&refNo=${refNo}" class="btn btn-primary" onclick="printCustom()" title="Print this page">
                                <i class="fa fa-arrow-right"></i>&nbsp;&nbsp;Print
                            </a>
                        </div>
                    </div>

                    <br>
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

                    <h5 class="fw-600">Vendor information</h5>
                    <hr>
                    <table id="commonNoPageTable" class="table table-striped bg-white" style="width: 100%" align="Center"  >
                        <thead>
                            <tr data-dt-order="disable">
                                <th>Vendor Code</th>
                                <th>Contact Person</th>
                                <th>Contact Email Id</th>
                                <th>Contact No.</th>
                                <th>Quotation No.</th>
                                <th>Grand Total</th>
                                <th>Rank</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach var="list1" items="${list4}" varStatus="status">
                                <tr>
                                    <td>${list1.vendorCode}</td>
                                    <td>${list1.contactPerson}</td>
                                    <td>${list1.conactEmail}</td>
                                    <td>${list1.contactNo}</td>
                                    <td>${list1.offerNo}</td>
                                    <td class="currency">${list1.finalTotal}</td>
                                    <td> ${status.count}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    
                </form:form>
            </section>
        </main>
        <script>
          CurrencyHandler.init({ currency: '${prMaster.currency}' });
        </script>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
