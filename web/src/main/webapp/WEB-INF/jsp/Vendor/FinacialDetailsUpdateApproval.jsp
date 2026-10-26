<%-- 
    Document   : FinacialDetailsUpdateApproval
    Created on : Jul 22, 2026, 1:47:30 PM
    Author     : Sumanth
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

    <head>
        <title>Financial Details Updated Details</title>
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
            @media print{
                a[href]:after{
                    content :none !important;
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
    </head>

    <body>

        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">

            <section id="printSection" class="main-content">
                <form:form action="vendorInformation.htm?act=finalFinanceApprovals"  enctype="multipart/form-data" method="post"
                           name='form' class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">Financial Details Updated Details</h5>
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

                    <c:forEach var="list" items="${list}" varStatus="status">
                        <input type="hidden" id="id" name="id" value="${list.id}">
                        <input type="hidden" id="id1" name="id1" value="${list.id}">

                        <table  class="bottom-table"  id="" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <thead>
                                <tr class="table-title">
                                     <td colspan="3" style="font-weight: bold; background-color: skyblue; text-align: center;">VENDOR DETAILS</td>
                                    <td style="font-weight: bold; background-color: skyblue;">
                                        All Attachments <a  href="vendorInformation.htm?act=vendorDetailsDocxdownloadzip&id1=${list.id}" style="text-decoration: none; color: black; font-size: 16px;">
                                            &nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                        </a>
                                    </td>
                                </tr>
                                <tr>
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
                                    <th style=""></th>
                                    <td></td>
                                </tr>
                            </tbody>
                        </table>
                        <br>

                        <table class="bottom-table" id="" align="Center">
                            <tr class="table-title">
                                									  <td colspan="3" style="font-weight: bold; background-color: skyblue;  text-align: center; ">TYPES OF VENDORS </td>

                            </tr>

                            <tr>
                                <th style="">Group Name</th> 
                                <th style="">Group Category Name</th> 
                                <th style="" colspan="2">Group Sub-Category Name</th> 
                            </tr>

                            <c:forEach var="list222" items="${list222}" varStatus="status">
                                <input type="hidden" class="input-field" id="groupId" name="groupId" value="${list222[2]}<" />
                                <tr>
                                    <td>${list222[2]}</td>
                                    <td>${list222[3]}</td>
                                    <td colspan="2">${list222[4]}</td>                                            
                                </tr>
                            </c:forEach>
                        </table>
                        <br>
                                                                
                        <div class="table-responsive">
                            <table class="bottom-table" id="" class="table table-bordered table-striped table-hover" align="Center">
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
                        <br>  
                        <div class="table-responsive">
                            <table class="bottom-table" id="" align="Center">
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
                        <br>
                        <div class="table-responsive">
                            <table class="bottom-table"  class="table table-bordered table-striped table-hover" align="Center">
                                <thead>
                                    <tr class="table-title">
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
                        <br>
                        <div class="table-responsive">
                            <table class="bottom-table" id="" class="table table-bordered table-striped table-hover" align="Center">
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
                        <br>
                        <div class="table-responsive">
                            <table class="bottom-table" id="" class="table table-bordered table-striped table-hover" align="Center">
                                <thead>
                                    <tr class="table-title">
                                        <td colspan="5" style="font-weight: bold; background-color: skyblue; text-align: center;">  PAST WORKING EXPERIENCE DETAILS </td>
                                        <td style="font-weight: bold; background-color: skyblue;">
                                            All Attachments <a  href="vendorInformation.htm?act=pastWorkingExpDetailsDocxdownloadzip&id1=${list.id}" style="text-decoration: none; color: black; font-size: 16px;">
                                                &nbsp;&nbsp;&nbsp; <span class="fa fa-download"></span>
                                            </a>
                                        </td>
                                    </tr>
                                <th>Company Name</th>
                                <th>Contact Person Name</th>
                                <th>Phone No.</th>
                                <th>Email</th>
                                <th>Designation</th>
                                <th>UnPriced PO / Work Complition Certificate</th>
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
                        <br>
                        <table class="bottom-table">
                            <thead>
                                <tr class="table-title">
									  <td colspan="7" style="font-weight: bold; background-color: skyblue; text-align: center;">SELF DECLARATION FORM </td>
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

                        <br>
                        <div class="table-responsive">
                            <table class="bottom-table" class="table table-bordered table-striped table-hover" align="Center">
                                <thead>
                                    <tr class="table-title">
				 <td colspan="4" style="font-weight: bold; background-color: skyblue; text-align: center;">COMPANY REGISTRATION DETAILS </td>
                                        <td style="font-weight: bold; background-color: skyblue;">
                                            All Attachments <a href="vendorInformation.htm?act=companyRegDetailsDocxdownloadzip&id1=${list.id}" style="text-decoration: none; color: black; font-size: 16px;">
                                                &nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                            </a>
                                        </td>
                                    </tr>
                                    <tr style="">
                                        <th style="width: 20%;">Name of Document</th>
                                        <th style="width: 20%;">Document No.</th>
                                        <th style="width: 20%;">Document</th>
                                        <th style="width: 20%;">Accept/Reject</th>
                                        <th style="width: 20%;">Response</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>GST</td>
                                        <td><c:if test="${list.gstStatus=='0'}"><strong>GST Not Available</strong></c:if>${list.gstinNo}</td>
                                        <td>
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
                                        <td>
                                            <label><input required type="radio" name="gstStatus" value="accept" onclick="toggleRemark(this)" <c:if test="${vendorFinancialApprovalDetails.gstStatus=='accept'}">checked</c:if>> Accept</label>
                                            <label><input required type="radio" name="gstStatus" value="reject" onclick="toggleRemark(this)" <c:if test="${vendorFinancialApprovalDetails.gstStatus=='reject'}">checked</c:if>> Reject</label>
                                            <div class="remark-box" style="display:none; margin-top:5px;">
                                                <textarea class="textarea-field" name="gstRemark" placeholder="Enter remark" rows="2" cols="30" maxlength="250" required>${vendorFinancialApprovalDetails.gstRemark}</textarea>
                                            </div>                                                                            
                                        </td>
                                        <td>
                                            <c:if test="${vendorFinancialApprovalDetails.gstStatus=='reject'}">
                                                ${vendorFinancialApprovalDetails.gstResponces}
                                            </c:if>
                                        </td>
                                    </tr>                                                                

                                    <tr>
                                        <td>PAN</td>
                                        <td><c:if test="${list.panStatus=='0'}"><strong>PAN Not Available</strong></c:if>${list.panNo}</td>
                                        <td>
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
                                        <td>
                                            <label><input type="radio" required name="panStatus" value="accept" onclick="toggleRemark(this)" <c:if test="${vendorFinancialApprovalDetails.panStatus=='accept'}">checked</c:if>>Accept</label>
                                            <label><input type="radio" required name="panStatus" value="reject" onclick="toggleRemark(this)" <c:if test="${vendorFinancialApprovalDetails.panStatus=='reject'}">checked</c:if>>Reject</label>
                                            <div class="remark-box" style="display:none; margin-top:5px;">
                                                <textarea class="textarea-field" name="panRemark" placeholder="Enter remark" rows="2" cols="30" maxlength="250" required>${vendorFinancialApprovalDetails.panRemark}</textarea>
                                            </div>                                                                            
                                        </td>
                                        <td>
                                            <c:if test="${vendorFinancialApprovalDetails.panStatus=='reject'}">
                                                ${vendorFinancialApprovalDetails.panResponces}
                                            </c:if>
                                        </td>
                                    </tr>                                                            

                                    <tr>
                                        <td>MSME</td>
                                        <td><c:if test="${list.msmeStatus=='0'}"><strong>MSME Not Available</strong></c:if>${list.service_tax}</td>
                                        <td>
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
                                        <td>
                                            <label><input type="radio" required name="msmeStatus" value="accept" onclick="toggleRemark(this)" <c:if test="${vendorFinancialApprovalDetails.msmeStatus=='accept'}">checked</c:if>>Accept</label>
                                            <label><input type="radio" required name="msmeStatus" value="reject" onclick="toggleRemark(this)" <c:if test="${vendorFinancialApprovalDetails.msmeStatus=='reject'}">checked</c:if>>Reject</label>
                                            <div class="remark-box" style="display:none; margin-top:5px;">
                                                <textarea class="textarea-field" name="msmeRemark" placeholder="Enter remark" rows="2" cols="30" maxlength="250" required>${vendorFinancialApprovalDetails.msmeRemark}</textarea>
                                            </div>                                                                            
                                        </td>
                                        <td>
                                            <c:if test="${vendorFinancialApprovalDetails.msmeStatus=='reject'}">
                                                ${vendorFinancialApprovalDetails.msmeResponces}
                                            </c:if>
                                        </td>
                                    </tr>                                                         

                                    <tr>
                                        <td>ESIC</td>
                                        <td><c:if test="${list.esicStatus == '0'}"><strong>ESIC Not Available</strong></c:if>${list.esicNo}</td>
                                        <td>
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
                                        <td>
                                            <label><input type="radio" required name="esicStatus" value="accept" onclick="toggleRemark(this)" <c:if test="${vendorFinancialApprovalDetails.esicStatus=='accept'}">checked</c:if>>Accept</label>
                                            <label><input type="radio" required name="esicStatus" value="reject" onclick="toggleRemark(this)" <c:if test="${vendorFinancialApprovalDetails.esicStatus=='reject'}">checked</c:if>>Reject</label>
                                            <div class="remark-box" style="display:none; margin-top:5px;">
                                                <textarea class="textarea-field" name="esicRemark" placeholder="Enter remark" rows="2" cols="30" maxlength="250" required>${vendorFinancialApprovalDetails.esicRemark}</textarea>
                                            </div>                                                                            
                                        </td>
                                        <td>
                                            <c:if test="${vendorFinancialApprovalDetails.esicStatus=='reject'}">
                                                ${vendorFinancialApprovalDetails.esicResponce}
                                            </c:if>
                                        </td>

                                    </tr>
                                    <tr>
                                        <td>EPFO</td>
                                        <td><c:if test="${list.epfoStatus == '0'}"><strong>EPFO Not Available</strong></c:if>${list.pfNo}</td>
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
                                            <label><input type="radio" required name="epfoStatus" value="accept" onclick="toggleRemark(this)" <c:if test="${vendorFinancialApprovalDetails.epfoStatus=='accept'}">checked</c:if>>Accept</label>
                                            <label><input type="radio" required name="epfoStatus" value="reject" onclick="toggleRemark(this)" <c:if test="${vendorFinancialApprovalDetails.epfoStatus=='reject'}">checked</c:if>>Reject</label>
                                            <div class="remark-box" style="display:none; margin-top:5px;">
                                                <textarea class="textarea-field" name="epfoRemark" placeholder="Enter remark" rows="2" cols="30" maxlength="250" required>${vendorFinancialApprovalDetails.epfoRemark}</textarea>
                                            </div>                                                                            
                                        </td>
                                        <td>
                                            <c:if test="${vendorFinancialApprovalDetails.epfoStatus=='reject'}">
                                                ${vendorFinancialApprovalDetails.epfoResponces}
                                            </c:if>
                                        </td>

                                    </tr>

                                    <tr>
                                        <td>Import Export Code</td>
                                        <td><c:if test="${list.eccStatus == '0'}"><strong>ECC Not Available</strong></c:if>${list.ecc_no}</td>
                                        <td>
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
                                        <td>
                                            <c:if test="${list.eccStatus != '0'}">
                                                <label><input type="radio" required name="iecStatus" value="accept" onclick="toggleRemark(this)" <c:if test="${vendorFinancialApprovalDetails.iecStatus=='accept'}">checked</c:if>>Accept</label>
                                                <label><input type="radio" required name="iecStatus" value="reject" onclick="toggleRemark(this)" <c:if test="${vendorFinancialApprovalDetails.iecStatus=='reject'}">checked</c:if>>Reject</label>
                                                <div class="remark-box" style="display:none; margin-top:5px;">
                                                    <textarea class="textarea-field" name="iecRemark" placeholder="Enter remark" rows="2" cols="30" maxlength="250" required>${vendorFinancialApprovalDetails.iecRemark}</textarea>
                                                </div>
                                            </c:if>
                                        </td>
                                       <td>
                                            <c:if test="${list.eccStatus!='0' && vendorFinancialApprovalDetails.iecStatus=='reject'}">
                                                ${vendorFinancialApprovalDetails.iecReponces}
                                            </c:if>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <br>

                        <div class="table-responsive">
                            <table class="bottom-table"  class="table table-bordered table-striped table-hover" align="Center">
                                <thead>
                                    <tr class="table-title">
                                        <td colspan="7" style="font-weight: bold; background-color: skyblue; text-align: center;">BANK DETAILS</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th style="">Account Number</th>
                                        <td>${list.accountNumber}</td>
                                        <th style="">Bank Name </th>
                                        <td>${list.bankName}</td>
                                    </tr>
                                    <tr>
                                        <th style="">Branch</th>
                                        <td>${list.branch}</td>
                                        <th style="">IFSC Code</th>
                                        <td>${list.ifscCode}</td>
                                    </tr>
                                    <tr>
                                        <th style="">Swift Code (if any) </th>
                                        <td> ${list.swiftCode}</td>
                                        <th style=""></th>
                                        <td></td>
                                    </tr>
                                    <tr>
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
                                        <td>                                                                        
                                            <label><input required type="radio" name="cancelCheckStatus" value="accept" onclick="toggleRemark(this)" <c:if test="${vendorFinancialApprovalDetails.cancelCheckStatus=='accept'}">checked</c:if>> Accept</label>
                                            <label><input required type="radio" name="cancelCheckStatus" value="reject" onclick="toggleRemark(this)" <c:if test="${vendorFinancialApprovalDetails.cancelCheckStatus=='reject'}">checked</c:if>> Reject</label>
                                            <div class="remark-box" style="display:none; margin-top:5px;">
                                                <textarea class="textarea-field" name="cancelCheckRemark" placeholder="Enter remark" rows="2" cols="30" maxlength="250">${vendorFinancialApprovalDetails.cancelCheckRemark}</textarea>
                                            </div>
                                        </td>
                                        <td>
                                            <c:if test="${vendorFinancialApprovalDetails.cancelCheckStatus=='reject'}">
                                                ${vendorFinancialApprovalDetails.cancelCheckResponse}
                                            </c:if>
                                        </td>
                                    </tr>

                                </tbody>
                            </table>
                        </div>
                        <br>

                        <div class="table-responsive">
                            <table class="bottom-table">
                                <thead>
                                    <tr class="table-title">
                                        <td colspan="4" style="font-weight: bold; background-color: skyblue; text-align: center">FINANCIAL STATEMENT (PROFIT AND LOSS / BALANCE SHEET)</td>
                                        <td style="font-weight: bold; background-color: skyblue;">
                                            All Attachments <a  href="vendorInformation.htm?act=financialStatementDetailsDocxdownloadzip&id1=${list.id}" style="text-decoration: none; color: black; font-size: 16px;">
                                                &nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                            </a>
                                        </td>
                                    </tr>
                                    <tr style="">
                                        <th>Year</th>
                                        <th>Financial Year</th>
                                        <th>Financial Amount</th>
                                        <th>Financial Attachment</th>
                                        <th>Financial Attachment Response</th>
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
                                            <br />
                                            <label><input required type="radio" name="firstYearStatus" value="accept" onclick="toggleRemark(this)" <c:if test="${vendorFinancialApprovalDetails.firstYearStatus=='accept'}">checked</c:if>>Accept</label>
                                            <label><input required type="radio" name="firstYearStatus" value="reject" onclick="toggleRemark(this)" <c:if test="${vendorFinancialApprovalDetails.firstYearStatus=='reject'}">checked</c:if>>Reject</label>
                                            <div class="remark-box" style="display:none; margin-top:5px;">
                                                <textarea class="textarea-field" name="firstYearRemark" placeholder="Enter remark" rows="2" cols="30" maxlength="250" required>${vendorFinancialApprovalDetails.firstYearRemark}</textarea>
                                            </div>
                                        </td>
                                        <td>
                                            <c:if test="${vendorFinancialApprovalDetails.firstYearStatus=='reject'}">
                                                ${vendorFinancialApprovalDetails.firstYearResponces}
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
                                            <br/>
                                            <label><input required type="radio" name="secondYearStatus" value="accept" onclick="toggleRemark(this)" <c:if test="${vendorFinancialApprovalDetails.secondYearStatus=='accept'}">checked</c:if>>Accept</label>
                                            <label><input required type="radio" name="secondYearStatus" value="reject" onclick="toggleRemark(this)" <c:if test="${vendorFinancialApprovalDetails.secondYearStatus=='reject'}">checked</c:if>>Reject</label>
                                            <div class="remark-box" style="display:none; margin-top:5px;">
                                                <textarea class="textarea-field" name="secondYearRemark" placeholder="Enter remark" rows="2" cols="30" maxlength="250" required>${vendorFinancialApprovalDetails.secondYearRemark}</textarea>
                                            </div>
                                        </td>
                                        <td>
                                            <c:if test="${vendorFinancialApprovalDetails.secondYearStatus=='reject'}">
                                                ${vendorFinancialApprovalDetails.secondYearResponces}
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
                                            <br />
                                            <label><input required type="radio" name="thirdYearStatus" value="accept" onclick="toggleRemark(this)" <c:if test="${vendorFinancialApprovalDetails.thirdYearStatus=='accept'}">checked</c:if>>Accept</label>
                                            <label><input required type="radio" name="thirdYearStatus" value="reject" onclick="toggleRemark(this)" <c:if test="${vendorFinancialApprovalDetails.thirdYearStatus=='reject'}">checked</c:if>>Reject</label>
                                            <div class="remark-box" style="display:none; margin-top:5px;">
                                                <textarea class="textarea-field" name="thirdYearRemark" placeholder="Enter remark" rows="2" cols="30" maxlength="250" required>${vendorFinancialApprovalDetails.thirdYearRemark}</textarea>
                                            </div>
                                        </td>
                                        <td>
                                            <c:if test="${vendorFinancialApprovalDetails.thirdYearStatus=='reject'}">
                                                ${vendorFinancialApprovalDetails.thirdYearResponces}
                                            </c:if>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </c:forEach>
                                                      
                    <br>
                    <table class="bottom-table"   class="table table-bordered table-striped table-hover" style="" align="Center">
                        <thead>
                            <tr class="table-title">
                                <td colspan="7" style="font-weight: bold; background-color: skyblue; text-align: center">VENDOR COMPANY DETAILS</td>
                            </tr>
                            <tr style="">
                                <th colspan="2">Company</th>
                                <th>Purchasing Organization</th>
                            </tr>
                        </thead>

                        <c:forEach var="vendorCompanyDetails" items="${vendorCompanyDetails}" varStatus="status">
                            <tr>
                                <td colspan="2">
                                    ${vendorCompanyDetails.vendorCompanyName}
                                </td>
                                <td>
                                    ${vendorCompanyDetails.vendorPO}
                                </td>
                            </tr>
                        </c:forEach>
                        <thead>
                            <tr class="table-title">
                                <td colspan="7" style="font-weight: bold; background-color: skyblue; text-align: center;">SAP DETAILS</td>
                            </tr>
                            <tr style="">
                                <th>Currency</th>
                                <th>BP Group </th>
                                <th>Search Term </th>
                            </tr>
                        </thead>

                        <tr>
                            <td>
                                ${vendorInformation1.currency}
                            </td>
                            <td>
                                ${vendorInformation1.bpGroup}
                            </td>
                            <td>
                                ${vendorInformation1.searchTerm1}
                            </td>
                        </tr>

                    </table>
                    <c:if test="${vendorInformation1.auditorAttachment!=null && not empty vendorInformation1.auditorAttachment && not empty vendorInformation1.riskBand}">                                        
                        <br>

                        <table class="bottom-table" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <thead>
                                <tr class="table-title">
                                    <td colspan="7" style="font-weight: bold; background-color: skyblue; text-align: center;">
                                        <c:if test="${vendorInformation1.riskCategory=='medium'}">
                                     INTERNAL AUDITOR APPROVAL

                                        </c:if>
                                        <c:if test="${vendorInformation1.riskCategory=='high'}">
										RISK EVALUATOR APPROVAL 
                                        </c:if>
                                    </td>
                                </tr>
                                <tr style="">
                                    <th>Attachment</th>
                                    <th>Risk Band</th>
                                    <th>Comment</th>
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
                                    <td>${vendorInformation1.auditorRemark}</td>
                                </tr>
                            </tbody>
                        </table>
                    </c:if>
                        <br>
                        <table class="bottom-table" class="table table-bordered table-striped table-hover" style="" align="Center"  >


                            <tbody>
                                <tr >
                                    <th style="width:25%;font-weight: bold; background-color: skyblue;">Vendor Financial Comment</th>
                                    <td style="width:75%;">
                                        ${vendorInformation1.vendorFinancialUpdateComment}
                                    </td>
                                </tr>
                            </tbody>


                        </table>
                                
                                
                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-12 col-md-6">
                                <div class="form-group comment-box">
                                    <label class="control-label">Comment :<span class="text-danger">*</span></label>
                                    <textarea type="text" name="comment" id="comment"  class="textarea-field comment" style="text-transform: uppercase;" maxlength="250" rows="3" required="required"></textarea>                                    
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="cta d-flex justify-content-center align-items-center">
                        <button type="submit" class="btn theme-btn recycle-btn mr-3" formaction="vendorInformation.htm?act=RecycleFinancalUpdate&id=${vendorInformation1.id}">
                            Rework
                        </button>
                        <button type="submit" id="submit2" class="btn theme-btn">Accept</button>
                    </div>
                    
                    <br>
                    <table class="bottom-table" class="table table-bordered table-striped table-hover" style="" align="Center">
                        <thead>
                            <tr class="table-title">
                                <td colspan="7" style="font-weight: bold; background-color: skyblue;">Approval History</td>
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
                </form:form>
            </section>
        </main>
        <script>
            function toggleRemark(radio) {
                const container = radio.closest('td');
                const remarkBox = container.querySelector('.remark-box');

                if (radio.value === 'reject') {
                    remarkBox.style.display = 'block';
                    remarkBox.querySelector('textarea').setAttribute('required', 'true');
                } else {
                    remarkBox.style.display = 'none';
                    remarkBox.querySelector('textarea').removeAttribute('required');
                }

                initRejectRemark();
            }
        </script>

        <script>
            function initRejectRemark() {
                const checkedRadios = document.querySelectorAll(
                    'input[type="radio"][value="reject"]:checked'
                );

                let rejectFound = false;

                checkedRadios.forEach(function (radio) {
                    const container = radio.closest('td');
                    const remarkBox = container.querySelector('.remark-box');

                    if (remarkBox) {
                        remarkBox.style.display = 'block';
                        remarkBox.querySelector('textarea').setAttribute('required', 'true');
                        rejectFound = true;
                    }
                });

                const approvedRadios = document.querySelectorAll(
                    'input[type="radio"]:checked:not([value="reject"])'
                );

                approvedRadios.forEach(function (radio) {
                    const container = radio.closest('td');
                    const remarkBox = container.querySelector('.remark-box');

                    if (remarkBox) {
                        remarkBox.style.display = 'none';
                        remarkBox.querySelector('textarea').removeAttribute('required');
                    }
                });

                const submitButton = document.getElementById('submit1');
                const submitButton2 = document.getElementById('submit2');
                if (submitButton) {
                    submitButton.disabled = rejectFound;
                }
                 if (submitButton2) {
                    submitButton2.disabled = rejectFound;
                }   
            }

            document.addEventListener('DOMContentLoaded', function () {
                initRejectRemark();
            });
        </script>
    </body>


    <!--<script src="StorageYard/assets/js/TableScript/commonTableScript.js" type="text/javascript"></script>-->

    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>


