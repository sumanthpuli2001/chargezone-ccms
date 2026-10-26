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
        <title>Procurement Head Approval Details View</title>
    </head>
    <body>
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
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
                            <h5 class="fw-600 mb-0  no-print">Procurement Head Approval Details View</h5>
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
                            <tbody>
                                <tr style="font-size:11px; height:20px;">
                                    <td colspan="1" style="padding:3px 5px;"><strong>Company Name</strong></td>
                                    <td colspan="2"style="padding:3px 5px;">${list.companyName}</td>
                                    <td colspan="1"  style="padding:3px 5px;"><strong>Email Id:</strong></td>
                                    <td colspan="2" style="padding:3px 5px;">${list.vendorEmailId}</td>
                                </tr>

                                <tr style="font-size:11px; height:20px;">
                                    <th colspan="1" style="padding:3px 5px;">
                                        <c:if test="${list.policyAccept=='1'}">Code of Conduct (Sign & Stamp in all Pages)</c:if>
                                        <c:if test="${list.policyAccept=='0'}">Deviation Policy</c:if></th>
                                    <td colspan="2" style="padding:3px 5px;"><c:if test="${list.policyAccept=='1'}">Accept</c:if>
                                        <c:if test="${list.policyAccept=='0'}"><span style="color: red;">Not Accept</span></c:if><br>
                                        <c:if test="${list.policy1File!='' &&  list.policy1File!=null}">
                                            <label>
                                                <c:if test="${vendorBuyerApproval.cocStatuss == 'accept'}">
                                                    <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                </c:if>
                                                <c:if test="${vendorBuyerApproval.cocStatuss == 'reject'}">
                                                    <span style="color:red; font-weight:bold;">&#10008; Rejected</span><br>
                                                    <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.cocRemarkk}</textarea>
                                                    <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.cocResponse}</textarea>
                                                </c:if>
                                            </label><br>
                                            <c:if test="${list.policy1File!=null && not empty list.policy1File}">                                        
                                                <span class="file-wrapper">
                                                    <span class="file-name text-break">${list.policy1File}</span>
                                                    <span class="file-actions">
                                                        <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.policy1File}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                        <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.policy1File}"><span class="fa fa-solid fa-eye"></span></a>
                                                    </span>
                                                </span>
                                            </c:if>
                                        </c:if>
                                    </td>
                                    <th colspan="1" style="padding:3px 5px;">    <c:if test="${list.ndaPolicyAccept=='1'}">NDA (Sign & Stamp in all Pages)</c:if>
                                        <c:if test="${list.ndaPolicyAccept=='0'}">NDA Policy</c:if></th> 
                                    <td colspan="2" style="padding:3px 5px;"><c:if test="${list.ndaPolicyAccept=='1'}">Accept</c:if>
                                        <c:if test="${list.ndaPolicyAccept=='0'}"><span style="color: red;">Not Accept</span></c:if><br>
                                        <c:if test="${list.ndaPolicyFile!='' &&  list.ndaPolicyFile!=null}">
                                            <label>
                                                <c:if test="${vendorBuyerApproval.ndaStatuss == 'accept'}">
                                                    <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                </c:if>
                                                <c:if test="${vendorBuyerApproval.ndaStatuss == 'reject'}">
                                                    <span style="color:red; font-weight:bold;">&#10008; Rejected</span><br>
                                                    <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.ndaRemarkk}</textarea>
                                                    <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.ndaResponse}</textarea>
                                                </c:if>
                                            </label><br>
                                            <c:if test="${list.ndaPolicyFile!=null && not empty list.ndaPolicyFile}">                                        
                                                <span class="file-wrapper">
                                                    <span class="file-name text-break">${list.ndaPolicyFile}</span>
                                                    <span class="file-actions">
                                                        <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.ndaPolicyFile}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                        <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.ndaPolicyFile}"><span class="fa fa-solid fa-eye"></span></a>
                                                    </span>
                                                </span>
                                            </c:if>
                                        </c:if>
                                    </td>

                                </tr>
                                <tr style="font-size:11px; height:20px;">
                                    <th colspan="1" style="padding:3px 5px;">Type of Company</th>
                                    <td colspan="2" style="padding:3px 5px;">${list.typeOfConcern}</td>
                                    <c:choose>
                                        <c:when test="${list.typeOfConcern == 'Sole Proprietorship'}">
                                            <th colspan="1" style="padding:3px 5px;">
                                                Shop or Establishment License
                                            </th>
                                        </c:when>

                                        <c:when test="${list.typeOfConcern == 'Hindu Undivided Family ( HUF)'}">
                                            <th colspan="1" style="padding:3px 5px;">
                                                Shop or Establishment License and HUF Deed
                                            </th>
                                        </c:when>

                                        <c:when test="${list.typeOfConcern == 'Partnership Firm'}">
                                            <th colspan="1" style="padding:3px 5px;">
                                                Shop or Establishment License and Partnership Deed
                                            </th>
                                        </c:when>

                                        <c:when test="${list.typeOfConcern == 'Limited Liability Partnership ( LLP)'}">
                                            <th colspan="1" style="padding:3px 5px;">
                                                Shop or Establishment License and LLP Agreement
                                            </th>
                                        </c:when>

                                        <c:when test="${list.typeOfConcern == 'Private/Public Company'}">
                                            <th colspan="1" style="padding:3px 5px;">
                                                Certificate of Incorporation (MCA)
                                            </th>
                                        </c:when>
                                            
                                        <c:when test="${list.typeOfConcern == 'Free Lancer'}">
                                            <th colspan="1" style="padding:3px 5px;">
                                                Professional Profile / Resume
                                            </th>
                                        </c:when>

                                        <c:otherwise>
                                            <th colspan="2" style="padding:3px 5px;">Proof Of Attachment</th>
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
                                    <th colspan="1" style="padding:3px 5px;">Year of Establishment of Company</th>
                                    <td colspan="2" style="padding:3px 5px;">${list.establishment}</td>
                                    <th  colspan="1" style="padding:3px 5px;">Risk Category</th>
                                    <td colspan="2" style="padding:3px 5px;" class="riskCategory">${list.riskCategory}</td>
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
                                        <td colspan="1" style="padding:3px 5px;">${status.count}</td>
                                        <td colspan="1" style="padding:3px 5px;">${mplist.name}</td>
                                        <td colspan="1" style="padding:3px 5px;">${mplist.designation}</td>
                                        <td colspan="1" style="padding:3px 5px;">+${mplist.countryCode}-${mplist.phoneNo}</td>
                                        <td colspan="1" style="padding:3px 5px;">${mplist.emailId}</td>
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
                                        <td colspan="1" style="padding:3px 5px;"><span>${lstwork.companyName}</span> </td> 
                                        <td colspan="1" style="padding:3px 5px;"><span>${lstwork.contactPersonName}</span> </td>
                                        <td colspan="1" style="padding:3px 5px;"><span>+${lstwork.countryCode}-${lstwork.mobileNumber}</span> </td> 
                                        <td colspan="1" style="padding:3px 5px;"><span>${lstwork.email}</span> </td> 
                                        <td colspan="1" style="padding:3px 5px;"><span>${lstwork.designation}</span></td> 

                                        <td colspan="1" style="padding:3px 5px;">
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
                        <table class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">                               
                                    COMPANY REGISTRATION DETAILS
                                </td>
                            </tr>
                            <tbody>
                                <tr style="font-size:11px; height:20px;">
                                    <th colspan="1" style="padding:3px 5px;">GST No.</th>
                                    <td colspan="2" style="padding:3px 5px;">
                                        <label>
                                            <c:if test="${vendorBuyerApproval.gstStatuss == 'accept'}">
                                                <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                            </c:if>
                                            <c:if test="${vendorBuyerApproval.gstStatuss == 'reject'}">
                                                <span style="color:red; font-weight:bold;">&#10008; Rejected</span><br>
