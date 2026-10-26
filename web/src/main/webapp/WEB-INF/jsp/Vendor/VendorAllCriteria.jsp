<%-- 
    Document   : VendorAllCriteria
    Created on : 31 Oct, 2025, 03:00:57 PM
    Author     : fnp
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarNewVendor.jsp"%>

    <head>
        <title>View Vendor All Details</title>

    <body>
        <style>
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
            
            #containers {
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                height: 800px;
            }
            @media print {

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

                * {
                    box-sizing: border-box !important;
                    margin: 0 !important;
                    padding: 0 !important;
                }

                body * {
                    visibility: hidden !important;
                }

                #printSection, #printSection * {
                    visibility: visible !important;
                }

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

                h1, h2, h3, h4, h5, h6, p {
                    margin: 2px 0 !important;
                    line-height: 1.2 !important;
                }

                .table_wrapper, .table-responsive {
                    overflow: visible !important;
                    width: 100% !important;
                    height: auto !important;
                    max-height: none !important;
                    display: block !important;
                    padding: 0 !important;
                    margin: 0 !important;
                    -ms-overflow-style: none !important;
                    scrollbar-width: none !important;  
                }

                .table_wrapper::-webkit-scrollbar,
                .table-responsive::-webkit-scrollbar {
                    display: none !important; 
                }

                table {
                    width: 100% !important;
                    max-width: 100% !important;
                    table-layout: fixed !important;
                    border-collapse: collapse !important;
                    word-wrap: break-word !important;
                    overflow-wrap: break-word !important;
                    overflow: visible !important;
                    margin: 0 auto !important;
                    -ms-overflow-style: none !important;
                    scrollbar-width: none !important;    
                }

                table::-webkit-scrollbar {
                    display: none !important; 
                }

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
                    display: table-header-group !important; 
                }

                tr {
                    page-break-inside: avoid !important;
                }

                [class*="mb-"], [class*="mt-"], [class*="pb-"], [class*="pt-"] {
                    margin: 0 !important;
                    padding: 0 !important;
                }

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
                    -webkit-print-color-adjust: exact !important;
                    color-adjust: exact !important;
                    print-color-adjust: exact !important;
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
                    color: black !important;
                }
                .fa, .fas, .far, .fal, .fad, .fab {
                    display: none !important;
                }
                .safety-section, .approval-section, .hr-section, .technical-section, .it-section {
                    page-break-before: always;
                }

                .no-print {
                    display: none !important;
                }
            }

        </style>         


        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">

            <section id="printSection" class="main-content">
                <form:form action="vendorInformation.htm?act=allCriteriaSubmited"  enctype="multipart/form-data" method="post"
                           name='form' class="form-horizontal" role="form">
                    <input type="hidden" id="VInformationId" name="VInformationId" value="${VInformationId}">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">View Vendor All Details</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a href="vendorInformation.htm?act=vendorAllCriteriaBack&VInformationId=${vendorInformation.id}" class="btn theme-btn light-btn mr-3">Back</a>                                            
                            <a href="vendorInformation.htm?act=VendorAllCriteriaPrint&id=${vendorInformation.id}" 
                               class="btn theme-btn mr-3">
                                Print
                            </a>              
                        </div>
                    </div>
                    <hr>

                    <table   class="bottom-table"  id="" class="table table-bordered table-striped " style="" align="Center"  >
                        <thead>
                            <tr class="table-title" style="cursor:pointer;">

                                <td colspan="2" style="font-weight:bold;background-color:skyblue;">VENDOR DETAILS</td>

                                <td colspan="2" style="font-weight:bold;background-color:skyblue; text-align:right;">ALL ATTACHMENTS
                                    <a href="vendorInformation.htm?act=vendorDetailsDocxdownloadzip&id1=${VInformationId}" style="margin-left:10px;">
                                        <i class="fa fa-download"></i>
                                    </a> &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
                                    
                                    <i class="bi bi-caret-down-fill" id="toggleIcon" onclick="toggleVendorTable()" style="margin-left:10px; cursor:pointer;  float:right;"></i>
                                   
                                </td>

                            </tr>
                        </thead>
                        <tbody id="vendorTableBody" style="display:none;">
                            <tr>
                                <th>
                                    <c:if test="${vendorInformation.policyAccept=='1'}">Code of Conduct (Sign & Stamp in all Pages)</c:if>
                                    <c:if test="${vendorInformation.policyAccept=='0'}">Deviation Policy</c:if>
                                </th>
                                <td>
                                    <c:if test="${vendorInformation.policyAccept=='1'}">Accept</c:if>
                                    <c:if test="${vendorInformation.policyAccept=='0'}"><span style="color: red;">Not Accept</span></c:if><br>
                                    
                                    <c:if test="${vendorInformation.policy1File!=null && not empty vendorInformation.policy1File}">                                        
                                        <span class="file-wrapper">
                                            <span class="file-name text-break">${vendorInformation.policy1File}</span>
                                            <span class="file-actions">
                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.policy1File}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.policy1File}"><span class="fa fa-solid fa-eye"></span></a>
                                            </span>
                                        </span>
                                    </c:if>
                                </td>
                                <th> 
                                    <c:if test="${vendorInformation.ndaPolicyAccept=='1'}">NDA (Sign & Stamp in all Pages)</c:if>
                                    <c:if test="${vendorInformation.ndaPolicyAccept=='0'}">NDA Policy</c:if>
                                </th> 
                                <td>
                                    <c:if test="${vendorInformation.ndaPolicyAccept=='1'}">Accept</c:if>
                                    <c:if test="${vendorInformation.ndaPolicyAccept=='0'}"><span style="color: red;">Not Accept</span></c:if><br>
                                    
                                    <c:if test="${vendorInformation.ndaPolicyFile!=null && not empty vendorInformation.ndaPolicyFile}">                                        
                                        <span class="file-wrapper">
                                            <span class="file-name text-break">${vendorInformation.ndaPolicyFile}</span>
                                            <span class="file-actions">
                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.ndaPolicyFile}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.ndaPolicyFile}"><span class="fa fa-solid fa-eye"></span></a>
                                            </span>
                                        </span>
                                    </c:if>
                                </td>
                            </tr>
                            <tr>
                                <th  style=";">Type of Company</th>
                                <td>${vendorInformation.typeOfConcern}</td>
                                <c:choose>
                                    <c:when test="${vendorInformation.typeOfConcern == 'Sole Proprietorship'}">
                                        <th  style=";">
                                            Shop or Establishment License
                                        </th>
                                    </c:when>

                                    <c:when test="${vendorInformation.typeOfConcern == 'Hindu Undivided Family ( HUF)'}">
                                        <th  style=";">
                                            Shop or Establishment License and HUF Deed
                                        </th>
                                    </c:when>

                                    <c:when test="${vendorInformation.typeOfConcern == 'Partnership Firm'}">
                                        <th  style=";">
                                            Shop or Establishment License and Partnership Deed
                                        </th>
                                    </c:when>

                                    <c:when test="${vendorInformation.typeOfConcern == 'Limited Liability Partnership ( LLP)'}">
                                        <th  style=";">
                                            Shop or Establishment License and LLP Agreement
                                        </th>
                                    </c:when>

                                    <c:when test="${vendorInformation.typeOfConcern == 'Private/Public Company'}">
                                        <th  style=";">
                                            Certificate of Incorporation (MCA)
                                        </th>
                                    </c:when>
                                    <c:when test="${vendorInformation.typeOfConcern == 'Free Lancer'}">
                                        <th  style=";">
                                            Professional Profile / Resume
                                        </th>
                                    </c:when>

                                    <c:otherwise>
                                        <th  style=";">Proof Of Attachment</th>
                                        </c:otherwise>
                                    </c:choose>

                                <td> 
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
                            <tr>
                                <th style="">Year of Establishment of Company</th>
                                <td>${vendorInformation.establishment}</td>
                                <th style="">Risk Category</th>
                                <td class="riskCategory">${vendorInformation.riskCategory}</td>
                            </tr>
                        </tbody>
                    </table>
                        <script>

                function toggleVendorTable(){

                    var table = document.getElementById("vendorTableBody");
                    var icon = document.getElementById("toggleIcon");

                    if(table.style.display === "none"){
                        table.style.display = "table-row-group";

                        icon.classList.remove("bi-caret-down-fill");
                        icon.classList.add("bi-caret-up-fill");

                    }else{
                        table.style.display = "none";

                        icon.classList.remove("bi-caret-up-fill");
                        icon.classList.add("bi-caret-down-fill");
                    }

                }

                    </script>     
                    <br>

                    <div class="table-responsive">
                        <table   class="bottom-table"  id="" class="table table-bordered table-striped " style="" align="Center"  >
                            <thead>
                                <tr class="table-title" style="cursor:pointer;">
                                    <td colspan="8" style="font-weight: bold; background-color: skyblue;">REGISTER ADDRESS
                                        <i class="bi bi-caret-down-fill" id="toggleRegisterIcon"
                                           onclick="toggleRegisterTable()"
                                           style="margin-left:10px; cursor:pointer;  float:right;"></i>
                                    </td>

                                </tr>

                               

                            </thead>

                            <tbody id="RegisterTableBody" style="display:none;">
                                 <tr>
                                    <th style="width: 25%;;">Street / House No.</th>
                                    <td style="width: 25%;"><span class="wrap-text">${vendorInformation.officeAddressLine1}</span></td>
                                    <th style="width: 25%;;">Street-1</th>
                                    <td style="width: 25%;"><span class="wrap-text">${vendorInformation.officeAddressLine2}</span></td>
                                </tr>
                                <tr>
                                    <th style="width: 25%;;">Street-2</th>
                                    <td style="width: 25%;"><span class="wrap-text">${vendorInformation.officeAddressLine3}</span></td>
                                    <th style="width: 25%;;">Country</th>
                                    <td style="width: 25%;">${vendorInformation.officeCountry}</td>

                                </tr>

                                <tr>
                                    <th style="width: 25%;;">State</th>
                                    <td>${vendorInformation.officeState}</td>
                                    <th style="width: 25%;;">District</th>
                                    <td>${vendorInformation.officeDistrict}</td>
                                </tr>

                                <tr>
                                    <th style="width: 25%;;">City</th>
                                    <td>${vendorInformation.officeCity}</td>
                                    <th style=";">Postal Code</th>
                                    <td>${vendorInformation.officePin}</td>
                                </tr>

                                <tr>
                                    <th style=";">Mobile No</th>
                                    <td>
                                   <c:if test="${!empty vendorInformation.countryCodeoffTele}">
                                       +${vendorInformation.countryCodeoffTele}-</c:if>${vendorInformation.officeTelephone}</td>
                                    <th style=";">Email</th>
                                    <td>${vendorInformation.officeEmail}</td>
                                </tr>

                                <tr>
                                    <th style=";">Website</th> 
                                    <td>${vendorInformation.officeWebsite}</td>
                                    <th style=";"></th> 
                                    <td></td> 
                                </tr>
                            </tbody>
                        </table>
                    </div>


                    <script>

                function toggleRegisterTable(){

                    var table = document.getElementById("RegisterTableBody");
                    var icon = document.getElementById("toggleRegisterIcon");

                    if(table.style.display === "none"){
                        table.style.display = "table-row-group";

                        icon.classList.remove("bi-caret-down-fill");
                        icon.classList.add("bi-caret-up-fill");

                    }else{
                        table.style.display = "none";

                        icon.classList.remove("bi-caret-up-fill");
                        icon.classList.add("bi-caret-down-fill");
                    }

                }

                    </script>                                                               
                                                                
                                                    <BR>

                                    <div class="table-responsive">
                                        <table   class="bottom-table"  id="" class="table table-bordered table-striped " style="" align="Center"  >

                                            <thead>
                                                <tr class="table-title" style="cursor:pointer;">
                                                    <td colspan="8" style="font-weight: bold; background-color: skyblue;">COMMUNICATION ADDRESS
                                                    <i class="bi bi-caret-down-fill" id="toggleCommunicationIcon"
                                           onclick="toggleCommunicationTable()"
                                           style="margin-left:10px; cursor:pointer;  float:right;"></i>
                                                    </td>
                                                </tr>

                                                

                                            </thead>

                                            <tbody id="CommunicationTableBody" style="display:none;">
