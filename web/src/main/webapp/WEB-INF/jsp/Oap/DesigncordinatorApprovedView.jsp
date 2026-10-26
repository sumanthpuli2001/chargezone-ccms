
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delivery Details</title>
    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="oapForm.htm?act=DesigncoordinatorApprovalViewsubmit" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                           class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Delivery Details</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                            <a href="oapForm.htm?act=DesigncordinatorPrint&id=${id}" class="btn theme-btn" onclick="printCustom()" title="Print this page">
                                Print
                            </a>  
                        </div>
                    </div>

                    <hr>
                    <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                    <input type="hidden" name="id" value="${id}">
                    <input type="hidden" name="id1" value="${list2.id}">
                    <input type="hidden" name="id2" value="${list3.id}">


                    <c:if test="${list3.id == 0}">
                        <h6>OAP Form Details</h6>
                        <div class="rounded-4 mt-4"> 
                            <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                                <div class="row buyer-info">
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Document No</label>
                                            <p class="fw-600">${list2.documentNo}</p>

                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Pcs Name</label>
                                            <p class="fw-600">${list2.pcsName}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-8 pb-1">
                                        <div class="form-group">
                                            <label>Project Name</label>
                                            <p class="fw-600">${list2.projectName}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Pcs CoOrdinates</label>
                                            <p class="fw-600">${list2.pcsCoordinates}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Client Name</label>
                                            <p class="fw-600">${list2.mobileNo}</p>
                                        </div>
                                    </div>

                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Department</label>
                                            <p class="fw-600">${list2.department}</p>
                                        </div>
                                    </div>  

                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Date</label>
                                            <p class="fw-600">${list2.createdDate}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>  
                        </div> 


                        <div class="rounded-4 mt-4"> 
                            <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                                <div class="row buyer-info">
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Document No</label>
                                            <p class="fw-600">${crcForm.documentNo}</p>

                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Pcs Name</label>
                                            <p class="fw-600">${crcForm.pcsName}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-8 pb-1">
                                        <div class="form-group">
                                            <label>PCS Drawing Number </label>
                                            <p class="fw-600">${crcForm.pcsDrawingNumber}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Prepared By</label>
                                            <p class="fw-600">${crcForm.preparedBy}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Scope Of Work</label>
                                            <p class="fw-600">${crcForm.scopeWork}</p>
                                        </div>
                                    </div>

                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Designation</label>
                                            <p class="fw-600">${crcForm.designation}</p>
                                        </div>
                                    </div>  


                                </div>
                            </div>  
                        </div>                    

                    </c:if>

                    <c:if test="${list2.id == 0}">
                        <h6>AOC Form Details</h6>
                        <div class="rounded-4 mt-4"> 
                            <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                                <div class="row buyer-info">
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Document Number</label>
                                            <p class="fw-600">${list3.documentNo}</p>

                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Depo.Name</label>
                                            <p class="fw-600">${list3.hubDepoName}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-8 pb-1">
                                        <div class="form-group">
                                            <label>Project Name</label>
                                            <p class="fw-600">${list3.clientProjectName}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Created By</label>
                                            <p class="fw-600">${list3.userId}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Client Name</label>
                                            <p class="fw-600">${list3.mobileNo}</p>
                                        </div>
                                    </div>

                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Date</label>
                                            <p class="fw-600">${list3.createdDate}</p>
                                        </div>
                                    </div>  


                                </div>
                            </div>  
                        </div> 

                        <h6>KICKOFF Form Details</h6>    

                        <div class="rounded-4 mt-4"> 
                            <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                                <div class="row buyer-info">
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Document No</label>
                                            <p class="fw-600">${kickOffForm.documentNo}</p>

                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Hub Location</label>
                                            <p class="fw-600">${kickOffForm.hubLocation}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-8 pb-1">
                                        <div class="form-group">
                                            <label>Project Name</label>
                                            <p class="fw-600">${kickOffForm.projectName}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Designation</label>
                                            <p class="fw-600">${kickOffForm.designation}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Date & Time</label>
                                            <p class="fw-600">${kickOffForm.dateTime}</p>
                                        </div>
                                    </div>




                                </div>
                            </div>  
                        </div>          


                    </c:if>


                    <table id="commonTable" class="table  table-striped bg-white" style="  max-width: 100%;" align="center">
                        <thead>
                            <tr>
                                <th>Sr No</th>
                                <th>Survey No</th>
                                <th>Project Representative</th>
                            </tr>
                        </thead>

                        <tbody>

                            <c:forEach var="oapSurveyAttch" items="${oapSurveyAttch}" varStatus="status">
                                <tr>
                                    <td >${status.count}</td>
                                    <td><a class="fw-600 text-break gradient-text" href="oapForm.htm?act=siteSurveyView&id=${oapSurveyAttch.surveyNo}">${oapSurveyAttch.surveyNo}</a></td>
                                    <td >${oapSurveyAttch.projectRepresentative}</td>

                                </tr>
                            </c:forEach>


                        </tbody>



                    </table>                         

                    <c:if test="${Contract1.size()>0}">
                        <h6>Item Details5555</h6>
                       
                            <table id="commonTable4" class="table table-striped bg-white" style="min-width: 100%" align="Center">
                                <thead>
                                    <tr>
                                        <th>Sr.No</th>
                                        <th style="min-width: 230px;">Item Code</th>
                                        <th style="min-width: 230px;">Item Description</th>
                                        <th style="min-width: 230px;">Purpose</th>
                                        <th>Make</th>
                                        <th>UOM</th>
                                        <th>Qty</th>
                                        <th>Account Category</th>
                                        <th>Account Value</th>
                                        <th>Product Type</th>
                                        <th>Product Group</th>
                                        <th>Tax Code</th>
                                        <th>Price</th>
                                        <th style="min-width: 230px;">Delivery Date</th>
                                        <th style="min-width: 230px;">Start Date</th>
                                        <th style="min-width: 230px;">End Date</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="iteam" items="${list7}" varStatus="status">
                                        <tr>
                                            <td>${iteam.sno}</td> <!-- Using index for serial number -->
                                            <td>${iteam.iteamCode}</td>
                                            <td>${iteam.iteamDescription}</td>
                                            <td>${iteam.purpose}</td>
                                            <td>${iteam.make}</td>
                                            <td>${iteam.uom}</td>
                                            <td>${iteam.qty}</td>
                                            <td>${iteam.accountCategory}</td>
                                            <td>${iteam.accountValue}</td>
                                            <td>${iteam.productType}</td>
                                            <td>${iteam.productGroup}</td>
                                            <td>${iteam.taxCode}</td>
                                            <td>${iteam.price}</td>
                                            <td>${iteam.deliveryDate}</td>
                                            <td>${iteam.startDate}</td>
                                            <td>${iteam.endDate}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                       


                    </c:if>

                    <c:if test="${GoodsContract4.size()>0}">
                        <h6 >Item Details For Service</h6>


                        <table id="commonTable1" class="table table-striped bg-white" style="min-width: 100%" align="Center">
                            <thead>
                                <tr>
                                    <th>Sr.No</th>
                                    <th style="min-min-width: 230px;">Item Code</th>
                                    <th style="min-width: 230px;">Item Description</th>
                                    <th style="min-min-width: 230px;">Purpose</th>
                                    <th>Make</th>
                                    <th>UOM</th>
                                    <th>Qty</th>
                                    <th>Account Category</th>
                                    <th>Account Value</th>
                                    <th>Product Type</th>
                                    <th>Product Group</th>
                                    <th>Tax Code</th>
                                    <th>Price</th>
                                    <th style="min-min-width: 230px;">Delivery Date</th>
                                    <th style="min-min-width: 230px;">Start Date</th>
                                    <th style="min-min-width: 230px;">End Date</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="iteam" items="${list5}" varStatus="status">
                                    <tr>
                                        <td>${iteam.sno}</td> <!-- Using index for serial number -->
                                        <td>${iteam.iteamCode}</td>
                                        <td>${iteam.iteamDescription}</td>
                                        <td>${iteam.purpose}</td>
                                        <td>${iteam.make}</td>
                                        <td>${iteam.uom}</td>
                                        <td>${iteam.qty}</td>
                                        <td>${iteam.accountCategory}</td>
                                        <td>${iteam.accountValue}</td>
                                        <td>${iteam.productType}</td>
                                        <td>${iteam.productGroup}</td>
                                        <td>${iteam.taxCode}</td>
                                        <td>${iteam.price}</td>
                                        <td>${iteam.deliveryDate}</td>
                                        <td>${iteam.startDate}</td>
                                        <td>${iteam.endDate}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>


                    </c:if>
                    <c:if test="${Goods.size()>0}">
                        <h6 >Item Details</h6>

                        <table id="commonTable2" class="table table-striped bg-white" style="min-width: 100%" align="Center">
                            <thead>
                                <tr>
                                    <th>Sr.No</th>
                                    <th style="min-min-width: 230px;">Item Code</th>
                                    <th style="min-width: 230px;">Item Description</th>
                                    <th style="min-min-width: 230px;">Purpose</th>
                                    <th>Make</th>
                                    <th>UOM</th>
                                    <th>Qty</th>
                                    <th>Account Category</th>
                                    <th>Account Value</th>
                                    <th>Product Type</th>
                                    <th>Product Group</th>
                                    <th>TAX Code</th>
                                    <th>Price</th>
                                    <th style="min-min-width: 230px;">Delivery Date</th>
                                    <th style="min-min-width: 230px;">Start Date</th>
                                    <th style="min-min-width: 230px;">End Date</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="iteam" items="${list0}" varStatus="status">
                                    <tr>
                                        <td>${iteam.sno}</td> <!-- Using index for serial number -->
                                        <td>${iteam.iteamCode}</td>
                                        <td>${iteam.iteamDescription}</td>
                                        <td>${iteam.purpose}</td>
                                        <td>${iteam.make}</td>
                                        <td>${iteam.uom}</td>
                                        <td>${iteam.qty}</td>
                                        <td>${iteam.accountCategory}</td>
                                        <td>${iteam.accountValue}</td>
                                        <td>${iteam.productType}</td>
                                        <td>${iteam.productGroup}</td>
                                        <td>${iteam.taxCode}</td>
                                        <td>${iteam.price}</td>
                                        <td>${iteam.deliveryDate}</td>
                                        <td>${iteam.startDate}</td>
                                        <td>${iteam.endDate}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        </div>
                        </div>
                    </c:if>
                    <c:if test="${Service.size()>0}">
                        <h6>Service Details</h6>

                        <table id="commonTable3" class="table table-striped bg-white" style="min-width: 100%" align="Center">
                            <thead>
                                <tr>
                                    <th>Sr No</th>
                                    <th style="min-width: 230px;">Item Code</th>
                                    <th style="min-width: 230px;">Item Description</th>
                                    <th style="min-width: 230px;">Purpose</th>
                                    <th>Make</th>
                                    <th>UOM</th>
                                    <th>Qty</th>
                                    <th>Account Category</th>
                                    <th>Account Value</th>
                                    <th>Product Type</th>
                                    <th>Product Group</th>
                                    <th>TAX Code</th>
                                    <th>Price</th>
                                    <th style="min-min-width: 230px;">Delivery Date</th>
                                    <th style="min-min-width: 230px;">Start Date</th>
                                    <th style="min-min-width: 230px;">End Date</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="iteam" items="${list4}" varStatus="status">
                                    <tr>
                                        <td>${iteam.sno}</td> <!-- Using index for serial number -->
                                        <td>${iteam.iteamCode}</td>
                                        <td>${iteam.iteamDescription}</td>
                                        <td>${iteam.purpose}</td>
                                        <td>${iteam.make}</td>
                                        <td>${iteam.uom}</td>
                                        <td>${iteam.qty}</td>
                                        <td>${iteam.accountCategory}</td>
                                        <td>${iteam.accountValue}</td>
                                        <td>${iteam.productType}</td>
                                        <td>${iteam.productGroup}</td>
                                        <td>${iteam.taxCode}</td>
                                        <td>${iteam.price}</td>
                                        <td>${iteam.deliveryDate}</td>
                                        <td>${iteam.startDate}</td>
                                        <td>${iteam.endDate}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        </div>
                        </div>
                    </c:if>                          


                    <c:if test="${aocformid == -1}"> 

                        <h6>OAP Deliverable Multi Attachment</h6>
                        <table id="commonTable5" class="table  table-striped bg-white" style="max-width: 100%;" align="Center">
                            <thead>
                                <tr>
                                    <th>Document Name</th>
                                    <th data-dt-order="disable">Attachment
                                        <c:if test="${prdSize != 0}">
                                            <a  href="oapForm.htm?act=delimultiDocxdownloadzip&id1=${delivablemultiid}" style="text-decoration: none; color: black; font-size: 16px;">
                                                &nbsp;&nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                            </a>
                                        </c:if>
                                    </th>


                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="list50" items="${list50}" varStatus="status">
                                <tr>
                                    <td>${list50.description}</td>
                                    <td>
                                        <a class="fw-600 text-break gradient-text" href="oapForm.htm?act=delivmultiDocxdownload&fileName=${list50.attachement}&id1=${list50.oapId}">${list50.attachement}</a>
                                    </td>




                                </tr>
                            </c:forEach>