<!--                                                <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.gstRemarkk}</textarea>-->
<!--                                                <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.gstResponse}</textarea>-->
                                            </c:if>
                                        </label><br>
                                        ${list.gstinNo}<br>
                                        <c:if test="${list.gstinFile!=null && not empty list.gstinFile}">                                        
                                            <span class="file-wrapper">
                                                <span class="file-name text-break">${list.gstinFile}</span>
                                                <span class="file-actions">
                                                    <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.gstinFile}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.gstinFile}"><span class="fa fa-solid fa-eye"></span></a>
                                                </span>
                                            </span>
                                        </c:if>

                                    </td>                                                    
                                    <th colspan="1" style="padding:3px 5px;" >PAN No</th>
                                    <td colspan="2" style="padding:3px 5px;">
                                        <label>
                                            <c:if test="${vendorBuyerApproval.panStatuss == 'accept'}">
                                                <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                            </c:if>
                                            <c:if test="${vendorBuyerApproval.panStatuss == 'reject'}">
                                                <span style="color:red; font-weight:bold;">&#10008; Rejected</span><br>
<!--                                                <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.panRemarkk}</textarea>-->
<!--                                                <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.panResponse}</textarea>-->
                                            </c:if>
                                        </label><br>
                                        ${list.panNo}<br>
                                        <c:if test="${list.panFile!=null && not empty list.panFile}">                                        
                                            <span class="file-wrapper">
                                                <span class="file-name text-break">${list.panFile}</span>
                                                <span class="file-actions">
                                                    <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.panFile}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.panFile}"><span class="fa fa-solid fa-eye"></span></a>
                                                </span>
                                            </span>
                                        </c:if>
                                    </td>
                                </tr>
                                <tr style="font-size:11px; height:20px;">
                                    <th colspan="1" style="padding:3px 5px;" >MSME No</th>
                                    <td colspan="2" style="padding:3px 5px;">
                                        <c:if test="${list.msmeStatus=='0'}"><strong>MSME Not Available</strong><br></c:if>
                                            <label>
                                            <c:if test="${vendorBuyerApproval.msmeStatuss == 'accept'}">
                                                <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                            </c:if>
                                            <c:if test="${vendorBuyerApproval.msmeStatuss == 'reject'}">
                                                <span style="color:red; font-weight:bold;">&#10008; Rejected</span><br>
