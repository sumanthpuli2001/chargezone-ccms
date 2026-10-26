<%-- 
    Document   : VendorActivevendorviewClickPrint
    Created on : Jun 30, 2026, 10:00:39 AM
    Author     : Sumanth
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNewPrint.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Vendor All Details</title>
    </head>
    <body>
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNewVendor.jsp"%>
            <section class="main-content">
                <form:form action="vendorInformation.htm?act=approveonesubmit" method="post"  name='form1' class="form-horizontal" role="form">             
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0 no-print">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2  d-print-none">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0  no-print">View Vendor All Details</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3 no-print">Back</a>
                            <a onclick="window.print();" class="btn btn theme-btn no-print" style="background-color: #4CAF50; border-color: #4CAF50;" >
                                <i class="fa fa-print"></i>&nbsp;&nbsp;Print
                            </a> 
                        </div>
                    </div>  
                    <br>
                    <c:forEach var="list" items="${list}" varStatus="status">
                        <input type="hidden" id="id" name="id" value="${list.id}">
                        <input type="hidden" id="id1" name="id1" value="${list.id}">

                        <table  class="flex-table printup" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                    Vendor Details
                                </td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Company Name</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${list.companyName}</td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>Email Id:</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${list.vendorEmailId}</td>
                            </tr>
                            <tbody>
                                <tr style="font-size:11px; height:20px;">
                                    <th colspan="1" style="padding:3px 5px;">   <c:if test="${list.policyAccept=='1'}">Code of Conduct (Sign & Stamp in all Pages)</c:if>
                                        <c:if test="${list.policyAccept=='0'}">Deviation Policy</c:if></th>
                                        <td colspan="2" style="padding:3px 5px;">
                                        <c:if test="${list.policyAccept=='1'}">Accept</c:if>
                                        <c:if test="${list.policyAccept=='0'}"><span style="color: red;">Not Accept</span></c:if><br>
                                        <c:if test="${vendorInformation1.policy1File!=null && not empty vendorInformation1.policy1File}">                                        
                                            <span class="file-wrapper">
                                                <span class="file-name text-break">${vendorInformation1.policy1File}</span>
                                                <span class="file-actions">
                                                    <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.policy1File}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.policy1File}"><span class="fa fa-solid fa-eye"></span></a>
                                                </span>
                                            </span>
                                        </c:if>
                                    </td>
                                    <th colspan="1" style="padding:3px 5px;">    <c:if test="${list.ndaPolicyAccept=='1'}">NDA (Sign & Stamp in all Pages)</c:if>
                                        <c:if test="${list.ndaPolicyAccept=='0'}">NDA Policy</c:if>
                                        </th> 
                                        <td colspan="2" style="padding:3px 5px;">
                                        <c:if test="${list.ndaPolicyAccept=='1'}">Accept</c:if>
                                        <c:if test="${list.ndaPolicyAccept=='0'}"><span style="color: red;">Not Accept</span></c:if><br>
                                        <c:if test="${vendorInformation1.ndaPolicyFile!=null && not empty vendorInformation1.ndaPolicyFile}">                                        
                                            <span class="file-wrapper">
                                                <span class="file-name text-break">${vendorInformation1.ndaPolicyFile}</span>
                                                <span class="file-actions">
                                                    <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.ndaPolicyFile}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.ndaPolicyFile}"><span class="fa fa-solid fa-eye"></span></a>
                                                </span>
                                            </span>
                                        </c:if>
                                    </td>
                                </tr>
                                <tr style="font-size:11px; height:20px;">
                                    <th colspan="1" style="padding:3px 5px;">Type of Company</th>
                                    <td colspan="2" style="padding:3px 5px;">${list.typeOfConcern}</td>
                                    <c:choose>
                                        <c:when test="${list.typeOfConcern == 'Sole Proprietorship'}">
                                            <th  colspan="1" style="padding:3px 5px;">
                                                Shop or Establishment License
                                            </th>
                                        </c:when>

                                        <c:when test="${list.typeOfConcern == 'Hindu Undivided Family ( HUF)'}">
                                            <th  colspan="2" style="padding:3px 5px;">
                                                Shop or Establishment License and HUF Deed
                                            </th>
                                        </c:when>

                                        <c:when test="${list.typeOfConcern == 'Partnership Firm'}">
                                            <th  colspan="1" style="padding:3px 5px;">
                                                Shop or Establishment License and Partnership Deed
                                            </th>
                                        </c:when>

                                        <c:when test="${list.typeOfConcern == 'Limited Liability Partnership ( LLP)'}">
                                            <th  colspan="2" style="padding:3px 5px;">
                                                Shop or Establishment License and LLP Agreement
                                            </th>
                                        </c:when>

                                        <c:when test="${list.typeOfConcern == 'Private/Public Company'}">
                                            <th  colspan="1" style="padding:3px 5px;">
                                                Certificate of Incorporation (MCA)
                                            </th>
                                        </c:when>
                                        
                                        <c:when test="${list.typeOfConcern == 'Free Lancer'}">
                                            <th  colspan="1" style="padding:3px 5px;">
                                                Professional Profile / Resume
                                            </th>
                                        </c:when>

                                        <c:otherwise>
                                            <th  colspan="2" style="padding:3px 5px;">Proof Of Attachment</th>
                                            </c:otherwise>
                                        </c:choose>
                                    <td colspan="1" style="padding:3px 5px;">
                                        <c:if test="${vendorInformation1.companyProof!=null && not empty vendorInformation1.companyProof}">                                        
                                            <span class="file-wrapper">
                                                <span class="file-name text-break">${vendorInformation1.companyProof}</span>
                                                <span class="file-actions">
                                                    <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.companyProof}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.companyProof}"><span class="fa fa-solid fa-eye"></span></a>
                                                </span>
                                            </span>
                                        </c:if>
                                        <c:if test="${vendorInformation1.companyProof2!=null && not empty vendorInformation1.companyProof2}">
                                            <br>
                                            <span class="file-wrapper">
                                                <span class="file-name text-break">${vendorInformation1.companyProof2}</span>
                                                <span class="file-actions">
                                                    <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.companyProof2}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.companyProof2}"><span class="fa fa-solid fa-eye"></span></a>
                                                </span>
                                            </span>
                                        </c:if>                                        
                                    </td>
                                </tr>
                                <tr style="font-size:11px; height:20px;">
                                    <th colspan="1" style="padding:3px 5px;">Year of Establishment of Company</th>
                                    <td colspan="2" style="padding:3px 5px;">${list.establishment}</td>
                                    <td colspan="1"  style="padding:3px 5px;"><strong>Risk Category</strong></td>
                                    <td colspan="2" style="padding:3px 5px;" class="riskCategory">${list.riskCategory}</td>
                                </tr>
                            </tbody>
                        </table>
                        <br>
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                    Register Address
                                </td>
                            </tr>           

                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Street / House No</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${list.officeAddressLine1}</td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>Street-1</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${list.officeAddressLine2}</td>
                            </tr>

                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Street-2</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${list.officeAddressLine3}</td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>Country</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${list.officeCountry}</td>
                            </tr>

                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>State</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${list.officeState}</td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>District</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${list.officeDistrict}</td>
                            </tr>

                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>City</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${list.officeCity}</td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>Postal Code</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${list.officePin}</td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Mobile No</strong></td>
                                <td colspan="2"style="padding:3px 5px;">+${list.countryCodeoffTele}-${list.officeTelephone}</td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>Email</strong></td>
                                <td colspan="2"  style="padding:3px 5px;">${list.officeEmail}</td>

                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1"  style="padding:3px 5px;"><strong>Website</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${list.officeWebsite}</td>
                                <td colspan="1"  style="padding:3px 5px;"></td>
                                <td colspan="2"  style="padding:3px 5px;"></td>
                            </tr>


                        </table> 
                        <br>
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">

                                    Communication Address
                                </td>
                            </tr>     
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Street / House No</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${declaration.altLocalAddress}</td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>Street-1</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${declaration.altLocalAddress1}</td>
                            </tr>

                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Street-2</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${declaration.altLocalAddress2}</td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>Country</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${declaration.altCountry}</td>
                            </tr>

                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>State</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${declaration.altState}</td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>City</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${declaration.altCity}</td>
                            </tr>

                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>District</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${declaration.altDistrict}</td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>Postal Code</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${declaration.altPostalCode}</td>
                            </tr>

                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Mobile No</strong></td>
                                <td colspan="2"style="padding:3px 5px;">+${list.countryCodeNewMobiles}-${declaration.altTelephone}</td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>Email </strong></td>
                                <td colspan="2" style="padding:3px 5px;">${declaration.altEmail}</td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Website</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${declaration.altWebsite}</td>
                                <td colspan="1" style="padding:3px 5px;"><strong></strong></td>
                                <td colspan="2"style="padding:3px 5px;"></td>
                            </tr>
                        </table>

                        <br>
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">                               
                                    Type Of Vendors
                                </td>
                            </tr>   
                            <c:forEach var="list222" items="${list222}" varStatus="status">
                                <tr style="font-size:11px; height:20px;">
                                <input type="hidden" class="input-field" id="groupId" name="groupId" value="${list222[2]}" />
                                <td colspan="1" style="padding:3px 5px;">${list222[2]}</td>
                                <td colspan="1" style="padding:3px 5px;">${list222[3]}</td>
                                <td colspan="1" style="padding:3px 5px;">${list222[4]}</td>
                                </tr>
                            </c:forEach>
                        </table>

                        <br>
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="8" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">                               
                                    Vendor Contacts
                                </td>
                            </tr> 

                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Type</strong></td>
                                <td colspan="1"style="padding:3px 5px;"><strong>Name</strong></td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>Job Title</strong></td>
                                <td colspan="1" style="padding:3px 5px;"><strong>Phone No.</strong></td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>Email</strong></td>

                            </tr>
                            <tbody>
                                <tr  style="font-size:11px; height:20px;">
                                    <td colspan="1" style="padding:3px 5px;">Sales/Commercial Contact(s) </td>
                                    <td colspan="1" style="padding:3px 5px;">${list.sales_name}</td>
                                    <td colspan="1" style="padding:3px 5px;">${list.sales_job}</td>
                                    <td colspan="1" style="padding:3px 5px;">+${list.countryCodeVendorContact}-${list.sales_phone}</td>
                                    <td colspan="1" style="padding:3px 5px;">${list.saleEmail}</td>
                                </tr>
                                <tr style="font-size:11px; height:20px;">
                                    <td colspan="1" style="padding:3px 5px;">Technical Contact(s) </td>
                                    <td colspan="1" style="padding:3px 5px;">${list.technical_name}</td>
                                    <td colspan="1" style="padding:3px 5px;">${list.technical_job}</td>
                                    <td colspan="1" style="padding:3px 5px;">+${list.countryCodeVendorContact1}-${list.technical_phone}</td>
                                    <td colspan="1" style="padding:3px 5px;">${list.technicalContactEmail}</td>
                                </tr>
                                <tr style="font-size:11px; height:20px;">
                                    <td colspan="1" style="padding:3px 5px;">Finance and Accounts </td>
                                    <td colspan="1" style="padding:3px 5px;">${list.quality_name}</td>
                                    <td colspan="1" style="padding:3px 5px;">${list.quality_job}</td>
                                    <td colspan="1" style="padding:3px 5px;">+${list.countryCodeVendorContact2}-${list.quality_phone}</td>
                                    <td colspan="1" style="padding:3px 5px;">${list.qualityEmail}</td>

                                </tr>                                                                    
                            </tbody>
                        </table>
                        <br>
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">                               
                                    MANAGERIAL PERSON DETAILS
                                </td>
                            </tr>

                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Sr.No</strong></td>
                                <td colspan="1" style="padding:3px 5px;"><strong>Name</strong></td>
                                <td colspan="1"style="padding:3px 5px;"><strong>Designation</strong></td>
                                <td colspan="1" style="padding:3px 5px;"><strong>Phone No.</strong></td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>Email</strong></td>

                            </tr>
                            <tbody>
                                <c:forEach items="${mplist}" var="mplist" varStatus="status">
                                    <tr style="font-size:11px; height:20px;">
                                        <td colspan="1"  style="padding:3px 5px;">${status.count}</td>
                                        <td colspan="1"  style="padding:3px 5px;">${mplist.name}</td>
                                        <td colspan="1"  style="padding:3px 5px;">${mplist.designation}</td>
                                        <td colspan="1"  style="padding:3px 5px;">+${mplist.countryCode}-${mplist.phoneNo}</td>
                                        <td colspan="1"  style="padding:3px 5px;">${mplist.emailId}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <br>
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">                               
                                    PAST WORKING EXPERIENCE DETAILS
                                </td>
                            </tr>

                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Company Name</strong></td>
                                <td colspan="1"style="padding:3px 5px;"><strong>Contact Person Name</strong></td>
                                <td colspan="1" style="padding:3px 5px;"><strong>Phone No.</strong></td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>Email</strong></td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>Designation</strong></td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>Attachment</strong></td>
                            </tr>
                            <tbody>
                                <c:forEach var="lstwork" items="${lstwork}">
                                    <tr style="font-size:11px; height:20px;">
                                        <td  colspan="1" style="padding:3px 5px;"><span>${lstwork.companyName}</span> </td> 
                                        <td  colspan="1" style="padding:3px 5px;"><span>${lstwork.contactPersonName}</span> </td>
                                        <td  colspan="1" style="padding:3px 5px;"><span>+${lstwork.countryCode}-${lstwork.mobileNumber}</span> </td> 
                                        <td colspan="1" style="padding:3px 5px;"><span>${lstwork.email}</span> </td> 
                                        <td  colspan="1" style="padding:3px 5px;"><span>${lstwork.designation}</span></td> 

                                        <td  colspan="1" style="padding:3px 5px;">
                                            <c:if test="${lstwork.attchment!=null && not empty lstwork.attchment}">                                        
                                                <span class="file-wrapper">
                                                    <span class="file-name text-break">${lstwork.attchment}</span>
                                                    <span class="file-actions">
                                                        <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadLastWorkingFileAprrove&fileName=${lstwork.attchment}&id=${lstwork.vendorInformationId}"><span class="fa fa-download"></span></a>
                                                        <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${lstwork.vendorInformationId}/LAST/${lstwork.attchment}"><span class="fa fa-solid fa-eye"></span></a>
                                                    </span>
                                                </span>
                                            </c:if>                                            
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <br>
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">                               
                                    COMPANY REGISTRATION DETAILS
                                </td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>GST No.</strong></td>
                                <td colspan="2"style="padding:3px 5px;"> 
                                    ${list.gstinNo}<br>
                                    <c:if test="${vendorInformation1.gstinFile!=null && not empty vendorInformation1.gstinFile}">                                        
                                        <span class="file-wrapper">
                                            <span class="file-name text-break">${vendorInformation1.gstinFile}</span>
                                            <span class="file-actions">
                                                <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.gstinFile}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.gstinFile}"><span class="fa fa-solid fa-eye"></span></a>
                                            </span>
                                        </span>
                                    </c:if>                                    
                                </td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>PAN No</strong></td>
                                <td colspan="2" style="padding:3px 5px;">
                                    ${list.panNo}<br>
                                    <c:if test="${vendorInformation1.panFile!=null && not empty vendorInformation1.panFile}">                                        
                                        <span class="file-wrapper">
                                            <span class="file-name text-break">${vendorInformation1.panFile}</span>
                                            <span class="file-actions">
                                                <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.panFile}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.panFile}"><span class="fa fa-solid fa-eye"></span></a>
                                            </span>
                                        </span>
                                    </c:if>                                    
                                </td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>MSME No</strong></td>
                                <td colspan="2"style="padding:3px 5px;"> 
                                    <c:if test="${list.msmeStatus=='0'}"><strong>MSME Not Available</strong></c:if>
                                    ${list.service_tax}<br>
                                    <c:if test="${vendorInformation1.service_file!=null && not empty vendorInformation1.service_file}">                                        
                                        <span class="file-wrapper">
                                            <span class="file-name text-break">${vendorInformation1.service_file}</span>
                                            <span class="file-actions">
                                                <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.service_file}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.service_file}"><span class="fa fa-solid fa-eye"></span></a>
                                            </span>
                                        </span>
                                    </c:if>                                    
                                </td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>ESIC No</strong></td>
                                <td colspan="2" style="padding:3px 5px;">
                                    <c:if test="${list.esicStatus=='0'}"><strong>ESIC Not
                                            Available</strong></c:if>
                                    ${list.esicNo}<br>
                                    <c:if test="${vendorInformation1.esicFile!=null && not empty vendorInformation1.esicFile}">                                        
                                        <span class="file-wrapper">
                                            <span class="file-name text-break">${vendorInformation1.esicFile}</span>
                                            <span class="file-actions">
                                                <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.esicFile}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.esicFile}"><span class="fa fa-solid fa-eye"></span></a>
                                            </span>
                                        </span>
                                    </c:if>                                    
                                </td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>EPFO No</strong></td>
                                <td colspan="2"style="padding:3px 5px;"> 
                                    <c:if test="${list.epfoStatus=='0'}"><strong>EPFO Not Available</strong></c:if>
                                    ${list.pfNo}<br>
                                    <c:if test="${vendorInformation1.pfAttachment!=null && not empty vendorInformation1.pfAttachment}">                                        
                                        <span class="file-wrapper">
                                            <span class="file-name text-break">${vendorInformation1.pfAttachment}</span>
                                            <span class="file-actions">
                                                <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.pfAttachment}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.pfAttachment}"><span class="fa fa-solid fa-eye"></span></a>
                                            </span>
                                        </span>
                                    </c:if>
                                </td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>Import Export Code</strong></td>
                                <td colspan="2" style="padding:3px 5px;">
                                    <c:if test="${list.eccStatus == '0'}"><strong>ECC Not
                                            Available</strong></c:if>
                                    ${list.ecc_no}<br>
                                    <c:if test="${vendorInformation1.ecc_file!=null && not empty vendorInformation1.ecc_file}">                                        
                                        <span class="file-wrapper">
                                            <span class="file-name text-break">${vendorInformation1.ecc_file}</span>
                                            <span class="file-actions">
                                                <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.ecc_file}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.ecc_file}"><span class="fa fa-solid fa-eye"></span></a>
                                            </span>
                                        </span>
                                    </c:if>                                    
                                </td>
                            </tr>
                        </table>
                        <br>
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">                               
                                    Bank Details
                                </td>
                            </tr>

                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Account Number</strong></td>
                                <td colspan="2"style="padding:3px 5px;">${list.accountNumber}</td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>Bank Name</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${list.bankName}</td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Branch </strong></td>
                                <td colspan="2"style="padding:3px 5px;">${list.branch}</td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>IFSC Code</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${list.ifscCode}</td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Swift Code (if any) </strong></td>
                                <td colspan="2"style="padding:3px 5px;">${list.swiftCode}</td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>Cancel Cheque</strong></td>
                                <td colspan="2" style="padding:3px 5px;">
                                    <c:if test="${vendorInformation1.cancelCheck!=null && not empty vendorInformation1.cancelCheck}">                                        
                                        <span class="file-wrapper">
                                            <span class="file-name text-break">${vendorInformation1.cancelCheck}</span>
                                            <span class="file-actions">
                                                <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.cancelCheck}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.cancelCheck}"><span class="fa fa-solid fa-eye"></span></a>
                                            </span>
                                        </span>
                                    </c:if>                                    
                                </td>
                            </tr>
                        </table>
                        <br>
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">                               
                                    FINANCIAL STATEMENT (PROFIT AND LOSS / BALANCE SHEET)
                                </td>
                            </tr>

                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>Year</strong></td>
                                <td colspan="1"style="padding:3px 5px;"><strong>Financial Year</strong></td>
                                <td colspan="1" style="padding:3px 5px;"><strong>Financial Amount</strong></td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>Financial Attachment</strong></td>
                            </tr>
                            <tbody>
                                <!-- 1st Year -->
                                <tr style="font-size:11px; height:20px;">
                                    <td colspan="1" style="padding:3px 5px;">1st Year </td>
                                    <td colspan="1" style="padding:3px 5px;">${list.finical1}</td>
                                    <td colspan="1" style="padding:3px 5px;">${list.finicalAmount1}</td>
                                    <td colspan="1" style="padding:3px 5px;">
                                        <c:if test="${vendorInformation1.finicalAttachment1!=null && not empty vendorInformation1.finicalAttachment1}">                                        
                                            <span class="file-wrapper">
                                                <span class="file-name text-break">${vendorInformation1.finicalAttachment1}</span>
                                                <span class="file-actions">
                                                    <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.finicalAttachment1}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.finicalAttachment1}"><span class="fa fa-solid fa-eye"></span></a>
                                                </span>
                                            </span>
                                        </c:if>
                                    </td>
                                </tr>
                                <!-- 2nd Year -->
                                <tr style="font-size:11px; height:20px;">
                                    <td colspan="1"  style="padding:3px 5px;">2nd Year </td>
                                    <td colspan="1"  style="padding:3px 5px;">${list.finical2}</td>
                                    <td colspan="1"  style="padding:3px 5px;">${list.finicalAmount2}</td>
                                    <td colspan="1"  style="padding:3px 5px;">
                                        <c:if test="${vendorInformation1.finicalAttachment2!=null && not empty vendorInformation1.finicalAttachment2}">                                        
                                            <span class="file-wrapper">
                                                <span class="file-name text-break">${vendorInformation1.finicalAttachment2}</span>
                                                <span class="file-actions">
                                                    <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.finicalAttachment2}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.finicalAttachment2}"><span class="fa fa-solid fa-eye"></span></a>
                                                </span>
                                            </span>
                                        </c:if>
                                    </td>
                                </tr>
                                <!-- 3rd Year -->
                                <tr style="font-size:11px; height:20px;">
                                    <td colspan="1"  style="padding:3px 5px;">3rd Year </td>
                                    <td colspan="1"  style="padding:3px 5px;">${list.finical3}</td>
                                    <td colspan="1"  style="padding:3px 5px;">${list.finicalAmount3}</td>
                                    <td colspan="1"  style="padding:3px 5px;">
                                        <c:if test="${vendorInformation1.finicalAttachment3!=null && not empty vendorInformation1.finicalAttachment3}">                                        
                                            <span class="file-wrapper">
                                                <span class="file-name text-break">${vendorInformation1.finicalAttachment3}</span>
                                                <span class="file-actions">
                                                    <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.finicalAttachment3}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.finicalAttachment3}"><span class="fa fa-solid fa-eye"></span></a>
                                                </span>
                                            </span>
                                        </c:if>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <br>
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">                               
                                    Self Declaration Form
                                </td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td  style="padding:3px 5px; width:50%; "><strong>Description </strong></td>
                                <td style="padding:3px 5px; width:25%;"><strong>Vendor Response</strong></td>
                                <td  style="padding:3px 5px; width:25%;"><strong>Comments</strong></td>

                            </tr>
                            <tbody>
                                <tr style="font-size:11px; height:20px;">
                                    <td style="padding:3px 5px;" >
                                        <b>1. Is the organization publicly listed company with shares being traded on any Stock Exchange? </b><span style="color:red">*</span>
                                    </td>
                                    <td style="padding:3px 5px;">

                                        <c:if test="${declaration.desDecOneFlag == 1}">
                                            Yes
                                        </c:if>
                                        <c:if test="${declaration.desDecOneFlag == 0}">
                                            No
                                        </c:if>

                                    </td>


                                    <td style="padding:3px 5px;" <c:if test="${declaration.desDecOneFlag == 1}">background: #e9ecef;</c:if>">
                                        <span class="wrap-text">${declaration.desDecOne}</span>
                                    </td>

                                </tr>
                                <tr style="font-size:11px; height:20px;">
                                    <td  style="padding:3px 5px;">
                                        <b>2. Has the Supplier ever conducted business under any alias...? </b><span style="color:red">*</span>
                                    </td>
                                    <td  style="padding:3px 5px;" >
                                        <c:if test="${declaration.desDecTwoFlag == 1}">
                                            Yes
                                        </c:if>
                                        <c:if test="${declaration.desDecTwoFlag == 0}">
                                            No
                                        </c:if>


                                    </td>
                                    <td  style="padding:3px 5px;"  <c:if test="${declaration.desDecTwoFlag == 1}">background: #e9ecef;</c:if>">
                                         <span class="wrap-text">${declaration.desDecTwo}</span>   
                                    </td>
                                </tr>
                                <tr style="font-size:11px; height:20px;">
                                    <td   style="padding:3px 5px;">
                                        <b> 3. Litigation History</b><bR>
                                        Whether your organization is involved in any legal proceedings?<br>
                                        - For Proprietorship organization the Proprietor to declare if he / she is involved in any legal proceedings.<br>
                                        - For Partnership organization all or any Partners are involved in any legal proceedings

                                    </td>
                                    <td   style="padding:3px 5px;">
                                        <c:if test="${declaration.litigationHistoryDesFlag == 1}">
                                            Yes
                                        </c:if>
                                        <c:if test="${declaration.litigationHistoryDesFlag == 0}">
                                            No
                                        </c:if>

                                    </td>
                                    <td  style="padding:3px 5px;" <c:if test="${declaration.litigationHistoryDesFlag == 1}">background: #e9ecef;</c:if>">
                                         <span class="wrap-text">${declaration.litigationHistoryDes}</span> 
                                    </td>
                                </tr>
                                <tr style="font-size:11px; height:20px;">
                                    <td  style="padding:3px 5px;" >
                                        <b> 4. Political Contributions</b><bR>
                                        Whether the Third Party or any person directly or indirectly connected to the Third Party (Employees, Directors, and their personal relations) has made any contributions / donations (either of a charitable or political nature), in the past or at present, to a political party / organization affiliated with a political party or a political leader, on behalf of the Third Party / Supplier or in their personal capacity?

                                    </td>
                                    <td  style="padding:3px 5px;">
                                        <c:if test="${declaration.politicalContributionDesFlag == 1}">
                                            Yes
                                        </c:if>
                                        <c:if test="${declaration.politicalContributionDesFlag == 0}">
                                            No
                                        </c:if>

                                    </td>
                                    <td  style="padding:3px 5px;" <c:if test="${declaration.politicalContributionDesFlag == 1}">background: #e9ecef;</c:if>">
                                         <span class="wrap-text">${declaration.politicalContributionDes}</span> 
                                    </td>
                                </tr>
                                <tr style="font-size:11px; height:20px;">
                                    <td  style="padding:3px 5px;" >
                                        <b> 5. Conflict of Interest</b><bR>
                                        Whether the Third Party or any person directly or indirectly connected to the Third Party (Employees, Directors, and their personal relations) have any financial interests, personal or familial relationships, or affiliations with Tecso Charge Zone Limited or any of its Directors or employees?

                                    </td>
                                    <td   style="padding:3px 5px;">
                                        <c:if test="${declaration.conflictInsterestDesFlag == 1}">
                                            Yes
                                        </c:if>
                                        <c:if test="${declaration.conflictInsterestDesFlag == 0}">
                                            No
                                        </c:if>

                                    </td>
                                    <td  style="padding:3px 5px;" <c:if test="${declaration.conflictInsterestDesFlag == 1}">background: #e9ecef;</c:if>">
                                         <span class="wrap-text">${declaration.conflictInsterestDes}</span> 
                                    </td>
                                </tr>
                                <tr style="font-size:11px; height:20px;">
                                    <td  style="padding:3px 5px;" >
                                        <b> 6.  Use of Executive/Judicial (Public Official) Influence</b><bR>
                                        Whether the Third Party or any person directly or indirectly connected to the Third Party (Employees, Directors, and their personal relations) has sought or obtained the assistance of a Public Official in connection with providing goods / services to CZ?

                                    </td>
                                    <td  style="padding:3px 5px;" >
                                        <c:if test="${declaration.executiveJudicialDesFlag == 1}">
                                            Yes
                                        </c:if>
                                        <c:if test="${declaration.executiveJudicialDesFlag == 0}">
                                            No
                                        </c:if>

                                    </td>
                                    <td  style="padding:3px 5px;"  <c:if test="${declaration.executiveJudicialDesFlag == 1}">background: #e9ecef;</c:if>">
                                         <span class="wrap-text">${declaration.executiveJudicialDes}</span> 
                                    </td>
                                </tr>
                                <tr style="font-size:11px; height:20px;">
                                    <td  style="padding:3px 5px;">
                                        <b>  7. Politically Exposed Personnel</b><bR>
                                        Whether the Third Party or any person directly or indirectly connected to the Third Party is or has been associated with any political party/ political leader / organization affiliated with a political party or a political leader?
                                        <br><i>[For illustrative purposes, ‘Y’ is an employee / proprietor of the Third Party entity and ‘K’, his maternal uncle is a local MLA in Raigad. Herein, ‘Y’ shall be considered as politically exposed for the purposes of disclosure to CZ]</i>

                                    </td>
                                    <td  style="padding:3px 5px;">
                                        <c:if test="${declaration.politicallyExposedDesOneFlag == 1}">
                                            Yes
                                        </c:if>
                                        <c:if test="${declaration.politicallyExposedDesOneFlag == 0}">
                                            No
                                        </c:if>

                                    </td>
                                    <td  style="padding:3px 5px;" <c:if test="${declaration.politicallyExposedDesOneFlag == 1}">background: #e9ecef;</c:if>">
                                         <span class="wrap-text">${declaration.politicallyExposedDesOne}</span> 
                                    </td>
                                </tr>
                                <tr style="font-size:11px; height:20px;">
                                    <td  style="padding:3px 5px;" >
                                        <b>  7.1</b><br>
                                        Whether the Third Party or any person directly or indirectly connected to the Third Party will seek / has sought or obtained the assistance of any political party / political leader / organization affiliated with a political party or a political leader in connection with providing goods / services to CZ?

                                    </td>
                                    <td  style="padding:3px 5px;" >
                                        <c:if test="${declaration.politicallyExposedDesTwoFlag == 1}">
                                            Yes
                                        </c:if>
                                        <c:if test="${declaration.politicallyExposedDesTwoFlag == 0}">
                                            No
                                        </c:if>

                                    </td>
                                    <td  style="padding:3px 5px;" <c:if test="${declaration.politicallyExposedDesTwoFlag == 1}">background: #e9ecef;</c:if>">
                                         <span class="wrap-text">${declaration.politicallyExposedDesTwo}</span> 
                                    </td>
                                </tr>
                                <tr style="font-size:11px; height:20px;">
                                    <td  style="padding:3px 5px;">
                                        <b>  7.2</b><br>
                                        Whether any assistance has been sought from a political party / political leader / an organization affiliated with a political party, or a political leader for resolution of any issues / concerns related to the functioning / management / regulatory compliance of the Third Party?

                                    </td>
                                    <td  style="padding:3px 5px;" >
                                        <c:if test="${declaration.politicallyExposedDesThreeFlag == 1}">
                                            Yes
                                        </c:if>
                                        <c:if test="${declaration.politicallyExposedDesThreeFlag == 0}">
                                            No
                                        </c:if>

                                    </td>
                                    <td  style="padding:3px 5px;"  <c:if test="${declaration.politicallyExposedDesThreeFlag == 1}">background: #e9ecef;</c:if>">
                                         <span class="wrap-text">${declaration.politicallyExposedDesThree}</span> 
                                    </td>
                                </tr>
                                <tr style="font-size:11px; height:20px;">
                                    <td  style="padding:3px 5px;">
                                        <b> 8. Nature of Services</b><bR>
                                        Whether the Scope of Work to be carried out by the Third Party will involve providing any form of liaising or facilitation services with Government Departments?

                                    </td>
                                    <td  style="padding:3px 5px;">
                                        <c:if test="${declaration.natureServicesOneFlag == 1}">
                                            Yes
                                        </c:if>
                                        <c:if test="${declaration.natureServicesOneFlag == 0}">
                                            No
                                        </c:if>

                                    </td>
                                    <td  style="padding:3px 5px;" <c:if test="${declaration.natureServicesOneFlag == 1}">background: #e9ecef;</c:if>">
                                         <span class="wrap-text">${declaration.natureServicesOne}</span> 
                                    </td>
                                </tr>
                                <tr style="font-size:11px; height:20px;">
                                    <td  style="padding:3px 5px;" >
                                        <b>  8.1</b><br>
                                        Whether the Scope of Work to be carried out by the Third Party will involve interacting with Public Officials (Government officials/Judges/Public Sector Companies, etc.) on behalf of Chargezone?

                                    </td>
                                    <td  style="padding:3px 5px;">
                                        <c:if test="${declaration.natureServicesTwoFlag == 1}">
                                            Yes
                                        </c:if>
                                        <c:if test="${declaration.natureServicesTwoFlag == 0}">
                                            No
                                        </c:if>

                                    </td>
                                    <td  style="padding:3px 5px;" <c:if test="${declaration.natureServicesTwoFlag == 1}">background: #e9ecef;</c:if>">
                                         <span class="wrap-text">${declaration.natureServicesTwo}</span> 
                                    </td>
                                </tr>
                                <tr style="font-size:11px; height:20px;">
                                    <td  style="padding:3px 5px;" >
                                        <b> 9.  Acknowledgment of understanding and NDA</b><bR>
                                        Has the Procurement team explained to you the Supplier Registration process especially the Code of Conduct document? Please answer in Yes or No

                                    </td>
                                    <td  style="padding:3px 5px;" >
                                        <c:if test="${declaration.ndaOneFlag == 1}">
                                            Yes
                                        </c:if>
                                        <c:if test="${declaration.ndaOneFlag == 0}">
                                            No
                                        </c:if>

                                    </td>
                                    <td  style="padding:3px 5px;" <c:if test="${declaration.ndaOneFlag == 1}">background: #e9ecef;</c:if>">
                                         <span class="wrap-text">${declaration.ndaOne}</span> 
                                    </td>
                                </tr>
                                <tr style="font-size:11px; height:20px;">
                                    <td  style="padding:3px 5px;">
                                        <b>  9.1</b><br>
                                        Has the Procurement team explained to you about the applicability of Non-Disclosure Agreement to your case? If yes have they shared NDA with you. Please answer in Yes or No.

                                    </td>
                                    <td  style="padding:3px 5px;" >
                                        <c:if test="${declaration.ndaTwoFlag == 1}">
                                            Yes
                                        </c:if>
                                        <c:if test="${declaration.ndaTwoFlag == 0}">
                                            No
                                        </c:if>

                                    </td>
                                    <td  style="padding:3px 5px;"  <c:if test="${declaration.ndaTwoFlag == 1}">background: #e9ecef;</c:if>">
                                         <span class="wrap-text">${declaration.ndaTwo}</span> 
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        
                         <c:if test="${list.auditorAttachment!=null && not empty list.auditorAttachment && not empty list.riskBand}">                                        
                             <br>
                             <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                 <tr class="table-title">
                                     <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">                               
                                         Auditor Criteria
                                     </td>
                                 </tr>

                                 <tr style="font-size:11px; height:20px;">
                                     <td colspan="1" style="padding:3px 5px;"><strong>Auditor Name</strong></td>
                                     <td colspan="1"style="padding:3px 5px;"><strong>Risk Band</strong></td>
                                     <td colspan="1"  style="padding:3px 5px;"><strong> Attachment</strong></td>
                                 </tr>
                                 <tbody>
                                     <tr style="font-size:11px; height:20px;">
                                         <td colspan="1" style="padding:3px 5px;">${list.auditorName}</td>
                                         <td colspan="1" style="padding:3px 5px;">${list.riskBand}</td>
                                         <td colspan="1" style="padding:3px 5px;">
                                             <c:if test="${vendorInformation1.auditorAttachment!=null && not empty vendorInformation1.auditorAttachment}">                                        
                                                 <span class="file-wrapper">
                                                     <span class="file-name text-break">${vendorInformation1.auditorAttachment}</span>
                                                     <span class="file-actions">
                                                         <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.auditorAttachment}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                         <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.auditorAttachment}"><span class="fa fa-solid fa-eye"></span></a>
                                                     </span>
                                                 </span>
                                             </c:if>	                                           
                                         </td>
                                     </tr>
                                 </tbody>
                             </table>
                         </c:if>
                         <c:if test="${not empty companyList}">
                             <br>
                             <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                 <tr class="table-title">
                                     <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">                               
                                         Company Details
                                     </td>
                                 </tr>

                                 <tr style="font-size:11px; height:20px;">
                                     <td  style="padding:3px 5px; width:50%;"><strong>Company</strong></td>
                                     <td style="padding:3px 5px; width:50%;"><strong>Purchasing Organization</strong></td>
                                 </tr>
                                 <tbody>
                                     <c:forEach var="companyList" items="${companyList}" >
                                         <tr id="companyRow1" style="font-size:11px; height:20px;">
                                             <td style="padding:3px 5px;">${companyList.vendorCompanyName}</td>
                                             <td style="padding:3px 5px;">${companyList.vendorPO}</td>
                                         </tr> 
                                     </c:forEach>
                                 </tbody>
                             </table>
                             <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                 <tr class="table-title">
                                     <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">                               
                                         SAP Details
                                     </td>
                                 </tr>

                                 <tr style="font-size:11px; height:20px;">
                                     <td colspan="1" style="padding:3px 5px;"><strong>Currency</strong></td>
                                     <td colspan="1" style="padding:3px 5px;"><strong>BP Group</strong></td>
                                     <td colspan="1"  style="padding:3px 5px;"><strong> Search Term</strong></td>
                                 </tr>
                                 <tbody>
                                     <tr style="font-size:11px; height:20px;">
                                         <td colspan="1" style="padding:3px 5px;">${list.currency}</td>
                                         <td colspan="1" style="padding:3px 5px;">${list.bpGroup}</td>
                                         <td colspan="1" style="padding:3px 5px;">${list.searchTerm1}</td>
                                     </tr>
                                 </tbody>
                             </table>
                             <br>
                         </c:if>
                        <c:if test="${not empty list.sapCode}">
                            <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                <tr class="table-title">
                                    <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">                               
                                        Sap Vendor Code
                                    </td>
                                </tr>
                                
                                <tbody>
                                    <tr style="font-size:11px; height:20px;">
                                        <td colspan="1" style="padding:3px 5px;">${list.sapCode}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </c:if>
                        
                         <c:if test="${!empty generalList}">
                             <br>
                             <table id="technicalTable" class="flex-table page-break-section" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                 <tr class="table-title">
                                     <td colspan="9" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">                               

                                         Technical Criteria
                                     </td>
                                 </tr>

                                 <tr style="font-size:11px; height:20px;">
                                     <td colspan="1" style="padding:3px 5px;"><strong>Sr No.</strong></td>
                                     <td colspan="1" style="padding:3px 5px;"><strong>Criteria</strong></td>
                                     <td colspan="1"style="padding:3px 5px;"><strong> Selection Criteria</strong></td>
                                     <td colspan="1"  style="padding:3px 5px;"><strong> Attachment</strong></td>
                                     <td colspan="1"  style="padding:3px 5px;"><strong> Vendor Score</strong></td>
                                     <td colspan="1" style="padding:3px 5px;"><strong>Comment</strong></td>
                                     <!--<td colspan="1"  style="padding:3px 5px;"><strong> Technical Score</strong></td>-->
                                     <!--<td colspan="2"  style="padding:3px 5px;"><strong> Technical Comment</strong></td>-->
                                 </tr>
                                 <tbody>
                                <input type="hidden" id="technicalVendorPercentage" value="${vendorPercentage[0].technicalPercentage}"/>
                                 <c:forEach var="list5" items="${generalList}" varStatus="status">
                                     <tr style="font-size:11px; height:20px;">
                                         <td colspan="1" style="padding:3px 5px;">${status.count}</td>
                                         <td  class="terms-details" colspan="1" style="padding:3px 5px;">${list5.criteria}</td>
                                         <td class="terms-details" colspan="1" style="padding:3px 5px;">${list5.selectionCriteria}</td>

                                         <td colspan="1" style="padding:3px 5px;">
                                             <c:if test="${list5.attachment!=null && not empty list5.attachment}">                                        
                                                 <span class="file-wrapper">
                                                     <span class="file-name text-break">${list5.attachment}</span>
                                                     <span class="file-actions">
                                                         <a class="fw-600 text-break gradient-text no-print" href="vendorInformation.htm?act=downloadCriteriaFileAprrove&amp;fileName=${list5.attachment}&foldName=TECHNICAL&id=${vendorInformation1.id}">&nbsp;<span class="fa fa-download"></span></a>
                                                         <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/TECHNICAL/${list5.attachment}"><span class="fa fa-solid fa-eye"></span></a>					
                                                     </span>
                                                 </span>
                                             </c:if>                                            
                                         </td>

                                     <input type="hidden" name="hrId" value="${list5.id}">

                                     <td class="technicalVendorScore" data-score="${list5.score}" colspan="1" style="padding:3px 5px;">
                                         <c:choose>
                                             <c:when test="${list5.score==1}">YES</c:when>
                                             <c:otherwise>NO</c:otherwise>
                                         </c:choose>

                                     </td>
                                         <td colspan="1" style="padding:3px 5px;">${list5.comment}</td>


