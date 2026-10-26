<%-- 
    Document   : VendorUpdateFinancialInformation
    Created on : 1 Nov, 2025, 09:57:57 AM
    Author     : fnp
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarNewVendor.jsp"%>

    <head>
        <title>Financial Details</title>
    </head>

    <body>
        <style>           
            input[type="text"], textarea {
                text-transform: uppercase;
            }
        </style>

        <script>
            document.addEventListener("input", function (e) {
                const el = e.target;

                if (
                    el.matches("input:not([type='hidden']):not([type='checkbox']):not([type='radio']), textarea")
                ) {
                    if (el.type === "email") {
                        el.value = el.value.toLowerCase();
                    } else {
                        el.value = el.value.toUpperCase();
                    }
                }
            });
        </script>
        <style>
            .alert-static{
                color:#721c24;
                background-color:#f8d7da;
                border-color:#f5c6cb}
            .alert-static hr{
                border-top-color:#f1b0b7}            
            </style>
            <!-- Content Wrapper. Contains page content -->
            <main class="d-flex align-items-end justify-content-end">

            <section id="printSection" class="main-content">
                <form:form action="vendorInformation.htm?act=basicUpdateVendorInformation"  enctype="multipart/form-data" method="post" commandName="vendorInformation"
                           name='form' class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">Financial Details</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>
                          <c:if test="${vendorInformation.status1 == '10' &&
                            (vendorInformation.finacialFlag == '1' || vendorInformation.finacialFlag == '6' || vendorInformation.finacialFlag == '8' ||
                             vendorInformation.finacialFlag == '9' ||vendorInformation.finacialFlag == '10')}">
                            <a href="vendorInformation.htm?act=vendorFinacilaHistoyList" class="btn theme-btn">History</a>
                        </c:if>
                        </div>
                    </div>
                    <hr>
                    <c:if test="${!empty failureMessage}">                        
                        <div class="fadeOutEffect alert alert-danger mt-2 mb-2" style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                            <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                            <div>
                                <strong>Note:</strong> <strong class="text-danger fs-13">${failureMessage} </strong><br>                            
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${!empty successMessage}">                       
                        <div class="fadeOutEffect alert alert-info mt-2 mb-2" style="display: flex; align-items: center; gap: 12px; background: #F0FFF4; color: #0F5132; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #198754; box-shadow: 2px 2px 10px rgba(25, 135, 84, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">                        
                            <div style="background: #198754; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px; ">✓</div>  
                            <div>                             
                                <strong>Note:</strong> <strong class="text-success fs-13">${successMessage} </strong><br>                            
                            </div>
                        </div>
                    </c:if>
                    <input type="hidden" id="VInformationId" name="VInformationId" value="${vendorInformation.id}">

                    <div class="card-box rounded-3 mt-3 py-2 px-3 top-0">
                        <ul class="list-unstyled mb-0 d-flex align-items-center overflow-auto">

                            <li class="tab-item mr-2">
                                <a href="vendorInformation.htm?act=policyUpdateLevelOneVendorInformation" class="tab-link transition-0" <c:if test="${vendorInformation.status1=='3'}">style="color: red;"</c:if>>Basic Information</a>
                                </li>                            

                                <li class="tab-item mr-2">
                                    <a href="vendorInformation.htm?act=policyUpdateVendorInformation" class="tab-link active transition-0" 
                                    <c:if test="${vendorInformation.finacialFlag == '3' || (vendorInformation.status1 == 10 && (vendorInformation.finacialFlag == '5' || vendorInformation.finacialFlag == '6' || vendorInformation.finacialFlag == '8' || vendorInformation.finacialFlag == '10'))}">
                                        style="color: red;"</c:if>>Financial Information</a>
                                </li>

                            <c:if test="${rightsMap['TECHNICAL'] != null}">
                                <li class="tab-item mr-2">
                                    <a href="vendorInformation.htm?act=electricTechnicalRecycle" class="tab-link transition-0" <c:if test="${vendorInformation.technicalFlag=='3'}">style="color: red;"</c:if>>Technical Information</a>
                                    </li>
                            </c:if>

                            <c:if test="${rightsMap['HR'] != null}">
                                <li class="tab-item mr-2">
                                    <a href="vendorInformation.htm?act=hrCriteriaRecycleView" class="tab-link transition-0" <c:if test="${vendorInformation.hrApprovalFlag=='3'}">style="color: red;"</c:if>>HR Information</a>
                                    </li>
                            </c:if>

                            <c:if test="${rightsMap['HSE'] != null}">
                                <li class="tab-item mr-2">
                                    <a href="vendorInformation.htm?act=safetyCriteriaRecycleView" class="tab-link transition-0" <c:if test="${vendorInformation.safteyApprovalFlag=='3'}">style="color: red;"</c:if>>Safety Information</a>
                                    </li>
                            </c:if>

                            <c:if test="${rightsMap['IT'] != null}">
                                <li class="tab-item mr-2">
                                    <a href="vendorInformation.htm?act=itCriteriaRecycleView" class="tab-link transition-0" <c:if test="${vendorInformation.itApprovalFlag=='3'}">style="color: red;"</c:if>>IT Information</a>
                                    </li>
                            </c:if>

                            <li class="tab-item">
                                <a href="vendorInformation.htm?act=activeVenderProfileView" class="tab-link transition-0">Vendor Information</a>
                            </li>
                        </ul>
                    </div>
                    <c:if test="${vendorInformation.status1 == 6 || vendorInformation.status1 == 7 || vendorInformation.status1 == 501 || vendorInformation.finacialFlag=='3' || vendorInformation.technicalFlag=='3' || vendorInformation.hrApprovalFlag=='3' || vendorInformation.safteyApprovalFlag=='3' || vendorInformation.itApprovalFlag=='3'|| vendorInformation.finacialFlag=='6'|| vendorInformation.finacialFlag=='10'|| (vendorInformation.status1 == 10 && (vendorInformation.finacialFlag == '5' || vendorInformation.finacialFlag == '6' || vendorInformation.finacialFlag == '8' || vendorInformation.finacialFlag == '10'))}">
                        <br>
                        <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                            <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                            <div>                        
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
                                <c:if test="${vendorInformation.status1 == 6}">
                                    <strong>Note:</strong> <strong class="text-danger fs-15">Reject from Buyer.</strong> <br>
                                </c:if>
                                <c:if test="${vendorInformation.status1 == 7}">
                                    <strong>Note:</strong> <strong class="text-danger fs-15">Reject from Procurement Head. </strong><br>
                                </c:if>
                                <c:if test="${vendorInformation.status1 == 501}">
                                    <strong>Note:</strong> <strong class="text-danger fs-15">Reject from Compliance Officer. </strong><br>
                                </c:if>
                                <c:if test="${vendorInformation.finacialFlag=='6'}">
                                    <strong>Note:</strong> <strong class="text-danger fs-15">The buyer has accepted your change request. Please update your financial details.</strong><br>
                                </c:if>
                                <c:if test="${vendorInformation.finacialFlag=='10'}">
                                    <strong>Note:</strong> <strong class="text-danger fs-15"> Recycle Financial  Team</strong><br>
                                </c:if>
                                <c:if test="${vendorInformation.status1 == 10 && (vendorInformation.finacialFlag == '5' || vendorInformation.finacialFlag == '8') }">
                                    <strong>Note:</strong> <strong class="text-danger fs-15">Vendor Financial Details Change Process </strong><br>
                                </c:if>
                                <strong>Note:</strong> Ensure your file size is within <strong>5MB</strong> for a smooth upload. <br>
                                <span style="font-weight: bold;">*</span>  Indicate That Attachment Are Mandatory
                            </div>
                        </div> 
                    </c:if>
                    <br>

                    <input type="hidden" name="vendorEmailId" value="${vendorInformation.vendorEmailId}" />
           
                    <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
                        <thead>
                            <tr>
                                <th colspan="4"
                                    style="border:1px solid black; background-color:skyblue; text-align:center;">
                                    VENDOR DETAILS
                                </th>
                            </tr>
                            <tr>
                                <th style="border:1px solid black;">Company Name</th>
                                <th style="border:1px solid black;">Email Id</th>
                                <th style="border:1px solid black;">Type of Company</th>
                                <th style="border:1px solid black;">Proof Of Attachment</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td style="border:1px solid black; word-break:break-word;">
                                    ${vendorInformation.companyName}
                                </td>

                                <td style="border:1px solid black; word-break:break-word;">
                                    ${vendorInformation.vendorEmailId}
                                </td>

                                <td style="border:1px solid black;">
                                    ${vendorInformation.typeOfConcern}
                                </td>

                                <td style="border:1px solid black; word-break:break-word;">
                                    <c:if test="${vendorInformation.companyProof!=null && not empty vendorInformation.companyProof}">                                        
                                        <span class="file-wrapper">
                                            <span class="file-name text-break">${vendorInformation.companyProof}</span>
                                            <span class="file-actions">
                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.companyProof}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.companyProof}"><span class="fa fa-solid fa-eye"></span></a>
                                            </span>
                                        </span>
                                    </c:if>
                                    <c:if test="${vendorInformation.companyProof2!=null && not empty vendorInformation.companyProof2}">
                                        <br>
                                        <span class="file-wrapper">
                                            <span class="file-name text-break">${vendorInformation.companyProof2}</span>
                                            <span class="file-actions">
                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.companyProof2}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.companyProof2}"><span class="fa fa-solid fa-eye"></span></a>
                                            </span>
                                        </span>
                                    </c:if>                                        
                                </td>
                            </tr>
                        </tbody>
                    </table>

                    <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
                        <thead>
                            <tr>
                                <th colspan="3" style="border:1px solid black; background-color:skyblue; text-align:center;">
                                    TYPE OF VENDORS
                                </th>
                            </tr>
                            <tr>
                                <th style="border:1px solid black;">Group Name</th>
                                <th style="border:1px solid black;">Group Category Name</th>
                                <th style="border:1px solid black;">Group Sub Category Name</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="list" items="${list}" varStatus="status">
                                <tr>
                                    <td style="border:1px solid black; word-break:break-word;">
                                        <input type="hidden" name="groupId" value="${list[2]}" />
                                        ${list[2]}
                                    </td>

                                    <td style="border:1px solid black; word-break:break-word;">
                                        ${list[3]}
                                    </td>

                                    <td style="border:1px solid black; word-break:break-word;">
                                        ${list[4]}
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                                        
                    <c:if test="${vendorInformation.finacialFlag=='1' || vendorInformation.finacialFlag=='0'  || vendorInformation.finacialFlag=='5'|| vendorInformation.finacialFlag=='8'|| vendorInformation.finacialFlag=='7'}">
                    <%--<c:if test="${vendorInformation.finacialFlag=='3'}">--%>

                        <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">

                            <thead>
                                <tr>
                                    <th colspan="2" style="border:1px solid black; background-color:skyblue; text-align:center;">
                                        COMPANY REGISTRATION DETAILS
                                    </th>
                                </tr>
                                <tr>
                                    <th style="border:1px solid black; width:50%;">Document Name</th>
                                    <th style="border:1px solid black; width:50%;">Details / File</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td style="border:1px solid black;">GST No.</td>
                                    <td style="border:1px solid black; word-break:break-word;">
                                        ${vendorInformation.gstinNo} <br>
                                        <c:if test="${vendorInformation.gstinFile!=null && not empty vendorInformation.gstinFile}">                                        
                                            <span class="file-wrapper">
                                                <span class="file-name text-break">${vendorInformation.gstinFile}</span>
                                                <span class="file-actions">
                                                    <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.gstinFile}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.gstinFile}"><span class="fa fa-solid fa-eye"></span></a>
                                                </span>
                                            </span>
                                        </c:if>                                        
                                    </td>
                                </tr>
                                <tr>
                                    <td style="border:1px solid black;">PAN No.</td>
                                    <td style="border:1px solid black; word-break:break-word;">
                                        ${vendorInformation.panNo} <br>
                                        <c:if test="${vendorInformation.panFile!=null && not empty vendorInformation.panFile}">                                        
                                            <span class="file-wrapper">
                                                <span class="file-name text-break">${vendorInformation.panFile}</span>
                                                <span class="file-actions">
                                                    <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.panFile}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.panFile}"><span class="fa fa-solid fa-eye"></span></a>
                                                </span>
                                            </span>
                                        </c:if>
                                    </td>
                                </tr>
                                
                                <tr>
                                    <td>MSME No</td>
                                    <td>
                                        <c:if test="${vendorInformation.msmeStatus=='0'}"><strong>MSME Not
                                                Available</strong></c:if>
                                        ${vendorInformation.service_tax}<br>
                                        <c:if test="${vendorInformation.service_file!=null && not empty vendorInformation.service_file}">                                        
                                            <span class="file-wrapper">
                                                <span class="file-name text-break">${vendorInformation.service_file}</span>
                                                <span class="file-actions">
                                                    <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.service_file}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.service_file}"><span class="fa fa-solid fa-eye"></span></a>
                                                </span>
                                            </span>
                                        </c:if>                                        
                                    </td>
                                </tr>
                                <tr>
                                    <td>ESIC No</td>
                                    <td>
                                        <c:if test="${vendorInformation.esicStatus=='0'}"><strong>ESIC Not Available</strong></c:if>
                                        ${vendorInformation.esicNo}<br>
                                        <c:if test="${vendorInformation.esicFile!=null && not empty vendorInformation.esicFile}">                                        
                                            <span class="file-wrapper">
                                                <span class="file-name text-break">${vendorInformation.esicFile}</span>
                                                <span class="file-actions">
                                                    <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.esicFile}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.esicFile}"><span class="fa fa-solid fa-eye"></span></a>
                                                </span>
                                            </span>
                                        </c:if>
                                    </td>
                                </tr>

                                <tr>
                                    <td>EPFO No.</td>
                                    <td>
                                        <c:if test="${vendorInformation.epfoStatus=='0'}"><strong>EPFO Not Available</strong></c:if>
                                        ${vendorInformation.pfNo}<br>
                                        <c:if test="${vendorInformation.pfAttachment!=null && not empty vendorInformation.pfAttachment}">                                        
                                            <span class="file-wrapper">
                                                <span class="file-name text-break">${vendorInformation.pfAttachment}</span>
                                                <span class="file-actions">
                                                    <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.pfAttachment}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.pfAttachment}"><span class="fa fa-solid fa-eye"></span></a>
                                                </span>
                                            </span>
                                        </c:if>                                        
                                    </td>
                                </tr>

                                <tr>
                                    <td>Import Export Code </td>
                                    <td> 
                                        <c:if test="${vendorInformation.eccStatus == '0'}"><strong>ECC Not Available</strong></c:if>
                                        ${vendorInformation.ecc_no}<br> 
                                        <c:if test="${vendorInformation.ecc_file!=null && not empty vendorInformation.ecc_file}">                                        
                                            <span class="file-wrapper">
                                                <span class="file-name text-break">${vendorInformation.ecc_file}</span>
                                                <span class="file-actions">
                                                    <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.ecc_file}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.ecc_file}"><span class="fa fa-solid fa-eye"></span></a>
                                                </span>
                                            </span>
                                        </c:if>
                                    </td>
                                </tr>
                            </tbody>

                        </table>
                                
                        <table class="table table-bordered custom-table mb-3"
                               style="width:100%; table-layout:fixed; border-collapse:collapse;">
                            <thead>
                                <tr>
                                    <th colspan="4" style="border:1px solid black; background-color:skyblue; text-align:center;">
                                        PAYMENT / BANKING DETAILS
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th>Account Number</th>
                                    <td>${vendorInformation.accountNumber}</td>
                                    <th>Bank Name</th>
                                    <td>${vendorInformation.bankName}</td>
                                </tr>
                                <tr>
                                    <th>Branch</th>
                                    <td>${vendorInformation.branch}</td>
                                    <th>IFSC Code</th>
                                    <td>${vendorInformation.ifscCode}</td>
                                </tr>
                                <tr>
                                    <th>Swift Code</th>
                                    <td>${vendorInformation.swiftCode}</td>
                                    <th>Cancel Cheque</th>
                                    <td>
                                        <c:if test="${vendorInformation.cancelCheck!=null && not empty vendorInformation.cancelCheck}">                                        
                                            <span class="file-wrapper">
                                                <span class="file-name text-break">${vendorInformation.cancelCheck}</span>
                                                <span class="file-actions">
                                                    <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.cancelCheck}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.cancelCheck}"><span class="fa fa-solid fa-eye"></span></a>
                                                </span>
                                            </span>
                                        </c:if>                                        
                                    </td>
                                </tr>
                            </tbody>
                        </table>


                        <table class="table table-bordered custom-table mb-3"
                               style="width:100%; table-layout:fixed; border-collapse:collapse;">

                            <thead>
                                <tr>
                                    <th colspan="4" style="border:1px solid black; background-color:skyblue; text-align:center;">
                                        FINANCIAL STATEMENT (PROFIT AND LOSS / BALANCE SHEET)
                                    </th>
                                </tr>
                                <tr>
                                    <th style="border:1px solid black;">Year</th>
                                    <th style="border:1px solid black;">Financial Year</th>
                                    <th style="border:1px solid black;">Financial Amount</th>
                                    <th style="border:1px solid black;">Financial Attachment</th>
                                </tr>
                            </thead>

                            <tbody>
                                <tr>
                                    <td style="border:1px solid black;">1st Year</td>
                                    <td style="border:1px solid black;">${vendorInformation.finical1}</td>
                                    <td style="border:1px solid black;">${vendorInformation.finicalAmount1}</td>
                                    <td style="border:1px solid black; word-break:break-word;">
                                        <c:if test="${vendorInformation.finicalAttachment1!=null && not empty vendorInformation.finicalAttachment1}">                                        
                                            <span class="file-wrapper">
                                                <span class="file-name text-break">${vendorInformation.finicalAttachment1}</span>
                                                <span class="file-actions">
                                                    <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.finicalAttachment1}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.finicalAttachment1}"><span class="fa fa-solid fa-eye"></span></a>
                                                </span>
                                            </span>
                                        </c:if>                                        
                                    </td>
                                </tr>

                                <tr>
                                    <td style="border:1px solid black;">2nd Year</td>
                                    <td style="border:1px solid black;">${vendorInformation.finical2}</td>
                                    <td style="border:1px solid black;">${vendorInformation.finicalAmount2}</td>
                                    <td style="border:1px solid black; word-break:break-word;">
                                        <c:if test="${vendorInformation.finicalAttachment2!=null && not empty vendorInformation.finicalAttachment2}">                                        
                                            <span class="file-wrapper">
                                                <span class="file-name text-break">${vendorInformation.finicalAttachment2}</span>
                                                <span class="file-actions">
                                                    <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.finicalAttachment2}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.finicalAttachment2}"><span class="fa fa-solid fa-eye"></span></a>
                                                </span>
                                            </span>
                                        </c:if>
                                    </td>
                                </tr>

                                <tr>
                                    <td style="border:1px solid black;">3rd Year</td>
                                    <td style="border:1px solid black;">${vendorInformation.finical3}</td>
                                    <td style="border:1px solid black;">${vendorInformation.finicalAmount3}</td>
                                    <td style="border:1px solid black; word-break:break-word;">
                                        <c:if test="${vendorInformation.finicalAttachment3!=null && not empty vendorInformation.finicalAttachment3}">                                        
                                            <span class="file-wrapper">
                                                <span class="file-name text-break">${vendorInformation.finicalAttachment3}</span>
                                                <span class="file-actions">
                                                    <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.finicalAttachment3}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.finicalAttachment3}"><span class="fa fa-solid fa-eye"></span></a>
                                                </span>
                                            </span>
                                        </c:if>                                        
                                    </td>
                                </tr>
                            </tbody>

                        </table>
                        

                    </c:if>
                                            

                    <c:if test="${vendorInformation.finacialFlag == '3'}">

                        

                        <div class="table-responsive">
                            <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">  
                                <thead>                                                    
                                    <tr class="table-title">
                                        <td colspan="5" style="font-weight: bold; background-color: skyblue;text-align:center;">COMPANY REGISTRATION DETAILS</td>
                                    </tr>
                                    <tr>
                                        <th style="">Name</th> 
                                        <th style="">Document Number</th> 
                                        <th style="">Document File</th> 
                                        <th style="">Accept / Reject</th> 
                                        <th style="">Response</th> 
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th style="width: 20%;">GST No.</th>
                                        <td>
                                            <c:if test="${vendorInformation.gstStatus=='0'}"><strong>GST Not Available</strong></c:if>
                                            <c:if test="${vendorInformation.gstStatus != '0'}">
                                                <input id="gstinNo" name="gstinNo" class="input-field" maxlength="15" title="Enter valid GSTIN (e.g. 27ABCDE1234F1Z5)" value="${vendorInformation.gstinNo}" <c:if test="${vendorInformation.gstStatuss == 'accept'}">readonly</c:if> onchange="checkGST();" oninput="this.value=this.value.toUpperCase();"/>
                                                <span id="gstError" style="color:red; font-size: 11px;"></span>
                                            </c:if>
                                            <script>
                                                function checkGST() {

                                                    var input = document.getElementById("gstinNo");
                                                    var gst = input.value.trim().toUpperCase();
                                                    var error = document.getElementById("gstError");

                                                    var pattern = /^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z][1-9A-Z]Z[0-9A-Z]$/;

                                                    if (gst === "") {
                                                        error.innerText = "GST Number is required";
                                                        input.style.border = "1px solid red";
                                                        return false;
                                                    }

                                                    if (gst.length !== 15) {
                                                        error.innerText = "GST Number must be 15 characters";
                                                        input.style.border = "1px solid red";
                                                        return false;
                                                    }

                                                    if (!pattern.test(gst)) {
                                                        error.innerText = "Enter valid GSTIN (Ex: 27ABCDE1234F1Z5)";
                                                        input.style.border = "1px solid red";
                                                        return false;
                                                    }

                                                    error.innerText = "";
                                                    input.style.border = "1px solid #ccc";
                                                    return true;
                                                }
                                            </script>
                                        </td>
                                        <td> 
                                            <c:if test="${vendorInformation.gstinFile!=null && not empty vendorInformation.gstinFile}">                                        
                                                <span class="file-wrapper">
                                                    <span class="file-name text-break">${vendorInformation.gstinFile}</span>
                                                    <span class="file-actions">
                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.gstinFile}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.gstinFile}"><span class="fa fa-solid fa-eye"></span></a>
                                                    </span>
                                                </span>
                                            </c:if>
                                            <input type="hidden" class="input-field" id="gstinFile1" name="gstinFile1" value="${vendorInformation.gstinFile}">
                                            <c:if test="${vendorInformation.gstStatuss == 'reject'}">
                                                <input type="file" class="input-field" id="gstinFile" name="gstinFile"  onchange="checkFileSize(this)" required>
                                                <span id="fileErrorGstin" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>
                                            </c:if>
                                        </td>
                                        <td>                                                            
                                            <c:if test="${vendorInformation.gstStatuss == 'accept'}">
                                                <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                            </c:if>
                                            <c:if test="${vendorInformation.gstStatuss == 'reject'}">
                                                <span style="color:red; font-weight:bold;">&#10008; Rejected</span>
                                                <div>
                                                    <textarea class="textarea-field"  name="gstRemarkk" readonly rows="2" cols="30" >${vendorInformation.gstRemarkk}</textarea>
                                                </div>
                                            </c:if>                                                            
                                        </td>
                                        <td>
                                            <c:if test="${vendorInformation.gstStatuss == 'reject'}">
                                                <textarea class="textarea-field"  name="gstResponse" rows="2" cols="30" maxlength="250" required>${vendorInformation.gstResponse}</textarea>
                                            </c:if>
                                        </td>
                                    </tr>

                                    <tr>
                                        <th style="width: 20%;">PAN No.</th>
                                        <td>
                                            <c:if test="${vendorInformation.panStatus=='0'}"><strong>PAN Not Available</strong></c:if>
                                            <c:if test="${vendorInformation.panStatus!='0'}">
                                                <input id="panNo" name="panNo" class="input-field" maxlength="10" value="${vendorInformation.panNo}" <c:if test="${vendorInformation.panStatuss == 'accept'}">readonly</c:if> onchange="checkPAN();" oninput="this.value=this.value.toUpperCase();"/>
                                                <span id="panError" style="color:red; font-size: 11px;"></span>
                                            </c:if>
                                            <script>
                                                function checkPAN() {

                                                    var input = document.getElementById("panNo");
                                                    var pan = input.value.trim().toUpperCase();
                                                    var error = document.getElementById("panError");

                                                    var pattern = /^[A-Z]{5}[0-9]{4}[A-Z]{1}$/;

                                                    if (pan === "") {
                                                        error.innerText = "PAN Number is required";
                                                        input.style.border = "1px solid red";
                                                        return false;
                                                    }

                                                    if (pan.length !== 10) {
                                                        error.innerText = "PAN Number must be 10 characters";
                                                        input.style.border = "1px solid red";
                                                        return false;
                                                    }

                                                    if (!pattern.test(pan)) {
                                                        error.innerText = "Enter valid PAN Number (Ex: ABCDE1234F)";
                                                        input.style.border = "1px solid red";
                                                        return false;
                                                    }

                                                    error.innerText = "";
                                                    input.style.border = "1px solid #ccc";
                                                    return true;
                                                }
                                            </script>
                                        </td>
                                        <td>
                                            <c:if test="${vendorInformation.panFile!=null && not empty vendorInformation.panFile}">                                        
                                                <span class="file-wrapper">
                                                    <span class="file-name text-break">${vendorInformation.panFile}</span>
                                                    <span class="file-actions">
                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.panFile}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.panFile}"><span class="fa fa-solid fa-eye"></span></a>
                                                    </span>
                                                </span>
                                            </c:if>
                                            <input type="hidden" class="input-field" id="panFile1" name="panFile1" accept="" value="${vendorInformation.panFile}">
                                            <c:if test="${vendorInformation.panStatuss == 'reject'}">
                                                <input type="file" class="input-field" id="panFile" name="panFile" accept="" onchange="checkFileSize(this)" required>
                                                <span id="fileErrorPan" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>
                                            </c:if>
                                        </td>
                                        <td>
                                            <c:if test="${vendorInformation.panStatuss == 'accept'}">
                                                <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                            </c:if>
                                            <c:if test="${vendorInformation.panStatuss == 'reject'}">
                                                <span style="color:red; font-weight:bold;">&#10008; Rejected</span>
                                                <div>
                                                    <textarea class="textarea-field"  name="panRemarkk" readonly rows="2" cols="30" >${vendorInformation.panRemarkk}</textarea>
                                                </div>
                                            </c:if>
                                        </td> 
                                        <td>
                                            <c:if test="${vendorInformation.panStatus != '0' && vendorInformation.panStatuss == 'reject'}">
                                                <textarea class="textarea-field"  name="panResponse" rows="2" cols="30" maxlength="250" required>${vendorInformation.panResponse}</textarea>
                                            </c:if>
                                        </td>
                                    </tr>

                                    <tr>
                                        <th style="width: 20%;">MSME No.</th>
                                        <td>
                                            <c:if test="${vendorInformation.msmeStatus=='0'}"><strong>MSME Not Available</strong></c:if>
                                            <c:if test="${vendorInformation.msmeStatus!='0'}">
                                                <input id="service_tax" name="service_tax" class="input-field" maxlength="19"  value="${vendorInformation.service_tax}" <c:if test="${vendorInformation.msmeStatuss == 'accept'}">readonly</c:if> onchange="checkMSME();" oninput="this.value=this.value.toUpperCase();"/>
                                                <span id="msmeError" style="color:red; font-size: 11px;"></span>
                                            </c:if>
                                            <script>
                                                function checkMSME() {

                                                    var input = document.getElementById("service_tax");
                                                    var msme = input.value.trim().toUpperCase();
                                                    var error = document.getElementById("msmeError");

                                                    var pattern = /^UDYAM-[A-Z]{2}-[0-9]{2}-[0-9]{7}$/;

                                                    if (msme === "") {
                                                        error.innerText = "MSME Number is required";
                                                        input.style.border = "1px solid red";
                                                        return false;
                                                    }

                                                    if (msme.length !== 19) {
                                                        error.innerText = "MSME Number must be 19 characters";
                                                        input.style.border = "1px solid red";
                                                        return false;
                                                    }

                                                    if (!pattern.test(msme)) {
                                                        error.innerText = "Enter valid MSME No (Ex: UDYAM-GJ-12-0001234)";
                                                        input.style.border = "1px solid red";
                                                        return false;
                                                    }

                                                    error.innerText = "";
                                                    input.style.border = "1px solid #ccc";
                                                    return true;
                                                }
                                                </script>
                                        </td>
                                        <td>
                                            <c:if test="${vendorInformation.service_file!=null && not empty vendorInformation.service_file}">                                        
                                                <span class="file-wrapper">
                                                    <span class="file-name text-break">${vendorInformation.service_file}</span>
                                                    <span class="file-actions">
                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.service_file}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.service_file}"><span class="fa fa-solid fa-eye"></span></a>
                                                    </span>
                                                </span>
                                            </c:if>
                                            <input type="hidden" class="input-field" id="serviceTaxFile1" name="serviceTaxFile1" accept="" value="${vendorInformation.service_file}">
                                            <c:if test="${vendorInformation.msmeStatuss == 'reject'}">
                                                <input type="file" class="input-field" id="serviceTaxFile" name="serviceTaxFile" accept="" onchange="checkFileSize(this)" required>
                                                <span id="fileErrorServiceTax" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>
                                            </c:if>
                                        </td>
                                        <td>
                                            <c:if test="${vendorInformation.msmeStatuss == 'accept'}">
                                                <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                            </c:if>
                                            <c:if test="${vendorInformation.msmeStatuss == 'reject'}">
                                                <span style="color:red; font-weight:bold;">&#10008; Rejected</span>
                                                <div>
                                                    <textarea class="textarea-field"  name="msmeRemarkk" readonly rows="2" cols="30" >${vendorInformation.msmeRemarkk}</textarea>
                                                </div>
                                            </c:if>
                                        </td>
                                        <td>
                                            <c:if test="${vendorInformation.msmeStatuss == 'reject'}">
                                                <textarea class="textarea-field"  name="msmeResponse" rows="2" cols="30"  maxlength="250" required>${vendorInformation.msmeResponse}</textarea>
                                            </c:if>
                                        </td>
                                    </tr>

                                    <tr>
                                        <th style="width: 20%;">ESIC No.</th>
                                        <td>
                                            <c:if test="${vendorInformation.esicStatus=='0'}"><strong>ESIC Not Available</strong></c:if>
                                            <c:if test="${vendorInformation.esicStatus!='0'}">
                                                <input id="esicNo" name="esicNo" class="input-field"  value="${vendorInformation.esicNo}" <c:if test="${vendorInformation.esicStatuss == 'accept'}">readonly</c:if> onchange="checkESIC();" oninput="this.value=this.value.toUpperCase();"/>
                                                <span id="esicError" style="color:red; font-size: 11px;"></span>
                                            </c:if>
                                            <script>
                                                function checkESIC() {

                                                var input = document.getElementById("esicNo");
                                                var esic = input.value.trim();
                                                var error = document.getElementById("esicError");

                                                var esicPattern = /^\d{17}$/;

                                                if (esic === "") {
                                                    error.innerHTML = "ESIC Number is required";
                                                    input.style.border = "1px solid red";
                                                    return false;
                                                }

                                                if (!esicPattern.test(esic)) {
                                                    error.innerHTML = "Enter valid 17 digit ESIC No";
                                                    input.style.border = "1px solid red";
                                                    return false;
                                                }

                                                error.innerHTML = "";
                                                input.style.border = "1px solid #ccc";
                                                return true;
                                                }
                                            </script>
                                        </td>
                                        <td>
                                            <c:if test="${vendorInformation.esicFile!=null && not empty vendorInformation.esicFile}">                                        
                                                <span class="file-wrapper">
                                                    <span class="file-name text-break">${vendorInformation.esicFile}</span>
                                                    <span class="file-actions">
                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.esicFile}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.esicFile}"><span class="fa fa-solid fa-eye"></span></a>
                                                    </span>
                                                </span>
                                            </c:if>
                                            <input type="hidden" class="input-field" id="esicFile1" name="esicFile1" accept="" value="${vendorInformation.esicFile}">
                                            <c:if test="${vendorInformation.esicStatuss == 'reject'}">
                                                <input type="file" class="input-field" id="esicFile" name="esicFile" accept="" onchange="checkFileSize(this)" required>
                                                <span id="fileErrorEsicFile" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>
                                            </c:if>
                                        </td>
                                        <td>
                                            <c:if test="${vendorInformation.esicStatuss == 'accept'}">
                                                <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                            </c:if>
                                            <c:if test="${vendorInformation.esicStatuss == 'reject'}">
                                                <span style="color:red; font-weight:bold;">&#10008; Rejected</span>
                                                <div>
                                                    <textarea class="textarea-field"  name="esicRem" readonly rows="2" cols="30"  maxlength="250" required>${vendorInformation.esicRem}</textarea>
                                                </div>
                                            </c:if>
                                        </td>
                                        <td>
                                            <c:if test="${vendorInformation.esicStatuss == 'reject'}">
                                                <textarea class="textarea-field"  name="esicRes" rows="2" cols="30">${vendorInformation.esicRes}</textarea>
                                            </c:if>
                                        </td>
                                    </tr>

                                    <tr>
                                        <th style="width: 20%;">Import Export Code</th>
                                        <td>
                                            <c:if test="${vendorInformation.eccStatus == '0'}"><strong>ECC Not Available</strong></c:if>
                                            <c:if test="${vendorInformation.eccStatus != '0'}">
                                                <input id="iecCode" name="ecc_no" class="input-field" maxlength="10" value="${vendorInformation.ecc_no}" <c:if test="${vendorInformation.eccStatuss == 'accept'}">readonly</c:if> onchange="checkIEC();" oninput="this.value=this.value.toUpperCase();"/>
                                                <span id="iecError" style="color:red; font-size: 11px;"></span>
                                            </c:if>
                                            <script>
                                                function checkIEC() {

                                                    var input = document.getElementById("iecCode");
                                                    var iec = input.value.trim();
                                                    var iecError = document.getElementById("iecError");

                                                    var iecPattern = /^[0-9]{10}$/;

                                                    if (!iecPattern.test(iec)) {
                                                        iecError.innerHTML = "Enter a valid 10-digit Import Export Code";
                                                        input.style.border = "1px solid red";
                                                        return false;
                                                    }

                                                    iecError.innerHTML = "";
                                                    input.style.border = "1px solid #ccc";
                                                    return true;
                                                }
                                            </script>
                                        </td>
                                        <td> 
                                            <c:if test="${vendorInformation.ecc_file!=null && not empty vendorInformation.ecc_file}">                                        
                                                <span class="file-wrapper">
                                                    <span class="file-name text-break">${vendorInformation.ecc_file}</span>
                                                    <span class="file-actions">
                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.ecc_file}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.ecc_file}"><span class="fa fa-solid fa-eye"></span></a>
                                                    </span>
                                                </span>
                                            </c:if>
                                            <input type="hidden" class="input-field" id="eccNoFile1" name="eccNoFile1" accept="" value="${vendorInformation.ecc_file}">
                                            <c:if test="${vendorInformation.eccStatuss == 'reject'}">
                                                <input type="file" class="input-field" id="eccNoFile" name="eccNoFile" accept="" onchange="checkFileSize(this)" required>
                                                <span id="fileErrorServiceTax" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>
                                            </c:if>
                                        </td>
                                        <td>
                                            <c:if test="${vendorInformation.eccStatuss == 'accept'}">
                                                <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                            </c:if>
                                            <c:if test="${vendorInformation.eccStatuss == 'reject'}">
                                                <span style="color:red; font-weight:bold;">&#10008; Rejected</span>
                                                <div>
                                                    <textarea class="textarea-field"  name="eccRemarkk" readonly rows="2" cols="30" >${vendorInformation.eccRemarkk}</textarea>
                                                </div>
                                            </c:if>
                                        </td> 
                                        <td>
                                            <c:if test="${vendorInformation.eccStatus != '0' && vendorInformation.eccStatuss == 'reject'}">
                                                <textarea class="textarea-field"  name="eccResponse" rows="2" cols="30"  maxlength="250" required>${vendorInformation.eccResponse}</textarea>
                                            </c:if>
                                        </td>
                                    </tr>
                                </tbody>    
                            </table>
                        </div>
                            <script>
                                                function toggleMSME(showInput) {
                                                const inputField = document.getElementById("service_tax");
                                                        const udyamLabel = document.getElementById("udyamLabel");
                                                        const msmeInputWrapper = document.getElementById("msmeInputWrapper");
                                                        const declarationLetterSection = document.getElementById("declarationLetterSection");
                                                        msmeInputWrapper.style.display = showInput ? "block" : "none";
                                                        udyamLabel.style.display = showInput ? "block" : "none";
                                                        if (showInput) {
                                                inputField.setAttribute("required", "required");
                                                        declarationLetterSection.style.display = "none";
                                                } else {
                                                inputField.removeAttribute("required");
                                                        declarationLetterSection.style.display = "block";
                                                }
                                                }

                                        window.addEventListener('load', function() {
                                        const hasMSME = '<c:out value="${vendorInformation.service_tax}" default="" />' !== '';
                                                toggleMSME(hasMSME);
                                                document.getElementById(hasMSME ? "msmeOptionYes" : "msmeOptionNo").checked = true;
                                        });
                                                        function toggleEPFO(showInput) {
                                                        const inputField = document.getElementById("pfNo");
                                                                const declarationLetterSection0 = document.getElementById("declarationLetterSection0");
                                                                document.getElementById("epfoInputWrapper").style.display = showInput ? "block" : "none";
                                                                if (showInput) {
                                                        inputField.setAttribute("required", "required");
                                                                declarationLetterSection0.style.display = "none";
                                                        } else {
                                                        inputField.removeAttribute("required");
                                                                declarationLetterSection0.style.display = "block";
                                                        }
                                                        }

                                                window.addEventListener('load', function() {
                                                const hasEPFO = '<c:out value="${vendorInformation.pfNo}" default="" />' !== '';
                                                        toggleEPFO(hasEPFO);
                                                        document.getElementById(hasEPFO ? "epfoOptionYes" : "epfoOptionNo").checked = true;
                                                });
                                                        function toggleInputs(isYes) {
                                                        const inputFields = document.getElementById('inputFields');
                                                                inputFields.style.display = isYes ? 'block' : 'none';
                                                        }

                                                window.addEventListener('load', function() {
                                                const hasIEC = '<c:out value="${vendorInformation.ecc_no}" default="" />' !== '';
                                                        toggleInputs(hasIEC);
                                                        document.getElementById(hasIEC ? "toggleInputYes" : "toggleInputNo").checked = true;
                                                });</script>
                        <div class="table-responsive">
                            <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">  
                                <thead> 
                                    <tr class="table-title">
                                        <td colspan="4" style="font-weight: bold; background-color: skyblue;text-align:center;">PAYMENT / BANKING INFORMATION</td>
                                    </tr>
                                </thead>
                                <tr>
                                    <th style="width: 20%;">Account Number.<span style="color: red;font-size: 12px;">*</span></th>
                                    <td>
                                        <input name="accountNumber"  class="input-field" value="${vendorInformation.accountNumber}" oninput="this.value = this.value.replace(/\D/g, '')" required <c:if test="${vendorInformation.cancelChequeStatuss == 'accept'}">readonly</c:if>/>
                                        </td>
                                        <th style="width: 20%;">Bank Name<span style="color: red;font-size: 12px;">*</span></th>
                                        <td>
                                            <input name="bankName"  class="input-field"  value="${vendorInformation.bankName}" required <c:if test="${vendorInformation.cancelChequeStatuss == 'accept'}">readonly</c:if>/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="width: 20%;">Branch<span style="color: red;font-size: 12px;">*</span></th>
                                        <td>
                                            <input name="branch"  class="input-field"  value="${vendorInformation.branch}" required <c:if test="${vendorInformation.cancelChequeStatuss == 'accept'}">readonly</c:if>/>
                                        </td>
                                        <th style="width: 20%;">IFSC Code<span style="color: red;font-size: 12px;">*</span></th>
                                        <td>
                                            <input name="ifscCode"  class="input-field"  value="${vendorInformation.ifscCode}" required <c:if test="${vendorInformation.cancelChequeStatuss == 'accept'}">readonly</c:if>/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="width: 20%;">Swift Code (if any)</th>
                                        <td>
                                            <input name="swiftCode"  class="input-field"  value="${vendorInformation.swiftCode}" <c:if test="${vendorInformation.cancelChequeStatuss == 'accept'}">readonly</c:if>/>
                                        </td>
                                        <th style=""></th>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <th style="width: 20%;">Cancel Cheque<span style="color: red;font-size: 12px;">*</span></th>
                                        <td>
                                        <c:if test="${vendorInformation.cancelCheck!=null && not empty vendorInformation.cancelCheck}">                                        
                                            <span class="file-wrapper">
                                                <span class="file-name text-break">${vendorInformation.cancelCheck}</span>
                                                <span class="file-actions">
                                                    <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.cancelCheck}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.cancelCheck}"><span class="fa fa-solid fa-eye"></span></a>
                                                </span>
                                            </span>
                                        </c:if>
                                        <input type="hidden" class="input-field" id="cancelcheck1" name="cancelcheck1" value="${vendorInformation.cancelCheck}">
                                        <c:if test="${vendorInformation.cancelChequeStatuss == 'reject'}">
                                            <input type="file" class="input-field" id="cancelcheck" name="cancelcheck" onchange="checkFileSize(this)" required/>
                                            <span id="cancelCheckError" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:if test="${vendorInformation.cancelChequeStatuss == 'accept'}">
                                            <div style="margin-top:5vh;">
                                                <span style="color:green;  font-weight:bold;">&#10004; Accepted</span>
                                            </div>
                                        </c:if>
                                        <c:if test="${vendorInformation.cancelChequeStatuss == 'reject'}">
                                            <span style="color:red; font-weight:bold;">&#10008; Rejected</span>
                                            <div>
                                                <textarea class="textarea-field"  name="cancelChequeRemarkk" readonly rows="2" cols="30" >${vendorInformation.cancelChequeRemarkk}</textarea>
                                            </div>
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:if test="${vendorInformation.cancelChequeStatuss == 'reject'}">
                                            <textarea class="textarea-field"  name="cancelChequeResponse" required rows="2" maxlength="250" cols="30">${vendorInformation.cancelChequeResponse}</textarea>
                                        </c:if>                                                        
                                    </td>
                                </tr>
                            </table>
                        </div>

                        <div class="table-responsive">
                            <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">  
                                <thead>
                                    <tr class="table-title">
                                        <td colspan="5" style="font-weight: bold; background-color: skyblue;text-align:center;">FINANCIAL STATEMENT (PROFIT AND LOSS / BALANCE SHEET)</td>
                                    </tr>
                                </thead>
                                <tr>
                                    <th style="width: 20%;">Financial Year</th>
                                    <th style="width: 20%;">Financial Amount</th>
                                    <th style="width: 20%;">Financial Attachment</th>
                                    <th style="width: 20%;">Accept / Reject</th>
                                    <th style="width: 20%;">Response</th>
                                </tr>
                                <tr>
                                    <td><input name="finical1" id="finicalInput1" class="input-field" maxlength="30" value="${vendorInformation.finical1}" readonly/></td>
                                    <td><input name="finicalAmount1" oninput="formatNumber(this)" class="input-field" maxlength="30" value="${vendorInformation.finicalAmount1}" <c:if test="${vendorInformation.fin1Statuss == 'accept'}">readonly</c:if>/></td>
                                    <td>
                                        <c:if test="${vendorInformation.finicalAttachment1!=null && not empty vendorInformation.finicalAttachment1}">                                        
                                            <span class="file-wrapper">
                                                <span class="file-name text-break">${vendorInformation.finicalAttachment1}</span>
                                                <span class="file-actions">
                                                    <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.finicalAttachment1}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.finicalAttachment1}"><span class="fa fa-solid fa-eye"></span></a>
                                                </span>
                                            </span>
                                        </c:if>
                                        <input type="hidden" class="input-field" name="finicalAttachment11" value="${vendorInformation.finicalAttachment1}" />
                                        <c:if test="${vendorInformation.fin1Statuss == 'reject'}">
                                            <input type="file" class="input-field" name="finicalAttachment1" onchange="checkFileSize(this)" required/>
                                            <span id="fileError1" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:if test="${vendorInformation.fin1Statuss == 'accept'}">
                                            <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                        </c:if>
                                        <c:if test="${vendorInformation.fin1Statuss == 'reject'}">
                                            <span style="color:red; font-weight:bold;">&#10008; Rejected</span>
                                            <div>
                                                <textarea class="textarea-field"  name="fin1Remarkk" readonly rows="2" cols="30" >${vendorInformation.fin1Remarkk}</textarea>
                                            </div>
                                        </c:if>
                                    </td>
                                    <td>                                                        
                                        <c:if test="${vendorInformation.fin1Statuss == 'reject'}">
                                            <textarea class="textarea-field"  name="fin1Response" required rows="2" cols="30"  maxlength="250" required >${vendorInformation.fin1Response}</textarea>
                                        </c:if>
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <input name="finical2" id="finicalInput2" class="input-field" maxlength="30" value="${vendorInformation.finical2}" readonly/>
                                    </td>
                                    <td>
                                        <input name="finicalAmount2" oninput="formatNumber(this)" class="input-field" maxlength="30" value="${vendorInformation.finicalAmount2}" <c:if test="${vendorInformation.fin2Statuss == 'accept'}">readonly</c:if>/>
                                    </td>
                                    <td>
                                        <c:if test="${vendorInformation.finicalAttachment2!=null && not empty vendorInformation.finicalAttachment2}">                                        
                                            <span class="file-wrapper">
                                                <span class="file-name text-break">${vendorInformation.finicalAttachment2}</span>
                                                <span class="file-actions">
                                                    <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.finicalAttachment2}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.finicalAttachment2}"><span class="fa fa-solid fa-eye"></span></a>
                                                </span>
                                            </span>
                                        </c:if>
                                        <input type="hidden" class="input-field" name="finicalAttachment22" value="${vendorInformation.finicalAttachment2}" />
                                        <c:if test="${vendorInformation.fin2Statuss == 'reject'}">
                                            <input type="file" class="input-field"  name="finicalAttachment2"  onchange="checkFileSize(this)" required/>
                                            <span id="fileError2" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:if test="${vendorInformation.fin2Statuss == 'accept'}">
                                            <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                        </c:if>
                                        <c:if test="${vendorInformation.fin2Statuss == 'reject'}">
                                            <span style="color:red; font-weight:bold;">&#10008; Rejected</span>
                                            <div>
                                                <textarea class="textarea-field"   name="fin2Remarkk" readonly rows="2" cols="30" >${vendorInformation.fin2Remarkk}</textarea>
                                            </div>
                                        </c:if>
                                    </td>
                                    <td>                                                       
                                        <c:if test="${vendorInformation.fin2Statuss == 'reject'}">
                                            <textarea class="textarea-field"   name="fin2Response" required rows="2" cols="30"  maxlength="250" required>${vendorInformation.fin2Response}</textarea>
                                        </c:if>
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <input name="finical3" id="finicalInput3" class="input-field" maxlength="30" value="${vendorInformation.finical3}" readonly/>
                                    </td>
                                    <td>
                                        <input name="finicalAmount3" oninput="formatNumber(this)" class="input-field" maxlength="30" value="${vendorInformation.finicalAmount3}" <c:if test="${vendorInformation.fin3Statuss == 'accept'}">readonly</c:if>/>
                                    </td>
                                    <td>
                                        <c:if test="${vendorInformation.finicalAttachment3!=null && not empty vendorInformation.finicalAttachment3}">                                        
                                            <span class="file-wrapper">
                                                <span class="file-name text-break">${vendorInformation.finicalAttachment3}</span>
                                                <span class="file-actions">
                                                    <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.finicalAttachment3}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.finicalAttachment3}"><span class="fa fa-solid fa-eye"></span></a>
                                                </span>
                                            </span>
                                        </c:if>
                                        <input type="hidden" class="input-field" name="finicalAttachment33" value="${vendorInformation.finicalAttachment3}" />
                                        <c:if test="${vendorInformation.fin3Statuss == 'reject'}">
                                            <input type="file" class="input-field" name="finicalAttachment3" onchange="checkFileSize(this)" required/>
                                            <span id="fileError3" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:if test="${vendorInformation.fin3Statuss == 'accept'}">
                                            <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                        </c:if>
                                        <c:if test="${vendorInformation.fin3Statuss == 'reject'}">
                                            <span style="color:red; font-weight:bold;">&#10008; Rejected</span>
                                            <div>
                                                <textarea class="textarea-field"  name="fin3Remarkk" readonly rows="2" cols="30" >${vendorInformation.fin3Remarkk}</textarea>
                                            </div>
                                        </c:if>
                                    </td>
                                    <td>                                                        
                                        <c:if test="${vendorInformation.fin3Statuss == 'reject'}">
                                            <textarea class="textarea-field"  name="fin3Response" required rows="2" cols="30"  maxlength="250" required>${vendorInformation.fin3Response}</textarea>
                                        </c:if>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <script>
                                                    document.getElementById('finicals1').addEventListener('change', function () {
                                            var selectedValue = this.value;
                                                    var currentDate = new Date();
                                                    var currentYear = currentDate.getFullYear();
                                                    var startYear, endYear;
                                                    if (currentDate.getMonth() >= 3) {
                                            startYear = currentYear;
                                                    endYear = currentYear + 1;
                                            } else {
                                            startYear = currentYear - 1;
                                                    endYear = currentYear;
                                            }

                                            var finicalInput1 = document.getElementById('finicalInput1');
                                                    var finicalInput2 = document.getElementById('finicalInput2');
                                                    var finicalInput3 = document.getElementById('finicalInput3');
                                                    if (selectedValue === "Current Financial Year") {
                                            finicalInput1.value = startYear + " - " + endYear;
                                                    finicalInput2.value = (startYear - 1) + " - " + startYear;
                                                    finicalInput3.value = (startYear - 2) + " - " + (startYear - 1);
                                            } else if (selectedValue === "Last Financial Year") {
                                            finicalInput1.value = (startYear - 1) + " - " + startYear;
                                                    finicalInput2.value = (startYear - 2) + " - " + (startYear - 1);
                                                    finicalInput3.value = (startYear - 3) + " - " + (startYear - 2);
                                            } else {
                                            finicalInput1.value = "";
                                                    finicalInput2.value = "";
                                                    finicalInput3.value = "";
                                            }
                                            });
                                                    function formatNumber(input) {
                                                    let value = input.value.replace(/,/g, '').replace(/[^\d.]/g, '');
                                                            let parts = value.split('.');
                                                            parts[0] = parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ',');
                                                            input.value = parts.join('.');
                                                    }
                        </script>

                        <div class="row mb-3">
                            <div class="col-lg-12 col-md-6">
                                <div class="form-group comment-box">
                                    <label class="control-label">Comment :<span class="text-danger">*</span></label>
                                    <textarea name="comments" id="comment"  class="textarea-field comment" maxlength="250" rows="3" required="required"></textarea>
                                    
                                </div>
                            </div>
                        </div>
                        <div class="cta d-flex justify-content-center align-items-center">
                            <c:if test="${vendorInformation.finacialFlag=='3'}">
                                <button type="submit" class="btn theme-btn" id="submit2">Submit</button>
                            </c:if>
                        </div>
         
                    <script>
                                        function checkFileSize1(input) {
                                        const file = input.files[0];
                                                const maxSize = 5 * 1024 * 1024;
                                                const errorMessage = input.closest('.form-group').querySelector('span[id^="cancelCheckError"]');
                                                if (file && file.size > maxSize) {
                                        errorMessage.style.display = 'block'; input.value = '';
                                        } else {
                                        errorMessage.style.display = 'none';
                                        }
                                        }
                    </script>
                    <style>
                        .error-message {
                            color: red;
                            font-size: 0.85em;
                            margin-top: 2px;
                            position: relative;
                            min-height: 18px;
                        }
                    </style>
                    <script>
                        if (field.next(".error-message").length === 0) {
                            field.after('<div class="error-message"></div>');
                        }
            
                        field.next(".error-message").text("This field is required");
                    </script>
                    <script>
                         $(document).ready(function () {

                            function validateForm(e) {

                                var isValid = true;
                                var firstInvalidElement = null;

                                var requiredFields = $("input[required], textarea[required], select[required]");

                                requiredFields.css("border", "");
                                $(".error-message").remove();

                                requiredFields.each(function () {
                                    var field = $(this);

                                    if (field.is(':hidden') || field.parents(':hidden').length) {
                                        return true; 
                                    }

                                    if (field.val() === "" || field.val() === null || $.trim(field.val()) === "") {
                                        isValid = false;

                                        if (firstInvalidElement === null) {
                                            firstInvalidElement = field;
                                        }

                                        field.css("border", "1px solid red");

                                        var parentWrapper = field.closest('.phone-wrapper, .phone-wrapper1, .phone-equal, .phone-equals');

                                        if (parentWrapper.length > 0) {
                                            if (parentWrapper.find(".error-message").length === 0) {
                                                parentWrapper.append('<div class="error-message">This field is required</div>');
                                            }
                                        } else {
                                            if (field.next(".error-message").length === 0) {
                                                field.after('<div class="error-message">This field is required</div>');
                                            }
                                        }
                                    }
                                });

                                if (!isValid) {
                                    e.preventDefault();

                                    if (firstInvalidElement) {
                                        $('html, body').animate({
                                            scrollTop: firstInvalidElement.offset().top - 150
                                        }, 500, function () {
                                            firstInvalidElement.focus();
                                        });
                                    }


                                }
                            }                           

                            $("#submit2").click(function (e) {
                                validateForm(e);
                            });

                        });
                        </script>
                    
                    </c:if>
                        
                        <c:if test="${vendorInformation.status1 == 10 and vendorInformation.finacialFlag == 1}">
                            <div class="cta d-flex align-items-center justify-content-center" style="gap:15px;">
                                <button type="button" class="btn theme-btn" id="submit1" title="submit1"
                                        onclick="openReviewModal('${vendorInformation.id}', '${vendorInformation.companyName}')">Financial Submit</button>
                            </div>
                        </c:if>
                        
                        
                        
                        
                        
                        
                </form:form>
                        
               <c:if test="${vendorInformation.finacialFlag == '6'||vendorInformation.finacialFlag == '10'}">

                                    <form id="financialUpdateForm" action="vendorInformation.htm" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="act" value="FinancialDetailsUpdateProcess">
                        <input type="hidden" name="id" value="${vendorInformation.id}">         

   
                                  <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; ">
                                      <thead>
                                          <tr>
                                              <th colspan="${vendorInformation.finacialFlag == 10 ? '4' : '3'}" style=" background-color: skyblue; text-align: center;">
                                                  COMPANY REGISTRATION DETAILS
                                              </th>
                                          </tr>

                                      </thead>
                                      <tr>
                                          <th>GST No.<span class="text-danger">*</span></th>
                                          <td>                                                
                                              <input name="gstinNo" id="gstinNo" onchange="checkGST()" 
                                                     placeholder="Ex: 27ABCDE1234F1Z5" 
                                                     class="gst-field input-field" 
                                                     maxlength="15" 
                                                     title="Enter valid GSTIN (e.g. 27ABCDE1234F1Z5)" 
                                                     value="${vendorInformation.gstinNo}"  
                                                     oninput="this.value=this.value.toUpperCase();"
                                                     ${vendorFinancialApprovalDetails.gstStatus == 'accept' ? 'readonly' : ''} />
                                              <span id="gstError" style="color:red;"></span>
                                          </td>
                                          <td>
                                              <c:if test="${vendorInformation.gstinFile!='' &&  vendorInformation.gstinFile!=null}">
                                                  <span class="file-wrapper">
                                                      <span class="file-name text-break">${vendorInformation.gstinFile}</span>
                                                      <span class="file-actions">
                                                          <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.gstinFile}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                          <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.gstinFile}"><span class="fa fa-solid fa-eye"></span></a>
                                                      </span>
                                                  </span>
                                              </c:if>
                                              <input type="hidden" class="input-field" id="gstinFile1" name="gstinFile1" value="${vendorInformation.gstinFile}">                                                

                                              <c:choose>
                                                  <c:when test="${vendorInformation.finacialFlag == 10}">
                                                      <c:if test="${vendorFinancialApprovalDetails.gstStatus == 'reject'}">
                                                          <input type="file" class="input-field" id="gstinFile" name="gstinFile" required onchange="validateFileSize(this, 'fileErrorGstin');">                                                            
                                                      </c:if>
                                                  </c:when>
                                                  <c:otherwise>
                                                      <input type="file" class="input-field" id="gstinFile" name="gstinFile" <c:if test="${empty vendorFinancialApprovalDetails.gstStatus}"></c:if> onchange="validateFileSize(this, 'fileErrorGstin');">
                                                  </c:otherwise>
                                              </c:choose>
                                              <span id="fileErrorGstin" style="color:red;font-size:11px;display:none;">
                                                  * File should not exceed 5MB
                                              </span>                                                
                                          </td>

                                          <c:if test="${vendorInformation.finacialFlag == 10}">
                                              <td>                                                            
                                                  <c:if test="${vendorFinancialApprovalDetails.gstStatus == 'accept'}">
                                                      <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                  </c:if>
                                                  <c:if test="${vendorFinancialApprovalDetails.gstStatus == 'reject'}">
                                                      <span style="color:red; font-weight:bold;">&#10008; Rejected</span>
                                                      <div>
                                                          <textarea class="textarea-field" name="gstRemark" readonly rows="2" cols="30">${vendorFinancialApprovalDetails.gstRemark}</textarea>
                                                      </div>
                                                  </c:if> 
                                                  <c:if test="${vendorFinancialApprovalDetails.gstStatus == 'reject'}">
                                                      <div>                                                            
                                                          <textarea class="textarea-field" name="gstResponces" rows="2" cols="30" maxlength="250" required>${vendorFinancialApprovalDetails.gstResponces}</textarea>
                                                      </div>
                                                  </c:if>
                                              </td>
                                          </c:if>
                                      </tr>
                                        <script>
                                            function checkGST() {

                                                var input = document.getElementById("gstinNo");
                                                var gst = input.value.trim().toUpperCase();
                                                var error = document.getElementById("gstError");

                                                var pattern = /^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z][1-9A-Z]Z[0-9A-Z]$/;

                                                if (gst === "") {
                                                    error.innerText = "GST Number is required";
                                                    input.style.border = "1px solid red";
                                                    return false;
                                                }

                                                if (gst.length !== 15) {
                                                    error.innerText = "GST Number must be 15 characters";
                                                    input.style.border = "1px solid red";
                                                    return false;
                                                }

                                                if (!pattern.test(gst)) {
                                                    error.innerText = "Enter valid GSTIN (Ex: 27ABCDE1234F1Z5)";
                                                    input.style.border = "1px solid red";
                                                    return false;
                                                }

                                                error.innerText = "";
                                                input.style.border = "1px solid #ccc";
                                                return true;
                                            }
                                        </script>
                                        <script>                                                

                                                function toggleGST(showInput) {
                                                const inputField = document.getElementById("gstinNo");
                                                        const declarationLetterSection0 = document.getElementById("declarationLetterSection0");
                                                        const gstLabel = document.getElementById("gstLabel");
                                                        if (gstLabel) {
                                                gstLabel.textContent = showInput ? "GST No." : "";
                                                }

                                                document.getElementById("gstInputWrapper").style.display = showInput ? "block" : "none";
                                                        if (showInput) {
                                                inputField.setAttribute("required", "required");
                                                        declarationLetterSection0.style.display = "none";
                                                } else {
                                                inputField.removeAttribute("required");
                                                        declarationLetterSection0.style.display = "block";
                                                }
                                                }

                                                document.addEventListener('DOMContentLoaded', function () {

                                                var gstStatus = '<c:out value="${vendorInformation.gstStatus}" default="0" />';
                                                        var hasGST = gstStatus === '1';
                                                        var yesRadio = document.getElementById('gstOptionYes');
                                                        var noRadio = document.getElementById('gstOptionNo');
                                                        if (yesRadio) yesRadio.checked = hasGST;
                                                        if (noRadio) noRadio.checked = !hasGST;
                                                        toggleGST(hasGST);
                                                });</script>                                        

                                        <tr>
                                            <th id="panLabel" style="">PAN No.<span class="text-danger">*</span></th>

                                            <td>                                                
                                                <input name="panNo" id="panNo" onchange="checkPAN()" 
                                                       placeholder="Example: ABCDE1234F" 
                                                       class="input-field pan-field" 
                                                       maxlength="10" 
                                                       value="${vendorInformation.panNo}" 
                                                       oninput="this.value=this.value.toUpperCase();"
                                                       ${vendorFinancialApprovalDetails.panStatus == 'accept' ? 'readonly' : ''} />
                                                <span id="panError" style="color:red;"></span>
                                            </td>

                                            <td>
                                                <c:if test="${vendorInformation.panFile!='' &&  vendorInformation.panFile!=null}">
                                                    <span class="file-wrapper">
                                                        <span class="file-name text-break">${vendorInformation.panFile}</span>
                                                        <span class="file-actions">
                                                            <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.panFile}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                            <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.panFile}"><span class="fa fa-solid fa-eye"></span></a>

                                                        </span>
                                                    </span>
                                                </c:if>
                                                <input type="hidden" class="input-field" id="panFile1" name="panFile1" accept="" value="${vendorInformation.panFile}">                                               

                                                <c:choose>
                                                    <c:when test="${vendorInformation.finacialFlag == 10}">
                                                        <c:if test="${vendorFinancialApprovalDetails.panStatus == 'reject'}">
                                                            <input type="file" class="input-field" id="panFile" name="panFile" accept="" onchange="validateFileSize(this, 'fileErrorPan');" required>                                                            
                                                        </c:if>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="file" class="input-field" id="panFile" name="panFile" accept="" onchange="validateFileSize(this, 'fileErrorPan');"  <c:if test="${empty vendorInformation.panFile}">required="required"</c:if> >                                                            
                                                    </c:otherwise>
                                                </c:choose>
                                                <span id="fileErrorPan" style="color:red;font-size:11px;display:none;">
                                                    * File should not exceed 5MB
                                                </span>
                                            </td>                                            

                                            <c:if test="${vendorInformation.finacialFlag == 10}">
                                                <td>                                                            
                                                    <c:if test="${vendorFinancialApprovalDetails.panStatus == 'accept'}">
                                                        <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                    </c:if>
                                                    <c:if test="${vendorFinancialApprovalDetails.panStatus == 'reject'}">
                                                        <span style="color:red; font-weight:bold;">&#10008; Rejected</span>
                                                        <div>
                                                            <textarea class="textarea-field"  name="panRemark" readonly rows="2" cols="30" >${vendorFinancialApprovalDetails.panRemark}</textarea>
                                                        </div>
                                                    </c:if> 
                                                    <c:if test="${vendorFinancialApprovalDetails.panStatus == 'reject'}">
                                                        <div>                                                            
                                                            <textarea class="textarea-field"  name="panResponse" rows="2" cols="30" maxlength="250" required>${vendorFinancialApprovalDetails.panResponces}</textarea>
                                                        </div>
                                                    </c:if>
                                                </td>
                                            </c:if>     
                                        </tr>

                                        <script>
                                            function checkPAN() {

                                                var input = document.getElementById("panNo");
                                                var pan = input.value.trim().toUpperCase();
                                                var error = document.getElementById("panError");

                                                var pattern = /^[A-Z]{5}[0-9]{4}[A-Z]{1}$/;

                                                if (pan === "") {
                                                    error.innerText = "PAN Number is required";
                                                    input.style.border = "1px solid red";
                                                    return false;
                                                }

                                                if (pan.length !== 10) {
                                                    error.innerText = "PAN Number must be 10 characters";
                                                    input.style.border = "1px solid red";
                                                    return false;
                                                }

                                                if (!pattern.test(pan)) {
                                                    error.innerText = "Enter valid PAN Number (Ex: ABCDE1234F)";
                                                    input.style.border = "1px solid red";
                                                    return false;
                                                }

                                                error.innerText = "";
                                                input.style.border = "1px solid #ccc";
                                                return true;
                                            }
                                        </script>


                                        <tr>
                                            <th style="">Do you have MSME No? <span style="color: red;font-size: 12px;">*</span></th>

