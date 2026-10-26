<%-- 
    Document   : activevendorviewClickPrint
    Created on : 11 Feb, 2026, 11:50:12 AM
    Author     : Admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNewPrint.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HR Approval View</title>
    </head>
    <body>
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="vendorInformation.htm?act=approveonesubmit" method="post"  name='form1' class="form-horizontal" role="form">             
                    <div class="content-top mb-0 d-flex align-items-center justify-content-between d-print-none sticky">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2  d-print-none">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0  no-print">HR Approval View</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3 no-print">Back</a>
                            <a href="" onclick="window.print();" class="btn btn theme-btn no-print" style="background-color: #4CAF50; border-color: #4CAF50;" >
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
                                    VENDOR DETAILS
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
                                        <c:if test="${list.policy1File!=null && not empty list.policy1File}">                                        
                                            <span class="file-wrapper">
                                                <span class="file-name text-break">${list.policy1File}</span>
                                                <span class="file-actions">
                                                    <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.policy1File}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.policy1File}"><span class="fa fa-solid fa-eye"></span></a>
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
                                        <c:if test="${list.ndaPolicyFile!=null && not empty list.ndaPolicyFile}">                                        
                                            <span class="file-wrapper">
                                                <span class="file-name text-break">${list.ndaPolicyFile}</span>
                                                <span class="file-actions">
                                                    <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.ndaPolicyFile}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.ndaPolicyFile}"><span class="fa fa-solid fa-eye"></span></a>
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
                                        <c:if test="${list.companyProof!=null && not empty list.companyProof}">                                        
                                            <span class="file-wrapper">
                                                <span class="file-name text-break">${list.companyProof}</span>
                                                <span class="file-actions">
                                                    <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.companyProof}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.companyProof}"><span class="fa fa-solid fa-eye"></span></a>
                                                </span>
                                            </span>
                                        </c:if>
                                        <c:if test="${list.companyProof2!=null && not empty list.companyProof2}">
                                            <br>
                                            <span class="file-wrapper">
                                                <span class="file-name text-break">${list.companyProof2}</span>
                                                <span class="file-actions">
                                                    <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.companyProof2}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.companyProof2}"><span class="fa fa-solid fa-eye"></span></a>
                                                </span>
                                            </span>
                                        </c:if>
                                    </td>
                                </tr>
                                <tr style="font-size:11px; height:20px;">
                                    <th  colspan="1" style="padding:3px 5px;">Year of Establishment of Company</th>
                                    <td>${list.establishment}</td>
                                    <th colspan="2" style="padding:3px 5px;"></th>
                                    <td></td>
                                </tr>
                            </tbody>
                        </table>
                        <br>
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                    REGISTER ADDRESS
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
                                    COMMUNICATION ADDRESS
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
                                    TYPE OF VENDORS
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
                                    VENDOR CONTACTS
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
                                    <td colspan="9" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">                               
                                       COMPANY REGISTRATION DETAILS
                                    </td>
                                </tr>

                                <tbody>                                                               
                                    <tr style="font-size:11px; height:20px;">
                                        <th colspan="1" style="padding:3px 5px;">EPFO No</th>
                                        <td colspan="1" style="padding:3px 5px;">
                                            <c:if test="${list.epfoStatuss == 'accept'}">
                                                <label><span style="color:green; font-weight:bold;">&#10004; Accepted</span></label><br>
                                            </c:if>
                                            <c:if test="${list.epfoStatuss=='0'}"><strong>EPFO Not Available</strong><br></c:if>
                                            <c:if test="${list.epfoStatuss == 'reject'}">
                                            <label>
                                                <span style="color:red; font-weight:bold;">&#10008; Rejected</span><br>
                                                <textarea class="textarea-field" readonly rows="3" cols="110" style="resize: none; background-color: #f9f9f9;">${list.msmeRemarkk}</textarea>
                                                <textarea class="textarea-field" readonly rows="3" cols="110" style="resize: none; background-color: #f9f9f9;">${list.msmeResponse}</textarea>
                                            </label><br>
                                            </c:if>
                                            ${list.pfNo}<br>
                                            <c:if test="${list.pfAttachment!=null && not empty list.pfAttachment}">                                        
                                                <span class="file-wrapper">
                                                    <span class="file-name text-break">${list.pfAttachment}</span>
                                                    <span class="file-actions">
                                                        <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.pfAttachment}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                        <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.pfAttachment}"><span class="fa fa-solid fa-eye"></span></a>
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
                                    <td colspan="9" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">                               
                                        HR CRITERIA
                                    </td>
                                </tr>

                                <tr style="font-size:11px; height:20px;">
                                    <td colspan="1" style="padding:3px 5px;"><strong>Sr No.</strong></td>
                                    <td colspan="1" style="padding:3px 5px;"><strong>Criteria</strong></td>
                                    <td colspan="1"style="padding:3px 5px;"><strong> Selection Criteria</strong></td>
                                    <td colspan="1"  style="padding:3px 5px;"><strong> Attachment</strong></td>
                                    <td colspan="1"  style="padding:3px 5px;"><strong> Vendor Score</strong></td>
                                    <td colspan="1" style="padding:3px 5px;"><strong>Comment</strong></td>
                                    <td colspan="1"  style="padding:3px 5px;"><strong> HR Score</strong></td>
                                    <td colspan="2"  style="padding:3px 5px;"><strong> HR Comment</strong></td>
                                </tr> 

                                <tbody>
                                <input type="hidden" name="vendorPercentage" id="vendorPercentage" value="${vendorPercentage[0].hrPercentage}">

                                <c:forEach var="list5" items="${hrList}" varStatus="status">
                                    <tr style="font-size:11px; height:20px;">
                                        <td colspan="1" style="padding:3px 5px;">${status.count}</td>
                                        <td colspan="1" style="padding:3px 5px;"><pre class="terms-details">${list5.criteriaName}</pre></td>
                                        <td colspan="1" style="padding:3px 5px;"><pre class="terms-details">${list5.criteriaDescription}</pre></td>

                                        <td colspan="1" style="padding:3px 5px;">
                                            <c:if test="${list5.attachement!=null && not empty list5.attachement}">                                        
                                                <span class="file-wrapper">
                                                    <span class="file-name text-break">${list5.attachement}</span>
                                                    <span class="file-actions">
                                                        <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadCriteriaFileAprrove&amp;fileName=${list5.attachement}&foldName=HR&id=${list.id}">&nbsp;<span class="fa fa-download"></span></a>
                                                        <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/HR/${list5.attachement}"><span class="fa fa-solid fa-eye"></span></a>					
                                                    </span>
                                                </span>
                                            </c:if>
                                        </td>

                                    <input type="hidden" name="hrId" value="${list5.id}">

                                    <td colspan="1" style="padding:3px 5px;">
                                        <c:if test="${list5.score==0}">NO</c:if>
                                        <c:if test="${list5.score==1}">YES</c:if>
                                        </td>
                                        <td colspan="1" style="padding:3px 5px;">${list5.comment}</td>


                                        <td colspan="1" style="padding:3px 5px;" class="hrScore" data-accept="${list5.accept}">
                                        <c:if test="${list5.accept=='2'}">Accept</c:if>
                                        <c:if test="${list5.accept=='1'}">Partial Accept</c:if>
                                        <c:if test="${list5.accept=='0'}">Reject</c:if>
                                        </td>

                                        <td colspan="2" style="padding:3px 5px;">
                                        ${list5.hrComment}
                                    </td>
                                    </tr>
                                </c:forEach>



                                <tr style="font-size:11px; height:20px;">
                                    <td colspan="6" style="padding:3px 5px;"style="font-weight: bold;">Total</td>
                                    <td  colspan="1" style="padding:3px 5px;"><input style="border:none; background:transparent; outline:none;" type="text" id="hrTotal" readonly="true" name="total" class=""></td>
                                    <td  colspan="1" style="padding:3px 5px;"></td>
                                </tr>


                                <tr style="font-size:11px; height:20px;">
                                    <td colspan="6"  style="padding:3px 5px;" style="font-weight: bold;">Total Percentage</td>
                                    <td  colspan="1" style="padding:3px 5px;"><input style="border:none; background:transparent; outline:none;" type="text" id="hrPercentage" readonly="true" name="percentage" class=""></td>
                                    <td  colspan="1" style="padding:3px 5px;"></td>
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
                        
                                           </c:forEach>
                                                    
                                                     
                                                     
                                                      <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <tr class="table-title">
                                                            <td colspan="9" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">                               
                                                               APPROVAL HISTORY
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