<!--                                     <td colspan="1" style="padding:3px 5px;" class="technicalScore" data-accept="${list5.response}">
                                         <c:if test="${list5.response=='2'}">Accept</c:if>
                                         <c:if test="${list5.response=='1'}">Partial Accept</c:if>
                                         <c:if test="${list5.response=='0'}">Reject</c:if>
                                         </td>

                                         <td colspan="2" style="padding:3px 5px;">
                                         ${list5.technicalComment}
                                     </td >-->
                                     </tr>
                                 </c:forEach>
                                 </tbody>

                                 <tr style="font-size:11px; height:20px;">
                                     <td  style="padding:3px 5px;"  style="font-weight: bold;">Total</td>
                                     <td colspan="1" style="padding:3px 5px;"> </td>
                                     <td colspan="1" style="padding:3px 5px;"> </td>
                                     <td colspan="1" style="padding:3px 5px;"> </td>
                                     <td colspan="1" id="technicalTotal" style="padding:3px 5px; text-align:center;">0</td>                                     <td colspan="1" style="padding:3px 5px;"> </td>
                                     <!--<td colspan="1" style="padding:3px 5px;"></td>-->
                                     <!--<td colspan="2" style="padding:3px 5px;"> </td>-->
                                 </tr>


                                 <tr style="font-size:11px; height:20px;">
                                     <td colspan="1" style="padding:3px 5px;" colspan="8" style="font-weight: bold;">Total Percentage</td>
                                     <td colspan="1" style="padding:3px 5px;"></td> 
                                     <td colspan="1" style="padding:3px 5px;"></td> 
                                     <td colspan="1" style="padding:3px 5px;"></td> 
                                     <td colspan="1" id="technicalPercentage" style="padding:3px 5px; text-align:center;">0 %</td>                                     <td colspan="1" style="padding:3px 5px;"></td> 

                                     <!--<td colspan="1" style="padding:3px 5px;"></td>-->
                                     <!--<td colspan="2" style="padding:3px 5px;"></td>--> 

                                 </tr>

                             </table>
                         </c:if>

                         <c:if test="${!empty hrList}">
                             <br>
                             <table id="hrTable" class="flex-table page-break-section" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                 <tr class="table-title">
                                     <td colspan="9" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">                               

                                         HR Criteria
                                     </td>
                                 </tr>

                                 <tr style="font-size:11px; height:20px;">
                                     <td colspan="1" style="padding:3px 5px;"><strong>Sr No.</strong></td>
                                     <td colspan="1" style="padding:3px 5px;"><strong>Criteria</strong></td>
                                     <td colspan="1"style="padding:3px 5px;"><strong> Selection Criteria</strong></td>
                                     <td colspan="1"  style="padding:3px 5px;"><strong> Attachment</strong></td>
                                     <td colspan="1"  style="padding:3px 5px;"><strong> Vendor Score</strong></td>
                                     <td colspan="1" style="padding:3px 5px;"><strong>Comment</strong></td>
                                     <!--<td colspan="1"  style="padding:3px 5px;"><strong> HR Score</strong></td>-->
                                     <!--<td colspan="2"  style="padding:3px 5px;"><strong> HR Comment</strong></td>-->
                                 </tr> 

                                 <tbody>
                                 <input type="hidden" id="hrVendorPercentage" value="${vendorPercentage[0].hrPercentage}"/>


                                 <c:forEach var="list5" items="${hrList}" varStatus="status">
                                     <tr style="font-size:11px; height:20px;">
                                         <td colspan="1" style="padding:3px 5px;">${status.count}</td>
                                         <td class="terms-details" colspan="1" style="padding:3px 5px;">${list5.criteriaName}</td>
                                         <td class="terms-details" colspan="1" style="padding:3px 5px;">${list5.criteriaDescription}</td>

                                         <td colspan="1" style="padding:3px 5px;">
                                             <c:if test="${list5.attachement!=null && not empty list5.attachement}">                                        
                                                 <span class="file-wrapper">
                                                     <span class="file-name text-break">${list5.attachement}</span>
                                                     <span class="file-actions">
                                                         <a class="fw-600 text-break gradient-text no-print" href="vendorInformation.htm?act=downloadCriteriaFileAprrove&amp;fileName=${list5.attachement}&foldName=HR&id=${vendorInformation1.id}">&nbsp;<span class="fa fa-download"></span></a>
                                                         <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/HR/${list5.attachement}"><span class="fa fa-solid fa-eye"></span></a>					
                                                     </span>
                                                 </span>
                                             </c:if>                                            
                                         </td>

                                     <input type="hidden" name="hrId" value="${list5.id}">

                                    <td class="hrVendorScore" data-score="${list5.score}" colspan="1" style="padding:3px 5px;">
                                         <c:choose>
                                             <c:when test="${list5.score==1}">YES</c:when>
                                             <c:otherwise>NO</c:otherwise>
                                         </c:choose>
                                    </td>
                                    <td colspan="1" style="padding:3px 5px;">${list5.comment}</td>


