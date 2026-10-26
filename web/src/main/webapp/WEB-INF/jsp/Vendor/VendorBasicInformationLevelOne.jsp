<%-- 
    Document   : VendorBasicInformationLevelOne
    Created on : 1 Nov, 2025, 09:57:57 AM
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
                <form:form action="vendorInformation.htm?act=basicUpdateVendorInformation1"  enctype="multipart/form-data" method="post" commandName="vendorInformation"
                           name='form' class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">Basic Information</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <%--<c:if test="${vendorInformation.status1=='3'  || vendorInformation.auditorFlag=='3'  }">
                                <button type="submit" class="btn theme-btn" id="submit2">Submit</button>
                            </c:if>--%>
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
                                <a href="vendorInformation.htm?act=policyUpdateLevelOneVendorInformation" class="tab-link active transition-0" <c:if test="${vendorInformation.status1=='3'}">style="color: red;"</c:if>>Basic Information</a>
                                </li>                            

                                <li class="tab-item mr-2">
                                    <a href="vendorInformation.htm?act=policyUpdateVendorInformation"
                                       class="tab-link transition-0"
                                    <c:if test="${vendorInformation.finacialFlag == '3'
                                        || vendorInformation.finacialFlag == '6'
                                        || vendorInformation.finacialFlag == '10'
                                        || (vendorInformation.status1 == '10' && vendorInformation.finacialFlag == '1')}">
                                        style="color: red;"
                                    </c:if>>
                                    Financial Information
                                </a>
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

                    <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
                        <thead>
                            <tr>
                                <td colspan="3"
                                    style="border:1px solid black; background-color:skyblue; text-align:center;">
                                    <strong>TYPE OF VENDORS</strong>
                                </td>
                            </tr>
                            <tr>
                                <th style="width:33%">Group Name</th>
                                <th style="width:33%">Group Category Name</th>
                                <th style="width:34%">Group Sub Category Name</th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach var="list" items="${list}" varStatus="status">
                                <tr>
                                    <!-- fixed hidden input -->
                            <input type="hidden" name="groupId" value="${list[1]}" />

                            <td>${list[2]}</td>
                            <td>${list[3]}</td>
                            <td>${list[4]}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>


                    <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
                        <thead>
                            <tr>
                                <td colspan="5" style="border:1px solid black; background-color:skyblue; text-align:center;">
                                    <strong>MANAGERIAL PERSON DETAILS</strong>
                                </td>
                            </tr>
                            <tr>
                                <th style="width:10%">Sr No.</th>
                                <th style="width:25%">Name</th>
                                <th style="width:25%">Designation</th>
                                <th style="width:20%">Phone No.</th>
                                <th style="width:20%">Email</th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach items="${mplist}" var="mplist" varStatus="status">
                                <tr>
                                    <td class="text-center">${status.count}</td>
                                    <td>${mplist.name}</td>
                                    <td>${mplist.designation}</td>
                                    <td>+${mplist.countryCode}-${mplist.phoneNo}</td>
                                    <td>${mplist.emailId}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                                    
                    <div class="table-responsive">
                        <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
                            <thead>
                                <tr class="table-title">
                                    <td colspan="4" style="border:1px solid black; background-color:skyblue; text-align:center;"><strong>COMPANY REGISTRATION DETAILS</strong></td>
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
                    <table class="table table-bordered custom-table mb-3"
                           style="width:100%; table-layout:fixed; border-collapse:collapse;">

                        <thead>
                            <tr>
                                <td colspan="4"
                                    style="border:1px solid black; background-color:skyblue; text-align:center;">
                                    <strong>FINANCIAL STATEMENT (PROFIT AND LOSS / BALANCE SHEET)</strong>
                                </td>
                            </tr>
                            <tr>
                                <th style="width:15%">Year</th>
                                <th style="width:25%">Financial Year</th>
                                <th style="width:20%">Financial Amount</th>
                                <th style="width:40%">Financial Attachment</th>
                            </tr>
                        </thead>

                        <tbody>
                            <!-- 1st Year -->
                            <tr>
                                <td>1st Year</td>
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

                            <!-- 2nd Year -->
                            <tr>
                                <td>2nd Year</td>
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

                            <!-- 3rd Year -->
                            <tr>
                                <td>3rd Year</td>
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
                                        
                    <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">

                        <thead>
                            <tr>
                                <td colspan="3"
                                    style="border:1px solid black; background-color:skyblue; text-align:center;">
                                    <strong>SELF DECLARATION FORM</strong>
                                </td>
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
                           

                                        <script>
                                                    function toggleGSTFields() {                                                           var gstApplicable = document.getElementById("gstApplicable");
                                                            var gstNotApplicable = document.getElementById("gstNotApplicable");
                                                            var gstFields = document.getElementById("gstFields");
                                                            var commentField = document.getElementById("commentField");
                                                            var gstNo = document.getElementById("gstinNo");
                                                            var gstFile = document.getElementById("gstinFile");
                                                            var gstComment = document.getElementById("gstComment");
                                                            if (gstApplicable.checked) {
                                                    gstFields.style.display = "block";
                                                            commentField.style.display = "none";
                                                            gstNotApplicable.checked = false;
                                                            // Required for GST Applicable
                                                            gstNo.setAttribute("required", "required");
                                                            //                                                        gstFile.setAttribute("required", "required");
                                                            gstComment.removeAttribute("required");
                                                    } else if (gstNotApplicable.checked) {                                                           gstFields.style.display = "none";
                                                            commentField.style.display = "block";
                                                            gstApplicable.checked = false;
                                                            // Required for GST Not Applicable
                                                            gstNo.removeAttribute("required");
                                                            //                                                        gstFile.removeAttribute("required");
                                                            gstComment.setAttribute("required", "required");
                                                    } else {
                                                    gstFields.style.display = "none";
                                                            commentField.style.display = "none";
                                                            // Remove all required attributes when neither is selected
                                                            gstNo.removeAttribute("required"); //                                                        gstFile.removeAttribute("required");
                                                            gstComment.removeAttribute("required");
                                                    }
                                                    }

                                        </script>





                                        <script>
                                            // Function to check file size
                                            function checkFileSize1(input, cancelCheckError) {
                                            const file = input.files[0]; // Get the selected file
                                                    const maxSize = 5 * 1024 * 1024; // 5MB in bytes

                                                    if (file && file.size > maxSize) {
                                            document.getElementById(cancelCheckError).style.display = 'block'; // Show error message
                                                    input.value = ''; // Clear the file input
                                            } else {
                                            document.getElementById(cancelCheckError).style.display = 'none'; // Hide error message
                                            }
                                            }
                                        </script>


                                        <script>
                                            // Function to check file size
                                            function checkFileSizef1(input, fileError1) {

                                            const file = input.files[0]; // Get the selected file
                                                    const maxSize = 5 * 1024 * 1024; // 5MB in bytes

                                                    if (file && file.size > maxSize) {
                                            document.getElementById(fileError1).style.display = 'block'; // Show error message
                                                    input.value = ''; // Clear the file input
                                            } else {
                                            document.getElementById(fileError1).style.display = 'none'; // Hide error message
                                            }
                                            }
                                        </script>
                                        <script>
                                            // Function to check file size
                                            function checkFileSizef2(input, fileError2) {

                                            const file = input.files[0]; // Get the selected file
                                                    const maxSize = 5 * 1024 * 1024; // 5MB in bytes

                                                    if (file && file.size > maxSize) {
                                            document.getElementById(fileError2).style.display = 'block'; // Show error message
                                                    input.value = ''; // Clear the file input
                                            } else {
                                            document.getElementById(fileError2).style.display = 'none'; // Hide error message
                                            }
                                            }
                                        </script>
                                        <script>
                                            // Function to check file size
                                            function checkFileSizef3(input, fileError3) {

                                            const file = input.files[0]; // Get the selected file
                                                    const maxSize = 5 * 1024 * 1024; // 5MB in bytes

                                                    if (file && file.size > maxSize) {                                                   document.getElementById(fileError3).style.display = 'block'; // Show error message
                                                    input.value = ''; // Clear the file input
                                            } else {
                                            document.getElementById(fileError3).style.display = 'none'; // Hide error message
                                            }
                                            }
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
                                            });</script>
                                        <script>
                                                    function formatNumber(input) {
                                                    // Remove all non-digit characters except the decimal point
                                                    let value = input.value.replace(/,/g, '').replace(/[^\d.]/g, '');
                                                            // Format number with commas
                                                            let parts = value.split('.');
                                                            parts[0] = parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ',');
                                                            input.value = parts.join('.');
                                                    }
                                        </script>
                                        
                                    
                                        <div class="table-responsive">

                                            <table class="table table-bordered custom-table mb-3" id="" style="width:100%;">                                                        
                                                <thead>
                                                    <tr class="table-title">
                                                        <td colspan="4" style="font-weight: bold; background-color: skyblue; text-align: center; text-transform: uppercase;">EXTERNAL VENDOR EMAIL</td>                                                
                                                    </tr>
                                                </thead>
                                                <tbody>    

                                                    <tr>
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
                                        </div>


                    
                </form:form>
            </section>
        </main>
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
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
