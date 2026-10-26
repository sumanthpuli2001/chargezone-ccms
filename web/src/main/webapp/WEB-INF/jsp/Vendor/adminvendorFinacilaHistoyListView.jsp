<%-- 
    Document   : adminvendorFinacilaHistoyListView
    Created on : Jul 25, 2026, 9:53:37 AM
    Author     : Sumanth
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

    <head>
        <title>vendor Financial Histoy View</title>

    </head>

    <body> 
        <style>
            @media print {

                /* Remove default browser margins */
                @page {
                    size: A4 portrait;
                    margin: 6mm 4mm 8mm 4mm !important;
                }

                html, body {
                    margin: 0 !important;
                    padding: 0 !important;
                    width: 100% !important;
                    height: auto !important;
                    overflow: visible !important;
                    background: white !important;
                    -webkit-print-color-adjust: exact !important;
                    print-color-adjust: exact !important;
                }

                /* Remove unwanted padding/margin everywhere */
                * {
                    box-sizing: border-box !important;
                    margin: 0 !important;
                    padding: 0 !important;
                }

                /* Hide everything except #printSection */
                body * {
                    visibility: hidden !important;
                }

                #printSection, #printSection * {
                    visibility: visible !important;
                }

                /* Full-width printable section */
                #printSection {
                    position: absolute !important;
                    top: 0;
                    left: 0;
                    width: 100% !important;
                    max-width: 100% !important;
                    overflow: visible !important;
                    margin: 0 !important;
                    padding: 0 !important;
                }

                /* Compact text */
                h1, h2, h3, h4, h5, h6, p {
                    margin: 2px 0 !important;
                    line-height: 1.2 !important;
                }

                /* Table wrapper */
                .table_wrapper, .table-responsive {
                    overflow: visible !important;
                    width: 100% !important;
                    height: auto !important;
                    max-height: none !important;
                    display: block !important;
                    padding: 0 !important;
                    margin: 0 !important;

                    /* Remove scrollbars in all browsers */
                    -ms-overflow-style: none !important; /* IE/Edge */
                    scrollbar-width: none !important;    /* Firefox */
                }

                .table_wrapper::-webkit-scrollbar,
                .table-responsive::-webkit-scrollbar {
                    display: none !important; /* Chrome, Safari, Opera */
                }

                /* Table styling */
                table {
                    width: 100% !important;
                    max-width: 100% !important;
                    table-layout: fixed !important; /* fixed ensures header alignment */
                    border-collapse: collapse !important;
                    word-wrap: break-word !important;
                    overflow-wrap: break-word !important;
                    overflow: visible !important;
                    margin: 0 auto !important;

                    /* Remove scrollbars in all browsers */
                    -ms-overflow-style: none !important; /* IE/Edge */
                    scrollbar-width: none !important;    /* Firefox */
                }

                table::-webkit-scrollbar {
                    display: none !important; /* Chrome, Safari, Opera */
                }

                /* Table headers & cells */
                th, td {
                    border: 1px solid #ccc !important;
                    word-break: break-word !important;
                    white-space: normal !important;
                    overflow: visible !important;
                    padding: 6px 8px !important;
                    text-align: left !important;
                    vertical-align: top !important;
                }

                thead {
                    display: table-header-group !important; /* repeat headers on pages */
                }

                tr {
                    page-break-inside: avoid !important; /* avoid breaking rows */
                }

                /* Remove extra Bootstrap spacing */
                [class*="mb-"], [class*="mt-"], [class*="pb-"], [class*="pt-"] {
                    margin: 0 !important;
                    padding: 0 !important;
                }

                /* Section layouts */
                .buyer-info {
                    display: flex !important;
                    flex-wrap: wrap !important;
                    justify-content: flex-start !important;
                    gap: 4px !important;
                }

                .buyer-info > [class*="col-"] {
                    width: 33% !important;
                    margin-bottom: 6px !important;
                }

                .card-box, .buyer-info, .form-group {
                    page-break-inside: avoid !important;
                }

                /* Hide unnecessary elements */
                footer, .footer, #footer,
                .dataTables_length,
                .dataTables_filter,
                .dataTables_info,
                .dataTables_paginate,
                .paginate_button,
                .paging_simple_numbers,
                .pagination {
                    display: none !important;
                }

            }
        </style>

        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">

            <section id="printSection" class="main-content">
                <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                    <div class="page-title d-flex align-items-center">
                        <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                            <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                 alt="Menu collapse">
                            <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                 alt="Menu collapse">
                        </div>
                        <h5 class="fw-600 mb-0">vendor Financial Histoy View</h5>
                    </div>
                    <div class="cta d-flex align-items-center">
                        <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>
