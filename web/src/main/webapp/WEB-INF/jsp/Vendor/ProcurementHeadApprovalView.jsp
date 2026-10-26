<%-- 
    Document   : ProcurementHeadApprovalView
    Created on : 16 Oct, 2025, 03:52:57 PM
    Author     : fnp
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

    <head>
        <title>Procurement Head Approval View</title>

    </head>

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

        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">

            <section id="printSection" class="main-content">
                <form:form action="vendorInformation.htm?act=ButtonProcurementHeadApprovals"  enctype="multipart/form-data" method="post"
                           name='form' class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">Procurement Head Approval View</h5>                            
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>                                               
                        </div>
                    </div>
                    <hr>
                   

                    <c:forEach var="list" items="${list}" varStatus="status">
                        <input type="hidden" id="id" name="id" value="${list.id}">
                        <input type="hidden" id="id1" name="id1" value="${list.id}">

                        <table class="table table-bordered custom-table mb-3" style="width:100%;">                                                        <thead> 
                            <thead>
                                <tr class="table-title">
                                     <td colspan="3" style="font-weight: bold; background-color: skyblue; text-align: center;">VENDOR DETAILS</td>
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
                                    <th  style="">Type of Company</th>
                                    <td>${list.typeOfConcern}</td>
                                    <c:choose>
                                        <c:when test="${list.typeOfConcern == 'Sole Proprietorship'}">
                                            <th  style="">
                                                Shop & Establishment License
                                            </th>
                                        </c:when>

                                        <c:when test="${list.typeOfConcern == 'Hindu Undivided Family ( HUF)'}">
                                            <th  style="">
                                                Shop & Establishment License and HUF Deed
                                            </th>
                                        </c:when>

                                        <c:when test="${list.typeOfConcern == 'Partnership Firm'}">
                                            <th  style="">
                                                1. Shop & Establishment License and Partnership Deed
                                            </th>
                                        </c:when>

                                        <c:when test="${list.typeOfConcern == 'Limited Liability Partnership ( LLP)'}">
                                            <th  style="">
                                                1. Shop & Establishment License and LLP Agreement
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
                                    <th style="">Risk Category</th>
                                    <td class="riskCategory">${list.riskCategory}</td>
                                </tr>
                            </tbody>
                        </table>
                         

                        <div class="table-responsive">
                            <table class="table table-bordered custom-table mb-3"  style="width:100%;">                                                        
                                <thead>
                                    <tr class="table-title">
									  <td colspan="8" style="font-weight: bold; background-color: skyblue; text-align: center; ">REGISTER ADDRESS </td>
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
                        <div class="table-responsive">
                            <table class="table table-bordered custom-table mb-3" id="" style="width:100%;">                                                        <thead> 
                                <thead>
                                    <tr class="table-title">
									  <td colspan="8" style="font-weight: bold; background-color: skyblue;  text-align: center; ">COMMUNICATION ADDRESS </td>
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

                        <table class="table table-bordered custom-table mb-3" id="table_1" style="width:100%;">                                                        <thead> 
                            <tr class="table-title">
									  <td colspan="3" style="font-weight: bold; background-color: skyblue;  text-align: center; ">TYPES OF VENDORS </td>
                            </tr>
                            <c:forEach var="list222" items="${list222}" varStatus="status">

                                <tr>
                                <input type="hidden" class="form-control" id="groupId" name="groupId" value="${list222[2]}<" />
                                <td>${list222[2]}</td>
                                <td>${list222[3]}</td>
                                <td>${list222[4]}</td>
                                </tr>
                            </c:forEach>
                        </table>

                        <div class="table-responsive">
                            <table class="table table-bordered custom-table mb-3" id="table_1" style="width:100%;">                                                        <thead> 
                                <thead <tr class="table-title">
									  <td colspan="7" style="font-weight: bold; background-color: skyblue; text-align: center; ">VENDORS CONTACTS </td>
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
                        <div class="table-responsive">
                            <table class="table table-bordered custom-table mb-3" id="" style="width:100%;">                                                        <thead> 
                                <thead>
                                    <tr class="table-title">
									  <td colspan="7" style="font-weight: bold; background-color: skyblue; text-align: center;">MANAGERIAL PERSON DETAILS</td>
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
                        <div class="table-responsive">
                            <table class="table table-bordered custom-table mb-3" id="" style="width:100%;">                                                        <thead> 
                                <thead>
                                    <tr class="table-title">
									  <td colspan="5" style="font-weight: bold; background-color: skyblue; text-align: center;">  PAST WORKING EXPERIENCE DETAILS </td>
                                        <td style="font-weight: bold; background-color: skyblue;">
                                            All Attachments <a href="vendorInformation.htm?act=pastWorkingExpDetailsDocxdownloadzip&id1=${vendorInformation1.id}" style="text-decoration: none; color: black; font-size: 16px;">
                                                &nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                            </a>
                                        </td>
                                    </tr>
                                    <th>Company Name</th>
                                    <th>Contact Person Name</th>
                                    <th>Phone No.</th>
                                    <th>Email</th>
                                    <th>Designation</th>
                                    <th>Attachment</th>
                                </thead>
                                <tbody>
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


                        <table class="table table-bordered custom-table mb-3" id="" style="width:100%;">                                                        <thead> 
                            <thead>
                                <tr class="table-title">
									  <td colspan="7" style="font-weight: bold; background-color: skyblue; text-align: center;">SELF DECLARATION FORM </td>
                                </tr>
                                <tr style="">
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
                            <table class="table table-bordered custom-table mb-3" id="" style="width:100%;">                                                        <thead> 
                                <thead >
                                    <tr class="table-title">
									  <td colspan="3" style="font-weight: bold; background-color: skyblue; text-align: center;">COMPANY REGISTRATION DETAILS </td>
                                        <td style="font-weight: bold; background-color: skyblue;">
                                            All Attachments <a href="vendorInformation.htm?act=companyRegDetailsDocxdownloadzip&id1=${vendorInformation1.id}" style="text-decoration: none; color: black; font-size: 16px;">
                                                &nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                            </a>
                                        </td>
                                    </tr>                                                            
                                </thead>
                                <tbody>
                                    <tr>
                                        <th style="width: 20%;">GST No.</th>
                                        <td>                                                        
                                            ${vendorInformation1.gstinNo}<br>
                                            <c:if test="${vendorInformation1.gstinFile!=null && not empty vendorInformation1.gstinFile}">                                        
                                                <span class="file-wrapper">
                                                    <span class="file-name text-break">${vendorInformation1.gstinFile}</span>
                                                    <span class="file-actions">
                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.gstinFile}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.gstinFile}"><span class="fa fa-solid fa-eye"></span></a>
                                                    </span>
                                                </span>
                                            </c:if>

                                        </td>                                                    
                                        <th style="width: 20%;">PAN No</th>
                                        <td>                                                    
                                            ${vendorInformation1.panNo}<br>
                                            <c:if test="${vendorInformation1.panFile!=null && not empty vendorInformation1.panFile}">                                        
                                                <span class="file-wrapper">
                                                    <span class="file-name text-break">${vendorInformation1.panFile}</span>
                                                    <span class="file-actions">
                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.panFile}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.panFile}"><span class="fa fa-solid fa-eye"></span></a>
                                                    </span>
                                                </span>
                                            </c:if>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="width: 20%;">MSME No</th>
                                        <td>
                                            <c:if test="${vendorInformation1.msmeStatus=='0'}"><strong>MSME Not
                                                    Available</strong></c:if>
                                            ${vendorInformation1.service_tax}<br>
                                            <c:if test="${vendorInformation1.service_file!=null && not empty vendorInformation1.service_file}">                                        
                                                <span class="file-wrapper">
                                                    <span class="file-name text-break">${vendorInformation1.service_file}</span>
                                                    <span class="file-actions">
                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.service_file}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.service_file}"><span class="fa fa-solid fa-eye"></span></a>
                                                    </span>
                                                </span>
                                            </c:if>
                                        </td>
                                        <th style="width: 20%;">ESIC No</th>
                                        <td>
                                            <c:if test="${vendorInformation1.esicStatus=='0'}"><strong>ESIC Not
                                                    Available</strong></c:if>
                                            ${vendorInformation1.esicNo}<br>
                                            <c:if test="${vendorInformation1.esicFile!=null && not empty vendorInformation1.esicFile}">                                        
                                                <span class="file-wrapper">
                                                    <span class="file-name text-break">${vendorInformation1.esicFile}</span>
                                                    <span class="file-actions">
                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.esicFile}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.esicFile}"><span class="fa fa-solid fa-eye"></span></a>
                                                    </span>
                                                </span>
                                            </c:if>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="width: 20%;">EPFO No.</th>
                                        <td>
                                            <c:if test="${vendorInformation1.epfoStatus=='0'}"><strong>EPFO Not
                                                    Available</strong></c:if>
                                            ${vendorInformation1.pfNo}<br>
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
                                            <c:if test="${vendorInformation1.eccStatus == '0'}"><strong>ECC Not
                                                    Available</strong></c:if>
                                            ${vendorInformation1.ecc_no}<br>
                                            <c:if test="${vendorInformation1.ecc_file!=null && not empty vendorInformation1.ecc_file}">                                        
                                                <span class="file-wrapper">
                                                    <span class="file-name text-break">${vendorInformation1.ecc_file}</span>
                                                    <span class="file-actions">
                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.ecc_file}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.ecc_file}"><span class="fa fa-solid fa-eye"></span></a>
                                                    </span>
                                                </span>
                                            </c:if>
                                        </td>                                                    
                                    </tr>
                                </tbody>
                            </table>
                        </div>

                        <div class="table-responsive">
                            <table class="table table-bordered custom-table mb-3" id="" style="width:100%;">      
                                <thead> 
                                    <tr class="table-title">
                                        <td colspan="7" style="font-weight: bold; background-color: skyblue; text-align: center;">BANK DETAILS</td>
                                    </tr>
                                    <tr>
                                        <th  style="">Account Number</th>
                                        <td>${vendorInformation1.accountNumber}</td>
                                        <th style="">Bank Name </th>
                                        <td>${vendorInformation1.bankName}</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th style="">Branch</th>
                                        <td>${vendorInformation1.branch}</td>
                                        <th style="">IFSC Code</th>
                                        <td>${vendorInformation1.ifscCode}</td>

                                    </tr>
                                    <tr>
                                        <th style="">Swift Code (if any) </th>
                                        <td> ${vendorInformation1.swiftCode}</td>
                                        <th style="">Cancel Cheque </th>
                                        <td>  
                                            <c:if test="${vendorInformation1.cancelCheck!=null && not empty vendorInformation1.cancelCheck}">                                        
                                                <span class="file-wrapper">
                                                    <span class="file-name text-break">${vendorInformation1.cancelCheck}</span>
                                                    <span class="file-actions">
                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.cancelCheck}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.cancelCheck}"><span class="fa fa-solid fa-eye"></span></a>
                                                    </span>
                                                </span>
                                            </c:if>
                                        </td>
                                    </tr>

                                </tbody>
                            </table>
                        </div>

                        <div class="table-responsive">
                            <table class="table table-bordered custom-table mb-3" id="" style="width:100%;">
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
                                        <td>${vendorInformation1.finical1}</td>
                                        <td>${vendorInformation1.finicalAmount1}</td>
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
                                        <td>${vendorInformation1.finical2}</td>
                                        <td>${vendorInformation1.finicalAmount2}</td>
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
                                        <td>${vendorInformation1.finical3}</td>
                                        <td>${vendorInformation1.finicalAmount3}</td>
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

                        <table class="table table-bordered custom-table mb-3" id="" style="width:100%;">                                                       
                            <thead> 
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
                                    <td>${vendorInformation1.email1}</td>
                                    <td>${vendorInformation1.email2}</td>
                                    <td>${vendorInformation1.email3}</td>
                                </tr>
                            </tbody>
                        </table>
                        <br>
                    </c:forEach>

                        <c:if test="${vendorInformation1.auditorAttachment!=null && not empty vendorInformation1.auditorAttachment && !empty vendorInformation1.riskBand}">                                        
                            <table class="table table-bordered custom-table mb-3" id="" style="width:100%;">                                                       
                                <thead>
                                    <tr class="table-title">
                                        <td colspan="7" style="font-weight: bold; background-color: skyblue;text-align: center;">
                                            <c:forEach var="list" items="${list}" varStatus="status">
                                                <c:if test="${list.riskCategory=='medium'}">
                                                    INTERNAL AUDITOR APPROVAL 
                                                </c:if>
                                                <c:if test="${list.riskCategory=='high'}">
                                                    RISK EVALUATOR APPROVAL 
                                                </c:if>
                                            </c:forEach>
                                        </td>
                                    </tr>
                                    <tr style="">
                                        <th>Attachment</th>
                                        <th>Risk Band</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>
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
                                        <td>${vendorInformation1.riskBand}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </c:if>
                

                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-12 col-md-6">
                                <div class="form-group comment-box">
                                    <label class="control-label">Procurement Head Comment :<span class="text-danger">*</span></label>
                                    <textarea type="text" name="comment" id="comment"  class="textarea-field comment"style="text-transform: uppercase;" maxlength="250"  required></textarea>                                   
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="cta d-flex align-items-center justify-content-center">
                        <button type="submit" class="btn theme-btn mr-3">Accept</button>
                        <button type="submit" class="btn theme-btn recycle-btn mr-3" formaction="vendorInformation.htm?act=RecycleProcurementHeadApproval">Recycle</button>
                        <button type="submit" class="btn theme-btn recycle-btn" formaction="vendorInformation.htm?act=RejectVendorProcurementHead">Reject</button>                                
<!--                        <script>
                            function recycle() {
                                var id = document.getElementsByName('id1');
                                y = id[0].value;
                                var comment = document.getElementsByName('comment');
                                comment1 = comment[0].value;
                                window.location = 'vendorInformation.htm?act=RecycleProcurementHeadApproval&id=' + y + '&comment=' + comment1;
                            }
                            function reject() {
                                var id = document.getElementsByName('id1');
                                y = id[0].value;
                                var comment = document.getElementsByName('comment');
                                comment1 = comment[0].value;
                                window.location = 'vendorInformation.htm?act=RejectVendorProcurementHead&id=' + y + '&comment=' + comment1;
                            }
                        </script>-->
                    </div>
                    <br>
                    <c:if test="${!empty vendorApproval}">
                         <table class="table table-bordered custom-table mb-3" id="" style="width:100%;">                                                        <thead> 
                            <thead>
                                <tr class="table-title">
									  <td colspan="7" style="font-weight: bold; background-color: skyblue; text-align: center;">APPROVAL HISTORY</td>
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

                </form:form>
            </section>
        </main> 
    </body>


    <!--<script src="StorageYard/assets/js/TableScript/commonTableScript.js" type="text/javascript"></script>-->

    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>


