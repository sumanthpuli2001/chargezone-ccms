<%-- 
    Document   : SafetyApprovalView
    Created on : 17 Oct, 2025, 03:00:57 PM
    Author     : fnp
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

    <head>
        <title>Compliance Officer</title>
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
            /* ✅ Force browser to print background colors & styles */
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
<script>
        function recycle() {
            var id = document.getElementsByName('id1');
            y = id[0].value;
            var comment = document.getElementsByName('comment');
            comment1 = comment[0].value;
            window.location = 'vendorInformation.htm?act=recyclevendor&id=' + y + '&comment=' + comment1;
        }
        function reject() {
            var id = document.getElementsByName('id1');
            y = id[0].value;
            var comment = document.getElementsByName('comment');
            comment1 = comment[0].value;
            window.location = 'vendorInformation.htm?act=rejectVendorComplienceOfficer&id=' + y + '&comment=' + comment1;
        }
       
    </script>
    <body>
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


        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">

            <section id="printSection" class="main-content">
                      <form:form action="vendorInformation.htm?act=ComplianceOfficerApproved"  method="post"
                   name='form1' class="form-horizontal" role="form" enctype="multipart/form-data">
                    <c:forEach var="list" items="${list}" varStatus="status">
                        <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                            <div class="page-title d-flex align-items-center">
                                <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                    <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                         alt="Menu collapse">
                                    <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                         alt="Menu collapse">
                                </div>
                                <h5 class="fw-600 mb-0">Compliance Officer</h5>
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

                                <table  class="bottom-table"  id="" class="table table-bordered table-striped table-hover" style="" align="Center"  >
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
                                            <th style="">Type of Company</th>
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
                                            <th>Risk Category</th>
                                            <td class="riskCategory">${list.riskCategory}</td>
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
                                                                    <td colspan="8" style="font-weight: bold; background-color: skyblue;">TYPES OF VENDORS</td>
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
                                                            <thead>
                                                                <tr class="table-title">
                                                                    <td colspan="7" style="font-weight: bold; background-color: skyblue;">VENDOR CONTACT DETAILS</td>
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
                                                    <br>

                                                   <div class="table-responsive">
                                                        <table class="bottom-table" id="table_1" class="table table-bordered table-striped table-hover" align="Center">
                                                            <thead>
                                                                <tr class="table-title">
                                                                    <td colspan="3" style="font-weight: bold; background-color: skyblue;">COMPANY REGISTRATION DETAILS</td>
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
                                                                        ${list.gstinNo}<br>
                                                                        <c:if test="${list.gstinFile!=null && not empty list.gstinFile}">                                        
                                                                            <span class="file-wrapper">
                                                                                <span class="file-name text-break">${list.gstinFile}</span>
                                                                                <span class="file-actions">
                                                                                    <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.gstinFile}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.gstinFile}"><span class="fa fa-solid fa-eye"></span></a>
                                                                                </span>
                                                                            </span>
                                                                        </c:if>
                                                                    </td>                                                    
                                                                    <th style="width: 20%;">PAN No</th>
                                                                    <td>                                                    
                                                                        ${list.panNo}<br>
                                                                        <c:if test="${list.panFile!=null && not empty list.panFile}">                                        
                                                                            <span class="file-wrapper">
                                                                                <span class="file-name text-break">${list.panFile}</span>
                                                                                <span class="file-actions">
                                                                                    <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.panFile}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.panFile}"><span class="fa fa-solid fa-eye"></span></a>
                                                                                </span>
                                                                            </span>
                                                                        </c:if>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <th style="width: 20%;">MSME No</th>
                                                                    <td>
                                                                        <c:if test="${list.msmeStatus=='0'}"><strong>MSME Not
                                                                                Available</strong></c:if>
                                                                        ${list.service_tax}<br>
                                                                        <c:if test="${list.service_file!=null && not empty list.service_file}">                                        
                                                                            <span class="file-wrapper">
                                                                                <span class="file-name text-break">${list.service_file}</span>
                                                                                <span class="file-actions">
                                                                                    <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.service_file}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.service_file}"><span class="fa fa-solid fa-eye"></span></a>
                                                                                </span>
                                                                            </span>
                                                                        </c:if>
                                                                    </td>
                                                                    <th style="width: 20%;">ESIC No</th>
                                                                    <td>
                                                                        <c:if test="${list.esicStatus=='0'}"><strong>ESIC Not
                                                                                Available</strong></c:if>
                                                                        ${list.esicNo}<br>
                                                                        <c:if test="${list.esicFile!=null && not empty list.esicFile}">                                        
                                                                            <span class="file-wrapper">
                                                                                <span class="file-name text-break">${list.esicFile}</span>
                                                                                <span class="file-actions">
                                                                                    <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.esicFile}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.esicFile}"><span class="fa fa-solid fa-eye"></span></a>
                                                                                </span>
                                                                            </span>
                                                                        </c:if>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <th style="width: 20%;">EPFO No.</th>
                                                                    <td>
                                                                        <c:if test="${list.epfoStatus=='0'}"><strong>EPFO Not
                                                                                Available</strong></c:if>
                                                                        ${list.pfNo}<br>
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
                                                                    <th style="width: 20%;">Import Export Code </th>
                                                                    <td> 
                                                                        <c:if test="${list.eccStatus == '0'}"><strong>ECC Not
                                                                                Available</strong></c:if>
                                                                        ${list.ecc_no}<br>
                                                                        <c:if test="${list.ecc_file!=null && not empty list.ecc_file}">                                        
                                                                            <span class="file-wrapper">
                                                                                <span class="file-name text-break">${list.ecc_file}</span>
                                                                                <span class="file-actions">
                                                                                    <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.ecc_file}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.ecc_file}"><span class="fa fa-solid fa-eye"></span></a>
                                                                                </span>
                                                                            </span>
                                                                        </c:if>
                                                                    </td>                                                    
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                    </div>

                                                    <br>

                                                    <div class="table-responsive">
                                                        <table class="bottom-table" id="table_1" class="table table-bordered table-striped table-hover" align="Center">
                                                            <thead>
                                                                <tr class="table-title">
                                                                    <td colspan="7" style="font-weight: bold; background-color: skyblue;">BANK DETAILS</td>
                                                                </tr>
                                                                <tr>
                                                                    <th  style="">Account Number</th>
                                                                    <td>${list.accountNumber}</td>
                                                                    <th style="">Bank Name </th>
                                                                    <td>${list.bankName}</td>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <tr>
                                                                    <th style="">Branch</th>
                                                                    <td>${list.branch}</td>
                                                                    <th style="">IFSC Code</th>
                                                                    <td>${list.ifscCode}</td>

                                                                </tr>
                                                                <tr>
                                                                    <th style="">Swift Code (if any) </th>
                                                                    <td> ${list.swiftCode}</td>
                                                                    <th style="">Cancel Cheque </th>
                                                                    <td>  
                                                                        <c:if test="${list.cancelCheck!=null && not empty list.cancelCheck}">                                        
                                                                            <span class="file-wrapper">
                                                                                <span class="file-name text-break">${list.cancelCheck}</span>
                                                                                <span class="file-actions">
                                                                                    <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.cancelCheck}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.cancelCheck}"><span class="fa fa-solid fa-eye"></span></a>
                                                                                </span>
                                                                            </span>
                                                                        </c:if>
                                                                    </td>
                                                                </tr>

                                                            </tbody>
                                                            </table>
                                                        </div>
                                                        <br>


                                                        <table class="bottom-table">
                                                            <thead>
                                                                <tr class="table-title">
                                                                    <td colspan="7" style="font-weight: bold; background-color: skyblue;">SELF DECLARATION FORM</td>
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


                                                    <c:if test="${!empty generalList}"> 
                                                    <br>
                                                        <div class="technical-section">
                                                            <table class="bottom-table">
                                                                <thead>
                                                                    <tr class="table-title">
                                                        <td colspan="6" style="font-weight: bold; background-color: skyblue;">TECHNICAL CRITERIA</td>
                                                        <td  colspan="2" style="font-weight: bold; background-color: skyblue;">
                                                            All Attachments <a href="vendorInformation.htm?act=technicalCriteriaDetailsDocxdownloadzip&id1=${list.id}" style="text-decoration: none; color: black; font-size: 16px;">
                                                                &nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                                            </a>
                                                        </td>
                                                    </tr>
                                                                    <tr style="">
                                                                        <th>Sr No.</th>
                                                                        <th>Criteria</th>
                                                                        <th>Selection Criteria</th>
                                                                       
                                                                        <th>Attachment</th>
                                                                        <th>Vendor Score</th>
                                                                         <th>Comment</th>
                                                                        <th>Technical Score</th>
                                                                        <th>Technical Comment</th>
                                                                    </tr>
                                                                </thead>

                                                                <tbody>
                                                                <input type="hidden" name="vendorPercentage" id="vendorPercentage" value="${vendorPercentage[0].technicalPercentage}">

                                                                <c:forEach var="list5" items="${generalList}" varStatus="status">
                                                                    <tr>
                                                                        <td>${status.count}</td>
                                                                        <td style="width: 15%;">${list5.criteria}</td>
                                                                        <td style="width: 25%;">${list5.selectionCriteria}</td>
                                                                        

                                                                        <td style="width: 10%;">
                                                                            <c:if test="${list5.attachment!=null && not empty list5.attachment}">                                        
                                                                                <span class="file-wrapper">
                                                                                    <span class="file-name text-break">${list5.attachment}</span>
                                                                                    <span class="file-actions">
                                                                                        <a class="fw-600 text-break gradient-text" href="vendorInformation.htm?act=downloadCriteriaFileAprrove&amp;fileName=${list5.attachment}&foldName=TECHNICAL&id=${vendorInformation1.id}">&nbsp;<span class="fa fa-download"></span></a>
                                                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/TECHNICAL/${list5.attachment}"><span class="fa fa-solid fa-eye"></span></a>					
                                                                                    </span>
                                                                                </span>
                                                                            </c:if>
                                                                        </td>

                                                                    <input type="hidden" name="hrId" value="${list5.id}">

                                                                    <td style="width: 10%;">
                                                                        <c:if test="${list5.score==0}">NO</c:if>
                                                                        <c:if test="${list5.score==1}">YES</c:if>
                                                                        </td>
                                                                        <td style="width: 10%;">${list5.comment}</td>

                                                                        <td style="width: 10%;" class="technicalScore" data-accept="${list5.response}">
                                                                        <c:if test="${list5.response=='2'}">Accept</c:if>
                                                                        <c:if test="${list5.response=='1'}">Partial Accept</c:if>
                                                                        <c:if test="${list5.response=='0'}">Reject</c:if>
                                                                        </td>

                                                                        <td style="width: 10%;">
                                                                        ${list5.technicalComment}
                                                                    </td>
                                                                    </tr>
                                                                </c:forEach>


                                                                <tr>
                                                                    <td colspan="6" style="font-weight: bold;">Total</td>
                                                                    <td><input type="text" id="technicalTotal" readonly="true" name="total" class="input-field"></td>
                                                                    <td></td>
                                                                </tr>


                                                                <tr>
                                                                    <td colspan="6" style="font-weight: bold;">Total Percentage</td>
                                                                    <td><input type="text" id="technicalPercentage" readonly="true" name="percentage" class="input-field"></td>
                                                                    <td></td>
                                                                </tr>
                                                                </tbody>
                                                            </table>


                                                            <script>
                                                                        document.addEventListener("DOMContentLoaded", function () {
                                                                        let total = 0;
                                                                                let count = 0;
                                                                                document.querySelectorAll(".technicalScore").forEach(function (cell) {
                                                                        let acceptVal = cell.getAttribute("data-accept");
                                                                                let score = parseInt(acceptVal);
                                                                                if (!isNaN(score)) {
                                                                        total += score;
                                                                                count++;
                                                                        }
                                                                        });
                                                                                document.getElementById("technicalTotal").value = total;
                                                                                if (count > 0) {
                                                                        let percentage = ((total / (count * 2)) * 100).toFixed(2);
                                                                                document.getElementById("technicalPercentage").value = percentage + " %";
                                                                        } else {
                                                                        document.getElementById("technicalPercentage").value = "0 %";
                                                                        }
                                                                        });</script>
                                                        </div>   
                                                    </c:if>


                                                    <c:if test="${!empty hrList}"> 
                                                    <br>
                                                        <div class="hr-section">
                                                            <table class="bottom-table">
                                                                <thead>
                                                                    <tr class="table-title">
                                                        <td colspan="6" style="font-weight: bold; background-color: skyblue;">HR CRITERIA</td>
                                                        <td colspan="2" style="font-weight: bold; background-color: skyblue;">
                                                            All Attachments <a href="vendorInformation.htm?act=hrCriteriaDetailsDocxdownloadzip&id1=${list.id}" style="text-decoration: none; color: black; font-size: 16px;">
                                                                &nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                                            </a>
                                                        </td>
                                                    </tr>
                                                                    <tr style="">
                                                                        <th>Sr No.</th>
                                                                        <th>Criteria</th>
                                                                        <th>Selection Criteria</th>
                                                                       
                                                                        <th>Attachment</th>
                                                                        <th>Vendor Score</th>
                                                                         <th>Comment</th>
                                                                        <th>HR Score</th>
                                                                        <th>HR Comment</th>
                                                                    </tr>
                                                                </thead>

                                                                <tbody>
                                                                <input type="hidden" name="vendorPercentage" id="vendorPercentage" value="${vendorPercentage[0].hrPercentage}">

                                                                <c:forEach var="list5" items="${hrList}" varStatus="status">
                                                                    <tr>
                                                                        <td>${status.count}</td>
                                                                        <td style="width: 15%;">${list5.criteriaName}</td>
                                                                        <td style="width: 25%;">${list5.criteriaDescription}</td>
                                                                        

                                                                        <td style="width: 10%;">
                                                                            <c:if test="${list5.attachement!=null && not empty list5.attachement}">                                        
                                                                                <span class="file-wrapper">
                                                                                    <span class="file-name text-break">${list5.attachement}</span>
                                                                                    <span class="file-actions">
                                                                                        <a class="fw-600 text-break gradient-text" href="vendorInformation.htm?act=downloadCriteriaFileAprrove&amp;fileName=${list5.attachement}&foldName=HR&id=${vendorInformation1.id}">&nbsp;<span class="fa fa-download"></span></a>
                                                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/HR/${list5.attachement}"><span class="fa fa-solid fa-eye"></span></a>					
                                                                                    </span>
                                                                                </span>
                                                                            </c:if>
                                                                        </td>

                                                                    <input type="hidden" name="hrId" value="${list5.id}">

                                                                    <td style="width: 10%;">
                                                                        <c:if test="${list5.score==0}">NO</c:if>
                                                                        <c:if test="${list5.score==1}">YES</c:if>
                                                                        </td>
                                                                        <td style="width: 10%;">${list5.comment}</td>

                                                                        <td style="width: 10%;" class="hrScore" data-accept="${list5.accept}">
                                                                        <c:if test="${list5.accept==2}">Accept</c:if>
                                                                        <c:if test="${list5.accept==1}">Partial Accept</c:if>
                                                                        <c:if test="${list5.accept==0}">Reject</c:if>
                                                                        </td>

                                                                        <td style="width: 10%;">
                                                                        ${list5.hrComment}
                                                                    </td>
                                                                    </tr>
                                                                </c:forEach>


                                                                <tr>
                                                                    <td colspan="6" style="font-weight: bold;">Total</td>
                                                                    <td><input type="text" id="hrTotal" readonly="true" name="total" class="input-field"></td>
                                                                    <td></td>
                                                                </tr>


                                                                <tr>
                                                                    <td colspan="6" style="font-weight: bold;">Total Percentage</td>
                                                                    <td><input type="text" id="hrPercentage" readonly="true" name="percentage" class="input-field"></td>
                                                                    <td></td>
                                                                </tr>
                                                                </tbody>
                                                            </table>


                                                            <script>
                                                                        document.addEventListener("DOMContentLoaded", function () {
                                                                        let total = 0;
                                                                                let count = 0;
                                                                                document.querySelectorAll(".hrScore").forEach(function (cell) {
                                                                        let acceptVal = cell.getAttribute("data-accept");
                                                                                let score = parseInt(acceptVal);
                                                                                if (!isNaN(score)) {
                                                                        total += score;
                                                                                count++;
                                                                        }
                                                                        });
                                                                                document.getElementById("hrTotal").value = total;
                                                                                if (count > 0) {
                                                                        let percentage = ((total / (count * 2)) * 100).toFixed(2);
                                                                                document.getElementById("hrPercentage").value = percentage + " %";
                                                                        } else {
                                                                        document.getElementById("hrPercentage").value = "0 %";
                                                                        }
                                                                        });</script>

                                                        </div>
                                                    </c:if>

                                                    <c:if test="${!empty itList}">       

                                                    <br>
                                                        <div class="it-section">
                                                            <table class="bottom-table">
                                                                <thead>
                                                                   <tr class="table-title">
                                                        <td colspan="6" style="font-weight: bold; background-color: skyblue;">IT CRITERIA</td>
                                                        <td colspan="2"  style="font-weight: bold; background-color: skyblue;">
                                                            All Attachments <a href="vendorInformation.htm?act=itCriteriaDetailsDocxdownloadzip&id1=${list.id}" style="text-decoration: none; color: black; font-size: 16px;">
                                                                &nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                                            </a>
                                                        </td>
                                                    </tr>
                                                                    <tr style="">
                                                                        <th>Sr No.</th>
                                                                        <th>Criteria</th>
                                                                        <th>Selection Criteria</th>
                                                                        
                                                                        <th>Attachment</th>
                                                                        <th>Vendor Score</th>
                                                                        <th>Comment</th>
                                                                        <th>IT Score</th>
                                                                        <th>IT Comment</th>
                                                                    </tr>
                                                                </thead>

                                                                <tbody>
                                                                <input type="hidden" name="vendorPercentage" id="vendorPercentage" value="${vendorPercentage[0].itPercentage}">

                                                                <c:forEach var="list5" items="${itList}" varStatus="status">
                                                                    <tr>
                                                                        <td>${status.count}</td>
                                                                        <td style="width: 15%;">${list5.criteriaName}</td>
                                                                        <td style="width: 25%;">${list5.criteriaDescription}</td>
                                                                        

                                                                        <td style="width: 10%;">
                                                                            <c:if test="${list5.attachement!=null && not empty list5.attachement}">                                        
                                                                                <span class="file-wrapper">
                                                                                    <span class="file-name text-break">${list5.attachement}</span>
                                                                                    <span class="file-actions">
                                                                                        <a class="fw-600 text-break gradient-text" href="vendorInformation.htm?act=downloadCriteriaFileAprrove&amp;fileName=${list5.attachement}&foldName=IT&id=${vendorInformation1.id}">&nbsp;<span class="fa fa-download"></span></a>
                                                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/IT/${list5.attachement}"><span class="fa fa-solid fa-eye"></span></a>					
                                                                                    </span>
                                                                                </span>
                                                                            </c:if>
                                                                        </td>

                                                                    <input type="hidden" name="criteriaName" value="${list5.id}">
                                                                    <td style="width: 10%;">
                                                                        <c:if test="${list5.score==0}">NO</c:if>
                                                                        <c:if test="${list5.score==1}">YES</c:if>
                                                                        </td>
                                                                        <td style="width: 10%;">${list5.comment}</td>

                                                                        <td style="width: 10%;" class="itScore" data-accept="${list5.accept}">
                                                                        <c:if test="${list5.accept==2}">Accept</c:if>
                                                                        <c:if test="${list5.accept==1}">Partial Accept</c:if>
                                                                        <c:if test="${list5.accept==0}">Reject</c:if>
                                                                        </td>
                                                                        <td style="width: 10%;">
                                                                        ${list5.itComment}
                                                                    </td>
                                                                    </tr>
                                                                </c:forEach>


                                                                <tr>
                                                                    <td colspan="6" style="font-weight: bold;">Total</td>
                                                                    <td><input type="text" id="itTotal" readonly="true" name="total" class="input-field"></td>
                                                                    <td></td>
                                                                </tr>

                                                                <tr>
                                                                    <td colspan="6" style="font-weight: bold;">Total Percentage</td>
                                                                    <td><input type="text" id="itPercentage" readonly="true" name="percentage" class="input-field"></td>
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
                                                                                document.getElementById("itTotal").value = total;
                                                                                if (count > 0) {
                                                                        let percentage = ((total / (count * 2)) * 100).toFixed(2);
                                                                                document.getElementById("itPercentage").value = percentage + " %";
                                                                        } else {
                                                                        document.getElementById("itPercentage").value = "0 %";
                                                                        }
                                                                        });</script>

                                                        </div>
                                                    </c:if>

                                                    <c:if test="${!empty saftyList}"> 
                                                    <br>
                                                        <div class="safety-section">
                                                            <table class="bottom-table">
                                                                <thead>
                                                                    <tr class="table-title">
                                                                        <td colspan="6" style="font-weight: bold; background-color: skyblue;">SAFETY CRITERIA</td>
                                                                        <td colspan="2" style="font-weight: bold; background-color: skyblue;">
                                                                            All Attachments <a href="vendorInformation.htm?act=safetyCriteriaDetailsDocxdownloadzip&id1=${list.id}" style="text-decoration: none; color: black; font-size: 16px;">
                                                                                &nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                                                            </a>
                                                                        </td>
                                                                    </tr>
                                                                    <tr style="">
                                                                        <th>Sr No.</th>
                                                                        <th>Criteria</th>
                                                                        <th>Selection Criteria</th>
                                                                        
                                                                        <th>Attachment</th>
                                                                        <th>Vendor Score</th>
                                                                        <th>Comment</th>
                                                                        <th>Safety Score</th>
                                                                        <th>Safety Comment</th>
                                                                    </tr>
                                                                </thead>

                                                                <tbody>
                                                                <input type="hidden" name="vendorPercentage" id="vendorPercentage" value="${vendorPercentage[0].safteyPercentage}">

                                                                <c:forEach var="list5" items="${saftyList}" varStatus="status">
                                                                    <tr>
                                                                        <td>${status.count}</td>
                                                                        <td style="width: 15%;">${list5.criteriaName}</td>
                                                                        <td style="width: 25%;">${list5.criteriaDescription}</td>
                                                                        

                                                                        <td style="width: 10%;">
                                                                            <c:if test="${list5.attachement!=null && not empty list5.attachement}">                                        
                                                                                <span class="file-wrapper">
                                                                                    <span class="file-name text-break">${list5.attachement}</span>
                                                                                    <span class="file-actions">
                                                                                        <a class="fw-600 text-break gradient-text" href="vendorInformation.htm?act=downloadCriteriaFileAprrove&amp;fileName=${list5.attachement}&foldName=HSE&id=${vendorInformation1.id}">&nbsp;<span class="fa fa-download"></span></a>
                                                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/HSE/${list5.attachement}"><span class="fa fa-solid fa-eye"></span></a>					
                                                                                    </span>
                                                                                </span>
                                                                            </c:if>
                                                                        </td>

                                                                    <input type="hidden" name="criteriaName" value="${list5.id}">

                                                                    <td style="width: 10%;">
                                                                        <c:if test="${list5.score==0}">NO</c:if>
                                                                        <c:if test="${list5.score==1}">YES</c:if>
                                                                        </td>
                                                                        <td style="width: 10%;">${list5.comment}</td>

                                                                        <td style="width: 10%;" class="safetyScore" data-accept="${list5.accept}">
                                                                        <c:if test="${list5.accept==2}">Accept</c:if>
                                                                        <c:if test="${list5.accept==1}">Partial Accept</c:if>
                                                                        <c:if test="${list5.accept==0}">Reject</c:if>
                                                                        </td>

                                                                        <td style="width: 10%;">
                                                                        ${list5.safetyComment}
                                                                    </td>
                                                                    </tr>
                                                                </c:forEach>
                                                                <tr>
                                                                    <td colspan="6" style="font-weight: bold;">Total</td>
                                                                    <td><input type="text" id="safetyTotal" readonly="true" name="total" class="input-field"></td>
                                                                    <td></td>
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="6" style="font-weight: bold;">Total Percentage</td>
                                                                    <td><input type="text" id="safetyPercentage" readonly="true" name="percentage" class="input-field"></td>
                                                                    <td></td>
                                                                </tr>
                                                                </tbody>
                                                            </table>


                                                            <script>
                                                                        document.addEventListener("DOMContentLoaded", function () {
                                                                        let total = 0;
                                                                                let count = 0;
                                                                                document.querySelectorAll(".safetyScore").forEach(function (cell) {
                                                                        let acceptVal = cell.getAttribute("data-accept");
                                                                                let score = parseInt(acceptVal);
                                                                                if (!isNaN(score)) {
                                                                        total += score;
                                                                                count++;
                                                                        }
                                                                        });
                                                                                document.getElementById("safetyTotal").value = total;
                                                                                if (count > 0) {
                                                                        let percentage = ((total / (count * 2)) * 100).toFixed(2);
                                                                                document.getElementById("safetyPercentage").value = percentage + " %";
                                                                        } else {
                                                                        document.getElementById("safetyPercentage").value = "0 %";
                                                                        }
                                                                        });</script>

                                                        </div>
                                                    </c:if>
                                                    <c:if test="${!empty generalList || !empty hrList || !empty saftyList || !empty itList}"> 
                                                        <br>                                    
                                                    <table class="bottom-table">
                                                        <thead>
                                                            <tr class="table-title">
                                                                <td colspan="7" style="font-weight: bold; background-color: skyblue;">OVERALL TOTAL PERCENTAGE</td>
                                                            </tr>
                                                            <tr style="">
                                                                <th>Total Percentage</th>
                                                                <th>Percentage</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <td>Total Percentage</td>
                                                                <td><input type="text" id="overallTotalPercentage" readonly="true" class="input-field"></td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                    </c:if>

                                                    <script>
                                                                document.addEventListener("DOMContentLoaded", function () {
                                                                function getPercentageValue(id) {
                                                                var el = document.getElementById(id);
                                                                        if (el && el.value) {
                                                                var val = el.value.replace('%', '').trim();
                                                                        var num = parseFloat(val);
                                                                        if (!isNaN(num)) {
                                                                return num;
                                                                }
                                                                }
                                                                return null;
                                                                }


                                                                setTimeout(function () {
                                                                var tech = getPercentageValue("technicalPercentage");
                                                                        var hr = getPercentageValue("hrPercentage");
                                                                        var it = getPercentageValue("itPercentage");
                                                                        var safety = getPercentageValue("safetyPercentage");
                                                                        var total = 0;
                                                                        var count = 0;
                                                                        if (tech !== null) { total += tech; count++; }
                                                                if (hr !== null) { total += hr; count++; }
                                                                if (it !== null) { total += it; count++; }
                                                                if (safety !== null) { total += safety; count++; }

                                                                var overall = 0;
                                                                        if (count > 0) {
                                                                overall = (total / count).toFixed(2);
                                                                }

                                                                var overallInput = document.getElementById("overallTotalPercentage");
                                                                        if (overallInput) {
                                                                overallInput.value = overall + " %";
                                                                }
                                                                }, 500);
                                                                });
                                                    </script>

                                                    <br>

                                                    

                                                    <table class="bottom-table" id="" class="table table-bordered table-striped table-hover" align="Center">
                                                        <thead>
                                                            <tr class="table-title">
                                                                <td colspan="8" style="font-weight: bold; background-color: skyblue;">COMPANY DETAILS</td>
                                                            </tr>
                                                            <tr style="">
                                                                <th colspan="3">Company</th>
                                                                <th colspan="3">Purchasing Organization</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach var="companyList" items="${companyList}" >
                                                                <tr id="companyRow1">
                                                                    <td colspan="3">${companyList.vendorCompanyName}</td>
                                                                    <td colspan="3">${companyList.vendorPO}</td>
                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                        <thead>
                                                            <tr class="table-title">
                                                                <td colspan="7" style="font-weight: bold; background-color: skyblue;">SAP DETAILS</td>
                                                            </tr>
                                                            <tr style="">
                                                                <th colspan="2">Currency</th>
                                                                <th colspan="2">BP Group</th>
                                                                <th colspan="2">Search Term</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <td colspan="2">${list.currency}</td>
                                                                <td colspan="2">${list.bpGroup}</td>
                                                                <td colspan="2">${list.searchTerm1}</td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                    <br>

                                                    <div class="table-responsive">
                                                        <table class="bottom-table">
                                                            <thead>
                                                                <tr class="table-title">
                                                    <td colspan="3" style="font-weight: bold; background-color: skyblue;">FINANCIAL STATEMENT (PROFIT AND LOSS / BALANCE SHEET)</td>
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
                                                                        <c:if test="${vendorInformation1.finicalAttachment1!=null && not empty vendorInformation1.finicalAttachment1}">                                        
                                                                            <span class="file-wrapper">
                                                                                <span class="file-name text-break">${vendorInformation1.finicalAttachment1}</span>
                                                                                <span class="file-actions">
                                                                                    <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.finicalAttachment1}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.finicalAttachment1}"><span class="fa fa-solid fa-eye"></span></a>
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
                                                                        <c:if test="${vendorInformation1.finicalAttachment2!=null && not empty vendorInformation1.finicalAttachment2}">                                        
                                                                            <span class="file-wrapper">
                                                                                <span class="file-name text-break">${vendorInformation1.finicalAttachment2}</span>
                                                                                <span class="file-actions">
                                                                                    <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.finicalAttachment2}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.finicalAttachment2}"><span class="fa fa-solid fa-eye"></span></a>
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
                                                                        <c:if test="${vendorInformation1.finicalAttachment3!=null && not empty vendorInformation1.finicalAttachment3}">                                        
                                                                            <span class="file-wrapper">
                                                                                <span class="file-name text-break">${vendorInformation1.finicalAttachment3}</span>
                                                                                <span class="file-actions">
                                                                                    <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.finicalAttachment3}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.finicalAttachment3}"><span class="fa fa-solid fa-eye"></span></a>
                                                                                </span>
                                                                            </span>
                                                                        </c:if>		
                                                                    </td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                    <br>
                                                    <table  class="bottom-table"  id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <thead>
                                                            <tr class="table-title">
                                                                <td colspan="7" style="font-weight: bold; background-color: skyblue;">EXTERNAL VENDOR DETAILS</td>
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
                                                    <c:if test="${list.auditorAttachment!=null && not empty list.auditorAttachment && not empty list.riskBand}">                                        
                                                        <br>
                                                        <div class="table-responsive">
                                                            <table class="table table-bordered custom-table mb-3" id="policyTable" style="width:100%;">                                                        
                                                                <thead >
                                                                    <tr class="table-title">
                                                                        <td colspan="8" style="font-weight: bold; background-color: skyblue;">
                                                                            <c:if test="${list.riskCategory=='medium'}">
                                                                                Internal Auditor Details
                                                                            </c:if>
                                                                            <c:if test="${list.riskCategory=='high'}">
                                                                                Risk Evaluator Details
                                                                            </c:if>
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <th style="">Attachment</th>
                                                                        <td style="">
                                                                            <c:if test="${vendorInformation1.auditorAttachment!=null && not empty vendorInformation1.auditorAttachment}">                                        
                                                                                <span class="file-wrapper">
                                                                                    <span class="file-name text-break">${vendorInformation1.auditorAttachment}</span>
                                                                                    <span class="file-actions">
                                                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.auditorAttachment}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.auditorAttachment}"><span class="fa fa-solid fa-eye"></span></a>
                                                                                    </span>
                                                                                </span>
                                                                            </c:if>
                                                                        </td>
                                                                        <th style="">Band</th>
                                                                        <td style="">${list.riskBand}</td>
                                                                    </tr>
                                                                </thead>

                                                            </table>
                                                        </div>
                                                    </c:if>
                                                </c:forEach>


                                                <br>
                                                
                                               

                                                <c:if test="${not empty vendorInformation1.specialComment or not empty vendorInformation1.specialAttachment}">
                                                    <table class="bottom-table" id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                        <thead>
                                                            <tr class="table-title">
                                                                <td colspan="7" style="font-weight: bold; background-color: skyblue;">COMPLIANCE OFFICER</td>
                                                            </tr>
                                                            <tr style="">
                                                                <th>Special Approval Comment</th>
                                                                <th>Special Approval Attachment</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <td>${vendorInformation1.specialComment}</td>
                                                                <td>
                                                                    <c:if test="${vendorInformation1.specialAttachment!=null && not empty vendorInformation1.specialAttachment}">                                        
                                                                        <span class="file-wrapper">
                                                                            <span class="file-name text-break">${vendorInformation1.specialAttachment}</span>
                                                                            <span class="file-actions">
                                                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.specialAttachment}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.specialAttachment}"><span class="fa fa-solid fa-eye"></span></a>
                                                                            </span>
                                                                        </span>
                                                                    </c:if>	
                                                                </td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </c:if>

                                          
                                                
                                                <tr>
                                                    <td style="width:20%; vertical-align: top; padding-top:10px;">
                                                        Comment <span class="text-danger">*</span>
                                                    </td>

                                                    <td style="width:80%;">
                                                        <textarea name="comment" id="comment" style="text-transform: uppercase;" class="textarea-field comment" maxlength="250" style="height:80px; resize:none;" required></textarea>
                                                        
                                                        <small id="charCount_comment" style="font-size:12px; color:green;">
                                                            250 characters remaining
                                                        </small>

                                                        <script type="text/javascript">
                                                            document.addEventListener("DOMContentLoaded", function () {
                                                                var textarea = document.getElementById("comment");
                                                                var counter = document.getElementById("charCount_comment");
                                                                var maxChars = 250;

                                                                function updateCounter() {
                                                                    var count = textarea.value.length;
                                                                    var remaining = maxChars - count;
                                                                    counter.textContent = remaining + " characters remaining";

                                                                    if (remaining <= 20) {
                                                                        counter.style.color = "red";
                                                                    } else {
                                                                        counter.style.color = "green";
                                                                    }
                                                                }

                                                                updateCounter(); 
                                                                textarea.addEventListener("input", updateCounter);
                                                            });
                                                        </script>
                                                    </td>
                                                </tr>

                                                <br>
                                                <div class="form-group">
                                                    <div style="display: flex;  justify-content: center;">
                                                        <button type="submit" id="approveBtn" class="btn theme-btn mr-3" style="width: 100px;" title="" value="">Approve</button>
                                                        <button type="submit" id="rejectBtn" class="btn theme-btn recycle-btn mr-3" style="width: 120px!important; " formaction="vendorInformation.htm?act=complianceOfficerReject&id=${checkId}" title="" value="">Reject</button>
                                                        <button type="button" class="btn theme-btn mr-3" style="" value="" id="btnSpecialApproval">Special Approval</button>
                                                        <button type="submit" id="recycleBtn" class="btn theme-btn recycle-btn mr-3" formaction="vendorInformation.htm?act=complianceOfficerRecycle&id=${checkId}" title="" value="">Recycle</button>
                                                    </div>
                                                </div>
                                                <div id="specialApprovalSection" style="display:none; margin-top:15px; width:100%;">

                                                    <div style="width:100%;">

                                                        <div style="display:flex; align-items:flex-start; margin-bottom:15px;">
                                                            <label for="specialComment" style="width:20%; font-weight:bold; padding-top:10px;">
                                                                Comment <span class="text-danger">*</span>
                                                            </label>
                                                            <div style="width:80%;">
                                                                <textarea name="specialComment"id="specialComment" style="text-transform: uppercase;" class="textarea-field comment" placeholder="Enter comment" style="width:100%; height:80px; resize:none;" required></textarea>
                                                            </div>
                                                        </div>

                                                        <div style="display:flex; align-items:center;">
                                                            <label for="specialAttachment" style="width:20%; font-weight:bold;">
                                                                Attachment <span class="text-danger">*</span>
                                                            </label>
                                                            <div style="width:80%;">
                                                                <input type="file" name="specialAttachment" id="specialAttachment" class="input-field" required/>
                                                                <input type="hidden" name="specialAttachment" id="specialAttachment" class="input-field"/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <br>
                                                    <div style="width:100%; display:flex; justify-content:center;">
                                                        <button style="" type="button" id="btnSubmitSpecial"  class="btn theme-btn mr-3">
                                                            Submit Special Approval
                                                        </button>
                                                    </div>

                                                </div>
                                                        <br>
                                                        <table  class="bottom-table"  id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
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
                                                
