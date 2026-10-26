<%-- 
    Document   : VendorActiveProfileView
    Created on : 3 Nov, 2025, 03:00:57 PM
    Author     : fnp
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarNewVendor.jsp"%>

    <head>
        <title>Vendor Information</title>
    </head>

    <body>
       


        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">

            <section id="printSection" class="main-content">
                <form:form action=""  enctype="multipart/form-data" method="post" commandName="vendorInformation"
                           name='form' class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">Vendor Information</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>                                            
                            <a href="vendorInformation.htm?act=vendorActivevendorviewClickPrint&id=${vendorInformation.id}" 
                               class="btn theme-btn">
                                Print
                            </a>              
                        </div>
                    </div>
                    <hr>                    

                    <div class="card-box rounded-3 mt-3 py-2 px-3 top-0">
                        <ul class="list-unstyled mb-0 d-flex align-items-center overflow-auto">

                            <li class="tab-item mr-2">
                                <a href="vendorInformation.htm?act=policyUpdateLevelOneVendorInformation" class="tab-link transition-0" <c:if test="${vendorInformation.status1=='3'}">style="color: red;"</c:if>>Basic Information</a>
                                </li>                            

                                <li class="tab-item mr-2">
                                    <a href="vendorInformation.htm?act=policyUpdateVendorInformation" class="tab-link transition-0" <c:if test="${vendorInformation.finacialFlag=='3'|| vendorInformation.finacialFlag=='6'|| vendorInformation.finacialFlag=='10'
                                      || (vendorInformation.status1 == '10' && vendorInformation.finacialFlag == '1')}">style="color: red;"</c:if>>Financial Information</a>
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
                                <a href="vendorInformation.htm?act=activeVenderProfileView" class="tab-link active transition-0">Vendor Information</a>
                            </li>
                        </ul>
                    </div>
                    <c:if test="${vendorInformation.status1 == 6 || vendorInformation.status1 == 7 || vendorInformation.status1 == 501 || vendorInformation.finacialFlag=='3' || vendorInformation.technicalFlag=='3' || vendorInformation.hrApprovalFlag=='3' || vendorInformation.safteyApprovalFlag=='3' || vendorInformation.itApprovalFlag=='3'}">
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
                            </div>
                        </div> 
                    </c:if>
                                <br>

                                <div class="table-responsive">

                                    <table class="table table-bordered custom-table mb-3" id="" style="width:100%;">                                                        <thead> 
                                        <thead>
                                            <tr class="table-title">
                                                <td colspan="4" style="font-weight: bold; background-color: skyblue; text-align: center; text-transform: uppercase;">Vendor Details</td>                                                
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <th style="width: 25%;">Company Name</th>
                                                <td style="width: 25%;">${vendorInformation.companyName}</td>
                                                <th style="width: 25%;">Email Id </th>
                                                <td style="width: 25%;">${vendorInformation.vendorEmailId}</td>

                                            </tr>
                                            <tr>
                                                <th style="">   <c:if test="${vendorInformation.policyAccept=='1'}">Code of Conduct (Sign & Stamp in all Pages)</c:if>
                                                    <c:if test="${vendorInformation.policyAccept=='0'}">Deviation Policy</c:if></th>
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
                                                <th style="">    <c:if test="${vendorInformation.ndaPolicyAccept=='1'}">NDA (Sign & Stamp in all Pages)</c:if>
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
                                                <th style="">Type of Company</th>
                                                <td>${vendorInformation.typeOfConcern}</td>
                                                <c:choose>
                                                    <c:when test="${vendorInformation.typeOfConcern == 'Sole Proprietorship'}">
                                                        <th  style="">
                                                            Shop or Establishment License
                                                        </th>
                                                    </c:when>

                                                    <c:when test="${vendorInformation.typeOfConcern == 'Hindu Undivided Family ( HUF)'}">
                                                        <th  style="">
                                                            Shop or Establishment License and HUF Deed
                                                        </th>
                                                    </c:when>

                                                    <c:when test="${vendorInformation.typeOfConcern == 'Partnership Firm'}">
                                                        <th  style="">
                                                            Shop or Establishment License and Partnership Deed
                                                        </th>
                                                    </c:when>

                                                    <c:when test="${vendorInformation.typeOfConcern == 'Limited Liability Partnership ( LLP)'}">
                                                        <th  style="">
                                                            Shop or Establishment License and LLP Agreement
                                                        </th>
                                                    </c:when>

                                                    <c:when test="${vendorInformation.typeOfConcern == 'Private/Public Company'}">
                                                        <th  style="">
                                                            Certificate of Incorporation (MCA)
                                                        </th>
                                                    </c:when>

                                                    <c:when test="${vendorInformation.typeOfConcern == 'Free Lancer'}">
                                                        <th  style="">
                                                            Professional Profile / Resume
                                                        </th>
                                                    </c:when>

                                                    <c:otherwise>
                                                        <th  style="">Proof Of Attachment</th>
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
                                                <th  style="">Year of Establishment of Company</th>
                                                <td>${vendorInformation.establishment}</td>
                                                <th style="">Risk Category</th>
                                                <td class="riskCategory">${vendorInformation.riskCategory}</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <br>

                                    <table class="table table-bordered custom-table mb-3" id="" style="width:100%;">                                                        <thead> 

                                        <thead>

                                            <tr class="table-title">
                                                <td colspan="8" style="font-weight: bold; background-color: skyblue; text-align: center; text-transform: uppercase;">Register Address</td>
                                            </tr>


                                        </thead>

                                        <tbody>
                                            <tr>
                                                <th style="width: 25%;">Street / House No.</th>
                                                <td style="width: 25%;"><span class="wrap-text">${vendorInformation.officeAddressLine1}</span></td>
                                                <th style="width: 25%;">Street-1</th>
                                                <td style="width: 25%;"><span class="wrap-text">${vendorInformation.officeAddressLine2}</span></td>
                                            </tr>

                                            <tr>
                                                <th style="width: 25%;">Street-2</th>
                                                <td style="width: 25%;"><span class="wrap-text">${vendorInformation.officeAddressLine3}</span></td>
                                                <th style="width: 25%;">Country</th>
                                                <td style="width: 25%;">${vendorInformation.officeCountry}</td>

                                            </tr>

                                            <tr>
                                                <th style="width: 25%;">State</th>
                                                <td>${vendorInformation.officeState}</td>
                                                <th style="width: 25%;">District</th>
                                                <td>${vendorInformation.officeDistrict}</td>
                                            </tr>

                                            <tr>
                                                <th style="width: 25%;">City</th>
                                                <td>${vendorInformation.officeCity}</td>
                                                <th style="">Postal Code</th>
                                                <td>${vendorInformation.officePin}</td>
                                            </tr>

                                            <tr>
                                                <th style="">Mobile No</th>
                                                <td>+${vendorInformation.countryCodeoffTele}-${vendorInformation.officeTelephone}</td>
                                                <th style="">Email</th>
                                                <td>${vendorInformation.officeEmail}</td>
                                            </tr>

                                            <tr>
                                                <th style="">Website</th> 
                                                <td>${vendorInformation.officeWebsite}</td>
                                                <th style=""></th> 
                                                <td></td> 
                                            </tr>

                                        </tbody>
                                    </table>

                                    <BR>


                                    <table class="table table-bordered custom-table mb-3" id="" style="width:100%;">                                                        <thead> 

                                        <thead>

                                            <tr class="table-title">
                                                <td colspan="8" style="font-weight: bold; background-color: skyblue; text-align: center; text-transform: uppercase;">Communication Address</td>
                                            </tr>


                                        </thead>

                                        <tbody>
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
                                                <td>+${vendorInformation.countryCodeNewMobiles}-${declaration.altTelephone}</td>
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

                                    
                                                                        <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
                                                                            <thead>
                                                                                <tr>
                                                                                    <th colspan="3" style="border:1px solid black; background-color:skyblue; text-align:center;">
                                                                                        TYPES OF VENDORS 
                                                                                    </th>
                                                                                </tr>
                                                                                <tr style="background-color:#f2f2f2; text-align:center;">
                                                                                    <th>Group Name</th>
                                                                                    <th>Group Category Name</th>
                                                                                    <th>Group Sub Category Name</th>
                                                                                </tr>
                                                                            </thead>

                                                                            <tbody>
                                                                                <c:forEach var="list7" items="${list7}" varStatus="status">
                                                                                    <tr>
                                                                                <input type="hidden" id="groupId" name="groupId" value="${list7[2]}" />
                                                                                <td>${list7[2]}</td>
                                                                                <td>${list7[3]}</td>
                                                                                <td>${list7[4]}</td>
                                                                                </tr>
                                                                            </c:forEach>
                                                                            </tbody>
                                                                        </table>



                                                                        <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
                                                                            <thead>
                                                                                <tr>
                                                                                    <th colspan="5" style="border:1px solid black; background-color:skyblue; text-align:center;">
                                                                                        VENDOR CONTACTS
                                                                                    </th>
                                                                                </tr>
                                                                                <tr style="background-color:#f2f2f2; text-align:center;">
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
                                                                                    <td>${vendorInformation.sales_name}</td>
                                                                                    <td>${vendorInformation.sales_job}</td>
                                                                                    <td>+${vendorInformation.countryCodeVendorContact}-${vendorInformation.sales_phone}</td>
                                                                                    <td>${vendorInformation.saleEmail}</td>
                                                                                </tr>

                                                                                <tr>
                                                                                    <td>Technical Contact(s)</td>
                                                                                    <td>${vendorInformation.technical_name}</td>
                                                                                    <td>${vendorInformation.technical_job}</td>
                                                                                    <td>+${vendorInformation.countryCodeVendorContact1}-${vendorInformation.technical_phone}</td>
                                                                                    <td>${vendorInformation.technicalContactEmail}</td>
                                                                                </tr>

                                                                                <tr>
                                                                                    <td>Finance and Accounts</td>
                                                                                    <td>${vendorInformation.quality_name}</td>
                                                                                    <td>${vendorInformation.quality_job}</td>
                                                                                    <td>+${vendorInformation.countryCodeVendorContact2}-${vendorInformation.quality_phone}</td>
                                                                                    <td>${vendorInformation.qualityEmail}</td>
                                                                                </tr>

                                                                               
                                                                            </tbody>
                                                                        </table>
                        

                                                                                    <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
                                                                                        <thead>
                                                                                            <tr>
                                                                                                <th colspan="5" style="border:1px solid black; background-color:skyblue; text-align:center;">
                                                                                                    MANAGERIAL PERSON DETAILS
                                                                                                </th>
                                                                                            </tr>
                                                                                            <tr style="background-color:#f2f2f2; text-align:center;">
                                                                                                <th style="width:8%;">Sr No.</th>
                                                                                                <th style="width:22%;">Name</th>
                                                                                                <th style="width:20%;">Designation</th>
                                                                                                <th style="width:20%;">Phone No.</th>
                                                                                                <th style="width:30%;">Email</th>
                                                                                            </tr>
                                                                                        </thead>

                                                                                        <tbody>
                                                                                            <c:forEach items="${mplist}" var="mp" varStatus="status">
                                                                                                <tr>
                                                                                                    <td style="text-align:center;">${status.count}</td>
                                                                                                    <td>${mp.name}</td>
                                                                                                    <td>${mp.designation}</td>
                                                                                                    <td>${mp.phoneNo}</td>
                                                                                                    <td>${mp.emailId}</td>
                                                                                                </tr>
                                                                                            </c:forEach>
                                                                                        </tbody>
                                                                                    </table>
                                                                                <br>

                                                                                <div class="table-responsive">
                                                                                    <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
                                                                                        <thead>
                                                                                            <tr class="table-title">
                                                                                                <td colspan="6" style="font-weight: bold; background-color: skyblue;text-align: center;">  PAST WORKING EXPERIENCE DETAILS </td>                                                                                                
                                                                                            </tr>
                                                                                            <tr>
                                                                                                <th>Company Name</th>
                                                                                                <th>Contact Person Name</th>
                                                                                                <th>Phone No.</th>
                                                                                                <th>Email</th>
                                                                                                <th>Designation</th>
                                                                                                <th>Attachment</th>
                                                                                            </tr>
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
                        

                                                                                <div class="table-responsive">
                                                                                    <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
                                                                                        <thead>
                                                                                            <tr>
                                                                                                <th colspan="4" style="border:1px solid black; background-color:skyblue; text-align:center;">
                                                                                                    COMPANY REGISTRATION DETAILS
                                                                                                </th>
                                                                                            </tr>                                               
                                                                                        </thead>
                                                                                        <tbody>
                                                                                            <tr>
                                                                                                <th style="width: 20%;">GST No.</th>
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
                                                                                                <th style="width: 20%;">PAN No</th>
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
                                                                                                <th style="width: 20%;">MSME No</th>
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
                                                                                                <th style="width: 20%;">ESIC No</th>
                                                                                                <td>
                                                                                                    <c:if test="${vendorInformation.esicStatus=='0'}"><strong>ESIC Not
                                                                                                            Available</strong></c:if>
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
                                                                                                <th style="width: 20%;">EPFO No.</th>
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
                                                                                                <th style="width: 20%;">Import Export Code </th>
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


                                                                                <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
                                                                                    <thead>
                                                                                        <tr>
                                                                                            <th colspan="6" style="border:1px solid black; background-color:skyblue; text-align:center;">
                                                                                                BANK DETAILS
                                                                                            </th>
                                                                                        </tr>
                                                                                    </thead>

                                                                                    <tbody>
                                                                                        <tr>
                                                                                            <th>Account Number</th>
                                                                                            <td colspan="2">${vendorInformation.accountNumber}</td>
                                                                                            <th>Bank Name</th>
                                                                                            <td colspan="2">${vendorInformation.bankName}</td>
                                                                                        </tr>

                                                                                        <tr>
                                                                                            <th>Branch</th>
                                                                                            <td colspan="2">${vendorInformation.branch}</td>
                                                                                            <th>IFSC Code</th>
                                                                                            <td colspan="2">${vendorInformation.ifscCode}</td>
                                                                                        </tr>

                                                                                        <tr>
                                                                                            <th>Swift Code (if any)</th>
                                                                                            <td colspan="2">${vendorInformation.swiftCode}</td>
                                                                                            <th>Cancel Cheque</th>
                                                                                            <td colspan="2">
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
                                                                        <th colspan="4"
                                                                            style="border:1px solid black; background-color:skyblue; text-align:center;">
                                                                             FINANCIAL STATEMENTS FOR LAST THREE YEARS
                                                                        </th>
                                                                    </tr>
                                                                    <tr style="background-color:#f2f2f2; text-align:center;">
                                                                        <th style="width:15%;">Year</th>
                                                                        <th style="width:25%;">Financial Year</th>
                                                                        <th style="width:25%;">Financial Amount</th>
                                                                        <th style="width:35%;">Financial Attachment</th>
                                                                    </tr>
                                                                </thead>

                                                                <tbody>
                                                                    <tr>
                                                                        <th>1st Year</th>
                                                                        <td>${vendorInformation.finical1}</td>
                                                                        <td>${vendorInformation.finicalAmount1}</td>
                                                                        <td  style=" max-width: 200px; word-break: break-all;  overflow-wrap: break-word;white-space: normal">
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
                                                                        <th>2nd Year</th>
                                                                        <td>${vendorInformation.finical2}</td>
                                                                        <td>${vendorInformation.finicalAmount2}</td>
                                                                        <td  style=" max-width: 200px; word-break: break-all;  overflow-wrap: break-word;white-space: normal">
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
                                                                        <th>3rd Year</th>
                                                                        <td>${vendorInformation.finical3}</td>
                                                                        <td>${vendorInformation.finicalAmount3}</td>
                                                                        <td  style=" max-width: 200px; word-break: break-all;  overflow-wrap: break-word;white-space: normal">
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
                       

                                                            <c:if test="${!empty list4}">
                                                                <div class="technical-section">

                                                                    <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
                                                                        <thead>
                                                                            <tr>
                                                                                <th colspan="6" style="border:1px solid black; background-color:skyblue; text-align:center;">
                                                                                     TECHNICAL CRITERIA
                                                                                </th>
                                                                            </tr>
                                                                            <tr style="background-color:#f2f2f2; text-align:center;">
                                                                                <th>Sr No.</th>
                                                                                <th>Criteria</th>
                                                                                <th>Selection Criteria</th>
                                                                                <th>Vendor Acceptance</th>
                                                                                <th>Comment</th>
                                                                                <th>Attachment</th>
                                                                            </tr>
                                                                        </thead>
                                                                        <tbody>
                                                                            <c:set var="total" value="0" />
                                                                            <c:set var="size" value="${list4.size() * 2}" />
                                                                            <c:forEach var="list4" items="${list4}" varStatus="status">
                                                                                <c:set var="total" value="${list4.score + total}" />
                                                                                <tr>
                                                                                    <td>${status.count}</td>
                                                                                    <td><pre class="terms-details">${list4.criteria}</pre></td>
                                                                                    <td><pre class="terms-details">${list4.selectionCriteria}</pre></td>
                                                                                    <td>                                                                                       
                                                                                        ${list4.score == '1' ? 'Yes' : 'No'}
                                                                                    </td>
                                                                                    <td>${list4.comment}</td>
                                                                                    <td  style=" max-width: 200px; word-break: break-all;  overflow-wrap: break-word;white-space: normal">
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
                                                            </c:if>


                                                            <c:if test="${!empty list5}">
                                                                <div class="hr-section">

                                                                    <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
                                                                        <thead>
                                                                            <tr>
                                                                                <th colspan="6" style="border:1px solid black; background-color:skyblue; text-align:center;">
                                                                                    HR CRITERIA
                                                                                </th>
                                                                            </tr>
                                                                            <tr style="background-color:#f2f2f2; text-align:center;">
                                                                                <th>Sr No.</th>
                                                                                <th>Criteria</th>
                                                                                <th>Selection Criteria</th>
                                                                                <th>Vendor Acceptance</th>
                                                                                <th>Comment</th>
                                                                                <th>Attachment</th>
                                                                            </tr>
                                                                        </thead>
                                                                        <tbody>
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
                                                                                    <td  style=" max-width: 200px; word-break: break-all;  overflow-wrap: break-word;white-space: normal">                                                                                        
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
                                                            </c:if>


                                                            <c:if test="${!empty list9}">
                                                                <div class="it-section">
                                                                    <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
                                                                        <thead>
                                                                            <tr>
                                                                                <th colspan="6" style="border:1px solid black; background-color:skyblue; text-align:center;">
                                                                                    IT CRITERIA
                                                                                </th>
                                                                            </tr>
                                                                            <tr style="background-color:#f2f2f2; text-align:center;">
                                                                                <th>Sr No.</th>
                                                                                <th>Criteria</th>
                                                                                <th>Selection Criteria</th>
                                                                                <th>Vendor Acceptance</th>
                                                                                <th>Comment</th>
                                                                                <th>Attachment</th>
                                                                            </tr>
                                                                        </thead>
                                                                        <tbody>
                                                                            <c:set var="total1" value="0" />
                                                                            <c:set var="size9" value="${list9.size() * 2}" />
                                                                            <c:forEach var="list9" items="${list9}" varStatus="status">
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
                                                            </c:if>

                                                            <c:if test="${!empty list6}">
                                                                <div class="safety-section">

                                                                    <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
                                                                        <thead>
                                                                            <tr>
                                                                                <th colspan="6" style="border:1px solid black; background-color:skyblue; text-align:center;">
                                                                                    SAFETY CRITERIA 
                                                                                </th>
                                                                            </tr>
                                                                            <tr style="background-color:#f2f2f2; text-align:center;">
                                                                                <th>Sr No.</th>
                                                                                <th>Criteria</th>
                                                                                <th>Selection Criteria</th>
                                                                                <th>Vendor Acceptance</th>
                                                                                <th>Comment</th>
                                                                                <th>Attachment</th>
                                                                            </tr>
                                                                        </thead>
                                                                        <tbody>
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
                                                                                    <td  style=" max-width: 200px; word-break: break-all;  overflow-wrap: break-word;white-space: normal">
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

                                                            </c:if> 

                                                            <c:if test="${!empty list6 || !empty list9 || !empty list5 || !empty list4}">
                                                                <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
                                                                    <tr>
                                                                        <td style="width: 50%;"><strong>Aggregate Percentage (%):</strong></td>
                                                                        <td style="width: 50%;">
                                                                            <fmt:formatNumber value="${((total + total1 + total2) * 100.0) / (size + size1 + size2)*2}" type="number" maxFractionDigits="2"  minFractionDigits="2"/>%
                                                                        </td>
                                                                    </tr>
                                                                </table>
                                                            </c:if>

                                                            <c:if test="${!empty vendorApproval}">
                                                                <br>
                                                                <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
                                                                    <thead>
                                                                        <tr>
                                                                            <th colspan="6" style="border:1px solid black; background-color:skyblue; text-align:center;">
                                                                                APPROVAL HISTORY
                                                                            </th>
                                                                        </tr>
                                                                        <tr style="background-color:#f2f2f2; text-align:center;">
                                                                            <th style="width:8%;">Sr No.</th>
                                                                            <th style="width:20%;">User Name</th>
                                                                            <th style="width:20%;">User Role</th>
                                                                            <th style="width:22%;">Date Time</th>
                                                                            <th style="width:20%;">Status</th>
                                                                            <th style="width:30%;">Comment</th>
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
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
