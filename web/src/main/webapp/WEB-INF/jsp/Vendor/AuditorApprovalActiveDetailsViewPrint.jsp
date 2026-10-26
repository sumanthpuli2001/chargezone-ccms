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
        <title>Risk Evaluator Approval</title>
    </head>
    <body>
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="vendorInformation.htm?act=approveonesubmit" method="post"  name='form1' class="form-horizontal" role="form">             
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2  d-print-none">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0  no-print">Risk Evaluator Approval</h5>
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
                                        <c:if test="${list.policy1File!='' &&  list.policy1File!=null}">
                                            ${list.policy1File}<a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.policy1File}&id=${list.id}"> &nbsp;<span class="fa fa-download d-print-none d-print-none"></span></a>
                                            <a target="#" class="text-break gradient-text fw-600 d-print-none" href="StorageYard/UserProfile/${list.id}/${list.policy1File}"><span class="fa fa-solid fa-eye d-print-none"></span></a>
                                            </c:if>
                                    </td>
                                    <th colspan="1" style="padding:3px 5px;">    <c:if test="${list.ndaPolicyAccept=='1'}">NDA (Sign & Stamp in all Pages)</c:if>
                                        <c:if test="${list.ndaPolicyAccept=='0'}">NDA Policy</c:if>
                                        </th> 
                                        <td colspan="2" style="padding:3px 5px;">
                                        <c:if test="${list.ndaPolicyAccept=='1'}">Accept</c:if>
                                        <c:if test="${list.ndaPolicyAccept=='0'}"><span style="color: red;">Not Accept</span></c:if><br>
                                        <c:if test="${list.ndaPolicyFile!='' &&  list.ndaPolicyFile!=null}">
                                            ${list.ndaPolicyFile}<a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.ndaPolicyFile}&id=${list.id}">  &nbsp;<span class="fa fa-download d-print-none d-print-none"></span></a> 
                                            <a target="#" class="text-break gradient-text fw-600 d-print-none" href="StorageYard/UserProfile/${list.id}/${list.ndaPolicyFile}"><span class="fa fa-solid fa-eye d-print-none"></span></a>
                                            </c:if>
                                    </td>
                                </tr>
                                <tr style="font-size:11px; height:20px;">
                                    <td colspan="1" style="padding:3px 5px;">Type of Company</td>
                                    <td colspan="1" style="padding:3px 5px;">${list.typeOfConcern}</td>
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
                                    <td colspan="1" style="padding:3px 5px;"> ${list.panFile}<a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadcompanyProof&amp;fileName=${list.companyProof}&amp;id=${list.id}"> &nbsp;<span class="fa fa-download d-print-none d-print-none"></span></a>
                                        <a target="#" class="text-break gradient-text fw-600 d-print-none" href="StorageYard/UserProfile/${list.id}/${list.companyProof}"><span class="fa fa-solid fa-eye d-print-none"></span></a>
                                    </td>
                                </tr>
                                <tr style="font-size:11px; height:20px;">
                                    <th  colspan="1" style="padding:3px 5px;">Year of Establishment of Company</th>
                                    <td colspan="1" style="padding:3px 5px;" >${list.establishment}</td>
                                    <th colspan="2" style="padding:3px 5px;"></th>
                                    <td colspan="1" style="padding:3px 5px;"></td>
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
                                <td colspan="2"style="padding:3px 5px;">${list.officeTelephone}</td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>Website</strong></td>
                                <td colspan="2" style="padding:3px 5px;">${list.officeWebsite}</td>
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
                                <td colspan="2"style="padding:3px 5px;">${declaration.altTelephone}</td>
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
                                    <td colspan="1" style="padding:3px 5px;">${list.sales_phone}</td>
                                    <td colspan="1" style="padding:3px 5px;">${list.saleEmail}</td>
                                </tr>
                                <tr style="font-size:11px; height:20px;">
                                    <td colspan="1" style="padding:3px 5px;">Technical Contact(s) </td>
                                    <td colspan="1" style="padding:3px 5px;">${list.technical_name}</td>
                                    <td colspan="1" style="padding:3px 5px;">${list.technical_job}</td>
                                    <td colspan="1" style="padding:3px 5px;">${list.technical_phone}</td>
                                    <td colspan="1" style="padding:3px 5px;">${list.technicalContactEmail}</td>
                                </tr>
                                <tr style="font-size:11px; height:20px;">
                                    <td colspan="1" style="padding:3px 5px;">Finance and Accounts </td>
                                    <td colspan="1" style="padding:3px 5px;">${list.quality_name}</td>
                                    <td colspan="1" style="padding:3px 5px;">${list.quality_job}</td>
                                    <td colspan="1" style="padding:3px 5px;">${list.quality_phone}</td>
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
                                            ${lstwork.attchment}  <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAprrove1&fileName=${lstwork.attchment}&id=${lstwork.vendorInformationId}">
                                                &nbsp;<span class="fa fa-download d-print-none"></span>
                                            </a>
                                            <a target="#" class="text-break gradient-text fw-600 d-print-none" href="StorageYard/UserProfile/${lstwork.vendorInformationId}/${lstwork.attchment}"><span class="fa fa-solid fa-eye d-print-none"></span></a>
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
                                    <c:if test="${list.gstinFile!='' &&  list.gstinFile!=null}">  ${list.gstinFile}
                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.gstinFile}&amp;id=${list.id}">&nbsp;<span class="fa fa-download d-print-none"></span></a> 
                                        <a target="#"  title="View" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/${vendorInformation1.id}/${vendorInformation1.gstinFile}"><span class="fa fa-solid fa-eye d-print-none"></span></a>
                                    </c:if></td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>PAN No</strong></td>
                                <td colspan="2" style="padding:3px 5px;">
                                    ${list.panNo}<br>
                                    <c:if test="${list.panFile!='' &&  list.panFile!=null}">
                                        ${list.panFile}
                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.panFile}&amp;id=${list.id}">&nbsp;<span class="fa fa-download d-print-none d-print-none"></span></a>
                                        <a target="#"  title="View" class="text-break gradient-text fw-600 " href="StorageYard/UserProfile/${vendorInformation1.id}/${vendorInformation1.panFile}"><span class="fa fa-solid fa-eye d-print-none d-print-none"></span></a>
                                        </c:if>
                                </td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>MSME No</strong></td>
                                <td colspan="2"style="padding:3px 5px;"> 
                                    <c:if test="${list.msmeStatus=='0'}"><strong>MSME Not
                                            Available</strong></c:if>
                                    ${list.service_tax}<br>
                                    <c:if test="${list.service_file!='' &&  list.service_file!=null}">
                                        ${list.service_file} 
                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.service_file}&amp;id=${list.id}">&nbsp;<span class="fa fa-download d-print-none"></span></a>
                                        <a target="#"  title="View" class="text-break gradient-text fw-600 d-print-none" href="StorageYard/UserProfile/${vendorInformation1.id}/${vendorInformation1.service_file}"><span class="fa fa-solid fa-eye d-print-none"></span></a>
                                    </c:if></td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>ESIC No</strong></td>
                                <td colspan="2" style="padding:3px 5px;">
                                    <c:if test="${list.esicStatus=='0'}"><strong>ESIC Not Available</strong></c:if>
                                    ${list.esicNo}<br>
                                    <c:if test="${list.esicFile!='' &&  list.esicFile!=null}">
                                        ${list.esicFile}
                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.esicFile}&amp;id=${list.id}">&nbsp;<span class="fa fa-download d-print-none"></span></a>
                                        <a target="#"  title="View" class="text-break gradient-text fw-600 d-print-none" href="StorageYard/UserProfile/${vendorInformation1.id}/${vendorInformation1.esicFile}"><span class="fa fa-solid fa-eye d-print-none"></span></a>
                                        </c:if>
                                </td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td colspan="1" style="padding:3px 5px;"><strong>EPFO No</strong></td>
                                <td colspan="2"style="padding:3px 5px;"> 
                                    <c:if test="${list.epfoStatus=='0'}"><strong>EPFO Not Available</strong></c:if>
                                    ${list.pfNo}<br>
                                    <c:if test="${list.pfAttachment!='' &&  list.pfAttachment!=null}">
                                        ${list.pfAttachment}
                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.pfAttachment}&amp;id=${list.id}">&nbsp;<span class="fa fa-download d-print-none"></span></a>
                                        <a target="#"  title="View" class="text-break gradient-text fw-600 d-print-none" href="StorageYard/UserProfile/${vendorInformation1.id}/${vendorInformation1.pfAttachment}"><span class="fa fa-solid fa-eye d-print-none"></span></a>
                                    </c:if></td>
                                <td colspan="1"  style="padding:3px 5px;"><strong>Import Export Code</strong></td>
                                <td colspan="2" style="padding:3px 5px;">
                                    <c:if test="${list.eccStatus == '0'}"><strong>ECC Not Available</strong></c:if>
                                    ${list.ecc_no}<br>
                                    <c:if test="${list.ecc_file!='' &&  list.ecc_file!=null}">
                                        ${list.ecc_file}
                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.ecc_file}&amp;id=${list.id}">&nbsp;<span class="fa fa-download d-print-none"></span></a>
                                        <a target="#"  title="View" class="text-break gradient-text fw-600 d-print-none" href="StorageYard/UserProfile/${vendorInformation1.id}/${vendorInformation1.ecc_file}"><span class="fa fa-solid fa-eye d-print-none"></span></a>
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
                                        <c:if test="${list.finicalAttachment1!='' &&  list.finicalAttachment1!=null}">
                                            ${list.finicalAttachment1}
                                            <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.finicalAttachment1}&amp;id=${list.id}">
                                                &nbsp;<span class="fa fa-download d-print-none"></span>
                                            </a>
                                            <a target="#" class="text-break gradient-text fw-600 d-print-none" href="StorageYard/UserProfile/${list.id}/${list.finicalAttachment1}"><span class="fa fa-solid fa-eye d-print-none"></span></a>

                                        </c:if>
                                    </td>
                                </tr>
                                <!-- 2nd Year -->
                                <tr style="font-size:11px; height:20px;">
                                    <td colspan="1"  style="padding:3px 5px;">2nd Year </td>
                                    <td colspan="1"  style="padding:3px 5px;">${list.finical2}</td>
                                    <td colspan="1"  style="padding:3px 5px;">${list.finicalAmount2}</td>
                                    <td colspan="1"  style="padding:3px 5px;">
                                        <c:if test="${list.finicalAttachment2!='' &&  list.finicalAttachment2!=null}">
                                            ${list.finicalAttachment2} 
                                            <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.finicalAttachment2}&amp;id=${list.id}">
                                                &nbsp;<span class="fa fa-download d-print-none"></span>
                                            </a>
                                            <a target="#" class="text-break gradient-text fw-600 d-print-none" href="StorageYard/UserProfile/${list.id}/${list.finicalAttachment2}"><span class="fa fa-solid fa-eye d-print-none"></span></a>

                                        </c:if>
                                    </td>
                                </tr>
                                <!-- 3rd Year -->
                                <tr style="font-size:11px; height:20px;">
                                    <td colspan="1"  style="padding:3px 5px;">3rd Year </td>
                                    <td colspan="1"  style="padding:3px 5px;">${list.finical3}</td>
                                    <td colspan="1"  style="padding:3px 5px;">${list.finicalAmount3}</td>
                                    <td colspan="1"  style="padding:3px 5px;">
                                        <c:if test="${list.finicalAttachment3!='' &&  list.finicalAttachment3!=null}">
                                            ${list.finicalAttachment3}<a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.finicalAttachment3}&amp;id=${list.id}">
                                                &nbsp;<span class="fa fa-download d-print-none"></span>
                                            </a>
                                            <a target="#" class="text-break gradient-text fw-600 d-print-none" href="StorageYard/UserProfile/${list.id}/${list.finicalAttachment3}"><span class="fa fa-solid fa-eye d-print-none"></span></a>

                                        </c:if>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <br>



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

                        <br>
                        <c:if test="${not empty vendorInformation1.specialComment or not empty vendorInformation1.specialAttachment}">
                            <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                <tr class="table-title">
                                    <td colspan="9" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">                               
                                        COMPLIANCE OFFICER
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
                                            <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAprrove&fileName=${vendorInformation1.specialAttachment}"> <span class="fa fa-download d-print-none"></span> </a>
                                            <a target="#" class="text-break gradient-text fw-600 d-print-none" href="StorageYard/Auditor/${vendorInformation1.id}/${vendorInformation1.specialAttachment}"><span class="fa fa-solid fa-eye d-print-none"></span></a>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </c:if>
                        
                        <c:if test="${list.auditorAttachment!=null && not empty list.auditorAttachment && not empty list.riskBand}">                                        

                            <br>
                            <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                <thead >
                                    <tr style="font-size:11px; height:20px;" class="table-title">
                                        <td colspan="8" style="padding:3px 5px;" style="font-weight: bold; background-color: skyblue;">
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
                                        <td colspan="1" style="padding:3px 5px;">
                                            <c:if test="${list.auditorAttachment!='' &&  list.auditorAttachment!=null}">
                                                ${list.auditorAttachment}<a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAuditorAttachment&amp;fileName=${list.auditorAttachment}&amp;id=${list.id}"> &nbsp;<span class="fa fa-download d-print-none"></span></a>
                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/Auditor/${list.id}/${list.auditorAttachment}"><span class="fa fa-solid fa-eye d-print-none"></span></a>

                                            </c:if>
                                        </td>
                                        <th colspan="1" style="padding:3px 5px;">Band</th>
                                        <td colspan="1" style="padding:3px 5px;">${list.riskBand}</td>
                                    </tr>
                                </thead>

                            </table>
                        </c:if>
                                <br>
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <thead>
                                                            <tr style="font-size:11px; height:20px;" class="table-title">
                                                                <td colspan="7"style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                                                    <c:if test="${list.riskCategory=='medium'}">
                                                                        Internal Auditor Approval
                                                                    </c:if>
                                                                    <c:if test="${list.riskCategory=='high'}">
                                                                        Risk Evaluator Approval
                                                                    </c:if>
                                                                </td>
                                                            </tr>
                                                            <tr style="font-size:11px; height:20px;">
                                                                <th colspan="1" style="padding:3px 5px;">Attachment</th>
                                                                <th colspan="1" style="padding:3px 5px;">Risk Band</th>
                                                                <th colspan="1" style="padding:3px 5px;">Comment</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr style="font-size:11px; height:20px;">
                                                                <td colspan="1" style="padding:3px 5px;">
                                                                    <c:if test="${list.auditorAttachment!='' &&  list.auditorAttachment!=null}">
                                                                        ${list.auditorAttachment}<a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAuditorAttachment&amp;fileName=${list.auditorAttachment}&amp;id=${list.id}"> &nbsp;<span class="fa fa-download d-print-none"></span></a>
                                                                  <a target="#" class="text-break gradient-text fw-600" href="StorageYard/Auditor/${list.id}/${list.auditorAttachment}"><span class="fa fa-solid fa-eye d-print-none"></span></a>

                                                                    </td>
                                                                </c:if>
                                                                <td colspan="1" style="padding:3px 5px;">${list.riskBand}</td>
                                                                <td colspan="1" style="padding:3px 5px;">${list.auditorRemark}</td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                    </c:forEach>
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
                            <tr>
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
