<%-- 
    Document   : approveoneviewClickview
    Created on : 14 Oct, 2025, 09:52:57 AM
    Author     : fnp
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

    <head>
        <title>Vendor Details</title>

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
                td {
    max-width: 200px;          /* jarur pramane */
    word-break: break-all;     /* long word ne todse */
    white-space: normal;       /* wrap allow kare */
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
                        <h5 class="fw-600 mb-0">Vendor Details</h5>
                    </div>
                    <div class="cta d-flex align-items-center">
                        <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>
                            <a href="vendorInformation.htm?act=approveoneviewClickviewPrint&id=${checkId}" 
                               class="btn theme-btn">
                                Print
                            </a>                     
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
                    <input type="hidden" id="id" name="id" value="${list.id}">
                    <input type="hidden" id="id1" name="id1" value="${list.id}">

                                 <div class="table-responsive">
                                    <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
                                                          <thead>
                                                            <tr class="table-title">
                                                                <td colspan="3" style="font-weight: bold; background-color: skyblue; text-align: center;">VENDOR DETAILS</td>
                                                                <td style="font-weight: bold; background-color: skyblue;">
                                                                    All Attachments <a href="vendorInformation.htm?act=vendorDetailsDocxdownloadzip&id1=${list.id}" style="text-decoration: none; color: black; font-size: 16px;">
                                                                        &nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                                                    </a>
                                                                </td>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <th>Company Name</th>
                                                                <td>${list.companyName}</td>
                                                                <th>Email Id </th>
                                                                <td>${list.vendorEmailId}</td>
                                                            </tr>
                                                            <tr>
                                                                <th style="">   <c:if test="${list.policyAccept=='1'}">Code of Conduct (Sign & Stamp in all Pages)</c:if>
                                                                    <c:if test="${list.policyAccept=='0'}">Deviation Policy</c:if></th>
                                                                <td><c:if test="${list.policyAccept=='1'}">Accept</c:if>
                                                                    <c:if test="${list.policyAccept=='0'}"><span style="color: red;">Not Accept</span></c:if><br>
                                                                    <c:if test="${list.policy1File!='' &&  list.policy1File!=null}">
                                                                        <c:if test="${list.policy1File!=null && not empty list.policy1File}">                                        
                                                                            <span class="file-wrapper">
                                                                                <span class="file-name text-break">${list.policy1File}</span>
                                                                                <span class="file-actions">
                                                                                    <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.policy1File}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.policy1File}"><span class="fa fa-solid fa-eye"></span></a>
                                                                                </span>
                                                                            </span>
                                                                        </c:if>
                                                                        <label>
                                                                            <c:if test="${vendorBuyerApproval.cocStatuss == 'accept'}">
                                                                                <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                                            </c:if>
                                                                            <c:if test="${vendorBuyerApproval.cocStatuss == 'reject'}">
                                                                                <span style="color:red; font-weight:bold;">&#10008; Rejected</span><br>
                                                                            </c:if>
                                                                        </label><br>
                                                                        <c:if test="${vendorBuyerApproval.cocStatuss == 'reject'}">
                                                                            <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.cocRemarkk}</textarea>
                                                                            <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.cocResponse}</textarea>
                                                                        </c:if>
                                                                    </c:if>
                                                                </td>
                                                                <th style="">    <c:if test="${list.ndaPolicyAccept=='1'}">NDA (Sign & Stamp in all Pages)</c:if>
                                                                    <c:if test="${list.ndaPolicyAccept=='0'}">NDA Policy</c:if></th> 
                                                                <td><c:if test="${list.ndaPolicyAccept=='1'}">Accept</c:if>
                                                                    <c:if test="${list.ndaPolicyAccept=='0'}"><span style="color: red;">Not Accept</span></c:if><br>
                                                                    <c:if test="${list.ndaPolicyFile!='' &&  list.ndaPolicyFile!=null}">
                                                                        <c:if test="${list.ndaPolicyFile!=null && not empty list.ndaPolicyFile}">                                        
                                                                            <span class="file-wrapper">
                                                                                <span class="file-name text-break">${list.ndaPolicyFile}</span>
                                                                                <span class="file-actions">
                                                                                    <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.ndaPolicyFile}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.ndaPolicyFile}"><span class="fa fa-solid fa-eye"></span></a>
                                                                                </span>
                                                                            </span>
                                                                        </c:if>
                                                                        <label>
                                                                            <c:if test="${vendorBuyerApproval.ndaStatuss == 'accept'}">
                                                                                <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                                            </c:if>
                                                                            <c:if test="${vendorBuyerApproval.ndaStatuss == 'reject'}">
                                                                                <span style="color:red; font-weight:bold;">&#10008; Rejected</span><br>
                                                                            </c:if>
                                                                        </label><br>
                                                                        <c:if test="${vendorBuyerApproval.ndaStatuss == 'reject'}">
                                                                            <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.ndaRemarkk}</textarea>
                                                                            <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.ndaResponse}</textarea>
                                                                        </c:if>
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
                                                                        <label>
                                                                            <c:if test="${vendorBuyerApproval.tocStatuss == 'accept'}">
                                                                                <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                                            </c:if>
                                                                            <c:if test="${vendorBuyerApproval.tocStatuss == 'reject'}">
                                                                                <span style="color:red; font-weight:bold;">&#10008; Rejected</span><br>
                                                                            </c:if>
                                                                        </label><br>
                                                                        <c:if test="${list.companyProof!=null && not empty list.companyProof}">                                        
                                                                            <span class="file-wrapper">
                                                                                <span class="file-name text-break">${list.companyProof}</span>
                                                                                <span class="file-actions">
                                                                                    <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.companyProof}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.companyProof}"><span class="fa fa-solid fa-eye"></span></a>
                                                                                </span>
                                                                            </span>
                                                                        </c:if>
                                                                        <c:if test="${vendorBuyerApproval.tocStatuss == 'reject'}">
                                                                            <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.tocRemarkk}</textarea>
                                                                            <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.tocResponse}</textarea>                                                                        
                                                                        </c:if>
                                                                        <c:if test="${!empty list.companyProof2}">
                                                                            <br>
                                                                            <label>
                                                                                <c:if test="${vendorBuyerApproval.tocStatuss1 == 'accept'}">
                                                                                    <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                                                </c:if>
                                                                                <c:if test="${vendorBuyerApproval.tocStatuss1 == 'reject'}">
                                                                                    <span style="color:red; font-weight:bold;">&#10008; Rejected</span><br>
                                                                                </c:if>    
                                                                            </label><br>
                                                                            <c:if test="${list.companyProof2!=null && not empty list.companyProof2}">
                                                                                <span class="file-wrapper">
                                                                                    <span class="file-name text-break">${list.companyProof2}</span>
                                                                                    <span class="file-actions">
                                                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.companyProof2}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.companyProof2}"><span class="fa fa-solid fa-eye"></span></a>
                                                                                    </span>
                                                                                </span>
                                                                            </c:if>
                                                                            <c:if test="${vendorBuyerApproval.tocStatuss1 == 'reject'}">
                                                                                <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.tocRemarkk1}</textarea>
                                                                                <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.tocResponse1}</textarea>
                                                                            </c:if>
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
</div>
                                                    <br>
                                                    <div class="table-responsive">
                                                        <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
                                                            <thead>
                                                                <td colspan="4" style="font-weight: bold; background-color: skyblue; text-align: center; ">REGISTER ADDRESS </td>
                                                            </thead>
                                                            <tbody>
                                                                <tr>
                                                                    <th style="width:25%; ">Street / House No.</th>
                                                                    <td style="width:25%;"><span class="wrap-text">${list.officeAddressLine1}</span></td>
                                                                    <th style="width:25%; ">Street-1</th>
                                                                    <td style="width:25%;"><span class="wrap-text">${list.officeAddressLine2}</span></td>
                                                                </tr>

                                                                <tr>
                                                                    <th style="">Street-2</th>
                                                                    <td><span class="wrap-text">${list.officeAddressLine3}</span></td>
                                                                    <th style="">Country</th>
                                                                    <td>${list.officeCountry}</td>
                                                                </tr>

                                                                <tr>
                                                                    <th style="">State</th>
                                                                    <td>${list.officeState}</td>
                                                                    <th style="">District</th>
                                                                    <td>${list.officeDistrict}</td>
                                                                </tr>

                                                                <tr>
                                                                    <th style="">City</th>
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

                                                                    
                                                <div class="table-responsive">
                                                    <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
                                                           

                                                        <thead>
                                                            <tr class="table-title">
                                                                <th colspan="4" style="font-weight:bold; text-align: center; background-color:skyblue;">
                                                                    COMMUNICATION ADDRESS
                                                                </th>
                                                            </tr>
                                                        </thead>

                                                        <tbody>
                                                            <tr>
                                                                <th style="width:25%;">Street / House No.</th>
                                                                <td style="width:25%;"><span class="wrap-text">${declaration.altLocalAddress}</span></td>
                                                                <th style="width:25%;">Street-1</th>
                                                                <td style="width:25%;"><span class="wrap-text">${declaration.altLocalAddress1}</span></td>
                                                            </tr>

                                                            <tr>
                                                                <th>Street-2</th>
                                                                <td><span class="wrap-text">${declaration.altLocalAddress2}</span></td>
                                                                <th>Country</th>
                                                                <td>${declaration.altCountry}</td>
                                                            </tr>

                                                            <tr>
                                                                <th>State</th>
                                                                <td>${declaration.altState}</td>
                                                                <th>City</th>
                                                                <td>${declaration.altCity}</td>
                                                            </tr>

                                                            <tr>
                                                                <th>District</th>
                                                                <td>${declaration.altDistrict}</td>
                                                                <th>Postal Code</th>
                                                                <td>${declaration.altPostalCode}</td>
                                                            </tr>

                                                            <tr>
                                                                <th>Mobile No</th>
                                                                <td>+${list.countryCodeNewMobiles}-${declaration.altTelephone}</td>
                                                                <th>Email</th>
                                                                <td>${declaration.altEmail}</td>
                                                            </tr>

                                                            <tr>
                                                                <th>Website</th>
                                                                <td>${declaration.altWebsite}</td>
                                                                <th></th>
                                                                <td></td>
                                                            </tr>
                                                        </tbody>

                                                    </table>
                                                </div>


                                                                        <table class="table table-bordered custom-table mb-3"
                                                                               style="width:100%; table-layout:fixed; border-collapse:collapse;">

                                                                            <thead>
                                                                                <tr class="table-title">
                                                                                    <th colspan="3" style="font-weight:bold; background-color:skyblue; text-align: center;">
                                                                                        TYPES OF VENDORS
                                                                                    </th>
                                                                                </tr>
                                                                            </thead>

                                                                            <tbody>
                                                                                <c:forEach var="list222" items="${list222}" varStatus="status">
                                                                                    <tr>
                                                                                        <td>
                                                                                            <input type="hidden"
                                                                                                   class="textarea-field"
                                                                                                   name="groupId"
                                                                                                   value="${list222[2]}" />
                                                                                            ${list222[2]}
                                                                                        </td>
                                                                                        <td>${list222[3]}</td>
                                                                                        <td>${list222[4]}</td>
                                                                                    </tr>
                                                                                </c:forEach>
                                                                            </tbody>

                                                                        </table>
                                                                   


                                                    <div class="table-responsive">
                                                        <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
                                                            <thead>
                                                                <tr class="table-title">
                                                                    <th colspan="5" style="font-weight:bold; background-color:skyblue; text-align: center;">
                                                                        VENDOR CONTACTS
                                                                    </th>
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
                                                                    <td>Sales / Commercial Contact(s)</td>
                                                                    <td>${list.sales_name}</td>
                                                                    <td>${list.sales_job}</td>
                                                                    <td>+${list.countryCodeVendorContact}-${list.sales_phone}</td>
                                                                    <td>${list.saleEmail}</td>
                                                                </tr>

                                                                <tr>
                                                                    <td>Technical Contact(s)</td>
                                                                    <td>${list.technical_name}</td>
                                                                    <td>${list.technical_job}</td>
                                                                    <td>+${list.countryCodeVendorContact1}-${list.technical_phone}</td>
                                                                    <td>${list.technicalContactEmail}</td>
                                                                </tr>

                                                                <tr>
                                                                    <td>Finance and Accounts</td>
                                                                    <td>${list.quality_name}</td>
                                                                    <td>${list.quality_job}</td>
                                                                    <td>+${list.countryCodeVendorContact2}-${list.quality_phone}</td>
                                                                    <td>${list.qualityEmail}</td>
                                                                </tr>
                                                            </tbody>

                                                        </table>
                                                    </div>
                                                                
                                                                <div class="table-responsive">
                                                                    <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
                                                                        <thead>
                                                                            <tr class="table-title">
                                                                                <th colspan="5" style="font-weight:bold; background-color:skyblue; text-align: center;">
                                                                                    MANAGERIAL PERSON DETAILS
                                                                                </th>
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
                                                                            <c:forEach items="${mplist}" var="mp" varStatus="status">
                                                                                <tr>
                                                                                    <td>${status.count}</td>
                                                                                    <td>${mp.name}</td>
                                                                                    <td>${mp.designation}</td>
                                                                                    <td>+${mp.countryCode}-${mp.phoneNo}</td>
                                                                                    <td >${mp.emailId}</td>
                                                                                </tr>
                                                                            </c:forEach>
                                                                        </tbody>
                                                                    </table>
                                                                </div>
              <div class="table-responsive">
    <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
        <thead>
            <!-- Title Row -->
            <tr class="table-title">
                <th colspan="6" style="font-weight:bold; background-color:skyblue;  text-align: center;">
                    PAST WORKING EXPERIENCE DETAILS
                </th>
                <th style="font-weight:bold; background-color:skyblue; text-align:center;">
                    All Attachments
                    <a href="vendorInformation.htm?act=pastWorkingExpDetailsDocxdownloadzip&id1=${list.id}"
                       style="text-decoration:none; color:black; font-size:16px;">
                        &nbsp;<i class="fa fa-download"></i>
                    </a>
                </th>
            </tr>

            <!-- Column Headers -->
            <tr style="">
                <th>Company Name</th>
                <th>Contact Person Name</th>
                <th>Phone No.</th>
                <th>Email</th>
                <th>Designation</th>
                <th>Attachment</th>
                <th>Response</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="lstwork" items="${lstwork}">
                <tr>
                    <td>${lstwork.companyName}</td>
                    <td>${lstwork.contactPersonName}</td>
                    <td>+${lstwork.countryCode}-${lstwork.mobileNumber}</td>
                    <td>${lstwork.email}</td>
                    <td>${lstwork.designation}</td>
                    <td  >
                        <c:if test="${not empty lstwork.attchment}">
                            <c:if test="${lstwork.statuss == 'accept'}">
                                <span style="color:green; font-weight:bold;">&#10004; Accepted</span><br>
                            </c:if>
                            <c:if test="${lstwork.statuss == 'reject'}">
                                <span style="color:red; font-weight:bold;">&#10008; Rejected</span><br>
                            </c:if>
                                <c:if test="${lstwork.attchment!=null && not empty lstwork.attchment}">                                        
                                    <span class="file-wrapper">
                                        <span class="file-name text-break">${lstwork.attchment}</span>
                                        <span class="file-actions">
                                            <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadLastWorkingFileAprrove&fileName=${lstwork.attchment}&id=${lstwork.vendorInformationId}"><span class="fa fa-download"></span></a>
                                            <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${lstwork.vendorInformationId}/LAST/${lstwork.attchment}"><span class="fa fa-solid fa-eye"></span></a>
                                        </span>
                                    </span>
                                </c:if>
                            <c:if test="${lstwork.statuss == 'reject'}">
                                <textarea class="textarea-field" readonly rows="3" cols="50">${lstwork.remarkk}</textarea>
                            </c:if>
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${lstwork.statuss == 'reject'}">
                            ${lstwork.response}
                        </c:if>                        
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

                                    <table class="table table-bordered custom-table mb-3" id="" style="width:100%;">
                                                        <thead>
                                                            <tr class="table-title">
                                                                <td colspan="7" style="font-weight: bold; background-color: skyblue;text-align: center;">SELF DECLARATION FORM</td>
                                                            </tr>
                                                            <tr  style="">
                                                                <th></th>
                                                                <th>Vendor Response</th>
                                                                <th>Comments</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
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


                                                          <div class="table-responsive">
                                                              <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
                                                            <thead>
                                                                <tr class="table-title">
                                                                    <td colspan="3" style="font-weight: bold; background-color: skyblue; text-align: center;">COMPANY REGISTRATION DETAILS </td>
                                                                    <td style="font-weight: bold; background-color: skyblue;">
                                                                        All Attachments <a href="vendorInformation.htm?act=companyRegDetailsDocxdownloadzip&id1=${list.id}" style="text-decoration: none; color: black; font-size: 16px;">
                                                                            &nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                                                        </a>
                                                                    </td>
                                                                </tr>                                                                
                                                            </thead>
                                                            <tbody>
                                                                <tr>
                                                                    <th style="width: 20%;">GST No.</th>
                                                                    <td>
                                                                        <label>
                                                                            <c:if test="${vendorBuyerApproval.gstStatuss == 'accept'}">
                                                                                <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                                            </c:if>
                                                                            <c:if test="${vendorBuyerApproval.gstStatuss == 'reject'}">
                                                                                <span style="color:red; font-weight:bold;">&#10008; Rejected</span><br>
                                                                            </c:if>
                                                                        </label><br>
                                                                        ${list.gstinNo}<br>
                                                                        <c:if test="${list.gstinFile!='' &&  list.gstinFile!=null}">
                                                                            <c:if test="${list.gstinFile!=null && not empty list.gstinFile}">                                        
                                                                                <span class="file-wrapper">
                                                                                    <span class="file-name text-break">${list.gstinFile}</span>
                                                                                    <span class="file-actions">
                                                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.gstinFile}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.gstinFile}"><span class="fa fa-solid fa-eye"></span></a>
                                                                                    </span>
                                                                                </span>
                                                                            </c:if>
                                                                            <c:if test="${vendorBuyerApproval.gstStatuss == 'reject'}">
                                                                                <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.gstRemarkk}</textarea>
                                                                                <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.gstResponse}</textarea>
                                                                            </c:if>
                                                                        </c:if>

                                                                    </td>                                                    
                                                                    <th style="width: 20%;">PAN No</th>
                                                                    <td>
                                                                        <label>
                                                                            <c:if test="${vendorBuyerApproval.panStatuss == 'accept'}">
                                                                                <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                                            </c:if>
                                                                            <c:if test="${vendorBuyerApproval.panStatuss == 'reject'}">
                                                                                <span style="color:red; font-weight:bold;">&#10008; Rejected</span><br>
                                                                            </c:if>
                                                                        </label><br>
                                                                        ${list.panNo}<br>
                                                                        <c:if test="${list.panFile!='' &&  list.panFile!=null}">
                                                                            <c:if test="${list.panFile!=null && not empty list.panFile}">                                        
                                                                                <span class="file-wrapper">
                                                                                    <span class="file-name text-break">${list.panFile}</span>
                                                                                    <span class="file-actions">
                                                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.panFile}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.panFile}"><span class="fa fa-solid fa-eye"></span></a>
                                                                                    </span>
                                                                                </span>
                                                                            </c:if>
                                                                            <c:if test="${vendorBuyerApproval.panStatuss == 'reject'}">
                                                                                <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.panRemarkk}</textarea>
                                                                                <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.panResponse}</textarea>
                                                                            </c:if>
                                                                        </c:if>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <th style="width: 20%;">MSME No</th>
                                                                    <td>
                                                                        <c:if test="${list.msmeStatus=='0'}"><strong>MSME Not Available</strong><br></c:if>
                                                                        <label>
                                                                            <c:if test="${vendorBuyerApproval.msmeStatuss == 'accept'}">
                                                                                <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                                            </c:if>
                                                                            <c:if test="${vendorBuyerApproval.msmeStatuss == 'reject'}">
                                                                                <span style="color:red; font-weight:bold;">&#10008; Rejected</span><br>
                                                                            </c:if>
                                                                        </label><br>
                                                                        ${list.service_tax}<br>
                                                                        <c:if test="${list.service_file!='' &&  list.service_file!=null}">
                                                                            <c:if test="${list.service_file!=null && not empty list.service_file}">                                        
                                                                                <span class="file-wrapper">
                                                                                    <span class="file-name text-break">${list.service_file}</span>
                                                                                    <span class="file-actions">
                                                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.service_file}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.service_file}"><span class="fa fa-solid fa-eye"></span></a>
                                                                                    </span>
                                                                                </span>
                                                                            </c:if>
                                                                            <c:if test="${vendorBuyerApproval.msmeStatuss == 'reject'}">
                                                                                <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.msmeRemarkk}</textarea>
                                                                                <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.msmeResponse}</textarea>
                                                                            </c:if>
                                                                        </c:if>
                                                                    </td>
                                                                    <th style="width: 20%;">ESIC No</th>
                                                                    <td>
                                                                        <c:if test="${list.esicStatus=='0'}"><strong>ESIC Not Available</strong><br></c:if>
                                                                        <label>
                                                                            <c:if test="${vendorBuyerApproval.esicStatuss == 'accept'}">
                                                                                <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                                            </c:if>
                                                                            <c:if test="${vendorBuyerApproval.esicStatuss == 'reject'}">
                                                                                <span style="color:red; font-weight:bold;">&#10008; Rejected</span><br>
                                                                            </c:if>
                                                                        </label><br>
                                                                        ${list.esicNo}<br>
                                                                        <c:if test="${list.esicFile!='' &&  list.esicFile!=null}">
                                                                            <c:if test="${list.esicFile!=null && not empty list.esicFile}">                                        
                                                                                <span class="file-wrapper">
                                                                                    <span class="file-name text-break">${list.esicFile}</span>
                                                                                    <span class="file-actions">
                                                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.esicFile}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.esicFile}"><span class="fa fa-solid fa-eye"></span></a>
                                                                                    </span>
                                                                                </span>
                                                                            </c:if>
                                                                            <c:if test="${vendorBuyerApproval.esicStatuss == 'reject'}">
                                                                                <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.esicRemarkk}</textarea>
                                                                                <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.esicResponse}</textarea>
                                                                            </c:if>
                                                                        </c:if>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <th style="width: 20%;">EPFO No.</th>
                                                                    <td>
                                                                        <c:if test="${list.epfoStatus=='0'}"><strong>EPFO Not Available</strong><br></c:if>
                                                                        <label>
                                                                            <c:if test="${vendorBuyerApproval.epfoStatuss == 'accept'}">
                                                                                <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                                            </c:if>
                                                                            <c:if test="${vendorBuyerApproval.epfoStatuss == 'reject'}">
                                                                                <span style="color:red; font-weight:bold;">&#10008; Rejected</span><br>
                                                                            </c:if>
                                                                        </label><br>
                                                                        ${list.pfNo}<br>
                                                                        <c:if test="${list.pfAttachment!='' &&  list.pfAttachment!=null}">
                                                                            <c:if test="${list.pfAttachment!=null && not empty list.pfAttachment}">                                        
                                                                                <span class="file-wrapper">
                                                                                    <span class="file-name text-break">${list.pfAttachment}</span>
                                                                                    <span class="file-actions">
                                                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.pfAttachment}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.pfAttachment}"><span class="fa fa-solid fa-eye"></span></a>
                                                                                    </span>
                                                                                </span>
                                                                            </c:if>
                                                                            <c:if test="${vendorBuyerApproval.epfoStatuss == 'reject'}">
                                                                                <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.epfoRemarkk}</textarea>
                                                                                <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.epfoResponse}</textarea>
                                                                            </c:if>
                                                                        </c:if>
                                                                    </td>
                                                                    <th style="width: 20%;">Import Export Code </th>
                                                                    <td> 
                                                                        <c:if test="${list.eccStatus == '0'}"><strong>ECC Not Available</strong><br></c:if>
                                                                        <c:if test="${list.eccStatus != '0'}">
                                                                            <label>
                                                                                <c:if test="${vendorBuyerApproval.eccStatuss == 'accept'}">
                                                                                    <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                                                </c:if>
                                                                                <c:if test="${vendorBuyerApproval.eccStatuss == 'reject'}">
                                                                                    <span style="color:red; font-weight:bold;">&#10008; Rejected</span><br>
                                                                                </c:if>
                                                                            </label><br>                                                                        
                                                                            ${list.ecc_no}<br>
                                                                            <c:if test="${list.ecc_file!='' &&  list.ecc_file!=null}">
                                                                                <c:if test="${list.ecc_file!=null && not empty list.ecc_file}">                                        
                                                                                    <span class="file-wrapper">
                                                                                        <span class="file-name text-break">${list.ecc_file}</span>
                                                                                        <span class="file-actions">
                                                                                            <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.ecc_file}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                                                            <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.ecc_file}"><span class="fa fa-solid fa-eye"></span></a>
                                                                                        </span>
                                                                                    </span>
                                                                                </c:if>
                                                                                <c:if test="${vendorBuyerApproval.eccStatuss == 'reject'}">
                                                                                    <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.eccRemarkk}</textarea>
                                                                                    <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.eccResponse}</textarea>
                                                                                </c:if>
                                                                            </c:if>
                                                                        </c:if>
                                                                    </td>                                                    
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                      
                                                    <div class="table-responsive">
                                                              <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
                                                            <thead>
                                                                <tr class="table-title">
                                                                    <td colspan="6" style="font-weight: bold; background-color: skyblue; text-align: center;">BANK DETAILS </td>
                                                                </tr>
                                                                <tr >
                                                                    <th style="" >Account Number</th>
                                                                    <td>${list.accountNumber}</td>
                                                                    <th style="">Bank Name </th>
                                                                    <td>${list.bankName}</td>
                                                                    <th style="">Branch</th>
                                                                    <td>${list.branch}</td>

                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <tr>
                                                                    <th style="">IFSC Code</th>
                                                                    <td>${list.ifscCode}</td>
                                                                    <th style="">Swift Code (if any) </th>
                                                                    <td> ${list.swiftCode}</td>
                                                                    <th style="">Cancel Cheque </th>

                                                                    <td>
                                                                        <c:if test="${list.cancelCheck!='' &&  list.cancelCheck!=null}">
                                                                            <label>
                                                                                <c:if test="${vendorBuyerApproval.cancelChequeStatuss == 'accept'}">
                                                                                    <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                                                </c:if>
                                                                                <c:if test="${vendorBuyerApproval.cancelChequeStatuss == 'reject'}">
                                                                                    <span style="color:red; font-weight:bold;">&#10008; Rejected</span><br>
                                                                                </c:if>
                                                                            </label><br>
                                                                            <c:if test="${list.cancelCheck!=null && not empty list.cancelCheck}">                                        
                                                                                <span class="file-wrapper">
                                                                                    <span class="file-name text-break">${list.cancelCheck}</span>
                                                                                    <span class="file-actions">
                                                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.cancelCheck}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.cancelCheck}"><span class="fa fa-solid fa-eye"></span></a>
                                                                                    </span>
                                                                                </span>
                                                                            </c:if>
                                                                            <c:if test="${vendorBuyerApproval.cancelChequeStatuss == 'reject'}">
                                                                                <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.cancelChequeRemarkk}</textarea>
                                                                                <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.cancelChequeResponse}</textarea>
                                                                            </c:if>
                                                                        </c:if>
                                                                    </td>
                                                                </tr>

                                                            </tbody>
                                                        </table>
                                                    </div>

                                                    <br>
                                                    <div class="table-responsive">
                                                              <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
                                                            <thead>
                                                                <tr class="table-title">
                                                                    <td colspan="3" style="font-weight: bold; background-color: skyblue; text-align: center;">FINANCIAL STATEMENT (PROFIT AND LOSS / BALANCE SHEET)</td>
                                                                    <td style="font-weight: bold; background-color: skyblue;">
                                                                        All Attachments <a href="vendorInformation.htm?act=financialStatementDetailsDocxdownloadzip&id1=${list.id}" style="text-decoration: none; color: black; font-size: 16px;">
                                                                            &nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                                                        </a>
                                                                    </td>
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
                                                                    <td>${list.finical1}</td>
                                                                    <td>${list.finicalAmount1}</td>
                                                                    <td>
                                                                        <c:if test="${list.finicalAttachment1!=null && not empty list.finicalAttachment1}">                                        
                                                                            <span class="file-wrapper">
                                                                                <span class="file-name text-break">${list.finicalAttachment1}</span>
                                                                                <span class="file-actions">
                                                                                    <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.finicalAttachment1}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.finicalAttachment1}"><span class="fa fa-solid fa-eye"></span></a>
                                                                                </span>
                                                                            </span>
                                                                        </c:if>
                                                                    </td>
                                                                </tr>
                                                                <!-- 2nd Year -->
                                                                <tr>
                                                                    <td>2nd Year </td>
                                                                    <td>${list.finical2}</td>
                                                                    <td>${list.finicalAmount2}</td>
                                                                    <td>
                                                                        <c:if test="${list.finicalAttachment2!=null && not empty list.finicalAttachment2}">                                        
                                                                            <span class="file-wrapper">
                                                                                <span class="file-name text-break">${list.finicalAttachment2}</span>
                                                                                <span class="file-actions">
                                                                                    <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.finicalAttachment2}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.finicalAttachment2}"><span class="fa fa-solid fa-eye"></span></a>
                                                                                </span>
                                                                            </span>
                                                                        </c:if>
                                                                    </td>
                                                                </tr>
                                                                <!-- 3rd Year -->
                                                                <tr>
                                                                    <td>3rd Year </td>
                                                                    <td>${list.finical3}</td>
                                                                    <td>${list.finicalAmount3}</td>
                                                                    <td>
                                                                        <c:if test="${list.finicalAttachment3!=null && not empty list.finicalAttachment3}">                                        
                                                                            <span class="file-wrapper">
                                                                                <span class="file-name text-break">${list.finicalAttachment3}</span>
                                                                                <span class="file-actions">
                                                                                    <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.finicalAttachment3}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.finicalAttachment3}"><span class="fa fa-solid fa-eye"></span></a>
                                                                                </span>
                                                                            </span>
                                                                        </c:if>	
                                                                    </td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                    </div>

                                                            <table class="table table-bordered custom-table mb-3" id="table_1" style="width:100%;">                                                        <thead> 
                                                        <thead
                                                            <tr class="table-title">
                                                                <td colspan="7" style="font-weight: bold; background-color: skyblue; text-align: center;">EXTERNAL VENDOR EMAIL </td>
                                                            </tr>
                                                            <tr style="">
                                                                <th>Vendor Email-1</th>
                                                                <th>Vendor Email-2</th>
                                                                <th>Vendor Email-3</th>

                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <td>${list.email1}</td>
                                                                <td>${list.email2}</td>
                                                                <td>${list.email3}</td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                            </c:forEach>

                                <table class="table table-bordered custom-table mb-3" id="table_1" style="width:100%;">                                                        <thead> 
                                    <thead>
                                        <tr class="table-title">
                                            <td colspan="7" style="font-weight: bold; background-color: skyblue; text-align: center;">APPROVAL HISTORY </td>
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



            </section>
        </main> 
    </body>


    <!--<script src="StorageYard/assets/js/TableScript/commonTableScript.js" type="text/javascript"></script>-->

    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>


