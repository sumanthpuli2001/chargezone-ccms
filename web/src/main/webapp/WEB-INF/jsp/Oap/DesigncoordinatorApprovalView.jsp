
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Design Co-ordinator Approval Details</title>
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

                            <h5 class="fw-600 mb-0">Design Co-ordinator Approval Details</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                            <button type="submit" class="btn theme-btn mr-3"  >Approve</button>
                            <button type="submit" class="btn theme-btn mr-3"  formaction="oapForm.htm?act=DesigncoordinatorReworkViewsubmit" >Rework</button>
                            <button type="submit" class="btn theme-btn"  formaction="oapForm.htm?act=DesigncoordinatorRejectViewsubmit" >Reject</button>
                        </div>
                    </div>

                    <hr>

                    <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">
                            !</div>
                        <div>
                            <p style="margin: 0;">• Fields marked with * are mandatory.</p>
                        </div>
                    </div>   

                    <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                    <input type="hidden" name="id" value="${id}">
                    <input type="hidden" name="id1" id="id1" value="${oapid}">
                    <input type="hidden" name="id2" id="id2" value="${aocid}">
                    <input type="hidden" name="id3" id="id3" value="${aocForm}">
                    <input type="hidden" name="id4" id="id4" value="${oapForm}">

                    <br>
                    <c:if test="${aocid == 0}">
                        <h6 class="fw-600">OAP Form Details</h6>
                        <div class="rounded-4 mt-4">
                            <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                                <div class="row buyer-info">
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Document No</label>
                                            <p class="fw-600">${oapForm.documentNo}</p>

                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Pcs Name</label>
                                            <p class="fw-600">${oapForm.pcsName}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-8 pb-1">
                                        <div class="form-group">
                                            <label>Project Name</label>
                                            <p class="fw-600">${oapForm.projectName}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Pcs CoOrdinates</label>
                                            <p class="fw-600">${oapForm.pcsCoordinates}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Client Name</label>
                                            <p class="fw-600">${oapForm.mobileNo}</p>
                                        </div>
                                    </div>

                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Department</label>
                                            <p class="fw-600">${oapForm.department}</p>
                                        </div>
                                    </div>

                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Date</label>
                                            <p class="fw-600">${oapForm.createdDate}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <h6 class="fw-600">CRC Form Details</h6>

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

                        <h6 class="fw-600">Site Survey Details</h6>
                        <table id="commonTable" class="table  table-striped  bg-white" style="  max-width: 100%;"
                               align="center">
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
                                        <td>${status.count}</td>
                                        <td><a class="fw-600 text-break gradient-text"
                                               href="oapForm.htm?act=siteSurveyView&id=${oapSurveyAttch.surveyNo}">${oapSurveyAttch.surveyNo}</a>
                                        </td>
                                        <td>${oapSurveyAttch.projectRepresentative}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:if>

                    <c:if test="${oapid == 0}">
                        <h6 class="fw-600">AOC Form Details</h6>
                        <div class="rounded-4 mt-4">
                            <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                                <div class="row buyer-info">
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Document Number</label>
                                            <p class="fw-600">${aocForm.documentNo}</p>

                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Depo.Name</label>
                                            <p class="fw-600">${aocForm.hubDepoName}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-8 pb-1">
                                        <div class="form-group">
                                            <label>Project Name</label>
                                            <p class="fw-600">${aocForm.clientProjectName}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Created By</label>
                                            <p class="fw-600">${aocForm.userId}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Client Name</label>
                                            <p class="fw-600">${aocForm.mobileNo}</p>
                                        </div>
                                    </div>

                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Date</label>
                                            <p class="fw-600">${aocForm.createdDate}</p>
                                        </div>
                                    </div>


                                </div>
                            </div>
                        </div>

                                        <h6 class="fw-600">KICKOFF Form Details</h6>

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

                        <h6 class="fw-600">Site Survey Details</h6>
                        <table id="commonTable1" class="table table-striped bg-white" style=" max-width: 100%;"
                               align="center">
                            <thead>
                                <tr>
                                    <th>Sr No</th>
                                    <th>Survey No</th>
                                    <th>Project Representative</th>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach var="aocSurveyAttch" items="${aocSurveyAttch}" varStatus="status">
                                    <tr>
                                        <td>${status.count}</td>
                                        <td><a class="fw-600 text-break gradient-text" href="oapForm.htm?act=siteSurveyView&id=${aocSurveyAttch.surveyNo}">${aocSurveyAttch.surveyNo}</a>
                                        </td>
                                        <td>${aocSurveyAttch.projectRepresentative}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                    <hr>
                    <c:if test="${Contract1.size()>0}">
                        <h6 class="fw-600">Item Details</h6>
                       
                        <table id="commonTable3" class="table table-striped bg-white" style="min-width: 100px;" align="Center">
                                    <thead>
                                        <tr>
                                            <th>Sr No</th>
                                            <th style="min-width: 190px;">Item Code</th>
                                            <th style="min-width: 250px;">Item Description</th>
                                            <th style="min-width: 250px;">Purpose</th>
                                            <th>Make</th>
                                            <th>UOM</th>
                                            <th>Qty</th>
                                            <th>Account Category</th>
                                            <th>Account Value</th>
                                            <th>Product Type</th>
                                            <th>Product Group</th>
                                            <th>TAX Code</th>
                                            <th>Price</th>
                                            <th style="min-width: 190px;">Delivery Date</th>
                                            <th style="min-width: 190px;">Start Date</th>
                                            <th style="min-width: 190px;">End Date</th> 
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="iteam" items="${list2}" varStatus="status">
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
                        <h6 class="fw-600">Item Details For Service</h6>
                        <table id="commonTable4" class="table table-striped bg-white" style="min-width: 100px;" align="Center">

                                    <thead>
                                        <tr>
                                            <th>Sr No</th>
                                            <th style="min-width: 190px;">Item Code</th>
                                            <th style="min-width: 250px;">Item Description</th>
                                            <th style="min-width: 250px;">Purpose</th>
                                            <th>Make</th>
                                            <th>UOM</th>
                                            <th>Qty</th>
                                            <th>Account Category</th>
                                            <th>Account Value</th>
                                            <th>Product Type</th>
                                            <th>Product Group</th>
                                            <th>TAX Code</th>
                                            <th>Price</th>
                                            <th style="min-width: 190px;">Delivery Date</th>
                                            <th style="min-width: 190px;">Start Date</th>
                                            <th style="min-width: 190px;">End Date</th> 
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="iteam" items="${list1}" varStatus="status">
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
                        <h6 class="fw-600">Item Details</h6>
                       
                        <table id="commonTable5" class="table table-striped bg-white" style="min-width: 100px;" align="Center">
                                    <thead>
                                        <tr>
                                            <th>Sr No</th>
                                            <th style="min-width: 190px;">Item Code</th>
                                            <th style="min-width: 250px;">Item Description</th>
                                            <th style="min-width: 250px;">Purpose</th>
                                            <th>Make</th>
                                            <th>UOM</th>
                                            <th>Qty</th>
                                            <th>Account Category</th>
                                            <th>Account Value</th>
                                            <th>Product Type</th>
                                            <th>Product Group</th>
                                            <th>TAX Code</th>
                                            <th>Price</th>
                                            <th style="min-width: 190px;">Delivery Date</th>
                                            <th style="min-width: 190px;">Start Date</th>
                                            <th style="min-width: 190px;">End Date</th> 
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="iteam" items="${list3}" varStatus="status">
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
                    <c:if test="${Service.size()>0}">
                        <h6 class="fw-600">Service Details</h6>
                       <table id="commonTable6" class="table table-striped bg-white" style="min-width: 100px;" align="Center">

                                    <thead>
                                        <tr>
                                            <th>Sr No</th>
                                            <th style="min-width: 190px;">Item Code</th>
                                            <th style="min-width: 250px;">Item Description</th>
                                            <th style="min-width: 250px;">Purpose</th>
                                            <th>Make</th>
                                            <th>UOM</th>
                                            <th>Qty</th>
                                            <th>Account Category</th>
                                            <th>Account Value</th>
                                            <th>Product Type</th>
                                            <th>Product Group</th>
                                            <th>TAX Code</th>
                                            <th>Price</th>
                                            <th style="min-width: 190px;">Delivery Date</th>
                                            <th style="min-width: 190px;">Start Date</th>
                                            <th style="min-width: 190px;">End Date</th> 
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
                           
                    </c:if>
                        <hr>
                        <c:if test="${aocformid == -1}"> 
                            <h6 class="fw-600">OAP Deliverable Multi Attachment</h6>
                                        <table id="commonTable9" class="table  table-striped bg-white" style="max-width: 100%;" align="Center">
                                            <thead>
                                                <tr>
                                                    <th>Document Name</th>
                                                    <th>Attachment
                                                        <c:if test="${prdSize != 0}">
                                                            <a href="oapForm.htm?act=delimultiDocxdownloadzip&id1=${id}" style="text-decoration: none; color: black; font-size: 16px;">
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

                                        <h6 class="fw-600">AOC Deliverable Multi Attachment</h6>
                                        <table id="commonTable7" class="table table-striped bg-white" style="max-width: 100%;" align="Center">
                                            <thead>
                                                <tr>
                                                    <th>Document Name</th>
                                                    <th>Attachment 
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
                                        
                           <div class="col-12 p-0">
                    <div class="form-group comment-box">
                        <label class="control-label">Comment :<span class="text-danger">*</span></label>
                        <textarea type="text" maxlength="250" class="textarea-field comment" id="comment" name="comment"  required="true"></textarea>
                    </div>
                </div>  
             
        <div class="form-group">
                                        <div style="display: flex;  justify-content: center;">

                                            <button type="submit" class="btn theme-btn mr-3"  >Approve</button>
                                            <button type="submit" class="btn theme-btn mr-3"  formaction="oapForm.htm?act=DesigncoordinatorReworkViewsubmit" >Rework</button>
                                            <button type="submit" class="btn theme-btn"  formaction="oapForm.htm?act=DesigncoordinatorRejectViewsubmit" >Reject</button>
                                        </div>
                                    </div>                                
                                        
                                        
                                        
                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