<!--                           <a href="vendorInformation.htm?act=approveviewClickTwoPrint&id=${checkId}" 
                               class="btn theme-btn">
                                Print
                            </a>                        -->
                    </div>
                </div>
                <hr>
                <c:if test="${!empty successMessage}">
                    <div id="successMsg" class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                </c:if>
                <c:if test="${!empty failureMessage}">
                    <div id="failureMsg" class="fadeOutEffect alert alert-danger" style="padding: 0px" role="alert">${failureMessage}</div>
                </c:if>

                <c:forEach var="list" items="${list}" varStatus="status">
                    <table class="table table-bordered custom-table mb-3" id="" style="width:100%;">                                                        <thead> 
                        <thead>
                            <tr class="table-title">
                                <td colspan="7" style="font-weight: bold; background-color: skyblue; text-align: center;">VENDOR DETAILS</td>
                            </tr>
                        </thead>
                        <tbody>

                            <tr>
                                <th style="width: 25%;">Company Name</th>
                                <td style="width: 25%;">${list.companyName}</td>
                                <th style="width: 25%;">Email Id </th>
                                <td style="width: 25%;">${list.vendorEmailId}</td>
                            </tr>    
                            <tr>
                                <th style="">   <c:if test="${list.policyAccept=='1'}">Code of Conduct (Sign & Stamp in all Pages)</c:if>
                                    <c:if test="${list.policyAccept=='0'}">Deviation Policy</c:if></th>
                                <td><c:if test="${list.policyAccept=='1'}">Accept</c:if>
                                    <c:if test="${list.policyAccept=='0'}"><span style="color: red;">Not Accept</span></c:if><br>
                                    <c:if test="${list.policy1File!=null && not empty list.policy1File}">                                        
                                        <span class="file-wrapper">
                                            <span class="file-name text-break">${list.policy1File}</span>
                                            <span class="file-actions">
                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.policy1File}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.policy1File}"><span class="fa fa-solid fa-eye"></span></a>
                                            </span>
                                        </span>
                                    </c:if></td>
                                <th style="">    <c:if test="${list.ndaPolicyAccept=='1'}">NDA (Sign & Stamp in all Pages)</c:if>
                                    <c:if test="${list.ndaPolicyAccept=='0'}">NDA Policy</c:if></th> 
                                <td><c:if test="${list.ndaPolicyAccept=='1'}">Accept</c:if>
                                    <c:if test="${list.ndaPolicyAccept=='0'}"><span style="color: red;">Not Accept</span></c:if><br>
                                    <c:if test="${list.ndaPolicyFile!=null && not empty list.ndaPolicyFile}">                                        
                                        <span class="file-wrapper">
                                            <span class="file-name text-break">${list.ndaPolicyFile}</span>
                                            <span class="file-actions">
                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.ndaPolicyFile}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.ndaPolicyFile}"><span class="fa fa-solid fa-eye"></span></a>
                                            </span>
                                        </span>
                                    </c:if>
                                </td>



                            </tr>
                            <tr>
                                <th  style="">Type of Company</th>
                                <td>${list.typeOfConcern}</td>
                                <c:choose>
                                    <c:when test="${list.typeOfConcern == 'Sole Proprietorship'}">
                                        <th  style="">
                                            Shop or Establishment License
                                        </th>
                                    </c:when>

                                    <c:when test="${list.typeOfConcern == 'Hindu Undivided Family ( HUF)'}">
                                        <th  style="">
                                            Shop or Establishment License and HUF Deed
                                        </th>
                                    </c:when>

                                    <c:when test="${list.typeOfConcern == 'Partnership Firm'}">
                                        <th  style="">
                                            Shop or Establishment License and Partnership Deed
                                        </th>
                                    </c:when>

                                    <c:when test="${list.typeOfConcern == 'Limited Liability Partnership ( LLP)'}">
                                        <th  style="">
                                            Shop or Establishment License and LLP Agreement
                                        </th>
                                    </c:when>

                                    <c:when test="${list.typeOfConcern == 'Private/Public Company'}">
                                        <th  style="">
                                            Certificate of Incorporation (MCA)
                                        </th>
                                    </c:when>

                                    <c:when test="${list.typeOfConcern == 'Free Lancer'}">
                                        <th  style="">
                                            Professional Profile / Resume
                                        </th>
                                    </c:when>

                                    <c:otherwise>
                                        <th  style="">Proof Of Attachment</th>
                                        </c:otherwise>
                                    </c:choose>
                                <td> 
                                    <c:if test="${list.companyProof!=null && not empty list.companyProof}">                                        
                                        <span class="file-wrapper">
                                            <span class="file-name text-break">${list.companyProof}</span>
                                            <span class="file-actions">
                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.companyProof}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.companyProof}"><span class="fa fa-solid fa-eye"></span></a>
                                            </span>
                                        </span>
                                    </c:if>
                                    <c:if test="${list.companyProof2!=null && not empty list.companyProof2}">
                                        <br>
                                        <span class="file-wrapper">
                                            <span class="file-name text-break">${list.companyProof2}</span>
                                            <span class="file-actions">
                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.companyProof2}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.companyProof2}"><span class="fa fa-solid fa-eye"></span></a>
                                            </span>
                                        </span>
                                    </c:if>
                                </td>
                            </tr>
                            <tr>
                                <th style="">Year of Establishment of Company</th>
                                <td>${list.establishment}</td>
                                <th style="">Risk Category</th>
                                <td class="riskCategory">${list.riskCategory}</td>
                            </tr>
                        </tbody>
                    </table>     



                </c:forEach>

                <div class="table-responsive">
                    <table class="table table-bordered custom-table mb-3" id="table_1" style="width:100%;">                                                        
                        <thead> 
                        <thead>
                            <tr class="table-title">
                                <td colspan="7" style="font-weight: bold; background-color: skyblue; text-align: center;">COMPANY REGISTRATION DETAILS</td>
                            </tr>

                        </thead>
                        <tbody>
                            <tr>
                                <th style="width: 20%;">GST No.</th>
                                <td>                                                        
                                    ${list1.gsntNo}<br>
                                    <c:if test="${list1.gstFile!=null && not empty list1.gstFile}">                                        
                                        <span class="file-wrapper">
                                            <span class="file-name text-break">${list1.gstFile}</span>
                                            <span class="file-actions">
                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list1.gstFile}&id=${list1.vendorInfoId}"><span class="fa fa-download"></span></a>
                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list1.vendorInfoId}/${list1.gstFile}"><span class="fa fa-solid fa-eye"></span></a>
                                            </span>
                                        </span>
                                    </c:if>

                                </td>                                                    
                                <th style="width: 20%;">PAN No</th>
                                <td>                                                    
                                    ${list1.panNo}<br>
                                    <c:if test="${list1.panFile!=null && not empty list1.panFile}">                                        
                                        <span class="file-wrapper">
                                            <span class="file-name text-break">${list1.panFile}</span>
                                            <span class="file-actions">
                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list1.panFile}&id=${list1.vendorInfoId}"><span class="fa fa-download"></span></a>
                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list1.vendorInfoId}/${list1.panFile}"><span class="fa fa-solid fa-eye"></span></a>
                                            </span>
                                        </span>
                                    </c:if>
                                </td>
                            </tr>


                            <tr>
                                <th style="width: 20%;">MSME No</th>
                                <td>
                                    <c:if test="${list1.msmeStatus=='0'}"><strong>MSME Not
                                            Available</strong></c:if>
                                    ${list1.msmeNo}<br>
                                    <c:if test="${list1.msmeFile!=null && not empty list1.msmeFile}">                                        
                                        <span class="file-wrapper">
                                            <span class="file-name text-break">${list1.msmeFile}</span>
                                            <span class="file-actions">
                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list1.msmeFile}&id=${list1.vendorInfoId}"><span class="fa fa-download"></span></a>
                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list1.vendorInfoId}/${list1.msmeFile}"><span class="fa fa-solid fa-eye"></span></a>
                                            </span>
                                        </span>
                                    </c:if>
                                </td>
                                <th style="width: 20%;">ESIC No</th>
                                <td>
                                    <c:if test="${list1.esicStatus=='0'}"><strong>ESIC Not
                                            Available</strong></c:if>
                                    ${list1.esicNo}<br>
                                    <c:if test="${list1.esicFile!=null && not empty list1.esicFile}">                                        
                                        <span class="file-wrapper">
                                            <span class="file-name text-break">${list1.esicFile}</span>
                                            <span class="file-actions">
                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list1.esicFile}&id=${list1.vendorInfoId}"><span class="fa fa-download"></span></a>
                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list1.vendorInfoId}/${list1.esicFile}"><span class="fa fa-solid fa-eye"></span></a>
                                            </span>
                                        </span>
                                    </c:if>
                                </td>
                            </tr>         

                            <tr>
                                <th style="width: 20%;">EPFO No.</th>
                                <td>
                                    <c:if test="${list1.epfoStatus=='0'}"><strong>EPFO Not
                                            Available</strong></c:if>
                                    ${list1.epfoNo}<br>
                                    <c:if test="${list1.epfoFile!=null && not empty list1.epfoFile}">                                        
                                        <span class="file-wrapper">
                                            <span class="file-name text-break">${list1.epfoFile}</span>
                                            <span class="file-actions">
                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list1.epfoFile}&id=${list1.vendorInfoId}"><span class="fa fa-download"></span></a>
                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list1.vendorInfoId}/${list1.epfoFile}"><span class="fa fa-solid fa-eye"></span></a>
                                            </span>
                                        </span>
                                    </c:if>
                                </td>

                                <th style="width: 20%;">Import Export Code </th>
                                <td> 
                                    <c:if test="${list1.iecStatus == '0'}"><strong>ECC Not
                                            Available</strong></c:if>
                                    ${list1.iecNo}<br>
                                    <c:if test="${list1.iecFile!=null && not empty list1.iecFile}">                                        
                                        <span class="file-wrapper">
                                            <span class="file-name text-break">${list1.iecFile}</span>
                                            <span class="file-actions">
                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list1.iecFile}&id=${list1.vendorInfoId}"><span class="fa fa-download"></span></a>
                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list1.vendorInfoId}/${list1.iecFile}"><span class="fa fa-solid fa-eye"></span></a>
                                            </span>
                                        </span>
                                    </c:if>
                                </td>                                                    
                            </tr>



                        </tbody>
                    </table>
                </div>     


                <div class="table-responsive">
                    <table class="table table-bordered custom-table mb-3" id="table_1" style="width:100%;">                                                        <thead> 
                        <thead>
                            <tr class="table-title">
                                <td colspan="7" style="font-weight: bold; background-color: skyblue; text-align: center">BANK DETAILS</td>
                            </tr>
                            <tr>
                                <th  style="">Account Number</th>
                                <td>${list1.accountNo}</td>
                                <th style="">Bank Name </th>
                                <td>${list1.bankName}</td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th style="">Branch</th>
                                <td>${list1.branchName}</td>
                                <th style="">IFSC Code</th>
                                <td>${list1.ifscCode}</td>
                            </tr>
                            <tr>
                                <th style="">Swift Code (if any) </th>
                                <td> ${list1.swiftCode}</td>
                                <th style="">Cancel Cheque </th>
                                <td>
                                    <c:if test="${list1.cancelCheck!=null && not empty list1.cancelCheck}">                                        
                                        <span class="file-wrapper">
                                            <span class="file-name text-break">${list1.cancelCheck}</span>
                                            <span class="file-actions">
                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list1.cancelCheck}&id=${list1.vendorInfoId}"><span class="fa fa-download"></span></a>
                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list1.vendorInfoId}/${list1.cancelCheck}"><span class="fa fa-solid fa-eye"></span></a>
                                            </span>
                                        </span>
                                    </c:if>
                                </td>
                            </tr>

                        </tbody>
                    </table>
                </div>

                <div class="table-responsive">
                    <table class="table table-bordered custom-table mb-3" id="" style="width:100%;">                                                        <thead> 
                        <thead>
                            <tr class="table-title">
                                <td colspan="7" style="font-weight: bold; background-color: skyblue; text-align: center;">FINANCIAL STATEMENT (PROFIT AND LOSS / BALANCE SHEET)</td>
                            </tr>
                            <tr style="">
                                <th>Year</th>
                                <th>Financial Year</th>
                                <th>Financial Amount</th>
                                <th>Financial Attachment</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- 1st Year -->
                            <tr>
                                <td>1st Year </td>
                                <td>${list1.finacialYearOne}</td>
                                <td>${list1.finacialYearAmountOne}</td>
                                <td>
                                    <c:if test="${list1.finacialYearFileOne!=null && not empty list1.finacialYearFileOne}">                                        
                                        <span class="file-wrapper">
                                            <span class="file-name text-break">${list1.finacialYearFileOne}</span>
                                            <span class="file-actions">
                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list1.finacialYearFileOne}&id=${list1.vendorInfoId}"><span class="fa fa-download"></span></a>
                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list1.vendorInfoId}/${list1.finacialYearFileOne}"><span class="fa fa-solid fa-eye"></span></a>
                                            </span>
                                        </span>
                                    </c:if>
                                </td>
                            </tr>
                            <!-- 2nd Year -->
                            <tr>
                                <td>2nd Year </td>
                                <td>${list1.finacialYearTwo}</td>
                                <td>${list1.finacialYearAmountTwo}</td>
                                <td>
                                    <c:if test="${list1.finacialYearFileTwo!=null && not empty list1.finacialYearFileTwo}">                                        
                                        <span class="file-wrapper">
                                            <span class="file-name text-break">${list1.finacialYearFileTwo}</span>
                                            <span class="file-actions">
                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list1.finacialYearFileTwo}&id=${list1.vendorInfoId}"><span class="fa fa-download"></span></a>
                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list1.vendorInfoId}/${list1.finacialYearFileTwo}"><span class="fa fa-solid fa-eye"></span></a>
                                            </span>
                                        </span>
                                    </c:if>
                                </td>
                            </tr>
                            <!-- 3rd Year -->
                            <tr>
                                <td>3rd Year </td>
                                <td>${list1.finacialYearThree}</td>
                                <td>${list1.finacialYearAmountThree}</td>
                                <td>
                                    <c:if test="${list1.finacialYearFileThree!=null && not empty list1.finacialYearFileThree}">                                        
                                        <span class="file-wrapper">
                                            <span class="file-name text-break">${list1.finacialYearFileThree}</span>
                                            <span class="file-actions">
                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list1.finacialYearFileThree}&id=${list1.vendorInfoId}"><span class="fa fa-download"></span></a>
                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list1.vendorInfoId}/${list1.finacialYearFileThree}"><span class="fa fa-solid fa-eye"></span></a>
                                            </span>
                                        </span>
                                    </c:if>	
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>               


                <div class="form-group comment-box">
                    <label class="control-label">Comments :</label>
                    <textarea type="text" maxlength="250" class="textarea-field remark" id="FinacilaUpadteremark" name="FinacilaUpadteremark" readonly="true" >${list1.historyComment}</textarea>
                </div> 







            </section>
        </main> 
    </body>






    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>