<tr>
                                                    <th style="width: 25%;;">Street / House No.</th>
                                                    <td style="width: 25%;"><span class="wrap-text">${declaration.altLocalAddress}</span></td>
                                                    <th style="width: 25%;;">Street-1</th>
                                                    <td style="width: 25%;"><span class="wrap-text">${declaration.altLocalAddress1}</span></td>
                                                </tr>

                                                <tr>                                                                
                                                    <th style="width: 25%;;">Street-2</th>
                                                    <td style="width: 25%;"> <span class="wrap-text">${declaration.altLocalAddress2}</span></td>
                                                    <th style="width: 25%;;">Country</th>
                                                    <td style="width: 25%;">${declaration.altCountry}</td>
                                                </tr>
                                                <tr>
                                                    <th style="width: 25%;;">State</th>
                                                    <td>${declaration.altState}</td>
                                                    <th style="width: 25%;;">City</th>
                                                    <td>${declaration.altCity}</td>
                                                </tr>

                                                <tr>
                                                    <th style="width: 25%;;">District</th>
                                                    <td>${declaration.altDistrict}</td>
                                                    <th style=";">Postal Code</th>
                                                    <td>${declaration.altPostalCode}</td>
                                                </tr>

                                                <tr>
                                                    <th style=";">Mobile No</th>
                                                    <td>
                                                      <c:if test="${!empty vendorInformation.countryCodeNewMobiles}">   
                                                          +${vendorInformation.countryCodeNewMobiles}-</c:if>${declaration.altTelephone}</td>
                                                    <th style=";">Email</th>
                                                    <td>${declaration.altEmail}</td>
                                                </tr>

                                                <tr>                                                                    
                                                    <th style=";">Website</th>
                                                    <td>${declaration.altWebsite}</td>
                                                    <th style=";"></th>
                                                    <td></td>
                                                </tr>

                                            </tbody>
                                        </table>
                                    </div>
                                                    
                     <script>

                function toggleCommunicationTable(){

                    var table = document.getElementById("CommunicationTableBody");
                    var icon = document.getElementById("toggleCommunicationIcon");

                    if(table.style.display === "none"){
                        table.style.display = "table-row-group";

                        icon.classList.remove("bi-caret-down-fill");
                        icon.classList.add("bi-caret-up-fill");

                    }else{
                        table.style.display = "none";

                        icon.classList.remove("bi-caret-up-fill");
                        icon.classList.add("bi-caret-down-fill");
                    }

                }

                    </script>                               
                                                    
                                                    
                                    <br>
                                    <div class="form-group">
                                        <table   class="bottom-table"  id="" class="table table-bordered table-striped " style="" align="Center"  >
                                                <thead >
                                                    <tr class="table-title" style="cursor:pointer;">
                                                        <td colspan="8" style="font-weight: bold; background-color: skyblue;">TYPE OF VENDORS
                                                        <i class="bi bi-caret-down-fill" id="toggleTypeIcon"
                                           onclick="toggleTypeTable()"
                                           style="margin-left:10px; cursor:pointer;  float:right;"></i>
                                                        </td>
                                                    </tr>
                                                </thead>
                                                <tbody id="TypeTableBody" style="display:none;">
                                                    <c:forEach var="list" items="${list7}" varStatus="status">

                                                    <input type="hidden" class="form-control" id="groupId" name="groupId" value="${list[2]}<" />
                                                    <tr>
                                                        <td>${list[2]}</td>
                                                        <td>${list[3]}</td>
                                                        <td>${list[4]}</td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>

                                            </table>
                                        </div>