<%--                                                <input type="radio" class="radio-inline" id="msmeOptionYes" name="msmeOption"  <c:if test="${vendorInformation.msmeStatus == '1'}"> checked="true"</c:if> value="1" onchange="toggleMSME(true)"> <label for="msmeOptionYes">Yes</label>
     <input type="radio" class="radio-inline" id="msmeOptionNo" name="msmeOption" value="0"   <c:if test="${vendorInformation.msmeStatus == '0'}"> checked="true"</c:if> onchange="toggleMSME(false)"> <label for="msmeOptionNo">No</label>    --%>
                                                <td colspan="2">
                                                    <input type="radio" class="radio-inline" id="msmeOptionYes" name="msmeOption"  
                                                    <c:if test="${vendorInformation.msmeStatus == '1'}"> checked="true"</c:if> 
                                                        value="1" onchange="toggleMSME(true)"
                                                    ${vendorFinancialApprovalDetails.msmeStatus == 'accept' ? 'disabled' : ''}> 
                                                <label for="msmeOptionYes">Yes</label>

                                                <input type="radio" class="radio-inline" id="msmeOptionNo" name="msmeOption" value="0"   
                                                       <c:if test="${vendorInformation.msmeStatus == '0'}"> checked="true"</c:if> 
                                                           onchange="toggleMSME(false)"
                                                       ${vendorFinancialApprovalDetails.msmeStatus == 'accept' ? 'disabled' : ''}> 
                                                <label for="msmeOptionNo">No</label>    
                                                <c:if test="${vendorFinancialApprovalDetails.msmeStatus == 'accept'}"><input type="hidden" name="msmeOption" value="${vendorInformation.msmeStatus}"></c:if>
                                            </td>

                                        </tr>

                                            <tr>
                                                <th id="msmeLabel" style="">MSME No<span class="text-danger">*</span> </th>
                                                <td>
                                                    <div id="msmeInputWrapper" style="display: none;">
                                                        <input name="service_tax" id="service_tax" placeholder="Ex: UDYAM-GJ-12-0001234" onchange="checkMSME();"  
                                                               class="msme-field input-field" maxlength="19" value="${vendorInformation.service_tax}" 
                                                        oninput="this.value=this.value.toUpperCase();" 
                                                        ${vendorFinancialApprovalDetails.msmeStatus == 'accept' ? 'readonly' : ''} />
                                                    <div id="msmeError" style="color:red; font-size:13px; margin-top:5px;"></div>
                                                </div>
                                                <div id="declarationLetterSectionM">
                                                    MSME Declaration Letter<a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileDeviation&amp;fileName=msmeDeclarationFormat.docx">&nbsp;<span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/msmeDeclarationFormat.docx"><span class="fa fa-solid fa-eye"></span></a><br>
                                                    <span><b>(Kindly download the document, Fill all required details and upload it once finished.)</b></span>
                                                </div>
                                            </td>
                                            <td>
                                                <div id="policy">
                                                    <c:if test="${not empty vendorInformation.service_file}">
                                                        <span class="file-wrapper">
                                                            <span class="file-name text-break">${vendorInformation.service_file}</span>
                                                            <span class="file-actions">
                                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.service_file}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.service_file}"><span class="fa fa-solid fa-eye"></span></a>
                                                            </span>
                                                        </span>
                                                    </c:if>
                                                </div>
                                                <input type="hidden" class="input-field" id="serviceTaxFile1" name="serviceTaxFile1" accept="" value="${vendorInformation.service_file}">

                                                <c:choose>
                                                    <c:when test="${vendorInformation.finacialFlag == 10}">
                                                        <c:if test="${vendorFinancialApprovalDetails.msmeStatus == 'reject'}">
                                                            <input type="file" class="input-field" id="serviceTaxFile" name="serviceTaxFile" accept="" onchange="validateFileSize(this,'fileErrorMsme');"  required>
                                                        </c:if>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="file" class="input-field" id="serviceTaxFile" name="serviceTaxFile" accept="" onchange="validateFileSize(this,'fileErrorMsme');"  <c:if test="${empty vendorInformation.service_file}">required="required"</c:if> >                                                            
                                                    </c:otherwise>
                                                </c:choose>
                                                <div id="udyamLabel">
                                                    <strong><span style="font-size: 12px; ">(Udyam certificate)</span></strong>
                                                </div>
                                                <span id="fileErrorMsme" style="color:red;font-size:11px;display:none;">
                                                    * File should not exceed 5MB
                                                </span>
                                            </td> 

                                            <c:if test="${vendorInformation.finacialFlag == 10}">
                                                <td>                                                            
                                                    <c:if test="${vendorFinancialApprovalDetails.msmeStatus == 'accept'}">
                                                        <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                    </c:if>
                                                    <c:if test="${vendorFinancialApprovalDetails.msmeStatus == 'reject'}">
                                                        <span style="color:red; font-weight:bold;">&#10008; Rejected</span>
                                                        <div>
                                                            <textarea class="textarea-field"  name="msmeRemark" readonly rows="2" cols="30" >${vendorFinancialApprovalDetails.msmeRemark}</textarea>
                                                        </div>
                                                    </c:if> 
                                                    <c:if test="${vendorFinancialApprovalDetails.msmeStatus == 'reject'}">
                                                        <div>                                                            
                                                            <textarea class="textarea-field"  name="msmeResponces" rows="2" cols="30" maxlength="250" required>${vendorFinancialApprovalDetails.msmeResponces}</textarea>
                                                        </div>
                                                    </c:if>
                                                </td>
                                            </c:if>  
                                        </tr>
                                         <script>
                                    function checkMSME() {

                                        var input = document.getElementById("service_tax");
                                        var msme = input.value.trim().toUpperCase();
                                        var error = document.getElementById("msmeError");

                                        var pattern = /^UDYAM-[A-Z]{2}-[0-9]{2}-[0-9]{7}$/;

                                        if (msme === "") {
                                            error.innerText = "MSME Number is required";
                                            input.style.border = "1px solid red";
                                            return false;
                                        }

                                        if (msme.length !== 19) {
                                            error.innerText = "MSME Number must be 19 characters";
                                            input.style.border = "1px solid red";
                                            return false;
                                        }

                                        if (!pattern.test(msme)) {
                                            error.innerText = "Enter valid MSME No (Ex: UDYAM-GJ-12-0001234)";
                                            input.style.border = "1px solid red";
                                            return false;
                                        }

                                        // valid hoy to
                                        error.innerText = "";
                                        input.style.border = "1px solid #ccc";
                                        return true;
                                    }
                                    </script>
                                            <script>                                              
                                                function toggleMSME(showInput) {
                                                    const inputField = document.getElementById("service_tax");
                                                    const msmeLabel = document.getElementById("msmeLabel");
                                                    const udyamLabel = document.getElementById("udyamLabel");
                                                    if (msmeLabel) {
                                                        msmeLabel.textContent = showInput ? "MSME No." : "MSME Deviation Policy";
                                                    }

                                                    document.getElementById("msmeInputWrapper").style.display = showInput ? "block" : "none";
                                                    document.getElementById("declarationLetterSectionM").style.display = showInput ? "none" : "block";
                                                    document.getElementById("udyamLabel").style.display = showInput ? "block" : "none";
                                                        if (showInput) {
                                                inputField.setAttribute("required", "required");
                                                } else {
                                                inputField.removeAttribute("required");
//                                                inputField.value = "";
                                                }
                                                }
                                                document.addEventListener('DOMContentLoaded', function () {

                                                var msmeStatus = '<c:out value="${vendorInformation.msmeStatus}" default="0" />';
                                                        var hasMSME = msmeStatus === '1';
                                                        var yesMSMERadio = document.getElementById('msmeOptionYes');
                                                        var noMSMERadio = document.getElementById('msmeOptionNo');
                                                        if (yesMSMERadio) yesMSMERadio.checked = hasMSME;
                                                        if (noMSMERadio) noMSMERadio.checked = !hasMSME;
                                                        toggleMSME(hasMSME);
                                                });
                                                </script>

                                                <tr>
                                                    <th style="">Do you have ESIC No? <span style="color: red;font-size: 12px;">*</span></th>
                                                    <td colspan="2">
                                                        <input type="radio" class="radio-inline" id="esicOptionYes" name="esicOption"  
                                                               <c:if test="${vendorInformation.esicStatus == '1'}"> checked</c:if> 
                                                                   value="1" onchange="toggleESIC(true)"
                                                               ${vendorFinancialApprovalDetails.esicStatus == 'accept' ? 'disabled' : ''}> 
                                                        <label for="esicOptionYes">Yes</label>

                                                        <input type="radio" class="radio-inline" id="esicOptionNo" name="esicOption" value="0"   
                                                               <c:if test="${vendorInformation.esicStatus == '0'}"> checked</c:if> 
                                                                   onchange="toggleESIC(false)"
                                                               ${vendorFinancialApprovalDetails.esicStatus == 'accept' ? 'disabled' : ''}> 
                                                        <label for="esicOptionNo">No</label>    
                                                        <c:if test="${vendorFinancialApprovalDetails.esicStatus == 'accept'}"><input type="hidden" name="esicOption" value="${vendorInformation.esicStatus}"></c:if>
                                                    </td>
                                                </tr>
                                        <tr>
                                            <th id="esicLabel" style="">ESIC No.<span style="color: red;font-size: 12px;">*</span></th>
                                            <td>
                                                <div id="esicInputWrapper" style="display: none;">                                                    
                                                    <input name="esicNo" id="esicNo"  placeholder="Ex: 12345678901234567"  onchange="checkESIC();"   
                                                           class="input-field" value="${vendorInformation.esicNo}" 
                                                    ${vendorFinancialApprovalDetails.esicStatus == 'accept' ? 'readonly' : ''} />
                                                <div id="esicError" style="color:red; font-size:13px; margin-top:5px;"></div>
                                            </div>
                                            <div id="declarationLetterSectionE">
                                                ESIC Declaration Letter<a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileDeviation&amp;fileName=epfoEsicDeclarationFormate.docx">&nbsp;<span class="fa fa-download"></span></a>
                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/epfoEsicDeclarationFormate.docx"><span class="fa fa-solid fa-eye"></span></a><br>
                                                <span><b>(Kindly download the document, Fill all required details and upload it once finished.)</b></span>
                                            </div>
                                        </td>

                                        <td>
                                            <c:if test="${vendorInformation.esicFile!='' &&  vendorInformation.esicFile!=null}">
                                                <span class="file-wrapper">
                                                    <span class="file-name text-break">${vendorInformation.esicFile}</span>
                                                    <span class="file-actions">
                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.esicFile}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.esicFile}"><span class="fa fa-solid fa-eye"></span></a>
                                                    </span>
                                                </span>
                                            </c:if>
                                            <input type="hidden" class="input-field" id="esicFile1" name="esicFile1" accept="" value="${vendorInformation.esicFile}">                                                

                                            <c:choose>
                                                <c:when test="${vendorInformation.finacialFlag == 10}">
                                                    <c:if test="${vendorFinancialApprovalDetails.esicStatus == 'reject'}">
                                                        <input type="file" class="input-field" id="esicFile" name="esicFile" accept="" onchange="validateFileSize(this, 'fileErrorEsic');" required />                                                            
                                                    </c:if>
                                                </c:when>
                                                <c:otherwise>
                                                    <input type="file" class="input-field" id="esicFile" name="esicFile" accept="" onchange="validateFileSize(this, 'fileErrorEsic');"  <c:if test="${empty vendorInformation.esicFile}">required="required"</c:if> />                                                            
                                                </c:otherwise>
                                            </c:choose>
                                            <span id="fileErrorEsic" style="color:red;font-size:11px;display:none;">
                                                * File should not exceed 5MB
                                            </span>
                                        </td>

                                        <c:if test="${vendorInformation.finacialFlag == 10}">
                                            <td>                                                            
                                                <c:if test="${vendorFinancialApprovalDetails.esicStatus == 'accept'}">
                                                    <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                </c:if>
                                                <c:if test="${vendorFinancialApprovalDetails.esicStatus == 'reject'}">
                                                    <span style="color:red; font-weight:bold;">&#10008; Rejected</span>
                                                    <div>
                                                        <textarea class="textarea-field"  name="esicRemark" readonly rows="2" cols="30" >${vendorFinancialApprovalDetails.esicRemark}</textarea>
                                                    </div>
                                                </c:if> 
                                                <c:if test="${vendorFinancialApprovalDetails.esicStatus == 'reject'}">
                                                    <div>                                                            
                                                        <textarea class="textarea-field"  name="esicResponce" rows="2" cols="30" maxlength="250" required>${vendorFinancialApprovalDetails.esicResponce}</textarea>
                                                    </div>
                                                </c:if>
                                            </td>
                                        </c:if>


                                        </tr>
                                        <script>
                                            function checkESIC() {

                                            var input = document.getElementById("esicNo");
                                            var esic = input.value.trim();
                                            var error = document.getElementById("esicError");

                                            var esicPattern = /^\d{17}$/;

                                            if (esic === "") {
                                                error.innerHTML = "ESIC Number is required";
                                                input.style.border = "1px solid red";
                                                return false;
                                            }

                                            if (!esicPattern.test(esic)) {
                                                error.innerHTML = "Enter valid 17 digit ESIC No";
                                                input.style.border = "1px solid red";
                                                return false;
                                            }

                                            error.innerHTML = "";
                                            input.style.border = "1px solid #ccc";
                                            return true;
                                            }
                                        </script>

                                        <script>
                                            function toggleESIC(showInput) {
                                                const inputField = document.getElementById("esicNo");
                                                const esicLabel = document.getElementById("esicLabel");
                                                if (esicLabel) {
                                                    esicLabel.textContent = showInput ? "ESIC No." : "ESIC Deviation Policy";
                                                }
                                                    document.getElementById("esicInputWrapper").style.display = showInput ? "block" : "none";
                                                    document.getElementById("declarationLetterSectionE").style.display = showInput ? "none" : "block";
                                                if (showInput) {
                                                    inputField.setAttribute("required", "required");
                                                } else {
                                                    inputField.removeAttribute("required");
//                                                    inputField.value = "";
                                                }
                                            }
                                                document.addEventListener('DOMContentLoaded', function () {

                                                    var esicStatus = '<c:out value="${vendorInformation.esicStatus}" default="0" />';
                                                    var hasESIC= esicStatus === '1';
                                                    var yesESICRadio = document.getElementById('esicOptionYes');
                                                    var noESICRadio = document.getElementById('esicOptionNo');
                                                    if (yesESICRadio) yesESICRadio.checked = hasESIC;
                                                    if (noESICRadio) noESICRadio.checked = !hasESIC;
                                                    toggleESIC(hasESIC);
                                                });
                                        </script>

                                        <tr>
                                            <th style="">Do you have EPFO No? <span style="color: red;font-size: 12px;">*</span></th>
                                            <td colspan="2">
                                                <input type="radio" class="radio-inline" id="epfoOptionYes" name="epfoOption"  value="1"  
                                                       <c:if test="${vendorInformation.epfoStatus == '1'}"> checked="true"</c:if> 
                                                           onchange="toggleEPFO(true)"
                                                       ${vendorFinancialApprovalDetails.epfoStatus == 'accept' ? 'disabled' : ''}> 
                                                <label for="epfoOptionYes">Yes</label>

                                                <input type="radio" class="radio-inline" id="epfoOptionNo" name="epfoOption" value="0"  
                                                       <c:if test="${vendorInformation.epfoStatus == '0'}"> checked="true"</c:if> 
                                                           onchange="toggleEPFO(false)"
                                                       ${vendorFinancialApprovalDetails.epfoStatus == 'accept' ? 'disabled' : ''}> 
                                                <label for="epfoOptionNo">No</label> 
                                                <c:if test="${vendorFinancialApprovalDetails.epfoStatus == 'accept'}"><input type="hidden" name="epfoOption" value="${vendorInformation.epfoStatus}"></c:if>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th id="epfoLabel" style="">EPFO No.</th>
                                            <td>
                                                <div id="epfoInputWrapper" style="display: none;">
                                                    <input type="text" id="epfoNo" name="pfNo" placeholder="Ex: GJ/SRT/1234567/000/0001" 
                                                           class="input-field" value="${vendorInformation.pfNo}" onchange="checkEPFO()" 
                                                    ${vendorFinancialApprovalDetails.epfoStatus == 'accept' ? 'readonly' : ''} />
                                                <span id="epfoError" style="color:red;font-size:12px;"></span>
                                            </div>
                                            <div id="declarationLetterSectionP">
                                                EPFO Declaration Letter<a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileDeviation&amp;fileName=epfoEsicDeclarationFormate.docx">&nbsp;<span class="fa fa-download"></span></a>
                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/epfoEsicDeclarationFormate.docx"><span class="fa fa-solid fa-eye"></span></a><br>
                                                <span><b>(Kindly download the document, Fill all required details and upload it once finished.)</b></span>
                                            </div>
                                        </td>
                                        <td>
                                            <div id="policy">
                                                <c:if test="${not empty vendorInformation.pfAttachment}">
                                                    <span class="file-wrapper">
                                                        <span class="file-name text-break">${vendorInformation.pfAttachment}</span>
                                                        <span class="file-actions">
                                                            <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.pfAttachment}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                            <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.pfAttachment}"><span class="fa fa-solid fa-eye"></span></a>
                                                        </span>
                                                    </span>
                                                </c:if>
                                            </div>

                                            <span id="cancelCheckError5" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>
                                            <input type="hidden" class="input-field" id="pfAttachment1" name="pfAttachment1" accept="" value="${vendorInformation.pfAttachment}">
                                            <c:choose>
                                                <c:when test="${vendorInformation.finacialFlag == 10}">
                                                    <c:if test="${vendorFinancialApprovalDetails.epfoStatus == 'reject'}">
                                                        <input type="file" class="input-field" id="pfAttachment" name="pfAttachment" accept="" onchange="validateFileSize(this,'fileErrorEpfo');" required/>                                                            
                                                    </c:if>
                                                </c:when>
                                                <c:otherwise>
                                                    <input type="file" class="input-field" id="pfAttachment" name="pfAttachment" accept="" onchange="validateFileSize(this,'fileErrorEpfo');"  <c:if test="${empty vendorInformation.pfAttachment}">required="required"</c:if> />                                                            
                                                </c:otherwise>
                                            </c:choose>
                                            <span id="fileErrorEpfo" style="color:red;font-size:11px;display:none;">
                                                * File should not exceed 5MB
                                            </span>


                                        </td>                                            

                                        <c:if test="${vendorInformation.finacialFlag == 10}">
                                            <td>                                                            
                                                <c:if test="${vendorFinancialApprovalDetails.epfoStatus == 'accept'}">
                                                    <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                </c:if>
                                                <c:if test="${vendorFinancialApprovalDetails.epfoStatus == 'reject'}">
                                                    <span style="color:red; font-weight:bold;">&#10008; Rejected</span>
                                                    <div>
                                                        <textarea class="textarea-field"  name="epfoRemark" readonly rows="2" cols="30" >${vendorFinancialApprovalDetails.epfoRemark}</textarea>
                                                    </div>
                                                </c:if> 
                                                <c:if test="${vendorFinancialApprovalDetails.epfoStatus == 'reject'}">
                                                    <div>                                                            
                                                        <textarea class="textarea-field"  name="epfoResponces" rows="2" cols="30" maxlength="250" required>${vendorFinancialApprovalDetails.epfoResponces}</textarea>
                                                    </div>
                                                </c:if>
                                            </td>
                                        </c:if>   


                                        </tr>
                                        <script>
                                            function checkEPFO() {

                                                var input = document.getElementById("epfoNo");
                                                var epfo = input.value.trim().toUpperCase();
                                                var error = document.getElementById("epfoError");

                                                var epfoPattern = /^[A-Z]{2}\\/[A-Z]{2,5}\\/[0-9]{1,7}\\/[0-9]{4}$/;

                                                if (epfo === "") {
                                                    error.innerHTML = "EPFO Number is required";
                                                    input.style.border = "1px solid red";
                                                    return false;
                                                }

                                                if (!epfoPattern.test(epfo)) {
                                                    error.innerHTML = "Enter valid EPFO No (Ex: GJ/SRT/1234567/000/0001)";
                                                    input.style.border = "1px solid red";
                                                    return false;
                                                }

                                                error.innerHTML = "";
                                                input.style.border = "1px solid #ccc";
                                                return true;
                                            }
                                        </script>
                                        <script>
                                            
                                            function toggleEPFO(showInput) {
                                                const inputField = document.getElementById("epfoNo");
                                                        const declarationLetterSection0 = document.getElementById("declarationLetterSection0");
                                                        const epfoLabel = document.getElementById("epfoLabel");
                                                        if (epfoLabel) {
                                                epfoLabel.textContent = showInput ? "EPFO No." : "EPFO Deviation Policy";
                                                }

                                                document.getElementById("epfoInputWrapper").style.display = showInput ? "block" : "none";
                                                document.getElementById("declarationLetterSectionP").style.display = showInput ? "none" : "block";
                                                        if (showInput) {
                                                inputField.setAttribute("required", "required");
                                                        declarationLetterSection0.style.display = "none";
                                                } else {
                                                inputField.removeAttribute("required");
//                                                inputField.value = "";
                                                        declarationLetterSection0.style.display = "block";
                                                }
                                                }
                                            document.addEventListener('DOMContentLoaded', function () {
                                                var epfoStatus = '<c:out value="${vendorInformation.epfoStatus}" default="0" />';
                                                        var hasEPFO = epfoStatus === '1';
                                                        var yesEPFORadio = document.getElementById('epfoOptionYes');
                                                        var noEPFORadio = document.getElementById('epfoOptionNo');
                                                        if (yesEPFORadio) yesEPFORadio.checked = hasEPFO;
                                                        if (noEPFORadio) noEPFORadio.checked = !hasEPFO;
                                                        toggleEPFO(hasEPFO);
                                                });
                                        </script>

                                        <tr>
                                            <th style="">Do you Have Import Export Code? <span style="color: red;font-size: 12px;">*</span></th>
                                            <td colspan="2">
                                                <input type="radio" class="radio-inline" id="iecOptionYes" name="eccOption"  value="1"  
                                                       <c:if test="${vendorInformation.eccStatus=='1'}"> checked="true"</c:if> 
                                                           onchange="toggleIEC(true);"
                                                       ${vendorFinancialApprovalDetails.iecStatus == 'accept' ? 'disabled' : ''}> 
                                                <label for="iecOptionYes">Yes</label>

                                                <input type="radio" class="radio-inline" id="iecOptionNo" name="eccOption" value="0" 
                                                       <c:if test="${vendorInformation.eccStatus=='0'}"> checked="true"</c:if> 
                                                           onchange="toggleIEC(false);"
                                                       ${vendorFinancialApprovalDetails.iecStatus == 'accept' ? 'disabled' : ''}> 
                                                <label for="iecOptionNo">No</label>
                                                <c:if test="${vendorFinancialApprovalDetails.iecStatus == 'accept'}"><input type="hidden" name="eccOption" value="${vendorInformation.eccStatus}"></c:if>
                                            </td>
                                        </tr>
                                        <tr id="iecRow">
                                            <th style="">Import Export Code.</th>
                                            <td>
                                                <input name="ecc_no" id="ecc_no" class="input-field" value="${vendorInformation.ecc_no}" maxlength="10"
                                                   ${vendorFinancialApprovalDetails.iecStatus == 'accept' ? 'readonly' : ''} />
                                        </td>
                                        <td>
                                            <c:if test="${not empty vendorInformation.ecc_file}">
                                                <span class="file-wrapper">
                                                    <span class="file-name text-break">${vendorInformation.ecc_file}</span>
                                                    <span class="file-actions">
                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.ecc_file}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.ecc_file}"><span class="fa fa-solid fa-eye"></span></a>
                                                    </span>
                                                </span>
                                            </c:if>

                                            <input type="hidden" class="input-field" id="eccNoFile1" name="eccNoFile1" accept="" value="${vendorInformation.ecc_file}">                                                

                                            <c:choose>
                                                <c:when test="${vendorInformation.finacialFlag == 10}">
                                                    <c:if test="${vendorFinancialApprovalDetails.iecStatus == 'reject'}">
                                                        <input type="file" class="input-field" id="eccNoFile" name="eccNoFile" accept="" onchange="validateFileSize(this,'fileErrorEcc');" required/>                                                            
                                                    </c:if>
                                                </c:when>
                                                <c:otherwise>
                                                    <input type="file" class="input-field" id="eccNoFile" name="eccNoFile" accept="" onchange="validateFileSize(this,'fileErrorEcc');"  <c:if test="${empty vendorInformation.ecc_file}">required="required"</c:if> />                                                            
                                                </c:otherwise>
                                            </c:choose>
                                            <span id="fileErrorEcc" style="color:red;font-size:11px;display:none;">
                                                * File should not exceed 5MB
                                            </span>
                                        </td>

                                        <c:if test="${vendorInformation.finacialFlag == 10}">
                                            <td>                                                            
                                                <c:if test="${vendorFinancialApprovalDetails.iecStatus == 'accept'}">
                                                    <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                </c:if>
                                                <c:if test="${vendorFinancialApprovalDetails.iecStatus == 'reject'}">
                                                    <span style="color:red; font-weight:bold;">&#10008; Rejected</span>
                                                    <div>
                                                        <textarea class="textarea-field"  name="iecRemark" readonly rows="2" cols="30" >${vendorFinancialApprovalDetails.iecRemark}</textarea>
                                                    </div>
                                                </c:if> 
                                                <c:if test="${vendorFinancialApprovalDetails.iecStatus == 'reject'}">
                                                    <div>                                                            
                                                        <textarea class="textarea-field"  name="iecReponces" rows="2" cols="30" maxlength="250" required>${vendorFinancialApprovalDetails.iecReponces}</textarea>
                                                    </div>
                                                </c:if>
                                            </td>
                                        </c:if>  
                                        </tr>
                                        <script>
                                            function toggleIEC(isYes) {
                                                const iecRow = document.getElementById("iecRow");
                                                const eccNo = document.getElementById("ecc_no");
                                                const eccFile = document.getElementById("eccNoFile");
                                                const existingFile = document.getElementById("eccNoFile1");

                                                if (isYes) {
                                                    iecRow.style.display = "table-row";
                                                    eccNo.setAttribute("required", "required");
                                                    if (!existingFile || existingFile.value === "") {
                                                        eccFile.setAttribute("required", "required");
                                                    } else {
                                                        eccFile.removeAttribute("required");
                                                        inputField.value = "";
                                                    }
                                                } else {
                                                    iecRow.style.display = "none";
                                                    eccNo.removeAttribute("required");
                                                    eccFile.removeAttribute("required");
//                                                    eccNo.value = "";
//                                                    eccFile.value = "";
                                                }
                                            } 

                                            document.addEventListener('DOMContentLoaded', function () {

                                            var eccStatus = '<c:out value="${vendorInformation.eccStatus}" default="0" />';
                                                    var hasIEC = eccStatus === '1';
                                                    var yesIECRadio = document.getElementById('iecOptionYes');
                                                    var noIECRadio = document.getElementById('iecOptionNo');
                                                    if (yesIECRadio) yesIECRadio.checked = hasIEC;
                                                    if (noIECRadio) noIECRadio.checked = !hasIEC;
                                                    toggleIEC(hasIEC);
                                            });
                                        </script>
                                        <br>
                                  </table>
    
                         
                                            <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; ">
                                                <thead>
                                                    <tr>
                                                        <th colspan="4" style=" background-color: skyblue; text-align: center;">
                                                            PAYMENT / BANKING DETAILS
                                                        </th>
                                                    </tr>
                                                </thead>
                                                <tr>
                                                    <th>
                                                        Account Number.<span style="color: red;font-size: 12px;">*</span>
                                                    </th>
                                                    <td>
                                                        <input name="accountNumber" class="input-field" oninput="this.value = this.value.replace(/\D/g, '')" 
                                                               value="${vendorInformation.accountNumber}" required
                                                               ${vendorFinancialApprovalDetails.cancelCheckStatus == 'accept' ? 'readonly' : ''}/>
                                                    </td>
                                                    <th>
                                                        Bank Name<span style="color: red;font-size: 12px;">*</span>
                                                    </th>
                                                    <td>
                                                        <input name="bankName" class="input-field" value="${vendorInformation.bankName}" required
                                                               ${vendorFinancialApprovalDetails.cancelCheckStatus == 'accept' ? 'readonly' : ''}/>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <th>
                                                        Branch<span style="color: red;font-size: 12px;">*</span>
                                                    </th>
                                                    <td>
                                                        <input name="branch" class="input-field" value="${vendorInformation.branch}" required
                                                               ${vendorFinancialApprovalDetails.cancelCheckStatus == 'accept' ? 'readonly' : ''}/>
                                                    </td>
                                                    <th>
                                                        IFSC Code<span style="color: red;font-size: 12px;">*</span>
                                                    </th>
                                                    <td>
                                                        <input  name="ifscCode"  class="input-field" value="${vendorInformation.ifscCode}" required 
                                                                ${vendorFinancialApprovalDetails.cancelCheckStatus == 'accept' ? 'readonly' : ''}/>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <th>
                                                        Swift Code (if any)
                                                    </th>
                                                    <td>
                                                        <input  name="swiftCode"  class="input-field" value="${vendorInformation.swiftCode}" 
                                                                ${vendorFinancialApprovalDetails.cancelCheckStatus == 'accept' ? 'readonly' : ''}/>
                                                    </td>
                                                    <th></th>
                                                    <td></td>
                                                </tr>
                                                <tr>
                                                    <th>
                                                        Cancel Cheque<span style="color: red;font-size: 12px;">*</span>
                                                    </th>
                                                    <td>
                                                        <div class="">
                                                            <c:if test="${vendorInformation.cancelCheck!='' && vendorInformation.cancelCheck!=null}">

                                                                <span class="file-wrapper">
                                                                    <span class="file-name text-break">${vendorInformation.cancelCheck}</span>
                                                                    <span class="file-actions">
                                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.cancelCheck}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.cancelCheck}"><span class="fa fa-solid fa-eye"></span></a>
                                                                    </span>
                                                                </span>

                                                            </c:if>

                                                            <c:choose>
                                                                <c:when test="${vendorInformation.finacialFlag == 10}">
                                                                    <c:if test="${vendorFinancialApprovalDetails.cancelCheckStatus == 'reject'}">
                                                                        <input type="file" class="input-field" id="cancelcheck" name="cancelcheck" required onchange="validateFileSize(this, 'fileErrorCancleCheck');">                                                            
                                                                    </c:if>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <input type="file" class="input-field" id="cancelcheck" name="cancelcheck" <c:if test="${empty vendorInformation.cancelCheck}">required="true"</c:if>  onchange="validateFileSize(this, 'fileErrorCancleCheck');">                                                            
                                                                </c:otherwise>
                                                            </c:choose>
                                                            <input type="hidden" class="input-field" id="cancelcheck1" name="cancelcheck1" value="${vendorInformation.cancelCheck}" />                                                            
                                                            <span id="fileErrorCancleCheck" style="color:red;font-size:11px;display:none;">
                                                                * File should not exceed 5MB
                                                            </span>
                                                        </div>                                                
                                                    </td> 


                                                    <c:if test="${vendorInformation.finacialFlag != 10}">
                                                        <th style=""></th>                                                
                                                        <td></td>                                                
                                                    </c:if>
                                                    <c:if test="${vendorInformation.finacialFlag == 10}">
                                                        <td colspan="2">                                                            
                                                            <c:if test="${vendorFinancialApprovalDetails.cancelCheckStatus == 'accept'}">
                                                                <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                            </c:if>
                                                            <c:if test="${vendorFinancialApprovalDetails.cancelCheckStatus == 'reject'}">
                                                                <span style="color:red; font-weight:bold;">&#10008; Rejected</span>
                                                                <div>
                                                                    <textarea class="textarea-field"  name="cancelCheckRemark" readonly rows="2" cols="30" >${vendorFinancialApprovalDetails.cancelCheckRemark}</textarea>
                                                                </div>
                                                            </c:if> 
                                                            <c:if test="${vendorFinancialApprovalDetails.cancelCheckStatus == 'reject'}">
                                                                <div>                                                            
                                                                    <textarea class="textarea-field"  name="cancelCheckResponse" rows="2" cols="30" maxlength="250" required>${vendorFinancialApprovalDetails.cancelCheckResponse}</textarea>
                                                                </div>
                                                            </c:if>
                                                        </td>
                                                    </c:if>

                                                </tr>
                                            </table>
                                        <br>
                                                <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; ">
                                                    <thead>
                                                        <tr>
                                                            <th colspan="${vendorInformation.finacialFlag == 10 ? '6' : '4'}" style=" background-color: skyblue; text-align: center;">
                                                                FINANCIAL STATEMENT FOR LAST THREEE YEARS
                                                            </th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <th>Select year<span class="text-danger">*</span> </th>
                                                            <th> Financial Year<span class="text-danger">*</span> </th>
                                                            <th> Financial Amount(Turnover)<span class="text-danger">*</span></th>
                                                            <th> Financial Attachment<span class="text-danger">*</span></th>
                                                                <c:if test="${vendorInformation.finacialFlag == '10'}">
                                                                <th>Response</th>
                                                                <th>Remark <span class="text-danger">*</span></th>
                                                                </c:if>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <select id="finicals1" name="finicals1" class="select-input" required
                                                                        ${(vendorFinancialApprovalDetails.firstYearStatus == 'accept' 
                                                                           && vendorFinancialApprovalDetails.secondYearStatus == 'accept' 
                                                                           && vendorFinancialApprovalDetails.thirdYearStatus == 'accept') ? 'disabled' : ''}>
                                                                    <option>--Select--</option>
                                                                    <option value="Current Financial Year">Current Financial Year</option>
                                                                    <option value="Last Financial Year">Last Financial Year</option>
                                                                </select>
                                                                <c:if test="${vendorFinancialApprovalDetails.firstYearStatus == 'accept' 
                                                                              && vendorFinancialApprovalDetails.secondYearStatus == 'accept' 
                                                                              && vendorFinancialApprovalDetails.thirdYearStatus == 'accept'}">
                                                                    <input type="hidden" name="finicals1" value="">
                                                                </c:if>
                                                            </td>
                                                            <td>
                                                                <input name="finical1" required="true" id="finicalInput1" value="${vendorInformation.finical1}" 
                                                                       class="input-field" maxlength="30" 
                                                                       ${vendorFinancialApprovalDetails.firstYearStatus == 'accept' ? 'readonly' : ''}/>
                                                            </td>
                                                            <td> 
                                                                <input name="finicalAmount1" required="true" value="${vendorInformation.finicalAmount1}" 
                                                                       oninput="formatNumber(this)" class="input-field" maxlength="30" 
                                                                       ${vendorFinancialApprovalDetails.firstYearStatus == 'accept' ? 'readonly' : ''}/>
                                                            </td>
                                                            <td>
                                                                <c:if test="${vendorInformation.finicalAttachment1!='' && vendorInformation.finicalAttachment1!=null}">

                                                                    <span class="file-wrapper">
                                                                        <span class="file-name text-break">${vendorInformation.finicalAttachment1}</span>
                                                                        <span class="file-actions">
                                                                            <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.finicalAttachment1}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                                            <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.finicalAttachment1}"><span class="fa fa-solid fa-eye"></span></a>

                                                                        </span>
                                                                    </span>
                                                                            <c:if test="${vendorInformation.finacialFlag !=10}">   
                                                                      <input type="file" <c:if test="${empty vendorInformation.finicalAttachment1}">required="true"</c:if> class="input-field" onchange="validateFileSize(this, 'fileErrorFinicalAttachment1');" id="finicalAttachment1" name="finicalAttachment1" />
                                                                    <span id="fileErrorFinicalAttachment1" style="color:red;font-size:11px;display:none;">
                                                                        * File should not exceed 5MB
                                                                    </span>
                                                                    </c:if>
                                                                </c:if>
                                                                
                                                                <input type="hidden" class="input-field" name="finicalAttachment11" value="${vendorInformation.finicalAttachment1}" />
                                                                <c:if test="${vendorFinancialApprovalDetails.firstYearStatus == 'reject'}">
                                                                    <input type="file" class="input-field" name="finicalAttachment1" onchange="checkFileSize(this)" required/>
                                                                    <span id="fileError1" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>
                                                                </c:if>
                                                               
                                                            </td>
                                                            <c:if test="${vendorInformation.finacialFlag == '10'}">
                                                                <td>
                                                                    <c:if test="${vendorFinancialApprovalDetails.firstYearStatus == 'accept'}">
                                                                        <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                                    </c:if>
                                                                    <c:if test="${vendorFinancialApprovalDetails.firstYearStatus == 'reject'}">
                                                                        <span style="color:red; font-weight:bold;">&#10008; Rejected</span>
                                                                        <div>
                                                                            <textarea class="textarea-field"  name="firstYearRemark" readonly rows="2" cols="30" >${vendorFinancialApprovalDetails.firstYearRemark}</textarea>
                                                                        </div>
                                                                    </c:if>
                                                                </td>

                                                                <td>                                                        
                                                                    <c:if test="${vendorFinancialApprovalDetails.firstYearStatus == 'reject'}">
                                                                        <textarea class="textarea-field"  name="firstYearResponces" required rows="2" cols="30"  maxlength="250" required >${vendorFinancialApprovalDetails.firstYearResponces}</textarea>
                                                                    </c:if>
                                                                </td>                            
                                                            </c:if>

                                                        </tr>
                                                            
                                                            
                                                        <tr>
                                                            <td></td>
                                                            <td><input name="finical2" required="true" id="finicalInput2" value="${vendorInformation.finical2}" 
                                                                       class="input-field" maxlength="30" 
                                                                       ${vendorFinancialApprovalDetails.secondYearStatus == 'accept' ? 'readonly' : ''}/></td>
                                                            <td><input name="finicalAmount2" required="true" oninput="formatNumber(this)" value="${vendorInformation.finicalAmount2}" 
                                                                       class="input-field" maxlength="30" 
                                                                       ${vendorFinancialApprovalDetails.secondYearStatus == 'accept' ? 'readonly' : ''}/></td>
                                                            <td> 
                                                                <c:if test="${vendorInformation.finicalAttachment2!='' && vendorInformation.finicalAttachment2!=null}">

                                                                    <span class="file-wrapper">
                                                                        <span class="file-name text-break">${vendorInformation.finicalAttachment2}</span>
                                                                        <span class="file-actions">
                                                                            <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.finicalAttachment2}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                                            <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.finicalAttachment2}"><span class="fa fa-solid fa-eye"></span></a>

                                                                        </span>
                                                                    </span> 
                                                                            <c:if test="${vendorInformation.finacialFlag !=10}">   
                                                                    
                                                                       <input type="file" <c:if test="${empty vendorInformation.finicalAttachment2}">required="true"</c:if> class="input-field" onchange="validateFileSize(this, 'fileErrorFinicalAttachment2');" id="finicalAttachment2" name="finicalAttachment2" />
                                                                    <span id="fileErrorFinicalAttachment2" style="color:red;font-size:11px;display:none;">
                                                                        * File should not exceed 5MB
                                                                    </span>     
                                                                     </c:if>       
                                                                            
                                                                </c:if>

                                                                <input type="hidden" class="input-field" name="finicalAttachment22" value="${vendorInformation.finicalAttachment2}" />
                                                                <c:if test="${vendorFinancialApprovalDetails.secondYearStatus == 'reject'}">
                                                                    <input type="file" class="input-field"  name="finicalAttachment2"  onchange="checkFileSize(this)" required/>
                                                                    <span id="fileError2" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>
                                                                </c:if>


                                                            </td>
                                                            <c:if test="${vendorInformation.finacialFlag == '10'}">
                                                                <td>
                                                                    <c:if test="${vendorFinancialApprovalDetails.secondYearStatus == 'accept'}">
                                                                        <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                                    </c:if>
                                                                    <c:if test="${vendorFinancialApprovalDetails.secondYearStatus == 'reject'}">
                                                                        <span style="color:red; font-weight:bold;">&#10008; Rejected</span>
                                                                        <div>
                                                                            <textarea class="textarea-field"   name="secondYearRemark" readonly rows="2" cols="30" >${vendorFinancialApprovalDetails.secondYearRemark}</textarea>
                                                                        </div>
                                                                    </c:if>
                                                                </td>


                                                                <td>                                                       
                                                                    <c:if test="${vendorFinancialApprovalDetails.secondYearStatus == 'reject'}">
                                                                        <textarea class="textarea-field"   name="secondYearResponces" required rows="2" cols="30"  maxlength="250" required>${vendorFinancialApprovalDetails.secondYearResponces}</textarea>
                                                                    </c:if>
                                                                </td>                       
                                                            </c:if>                      





                                                        </tr>
                                                            
                                                        
                                                        <tr>
                                                            <td></td>
                                                            <td><input name="finical3" required="true" id="finicalInput3"  value="${vendorInformation.finical3}" 
                                                                       class="input-field" maxlength="30" 
                                                                       ${vendorFinancialApprovalDetails.thirdYearStatus == 'accept' ? 'readonly' : ''}/></td>
                                                            <td><input name="finicalAmount3" required="true" oninput="formatNumber(this)" value="${vendorInformation.finicalAmount3}" 
                                                                       class="input-field" maxlength="30" 
                                                                       ${vendorFinancialApprovalDetails.thirdYearStatus == 'accept' ? 'readonly' : ''}/></td>
                                                            <td> 
                                                                <c:if test="${vendorInformation.finicalAttachment3!='' && vendorInformation.finicalAttachment3!=null}">

                                                                    <span class="file-wrapper">
                                                                        <span class="file-name text-break">${vendorInformation.finicalAttachment3}</span>
                                                                        <span class="file-actions">
                                                                            <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.finicalAttachment3}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                                            <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.finicalAttachment3}"><span class="fa fa-solid fa-eye"></span></a>

                                                                        </span>
                                                                    </span>    
                                                                       <c:if test="${vendorInformation.finacialFlag !=10}">      
                                                                    <input type="file" <c:if test="${empty vendorInformation.finicalAttachment3}">required="true"</c:if> class="input-field" onchange="validateFileSize(this, 'fileErrorFinicalAttachment3');" id="finicalAttachment3" name="finicalAttachment3" />
                                                                    <span id="fileErrorFinicalAttachment3" style="color:red;font-size:11px;display:none;">
                                                                        * File should not exceed 5MB
                                                                    </span> 
                                                                </c:if>
                                                                </c:if>

                                                                <input type="hidden" class="input-field" name="finicalAttachment33" value="${vendorInformation.finicalAttachment3}" />
                                                                <c:if test="${vendorFinancialApprovalDetails.thirdYearStatus == 'reject'}">
                                                                    <input type="file" class="input-field" name="finicalAttachment3" onchange="checkFileSize(this)" required/>
                                                                    <span id="fileError3" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>
                                                                </c:if>
                                                            </td>    
                                                            <c:if test="${vendorInformation.finacialFlag == '10'}">

                                                                <td>
                                                                    <c:if test="${vendorFinancialApprovalDetails.thirdYearStatus == 'accept'}">
                                                                        <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                                    </c:if>
                                                                    <c:if test="${vendorFinancialApprovalDetails.thirdYearStatus == 'reject'}">
                                                                        <span style="color:red; font-weight:bold;">&#10008; Rejected</span>
                                                                        <div>
                                                                            <textarea class="textarea-field"  name="thirdYearRemark" readonly rows="2" cols="30" >${vendorFinancialApprovalDetails.thirdYearRemark}</textarea>
                                                                        </div>
                                                                    </c:if>
                                                                </td>                     
                                                                <td>                                                        
                                                                    <c:if test="${vendorFinancialApprovalDetails.thirdYearStatus == 'reject'}">
                                                                        <textarea class="textarea-field"  name="thirdYearResponces" required rows="2" cols="30"  maxlength="250" required>${vendorFinancialApprovalDetails.thirdYearResponces}</textarea>
                                                                    </c:if>
                                                                </td>  
                                                            </c:if>

                                                        </tr>
                                                    </tbody>
                                                </table>
                                                    <script>
                                                        document.addEventListener("DOMContentLoaded", function () {

                                                            const finicalInput1 = document.getElementById("finicalInput1");
                                                            const finicals1 = document.getElementById("finicals1");

                                                            if (!finicalInput1 || !finicals1) {
                                                                console.log("Element not found");
                                                                return;
                                                            }

                                                            const inputValue = finicalInput1.value.trim();

                                                            const currentDate = new Date();
                                                            const currentYear = currentDate.getFullYear();

                                                            let startYear, endYear;

                                                            if (currentDate.getMonth() >= 3) {
                                                                startYear = currentYear;
                                                                endYear = currentYear + 1;
                                                            } else {
                                                                startYear = currentYear - 1;
                                                                endYear = currentYear;
                                                            }

                                                            const currentFY = startYear + " - " + endYear;
                                                            const lastFY = (startYear - 1) + " - " + startYear;

                                                            console.log("Input Value:", inputValue);
                                                            console.log("Current FY:", currentFY);
                                                            console.log("Last FY:", lastFY);

                                                            if (inputValue === currentFY) {
                                                                finicals1.value = "Current Financial Year";
                                                            } else if (inputValue === lastFY) {
                                                                finicals1.value = "Last Financial Year";
                                                            } else {
                                                                finicals1.value = "--Select--";
                                                            }
                                                        });
                                                    </script>
                                                    <script>
                                                document.getElementById('finicals1').addEventListener('change', function () {
                                                var selectedValue = this.value;
                                                        var currentDate = new Date();
                                                        var currentYear = currentDate.getFullYear();
                                                        var startYear, endYear;
                                                        if (currentDate.getMonth() >= 3) {
                                                startYear = currentYear;
                                                        endYear = currentYear + 1;
                                                } else {
                                                startYear = currentYear - 1;
                                                        endYear = currentYear;
                                                }

                                                var finicalInput1 = document.getElementById('finicalInput1');
                                                        var finicalInput2 = document.getElementById('finicalInput2');
                                                        var finicalInput3 = document.getElementById('finicalInput3');
                                                        if (selectedValue === "Current Financial Year") {
                                                finicalInput1.value = startYear + " - " + endYear;
                                                        finicalInput2.value = (startYear - 1) + " - " + startYear;
                                                        finicalInput3.value = (startYear - 2) + " - " + (startYear - 1);
                                                } else if (selectedValue === "Last Financial Year") {
                                                finicalInput1.value = (startYear - 1) + " - " + startYear;
                                                        finicalInput2.value = (startYear - 2) + " - " + (startYear - 1);
                                                        finicalInput3.value = (startYear - 3) + " - " + (startYear - 2);
                                                } else {
                                                finicalInput1.value = ""; // Clear the inputs if no valid selection
                                                        finicalInput2.value = "";
                                                        finicalInput3.value = "";
                                                }
                                                });
                                                        function formatNumber(input) {
                                                        // Remove all non-digit characters except the decimal point
                                                        let value = input.value.replace(/,/g, '').replace(/[^\d.]/g, '');
                                                                // Format number with commas
                                                                let parts = value.split('.');
                                                                parts[0] = parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ',');
                                                                input.value = parts.join('.');
                                                        }
                                            </script> 
                                            
                                            <div class="form-group comment-box">
                                                <label class="control-label">Comments :<span class="text-danger">*</span></label>
                                                <textarea type="text" maxlength="250" class="textarea-field remark" id="FinacilaUpadteremark" name="FinacilaUpadteremark" required="true"></textarea>
                                            </div> 

                                            <div class="cta d-flex align-items-center justify-content-center" style="gap:15px;">
                                                <button type="button" class="btn theme-btn" id="submitfinacUpdate" title="submitfinacUpdate">
                                                    <span id="submitfinacUpdateText" style="color: white;">Submit Financial</span>
                                                </button>
                                            </div>
                                            <c:if test="${vendorInformation.finacialFlag == '10'}">

                                                <br>
                                                <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; ">
                                                    <thead>
                                                        <tr class="table-title">
                                                            <td colspan="6" style="font-weight: bold; background-color: skyblue;">Approval History</td>
                                                        </tr>
                                                        <tr style="">
                                                            <th>Sr. No.</th>
                                                            <th>User Name</th>
                                                            <th>User Role</th>
                                                            <th>Date Time</th>
                                                            <th>Action</th>
                                                            <th>Comment</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:set var="srNo" value="1"/>
                                                        <tr>
                                                            <td>${srNo}</td>
                                                            <td>${vendorInvitation.invitedBy}</td>
                                                            <td>Buyer</td>
                                                            <td>${vendorInvitation.invitedDateTime}</td>
                                                            <td>Vendor Invited</td>
                                                            <td></td>
                                                        </tr>
                                                        <c:set var="srNo" value="${srNo + 1}"/>
                                                        <c:forEach var="vendorApproval" items="${vendorApproval}">
                                                            <tr>
                                                                <td>${srNo}</td>
                                                                <td>${vendorApproval.userId}</td>
                                                                <td>${vendorApproval.userRole}</td>
                                                                <td>${vendorApproval.dateTime}</td>
                                                                <td>${vendorApproval.activity}</td>
                                                                <td>${vendorApproval.description}</td>
                                                            </tr>
                                                            <c:set var="srNo" value="${srNo + 1}"/>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>                                         
                                                    </c:if>                           
                                            
                                            
                                                    <script>
                                                        $(document).ready(function () {

                                                            function validateFinancialForm() {
                                                                var isValid = true;
                                                                var firstInvalidElement = null;

                                                                var requiredFields = $("#financialUpdateForm input[required], #financialUpdateForm textarea[required], #financialUpdateForm select[required]");

                                                                requiredFields.css("border", "");
                                                                $("#financialUpdateForm .error-message").remove();

                                                                requiredFields.each(function () {
                                                                    var field = $(this);

                                                                    // Skip fields that are hidden (e.g. inside a toggled-off section)
                                                                    if (field.is(':hidden') || field.parents(':hidden').length) {
                                                                        return true;
                                                                    }

                                                                    // Handle radio button groups (only validate once per group)
                                                                    if (field.attr('type') === 'radio') {
                                                                        var groupName = field.attr('name');
                                                                        if ($("input[name='" + groupName + "']:checked").length === 0) {
                                                                            isValid = false;
                                                                            if (firstInvalidElement === null) {
                                                                                firstInvalidElement = field;
                                                                            }
                                                                            if (field.closest('td').find(".error-message").length === 0) {
                                                                                field.closest('td').append('<div class="error-message">This field is required</div>');
                                                                            }
                                                                        }
                                                                        return true;
                                                                    }

                                                                    // Handle file inputs
                                                                    if (field.attr('type') === 'file') {
                                                                        if (field[0].files.length === 0) {
                                                                            isValid = false;
                                                                            if (firstInvalidElement === null) {
                                                                                firstInvalidElement = field;
                                                                            }
                                                                            field.css("border", "1px solid red");
                                                                            if (field.next(".error-message").length === 0) {
                                                                                field.after('<div class="error-message">This field is required</div>');
                                                                            }
                                                                        }
                                                                        return true;
                                                                    }

                                                                    // Handle text/select/textarea inputs
                                                                    if (field.val() === "" || field.val() === null || $.trim(field.val()) === "") {
                                                                        isValid = false;

                                                                        if (firstInvalidElement === null) {
                                                                            firstInvalidElement = field;
                                                                        }

                                                                        field.css("border", "1px solid red");

                                                                        if (field.next(".error-message").length === 0) {
                                                                            field.after('<div class="error-message">This field is required</div>');
                                                                        }
                                                                    }
                                                                });

                                                                if (!isValid && firstInvalidElement) {
                                                                    $('html, body').animate({
                                                                        scrollTop: firstInvalidElement.offset().top - 150
                                                                    }, 500, function () {
                                                                        firstInvalidElement.focus();
                                                                    });
                                                                }

                                                                return isValid;
                                                            }

                                                            $("#submitfinacUpdate").click(function (e) {
                                                                e.preventDefault();

                                                                if (!validateFinancialForm()) {
                                                                    return;
                                                                }

                                                                $("#submitfinacUpdate").prop("disabled", true);
                                                                $("#submitfinacUpdateText").text("Submitting...");

                                                                var formData = new FormData($("#financialUpdateForm")[0]);

                                                                $.ajax({
                                                                    url: $("#financialUpdateForm").attr("action"),
                                                                    type: "POST",
                                                                    data: formData,
                                                                    processData: false,
                                                                    contentType: false,

                                                                    success: function (response) {
                                                                        window.location.href = "vendorInformation.htm?act=policyUpdateVendorInformation";
                                                                    },

                                                                   error: function () {
                                                                    $("#submitfinacUpdate").prop("disabled", false);
                                                                    $("#submitfinacUpdateText").text("Submit Financial");

                                                                    Swal.fire({
                                                                        icon: "error",
                                                                        title: "Submission Failed",
                                                                        text: "We couldn't submit your financial details. Please try again in a moment.",
                                                                        confirmButtonColor: "#3085d6"
                                                                            });
                                                                        }
                                                                });
                                                            });

                                                            // Re-validate a field live as the user fixes it, so the red border/error clears immediately
                                                            $("#financialUpdateForm").on('input change', 'input[required], textarea[required], select[required]', function () {
                                                                var field = $(this);
                                                                if (field.attr('type') === 'radio') {
                                                                    var groupName = field.attr('name');
                                                                    if ($("input[name='" + groupName + "']:checked").length > 0) {
                                                                        field.closest('td').find(".error-message").remove();
                                                                    }
                                                                    return;
                                                                }
                                                                if (field.attr('type') === 'file') {
                                                                    if (field[0].files.length > 0) {
                                                                        field.css("border", "");
                                                                        field.next(".error-message").remove();
                                                                    }
                                                                    return;
                                                                }
                                                                if ($.trim(field.val()) !== "") {
                                                                    field.css("border", "");
                                                                    field.next(".error-message").remove();
                                                                }
                                                            });
                                                        });
                                                    </script>
                                                    </form>                   
 
                                                             </c:if>          
                        
                        
                        
                        
                        
                        
                        
                        <!-- Review Modal -->
                        <div class="modal fade" id="reviewModal" data-backdrop="static" data-keyboard="false" tabindex="-1"
                             aria-labelledby="reviewModalLabel" aria-hidden="true">
                            <div class="modal-dialog modal-sm">
                                <div class="modal-content">
                                    <div class="modal-header align-items-center">
                                        <h5 class="modal-title" id="reviewModalLabel">Review Vendor :</h5>
                                        <div class="cta-btn d-flex align-items-center">
                                            <button type="button" class="btn theme-btn light-btn" data-dismiss="modal"
                                                    onclick="window.location.href='vendorInformation.htm?act=policyUpdateVendorInformation';">Close</button>
                                            <button type="button" class="btn theme-btn ml-3" id="reviewSubmitButton">
                                                <span class="btn-spinner" id="reviewBtnSpinner"></span>
                                                <span id="reviewBtnText" style="color: white;">Submit</span>
                                            </button>
                                        </div>
                                    </div>
                                    <div class="modal-body">
                                        <div id="reviewResultDiv" class="bg-white">

                                            <div class="review-loading-overlay" id="reviewLoadingOverlay">
                                                <div class="spinner-border text-danger" role="status"></div>
                                                <span>Processing, please wait...</span>
                                            </div>

                                            <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                                                <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                                                <div>
                                                    <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.
                                                    <div style="font-weight: bold;" id="reviewErrorMsg" class="text-danger" style="display:none; font-size:12px;"></div>
                                                </div>
                                            </div>
                                            <br>

                                            <form id="reviewForm" action="vendorInformation.htm" method="post">

                                                <input type="hidden" name="act" value="FinancialDetailsChangeProcess">
                                                <input type="hidden" name="id" id="reviewVendorId">
                                                <div class="col-12 p-0">
                                                    <div class="form-group">
                                                        <label class="control-label">Company Name :</label>
                                                        <span id="reviewCompanyName" style="font-weight: bold;"></span>
                                                    </div>

                                                    <div class="form-group comment-box">
                                                        <label class="control-label">Comments :<span class="text-danger">*</span></label>
                                                        <textarea type="text" maxlength="250" class="textarea-field remark" id="reviewRemark" name="remark" required="true"></textarea>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