<script>
        document.getElementById("approveBtn").addEventListener('click', function () {
            const specialComment = document.getElementById("specialComment");
            specialComment.removeAttribute('required');
            const specialAttachment = document.getElementById("specialAttachment");
            specialAttachment.removeAttribute('required');
        });   
        document.getElementById("rejectBtn").addEventListener('click', function () {
            const specialComment = document.getElementById("specialComment");
            specialComment.removeAttribute('required');
            const specialAttachment = document.getElementById("specialAttachment");
            specialAttachment.removeAttribute('required');
        });   
        document.getElementById("recycleBtn").addEventListener('click', function () {
            const specialComment = document.getElementById("specialComment");
            specialComment.removeAttribute('required');
            const specialAttachment = document.getElementById("specialAttachment");
            specialAttachment.removeAttribute('required');
        });   
    </script>
<script>
    $(document).ready(function () {

        $("#btnSpecialApproval").click(function (e) {
            e.preventDefault();
            $("#specialApprovalSection").show();
        });

        $("#btnSubmitSpecial").click(function () {

            var comment = $("#specialComment").val();
            var attachment = $("#specialAttachment").val();

            if (comment.trim() === "") {
                alert("Please enter a comment before submitting!");
                return;
            }
            if (attachment.trim() === "") {
                alert("Please enter a attachment before submitting!");
                return;
            }

            $("form").attr("action", "vendorInformation.htm?act=SpecialApproval&id=${checkId}");

            $("form").submit();

        });

    });
</script>

                </form:form>
            </section>
        </main>
        <script>
            function toggleRemark(radio) {
            const container = radio.closest('td');
                    const remarkBox = container.querySelector('.remark-box');
                    if (radio.value === 'reject') {
            remarkBox.style.display = 'block';
            } else {
            remarkBox.style.display = 'none';
            }

            const rejectSelected = document.querySelectorAll('input[type="radio"][value="reject"]:checked').length > 0;
                    document.getElementById('submit1').disabled = rejectSelected;
            }
        </script>
    </body>


    <!--<script src="StorageYard/assets/js/TableScript/commonTableScript.js" type="text/javascript"></script>-->

    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>