<script>

                function toggleTypeTable(){

                    var table = document.getElementById("TypeTableBody");
                    var icon = document.getElementById("toggleTypeIcon");

                    if(table.style.display === "none"){
                        table.style.display = "table-row-group";

                        icon.classList.remove("bi-caret-down-fill");
                        icon.classList.add("bi-caret-up-fill");

                    }else{
                        table.style.display = "none";

                        icon.classList.remove("bi-caret-up-fill");
                        icon.classList.add("bi-caret-down-fill");
                    }

                }

                    </script> 
                                    <div class="table-responsive">
                                        <table   class="bottom-table"  id="" class="table table-bordered table-striped " style="" align="Center"  >
                                            <thead>
                                                <tr class="table-title" style="cursor:pointer;">
                                                    <td colspan="7" style="font-weight: bold; background-color: skyblue;">VENDOR CONTACTS
                                                    <i class="bi bi-caret-down-fill" id="toggleContactsIcon"
                                           onclick="toggleContactsTable()"
                                           style="margin-left:10px; cursor:pointer;  float:right;"></i>
                                                    </td>
                                                </tr>
                                                
                                            </thead>
                                            <tbody id="ContactsTableBody" style="display:none;">
                                                <tr style=";">
                                                    <th>Type</th>
                                                    <th>Name</th>
                                                    <th>Job Title</th>
                                                    <th>Phone No.</th>
                                                    <th>Email</th>
                                                </tr>
                                                <tr>
                                                    <td>Sales/Commercial Contact(s) </td>
                                                    <td>${vendorInformation.sales_name}</td>
                                                    <td>${vendorInformation.sales_job}</td>
                                                    <td><c:if test="${!empty vendorInformation.countryCodeVendorContact}">
                                                        +${vendorInformation.countryCodeVendorContact}-</c:if>${vendorInformation.sales_phone}</td>
                                                    <td>${vendorInformation.saleEmail}</td>
                                                </tr>
                                                <tr>
                                                    <td>Technical Contact(s) </td>
                                                    <td>${vendorInformation.technical_name}</td>
                                                    <td>${vendorInformation.technical_job}</td>
                                                    <td><c:if test="${!empty vendorInformation.countryCodeVendorContact1}">
                                                        +${vendorInformation.countryCodeVendorContact1}-</c:if>${vendorInformation.technical_phone}</td>
                                                    <td>${vendorInformation.technicalContactEmail}</td>
                                                </tr>
                                                <tr>
                                                    <td>Finance and Accounts </td>
                                                    <td>${vendorInformation.quality_name}</td>
                                                    <td>${vendorInformation.quality_job}</td>
                                                    <td><c:if test="${!empty vendorInformation.countryCodeVendorContact2}">
                                                        +${vendorInformation.countryCodeVendorContact2}-</c:if>${vendorInformation.quality_phone}</td>
                                                    <td>${vendorInformation.qualityEmail}</td>

                                                </tr>                                                
                                            </tbody>
                                        </table>
                                    </div>
<script>

                function toggleContactsTable(){

                    var table = document.getElementById("ContactsTableBody");
                    var icon = document.getElementById("toggleContactsIcon");

                    if(table.style.display === "none"){
                        table.style.display = "table-row-group";

                        icon.classList.remove("bi-caret-down-fill");
                        icon.classList.add("bi-caret-up-fill");

                    }else{
                        table.style.display = "none";

                        icon.classList.remove("bi-caret-up-fill");
                        icon.classList.add("bi-caret-down-fill");
                    }

                }

                    </script>
                                    <br>

                                    <div class="table-responsive">
                                        <table   class="bottom-table"  id="" class="table table-bordered table-striped " style="" align="Center"  >
                                            <thead>
                                                <tr class="table-title" style="cursor:pointer;">
                                                    <td colspan="7" style="font-weight: bold; background-color: skyblue;">MANAGERIAL PERSON DETAILS
                                                    <i class="bi bi-caret-down-fill" id="toggleMANAGERIALIcon"
                                           onclick="toggleMANAGERIALTable()"
                                           style="margin-left:10px; cursor:pointer;  float:right;"></i>
                                                    
                                                    </td>
                                                </tr>
                                                
                                            </thead>
                                            <tbody id="MANAGERIALTableBody" style="display:none;">
                                                <tr style=";">
                                                    <th>Sr No.</th>
                                                    <th>Name</th>
                                                    <th>Designation</th>
                                                    <th>Phone No.</th>
                                                    <th>Email</th>
                                                </tr>
                                                <c:forEach items="${mplist}" var="mplist" varStatus="status">
                                                    <tr>
                                                        <td>${status.count}</td>
                                                        <td>${mplist.name}</td>
                                                        <td>${mplist.designation}</td>
                                                        <td>+${mplist.countryCode}-${mplist.phoneNo}</td>
                                                        <td>${mplist.emailId}</td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                    <script>

                function toggleMANAGERIALTable(){

                    var table = document.getElementById("MANAGERIALTableBody");
                    var icon = document.getElementById("toggleMANAGERIALIcon");

                    if(table.style.display === "none"){
                        table.style.display = "table-row-group";

                        icon.classList.remove("bi-caret-down-fill");
                        icon.classList.add("bi-caret-up-fill");

                    }else{
                        table.style.display = "none";

                        icon.classList.remove("bi-caret-up-fill");
                        icon.classList.add("bi-caret-down-fill");
                    }

                }

                    </script>
                                    <br>

                                    <div class="table-responsive">
                                        <table   class="bottom-table"  id="" class="table table-bordered table-striped " style="" align="Center"  >
                                            <thead>
                                                <tr class="table-title" style="cursor:pointer;">
                                                    <td colspan="5" style="font-weight:bold;background-color:skyblue;"> PAST WORKING EXPERIENCE DETAILS  </td>

                                                    <td colspan="1" style="font-weight:bold;background-color:skyblue; text-align:right;">ALL ATTACHMENTS
                                                        <a href="vendorInformation.htm?act=pastWorkingExpDetailsDocxdownloadzip&id1=${VInformationId}" style="text-decoration: none; color: black; font-size: 16px;">
                                                            <i class="fa fa-download"></i>
                                                        </a> &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;

                                                        <i class="bi bi-caret-down-fill" id="togglePASTIcon"
                                                           onclick="togglePASTTable()"
                                                           style="margin-left:10px; cursor:pointer;  float:right;"></i> 
                                                    </td>
                                                </tr> 
                                            </thead>
                                            <tbody id="PASTTableBody" style="display:none;">
                                            <th >Company Name</th>
                                            <th >Contact Person Name</th>
                                            <th >Phone No.</th>
                                            <th >Email</th>
                                            <th >Designation</th>
                                            <th >Attachment</th>
                                                <c:forEach var="lstwork" items="${lstwork}">
                                                <tr>
                                                    <td><span>${lstwork.companyName}</span> </td> 
                                                    <td><span>${lstwork.contactPersonName}</span> </td>
                                                    <td><span>+${lstwork.countryCode}-${lstwork.mobileNumber}</span> </td> 
                                                    <td><span>${lstwork.email}</span> </td> 
                                                    <td><span>${lstwork.designation}</span></td> 

                                                    <td>                                                        
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
<script>

                function togglePASTTable(){

                    var table = document.getElementById("PASTTableBody");
                    var icon = document.getElementById("togglePASTIcon");

                    if(table.style.display === "none"){
                        table.style.display = "table-row-group";

                        icon.classList.remove("bi-caret-down-fill");
                        icon.classList.add("bi-caret-up-fill");

                    }else{
                        table.style.display = "none";

                        icon.classList.remove("bi-caret-up-fill");
                        icon.classList.add("bi-caret-down-fill");
                    }

                }

                    </script>
                                    <br>

                                    <div class="table-responsive">
                                        <table   class="bottom-table"  id="" class="table table-bordered table-striped " style="" align="Center"  >
                                           
                                        <tr class="table-title" style="cursor:pointer;">

                                <td colspan="3" style="font-weight:bold;background-color:skyblue;">COMPANY REGISTRATION DETAILS</td>

                                <td colspan="3" style="font-weight:bold;background-color:skyblue; text-align:right;">ALL ATTACHMENTS
                                    <a href="vendorInformation.htm?act=companyRegDetailsDocxdownloadzip&id1=${VInformationId}" style="text-decoration: none; color: black; font-size: 16px;">
                                                            <i class="fa fa-download"></i>
                                                        </a> &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
                                    <i class="bi bi-caret-down-fill" id="toggleCOMPANYIcon"
                                           onclick="toggleCOMPANYTable()"
                                           style="margin-left:10px; cursor:pointer;  float:right;"></i> 
                                </td>
                            </tr>     
                                  
                                            <tbody id="COMPANYTableBody" style="display:none;" >
                                                <tr>
                                                    <th>GST No.</th>
                                                    <td>
                                                        ${vendorInformation.gstinNo}<br>
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
                                                    <th>PAN No</th>
                                                    <td>                                                    
                                                        ${vendorInformation.panNo}<br>
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
                                                    <th>MSME No</th>
                                                    <td>
                                                        <c:if test="${vendorInformation.msmeStatus=='0'}"><strong>MSME Not Available</strong></c:if>
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
                                                    <th>ESIC No</th>
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
                                                    <th>EPFO No.</th>
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
                                                    <th>Import Export Code </th>
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
                                    </div>