</tbody>

                        </table>
                    </c:if>             

<c:if test="${oapformid == -1}">  

                                        <h6>AOC Deliverable Multi Attachment</h6>
                                        <table id="commonTable6" class="table  table-striped bg-white" style="max-width: 100%;" align="Center">
                                            <thead>
                                                <tr>
                                                    <th>Document Name</th>
                                                    <th data-dt-order="disable">Attachment 

                                                        <a href="oapForm.htm?act=delimultiDocxdownloadzip&id1=${id}" style="text-decoration: none; color: black; font-size: 16px;">
                                                            &nbsp;&nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                                        </a>
                                                    </th>

                                                </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="list40" items="${list40}" varStatus="status">
                                                <tr>
                                                    <td>${list40.description}</td>
                                                    <td>
                                                        <a class="fw-600 text-break gradient-text" href="oapForm.htm?act=delivmultiDocxdownload&fileName=${list40.attachement}&id1=${list40.aocId}">${list40.attachement}</a>
                                                    </td>




                                                </tr>
                                            </c:forEach>
</tbody>

                                        </table>
                                    </c:if> 



                                        <h6>Approval Status</h6>
                                        <table id="commonTable7" class="table table-striped bg-white" align="center" style="max-width: 100%;">

                                        <thead>
                                            <tr>
                                                <th>Sr. No</th>
                                                <th>User</th>
                                                <th style="min-width: 230px;">Comments</th>
                                                <th data-dt-order="disable">Action</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <c:forEach var="list" items="${list10}" varStatus="status">
                                                <tr>

                                                    <td>${status.count}</td>
                                                    <td>${list[2]}</td>
                                                    <td>${list[1]}</td>
                                                    <td>
                                                        <c:if test="${list[4] == '2'}">
                                                            Recycle
                                                        </c:if>
                                                        <c:if test="${list[4] == '6'}">
                                                            Closed
                                                        </c:if>
                                                        <c:if test="${list[4] == '3'}">
                                                            Rejected
                                                        </c:if>
                                                        <c:if test="${list[4] == '1'||list[4] == '5'}">
                                                            Approved
                                                        </c:if>
                                                    </td>







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