<style>
    #reviewResultDiv {
        position: relative;
    }
    .review-loading-overlay {
        display: none;
        position: absolute;
        top: 0; left: 0; right: 0; bottom: 0;
        background: rgba(255, 255, 255, 0.75);
        z-index: 10;
        align-items: center;
        justify-content: center;
        flex-direction: column;
        border-radius: 8px;
    }
    .review-loading-overlay .spinner-border {
        width: 2rem;
        height: 2rem;
    }
    .review-loading-overlay span {
        margin-top: 8px;
        font-size: 13px;
        font-weight: bold;
        color: #333;
    }
    #reviewSubmitButton .btn-spinner {
        display: none;
        width: 14px;
        height: 14px;
        border: 2px solid rgba(255,255,255,0.5);
        border-top-color: #fff;
        border-radius: 50%;
        margin-right: 6px;
        animation: review-spin 0.7s linear infinite;
        vertical-align: middle;
    }
    @keyframes review-spin {
        to { transform: rotate(360deg); }
    }
</style>

<script>
    function openReviewModal(id, companyName) {
        $('#reviewErrorMsg').hide().text('');
        $('#reviewVendorId').val(id);
        $('#reviewCompanyName').text(companyName);
        $('#reviewRemark').val('');

        setReviewLoading(false);

        $('#reviewSubmitButton').prop('disabled', false);
        $('#reviewBtnSpinner').hide();
        $('#reviewBtnText').text('Submit');

        $('#reviewModal').modal('show');
    }

    function showReviewError(message) {
        var $errorMsg = $('#reviewErrorMsg');
        clearTimeout($errorMsg.data('timeout'));

        $errorMsg.stop(true, true)
                 .removeClass('text-success')
                 .addClass('text-danger')
                 .text(message)
                 .show();

        var timeout = setTimeout(function () {
            $errorMsg.fadeOut(function () {
                $(this).text('');
            });
        }, 3000);

        $errorMsg.data('timeout', timeout);
    }

    function setReviewLoading(isLoading) {
        if (isLoading) {
            $('#reviewLoadingOverlay').css('display', 'flex');
            $('#reviewSubmitButton').prop('disabled', true);
            $('#reviewBtnSpinner').show();
            $('#reviewBtnText').text('Processing...');
        } else {
            $('#reviewLoadingOverlay').hide();
            $('#reviewBtnSpinner').hide();

            if (!$('#reviewSubmitButton').prop('disabled')) {
                $('#reviewBtnText').text('Submit');
            }
        }
    }

    $(document).on('click', '#reviewSubmitButton', function (e) {
        e.preventDefault();

        var remark = $('#reviewRemark').val().trim();

        if (!remark) {
            showReviewError('Remark is mandatory');
            return;
        }

        var formData = new FormData($('#reviewForm')[0]);

        setReviewLoading(true);

        $.ajax({
            url: $('#reviewForm').attr('action'),
            type: 'POST',
            data: formData,
            processData: false,
            contentType: false,

            success: function (response) {

                $('#reviewErrorMsg')
                    .removeClass('text-danger')
                    .addClass('text-success')
                    .text('Vendor Reviewed successfully')
                    .show();

                $('#reviewRemark').val('');

                $('#reviewLoadingOverlay').hide();
                $('#reviewBtnSpinner').hide();

                $('#reviewSubmitButton').prop('disabled', true);
                $('#reviewBtnText').text('Submitted');
            },

            error: function () {
                setReviewLoading(false);
                showReviewError('Something went wrong.');
            },

            complete: function () {
                if (!$('#reviewSubmitButton').prop('disabled')) {
                    setReviewLoading(false);
                }
            }
        });
    });
</script>
<script>
    function validateFileSize(input, errorId) {
        const file = input.files[0]; 
        const maxSize = 5 * 1024 * 1024; 

        if (file && file.size > maxSize) {
            document.getElementById(errorId).style.display = 'block';
            input.value = ''; 
        } else {
            document.getElementById(errorId).style.display = 'none';
        }
    }
</script>
            </section>
        </main>        
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