<script>

                function toggleCOMPANYTable(){

                    var table = document.getElementById("COMPANYTableBody");
                    var icon = document.getElementById("toggleCOMPANYIcon");

                    if(table.style.display === "none"){
                        table.style.display = "table-row-group";

                        icon.classList.remove("bi-caret-down-fill");
                        icon.classList.add("bi-caret-up-fill");

                    }else{
                        table.style.display = "none";

                        icon.classList.remove("bi-caret-up-fill");
                        icon.classList.add("bi-caret-down-fill");
                    }

                }

                    </script>
                                    <br>

                                    <div class="table-responsive">
                                        <table   class="bottom-table"  id="" class="table table-bordered table-striped " style="" align="Center"  >
                                            <thead>
                                                <tr class="table-title" style="cursor:pointer;">
                                                    <td colspan="7" style="font-weight: bold; background-color: skyblue;">BANK DETAILS
                                                    
                                                   <i class="bi bi-caret-down-fill" id="toggleBankIcon"onclick="toggleBankTable()"
                                           style="margin-left:10px; cursor:pointer;  float:right;"></i>   
                                                    </td>
                                                </tr>
                                               
                                            </thead>
                                            <tbody id="BankTableBody" style="display:none;">
                                                 <tr>
                                                    <th style=";" >Account Number</th>
                                                    <td>${vendorInformation.accountNumber}</td>
                                                    <th style=";">Bank Name </th>
                                                    <td>${vendorInformation.bankName}</td>
                                                    <th style=";">Branch</th>
                                                    <td>${vendorInformation.branch}</td>
                                                </tr>
                                                <tr>
                                                    <th style=";">IFSC Code</th>
                                                    <td>${vendorInformation.ifscCode}</td>
                                                    <th style=";">Swift Code (if any) </th>
                                                    <td> ${vendorInformation.swiftCode}</td>
                                                    <th style=";">Cancel Cheque </th>
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
                                    </div>
                                                    
           <script>

                function toggleBankTable(){

                    var table = document.getElementById("BankTableBody");
                    var icon = document.getElementById("toggleBankIcon");

                    if(table.style.display === "none"){
                        table.style.display = "table-row-group";

                        icon.classList.remove("bi-caret-down-fill");
                        icon.classList.add("bi-caret-up-fill");

                    }else{
                        table.style.display = "none";

                        icon.classList.remove("bi-caret-up-fill");
                        icon.classList.add("bi-caret-down-fill");
                    }

                }

                    </script>                                       
                                                    
                                    <br>
                                    <div class="table-responsive">
                                     <table   class="bottom-table"  id="" class="table table-bordered table-striped " style="" align="Center"  >
