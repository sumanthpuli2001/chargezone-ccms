
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deliverable OAP View</title>
    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="employeeMaster.htm?act=submitDepartment" commandName="departmentMaster" method="post">

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Deliverable OAP View</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>
                            <a href="oapForm.htm?act=DeliverablePrint&id=${id}" class="btn theme-btn" onclick="printCustom()" title="Print this page">
                                <i class="fa fa-arrow-right"></i>&nbsp;&nbsp;Print
                            </a>

                        </div>
                    </div>

                    <hr>

                    <h6><b>OAP Form Details</b></h6>
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

                    <h6><b>CRC Form Details</b></h6>   

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
                                        <label>Scope Of Work </label>
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

                    <h6><b>Site Survey Details</b></h6>   

                    <table id="commonDocTable" class="table  table-striped bg-white" style=" margin: auto; max-width: 100%;" align="center">
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
                    <br>
                    <h6><b>Deliverable Details</b></h6> 
                   

                    <div class="rounded-4 mt-4"> 
                        <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                            <div class="row buyer-info">
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Date</label>
                                        <p class="fw-600">${list10.date}</p>

                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Description</label>
                                        <p class="fw-600">${list10.description}</p>
                                    </div>
                                </div>
                            </div>
                        </div>  
                    </div>
                                    <table id="commonTable" class="table  table-striped bg-white" style=" margin: auto; max-width: 100%;" align="center">
                        <thead>
                            <tr>
                                <th>Sr No</th>
                                <th>Description</th>
                                <th>Design Co-ordinator</th>
                            </tr>
                        </thead>

                        <tbody>

                            <c:forEach var="list11" items="${list11}" varStatus="status">
                                <tr>
                                    <td >${status.count}</td>
                                    <td>${list11.description}</a></td>
                                    <td >${list11.designCoordinator}</td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table> 
                                    <br>
                      <h6><b>OAP Deliverable Multi Attachment</b></h6>                
                                    
                                    
                     <table id="commonTable2" class="table table-striped bg-white" style="max-width: 100%;" align="Center">
                                        <thead>
                                            <tr>
                                                <th style="text-align: left;">Document Name</th>
                                                <th >Attachment 
                                                    <c:if test="${prdSize != 0}">
                                                    <a href="oapForm.htm?act=delimultiDocxdownloadzip&id1=${delivablemultiid}" style="text-decoration: none; color: black; font-size: 16px;">
                                                        &nbsp;&nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                                    </a>
                                                        </c:if>
                                                </th>


                                            </tr>
                                        </thead>

                                        <c:forEach var="list5" items="${list5}" varStatus="status">
                                            <tr>
                                                <td style="text-align: left;">${list5.description}</td>
                                                <td>
                                                    <a class="fw-600 text-break gradient-text" href="oapForm.htm?act=delivmultiDocxdownload&fileName=${list5.attachement}&id1=${list5.oapId}">${list5.attachement}</a>
                                                </td>

                                            </tr>
                                        </c:forEach>
                                    </table>               
                      <br>
                      <h6><b>Approval Status</b></h6>  
                      
                      <table id="commonTable3" class="table table-striped bg-white" align="center" style="max-width: 100%;">

                                            <thead>
                                                <tr>
                                                    <th >Sr.No</th>
                                                    <th >User</th>
                                                    <th >Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="list0" items="${list0}" varStatus="status">
                                                    <tr>
                                                        <td> ${status.count}</td> 
                                                        <td>${list0.designAssign}</td> <!-- User ID -->
                                                        <td>
                                                            <c:if test="${list0.flagStatus == '1'|| list0.flagStatus == '5'}">
                                                                Approved
                                                            </c:if>  
                                                            <c:if test="${list0.flagStatus == '2'}">
                                                                Recycle
                                                            </c:if>  
                                                            <c:if test="${list0.flagStatus == '3'}">
                                                                Reject
                                                            </c:if>
                                                        </td> <!-- Approval Status -->
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