<!--                                     <td colspan="1" style="padding:3px 5px;" class="hrScore" data-accept="${list5.accept}">
                                         <c:if test="${list5.accept=='2'}">Accept</c:if>
                                         <c:if test="${list5.accept=='1'}">Partial Accept</c:if>
                                         <c:if test="${list5.accept=='0'}">Reject</c:if>
                                         </td>

                                         <td colspan="2" style="padding:3px 5px;">
                                         ${list5.hrComment}
                                     </td>-->
                                     </tr>
                                 </c:forEach>

                                    <tr style="font-size:11px; height:20px;">
                                     <td  style="padding:3px 5px;"  style="font-weight: bold;">Total</td>
                                     <td colspan="1" style="padding:3px 5px;"> </td>
                                     <td colspan="1" style="padding:3px 5px;"> </td>
                                     <td colspan="1" style="padding:3px 5px;"> </td>
                                     <td colspan="1" id="hrTotal" style="padding:3px 5px; text-align:center;">0</td>                             
                                     <td colspan="1" style="padding:3px 5px;"> </td>
                                     <!--<td colspan="1" style="padding:3px 5px;"></td>-->
                                     <!--<td colspan="2" style="padding:3px 5px;"> </td>-->
                                 </tr>


                                 <tr style="font-size:11px; height:20px;">
                                     <td colspan="1" style="padding:3px 5px;" colspan="8" style="font-weight: bold;">Total Percentage</td>
                                     <td colspan="1" style="padding:3px 5px;"></td> 
                                     <td colspan="1" style="padding:3px 5px;"></td> 
                                     <td colspan="1" style="padding:3px 5px;"></td> 
                                     <td colspan="1" id="hrPercentage" style="padding:3px 5px; text-align:center;">0 %</td>                           
                                     <td colspan="1" style="padding:3px 5px;"></td> 

                                     <!--<td colspan="1" style="padding:3px 5px;"></td>-->
                                     <!--<td colspan="2" style="padding:3px 5px;"></td>--> 

                                 </tr>

                                 
                                 </tbody>



                             </table>



                         </c:if>


                         <c:if test="${!empty itList}">    
                             <br>
                             <table id="itTable" class="flex-table page-break-section" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                 <tr class="table-title">
                                     <td colspan="9" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">                               

                                         IT Criteria
                                     </td>
                                 </tr>

                                 <tr style="font-size:11px; height:20px;">
                                     <td colspan="1" style="padding:3px 5px;"><strong>Sr No.</strong></td>
                                     <td colspan="1" style="padding:3px 5px;"><strong>Criteria</strong></td>
                                     <td colspan="1"style="padding:3px 5px;"><strong> Selection Criteria</strong></td>
                                     <td colspan="1"  style="padding:3px 5px;"><strong> Attachment</strong></td>
                                     <td colspan="1"  style="padding:3px 5px;"><strong> Vendor Score</strong></td>
                                     <td colspan="1" style="padding:3px 5px;"><strong>Comment</strong></td>
                                     <!--<td colspan="1"  style="padding:3px 5px;"><strong> IT Score</strong></td>-->
                                     <!--<td colspan="2"  style="padding:3px 5px;"><strong> IT Comment</strong></td>-->
                                 </tr> 
                                 <tbody>
                                 <input type="hidden" id="itVendorPercentage" value="${vendorPercentage[0].itPercentage}"/>


                                 <c:forEach var="list5" items="${itList}" varStatus="status">
                                     <tr style="font-size:11px; height:20px;">
                                         <td colspan="1" style="padding:3px 5px;">${status.count}</td>
                                         <td class="terms-details" colspan="1" style="padding:3px 5px;">${list5.criteriaName}</td>
                                         <td class="terms-details" colspan="1" style="padding:3px 5px;">${list5.criteriaDescription}</td>

                                         <td colspan="1" style="padding:3px 5px;">
                                             <c:if test="${list5.attachement!=null && not empty list5.attachement}">                                        
                                                 <span class="file-wrapper">
                                                     <span class="file-name text-break">${list5.attachement}</span>
                                                     <span class="file-actions">
                                                         <a class="fw-600 text-break gradient-text no-print" href="vendorInformation.htm?act=downloadCriteriaFileAprrove&amp;fileName=${list5.attachement}&foldName=IT&id=${vendorInformation1.id}">&nbsp;<span class="fa fa-download"></span></a>
                                                         <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/IT/${list5.attachement}"><span class="fa fa-solid fa-eye"></span></a>					
                                                     </span>
                                                 </span>
                                             </c:if>
                                         </td>

                                     <input type="hidden" name="criteriaName" value="${list5.id}">

                                    <td class="itVendorScore" data-score="${list5.score}" colspan="1" style="padding:3px 5px;">
                                         <c:choose>
                                             <c:when test="${list5.score==1}">YES</c:when>
                                             <c:otherwise>NO</c:otherwise>
                                         </c:choose>
                                    </td>
                                    <td colspan="1" style="padding:3px 5px;">${list5.comment}</td>