<!--                                                <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.msmeRemarkk}</textarea>-->
<!--                                                <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.msmeResponse}</textarea>-->
                                            </c:if>
                                        </label><br>
                                        ${list.service_tax}<br>
                                        <c:if test="${list.service_file!=null && not empty list.service_file}">                                        
                                            <span class="file-wrapper">
                                                <span class="file-name text-break">${list.service_file}</span>
                                                <span class="file-actions">
                                                    <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.service_file}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.service_file}"><span class="fa fa-solid fa-eye"></span></a>
                                                </span>
                                            </span>
                                        </c:if>
                                    </td>
                                    <th colspan="1" style="padding:3px 5px;" >ESIC No</th>
                                    <td colspan="2" style="padding:3px 5px;">
                                        <c:if test="${list.esicStatus=='0'}"><strong>ESIC Not Available</strong><br></c:if>
                                            <label>
                                            <c:if test="${vendorBuyerApproval.esicStatuss == 'accept'}">
                                                <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                            </c:if>
                                            <c:if test="${vendorBuyerApproval.esicStatuss == 'reject'}">
                                                <span style="color:red; font-weight:bold;">&#10008; Rejected</span><br>
<!--                                                <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.esicRemarkk}</textarea>-->
<!--                                                <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.esicResponse}</textarea>-->
                                            </c:if>
                                        </label><br>
                                        ${list.esicNo}<br>
                                        <c:if test="${list.esicFile!=null && not empty list.esicFile}">                                        
                                            <span class="file-wrapper">
                                                <span class="file-name text-break">${list.esicFile}</span>
                                                <span class="file-actions">
                                                    <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.esicFile}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.esicFile}"><span class="fa fa-solid fa-eye"></span></a>
                                                </span>
                                            </span>
                                        </c:if>
                                    </td>
                                </tr>
                                <tr style="font-size:11px; height:20px;">
                                    <th colspan="1" style="padding:3px 5px;">EPFO No.</th>
                                    <td colspan="2" style="padding:3px 5px;">
                                        <c:if test="${list.epfoStatus=='0'}"><strong>EPFO Not Available</strong><br></c:if>
                                            <label>
                                            <c:if test="${vendorBuyerApproval.epfoStatuss == 'accept'}">
                                                <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                            </c:if>
                                            <c:if test="${vendorBuyerApproval.epfoStatuss == 'reject'}">
                                                <span style="color:red; font-weight:bold;">&#10008; Rejected</span><br>
<!--                                                <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.epfoRemarkk}</textarea>-->
<!--                                                <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.epfoResponse}</textarea>-->
                                            </c:if>
                                        </label><br>
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
                                    <th colspan="1" style="padding:3px 5px;" >Import Export Code </th>
                                    <td colspan="2" style="padding:3px 5px;"> 
                                        <c:if test="${list.eccStatus == '0'}"><strong>ECC Not Available</strong><br></c:if>
                                        <c:if test="${list.eccStatus != '0'}">
                                            <label>
                                                <c:if test="${vendorBuyerApproval.eccStatuss == 'accept'}">
                                                    <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                </c:if>
                                                <c:if test="${vendorBuyerApproval.eccStatuss == 'reject'}">
                                                    <span style="color:red; font-weight:bold;">&#10008; Rejected</span><br>
