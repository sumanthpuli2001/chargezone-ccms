<%-- 
    Document   : HRApprovalView
    Created on : 17 Oct, 2025, 03:00:57 PM
    Author     : fnp
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

    <head>
        <title>HR Approval</title>
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
                    border: 1px solid white !important;
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
                .hr-section{
                    page-break-before: always;
                }
                /* Optional: hide buttons or elements not needed in print */
                .no-print {
                    display: none !important;
                }
            }
        </style>
        <style>
            .wrap-text {
                display: block;
                white-space: normal;
                word-break: break-word;
                overflow-wrap: anywhere;
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
        </style>
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


        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">

            <section id="printSection" class="main-content">
                <form:form action="vendorInformation.htm?act=ButtonHrApprovals"  enctype="multipart/form-data" method="post"
                           name='form' class="form-horizontal" role="form">
                    <c:forEach var="list" items="${list}" varStatus="status">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">HR Approval</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>                            
                        </div>
                    </div>
                    <hr>
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
                    <input type="hidden" id="id" name="id" value="${list.id}">
                    <input type="hidden" id="id1" name="id1" value="${list.id}">
                    

                        <table  class="bottom-table" id="" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <thead>
                                                            <tr class="table-title">
                                                                <td colspan="3" style="font-weight: bold; background-color: skyblue;">VENDOR DETAILS</td>
                                                                <td style="font-weight: bold; background-color: skyblue;">
                                                                    All Attachments <a href="vendorInformation.htm?act=vendorDetailsDocxdownloadzip&id1=${list.id}" style="text-decoration: none; color: black; font-size: 16px;">
                                                                        &nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                                                    </a>
                                                                </td>
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
                                                                <th style="">   <c:if test="${list.policyAccept=='1'}">Code of COnduct (Sign & Stamp in all Pages)</c:if>
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
                                                                <th  style="">Year of Establishment of Company</th>
                                                                <td>${list.establishment}</td>
                                                                <th></th>
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
                                                    <br>
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
                                                                        <td>+${mplist.countryCode}-${mplist.phoneNo}</td>
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
                                                                    <td colspan="5" style="font-weight: bold; background-color: skyblue;">  PAST WORKING EXPERIENCE DETAILS </td>
                                                                    <td style="font-weight: bold; background-color: skyblue;">
                                                                        All Attachments <a href="vendorInformation.htm?act=pastWorkingExpDetailsDocxdownloadzip&id1=${list.id}" style="text-decoration: none; color: black; font-size: 16px;">
                                                                            &nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                                                        </a>
                                                                    </td>
                                                                </tr>
                                                            <th >Company Name</th>
                                                            <th >Contact Person Name</th>
                                                            <th >Phone No.</th>
                                                            <th >Email</th>
                                                            <th >Designation</th>
                                                            <th >Attachment</th>
                                                            </thead>
                                                            <tbody>
                                                                <c:forEach var="lstwork" items="${lstwork}">
                                                                    <tr>
                                                                        <td ><span>${lstwork.companyName}</span> </td> 
                                                                        <td ><span>${lstwork.contactPersonName}</span> </td>

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


                                                    
                                                    <table class="bottom-table">
                                                        <thead>
                                                            <tr class="table-title">
                                                                <td colspan="4" style="font-weight: bold; background-color: skyblue;">EPFO DETAILS</td>
                                                            </tr>
                                                            <tr>
                                                                <th>EPFO No.</th>
                                                                <th>Attachment</th>
                                                                <th>Accept / Reject</th>
                                                                <th>Response</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <td><c:if test="${list.epfoStatus=='0'}"><strong>EPFO Not Available</strong></c:if>${list.pfNo}</td>
                                                                <td>
                                                                    <c:if test="${list.pfAttachment!=null && not empty list.pfAttachment}">                                        
                                                                        <span class="file-wrapper">
                                                                            <span class="file-name text-break">${list.pfAttachment}</span>
                                                                            <span class="file-actions">
                                                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.pfAttachment}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.pfAttachment}"><span class="fa fa-solid fa-eye"></span></a>
                                                                            </span>
                                                                        </span>
                                                                    </c:if>
                                                                </td>
                                                                <td>
                                                                    <label><input required class="radio" type="radio" name="epfoStatuss" value="accept" onclick="toggleRemark(this)"  <c:if test="${list.epfoStatuss=='accept'}">checked</c:if>> Accept</label>
                                                                    <label><input required class="radio" type="radio" name="epfoStatuss" value="reject" onclick="toggleRemark(this)"  <c:if test="${list.epfoStatuss=='reject'}">checked</c:if>> Reject</label><br>
                                                                    <div class="remark-box" style="display:none; margin-top:5px;">
                                                                        <textarea name="epfoRemarkk" class="textarea-field" placeholder="Enter remark" >${list.epfoRemarkk}</textarea>
                                                                    </div>
                                                                </td>
                                                                <td>
                                                                    <c:if test="${list.epfoStatuss=='reject'}">
                                                                        ${list.epfoResponse}
                                                                    </c:if>
                                                                </td>
                                                            </tr>


                                                        </tbody>
                                                    </table>

                                                    <br>

                                                    <table class="bottom-table">
                                                        <thead>
                                                            <tr class="table-title">
                                                                <td colspan="6" style="font-weight: bold; background-color: skyblue;">HR CRITERIA</td>
                                                                <td colspan="2" style="font-weight: bold; background-color: skyblue;">
                                                                    All Attachments <a href="vendorInformation.htm?act=hrCriteriaDetailsDocxdownloadzip&id1=${VInformationId}" style="text-decoration: none; color: black; font-size: 16px;">
                                                                        &nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                                                    </a>
                                                                </td>
                                                            </tr>
                                                        </thead>
                                                        <tr style="">

                                                            <th>Criteria</th>
                                                            <th>Selection Criteria</th>
                                                            <th>Comment</th>
                                                            <th>Attachment</th>
                                                            <th>Vendor Score</th>
                                                            <th>Accept</th>
                                                            <th>Score</th>
                                                            <th>HR Comment</th>
                                                        </tr>
                                                        <input type="hidden" id="hrPercentage" value="${hrPercentage}">
                                                        <c:forEach var="list5" items="${hrList}" varStatus="status">

                                                            <tr>
                                                                <td style="width: 15%;"><pre class="terms-details">${list5.criteriaName}</pre></td>
                                                                <td style="width: 25%;"><pre class="terms-details">${list5.criteriaDescription}</pre></td>
                                                                <td style="width: 10%;">${list5.comment}</td>
                                                                <td style="width: 10%;">
                                                                    <c:if test="${list5.attachement!=null && not empty list5.attachement}">                                        
                                                                        <span class="file-wrapper">
                                                                            <span class="file-name text-break">${list5.attachement}</span>
                                                                            <span class="file-actions">
                                                                                <a class="fw-600 text-break gradient-text" href="vendorInformation.htm?act=downloadCriteriaFileAprrove&amp;fileName=${list5.attachement}&foldName=HR&id=${list.id}">&nbsp;<span class="fa fa-download"></span></a>
                                                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/HR/${list5.attachement}"><span class="fa fa-solid fa-eye"></span></a>					
                                                                            </span>
                                                                        </span>
                                                                    </c:if>
                                                                </td>
                                                                <td style="width: 10%;"><c:if test="${list5.score==0}">NO</c:if>
                                                                    <c:if test="${list5.score==1}">YES</c:if></td>
                                                            <input type="hidden" name="hrId" value="${list5.id}">
                                                            <td style="width: 10%;">
                                                                <select class="select-input accept-select" 
                                                                        name="accept" 
                                                                        id="accept${status.count}" 
                                                                        data-compulsaryflag="${list5.compulsaryFlag}" 
                                                                        onchange="response();">
                                                                    <c:choose>
                                                                        <c:when test="${list5.accept=='0'}">
                                                                            <option value="2">Accept</option>
                                                                            <option value="1">Partial Accept</option>  
                                                                            <option value="0" selected="true">Reject</option>
                                                                        </c:when>
                                                                        <c:when test="${list5.accept=='1'}">
                                                                            <option value="2">Accept</option>
                                                                            <option value="1" selected="true">Partial Accept</option>  
                                                                            <option value="0" >Reject</option>
                                                                        </c:when>
                                                                        <c:when test="${list5.accept=='2'}">
                                                                            <option value="2" selected="true">Accept</option>
                                                                            <option value="1" >Partial Accept</option>  
                                                                            <option value="0" >Reject</option>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <option value="">--Select--</option>
                                                                            <option value="2">Accept</option>
                                                                            <option value="1">Partial Accept</option>  
                                                                            <option value="0">Reject</option>
                                                                        </c:otherwise>
                                                                    </c:choose>

                                                                </select>
                                                            </td>
                                                            <td style="width: 10%;"><input type="text" id="remark${status.count}" readonly="true" name="remark" class="input-field"></td>
                                                            <td style="width: 10%;"><textarea type="text" id="hrComment${status.count}" value=""  name="hrComment" style="display: none;" maxlength="250" class="input-field">${list5.hrComment}</textarea></td>
                                                            </tr>

                                                        </c:forEach>
                                                        <tr>
                                                            <td colspan="5">Total</td>
                                                            <td><input type="text" id="total" readonly="true" name="total" class="input-field"></td>
                                                            <td></td>
                                                            <td></td>
                                                        </tr>


                                                        <tr>
                                                            <td colspan="5">Total Percentage</td>
                                                            <td><input type="text" id="percentage" readonly="true" name="percentage" class="input-field"></td>
                                                            <td></td>
                                                            <td></td>
                                                        </tr>
                                                    </table>

                                                    

                                                </c:forEach>

                                                <div class="rounded-4 mt-4">
                                                    <div class="row mb-3">
                                                        <div class="col-lg-12 col-md-6">
                                                            <div class="form-group -box">
                                                                <label class="control-label">Comment :<span class="text-danger">*</span></label>
                                                                <textarea name="comment" id="comment"  class="textarea-field "style="text-transform: uppercase;" maxlength="250"  required="required"></textarea>                                                                
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                    
                                                    <div class="cta d-flex justify-content-center align-items-center">
                                                        <button type="submit" class="btn theme-btn recycle-btn mr-3" formaction="vendorInformation.htm?act=RecycleHrApproval&id=${vendorInformation1.id}">
                                                            Recycle
                                                        </button>
                                                        <button type="submit" id="submit1" class="btn theme-btn">
                                                            Accept
                                                        </button>
                                                    </div>
                                                    <br>

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
        <script>
            function response() {
                var l = document.getElementsByName("hrId").length;
                var sum = 0;
                var total = l * 2;

                for (var i = 1; i <= l; i++) {
                    var accept = document.getElementById("accept" + i).value;
                    document.getElementById("remark" + i).value = accept;

                    var remarkValue = parseFloat(accept) || 0;
                    sum += remarkValue;

                    toggleHRComment(i, accept);
                }

                document.getElementById("total").value = sum;

                var totalPercentage = (sum * 100) / total;
                document.getElementById("percentage").value = totalPercentage.toFixed(2) + "%";

                var hrPercentage = document.getElementById("hrPercentage").value;

                var compulsoryOk = true;
                var selects = document.querySelectorAll('.accept-select');

                selects.forEach(function (select) {
                    var flag = select.getAttribute('data-compulsaryflag');
                    var value = select.value;

                    if (flag === '1' && value !== '2') {
                        compulsoryOk = false;
                    }
                });

                // ✅ FIXED NAME
                var isRejected = document.querySelector('input[name="epfoStatuss"]:checked')?.value === 'reject';

                // ✅ FINAL BUTTON LOGIC
                let disableBtn = !(totalPercentage >= hrPercentage && compulsoryOk) || isRejected;

                document.getElementById("submit1")?.toggleAttribute('disabled', disableBtn);
                document.getElementById("submit2")?.toggleAttribute('disabled', disableBtn);
            }


            function toggleHRComment(index, value) {
                var hrCommentField = document.getElementById("hrComment" + index);

                if (value === "0") {
                    hrCommentField.style.display = "block";
                    hrCommentField.setAttribute("required", "true");
                 } else if (value === "1" || value === "2") {
                    hrCommentField.value = "";
                    hrCommentField.style.display = "none";
                    hrCommentField.removeAttribute("required");
                } else {
                    hrCommentField.style.display = "none";
                    hrCommentField.removeAttribute("required");
                    hrCommentField.value = "";
                }
            }


            // ================= EPFO (Reject Remark) =================

            function toggleRemark(radio) {
                const container = radio.closest('td') || radio.parentElement;
                const remarkBox = container.querySelector('.remark-box');

                if (!remarkBox) return;

                const textarea = remarkBox.querySelector('textarea');

                if (radio.value === 'reject') {
                    remarkBox.style.display = 'block';
                    textarea.setAttribute('required', 'true');
                } else {
                    remarkBox.style.display = 'none';
                    textarea.removeAttribute('required');
                }

                // sync both logics
                initRejectRemark();
                response();
            }

            function initRejectRemark() {
                const checkedRadios = document.querySelectorAll('input[type="radio"]:checked');

                let rejectFound = false;

                checkedRadios.forEach(function (radio) {
                    const container = radio.closest('td') || radio.parentElement;
                    const remarkBox = container.querySelector('.remark-box');

                    if (!remarkBox) return;

                    const textarea = remarkBox.querySelector('textarea');

                    if (radio.value === 'reject') {
                        remarkBox.style.display = 'block';
                        textarea.setAttribute('required', 'true');
                        rejectFound = true;
                    } else {
                        remarkBox.style.display = 'none';
                        textarea.removeAttribute('required');
                    }
                });

                // ❗ DO NOT directly control button here
                // Let response() handle it
            }


            // ✅ ON LOAD
            document.addEventListener('DOMContentLoaded', function () {
                initRejectRemark();
                response(); // VERY IMPORTANT
            });
            </script>
    </body>



    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>