<!--                                     <td colspan="1" style="padding:3px 5px;" class="itScore" data-accept="${list5.accept}">
                                         <c:if test="${list5.accept=='2'}">Accept</c:if>
                                         <c:if test="${list5.accept=='1'}">Partial Accept</c:if>
                                         <c:if test="${list5.accept=='0'}">Reject</c:if>
                                         </td>

                                         <td colspan="2
                                             " style="padding:3px 5px;">
                                         ${list5.itComment}
                                     </td>-->
                                     </tr>
                                 </c:forEach>
                                <tr style="font-size:11px; height:20px;">
                                     <td  style="padding:3px 5px;"  style="font-weight: bold;">Total</td>
                                     <td colspan="1" style="padding:3px 5px;"> </td>
                                     <td colspan="1" style="padding:3px 5px;"> </td>
                                     <td colspan="1" style="padding:3px 5px;"> </td>
                                     <td colspan="1" id="itTotal" style="padding:3px 5px; text-align:center;">0</td>                             
                                     <td colspan="1" style="padding:3px 5px;"> </td>
                                     <!--<td colspan="1" style="padding:3px 5px;"></td>-->
                                     <!--<td colspan="2" style="padding:3px 5px;"> </td>-->
                                 </tr>


                                 <tr style="font-size:11px; height:20px;">
                                     <td colspan="1" style="padding:3px 5px;" colspan="8" style="font-weight: bold;">Total Percentage</td>
                                     <td colspan="1" style="padding:3px 5px;"></td> 
                                     <td colspan="1" style="padding:3px 5px;"></td> 
                                     <td colspan="1" style="padding:3px 5px;"></td> 
                                     <td colspan="1" id="itPercentage" style="padding:3px 5px; text-align:center;">0 %</td>                           
                                     <td colspan="1" style="padding:3px 5px;"></td> 

                                     <!--<td colspan="1" style="padding:3px 5px;"></td>-->
                                     <!--<td colspan="2" style="padding:3px 5px;"></td>--> 

                                 </tr>

                                
                                 </tbody>
                             </table>
                         </c:if>


                         <c:if test="${!empty saftyList}">    
                             <br>
                             <table id="safetyTable" class="flex-table page-break-section" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                 <tr class="table-title">
                                     <td colspan="9" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">                               

                                         Safety Criteria
                                     </td>
                                 </tr>

                                 <tr style="font-size:11px; height:20px;">
                                     <td colspan="1" style="padding:3px 5px;"><strong>Sr No.</strong></td>
                                     <td colspan="1" style="padding:3px 5px;"><strong>Criteria</strong></td>
                                     <td colspan="1"style="padding:3px 5px;"><strong> Selection Criteria</strong></td>
                                     <td colspan="1"  style="padding:3px 5px;"><strong> Attachment</strong></td>
                                     <td colspan="1"  style="padding:3px 5px;"><strong> Vendor Score</strong></td>
                                     <td colspan="1" style="padding:3px 5px;"><strong>Comment</strong></td>
                                     <!--<td colspan="1"  style="padding:3px 5px;"><strong> Safety Score</strong></td>-->
                                     <!--<td colspan="2"  style="padding:3px 5px;"><strong> Safety Comment</strong></td>-->
                                 </tr> 
                                 <tbody>
                                 <input type="hidden" id="safetyVendorPercentage" value="${vendorPercentage[0].safteyPercentage}"/>

                                 <c:forEach var="list5" items="${saftyList}" varStatus="status">
                                     <tr style="font-size:11px; height:20px;">
                                         <td colspan="1" style="padding:3px 5px;">${status.count}</td>
                                         <td class="terms-details" colspan="1" style="padding:3px 5px;">${list5.criteriaName}</td>
                                         <td class="terms-details" colspan="1" style="padding:3px 5px;">${list5.criteriaDescription}</td>

                                         <td colspan="1" style="padding:3px 5px;">
                                             <c:if test="${list5.attachement!=null && not empty list5.attachement}">                                        
                                                 <span class="file-wrapper">
                                                     <span class="file-name text-break">${list5.attachement}</span>
                                                     <span class="file-actions">
                                                         <a class="fw-600 text-break gradient-text no-print" href="vendorInformation.htm?act=downloadCriteriaFileAprrove&amp;fileName=${list5.attachement}&foldName=HSE&id=${vendorInformation1.id}">&nbsp;<span class="fa fa-download"></span></a>
                                                         <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/HSE/${list5.attachement}"><span class="fa fa-solid fa-eye"></span></a>					
                                                     </span>
                                                 </span>
                                             </c:if>                                                                 
                                         </td>

                                     <input type="hidden" name="criteriaName" value="${list5.id}">

                                    <td class="safetyVendorScore" data-score="${list5.score}" colspan="1" style="padding:3px 5px;">
                                         <c:choose>
                                             <c:when test="${list5.score==1}">YES</c:when>
                                             <c:otherwise>NO</c:otherwise>
                                         </c:choose>
                                    </td>
                                    <td colspan="1" style="padding:3px 5px;">${list5.comment}</td>