<thead>
                            <tr class="table-title" style="cursor:pointer;">

                                <td colspan="2" style="font-weight:bold;background-color:skyblue;">FINANCIAL STATEMENT (PROFIT AND LOSS / BALANCE SHEET)</td>

                                <td colspan="2" style="font-weight:bold;background-color:skyblue; text-align:right;">ALL ATTACHMENTS
                                    <a href="vendorInformation.htm?act=financialStatementDetailsDocxdownloadzip&id1=${VInformationId}" style="margin-left:10px;">
                                        <i class="fa fa-download"></i>
                                    </a> &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
                                    
                                    <i class="bi bi-caret-down-fill" id="toggleFINANCIALIcon"
                                           onclick="toggleFINANCIALTable()"
                                           style="margin-left:10px; cursor:pointer;  float:right;"></i> 
                                    
                                    
                                    
                                   
                                </td>

                            </tr>
                        </thead>
                                            
                                            <tbody id="FINANCIALTableBody" style="display:none;">
                                                <tr style=";">
                                                    <th>Year</th>
                                                    <th>Financial Year</th>
                                                    <th>Financial Amount</th>
                                                    <th>Financial Attachment</th>
                                                </tr>
                                                <!-- 1st Year -->
                                                <tr>
                                                    <td>1st Year </td>
                                                    <td>${vendorInformation.finical1}</td>
                                                    <td>${vendorInformation.finicalAmount1}</td>
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
                                                    </td>
                                                </tr>
                                                <!-- 2nd Year -->
                                                <tr>
                                                    <td>2nd Year </td>
                                                    <td>${vendorInformation.finical2}</td>
                                                    <td>${vendorInformation.finicalAmount2}</td>
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
                                                    </td>
                                                </tr>
                                                <!-- 3rd Year -->
                                                <tr>
                                                    <td>3rd Year </td>
                                                    <td>${vendorInformation.finical3}</td>
                                                    <td>${vendorInformation.finicalAmount3}</td>
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
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                                    
                                                    <script>

                function toggleFINANCIALTable(){

                    var table = document.getElementById("FINANCIALTableBody");
                    var icon = document.getElementById("toggleFINANCIALIcon");

                    if(table.style.display === "none"){
                        table.style.display = "table-row-group";

                        icon.classList.remove("bi-caret-down-fill");
                        icon.classList.add("bi-caret-up-fill");

                    }else{
                        table.style.display = "none";

                        icon.classList.remove("bi-caret-up-fill");
                        icon.classList.add("bi-caret-down-fill");
                    }

                }

                    </script> 
                                    <br>

                                      <table   class="bottom-table"  id="" class="table table-bordered table-striped " style="" align="Center"  >

                                        <thead>
                                            <tr class="table-title" style="cursor:pointer;">
                                                <td colspan="7" style="font-weight: bold; background-color: skyblue;">SELF DECLARATION FORM
                                                <i class="bi bi-caret-down-fill" id="toggleSelfIcon"onclick="toggleSelfTable()"
                                           style="margin-left:10px; cursor:pointer;  float:right;"></i>
                                                
                                                </td>
                                            </tr>
                                            
                                        </thead>
                                        <tbody id="SelfTableBody" style="display:none;">
                                            <tr  style=";">
                                                <th></th>
                                                <th>Vendor Response</th>
                                                <th>Comments</th>
                                            </tr>
                                            <tr>
                                                <td style="width: 40%;">
                                                    <b>1. Is the organization publicly listed company with shares being traded on any Stock Exchange? </b><span style="color:red">*</span>
                                                </td>
                                                <td style="width: 20%;">

                                                    <c:if test="${declaration.desDecOneFlag == 1}">
                                                        Yes
                                                    </c:if>
                                                    <c:if test="${declaration.desDecOneFlag == 0}">
                                                        No
                                                    </c:if>

                                                </td>
                                        <style>
                                            .wrap-text {
                                                display: block;
                                                white-space: normal;
                                                word-break: break-word;
                                                overflow-wrap: anywhere;
                                            }
                                        </style>

                                        <td style="width: 40%;<c:if test="${declaration.desDecOneFlag == 1}">background: #e9ecef;</c:if>">
                                            <span class="wrap-text">${declaration.desDecOne}</span>
                                        </td>

                                        </tr>
                                        <tr>
                                            <td style="width: 40%;">
                                                <b>2. Has the Supplier ever conducted business under any alias...? </b><span style="color:red">*</span>
                                            </td>
                                            <td style="width: 20%;">
                                                <c:if test="${declaration.desDecTwoFlag == 1}">
                                                    Yes
                                                </c:if>
                                                <c:if test="${declaration.desDecTwoFlag == 0}">
                                                    No
                                                </c:if>


                                            </td>
                                            <td style="width: 40%; <c:if test="${declaration.desDecTwoFlag == 1}">background: #e9ecef;</c:if>">
                                                <span class="wrap-text">${declaration.desDecTwo}</span>   
                                            </td>
                                        </tr>
                                        <tr>
                                            <td style="width: 40%;">
                                                <b> 3. Litigation History</b><bR>
                                                Whether your organization is involved in any legal proceedings?<br>
                                                - For Proprietorship organization the Proprietor to declare if he / she is involved in any legal proceedings.<br>
                                                - For Partnership organization all or any Partners are involved in any legal proceedings

                                            </td>
                                            <td style="width: 20%;">
                                                <c:if test="${declaration.litigationHistoryDesFlag == 1}">
                                                    Yes
                                                </c:if>
                                                <c:if test="${declaration.litigationHistoryDesFlag == 0}">
                                                    No
                                                </c:if>

                                            </td>
                                            <td style="width: 40%; <c:if test="${declaration.litigationHistoryDesFlag == 1}">background: #e9ecef;</c:if>">
                                                <span class="wrap-text">${declaration.litigationHistoryDes}</span> 
                                            </td>
                                        </tr>
                                        <tr>
                                            <td style="width: 40%;">
                                                <b> 4. Political Contributions</b><bR>
                                                Whether the Third Party or any person directly or indirectly connected to the Third Party (Employees, Directors, and their personal relations) has made any contributions / donations (either of a charitable or political nature), in the past or at present, to a political party / organization affiliated with a political party or a political leader, on behalf of the Third Party / Supplier or in their personal capacity?

                                            </td>
                                            <td style="width: 20%;">
                                                <c:if test="${declaration.politicalContributionDesFlag == 1}">
                                                    Yes
                                                </c:if>
                                                <c:if test="${declaration.politicalContributionDesFlag == 0}">
                                                    No
                                                </c:if>

                                            </td>
                                            <td style="width: 40%; <c:if test="${declaration.politicalContributionDesFlag == 1}">background: #e9ecef;</c:if>">
                                                <span class="wrap-text">${declaration.politicalContributionDes}</span> 
                                            </td>
                                        </tr>
                                        <tr>
                                            <td style="width: 40%;">
                                                <b> 5. Conflict of Interest</b><bR>
                                                Whether the Third Party or any person directly or indirectly connected to the Third Party (Employees, Directors, and their personal relations) have any financial interests, personal or familial relationships, or affiliations with Tecso Charge Zone Limited or any of its Directors or employees?

                                            </td>
                                            <td style="width: 20%;">
                                                <c:if test="${declaration.conflictInsterestDesFlag == 1}">
                                                    Yes
                                                </c:if>
                                                <c:if test="${declaration.conflictInsterestDesFlag == 0}">
                                                    No
                                                </c:if>

                                            </td>
                                            <td style="width: 40%; <c:if test="${declaration.conflictInsterestDesFlag == 1}">background: #e9ecef;</c:if>">
                                                <span class="wrap-text">${declaration.conflictInsterestDes}</span> 
                                            </td>
                                        </tr>
                                        <tr>
                                            <td style="width: 40%;">
                                                <b> 6.  Use of Executive/Judicial (Public Official) Influence</b><bR>
                                                Whether the Third Party or any person directly or indirectly connected to the Third Party (Employees, Directors, and their personal relations) has sought or obtained the assistance of a Public Official in connection with providing goods / services to CZ?

                                            </td>
                                            <td style="width: 20%;">
                                                <c:if test="${declaration.executiveJudicialDesFlag == 1}">
                                                    Yes
                                                </c:if>
                                                <c:if test="${declaration.executiveJudicialDesFlag == 0}">
                                                    No
                                                </c:if>

                                            </td>
                                            <td style="width: 40%; <c:if test="${declaration.executiveJudicialDesFlag == 1}">background: #e9ecef;</c:if>">
                                                <span class="wrap-text">${declaration.executiveJudicialDes}</span> 
                                            </td>
                                        </tr>
                                        <tr>
                                            <td style="width: 40%;">
                                                <b>  7. Politically Exposed Personnel</b><bR>
                                                Whether the Third Party or any person directly or indirectly connected to the Third Party is or has been associated with any political party/ political leader / organization affiliated with a political party or a political leader?
                                                <br><i>[For illustrative purposes, ‘Y’ is an employee / proprietor of the Third Party entity and ‘K’, his maternal uncle is a local MLA in Raigad. Herein, ‘Y’ shall be considered as politically exposed for the purposes of disclosure to CZ]</i>

                                            </td>
                                            <td style="width: 20%;">
                                                <c:if test="${declaration.politicallyExposedDesOneFlag == 1}">
                                                    Yes
                                                </c:if>
                                                <c:if test="${declaration.politicallyExposedDesOneFlag == 0}">
                                                    No
                                                </c:if>

                                            </td>
                                            <td style="width: 40%; <c:if test="${declaration.politicallyExposedDesOneFlag == 1}">background: #e9ecef;</c:if>">
                                                <span class="wrap-text">${declaration.politicallyExposedDesOne}</span> 
                                            </td>
                                        </tr>
                                        <tr>
                                            <td style="width: 40%;">
                                                <b>  7.1</b><br>
                                                Whether the Third Party or any person directly or indirectly connected to the Third Party will seek / has sought or obtained the assistance of any political party / political leader / organization affiliated with a political party or a political leader in connection with providing goods / services to CZ?

                                            </td>
                                            <td style="width: 20%;">
                                                <c:if test="${declaration.politicallyExposedDesTwoFlag == 1}">
                                                    Yes
                                                </c:if>
                                                <c:if test="${declaration.politicallyExposedDesTwoFlag == 0}">
                                                    No
                                                </c:if>

                                            </td>
                                            <td style="width: 40%; <c:if test="${declaration.politicallyExposedDesTwoFlag == 1}">background: #e9ecef;</c:if>">
                                                <span class="wrap-text">${declaration.politicallyExposedDesTwo}</span> 
                                            </td>
                                        </tr>
                                        <tr>
                                            <td style="width: 40%;">
                                                <b>  7.2</b><br>
                                                Whether any assistance has been sought from a political party / political leader / an organization affiliated with a political party, or a political leader for resolution of any issues / concerns related to the functioning / management / regulatory compliance of the Third Party?

                                            </td>
                                            <td style="width: 20%;">
                                                <c:if test="${declaration.politicallyExposedDesThreeFlag == 1}">
                                                    Yes
                                                </c:if>
                                                <c:if test="${declaration.politicallyExposedDesThreeFlag == 0}">
                                                    No
                                                </c:if>

                                            </td>
                                            <td style="width: 40%; <c:if test="${declaration.politicallyExposedDesThreeFlag == 1}">background: #e9ecef;</c:if>">
                                                <span class="wrap-text">${declaration.politicallyExposedDesThree}</span> 
                                            </td>
                                        </tr>
                                        <tr>
                                            <td style="width: 40%;">
                                                <b> 8. Nature of Services</b><bR>
                                                Whether the Scope of Work to be carried out by the Third Party will involve providing any form of liaising or facilitation services with Government Departments?

                                            </td>
                                            <td style="width: 20%;">
                                                <c:if test="${declaration.natureServicesOneFlag == 1}">
                                                    Yes
                                                </c:if>
                                                <c:if test="${declaration.natureServicesOneFlag == 0}">
                                                    No
                                                </c:if>

                                            </td>
                                            <td style="width: 40%; <c:if test="${declaration.natureServicesOneFlag == 1}">background: #e9ecef;</c:if>">
                                                <span class="wrap-text">${declaration.natureServicesOne}</span> 
                                            </td>
                                        </tr>
                                        <tr>
                                            <td style="width: 40%;">
                                                <b>  8.1</b><br>
                                                Whether the Scope of Work to be carried out by the Third Party will involve interacting with Public Officials (Government officials/Judges/Public Sector Companies, etc.) on behalf of Chargezone?

                                            </td>
                                            <td style="width: 20%;">
                                                <c:if test="${declaration.natureServicesTwoFlag == 1}">
                                                    Yes
                                                </c:if>
                                                <c:if test="${declaration.natureServicesTwoFlag == 0}">
                                                    No
                                                </c:if>

                                            </td>
                                            <td style="width: 40%; <c:if test="${declaration.natureServicesTwoFlag == 1}">background: #e9ecef;</c:if>">
                                                <span class="wrap-text">${declaration.natureServicesTwo}</span> 
                                            </td>
                                        </tr>
                                        <tr>
                                            <td style="width: 40%;">
                                                <b> 9.  Acknowledgment of understanding and NDA</b><bR>
                                                Has the Procurement team explained to you the Supplier Registration process especially the Code of Conduct document? Please answer in Yes or No

                                            </td>
                                            <td style="width: 20%;">
                                                <c:if test="${declaration.ndaOneFlag == 1}">
                                                    Yes
                                                </c:if>
                                                <c:if test="${declaration.ndaOneFlag == 0}">
                                                    No
                                                </c:if>

                                            </td>
                                            <td style="width: 40%; <c:if test="${declaration.ndaOneFlag == 1}">background: #e9ecef;</c:if>">
                                                <span class="wrap-text">${declaration.ndaOne}</span> 
                                            </td>
                                        </tr>
                                        <tr>
                                            <td style="width: 40%;">
                                                <b>  9.1</b><br>
                                                Has the Procurement team explained to you about the applicability of Non-Disclosure Agreement to your case? If yes have they shared NDA with you. Please answer in Yes or No.

                                            </td>
                                            <td style="width: 20%;">
                                                <c:if test="${declaration.ndaTwoFlag == 1}">
                                                    Yes
                                                </c:if>
                                                <c:if test="${declaration.ndaTwoFlag == 0}">
                                                    No
                                                </c:if>

                                            </td>
                                            <td style="width: 40%; <c:if test="${declaration.ndaTwoFlag == 1}">background: #e9ecef;</c:if>">
                                                <span class="wrap-text">${declaration.ndaTwo}</span> 
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <br>
<script>

                function toggleSelfTable(){

                    var table = document.getElementById("SelfTableBody");
                    var icon = document.getElementById("toggleSelfIcon");

                    if(table.style.display === "none"){
                        table.style.display = "table-row-group";

                        icon.classList.remove("bi-caret-down-fill");
                        icon.classList.add("bi-caret-up-fill");

                    }else{
                        table.style.display = "none";

                        icon.classList.remove("bi-caret-up-fill");
                        icon.classList.add("bi-caret-down-fill");
                    }

                }

                    </script> 
                                    
                                    
                                    <c:if test="${!empty list4}">
                                        <div class="technical-section">
                                            <table   class="bottom-table"  id="" class="table table-bordered table-striped " style="" align="Center"  >
                                                <thead>
                                                    <tr class="table-title" style="cursor:pointer;">
                                                        <td colspan="4" style="font-weight:bold;background-color:skyblue;">TECHNICAL CRITERIA</td>
                                                        <td colspan="2" style="font-weight:bold;background-color:skyblue; text-align:right;">ALL ATTACHMENTS
                                                            <a href="vendorInformation.htm?act=technicalCriteriaDetailsDocxdownloadzip&id1=${VInformationId}" style="margin-left:10px;">
                                                                <i class="fa fa-download"></i>
                                                            </a> &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
                                                            <i class="bi bi-caret-down-fill" id="toggleTechnicalIcon"
                                                               onclick="toggleTechnicalTable()"
                                                               style="margin-left:10px; cursor:pointer;  float:right;"></i> 
                                                        </td>
                                                    </tr>
                                                </thead>
                                                <tbody id="TechnicalTableBody" style="display:none;">   

                                                    <tr style=";">
                                                        <th>Sr No.</th>
                                                        <th>Criteria</th>
                                                        <th>Selection Criteria</th>
                                                        <th>Vendor Acceptance</th>
                                                        <th>Comment</th>
                                                        <th>Attachment</th>
                                                    </tr>
                                                    <c:set var="total" value="0" />
                                                    <c:set var="size" value="${list4.size() * 2}" />
                                                    <c:forEach var="list4" items="${list4}" varStatus="status">
                                                        <c:set var="total" value="${list4.score + total}" />
                                                        <tr>
                                                            <td>${status.count}</td>
                                                            <td><pre class="terms-details">${list4.criteria}</pre></td>
                                                            <td><pre class="terms-details">${list4.selectionCriteria}</pre></td>
                                                            <td>
                                                                <c:if test="${list4.score == '0'}">
                                                                    No
                                                                </c:if>
                                                                <c:if test="${list4.score == '1'}">
                                                                    Yes
                                                                </c:if>
                                                            </td>
                                                            <td>${list4.comment}</td>
                                                            <td>
                                                                <c:if test="${list4.attachment!=null && not empty list4.attachment}">                                        
                                                                    <span class="file-wrapper">
                                                                        <span class="file-name text-break">${list4.attachment}</span>
                                                                        <span class="file-actions">
                                                                            <a class="fw-600 text-break gradient-text" href="vendorInformation.htm?act=downloadCriteriaFileAprrove&amp;fileName=${list4.attachment}&foldName=TECHNICAL&id=${vendorInformation.id}">&nbsp;<span class="fa fa-download"></span></a>
                                                                            <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/TECHNICAL/${list4.attachment}"><span class="fa fa-solid fa-eye"></span></a>					
                                                                        </span>
                                                                    </span>
                                                                </c:if>                                                                
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                    <tr>
                                                        <td colspan="3"><strong>Total</strong></td>
                                                        <td>${total}</td>
                                                        <td colspan="2"></td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="3"><strong>Total Percentage</strong></td>
                                                        <td>${String.format('%.2f', (total * 100) / size)*2}%</td>
                                                        <td colspan="2"></td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                        <br>
                           <script>

                function toggleTechnicalTable(){

                    var table = document.getElementById("TechnicalTableBody");
                    var icon = document.getElementById("toggleTechnicalIcon");

                    if(table.style.display === "none"){
                        table.style.display = "table-row-group";

                        icon.classList.remove("bi-caret-down-fill");
                        icon.classList.add("bi-caret-up-fill");

                    }else{
                        table.style.display = "none";

                        icon.classList.remove("bi-caret-up-fill");
                        icon.classList.add("bi-caret-down-fill");
                    }

                }

                    </script>              
                                        
                                    </c:if>



                                    <c:if test="${!empty list5}">
                                        <div class="hr-section">

                                            <table   class="bottom-table"  id="" class="table table-bordered table-striped " style="" align="Center"  >
                                                <thead>
                                                    <tr class="table-title" style="cursor:pointer;">
                                                        <td colspan="5" style="font-weight:bold;background-color:skyblue;">HR CRITERIA</td>
                                                        <td colspan="1" style="font-weight:bold;background-color:skyblue; text-align:right;">ALL ATTACHMENTS
                                                            <a href="vendorInformation.htm?act=hrCriteriaDetailsDocxdownloadzip&id1=${VInformationId}" style="margin-left:10px;">
                                                                <i class="fa fa-download"></i>
                                                            </a> &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
                                                            <i class="bi bi-caret-down-fill" id="toggleHRIcon"
                                                               onclick="toggleHRTable()"
                                                               style="margin-left:10px; cursor:pointer;  float:right;"></i> 
                                                        </td>
                                                    </tr>
                                                </thead>
                                                <tbody id="HRTableBody" style="display:none;">        

                                                    <tr style=";">
                                                        <th>Sr No.</th>
                                                        <th>Criteria</th>
                                                        <th>Selection Criteria</th>
                                                        <th>Vendor Acceptance</th>
                                                        <th>Comment</th>
                                                        <th>Attachment</th>
                                                    </tr>                  

                                                    <c:set var="total1" value="0" />
                                                    <c:set var="size1" value="${list5.size() * 2}" />
                                                    <c:forEach var="list5" items="${list5}" varStatus="status">
                                                        <c:set var="total1" value="${list5.score + total1}" />
                                                        <tr>
                                                            <td>${status.count}</td>
                                                            <td><pre class="terms-details">${list5.criteriaName}</pre></td>
                                                            <td><pre class="terms-details">${list5.criteriaDescription}</pre></td>
                                                            <td>

                                                                <c:if test="${list5.score == '0'}">
                                                                    No
                                                                </c:if>
                                                                <c:if test="${list5.score == '1'}">
                                                                    Yes
                                                                </c:if>

                                                            </td>
                                                            <td>${list5.comment}</td>
                                                            <td>
                                                                <c:if test="${list5.attachement!=null && not empty list5.attachement}">                                        
                                                                    <span class="file-wrapper">
                                                                        <span class="file-name text-break">${list5.attachement}</span>
                                                                        <span class="file-actions">
                                                                            <a class="fw-600 text-break gradient-text" href="vendorInformation.htm?act=downloadCriteriaFileAprrove&amp;fileName=${list5.attachement}&foldName=HR&id=${vendorInformation.id}">&nbsp;<span class="fa fa-download"></span></a>
                                                                            <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/HR/${list5.attachement}"><span class="fa fa-solid fa-eye"></span></a>					
                                                                        </span>
                                                                    </span>
                                                                </c:if>                                                                
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                    <tr>
                                                        <td colspan="3"><strong>Total</strong></td>
                                                        <td>${total1}</td>
                                                        <td colspan="2"></td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="3"><strong>Total Percentage</strong></td>
                                                        <td>${String.format('%.2f', (total1 * 100) / size1)*2}%</td>
                                                        <td colspan="2"></td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                        <br>
                                        <script>

                function toggleHRTable(){

                    var table = document.getElementById("HRTableBody");
                    var icon = document.getElementById("toggleHRIcon");

                    if(table.style.display === "none"){
                        table.style.display = "table-row-group";

                        icon.classList.remove("bi-caret-down-fill");
                        icon.classList.add("bi-caret-up-fill");

                    }else{
                        table.style.display = "none";

                        icon.classList.remove("bi-caret-up-fill");
                        icon.classList.add("bi-caret-down-fill");
                    }

                }

                    </script>
                                    </c:if>                                

                                    <c:if test="${!empty list101}">
                                        <div class="it-section">                                          

                                            <table   class="bottom-table"  id="" class="table table-bordered table-striped " style="" align="Center"  >
                                                <thead>
                                                    <tr class="table-title" style="cursor:pointer;">
                                                        <td colspan="5" style="font-weight:bold;background-color:skyblue;">IT CRITERIA</td>
                                                        <td colspan="1" style="font-weight:bold;background-color:skyblue; text-align:right;">ALL ATTACHMENTS
                                                            <a href="vendorInformation.htm?act=itCriteriaDetailsDocxdownloadzip&id1=${VInformationId}" style="margin-left:10px;">
                                                                <i class="fa fa-download"></i>
                                                            </a> &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
                                                            <i class="bi bi-caret-down-fill" id="toggleITIcon"
                                                               onclick="toggleITTable()"
                                                               style="margin-left:10px; cursor:pointer;  float:right;"></i> 
                                                        </td>
                                                    </tr>
                                                </thead>
                                                <tbody id="ITTableBody" style="display:none;">             

                                                    <tr style=";">
                                                        <th>Sr No.</th>
                                                        <th>Criteria</th>
                                                        <th>Selection Criteria</th>
                                                        <th>Vendor Acceptance</th>
                                                        <th>Comment</th>
                                                        <th>Attachment</th>
                                                    </tr>
                                                    <c:set var="total1" value="0" />
                                                    <c:set var="size9" value="${list101.size() * 2}" />
                                                    <c:forEach var="list9" items="${list101}" varStatus="status">
                                                        <c:set var="total1" value="${list9.score + total1}" />
                                                        <tr>
                                                            <td>${status.count}</td>
                                                            <td><pre class="terms-details">${list9.criteriaName}</pre></td>
                                                            <td><pre class="terms-details">${list9.criteriaDescription}</pre></td>
                                                            <td> <c:if test="${list9.score == '0'}">
                                                                    No
                                                                </c:if>
                                                                <c:if test="${list9.score == '1'}">
                                                                    Yes
                                                                </c:if></td>
                                                            <td>${list9.comment}</td>
                                                            <td>
                                                                <c:if test="${list9.attachement!=null && not empty list9.attachement}">                                        
                                                                    <span class="file-wrapper">
                                                                        <span class="file-name text-break">${list9.attachement}</span>
                                                                        <span class="file-actions">
                                                                            <a class="fw-600 text-break gradient-text" href="vendorInformation.htm?act=downloadCriteriaFileAprrove&amp;fileName=${list9.attachement}&foldName=IT&id=${vendorInformation.id}">&nbsp;<span class="fa fa-download"></span></a>
                                                                            <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/IT/${list9.attachement}"><span class="fa fa-solid fa-eye"></span></a>					
                                                                        </span>
                                                                    </span>
                                                                </c:if>                                                                
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                    <tr>
                                                        <td colspan="3"><strong>Total</strong></td>
                                                        <td>${total1}</td>
                                                        <td colspan="2"></td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="3"><strong>Total Percentage</strong></td>
                                                        <td>${String.format('%.2f', (total1 * 100) / size9) *2}%</td>
                                                        <td colspan="2"></td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                        <br>
                                        <script>

                function toggleITTable(){

                    var table = document.getElementById("ITTableBody");
                    var icon = document.getElementById("toggleITIcon");

                    if(table.style.display === "none"){
                        table.style.display = "table-row-group";

                        icon.classList.remove("bi-caret-down-fill");
                        icon.classList.add("bi-caret-up-fill");

                    }else{
                        table.style.display = "none";

                        icon.classList.remove("bi-caret-up-fill");
                        icon.classList.add("bi-caret-down-fill");
                    }

                }

                    </script>
                                    </c:if>

                                    <c:if test="${!empty list6}">
                                        <div class="safety-section">


                                            <table   class="bottom-table"  id="" class="table table-bordered table-striped " style="" align="Center"  >
                                                <thead>
                                                    <tr class="table-title" style="cursor:pointer;">
                                                        <td colspan="5" style="font-weight:bold;background-color:skyblue;">SAFETY CRITERIA</td>
                                                        <td colspan="1" style="font-weight:bold;background-color:skyblue; text-align:right;">ALL ATTACHMENTS
                                                            <a href="vendorInformation.htm?act=safetyCriteriaDetailsDocxdownloadzip&id1=${VInformationId}" style="margin-left:10px;">
                                                                <i class="fa fa-download"></i>
                                                            </a> &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
                                                            <i class="bi bi-caret-down-fill" id="toggleSafetyIcon"
                                                               onclick="toggleSafetyTable()"
                                                               style="margin-left:10px; cursor:pointer;  float:right;"></i> 
                                                        </td>
                                                    </tr>
                                                </thead>
                                                <tbody id="SafetyTableBody" style="display:none;">              

                                                    <tr style=";">
                                                        <th>Sr No.</th>
                                                        <th>Criteria</th>
                                                        <th>Selection Criteria</th>
                                                        <th>Vendor Acceptance</th>
                                                        <th>Comment</th>
                                                        <th>Attachment</th>
                                                    </tr>        


                                                    <c:set var="total2" value="0" />
                                                    <c:set var="size2" value="${list6.size() * 2}" />
                                                    <c:forEach var="list6" items="${list6}" varStatus="status">
                                                        <c:set var="total2" value="${list6.score + total2}" />
                                                        <tr>
                                                            <td>${status.count}</td>
                                                            <td><pre class="terms-details">${list6.criteriaName}</pre></td>
                                                            <td><pre class="terms-details">${list6.criteriaDescription}</pre></td>
                                                            <td> <c:if test="${list6.score == '0'}">
                                                                    No
                                                                </c:if>
                                                                <c:if test="${list6.score == '1'}">
                                                                    Yes
                                                                </c:if></td>
                                                            <td>${list6.comment}</td>
                                                            <td>
                                                                <c:if test="${list6.attachement!=null && not empty list6.attachement}">                                        
                                                                    <span class="file-wrapper">
                                                                        <span class="file-name text-break">${list6.attachement}</span>
                                                                        <span class="file-actions">
                                                                            <a class="fw-600 text-break gradient-text" href="vendorInformation.htm?act=downloadCriteriaFileAprrove&amp;fileName=${list6.attachement}&foldName=HSE&id=${vendorInformation.id}">&nbsp;<span class="fa fa-download"></span></a>
                                                                            <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/HSE/${list6.attachement}"><span class="fa fa-solid fa-eye"></span></a>					
                                                                        </span>
                                                                    </span>
                                                                </c:if>                                                                
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                    <tr>
                                                        <td colspan="3"><strong>Total</strong></td>
                                                        <td>${total2}</td>
                                                        <td colspan="2"></td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="3"><strong>Total Percentage</strong></td>
                                                        <td>${String.format('%.2f', (total2 * 100) / size2) * 2}%</td>
                                                        <td colspan="2"></td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                        <br>
                                         <script>

                function toggleSafetyTable(){

                    var table = document.getElementById("SafetyTableBody");
                    var icon = document.getElementById("toggleSafetyIcon");

                    if(table.style.display === "none"){
                        table.style.display = "table-row-group";

                        icon.classList.remove("bi-caret-down-fill");
                        icon.classList.add("bi-caret-up-fill");

                    }else{
                        table.style.display = "none";

                        icon.classList.remove("bi-caret-up-fill");
                        icon.classList.add("bi-caret-down-fill");
                    }

                }

                    </script>
                                    </c:if> 

                                  
                                            
                                        <table   class="bottom-table"  id="" class="table table-bordered table-striped " style="" align="Center"  >
                                            <thead>
                                                <tr class="table-title" style="cursor:pointer;">
                                                    <td colspan="7" style="font-weight: bold; background-color: skyblue;">EXTERNAL VENDOR EMAIL
                                                    <i class="bi bi-caret-down-fill" id="toggleExternalIcon"
                                           onclick="toggleExternalTable()"
                                           style="margin-left:10px; cursor:pointer;  float:right;"></i>
                                                    </td>
                                                </tr>
                                                
                                            </thead>
                                            <tbody id="ExternalTableBody" style="display:none;">    
                                            
                                            <tr style=";">
                                                <th>Vendor Email-1</th>
                                                <th>Vendor Email-2</th>
                                                <th>Vendor Email-3</th>
                                            </tr>
                                            
                                            <tr>
                                                <td>${vendorInformation.email1}</td>
                                                <td>${vendorInformation.email2}</td>
                                                <td>${vendorInformation.email3}</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                            
                               <script>

                function toggleExternalTable(){

                    var table = document.getElementById("ExternalTableBody");
                    var icon = document.getElementById("toggleExternalIcon");

                    if(table.style.display === "none"){
                        table.style.display = "table-row-group";

                        icon.classList.remove("bi-caret-down-fill");
                        icon.classList.add("bi-caret-up-fill");

                    }else{
                        table.style.display = "none";

                        icon.classList.remove("bi-caret-up-fill");
                        icon.classList.add("bi-caret-down-fill");
                    }

                }

                    </script>             
                                            
                                            
                                            
                                    <br>
                                    <div class="d-flex justify-content-center align-items-center" style="">
                                        <button type="submit" class="btn theme-btn">
                                            Submit
                                        </button>
                                    </div>

                </form:form>
            </section>
        </main>        
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
