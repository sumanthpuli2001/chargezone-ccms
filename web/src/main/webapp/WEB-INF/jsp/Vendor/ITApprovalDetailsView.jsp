<%-- 
    Document   : ITApprovalDetailsView
    Created on : 17 Oct, 2025, 03:00:57 PM
    Author     : fnp
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

    <head>
        <title>IT Approval View</title>
        <style>
            table {
                width: 100%;
                border-collapse: collapse;
            }
            table, th, td {
                border: 1px solid black;
            }
            th, td {
                padding: 10px;
                text-align: left;
            }
            textarea {
                width: 100%;
                height: 60px;
                resize: vertical;
            }
            input[type="file"] {
                width: 100%;
            }
            @media print {
                body {
                    -webkit-print-color-adjust: exact !important; /* Chrome/Safari */
                    color-adjust: exact !important;               /* Firefox */
                    print-color-adjust: exact !important;         /* Modern browsers */
                }

                table {
                    border-collapse: collapse !important;
                    width: 100%;
                }

                th, td {
                    border: 1px solid black !important;
                    padding: 6px !important;
                    color: black !important;
                }

                .bottom-table th { 
                    border: 1px solid black !important;
                    background-color: gainsboro !important;
                }

                .table-title td {
                    background-color: skyblue !important;
                    font-weight: bold !important;
                    text-align: center !important;
                }                
                .wrap-text {
                    white-space: pre-wrap !important;
                    word-break: break-word !important;
                }
                a[href]:after {
                    content: "" !important;
                }

                a {
                    text-decoration: none !important;
                    color: black !important; /* optional: make it look like plain text */
                }
                .fa, .fas, .far, .fal, .fad, .fab {
                    display: none !important;
                }
                .approval-section{
                    page-break-before: always;
                }
                .it-section{
                    page-break-before: always;
                }
                /* Optional: hide buttons or elements not needed in print */
                .no-print {
                    display: none !important;
                }
            }
        </style>
    </head>

    <body>
        <style>
            .input-percent {
                position: relative;
            }

            .input-percent input {
                padding-right: 25px; /* space for % symbol */
                text-align: left;   /* aligns text nicely */
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
                <form:form action="vendorInformation.htm?act=ButtonHrApprovals1"  enctype="multipart/form-data" method="post"
                           name='form' class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">IT Approval View</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>                                            
                                <a href="vendorInformation.htm?act=ITApprovalDetailsViewPrint&id=${checkId}" 
                               class="btn theme-btn">
                                Print
                            </a>                        </div>
                    </div>
                    <hr>
                    <c:if test="${!empty successMessage}">
                        <div id="successMsg" class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                    </c:if>
                    <c:if test="${!empty failureMessage}">
                        <div id="failureMsg" class="fadeOutEffect alert alert-danger" style="padding: 0px" role="alert">${failureMessage}</div>
                    </c:if>

                    <c:forEach var="list" items="${list}" varStatus="status">
                        <input type="hidden" id="id" name="id" value="${list.id}">
                        <input type="hidden" id="id1" name="id1" value="${list.id}">

                        <table  class="bottom-table"  id="" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <thead>
                                                            <tr class="table-title">
                                                                <td colspan="7" style="font-weight: bold; background-color: skyblue;">VENDOR DETAILS</td>
                                                            </tr>
                                                            <tr >
                                                                <th style="width: 25%;">Company Name</th>
                                                                <td style="width: 25%;">${list.companyName}</td>
                                                                <th style="width: 25%;">Email Id </th>
                                                                <td style="width: 25%;">${list.vendorEmailId}</td>

                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <th style="">   <c:if test="${list.policyAccept=='1'}">Code of Conduct (Sign & Stamp in all Pages</c:if>
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
                                                                    </c:if>    
                                                                </td>
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
                                                                <th style=""></th>
                                                                <td></td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                    <br>
                                                    <div class="table-responsive">
                                                        <table class="bottom-table" id="" class="table table-bordered table-striped table-hover" align="Center">

                                                            <thead>

                                                                <tr class="table-title">
                                                                    <td colspan="8" style="font-weight: bold; background-color: skyblue;">REGISTER ADDRESS</td>
                                                                </tr>

                                                                <tr>
                                                                    <th style="width: 25%;">Street / House No.</th>
                                                                    <td style="width: 25%;"><span class="wrap-text">${list.officeAddressLine1}</span></td>
                                                                    <th style="width: 25%;">Street-1</th>
                                                                    <td style="width: 25%;"><span class="wrap-text">${list.officeAddressLine2}</span></td>
                                                                </tr>

                                                            </thead>

                                                            <tbody>

                                                                <tr>
                                                                    <th style="width: 25%;">Street-2</th>
                                                                    <td style="width: 25%;"><span class="wrap-text">${list.officeAddressLine3}</span></td>
                                                                    <th style="width: 25%;">Country</th>
                                                                    <td style="width: 25%;">${list.officeCountry}</td>

                                                                </tr>

                                                                <tr>
                                                                    <th style="width: 25%;">State</th>
                                                                    <td>${list.officeState}</td>
                                                                    <th style="width: 25%;">District</th>
                                                                    <td>${list.officeDistrict}</td>
                                                                </tr>

                                                                <tr>
                                                                    <th style="width: 25%;">City</th>
                                                                    <td>${list.officeCity}</td>
                                                                    <th style="">Postal Code</th>
                                                                    <td>${list.officePin}</td>
                                                                </tr>

                                                                <tr>
                                                                    <th style="">Mobile No</th>
                                                                    <td>+${list.countryCodeoffTele}-${list.officeTelephone}</td>
                                                                    <th style="">Email</th>
                                                                    <td>${list.officeEmail}</td>
                                                                </tr>

                                                                <tr>
                                                                    <th style="">Website</th> 
                                                                    <td>${list.officeWebsite}</td>
                                                                    <th style=""></th> 
                                                                    <td></td> 
                                                                </tr>

                                                            </tbody>
                                                        </table>
                                                    </div>
                                                    <BR>

                                                    <div class="table-responsive">
                                                        <table class="bottom-table" id="" align="Center">

                                                            <thead>

                                                                <tr class="table-title">
                                                                    <td colspan="8" style="font-weight: bold; background-color: skyblue;">COMMUNICATION ADDRESS</td>
                                                                </tr>

                                                                <tr>
                                                                    <th style="width: 25%;">Street / House No.</th>
                                                                    <td style="width: 25%;"><span class="wrap-text">${declaration.altLocalAddress}</span></td>
                                                                    <th style="width: 25%;">Street-1</th>
                                                                    <td style="width: 25%;"><span class="wrap-text">${declaration.altLocalAddress1}</span></td>
                                                                </tr>

                                                                <tr>                                                                
                                                                    <th style="width: 25%;">Street-2</th>
                                                                    <td style="width: 25%;"> <span class="wrap-text">${declaration.altLocalAddress2}</span></td>
                                                                    <th style="width: 25%;">Country</th>
                                                                    <td style="width: 25%;">${declaration.altCountry}</td>
                                                                </tr>

                                                            </thead>

                                                            <tbody>

                                                                <tr>
                                                                    <th style="width: 25%;">State</th>
                                                                    <td>${declaration.altState}</td>
                                                                    <th style="width: 25%;">City</th>
                                                                    <td>${declaration.altCity}</td>
                                                                </tr>

                                                                <tr>
                                                                    <th style="width: 25%;">District</th>
                                                                    <td>${declaration.altDistrict}</td>
                                                                    <th style="">Postal Code</th>
                                                                    <td>${declaration.altPostalCode}</td>
                                                                </tr>

                                                                <tr>
                                                                    <th style="">Mobile No</th>
                                                                    <td>+${list.countryCodeNewMobiles}-${declaration.altTelephone}</td>
                                                                    <th style="">Email</th>
                                                                    <td>${declaration.altEmail}</td>
                                                                </tr>

                                                                <tr>                                                                    
                                                                    <th style="">Website</th>
                                                                    <td>${declaration.altWebsite}</td>
                                                                    <th style=""></th>
                                                                    <td></td>
                                                                </tr>

                                                            </tbody>
                                                        </table>
                                                    </div>
                                                    <BR>

                                                 
                                                    
                                                    
                                                    <div class="form-group">
                                                        <table id="table_1" class="bottom-table" style="" align="Center">
                                                            <tr class="table-title">
                                                                <td colspan="8" style="font-weight: bold; background-color: skyblue;">TYPE OF VENDORS</td>
                                                            </tr>
                                                            <c:forEach var="list222" items="${list222}" varStatus="status">

                                                                <tr>
                                                                <input type="hidden" class="input-field" id="groupId" name="groupId" value="${list222[2]}<" />
                                                                <td>${list222[2]}</td>
                                                                <td>${list222[3]}</td>
                                                                <td>${list222[4]}</td>
                                                                </tr>
                                                            </c:forEach>
                                                        </table>
                                                    </div>

                                                    <div class="table-responsive">
                                                        <table class="bottom-table" id="table_1" class="table table-bordered table-striped table-hover" align="Center">
                                                            <thead <tr class="table-title">
                                                                    <td colspan="7" style="font-weight: bold; background-color: skyblue;">VENDOR CONTACTS</td>
                                                                </tr>
                                                                <tr style="">
                                                                    <th>Type</th>
                                                                    <th>Name</th>
                                                                    <th>Job Title</th>
                                                                    <th>Phone No.</th>
                                                                    <th>Email</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <tr>
                                                                    <td>Sales/Commercial Contact(s) </td>
                                                                    <td>${list.sales_name}</td>
                                                                    <td>${list.sales_job}</td>
                                                                    <td>+${list.countryCodeVendorContact}-${list.sales_phone}</td>
                                                                    <td>${list.saleEmail}</td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Technical Contact(s) </td>
                                                                    <td>${list.technical_name}</td>
                                                                    <td>${list.technical_job}</td>
                                                                    <td>+${list.countryCodeVendorContact1}-${list.technical_phone}</td>
                                                                    <td>${list.technicalContactEmail}</td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Finance and Accounts </td>
                                                                    <td>${list.quality_name}</td>
                                                                    <td>${list.quality_job}</td>
                                                                    <td>+${list.countryCodeVendorContact2}-${list.quality_phone}</td>
                                                                    <td>${list.qualityEmail}</td>
                                                                </tr>                                                                
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                    <br>
                                                    <div class="table-responsive">
                                                        <table class="bottom-table" id="" class="table table-bordered table-striped table-hover" align="Center">
                                                            <thead>
                                                                <tr class="table-title">
                                                                    <td colspan="7" style="font-weight: bold; background-color: skyblue;">MANAGERIAL PERSON DETAILS</td>
                                                                </tr>
                                                                <tr style="">
                                                                    <th>Sr No.</th>
                                                                    <th>Name</th>
                                                                    <th>Designation</th>
                                                                    <th>Phone No.</th>
                                                                    <th>Email</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <c:forEach items="${mplist}" var="mplist" varStatus="status">
                                                                    <tr>
                                                                        <td>${status.count}</td>
                                                                        <td>${mplist.name}</td>
                                                                        <td>${mplist.designation}</td>
                                                                        <td>${mplist.phoneNo}</td>
                                                                        <td>${mplist.emailId}</td>
                                                                    </tr>
                                                                </c:forEach>
                                                            </tbody>
                                                        </table>
                                                    </div>

                                                   <br>

                                    <div class="table-responsive">
                                        <table class="bottom-table" id="" class="table table-bordered table-striped table-hover" align="Center">
                                            <thead>
                                                <tr class="table-title">
                                                    <td colspan="7" style="font-weight: bold; background-color: skyblue;">  PAST WORKING EXPERIENCE DETAILS </td>
                                                </tr>
                                                       <th>Company Name</th>
                                                        <th >Contact Person Name</th>
                                                        <th >Phone No.</th>
                                                        <th >Email</th>
                                                        <th >Designation</th>
                                                        <th >Attachment</th>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="lstwork" items="${lstwork}">
                                                    <tr>
                                                        <td><span>${lstwork.companyName}</span> </td> 
                                                         <td><span>${lstwork.contactPersonName}</span> </td>

                                                        <td ><span>+${lstwork.countryCode}-${lstwork.mobileNumber}</span> </td> 
                                                        <td ><span>${lstwork.email}</span> </td> 
                                                        <td ><span>${lstwork.designation}</span></td> 

                                                        <td >
                                                            <c:if test="${lstwork.attchment!=null && not empty lstwork.attchment}">                                        
                                                                <span class="file-wrapper">
                                                                    <span class="file-name text-break">${lstwork.attchment}</span>
                                                                    <span class="file-actions">
                                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadLastWorkingFileAprrove&fileName=${lstwork.attchment}&id=${lstwork.vendorInformationId}"><span class="fa fa-download"></span></a>
                                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${lstwork.vendorInformationId}/LAST/${lstwork.attchment}"><span class="fa fa-solid fa-eye"></span></a>
                                                                    </span>
                                                                </span>
                                                            </c:if>
                                                        </td>


                                                                                                       

                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
     <br>

                                                    <div class="it-section">
                                                        <table class="bottom-table">
                                                            <thead>
                                                                <tr class="table-title">
                                                                    <td colspan="9" style="font-weight: bold; background-color: skyblue;">IT CRITERIA</td>
                                                                </tr>
                                                                <tr style="">
                                                                    <th>Sr No.</th>
                                                                    <th>Criteria</th>
                                                                    <th>Selection Criteria</th>
                                                                   
                                                                    
                                                                    <th>Vendor Score</th>
                                                                     <th>Comment</th>
                                                                     <th>Attachment</th>
                                                                    <th>IT Score</th>
                                                                    <th>IT Comment</th>
                                                                </tr>
                                                            </thead>

                                                            <tbody>
                                                            <input type="hidden" name="vendorPercentage" id="vendorPercentage" value="${vendorPercentage[0].itPercentage}">

                                                            <c:forEach var="list5" items="${itList}" varStatus="status">
                                                                <tr>
                                                                    <td>${status.count}</td>
                                                                    <td style="width: 15%;"><pre class="terms-details">${list5.criteriaName}</pre></td>
                                                                    <td style="width: 25%;"><pre class="terms-details">${list5.criteriaDescription}</pre></td>
                                                                   

                                                                    

                                                                <input type="hidden" name="criteriaName" value="${list5.id}">

                                                                <td style="width: 10%;">
                                                                    <c:if test="${list5.score==0}">NO</c:if>
                                                                    <c:if test="${list5.score==1}">YES</c:if>
                                                                    </td>
                                                                     <td style="width: 10%;">${list5.comment}</td>
                                                                <td style="width: 10%;">
                                                                        <c:if test="${list5.attachement!=null && not empty list5.attachement}">                                        
                                                                            <span class="file-wrapper">
                                                                                <span class="file-name text-break">${list5.attachement}</span>
                                                                                <span class="file-actions">
                                                                                    <a class="fw-600 text-break gradient-text" href="vendorInformation.htm?act=downloadCriteriaFileAprrove&amp;fileName=${list5.attachement}&foldName=IT&id=${list.id}">&nbsp;<span class="fa fa-download"></span></a>
                                                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/IT/${list5.attachement}"><span class="fa fa-solid fa-eye"></span></a>					
                                                                                </span>
                                                                            </span>
                                                                        </c:if>
                                                                    </td>
                                                                    <td style="width: 10%;" class="itScore" data-accept="${list5.accept}">
                                                                    <c:if test="${list5.accept=='2'}">Accept</c:if>
                                                                    <c:if test="${list5.accept=='1'}">Partial Accept</c:if>
                                                                    <c:if test="${list5.accept=='0'}">Reject</c:if>
                                                                    </td>

                                                                    <td style="width: 10%;">
                                                                    ${list5.itComment}
                                                                </td>
                                                                </tr>
                                                            </c:forEach>


                                                            <tr>
                                                                <td colspan="6" style="font-weight: bold;">Total</td>
                                                                <td><input type="text" id="total" readonly="true" name="total" class="input-field"></td>
                                                                <td></td>
                                                            </tr>


                                                            <tr>
                                                                <td colspan="6" style="font-weight: bold;">Total Percentage</td>
                                                                <td><input type="text" id="percentage" readonly="true" name="percentage" class="input-field"></td>
                                                                <td></td>
                                                            </tr>
                                                            </tbody>
                                                        </table>


                                                        <script>
                                                                    document.addEventListener("DOMContentLoaded", function () {
                                                                    let total = 0;
                                                                            let count = 0;
                                                                            document.querySelectorAll(".itScore").forEach(function (cell) {
                                                                    let acceptVal = cell.getAttribute("data-accept");
                                                                            let score = parseInt(acceptVal);
                                                                            if (!isNaN(score)) {
                                                                    total += score;
                                                                            count++;
                                                                    }
                                                                    });
                                                                            document.getElementById("total").value = total;
                                                                            if (count > 0) {
                                                                    let percentage = ((total / (count * 2)) * 100).toFixed(2);
                                                                            document.getElementById("percentage").value = percentage + " %";
                                                                    } else {
                                                                    document.getElementById("percentage").value = "0 %";
                                                                    }
                                                                    });</script>

                                                    </div>
                                                 </c:forEach>
                                                    <br>


                    <div class="approval-section">
                                                    <table class="bottom-table"  id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center">

                                                        <thead>
                                                            <tr class="table-title">
                                                                <td colspan="7" style="font-weight: bold; background-color: skyblue;">APPROVAL HISTORY</td>
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
                                                </div>

                </form:form>
            </section>
        </main>        
    </body>


    <!--<script src="StorageYard/assets/js/TableScript/commonTableScript.js" type="text/javascript"></script>-->

    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>