<!--                                     <td colspan="1" style="padding:3px 5px;" class="safetyScore" data-accept="${list5.accept}">
                                         <c:if test="${list5.accept=='2'}">Accept</c:if>
                                         <c:if test="${list5.accept=='1'}">Partial Accept</c:if>
                                         <c:if test="${list5.accept=='0'}">Reject</c:if>
                                         </td>

                                         <td colspan="2" style="padding:3px 5px;">
                                         ${list5.safetyComment}
                                     </td>-->
                                     </tr>
                                 </c:forEach>
                                     
                                  <tr style="font-size:11px; height:20px;">
                                     <td  style="padding:3px 5px;"  style="font-weight: bold;">Total</td>
                                     <td colspan="1" style="padding:3px 5px;"> </td>
                                     <td colspan="1" style="padding:3px 5px;"> </td>
                                     <td colspan="1" style="padding:3px 5px;"> </td>
                                     <td colspan="1" id="safetyTotal" style="padding:3px 5px; text-align:center;">0</td>                             
                                     <td colspan="1" style="padding:3px 5px;"> </td>
                                     <!--<td colspan="1" style="padding:3px 5px;"></td>-->
                                     <!--<td colspan="2" style="padding:3px 5px;"> </td>-->
                                 </tr>


                                 <tr style="font-size:11px; height:20px;">
                                     <td colspan="1" style="padding:3px 5px;" colspan="8" style="font-weight: bold;">Total Percentage</td>
                                     <td colspan="1" style="padding:3px 5px;"></td> 
                                     <td colspan="1" style="padding:3px 5px;"></td> 
                                     <td colspan="1" style="padding:3px 5px;"></td> 
                                     <td colspan="1" id="safetyPercentage" style="padding:3px 5px; text-align:center;">0 %</td>                           
                                     <td colspan="1" style="padding:3px 5px;"></td> 

                                     <!--<td colspan="1" style="padding:3px 5px;"></td>-->
                                     <!--<td colspan="2" style="padding:3px 5px;"></td>--> 

                                 </tr>   
                                     
                                     
                                
                                 </tbody>
                             </table>
                         </c:if>

                         <c:if test="${!empty generalList || !empty hrList || !empty itList || !empty saftyList}">
                             <br>

                             <table  id="overallTable" class="flex-table page-break-section" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                 <tr class="table-title">
                                     <td colspan="9" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">                               

                                         Overall Total Percentage
                                     </td>
                                 </tr>

                                 <tr style="font-size:11px !important; height:20px;">
                                     <td colspan="1" style="padding:3px 5px;"><strong>Total Percentage</strong></td>
                                     <td colspan="1" style="padding:3px 5px;"><strong>Percentage</strong></td>
                                 </tr> 
                                 <tbody>
                                     <tr style="font-size:11px !important; height:20px;">
                                         <td colspan="1" style="padding:3px 5px;">Total Percentage</td>
                                         <td colspan="1" style="padding:3px 5px;font-size:11px !important;"><input style="border:none; background:transparent; outline:none; font-size:11px !important;" type="text" id="overallTotalPercentage" readonly="true" class=""></td>
                                     </tr>
                                 </tbody>
                             </table>

                         </c:if>
                            <script>
                                document.addEventListener("DOMContentLoaded", function () {

                                    function calculateVendorScore(scoreClass, totalId, percentageId) {

                                        let total = 0;
                                        let count = 0;

                                        document.querySelectorAll("." + scoreClass).forEach(function (cell) {

                                            let score = parseInt(cell.getAttribute("data-score"));

                                            if (!isNaN(score)) {
                                                total += score;
                                                count++;
                                            }

                                        });

                                        // Total Vendor Score
                                        if (document.getElementById(totalId)) {
                                            document.getElementById(totalId).innerHTML = total;
                                        }

                                        // Vendor Percentage
                                        let percentage = 0;

                                        if (count > 0) {
                                            percentage = (total / count) * 100;
                                        }

                                        if (document.getElementById(percentageId)) {
                                            document.getElementById(percentageId).innerHTML = percentage.toFixed(2) + " %";
                                        }

                                        return percentage;
                                    }


                                    let percentages = [];

                                    if (document.querySelector(".technicalVendorScore")) {

                                        percentages.push(
                                            calculateVendorScore(
                                                "technicalVendorScore",
                                                "technicalTotal",
                                                "technicalPercentage"
                                            )
                                        );

                                    }

                                    if (document.querySelector(".hrVendorScore")) {

                                        percentages.push(
                                            calculateVendorScore(
                                                "hrVendorScore",
                                                "hrTotal",
                                                "hrPercentage"
                                            )
                                        );

                                    }

                                    if (document.querySelector(".itVendorScore")) {

                                        percentages.push(
                                            calculateVendorScore(
                                                "itVendorScore",
                                                "itTotal",
                                                "itPercentage"
                                            )
                                        );

                                    }

                                    if (document.querySelector(".safetyVendorScore")) {

                                        percentages.push(
                                            calculateVendorScore(
                                                "safetyVendorScore",
                                                "safetyTotal",
                                                "safetyPercentage"
                                            )
                                        );

                                    }


                                    // Overall Vendor Percentage

                                    let overallTotalScore = 0;
                                    let overallTotalCount = 0;

                                    ["technicalVendorScore", "hrVendorScore", "itVendorScore", "safetyVendorScore"].forEach(function (cls) {
                                        document.querySelectorAll("." + cls).forEach(function (cell) {
                                            let score = parseInt(cell.getAttribute("data-score"));
                                            if (!isNaN(score)) {
                                                overallTotalScore += score;
                                                overallTotalCount++;
                                            }
                                        });
                                    });

                                    let overallPercentage = 0;
                                    if (overallTotalCount > 0) {
                                        overallPercentage = (overallTotalScore / overallTotalCount) * 100;
                                    }

                                    document.getElementById("overallTotalPercentage").value =
                                        overallPercentage.toFixed(2) + " %";

                                });
                            </script>
                             
                                                    <br>
                                                    <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <tr class="table-title">
                                                            <td colspan="9" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">                               
                                                                External Vendor Email
                                                            </td>
                                                        </tr>

                                                        <tr style="font-size:11px; height:20px;">
                                                            <td colspan="1" style="padding:3px 5px;"><strong>Vendor Email-1</strong></td>
                                                            <td colspan="1" style="padding:3px 5px;"><strong>Vendor Email-2</strong></td>
                                                            <td colspan="1" style="padding:3px 5px;"><strong>Vendor Email-3</strong></td>
                                                        </tr> 
                                                        <tbody>
                                                            <tr style="font-size:11px; height:20px;">
                                                                <td colspan="1" style="padding:3px 5px;">${list.email1}</td>
                                                                <td colspan="1" style="padding:3px 5px;">${list.email2}</td>
                                                                <td colspan="1" style="padding:3px 5px;">${list.email3}</td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                           </c:forEach>
                                                    
                                                     <br>
                                                     <c:if test="${not empty vendorInformation1.specialComment or not empty vendorInformation1.specialAttachment}">
                                                         <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                             <tr class="table-title">
                                                                 <td colspan="9" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">                               
                                                                     Compliance Officer
                                                                 </td>
                                                             </tr>
                                                             <tr style="font-size:11px; height:20px;">
                                                                 <td colspan="1" style="padding:3px 5px;"><strong>Special Approval Comment</strong></td>
                                                                 <td colspan="1" style="padding:3px 5px;"><strong>Special Approval Attachment</strong></td>
                                                             </tr>
                                                             <tbody>
                                                                 <tr style="font-size:11px; height:20px;">
                                                                     <td colspan="1" style="padding:3px 5px;">${vendorInformation1.specialComment}</td>
                                                                     <td colspan="1" style="padding:3px 5px;">
                                                                         <c:if test="${vendorInformation1.specialAttachment!=null && not empty vendorInformation1.specialAttachment}">                                        
                                                                             <span class="file-wrapper">
                                                                                 <span class="file-name text-break">${vendorInformation1.specialAttachment}</span>
                                                                                 <span class="file-actions">
                                                                                     <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.specialAttachment}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                                                     <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.specialAttachment}"><span class="fa fa-solid fa-eye"></span></a>
                                                                                 </span>
                                                                             </span>
                                                                         </c:if>                                                                         
                                                                     </td>
                                                                 </tr>
                                                             </tbody>
                                                         </table>
                                                         <br>
                                                     </c:if>
                                                     
                                                    <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <tr class="table-title">
                                                            <td colspan="9" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">                               
                                                               Approval History
                                                            </td>
                                                        </tr>
                                                   
                                                        <tr style="font-size:11px; height:20px;">
                                                            <td colspan="1" style="padding:3px 5px;"><strong> Sr. No.</strong></td>
                                                            <td colspan="1" style="padding:3px 5px;"><strong>User Name</strong></td>
                                                            <td colspan="1" style="padding:3px 5px;"><strong>User Role</strong></td>
                                                            <td colspan="1" style="padding:3px 5px;"><strong>Date Time</strong></td>
                                                            <td colspan="1" style="padding:3px 5px;"><strong>Action</strong></td>
                                                            <td colspan="1" style="padding:3px 5px;"><strong>Comment</strong></td>
                                                        </tr>
                                                         <tbody>
                                                            <c:set var="srNo" value="1"/>
                                                            <tr style="font-size:11px; height:20px;">
                                                                <td colspan="1" style="padding:3px 5px;">${srNo}</td>
                                                                <td colspan="1" style="padding:3px 5px;">${vendorInvitation.invitedBy}</td>
                                                                <td colspan="1" style="padding:3px 5px;">Buyer</td>
                                                                <td colspan="1" style="padding:3px 5px;">${vendorInvitation.invitedDateTime}</td>
                                                                <td colspan="1" style="padding:3px 5px;">Vendor Invited</td>
                                                                <td colspan="1" style="padding:3px 5px;"></td>
                                                            </tr>
                                                            <c:set var="srNo" value="${srNo + 1}"/>
                                                            <c:forEach var="vendorApproval" items="${vendorApproval}">
                                                                <tr style="font-size:11px; height:20px;">
                                                                    <td colspan="1" style="padding:3px 5px;">
                                                                        ${srNo}
                                                                    </td>
                                                                    <td colspan="1" style="padding:3px 5px;">
                                                                        ${vendorApproval.userId}
                                                                    </td>
                                                                    <td colspan="1" style="padding:3px 5px;">
                                                                        ${vendorApproval.userRole}
                                                                    </td>
                                                                    <td colspan="1" style="padding:3px 5px;">
                                                                        ${vendorApproval.dateTime}
                                                                    </td>
                                                                    <td colspan="1" style="padding:3px 5px;">
                                                                        ${vendorApproval.activity}
                                                                    </td>
                                                                    <td colspan="1" style="padding:3px 5px;">
                                                                        ${vendorApproval.description}
                                                                    </td>
                                                                </tr>
                                                                <c:set var="srNo" value="${srNo + 1}"/>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>




                </form:form>
            </section>
        </main>
    </body>
    <!--    <body onload="window.print();">
        </body>-->
    <%@include file="/WEB-INF/jsp/Common/NewUIFooterPrint.jsp"%>
</html>