<!--                                                    <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.eccRemarkk}</textarea>-->
<!--                                                    <textarea class="textarea-field" readonly rows="3" cols="50">${vendorBuyerApproval.eccResponse}</textarea>-->
                                                </c:if>
                                            </label><br>                                                                        
                                            ${list.ecc_no}<br>
                                            <c:if test="${list.ecc_file!=null && not empty list.ecc_file}">                                        
                                                <span class="file-wrapper">
                                                    <span class="file-name text-break">${list.ecc_file}</span>
                                                    <span class="file-actions">
                                                        <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.ecc_file}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                        <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.ecc_file}"><span class="fa fa-solid fa-eye"></span></a>
                                                    </span>
                                                </span>
                                            </c:if>
                                        </c:if>
                                    </td>                                                    
                                </tr>
                            </tbody>
                        </table>
                        <br>
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">                               
                                    BANK DETAILS
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
                                    <c:if test="${list.cancelCheck!=null && not empty list.cancelCheck}">                                        
                                        <span class="file-wrapper">
                                            <span class="file-name text-break">${list.cancelCheck}</span>
                                            <span class="file-actions">
                                                <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.cancelCheck}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.cancelCheck}"><span class="fa fa-solid fa-eye"></span></a>
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
                                    SELF DECLARATION FORM
                                </td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td style="padding:3px 5px; width:50%; "><strong>Description </strong></td>
                                <td style="padding:3px 5px; width:25%;"><strong>Vendor Response</strong></td>
                                <td style="padding:3px 5px; width:25%;"><strong>Comments</strong></td>

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
                        <br>
                        
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="9" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">                               
                                    EXTERNAL VENDOR EMAIL
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
                        <c:if test="${vendorInformation1.auditorAttachment!=null && not empty vendorInformation1.auditorAttachment && !empty vendorInformation1.riskBand}">                                        

                            <br>
                            <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                <thead>
                                    <tr style="font-size:11px; height:20px;" class="table-title">
                                        <td colspan="7"style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                            <c:if test="${list.riskCategory=='medium'}">
                                                INTERNAL AUDITOR APPROVAL
                                            </c:if>
                                            <c:if test="${list.riskCategory=='high'}">
                                                RISK EVALUATOR APPROVAL
                                            </c:if>
                                        </td>
                                    </tr>
                                    <tr style="font-size:11px; height:20px;">
                                        <th colspan="1" style="padding:3px 5px;">Attachment</th>
                                        <th colspan="1" style="padding:3px 5px;">Risk Band</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr style="font-size:11px; height:20px;">
                                        <td colspan="1" style="padding:3px 5px;">
                                            <c:if test="${list.auditorAttachment!=null && not empty list.auditorAttachment}">                                        
                                                <span class="file-wrapper">
                                                    <span class="file-name text-break">${list.auditorAttachment}</span>
                                                    <span class="file-actions">
                                                        <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.auditorAttachment}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                        <a target="#" class="text-break gradient-text no-print fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.auditorAttachment}"><span class="fa fa-solid fa-eye"></span></a>
                                                    </span>
                                                </span>
                                            </c:if>
                                        <td colspan="1" style="padding:3px 5px;">${list.riskBand}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </c:if>
                    </c:forEach>

                    <%--<c:if test="${not empty vendorInformation1.specialComment or not empty vendorInformation1.specialAttachment}">--%>
                    <!--                                                         <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
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
                    ${vendorInformation1.specialAttachment}
                    <a class="text-break gradient-text no-print fw-600" href="vendorInformation.htm?act=downloadFileAprrove&fileName=${vendorInformation1.specialAttachment}"> <span class="fa fa-download d-print-none d-print-none"></span> </a>
                    <a target="#" class="text-break gradient-text no-print fw-600 d-print-none" href="StorageYard/Auditor/${vendorInformation1.id}/${vendorInformation1.specialAttachment}"><span class="fa fa-solid fa-eye d-print-none d-print-none"></span></a>
                </td>
            </tr>
        </tbody>
    </table>-->
                    <%--</c:if>--%>
                    <br>
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
