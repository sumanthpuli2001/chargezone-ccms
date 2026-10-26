<%-- 
    Document   : HRCriteriaRecycleView
    Created on : 1 Nov, 2025, 09:57:57 AM
    Author     : fnp
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarNewVendor.jsp"%>

    <head>
        <title>Vendor HR Details</title>
    </head>

    <body>
        <style>
            .alert-static{
                color:#721c24;
                background-color:#f8d7da;
                border-color:#f5c6cb
            }
            .alert-static hr{
                border-top-color:#f1b0b7
            }
            .input-percent {
                position: relative;
            }

            .input-percent input {
                padding-right: 25px; 
                text-align: left;  
            }

            .input-percent::after {
                content: "%";
                position: absolute;
                right: 10px;
                top: 50%;
                transform: translateY(-50%);
                color: #555;
                pointer-events: none;
            }
            table > tbody > tr:nth-of-type(odd) {
                background-color: #F3F7FF;
            }
            table > thead > tr {
                background: skyblue;
            }
        </style>
        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">

            <section id="printSection" class="main-content">
                <form:form action="vendorInformation.htm?act=hrCriteriaRecycleSubmit"  enctype="multipart/form-data" method="post" commandName="vendorInformation"
                           name='form' class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">Vendor HR Details</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <c:if test="${vendorInformation.hrApprovalFlag=='3'}">
                                <button type="submit" class="btn theme-btn" id="submit2">Submit</button>
                            </c:if>
                        </div>
                    </div>
                    <hr>

                    <input type="hidden" id="VInformationId" name="VInformationId" value="${vendorInformation.id}">

                    <div class="card-box rounded-3 mt-3 py-2 px-3 top-0">
                        <ul class="list-unstyled mb-0 d-flex align-items-center overflow-auto">

                            <li class="tab-item mr-2">
                                <a href="vendorInformation.htm?act=policyUpdateLevelOneVendorInformation" class="tab-link transition-0" <c:if test="${vendorInformation.status1=='3'}">style="color: red;"</c:if>>Basic Information</a>
                                </li>                            

                                <li class="tab-item mr-2">
                                    <a href="vendorInformation.htm?act=policyUpdateVendorInformation" class="tab-link transition-0" <c:if test="${vendorInformation.finacialFlag=='3'}">style="color: red;"</c:if>>Financial Approval</a>
                                </li>

                            <c:if test="${rightsMap['TECHNICAL'] != null}">
                                <li class="tab-item mr-2">
                                    <a href="vendorInformation.htm?act=electricTechnicalRecycle" class="tab-link transition-0" <c:if test="${vendorInformation.technicalFlag=='3'}">style="color: red;"</c:if>>Technical Approval</a>
                                    </li>
                            </c:if>

                            <c:if test="${rightsMap['HR'] != null}">
                                <li class="tab-item mr-2">
                                    <a href="vendorInformation.htm?act=hrCriteriaRecycleView" class="tab-link active transition-0" <c:if test="${vendorInformation.hrApprovalFlag=='3'}">style="color: red;"</c:if>>HR Approval</a>
                                    </li>
                            </c:if>

                            <c:if test="${rightsMap['HSE'] != null}">
                                <li class="tab-item mr-2">
                                    <a href="vendorInformation.htm?act=safetyCriteriaRecycleView" class="tab-link transition-0" <c:if test="${vendorInformation.safteyApprovalFlag=='3'}">style="color: red;"</c:if>>Safety Approval</a>
                                    </li>
                            </c:if>

                            <c:if test="${rightsMap['IT'] != null}">
                                <li class="tab-item mr-2">
                                    <a href="vendorInformation.htm?act=itCriteriaRecycleView" class="tab-link transition-0" <c:if test="${vendorInformation.itApprovalFlag=='3'}">style="color: red;"</c:if>>IT Approval</a>
                                    </li>
                            </c:if>

                            <li class="tab-item">
                                <a href="vendorInformation.htm?act=activeVenderProfileView" class="tab-link transition-0">Vendor Information</a>
                            </li>
                        </ul>
                    </div><br>
                           
                    <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                             <c:if test="${vendorInformation.status1=='3'}">
                                <strong>Note:</strong> <strong class="text-danger fs-15">Recycle By Buyer Team</strong> <br>
                            </c:if>
                             <c:if test="${vendorInformation.finacialFlag=='3'}">
                                <strong>Note:</strong> <strong class="text-danger fs-15">Recycle By Financial Approval Team. </strong><br>
                            </c:if>
                    <c:if test="${vendorInformation.technicalFlag=='3'}">
                                <strong>Note:</strong> <strong class="text-danger fs-15">Recycle By Technical Team </strong><br>
                            </c:if>
                    <c:if test="${vendorInformation.hrApprovalFlag=='3'}">
                                <strong>Note:</strong> <strong class="text-danger fs-15">Recycle By HR Approval Team. </strong><br>
                            </c:if>
                    <c:if test="${vendorInformation.safteyApprovalFlag=='3'}">
                                <strong>Note:</strong> <strong class="text-danger fs-15">Recycle By Safety Approval Team</strong><br>
                            </c:if>
                    <c:if test="${vendorInformation.itApprovalFlag=='3'}">
                                <strong>Note:</strong> <strong class="text-danger fs-15">Recycle By IT Approval Team</strong><br>
                            </c:if>
                    <c:if test="${vendorInformation.status1=='9'}">
                                <strong>Note:</strong> <strong class="text-danger fs-15">Changes For Account Details Rejected By Buyer</strong><br>
                            </c:if>
                    <c:if test="${vendorInformation.status1=='11'}">
                                <strong>Note:</strong> <strong class="text-danger fs-15">Changes For Account Details Accepted By Buyer</strong><br>
                            </c:if>
                            <strong>Note:</strong> Ensure your file size is within <strong>5MB</strong> for a smooth upload. <br>
                            <span style="font-weight: bold;">*</span>  Indicate That Attachment Are Mandatory
                        </div>
                    </div> 
                    <c:if test="${!empty failureMessage}">
                        <br>
                        <div class="fadeOutEffect alert alert-danger" style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                            <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                            <div>
                                <strong>Note:</strong> <strong class="text-danger fs-13">${failureMessage} </strong><br>                            
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${!empty successMessage}">
                        <br>
                        <div class="fadeOutEffect alert alert-info" style="display: flex; align-items: center; gap: 12px; background: #F0FFF4; color: #0F5132; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #198754; box-shadow: 2px 2px 10px rgba(25, 135, 84, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">                        
                            <div style="background: #198754; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px; ">✓</div>  
                            <div>                             
                                <strong>Note:</strong> <strong class="text-success fs-13">${successMessage} </strong><br>                            
                            </div>
                        </div>
                    </c:if>

                </form:form>
            </section>
        </main>        
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
